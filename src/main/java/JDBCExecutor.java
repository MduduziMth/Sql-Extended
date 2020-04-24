import sun.text.SupplementaryCharacterData;

import java.sql.*;


public class JDBCExecutor {
   static DatabaseConnectionManager cns = new DatabaseConnectionManager("localhost","umuzi","user","pass");


    public static void main(String[] args) throws Exception {
        SelectAllCustomers();
        SelectOnlyName();
        SelectCustomerWhereIdIsOne();
        UpdateCustomer();
        DeleteCustomer();
        UniqueStatusesFromOrder();
        Maximumpayments();
        SelectAllCustomerAndSortByCountry();
        ProductsBetween100and600();
    }

    //1
    public static void SelectAllCustomers()
    {
        try {

            Connection connection = cns.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from customers");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i < columnCount; i++) {
                    String columnName = resultSetMetaData.getColumnName(i);
                    System.out.print(columnName.toUpperCase() + ": ");
                    System.out.print(resultSet.getString(i) + ", ");
                }
                System.out.println();

            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
    //2
    public static void SelectOnlyName()
    {
        try {

            Connection connection = cns.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from customers");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("firstname"));
                System.out.println();

            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
    //3
    public static void SelectCustomerWhereIdIsOne()
    {
        try {

            Connection connection = cns.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from customers where customerId = 1");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("firstname"));
                System.out.println();

            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

    //4
    public static void UpdateCustomer()
    {
        try {

            Connection connection = cns.getConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery("Update customers Set firstname='Lerato', lastname='Mabitso' Where customerid = 1");
        }
        catch (SQLException e){
            e.printStackTrace();
        }


    }

    //5
    public static void DeleteCustomer()
    {
        try {

            Connection connection = cns.getConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery("Delete from customers Where customerid = 2");
        }
        catch (SQLException e){
            e.printStackTrace();
        }



    }

    //6
    public static void UniqueStatusesFromOrder()
    {
        try {

            Connection connection = cns.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select distinct on (status) status From order");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("status"));
                System.out.println();

            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }


    }

    //7
    public static void Maximumpayments()
    {
        try {

            Connection connection = cns.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select Max(Amount) from payments");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("max"));
                System.out.println();

            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    //8
    public static void SelectAllCustomerAndSortByCountry()
    {
        try {

            Connection connection = cns.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from customers order by country");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i < columnCount; i++) {
                    String columnName = resultSetMetaData.getColumnName(i);
                    System.out.print(columnName.toUpperCase() + ": ");
                    System.out.print(resultSet.getString(i) + ", ");
                }
                System.out.println();

            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
    //9
    public static void ProductsBetween100and600()
    {
        try {

            Connection connection = cns.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from products Where Buyprice > 100 and Buyprice < 600");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i < columnCount; i++) {
                    String columnName = resultSetMetaData.getColumnName(i);
                    System.out.print(columnName.toUpperCase() + ": ");
                    System.out.print(resultSet.getString(i) + ", ");
                }
                System.out.println();

            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }









}
