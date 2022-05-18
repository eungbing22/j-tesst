// 0429
//성적관리 조회, 수정/삭제, 조회에서 다 쓸 수 있게 공통적으로 작업

package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {

		//보안을 위해 private
		private String driver = "com.mysql.cj.jdbc.Driver";
		private String path = "jdbc:mysql://localhost:3306/lecture";
		private String user = "hong";
		private String pwd = "1111";
	
		Connection conn;
		
		// 패키지 타입의 생성자
		DBConn(){
			
			try {
				Class.forName(driver);
				this.conn = DriverManager.getConnection(path, user, pwd);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
		public Connection getConn() {
			return this.conn;
		}
}
