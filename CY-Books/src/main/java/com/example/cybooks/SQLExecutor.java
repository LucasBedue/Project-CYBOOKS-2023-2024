package com.example.cybooks;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;

public class SQLExecutor {

    private final String url;
    private final String userName;
    private final String password;

    public SQLExecutor(String className,String url, String userName, String password)
            throws ClassNotFoundException  {
        Class.forName(className);
        this.url = url;
        this.userName = userName;
        this.password = password;
    }


    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, userName, password);
    }


    private void printMetaData(Connection connection)
            throws SQLException
    {
        DatabaseMetaData metaData = connection.getMetaData();
        String format = "\nDatabase metadata\n"
                + "Database name : %s\n"
                + "Database version : %s\n"
                + "Database driver name : %s\n"
                + "Database driver version : %s\n\n";
        System.out.printf(format,
                metaData.getDatabaseProductName(),
                metaData.getDatabaseProductVersion(),
                metaData.getDriverName(),
                metaData.getDriverVersion());
    }

    public void executeFile(String path)
    {


        try {
            // Creating a connection between Java class and Database instance
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cy_Books_Database", "root", "");
            Statement statement = connection.createStatement();

            // path to our SQL Script file
            File myObj = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(myObj));

            // String Builder to build the query line by line.
            StringBuilder query = new StringBuilder();
            String line;

            while((line = br.readLine()) != null) {

                if(line.trim().startsWith("-- ")) {
                    continue;
                }

                // Append the line into the query string and add a space after that
                query.append(line).append(" ");

                if(line.trim().endsWith(";")) {
                    // Execute the Query
                    statement.execute(query.toString().trim());
                    // Empty the Query string to add new query from the file
                    query = new StringBuilder();
                }
            }



            // Getting the ResultSet after executing the Script File
            ResultSet resultSet = statement.getResultSet();


        }
        catch (Exception e) {
            // Error handling Statements
            System.out.println(e.toString());
        }
    }




}

