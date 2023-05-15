package ru.akvine.prorise.rest.dto.kpi.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;

@Getter
@Setter
@Accessors(chain = true)
public class Employer {
    @Nullable
    private String uuid;

    @Nullable
    private String firstName;

    @Nullable
    private String secondName;

    @Nullable
    private String thirdName;
}
