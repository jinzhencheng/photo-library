
create database photo-library;
use photo-library;

--管理员表（密码采用密文存储)
create table admin
(
		id int not null constraint pk_my_user primary key auto_increment,
		username varchar(20) not null,
		password varchar(40) not null,
);
--用户表
/*用户管理和获取openid冲突?*/

create table my_user
(
	id int not null constraint pk_my_user primary key auto_increment,
	open_id varchar(20) not null 
);

--图片表
create table photo
(
		--- /upload/name.png (12342347825.png)
		id int not null constraint pk_photo primary key auto_increment,
		name varchar(30) not null,
		the_date datetime not null
);

--收藏表 (用户是否需要登陆?)
create table collection
(
		id int not null constraint pk_collection primary key auto_increment,
		photo_id int not null constraint fk_tag_agent_category foreign key reference photo(id),
		user_id int not null constraint fk_record_user foreign key reference my_user(id)
);
--标签表
create table tag
(
		id int not null constraint pk_tag primary key auto_increment,
		name varchar(10) not null,
		click_count int not null default 0
);

--类别表(为了便于后期再分类，将其单独设表)
create table category
(
		id int not null constraint pk_category primary key auto_increment,
		name varchar(10) not null,
		sequence tingint int,
		parent_id int constraint fk_child_parent foreign key reference category(id)	
);

--类别 <-> 标签
create table category_agent
(
		id int not null constraint pk_category_agent primary key auto_increment,
		category_id int not null constraint fk_tag_agent_category foreign key reference category(id),
		tag_id int not null constraint fk_tag_agent_tag foreign key reference tag(id)
);

--图片 <-> 标签
create table photo_agent
(
		id int not null constraint pk_photo_agent primary key auto_increment,
		photo_id int not null constraint fk_tag_agent_category foreign key reference photo(id),
		tag_id int not null constraint fk_tag_agent_tag foreign key reference tag(id)
);

--搜索记录表
create table record
(
		id int not null constraint pk_photo_agent primary key auto_increment,
		content varchar(40) not null,
		user_id int not null constraint fk_record_user foreign key reference my_user(id)
);
--系统设置
create table setting
(
		id int not null constraint pk_setting primary key auto_increment,
		content text null,
		flag tingint not null
);

--意见反馈
create table opinion
(
		id int not null constraint pk_opinion primary key auto_increment,
		content text not null,
		the_date datetime not null,
		user_id int not null constraint fk_record_user foreign key reference my_user(id)
);










