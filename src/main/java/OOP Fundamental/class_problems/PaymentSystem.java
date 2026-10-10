
import java.util.Scanner;

interface Payment {
    double calculateAmount(double amount);
    String getType();
}

class CardPayment implements Payment {
    public double calculateAmount(double amount) {
        return amount + amount * 0.02;
    }

    public String getType() {
        return "CARD";
    }
}

class WalletPayment implements Payment {
    public double calculateAmount(double amount) {
        return amount + amount * 0.01;
    }

    public String getType() {
        return "WALLET";
    }
}

class BankTransfer implements Payment {
    public double calculateAmount(double amount) {
        return amount;
    }

    public String getType() {
        return "BANKTRANSFER";
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        Payment[] payments = new Payment[n];
        double[] amounts = new double[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            if (type.equals("CARD")) {
                payments[i] = new CardPayment();
            } else if (type.equals("WALLET")) {
                payments[i] = new WalletPayment();
            } else {
                payments[i] = new BankTransfer();
            }

            amounts[i] = amount;
        }

        for (int i = 0; i < n; i++) {
            double adjusted = payments[i].calculateAmount(amounts[i]);
            System.out.printf("%s: %.2f%n",
                    payments[i].getType(), adjusted);
            total += adjusted;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
