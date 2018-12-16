public class Passenger {
    private String name;
    private int wallet;

    public Passenger(String name, int wallet){
        this.name = name;
        this.wallet = wallet;
    }

    public String getName() {
        return name;
    }

    public int getWallet() {
        return wallet;
    }

    public void payMoney(int cost){

        this.wallet = wallet - cost;
    }
}
