# near-grade-564   MGNREGA (Mini_Project_Console_Base)
MNREGA(The Mahatma Gandhi National Rural Employment Guarantee Act ) is a scheme by which unskilled people of rural India are guaranteed to have 100 days of paid work. Main objective of this project is to manage employments offered through this scheme.There are two users of this system : 

 a. BDO (Block Development Officer) 
 b. GPM (Gram Panchayat member)
System works in the following way:
A project is created by BDO. Project is where people are assigned to.
Before assigning anybody to a project(done by Gram Panchayat member) his/her data must be inserted into the system.



Important Credentials
BDO

Email_id - vishal

Password - 123

Functions of BDO:
1. Login into their account.
2. Create a project.
3. View List Of Project.
4. Create new Gram Panchayat Member(GPM).
5. View all the GPM.
6. Allocate  Project to GPM
7. See List of Employee working on that Project and their wages.


GPM

Email_id - vishal@gmail.com

Password - vishal@123

Authors
Vishal Girhepunje


Function of Gram Panchayet member:
1. Login into their Account.
2. Create Employee.
3. View the Details of Employee.
4. Assign Employee to a Project.
5. View total number of days Employee worked in a project and also their wages.



+-----------------------+
| Tables_in_aht_mgnrega |
+-----------------------+
| employee              |
| gpm                   |          |
| project               |
| project_employee      |
+-----------------------+

Employee

+-------+--------+------------+----------+---------------+--------+
| eid   | ename  | emobile    | eaddress | etotaldaywork | ewages |
+-------+--------+------------+----------+---------------+--------+
|     1 | Vivek  | 9834196967 | Bhandara |            12 | 12000  |
|    54 | gghgh  | 4512698564 | jhkkjg   |            45 | 251    |
|   102 | nfkf   | 54546552   | jnnjkf   |            45 | 245    |
|   206 | raghaw | 2356898956 | kamthi   |            54 | 560    |
|   401 | fhjnj  | 4568792586 | klkkjkj  |            42 | 221    |
|   456 | garima | 9595956577 | latur    |            54 | 540    |
| 12121 | jhfkjs | 9856423258 | kjkiji   |            24 | 400    |
+-------+--------+------------+----------+---------------+--------+

GPM

+-----+---------+----------------+-----------+------------+----------+
| gid | gname   | gemail         | gpassword | gmobile    | gaddress |
+-----+---------+----------------+-----------+------------+----------+
| 102 | vkfgg   | nggk@gmail.com | 64895     | 4568791456 | jjkjhjgh |
| 124 | fgh     | df@mail.com    | 258       | 845698745  | fjdjhfk  |
| 201 | subhash | subah@com      | 564       | 4565456558 | falguni  |
| 401 | raghaw  | ghgh@gmail.com | 546       | 6547897535 | ljhgfdsg |
+-----+---------+----------------+-----------+------------+----------+

Project

+------+--------+----------+------------+
| pid  | pname  | pcost    | pissuedate |
+------+--------+----------+------------+
|  101 | hghj   | 1200     | 2025-12-31 |
|  152 | jhnjnh | 41564655 | 2054-04-23 |
| 2001 | UDAN   | 25000CR  | 2025-02-23 |
+------+--------+----------+------------+

Project_Employee

+------+------+
| pid  | eid  |
+------+------+
|  152 |   54 |
|  101 |    1 |
+------+------+
