
import java.util.Scanner;

abstract class Ticket {
    int count;

    static final double CONVENIENCE_FEE = 20.0;

    Ticket(int count) {
        this.count = count;
    }

    abstract double getPrice();

    abstract String getType();

    final double calculateAmount() {
        return count * (getPrice() + CONVENIENCE_FEE);
    }
}

class Regular extends Ticket {
    Regular(int count) {
        super(count);
    }

    double getPrice() {
        return 150.0;
    }

    String getType() {
        return "REGULAR";
    }
}

class Premium extends Ticket {
    Premium(int count) {
        super(count);
    }

    double getPrice() {
        return 250.0;
    }

    String getType() {
        return "PREMIUM";
    }
}

class Recliner extends Ticket {
    Recliner(int count) {
        super(count);
    }

    double getPrice() {
        return 400.0;
    }

    String getType() {
        return "RECLINER";
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Ticket[] tickets = new Ticket[n];
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int count = sc.nextInt();
            if (type.equals("REGULAR")) {
                tickets[i] = new Regular(count);
            } else if (type.equals("PREMIUM")) {
                tickets[i] = new Premium(count);
            } else {
                tickets[i] = new Recliner(count);
            }
        }
        double total = 0;
        for (Ticket ticket : tickets) {
            double amount = ticket.calculateAmount();
            System.out.printf("%s: %.2f%n",
                    ticket.getType(), amount);
            total += amount;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
