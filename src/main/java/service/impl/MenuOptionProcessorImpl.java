package service.impl;

import constant.MenuOption;
import entity.Student;
import org.apache.commons.lang3.StringUtils;
import service.ConvertService;
import service.MenuOptionProcessor;
import service.StudentService;

import javax.xml.bind.JAXBException;

import java.util.Objects;

import static constant.MenuOption.UNKNOWN_OPTION;
import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public class MenuOptionProcessorImpl implements MenuOptionProcessor {

    private StudentService studentService = new StudentServiceImpl();
    private ConvertService convertService = new ConvertServiceImpl();

    @Override
    public String processOption(MenuOption menuOption, String request) throws JAXBException {
        switch (menuOption) {
            case ADD:
                return processAddOption(request);
            case VIEW_ALL:
                return processViewAllOption();
            case FIND_BY_ID:
                return processFindById(request);
        }
        return UNKNOWN_OPTION.getLabel();
    }

    private String processAddOption(String request) throws JAXBException {
        String name = convertService.extractSubStringByNumber(request, 1);
        if (isNull(name)) {
            return EMPTY;
        }
        int age = convertService.convertStringToInt(convertService.extractSubStringByNumber(request, 2));
        if (age == -1) {
            return EMPTY;
        }
        return studentService.create(new Student(0L, name, age)).toString();
    }

    private String processViewAllOption() throws JAXBException {
        return studentService.getAll().toString();
    }

    private String processFindById(String request) throws JAXBException {
        Long id = convertService.convertStringToLong(convertService.extractSubStringByNumber(request, 1));
        Student found = studentService.findById(id);
        return isNull(found) ? EMPTY : found.toString();
    }
}
