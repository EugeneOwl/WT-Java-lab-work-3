package service.impl;

import entity.Student;
import entity.Students;
import repository.StudentRepository;
import repository.impl.StudentRepositoryImpl;
import service.StudentService;

import javax.xml.bind.JAXBException;

public class StudentServiceImpl implements StudentService {

    private StudentRepository repository = new StudentRepositoryImpl();

    @Override
    public Student create(Student student) throws JAXBException {
        return repository.create(student);
    }

    @Override
    public Student findById(Long id) throws JAXBException {
        return repository.findById(id);
    }

    @Override
    public void saveAll(Students students) throws JAXBException {
        repository.saveAll(students);
    }

    @Override
    public Students getAll() throws JAXBException {
        return repository.getAll();
    }
}
