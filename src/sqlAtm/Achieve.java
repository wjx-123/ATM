package sqlAtm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Achieve {
    private static ResultSet resultSet;
/**
 * @Author 王家璇
 * @Description 查值
 * @Date 19:57 2020/11/12
 * @Param []
 * @return void
 **/
    public static void userFromSql() throws SQLException, ClassNotFoundException {
        Sql sql = new Sql();
        resultSet = sql.queryAtmUser();
    }
/**
 * @Author 王家璇
 * @Description 修改余额
 * @Date 19:59 2020/11/12
 * @Param
 * @return
 **/
    public static void updateMoney(int num,String username,int i ) throws SQLException, ClassNotFoundException {//取出的金额，当前账户，1代表取钱,2代表存钱
        Sql sql = new Sql();
        int money = 0;
        if (i == 1){
            //取钱
            money = resultSet.getInt("money") - num;
        }else if (i ==2){
            //存钱
            money = resultSet.getInt("money") + num;
        }
        sql.updateMoney(money,username);
    }
/**
 * @Author 王家璇
 * @Description Atm进入
 * @Date 19:58 2020/11/12
 * @Param []
 * @return void
 **/
    public static void achieve() throws SQLException, ClassNotFoundException {
        Bean bean = new Bean();
        Sql sql = new Sql();
        Scanner scanner = new Scanner(System.in);
        System.out.println("欢迎进入当前用户,请输入您的操作");
        System.out.println("1.查询当前余额");
        System.out.println("2.取款");
        System.out.println("3.存款");
        System.out.println("0.返回主界面");
        int input = scanner.nextInt();
        switch (input) {
            case 0:
                achieve();
                break;
            case 1:
                System.out.println("当前余额为：" + resultSet.getInt("money"));
                System.out.println("按任意键返回主页");
                int input0 = scanner.nextInt();
                achieve();
                break;
            case 2:
                System.out.println("请输入取款金额：");
                int takemoney1 = scanner.nextInt();
//                bean.takemoney(takemoney1);
                updateMoney(takemoney1,resultSet.getString("username"),1);//取出的金额，当前账户，1代表取钱
                int a = sql.queryMoney(resultSet.getString("username"));
                System.out.println("当前余额为：" + a);
                System.out.println("**************");
                achieve();
                break;
            case 3:
                System.out.println("请输入存款金额：");
                int savemoney1 = scanner.nextInt();
//                bean.savemoney(savemoney1);
                updateMoney(savemoney1,resultSet.getString("username"),2);
                int b = sql.queryMoney(resultSet.getString("username"));
                System.out.println("当前余额为：" + b);
                System.out.println("*************");
                achieve();
                break;
            default:
                System.out.println("输入无效，请重新输入");
                int input1 = scanner.nextInt();
                achieve();
                break;
        }
    }
/**
 * @Author 王家璇
 * @Description 启动
 * @Date 19:58 2020/11/12
 * @Param []
 * @return void
 **/
    public  void start() throws SQLException, ClassNotFoundException {
        userFromSql();
        Bean bean = new Bean();
        Scanner scanner = new Scanner(System.in);
        System.out.println("欢迎进入银行系统！");
        System.out.println("*************");
        System.out.println("请输入卡号：");
        Integer CardNumer = scanner.nextInt();
        System.out.println("请输入密码：");
        Integer judgePin = scanner.nextInt();
        while (resultSet.next()) {
            if (CardNumer == resultSet.getInt("username")){
                if (judgePin == resultSet.getInt("password")){
                    achieve();
                }else{
                    System.out.println("密码错误，返回主界面请按0");
                    int input=scanner.nextInt();
                       if(input==0){
                            start();
                       } else {
                           System.out.println("输入错误");
                              }
                     }
            }else {
                System.out.println("账号错误");
            }
        }

    }
}
