package com.example.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Theater {

    private final String name;
    private List<Seat> seats = new ArrayList<>();

    public Theater(String name, int rows, int columns) {
        this.name = name;
        for (char row = 'A'; row <= 'A' + rows - 1; row++) {
            for (int seatNum = 1; seatNum <= columns; seatNum++) {
                double price = 12.00;
                if ((row < 'D') && (seatNum >= 4 && seatNum <= 9)) {
                    price = 14.00;
                } else if ((row > 'F') || (seatNum < 4 || seatNum > 9)) {
                    price = 7.00;
                }
                seats.add(new Seat(row + String.format("%02d", seatNum), price));
            }
        }
    }

    public String getName() {
        return name;
    }

    public void reserveSeat(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber, 0);
        int index = Collections.binarySearch(seats, requestedSeat);
        if (index >= 0) {
            seats.get(index).reserve();
        } else {
            System.out.println("Seat not found.");
        }
    }

    public void cancelSeatReservation(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber, 0);
        int index = Collections.binarySearch(seats, requestedSeat, null);
        if (index >= 0) {
            seats.get(index).cancel();
        } else {
            System.out.println("Seat not found.");
        }
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void listSeats() {
        seats.forEach(System.out::println);
    }

    public class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean reserved;

        private double price;

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        public double getPrice() {
            return price;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public void reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println(this + " is reserved.");
            } else {
                System.out.println("Seat is already reserved.");
            }
        }

        public void cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println(this + " is available.");
            } else {
                System.out.println("Seat is not reserved.");
            }
        }

        @Override
        public String toString() {
            return "Seat{" +
                    "seatNumber='" + seatNumber + '\'' +
                    ", reserved=" + reserved +
                    ", price=" + price +
                    '}';
        }

        @Override
        public int compareTo(Seat seat) {
            return this.getSeatNumber().compareToIgnoreCase(seat.getSeatNumber());
        }
    }
}
