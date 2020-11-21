package atm;

import java.io.*;

public class ReadFromTxt {

    private static  int username;
    private static String[] arr;
    private static Bean list;

    public void read() throws IOException {
        File file = new File("D:\\666.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str = "";
        while ((str = bufferedReader.readLine()) != null) //●判断最后一行不存在，为空
        {
//            System.out.println(str);
            if (username==123){
                spilt(str);
            }
        }
        bufferedReader.close();
        fileReader.close();
    }

    public int user(int a) throws IOException {
        username = a;
        read();
        return a;
    }

    public String[] spilt(String aString){
        arr = aString.split(" ", -1);
//        int a = arr.length;
        list = new Bean();
        if (username == 123){
            list.setUsername(arr[0]);
            list.setPassword(arr[1]);
            list.setMoney(Integer.parseInt(arr[2]));
            username = 0;
        }
        Achieve achieve = new Achieve();
        achieve.get(list);
        return arr;
    }

}
