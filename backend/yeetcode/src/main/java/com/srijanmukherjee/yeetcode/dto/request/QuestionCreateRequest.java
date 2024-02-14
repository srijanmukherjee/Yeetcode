package com.srijanmukherjee.yeetcode.dto.request;

import com.srijanmukherjee.yeetcode.entity.CodeSnippet;
import com.srijanmukherjee.yeetcode.entity.QuestionDifficulty;
import com.srijanmukherjee.yeetcode.entity.Tag;

import java.util.List;
import java.util.Set;

public record QuestionCreateRequest(String title, String slug, String content, QuestionDifficulty difficulty,
                                    List<CodeSnippet> codeSnippets, Set<Tag> tags, String metadata) {
}
