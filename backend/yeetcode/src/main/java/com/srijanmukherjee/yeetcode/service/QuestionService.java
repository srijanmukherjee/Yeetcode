package com.srijanmukherjee.yeetcode.service;

import com.srijanmukherjee.yeetcode.dto.request.QuestionCreateRequest;
import com.srijanmukherjee.yeetcode.dto.request.TestCaseRequest;
import com.srijanmukherjee.yeetcode.dto.response.QuestionDetailResponse;
import com.srijanmukherjee.yeetcode.dto.response.QuestionResponse;
import com.srijanmukherjee.yeetcode.entity.Question;

import java.util.List;

public interface QuestionService {
    void addQuestion(QuestionCreateRequest questionCreateRequest);
    List<QuestionResponse> getQuestions();
    QuestionDetailResponse getQuestion(String slug);
    void updateQuestion();
    void addTestCases(String slug, List<TestCaseRequest> testCaseRequests);
}
