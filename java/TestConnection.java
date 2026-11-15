
import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {
        try {
            Connection con = DatabaseConnection.getConnection();

            System.out.println("PostgreSQL Connected Successfully!");

            con.close();

        } catch (Exception e) {
            System.out.println("Database Connection Failed!");
            e.printStackTrace();
        }
    }
}
