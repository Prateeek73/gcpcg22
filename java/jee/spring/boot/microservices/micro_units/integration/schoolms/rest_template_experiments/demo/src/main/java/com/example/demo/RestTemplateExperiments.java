package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateExperiments {

    private String baseDepartmentUrl = "http://localhost:8586/departments";

    @Autowired
    private RestTemplate template;

    public void execute() {
        AddDepartmentRequest request = new AddDepartmentRequest();
        request.setName("test");
        System.out.println("****adding dev department");
        DepartmentDetailsResponse response1 = createDepartment2(request);
        int departmentId = response1.getId();
        display(response1);
        System.out.println("***fetch department by id=" + departmentId);
        DepartmentDetailsResponse response2 = fetchDepartmentById1(departmentId);
        display(response2);

        DepartmentDetailsResponse response3 = fetchDepartmentById2(departmentId);
        display(response3);

        ChangeDepartmentNameRequest changeRequest=new ChangeDepartmentNameRequest();
        changeRequest.setDepartmentId(departmentId);
        changeRequest.setNewName("testing2");
        DepartmentDetailsResponse response4=updateDepartment2(changeRequest);
        display(response4);
    }


    void display(DepartmentDetailsResponse department) {
        System.out.println(department.getId() + " " + department.getName());
    }

    public DepartmentDetailsResponse fetchDepartmentById1(int id) {
        String url = baseDepartmentUrl + "/byid/" + id;
        DepartmentDetailsResponse response = template.getForObject(url, DepartmentDetailsResponse.class);
        return response;
    }



    public DepartmentDetailsResponse fetchDepartmentById2(int id){
        String url=baseDepartmentUrl+"/byid/"+id;
        ResponseEntity<DepartmentDetailsResponse> responseEntity=template.getForEntity(url,DepartmentDetailsResponse.class);
        HttpStatus responseStatus= responseEntity.getStatusCode();
        System.out.println("response status code="+responseStatus);
        DepartmentDetailsResponse response=responseEntity.getBody();
        return response;
    }



    public DepartmentDetailsResponse createDepartment1(AddDepartmentRequest request) {
        String url = baseDepartmentUrl + "/create";
        DepartmentDetailsResponse response = template.postForObject(url, request, DepartmentDetailsResponse.class);
        return response;
    }


    public DepartmentDetailsResponse createDepartment2(AddDepartmentRequest request) {
        String url = baseDepartmentUrl + "/create";
        ResponseEntity<DepartmentDetailsResponse> responseEntity = template.postForEntity(url, request, DepartmentDetailsResponse.class);
        HttpStatus responseStatus= responseEntity.getStatusCode();
        System.out.println("response status code="+responseStatus);
        DepartmentDetailsResponse response=responseEntity.getBody();
        return response;
    }

    public void changeDepartmentName1(ChangeDepartmentNameRequest request){
        String url=baseDepartmentUrl+"/change/name";
        template.put(url,request);
    }

    public DepartmentDetailsResponse updateDepartment2(ChangeDepartmentNameRequest request){
        String url=baseDepartmentUrl+"/change/name";
        HttpEntity requestEntity=new HttpEntity(request);
        ResponseEntity<DepartmentDetailsResponse>responseEntity=template.exchange(url, HttpMethod.PUT,requestEntity,DepartmentDetailsResponse.class);
        HttpStatus responseStatus= responseEntity.getStatusCode();
        System.out.println("response status code="+responseStatus);
        DepartmentDetailsResponse response=responseEntity.getBody();
        return response;
    }

}
