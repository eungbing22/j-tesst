package db.product;

import java.util.List;

public interface ProductInterface {
	
	public boolean insert(ProductVo vo);
	
	public boolean update(ProductVo vo);
	
	public boolean delete(int sno);
	
	public List<ProductVo> select(String findStr);
	//검색어를 매개변수로 전달받아 그 결과를 list의 <ProductVo>로 만들어 반환하겠다.

	public ProductVo selectOne(int sno);
	//프라이머리키라 필요하다!
	
	public ProductVo selectOne(String code);
	//코드를 매개변수로 전달받아 그 결과를 vo로 만들어 반환하겠다.
}
