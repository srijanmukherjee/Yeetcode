package com.srijanmukherjee.yeetcode.repository;

import com.srijanmukherjee.yeetcode.entity.ConfirmationCode;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface ConfirmationCodeRepository extends CrudRepository<ConfirmationCode, Integer> {
    Optional<ConfirmationCode> findFirstByUserIdOrderByCreatedAtDesc(UUID userId);
}
