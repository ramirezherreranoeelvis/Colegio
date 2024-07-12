package com.exam.colegio.dto;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @author Gatomontes
 */
@Getter
@Builder
public class CourseHorarioDTO {

        private String name;

        private LocalTime startTime;

        private LocalTime endTime;

        private String day;

}
