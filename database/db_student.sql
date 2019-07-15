drop database  if exists db_student;

create database db_student character set utf8;

use db_student;

create table tb_admin(
	adminID varchar(10) primary key,
	username varchar(20),
	password varchar(20)
);

insert into tb_admin value('admin1','cwg','wqnmlgb');
insert into tb_admin value('admin2','root','root');
insert into tb_admin value('admin3','test','test');

create table tb_grade(
	gradeID varchar(20) primary key,
	gradeName varchar(20)
);

insert into tb_grade value('grade1','大一');
insert into tb_grade value('grade2','大二');
insert into tb_grade value('grade3','大三');
insert into tb_grade value('grade4','大四');

create table tb_class(
	classID varchar(20),
	gradeID varchar(20),
	className varchar(20),
	primary key(classID,gradeID),
	foreign key(gradeID) references tb_grade(gradeID)
);

insert into tb_class value('18F','grade1','18软件工程');
insert into tb_class value('17F','grade2','17软件工程');
insert into tb_class value('16F','grade3','16软件工程');
insert into tb_class value('15F','grade4','15软件工程');

insert into tb_class value('18A','grade1','18计科师范');
insert into tb_class value('17A','grade2','17计科师范');
insert into tb_class value('16A','grade3','16计科师范');
insert into tb_class value('15A','grade4','15计科师范');

insert into tb_class value('18B','grade1','18计科非师范');
insert into tb_class value('17B','grade2','17计科非师范');
insert into tb_class value('16B','grade3','16计科非师范');
insert into tb_class value('15B','grade4','15计科非师范');


create table tb_examkind(
	kindID varchar(20) primary key,
	kindName varchar(20)
);

insert into tb_examkind value('kind1','笔试');
insert into tb_examkind value('kind2','机试');
insert into tb_examkind value('kind3','自主考试');


create table tb_student(
		stuID varchar(20) primary key,
		classID varchar(20),
		stuName varchar(20),
		sex varchar(10),
		age int,
		addr varchar(50),
		phone varchar(20)
);

insert into tb_student value('1643205000228','16B','张玲莉','女',22,'云南曲靖','15911562136');
insert into tb_student value('1643205000238','16B','恭子玲','女',21,'云南曲靖','18812340807');
insert into tb_student value('1643205000270','16B','李梦瑶','女',22,'云南曲靖','18468066009');
insert into tb_student value('1643205000254','16B','李国菡','女',21,'云南曲靖','15825136697');
insert into tb_student value('1643205000245','16B','叶梦娇','女',22,'云南曲靖','18388578681');
insert into tb_student value('1643205000262','16B','张晓娇','女',21,'云南曲靖','18468034540');
insert into tb_student value('1643205000251','16B','周耀宗','男',22,'云南楚雄','15288523057');
insert into tb_student value('1643205000217','16B','杨之耀','男',21,'河北','15531738466');
insert into tb_student value('1643205000253','16B','谢存宇','男',23,'云南楚雄','15758333937');
insert into tb_student value('1643205000268','16B','杨浩宇','男',20,'云南迪庆','18468219533');
insert into tb_student value('1643205000236','16B','张浩','男',21,'云南昭通','15125323184');
insert into tb_student value('1643205000234','16B','张飞虎','男',22,'云南昭通','14769100244');
insert into tb_student value('1643205000264','16B','钏丽兴','女',22,'云南昆明','15770290164');
insert into tb_student value('1643205000231','16B','周瑞','女',21,'云南昆明','18468263089');
insert into tb_student value('1643205000257','16B','杨洋','女',20,'云南昆明','15087320939');
insert into tb_student value('1643205000260','16B','李润梅','女',22,'云南昆明','18468015460');
insert into tb_student value('1643205000269','16B','周奕灵','女',21,'云南昆明','15974551497');
insert into tb_student value('1643205000247','16B','陆雅婷','女',21,'云南昆明','13368874866');
insert into tb_student value('1643205000246','16B','刘琼','女',21,'云南昆明','15987475652');
insert into tb_student value('1643205000220','16B','郝旭影','女',21,'山东','18468086917');
insert into tb_student value('1643205000243','16B','蔡娅蕊','女',21,'云南昆明','18468110243');
insert into tb_student value('1643205000222','16B','张娅敏','女',21,'云南昆明','13577059716');
insert into tb_student value('1643205000261','16B','罗荣杰','女',21,'云南昆明','18387248708');
insert into tb_student value('1643205000226','16B','马帧霓','女',21,'云南昆明','15969469674');
insert into tb_student value('1643205000266','16B','李木兰','女',21,'云南昆明','18468022746');
insert into tb_student value('1643205000229','16B','朱明丽','女',21,'云南昆明','18468111043');
insert into tb_student value('1643205000248','16B','陈南丽','女',21,'云南昆明','18468073602');
insert into tb_student value('1643205000216','16B','李一璠','女',21,'云南昆明','18468005296');
insert into tb_student value('1643205000242','16B','王嫄','女',21,'云南昆明','18468068943');
insert into tb_student value('1643205000224','16B','李萌','女',21,'云南昆明','15912562472');
insert into tb_student value('1643205000237','16B','高孟','男',21,'云南昆明','18213782590');
insert into tb_student value('1643205000223','16B','李红伟','男',21,'云南昆明','13698746024');
insert into tb_student value('1643205000233','16B','彭祥富','男',21,'云南昆明','15750187186');
insert into tb_student value('1643205000250','16B','杜国龙','男',21,'云南昆明','18787445635');
insert into tb_student value('1643205000255','16B','丁靖','男',21,'云南昆明','18468021549');
insert into tb_student value('1643205000265','16B','赵腊约','男',21,'云南昆明','18468274276');
insert into tb_student value('1643205000225','16B','黄磊','男',21,'云南昆明','13529375920');
insert into tb_student value('1643205000263','16B','杜学山','男',21,'云南昆明','15287217905');
insert into tb_student value('1643205000227','16B','李加涛','男',21,'云南昆明','13354910361');
insert into tb_student value('1643205000241','16B','白文杉','男',21,'云南昆明','18468006418');
insert into tb_student value('1643205000252','16B','杜红鑫','男',23,'云南楚雄','15125871885');
insert into tb_student value('1643205000235','16B','蔡万刚','男',21,'云南昭通','18468126183');
insert into tb_student value('1643205000259','16B','梁正厅','男',21,'云南文山','18468110209');
insert into tb_student value('1643205000230','16B','龙智','男',23,'云南昭通','18468262956');
insert into tb_student value('1443205000037','16B','董文斌','男',24,'云南昆明','15752067261');
insert into tb_student value('1643205000218','16B','张峻浩','男',22,'东北','18468077256');
insert into tb_student value('1643205000244','16B','尹丹','女',21,'云南昆明','18787436685');
insert into tb_student value('1643205000258','16B','江文','女',21,'云南昆明','17387000617');
insert into tb_student value('1643205000239','16B','华婷','女',21,'云南昆明','18213706541');
insert into tb_student value('1643205000221','16B','俞志丽','女',22,'云南昆明','18468030376');
insert into tb_student value('1643205000249','16B','杨吉欣','女',22,'云南昆明','13618840160');
insert into tb_student value('1643205000271','16B','和鑫','女',21,'云南昆明','13368873268');
insert into tb_student value('1643205000219','16B','王西禾','女',20,'云南昆明','18744684591');
insert into tb_student value('1643205000256','16B','祖萍琰','女',23,'云南昆明','15126356268');
insert into tb_student value('1643205000267','16B','邱菊','女',21,'云南昆明','18869697490');
insert into tb_student value('1643205000232','16B','程清念','女',22,'云南昆明','18468026215');
insert into tb_student value('1643204000310','16B','郭进军','男',22,'云南昆明','18787260102');

insert into tb_student value('1643205000012','16A','荣博','男',22,'云南昆明','18468008739');
insert into tb_student value('1643205000008','16A','任斌','男',22,'云南昆明','18388773240');
insert into tb_student value('1643205000009','16A','王照','男',22,'云南昆明','18468160552');
insert into tb_student value('1643205000029','16A','乔忠文','男',22,'云南昆明','18468212500');
insert into tb_student value('1643205000011','16A','耿赛','男',22,'云南昆明','15287424249');
insert into tb_student value('1643205000032','16A','魏礼柱','男',22,'云南昆明','15697052927');
insert into tb_student value('1643205000021','16A','王凯','男',22,'云南昆明','18187026759');
insert into tb_student value('1643205000033','16A','木合塔尔','男',22,'云南昆明','15587090412');
insert into tb_student value('1643205000013','16A','李金','男',22,'云南昆明','18468286742');
insert into tb_student value('1643205000001','16A','冯钧','男',22,'云南昆明','15196506827');
insert into tb_student value('1643205000023','16A','段天成','男',22,'云南昆明','18468013796');
insert into tb_student value('1643205000022','16A','赵凯','男',22,'云南昆明','14787723781');
insert into tb_student value('1643205000020','16A','龙正喜','男',22,'云南昆明','15908765414');
insert into tb_student value('1643205000034','16A','阿卜杜热合曼','男',22,'云南昆明','18468101614');
insert into tb_student value('1643205000035','16A','李若愚','男',22,'云南昆明','13908702207');
insert into tb_student value('1643205000036','16A','李寿根','男',22,'云南昆明','18487814616');
insert into tb_student value('1643205000025','16A','常飞燕','女',22,'云南昆明','18468008748');
insert into tb_student value('1643205000014','16A','沈莹莹','女',22,'云南昆明','18468113453');
insert into tb_student value('1643205000037','16A','白玉珍','女',22,'云南昆明','13688700194');
insert into tb_student value('1643205000030','16A','施霜','女',22,'云南昆明','15587082509');
insert into tb_student value('1643205000007','16A','冯慢','女',22,'云南昆明','15126622446');
insert into tb_student value('1643205000004','16A','罗姣','女',22,'云南昆明','15908890761');
insert into tb_student value('1643205000027','16A','杨玺悦','女',22,'云南昆明','18988232196');
insert into tb_student value('1643205000031','16A','张漫迪','女',22,'云南昆明','18468094706');
insert into tb_student value('1643205000010','16A','施文青','女',22,'云南昆明','18468051196');
insert into tb_student value('1643205000015','16A','熊萍','女',22,'云南昆明','18468047986');
insert into tb_student value('1643205000017','16A','蒋文雅','女',22,'云南昆明','18468081211');
insert into tb_student value('1643205000024','16A','朱宇珊','女',22,'云南昆明','18287265074');
insert into tb_student value('1643205000026','16A','杨素蓉','女',22,'云南昆明','18468161334');
insert into tb_student value('1643205000018','16A','许婉','女',22,'云南昆明','18214357630');
insert into tb_student value('1643205000002','16A','余秋凤','女',22,'云南昆明','18468110526');
insert into tb_student value('1643205000006','16A','猫良茜','女',22,'云南昆明','13769102047');
insert into tb_student value('1643205000003','16A','陈娜','女',22,'云南昆明','18213003095');
insert into tb_student value('1643205000016','16A','饶师瑾','女',22,'云南昆明','18214310507');
insert into tb_student value('1643205000019','16A','闫云丽','女',22,'云南昆明','15025197540');
insert into tb_student value('1643205000028','16A','陈寿艳','女',22,'云南昆明','18869000530');
insert into tb_student value('1643205000005','16A','解兆婷','女',22,'云南昆明','15559876341');

insert into tb_student value('1643205000136','16F','尹富亮','男',22,'云南昆明','18088260699');
insert into tb_student value('1643205000152','16F','保俊浩','男',22,'云南昆明','15108655335');
insert into tb_student value('1643205000158','16F','韩明智','男',22,'云南昆明','15154961256');
insert into tb_student value('1643205000126','16F','梁展聪','男',22,'云南昆明','17707855305');
insert into tb_student value('1643205000142','16F','王明阳','男',22,'云南昆明','15508850962');
insert into tb_student value('1643205000175','16F','韩文科','男',22,'云南昆明','15592675202');
insert into tb_student value('1643205000169','16F','王春江','男',22,'云南昆明','18468162336');
insert into tb_student value('1643205000161','16F','何开阔','男',22,'云南昆明','18468245955');
insert into tb_student value('1643205000171','16F','阮鑫旭','男',22,'云南昆明','18008768052');
insert into tb_student value('1643205000174','16F','陶文林','男',22,'云南昆明','15687384151');
insert into tb_student value('1643205000132','16F','苏顺梅','女',22,'云南昆明','18208745152');
insert into tb_student value('1643205000125','16F','黄欣琦','女',22,'云南昆明','18468160492');
insert into tb_student value('1643205000140','16F','李锐','女',22,'云南昆明','18468056318');
insert into tb_student value('1643205000157','16F','陈颖','女',22,'云南昆明','15108702959');
insert into tb_student value('1643205000129','16F','梁雪蓉','女',22,'云南昆明','13629608052');
insert into tb_student value('1643205000138','16F','杨露','女',22,'云南昆明','18314563227');
insert into tb_student value('1643205000163','16F','高秀珍','女',22,'云南昆明','18468045455');
insert into tb_student value('1643205000146','16F','周儒','女',22,'云南昆明','18468093368');
insert into tb_student value('1643205000123','16F','吕琪','女',22,'云南昆明','18468028126');
insert into tb_student value('1643205000145','16F','母冉','女',22,'云南昆明','18087467068');
insert into tb_student value('1643205000162','16F','刁明月','女',22,'云南昆明','18468153295');
insert into tb_student value('1643205000172','16F','刘宣宣','女',22,'云南昆明','18468077990');
insert into tb_student value('1643205000153','16F','孙玉梅','女',22,'云南昆明','18468078775');
insert into tb_student value('1643205000173','16F','魏红','女',22,'云南昆明','13987646131');
insert into tb_student value('1643205000143','16F','谢丽','女',22,'云南昆明','18468016940');
insert into tb_student value('1643205000149','16F','张海东','男',22,'云南昆明','15587064011');
insert into tb_student value('1643205000141','16F','张韩','男',22,'云南昆明','14769121841');
insert into tb_student value('1643205000147','16F','刘迪','男',22,'云南昆明','17387017854');
insert into tb_student value('1643205000156','16F','何涵','男',22,'云南昆明','15559886032');
insert into tb_student value('1643205000166','16F','高长宝','男',22,'云南昆明','13013394657');
insert into tb_student value('1643205000160','16F','杨春','男',22,'云南昆明','13887505434');
insert into tb_student value('1643205000155','16F','朱凡','男',22,'云南昆明','18468006994');
insert into tb_student value('1643205000148','16F','魏文东','男',22,'云南昆明','18468023003');
insert into tb_student value('1643205000168','16F','陈博文','男',22,'云南昆明','15687510818');
insert into tb_student value('1643205000170','16F','张凯迪','男',22,'云南昆明','18468052246');
insert into tb_student value('1643205000124','16F','李国赏','男',22,'云南昆明','17308895989');
insert into tb_student value('1643205000135','16F','胡杨士杰','男',22,'云南昆明','18288606217');
insert into tb_student value('1643205000150','16F','舒双涛','男',22,'云南昆明','13887476265');
insert into tb_student value('1643205000131','16F','陈凡','男',22,'云南昆明','18687710876');
insert into tb_student value('1643205000164','16F','刘建聪','男',22,'云南昆明','18387264693');
insert into tb_student value('1643205000134','16F','李进才','男',22,'云南昆明','18267874868');
insert into tb_student value('1643205000139','16F','戴昌煜','男',22,'云南昆明','18468037151');
insert into tb_student value('1643205000133','16F','李俊辉','男',22,'云南昆明','18288268391');
insert into tb_student value('1643205000165','16F','孔繁超','男',22,'云南昆明','18468227719');
insert into tb_student value('1643205000167','16F','字立生','男',22,'云南昆明','18468020368');
insert into tb_student value('1643205000151','16F','刘星宏','男',22,'云南昆明','13508744276');
insert into tb_student value('1643205000144','16F','陈然辉','男',22,'云南昆明','18468026389');
insert into tb_student value('1643205000137','16F','温志洪','男',22,'云南昆明','18243453637');
insert into tb_student value('1643205000127','16F','郑晓航','男',22,'云南昆明','18468283928');
insert into tb_student value('1643205000128','16F','朱洪伟','男',22,'云南昆明','18988458485');

