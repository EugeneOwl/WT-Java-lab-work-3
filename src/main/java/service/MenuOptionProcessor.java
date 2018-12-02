package service;

import constant.MenuOption;

import javax.xml.bind.JAXBException;

public interface MenuOptionProcessor {

    String processOption(MenuOption menuOption, String request) throws JAXBException;
}
