package com.srijanmukherjee.yeetcode.mapping;

import com.srijanmukherjee.yeetcode.dto.request.TestCaseRequest;
import com.srijanmukherjee.yeetcode.dto.response.TestCaseResponse;
import com.srijanmukherjee.yeetcode.entity.TestCase;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = ComponentModel.SPRING)
public interface TestCasePojoMapper {
    List<TestCaseResponse> testCaseToTestCaseResponse(List<TestCase> testCases);
    List<TestCase> testCaseRequestToTestCase(List<TestCaseRequest> testCaseRequests);
}
