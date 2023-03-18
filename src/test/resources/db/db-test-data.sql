INSERT INTO DEPARTMENT_TYPE (ID, UUID, DESCRIPTION, CODE, TYPE, CREATED_DATE, IS_DELETED) VALUES (1, 'department_type_uuid_1', 'department_type_description_1', 'department_type_code_1', 'IT', '2023-03-18', 0);
INSERT INTO DEPARTMENT_TYPE (ID, UUID, DESCRIPTION, CODE, TYPE, CREATED_DATE, IS_DELETED) VALUES (2, 'department_type_uuid_2', 'department_type_description_2', 'department_type_code_2', 'FINANCIAL', '2023-03-18', 0);
INSERT INTO DEPARTMENT_TYPE (ID, UUID, DESCRIPTION, CODE, TYPE, CREATED_DATE, IS_DELETED) VALUES (3, 'department_type_uuid_3', 'department_type_description_3', 'department_type_code_3', 'LOGISTIC', '2023-03-18', 0);
INSERT INTO DEPARTMENT_TYPE (ID, UUID, DESCRIPTION, CODE, TYPE, CREATED_DATE, IS_DELETED) VALUES (4, 'department_type_uuid_4', 'department_type_description_4', 'department_type_code_4', 'LEGAL', '2023-03-18', 0);
INSERT INTO DEPARTMENT_TYPE (ID, UUID, DESCRIPTION, CODE, TYPE, CREATED_DATE, IS_DELETED) VALUES (5, 'department_type_uuid_5', 'department_type_description_5', 'department_type_code_5', 'PURCHASING', '2023-03-18', 0);
INSERT INTO DEPARTMENT_TYPE (ID, UUID, DESCRIPTION, CODE, TYPE, CREATED_DATE, IS_DELETED) VALUES (6, 'department_type_uuid_6', 'department_type_description_6', 'department_type_code_6', 'PRODUCTION', '2023-03-18', 0);
INSERT INTO DEPARTMENT_TYPE (ID, UUID, DESCRIPTION, CODE, TYPE, CREATED_DATE, IS_DELETED) VALUES (7, 'department_type_uuid_7', 'department_type_description_7', 'department_type_code_7', 'SALES', '2023-03-18', 0);
INSERT INTO DEPARTMENT_TYPE (ID, UUID, DESCRIPTION, CODE, TYPE, CREATED_DATE, IS_DELETED) VALUES (8, 'department_type_uuid_8', 'department_type_description_8', 'department_type_code_8', 'MARKETING', '2023-03-18', 0);
INSERT INTO DEPARTMENT_TYPE (ID, UUID, DESCRIPTION, CODE, TYPE, CREATED_DATE, IS_DELETED) VALUES (9, 'department_type_uuid_9', 'department_type_description_9', 'department_type_code_8', 'HR', '2023-03-18', 0);

INSERT INTO DEPARTMENT (ID, UUID, TITLE, DEPARTMENT_TYPE_ID, DESCRIPTION, CREATED_DATE, IS_DELETED) VALUES (1, 'department_uuid_1', 'department_title_1', 1, 'department_description_1', '2023-03-18', 0);
INSERT INTO DEPARTMENT (ID, UUID, TITLE, DEPARTMENT_TYPE_ID, DESCRIPTION, CREATED_DATE, IS_DELETED) VALUES (2, 'department_uuid_2', 'department_title_2', 1, 'department_description_2', '2023-03-18', 0);
INSERT INTO DEPARTMENT (ID, UUID, TITLE, DEPARTMENT_TYPE_ID, DESCRIPTION, CREATED_DATE, IS_DELETED) VALUES (3, 'department_uuid_3', 'department_title_3', 1, 'department_description_3', '2023-03-18', 0);
INSERT INTO DEPARTMENT (ID, UUID, TITLE, DEPARTMENT_TYPE_ID, DESCRIPTION, CREATED_DATE, IS_DELETED) VALUES (4, 'department_uuid_4', 'department_title_4', 1, 'department_description_4', '2023-03-18', 0);

INSERT INTO TEAM (ID, UUID, TITLE, DEPARTMENT_ID, DESCRIPTION, CREATED_DATE, IS_DELETED) VALUES (1, 'team_uuid_1', 'team_title_1', 1, 'team_description_1', '2023-03-18', 0);
INSERT INTO TEAM (ID, UUID, TITLE, DEPARTMENT_ID, DESCRIPTION, CREATED_DATE, IS_DELETED) VALUES (2, 'team_uuid_2', 'team_title_2', 2, 'team_description_2', '2023-03-18', 0);
INSERT INTO TEAM (ID, UUID, TITLE, DEPARTMENT_ID, DESCRIPTION, CREATED_DATE, IS_DELETED) VALUES (3, 'team_uuid_3', 'team_title_3', 3, 'team_description_3', '2023-03-18', 0);
INSERT INTO TEAM (ID, UUID, TITLE, DEPARTMENT_ID, DESCRIPTION, CREATED_DATE, IS_DELETED) VALUES (4, 'team_uuid_4', 'team_title_4', 4, 'team_description_4', '2023-03-18', 0);

INSERT INTO PROJECT (ID, UUID, TITLE, START_DATE, DESCRIPTION, PROJECT_TYPE, TEAM_ID, IS_DONE, CREATED_DATE, IS_DELETED) VALUES (1, 'project_uuid_1', 'project_title_1', '2023-03-19', 'project_description_1', 'TECHNICAL', 1, 0, '2023-03-19', 0);
INSERT INTO PROJECT (ID, UUID, TITLE, START_DATE, DESCRIPTION, PROJECT_TYPE, TEAM_ID, IS_DONE, CREATED_DATE, IS_DELETED) VALUES (2, 'project_uuid_2', 'project_title_2', '2023-03-19', 'project_description_2', 'STRATEGY', 2, 0, '2023-03-19', 0);
INSERT INTO PROJECT (ID, UUID, TITLE, START_DATE, DESCRIPTION, PROJECT_TYPE, TEAM_ID, IS_DONE, CREATED_DATE, IS_DELETED) VALUES (3, 'project_uuid_3', 'project_title_3', '2023-03-19', 'project_description_3', 'ECONOMIC', 3, 0, '2023-03-19', 0);

INSERT INTO GOAL (ID, UUID, TITLE, DESCRIPTION, PROJECT_ID, IS_DONE, CREATED_DATE, IS_DELETED) VALUES (1, 'goal_uuid_1', 'goal_title_1', 'goal_description_1', 1, 0, '2023-03-19', 0);
INSERT INTO GOAL (ID, UUID, TITLE, DESCRIPTION, PROJECT_ID, IS_DONE, CREATED_DATE, IS_DELETED) VALUES (2, 'goal_uuid_2', 'goal_title_2', 'goal_description_2', 2, 0, '2023-03-19', 0);
INSERT INTO GOAL (ID, UUID, TITLE, DESCRIPTION, PROJECT_ID, IS_DONE, CREATED_DATE, IS_DELETED) VALUES (3, 'goal_uuid_3', 'goal_title_3', 'goal_description_3', 3, 0, '2023-03-19', 0);