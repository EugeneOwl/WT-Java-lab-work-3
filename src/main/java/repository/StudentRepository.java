package repository;

import entity.Student;
import entity.Students;

import javax.xml.bind.JAXBException;

public interface StudentRepository {

    Student create(Student student) throws JAXBException;

    Student findById(Long id) throws JAXBException;

    void saveAll(Students students) throws JAXBException;

    Students getAll() throws JAXBException;
}
