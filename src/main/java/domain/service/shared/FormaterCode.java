package domain.service.shared;

public class FormaterCode {

    public static String format(String code) {
        if (code == null)
            throw new RuntimeException("Code not be null");
        return code.replace("\\s+", "") + "|2|1|1|0000000000000000000000000000000000000000|";
    }
}
