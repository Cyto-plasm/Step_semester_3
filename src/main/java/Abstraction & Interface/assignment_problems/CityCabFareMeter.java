
import java.util.Scanner;

interface NightService {
}

abstract class Cab {
    double distance;

    Cab(double distance) {
        this.distance = distance;
    }

    abstract double getRate();

    abstract String getType();

    final double calculateDayFare() {
        return Math.max(distance * getRate(), 100.0);
    }

    final double calculateNightFare() {
        if (!(this instanceof NightService)) {
            return -1;
        }

        return calculateDayFare() * 1.20;
    }
}

class Mini extends Cab {
    Mini(double distance) {
        super(distance);
    }

    double getRate() {
        return 10.0;
    }

    String getType() {
        return "MINI";
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double distance) {
        super(distance);
    }

    double getRate() {
        return 14.0;
    }

    String getType() {
        return "SEDAN";
    }
}

class SUV extends Cab implements NightService {
    SUV(double distance) {
        super(distance);
    }

    double getRate() {
        return 18.0;
    }

    String getType() {
        return "SUV";
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Cab[] cabs = new Cab[n];
        String[] times = new String[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            times[i] = sc.next();

            if (type.equals("MINI")) {
                cabs[i] = new Mini(distance);
            } else if (type.equals("SEDAN")) {
                cabs[i] = new Sedan(distance);
            } else {
                cabs[i] = new SUV(distance);
            }
        }

        double total = 0;

        for (int i = 0; i < n; i++) {
            Cab cab = cabs[i];
            double fare;

            if (times[i].equals("NIGHT")) {
                fare = cab.calculateNightFare();
            } else {
                fare = cab.calculateDayFare();
            }

            if (fare < 0) {
                System.out.println(
                    cab.getType() + ": night service not available"
                );
            } else {
                System.out.printf("%s: %.2f%n",
                        cab.getType(), fare);
                total += fare;
            }
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
