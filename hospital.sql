
INSERT INTO hospital.hospital(name,address)values("市一医院","广州越秀");
use hospital;
INSERT INTO hospital.hospital(name,address)values("省中医院","番禺");

insert into hospital.department(type,name,hospital_id) values("内科","1诊室",1);
insert into hospital.department(type,name,hospital_id) values("外科","2诊室",2);

insert into hospital.period(date,begin_time,end_time) values("2016-05-04","09:00:00","10:00:00");
insert into hospital.period(date,begin_time,end_time) values("2016-05-21","9:00:00","10:00:00");	
insert into hospital.period(date,begin_time,end_time) values("2016-05-21","10:00:00","11:00:00");	
insert into hospital.period(date,begin_time,end_time) values("2016-05-21","11:00:00","12:00:00");

insert into hospital.doctor(name,sex,age,department_id,tel,hospital_id)values("爽哥","男",20,1,"12345678901",1);
insert into hospital.doctor(name,sex,age,department_id,tel,hospital_id)values("子龙","男",21,2,"18811123456",2);

insert into hospital.schedule(doctor_id,period_id) values(1,1);
insert into hospital.schedule(doctor_id,period_id) values(1,2);	
insert into hospital.schedule(doctor_id,period_id) values(1,3);	

insert into hospital.user(user_name,user_pwd,user_realname,sex,address,tel,identification_id,birthday,balance)
values("胖子","12345678","严家勋","男","深圳","18812345567","440123456789098745","1995-01-01",10);



insert into hospital.registration(doctor_id,department_id,period_id,user_id,hospital_id,submitTime,state) values(1,1,1,1,1,"2016_05_22","已预约");

insert into hospital.registration(doctor_id,department_id,period_id,user_id,hospital_id,submitTime,state) values(1,1,1,124,1,"2016_05_22","已预约");

use hospital;
select r.id id,u.user_name userName ,p.begin_time beginTime ,do.name 
 from registration r join doctor do join department de join user u join period p 
 where  r.doctor_id=do.id and r.department_id = de.id and r.user_id=u.user_id and r.period_id=p.id  and 
  do.name="爽哥";
  
use hospital;
select
        r.id id,
        u.user_name userName ,
        p.begin_time beginTime 
    from
        registration r 
    join
        doctor do 
    join
        department de 
    join
        user u 
    join
        period p  
    where
        r.doctor_id=do.id 
        and r.department_id = de.id 
        and r.user_id=u.user_id 
        and r.period_id=p.id  
        and  do.name="爽哥" 
        and p.date="2016-05-04"
        and p.begin_time>="09:00:00" 
        and p.begin_time<="11:00:00";  
        
use hospital;
update registration set state="已预约" where user_id=1;     