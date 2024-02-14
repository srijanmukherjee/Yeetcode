package com.srijanmukherjee.yeetcode.mapping;

import com.srijanmukherjee.yeetcode.dto.request.QuestionCreateRequest;
import com.srijanmukherjee.yeetcode.dto.request.QuestionUpdateRequest;
import com.srijanmukherjee.yeetcode.dto.response.QuestionDetailResponse;
import com.srijanmukherjee.yeetcode.dto.response.QuestionResponse;
import com.srijanmukherjee.yeetcode.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = ComponentModel.SPRING)
public interface QuestionPojoMapper {
    QuestionResponse questionToQuestionResponse(Question question);
    QuestionDetailResponse questionToQuestionDetailResponse(Question question);
    Question questionCreateRequestToQuestion(QuestionCreateRequest questionCreateRequest);
    void updateQuestionFromQuestionUpdateRequest(QuestionUpdateRequest questionUpdateRequest, @MappingTarget Question question);
}
