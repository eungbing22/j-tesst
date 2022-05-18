// 0422~0425
// Data Access Object

package gui.product;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class ProductDao {
	
	Map<String, String> map;
	Vector<ProductVo> data = new Vector<ProductVo>();
	int sno;

	public ProductDao() {
		map = new HashMap<String, String>();
		map.put("c001", "컴퓨터");
		map.put("d001", "모니터");
		map.put("e001", "마우스");
		map.put("f001", "키보드");
		map.put("g001", "SSD");
		map.put("a001", "냉장고");
		map.put("b001", "세탁기");

		// 테스트를 위한 초기 데이터
		data.add(new ProductVo(1, "c001", "컴퓨터", "2022-01-01", 100, 5000));
		data.add(new ProductVo(2, "d001", "모니터", "2022-01-11", 100, 5000));
		data.add(new ProductVo(3, "e001", "마우스", "2022-01-21", 100, 5000));
		data.add(new ProductVo(4, "f001", "키보드", "2022-02-01", 100, 5000));
		data.add(new ProductVo(5, "g001", "SSD", "2022-03-01", 100, 5000));
		sno = 6; // 데이터가 추가될때마다 무조건 1씩 증가! // 순번 => serial

	}

	public Vector<ProductVo> getData() {
		return data;
	}

	public ProductVo getVo(int index) {
		ProductVo vo = null;
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getSno() == index) {
				vo = data.get(i);
				break;
			}

		}
		return vo;
	}

	// getter
	public int getSno() { 
		return sno;
	}

	// append
	public boolean append(ProductVo vo) {
		boolean b = false;
		try {
			// 저장이 정상
			data.add(vo);
			b = true;
			sno++;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return b;
	}

	// modify
	public boolean modify(ProductVo vo) {
		boolean b = false;
	
		int index = data.indexOf(vo); 

		if (index >= 0) {
			data.set(index, vo);
			b = true;
		}
		return b;
	}
	
	public boolean delete(ProductVo vo){
		boolean b = data.remove(vo);
		return b;
	}
}

























