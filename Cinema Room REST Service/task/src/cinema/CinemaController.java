package cinema;

import cinema.domain.*;
import cinema.exception.NotAuthorizedException;
import cinema.service.CinemaService;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CinemaController {

    private CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping(value = "/seats", produces = "application/json")
    public @ResponseBody
    Cinema availableSeats() {
        return cinemaService.getCinema();
    }


    @PostMapping(value = "/purchase", produces = "application/json")
    public @ResponseBody
    Ticket purchaseSeat(@RequestBody Seat seat) {
        return cinemaService.purchase(seat);

    }

    @PostMapping(value = "/return", produces = "application/json")
    public @ResponseBody
    ReturnedTicket returnTicket(@RequestBody RefundToken token) {
        return cinemaService.returnTicket(token);

    }

    @PostMapping(value = "/stats", produces = "application/json")
    public @ResponseBody
    Stats returnTicket(@RequestParam @Nullable String password) {
        if (null == password || !password.equals("super_secret")) {
            throw new NotAuthorizedException();
        }
        return cinemaService.stats();

    }


}
