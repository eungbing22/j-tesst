//0429_오후 미션_1
// 오후 4시 40분

// 여러개 같이 사용중
// DBConn
// StudentInterface, StudentDao, StudentVo, StudentInput, StudentModify, StudentDelete;
// ScoreInterface, ScoreDao, ScoreVo, ScoreInput, ScoreModify, ScoreDelete;

package db;

import java.util.List;

public interface ScoreInterface {
	public boolean insert(ScoreVo vo);
	public boolean update(ScoreVo vo);
	public boolean delete(int sno); //int sno로 다시 바꿈//id꺼를 다 지우면 안되니께
	public List<ScoreVo> select(String findStr);
	public ScoreVo selectOne(int sno);
	//public ScoreVo selectOne(String id);
	public String search(String id); //추가하고 대체
}


