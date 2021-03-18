drop database dbaccess_courses_db;
drop user dbaccessadmin;

create user dbaccessadmin with password '12345678';
create database dbaccess_courses_db with owner=dbaccessadmin;

\connect dbaccess_courses_db;

alter default privileges grant all on tables to dbaccessadmin;
alter default privileges grant all on sequences to dbaccessadmin;

create sequence instructor_id_seq increment 1 start 1;

create table instructor (
    instructor_id integer primary key not null unique default nextval('instructor_id_seq'),
    name varchar(120) not null ,
    identification varchar(10) not null
);

create sequence course_id_seq increment 1 start 1;

create table course (
  course_id integer primary key not null unique default nextval('course_id_seq'),
  name varchar(150) not null,
  description varchar(500)
);

create sequence school_year_id_seq increment 1 start 1;

create table school_year (
    school_year_id integer default nextval('school_year_id_seq'),
    course_id integer,
    instructor_id integer,
    year integer,
    PRIMARY KEY (course_id, instructor_id, year)
);

alter table school_year add constraint course_fk
    foreign key (course_id) references course(course_id);

alter table school_year add constraint instructor_fk
    foreign key (instructor_id) references instructor(instructor_id);