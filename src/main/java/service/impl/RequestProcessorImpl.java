package service.impl;

import constant.MenuOption;
import dto.Response;
import service.ConvertService;
import service.MenuOptionProcessor;
import service.RequestProcessor;

import javax.xml.bind.JAXBException;

import static constant.MessageConstant.SERVER_RESPONSE_UNKNOWN_MENU_OPTION_MESSAGE;
import static constant.ResponseStatusConstant.BAD_REQUEST;
import static constant.ResponseStatusConstant.OK;
import static java.util.Objects.isNull;

public class RequestProcessorImpl implements RequestProcessor {

    private ConvertService convertService = new ConvertServiceImpl();
    private MenuOptionProcessor menuOptionProcessor = new MenuOptionProcessorImpl();

    @Override
    public Response processRequest(String request) throws JAXBException {
        MenuOption menuOption = convertService.convertStringToMenuOption(
                convertService.extractSubStringByNumber(request, 0)
        );
        if (isNull(menuOption)) {
            return new Response(BAD_REQUEST, SERVER_RESPONSE_UNKNOWN_MENU_OPTION_MESSAGE);
        }
        return new Response(OK, menuOptionProcessor.processOption(menuOption, request));
    }
}
