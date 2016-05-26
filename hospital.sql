
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

use hospital;
create table worktime(doctor_id int,period_id int,primary key(doctor_id,period_id),
foreign key(doctor_id)references doctor(id),foreign key(period_id)references period(id));

use hospital;
select doctor_id,period_id
from worktime w join period p on w.period_id=p.id
 where w.doctor_id=1 and p.date="2016-05-04" 
 and p.begin_time>="09:00:00" and p.end_time<="11:00:00";
 
 use hospital;
 delete from hospital.worktime where doctor_id>0;
 
 use hospital;
 insert into hospital(name,address) values("广州中医药大学第一附属医院","广州白云机场路16号");
 


use hospital;
insert into department(name,hospital_id)values("内科门诊",5);
insert into hospital.department(name,hospital_id)values("外科门诊",5);
insert into hospital.department(name,hospital_id)values("产科门诊",5);

insert into hospital.department(name,hospital_id)values("眼科门诊",5);
insert into hospital.department(name,hospital_id)values("耳鼻喉科门诊",5);
insert into hospital.department(name,hospital_id)values("皮肤科门诊",5);

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("李志英","男",11,5,"教授","青光眼、白内障、高度近视、眼底病、流泪症");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("王幼生","男",11,5,"主任医师","长期从事近视眼防治研究，擅长近视眼的各种手术和非手术防治方法、眼科常见病");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("刘求红","男",11,5,"主治医师","眼科常见病");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("詹宇坚","男",11,5,"主任医师","从事眼科临床、教学、科研工作二十多年，中医理论造诣较深，擅长中西医结合诊疗眼底病，尤其对葡萄膜炎、眼底病、白内障、老年性黄斑变性有丰富的临床经验");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("王小川","女",11,5,"主治医师","擅长：眼科常见病");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("冀建平","男",11,5,"主治医师","角膜病、近视、青光眼等");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("钟筱华","女",12,5,"副主任医师","耳鼻喉科杂病");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("王顺兰","女",12,5,"副主任医师","头颈肿瘤、鼻窦炎、咽喉炎等");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("邱宝珊","女",12,5,"教授","耳鸣、耳聋、鼻炎、鼻咽癌、咽喉疾病、鼻病等");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("查旭山","男",13,5,"教授","各种结缔组织病、性病、真菌病、美容手术等");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("周克邦","男",13,5,"副教授","种结缔组织病、性病、真菌病。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("林少健","女",13,5,"副主任医师","寻麻疹、痤疮、脱发、尖锐湿疣等");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title)
values("柯晓燕","女",8,5,"主治医师");

insert into hospital.doctor(name,department_id,hospital_id)
values("赵小凤",8,5);

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("刘敏","男",5,5,"教授","糖尿病及其并发症、甲亢、失眠、咳嗽");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("吴智兵","男",5,5,"主任医师","脑血管病、头痛、头晕、周围神经病、帕金森病、多发性硬化、发热、咳嗽");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("刘琼","女",5,5,"副教授","呼吸系统疾病的中西药结合诊治、急慢性支气管炎、哮喘、肺心病、肺炎");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("梁毅","男",5,5,"副主任医师","血、白血病、恶性血液病、各种贫血、血小板减少症、白细胞减少症");

insert into hospital.doctor(name,department_id,hospital_id)
values("李健明",5,5);

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("陈刚毅","男",5,5,"副教授","尿路感染、肾结石、肾病综合病、肾功能衰竭等");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title)
values("钟崇","男",6,5,"副主任医师");

insert into hospital.doctor(name,department_id,hospital_id)
values("王志刚",6,5);

insert into hospital.doctor(name,department_id,hospital_id)
values("郝蕾",6,5);

insert into hospital.doctor(name,department_id,hospital_id)
values("翁治委",6,5);

insert into hospital.doctor(id,name,sex,department_id,hospital_id,academic_title,speciality)
values(22,"郭亚雄","男",6,5,"主治医师","心脏、大血管、肺部、食道胸噬病");

insert into hospital.doctor(name,department_id,hospital_id)
values("许志恒",6,5);





insert into hospital.hospital(name,address) values("广州医科大学附属第二医院","广州市海珠区昌岗东路250号");

