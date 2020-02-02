select * from tb_dept;
select * from tb_emp;

-- inner join
select * from tb_dept dept join tb_emp emp on emp.deptId = dept.id;

-- left join
select * from tb_dept dept left join tb_emp emp on emp.deptId = dept.id;
-- left excluding join
select * from tb_dept dept left join tb_emp emp on emp.deptId = dept.id where emp.id is null ;


-- right join
select * from tb_dept dept right join tb_emp emp on emp.deptId = dept.id;
-- right excluding join
select * from tb_dept dept right join tb_emp emp on emp.deptId = dept.id where dept.id is null ;


-- full join
select * from tb_dept dept left join tb_emp emp on emp.deptId = dept.id
union
select * from tb_dept dept right join tb_emp emp on emp.deptId = dept.id where dept.id is null ;
-- outer excluding join
explain select * from tb_dept dept left join tb_emp emp on emp.deptId = dept.id where emp.id is null
union
select * from tb_dept dept right join tb_emp emp on emp.deptId = dept.id where dept.id is null ;


show index from tb_emp;


explain select * from tb_emp , tb_dept where tb_emp.deptId = tb_dept.id;


-- const
explain select * from tb_dept where id=1;
-- const ref
explain select * from (select * from tb_dept where id=1) dept, tb_emp emp where dept.id = emp.deptId;

-- all eq_ref
explain select * from tb_dept dept inner join tb_emp emp on emp.deptId = dept.id where emp.name = 'sa';

-- ref
explain select * from tb_emp where tb_emp.deptId='3';
explain select * from tb_emp where tb_emp.deptId='3' and name='s7';
explain select * from tb_emp where tb_emp.deptId='3' and id=6;
-- range
explain select * from tb_dept where id in(1, 2) ;
-- index
explain select id from tb_dept;
-- all
explain select * from tb_dept ;


explain select id, deptId from tb_emp;

explain select * from tb_dept dept inner join tb_emp emp on emp.deptId = dept.id where emp.name = 'sa';



show index from tb_emp;
explain select * from tb_emp emp  where deptId = 3 order by id;


-- 1. single table optimize
-- origin condition: type: all, key: null, extra: Using where; Using filesort
explain select id, category_id, views from article where comments > 0 and category_id=1 order by views desc limit 1;

-- create single index article
create  index IDX_ARTICLE_COMMENTS on article(comments);  -- no use
create  index IDX_ARTICLE_VIEWS on article(views);  -- work
show index from article;
-- now: type: index, key: IDX_ARTICLE_VIEWS, extra: Using where
explain select id, category_id, views from article where comments > 0 and category_id=1 order by views desc limit 1;
drop index IDX_ARTICLE_COMMENTS on article;
drop index IDX_ARTICLE_VIEWS on article;


-- create complex index1:
alter TABLE article add index IDX_C_C_V(category_id, comments, views);
show index from article;
-- now: type: range, key: IDX_C_C_V,  extra: Using where; Using index; Using filesort
explain select id, category_id, views from article where comments > 0 and category_id=1 order by views desc limit 1;
drop index IDX_C_C_V on article;

-- create complex index2:
alter TABLE article add index IDX_C_V(category_id, views);
show index from article;
-- now: type: ref, key: IDX_C_V,  extra: Using where
explain select id, category_id, views from article where comments > 0 and category_id=1 order by views desc limit 1;
drop index IDX_C_V on article;




-- 2 table optimize
select * from book;
select * from class;

-- origin:
explain select * from book left join class on book.card = class.card;

-- create index on class
alter TABLE class add index IDX_CLASS_CARD(card);
explain select * from book left join class on book.card = class.card;
drop index IDX_CLASS_CARD on class;

-- create index on class: bad
alter TABLE book add index IDX_BOOK_CARD(card);
explain select * from book left join class on book.card = class.card;
drop index IDX_BOOK_CARD on book;

-- third tables optimize
-- the follow sql is differ.
explain select * from book left join class on book.card = class.card left join phone on class.card = phone.card;
explain select * from book left join class on book.card = class.card left join phone on class.card = phone.card;

alter TABLE class add index IDX_CLASS_CARD(card);
alter TABLE phone add index IDX_PHONE_CARD(card);
explain select * from book left join class on book.card = class.card left join phone on book.card = phone.card;
drop index IDX_CLASS_CARD on class;
drop index IDX_PHONE_CARD on phone;



-- index invalid
select * from staffs;

show index from staffs;
-- 2.最佳左前缀法则
-- index is valid:
explain select * from staffs where NAME='z3';
explain select * from staffs where NAME='z3' and age=2;
explain select * from staffs where age=2 and NAME='z3' ;
explain select * from staffs where NAME='z3' and age=2 and pos='manager';
explain select * from staffs where NAME='z3' and pos='manager';
-- index is invalid
explain select name, age from staffs where age= 2; -- valid
explain select name, add_time from staffs where age= 2; -- invalid

