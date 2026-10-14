import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class programD {
    public static void main(String[] args) {

		try {
			Class.forName("org.sqlite.JDBC");
			String url = "jdbc:sqlite:students.db";
			Connection conn = DriverManager.getConnection(url);

			Statement stmt = conn.createStatement();

			String deleteSQL = "DELETE FROM Student WHERE RollNo = ?";
			PreparedStatement pstmt = conn.prepareStatement(deleteSQL);

			pstmt.setInt(1, 1); // 1st roll number
			pstmt.executeUpdate();

                System.out.println();
                System.out.printf("%-10s | %-20s | %-10s%n", "Roll No", "Name", "Marks");
                System.out.println();

				String query = "SELECT RollNo, Name, Marks FROM Student";

				ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    int rollNo = rs.getInt("RollNo");
                    String name = rs.getString("Name");
                    int marks = rs.getInt("Marks");

                    // formatted
                    System.out.printf("%-10d | %-20s | %-10d\n", rollNo, name, marks);
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
