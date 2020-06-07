
-- Student

delete from Student;

insert into Student(code, name, gender, birthday, address, createdBy, updatedBy)
values
      ('S0001', 'Tom', 'M', '2001-03-05', null, 'TEST', 'TEST')
    , ('S0002', 'Ted', 'M', '2001-06-12', null, 'TEST', 'TEST')
    , ('S0003', 'Mary', 'F', '2001--9-12', 'Chicago', 'TEST', 'TEST')
;
