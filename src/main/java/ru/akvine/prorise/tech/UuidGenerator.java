package ru.akvine.prorise.tech;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UuidGenerator {
    public String generate() {
        return UUID.randomUUID().toString().toUpperCase();
    }

    public String generate(int length) {
        String generatedUuid = generate();
        validate(generatedUuid, length);
        return generatedUuid.substring(0, length);
    }

    public String generate(String target) {
        return generate().replace(target, "");
    }

    public String generate(int length, String target) {
        String generatedUuid = generate().replace(target, "");
        validate(generatedUuid, length);
        return generatedUuid.substring(0, length);
    }

    public String generate(int length, String target, String replacement) {
        String generatedUuid = generate().replace(target, replacement);
        validate(generatedUuid, length);
        return generatedUuid.substring(0, length);
    }

    private void validate(String uuid, int length) {
        if (length > uuid.length() || length < -1) {
            throw new RuntimeException("Length can't be less -1 or more than generated uuid");
        }
    }
}