insert into tb_student value('1543205000002','15A','刘春杰','女',24,'云南昆明','18788444648');
insert into tb_student value('1543205000009','15A','王丽婷','女',24,'云南昆明','18787059925');
insert into tb_student value('1543205000007','15A','陈波','女',24,'云南昆明','15025156296');
insert into tb_student value('1543205000003','15A','李梦雅','女',24,'云南昆明','15025119519');
insert into tb_student value('1543205000006','15A','华伟芳','女',24,'云南昆明','18213855584');
insert into tb_student value('1543205000005','15A','吾如丽妮萨','女',24,'云南昆明','18487244186');
insert into tb_student value('1543205000012','15A','胡莉','女',24,'云南昆明','13648877531');
insert into tb_student value('1543205000013','15A','张祝鸿','女',24,'云南昆明','15187973418');
insert into tb_student value('1543205000014','15A','王玲琳','女',24,'云南昆明','15808748097');
insert into tb_student value('1543205000015','15A','王婷','女',24,'云南昆明','18213897706');
insert into tb_student value('1543205000016','15A','陆雪静','女',24,'云南昆明','18287169404');
insert into tb_student value('1543205000018','15A','马佳','女',24,'云南昆明','18288622944');
insert into tb_student value('1543205000019','15A','李巧','女',24,'云南昆明','18208864404');
insert into tb_student value('1543205000020','15A','马虹宇','女',24,'云南昆明','18206811554');
insert into tb_student value('1543205000021','15A','杨春建','女',24,'云南昆明','18208846594');
insert into tb_student value('1543205000022','15A','卢贵云','女',24,'云南昆明','18288610534');
insert into tb_student value('1543205000024','15A','张梅','女',24,'云南昆明','18206717794');
insert into tb_student value('1543205000025','15A','杨丽梅','女',24,'云南昆明','18288982544');
insert into tb_student value('1543205000026','15A','赵黎梅','女',24,'云南昆明','18213574064');
insert into tb_student value('1543205000027','15A','田文妹','女',24,'云南昆明','18213589534');
insert into tb_student value('1543205000028','15A','杨洪蓉','女',24,'云南昆明','18208858394');
insert into tb_student value('1543205000030','15A','李爱萍','女',24,'云南昆明','18387525955');
insert into tb_student value('1543205000031','15A','覃芳','女',24,'云南昆明','18288636164');
insert into tb_student value('1543205000032','15A','崔贵萍','女',24,'云南昆明','18288277284');
insert into tb_student value('1543205000033','15A','师妍','女',24,'云南昆明','15912576514');
insert into tb_student value('1543205000034','15A','候韩钰','女',24,'云南昆明','15829638980');
insert into tb_student value('1543205000001','15A','魏梓泉','男',24,'云南昆明','18787031150');
insert into tb_student value('1543205000008','15A','周肖','男',24,'云南昆明','13518743754');
insert into tb_student value('1543205000023','15A','韩天','男',24,'云南昆明','18213388805');
insert into tb_student value('1543205000029','15A','韩一峰','男',24,'云南昆明','18214693079');
insert into tb_student value('1543205000004','15A','麦麦提艾力','男',24,'云南昆明','15009054640');
insert into tb_student value('1543205000010','15A','马鹏飞','男',24,'云南昆明','18287174074');
insert into tb_student value('1543205000017','15A','杨云飞','男',24,'云南昆明','15187722155');
insert into tb_student value('1543205000011','15A','郑家友','男',24,'云南昆明','18183554192');
insert into tb_student value('1543205000035','15A','张敏涛','男',24,'云南昆明','15812070197');

insert into tb_student value('1543205000207','15B','宁德瑞','男',24,'云南昆明','18288931544');
insert into tb_student value('1543205000209','15B','李达','男',24,'云南昆明','15187766109');
insert into tb_student value('1543205000216','15B','马宁','男',24,'云南昆明','18213016014');
insert into tb_student value('1543205000224','15B','马岩南','男',24,'云南昆明','18987544781');
insert into tb_student value('1543205000217','15B','罗强','男',24,'云南昆明','18213021044');
insert into tb_student value('1543205000206','15B','田松','男',24,'云南昆明','18388332534');
insert into tb_student value('1543205000199','15B','魏斌','男',24,'云南昆明','18213464694');
insert into tb_student value('1543205000200','15B','洪鑫','男',24,'云南昆明','13278675513');
insert into tb_student value('1543205000203','15B','蒋尚兵','男',24,'云南昆明','18313708004');
insert into tb_student value('1543205000204','15B','陈文波','男',24,'云南昆明','18206860024');
insert into tb_student value('1543205000201','15B','杨禀乾','男',24,'云南昆明','18812340874');
insert into tb_student value('1543205000196','15B','彭云川','男',24,'云南昆明','18214282185');
insert into tb_student value('1543205000183','15B','曾仁志','男',24,'云南昆明','18208811304');
insert into tb_student value('1543205000185','15B','夏宁','男',24,'云南昆明','15687762711');
insert into tb_student value('1543205000218','15B','李睿星','男',24,'云南昆明','18213855884');
insert into tb_student value('1543205000202','15B','杨克浩','男',24,'云南昆明','18206790324');
insert into tb_student value('1543205000219','15B','杜明川','男',24,'云南昆明','15912552194');
insert into tb_student value('1543205000186','15B','李超','男',24,'云南昆明','15912129557');
insert into tb_student value('1543205000179','15B','王林','男',24,'云南昆明','13619498665');
insert into tb_student value('1543205000226','15B','邓逸','男',24,'云南昆明','13170695366');
insert into tb_student value('1543205000194','15B','李通信','男',24,'云南昆明','18108851486');
insert into tb_student value('1543205000180','15B','卢超宇','男',24,'云南昆明','15559906805');
insert into tb_student value('1543205000191','15B','陈勇亦','男',24,'云南昆明','18213086156');
insert into tb_student value('1543205000193','15B','王东发','男',24,'云南昆明','13529451279');
insert into tb_student value('1543205000220','15B','杨春婷','女',24,'云南昆明','18213001504');
insert into tb_student value('1543205000213','15B','邱美华','女',24,'云南昆明','18213858004');
insert into tb_student value('1543205000214','15B','胡艺','女',24,'云南昆明','18213989224');
insert into tb_student value('1543205000181','15B','陈安珂','女',24,'云南昆明','18487229525');
insert into tb_student value('1543205000195','15B','马涵','女',24,'云南昆明','18287190764');
insert into tb_student value('1543205000205','15B','张蝶','女',24,'云南昆明','15887197304');
insert into tb_student value('1543205000189','15B','胡婷婷','女',24,'云南昆明','15287191896');
insert into tb_student value('1543205000182','15B','孟颖','女',24,'云南昆明','15308631750');
insert into tb_student value('1543205000192','15B','韩洁','女',24,'云南昆明','18313876335');
insert into tb_student value('1543205000208','15B','刘开瑜','女',24,'云南昆明','18287484810');
insert into tb_student value('1543205000212','15B','薛敏','女',24,'云南昆明','18208871834');
insert into tb_student value('1543205000184','15B','梁荔','女',24,'云南昆明','15198782474');
insert into tb_student value('1543205000215','15B','唐铭蔚','女',24,'云南昆明','13466287045');
insert into tb_student value('1543205000222','15B','杨胜隆','女',24,'云南昆明','18787243510');
insert into tb_student value('1543205000198','15B','王艳','女',24,'云南昆明','13759120274');
insert into tb_student value('1543205000223','15B','霍永健','女',24,'云南昆明','15094200755');
insert into tb_student value('1543205000221','15B','吴金萍','女',24,'云南昆明','18213819264');
insert into tb_student value('1543205000227','15B','刘瑞珠','女',24,'云南昆明','15969206588');
insert into tb_student value('1543205000225','15B','杨舒越','女',24,'云南昆明','18213820354');
insert into tb_student value('1543205000187','15B','龙怡君','女',24,'云南昆明','18787491365');
insert into tb_student value('1543205000188','15B','夏嘉','女',24,'云南昆明','13529006284');
insert into tb_student value('1543205000190','15B','李怡琦','女',24,'云南昆明','18687164623');
insert into tb_student value('1543205000210','15B','禹丽莹','女',24,'云南昆明','18287146747');
insert into tb_student value('1543205000211','15B','黄思思','女',24,'云南昆明','18288746364');
insert into tb_student value('1543205000197','15B','杨菊','女',24,'云南昆明','18206735774');
		
insert into tb_student value('1543205000108','15F','瞿佳',	'女',21,'云南昆明','18214620594');	
insert into tb_student value('1543205000123','15F','王力澜','女',21,'云南昆明','18587330115');	
insert into tb_student value('1543215000118','15F','何欣蓉','女',21,'云南昆明','15887279058');	
insert into tb_student value('1543205000126','15F','肖朴凤','女',21,'云南昆明','15288437201');	
insert into tb_student value('1543205000244','15F','余文凤','女',21,'云南昆明','13629690120');	
insert into tb_student value('1543205000110','15F','刘云舒','女',21,'云南昆明','15808758799');	
insert into tb_student value('1543205000121','15F','张明英','女',21,'云南昆明','18487224220');	
insert into tb_student value('1543205000133','15F','秦丽芬','女',21,'云南昆明','18487222519');	
insert into tb_student value('1543205000140','15F','黄欣',	'女',21,'云南昆明','15126105662');	
insert into tb_student value('1543205000146','15F','唐钟秀','女',21,'云南昆明','18213892124');	
insert into tb_student value('1543205000148','15F','陈如虹','女',21,'云南昆明','18288746554');	
insert into tb_student value('1543205000139','15F','卢庭玉','女',21,'云南昆明','18213613967');	
insert into tb_student value('1543205000115','15F','任秋臻','女',21,'云南昆明','15911594102');	
insert into tb_student value('1543205000117','15F','朱艳萍','女',21,'云南昆明','18206858449');	
insert into tb_student value('1543205000124','15F','杨海思','女',21,'云南昆明','18214584264');	
insert into tb_student value('1543205000128','15F','谭春艳','女',21,'云南昆明','15188140300');	
insert into tb_student value('1543205000147','15F','周玉婷','女',21,'云南昆明','18213040458');	
insert into tb_student value('1543205000151','15F','马珊珊','女',21,'云南昆明','18869015243');	
insert into tb_student value('1543205000136','15F','尚熙杰','男',21,'云南昆明','15425855560');	
insert into tb_student value('1543205000131','15F','夏安邦','男',21,'云南昆明','18288211524');	
insert into tb_student value('1543205000142','15F','侯孟超','男',21,'云南昆明','15924610820');	
insert into tb_student value('1543205000155','15F','罗庆秋','男',21,'云南昆明','15887105054');	
insert into tb_student value('1543205000119','15F','蒋茂林','男',21,'云南昆明','15887144374');	
insert into tb_student value('1543205000150','15F','张斌',	'男',21,'云南昆明','18314379971');	
insert into tb_student value('1543205000135','15F','李清宇','男',21,'云南昆明','18687873654');	
insert into tb_student value('1543205000130','15F','陈涛',	'男',21,'云南昆明','18388345912');	
insert into tb_student value('1543205000145','15F','张建标','男',21,'云南昆明','18288935684');	
insert into tb_student value('1543205000153','15F','杨金海','男',21,'云南昆明','18214599464');	
insert into tb_student value('1543205000105','15F','徐春晓','男',21,'云南昆明','15912496574');	
insert into tb_student value('1543205000109','15F','姜徐键','男',21,'云南昆明','14787875290');	
insert into tb_student value('1543205000113','15F','王康',	'男',21,'云南昆明','15912542385');	
insert into tb_student value('1543205000116','15F','蒋堞',	'男',21,'云南昆明','18725082705');	
insert into tb_student value('1543205000107','15F','苏明勇','男',21,'云南昆明','15887102064');	
insert into tb_student value('1543205000129','15F','朱澄',	'男',21,'云南昆明','18313577877');	
insert into tb_student value('1543205000122','15F','刘茂潇','男',21,'云南昆明','15198775994');	
insert into tb_student value('1543205000114','15F','杨艳伟','男',21,'云南昆明','15687091973');	
insert into tb_student value('1543205000137','15F','李国',	'男',21,'云南昆明','18487250137');	
insert into tb_student value('1543205000132','15F','刘易',	'男',21,'云南昆明','15198720367');	
insert into tb_student value('1543205000125','15F','冷玲聪','男',21,'云南昆明','15287875943');	
insert into tb_student value('1543205000138','15F','管绍春','男',21,'云南昆明','13064283256');	
insert into tb_student value('1543205000156','15F','林靖卓','男',21,'云南昆明','13108709019');	
insert into tb_student value('1543205000152','15F','杨国琦','男',21,'云南昆明','18487232667');	
insert into tb_student value('1543205000149','15F','谢振斌','男',21,'云南昆明','18487274849');	
insert into tb_student value('1543205000112','15F','吴佳洋','男',21,'云南昆明','18788565139');	
insert into tb_student value('1543205000106','15F','苏金豪','男',21,'云南昆明','15995367187');	
insert into tb_student value('1543205000127','15F','陶加贵','男',21,'云南昆明','15288044876');	
insert into tb_student value('1543205000120','15F','何志林','男',21,'云南昆明','18487372627');	
insert into tb_student value('1543205000154','15F','席孝文','男',21,'云南昆明','15559888430');	
insert into tb_student value('1543205000141','15F','程刚',	'男',21,'云南昆明','18213519434');	
insert into tb_student value('1543205000111','15F','李宗泽','男',21,'云南昆明','13577128985');	
insert into tb_student value('1543205000143','15F','周杰',	'男',21,'云南昆明','13064266397');	
insert into tb_student value('1543202000005','15F','任大吉','男',21,'云南昆明','17387191926');	
insert into tb_student value('1543202000196','15F','袁鹏程','男',21,'云南昆明','15912526774');	
insert into tb_student value('1543207000006','15F','傅正彬','男',21,'云南昆明','18487232807');
	
