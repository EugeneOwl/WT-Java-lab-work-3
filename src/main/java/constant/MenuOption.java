package constant;

public enum MenuOption {
    VIEW_ALL(1, "view all"),
    ADD(2, "add"),
    FIND_BY_ID(3, "find by id"),
    UNKNOWN_OPTION(-1, "(unknown option)");

    private int number;
    private String label;

    MenuOption(int number, String label) {
        this.number = number;
        this.label = label;
    }

    public int getNumber() {
        return number;
    }

    public String getLabel() {
        return label;
    }
}
