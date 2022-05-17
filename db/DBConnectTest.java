// 0428_1 

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
			// conn.close();

			// 0) employees 테이블에서 firstName을 출력
			String sql = "select firstName from employees";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			//
			while (rs.next()) {
				String firstName = rs.getString("firstName");
				// firstName이 varchar라서 string으로 get
				System.out.println(firstName);
			}

			// 1) employees 테이블에서 firstName과 email을 출력
			// 위에서 사용한 sql 다시 활용
			sql = "select firstName,email from employees";

			// 문자열을 매개변수로 connection을 만드는게 PreparedStatement의 기능
			ps = conn.prepareStatement(sql);

			// statement를 실행
			rs = ps.executeQuery();

			// boolean 타입의 while 문으로 진행
			while (rs.next()) {
				String firstName = rs.getString("firstName");
				String email = rs.getString("email");

				System.out.println(firstName + " : " + email);
			}

			// semi mission
			/*
			 * officeCode가 1번인 직원들의 employeeNumber,firstName,jobTitle 을 출력하시오.
			 */

			sql = "select employeeNumber,firstName,jobTitle from employees " 
				+ "where officeCode=1";
			// 줄바꿈을 할때는 공백 하나를 만들어야 한다!

			ps = conn.prepareStatement(sql);
			// 자바가 인지할수있게 prepareStatement

			rs = ps.executeQuery();
			// 실행

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
