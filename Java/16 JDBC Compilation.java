import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class programMega {
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
									"Marks INTEGER)";
			stmt = conn.createStatement();
			stmt.execute(createTableSQL);

			String insertSQL = "INSERT INTO Student (RollNo, Name, Marks) VALUES (?, ?, ?)";

			PreparedStatement pstmt = conn.prepareStatement(insertSQL);

			for (int i = 0; i < 10; i++)
			{
				int[] rollsAry = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
				String[] namesAry = {"David", "Eli", "Arnold", "Peter", "Evelyn", "Matias", "William", "Robin", "Tom", "Bob"};
				int[] marksAry = {23, 65, 85, 43, 87, 99, 32, 67, 43, 74};

				pstmt.setInt(1, rollsAry[i]);
				pstmt.setString(2, namesAry[i]);
				pstmt.setInt(3, marksAry[i]);
				pstmt.executeUpdate();
			}

		// PROGRAM B - display higher than 70
			String query = "SELECT RollNo, Name, Marks FROM Student WHERE Marks > 70";
				
				ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    int rollNo = rs.getInt("RollNo");
                    String name = rs.getString("Name");
                    int marks = rs.getInt("Marks");

                    // formatted
                    System.out.printf("%-10d | %-20s | %-10d\n", rollNo, name, marks);
                }
			

                System.out.println();
                System.out.printf("%-10s | %-20s | %-10s%n", "Roll No", "Name", "Marks");
                System.out.println();

		// PROGRAM C - updates third roll number to 39
			stmt = conn.createStatement();

			String updateSQL = "UPDATE Student SET Marks = ? WHERE RollNo = ?";
			pstmt = conn.prepareStatement(updateSQL);

			pstmt.setInt(1, 39); // just barely fail the student
			pstmt.setInt(2, 3); // third roll number
			pstmt.executeUpdate();

		// PROGRAM D - removes first roll number
			stmt = conn.createStatement();

			String deleteSQL = "DELETE FROM Student WHERE RollNo = ?";
			pstmt = conn.prepareStatement(deleteSQL);

			pstmt.setInt(1, 1); // 1st roll number
			pstmt.executeUpdate();


		// PROGRAM E - display all
			query = "SELECT RollNo, Name, Marks FROM Student";

			rs = stmt.executeQuery(query);
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
