package com.example.inventory.common.web;

import java.util.Map;

public record ApiError(String code, String message, Map<String, Object> params) {
}
