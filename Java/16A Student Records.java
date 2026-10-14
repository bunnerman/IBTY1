import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class programA {
    public static void main(String[] args) {

        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:students.db";
            Connection conn = DriverManager.getConnection(url);

            Statement stmt = conn.createStatement();

        // PROGRAM A - add students to table (10)
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Student (" +
                                    "RollNo INTEGER PRIMARY KEY, " +
                                    "Name TEXT, " +
                                    "Marks REAL)";
            stmt = conn.createStatement();
            stmt.execute(createTableSQL);

            String insertSQL = "INSERT INTO Student (RollNo, Name, Marks) VALUES (?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(insertSQL);

            for (int i = 0; i < 10; i++)
            {
                int[] rollsAry = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
                String[] namesAry = {"David", "Eli", "Arnold", "Peter", "Evelyn", "Matias", "William", "Robin", "Tom", "Bob"};
                double[] marksAry = {23.3, 65.6, 85.5, 43.6, 87.0, 99.9, 32.3, 67.6, 43.2, 74.1};

                pstmt.setInt(1, rollsAry[i]);
                pstmt.setString(2, namesAry[i]);
                pstmt.setDouble(3, marksAry[i]);
                pstmt.executeUpdate();
            }
        }
        catch (ClassNotFoundException e) {
            System.out.println("Err, Error1: " + e.getMessage());
        }
        catch (SQLException e) {
            System.out.print("Err, Error2: " + e.getMessage());
        }
    }
}
