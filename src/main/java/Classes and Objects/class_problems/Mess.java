class MessWallet{
    private double balance;
    MessWallet(double balance){
        this.balance = balance;
    }
    void topUp(double amount){
        if(amount<=0)
            System.out.println("Cannot topup");
        else{
            balance += amount;
            System.out.println("Balance after Top-up: "+balance);

        }
    }
    void deduct(double amount){
        if(amount >= balance){
            System.out.println("Deduct rejected: insufficient balance");
        }
        else{
            balance -= amount;
            System.out.println("Balance after Deduction: "+balance);
        }
    }
    double getbalance(){
        return balance;
    }
}
public class Mess {
    public static void main(String[] args){
    MessWallet m1 = new MessWallet(2000);
    m1.topUp(200.0);
    m1.deduct(3000);
    }

}
