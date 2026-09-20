import java.util.Scanner;
class Palindrome {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a nummber: ");
        int num = sc.nextInt();
        int originalNumber = num;
        int reversedNumber = 0;
        while(num != 0){
            int digit = num%10;
            reversedNumber = reversedNumber * 10 + digit;
            num /= 10; 
        }
        boolean isPalindrome = reversedNumber == originalNumber;
        System.out.println("Is the number "+originalNumber +" a Palindrome? "+isPalindrome);
        sc.close();
    }

}