package infrastructure.msfazenda.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMSFazenda {
    private String xml;
    private String cookie;
}
