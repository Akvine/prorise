package ru.akvine.prorise.entities.task;

public enum PriorityType {
    HIGHEST,
    HIGH,
    MEDIUM,
    LOW,
    LOWEST;

    public static PriorityType safeValueOf(String value) {
        switch (value.toUpperCase()) {
            case "HIGHEST": return HIGHEST;
            case "HIGH": return HIGH;
            case "MEDIUM": return MEDIUM;
            case "LOW": return LOW;
            case "LOWEST": return LOWEST;
            default:
                throw new IllegalArgumentException("Not exists priority");
        }
    }
}
