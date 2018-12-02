package service.impl;

import constant.MenuOption;
import service.ConvertService;

import java.util.Arrays;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;

public class ConvertServiceImpl implements ConvertService {

    @Override
    public MenuOption convertStringToMenuOption(String s) {
        return Arrays.stream(MenuOption.values())
                .filter(it -> containsIgnoreCase(it.getLabel(), s))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String extractSubStringByNumber(String s, int number) {
        String[] subStrings = s.split(" ");
        if (subStrings.length > number) {
            return subStrings[number];
        }
        return null;
    }

    @Override
    public Long convertStringToLong(String s) {
        try {
            return parseLong(s);
        } catch (NumberFormatException e) {
            return -1L;
        }
    }

    @Override
    public int convertStringToInt(String s) {
        try {
            return parseInt(s);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
