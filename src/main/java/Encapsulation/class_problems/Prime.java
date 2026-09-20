import java.util.Scanner;
class Prime {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        boolean isPrime = true;
        if(num<2){
            isPrime = false;
        }
        else{
            for(int i = 2; i < num; i++){
                if(num % i == 0){
                    isPrime = false;
                    break;
                }
            }
        }
        System.out.println("Is the number "+num + " a Prime number? "+isPrime);
        sc.close();
    }
}
