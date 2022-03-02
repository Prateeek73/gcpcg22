

Employee{

id :int

name: String


}



enum Sort{

BYNAME,

BYID

}


EmployeeService{


 sortEmployees(List<Employee>list , Sort sort) : List<Employee>

}

