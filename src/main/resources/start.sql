CREATE KEYSPACE springcloud
    WITH replication = {'class': 'SimpleStrategy','replication_factor':3};

use springcloud;

CREATE TABLE employee2(
                         emp_id  int PRIMARY KEY,
                         emp_name  text ,
                         emp_city text,
                         emp_phone varint
);

select * from employee