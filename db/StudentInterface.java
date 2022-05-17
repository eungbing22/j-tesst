// 0429_1
// 오전  10시 14분

package db;

import java.util.List;

public interface StudentInterface {

	//C : 화면의 내용이 Vo로 만들어져서, 매개변수로 전달되면,
	//해당 내용을 처리하고 그 결과를 논리값으로 반환하겠다.
	public boolean insert(StudentVo vo);
	
	
	//R : 1) 검색어를 매개변수로 전달받아 
	// 그 결과를 List<vo>로 만들어 반환하겠다.
	public List<StudentVo> select(String findStr);
	//검색어로 전달받은 내용을 select라하고 List<StudentVo>에 반환?
	
	
	//R : 2) 아이디를 매개변수로 전달받아 그 결과를 vo로 만들어 반환하겠다.
	public StudentVo selectOne(String id);
	
	
	//U : 화면의 내용을 vo로 만들어 매개변수로 전달되면 처리를 한 후에 논리값으로 반환하겠다.
	public boolean update(StudentVo vo);
	//update(StudentVo vo)를 boolean으로 전달해라~~~~?
	
	
	//D : 아이디와 암호를 전달받아 삭제하고 그 결과를 논리값으로 반환 하겠다.
	public boolean delete(String id, String pwd);
		
}
