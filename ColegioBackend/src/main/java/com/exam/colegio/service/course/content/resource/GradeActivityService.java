package com.exam.colegio.service.course.content.resource;

import com.exam.colegio.model.course.content.resource.activity.Forum;
import com.exam.colegio.model.course.content.resource.activity.Homework;
import com.exam.colegio.model.course.content.resource.activity.exam.DailyExam;
import com.exam.colegio.model.course.content.resource.activity.exam.MonthlyExam;
import com.exam.colegio.model.course.content.resource.activity.exam.WeeklyExam;
import com.exam.colegio.model.course.content.resource.activity.exam.examfinal.ExamFinal;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GradeActivity {

        public double promedioTarea(List<Homework> tareas, int idStudent) {
                var sumaTotalNotasTareas = tareas.stream()
                        .mapToDouble(homework -> {
                                var gradeActivityList = homework.getGradeActivity()
                                        .stream()
                                        .filter(gradeActivity -> gradeActivity != null)
                                        .collect(Collectors.toList());

                                var gradeList = gradeActivityList.stream()
                                        .filter(gradeActivity -> gradeActivity.getPerson().getIdPerson() == idStudent)
                                        .findFirst().orElse(null);

                                if (gradeList == null) {
                                        return 0;
                                }
                                return gradeList.getGradeValue().doubleValue();

                        })
                        .sum();
                return sumaTotalNotasTareas / tareas.size();
        }

        public double notaExamenFinal(List<ExamFinal> examFinalList, int idStudent) {
                var sumaTotalNotasTareas = examFinalList.stream()
                        .mapToDouble(bimonthlyExam -> {
                                var gradeActivityList = bimonthlyExam.getGradeActivity()
                                        .stream()
                                        .filter(gradeActivity -> gradeActivity != null)
                                        .collect(Collectors.toList());

                                var gradeList = gradeActivityList.stream()
                                        .filter(gradeActivity -> gradeActivity.getPerson().getIdPerson() == idStudent)
                                        .findFirst().orElse(null);

                                if (gradeList == null) {
                                        return 0;
                                }
                                return gradeList.getGradeValue().doubleValue();

                        })
                        .sum();
                return sumaTotalNotasTareas / examFinalList.size();
        }

        public double promedioForo(List<Forum> foros, int idStudent) {
                var sumaTotalNotasTareas = foros.stream()
                        .mapToDouble(homework -> {
                                var gradeActivityList = homework.getGradeActivity()
                                        .stream()
                                        .filter(gradeActivity -> gradeActivity != null)
                                        .collect(Collectors.toList());

                                var gradeList = gradeActivityList.stream()
                                        .filter(gradeActivity -> gradeActivity.getPerson().getIdPerson() == idStudent)
                                        .findFirst().orElse(null);

                                if (gradeList == null) {
                                        return 0;
                                }
                                return gradeList.getGradeValue().doubleValue();

                        })
                        .sum();
                return sumaTotalNotasTareas / foros.size();
        }

        public double promedioExamenesDiarios(List<DailyExam> examenesDiarios, int idStudent) {
                var sumaTotalNotasTareas = examenesDiarios.stream()
                        .mapToDouble(homework -> {
                                var gradeActivityList = homework.getGradeActivity()
                                        .stream()
                                        .filter(gradeActivity -> gradeActivity != null)
                                        .collect(Collectors.toList());

                                var gradeList = gradeActivityList.stream()
                                        .filter(gradeActivity -> gradeActivity.getPerson().getIdPerson() == idStudent)
                                        .findFirst().orElse(null);

                                if (gradeList == null) {
                                        return 0;
                                }
                                return gradeList.getGradeValue().doubleValue();

                        })
                        .sum();
                return sumaTotalNotasTareas / examenesDiarios.size();
        }

        public double promedioExamenesSemanales(List<WeeklyExam> examenesSemanales, int idStudent) {
                var sumaTotalNotasTareas = examenesSemanales.stream()
                        .mapToDouble(homework -> {
                                var gradeActivityList = homework.getGradeActivity()
                                        .stream()
                                        .filter(gradeActivity -> gradeActivity != null)
                                        .collect(Collectors.toList());

                                var gradeList = gradeActivityList.stream()
                                        .filter(gradeActivity -> gradeActivity.getPerson().getIdPerson() == idStudent)
                                        .findFirst().orElse(null);

                                if (gradeList == null) {
                                        return 0;
                                }
                                return gradeList.getGradeValue().doubleValue();

                        })
                        .sum();
                return sumaTotalNotasTareas / examenesSemanales.size();
        }

        public double promedioExamenesMensuales(List<MonthlyExam> examenesMensuales, int idStudent) {
                var sumaTotalNotasTareas = examenesMensuales.stream()
                        .mapToDouble(homework -> {
                                var gradeActivityList = homework.getGradeActivity()
                                        .stream()
                                        .filter(gradeActivity -> gradeActivity != null)
                                        .collect(Collectors.toList());

                                var gradeList = gradeActivityList.stream()
                                        .filter(gradeActivity -> gradeActivity.getPerson().getIdPerson() == idStudent)
                                        .findFirst().orElse(null);

                                if (gradeList == null) {
                                        return 0;
                                }
                                return gradeList.getGradeValue().doubleValue();

                        })
                        .sum();
                return sumaTotalNotasTareas / examenesMensuales.size();
        }


}
