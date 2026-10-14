import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class programC {
    public static void main(String[] args) {

		try {
			Class.forName("org.sqlite.JDBC");
			String url = "jdbc:sqlite:students.db";
			Connection conn = DriverManager.getConnection(url);

			String updateSQL = "UPDATE Student SET Marks = ? WHERE RollNo = ?";
			PreparedStatement pstmt = conn.prepareStatement(updateSQL);

			pstmt.setDouble(1, 39.8); // just barely fail the student
			pstmt.setInt(2, 3); // third roll number
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
