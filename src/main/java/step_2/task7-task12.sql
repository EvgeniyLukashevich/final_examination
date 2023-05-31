# TASK 7. В подключенном MySQL репозитории создать базу данных “Друзья человека”

DROP DATABASE IF EXISTS friends;
CREATE DATABASE friends;
USE friends;



# TASK 8. Создать таблицы с иерархией из диаграммы в БД

CREATE TABLE animals(
    type_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
    animal_type VARCHAR(20) NOT NULL
);

INSERT animals (animal_type) 
VALUES ('pets'), ('packs'); 

CREATE TABLE packs(
    type_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
    animal_type VARCHAR(20) NOT NULL
);

CREATE TABLE pets(
    type_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
    animal_type VARCHAR(20) NOT NULL
);

INSERT packs(animal_type) 
VALUES ('horses'), ('donkeys'), ('camels'); 

INSERT pets(animal_type) 
VALUES ('cats'), ('dogs'), ('hamsters'); 

CREATE TABLE cats(
    cat_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
    name VARCHAR(20) NOT NULL,
    birthday DATE NOT NULL,
    command VARCHAR(20) NOT NULL,
    subtype INT NOT NULL,
    animal_type INT NOT NULL
);

CREATE TABLE dogs(
    dog_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
    name VARCHAR(20) NOT NULL,
    birthday DATE NOT NULL,
    command VARCHAR(20) NOT NULL,
    subtype INT NOT NULL,
    animal_type INT NOT NULL
);

CREATE TABLE hamsters(
    hamster_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
    name VARCHAR(20) NOT NULL,
    birthday DATE NOT NULL,
    command VARCHAR(20) NOT NULL,
    subtype INT NOT NULL,
    animal_type INT NOT NULL
);

CREATE TABLE horses(
    horse_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
    name VARCHAR(20) NOT NULL,
    birthday DATE NOT NULL,
    command VARCHAR(20) NOT NULL,
    subtype INT NOT NULL,
    animal_type INT NOT NULL
);

CREATE TABLE donkeys(
    donkey_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
    name VARCHAR(20) NOT NULL,
    birthday DATE NOT NULL,
    command VARCHAR(20) NOT NULL,
    subtype INT NOT NULL,
    animal_type INT NOT NULL
);

CREATE TABLE camels(
    camel_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
    name VARCHAR(20) NOT NULL,
    birthday DATE NOT NULL,
    command VARCHAR(20) NOT NULL,
    subtype INT NOT NULL,
    animal_type INT NOT NULL
);



# TASK 9. Заполнить низкоуровневые таблицы именами(животных), 
# командами которые они выполняют и датами рождения

INSERT cats(name, birthday, command, subtype, animal_type) 
VALUES ('Venya', '2017-01-01', 'eat',
 (SELECT type_id FROM pets WHERE animal_type='cats'),
 (SELECT type_id FROM animals WHERE animal_type='pets')),
('Sonya','2021-03-11', 'run',
 (SELECT type_id FROM pets WHERE animal_type='cats'),
 (SELECT type_id FROM animals WHERE animal_type='pets'));

INSERT dogs(name, birthday, command, subtype, animal_type) 
VALUES ('Mike', '2016-05-22', 'relax',
 (SELECT type_id FROM pets WHERE animal_type='dogs'),
 (SELECT type_id FROM animals WHERE animal_type='pets')),
('Misty','2020-11-05', 'jump',
 (SELECT type_id FROM pets WHERE animal_type='dogs'),
 (SELECT type_id FROM animals WHERE animal_type='pets'));

INSERT hamsters(name, birthday, command, subtype, animal_type) 
VALUES ('Dale', '2023-01-14', 'fight',
 (SELECT type_id FROM pets WHERE animal_type='hamsters'),
 (SELECT type_id FROM animals WHERE animal_type='pets'));

