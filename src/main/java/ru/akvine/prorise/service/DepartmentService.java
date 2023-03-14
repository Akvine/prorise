package ru.akvine.prorise.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.akvine.prorise.repositories.DepartmentRepository;
import ru.akvine.prorise.repositories.DepartmentTypeRepository;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentTypeRepository departmentTypeRepository;

}
