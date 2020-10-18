package com.example.mongodemodb.service;

import com.example.mongodemodb.model.Person;
import com.example.mongodemodb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService
{
    @Autowired
    private PersonRepository personRepository;

    //create operation
    public Person create(String firstName, String lastName, int age)
    {
        return personRepository.save(new Person(firstName,lastName,age));
    }

    //retrieve operation
    public List<Person> getAll()
    {
        return personRepository.findAll();
    }

    public Person getByFirstName(String firstName)
    {
        return personRepository.findByFirstName(firstName);
    }

    //Update Operation
    public Person update(String firstName, String lastName, int age)
    {
        Person person = personRepository.findByFirstName(firstName);
        System.out.println("person.toString() = " + person.toString());
        person.setLastName(lastName);
        person.setAge(age);
        return personRepository.save(person);
    }

    //Delete operation
    public void deleteAll()
    {
        personRepository.deleteAll();
    }

    public void delete(String firstName)
    {
        Person person = personRepository.findByFirstName(firstName);
        personRepository.delete(person);
    }
}