explain select * from staffs where pos like '%manager%'; -- invalid
explain select NAME from staffs where pos like '%manager%'; -- valid
explain select * from staffs where age= 2 and pos='manager';

-- 3. 不在索引列上做任何操作
explain select * from staffs where NAME = 'July';
explain select sum(id) from staffs;
-- index is invalid
explain select * from staffs where left(NAME, 4) = 'July';


-- 4. 存储引擎不能使用索引中范围条件右边的列
explain select * from staffs where NAME='z3' and age > 2 and pos= 'manager';


-- 5. 尽量使用覆盖索引, 禁止 SELECT *
explain select * from staffs where NAME='z3' and age=2 and pos='manager';
explain select NAME, pos, age from staffs where NAME='z3' and age=2 and pos='manager';
explain select NAME, age, pos  from staffs where NAME='z3' and age>2 and pos='manager';

-- 6. MYSQL 在使用不等于[！= 或者 `<>`] 的时候无法使用索引会导致全表扫描
explain select name from staffs where NAME='July';
explain select name from staffs where NAME !='July';  -- valid

explain select name, add_time from staffs where NAME !='July';  -- index invalid
explain select name, add_time from staffs where NAME <> 'July';  -- index invalid

-- 7. IS NULL 在索引会一直失效; IS NOT NULL 在非覆盖索引下会失效:
explain select name from staffs where NAME='July';
explain select name from staffs where NAME is null ;  -- index invalid
explain select name, add_time from staffs where NAME is null ;  -- index invalid
explain select name from staffs where NAME is not null ; -- index valid
explain select name, age, pos from staffs where NAME is not null ; -- index valid
explain select name, add_time from staffs where NAME is not null ;  -- index invalid


-- 8. LIKE 非覆盖索引下: 以通配符开头['$abc...'] MYSQL 索引失效会变成全表扫描操作
-- type: index
explain select name from staffs where NAME like '%July%'; -- valid
explain select age from staffs where NAME like '%July%'; -- valid
explain select name, add_time from staffs where NAME like '%July%'; -- invalid
-- type: all
explain select name, add_time from staffs where NAME like '%July%'; -- invalid

-- type: index
explain select name from staffs where NAME like '%July'; -- valid
-- type: all
explain select name, add_time from staffs where NAME like '%July'; -- invalid

-- type: range
explain select name from staffs where NAME like 'July%'; -- valid
explain select name, add_time from staffs where NAME like 'July%'; -- valid


-- 9. 字符串不加单引号索引失效

explain select name from staffs where NAME = 200; -- valid
explain select name, add_time from staffs where NAME = 200; -- invalid


-- 10. 少用or, 用它连接时会索引失效
explain select name, add_time from staffs where NAME = 'July' or age = 12; -- invalid
explain select name from staffs where NAME = 'July' or age = 12; -- valid
explain select name, add_time from staffs where NAME = 'July'; -- valid
explain select name, add_time from staffs where NAME = 'July' and age = 12; -- valid




-- sample
create table test03(
  a int primary key not null auto_increment,
  c1 char(10),
  c2 char(10),
  c3 char(10),
  c4 char(10),
  c5 char(10)
);

insert into test03(c1,c2,c3,c4,c5) values('a1','a2', 'a3', 'a4','a5');
insert into test03(c1,c2,c3,c4,c5) values('b1','b2', 'b3', 'b4','b5');
insert into test03(c1,c2,c3,c4,c5) values('c1','c2', 'c3', 'c4','c5');
insert into test03(c1,c2,c3,c4,c5) values('d1','d2', 'd3', 'd4','d5');
insert into test03(c1,c2,c3,c4,c5) values('e1','e2', 'e3', 'e4','e5');

select * from test03;

create index IDX_C1_C2_C3_C4 on test03(c1, c2, c3, c4) ;

## ref
-- all valid
-- type: ref, extra: using where
explain select c1, c2, c3, c4, c5 from test03 where c1 = 'a1' and c2 = 'a2' and c3 = 'a3' and c4 = 'a4' and c5 = 'a5';
explain select c1, c2, c3, c4, c5 from test03 where c3 = 'a3' and c4 = 'a4' and c5 = 'a5'; -- invalid
-- same the follow 3 sql:
-- type: ref, extra: null
explain select c1, c2, c3, c4, c5 from test03 where c1 = 'a1' and c2 = 'a2' and c3 = 'a3' and c4 = 'a4';
explain select c1, c2, c3, c4, c5 from test03 where c1 = 'a1' and c3 = 'a3' and c2 = 'a2' and c4 = 'a4';
explain select c1, c2, c3, c4, c5 from test03 where c3 = 'a3' and c1 = 'a1' and c2 = 'a2' and c4 = 'a4';
explain select c1, c2, c3, c4, c5 from test03 where c1 = 'a1' and c2 = 'a2' and c3 = 'a3' ;
explain select c1, c2, c3, c4, c5 from test03 where c1 = 'a1' and c2 = 'a2' ;
explain select c1, c2, c3, c4, c5 from test03 where c1 = 'a1' ;

