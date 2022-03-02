
Customer{

id: long

name: String

age: int

department: String

}


CustomerDto{

name: String

age: int

}


CustomerService{

 List< CustomerDto >    sortCustomersById(List< Customer > list)


}
