package cinema.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stats {
    @JsonProperty("current_income")
    final private int currentIncome;
    @JsonProperty("number_of_available_seats")
    final private int numberOfAvailableSeats;

    @JsonProperty("number_of_purchased_tickets")
    final private int numberOfPurchasedTickets;

    public Stats(int currentIncome, int numberOfAvailableSeats, int numberOfPurchasedTickets) {
        this.currentIncome = currentIncome;
        this.numberOfAvailableSeats = numberOfAvailableSeats;
        this.numberOfPurchasedTickets = numberOfPurchasedTickets;
    }

}
