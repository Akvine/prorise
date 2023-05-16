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

INSERT INTO EMPLOYER (ID, UUID, FIRST_NAME, SECOND_NAME, EMPLOYMENT_DATE, EMPLOYER_TYPE, TEAM_ID, CREATED_DATE, IS_DELETED) VALUES (1, 'employer_uuid_1', 'employer_first_name_1', 'employer_second_name_1', '2023-03-19', 'WORKER', 1, '2023-03-19', 0);
INSERT INTO EMPLOYER (ID, UUID, FIRST_NAME, SECOND_NAME, EMPLOYMENT_DATE, EMPLOYER_TYPE, TEAM_ID, CREATED_DATE, IS_DELETED) VALUES (2, 'employer_uuid_2', 'employer_first_name_2', 'employer_second_name_2', '2023-03-19', 'WORKER', 1, '2023-03-19', 0);
INSERT INTO EMPLOYER (ID, UUID, FIRST_NAME, SECOND_NAME, EMPLOYMENT_DATE, EMPLOYER_TYPE, TEAM_ID, CREATED_DATE, IS_DELETED) VALUES (3, 'employer_uuid_3', 'employer_first_name_3', 'employer_second_name_3', '2023-03-19', 'WORKER', 1, '2023-03-19', 0);

INSERT INTO TASK (ID, UUID, TITLE, DESCRIPTION, START_DATE, PRIORITY_TYPE, EMPLOYER_ID, GOAL_ID, STATUS, IS_DONE, CREATED_DATE, IS_DELETED) VALUES (1, 'task_uuid_1', 'task_title_1', 'task_description_1', '2023-03-19 00:00:00', 'MEDIUM', 1, 1, 'IN_PROGRESS', 0, '2023-03-19', 0);
INSERT INTO TASK (ID, UUID, TITLE, DESCRIPTION, START_DATE, PRIORITY_TYPE, EMPLOYER_ID, GOAL_ID, STATUS, IS_DONE, CREATED_DATE, IS_DELETED) VALUES (2, 'task_uuid_2', 'task_title_2', 'task_description_2', '2023-03-19 00:00:00', 'MEDIUM', 1, 1, 'IN_PROGRESS', 0, '2023-03-19', 0);
INSERT INTO TASK (ID, UUID, TITLE, DESCRIPTION, START_DATE, PRIORITY_TYPE, EMPLOYER_ID, GOAL_ID, STATUS, IS_DONE, CREATED_DATE, IS_DELETED) VALUES (3, 'task_uuid_3', 'task_title_3', 'task_description_3', '2023-03-19 00:00:00', 'MEDIUM', 1, 1, 'IN_PROGRESS', 0, '2023-03-19', 0);

INSERT INTO DEPARTMENT (ID, CREATED_DATE, IS_DELETED, DELETED_DATE, DESCRIPTION, TITLE, UPDATED_DATE, UUID, DEPARTMENT_TYPE_ID)
VALUES
(5, '2023-01-01', 0, null, 'department_description_5', 'department_title_5', NULL, 'department_uuid_5', 1),
(6, '2023-01-02', 0, null, 'department_description_6', 'department_title_6', NULL, 'department_uuid_6', 2),
(7, '2023-01-03', 0, null, 'department_description_7', 'department_title_7', NULL, 'department_uuid_7', 1),
(8, '2023-01-04', 0, null, 'department_description_8', 'department_title_8', NULL, 'department_uuid_8', 2),
(9, '2023-01-05', 0, null, 'department_description_9', 'department_title_9', NULL, 'department_uuid_9', 1),
(10, '2023-01-06', 0, null, 'department_description_10', 'department_title_10', NULL, 'department_uuid_10', 2),
(11, '2023-01-07', 0, null, 'department_description_11', 'department_title_11', NULL, 'department_uuid_11', 1),
(12, '2023-01-08', 0, null, 'department_description_12', 'department_title_12', NULL, 'department_uuid_12', 2),
(13, '2023-01-09', 0, null, 'department_description_13', 'department_title_13', NULL, 'department_uuid_13', 1),
(14, '2023-01-10', 0, null, 'department_description_14', 'department_title_14', NULL, 'department_uuid_14', 2),
(15, '2023-01-11', 0, null, 'department_description_15', 'department_title_15', NULL, 'department_uuid_15', 1),
(16, '2023-01-12', 0, null, 'department_description_16', 'department_title_16', NULL, 'department_uuid_16', 2),
(17, '2023-01-13', 0, null, 'department_description_17', 'department_title_17', NULL, 'department_uuid_17', 1),
(18, '2023-01-14', 0, null, 'department_description_18', 'department_title_18', NULL, 'department_uuid_18', 2),
(19, '2023-01-15', 0, null, 'department_description_19', 'department_title_19', NULL, 'department_uuid_19', 1),
(20, '2023-01-16', 0, null, 'department_description_20', 'department_title_20', NULL, 'department_uuid_20', 2),
(21, '2023-01-17', 0, null, 'department_description_21', 'department_title_21', NULL, 'department_uuid_21', 1),
(22, '2023-01-18', 0, null, 'department_description_22', 'department_title_22', NULL, 'department_uuid_22', 2),
(23, '2023-01-19', 0, null, 'department_description_23', 'department_title_23', NULL, 'department_uuid_23', 1),
(24, '2023-01-20', 0, null, 'department_description_24', 'department_title_24', NULL, 'department_uuid_24', 2);

