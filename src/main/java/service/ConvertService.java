package service;

import constant.MenuOption;

public interface ConvertService {

    MenuOption convertStringToMenuOption(String s);

    String extractSubStringByNumber(String s, int number);

    Long convertStringToLong(String s);

    int convertStringToInt(String s);
}
