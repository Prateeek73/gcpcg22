**layered architecture task , spring boot, hibernate, jpa, rest**


sprint 1- complete till service layer, verify by manual testing using FrontEnd class

sprint 2 - Add restpoints

Job{

id : long

description : String

type : JobType   (enum contants can be Dev,Testing,HR, Admin)


createdBy: long // recruiter id

++ getters setters

}


IJobDao{


addJob(Job job): void

findById(long id): Job

update(Job job): Job



}

IJobService{

addJob(AddJobRequest requestData): JobDetails

findById(long id): Job

findJobDetailsById(long id):JobDetails

changeJobType(ChangeJobTypeRequest requestdata)



}




Add restpoints

1) add job

2) find job by id




Validations

job description should be between 20-100letters 

job type cant be empty


Recruiter management MS

Entity

Recruiter

{

id: long

name : String

company: String

age: int

}


IRecruiterService {

addRecruiter(AddRecuiterRecquest request) : RecruiterDetails

findRecruiterDetailsById(long recruiterId): RecruiterDetails


}
