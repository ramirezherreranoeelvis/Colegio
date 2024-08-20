package com.exam.colegio.dto.curso;

import lombok.*;

import java.time.LocalTime;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
public class CursoDTO {

        private String codigo;
        private String nombre;
        private int numeroSalon;
        private int piso;
        private LocalTime horaInicio;
        private LocalTime horaFin;
        private String dia;
        private List<String> profesores;
        private String portada;
        private int numeroSesiones;
        private List<ContentDTO> contenidos;

}
