package repository.impl;

import entity.Student;
import entity.Students;
import repository.StudentRepository;
import repository.StudentRepositoryHelper;

import javax.xml.bind.JAXBException;

public class StudentRepositoryImpl implements StudentRepository {

    private StudentRepositoryHelper helper = new StudentRepositoryHelperImpl();

    @Override
    public Student create(Student student) throws JAXBException {
        Students students = getAll();
        Long lastId = getLastId(students);
        student.setId(lastId + 1);
        students.getStudents().add(student);
        saveAll(students);
        return student;
    }

    @Override
    public Student findById(Long id) throws JAXBException {
        return getAll()
                .getStudents()
                .stream()
                .filter(it -> it.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void saveAll(Students students) throws JAXBException {
        helper.getMarshaller().marshal(students, helper.getEntityFile());
    }

    @Override
    public Students getAll() throws JAXBException {
        return (Students) helper.getUnmarshaller().unmarshal(helper.getEntityFile());
    }

    private Long getLastId(Students students) {
        return students
                .getStudents()
                .stream()
                .mapToLong(Student::getId)
                .max()
                .orElse(0);
    }
}
