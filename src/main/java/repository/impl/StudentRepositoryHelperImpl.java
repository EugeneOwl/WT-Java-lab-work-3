package repository.impl;

import entity.Students;
import repository.StudentRepositoryHelper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import static constant.FileConstant.ARCHIVE_FILE_PATH;
import static java.util.Objects.nonNull;
import static javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT;

public class StudentRepositoryHelperImpl implements StudentRepositoryHelper {

    private JAXBContext jaxbContext;
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;
    private File entityFile;

    @Override
    public Marshaller getMarshaller() throws JAXBException {
        if (nonNull(marshaller)) {
            return marshaller;
        }
        Marshaller marshaller = getJaxbContext().createMarshaller();
        marshaller.setProperty(JAXB_FORMATTED_OUTPUT, true);
        return marshaller;
    }

    @Override
    public Unmarshaller getUnmarshaller() throws JAXBException {
        if (nonNull(marshaller)) {
            return unmarshaller;
        }
        return getJaxbContext().createUnmarshaller();
    }

    @Override
    public File getEntityFile() {
        if (nonNull(entityFile)) {
            return entityFile;
        }
        return new File(ARCHIVE_FILE_PATH);
    }

    private JAXBContext getJaxbContext() throws JAXBException {
        if (nonNull(jaxbContext)) {
            return jaxbContext;
        }
        return JAXBContext.newInstance(Students.class);
    }
}