insert into tb_student value('1743205000001','17A','刘潺',	'女',21,'云南昆明','18388019724');	
insert into tb_student value('1743205000003','17A','韩文静','女',21,'云南昆明','18487207619');	
insert into tb_student value('1743205000011','17A','徐志敏','女',21,'云南昆明','15877868524');	
insert into tb_student value('1743205000035','17A','阿曼妮萨·铁木尔','女',22,'云南昆明','18299805112');	
insert into tb_student value('1743205000004','17A','赵艺洋','女',21,'云南昆明','15525709526');	
insert into tb_student value('1743205000009','17A','钟华','女',23,'云南昆明','13698748081');	
insert into tb_student value('1743205000020','17A','何星宇','女',21,'云南昆明','13759090397');	
insert into tb_student value('1743205000036','17A','吾日姑力·图尔荪','女',22,'云南昆明','18314177357');	
insert into tb_student value('1743205000005','17A','徐国秦','女',19,'云南昆明','18313844570');	
insert into tb_student value('1743205000007','17A','陈丹丹','女',19,'云南昆明','18987024315');	
insert into tb_student value('1743205000022','17A','王愉璐','女',19,'云南昆明','15925365576');	
insert into tb_student value('1743205000024','17A','金珠','女',20,'云南昆明','18388651887');	
insert into tb_student value('1743205000029','17A','杨晴路','女',21,'云南昆明','18087213376');	
insert into tb_student value('1743205000038','17A','李雅琪','女',21,'云南昆明','13518701297');	
insert into tb_student value('1743205000006','17A','于婷','女',21,'云南昆明','15911539621');	
insert into tb_student value('1743205000008','17A','舒和航','女',22,'云南昆明','15094261268');	
insert into tb_student value('1743205000013','17A','孙玉','女',21,'云南昆明','15198830107');	
insert into tb_student value('1743205000018','17A','姜明','女',21,'云南昆明','13577423533');	
insert into tb_student value('1743205000021','17A','李伦','女',21,'云南昆明','15287302122');	
insert into tb_student value('1743205000023','17A','殷艳娇','女',21,'云南昆明','15087346377');	
insert into tb_student value('1743205000019','17A','王晓颖','女',21,'云南昆明','13769514948');	
insert into tb_student value('1743205000028','17A','杨紫依','女',21,'云南昆明','18725353927');	
insert into tb_student value('1743205000031','17A','罗桂婷','女',21,'云南昆明','18314278548');	
insert into tb_student value('1743205000032','17A','杨婷','女',21,'云南昆明','18725353927');	
insert into tb_student value('1743205000033','17A','张美佳','女',21,'云南昆明','18306988472');	
insert into tb_student value('1743205000034','17A','姚晓露','女',21,'云南昆明','18313487887');	
insert into tb_student value('1743205000002','17A','陈盈旭','男',22,'云南昆明','13330442338');	
insert into tb_student value('1743205000010','17A','夏吉楠','男',22,'云南昆明','15087469463');	
insert into tb_student value('1743205000017','17A','陈坤美','男',22,'云南昆明','15188104694');	
insert into tb_student value('1743205000012','17A','赵海先','男',22,'云南昆明','15924841996');	
insert into tb_student value('1743205000016','17A','孔韦达','男',22,'云南昆明','18788413776');	
insert into tb_student value('1743205000026','17A','盘镇鸣','男',22,'云南昆明','13628768137');	
insert into tb_student value('1743205000037','17A','张利贤','男',22,'云南昆明','13116286265');	
insert into tb_student value('1743205000025','17A','康有进','男',22,'云南昆明','18387621834');	
insert into tb_student value('1743205000027','17A','廖世成','男',22,'云南昆明','18896359859');	
insert into tb_student value('1743205000030','17A','陈彤','男',22,'云南昆明','18469792420');	
insert into tb_student value('1743205000014','17A','王靖阳','男',22,'云南昆明','18388380125');	

insert into tb_student value('1743205000181','17B','李颖慧','女',21,'云南昆明','17787458586');	
insert into tb_student value('1743205000183','17B','马继源','女',21,'云南昆明','18387171080');	
insert into tb_student value('1743205000195','17B','尹雨凡','女',21,'云南昆明','13170715145');	
insert into tb_student value('1743205000215','17B','李玉婷','女',21,'云南昆明','13170715145');	
insert into tb_student value('1743205000182','17B','刘羽鹤','女',21,'云南昆明','18487266556');	
insert into tb_student value('1743205000185','17B','袁瑞','女',21,'云南昆明','18064887167');	
insert into tb_student value('1743205000216','17B','杨秋霞','女',21,'云南昆明','15912607714');	
insert into tb_student value('1743205000219','17B','吴晓佳','女',21,'云南昆明','17787478982');	
insert into tb_student value('1743205000194','17B','罗梅','女',21,'云南昆明','18869448782');	
insert into tb_student value('1743205000196','17B','徐安令','女',21,'云南昆明','17587007716');	
insert into tb_student value('1743205000205','17B','叶春丽','女',21,'云南昆明','15891869232');	
insert into tb_student value('1743205000208','17B','普丽清','女',21,'云南昆明','18725426992');	
insert into tb_student value('1743205000213','17B','陶扬','女',21,'云南昆明','18788082619');	
insert into tb_student value('1743205000223','17B','知识卓玛','女',21,'云南昆明','13988749364');	
insert into tb_student value('1743205000203','17B','刘粉连','女',21,'云南昆明','18213917346');	
insert into tb_student value('1743205000189','17B','彭丹','女',21,'云南昆明','15187099116');	
insert into tb_student value('1743205000199','17B','孙妙','女',21,'云南昆明','15287872238');	
insert into tb_student value('1743205000201','17B','肖忆','女',21,'云南昆明','15987480517');	
insert into tb_student value('1743205000207','17B','许娅玲','女',21,'云南昆明','18487715613');	
insert into tb_student value('1743205000217','17B','赵蓉','女',21,'云南昆明','15125220240');	
insert into tb_student value('1743205000221','17B','迪机竹玛','女',21,'云南昆明','15559818685');	
insert into tb_student value('1743205000190','17B','邓绪','男',22,'云南昆明','17868974107');	
insert into tb_student value('1743205000191','17B','马举令','男',22,'云南昆明','13187555910');	
insert into tb_student value('1743205000197','17B','朱蒙','男',22,'云南昆明','17787274262');	
insert into tb_student value('1743205000202','17B','范林','男',22,'云南昆明','17787474585');	
insert into tb_student value('1743205000211','17B','张丁','男',22,'云南昆明','13577684424');	
insert into tb_student value('1743205000218','17B','蒋明飞','男',22,'云南昆明','15770314191');	
insert into tb_student value('1743205000188','17B','余国君','男',22,'云南昆明','15198734072');	
insert into tb_student value('1743205000192','17B','陈和雨','男',22,'云南昆明','13578031187');	
insert into tb_student value('1743205000193','17B','周盼','男',22,'云南昆明','18508804692');	
insert into tb_student value('1743205000209','17B','陈建振','男',22,'云南昆明','18213684510');	
insert into tb_student value('1743205000210','17B','李金康','男',22,'云南昆明','13987320703');	
insert into tb_student value('1743205000222','17B','王玉棋','男',22,'云南昆明','18808856713');	
insert into tb_student value('1743205000180','17B','葛云枫','男',22,'云南昆明','13512614019');	
insert into tb_student value('1743205000186','17B','李润','男',22,'云南昆明','15198714850');	
insert into tb_student value('1743205000198','17B','侯智斌','男',22,'云南昆明','18388861529');	
insert into tb_student value('1743205000214','17B','张磊','男',22,'云南昆明','18314266427');	
insert into tb_student value('1743205000179','17B','毛宏扬','男',22,'云南昆明','17787145219');	
insert into tb_student value('1743205000184','17B','李柏岳','男',22,'云南昆明','13888709917');	
insert into tb_student value('1743205000200','17B','徐扣章','男',22,'云南昆明','15188142161');	
insert into tb_student value('1743205000204','17B','许文','男',22,'云南昆明','13987858691');	
insert into tb_student value('1743205000187','17B','王登雄','男',22,'云南昆明','13099982859');	
insert into tb_student value('1743205000206','17B','刘海军','男',22,'云南昆明','13887726087');	
insert into tb_student value('1743205000220','17B','刘万宁','男',22,'云南昆明','15908874460');	

insert into tb_student value('1723205000001','17F','施丽娜','女',22,'云南昆明','18100881512');	
insert into tb_student value('1723205000002','17F','陈亚梅','女',22,'云南昆明','18487181676');	
insert into tb_student value('1723205000003','17F','谭文静','女',22,'云南昆明','18487163601');	
insert into tb_student value('1723205000006','17F','周娣','女',22,'云南昆明','15559659014');	
insert into tb_student value('1723205000007','17F','向甜瑶','女',22,'云南昆明','18388430748');	
insert into tb_student value('1723205000011','17F','罗志英','女',22,'云南昆明','18388471569');	
insert into tb_student value('1723205000012','17F','刘林聪','女',22,'云南昆明','18487185726');	
insert into tb_student value('1723205000013','17F','王韵岚','女',22,'云南昆明','15969431086');	
insert into tb_student value('1723205000015','17F','刘会琴','女',22,'云南昆明','18787463484');	
insert into tb_student value('1723205000016','17F','郭娜','女',22,'云南昆明','18388147309');	
insert into tb_student value('1723205000017','17F','李可欣','女',22,'云南昆明','13987788713');	
insert into tb_student value('1723205000018','17F','罗玉乔','女',22,'云南昆明','18487087741');	
insert into tb_student value('1723205000019','17F','王云俊','女',22,'云南昆明','18468213940');	
insert into tb_student value('1723205000022','17F','黄玲','女',22,'云南昆明','18487208933');	
insert into tb_student value('1723205000024','17F','花卉','女',22,'云南昆明','15284455778');	
insert into tb_student value('1723205000025','17F','和晓梅','女',22,'云南昆明','13238685032');	
insert into tb_student value('1723205000027','17F','朱单','女',22,'云南昆明','13629684128');	
insert into tb_student value('1723205000028','17F','伊雪飞','女',22,'云南昆明','15969425405');	
insert into tb_student value('1723205000030','17F','任春桦','女',22,'云南昆明','18469139556');	
insert into tb_student value('1723205000031','17F','郑洋','女',22,'云南昆明','18468016052');	
insert into tb_student value('1723205000034','17F','李雅倩','女',22,'云南昆明','13354601916');	
insert into tb_student value('1723205000035','17F','任莹','女',22,'云南昆明','18788153205');	
insert into tb_student value('1723205000036','17F','张凝慧','女',22,'云南昆明','18487185670');	
insert into tb_student value('1723205000043','17F','熊秋娣','女',22,'云南昆明','18387059657');	
insert into tb_student value('1723205000044','17F','沈绍润','女',22,'云南昆明','18214240646');	
insert into tb_student value('1723205000045','17F','和万良','女',22,'云南昆明','15770255782');	
insert into tb_student value('1723205000046','17F','王敏','女',22,'云南昆明','13638882319');	
insert into tb_student value('1723205000047','17F','艾丽华','女',22,'云南昆明','13095208728');	
insert into tb_student value('1723205000048','17F','李迪','女',22,'云南昆明','18869740002');	
insert into tb_student value('1723205000049','17F','胡蓉','女',22,'云南昆明','15187930346');	
insert into tb_student value('1723205000050','17F','罗云乔','女',22,'云南昆明','18869702217');	
insert into tb_student value('1723205000051','17F','何集琼','女',22,'云南昆明','18487733964');	
insert into tb_student value('1723205000052','17F','赵新','女',22,'云南昆明','15750315868');	
insert into tb_student value('1723205000053','17F','朱正梅','女',22,'云南昆明','18487247321');	
insert into tb_student value('1723205000054','17F','李韩娟','女',22,'云南昆明','15750281179');	
insert into tb_student value('1723205000055','17F','朱丽玲','女',22,'云南昆明','18469337826');	
insert into tb_student value('1723205000056','17F','陶跃','女',22,'云南昆明','15750300740');	
insert into tb_student value('1723205000057','17F','陈佳','女',22,'云南昆明','15758208739');	
insert into tb_student value('1723205000058','17F','杨丽萍','女',22,'云南昆明','18487096157');	
insert into tb_student value('1723205000059','17F','倪云丽','女',22,'云南昆明','15108743539');	
insert into tb_student value('1723205000060','17F','张龄丹','女',22,'云南昆明','18887046851');	
insert into tb_student value('1723205000061','17F','刘梦欣','女',22,'云南昆明','18313707636');	
insert into tb_student value('1723205000062','17F','董佳','女',22,'云南昆明','15908806451');	
insert into tb_student value('1723205000063','17F','李文红','女',22,'云南昆明','13577536040');	
insert into tb_student value('1723205000065','17F','彭春秀','女',22,'云南昆明','18487130229');	
insert into tb_student value('1723205000067','17F','陈会','女',22,'云南昆明','13578236886');	
insert into tb_student value('1723205000069','17F','钏仕飘','女',22,'云南昆明','13778255812');	
insert into tb_student value('1723205000071','17F','汪武芸','女',22,'云南昆明','18408885886');	
insert into tb_student value('1723205000072','17F','杨涛','女',22,'云南昆明','18869044368');	
insert into tb_student value('1723205000023','17F','佘斌维','男',21,'云南昆明','18487181904');	
insert into tb_student value('1723205000026','17F','雷博程','男',21,'云南昆明','18288658103');	
insert into tb_student value('1723205000029','17F','张睿超','男',21,'云南昆明','18468048246');	
insert into tb_student value('1723205000032','17F','王朴云','男',21,'云南昆明','18213430084');	
insert into tb_student value('1723205000033','17F','赛旭辉','男',21,'云南昆明','15559787017');	
insert into tb_student value('1723205000037','17F','李有兵','男',21,'云南昆明','18469136229');	
insert into tb_student value('1723205000038','17F','张旺','男',21,'云南昆明','15288365300');	
insert into tb_student value('1723205000039','17F','陈光龙','男',21,'云南昆明','18487266634');	
insert into tb_student value('1723205000040','17F','倪燕刚','男',21,'云南昆明','15587188038');	
insert into tb_student value('1723205000041','17F','罗筱同','男',21,'云南昆明','13987618388');	
insert into tb_student value('1723205000042','17F','吕昌俊','男',21,'云南昆明','18487199784');	
insert into tb_student value('1723205000068','17F','雷伟','男',21,'云南昆明','13578250016');	
insert into tb_student value('1723205000070','17F','牛金城','男',21,'云南昆明','13769807442');	
insert into tb_student value('1723205000004','17F','吕猛','男',21,'云南昆明','13408777953');	
insert into tb_student value('1723205000005','17F','刘德基','男',21,'云南昆明','18082757759');	
insert into tb_student value('1723205000008','17F','杨亚','男',21,'云南昆明','15894549490');	
insert into tb_student value('1723205000009','17F','陈刘明','男',21,'云南昆明','18206774231');	
insert into tb_student value('1723205000010','17F','韩振','男',21,'云南昆明','18388424795');	
insert into tb_student value('1723205000014','17F','李仁智','男',21,'云南昆明','13608876831');	
insert into tb_student value('1723205000020','17F','蜂铁','男',21,'云南昆明','15887815791');	
insert into tb_student value('1723205000021','17F','谢红超','男',21,'云南昆明','18388424049');	

insert into tb_student value('1843205000149','18A','何颖','男',22,'云南昆明','17787475602');	
insert into tb_student value('1843205000155','18A','代源红','男',22,'云南昆明','13769744006');	
insert into tb_student value('1843205000157','18A','孔东蕊','男',22,'云南昆明','15087497593');	
insert into tb_student value('1843205000173','18A','田敏','男',22,'云南昆明','18314268304');	
insert into tb_student value('1843205000150','18A','吴文其','女',21,'云南昆明','18889372351');	
insert into tb_student value('1843205000158','18A','吴凤明','女',21,'云南昆明','15912002018');	
insert into tb_student value('1843205000159','18A','孙彩艳','女',21,'云南昆明','18213034641');	
insert into tb_student value('1843205000171','18A','董敏','男',22,'云南昆明','18314027692');	
insert into tb_student value('1843205000160','18A','陶怡君','女',21,'云南昆明','18687441834');	
insert into tb_student value('1843205000161','18A','赵红雨','女',21,'云南昆明','18388337812');	
insert into tb_student value('1843205000162','18A','尚照清','女',21,'云南昆明','18213188225');	
insert into tb_student value('1843205000168','18A','王雪','男',22,'云南昆明','18214131537');	
insert into tb_student value('1843205000169','18A','李彦','男',22,'云南昆明','18387301502');	
insert into tb_student value('1843205000174','18A','史洁','男',22,'云南昆明','18313171529');	
insert into tb_student value('1843205000163','18A','蔡霜','男',22,'云南昆明','15974636728');	
insert into tb_student value('1843205000164','18A','王晓蓉','男',22,'云南昆明','15911926248');	
insert into tb_student value('1843205000167','18A','吕雨霏','男',22,'云南昆明','15825127329');	
insert into tb_student value('1843205000170','18A','李桂林','男',22,'云南昆明','15287371156');	
insert into tb_student value('1843205000175','18A','王赛','男',22,'云南昆明','18213407718');	
insert into tb_student value('1843205000176','18A','熊润红','女',21,'云南昆明','17787470235');	
insert into tb_student value('1843205000178','18A','张国芹','女',21,'云南昆明','18313950340');	

