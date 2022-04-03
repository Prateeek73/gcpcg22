package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TraineeController {
    private Map<Integer, Trainee> store = new HashMap<>();


    public TraineeController() {
        Trainee trainee1 = new Trainee();
        trainee1.setId(1);
        trainee1.setAge(21);
        trainee1.setName("subham");
        store.put(1, trainee1);

        Trainee trainee2 = new Trainee();
        trainee2.setId(2);
        trainee2.setAge(21);
        trainee2.setName("prateek");
        store.put(2, trainee2);


    }


    @GetMapping("/greet/view")
    public ModelAndView greet() {
        String message = "Welcome to spring webmvc";
        ModelAndView modelAndView = new ModelAndView("welcome", "msg", message);
        return modelAndView;
    }

    // /trainees/trainee/view?id=1
    @GetMapping("/trainees/trainee/view")
    public ModelAndView fetchTraineeDetails(@RequestParam("id") int id) {
        Trainee trainee = store.get(id);
        ModelAndView modelAndView = new ModelAndView("traineedetails", "trainee", trainee);
        return modelAndView;
    }

}
