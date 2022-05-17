//0429_오후

package db;

import java.util.List;

public interface ScoreInterface {
	public boolean insert(ScoreVo vo);
	public boolean update(ScoreVo vo);
	public boolean delete(int sno); 
	public List<ScoreVo> select(String findStr);
	public ScoreVo selectOne(int sno);
	public String search(String id);
}


