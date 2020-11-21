package sqlAtm;

import java.sql.SQLException;

public class ATMmain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        /**
         * @Author 王家璇
         * @Description测试用
         * @Date 19:54 2020/11/12
         * @Param [args]
         * @return void
         **/
//        Sql sql = new Sql();
//        sql.queryAtmUser();
       Achieve achieve = new Achieve();
       achieve.start();
    }
}
