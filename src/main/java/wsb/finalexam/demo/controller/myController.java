/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wsb.finalexam.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.entity.Person;
import model.jpacontroller.PersonJpaController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Habib Santoso
 * @nim 20180140122
 */
@RestController
@CrossOrigin
@RequestMapping("/PERSON")
public class myController {
    Person person = new Person();
    PersonJpaController ctrl = new PersonJpaController();
    
    @GetMapping("/{id}")
    public List<Person> getNameById(@PathVariable("id") int id) {
        List<Person> dummy = new ArrayList<>(); // Declare new LIST
        try {
            person = ctrl.findPerson(id); // get data from db
            dummy.add(person); // fill data from db to list
        } catch (Exception e) {
            //dummy = Collections.unmodifiableList(person); // data not found
        }
        return dummy;
    }
    
    @GetMapping
    public List<Person> getAll(){
        List<Person> dummy = new ArrayList<>(); // Declare new LIST
        try {
            dummy = ctrl.findPersonEntities(); // fill data from db to list
        } catch (Exception e) {
            //dummy = Collections.unmodifiableList(person); // data not found
        }
        return dummy;
    }
    
    
}
