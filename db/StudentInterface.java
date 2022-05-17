// 0429_1

package db;

import java.util.List;

public interface StudentInterface {
	public boolean insert(StudentVo vo);
	
	public List<StudentVo> select(String findStr);
	
	public StudentVo selectOne(String id);

	public boolean update(StudentVo vo);
	
	public boolean delete(String id, String pwd);
		
}