INSERT donkeys(name, birthday, command, subtype, animal_type) 
VALUES ('Ear', '2015-12-20', 'galop',
(SELECT type_id FROM packs WHERE animal_type='donkeys'), 
(SELECT type_id FROM animals WHERE animal_type='packs')),
('Gray','2021-07-13', 'scream',
(SELECT type_id FROM packs WHERE animal_type='donkeys'), 
(SELECT type_id FROM animals WHERE animal_type='packs'));

INSERT horses(name, birthday, command, subtype, animal_type) 
VALUES ('Ford', '2018-04-15', 'smile',
(SELECT type_id FROM packs WHERE animal_type='horses'), 
(SELECT type_id FROM animals WHERE animal_type='packs')),
('Camry','2022-09-15', 'jump',
(SELECT type_id FROM packs WHERE animal_type='horses'), 
(SELECT type_id FROM animals WHERE animal_type='packs'));

INSERT camels(name, birthday, command, subtype, animal_type) 
VALUES ('Strong', '2015-10-14', 'smoke', 
(SELECT type_id FROM packs WHERE animal_type='camels'), 
(SELECT type_id FROM animals WHERE animal_type='packs')),
('Light','2017-03-01', 'smile', 
(SELECT type_id FROM packs WHERE animal_type='camels'), 
(SELECT type_id FROM animals WHERE animal_type='packs'));



# TASK 10. Удалив из таблицы верблюдов, т.к. 
# верблюдов решили перевезти в другой питомник на зимовку,
# объединить таблицы лошади, и ослы в одну таблицу.

DELETE FROM camels WHERE camel_id > 0;

CREATE TABLE horses_and_donkeys (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY)
SELECT name, birthday, command, subtype, animal_type
  FROM horses 
 UNION
SELECT name, birthday, command, subtype, animal_type
  FROM donkeys;
  

# TASK 11. В таблицу youngsters будут занесены животные с указанием возраста исчисляемого в месяцах

CREATE TABLE youngsters (name VARCHAR(50), age_in_months INT NOT NULL);

INSERT INTO youngsters (name, age_in_months)
SELECT name, TIMESTAMPDIFF(MONTH, birthday, NOW()) AS age_in_months
  FROM cats 
 WHERE birthday < DATE_SUB(NOW(), INTERVAL 1 YEAR)
   AND birthday > DATE_SUB(NOW(), INTERVAL 3 YEAR);
   
INSERT INTO youngsters (name, age_in_months)
SELECT name, TIMESTAMPDIFF(MONTH, birthday, NOW()) AS age_in_months
  FROM dogs 
 WHERE birthday < DATE_SUB(NOW(), INTERVAL 1 YEAR)
   AND birthday > DATE_SUB(NOW(), INTERVAL 3 YEAR);
   
INSERT INTO youngsters (name, age_in_months)
SELECT name, TIMESTAMPDIFF(MONTH, birthday, NOW()) AS age_in_months
  FROM hamsters 
 WHERE birthday < DATE_SUB(NOW(), INTERVAL 1 YEAR)
   AND birthday > DATE_SUB(NOW(), INTERVAL 3 YEAR);
   
INSERT INTO youngsters (name, age_in_months)
SELECT name, TIMESTAMPDIFF(MONTH, birthday, NOW()) AS age_in_months
  FROM horses_and_donkeys 
 WHERE birthday < DATE_SUB(NOW(), INTERVAL 1 YEAR)
   AND birthday > DATE_SUB(NOW(), INTERVAL 3 YEAR);




# TASK 12. Объединить все таблицы в одну, при этом сохраняя поля,
# указывающие на прошлую принадлежность к старым таблицам.

CREATE TABLE crew (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY)
SELECT name, birthday, command, subtype, animal_type
  FROM cats 
 UNION
SELECT name, birthday, command, subtype, animal_type
  FROM dogs 
 UNION
SELECT name, birthday, command, subtype, animal_type
  FROM hamsters 
 UNION
SELECT name, birthday, command, subtype, animal_type
  FROM horses 
 UNION
SELECT name, birthday, command, subtype, animal_type
  FROM donkeys;
  
