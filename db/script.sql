create table students(id serial primary key, firstname varchar(255), lastname varchar(255),
	facultyname varchar(255), facultybudget bool,
	age int
);
insert into students(firstname, lastname, facultyname, facultybudget, age)
    values('Ivan', 'Petrov', 'Mathematics', true, 22);
update students set firstname = 'John';
delete from students where firstname = 'John';
