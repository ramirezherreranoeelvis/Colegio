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
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/historial")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class HistorialDeIngresoController {


        public ResponseEntity<?> findAllByStudent(@RequestParam String dniStudent) {

                return ResponseEntity.ok("");
        }

        @GetMapping
        public List<SemanaDTO> convertir() {
                // Obtiene todas las entradas de la escuela
                var fechasSinAlumno = entrySchoolDAO.findAll().stream()
                        .map(entrySchool -> EntrySchool.builder()
                                .idEntrySchool(entrySchool.getIdEntrySchool())
                                .timeEntry(entrySchool.getTimeEntry())
                                .timeExit(entrySchool.getTimeExit())
                                .build())
                        .toList();

                // Agrupar las entradas por semanas
                Map<String, List<EntrySchool>> semanas = new HashMap<>();

                for (EntrySchool entry : fechasSinAlumno) {
                        // Formatear la fecha para obtener el día de la semana
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(entry.getTimeEntry());
                        String semanaKey = getSemanaKey(calendar); // Método que devuelve la clave de la semana

                        // Agrupar por semana
                        semanas.computeIfAbsent(semanaKey, k -> new ArrayList<>()).add(entry);
                }

                // Convertir a lista de SemanaDTO
                List<SemanaDTO> semanaDTOs = new ArrayList<>();
                for (Map.Entry<String, List<EntrySchool>> entry : semanas.entrySet()) {
                        List<DiaIngreso> dias = new ArrayList<>();
                        Map<Integer, EntrySchool> diasExistentes = new HashMap<>();

                        // Guardar las entradas existentes en un mapa para referencia
                        for (EntrySchool entrySchool : entry.getValue()) {
                                Calendar calendar = Calendar.getInstance();
                                calendar.setTime(entrySchool.getTimeEntry());
                                int diaDelMes = calendar.get(Calendar.DAY_OF_MONTH);
                                diasExistentes.put(diaDelMes, entrySchool);
                        }

                        // Iterar sobre los días de la semana (de 1 a 7)
                        // Parte del código donde se añaden días con estado vacío
                        for (int i = Calendar.SUNDAY; i <= Calendar.SATURDAY; i++) {
                                // Establecer el primer día del mes como referencia
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(Calendar.DAY_OF_WEEK, i);
                                calendar.set(Calendar.WEEK_OF_YEAR, getSemanaNumber(entry.getKey()));
                                calendar.set(Calendar.YEAR, getYear(entry.getKey()));

                                // Asegúrate de que la fecha esté configurada correctamente
                                if (calendar.getTime() != null) {
                                        String diaName = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
                                        int diaDelMes = calendar.get(Calendar.DAY_OF_MONTH);

                                        EntrySchool entrySchool = diasExistentes.get(diaDelMes);
                                        DiaIngreso dia = new DiaIngreso();
                                        dia.setName(diaName);

                                        if (entrySchool != null) {
                                                // Suponiendo que tienes un método para obtener el estado
                                                String statusEntrada = "asistio"; // Lógica para determinar estado real
                                                String statusSalida = "falto"; // Lógica para determinar estado real

                                                dia.setEntrada(new EventDTO(formatDate(entrySchool.getTimeEntry()), statusEntrada));
                                                dia.setSalida(new EventDTO(formatDate(entrySchool.getTimeExit()), statusSalida));
                                                dia.setElementoFinal(false); // Cambiar según la lógica requerida
                                        } else {
                                                // Asegurarse de que calendar.getTime() no es null
                                                Date fechaFaltante = calendar.getTime();
                                                dia.setEntrada(new EventDTO(formatDate(fechaFaltante), "falto"));
                                                dia.setSalida(new EventDTO(formatDate(fechaFaltante), "falto"));
                                                dia.setElementoFinal(false); // Cambiar según la lógica requerida
                                        }

                                        dias.add(dia);
                                }
                        }

                        SemanaDTO semanaDTO = new SemanaDTO(entry.getKey(), dias);
                        semanaDTOs.add(semanaDTO);
                }

                return semanaDTOs;
        }

        // Método auxiliar para determinar la clave de la semana
        private String getSemanaKey(Calendar calendar) {
                int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
                int year = calendar.get(Calendar.YEAR);
                return "Semana " + weekOfYear + " del " + year;
        }

        // Método auxiliar para obtener el número de la semana desde el nombre de la semana
        private int getSemanaNumber(String semanaKey) {
                return Integer.parseInt(semanaKey.split(" ")[1]); // Extrae el número de semana
        }

        // Método auxiliar para obtener el año desde el nombre de la semana
        private int getYear(String semanaKey) {
                return Integer.parseInt(semanaKey.split(" ")[3]); // Extrae el año
        }

        // Método auxiliar para formatear la fecha
        public String formatDate(Date date) {
                if (date == null) {
                        // Maneja la fecha null, tal vez lanzando una excepción o retornando un valor por defecto
                        return "Fecha no disponible"; // o puedes retornar null, dependiendo de lo que desees
                }
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                return sdf.format(date);
        }


        private final IEntrySchoolDAO entrySchoolDAO;

        @Autowired
        public HistorialDeIngresoController(IEntrySchoolDAO entrySchoolDAO) {
                this.entrySchoolDAO = entrySchoolDAO;
        }

}
