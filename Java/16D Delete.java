import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;

public class programD {
    public static void main(String[] args) {

		try {
			Class.forName("org.sqlite.JDBC");
			String url = "jdbc:sqlite:students.db";
			Connection conn = DriverManager.getConnection(url);

			String deleteSQL = "DELETE FROM Student WHERE RollNo = ?";
			PreparedStatement pstmt = conn.prepareStatement(deleteSQL);

			pstmt.setInt(1, 1); // 1st roll number
			pstmt.executeUpdate();
		}
		catch (ClassNotFoundException e) {
            System.out.println("Err, Error1: " + e.getMessage());
        }
		catch (SQLException e) {
			System.out.print("Err, Error2: " + e.getMessage());
		}
 	}
}
