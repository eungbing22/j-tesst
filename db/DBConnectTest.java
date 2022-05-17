// 0428_1 
// 오전 10시반~ 오후 12시 20분

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
			Class.forName(driver); // 호출만 하겠다! 라는 뜻인가요 ㅠㅠ
			System.out.println("driver loading ok...");

			Connection conn = DriverManager.getConnection(path, user, pwd);
			System.out.println("connection ok...");
			// conn.close(); // 왜 닫았나요 ㅠㅠ

			// 0) employees 테이블에서 firstName을 출력
			String sql = "select firstName from employees";
			PreparedStatement ps = conn.prepareStatement(sql);
			// 실행되면 문자열에서 statement 형태로 변경이 되어진다.
			ResultSet rs = ps.executeQuery();

			//
			while (rs.next()) {
				String firstName = rs.getString("firstName");
				// firstName이 varchar라서 string으로 get
				System.out.println(firstName);
			}

			// 1) employees 테이블에서 firstName과 email을 출력
			// 위에서 사용한 sql 재활용
			sql = "select firstName,email from employees";

			// 문자열을 매개변수로 connection을 만드는게 PreparedStatement의 기능이다.
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

			// 은빈 푼거
			sql = "select employeeNumber,firstName,jobTitle from employees where officeCode=1";
			// 숫자 문자 문자
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Integer employeeNumber = rs.getInt("employeeNumber");
				String firstName = rs.getString("firstName");
				String jobTitle = rs.getString("jobTitle");

				System.out.println(employeeNumber + "/" + firstName + "/" + jobTitle);

			}

			// 쌤이 풀어주신거 한번 더 풀어봄
			System.out.println("-------------------쌤ex");

			sql = "select employeeNumber,firstName,jobTitle from employees " 
				+ "where officeCode=1";
			// 줄바꿈을 할때는 공백 하나를 만들어야한다!

			ps = conn.prepareStatement(sql);
			// 자바가 인지할수있게 prepareStatement 하세욥

			rs = ps.executeQuery();
			// 실행하세욥 // select는 무조건 executeQuery() 이거고, select 이외의
			// 나머지는update,delete -> executeUpdate()로 한다는거 같다심~

			// 출력하기
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
		new DBConnectTest(); // 아너니머스로 할거
		// DBConnectTest dt = new DBConnectTest();

	}

}
