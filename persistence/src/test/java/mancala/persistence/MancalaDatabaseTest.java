package mancala.persistence;

import mancala.domain.IMancala;
import mancala.domain.Mancala;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.*;
public class MancalaDatabaseTest {
    @Test
    void Connection_Test() throws ClassNotFoundException, SQLException {
        MancalaDatabase db = new MancalaDatabase();

//        db.connect();
        db.save("a", new Mancala("1","2"));
//        db.close();



//        Connection connection = db.connect();
//
//        assertNotNull(connection);
    }

}
