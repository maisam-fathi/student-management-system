use Schulmanagmentsystem;
/*create table course(
courseID int auto_increment primary key,
course_Name varchar(30) not null,
studentID int,
foreign key(studentID) references student(studentID) on delete cascade on update cascade
);*/

/*INSERT INTO course (course_Name) VALUES
('Mathematik'),
('Deutsch'),
('Englisch'),
('Geschichte'),
('Biologie'),
('Chemie'),
('Physik'),
('Informatik'),
('Kunst'),
('Musik');*/

/*-- Mathematik
INSERT INTO course (course_Name, studentID) VALUES
('Mathematik', 1), ('Mathematik', 11), ('Mathematik', 21), ('Mathematik', 31), ('Mathematik', 41),('Mathematik', 51), ('Mathematik', 61), ('Mathematik', 71), ('Mathematik', 81), ('Mathematik', 91),
-- Deutsch
('Deutsch', 2), ('Deutsch', 12), ('Deutsch', 22), ('Deutsch', 32), ('Deutsch', 42),('Deutsch', 52), ('Deutsch', 62), ('Deutsch', 72), ('Deutsch', 82), ('Deutsch', 92),
-- Englisch
('Englisch', 3), ('Englisch', 13), ('Englisch', 23), ('Englisch', 33), ('Englisch', 43),('Englisch', 53), ('Englisch', 63), ('Englisch', 73), ('Englisch', 83), ('Englisch', 93),
-- Geschichte
('Geschichte', 4), ('Geschichte', 14), ('Geschichte', 24), ('Geschichte', 34), ('Geschichte', 44),('Geschichte', 54), ('Geschichte', 64), ('Geschichte', 74), ('Geschichte', 84), ('Geschichte', 94),
-- Biologie
('Biologie', 5), ('Biologie', 15), ('Biologie', 25), ('Biologie', 35), ('Biologie', 45),('Biologie', 55), ('Biologie', 65), ('Biologie', 75), ('Biologie', 85), ('Biologie', 95),
-- Chemie
('Chemie', 6), ('Chemie', 16), ('Chemie', 26), ('Chemie', 36), ('Chemie', 46),('Chemie', 56), ('Chemie', 66), ('Chemie', 76), ('Chemie', 86), ('Chemie', 96),
-- Physik
('Physik', 7), ('Physik', 17), ('Physik', 27), ('Physik', 37), ('Physik', 47),('Physik', 57), ('Physik', 67), ('Physik', 77), ('Physik', 87), ('Physik', 97),
-- Informatik
('Informatik', 8), ('Informatik', 18), ('Informatik', 28), ('Informatik', 38), ('Informatik', 48),('Informatik', 58), ('Informatik', 68), ('Informatik', 78), ('Informatik', 88), ('Informatik', 98),
-- Sport
('Sport', 9), ('Sport', 19), ('Sport', 29), ('Sport', 39), ('Sport', 49),('Sport', 59), ('Sport', 69), ('Sport', 79), ('Sport', 89), ('Sport', 99),
-- Musik
('Musik', 10), ('Musik', 20), ('Musik', 30), ('Musik', 40), ('Musik', 50),('Musik', 60), ('Musik', 70), ('Musik', 80), ('Musik', 90);*/
select*from student;
select * from course;