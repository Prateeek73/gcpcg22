package com.trainingapps.schoolps.main;

import com.trainingapps.schoolps.frontend.FrontEnd;
import com.trainingapps.schoolps.service.IStudentService;

public class SchoolMsApp {
    public static void main(String args[]){
        FrontEnd frontEnd=new FrontEnd();
        frontEnd.runUI();
    }
}