package sqlAtm;

import java.sql.*;

/**
 * @Author 王家璇
 * @Description 对数据库的操作
 * @Date 19:10 2020/11/12
 * @Param
 * @return
 **/
public class Sql {
    public static final String URL = "jdbc:mysql://localhost:3306/atm";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";

    /**
     * @Author 王家璇
     * @Description 连接
     * @Date 19:13 2020/11/12
     * @Param []
     * @return void
     **/
    public Connection connectToSql() throws ClassNotFoundException, SQLException {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获得数据库连接
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    /**
     * @Author 王家璇
     * @Description 查账号信息
     * @Date 19:31 2020/11/12
     * @Param []
     * @return void
     **/
    public ResultSet queryAtmUser() throws SQLException, ClassNotFoundException {
        Connection connection;
        connection = connectToSql();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM atm_user");
        //遍历
//        while(rs.next()){
//            System.out.println(rs.getInt("username")+" mima："+rs.getInt("password"));
//        }
        return rs;
    }
    /**
     * @Author 王家璇
     * @Description 修改余额
     * @Date 19:55 2020/11/12
     * @Param
     * @return
     **/
    public void updateMoney(int money, String username) throws SQLException, ClassNotFoundException {
        Connection connection;
        connection = connectToSql();
        Statement statement = connection.createStatement();
        String sql = "update atm_user set money = "+money+" where username = "+username;
        System.out.println(sql);
        int resultSet = statement.executeUpdate(sql);
    }
    /**
     * @Author 王家璇
     * @Description 查当前余额
     * @Date 20:21 2020/11/12
     * @Param
     * @return
     **/
    public int queryMoney(String username) throws SQLException, ClassNotFoundException {
        int money = 0;
        Connection connection;
        connection = connectToSql();
        Statement stmt = connection.createStatement();
        String sql = "select money from atm_user where username = "+username;
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            //System.out.println(rs.getInt("money"));
            money = rs.getInt("money");
        }
        return money;
    }
}
