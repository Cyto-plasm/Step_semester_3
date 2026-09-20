public class LibIdCard {
    String name;
    int booksIssued;

    public LibIdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public static void main(String[] args) {

        LibIdCard ravi = new LibIdCard("Ravi", 0);
        LibIdCard duplicate = ravi;

        duplicate.booksIssued = 3;

        LibIdCard separate = new LibIdCard("Ravi", 3);

        System.out.println(
            "Ravi's booksIssued (via first variable): "
            + ravi.booksIssued
        );

        System.out.println(
            "duplicate == ravi: " + (duplicate == ravi)
        );

        System.out.println(
            "separate == ravi: " + (separate == ravi)
        );
    }
}
