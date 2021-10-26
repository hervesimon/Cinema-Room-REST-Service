package cinema.domain;

import java.util.UUID;

public class Ticket {
    final private UUID token;
    final private Seat ticket;

    public Ticket(UUID token, Seat ticket) {
        this.token = token;
        this.ticket = ticket;
    }

    public UUID getToken() {
        return token;
    }

    public Seat getTicket() {
        return ticket;
    }

}
