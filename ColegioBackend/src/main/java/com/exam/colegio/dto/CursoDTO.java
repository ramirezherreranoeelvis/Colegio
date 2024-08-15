package com.exam.colegio.dto;

import lombok.*;

import java.time.LocalTime;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
public class CursoDTO {

        private int id;
        private String name;
        private int numberClassroom;
        private int floor;
        private LocalTime startTime;
        private LocalTime endTime;
        private String day;
        private List<String> profesores;
        private String portada;

}
