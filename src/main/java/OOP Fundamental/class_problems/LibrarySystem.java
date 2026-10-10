
import java.util.Scanner;
import java.time.LocalDate;

abstract class LibraryItem {
    String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int getBorrowingDays();

    LocalDate calculateDueDate() {
        return LocalDate.of(2023, 10, 26)
                .plusDays(getBorrowingDays());
    }
}

class Book extends LibraryItem {
    Book(String title) {
        super(title);
    }

    int getBorrowingDays() {
        return 14;
    }
}

class DVD extends LibraryItem {
    DVD(String title) {
        super(title);
    }

    int getBorrowingDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    Magazine(String title) {
        super(title);
    }

    int getBorrowingDays() {
        return 3;
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        LibraryItem[] items = new LibraryItem[n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int space = line.indexOf(' ');

            String type = line.substring(0, space);
            String title = line.substring(space + 1).trim();

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            if (type.equals("BOOK")) {
                items[i] = new Book(title);
            } else if (type.equals("DVD")) {
                items[i] = new DVD(title);
            } else {
                items[i] = new Magazine(title);
            }
        }

        for (LibraryItem item : items) {
            System.out.println(item.title + ": "
                    + item.calculateDueDate());
        }

        sc.close();
    }
}
