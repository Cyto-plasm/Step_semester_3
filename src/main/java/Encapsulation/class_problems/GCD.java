import java.util.Scanner;

class GCD {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter number 1: ");
    int num1 = sc.nextInt();
    System.out.print("Enter number 2: ");
    int num2 = sc.nextInt();
    int originalNumber1 = num1;
    int originalNumber2 = num2;
    while(num2 != 0){
        int remainder = num1/num2;
        num1 = num2;
        num2 = remainder;
    }
    System.out.println("The GCD of "+originalNumber1 +" and "+originalNumber2 +" is "+num1);
    sc.close();
    }
    
}
