package com.srijanmukherjee.yeetcode.mapping;


import com.srijanmukherjee.yeetcode.dto.request.CreateTagRequest;
import com.srijanmukherjee.yeetcode.dto.response.TagDetailResponse;
import com.srijanmukherjee.yeetcode.entity.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

import java.util.List;

@Mapper(componentModel = ComponentModel.SPRING)
public interface TagPojoMapper {
    Tag createTagRequestToTag(CreateTagRequest tagRequest);
    List<TagDetailResponse> tagToTagResponse(Iterable<Tag> tag);
}
