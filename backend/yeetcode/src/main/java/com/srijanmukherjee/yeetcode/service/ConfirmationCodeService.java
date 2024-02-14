package com.srijanmukherjee.yeetcode.service;

import com.srijanmukherjee.yeetcode.entity.ConfirmationCode;
import com.srijanmukherjee.yeetcode.entity.User;
import com.srijanmukherjee.yeetcode.repository.ConfirmationCodeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ConfirmationCodeService {
    ConfirmationCodeRepository repository;

    public String generateConfirmationCode(User user, int validity) {
        final var code = String.valueOf(
                ThreadLocalRandom.current().nextInt(1000, 10000)
        );

        var confirmationCode = ConfirmationCode.builder()
                .code(code)
                .user(user)
                .expiresAt(LocalDateTime.now().plusMinutes(validity))
                .build();

        repository.save(confirmationCode);
        return code;
    }

    public Optional<ConfirmationCode> getLatest(User user) {
        return repository.findFirstByUserIdOrderByCreatedAtDesc(user.getId());
    }
}