insert into tb_student value('1843205000039','18B','孔艺铮','女',21,'云南昆明','17787472775');	
insert into tb_student value('1843205000045','18B','王廷琴','女',21,'云南昆明','18869534901');	
insert into tb_student value('1843205000049','18B','张婷','女',21,'云南昆明','15187423734');	
insert into tb_student value('1843205000067','18B','李佩姿','女',21,'云南昆明','18597106256');	
insert into tb_student value('1843205000040','18B','曾岚岚','女',21,'云南昆明','17787475797');	
insert into tb_student value('1843205000042','18B','尹佳莲','女',21,'云南昆明','15288189840');	
insert into tb_student value('1843205000050','18B','钱静怡','女',21,'云南昆明','15087495854');	
insert into tb_student value('1843205000068','18B','阿下','女',21,'云南昆明','18487142433');	
insert into tb_student value('1843205000043','18B','张兴秀','女',21,'云南昆明','18214220173');	
insert into tb_student value('1843205000047','18B','王婷','女',21,'云南昆明','15912007539');	
insert into tb_student value('1843205000053','18B','李茂','女',21,'云南昆明','18487152504');	
insert into tb_student value('1843205000064','18B','朱红琴','女',21,'云南昆明','15894543528');	
insert into tb_student value('1843205000066','18B','刘玲艳','女',21,'云南昆明','18468183092');	
insert into tb_student value('1843205000046','18B','刘丽萍','女',21,'云南昆明','13638854296');	
insert into tb_student value('1843205000048','18B','孙雯','女',21,'云南昆明','18313596621');	
insert into tb_student value('1843205000051','18B','魏红','女',21,'云南昆明','15188007967');	
insert into tb_student value('1843205000054','18B','俞泽源','女',21,'云南昆明','18313533855');	
insert into tb_student value('1843205000056','18B','周娟','女',21,'云南昆明','18487216895');	
insert into tb_student value('1843205000060','18B','杨丽雪','女',21,'云南昆明','15758510967');	
insert into tb_student value('1843205000055','18B','吴欣雨','女',21,'云南昆明','18168278843');	
insert into tb_student value('1843205000058','18B','万春艳','女',21,'云南昆明','15184897060');	
insert into tb_student value('1843205000059','18B','李晓艳','女',21,'云南昆明','18787889422');	
insert into tb_student value('1843205000061','18B','余纹影','女',21,'云南昆明','18214127036');	
insert into tb_student value('1843205000062','18B','管世瑞','女',21,'云南昆明','18388644393');	
insert into tb_student value('1843205000065','18B','杨炳锐','女',21,'云南昆明','18487148365');	

insert into tb_student value('1843205000069','18F','林启莎','女',21,'云南昆明','18083699717');	
insert into tb_student value('1843205000073','18F','肖梦园','女',21,'云南昆明','15288399295');	
insert into tb_student value('1843205000077','18F','张蕊','女',21,'云南昆明','15187845625');	
insert into tb_student value('1843205000080','18F','金艾','女',21,'云南昆明','17787282360');	
insert into tb_student value('1843205000091','18F','鲁金凤','女',21,'云南昆明','15894520324');	
insert into tb_student value('1843205000093','18F','张李涵','女',21,'云南昆明','17387742490');	
insert into tb_student value('1843205000070','18F','何德芬','女',21,'云南昆明','15885214690');	
insert into tb_student value('1843205000079','18F','赵娅','女',21,'云南昆明','15825025638');	
insert into tb_student value('1843205000081','18F','王春燕','女',21,'云南昆明','13577443497');	
insert into tb_student value('1843205000092','18F','马金秀','女',21,'云南昆明','18487243580');	
insert into tb_student value('1843205000094','18F','何国林','女',21,'云南昆明','18869014601');	
insert into tb_student value('1843205000097','18F','张鑫玮','女',21,'云南昆明','13997093418');
insert into tb_student value('1843205000075','18F','许银中','男',22,'云南昆明','13759432407');	
insert into tb_student value('1843205000076','18F','邓江林','男',22,'云南昆明','18468235150');	
insert into tb_student value('1843205000083','18F','林鹏','男',22,'云南昆明','18487121290');	
insert into tb_student value('1843205000086','18F','王悦衡','男',22,'云南昆明','18787795256');	
insert into tb_student value('1843205000088','18F','郎富喜','男',22,'云南昆明','13404917763');	
insert into tb_student value('1843205000095','18F','鲁文斌','男',22,'云南昆明','18468264694');	
insert into tb_student value('1843205000071','18F','陈鑫','男',22,'云南昆明','17687127475');	
insert into tb_student value('1843205000082','18F','张红松','男',22,'云南昆明','18760800059');	
insert into tb_student value('1843205000085','18F','曲志良','男',22,'云南昆明','15393906965');	
insert into tb_student value('1843205000087','18F','高星瑞','男',22,'云南昆明','18287713219');	
insert into tb_student value('1843205000072','18F','石耀','男',22,'云南昆明','15912406504');	
insert into tb_student value('1843205000089','18F','刘庆国','男',22,'云南昆明','14787286068');	
insert into tb_student value('1843205000090','18F','王寅曦','男',22,'云南昆明','18387267351');	
insert into tb_student value('1843205000098','18F','贺庭瑞','男',22,'云南昆明','18487306628');	
insert into tb_student value('1843205000074','18F','陈浩洋','男',22,'云南昆明','18687830406');	
insert into tb_student value('1843205000084','18F','张祥','男',22,'云南昆明','18487081513');	
insert into tb_student value('1843205000096','18F','罗应成','男',22,'云南昆明','15287608468');	


					
create table tb_subject(
	subID varchar(20) primary key,
	subject varchar(40),
	kindID varchar(20),
	foreign key(kindID) references tb_examkind(kindID)
);

insert into tb_subject value('subject1','软件工程导论','kind1');
insert into tb_subject value('subject2','模式识别','kind1');
insert into tb_subject value('subject3','计算机组成原理','kind1');
insert into tb_subject value('subject4','算法分析与设计','kind2');
insert into tb_subject value('subject5','计算机网络','kind2');
insert into tb_subject value('subject6','编译原理','kind1');
insert into tb_subject value('subject7','人工智能导论','kind1');
insert into tb_subject value('subject8','python程序设计语言','kind3');
insert into tb_subject value('subject9','线性代数','kind3');

create table tb_grade_sub(
	stuID varchar(20),
	stuName varchar(20),
	kindID varchar(20),
	subID varchar(20),
	grade double,
	examDate timestamp,
	classID varchar(20),
	primary key(stuID,kindID,subID),
	foreign key(kindID) references tb_examkind(kindID),
	foreign key(subID) references tb_subject(subID),
	foreign key(stuID) references tb_student(stuID)
);

insert into tb_grade_sub value('1543205000001','魏梓泉','kind1','subject1',99,null,'15A');
insert into tb_grade_sub value('1543205000001','魏梓泉','kind1','subject2',99,null,'15A');
insert into tb_grade_sub value('1543205000001','魏梓泉','kind1','subject3',99,null,'15A');
insert into tb_grade_sub value('1543205000001','魏梓泉','kind2','subject4',99,null,'15A');
insert into tb_grade_sub value('1543205000001','魏梓泉','kind2','subject5',99,null,'15A');
insert into tb_grade_sub value('1543205000001','魏梓泉','kind1','subject6',99,null,'15A');
insert into tb_grade_sub value('1543205000001','魏梓泉','kind1','subject7',99,null,'15A');
insert into tb_grade_sub value('1543205000001','魏梓泉','kind3','subject8',99,null,'15A');
insert into tb_grade_sub value('1543205000001','魏梓泉','kind3','subject9',99,null,'15A');

insert into tb_grade_sub value('1543205000016','陆雪静','kind1','subject1',84,null,'15A');
insert into tb_grade_sub value('1543205000016','陆雪静','kind1','subject2',85,null,'15A');
insert into tb_grade_sub value('1543205000016','陆雪静','kind1','subject3',86,null,'15A');
insert into tb_grade_sub value('1543205000016','陆雪静','kind2','subject4',83,null,'15A');
insert into tb_grade_sub value('1543205000016','陆雪静','kind2','subject5',81,null,'15A');
insert into tb_grade_sub value('1543205000016','陆雪静','kind1','subject6',82,null,'15A');
insert into tb_grade_sub value('1543205000016','陆雪静','kind1','subject7',87,null,'15A');
insert into tb_grade_sub value('1543205000016','陆雪静','kind3','subject8',89,null,'15A');
insert into tb_grade_sub value('1543205000016','陆雪静','kind3','subject9',88,null,'15A');

insert into tb_grade_sub value('1543205000033','师妍','kind1','subject1',91,null,'15A');
insert into tb_grade_sub value('1543205000033','师妍','kind1','subject2',92,null,'15A');
insert into tb_grade_sub value('1543205000033','师妍','kind1','subject3',93,null,'15A');
insert into tb_grade_sub value('1543205000033','师妍','kind2','subject4',94,null,'15A');
insert into tb_grade_sub value('1543205000033','师妍','kind2','subject5',95,null,'15A');
insert into tb_grade_sub value('1543205000033','师妍','kind1','subject6',96,null,'15A');
insert into tb_grade_sub value('1543205000033','师妍','kind1','subject7',97,null,'15A');
insert into tb_grade_sub value('1543205000033','师妍','kind3','subject8',98,null,'15A');
insert into tb_grade_sub value('1543205000033','师妍','kind3','subject9',99,null,'15A');


insert into tb_grade_sub value('1543205000213','邱美华','kind1','subject1',59,null,'15B');
insert into tb_grade_sub value('1543205000213','邱美华','kind1','subject2',62,null,'15B');
insert into tb_grade_sub value('1543205000213','邱美华','kind1','subject3',86,null,'15B');
insert into tb_grade_sub value('1543205000213','邱美华','kind2','subject4',85,null,'15B');
insert into tb_grade_sub value('1543205000213','邱美华','kind2','subject5',84,null,'15B');
insert into tb_grade_sub value('1543205000213','邱美华','kind1','subject6',90,null,'15B');
insert into tb_grade_sub value('1543205000213','邱美华','kind1','subject7',93,null,'15B');
insert into tb_grade_sub value('1543205000213','邱美华','kind3','subject8',92,null,'15B');
insert into tb_grade_sub value('1543205000213','邱美华','kind3','subject9',91,null,'15B');

insert into tb_grade_sub value('1543205000181','陈安珂','kind1','subject1',90,null,'15B');
insert into tb_grade_sub value('1543205000181','陈安珂','kind1','subject2',93,null,'15B');
insert into tb_grade_sub value('1543205000181','陈安珂','kind1','subject3',92,null,'15B');
insert into tb_grade_sub value('1543205000181','陈安珂','kind2','subject4',91,null,'15B');
insert into tb_grade_sub value('1543205000181','陈安珂','kind2','subject5',59,null,'15B');
insert into tb_grade_sub value('1543205000181','陈安珂','kind1','subject6',62,null,'15B');
insert into tb_grade_sub value('1543205000181','陈安珂','kind1','subject7',86,null,'15B');
insert into tb_grade_sub value('1543205000181','陈安珂','kind3','subject8',85,null,'15B');
insert into tb_grade_sub value('1543205000181','陈安珂','kind3','subject9',84,null,'15B');

insert into tb_grade_sub value('1543205000180','卢超宇','kind1','subject1',81,null,'15B');
insert into tb_grade_sub value('1543205000180','卢超宇','kind1','subject2',82,null,'15B');
insert into tb_grade_sub value('1543205000180','卢超宇','kind1','subject3',83,null,'15B');
insert into tb_grade_sub value('1543205000180','卢超宇','kind2','subject4',84,null,'15B');
insert into tb_grade_sub value('1543205000180','卢超宇','kind2','subject5',85,null,'15B');
insert into tb_grade_sub value('1543205000180','卢超宇','kind1','subject6',86,null,'15B');
insert into tb_grade_sub value('1543205000180','卢超宇','kind1','subject7',87,null,'15B');
insert into tb_grade_sub value('1543205000180','卢超宇','kind3','subject8',88,null,'15B');
insert into tb_grade_sub value('1543205000180','卢超宇','kind3','subject9',89,null,'15B');


insert into tb_grade_sub value('1543205000139','卢庭玉','kind1','subject1',85,null,'15F');
insert into tb_grade_sub value('1543205000139','卢庭玉','kind1','subject2',85,null,'15F');
insert into tb_grade_sub value('1543205000139','卢庭玉','kind1','subject3',85,null,'15F');
insert into tb_grade_sub value('1543205000139','卢庭玉','kind2','subject4',85,null,'15F');
insert into tb_grade_sub value('1543205000139','卢庭玉','kind2','subject5',84,null,'15F');
insert into tb_grade_sub value('1543205000139','卢庭玉','kind1','subject6',83,null,'15F');
insert into tb_grade_sub value('1543205000139','卢庭玉','kind1','subject7',86,null,'15F');
insert into tb_grade_sub value('1543205000139','卢庭玉','kind3','subject8',81,null,'15F');
insert into tb_grade_sub value('1543205000139','卢庭玉','kind3','subject9',82,null,'15F');

insert into tb_grade_sub value('1543205000147','周玉婷','kind1','subject1',88,null,'15F');
insert into tb_grade_sub value('1543205000147','周玉婷','kind1','subject2',88,null,'15F');
insert into tb_grade_sub value('1543205000147','周玉婷','kind1','subject3',88,null,'15F');
insert into tb_grade_sub value('1543205000147','周玉婷','kind2','subject4',88,null,'15F');
insert into tb_grade_sub value('1543205000147','周玉婷','kind2','subject5',79,null,'15F');
insert into tb_grade_sub value('1543205000147','周玉婷','kind1','subject6',78,null,'15F');
insert into tb_grade_sub value('1543205000147','周玉婷','kind1','subject7',77,null,'15F');
insert into tb_grade_sub value('1543205000147','周玉婷','kind3','subject8',79,null,'15F');
insert into tb_grade_sub value('1543205000147','周玉婷','kind3','subject9',85,null,'15F');

insert into tb_grade_sub value('1543205000140','黄欣','kind1','subject1',78,null,'15F');
insert into tb_grade_sub value('1543205000140','黄欣','kind1','subject2',77,null,'15F');
insert into tb_grade_sub value('1543205000140','黄欣','kind1','subject3',79,null,'15F');
insert into tb_grade_sub value('1543205000140','黄欣','kind2','subject4',85,null,'15F');
insert into tb_grade_sub value('1543205000140','黄欣','kind2','subject5',79,null,'15F');
insert into tb_grade_sub value('1543205000140','黄欣','kind1','subject6',82,null,'15F');
insert into tb_grade_sub value('1543205000140','黄欣','kind1','subject7',83,null,'15F');
insert into tb_grade_sub value('1543205000140','黄欣','kind3','subject8',84,null,'15F');
insert into tb_grade_sub value('1543205000140','黄欣','kind3','subject9',85,null,'15F');

insert into tb_grade_sub value('1643205000007','冯慢','kind1','subject1',94,null,'16A');
insert into tb_grade_sub value('1643205000007','冯慢','kind1','subject2',85,null,'16A');
insert into tb_grade_sub value('1643205000007','冯慢','kind1','subject3',89,null,'16A');
insert into tb_grade_sub value('1643205000007','冯慢','kind2','subject4',84,null,'16A');
insert into tb_grade_sub value('1643205000007','冯慢','kind2','subject5',86,null,'16A');
insert into tb_grade_sub value('1643205000007','冯慢','kind1','subject6',89,null,'16A');
insert into tb_grade_sub value('1643205000007','冯慢','kind1','subject7',94,null,'16A');
insert into tb_grade_sub value('1643205000007','冯慢','kind3','subject8',90,null,'16A');
insert into tb_grade_sub value('1643205000007','冯慢','kind3','subject9',92,null,'16A');

