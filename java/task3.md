**package, inheritance, access specifier, equals method, interface**

Base Package : com.mycompany

Employee{

id: long

name: String


}


Developer extends Employee{

createdSoftware: String

}


Tester extends Employee{

testedSoftware: String

}

IEmployeeService(interface)
{
/*
 find employee by id from the store
*/

 Employeee findById(long id);

/*
Add Developer in store
*/

 Developer addDeveloper(long id, String name, String createdSoftware)
 
 
/*
Add Tester in store
*/

 Tester addTester(long id, String name, String testedSoftware);

}


implementation class EmployeeServiceImpl implements IEmployeeService{

store of min. 2 employees // one employee will be Developer, One will be Tester 

 ....
 
 
 }


// Main class

EmployeeMain{

//print details of an employee by id

} 





