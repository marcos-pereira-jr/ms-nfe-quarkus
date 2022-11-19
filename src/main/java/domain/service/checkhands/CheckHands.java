package domain.service.checkhands;

import lombok.Getter;

public class CheckHands {
    @Getter
    public final String cookie;
    @Getter
    public final String viewState;

    private CheckHands(String cookie, String viewState) {
        this.cookie = cookie;
        this.viewState = viewState;
    }

    public static CheckHands create(String cookie, String viewState) {
        return new CheckHands(cookie, viewState);
    }

}
