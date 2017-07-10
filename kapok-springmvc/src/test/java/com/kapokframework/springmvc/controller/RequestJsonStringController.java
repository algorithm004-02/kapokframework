package com.kapokframework.springmvc.controller;


import com.kapokframework.springmvc.WapperMap;
import com.kapokframework.springmvc.annotations.RequestJsonString;
import com.kapokframework.springmvc.entity.Car;
import com.kapokframework.springmvc.entity.Person;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.*;

import static com.kapokframework.springmvc.views.json.JsonView.EXCLUDE;
import static com.kapokframework.springmvc.views.json.JsonView.RESULT;


/**
 * @author Will WM. Zhang
 * @since 2017-01-04 16:12
 */
@Controller
@RequestMapping("/jsonstring")
public class RequestJsonStringController {

    @RequestMapping("/setPerson")
    public void setPerson(@RequestJsonString Person person, Person person1) {
        System.out.println("person=" + person);
        System.out.println("person1=" + person1);
    }

    @RequestMapping("/setPersonWithCars")
    public void setPersonWithCars(@Valid @RequestJsonString Person personWithCars, Person person1) {
        System.out.println(personWithCars);
        System.out.println(personWithCars.getCars());
        System.out.println(person1);
    }

    @RequestMapping("/setPersons")
    public void setPersons(@Valid @RequestJsonString List<Person> persons) {
        System.out.println("size=" + persons.size());
        System.out.println("persons[0]=" + persons.get(0));
    }

    @RequestMapping("/setPersonsWithCars")
    public void setPersonsWithCars(@Valid @RequestJsonString List<Person> persons) {
        System.out.println("size=" + persons.size());
        System.out.println("persons[0]=" + persons.get(0));
    }

    @RequestMapping("/setPersonsMap")
    public void setPersonsMap(@RequestJsonString Map<String, Person> personsMap) {
        System.out.println(personsMap.get("person1"));
        System.out.println(personsMap.get("person2"));
    }

    @RequestMapping("/setPersonsWapperMap")
    public void setPersonsWapperMap(@Valid @RequestJsonString WapperMap<String, Person> personsMap) {
        System.out.println(personsMap.get("person1"));
        System.out.println(personsMap.get("person2"));
    }

    @RequestMapping("/getPerson")
    public String getPerson(Model model) {

        Person person = new Person();
        person.setName("zhangxxx");
        person.setGender("male");
        person.setDateOfBirth(new Date());
        person.setCreateTime(new DateTime());

        List<Car> cars = new LinkedList<>();

        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        car1.setBrand("BMW");
        car2.setBrand("法拉利");
        car3.setBrand("东风标致");

        cars.add(car1);
        cars.add(car2);

        person.setCar(car3);
        person.setCars(cars);

        model.addAttribute(EXCLUDE, "car,cars");
        model.addAttribute(RESULT, person);

        return "jsonView";
    }

    @RequestMapping("/getPersons")
    public String getPersons(Model model) {

        List<Person> persons = new ArrayList<>();

        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();

        person1.setId(1l);
        person1.setName("zhangxxx");
        person2.setId(2l);
        person2.setName("lixxx");
        person3.setId(3l);
        person3.setName("wangxxx");

        persons.add(person1);
        persons.add(person2);
        persons.add(person3);

        model.addAttribute(EXCLUDE, "car,cars");
        model.addAttribute(RESULT, persons);

        return "jsonView";
    }

    @RequestMapping("/getPersonResponseBody")
    @ResponseBody
    public Person getPersonResponseBody() {
        Person person = new Person();
        person.setName("xiaguangjun");
        person.setGender("female");
        person.setDateOfBirth(new Date());
        person.setCreateTime(new DateTime());
        return person;
    }

    @RequestMapping("/exception")
    public void exception(@RequestJsonString Person person) {
        System.out.println("person=" + person);
    }

    @RequestMapping("/setPersonValidator")
    public void setPersonValidator(@Valid @RequestJsonString Person person) {
        System.out.println("person=" + person);
    }

}
