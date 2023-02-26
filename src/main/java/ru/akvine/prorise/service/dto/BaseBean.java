package ru.akvine.prorise.service.dto;

import com.google.common.base.Preconditions;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import ru.akvine.prorise.entities.BaseEntity;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class BaseBean<ID> {
    private ID id;
    private String uuid;
    private LocalDate createdDate;
    private LocalDate updatedDate;

    public BaseBean(BaseEntity entity) {
        Preconditions.checkNotNull(entity, "entity is null");
        this.uuid = entity.getUuid();
        this.createdDate = entity.getCreatedDate();
        this.updatedDate = entity.getUpdatedDate();
    }
}
