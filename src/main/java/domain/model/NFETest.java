package domain.model;

import lombok.Getter;

public class NFETest {
    @Getter
    private final String id;
    @Getter
    private final String name;
    @Getter
    private final String color;

    private NFETest(String id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public static NFETest create(String id, String name, String color) {
        return new NFETest(id, name, color);
    }
}
