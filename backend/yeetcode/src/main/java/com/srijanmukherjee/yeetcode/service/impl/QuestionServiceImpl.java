package com.srijanmukherjee.yeetcode.service.impl;

import com.srijanmukherjee.yeetcode.dto.request.QuestionCreateRequest;
import com.srijanmukherjee.yeetcode.dto.request.TestCaseRequest;
import com.srijanmukherjee.yeetcode.dto.response.QuestionDetailResponse;
import com.srijanmukherjee.yeetcode.dto.response.QuestionResponse;
import com.srijanmukherjee.yeetcode.exception.ResourceNotFoundException;
import com.srijanmukherjee.yeetcode.mapping.QuestionPojoMapper;
import com.srijanmukherjee.yeetcode.mapping.TestCasePojoMapper;
import com.srijanmukherjee.yeetcode.repository.CodeSnippetRepository;
import com.srijanmukherjee.yeetcode.repository.LanguageRepository;
import com.srijanmukherjee.yeetcode.repository.QuestionRepository;
import com.srijanmukherjee.yeetcode.repository.TestCaseRepository;
import com.srijanmukherjee.yeetcode.service.QuestionService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    QuestionRepository questionRepository;
    CodeSnippetRepository codeSnippetRepository;
    LanguageRepository languageRepository;
    TestCaseRepository testCaseRepository;
    QuestionPojoMapper questionPojoMapper;
    TestCasePojoMapper testCasePojoMapper;

    @Override
    @Transactional
    public void addQuestion(QuestionCreateRequest questionCreateRequest) {
        var question = questionPojoMapper.questionCreateRequestToQuestion(questionCreateRequest);
        for (var snippet : question.getCodeSnippets()) {
            if (!languageRepository.existsById(snippet.getLanguage().getId())) {
                throw new ResourceNotFoundException("Language %s doesn't exist".formatted(snippet.getLanguage().getId()));
            }
        }
        codeSnippetRepository.saveAll(question.getCodeSnippets());
        questionRepository.save(question);
    }

    @Override
    public List<QuestionResponse> getQuestions() {
        var questions = new ArrayList<QuestionResponse>();
        questionRepository.findAll().forEach(q -> questions.add(questionPojoMapper.questionToQuestionResponse(q)));
        return questions;
    }

    @Override
    public QuestionDetailResponse getQuestion(String slug) {
        var question = questionRepository.findBySlug(slug).orElseThrow(() -> new ResourceNotFoundException("Question with slug %s not found".formatted(slug)));
        var exampleTestCases = testCaseRepository.findTestCaseByQuestionIdAndExampleIs(question.getId(), true);
        var questionDetailResponse = questionPojoMapper.questionToQuestionDetailResponse(question);
        questionDetailResponse.setExampleTestCases(testCasePojoMapper.testCaseToTestCaseResponse(exampleTestCases));
        return questionDetailResponse;
    }

    @Override
    public void updateQuestion() {

    }

    @Override
    @Transactional
    public void addTestCases(String slug, List<TestCaseRequest> testCaseRequests) {
        var question = questionRepository.findBySlug(slug).orElseThrow(() -> new ResourceNotFoundException("Question with slug %s not found".formatted(slug)));
        var testCases = testCasePojoMapper.testCaseRequestToTestCase(testCaseRequests);

        testCases.forEach(question::addTestCase);
        testCaseRepository.saveAll(testCases);
    }
}