insert into tb_grade_sub value('1643205000027','杨玺悦','kind1','subject1',86,null,'16A');
insert into tb_grade_sub value('1643205000027','杨玺悦','kind1','subject2',85,null,'16A');
insert into tb_grade_sub value('1643205000027','杨玺悦','kind1','subject3',84,null,'16A');
insert into tb_grade_sub value('1643205000027','杨玺悦','kind2','subject4',87,null,'16A');
insert into tb_grade_sub value('1643205000027','杨玺悦','kind2','subject5',86,null,'16A');
insert into tb_grade_sub value('1643205000027','杨玺悦','kind1','subject6',89,null,'16A');
insert into tb_grade_sub value('1643205000027','杨玺悦','kind1','subject7',94,null,'16A');
insert into tb_grade_sub value('1643205000027','杨玺悦','kind3','subject8',95,null,'16A');
insert into tb_grade_sub value('1643205000027','杨玺悦','kind3','subject9',91,null,'16A');

insert into tb_grade_sub value('1643205000010','施文青','kind1','subject1',74,null,'16A');
insert into tb_grade_sub value('1643205000010','施文青','kind1','subject2',75,null,'16A');
insert into tb_grade_sub value('1643205000010','施文青','kind1','subject3',76,null,'16A');
insert into tb_grade_sub value('1643205000010','施文青','kind2','subject4',77,null,'16A');
insert into tb_grade_sub value('1643205000010','施文青','kind2','subject5',78,null,'16A');
insert into tb_grade_sub value('1643205000010','施文青','kind1','subject6',89,null,'16A');
insert into tb_grade_sub value('1643205000010','施文青','kind1','subject7',81,null,'16A');
insert into tb_grade_sub value('1643205000010','施文青','kind3','subject8',73,null,'16A');
insert into tb_grade_sub value('1643205000010','施文青','kind3','subject9',69,null,'16A');

insert into tb_grade_sub value('1643205000001','冯钧','kind1','subject1',94,null,'16A');
insert into tb_grade_sub value('1643205000001','冯钧','kind1','subject2',85,null,'16A');
insert into tb_grade_sub value('1643205000001','冯钧','kind1','subject3',89,null,'16A');
insert into tb_grade_sub value('1643205000001','冯钧','kind2','subject4',84,null,'16A');
insert into tb_grade_sub value('1643205000001','冯钧','kind2','subject5',86,null,'16A');
insert into tb_grade_sub value('1643205000001','冯钧','kind1','subject6',89,null,'16A');
insert into tb_grade_sub value('1643205000001','冯钧','kind1','subject7',92,null,'16A');
insert into tb_grade_sub value('1643205000001','冯钧','kind3','subject8',92,null,'16A');
insert into tb_grade_sub value('1643205000001','冯钧','kind3','subject9',92,null,'16A');


insert into tb_grade_sub value('1643205000220','郝旭影','kind1','subject1',99,null,'16B');
insert into tb_grade_sub value('1643205000220','郝旭影','kind1','subject2',99,null,'16B');
insert into tb_grade_sub value('1643205000220','郝旭影','kind1','subject3',99,null,'16B');
insert into tb_grade_sub value('1643205000220','郝旭影','kind2','subject4',99,null,'16B');
insert into tb_grade_sub value('1643205000220','郝旭影','kind2','subject5',99,null,'16B');
insert into tb_grade_sub value('1643205000220','郝旭影','kind1','subject6',99,null,'16B');
insert into tb_grade_sub value('1643205000220','郝旭影','kind1','subject7',99,null,'16B');
insert into tb_grade_sub value('1643205000220','郝旭影','kind3','subject8',99,null,'16B');
insert into tb_grade_sub value('1643205000220','郝旭影','kind3','subject9',99,null,'16B');

insert into tb_grade_sub value('1643205000246','刘琼','kind1','subject1',95,null,'16B');
insert into tb_grade_sub value('1643205000246','刘琼','kind1','subject2',89,null,'16B');
insert into tb_grade_sub value('1643205000246','刘琼','kind1','subject3',91,null,'16B');
insert into tb_grade_sub value('1643205000246','刘琼','kind2','subject4',85,null,'16B');
insert into tb_grade_sub value('1643205000246','刘琼','kind2','subject5',89,null,'16B');
insert into tb_grade_sub value('1643205000246','刘琼','kind1','subject6',90,null,'16B');
insert into tb_grade_sub value('1643205000246','刘琼','kind1','subject7',95,null,'16B');
insert into tb_grade_sub value('1643205000246','刘琼','kind3','subject8',95,null,'16B');
insert into tb_grade_sub value('1643205000246','刘琼','kind3','subject9',95,null,'16B');

insert into tb_grade_sub value('1643205000244','尹丹','kind1','subject1',94,null,'16B');
insert into tb_grade_sub value('1643205000244','尹丹','kind1','subject2',85,null,'16B');
insert into tb_grade_sub value('1643205000244','尹丹','kind1','subject3',89,null,'16B');
insert into tb_grade_sub value('1643205000244','尹丹','kind2','subject4',84,null,'16B');
insert into tb_grade_sub value('1643205000244','尹丹','kind2','subject5',86,null,'16B');
insert into tb_grade_sub value('1643205000244','尹丹','kind1','subject6',89,null,'16B');
insert into tb_grade_sub value('1643205000244','尹丹','kind1','subject7',92,null,'16B');
insert into tb_grade_sub value('1643205000244','尹丹','kind3','subject8',92,null,'16B');
insert into tb_grade_sub value('1643205000244','尹丹','kind3','subject9',92,null,'16B');

insert into tb_grade_sub value('1643205000228','张玲莉','kind1','subject1',94,null,'16B');
insert into tb_grade_sub value('1643205000228','张玲莉','kind1','subject2',88,null,'16B');
insert into tb_grade_sub value('1643205000228','张玲莉','kind1','subject3',90,null,'16B');
insert into tb_grade_sub value('1643205000228','张玲莉','kind2','subject4',84,null,'16B');
insert into tb_grade_sub value('1643205000228','张玲莉','kind2','subject5',88,null,'16B');
insert into tb_grade_sub value('1643205000228','张玲莉','kind1','subject6',89,null,'16B');
insert into tb_grade_sub value('1643205000228','张玲莉','kind1','subject7',94,null,'16B');
insert into tb_grade_sub value('1643205000228','张玲莉','kind3','subject8',94,null,'16B');
insert into tb_grade_sub value('1643205000228','张玲莉','kind3','subject9',94,null,'16B');

insert into tb_grade_sub value('1643205000238','恭子玲','kind1','subject1',94,null,'16B');
insert into tb_grade_sub value('1643205000238','恭子玲','kind1','subject2',87,null,'16B');
insert into tb_grade_sub value('1643205000238','恭子玲','kind1','subject3',89,null,'16B');
insert into tb_grade_sub value('1643205000238','恭子玲','kind2','subject4',83,null,'16B');
insert into tb_grade_sub value('1643205000238','恭子玲','kind2','subject5',87,null,'16B');
insert into tb_grade_sub value('1643205000238','恭子玲','kind1','subject6',88,null,'16B');
insert into tb_grade_sub value('1643205000238','恭子玲','kind1','subject7',93,null,'16B');
insert into tb_grade_sub value('1643205000238','恭子玲','kind3','subject8',93,null,'16B');
insert into tb_grade_sub value('1643205000238','恭子玲','kind3','subject9',93,null,'16B');

insert into tb_grade_sub value('1643205000236','张浩','kind1','subject1',99,null,'16B');
insert into tb_grade_sub value('1643205000236','张浩','kind1','subject2',67,null,'16B');
insert into tb_grade_sub value('1643205000236','张浩','kind1','subject3',84,null,'16B');
insert into tb_grade_sub value('1643205000236','张浩','kind2','subject4',83,null,'16B');
insert into tb_grade_sub value('1643205000236','张浩','kind2','subject5',81,null,'16B');
insert into tb_grade_sub value('1643205000236','张浩','kind1','subject6',93,null,'16B');
insert into tb_grade_sub value('1643205000236','张浩','kind1','subject7',89,null,'16B');
insert into tb_grade_sub value('1643205000236','张浩','kind3','subject8',89,null,'16B');
insert into tb_grade_sub value('1643205000236','张浩','kind3','subject9',89,null,'16B');

insert into tb_grade_sub value('1643205000245','叶梦娇','kind1','subject1',98,null,'16B');
insert into tb_grade_sub value('1643205000245','叶梦娇','kind1','subject2',66,null,'16B');
insert into tb_grade_sub value('1643205000245','叶梦娇','kind1','subject3',83,null,'16B');
insert into tb_grade_sub value('1643205000245','叶梦娇','kind2','subject4',82,null,'16B');
insert into tb_grade_sub value('1643205000245','叶梦娇','kind2','subject5',82,null,'16B');
insert into tb_grade_sub value('1643205000245','叶梦娇','kind1','subject6',92,null,'16B');
insert into tb_grade_sub value('1643205000245','叶梦娇','kind1','subject7',88,null,'16B');
insert into tb_grade_sub value('1643205000245','叶梦娇','kind3','subject8',88,null,'16B');
insert into tb_grade_sub value('1643205000245','叶梦娇','kind3','subject9',88,null,'16B');

insert into tb_grade_sub value('1643205000235','蔡万刚','kind1','subject1',97,null,'16B');
insert into tb_grade_sub value('1643205000235','蔡万刚','kind1','subject2',67,null,'16B');
insert into tb_grade_sub value('1643205000235','蔡万刚','kind1','subject3',82,null,'16B');
insert into tb_grade_sub value('1643205000235','蔡万刚','kind2','subject4',89,null,'16B');
insert into tb_grade_sub value('1643205000235','蔡万刚','kind2','subject5',82,null,'16B');
insert into tb_grade_sub value('1643205000235','蔡万刚','kind1','subject6',83,null,'16B');
insert into tb_grade_sub value('1643205000235','蔡万刚','kind1','subject7',89,null,'16B');
insert into tb_grade_sub value('1643205000235','蔡万刚','kind3','subject8',89,null,'16B');
insert into tb_grade_sub value('1643205000235','蔡万刚','kind3','subject9',89,null,'16B');

insert into tb_grade_sub value('1643205000258','江文','kind1','subject1',96,null,'16B');
insert into tb_grade_sub value('1643205000258','江文','kind1','subject2',66,null,'16B');
insert into tb_grade_sub value('1643205000258','江文','kind1','subject3',81,null,'16B');
insert into tb_grade_sub value('1643205000258','江文','kind2','subject4',88,null,'16B');
insert into tb_grade_sub value('1643205000258','江文','kind2','subject5',81,null,'16B');
insert into tb_grade_sub value('1643205000258','江文','kind1','subject6',82,null,'16B');
insert into tb_grade_sub value('1643205000258','江文','kind1','subject7',88,null,'16B');
insert into tb_grade_sub value('1643205000258','江文','kind3','subject8',88,null,'16B');
insert into tb_grade_sub value('1643205000258','江文','kind3','subject9',88,null,'16B');

insert into tb_grade_sub value('1643205000260','李润梅','kind1','subject1',95,null,'16B');
insert into tb_grade_sub value('1643205000260','李润梅','kind1','subject2',64,null,'16B');
insert into tb_grade_sub value('1643205000260','李润梅','kind1','subject3',80,null,'16B');
insert into tb_grade_sub value('1643205000260','李润梅','kind2','subject4',87,null,'16B');
insert into tb_grade_sub value('1643205000260','李润梅','kind2','subject5',80,null,'16B');
insert into tb_grade_sub value('1643205000260','李润梅','kind1','subject6',81,null,'16B');
insert into tb_grade_sub value('1643205000260','李润梅','kind1','subject7',87,null,'16B');
insert into tb_grade_sub value('1643205000260','李润梅','kind3','subject8',87,null,'16B');
insert into tb_grade_sub value('1643205000260','李润梅','kind3','subject9',87,null,'16B');

insert into tb_grade_sub value('1643205000239','华婷','kind1','subject1',82.1,null,'16B');
insert into tb_grade_sub value('1643205000239','华婷','kind1','subject2',82.1,null,'16B');
insert into tb_grade_sub value('1643205000239','华婷','kind1','subject3',82.1,null,'16B');
insert into tb_grade_sub value('1643205000239','华婷','kind2','subject4',82.1,null,'16B');
insert into tb_grade_sub value('1643205000239','华婷','kind2','subject5',82.1,null,'16B');
insert into tb_grade_sub value('1643205000239','华婷','kind1','subject6',82.1,null,'16B');
insert into tb_grade_sub value('1643205000239','华婷','kind1','subject7',82.1,null,'16B');
insert into tb_grade_sub value('1643205000239','华婷','kind3','subject8',82.1,null,'16B');
insert into tb_grade_sub value('1643205000239','华婷','kind3','subject9',82.1,null,'16B');

insert into tb_grade_sub value('1643205000221','俞志丽','kind1','subject1',82,null,'16B');
insert into tb_grade_sub value('1643205000221','俞志丽','kind1','subject2',82,null,'16B');
insert into tb_grade_sub value('1643205000221','俞志丽','kind1','subject3',82,null,'16B');
insert into tb_grade_sub value('1643205000221','俞志丽','kind2','subject4',82,null,'16B');
insert into tb_grade_sub value('1643205000221','俞志丽','kind2','subject5',82,null,'16B');
insert into tb_grade_sub value('1643205000221','俞志丽','kind1','subject6',82,null,'16B');
insert into tb_grade_sub value('1643205000221','俞志丽','kind1','subject7',82,null,'16B');
insert into tb_grade_sub value('1643205000221','俞志丽','kind3','subject8',82,null,'16B');
insert into tb_grade_sub value('1643205000221','俞志丽','kind3','subject9',82,null,'16B');

insert into tb_grade_sub value('1643205000262','张晓娇','kind1','subject1',80.9,null,'16B');
insert into tb_grade_sub value('1643205000262','张晓娇','kind1','subject2',80.9,null,'16B');
insert into tb_grade_sub value('1643205000262','张晓娇','kind1','subject3',80.9,null,'16B');
insert into tb_grade_sub value('1643205000262','张晓娇','kind2','subject4',80.9,null,'16B');
insert into tb_grade_sub value('1643205000262','张晓娇','kind2','subject5',80.9,null,'16B');
insert into tb_grade_sub value('1643205000262','张晓娇','kind1','subject6',80.9,null,'16B');
insert into tb_grade_sub value('1643205000262','张晓娇','kind1','subject7',80.9,null,'16B');
insert into tb_grade_sub value('1643205000262','张晓娇','kind3','subject8',80.9,null,'16B');
insert into tb_grade_sub value('1643205000262','张晓娇','kind3','subject9',80.9,null,'16B');

insert into tb_grade_sub value('1643205000229','朱明丽','kind1','subject1',80.8,null,'16B');
insert into tb_grade_sub value('1643205000229','朱明丽','kind1','subject2',80.8,null,'16B');
insert into tb_grade_sub value('1643205000229','朱明丽','kind1','subject3',80.8,null,'16B');
insert into tb_grade_sub value('1643205000229','朱明丽','kind2','subject4',80.8,null,'16B');
insert into tb_grade_sub value('1643205000229','朱明丽','kind2','subject5',80.8,null,'16B');
insert into tb_grade_sub value('1643205000229','朱明丽','kind1','subject6',80.8,null,'16B');
insert into tb_grade_sub value('1643205000229','朱明丽','kind1','subject7',80.8,null,'16B');
insert into tb_grade_sub value('1643205000229','朱明丽','kind3','subject8',80.8,null,'16B');
insert into tb_grade_sub value('1643205000229','朱明丽','kind3','subject9',80.8,null,'16B');

