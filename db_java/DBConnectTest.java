// 0428
// DB Connection Test

package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnectTest {

	// 생성자 메서드
	public DBConnectTest() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String path = "jdbc:mysql://localhost:3306/classicmodels";
		String user = "hong";
		String pwd = "1111";

		try {
			Class.forName(driver);
			System.out.println("driver loading ok...");

			Connection conn = DriverManager.getConnection(path, user, pwd);
			System.out.println("connection ok...");

			String sql = "select firstName from employees";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String firstName = rs.getString("firstName");
				System.out.println(firstName);
			}

			sql = "select firstName,email from employees";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				
				String firstName = rs.getString("firstName");
				String email = rs.getString("email");
				
				System.out.println(firstName + " : " + email);
			}

			/*
			 * test - officeCode가 1번인 직원들의 employeeNumber, firstName, jobTitle 을 출력
			 */

			sql = "select employeeNumber,firstName,jobTitle from employees " 
				+ "where officeCode=1";

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			// 출력
			while (rs.next()) {
				int en = rs.getInt("employeeNumber");
				String fn = rs.getString("firstName");
				String job = rs.getString("jobTitle");

				System.out.println(en + ", " + fn + ", " + job);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new DBConnectTest();
	}

}
