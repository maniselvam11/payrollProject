----------user table----------------
create table 
admin_details
(email_id varchar2(40) ,
password varchar2(20) not null);

insert into admin_details values('maniselvam11@gmail.com','Maniselvam11@');
commit;

-------------employees table---------------
create table employees
(emp_id int GENERATED ALWAYS AS IDENTITY START WITH 1 ,
emp_name varchar2(30) not null,
emp_dob date not null,
emp_doj date not null,
emp_address varchar2(40) not null,
emp_city varchar2(20) not null,
emp_pincode int ,
emp_mobile_no int not null,
emp_state varchar2(20),
emp_email_id varchar2(40) not null,
emp_pan_no varchar2(30) not null,
dept_id number,
constraint pk_empid primary key(emp_id),
constraint fk_dept_id foreign key (dept_id)references departments (dept_id));



--------department table--------------
create table 
departments
(dept_id int,
dept_name varchar2(30) not null,
grade_id number ,
CONSTRAINT pk_deptid PRIMARY KEY (dept_id),
constraint fk_grade_id foreign key (grade_id) references grades (grade_id));

-------------grade table---------
create table 
grades 
(grade_id int GENERATED ALWAYS AS IDENTITY START WITH 1201 increment by 1  ,
grade_name varchar2(30) not null,
grade_basic int not null,
grade_bonus int not null,
grade_pf int not null,
grade_pt int not null,
constraint pk_gradeid primary key (grade_id));

insert into  grades(grade_name,grade_basic,grade_bonus,grade_pf,grade_pt) values('Trainee',15000,1500,1000,1700);
select * from grades;

----------------salary table------------------
create table salarys 
(trans_id int GENERATED ALWAYS AS IDENTITY START WITH 1,
emp_id int,
dept_id int ,
leave_id int ,
grade_id int ,
paid_date date,
gross_salary int,
total_salary int,
constraint pk_transid primary key (trans_id),
constraint fk_empid foreign key (emp_id) references employees (emp_id),
constraint fk_gradeid foreign key (grade_id) references grades (grade_id),
constraint fk_deptid foreign key (dept_id) references departments (dept_id));
desc salarys;

---------------------------------------------leave Details---------------------------------------------------------
create table leave_details (leave_id int GENERATED ALWAYS AS IDENTITY START WITH 1,
emp_id int,
 leave_date date,
 reason varchar2(40),
 
constraint pk_leave_id primary key(leave_id),
constraint fk_emp_id foreign key (emp_id) references employees(emp_id)
 );


desc departments;
insert into departments values(11,'oracle',1202);
insert into departments values(14,'service',1206);
insert into departments values(15,'product',1203);

select * from departments;
insert into departments values(2,'product',1201);

select * from admin_details;
select * from departments;
delete from departments where dept_id=11;

select * from grades; 
-----------perday salary--------------
select grade_name,(grade_basic /(30 - (select count(leave_id),emp_id from leave_details where emp_id=2 group by emp_id ))) perday from grades;
select grade_basic,grade_name from grades;
(30-(select count(leave_id),emp_id from leave_details group by emp_id));
select (grade_basic/30)perDaySalary from grades where grade_name='Technical Lead';
/
with
function leave_details(emp_id in number) return number is
begin

/

with leave_days as
(select count(leave_id),emp_id from leave_details group by emp_id)
select g.grade_name,(g.grade_basic /(30 - l.leave_days)) perday from grades g join leave_days l;


/
select grade_basic from grades;

select * from employees;
desc employees;
select * from salarys;  
desc salarys;
select * from leave_details;
desc leave_details;
select * from employees where dept_id=1;


select grade_id,grade_name,grade_basic,grade_bonus,grade_pf,grade_pt,(grade_basic + grade_bonus 
+ grade_pt + grade_pf)gross,(grade_basic+grade_bonus)total 
from grades;

------------basic + bonus---------
select(grade_basic+grade_bonus)total 
from grades;
-----------basic--------
select grade_basic from grades;
insert into leave_details (emp_id,leave_date,reason) values(2,'11-03-2020','dengu');

select count(leave_id),emp_id from leave_details group by emp_id;


desc employees;
delete from employees where emp_email_id='fghj@gmail.com';

select e.emp_id,d.dept_id,g.grade_id,l.leave_id from leave_details l join employees e
on l.emp_id=e.emp_id join departments d on e.dept_id=d.dept_id join grades g
on d.grade_id=g.grade_id;


ALTER TABLE departments DISABLE CONSTRAINT pk_deptid;

select * from grades;
select * from departments;
desc employees;
select * from employees where emp_email_id='sweety@gmail.com';
select * from leave_details  where leave_date='23-06-2020'and emp_id=5;

update employees set emp_address='gokaya' where emp_id=5;

commit;
select * from leave_details;
select * from salarys;
