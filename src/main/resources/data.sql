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


insert into module (mdl_id, mdl_maxstd, mdl_name, mdl_topic, stf_id) values
(1, 25, 'Major Pharmaceuticals', 'Health Care', 11),
(2, 42, 'Farming/Seeds/Milling', 'Consumer Non-Durables', 9),
(3, 26, 'Military/Government/Technical', 'Consumer Services', 6),
(4, 18, 'Apparel', 'Consumer Non-Durables', 3),
(5, 21, 'Real Estate Investment Trusts', 'Consumer Services', 11),
(6, 38, 'Medical Specialities', 'Health Care', 5),
(7, 43, 'Other Consumer Services', 'Consumer Services', 3),
(8, 49, 'Property-Casualty Insurers', 'Finance', 10),
(9, 16, 'EDP Services', 'Technology', 2),
(10, 45, 'Ordnance And Accessories', 'Capital Goods', 10),
(11, 20, 'Publishing', 'Consumer Durables', 5),
(12, 31, 'Services-Misc. Amusement & Recreation', 'Consumer Services', 5),
(13, 16, 'Automotive Aftermarket', 'Consumer Durables', 8),
(14, 28, 'Fluid Controls', 'Capital Goods', 11),
(15, 27, 'Natural Gas Distribution', 'Energy', 5),
(16, 47, 'Homebuilding', 'Capital Goods', 3),
(17, 29, 'Meat/Poultry/Fish', 'Consumer Non-Durables', 10),
(18, 33, 'Computer Software: Prepackaged Software', 'Technology', 7),
(19, 18, 'Agricultural Chemicals', 'Basic Industries', 9),
(20, 47, 'Oil & Gas Production', 'Energy', 10),
(21, 49, 'Telecommunications Equipment', 'Consumer Non-Durables', 11);

INSERT INTO student (std_username, std_id, std_address, std_email, std_name, std_password , std_sex, std_surname)
VALUES
    ('temp', 1, 'addr', 'temp@example.com', 'Joe', 'pass', 1, 'D');