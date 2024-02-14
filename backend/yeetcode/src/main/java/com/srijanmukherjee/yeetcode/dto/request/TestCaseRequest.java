package com.srijanmukherjee.yeetcode.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TestCaseRequest {
    String input;
    String output;
    boolean example = false;
}

