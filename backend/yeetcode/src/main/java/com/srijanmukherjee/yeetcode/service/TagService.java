package com.srijanmukherjee.yeetcode.service;

import com.srijanmukherjee.yeetcode.dto.request.CreateTagRequest;
import com.srijanmukherjee.yeetcode.dto.response.TagDetailResponse;

import java.util.List;

public interface TagService {
    void addTag(CreateTagRequest topicRequest);
    List<TagDetailResponse> getTags();
}
