package atm;

public class Bean {
    private String username;
    private String password;
    private int money;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
        //取钱操作
    public int takemoney(int takemoney1){
        this.money-=takemoney1;
        return money;
    }
        //存钱操作
    public int savemoney(int savemoney1){
        this.money+=savemoney1;
        return money;
    }

}
