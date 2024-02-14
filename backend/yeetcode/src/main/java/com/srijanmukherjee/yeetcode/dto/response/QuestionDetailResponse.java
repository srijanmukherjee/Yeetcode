package com.srijanmukherjee.yeetcode.dto.response;

import com.srijanmukherjee.yeetcode.entity.CodeSnippet;
import com.srijanmukherjee.yeetcode.entity.TestCase;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString(exclude = "exampleTestCases")
public class QuestionDetailResponse {
        String title;
        String slug;
        String content;
        String metadata;
        List<CodeSnippet> codeSnippets;
        Set<TagDetailResponse> tags;
        List<TestCaseResponse> exampleTestCases;
        String createdAt;
        String updatedAt;
}
