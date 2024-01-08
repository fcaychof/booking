package com.caycho.booking.controller.request;

import lombok.Builder;

@Builder
public record PropertyRequest(String description) {
}
