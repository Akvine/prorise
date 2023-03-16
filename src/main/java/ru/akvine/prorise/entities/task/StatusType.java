package ru.akvine.prorise.entities.task;

public enum StatusType {
    BACKLOG,
    STOPPED,
    OPEN,
    IN_PROGRESS,
    IN_REVIEW,
    IN_TESTING,
    DONE;

    public static StatusType safeValueOf(String value) {
        switch (value.toUpperCase()) {
            case "BACKLOG": return BACKLOG;
            case "STOPPED": return STOPPED;
            case "OPEN": return OPEN;
            case "IN_PROGRESS": return IN_PROGRESS;
            case "IN_REVIEW": return IN_REVIEW;
            case "IN_TESTING": return IN_TESTING;
            case "DONE": return DONE;
            default:
                throw new IllegalArgumentException("Not exists status");
        }
    }
}
