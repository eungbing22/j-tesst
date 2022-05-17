package db.product;

import java.util.List;

public interface PartsInterface {
	
	public String search(String Code);
	
	public boolean insert(PartsVo vo);
	
	//검색어를 매개변수로 전달받아 그 결과를 list의 vo로 만들어 반환
	public List<PartsVo> select(String findStr);
	
	//우측의 list 내용을 가지고와서 왼쪽 text field에 출력
	public PartsVo selectOne(String code);
	
	public boolean update(PartsVo vo);
	
	public boolean delete(PartsVo vo);
	
}
