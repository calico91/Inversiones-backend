package com.cblandon.inversiones.Excepciones.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDTO {
    private Integer status;
    private String message;
}