INSERT INTO TEAM (ID, CREATED_DATE, IS_DELETED, DELETED_DATE, DESCRIPTION, TITLE, UPDATED_DATE, UUID, DEPARTMENT_ID)
VALUES
(5, '2023-01-01', 0, NULL, 'Description 1', 'Title 1', NULL, 'uuid1', 1),
(6, '2023-01-02', 0, NULL, 'Description 2', 'Title 2', NULL, 'uuid2', 1),
(7, '2023-01-03', 0, NULL, 'Description 3', 'Title 3', NULL, 'uuid3', 2),
(8, '2023-01-04', 0, NULL, 'Description 4', 'Title 4', NULL, 'uuid4', 2),
(9, '2023-01-05', 0, NULL, 'Description 5', 'Title 5', NULL, 'uuid5', 3),
(10, '2023-01-06', 0, NULL, 'Description 6', 'Title 6', NULL, 'uuid6', 3),
(11, '2023-01-07', 0, NULL, 'Description 7', 'Title 7', NULL, 'uuid7', 4),
(12, '2023-01-08', 0, NULL, 'Description 8', 'Title 8', NULL, 'uuid8', 4),
(13, '2023-01-09', 0, NULL, 'Description 9', 'Title 9', NULL, 'uuid9', 5),
(14, '2023-01-10', 0, NULL, 'Description 10', 'Title 10', NULL, 'uuid10', 5),
(15, '2023-01-11', 0, NULL, 'Description 11', 'Title 11', NULL, 'uuid11', 6),
(16, '2023-01-12', 0, NULL, 'Description 12', 'Title 12', NULL, 'uuid12', 6),
(17, '2023-01-13', 0, NULL, 'Description 13', 'Title 13', NULL, 'uuid13', 7),
(18, '2023-01-14', 0, NULL, 'Description 14', 'Title 14', NULL, 'uuid14', 7),
(19, '2023-01-15', 0, NULL, 'Description 15', 'Title 15', NULL, 'uuid15', 8),
(20, '2023-01-16', 0, NULL, 'Description 16', 'Title 16', NULL, 'uuid16', 8),
(21, '2023-01-17', 0, NULL, 'Description 17', 'Title 17', NULL, 'uuid17', 9),
(22, '2023-01-18', 0, NULL, 'Description 18', 'Title 18', NULL, 'uuid18', 9),
(23, '2023-01-19', 0, NULL, 'Description 19', 'Title 19', NULL, 'uuid19', 10),
(24, '2023-01-20', 0, NULL, 'Description 20', 'Title 20', NULL, 'uuid20', 10),
(25, '2023-01-21', 0, NULL, 'Description 21', 'Title 21', NULL, 'uuid21', 11),
(26, '2023-01-22', 0, NULL, 'Description 22', 'Title 22', NULL, 'uuid22', 11),
(27, '2023-01-23', 0, NULL, 'Description 23', 'Title 23', NULL, 'uuid23', 12),
(28, '2023-01-24', 0, NULL, 'Description 24', 'Title 24', NULL, 'uuid24', 12),
(29, '2023-01-25', 0, NULL, 'Description 25', 'Title 25', NULL, 'uuid25', 13),
(30, '2023-01-26', 0, NULL, 'Description 26', 'Title 26', NULL, 'uuid26', 13),
(31, '2023-01-27', 0, NULL, 'Description 27', 'Title 27', NULL, 'uuid27', 14),
(32, '2023-01-28', 0, NULL, 'Description 28', 'Title 28', NULL, 'uuid28', 14),
(33, '2023-01-29', 0, NULL, 'Description 29', 'Title 29', NULL, 'uuid29', 15),
(34, '2023-01-30', 0, NULL, 'Description 30', 'Title 30', NULL, 'uuid30', 15),
(35, '2023-01-31', 0, NULL, 'Description 31', 'Title 31', NULL, 'uuid31', 16),
(36, '2023-02-01', 0, NULL, 'Description 32', 'Title 32', NULL, 'uuid32', 16),
(37, '2023-02-02', 0, NULL, 'Description 33', 'Title 33', NULL, 'uuid33', 17),
(38, '2023-02-03', 0, NULL, 'Description 34', 'Title 34', NULL, 'uuid34', 17),
(39, '2023-02-04', 0, NULL, 'Description 35', 'Title 35', NULL, 'uuid35', 18),
(40, '2023-02-05', 0, NULL, 'Description 36', 'Title 36', NULL, 'uuid36', 18),
(41, '2023-02-06', 0, NULL, 'Description 37', 'Title 37', NULL, 'uuid37', 19),
(42, '2023-02-07', 0, NULL, 'Description 38', 'Title 38', NULL, 'uuid38', 19),
(43, '2023-02-08', 0, NULL, 'Description 39', 'Title 39', NULL, 'uuid39', 20),
(44, '2023-02-09', 0, NULL, 'Description 40', 'Title 40', NULL, 'uuid40', 20),
(45, '2023-02-10', 0, NULL, 'Description 41', 'Title 41', NULL, 'uuid41', 21),
(46, '2023-02-11', 0, NULL, 'Description 42', 'Title 42', NULL, 'uuid42', 21),
(47, '2023-02-12', 0, NULL, 'Description 43', 'Title 43', NULL, 'uuid43', 22),
(48, '2023-02-13', 0, NULL, 'Description 44', 'Title 44', NULL, 'uuid44', 22),
(49, '2023-02-14', 0, NULL, 'Description 45', 'Title 45', NULL, 'uuid45', 23),
(50, '2023-02-15', 0, NULL, 'Description 46', 'Title 46', NULL, 'uuid46', 23),
(51, '2023-02-16', 0, NULL, 'Description 47', 'Title 47', NULL, 'uuid47', 24),
(52, '2023-02-17', 0, NULL, 'Description 48', 'Title 48', NULL, 'uuid48', 24),
(53, '2023-02-18', 0, NULL, 'Description 49', 'Title 49', NULL, 'uuid49', 24),
(54, '2023-02-19', 0, NULL, 'Description 50', 'Title 50', NULL, 'uuid50', 24);

