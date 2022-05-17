package db.product;

import java.util.List;

public interface ProductInterface {
	
	public boolean insert(ProductVo vo);
	
	public boolean update(ProductVo vo);
	
	public boolean delete(int sno);
	
	public List<ProductVo> select(String findStr);

	public ProductVo selectOne(int sno);

	public ProductVo selectOne(String code);

}
