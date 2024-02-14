package com.srijanmukherjee.yeetcode.dto.response;

import com.srijanmukherjee.yeetcode.entity.QuestionDifficulty;

import java.util.HashSet;
import java.util.Set;

public record QuestionResponse(
        String title,
        String slug,
        QuestionDifficulty difficulty,
        Set<TagResponse> tags,
        String createdAt,
        String updatedAt) {
}
