//0502_오후

package db.product;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBProductConn {

	// 보안떄문에 private
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String path = "jdbc:mysql://localhost:3306/lecture";
	private String user = "hong";
	private String pwd = "1111";

	Connection conn;

	// 생성자
	DBProductConn() {
		try {
			Class.forName(driver);// driver를 호출하겠다.
			this.conn = DriverManager.getConnection(path, user, pwd);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public Connection getConn() {
		return this.conn;
	}
}


