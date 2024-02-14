package com.srijanmukherjee.yeetcode.dto.request;

import java.util.UUID;

public record ConfirmationRequest(String code, UUID userId) {
}
