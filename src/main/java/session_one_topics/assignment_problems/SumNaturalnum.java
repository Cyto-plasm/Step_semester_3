public class SumNaturalnum {
    static void sumOfNaturalNumbers(int n){
        int count = 1;
        int sum = 0;
        while(count <= n){
            sum = sum + count;
            count++;
        }
        System.out.println("Sum of numbers from 1 to "+n +": " +sum);
    }
    public static void main(String[] args){
        sumOfNaturalNumbers(5);
    }

}
