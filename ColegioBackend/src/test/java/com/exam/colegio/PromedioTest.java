package com.exam.colegio;

import com.exam.colegio.dto.notas.Promedio;
import com.exam.colegio.model.course.CourseScheduled;
import com.exam.colegio.model.course.content.resource.activity.Homework;
import com.exam.colegio.model.enrollment.Enrollment;
import com.exam.colegio.model.enrollment.EnrollmentPeriod;
import com.exam.colegio.model.enrollment.Period;
import com.exam.colegio.repository.enrollment.IEnrollmentRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class PromedioTest {

        @Transactional
        @Test
        void obternetPromedioByIdEnrollment() {

                Enrollment enrollment = this.enrollmentRepository.findById(7).get();
                int idStudent = 28;
                List<EnrollmentPeriod> enrollmentPeriods = enrollment.getEnrollmentPeriods();
                List<CourseScheduled> cursosProgramados = enrollment.getCourseScheduleds();

                List<Promedio> notas = cursosProgramados.stream()
                        .map(courseScheduled -> {
                                        List<Integer> promedios = new ArrayList<>();
                                        enrollmentPeriods.forEach(enrollmentPeriod -> {
                                                if (enrollmentPeriod.isVisibilityDate()) {
                                                        var period = enrollmentPeriod.getPeriod();
                                                        var homeworkList = getActivity(courseScheduled, period.getStartDate(), period.getEndtDate());

                                                        Integer promedio = (int) homeworkList.stream()
                                                                .mapToDouble(homework -> homework.getGradeActivity()
                                                                        .stream().filter(gradeActivity -> gradeActivity.getPerson().getIdPerson() == idStudent).findFirst().get()
                                                                        .getGradeValue().doubleValue())
                                                                .sum();

                                                        promedios.add(promedio);

                                                } else {
                                                        promedios.add(null);
                                                }


                                        });
                                        return Promedio.builder()
                                                .nombre(courseScheduled.getCourse().getName())
                                                .promedios(promedios)
                                                .build();
                                }
                        ).toList();

                notas.forEach(promedio -> {
                        System.out.println(promedio.getNombre());
                        promedio.getPromedios().forEach(System.out::println);
                });

        }

        List<Homework> getActivity(CourseScheduled courseScheduled, Date createdAt, Date dueDate) {
                return courseScheduled.getContentList().stream()
                        .flatMap(content -> content.getResourceList().stream())
                        .filter(resource -> resource.getType().equals("homework"))
                        .map(Homework.class::cast)
                        .filter(homework -> homework.getDueDate().before(dueDate) && !homework.getDueDate().before(createdAt))
                        .collect(Collectors.toList());
        }

        double promedioTarea(List<Double> notas) {
                return notas.stream().mapToDouble(value -> value).sum() / notas.size();
        }

        double promedioExamenes(List<Double> notas) {
                return notas.stream().mapToDouble(value -> value).sum() / notas.size();
        }

        double promedioPeriodo(double notaExamenFinal, double notaTarea) {
                return notaExamenFinal + notaTarea / 2;
        }

        double promedioGeneral(List<Double> notas) {
                return notas.stream().mapToDouble(value -> value).sum() / notas.size();
        }

        private final IEnrollmentRepository enrollmentRepository;

        @Autowired
        public PromedioTest(IEnrollmentRepository enrollmentRepository) {
                this.enrollmentRepository = enrollmentRepository;
        }

}
