package com.srijanmukherjee.yeetcode.repository;

import com.srijanmukherjee.yeetcode.entity.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface QuestionRepository extends CrudRepository<Question, UUID> {
    Optional<Question> findBySlug(String slug);
}
