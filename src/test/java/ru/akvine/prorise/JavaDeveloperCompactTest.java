package ru.akvine.prorise;

import org.junit.jupiter.api.Test;
import ru.yaal.project.hhapi.HhApi;
import ru.yaal.project.hhapi.dictionary.Constants;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.Area;
import ru.yaal.project.hhapi.dictionary.entry.entries.proffield.ProfField;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.Period;
import ru.yaal.project.hhapi.search.parameter.Text;
import ru.yaal.project.hhapi.vacancy.Salary;
import ru.yaal.project.hhapi.vacancy.Vacancy;
import ru.yaal.project.hhapi.vacancy.VacancyList;
import ru.yaal.project.hhapi.vacancy.VacancySearch;

import static java.lang.System.out;

public class JavaDeveloperCompactTest {
    @Test
    public void javaDeveloperCompact() throws SearchException {
//        VacancyList vacancies = HhApi.search(
//                50,
//                new Text("java", Constants.VacancySearchFields.VACANCY_NAME),
//                Area.AREAS.getByName("Россия"),
//                ProfField.PROF_FIELDS.getById("1.221"),
//                new Salary(3000, 5000, Constants.Currency.USD),
//                Constants.Experience.BETWEEN_3_AND_6,
//                new Period(30),
//                Constants.Schedule.FULL_DAY,
//                Constants.Employment.FULL
//        );

//        out.printf("Вакансии.\n", vacancies.size());

//        Vacancy v0 = vacancies.get(0);
//        out.println(v0.getId());
//        out.println(v0.getName());
//        out.println(v0.getSalary());
//        out.println(v0.getProfFields());
//        out.println(v0.getExperience());
//        out.println(v0.getAcceptHandicapped());
//        out.println(v0.getAddress());
//        out.println(v0.getArea());
//        out.println(v0.getSchedule());
//        out.println(v0.getUrl());
//        out.println(v0.getArchived());
//        out.println(v0.getDescription());
//        out.println(v0.getCreatedAt());
//        out.println(v0.getEmployer());
//        out.println(v0.getType());
//        out.println(v0.getResponseLetterRequired());
//        out.println(v0.getRelations());
//        out.println(v0.getEmployment());
//        out.println(v0.getAlternateUrl());
    }

    @Test
    public void findEmployees() throws SearchException {
//        VacancyList vacancies = HhApi.search(
//                50,
//                new Text("java", Constants.VacancySearchFields.COMPANY_NAME)
//        );
    }



}
