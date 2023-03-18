CREATE TABLE DEPARTMENT_TYPE
(
    ID BIGINT NOT NULL,
    CODE VARCHAR(255) NOT NULL,
    CREATED_DATE DATE NOT NULL,
    IS_DELETED BOOLEAN NOT NULL,
    DELETED_DATE DATE,
    DESCRIPTION VARCHAR(255) NOT NULL,
    TYPE VARCHAR(255),
    UPDATED_DATE DATE,
    UUID VARCHAR(255) NOT NULL,
    CONSTRAINT DEPARTMENT_TYPE_PK PRIMARY KEY (id)
);
CREATE SEQUENCE DEPARTMENT_TYPE_ID_SEQUENCE START WITH 1 INCREMENT BY 1000;

CREATE TABLE DEPARTMENT
(
    ID BIGINT NOT NULL,
    CREATED_DATE DATE NOT NULL,
    IS_DELETED BOOLEAN NOT NULL,
    DELETED_DATE DATE,
    DESCRIPTION VARCHAR(255),
    TITLE VARCHAR(255) NOT NULL,
    UPDATED_DATE DATE,
    UUID VARCHAR(255) NOT NULL,
    DEPARTMENT_TYPE_ID BIGINT NOT NULL,
    CONSTRAINT DEPARTMENT_PK PRIMARY KEY (ID),
    CONSTRAINT DEPARTMENT_DEPARTMENT_TYPE_FK FOREIGN KEY (DEPARTMENT_TYPE_ID)
        REFERENCES DEPARTMENT_TYPE (ID)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
CREATE SEQUENCE DEPARTMENT_ID_SEQUENCE START WITH 1 INCREMENT BY 1000;

CREATE TABLE TEAM
(
    ID BIGINT NOT NULL,
    CREATED_DATE DATE NOT NULL,
    IS_DELETED BOOLEAN NOT NULL,
    DELETED_DATE DATE,
    DESCRIPTION VARCHAR(255),
    TITLE VARCHAR(255) NOT NULL,
    UPDATED_DATE DATE,
    UUID VARCHAR(255) NOT NULL,
    DEPARTMENT_ID BIGINT NOT NULL,
    CONSTRAINT TEAM_PK PRIMARY KEY (ID),
    CONSTRAINT TEAM_DEPARTMENT_FK FOREIGN KEY (DEPARTMENT_ID)
        REFERENCES DEPARTMENT (ID)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
CREATE SEQUENCE TEAM_ID_SEQUENCE START WITH 1 INCREMENT BY 1000;

CREATE TABLE PROJECT
(
    ID BIGINT NOT NULL,
    CREATED_DATE DATE NOT NULL,
    IS_DELETED BOOLEAN NOT NULL,
    DELETED_DATE DATE,
    DESCRIPTION VARCHAR(255),
    IS_DONE BOOLEAN NOT NULL,
    END_DATE DATE,
    START_DATE DATE NOT NULL,
    TITLE VARCHAR(255) NOT NULL,
    PROJECT_TYPE VARCHAR(255),
    UPDATED_DATE DATE,
    UUID VARCHAR(255) NOT NULL,
    TEAM_ID BIGINT NOT NULL,
    CONSTRAINT PROJECT_PK PRIMARY KEY (ID),
    CONSTRAINT PROJECT_TEAM_FK FOREIGN KEY (TEAM_ID)
        REFERENCES TEAM (ID)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
CREATE SEQUENCE PROJECT_ID_SEQUENCE START WITH 1 INCREMENT BY 1000;

CREATE TABLE GOAL
(
    ID BIGINT NOT NULL,
    CREATED_DATE DATE NOT NULL,
    IS_DELETED BOOLEAN NOT NULL,
    DELETED_DATE DATE,
    DESCRIPTION VARCHAR(255) NOT NULL,
    IS_DONE BOOLEAN NOT NULL,
    TITLE VARCHAR(255) NOT NULL,
    UPDATED_DATE DATE,
    UUID VARCHAR(255) NOT NULL,
    PROJECT_ID BIGINT NOT NULL,
    CONSTRAINT GOAL_PK PRIMARY KEY (id),
    CONSTRAINT GOAL_PROJECT_FK FOREIGN KEY (PROJECT_ID)
        REFERENCES PROJECT (ID)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
CREATE SEQUENCE GOAL_ID_SEQUENCE START WITH 1 INCREMENT BY 1000;

CREATE TABLE EMPLOYER
(
    ID BIGINT NOT NULL,
    CREATED_DATE DATE NOT NULL,
    IS_DELETED BOOLEAN NOT NULL,
    DELETED_DATE DATE,
    DISMISSAL_DATE DATE,
    EMPLOYMENT_DATE DATE NOT NULL,
    FIRST_NAME VARCHAR(255) NOT NULL,
    SECOND_NAME VARCHAR(255) NOT NULL,
    THIRD_NAME VARCHAR(255),
    EMPLOYER_TYPE VARCHAR(255) NOT NULL,
    UPDATED_DATE DATE,
    UUID VARCHAR(255) NOT NULL,
    TEAM_ID BIGINT NOT NULL,
    CONSTRAINT EMPLOYER_PK PRIMARY KEY (ID),
    CONSTRAINT EMPLOYER_TEAM_FK FOREIGN KEY (TEAM_ID)
        REFERENCES TEAM (ID)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
CREATE SEQUENCE EMPLOYER_ID_SEQUENCE START WITH 1 INCREMENT BY 1000;

CREATE TABLE TASK
(
    ID BIGINT NOT NULL,
    CREATED_DATE DATE NOT NULL,
    IS_DELETED BOOLEAN NOT NULL,
    DELETED_DATE DATE,
    DESCRIPTION VARCHAR(255) NOT NULL,
    IS_DONE BOOLEAN NOT NULL,
    END_DATE DATE,
    PRIORITY_TYPE VARCHAR(255) NOT NULL,
    START_DATE DATE NOT NULL,
    STATUS VARCHAR(255) NOT NULL,
    TITLE VARCHAR(255) NOT NULL,
    UPDATED_DATE DATE,
    UUID VARCHAR(255) NOT NULL,
    EMPLOYER_ID BIGINT NOT NULL,
    GOAL_ID BIGINT NOT NULL,
    CONSTRAINT TASK_PK PRIMARY KEY (ID),
    CONSTRAINT TASK_GOAL_FK FOREIGN KEY (GOAL_ID)
        REFERENCES GOAL (ID)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT TASK_EMPLOYER_FK FOREIGN KEY (EMPLOYER_ID)
        REFERENCES EMPLOYER (ID)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
CREATE SEQUENCE TASK_ID_SEQUENCE START WITH 1 INCREMENT BY 1000;

CREATE TABLE SALARY
(
    ID BIGINT NOT NULL,
    CREATED_DATE DATE NOT NULL,
    CURRENCY_TYPE VARCHAR(255) NOT NULL,
    IS_DELETED BOOLEAN NOT NULL,
    DELETED_DATE DATE,
    SALARY BIGINT NOT NULL,
    UPDATED_DATE DATE,
    UUID VARCHAR(255) NOT NULL,
    EMPLOYER_ID BIGINT NOT NULL,
    CONSTRAINT SALARY_PK PRIMARY KEY (ID),
    CONSTRAINT SALARY_EMPLOYER_FK FOREIGN KEY (EMPLOYER_ID)
        REFERENCES EMPLOYER (ID)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
CREATE SEQUENCE SALARY_ID_SEQUENCE START WITH 1 INCREMENT BY 1000;

CREATE TABLE CONTACT
(
    ID BIGINT NOT NULL,
    CREATED_DATE DATE NOT NULL,
    IS_DELETED BOOLEAN NOT NULL,
    DELETED_DATE DATE,
    EMAIL VARCHAR(255),
    PHONE VARCHAR(255),
    UPDATED_DATE DATE,
    UUID VARCHAR(255) NOT NULL,
    EMPLOYER_ID BIGINT NOT NULL,
    CONSTRAINT CONTACT_PK PRIMARY KEY (ID),
    CONSTRAINT CONTACT_EMPLOYER_FK FOREIGN KEY (EMPLOYER_ID)
        REFERENCES EMPLOYER (ID)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
CREATE SEQUENCE CONTACT_ID_SEQUENCE START WITH 1 INCREMENT BY 1000;

CREATE TABLE COMPETENCE
(
    ID BIGINT NOT NULL,
    IS_ACTIVE BOOLEAN NOT NULL,
    CREATED_DATE DATE NOT NULL,
    IS_DELETED BOOLEAN NOT NULL,
    DELETED_DATE DATE,
    EXPERIENCE BIGINT NOT NULL,
    TECHNOLOGY VARCHAR(255),
    TYPE INTEGER NOT NULL,
    UPDATED_DATE DATE,
    UUID VARCHAR(255) NOT NULL,
    EMPLOYER_ID BIGINT NOT NULL,
    CONSTRAINT COMPETENCE_PK PRIMARY KEY (ID),
    CONSTRAINT COMPETENCE_EMPLOYER_FK FOREIGN KEY (EMPLOYER_ID)
        REFERENCES EMPLOYER (ID)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
CREATE SEQUENCE COMPETENCE_ID_SEQUENCE START WITH 1 INCREMENT BY 1000;

CREATE TABLE AWARD
(
    ID BIGINT NOT NULL,
    CREATED_DATE DATE NOT NULL,
    IS_DELETED BOOLEAN NOT NULL,
    DELETED_DATE DATE,
    DESCRIPTION VARCHAR(255),
    REASON VARCHAR(255),
    RECEIPT_DATE DATE,
    TITLE VARCHAR(255) NOT NULL,
    UPDATED_DATE DATE,
    UUID VARCHAR(255) NOT NULL,
    EMPLOYER_ID BIGINT NOT NULL,
    CONSTRAINT AWARD_PK PRIMARY KEY (ID),
    CONSTRAINT AWARD_EMPLOYER_FK FOREIGN KEY (EMPLOYER_ID)
        REFERENCES EMPLOYER (ID)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
CREATE SEQUENCE AWARD_ID_SEQUENCE START WITH 1 INCREMENT BY 1000;

CREATE TABLE ADDRESS
(
    ID BIGINT NOT NULL,
    ADDRESS VARCHAR(255) NOT NULL,
    COUNTRY VARCHAR(255) NOT NULL,
    CREATED_DATE DATE NOT NULL,
    IS_DELETED BOOLEAN NOT NULL,
    DELETED_DATE DATE,
    UPDATED_DATE DATE,
    UUID VARCHAR(255) NOT NULL,
    EMPLOYER_ID BIGINT NOT NULL,
    CONSTRAINT ADDRESS_PK PRIMARY KEY (ID),
    CONSTRAINT ADDRESS_EMPLOYER_FK FOREIGN KEY (EMPLOYER_ID)
        REFERENCES EMPLOYER (ID)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
CREATE SEQUENCE ADDRESS_ID_SEQUENCE START WITH 1 INCREMENT BY 1000;

CREATE TABLE TRAINING
(
    ID BIGINT NOT NULL,
    CREATED_DATE DATE NOT NULL,
    CURRENCY_TYPE INTEGER NOT NULL,
    IS_DELETED BOOLEAN NOT NULL,
    DELETED_DATE DATE,
    DESCRIPTION VARCHAR(255),
    END_DATE DATE NOT NULL,
    PRICE BIGINT NOT NULL,
    START_DATE DATE NOT NULL,
    TITLE VARCHAR(255) NOT NULL,
    UPDATED_DATE DATE,
    UUID VARCHAR(255) NOT NULL,
    EMPLOYER_ID BIGINT NOT NULL,
    CONSTRAINT TRAINING_PK PRIMARY KEY (ID),
    CONSTRAINT TRAINING_EMPLOYER_FK FOREIGN KEY (EMPLOYER_ID)
        REFERENCES EMPLOYER (ID)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
CREATE SEQUENCE TRAINING_ID_SEQUENCE START WITH 1 INCREMENT BY 1000;