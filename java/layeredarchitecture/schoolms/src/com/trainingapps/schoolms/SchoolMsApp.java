package com.trainingapps.schoolms;

import com.trainingapps.schoolms.frontend.FrontEnd;
import com.trainingapps.schoolms.service.IStudentService;

public class SchoolMsApp {

    public static void main(String args[]){
        FrontEnd frontEnd=new FrontEnd();
        frontEnd.runUI();
    }
}
