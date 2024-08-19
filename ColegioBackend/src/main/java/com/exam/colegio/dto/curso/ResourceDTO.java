package com.exam.colegio.dto.curso;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
public class ContentDTO {

        private String name;
        private int number;
        private boolean isVisible;

}
