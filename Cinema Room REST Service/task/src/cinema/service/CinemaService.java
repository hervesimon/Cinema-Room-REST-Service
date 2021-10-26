package cinema.service;

import cinema.domain.*;
import cinema.exception.AlreadyPurchasedException;
import cinema.exception.InvalidTokenException;
import cinema.exception.UnsupportedPurchaseException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CinemaService {

    private Cinema cinema = new Cinema(9, 9);
    private List<Ticket> purchasedTickets = new ArrayList<>();

    public Cinema getCinema() {
        Cinema availableSeats = new Cinema(cinema.getTotalRows(), cinema.getTotalColumns());
        availableSeats.setSeats(getAvailableSeats());
        return availableSeats;
    }

    public Ticket purchase(Seat seatToBooked) {
        Seat currentSeat = cinema.getSeats().stream()
                .filter(seat -> seat.getRow() == seatToBooked.getRow() && seat.getColumn() == seatToBooked.getColumn())
                .findFirst().orElseThrow(UnsupportedPurchaseException::new);

        if (currentSeat.isBooked()) {
            throw new AlreadyPurchasedException();
        } else {
            currentSeat.setBooked(true);
        }
        Ticket ticket = new Ticket(UUID.randomUUID(), currentSeat);
        purchasedTickets.add(ticket);
        return ticket;
    }

    private List<Seat> getAvailableSeats() {
        return cinema.getSeats()
                .stream().filter(seat -> !seat.isBooked())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ReturnedTicket returnTicket(RefundToken token) {
        Ticket currentTicket = purchasedTickets.stream()
                .filter(ticket -> ticket.getToken().equals(token.getToken()))
                .findFirst().orElseThrow(InvalidTokenException::new);
        Seat currentSeat = cinema.getSeats().stream()
                .filter(seat -> seat.getRow() == currentTicket.getTicket().getRow() && seat.getColumn() == currentTicket.getTicket().getColumn())
                .findFirst().get();
        currentSeat.setBooked(false);
        purchasedTickets = purchasedTickets.stream()
                .filter(ticket -> !ticket.getToken().equals(token.getToken()))
                .collect(Collectors.toCollection(ArrayList::new));
        return new ReturnedTicket(currentSeat);
    }

    public Stats stats() {
        int income = purchasedTickets.stream()
                .map(ticket -> ticket.getTicket().getPrice())
                .reduce(0, Integer::sum);
        int availableSeat = getAvailableSeats().size();

        int purchased = purchasedTickets.size();

        return new Stats(income, availableSeat, purchased);
    }
}
