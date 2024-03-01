package mancala.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import mancala.domain.IMancala;
import mancala.domain.Mancala;


import java.sql.*;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MancalaDatabase implements IMancalaRepository {
    Connection connection;

    public void connect() throws ClassNotFoundException, SQLException {
        String userDirectoryPath = System.getProperty("user.dir");
        System.out.println(userDirectoryPath);

//        try {
//            Class.forName("org.sqlite.JDBC");

            connection = DriverManager.getConnection(
                    "jdbc:sqlite:database.db");
            System.out.println("say something");
//        } catch (java.lang.ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        } catch (SQLException e){
//            System.out.println(e.getMessage());
//        }

    }

    public void close(){
        try {
            connection.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void save(String key, IMancala game) {
//        try {
//            Statement statement;
//            statement = connection.createStatement();
//            statement.execute("""
//                    INSERT INTO games VALUES ("3","3");
//                    """);
//
//            } catch (SQLException e){
//            System.out.println(e.getMessage());
//        }
        makeJSON(new Mancala("1","2"));
    }

    @Override
    public IMancala get(String key) {
//        Statement statement;
//        statement = connection.createStatement();
//        ResultSet resultSet;
//        resultSet = statement.executeQuery(
//                "select * from games;");
//        while (resultSet.next()){
//            System.out.println(resultSet.getInt("key"));
//        }
        return null;


    }

    private String makeJSON(IMancala mancala){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(mancala);
            System.out.println(jsonString);
            return jsonString;
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}

