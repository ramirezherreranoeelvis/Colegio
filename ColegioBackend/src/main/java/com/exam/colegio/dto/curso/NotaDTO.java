package com.exam.colegio.dto.curso;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
public class NotaDTO {
        private String comentario;
        private BigDecimal nota;
        private Date fechaCalificacion;
}
