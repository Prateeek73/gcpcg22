package com.example.jobms.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.jobms.dto.AddJobRequest;
import com.example.jobms.dto.ChangeJobTypeRequest;
import com.example.jobms.dto.JobDetails;
import com.example.jobms.entity.Job;
import com.example.jobms.exceptions.DescriptionOutOfBoundsException;
import com.example.jobms.exceptions.IdNotFoundException;
import com.example.jobms.exceptions.InvalidJobTypeException;
import com.example.jobms.service.IJobService;

@Component
public class FrontEnd {

	@Autowired
	private IJobService service;
	
	public void runUI() {
        try {
        	
        	//adding jobs
        	System.out.println("***Adding Jobs***");
        	AddJobRequest addJobRequest = new AddJobRequest();
        	JobDetails jobDetails = new JobDetails();
        	
        	addJobRequest.setDescription("Tis is description a very big one also pleas accept");
        	addJobRequest.setJobType("Admin");
        	jobDetails = service.addJob(addJobRequest);
        	
        	addJobRequest.setDescription("Tis is description a very big one also pleas accept");
        	addJobRequest.setJobType("Dev");
        	jobDetails = service.addJob(addJobRequest);
        	
        	addJobRequest.setDescription("Tis is description a very big one also pleas accept");
        	addJobRequest.setJobType("HR");
        	jobDetails = service.addJob(addJobRequest);

        	
//        	//finding jobs
//        	System.out.println("***Finding Job***");
//        	Job job = service.findById();
//        	System.out.println("Found : " + job.toString());
//        	
//        	//changing job types
//        	System.out.println("***Changing Job Type***");
//        	service.changeJobType(new ChangeJobTypeRequest(, "HR"));
//        	System.out.println("***Changed Job Type***");
//
//        	
//        } catch(IdNotFoundException ex) {
//        	System.err.println(ex.getMessage());
        } catch(InvalidJobTypeException ex) {
        	System.err.println(ex.getMessage());
        } catch(DescriptionOutOfBoundsException ex) {
        	System.err.println(ex.getMessage());
        } catch(Exception ex) {
        	System.err.println(ex.getMessage());
        } 

    }
	
}
