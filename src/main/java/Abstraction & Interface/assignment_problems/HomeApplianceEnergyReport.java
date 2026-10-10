
import java.util.Scanner;

interface SaverMode {
    double applySaverMode(double units);
}

abstract class Appliance {
    double hours;

    static final double COST_PER_UNIT = 8.0;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    abstract String getType();

    double calculateUnits() {
        return getPower() * hours / 1000.0;
    }

    final double calculateCost(double units) {
        return units * COST_PER_UNIT;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150.0;
    }

    String getType() {
        return "FRIDGE";
    }
}

class AC extends Appliance implements SaverMode {
    AC(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500.0;
    }

    String getType() {
        return "AC";
    }

    public double applySaverMode(double units) {
        return units * 0.75;
    }
}

class TV extends Appliance {
    TV(double hours) {
        super(hours);
    }

    double getPower() {
        return 100.0;
    }

    String getType() {
        return "TV";
    }
}

class Washer extends Appliance implements SaverMode {
    Washer(double hours) {
        super(hours);
    }

    double getPower() {
        return 500.0;
    }

    String getType() {
        return "WASHER";
    }

    public double applySaverMode(double units) {
        return units * 0.75;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Appliance[] appliances = new Appliance[n];
        boolean[] saverRequested = new boolean[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();

            saverRequested[i] = sc.hasNext("SAVER");

            if (saverRequested[i]) {
                sc.next();
            }

            if (type.equals("FRIDGE")) {
                appliances[i] = new Fridge(hours);
            } else if (type.equals("AC")) {
                appliances[i] = new AC(hours);
            } else if (type.equals("TV")) {
                appliances[i] = new TV(hours);
            } else {
                appliances[i] = new Washer(hours);
            }
        }

        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            Appliance appliance = appliances[i];

            if (saverRequested[i]
                    && !(appliance instanceof SaverMode)) {
                System.out.println(
                    appliance.getType() + ": saver mode not supported"
                );
                continue;
            }

            double units = appliance.calculateUnits();

            if (saverRequested[i]) {
                SaverMode saver = (SaverMode) appliance;
                units = saver.applySaverMode(units);
            }

            double cost = appliance.calculateCost(units);

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                appliance.getType(), units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
