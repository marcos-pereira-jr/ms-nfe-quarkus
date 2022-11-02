package domain.model;

import lombok.Getter;

public class NFE {
    @Getter
    private final String id;
    @Getter
    private final String name;
    @Getter
    private final String color;

    private NFE(String id,String name,String color){
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public static NFE create(String id,String name,String color){
        return new NFE(id,name,color);
    }
}
