import java.sql.*;
import java.util.*;
public class test {

	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		//Connection c = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		try
		{
			// get connection 
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","nOhA31427112340");
	
	Statement mys = c.createStatement(); // create statement
	
	 
	
	// execute SQL query
	
	ResultSet myr = mys.executeQuery("select * from customer");
	
	while(myr.next())
	{
		System.out.println(myr.getString("CustomerName") );
	}
	
	System.out.println();
	
	//String sql = "insert into Customer" +"(CustomerName,CustomerID,CustomerGender,PassportNumber,RoomNumber,PaymentType,Price)" +"values ( 'Sarah',1014,'F',00123,29,'visa',1029)";
	//mys.executeUpdate(sql);
	
	//System.out.println("Inserted completed");
	
	//System.out.println("Enter the payment typ that you want to change");
	//String v = s.nextLine();
	
	//String sql1 = "update Customer" + " set PaymentType= 'visa'" + "where CustomerID = 1011";
	//mys.executeUpdate(sql1);
	
	//System.out.println("update completed");
	
	System.out.println();
	
	String sql2 ="delete from Manager where EmployeeID =123499 ";
	
	int row = mys.executeUpdate(sql2);
	System.out.println(" row affected "+ row );
	System.out.println(" Delete completed");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		

		
		
		

	}
	
	private static void display(ResultSet myRs) throws SQLException {
		while (myRs.next()) {
			String Employeename = myRs.getString("Employeename");
			int EmployeeID = myRs.getInt("EmployeeID");
			double EmployeeSalary = myRs.getDouble("EmployeeSalary");
			//String department = myRs.getString("department");
			
			System.out.println( Employeename + EmployeeID + EmployeeSalary);
		}
	}


}
