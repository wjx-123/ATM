package atm;


import java.io.IOException;
import java.util.Scanner;

public class Achieve {

    private static Bean bean;

    public void get(Bean list){
        bean = list;
    }

    public static void achieve() throws IOException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("欢迎进入当前用户,请输入您的操作");
        System.out.println("1.查询当前余额");
        System.out.println("2.取款");
        System.out.println("3.存款");
        System.out.println("0.返回主界面");
        System.out.println("4.退出程序");
        int input = scanner.nextInt();
        switch (input) {
            case 0:
                achieve();
                break;
            case 1:
                System.out.println("当前余额为："+bean.getMoney());
                System.out.println("按任意键返回主页");
                int input0=scanner.nextInt();
                achieve();
                break;
            case 2:
                System.out.println("请输入取款金额：");
                int takemoney1=scanner.nextInt();
                bean.takemoney(takemoney1);
                System.out.println("当前余额为："+bean.getMoney());
                System.out.println("**************");
                achieve();
                break;
            case 3:
                System.out.println("请输入存款金额：");
                int savemoney1=scanner.nextInt();
                bean.savemoney(savemoney1);
                System.out.println("当前余额为："+bean.getMoney());
                System.out.println("*************");
                achieve();
                break;
            case 4:
                System.out.println("程序已退出，请重新登陆");
                start();
            default:
                System.out.println("输入无效，请重新输入");
                int input1=scanner.nextInt();
                achieve();
                break;
        }
    }
    public static void start() throws IOException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("欢迎进入银行系统！");
        System.out.println("*************");
        System.out.println("请输入卡号：");
        Integer CardNumer = scanner.nextInt();
        ReadFromTxt readFromTxt = new ReadFromTxt();
        readFromTxt.user(CardNumer);
        if (bean==null){
//            readFromTxt.user(CardNumer);
            System.out.println("系统异常，重新加载");
            start();
        }else if (bean!=null){
            System.out.println("请输入密码：");
            Integer judgePin = scanner.nextInt();
            if (CardNumer == Integer.parseInt(bean.getUsername())){
                if (judgePin == Integer.parseInt(bean.getPassword())){
                    achieve();//成功登陆
                }else {
                    System.out.println("密码不正确，返回请按0");
                    int input=scanner.nextInt();
                    if(input==0){
                        start();
                    }else {
                        System.out.println("输入错误");
                    }
                }
            }else{
                System.out.println("用户名不正确，返回请按0");
                int input=scanner.nextInt();
                if(input==0){
                    start();
                }else {
                    System.out.println("输入错误");
                }
            }
        }

    }
}
