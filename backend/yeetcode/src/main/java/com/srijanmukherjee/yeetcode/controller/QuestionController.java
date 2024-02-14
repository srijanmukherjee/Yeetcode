package com.srijanmukherjee.yeetcode.controller;

import com.srijanmukherjee.yeetcode.dto.request.QuestionCreateRequest;
import com.srijanmukherjee.yeetcode.dto.request.TestCaseRequest;
import com.srijanmukherjee.yeetcode.dto.response.QuestionDetailResponse;
import com.srijanmukherjee.yeetcode.dto.response.QuestionResponse;
import com.srijanmukherjee.yeetcode.entity.Question;
import com.srijanmukherjee.yeetcode.entity.TestCase;
import com.srijanmukherjee.yeetcode.service.QuestionService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/questions")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class QuestionController {
    QuestionService questionService;

    @GetMapping
    public List<QuestionResponse> getQuestions() {
        return questionService.getQuestions();
    }

    @GetMapping("/{slug}")
    public ResponseEntity<QuestionDetailResponse> getQuestion(@PathVariable String slug) {
        var question = questionService.getQuestion(slug);
        return ResponseEntity.ok().body(question);
    }

    @PostMapping
    public ResponseEntity<?> addQuestion(@RequestBody QuestionCreateRequest question) {
        questionService.addQuestion(question);
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    public void updateQuestion(@RequestBody Question question) {
        throw new RuntimeException("Not implemented");
    }

    @PutMapping("/{slug}/testcase")
    public ResponseEntity<?> addTestCase(@PathVariable String slug, @RequestBody List<TestCaseRequest> testCases) {
        questionService.addTestCases(slug, testCases);
        return ResponseEntity.ok().build();
    }
}
