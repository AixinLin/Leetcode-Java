select FirstName, LastName, City, State
from Person left join Address
on Person.PersonId = Address.PersonId;

Why does the solution above read, "Approach: Using outer join [Accepted]" yet the code shows left join?
cause we also can use right join by exchange two tables' position