package com.foro.hub.dtos;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public record TopicDto(

        @NotBlank(message = "No puede ser vacio") String titulo,

        @NotBlank(message = "No puede ser vacio") String mensaje,

        @NotBlank(message = "No puede ser vacio") String autor,

        @NotBlank(message = "No puede ser vacio") String curso,

        @Future LocalDateTime fechaCreacion

) {
}
