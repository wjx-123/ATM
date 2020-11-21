package sqlAtm;

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

    @Override
    public String toString() {
        return "Bean{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                '}';
    }

    public Bean(String username, String password, int money) {
        this.username = username;
        this.password = password;
        this.money = money;
    }
    public Bean(){
        super();
    }
}
