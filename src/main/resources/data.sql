DELETE FROM module;
DELETE FROM staff;
DELETE FROM student;

INSERT INTO staff (stf_id, stf_username,stf_password,stf_name,stf_surname,stf_sex)
VALUES
    (1, 'test', 'pass', 'Test', 'User', 0),
    (2, 'SEstrada','IAN56NYE7OT','Sonya','Estrada',1),
    (3, 'CMcclure','WJX98AME2NB','Colin','Mcclure',0),
    (4, 'DNieves','KAW45WDS1NN','Dillon','Nieves',0),
    (5, 'ISosa','TRL69RRV4GV','India','Sosa',1),
    (6, 'CEllis','XKE30ULX5YT','Connor','Ellis',0),
    (7, 'PWatson','DYK21GYN8LN','Pascale','Watson',0),
    (8, 'MPruitt','SMT89XOH5TN','MacKensie','Pruitt',1),
    (9, 'ERogers','QVL96YJC4VW','Erin','Rogers',1),
    (10, 'XPalmer','DJB13JBQ5EA','Xyla','Palmer',1),
    (11, 'RHobbs','XOQ14HEO3CK','Reed','Hobbs',0);


INSERT INTO module (mdl_id, mdl_maxstd, mdl_name, mdl_topic, stf_id)
VALUES
    (1, 15, 'Temp Module', 'Science', 1);

INSERT INTO student (std_username, std_id, std_address, std_email, std_name, std_password , std_sex, std_surname)
VALUES
    ('temp', 1, 'addr', 'temp@example.com', 'Joe', 'pass', 1, 'D');