package com.exam.colegio.util;

public enum TypePeriod {

        BIMESTRE("BIMESTRE"),
        TRIMESTRE("TRIMESTRE");

        private final String displayName;

        TypePeriod(String displayName) {
                this.displayName = displayName;
        }

        public String getDisplayName() {
                return displayName;
        }
}
