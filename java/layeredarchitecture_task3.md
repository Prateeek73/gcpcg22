**layered architecture task , spring boot, hibernate, jpa, rest**

sprint 1 - hashmap as storage

sprint 2 - database as storage

sprint 3 - Add restpoints

Blogger{

id : long

firstName:String

lastName: String


++ getters setters

}


IBloggerDao{


addBlogger(Blogger blogger): void

findById(long id): Blogger

updateBlogger(Blogger blogger): Blogger

findAll(): List< Blogger >

}

IBloggerService{

register(String firstName, String lastName)

findById(long id): Blogger

changeBloggerName(id, newFirstName, newLastName)


}


Add restpoints

1) add blogger

2) find blogger by id

3) Change blogger name


Validations

length of firstname, lastname  can't be less than 2, and can't be greater than 10




FrontEnd{

}