insert into tb_grade_sub value('1643205000225','黄磊','kind1','subject1',80.6,null,'16B');
insert into tb_grade_sub value('1643205000225','黄磊','kind1','subject2',80.6,null,'16B');
insert into tb_grade_sub value('1643205000225','黄磊','kind1','subject3',80.6,null,'16B');
insert into tb_grade_sub value('1643205000225','黄磊','kind2','subject4',80.6,null,'16B');
insert into tb_grade_sub value('1643205000225','黄磊','kind2','subject5',80.6,null,'16B');
insert into tb_grade_sub value('1643205000225','黄磊','kind1','subject6',80.6,null,'16B');
insert into tb_grade_sub value('1643205000225','黄磊','kind1','subject7',80.6,null,'16B');
insert into tb_grade_sub value('1643205000225','黄磊','kind3','subject8',80.6,null,'16B');
insert into tb_grade_sub value('1643205000225','黄磊','kind3','subject9',80.6,null,'16B');

insert into tb_grade_sub value('1643205000251','周耀宗','kind1','subject1',80.5,null,'16B');
insert into tb_grade_sub value('1643205000251','周耀宗','kind1','subject2',80.5,null,'16B');
insert into tb_grade_sub value('1643205000251','周耀宗','kind1','subject3',80.5,null,'16B');
insert into tb_grade_sub value('1643205000251','周耀宗','kind2','subject4',80.5,null,'16B');
insert into tb_grade_sub value('1643205000251','周耀宗','kind2','subject5',80.5,null,'16B');
insert into tb_grade_sub value('1643205000251','周耀宗','kind1','subject6',80.5,null,'16B');
insert into tb_grade_sub value('1643205000251','周耀宗','kind1','subject7',80.5,null,'16B');
insert into tb_grade_sub value('1643205000251','周耀宗','kind3','subject8',80.5,null,'16B');
insert into tb_grade_sub value('1643205000251','周耀宗','kind3','subject9',80.5,null,'16B');

insert into tb_grade_sub value('1643205000242','王嫄','kind1','subject1',80.4,null,'16B');
insert into tb_grade_sub value('1643205000242','王嫄','kind1','subject2',80.4,null,'16B');
insert into tb_grade_sub value('1643205000242','王嫄','kind1','subject3',80.4,null,'16B');
insert into tb_grade_sub value('1643205000242','王嫄','kind2','subject4',80.4,null,'16B');
insert into tb_grade_sub value('1643205000242','王嫄','kind2','subject5',80.4,null,'16B');
insert into tb_grade_sub value('1643205000242','王嫄','kind1','subject6',80.4,null,'16B');
insert into tb_grade_sub value('1643205000242','王嫄','kind1','subject7',80.4,null,'16B');
insert into tb_grade_sub value('1643205000242','王嫄','kind3','subject8',80.4,null,'16B');
insert into tb_grade_sub value('1643205000242','王嫄','kind3','subject9',80.4,null,'16B');

insert into tb_grade_sub value('1643205000248','陈南丽','kind1','subject1',80.2,null,'16B');
insert into tb_grade_sub value('1643205000248','陈南丽','kind1','subject2',80.2,null,'16B');
insert into tb_grade_sub value('1643205000248','陈南丽','kind1','subject3',80.2,null,'16B');
insert into tb_grade_sub value('1643205000248','陈南丽','kind2','subject4',80.2,null,'16B');
insert into tb_grade_sub value('1643205000248','陈南丽','kind2','subject5',80.2,null,'16B');
insert into tb_grade_sub value('1643205000248','陈南丽','kind1','subject6',80.2,null,'16B');
insert into tb_grade_sub value('1643205000248','陈南丽','kind1','subject7',80.2,null,'16B');
insert into tb_grade_sub value('1643205000248','陈南丽','kind3','subject8',80.2,null,'16B');
insert into tb_grade_sub value('1643205000248','陈南丽','kind3','subject9',80.2,null,'16B');

insert into tb_grade_sub value('1643205000254','李国函','kind1','subject1',80.2,null,'16B');
insert into tb_grade_sub value('1643205000254','李国函','kind1','subject2',80.2,null,'16B');
insert into tb_grade_sub value('1643205000254','李国函','kind1','subject3',80.2,null,'16B');
insert into tb_grade_sub value('1643205000254','李国函','kind2','subject4',80.2,null,'16B');
insert into tb_grade_sub value('1643205000254','李国函','kind2','subject5',80.2,null,'16B');
insert into tb_grade_sub value('1643205000254','李国函','kind1','subject6',80.2,null,'16B');
insert into tb_grade_sub value('1643205000254','李国函','kind1','subject7',80.2,null,'16B');
insert into tb_grade_sub value('1643205000254','李国函','kind3','subject8',80.2,null,'16B');
insert into tb_grade_sub value('1643205000254','李国函','kind3','subject9',80.2,null,'16B');

insert into tb_grade_sub value('1643205000224','李萌','kind1','subject1',80.1,null,'16B');
insert into tb_grade_sub value('1643205000224','李萌','kind1','subject2',80.1,null,'16B');
insert into tb_grade_sub value('1643205000224','李萌','kind1','subject3',80.1,null,'16B');
insert into tb_grade_sub value('1643205000224','李萌','kind2','subject4',80.1,null,'16B');
insert into tb_grade_sub value('1643205000224','李萌','kind2','subject5',80.1,null,'16B');
insert into tb_grade_sub value('1643205000224','李萌','kind1','subject6',80.1,null,'16B');
insert into tb_grade_sub value('1643205000224','李萌','kind1','subject7',80.1,null,'16B');
insert into tb_grade_sub value('1643205000224','李萌','kind3','subject8',80.1,null,'16B');
insert into tb_grade_sub value('1643205000224','李萌','kind3','subject9',80.1,null,'16B');

insert into tb_grade_sub value('1643205000231','周瑞','kind1','subject1',79.8,null,'16B');
insert into tb_grade_sub value('1643205000231','周瑞','kind1','subject2',79.8,null,'16B');
insert into tb_grade_sub value('1643205000231','周瑞','kind1','subject3',79.8,null,'16B');
insert into tb_grade_sub value('1643205000231','周瑞','kind2','subject4',79.8,null,'16B');
insert into tb_grade_sub value('1643205000231','周瑞','kind2','subject5',79.8,null,'16B');
insert into tb_grade_sub value('1643205000231','周瑞','kind1','subject6',79.8,null,'16B');
insert into tb_grade_sub value('1643205000231','周瑞','kind1','subject7',79.8,null,'16B');
insert into tb_grade_sub value('1643205000231','周瑞','kind3','subject8',79.8,null,'16B');
insert into tb_grade_sub value('1643205000231','周瑞','kind3','subject9',79.8,null,'16B');

insert into tb_grade_sub value('1643205000255','丁靖','kind1','subject1',79.3,null,'16B');
insert into tb_grade_sub value('1643205000255','丁靖','kind1','subject2',79.3,null,'16B');
insert into tb_grade_sub value('1643205000255','丁靖','kind1','subject3',79.3,null,'16B');
insert into tb_grade_sub value('1643205000255','丁靖','kind2','subject4',79.3,null,'16B');
insert into tb_grade_sub value('1643205000255','丁靖','kind2','subject5',79.3,null,'16B');
insert into tb_grade_sub value('1643205000255','丁靖','kind1','subject6',79.3,null,'16B');
insert into tb_grade_sub value('1643205000255','丁靖','kind1','subject7',79.3,null,'16B');
insert into tb_grade_sub value('1643205000255','丁靖','kind3','subject8',79.3,null,'16B');
insert into tb_grade_sub value('1643205000255','丁靖','kind3','subject9',79.3,null,'16B');

insert into tb_grade_sub value('1643205000259','梁正厅','kind1','subject1',96,null,'16B');
insert into tb_grade_sub value('1643205000259','梁正厅','kind1','subject2',61,null,'16B');
insert into tb_grade_sub value('1643205000259','梁正厅','kind1','subject3',77,null,'16B');
insert into tb_grade_sub value('1643205000259','梁正厅','kind2','subject4',75,null,'16B');
insert into tb_grade_sub value('1643205000259','梁正厅','kind2','subject5',78,null,'16B');
insert into tb_grade_sub value('1643205000259','梁正厅','kind1','subject6',82,null,'16B');
insert into tb_grade_sub value('1643205000259','梁正厅','kind1','subject7',80,null,'16B');
insert into tb_grade_sub value('1643205000259','梁正厅','kind3','subject8',80,null,'16B');
insert into tb_grade_sub value('1643205000259','梁正厅','kind3','subject9',80,null,'16B');

insert into tb_grade_sub value('1643205000227','李加涛','kind1','subject1',78.7,null,'16B');
insert into tb_grade_sub value('1643205000227','李加涛','kind1','subject2',78.7,null,'16B');
insert into tb_grade_sub value('1643205000227','李加涛','kind1','subject3',78.7,null,'16B');
insert into tb_grade_sub value('1643205000227','李加涛','kind2','subject4',78.7,null,'16B');
insert into tb_grade_sub value('1643205000227','李加涛','kind2','subject5',78.7,null,'16B');
insert into tb_grade_sub value('1643205000227','李加涛','kind1','subject6',78.7,null,'16B');
insert into tb_grade_sub value('1643205000227','李加涛','kind1','subject7',78.7,null,'16B');
insert into tb_grade_sub value('1643205000227','李加涛','kind3','subject8',78.7,null,'16B');
insert into tb_grade_sub value('1643205000227','李加涛','kind3','subject9',78.7,null,'16B');

insert into tb_grade_sub value('1643205000269','陆雅婷','kind1','subject1',78.7,null,'16B');
insert into tb_grade_sub value('1643205000269','陆雅婷','kind1','subject2',78.7,null,'16B');
insert into tb_grade_sub value('1643205000269','陆雅婷','kind1','subject3',78.7,null,'16B');
insert into tb_grade_sub value('1643205000269','陆雅婷','kind2','subject4',78.7,null,'16B');
insert into tb_grade_sub value('1643205000269','陆雅婷','kind2','subject5',78.7,null,'16B');
insert into tb_grade_sub value('1643205000269','陆雅婷','kind1','subject6',78.7,null,'16B');
insert into tb_grade_sub value('1643205000269','陆雅婷','kind1','subject7',78.7,null,'16B');
insert into tb_grade_sub value('1643205000269','陆雅婷','kind3','subject8',78.7,null,'16B');
insert into tb_grade_sub value('1643205000269','陆雅婷','kind3','subject9',78.7,null,'16B');

insert into tb_grade_sub value('1643205000261','罗荣杰','kind1','subject1',77.7,null,'16B');
insert into tb_grade_sub value('1643205000261','罗荣杰','kind1','subject2',77.7,null,'16B');
insert into tb_grade_sub value('1643205000261','罗荣杰','kind1','subject3',77.7,null,'16B');
insert into tb_grade_sub value('1643205000261','罗荣杰','kind2','subject4',77.7,null,'16B');
insert into tb_grade_sub value('1643205000261','罗荣杰','kind2','subject5',77.7,null,'16B');
insert into tb_grade_sub value('1643205000261','罗荣杰','kind1','subject6',77.7,null,'16B');
insert into tb_grade_sub value('1643205000261','罗荣杰','kind1','subject7',77.7,null,'16B');
insert into tb_grade_sub value('1643205000261','罗荣杰','kind3','subject8',77.7,null,'16B');
insert into tb_grade_sub value('1643205000261','罗荣杰','kind3','subject9',77.7,null,'16B');

insert into tb_grade_sub value('1643205000234','张飞虎','kind1','subject1',77.1,null,'16B');
insert into tb_grade_sub value('1643205000234','张飞虎','kind1','subject2',77.1,null,'16B');
insert into tb_grade_sub value('1643205000234','张飞虎','kind1','subject3',77.1,null,'16B');
insert into tb_grade_sub value('1643205000234','张飞虎','kind2','subject4',77.1,null,'16B');
insert into tb_grade_sub value('1643205000234','张飞虎','kind2','subject5',77.1,null,'16B');
insert into tb_grade_sub value('1643205000234','张飞虎','kind1','subject6',77.1,null,'16B');
insert into tb_grade_sub value('1643205000234','张飞虎','kind1','subject7',77.1,null,'16B');
insert into tb_grade_sub value('1643205000234','张飞虎','kind3','subject8',77.1,null,'16B');
insert into tb_grade_sub value('1643205000234','张飞虎','kind3','subject9',77.1,null,'16B');

insert into tb_grade_sub value('1643205000216','李一璠','kind1','subject1',77,null,'16B');
insert into tb_grade_sub value('1643205000216','李一璠','kind1','subject2',77,null,'16B');
insert into tb_grade_sub value('1643205000216','李一璠','kind1','subject3',77,null,'16B');
insert into tb_grade_sub value('1643205000216','李一璠','kind2','subject4',77,null,'16B');
insert into tb_grade_sub value('1643205000216','李一璠','kind2','subject5',77,null,'16B');
insert into tb_grade_sub value('1643205000216','李一璠','kind1','subject6',77,null,'16B');
insert into tb_grade_sub value('1643205000216','李一璠','kind1','subject7',77,null,'16B');
insert into tb_grade_sub value('1643205000216','李一璠','kind3','subject8',77,null,'16B');
insert into tb_grade_sub value('1643205000216','李一璠','kind3','subject9',77,null,'16B');

insert into tb_grade_sub value('1643205000222','张娅敏','kind1','subject1',76.9,null,'16B');
insert into tb_grade_sub value('1643205000222','张娅敏','kind1','subject2',76.9,null,'16B');
insert into tb_grade_sub value('1643205000222','张娅敏','kind1','subject3',76.9,null,'16B');
insert into tb_grade_sub value('1643205000222','张娅敏','kind2','subject4',76.9,null,'16B');
insert into tb_grade_sub value('1643205000222','张娅敏','kind2','subject5',76.9,null,'16B');
insert into tb_grade_sub value('1643205000222','张娅敏','kind1','subject6',76.9,null,'16B');
insert into tb_grade_sub value('1643205000222','张娅敏','kind1','subject7',76.9,null,'16B');
insert into tb_grade_sub value('1643205000222','张娅敏','kind3','subject8',76.9,null,'16B');
insert into tb_grade_sub value('1643205000222','张娅敏','kind3','subject9',76.9,null,'16B');

insert into tb_grade_sub value('1643205000270','李梦瑶','kind1','subject1',76.3,null,'16B');
insert into tb_grade_sub value('1643205000270','李梦瑶','kind1','subject2',76.3,null,'16B');
insert into tb_grade_sub value('1643205000270','李梦瑶','kind1','subject3',76.3,null,'16B');
insert into tb_grade_sub value('1643205000270','李梦瑶','kind2','subject4',76.3,null,'16B');
insert into tb_grade_sub value('1643205000270','李梦瑶','kind2','subject5',76.3,null,'16B');
insert into tb_grade_sub value('1643205000270','李梦瑶','kind1','subject6',76.3,null,'16B');
insert into tb_grade_sub value('1643205000270','李梦瑶','kind1','subject7',76.3,null,'16B');
insert into tb_grade_sub value('1643205000270','李梦瑶','kind3','subject8',76.3,null,'16B');
insert into tb_grade_sub value('1643205000270','李梦瑶','kind3','subject9',76.3,null,'16B');

insert into tb_grade_sub value('1643205000257','杨洋','kind1','subject1',76.3,null,'16B');
insert into tb_grade_sub value('1643205000257','杨洋','kind1','subject2',76.3,null,'16B');
insert into tb_grade_sub value('1643205000257','杨洋','kind1','subject3',76.3,null,'16B');
insert into tb_grade_sub value('1643205000257','杨洋','kind2','subject4',76.3,null,'16B');
insert into tb_grade_sub value('1643205000257','杨洋','kind2','subject5',76.3,null,'16B');
insert into tb_grade_sub value('1643205000257','杨洋','kind1','subject6',76.3,null,'16B');
insert into tb_grade_sub value('1643205000257','杨洋','kind1','subject7',76.3,null,'16B');
insert into tb_grade_sub value('1643205000257','杨洋','kind3','subject8',76.3,null,'16B');
insert into tb_grade_sub value('1643205000257','杨洋','kind3','subject9',76.3,null,'16B');

