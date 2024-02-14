package com.srijanmukherjee.yeetcode.service;

import com.srijanmukherjee.yeetcode.dto.request.ConfirmationRequest;
import com.srijanmukherjee.yeetcode.dto.request.LoginRequest;
import com.srijanmukherjee.yeetcode.dto.request.RegisterRequest;
import com.srijanmukherjee.yeetcode.dto.response.AuthenticationResponse;
import com.srijanmukherjee.yeetcode.dto.response.ConfirmationResponse;
import com.srijanmukherjee.yeetcode.dto.response.RegistrationResponse;
import com.srijanmukherjee.yeetcode.entity.Role;
import com.srijanmukherjee.yeetcode.entity.User;
import com.srijanmukherjee.yeetcode.exception.ResourceNotFoundException;
import com.srijanmukherjee.yeetcode.repository.ConfirmationCodeRepository;
import com.srijanmukherjee.yeetcode.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {
    UserRepository repository;
    ConfirmationCodeRepository confirmationCodeRepository;
    PasswordEncoder passwordEncoder;
    AuthenticationManager authenticationManager;
    ConfirmationCodeService confirmationCodeService;
    JwtService jwtService;
    EmailService emailService;

    @Value("${confirmation_code_validity}")
    @NonFinal
    private Integer confirmationCodeValidity;

    @Transactional
    public RegistrationResponse register(RegisterRequest request) {
        var user = User.builder()
                .username(request.username())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.USER)
                .build();
        repository.save(user);
        var code = confirmationCodeService.generateConfirmationCode(user, confirmationCodeValidity);
        emailService.sendAccountConfirmationCode(user.getEmail(), code);
        return new RegistrationResponse("User successfully registered", user.getId());
    }

    public AuthenticationResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );

        final var user = repository.findByUsernameOrEmail(request.username(), request.username())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        var jwt = jwtService.generateToken(user);
        return new AuthenticationResponse(jwt);
    }

    @Transactional
    public ConfirmationResponse confirmCode(ConfirmationRequest request) {
        // TODO: throw meaningful error
        var user = repository.findById(request.userId()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        if (user.isActivated()) {
            return new ConfirmationResponse("Account already activated");
        }
        var confirmationCode = confirmationCodeService.getLatest(user).orElseThrow(RuntimeException::new);
        if (!confirmationCode.getCode().equals(request.code())) {
            throw new RuntimeException("Invalid confirmation code");
        }
        if (confirmationCode.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Confirmation code has expired");
        }
        user.setActivated(true);
        repository.save(user);
        confirmationCodeRepository.delete(confirmationCode);
        return new ConfirmationResponse("Account activated");
    }
}
