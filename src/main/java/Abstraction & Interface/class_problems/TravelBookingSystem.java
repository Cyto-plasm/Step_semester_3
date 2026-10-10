
import java.util.Scanner;

abstract class TravelBooking {
    double distance;

    static final double BOOKING_FEE = 50.0;

    TravelBooking(double distance) {
        this.distance = distance;
    }

    abstract double calculateBaseFare();

    abstract String getMode();

    final double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class Bus extends TravelBooking {
    Bus(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return distance * 2.0;
    }

    String getMode() {
        return "BUS";
    }
}

class Train extends TravelBooking {
    Train(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return distance * 1.5;
    }

    String getMode() {
        return "TRAIN";
    }
}

class Flight extends TravelBooking {
    Flight(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return 2500 + distance * 4.0;
    }

    String getMode() {
        return "FLIGHT";
    }
}

public class TravelBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        TravelBooking[] bookings = new TravelBooking[n];

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            if (mode.equals("BUS")) {
                bookings[i] = new Bus(distance);
            } else if (mode.equals("TRAIN")) {
                bookings[i] = new Train(distance);
            } else {
                bookings[i] = new Flight(distance);
            }
        }

        for (TravelBooking booking : bookings) {
            System.out.printf("%s: %.2f%n",
                    booking.getMode(), booking.calculateTotal());
        }

        sc.close();
    }
}
