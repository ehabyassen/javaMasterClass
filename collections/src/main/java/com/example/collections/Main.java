package com.example.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Comparator.comparingDouble;

public class Main {

    public static void main(String[] args) {
        Theater theater = new Theater("Teatro Masr", 8, 12);

        theater.reserveSeat("D12");
        theater.reserveSeat("D12");
        theater.reserveSeat("B13");

        printSeats(theater.getSeats());
        List<Theater.Seat> reversedSeats = new ArrayList<>(theater.getSeats());
        Collections.reverse(reversedSeats);
        printSeats(reversedSeats);


        List<Theater.Seat> priceSeats = new ArrayList<>(theater.getSeats());
        priceSeats.add(theater.new Seat("B00", 13.00));
        priceSeats.add(theater.new Seat("A00", 13.00));
        Collections.sort(priceSeats, comparingDouble(Theater.Seat::getPrice));

        printSeats(priceSeats);

    }

    public static void printSeats(List<Theater.Seat> seats) {
        seats.forEach(System.out::print);
        System.out.println("-".repeat(50));
    }

}