INSERT INTO PROJECT (ID, CREATED_DATE, IS_DELETED, DELETED_DATE, DESCRIPTION, IS_DONE, END_DATE, START_DATE, TITLE, PROJECT_TYPE, UPDATED_DATE, UUID, TEAM_ID)
VALUES
(4, '2023-01-01', 0, NULL, 'Description 1', 1, '2023-01-10', '2023-01-01', 'Title 1', 'TECHNICAL', NULL, 'uuid1', 1),
(5, '2023-01-02', 0, NULL, 'Description 2', 0, '2023-01-15', '2023-01-03', 'Title 2', 'STRATEGY', NULL, 'uuid2', 1),
(6, '2023-01-03', 0, NULL, 'Description 3', 1, '2023-01-20', '2023-01-05', 'Title 3', 'TECHNICAL', NULL, 'uuid3', 2),
(7, '2023-01-04', 0, NULL, 'Description 4', 0, '2023-01-25', '2023-01-07', 'Title 4', 'STRATEGY', NULL, 'uuid4', 2),
(8, '2023-01-05', 0, NULL, 'Description 5', 1, '2023-01-30', '2023-01-09', 'Title 5', 'TECHNICAL', NULL, 'uuid5', 3),
(9, '2023-01-06', 0, NULL, 'Description 6', 0, '2023-02-05', '2023-01-11', 'Title 6', 'STRATEGY', NULL, 'uuid6', 3),
(10, '2023-01-07', 0, NULL, 'Description 7', 1, '2023-02-10', '2023-01-13', 'Title 7', 'TECHNICAL', NULL, 'uuid7', 4),
(11, '2023-01-08', 0, NULL, 'Description 8', 0, '2023-02-15', '2023-01-15', 'Title 8', 'STRATEGY', NULL, 'uuid8', 4),
(12, '2023-01-09', 0, NULL, 'Description 9', 1, '2023-02-20', '2023-01-17', 'Title 9', 'TECHNICAL', NULL, 'uuid9', 5),
(13, '2023-01-10', 0, NULL, 'Description 10', 0, '2023-02-25', '2023-01-19', 'Title 10', 'STRATEGY', NULL, 'uuid10', 5),
(14, '2023-01-11', 0, NULL, 'Description 11', 1, '2023-03-01', '2023-01-21', 'Title 11', 'TECHNICAL', NULL, 'uuid11', 6),
(15, '2023-01-12', 0, NULL, 'Description 12', 0, '2023-03-05', '2023-01-23', 'Title 12', 'STRATEGY', NULL, 'uuid12', 6),
(16, '2023-01-13', 0, NULL, 'Description 13', 1, '2023-03-10', '2023-01-25', 'Title 13', 'TECHNICAL', NULL, 'uuid13', 7),
(17, '2023-01-14', 0, NULL, 'Description 14', 0, '2023-03-15', '2023-01-27', 'Title 14', 'STRATEGY', NULL, 'uuid14', 7),
(18, '2023-01-15', 0, NULL, 'Description 15', 1, '2023-03-20', '2023-01-29', 'Title 15', 'TECHNICAL', NULL, 'uuid15', 8),
(19, '2023-01-16', 0, NULL, 'Description 16', 0, '2023-03-25', '2023-01-31', 'Title 16', 'STRATEGY', NULL, 'uuid16', 8);

