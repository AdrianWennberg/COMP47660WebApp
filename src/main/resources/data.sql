DELETE FROM module;
DELETE FROM staff;
DELETE FROM student;

INSERT INTO staff (stf_id, stf_password, stf_name, stf_surname, stf_username, stf_sex)
VALUES
    (1, 'pass', 'temp', 'John', 'Dow', 0);

INSERT INTO module (mdl_id, mdl_maxstd, mdl_name, mdl_topic, stf_id)
VALUES
    (1, 15, 'Temp Module', 'Science', 1);

INSERT INTO student (std_username, std_id, std_address, std_email, std_name, std_password , std_sex, std_surname)
VALUES
    ('temp', 1, 'addr', 'temp@example.com', 'Joe', 'pass', 1, 'D');