package com.exam.colegio.util;

/**
 * @author Gatomontes
 */
public enum Permission {

        TEACHER("TEACHER"),
        ALL("ALL");

        private final String displayName;

        Permission(String displayName) {
                this.displayName = displayName;
        }

        public String getDisplayName() {
                return displayName;
        }
}
