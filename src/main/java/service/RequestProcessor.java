package service;

import dto.Response;

import javax.xml.bind.JAXBException;

public interface RequestProcessor {

    Response processRequest(String request) throws JAXBException;
}
