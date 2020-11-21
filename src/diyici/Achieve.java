package diyici;

import java.util.Scanner;

public class Achieve {
    public static void achieve(){
        Bean bean=new Bean();
        Scanner scanner=new Scanner(System.in);
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
                System.out.println("当前余额为："+bean.balance);
                System.out.println("按任意键返回主页");
                int input0=scanner.nextInt();
                achieve();
                break;
            case 2:
                System.out.println("请输入取款金额：");
                int takemoney1=scanner.nextInt();
                bean.takemoney(takemoney1);
                System.out.println("当前余额为："+bean.balance);
                System.out.println("**************");
                achieve();
                break;
            case 3:
                System.out.println("请输入存款金额：");
                int savemoney1=scanner.nextInt();
                bean.savemoney(savemoney1);
                System.out.println("当前余额为："+bean.balance);
                System.out.println("*************");
                achieve();
                break;
            default:
                System.out.println("输入无效，请重新输入");
                int input1=scanner.nextInt();
                achieve();
                break;
        }
    }
    public static void start(){
        Bean bean=new Bean();
        Scanner scanner=new Scanner(System.in);
        System.out.println("欢迎进入银行系统！");
        System.out.println("*************");
        System.out.println("请输入卡号：");
        Integer CardNumer = scanner.nextInt();
        System.out.println("请输入密码：");
        Integer judgePin = scanner.nextInt();
        for (int i = 0; i < bean.arr.length; i++) {
            if (CardNumer==bean.arr[i][0]){
                if (judgePin == bean.arr[i][1]) {
                    achieve();
                }
            } else {
                System.out.println("当前用户名或密码不正确，返回主界面请按0");
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
