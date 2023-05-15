package ru.akvine.prorise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.akvine.prorise.entities.employer.EmployerEntity;

import java.util.List;
import java.util.Optional;

public interface EmployerRepository extends JpaRepository<EmployerEntity, Long> {

    @Query("from EmployerEntity ee where ee.uuid = :uuid and ee.deleted = false")
    Optional<EmployerEntity> findByUuidAndNotDeleted(@Param("uuid") String uuid);

    @Query("from EmployerEntity ee " +
            "where " +
            "ee.team.departmentEntity.title like concat('%', :title, '%') or concat('', ee.team.departmentEntity.departmentType.type) like concat('%', :type, '%') " +
            "and " +
            "ee.deleted = false and ee.deletedDate is null " +
            "and " +
            "ee.team.deleted = false and ee.team.deletedDate is null " +
            "and " +
            "ee.team.departmentEntity.deleted = false and ee.team.departmentEntity.deletedDate is null")
    List<EmployerEntity> findByDepartmentTitleOrType(@Param("title") String title, @Param("type") String type);

    @Query("from EmployerEntity ee " +
            "where " +
            "ee.team.title like concat('%', :title, '%') " +
            "and " +
            "ee.deleted = false and ee.deletedDate is null " +
            "and " +
            "ee.team.deleted = false and ee.team.deletedDate is null")
    List<EmployerEntity> findByTeamTitle(@Param("title") String title);

    @Query("from EmployerEntity ee " +
            "where " +
            "ee.uuid like concat('%', :uuid, '%') " +
            "or ee.firstName like concat('%', :firstName, '%') " +
            "or ee.secondName like concat('%', :secondName, '%') " +
            "or ee.thirdName like concat('%', :thirdName, '%') " +
            "and ee.deleted = false and ee.deletedDate is null")
    List<EmployerEntity> findByUuidOrFirstNameOrSecondNameOrThirdName(@Param("uuid") String uuid, @Param("firstName") String firstName, @Param("secondName") String secondName, @Param("thirdName") String thirdName);
}
