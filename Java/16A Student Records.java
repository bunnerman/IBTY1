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

			String createTableSQL = "CREATE TABLE IF NOT EXISTS Student (" +
									"RollNo INTEGER PRIMARY KEY, " +
									"Name TEXT, " +
									"Marks INTEGER)";
			Statement stmt = conn.createStatement();
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

			System.out.println("All Student Records:");
                System.out.println();
                System.out.printf("%-10s | %-20s | %-10s%n", "Roll No", "Name", "Marks");
                System.out.println();

                boolean found = false;
				String query = "SELECT RollNo, Name, Marks FROM Student";

				ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    found = true;
                    int rollNo = rs.getInt("RollNo");
                    String name = rs.getString("Name");
                    int marks = rs.getInt("Marks");

                    // formatted
                    System.out.printf("%-10d | %-20s | %-10d\n", rollNo, name, marks);
                }
				if (!found)
                    System.out.println("Empty Table");
		}
		catch (ClassNotFoundException e) {
            System.out.println("Err, Error1: " + e.getMessage());
        }
		catch (SQLException e) {
			System.out.print("Err, Error2: " + e.getMessage());
		}
 	}
}
