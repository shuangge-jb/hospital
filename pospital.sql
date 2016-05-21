use hospital;
INSERT INTO hospital(name,address)values("市一医院","广州越秀");


insert into department(type,name,hospital_id) values("内科","1诊室",1);

insert into period(date,begin_time,end_time) values("2016-05-04","09:00:00","10:00:00");

insert into doctor(name,sex,age,department_id,tel,hospital_id)values("爽哥","男",20,1,"12345678901",1);

insert into schedule(doctor_id,period_id) values(1,1);

insert into period(date,begin_time,end_time) values("2016-05-21","10:00:00","11:00:00");	

insert into schedule(doctor_id,period_id) values(1,2);	