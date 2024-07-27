package com.exam.colegio.entity.other;

/**
 *
 * @author Gatomontes
 */
public enum DayOfWeek {

        MONDAY("LUNES"),
        TUESDAY("MARTES"),
        WEDNESDAY("MIERCOLES"),
        THURSDAY("JUEVES"),
        FRIDAY("VIERNES"),
        SATURDAY("SABADO"),
        SUNDAY("DOMINGO");

        private final String displayName;

        DayOfWeek(String displayName) {
                this.displayName = displayName;
        }

        public String getDisplayName() {
                return displayName;
        }
}
