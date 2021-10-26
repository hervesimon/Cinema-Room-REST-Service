package cinema.domain;

import java.util.UUID;

public class RefundToken {
    private UUID token;

    public RefundToken(UUID token) {
        this.token = token;
    }

    public RefundToken() {
    }

    public UUID getToken() {
        return token;
    }

}
