// 0422~0425

package gui.product;

import java.util.Vector;

public class ProductVo {

	// 필드
	int sno; 		// 순번
	String code;	// 제품코드
	String codeName;// 제품명
	String nal; 	// 생산일자
	int ea; 		// 수량
	int price; 		// 단가
	int amt; 		// 금액(수량*단가)

	// 생성자 메서드
	public ProductVo(int sno, String code, String codeName, String nal, int ea, int price) {

		this.sno = sno;
		this.code = code;
		this.codeName = codeName;
		this.nal = nal;
		this.ea = ea;
		this.price = price;
		this.amt = ea * price; // amt 생성
	}

	// 오버로딩
	public ProductVo() {
	}

	// vector로 만들어 리스트에 추가
	public Vector<String> getVector() {
		Vector v = new Vector();
		v.add(sno);
		v.add(code);
		v.add(codeName);
		v.add(nal);
		v.add(ea + "");
		v.add(price + "");
		v.add(amt + "");
		return v;
	}
	

	//hashCode와 equals 재정의
	@Override
	public int hashCode() {		
		return this.sno; 
	}

	@Override
	public boolean equals(Object obj) {
		 boolean b = false;
		 if(obj instanceof ProductVo) {
			 ProductVo temp = (ProductVo) obj; 
			 if(temp.getSno() == this.sno) {
				 b=true;
			 }
		 }
		
		return b;
	}
	
	
	// getter & setter
	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

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

	public String getNal() {
		return nal;
	}

	public void setNal(String nal) {
		this.nal = nal;
	}

	public int getEa() {
		return ea;
	}

	public void setEa(int ea) {
		this.ea = ea;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmt() {
		return amt;
	}

	public void setAmt(int amt) {
		this.amt = amt;
	}

}
