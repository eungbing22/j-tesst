// 0429~0502

package db;

import java.util.List;

public interface StudentInterface {

	// C
	public boolean insert(StudentVo vo);
	
	// R
	public List<StudentVo> select(String findStr);

	// R
	public StudentVo selectOne(String id);
	
	// U
	public boolean update(StudentVo vo);

	// D
	public boolean delete(String id, String pwd);
		
}
