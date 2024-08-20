package com.exam.colegio.dto.curso;

import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
public class ResourceDTO {

        private String nombre;
        private String descripcion;
        private String tipo;
        private List<ItemDTO> items;

}
