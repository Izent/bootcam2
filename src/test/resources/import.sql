--STUDENTS
INSERT INTO students (first_name, gender, last_name, middle_name, date_of_birth, other_student_details)VALUES ('laura', 'F', 'laura', 'laura', '1990-05-05', 'oth');
INSERT INTO students (first_name, gender, last_name, middle_name, date_of_birth, other_student_details)VALUES ('joaquin', 'M', 'laura', 'laura', '1990-05-05', 'oth');
INSERT INTO students (first_name, gender, last_name, middle_name, date_of_birth, other_student_details)VALUES ('ricky', 'F', 'toso', 'laura', '1990-05-05', 'oth');
INSERT INTO students (first_name, gender, last_name, middle_name, date_of_birth, other_student_details)VALUES ('raul', 'M', 'raul', 'raul', '1990-05-05', 'oth');
-- SUBJECTS
INSERT INTO subject (subject_name)VALUES ('introd');
INSERT INTO subject (subject_name)VALUES ('ingles');
INSERT INTO subject (subject_name)VALUES ('recreo');
--TEACHERS
INSERT INTO teacher (first_name, gender, last_name, middle_name, other_teacher_details)VALUES ('laura', 'F', 'laura', 'laura', 'oth');
INSERT INTO teacher (first_name, gender, last_name, middle_name, other_teacher_details)VALUES ('no', 'F', 'sofia', 'sofia', 'oth');
INSERT INTO teacher (first_name, gender, last_name, middle_name, other_teacher_details)VALUES ('esta', 'F', 'rastha', 'laura', 'oth');
INSERT INTO teacher (first_name, gender, last_name, middle_name, other_teacher_details)VALUES ('se fue', 'F', 'laura', 'laura', 'oth');

-- CLASES
INSERT INTO classes (class_code, class_name, teacher_id, subject_id, date_form, date_to)VALUES (2, 'intro', 1, 1, '2019-05-05', '2019-05-05');
INSERT INTO classes (class_code, class_name, teacher_id, subject_id, date_form, date_to)VALUES (2, 'intro', 2, 2, '2019-05-05', '2019-05-05');
INSERT INTO classes (class_code, class_name, teacher_id, subject_id, date_form, date_to)VALUES (2, 'intro', 2, 1, '2019-05-05', '2019-05-05');
INSERT INTO classes (class_code, class_name, teacher_id, subject_id, date_form, date_to)VALUES (2, 'intro', 3, 1, '2019-05-05', '2019-05-05');

--STUDENTCLASSES
INSERT INTO student_classes (student_id, class_id, date_from, date_to)VALUES (1, 1, '2019-05-03', '2019-05-05');
INSERT INTO student_classes (student_id, class_id, date_from, date_to)VALUES (2, 2, '2019-06-04', '2019-05-05');
INSERT INTO student_classes (student_id, class_id, date_from, date_to)VALUES (2, 1, '2019-07-05', '2019-05-05');
INSERT INTO student_classes (student_id, class_id, date_from, date_to)VALUES (1, 1, '2019-08-06', '2019-05-05');

