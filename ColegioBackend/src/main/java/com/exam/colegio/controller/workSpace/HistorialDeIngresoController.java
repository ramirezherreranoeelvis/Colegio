package com.exam.colegio.controller.workspace;

import com.exam.colegio.dao.other.IEntrySchoolDAO;
import com.exam.colegio.dto.historial.DiaIngreso;
import com.exam.colegio.dto.historial.EventDTO;
import com.exam.colegio.dto.historial.SemanaDTO;
import com.exam.colegio.model.other.EntrySchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/historial")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class HistorialDeIngresoController {

        public ResponseEntity<?> findAllByStudent(@RequestParam String dniStudent) {

                return ResponseEntity.ok("");
        }

        @GetMapping
        public List<?> historial() {
                // Obtiene todas las entradas de la escuela
                var fechasSinAlumno = entrySchoolDAO.findAll().stream()
                        .map(entrySchool -> EntrySchool.builder()
                                .idEntrySchool(entrySchool.getIdEntrySchool())
                                .timeEntry(entrySchool.getTimeEntry())
                                .timeExit(entrySchool.getTimeExit())
                                .build())
                        .collect(Collectors.toList());

                rellenarDiasIntermedios(fechasSinAlumno);
                return castListSemanaDTO(fechasSinAlumno);
        }

        public static void rellenarDiasIntermedios(List<EntrySchool> list) {
                List<EntrySchool> newEntries = new ArrayList<>();

                // Agrupar por semana
                list.stream().collect(Collectors.groupingBy(entry -> {
                        LocalDate date = entry.getTimeEntry().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        return date.with(DayOfWeek.MONDAY);
                })).forEach((weekStart, entries) -> {
                        // Crear un conjunto de días presentes en la semana
                        List<DayOfWeek> daysPresent = entries.stream().map(entry -> entry.getTimeEntry().toInstant().atZone(ZoneId.systemDefault()).getDayOfWeek()).collect(Collectors.toList());

                        // Rellenar los días faltantes
                        for (DayOfWeek day : DayOfWeek.values()) {
                                if (!daysPresent.contains(day)) {
                                        try {
                                                LocalDate date = weekStart.plusDays(day.getValue() - 1);
                                                Date timeEntry = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
                                                newEntries.add(EntrySchool.builder().timeEntry(timeEntry).build());
                                        } catch (Exception e) {
                                                e.printStackTrace();
                                        }
                                }
                        }
                });

                list.addAll(newEntries);
                list.sort((e1, e2) -> e1.getTimeEntry().compareTo(e2.getTimeEntry()));
        }

        public static List<SemanaDTO> castListSemanaDTO(List<EntrySchool> list) {
                //datos:
                List<SemanaDTO> semanaDTOS = new ArrayList<>();
                List<EntrySchool[]> semanas = new ArrayList<>();

                //separacion por semanas:
                BiFunction<List<EntrySchool>, List<EntrySchool[]>, List<EntrySchool[]>> separacionPorSemanas = (x, y) -> {
                        var semana = new EntrySchool[7];
                        int nDiaSemana = 0;
                        for (var entradas : x) {
                                if (nDiaSemana == 7) {
                                        nDiaSemana = 0;
                                        y.add(semana);
                                        semana = new EntrySchool[7];
                                }
                                semana[nDiaSemana] = entradas;
                                nDiaSemana++;
                        }
                        return y;
                };
                semanas = separacionPorSemanas.apply(list, semanas);

                //conversion de arreglos uno por uno arreglo convirtiendo:
                for (var semana : semanas) {
                        semanaDTOS.add(castSemanaDTO(semana));
                }

                //resultado:
                return semanaDTOS;
        }

        public static SemanaDTO castSemanaDTO(EntrySchool[] entrySchools) {
                SemanaDTO semanaDTO = new SemanaDTO();
                semanaDTO.setName("Semana Actual");
                List<DiaIngreso> dias = new ArrayList<>();

                int nDia = 0;
                var nameDias = new String[]{"lunes", "martes", "miércoles", "jueves", "viernes", "sábado", "domingo"};
                // Recorrer el arreglo de EntrySchool
                for (EntrySchool entry : entrySchools) {
                        DiaIngreso dia = new DiaIngreso();
                        //ponemos nombre del dia
                        dia.setName(nameDias[nDia]);

                        // Verificar si el idEntrySchool es 0
                        if (entry.getIdEntrySchool() != 0) {
                                dia.setEntrada(convertirEvento(entry.getTimeEntry(), "asistio"));
                                if (entry.getTimeExit() != null) {
                                        dia.setSalida(convertirEvento(entry.getTimeExit(), "asistio"));
                                } else {
                                        dia.setSalida(convertirEvento(entry.getTimeEntry(), "falto"));
                                }

                        } else {
                                dia.setEntrada(convertirEvento(entry.getTimeEntry(), ""));
                                dia.setSalida(convertirEvento(entry.getTimeEntry(), ""));
                        }

                        dia.setElementoFinal(false); // Ajustar según sea necesario
                        dias.add(dia);

                        //incrementamos dia y si es el ultimo vuelve al 0 que es lunes
                        nDia++;
                        if (nDia == 7) {
                                nDia = 0;
                        }
                }

                // Establecer el último elemento como elementoFinal
                if (!dias.isEmpty()) {
                        dias.get(dias.size() - 1).setElementoFinal(true);
                }

                semanaDTO.setDias(dias);
                return semanaDTO;
        }

        private static EventDTO convertirEvento(Date fecha, String status) {
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                EventDTO evento = new EventDTO();
                evento.setContent(formato.format(fecha));
                evento.setStatus(status);
                return evento;
        }

        private final IEntrySchoolDAO entrySchoolDAO;

        @Autowired
        public HistorialDeIngresoController(IEntrySchoolDAO entrySchoolDAO) {
                this.entrySchoolDAO = entrySchoolDAO;
        }

}
