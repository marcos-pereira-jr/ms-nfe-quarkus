package application.usecase.nfe.add.request;

import lombok.Data;

@Data
public class NFERequest {
    private String id;
    private String name;
    public String color;
}
