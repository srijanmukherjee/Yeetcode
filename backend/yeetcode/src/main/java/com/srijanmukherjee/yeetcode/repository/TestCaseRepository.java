package com.srijanmukherjee.yeetcode.repository;

import com.srijanmukherjee.yeetcode.entity.TestCase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TestCaseRepository extends CrudRepository<TestCase, Long> {
    List<TestCase> findTestCaseByQuestionIdAndExampleIs(UUID questionId, boolean isExample);
}
