//0429_3
//오전 11시20분

//학생관리 조회,수정삭제,조회
//성적관리 조회,수정삭제,조회에서 다 쓸 수 있게
//공통적으로 작업한다심

// 여러개 같이 사용중
// DBConn
// StudentInterface, StudentDao, StudentVo, StudentInput, StudentModify, StudentDelete;
// ScoreInterface, ScoreDao, ScoreVo, ScoreInput, ScoreModify, ScoreDelete;

package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {

		//보안떄문에 private
		private String driver = "com.mysql.cj.jdbc.Driver";
		private String path = "jdbc:mysql://localhost:3306/lecture";
		private String user = "hong";
		private String pwd = "1111";
	
		//디폴트로 만듦 
		//나와같은 패키지안의 클래스들한테만 공유하겠다
		Connection conn;
		
		//생성자
		//패키지타입
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