insert into hospital.doctor(name,department_id,hospital_id,academic_title,speciality)
values("赵英恒",5,6,"主任医师","中西医结合及胃肠镜诊治消化不良、胃炎、肠炎、胃肠道出血、腹泻、便秘、肝胆胰等疾病");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("李万根","男",5,6,"主任医师","各种内分泌疾病的诊治。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("冯莹","女",5,6,"主任医师","血液肿瘤、疑难出血和血栓性疾病的诊治");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("陈瑞林","男",5,6,"副教授","对诊治通风、类风湿关节炎、系统性红斑狼疮、骨关节炎、骨质疏松症、强直性脊柱炎、血管炎、成人斯蒂尔病等各种风湿性疾病有丰富的临床经验");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("胡惠娟","女",5,6,"副主任医师","慢性咳嗽的鉴别诊断及诊疗，咳嗽比阿尼性支气管哮喘，支气管扩展，肺部感染，慢性阻塞性肺疾病的诊治");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("田利奇","男",5,6,"主任医师","呼吸系统感染性疾病、慢性阻塞性肺疾病、支气管哮喘、肺间质疾病、胸腔积液的诊断与治疗，肺部阴影的诊断与鉴别诊断。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("章乐虹","女",6,6,"教授","乳腺疾病外科治疗，乳腺癌手术治疗及乳房重建、乳腺癌化疗、内分泌治疗等综合治疗。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("林少芒","男",6,6,"教授","胸腹主动脉瘤、动脉硬化闭塞、下肢溃疡、脉管炎、静脉曲张、静脉血栓、糖尿病足。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("邓一文","女",6,6,"副主任医师","对普通外科疾病有丰富的临床诊治经验，手术技巧精湛，对胃肠肿瘤，甲状腺疾病、腹股沟疝、直肠肛门良性疾病治疗经验独到，尤其擅长腹部外科急症的临床处理。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("陈志光","男",6,6,"教授","泌尿、男生殖系统肿瘤、复杂性尿路结石、肾上腺疾病，慢性前列腺炎等疾病的诊断及处理，腔镜手术如经尿道前列腺电切术，输尿管镜碎石术。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("许日初","男",6,6,"主任医师","脊柱外科人工关节置换，创伤、骨病、慢性软组织损伤。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("梁建辉","男",6,6,"教授","各种胸部肿瘤的微创手术，重症肌无力、胸部疑难疾病的诊治及严重胸外伤的抢救。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("田耕","男",8,6,"主任医师","妇产科各种疑难危重疾病的诊治，尤其是各种高危妊娠、妊娠合并症、难产手术有丰富的临床经验。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("张兰珍","女",8,6,"主任医师","在围产医学和胎儿超声等方面有较深的研究，擅长产科妊娠合并症、并发症及难产的诊断和处理如：双胎妊娠、妊娠期糖尿病、妊娠合并系统性红斑狼疮、妊娠合并血栓性疾病等。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("郑小东","男",8,6,"副主任医师","对妊娠胆汁淤积综合症、妊娠期糖尿病、妊高征、早产、胎儿宫内发育迟缓、前置胎盘、妊娠糖尿病等高危妊娠疾病的诊断与治疗具有较深入的研究。擅长各种难产手术及剖宫产。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("沙翔垠","男",11,6,"主任医师","从事眼科工作25年，尤其是处理疑难复杂眼病的经验和能力，擅长于各种白内障超声乳化手术、各种角膜移植手术、准分子激光治疗近视手术、玻璃体切割手术，复杂眼外伤等等眼科显微手术，以及间接检眼镜直视下视网膜脱离复位手术等手术。2010年作为国际防盲专家参加了澳大利亚国际慈善基金总会发起的白内障手术医疗队，");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("郭露萍","女",11,6,"主任医师","眼底病、老年性眼病及全身疾病引起的眼部病变的诊治");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("姚达强","男",11,6,"主任医师","白内障、近视、青光眼等常见眼病，手术经验过万次");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("郭镇平","男",12,6,"主任医师","临床经验丰富，擅长耳鼻咽喉头颈肿瘤、疑难病症的诊疗有较高造诣。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("翁盛贤","男",12,6,"主任医师","对耳科学、听力学、鼻内窥镜手术、嗓音学、阻塞性睡眠暂停诊断治疗有较高的造诣。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("严小玲","女",12,6,"副主任医师","对头颈部肿瘤、耳科学、鼻内窥镜手术、阻塞性睡眠暂停综合征等疾病的诊治有独到见解。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("杨健","男",13,6,"教授","在诊治过敏性皮肤病、光线性皮肤病、真菌感染、带状疱疹、白癜风、皮肤肿瘤、性病及疑难重症病例方面有较多心得。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("杨文林","男",13,6,"副主任医师","对皮肤病和性病的诊治具有丰富的临床经验和心得，擅长儿童皮肤病及性传播疾病的诊疗，诊治了不少的疑难和少见病例。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("黄新宇","男",13,6,"副主任医师","临床经验丰富，擅长慢性荨麻疹、痤疮、尖锐湿疣、梅毒等皮肤病、性病的诊治及激光美容。");

delete from hospital.hospital where hospital_id=9;

insert into hospital.hospital(hospital_id,name,rank,address,telephone,brief,property) 
values(7,"广州市南沙中心医院","三级医院","广州市南沙区丰泽东路105号","020-22903666",

"广州市南沙中心医院是广州市人民政府与南沙区人民政府为完善南沙区的医疗设施配置，
加快南部广州新城建设而共同投资的，南沙区内唯一一所按三级医院标准兴建的综合性医院。
医院隶属广州市卫生局，为财政核补正处级事业单位，由具有113年历史的广州市第一人民医院负责经营管理，
已于2008年7月15日开业。医院西邻虎门高速公路及蕉门水道，紧靠南沙环岛西路，北邻广州地铁4号线金洲总站，
依山近水，环境优美，空气清新，地理位置优越。广州市南沙中心医院总占地面积10.05万平方米，
建筑工程分三期进行，现已完成的一期工程，建筑面积为3万平方米，目前设置床位100张。
二期工程将在2012年年底动工，预计2014年10月交付使用，包括十三层住院楼及五层医技楼，开设床位600张。
现已开设内科、外科、妇科、儿科、急诊科、危重医学科、麻醉科、中医科、康复科、眼科、耳鼻喉科、口腔科、
皮肤科、医学影像科、医学检验科、临床药学科等16个专业科室。拥有医务人员257人，
技术骨干及管理人员均为广州市第一人民医院派驻。
拥有东芝64排螺旋CT等各种先进医疗设备及具有世界先进水平的数字一体化手术室。
广州市南沙中心医院自开业以来，为人民群众提供了各种高质量的医疗服务，开展了各类高难度手术，
成功抢救多起复杂疑难危重病患者，业务量快速攀升。目前特色专科有：
创伤外科、消化内科、皮肤科、儿科、中医科、影像科、检验科、体检中心等。
2012年9月6日，国务院正式批复同意《广州南沙新区发展规划》，广州南沙区成为继上海浦东、
天津滨海等新区之后的第6个国家级新区，明确南沙区的战略定位是：立足广州、依托珠三角、连接港澳、服务内地、
面各世界，建设成为粤港澳优质生活圈、新型城市化典范、以生产性服务业为主导的现代产业新高地、
具有世界先进水平的综合服务枢纽、社会管理服务创新试验区，打造粤港澳全面合作示范区。
这是广州南沙开发建设史上的重要里程碑，标志着南沙新区发展上升为国家战略。未来五年，
广州市南沙中心医院将建设成为一所集医疗、预防、保健、康复、教学、科研于一体的大型综合性医院，
以精湛的技术、优良的设备、先进的管理成为立足南沙辐射珠三角的医疗中心。
医院总机：020-39096666广州市南沙中心医院网址：www.nshosp.cn
地址：广州市南沙区丰泽东路105号邮编：511457",
"公立医院");

insert into hospital.hospital(hospital_id,name,rank,address,telephone,brief,property) 
values(8,"中山大学附属第六医院","三级医院","广州市天河区员村二横路26号","38254000",
"中山大学附属第六医院是一所集医疗、教学、科研、预防和康复保健等为一体的大专科强综合医院，
拥有两个院区（员村院本部和瘦狗岭北院区）。是中华医学会外科学分会结直肠肛门外科学组组长单位，
中国中西医结合学会大肠肛门病专业委员会主任委员单位。拥有国内最高水平之一的结直肠癌会诊诊治中心，
与诺贝尔奖获得者亚利桑那大学Lee Hartwell教授合作共建国内唯一的“结直肠癌个体化治疗中心”，
开设华南地区首家直肠癌联合诊治中心、炎症性肠病联合诊治中心。 普通外科为国家临床重点专科，
结直肠肛门外科、肾内科、麻醉科、医学影像科等为省重点专科。
医院内设的中山大学胃肠病学研究所为广东省重点实验室，承办《中华胃肠外科杂志》。
医院内外妇儿等综合学科设置齐全，专科特色鲜明，设备先进，配备全国最先进的消化内镜中心、
生殖医学中心、炎症性肠病诊治中心、睡眠呼吸障碍诊疗中心、血液透析中心、盆底疾病研究中心、
临床听力中心、影像检验中心、围产医学中心。根据疾病特点细分胃肠肛门学科群，
仅结直肠肛门外科就下设结直肠癌、炎性肠病、放射性肠炎、慢性便秘、肛周良性疾病等十个亚专科，
分科最细，专业诊治，专业护理，专业服务。 坐拥目前广州市内面积最大的单体医疗大楼，
医院设置床位1200-1600张（专科床位700张）。医院将以国内一流、国际知名的现代化综合医院为愿景，
恪行“守真”院训，打造全国规模最大、最有影响力的胃肠肛门医院，竭诚为患者提供温馨、优质、
高效的医疗保健服务！","公立医院");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("温东东","男",6,7,"副主任医师","主任医师，从事外科临床工作40余年；
广州市第一人民医院工作20余年，现为广州市南沙中心医院返聘外科专家。
外科临床经验丰富、擅长阑尾炎、胰腺炎、胆囊炎、腹股沟疝、消化道肿瘤等外科常见病的诊断及手术治疗；
对甲状腺、肺、食管、纵膈等各种胸腔疾病及乳腺疾病的治疗有丰富经验。曾任广州市结核病学学会历届委员、
广州市医疗事故鉴定委员会成员；发表论文10余篇，人工生物食管课题获广东省科技厅资助、
中西医结合治疗乳腺癌课题获广州市卫生局课题资助。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("古维立","男",6,7,"主任医师","肝胆外科科主任，主任医师，医学博士，硕士研究生导师。
现任广东省肝病学会外科手术专业副主委、广东省肝病学会微创专业副主委、广东省肝病学会器官移植专业常务、
广州市医学会器官移植学会常务、广州市医学会腔镜外科分会委员兼秘书等职务。曾留学日本长崎大学9年，
从事肝胆胰脾外科工作近30年，完成医院首例肝移植手术，主持省市科研项目6项，已培养研究生7人。 
具有丰富的肝胆道常见病、多发病和复杂疑难病的诊治经验。擅长治疗肝脏、胆道、胰腺的各种疾病，
主要致力于：①肝脏、胆道肿瘤的治疗；②肝胆管结石、先天性胆管囊性扩张症的治疗；
③各种胆囊疾病的治疗；④肝硬化门脉高压症的治疗；⑤胆管癌、胰腺肿瘤的外科治疗。周四全天出诊。
");


insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title)
values("阳峻","男",6,7,"副主任医师");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("赵子文","男",5,7,"主任医师","中华医学会呼吸病分会COPD学组成员，
广东省医学会呼吸病分会副主任委员、 广东省医师协会呼吸病分会副主任委员、 
广州市医学会呼吸病分会副主任委员、 广东省医学会结核病分会常委，
美国微生物学会（EMS）会员、欧洲呼吸协会会员。《中华生物医学工程杂志》
《广州医学院学报》和《广东医学》审稿专家。对呼吸系统感染、支气管哮喘、
支气管扩张、肺癌等常见呼吸疾病诊治以及危重肺部感染和呼吸衰竭的治疗有丰富的实践经验, 
擅长于呼吸系统疑难危重病症的诊断和治疗以及支纤镜直视下支纤镜直视下支纤镜支架放置治疗良恶性气管支气管狭窄。
周二上午，周三下午出诊。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("张颖","女",5,7,"主任医师","从事呼吸内科临床、科研、教学18年，中华医学会会员，
擅长支气管哮喘和慢性阻塞性肺病、睡眠呼吸暂停、呼吸衰竭的诊断与治疗 。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("邓玲红","女",8,7,"主任医师","邓玲红，女，主任医师，硕士，
现任广州市妇幼保健工作委员会委员，广东省医学会围产医学学会委员，
广东省医学会计划生育学会委员，广东省优生优育学会委员，广东省、广州医学会医疗事故技术鉴定专家，
广州市劳动能力鉴定专家。广州市第一人民医院产科主任。 从事妇产科临床医学与研究近三十年，
临床技术素养高，凭借丰富的临床工作经验，熟练掌握妇产科的常见病、多发病及疑难病症的诊治技术，
熟练诊治产科失血性休克、感染性休克、羊水栓塞及其他产科并发症及合并症，
具有对危重病抢救应急处理及复杂疑难病症的分析、综合判断能力,
并在抢救和高难手术方面具有自己独特的见解和手术技巧。 
在产科开展了改变胎儿羊水成份治疗胎儿宫内窘迫、宫内发育迟缓、促胎儿肺成熟等多种疾病，
从而降低早产儿及新生儿的发病率和死亡率；在省内较早开展血管性介入治疗方法抢救产后出血，
成功地抢救了产妇的生命，也保住了患者的器官，受到病人及同行们的好评。 
市一医院门诊：周三上午、周四下午 南沙中心医院：周一上午");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("唐蔚","女",8,7,"副主任医师","副主任医师，讲师。东南大学毕业，暨南大学研究生。
长期从事妇产科临床、教学工作，具有丰富的临床经验和熟练的手术技巧，
擅长妇科炎症、不孕不育及肿瘤、围产期保健、高危妊娠管理、难产等的诊断及治疗。
2010年于北京协和医院进修，取得卫生部妇产内镜诊疗技术证书，
参加美国家庭医师协会高级产科生命支持学习班，获得证书。
已经撰写论文数篇，参与教学、科研课题申报多项。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title)
values("陈能","男",8,7,"主治医师");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("苏芳","女",12,7,"主任医师","耳鼻咽喉科主任医师，广州市医疗卫生专家库专家成员。 
从事耳鼻咽喉科临床工作二十多年，擅长耳鼻咽喉科各类疑难疾病的诊断、治疗，
对耳鼻咽喉及头颈部疾病的诊断与治疗有丰富的临床经验。
对急慢性咽喉炎、急慢性鼻窦炎、鼻息肉、鼻炎、中耳炎、耳鸣、耳聋、眩晕、声嘶、鼾症、
鼻咽癌、喉癌、甲状腺肿瘤、腮腺肿瘤等头颈部肿瘤的诊治有深入的研究。
近年来开设了针对鼻炎的专科门诊，针对不同患者，不同鼻炎，开展了包括过敏性鼻炎的免疫治疗，
鼻炎的激光、射频、微波等治疗，取得了很好的疗效，使广大鼻炎患者得到正规、系统的诊断与治疗。
在省级及国家级医学杂志发表论文20多篇。参与、负责多项广东省卫生厅、广东医学科技局科研课题。 
专家门诊:周一下午，周二全天");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("曾国庆","男",12,7,"医师","医学硕士，长期从事耳鼻咽喉科临床、科研工作，
基础理论和专业知识扎实。熟练掌握过敏性鼻炎、鼻窦炎、鼻息肉、急慢性咽喉炎、声带息肉、
中耳炎、面瘫、鼻咽癌、喉癌、甲状腺癌等常见疾病及疑难疾病的诊断和治疗。
研究方向为耳科疾病的诊断与临床治疗。作为第一作者在核心期刊发表专业论文2篇，
参与编写耳鼻咽喉科普丛书2本。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("张改霞","女",12,7,"医师","医学硕士，毕业于郑州大学医学院，熟练掌握耳鼻咽喉常见疾病、
多发病的诊疗常规，对耳鼻喉科急诊如鼻出血，耳、鼻、咽喉部异物等能熟练处理，
独立完成简单的乳突根治术、鼓膜切开置管术、简单的鼓膜修补术及鼓室灌注、扁桃体切除、
鼻中隔等手术， 在校期间发表核心期刊两篇。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("刘国龙","男",13,7,"主任医师","刘国龙：肿瘤科科主任、主任医师、临床肿瘤学硕士研究生导师，
广东放疗学会委员，广州肿瘤学会副主任委员，广州抗癌协会热疗与消融治疗专业委员会主任委员。
主持与参加国家、广东省、卫生厅科研基金6项，获军队科技进步奖4项。 从事肿瘤放、化疗临床工作23年，
擅长头颈部肿瘤（脑胶质瘤、鼻咽癌、喉癌）的放、化联合治疗，肺癌与肝区肿瘤的微创治疗
（射频消融与光子刀），对消化系肿瘤（食管癌、胃癌、大肠癌）的非手术综合治疗有丰富的临床经验。
出诊时间：每周一上午。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("曹小飞","男",13,7,"副主任医师","肿瘤科副主任医师，本科毕业于第三军医大学，
硕士毕业于第一军医大学。从事肿瘤科临床工作15余年，擅长于肿瘤放疗、化疗、免疫治疗及分子靶向治疗，
对鼻咽癌、喉癌、肺癌、食道癌、肝癌、结直肠癌、乳腺癌、宫颈癌、
恶性淋巴瘤等肿瘤综合治疗有较深入的研究并积累了丰富的临床经验。 广东省医师协会肿瘤专科医师分会委员，
广州市医学会肿瘤放射治疗学分会委员，《分子诊断与治疗杂志》编委。");



insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("李初俊","男",5,8,"副主任医师","消化内科副主任医师，硕士研究生导师。 
中山大学附属第六医院消化内镜中心主任，消化内科主任。 
中华医学会消化内镜学分会青年委员会和大肠镜专业学组成员、
广东省医学会消化内镜学分会常委和消化病学分会委员、广东省医师协会消化科医生分会常委。 
具有丰富的消化系统疾患临床诊治疗经验。娴熟利用胃镜、肠镜、小肠镜、十二指肠镜、超声内镜、
胶囊内镜进行疾病诊断和内镜下微创治疗，包括消化道息肉和早期癌、黏膜下肿瘤、消化道出血与狭窄、
胆管结石等的微创治疗、各种消化道支架和胆胰管支架的置放、内镜下各种营养管道的建立等。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("黎苗","女",5,8,"主治医师","消化内科主治医生，医学硕士。 长期从事内科临床工作，
积累了丰富的临床经验，尤其擅长消化内科常见疾病如慢性胃炎、消化性溃疡、腹泻、便秘、
胃肠道肿瘤、炎症性肠病以及肝胆疾病的诊疗。对于消化等内科急危重症的救治有独特的见解。
熟练掌握消化内镜的操作与镜下诊治。工作学习期间撰写及发表本专业及相关专业文章多篇。
参与多项本专业和相关专业科研工作。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("贺青","女",5,8,"副主任医师","消化内科副主任医师，医学博士，硕士生导师。 
从事临床工作多年，对胃肠道疾病如慢性胃炎、消化性溃疡、慢性腹泻、便秘、胃肠道肿瘤，
以及急慢性肝炎、肝硬化等的诊断治疗有较丰富的经验，对炎症性肠病如溃疡性结肠炎、
克罗恩病的治疗有较独特的见解。对胃肠镜的镜下诊断治疗经验丰富。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("汪中扬","男",6,8,"副主任医师","泌尿外科副主任医师，硕士生导师，大外科副主任。 
1987年毕业于中山医科大学医学系。从事泌尿外科工作25年，现任党委副书记，纪委书记。
中华医学会广州分会泌尿外科学会常委，中华医学会广州分会男科学会常委，广东省男科学会委员，
广东省抗癌协会泌尿生殖肿瘤专业委员。 擅长泌尿外科结石、肿瘤、先天畸形、泌尿系感染，
前列腺增生癌、前列腺炎、肾积水及男性性功能障碍和男性不育症的诊断和治疗。临床经验丰富。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("马波","男",6,8,"主治医师","泌尿外科主治医师，1997年毕业于白求恩医科大学。
从事泌尿外科临床工作10余年，擅长前列腺增生症、泌尿系结石的微创治疗。
开展了经尿道前列腺电切术、输尿管镜下碎石术、经皮肾穿刺造瘘取石术等微创手术。
使大量患者免除了传统手术的痛苦。同时对泌尿系肿瘤、男科疾病有较好的治疗效果。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("瞿虎","男",6,8,"主治医师","泌尿外科主治医师。1998年中山医科大学本科毕业，
1998-2004年于中山大学附属第一医院（黄埔院区）工作。
2004-2009年在中山大学附属第一医院攻读外科学（泌尿外科）硕士+博士学位，
研究方向为下尿路功能障碍及前列腺恶性肿瘤的早期诊断治疗，
2009年到中山大学附属第六医院泌尿外科工作，并于广东省计划生育研究工作所（人类精子库）进修学习男科学。
现在从事泌尿外科及男科学相关疾病的诊疗工作。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("刘晓英","女",8,8,"主治医师","妇产科主治医师 毕业于暨南大学，从事妇产科临床工作15年，
临床经验丰富，擅长孕期保健及高危妊娠的诊断和治疗，特别对妊娠期糖尿病、妊娠期高血压的诊治经验丰富；
救治危重症病人能力强；具有娴熟的手术技巧，特别是剖宫产、难产等助产技术。熟悉妇科常见病的诊治。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("黄冬丽","女",8,8,"主治医师","妇产科主治医师 2002年毕业于白求恩医科大学一直从事妇产科临床工作 
具有丰富的临床经验，擅长高危妊娠的诊治，特别对妊娠糖尿病的诊治经验丰富，熟悉妇科常见病的诊治，
对各种计划生育手术及产科手术操作娴熟。");


insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("冯志贞","女",11,8,"主治医师","眼科主治医师。 从事眼科临床工作十余年，
对眼科疾病有较丰富的经验。擅长各种眼科常见病及多发病的诊断和治疗，
尤其对青少年屈光不正的验光配镜有较丰富的临床经验。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("夏朝霞","女",11,8,"副主任医师","眼科副主任医师，医学博士，眼科专科主任。 
从事眼科的临床医疗及教学工作十余年，在眼科疾病领域中积累了较为丰富的经验，
尤其在白内障领域有较深的研究和造诣，擅长各种白内障的诊断和手术治疗，擅长青光眼、
葡萄膜炎、眼外伤及眼整形、小儿弱视等方面的诊治。近年在国家级及省级专业核心期刊上发表了数十篇文章，
主持并参与国家级、省、院级多项科研项目。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title)
values("杨筱曦","女",11,8,"主治医师");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("王维建","男",12,8,"副主任医师","耳鼻喉科副主任医师，中华医学会广州耳鼻喉科分会委员，
中国艺术医学协会理事。 在耳鼻喉科常见病及疑难病诊治方面有较丰富经验，对嗓音医学有较深入研究，
擅长声嘶疾病及耳鼻喉科肿瘤诊治。在省级以上杂志发表多篇论文。开设耳鼻喉科及嗓音医学专家门诊。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title)
values("龙镇","男",12,8,"主治医师");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("吴良才","男",13,8,"副主任医师","皮肤科 主任 医学博士 副主任医师 
中山大学硕士毕业后留校工作10余年，现任皮肤科学科带头人和专科主任。
博士期间专注于干细胞美容以及白癜风的临床研究工作,曾在新加坡国立大学医院（NUH)短期访问交流。 
对皮肤科常见病和疑难病的诊治有丰富的临床经验，尤其擅长白癜风、痤疮、病毒疣、色斑、胎痣、
瘙痒性皮肤病等的治疗。在重型药疹，天疱疮，红斑狼疮等自身免疫性疾病有丰富的抢救经验。
先后主持、参与国家级、省局级科研项目8项。在国内外专业核心期刊发表学术论文20余篇。");

insert into hospital.doctor(name,sex,department_id,hospital_id,academic_title,speciality)
values("陈志和","男",13,8,"副主任医师","皮肤科副主任医师。皮肤科负责人。
1977年毕业于第一军医大学临床医学系。 从事皮肤性病科临床工作30多年。
对诊治皮肤性病积累了丰富的临床经验，主治各种皮肤病（如前列腺炎、痤疮、牛皮癣、脱发等）
和性病（淋病、梅毒、非淋菌性尿道炎、生殖器疱疹、尖锐湿疣等）。擅长于腋臭电解术、
激光治疗术和各种皮肤外科小手术。");

use hospital;
select do.name from doctor do join department de join hospital h 
where do.department_id=de.department_id and do.hospital_id=h.hospital_id 
and de.name='内科门诊' and h.name='广州中医药大学第一附属医院';