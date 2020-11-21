package diyici;

public class Bean {
    static int  balance=1000;//余额
    int arr[][]={{123,123},{111,111}};

    public int getBalance() {

        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

    //显示当前余额
    public int balance(){
        return this.balance;
    }
    //取钱操作
    public int takemoney(int takemoney1){
        this.balance-=takemoney1;
        return balance;
    }
    //存钱操作
    public int savemoney(int savemoney1){
        this.balance+=savemoney1;
        return balance;
    }
}