insert into tb_grade_sub value('1643205000266','李木兰','kind1','subject1',76,null,'16B');
insert into tb_grade_sub value('1643205000266','李木兰','kind1','subject2',76,null,'16B');
insert into tb_grade_sub value('1643205000266','李木兰','kind1','subject3',76,null,'16B');
insert into tb_grade_sub value('1643205000266','李木兰','kind2','subject4',76,null,'16B');
insert into tb_grade_sub value('1643205000266','李木兰','kind2','subject5',76,null,'16B');
insert into tb_grade_sub value('1643205000266','李木兰','kind1','subject6',76,null,'16B');
insert into tb_grade_sub value('1643205000266','李木兰','kind1','subject7',76,null,'16B');
insert into tb_grade_sub value('1643205000266','李木兰','kind3','subject8',76,null,'16B');
insert into tb_grade_sub value('1643205000266','李木兰','kind3','subject9',76,null,'16B');

insert into tb_grade_sub value('1643205000271','和鑫','kind1','subject1',75.58,null,'16B');
insert into tb_grade_sub value('1643205000271','和鑫','kind1','subject2',75.58,null,'16B');
insert into tb_grade_sub value('1643205000271','和鑫','kind1','subject3',75.58,null,'16B');
insert into tb_grade_sub value('1643205000271','和鑫','kind2','subject4',75.58,null,'16B');
insert into tb_grade_sub value('1643205000271','和鑫','kind2','subject5',75.58,null,'16B');
insert into tb_grade_sub value('1643205000271','和鑫','kind1','subject6',75.58,null,'16B');
insert into tb_grade_sub value('1643205000271','和鑫','kind1','subject7',75.58,null,'16B');
insert into tb_grade_sub value('1643205000271','和鑫','kind3','subject8',75.58,null,'16B');
insert into tb_grade_sub value('1643205000271','和鑫','kind3','subject9',75.58,null,'16B');

insert into tb_grade_sub value('1643205000223','李红伟','kind1','subject1',75.1,null,'16B');
insert into tb_grade_sub value('1643205000223','李红伟','kind1','subject2',75.1,null,'16B');
insert into tb_grade_sub value('1643205000223','李红伟','kind1','subject3',75.1,null,'16B');
insert into tb_grade_sub value('1643205000223','李红伟','kind2','subject4',75.1,null,'16B');
insert into tb_grade_sub value('1643205000223','李红伟','kind2','subject5',75.1,null,'16B');
insert into tb_grade_sub value('1643205000223','李红伟','kind1','subject6',75.1,null,'16B');
insert into tb_grade_sub value('1643205000223','李红伟','kind1','subject7',75.1,null,'16B');
insert into tb_grade_sub value('1643205000223','李红伟','kind3','subject8',75.1,null,'16B');
insert into tb_grade_sub value('1643205000223','李红伟','kind3','subject9',75.1,null,'16B');

insert into tb_grade_sub value('1643205000232','程清念','kind1','subject1',74.7,null,'16B');
insert into tb_grade_sub value('1643205000232','程清念','kind1','subject2',74.7,null,'16B');
insert into tb_grade_sub value('1643205000232','程清念','kind1','subject3',74.7,null,'16B');
insert into tb_grade_sub value('1643205000232','程清念','kind2','subject4',74.7,null,'16B');
insert into tb_grade_sub value('1643205000232','程清念','kind2','subject5',74.7,null,'16B');
insert into tb_grade_sub value('1643205000232','程清念','kind1','subject6',74.7,null,'16B');
insert into tb_grade_sub value('1643205000232','程清念','kind1','subject7',74.7,null,'16B');
insert into tb_grade_sub value('1643205000232','程清念','kind3','subject8',74.7,null,'16B');
insert into tb_grade_sub value('1643205000232','程清念','kind3','subject9',74.7,null,'16B');

insert into tb_grade_sub value('1643205000243','蔡娅蕊','kind1','subject1',74.5,null,'16B');
insert into tb_grade_sub value('1643205000243','蔡娅蕊','kind1','subject2',74.5,null,'16B');
insert into tb_grade_sub value('1643205000243','蔡娅蕊','kind1','subject3',74.5,null,'16B');
insert into tb_grade_sub value('1643205000243','蔡娅蕊','kind2','subject4',74.5,null,'16B');
insert into tb_grade_sub value('1643205000243','蔡娅蕊','kind2','subject5',74.5,null,'16B');
insert into tb_grade_sub value('1643205000243','蔡娅蕊','kind1','subject6',74.5,null,'16B');
insert into tb_grade_sub value('1643205000243','蔡娅蕊','kind1','subject7',74.5,null,'16B');
insert into tb_grade_sub value('1643205000243','蔡娅蕊','kind3','subject8',74.5,null,'16B');
insert into tb_grade_sub value('1643205000243','蔡娅蕊','kind3','subject9',74.5,null,'16B');

insert into tb_grade_sub value('1643204000310','郭进军','kind1','subject1',74.36,null,'16B');
insert into tb_grade_sub value('1643204000310','郭进军','kind1','subject2',74.36,null,'16B');
insert into tb_grade_sub value('1643204000310','郭进军','kind1','subject3',74.36,null,'16B');
insert into tb_grade_sub value('1643204000310','郭进军','kind2','subject4',74.36,null,'16B');
insert into tb_grade_sub value('1643204000310','郭进军','kind2','subject5',74.36,null,'16B');
insert into tb_grade_sub value('1643204000310','郭进军','kind1','subject6',74.36,null,'16B');
insert into tb_grade_sub value('1643204000310','郭进军','kind1','subject7',74.36,null,'16B');
insert into tb_grade_sub value('1643204000310','郭进军','kind3','subject8',74.36,null,'16B');
insert into tb_grade_sub value('1643204000310','郭进军','kind3','subject9',74.36,null,'16B');

insert into tb_grade_sub value('1643205000237','高孟','kind1','subject1',73.8,null,'16B');
insert into tb_grade_sub value('1643205000237','高孟','kind1','subject2',73.8,null,'16B');
insert into tb_grade_sub value('1643205000237','高孟','kind1','subject3',73.8,null,'16B');
insert into tb_grade_sub value('1643205000237','高孟','kind2','subject4',73.8,null,'16B');
insert into tb_grade_sub value('1643205000237','高孟','kind2','subject5',73.8,null,'16B');
insert into tb_grade_sub value('1643205000237','高孟','kind1','subject6',73.8,null,'16B');
insert into tb_grade_sub value('1643205000237','高孟','kind1','subject7',73.8,null,'16B');
insert into tb_grade_sub value('1643205000237','高孟','kind3','subject8',73.8,null,'16B');
insert into tb_grade_sub value('1643205000237','高孟','kind3','subject9',73.8,null,'16B');

insert into tb_grade_sub value('1643205000226','马桢霓','kind1','subject1',73.3,null,'16B');
insert into tb_grade_sub value('1643205000226','马桢霓','kind1','subject2',73.3,null,'16B');
insert into tb_grade_sub value('1643205000226','马桢霓','kind1','subject3',73.3,null,'16B');
insert into tb_grade_sub value('1643205000226','马桢霓','kind2','subject4',73.3,null,'16B');
insert into tb_grade_sub value('1643205000226','马桢霓','kind2','subject5',73.3,null,'16B');
insert into tb_grade_sub value('1643205000226','马桢霓','kind1','subject6',73.3,null,'16B');
insert into tb_grade_sub value('1643205000226','马桢霓','kind1','subject7',73.3,null,'16B');
insert into tb_grade_sub value('1643205000226','马桢霓','kind3','subject8',73.3,null,'16B');
insert into tb_grade_sub value('1643205000226','马桢霓','kind3','subject9',73.3,null,'16B');

insert into tb_grade_sub value('1643205000249','杨吉欣','kind1','subject1',73.2,null,'16B');
insert into tb_grade_sub value('1643205000249','杨吉欣','kind1','subject2',73.2,null,'16B');
insert into tb_grade_sub value('1643205000249','杨吉欣','kind1','subject3',73.2,null,'16B');
insert into tb_grade_sub value('1643205000249','杨吉欣','kind2','subject4',73.2,null,'16B');
insert into tb_grade_sub value('1643205000249','杨吉欣','kind2','subject5',73.2,null,'16B');
insert into tb_grade_sub value('1643205000249','杨吉欣','kind1','subject6',73.2,null,'16B');
insert into tb_grade_sub value('1643205000249','杨吉欣','kind1','subject7',73.2,null,'16B');
insert into tb_grade_sub value('1643205000249','杨吉欣','kind3','subject8',73.2,null,'16B');
insert into tb_grade_sub value('1643205000249','杨吉欣','kind3','subject9',73.2,null,'16B');

insert into tb_grade_sub value('1643205000265','赵腊约','kind1','subject1',73.1,null,'16B');
insert into tb_grade_sub value('1643205000265','赵腊约','kind1','subject2',73.1,null,'16B');
insert into tb_grade_sub value('1643205000265','赵腊约','kind1','subject3',73.1,null,'16B');
insert into tb_grade_sub value('1643205000265','赵腊约','kind2','subject4',73.1,null,'16B');
insert into tb_grade_sub value('1643205000265','赵腊约','kind2','subject5',73.1,null,'16B');
insert into tb_grade_sub value('1643205000265','赵腊约','kind1','subject6',73.1,null,'16B');
insert into tb_grade_sub value('1643205000265','赵腊约','kind1','subject7',73.1,null,'16B');
insert into tb_grade_sub value('1643205000265','赵腊约','kind3','subject8',73.1,null,'16B');
insert into tb_grade_sub value('1643205000265','赵腊约','kind3','subject9',73.1,null,'16B');

insert into tb_grade_sub value('1643205000247','周奕灵','kind1','subject1',72.5,null,'16B');
insert into tb_grade_sub value('1643205000247','周奕灵','kind1','subject2',72.5,null,'16B');
insert into tb_grade_sub value('1643205000247','周奕灵','kind1','subject3',72.5,null,'16B');
insert into tb_grade_sub value('1643205000247','周奕灵','kind2','subject4',72.5,null,'16B');
insert into tb_grade_sub value('1643205000247','周奕灵','kind2','subject5',72.5,null,'16B');
insert into tb_grade_sub value('1643205000247','周奕灵','kind1','subject6',72.5,null,'16B');
insert into tb_grade_sub value('1643205000247','周奕灵','kind1','subject7',72.5,null,'16B');
insert into tb_grade_sub value('1643205000247','周奕灵','kind3','subject8',72.5,null,'16B');
insert into tb_grade_sub value('1643205000247','周奕灵','kind3','subject9',72.5,null,'16B');


insert into tb_grade_sub value('1643205000129','梁雪蓉','kind1','subject1',94,null,'16F');
insert into tb_grade_sub value('1643205000129','梁雪蓉','kind1','subject2',85,null,'16F');
insert into tb_grade_sub value('1643205000129','梁雪蓉','kind1','subject3',89,null,'16F');
insert into tb_grade_sub value('1643205000129','梁雪蓉','kind2','subject4',84,null,'16F');
insert into tb_grade_sub value('1643205000129','梁雪蓉','kind2','subject5',86,null,'16F');
insert into tb_grade_sub value('1643205000129','梁雪蓉','kind1','subject6',89,null,'16F');
insert into tb_grade_sub value('1643205000129','梁雪蓉','kind1','subject7',92,null,'16F');
insert into tb_grade_sub value('1643205000129','梁雪蓉','kind3','subject8',92,null,'16F');
insert into tb_grade_sub value('1643205000129','梁雪蓉','kind3','subject9',92,null,'16F');

insert into tb_grade_sub value('1643205000173','魏红','kind1','subject1',94,null,'16F');
insert into tb_grade_sub value('1643205000173','魏红','kind1','subject2',85,null,'16F');
insert into tb_grade_sub value('1643205000173','魏红','kind1','subject3',89,null,'16F');
insert into tb_grade_sub value('1643205000173','魏红','kind2','subject4',84,null,'16F');
insert into tb_grade_sub value('1643205000173','魏红','kind2','subject5',86,null,'16F');
insert into tb_grade_sub value('1643205000173','魏红','kind1','subject6',89,null,'16F');
insert into tb_grade_sub value('1643205000173','魏红','kind1','subject7',92,null,'16F');
insert into tb_grade_sub value('1643205000173','魏红','kind3','subject8',92,null,'16F');
insert into tb_grade_sub value('1643205000173','魏红','kind3','subject9',92,null,'16F');

insert into tb_grade_sub value('1643205000148','魏文东','kind1','subject1',94,null,'16F');
insert into tb_grade_sub value('1643205000148','魏文东','kind1','subject2',85,null,'16F');
insert into tb_grade_sub value('1643205000148','魏文东','kind1','subject3',89,null,'16F');
insert into tb_grade_sub value('1643205000148','魏文东','kind2','subject4',84,null,'16F');
insert into tb_grade_sub value('1643205000148','魏文东','kind2','subject5',86,null,'16F');
insert into tb_grade_sub value('1643205000148','魏文东','kind1','subject6',89,null,'16F');
insert into tb_grade_sub value('1643205000148','魏文东','kind1','subject7',92,null,'16F');
insert into tb_grade_sub value('1643205000148','魏文东','kind3','subject8',92,null,'16F');
insert into tb_grade_sub value('1643205000148','魏文东','kind3','subject9',92,null,'16F');


insert into tb_grade_sub value('1743205000001','刘潺','kind1','subject1',94,null,'17A');
insert into tb_grade_sub value('1743205000001','刘潺','kind1','subject2',85,null,'17A');
insert into tb_grade_sub value('1743205000001','刘潺','kind1','subject3',89,null,'17A');
insert into tb_grade_sub value('1743205000001','刘潺','kind2','subject4',84,null,'17A');
insert into tb_grade_sub value('1743205000001','刘潺','kind2','subject5',86,null,'17A');
insert into tb_grade_sub value('1743205000001','刘潺','kind1','subject6',89,null,'17A');
insert into tb_grade_sub value('1743205000001','刘潺','kind1','subject7',92,null,'17A');
insert into tb_grade_sub value('1743205000001','刘潺','kind3','subject8',92,null,'17A');
insert into tb_grade_sub value('1743205000001','刘潺','kind3','subject9',92,null,'17A');

insert into tb_grade_sub value('1743205000007','陈丹丹','kind1','subject1',94,null,'17A');
insert into tb_grade_sub value('1743205000007','陈丹丹','kind1','subject2',85,null,'17A');
insert into tb_grade_sub value('1743205000007','陈丹丹','kind1','subject3',89,null,'17A');
insert into tb_grade_sub value('1743205000007','陈丹丹','kind2','subject4',84,null,'17A');
insert into tb_grade_sub value('1743205000007','陈丹丹','kind2','subject5',86,null,'17A');
insert into tb_grade_sub value('1743205000007','陈丹丹','kind1','subject6',89,null,'17A');
insert into tb_grade_sub value('1743205000007','陈丹丹','kind1','subject7',92,null,'17A');
insert into tb_grade_sub value('1743205000007','陈丹丹','kind3','subject8',92,null,'17A');
insert into tb_grade_sub value('1743205000007','陈丹丹','kind3','subject9',92,null,'17A');

