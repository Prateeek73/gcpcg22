package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/trainees")
@RestController
public class TraineeController {

    private Map<Integer,Trainee>store=new HashMap<>();

    int generatedId;

    public int generateId(){
        return ++generatedId;
    }

/*
    @GetMapping("/byid/{id}")
    public Trainee fetchTrainee(@PathVariable("id") int idArg){
        Trainee trainee=store.get(idArg);
        return trainee;
    }*/

    //@RequestMapping(path="/byid/{id}",method=RequestMethod.GET)
    @GetMapping("/byid/{id}")
    public ResponseEntity<Trainee> fetchTrainee(@PathVariable("id") int idArg){
        Trainee trainee=store.get(idArg);
        ResponseEntity<Trainee> responseEntity=new ResponseEntity<>(trainee, HttpStatus.OK);
        return responseEntity;
    }

/*
    @PostMapping("/add")
    public Trainee addTrainee(@RequestBody Trainee requestData){
        int newId=generateId();
        requestData.setId(newId);
        store.put(newId, requestData);
        return requestData;
    }
*/

    //@RequestMapping(path="/add",method=RequestMethod.POST)
    @PostMapping("/add")
    public ResponseEntity<Trainee> addTrainee(@RequestBody Trainee requestData){
        int newId=generateId();
        requestData.setId(newId);
        store.put(newId, requestData);
        ResponseEntity<Trainee>responseEntity=new ResponseEntity<>(requestData,HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping("/update")
    public Trainee updateTrainee(@RequestBody Trainee newRequestData){
      Trainee trainee=store.get(newRequestData.getId());
      trainee.setAge(newRequestData.getAge());
      trainee.setName(newRequestData.getName());
      return trainee;
    }

    @DeleteMapping("/delete/byid/{id}")
    public String deleteById(@PathVariable int id){
        store.remove(id);
        return "trainee delete for id="+id;
    }

}
