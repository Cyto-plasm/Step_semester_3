
import java.util.Scanner;

abstract class Staff {
    String name;

    Staff(String name) {
        this.name = name;
    }

    abstract double calculatePay();
}

class FullTimeStaff extends Staff {
    double weeklySalary;

    FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends Staff {
    double hours, rate;

    HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        }

        return 40 * rate + (hours - 40) * rate * 1.5;
    }
}

class Intern extends Staff {
    double stipend;

    Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Staff[] staffMembers = new Staff[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            if (type.equals("FULLTIME")) {
                double salary = sc.nextDouble();
                staffMembers[i] = new FullTimeStaff(name, salary);
            } else if (type.equals("HOURLY")) {
                double hours = sc.nextDouble();
                double rate = sc.nextDouble();
                staffMembers[i] = new HourlyStaff(name, hours, rate);
            } else {
                double stipend = sc.nextDouble();
                staffMembers[i] = new Intern(name, stipend);
            }
        }

        double total = 0;

        for (Staff staff : staffMembers) {
            double pay = staff.calculatePay();

            System.out.printf("%s: %.2f%n", staff.name, pay);
            total += pay;
        }

        System.out.printf("Total Payroll: %.2f%n", total);
        sc.close();
    }
}
