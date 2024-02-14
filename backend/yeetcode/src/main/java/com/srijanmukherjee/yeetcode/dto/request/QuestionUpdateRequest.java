package com.srijanmukherjee.yeetcode.dto.request;

import com.srijanmukherjee.yeetcode.entity.QuestionDifficulty;

public record QuestionUpdateRequest(String title, String slug, QuestionDifficulty difficulty, String content) {
}
