# Write your MySQL query statement below

select Person.firstname as firstname,Person.lastname as lastname,Address.city as city,Address.state as state
from Person LEFT JOIN Address
on Person.personId = Address.personId

