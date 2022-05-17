// 0429_2
// 오전 10시 30분 수업

package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao implements StudentInterface {
	
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	
	//생성자로만들어서
	StudentDao() {
		this.conn = new DBConn().getConn();
	}

	@Override
	public boolean insert(StudentVo vo) {
		
		boolean b = false;
		
		//1. SQL문장을 만든다
		String sql = "insert into student(id, mName, pwd, email, phone) values(?, ?, ?, ?, ?)";
		
		//2.PreparedStatement를 만든다
		
		// 다 써줘야 하니까 이왕이면 필드로 꺼내면 편하다!
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getId() );
			ps.setString(2, vo.getmName() );
			ps.setString(3, vo.getPwd() );
			ps.setString(4, vo.getEmail() );
			ps.setString(5, vo.getPhone() );
			
		// 3. 저장잘못될까바 오토 커밋 false
			conn.setAutoCommit(false);
			
		// 반환 execute	
			int n = ps.executeUpdate();
			
		// 
			if (n>0) {
				b = true;
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
	public List<StudentVo> select(String findStr) {
		// list로 만들어서 반환하라~~
		
		//null값이면 나중에 불편해서 재정의함.. 
		List<StudentVo> list = new ArrayList<StudentVo>();
		
		String sql = "select * from student "
				+"where id like ? or mName like ? "			
				+"or email like ? or phone like ? ";
		
		try { 
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + findStr + "%");
			ps.setString(2, "%" + findStr + "%");
			ps.setString(3, "%" + findStr + "%");
			ps.setString(4, "%" + findStr + "%");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				StudentVo vo = new StudentVo();

				vo.setId(rs.getString("id"));
				vo.setmName(rs.getString("mName"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				
				list.add(vo);
			}
	
		}catch(Exception ex) {
			ex.printStackTrace();
		}
			
		return list;
	}

	@Override
	public StudentVo selectOne(String id) {
	
		String sql = "";
		StudentVo vo = null;
		
		try {
		
		sql = "select * from student where id=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		rs = ps.executeQuery();
		
		//while도 상관없는데 그냥 1건이라 next
		if(rs.next()) {
			vo = new StudentVo(
				rs.getString("id"),
				rs.getString("mName"),
				rs.getString("pwd"),
				rs.getString("email"),
				rs.getString("phone")
				);
		}
		
		
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		//vo를 만들어 리턴하겠다
		return vo;
	}

	@Override
	public boolean update(StudentVo vo) {
		
		boolean b  = false;
	
		String sql = "update student set mName=?, email=?, phone=? "
				+ "where id = ? and pwd = ? ";
		
		try {
			ps=conn.prepareStatement(sql);
			
			
			ps.setString(1, vo.getmName());
			ps.setString(2, vo.getEmail());
			ps.setString(3, vo.getPhone());
			ps.setString(4, vo.getId());
			ps.setString(5, vo.getPwd());
			
			conn.setAutoCommit(false);
			int n = ps.executeUpdate();
			if(n>0) {
				b=true;
				conn.commit();
			}else {
				conn.rollback();
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean delete(String id, String pwd) {
		boolean b = false;
		
		String sql = "delete from student where id=? and pwd=?";
		
		try { 
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			
			int n = ps.executeUpdate();
			
			if(n>0){
				b=true;
				conn.commit();
			}else {
				conn.rollback();
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return b;
	}

}



















