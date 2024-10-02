package enums;

public enum RegisterFields {

    USERNAME("Alina123456"),
    EMAIL("alina123456@gmail.com"),
    PASSWORD("Alina123456"),
    REPEAT_PASSWORD("Alina123456");

    private final String value;

    RegisterFields(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

