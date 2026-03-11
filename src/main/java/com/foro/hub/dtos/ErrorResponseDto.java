package com.foro.hub.dtos;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorResponseDto(
                String status,
                String message,
                LocalDateTime time,
                List<String> details) {
}
