package ru.akvine.prorise.service.dto.kpi.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class EmployerFilter {
    @Nullable
    private String uuid;

    @Nullable
    private String firstName;

    @Nullable
    private String secondName;

    @Nullable
    private String thirdName;
}
