// 0502_ 오후 3시반부터

package db.product;

import java.text.DecimalFormat;
import java.util.Vector;

public class PartsVo {
	//필드선언
	int no; //테이블 No표기에만 사용
	String code;
	String codeName;
	String spec;
	int price;
	DecimalFormat df = new DecimalFormat("###,###");
	//천단위 기호로 표시하자!
	
	//오버로딩
	PartsVo() {}
	
	//한건의 데이터를 넣는게 vo!ㅋ
	//생성자 메서드
	PartsVo(String code, String codeName, String spec, int price){
		this.code = code;
		this.codeName = codeName;
		this.spec = spec;
		this.price = price;
		
	}
	
	//no를 용이하게 쓰기위해 getter&setter로 불러옴
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}

	//DefaultTableModel을 위한 메서드 getVector를 생성
	public Vector<String> getVector(){
		Vector<String> v = new Vector<String>();
		v.add(no+""); //테이블에서만 사용하는 no
		v.add(code);
		v.add(codeName);
		v.add(spec);
		v.add(df.format(price));
		//소수점을 사용하고, 천단위 분류 기호로 사용하겠다 라는 의미.
		return v;
	}
	
	//setter,getter
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}


