package entity;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

import static constant.ServerConstant.XML_ROOT;
import static constant.ServerConstant.XML_STUDENT_NODE;
import static javax.xml.bind.annotation.XmlAccessType.FIELD;

@XmlRootElement(name = XML_ROOT)
@XmlAccessorType(FIELD)
public class Students {

    @XmlElementWrapper
    @XmlElement(name = XML_STUDENT_NODE)
    private List<Student> students = new ArrayList<>();

    public Students() {
    }

    public Students(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Students{" +
                "students=" + students +
                '}';
    }
}
