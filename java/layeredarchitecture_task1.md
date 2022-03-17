**layered architecture task , store will be be hashmap type**

Customer{

id : long

firstName:String

lastName: String

balance: double

++ getters setters

}


ICustomerDao{
//keep Map < Long, Customer >//for storage

addCustomer(Customer customer): void

findById(long id): Customer

updateCustomer(Customer customer): Customer

findAll(): List< Customer >

}

ICustomerService{

addCustomer(String firstName, String lastName, double balance)

findById(long id): Customer


findCustomersByFirstName(String firstname):List< Customer >


debit(long customerId, double value) : Customer

}

Validations

length of firstname, lastname  can't be less than 2, and can't be greater than 10

minimum balance can't be less than 3000



FrontEnd{

}


CustomerMain{

}

