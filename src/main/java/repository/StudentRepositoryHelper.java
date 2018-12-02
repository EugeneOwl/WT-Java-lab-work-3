package repository;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public interface StudentRepositoryHelper {

    Marshaller getMarshaller() throws JAXBException;

    Unmarshaller getUnmarshaller() throws JAXBException;

    File getEntityFile();
}
