package com.flipkart.cache;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Response {
    private String value;
    private int totalTime;
}
