package com.srijanmukherjee.yeetcode.service.impl;

import com.srijanmukherjee.yeetcode.dto.request.CreateTagRequest;
import com.srijanmukherjee.yeetcode.dto.response.TagDetailResponse;
import com.srijanmukherjee.yeetcode.mapping.TagPojoMapper;
import com.srijanmukherjee.yeetcode.repository.TagRepository;
import com.srijanmukherjee.yeetcode.service.TagService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TagServiceImpl implements TagService {
    TagRepository tagRepository;
    TagPojoMapper tagPojoMapper;

    @Override
    public void addTag(CreateTagRequest tagRequest) {
        var topic = tagPojoMapper.createTagRequestToTag(tagRequest);
        tagRepository.save(topic);
    }

    @Override
    public List<TagDetailResponse> getTags() {
        var topics = tagRepository.findAll();
        return tagPojoMapper.tagToTagResponse(topics);
    }
}