INSERT INTO GOAL (ID, CREATED_DATE, IS_DELETED, DELETED_DATE, DESCRIPTION, IS_DONE, TITLE, UPDATED_DATE, UUID, PROJECT_ID)
VALUES
(4, '2023-01-01', 0, NULL, 'Goal Description 1', 1, 'Goal Title 1', NULL, 'goal-uuid1', 4),
(5, '2023-01-02', 0, NULL, 'Goal Description 2', 0, 'Goal Title 2', NULL, 'goal-uuid2', 4),
(6, '2023-01-03', 0, NULL, 'Goal Description 3', 1, 'Goal Title 3', NULL, 'goal-uuid3', 4),
(7, '2023-01-04', 0, NULL, 'Goal Description 4', 1, 'Goal Title 4', NULL, 'goal-uuid4', 5),
(8, '2023-01-05', 0, NULL, 'Goal Description 5', 0, 'Goal Title 5', NULL, 'goal-uuid5', 5),
(9, '2023-01-06', 0, NULL, 'Goal Description 6', 1, 'Goal Title 6', NULL, 'goal-uuid6', 5),
(10, '2023-01-07', 0, NULL, 'Goal Description 7', 1, 'Goal Title 7', NULL, 'goal-uuid7', 6),
(11, '2023-01-08', 0, NULL, 'Goal Description 8', 0, 'Goal Title 8', NULL, 'goal-uuid8', 6),
(12, '2023-01-09', 0, NULL, 'Goal Description 9', 1, 'Goal Title 9', NULL, 'goal-uuid9', 6),
(13, '2023-01-10', 0, NULL, 'Goal Description 10', 1, 'Goal Title 10', NULL, 'goal-uuid10', 7),
(14, '2023-01-11', 0, NULL, 'Goal Description 11', 0, 'Goal Title 11', NULL, 'goal-uuid11', 7),
(15, '2023-01-12', 0, NULL, 'Goal Description 12', 1, 'Goal Title 12', NULL, 'goal-uuid12', 7),
(16, '2023-01-13', 0, NULL, 'Goal Description 13', 1, 'Goal Title 13', NULL, 'goal-uuid13', 8),
(17, '2023-01-14', 0, NULL, 'Goal Description 14', 0, 'Goal Title 14', NULL, 'goal-uuid14', 8),
(18, '2023-01-15', 0, NULL, 'Goal Description 15', 1, 'Goal Title 15', NULL, 'goal-uuid15', 8),
(19, '2023-01-16', 0, NULL, 'Goal Description 16', 1, 'Goal Title 16', NULL, 'goal-uuid16', 9),
(20, '2023-01-17', 0, NULL, 'Goal Description 17', 0, 'Goal Title 17', NULL, 'goal-uuid17', 9),
(21, '2023-01-18', 0, NULL, 'Goal Description 18', 1, 'Goal Title 18', NULL, 'goal-uuid18', 9),
(22, '2023-01-19', 0, NULL, 'Goal Description 19', 1, 'Goal Title 19', NULL, 'goal-uuid19', 9),
(23, '2023-01-20', 0, NULL, 'Goal Description 20', 0, 'Goal Title 20', NULL, 'goal-uuid20', 10),
(24, '2023-01-21', 0, NULL, 'Goal Description 21', 1, 'Goal Title 21', NULL, 'goal-uuid21', 10),
(25, '2023-01-22', 0, NULL, 'Goal Description 22', 1, 'Goal Title 22', NULL, 'goal-uuid22', 10),
(26, '2023-01-23', 0, NULL, 'Goal Description 23', 0, 'Goal Title 23', NULL, 'goal-uuid23', 11),
(27, '2023-01-24', 0, NULL, 'Goal Description 24', 1, 'Goal Title 24', NULL, 'goal-uuid24', 11),
(28, '2023-01-25', 0, NULL, 'Goal Description 25', 1, 'Goal Title 25', NULL, 'goal-uuid25', 11),
(29, '2023-01-26', 0, NULL, 'Goal Description 26', 0, 'Goal Title 26', NULL, 'goal-uuid26', 12),
(30, '2023-01-27', 0, NULL, 'Goal Description 27', 1, 'Goal Title 27', NULL, 'goal-uuid27', 12);