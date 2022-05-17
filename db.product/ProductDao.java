package db.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements ProductInterface {

	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	//생성자메서드
	public ProductDao() {
		//this.conn = new DBProductConn().getConn();
		// 각 메서드에 커넥션 선언해서 주석처리함
	}
	//tfSno에 순번표시를 위한 메서드 생성
	public int getSno() {
		conn = new DBProductConn().getConn();
		int sno = 0;
		String sql = "select max(sno) as k from product";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				sno = rs.getInt("k");
			}
			//conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sno;
	}

	@Override
	public boolean insert(ProductVo vo) {
		
		conn = new DBProductConn().getConn();
	
		boolean b = false;
		
		String sql = "insert into product(code, nal, ea, price, amt) "
				+ "values(?, ?, ?, ?, ?)"; // product에는 codeName,spec 없음
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getCode());
			ps.setString(2, vo.getNal());
			ps.setInt(3, vo.getEa());
			ps.setInt(4, vo.getPrice());
			ps.setInt(5, vo.getAmt());
			
			conn.setAutoCommit(false);
			
			int n = ps.executeUpdate();
			
			if(n>0) {
				b = true;
				conn.commit();
			}else {
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
	public boolean update(ProductVo vo) {

		conn = new DBProductConn().getConn();
		
		boolean b = false;
		String sql = "update product set code=?, nal=?, ea=?, price=?, amt=? "
				   + "where sno=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getCode()+"");
			ps.setString(2, vo.getNal());
			ps.setString(3, vo.getEa()+"");
			ps.setString(4, vo.getPrice()+"");
			ps.setString(5, vo.getAmt()+"");
			ps.setInt(6, vo.getSno());

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
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return b;
	}

	@Override
	public boolean delete(int sno) {
		
		conn = new DBProductConn().getConn();
		
		boolean b = false;
		String sql = "delete from product where sno=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sno);
			conn.setAutoCommit(false);
			int n = ps.executeUpdate();
			if(n>0) {
				b=true;
				conn.commit();
			}else {
				conn.rollback();				
			}
		}catch(Exception e) {
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
	public List<ProductVo> select(String findStr) {
		conn = new DBProductConn().getConn();
		//검색 버튼 눌렀을때
		List<ProductVo> list = new ArrayList<ProductVo>();
		
		String sql = "select sno, p1.code code, p1.codeName codeName, p1.spec spec, "
				   + "nal, ea, p1.price, amt "
				   + "from parts p1 join product p2 "
				   + "on p1.code = p2.code "
				   + "where p1.code like ? "
				   + "or codeName like ? "
				   + "or nal like ? "
				   + "or p1.price like ?"
				   + "order by p2.sno";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,"%"+findStr+"%");
			ps.setString(2,"%"+findStr+"%");
			ps.setString(3,"%"+findStr+"%");
			ps.setString(4,"%"+findStr+"%");
			conn.setAutoCommit(false);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ProductVo vo = new ProductVo();
				vo.setSno(rs.getInt("sno"));
				vo.setCode(rs.getString("code"));
				vo.setCodeName(rs.getString("codeName"));
				vo.setSpec(rs.getString("spec"));
				vo.setNal(rs.getString("nal"));
				vo.setEa(rs.getInt("ea"));
				vo.setPrice(rs.getInt("price"));
				vo.setAmt(rs.getInt("amt"));
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
	public ProductVo selectOne(int sno) {
		conn = new DBProductConn().getConn();
					
		String sql = "select sno, p1.code code, p1.codeName codeName, p1.spec spec, "
				   + "nal, ea, p1.price, amt "
				   + "from parts p1 join product p2 "
				   + "on p1.code = p2.code "
				   + "where sno=?";
		
		ProductVo vo = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sno);
			rs = ps.executeQuery();
	
			if(rs.next()) {
				vo = new ProductVo();
				vo.setSno(rs.getInt("sno"));
				vo.setCode(rs.getString("code"));
				vo.setCodeName(rs.getString("codeName"));
				vo.setSpec(rs.getString("spec"));
				vo.setNal(rs.getString("nal"));
				vo.setEa(rs.getInt("ea"));
				vo.setPrice(rs.getInt("price"));
				vo.setAmt(rs.getInt("amt"));
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
	public ProductVo selectOne(String code) {
		// 제품코드 parts에서 조회
		conn = new DBProductConn().getConn();
		
		String sql = "select code, codeName, spec, price from "
				   + "parts where code=?";
		ProductVo vo = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, code);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				vo = new ProductVo();
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
}
