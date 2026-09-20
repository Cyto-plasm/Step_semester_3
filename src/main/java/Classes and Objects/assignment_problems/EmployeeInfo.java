public class EmployeeInfo {

    String empName;
    double salary;

    static String companyName =
        "Bright Horizon Technologies";

    static int employeeCount = 0;

    public EmployeeInfo(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;

        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println(
            "Employees on record: " + employeeCount
        );
    }

    public static void main(String[] args) {

        EmployeeInfo employee1 =
            new EmployeeInfo("Ravi", 50000);

        EmployeeInfo employee2 =
            new EmployeeInfo("Ananya", 60000);

        EmployeeInfo employee3 =
            new EmployeeInfo("Arjun", 55000);

        EmployeeInfo.printCompanyInfo();
    }
}
