package service;

import entity.Student;
import entity.Students;

import javax.xml.bind.JAXBException;

public interface StudentService {

    Student create(Student student) throws JAXBException;

    Student findById(Long id) throws JAXBException;

    void saveAll(Students students) throws JAXBException;

    Students getAll() throws JAXBException;
}
