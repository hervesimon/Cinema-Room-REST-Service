package cinema.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Cinema {

    @JsonProperty("total_rows")
    final private int totalRows;
    @JsonProperty("total_columns")
    final private int totalColumns;
    @JsonProperty("available_seats")
    private List<Seat> seats;

    public Cinema(int totalRows, int totalColumns) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        this.seats = this.initSeats(totalRows, totalColumns);
    }

    private ArrayList<Seat> initSeats(int rowNumber, int columnNumber) {
        ArrayList<Seat> seats = new ArrayList<>();
        for (int row = 1; row <= rowNumber; row++) {
            for (int column = 1; column <= columnNumber; column++) {
                seats.add(new Seat(row, column, getPrice(row)));
            }
        }
        return seats;
    }

    private int getPrice(int row) {
        return row <= 4 ? 10 : 8;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