-- type: ref, extra: using index
explain select c1, c2, c3, c4 from test03 where c1 = 'a1' and c2 = 'a2' and c3 = 'a3' and  c4 = 'a4' and c5 = 'a5';
explain select c1, c2, c3, c4 from test03 where c1 = 'a1' and c2 = 'a2' and c3 = 'a3' and  c4 = 'a4';
explain select c1, c2, c3, c4 from test03 where c1 = 'a1' and c3 = 'a3' and c2 = 'a2' and  c4 = 'a4';
explain select c1, c2, c3, c4 from test03 where c3 = 'a3' and c1 = 'a1' and c2 = 'a2' and  c4 = 'a4';
explain select c1, c2, c3, c4 from test03 where c1 = 'a1' and c2 = 'a2' and c3 = 'a3' ;
explain select c1, c2, c3, c4 from test03 where c1 = 'a1' and c2 = 'a2';
explain select c1, c2, c3, c4 from test03 where c1 = 'a1' ;




## Range
-- valid, and type: range, extra: Using where; Using index
explain select c1, c2, c3, c4 from test03 where c1 = 'a1' and c2 = 'a2' and c3 > 'a3' and  c4 = 'a4';
explain select c1, c2, c3, c4 from test03 where c1 = 'a1' and c2 = 'a2' and  c4 = 'a4' and c3 > 'a3';
-- valid, and type: range, extra: Using index condition
explain select c1, c2, c3, c4, c5 from test03 where c1 = 'a1' and c2 = 'a2' and c3 > 'a3' and  c4 = 'a4';

-- valid, and type: range, extra: Using where; Using index
explain select c1, c2, c3, c4 from test03 where c1 = 'a1' and c2 = 'a2' and  c4 > 'a4' and c3 = 'a3' ;
-- valid, and type: range, extra: Using index condition
explain select c1, c2, c3, c4, c5 from test03 where c1 = 'a1' and c2 = 'a2' and  c4 > 'a4' and c3 = 'a3' ;




## order by
-- type: ref, ref: 2, because c3 break, and c3 used to order by
explain select c1, c2, c3, c4, c5 from test03 where c1 = 'a1' and c2 = 'a2' and  c4 = 'a4' order by c3;
explain select c1, c2, c3, c4 from test03 where c1 = 'a1' and c2 = 'a2' and  c4 = 'a4' order by c3;
explain select c1, c2, c3, c4 from test03 where c1 = 'a1' and c2 = 'a2' order by c3;
explain select c1, c2, c3, c4, c5 from test03 where c1 = 'a1' and c2 = 'a2' order by c3;

-- type: ref, extra: Using index condition; Using filesort
-- this is because c3 break
explain select c1, c2, c3, c4, c5 from test03 where c1 = 'a1' and c2 = 'a2' order by c4;
explain select c1, c2, c3, c4 from test03 where c1 = 'a1' and c2 = 'a2' order by c4;
-- type: ref, extra: Using index condition
explain select c1, c2, c3, c4, c5 from test03 where c1 = 'a1' and c2 = 'a2' order by c3, c4;
-- type: ref, extra: Using where; Using index
explain select c1, c2, c3, c4 from test03 where c1 = 'a1' and c2 = 'a2' order by c3, c4;
-- type: ref, extra: Using where; Using index; Using filesort
explain select c1, c2, c3, c4 from test03 where c1 = 'a1' and c2 = 'a2' order by c4, c3;
-- type: ref, extra: Using where; Using index
explain select c1, c2, c3, c4 from test03 where c1 = 'a1' and c2 = 'a2' order by c3, c2;
-- type: ref, extra: Using where; Using index
explain select c1, c2, c3, c4 from test03 where c1 = 'a1' and c2 = 'a2' order by c2, c3;
-- type: ref, extra: Using index condition; Using where
explain select c1, c2, c3, c4 from test03 where c1 = 'a1' and c2 = 'a2' and c5 = 'a5' order by c2, c3;






## group by
-- type: ref, extra: Using where; Using index
explain select c1, c2, c3, c4 from test03 where c1 = 'a1' and c4 = 'a4' group by c2, c3;
explain select c1, c2, c3 from test03 where c1 = 'a1' group by c2, c3;
-- type: ref, extra: Using where; Using index; Using temporary; Using filesort
explain select c1, c2, c3, c4 from test03 where c1 = 'a1' and c4 = 'a4' group by c3, c2;

