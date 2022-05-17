// 0502

package db.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gui.product.ProductVo;

public class PartsDao implements PartsInterface {

	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	// 생성자메서드
	public PartsDao() {
		// this.conn = new DBProductConn().getConn();
		// 각각 메서드에서 선언해두어서 주석처리
	}

	@Override
	public String search(String code) { // 코드 찾기
		conn = new DBProductConn().getConn();	//각각 열고 닫아서 충돌 예방

		String sql = "select codeName, price from parts " 
				   + "where code=?";
		String codeName = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, code);
			rs = ps.executeQuery();

			if (rs.next()) {
				codeName = rs.getString("codeName");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return codeName;
	}

	@Override
	public boolean insert(PartsVo vo) {	// 저장 관련
		
		conn = new DBProductConn().getConn();
		
		boolean b = false;
		
		String sql = "insert into parts(code, codeName, spec, price) " 
		           + "values( ?, ?, ?, ? )";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getCode());
			ps.setString(2, vo.getCodeName());
			ps.setString(3, vo.getSpec());
			ps.setInt(4, vo.getPrice());

			conn.setAutoCommit(false);
			int n = ps.executeUpdate();

			if (n > 0) {
				b = true;
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<PartsVo> select(String findStr) {

		conn = new DBProductConn().getConn();

		// list로 만들어 반환
		List<PartsVo> list = new ArrayList<PartsVo>();

		String sql = "select code, codeName, spec, price " 
				   + "from parts where code like ? "
				   + "or codeName like ? or spec like ? " 
				   + "or price like ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + findStr + "%");
			ps.setString(2, "%" + findStr + "%");
			ps.setString(3, "%" + findStr + "%");
			ps.setString(4, "%" + findStr + "%");
			rs = ps.executeQuery();

			while (rs.next()) {
				PartsVo vo = new PartsVo();
				vo.setCode(rs.getString("code"));
				vo.setCodeName(rs.getString("codeName"));
				vo.setSpec(rs.getString("spec"));
				vo.setPrice(rs.getInt("price"));

				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public PartsVo selectOne(String code) {
		conn = new DBProductConn().getConn();

		String sql = "select code, codeName, spec, price from parts " 
				   + "where code=?";
		PartsVo vo = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, code);
			rs = ps.executeQuery();

			if (rs.next()) {
				vo = new PartsVo();
				vo.setCode(rs.getString("code"));
				vo.setCodeName(rs.getString("codeName"));
				vo.setSpec(rs.getString("spec"));
				vo.setPrice(rs.getInt("price"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public boolean update(PartsVo vo) {

		conn = new DBProductConn().getConn();

		boolean b = false;

		String sql = "update parts set codeName=?, spec=?, price=? " 
		           + "where code=?";
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, vo.getCodeName());
			ps.setString(2, vo.getSpec());
			ps.setInt(3, vo.getPrice());
			ps.setString(4, vo.getCode());

			conn.setAutoCommit(false);

			int n = ps.executeUpdate();

			if (n > 0) {
				b = true;
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean delete(PartsVo vo) {

		conn = new DBProductConn().getConn();

		boolean b = false;

		String sql = "delete from parts where code=?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getCode());
			conn.setAutoCommit(false);
			int n = ps.executeUpdate();
			if (n > 0) {
				b = true;
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return b;
	}
}
