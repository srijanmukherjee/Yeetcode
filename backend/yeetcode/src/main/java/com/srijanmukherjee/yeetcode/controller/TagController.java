package com.srijanmukherjee.yeetcode.controller;

import com.srijanmukherjee.yeetcode.dto.request.CreateTagRequest;
import com.srijanmukherjee.yeetcode.dto.response.TagDetailResponse;
import com.srijanmukherjee.yeetcode.service.TagService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TagController {
    TagService tagService;

    @GetMapping
    public List<TagDetailResponse> getTags() {
        return tagService.getTags();
    }

    @PostMapping
    public void addTag(@RequestBody CreateTagRequest tagRequest) {
        tagService.addTag(tagRequest);
    }
}
