//0429_오후 미션_2

// 여러개 같이 사용중
// DBConn
// StudentInterface, StudentDao, StudentVo, StudentInput, StudentModify, StudentDelete;
// ScoreInterface, ScoreDao, ScoreVo, ScoreInput, ScoreModify, ScoreDelete;

package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScoreDao implements ScoreInterface {
	
	// 필드선언
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	// 생성자 메서드
		ScoreDao(){
			this.conn = new DBConn().getConn();
		}
	
	// 다른분꺼 참고 //getSno라는 메서드 생성
	public int getSno() {
		int sno = 0;
		String sql = "select max(sno) as k from score";	//score의 가장 큰 값을 가지고 와! 거기에 auto_increment 적용
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				sno = rs.getInt("k");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return sno;
	}
	// 다른분꺼 참고한고
	
	@Override
	public boolean insert(ScoreVo vo) {
		boolean b = false;
		String sql = "insert into score(id, subject, score, nal) "	
				+ "values(?, ?, ?, ?)";		//sno 자동, mName자동이라 생략
		try {			
			ps = conn.prepareStatement(sql);
			ps.setString(1,  vo.getId());
			ps.setString(2, vo.getSubject());
			ps.setInt(3, vo.getScore());
			ps.setString(4, vo.getNal());
			
			conn.setAutoCommit(false); //이왕이면 써주자!
			int n = ps.executeUpdate();
			
			if(n>0) {
				b=true;
				conn.commit();
			}else {
				conn.rollback();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	//참고해서 작성한고 
	
	@Override
	public String search(String id) {
		String sql = "select mName from student "
				+ "where id=?";
		
		String mName = null;
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				mName = rs.getString("mName");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mName;
	}
	// 다른분꺼 참고함 ㅠㅠ

	@Override
	public boolean update(ScoreVo vo) {
		boolean b = false;
		String sql = "update score set subject=?, score=?, nal=? "
				   + "where sno=? and id=?";	
		try {
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, vo.getSubject());
			ps.setInt(2, vo.getScore());
			ps.setString(3, vo.getNal());
			ps.setInt(4,vo.getSno());
			ps.setString(5,vo.getId());
			
			conn.setAutoCommit(false);
			int n = ps.executeUpdate();	
			if(n>0) {
				b=true;
				conn.commit();
			}else {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean delete(int sno) {
		boolean b = false;
		String sql = "delete from score where sno=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, sno);
			
			conn.setAutoCommit(false); // 수동으로 transaction 만들기!
			int n = ps.executeUpdate();
			
			if(n>0) {
				b=true;
				conn.commit();
			}else {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<ScoreVo> select(String findStr) {
		// list로 만들어서 반환하라.
		List<ScoreVo> list = new ArrayList<ScoreVo>();
		
		String sql = "select c.sno, s.mName, c.subject, c.score, c.nal " 
				+ "from score c join student s "
				+ "on c.id = s.id "
				+ "where c.id like ? "
				+ "or s.mName like ? "
				+ "or c.subject like ? "
				+ "or c.nal like ? "
				+ "order by c.sno";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,"%"+findStr+"%");
			ps.setString(2,"%"+findStr+"%");
			ps.setString(3,"%"+findStr+"%");
			ps.setString(4,"%"+findStr+"%");
			conn.setAutoCommit(false);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ScoreVo vo = new ScoreVo(); 	
				
				vo.setSno(rs.getInt("sno"));
				vo.setmName(rs.getString("mName"));
				vo.setSubject(rs.getString("subject"));
				vo.setScore(rs.getInt("score"));
				vo.setNal(rs.getString("nal"));
				
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ScoreVo selectOne(int sno) {
		//insert에서 사용할 것
		
		String sql = "";
		ScoreVo vo = null;
		
		try {
			sql = "select s.id, s.mName, c.subject, c.score, c.nal " 
				+ "from student s join score c "
				+ "on s.id = c.id " 
				+ "where c.sno=?";
			
			ps = conn.prepareStatement(sql);
			ps. setInt(1,sno);
			rs = ps.executeQuery();
			
			if(rs.next()) {
			vo = new ScoreVo(	//Sno는 자동
			//	rs.getInt("c.sno"),
				rs.getString("s.id"),
				rs.getString("s.mName"),
				rs.getString("c.subject"),
				rs.getInt("c.score"),
				rs.getString("c.nal")	
				);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return vo;
	}

	//제꺼는 걍 뺴고 다른걸로 추가했슈
	//overloding 중복선언!
	/* 
	 * @Override
	public ScoreVo selectOne(String id) {
		String sql = "";
		ScoreVo vo = null;
		
		try {
			sql = "select s.id, s.mNme, c.subject, c.score, c.nal " 
				+ "from student "
				+ "on s.id = c.id " 
				+ "where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				vo = new ScoreVo(
						//값이 있으면 가져와!
					rs.getString("s.id"),
					rs.getString("s.mName"),
					rs.getString("subject"),
					rs.getInt("score"),
					rs.getString("nal")						
					);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
	 */

}