insert into tb_grade_sub value('1743205000018','姜明','kind1','subject1',94,null,'17A');
insert into tb_grade_sub value('1743205000018','姜明','kind1','subject2',85,null,'17A');
insert into tb_grade_sub value('1743205000018','姜明','kind1','subject3',89,null,'17A');
insert into tb_grade_sub value('1743205000018','姜明','kind2','subject4',84,null,'17A');
insert into tb_grade_sub value('1743205000018','姜明','kind2','subject5',86,null,'17A');
insert into tb_grade_sub value('1743205000018','姜明','kind1','subject6',89,null,'17A');
insert into tb_grade_sub value('1743205000018','姜明','kind1','subject7',92,null,'17A');
insert into tb_grade_sub value('1743205000018','姜明','kind3','subject8',92,null,'17A');
insert into tb_grade_sub value('1743205000018','姜明','kind3','subject9',92,null,'17A');

insert into tb_grade_sub value('1743205000038','李雅琪','kind1','subject1',94,null,'17A');
insert into tb_grade_sub value('1743205000038','李雅琪','kind1','subject2',85,null,'17A');
insert into tb_grade_sub value('1743205000038','李雅琪','kind1','subject3',89,null,'17A');
insert into tb_grade_sub value('1743205000038','李雅琪','kind2','subject4',84,null,'17A');
insert into tb_grade_sub value('1743205000038','李雅琪','kind2','subject5',86,null,'17A');
insert into tb_grade_sub value('1743205000038','李雅琪','kind1','subject6',89,null,'17A');
insert into tb_grade_sub value('1743205000038','李雅琪','kind1','subject7',92,null,'17A');
insert into tb_grade_sub value('1743205000038','李雅琪','kind3','subject8',92,null,'17A');
insert into tb_grade_sub value('1743205000038','李雅琪','kind3','subject9',92,null,'17A');


insert into tb_grade_sub value('1743205000216','杨秋霞','kind1','subject1',94,null,'17B');
insert into tb_grade_sub value('1743205000216','杨秋霞','kind1','subject2',85,null,'17B');
insert into tb_grade_sub value('1743205000216','杨秋霞','kind1','subject3',89,null,'17B');
insert into tb_grade_sub value('1743205000216','杨秋霞','kind2','subject4',84,null,'17B');
insert into tb_grade_sub value('1743205000216','杨秋霞','kind2','subject5',86,null,'17B');
insert into tb_grade_sub value('1743205000216','杨秋霞','kind1','subject6',89,null,'17B');
insert into tb_grade_sub value('1743205000216','杨秋霞','kind1','subject7',92,null,'17B');
insert into tb_grade_sub value('1743205000216','杨秋霞','kind3','subject8',92,null,'17B');
insert into tb_grade_sub value('1743205000216','杨秋霞','kind3','subject9',92,null,'17B');

insert into tb_grade_sub value('1743205000205','叶春丽','kind1','subject1',94,null,'17B');
insert into tb_grade_sub value('1743205000205','叶春丽','kind1','subject2',85,null,'17B');
insert into tb_grade_sub value('1743205000205','叶春丽','kind1','subject3',89,null,'17B');
insert into tb_grade_sub value('1743205000205','叶春丽','kind2','subject4',84,null,'17B');
insert into tb_grade_sub value('1743205000205','叶春丽','kind2','subject5',86,null,'17B');
insert into tb_grade_sub value('1743205000205','叶春丽','kind1','subject6',89,null,'17B');
insert into tb_grade_sub value('1743205000205','叶春丽','kind1','subject7',92,null,'17B');
insert into tb_grade_sub value('1743205000205','叶春丽','kind3','subject8',92,null,'17B');
insert into tb_grade_sub value('1743205000205','叶春丽','kind3','subject9',92,null,'17B');

insert into tb_grade_sub value('1743205000189','彭丹','kind1','subject1',94,null,'17B');
insert into tb_grade_sub value('1743205000189','彭丹','kind1','subject2',85,null,'17B');
insert into tb_grade_sub value('1743205000189','彭丹','kind1','subject3',89,null,'17B');
insert into tb_grade_sub value('1743205000189','彭丹','kind2','subject4',84,null,'17B');
insert into tb_grade_sub value('1743205000189','彭丹','kind2','subject5',86,null,'17B');
insert into tb_grade_sub value('1743205000189','彭丹','kind1','subject6',89,null,'17B');
insert into tb_grade_sub value('1743205000189','彭丹','kind1','subject7',92,null,'17B');
insert into tb_grade_sub value('1743205000189','彭丹','kind3','subject8',92,null,'17B');
insert into tb_grade_sub value('1743205000189','彭丹','kind3','subject9',92,null,'17B');


insert into tb_grade_sub value('1723205000001','施丽娜','kind1','subject1',94,null,'17F');
insert into tb_grade_sub value('1723205000001','施丽娜','kind1','subject2',85,null,'17F');
insert into tb_grade_sub value('1723205000001','施丽娜','kind1','subject3',89,null,'17F');
insert into tb_grade_sub value('1723205000001','施丽娜','kind2','subject4',84,null,'17F');
insert into tb_grade_sub value('1723205000001','施丽娜','kind2','subject5',86,null,'17F');
insert into tb_grade_sub value('1723205000001','施丽娜','kind1','subject6',89,null,'17F');
insert into tb_grade_sub value('1723205000001','施丽娜','kind1','subject7',92,null,'17F');
insert into tb_grade_sub value('1723205000001','施丽娜','kind3','subject8',92,null,'17F');
insert into tb_grade_sub value('1723205000001','施丽娜','kind3','subject9',92,null,'17F');

insert into tb_grade_sub value('1723205000063','李文红','kind1','subject1',94,null,'17F');
insert into tb_grade_sub value('1723205000063','李文红','kind1','subject2',85,null,'17F');
insert into tb_grade_sub value('1723205000063','李文红','kind1','subject3',89,null,'17F');
insert into tb_grade_sub value('1723205000063','李文红','kind2','subject4',84,null,'17F');
insert into tb_grade_sub value('1723205000063','李文红','kind2','subject5',86,null,'17F');
insert into tb_grade_sub value('1723205000063','李文红','kind1','subject6',89,null,'17F');
insert into tb_grade_sub value('1723205000063','李文红','kind1','subject7',92,null,'17F');
insert into tb_grade_sub value('1723205000063','李文红','kind3','subject8',92,null,'17F');
insert into tb_grade_sub value('1723205000063','李文红','kind3','subject9',92,null,'17F');

insert into tb_grade_sub value('1723205000067','陈会','kind1','subject1',94,null,'17F');
insert into tb_grade_sub value('1723205000067','陈会','kind1','subject2',85,null,'17F');
insert into tb_grade_sub value('1723205000067','陈会','kind1','subject3',89,null,'17F');
insert into tb_grade_sub value('1723205000067','陈会','kind2','subject4',84,null,'17F');
insert into tb_grade_sub value('1723205000067','陈会','kind2','subject5',86,null,'17F');
insert into tb_grade_sub value('1723205000067','陈会','kind1','subject6',89,null,'17F');
insert into tb_grade_sub value('1723205000067','陈会','kind1','subject7',92,null,'17F');
insert into tb_grade_sub value('1723205000067','陈会','kind3','subject8',92,null,'17F');
insert into tb_grade_sub value('1723205000067','陈会','kind3','subject9',92,null,'17F');


insert into tb_grade_sub value('1843205000159','孙彩艳','kind1','subject1',94,null,'18A');
insert into tb_grade_sub value('1843205000159','孙彩艳','kind1','subject2',85,null,'18A');
insert into tb_grade_sub value('1843205000159','孙彩艳','kind1','subject3',89,null,'18A');
insert into tb_grade_sub value('1843205000159','孙彩艳','kind2','subject4',84,null,'18A');
insert into tb_grade_sub value('1843205000159','孙彩艳','kind2','subject5',86,null,'18A');
insert into tb_grade_sub value('1843205000159','孙彩艳','kind1','subject6',89,null,'18A');
insert into tb_grade_sub value('1843205000159','孙彩艳','kind1','subject7',92,null,'18A');
insert into tb_grade_sub value('1843205000159','孙彩艳','kind3','subject8',92,null,'18A');
insert into tb_grade_sub value('1843205000159','孙彩艳','kind3','subject9',92,null,'18A');

insert into tb_grade_sub value('1843205000162','尚照清','kind1','subject1',94,null,'18A');
insert into tb_grade_sub value('1843205000162','尚照清','kind1','subject2',85,null,'18A');
insert into tb_grade_sub value('1843205000162','尚照清','kind1','subject3',89,null,'18A');
insert into tb_grade_sub value('1843205000162','尚照清','kind2','subject4',84,null,'18A');
insert into tb_grade_sub value('1843205000162','尚照清','kind2','subject5',86,null,'18A');
insert into tb_grade_sub value('1843205000162','尚照清','kind1','subject6',89,null,'18A');
insert into tb_grade_sub value('1843205000162','尚照清','kind1','subject7',92,null,'18A');
insert into tb_grade_sub value('1843205000162','尚照清','kind3','subject8',92,null,'18A');
insert into tb_grade_sub value('1843205000162','尚照清','kind3','subject9',92,null,'18A');

insert into tb_grade_sub value('1843205000174','史洁','kind1','subject1',94,null,'18A');
insert into tb_grade_sub value('1843205000174','史洁','kind1','subject2',85,null,'18A');
insert into tb_grade_sub value('1843205000174','史洁','kind1','subject3',89,null,'18A');
insert into tb_grade_sub value('1843205000174','史洁','kind2','subject4',84,null,'18A');
insert into tb_grade_sub value('1843205000174','史洁','kind2','subject5',86,null,'18A');
insert into tb_grade_sub value('1843205000174','史洁','kind1','subject6',89,null,'18A');
insert into tb_grade_sub value('1843205000174','史洁','kind1','subject7',92,null,'18A');
insert into tb_grade_sub value('1843205000174','史洁','kind3','subject8',92,null,'18A');
insert into tb_grade_sub value('1843205000174','史洁','kind3','subject9',92,null,'18A');


insert into tb_grade_sub value('1843205000065','杨炳锐','kind1','subject1',94,null,'18B');
insert into tb_grade_sub value('1843205000065','杨炳锐','kind1','subject2',85,null,'18B');
insert into tb_grade_sub value('1843205000065','杨炳锐','kind1','subject3',89,null,'18B');
insert into tb_grade_sub value('1843205000065','杨炳锐','kind2','subject4',84,null,'18B');
insert into tb_grade_sub value('1843205000065','杨炳锐','kind2','subject5',86,null,'18B');
insert into tb_grade_sub value('1843205000065','杨炳锐','kind1','subject6',89,null,'18B');
insert into tb_grade_sub value('1843205000065','杨炳锐','kind1','subject7',92,null,'18B');
insert into tb_grade_sub value('1843205000065','杨炳锐','kind3','subject8',92,null,'18B');
insert into tb_grade_sub value('1843205000065','杨炳锐','kind3','subject9',92,null,'18B');

insert into tb_grade_sub value('1843205000061','余纹影','kind1','subject1',94,null,'18B');
insert into tb_grade_sub value('1843205000061','余纹影','kind1','subject2',85,null,'18B');
insert into tb_grade_sub value('1843205000061','余纹影','kind1','subject3',89,null,'18B');
insert into tb_grade_sub value('1843205000061','余纹影','kind2','subject4',84,null,'18B');
insert into tb_grade_sub value('1843205000061','余纹影','kind2','subject5',86,null,'18B');
insert into tb_grade_sub value('1843205000061','余纹影','kind1','subject6',89,null,'18B');
insert into tb_grade_sub value('1843205000061','余纹影','kind1','subject7',92,null,'18B');
insert into tb_grade_sub value('1843205000061','余纹影','kind3','subject8',92,null,'18B');
insert into tb_grade_sub value('1843205000061','余纹影','kind3','subject9',92,null,'18B');

insert into tb_grade_sub value('1843205000049','张婷','kind1','subject1',94,null,'18B');
insert into tb_grade_sub value('1843205000049','张婷','kind1','subject2',85,null,'18B');
insert into tb_grade_sub value('1843205000049','张婷','kind1','subject3',89,null,'18B');
insert into tb_grade_sub value('1843205000049','张婷','kind2','subject4',84,null,'18B');
insert into tb_grade_sub value('1843205000049','张婷','kind2','subject5',86,null,'18B');
insert into tb_grade_sub value('1843205000049','张婷','kind1','subject6',89,null,'18B');
insert into tb_grade_sub value('1843205000049','张婷','kind1','subject7',92,null,'18B');
insert into tb_grade_sub value('1843205000049','张婷','kind3','subject8',92,null,'18B');
insert into tb_grade_sub value('1843205000049','张婷','kind3','subject9',92,null,'18B');


insert into tb_grade_sub value('1843205000069','林启莎','kind1','subject1',94,null,'18F');
insert into tb_grade_sub value('1843205000069','林启莎','kind1','subject2',85,null,'18F');
insert into tb_grade_sub value('1843205000069','林启莎','kind1','subject3',89,null,'18F');
insert into tb_grade_sub value('1843205000069','林启莎','kind2','subject4',84,null,'18F');
insert into tb_grade_sub value('1843205000069','林启莎','kind2','subject5',86,null,'18F');
insert into tb_grade_sub value('1843205000069','林启莎','kind1','subject6',89,null,'18F');
insert into tb_grade_sub value('1843205000069','林启莎','kind1','subject7',92,null,'18F');
insert into tb_grade_sub value('1843205000069','林启莎','kind3','subject8',92,null,'18F');
insert into tb_grade_sub value('1843205000069','林启莎','kind3','subject9',92,null,'18F');

insert into tb_grade_sub value('1843205000091','鲁金凤','kind1','subject1',94,null,'18F');
insert into tb_grade_sub value('1843205000091','鲁金凤','kind1','subject2',85,null,'18F');
insert into tb_grade_sub value('1843205000091','鲁金凤','kind1','subject3',89,null,'18F');
insert into tb_grade_sub value('1843205000091','鲁金凤','kind2','subject4',84,null,'18F');
insert into tb_grade_sub value('1843205000091','鲁金凤','kind2','subject5',86,null,'18F');
insert into tb_grade_sub value('1843205000091','鲁金凤','kind1','subject6',89,null,'18F');
insert into tb_grade_sub value('1843205000091','鲁金凤','kind1','subject7',92,null,'18F');
insert into tb_grade_sub value('1843205000091','鲁金凤','kind3','subject8',92,null,'18F');
insert into tb_grade_sub value('1843205000091','鲁金凤','kind3','subject9',92,null,'18F');

insert into tb_grade_sub value('1843205000094','何国林','kind1','subject1',94,null,'18F');
insert into tb_grade_sub value('1843205000094','何国林','kind1','subject2',85,null,'18F');
insert into tb_grade_sub value('1843205000094','何国林','kind1','subject3',89,null,'18F');
insert into tb_grade_sub value('1843205000094','何国林','kind2','subject4',84,null,'18F');
insert into tb_grade_sub value('1843205000094','何国林','kind2','subject5',86,null,'18F');
insert into tb_grade_sub value('1843205000094','何国林','kind1','subject6',89,null,'18F');
insert into tb_grade_sub value('1843205000094','何国林','kind1','subject7',92,null,'18F');
insert into tb_grade_sub value('1843205000094','何国林','kind3','subject8',92,null,'18F');
insert into tb_grade_sub value('1843205000094','何国林','kind3','subject9',92,null,'18F');


create table tb_teacher(
	teaID varchar(20) primary key,
	classID varchar(20),
	teaName varchar(20),
	sex varchar(10),
	knowledge varchar(20),
	level varchar(20)
);

insert into tb_teacher value('tea1','16B','张春节','女','讲师','中级');
insert into tb_teacher value('tea2','16B','陈载清','男','副教授','高级');
insert into tb_teacher value('tea3','16B','高俊翔','男','讲师','中级');
insert into tb_teacher value('tea4','16B','白磊','男','副教授','高级');
insert into tb_teacher value('tea5','16B','刘平','男','副教授','高级');
insert into tb_teacher value('tea6','16B','王坤','男','讲师','中级');
insert into tb_teacher value('tea7','16F','王保云','男','讲师','中级');