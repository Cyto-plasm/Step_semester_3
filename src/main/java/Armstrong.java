import java.util.Scanner;
class Armstrong {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number ");
        int number = sc.nextInt();
        int originalNumber = number;
        int sum = 0;
        while (number!=0) {
            int digit = number % 10;
            sum  = sum + digit*digit*digit;
            number /= 10;
        }
        boolean isArmstrong = sum == originalNumber;
        System.out.println("Is the number "+originalNumber + " an Armstrong number? "+isArmstrong);
        sc.close();
    }    
}
