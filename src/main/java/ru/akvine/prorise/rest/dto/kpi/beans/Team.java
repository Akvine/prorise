package ru.akvine.prorise.rest.dto.kpi.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;

@Getter
@Setter
@Accessors(chain = true)
public class Team {
    @Nullable
    private String title;
}
