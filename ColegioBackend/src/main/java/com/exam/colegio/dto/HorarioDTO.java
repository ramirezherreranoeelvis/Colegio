package com.exam.colegio.dto;

import com.exam.colegio.entity.course.CourseScheduled;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

/**
 *
 * @author Gatomontes
 */
@Getter
@Builder
public class HorarioDTO {

        private List<CourseScheduled> courseScheduleds;
        
        

}
