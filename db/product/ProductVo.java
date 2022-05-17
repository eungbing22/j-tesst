//0502_ 오후 3시반부터

package db.product;

import java.text.DecimalFormat;
import java.util.Vector;

public class ProductVo {
	//필드 선언
	int sno;
	String code;
	String codeName;
	String spec;
	String nal;
	int ea;
	int price;
	int amt;
	DecimalFormat df = new DecimalFormat("###,###");
	
	//오버로딩
	public ProductVo(){}
	
	//저장용 생성자			// 퍼포먼스의 향상을 기대할 수 있다!
	public ProductVo(int sno, String code, String nal, int ea, int price){
		this.sno = sno;
		this.code = code;
		this.nal = nal;
		this.ea = ea;
		this.price = price;
		this.amt = ea*price;
	}
	
	//수정,삭제를 위한 값을 표시하는 생성자  //view
	public ProductVo(int sno, String code, String codeName, String spec, String nal, 
		int ea, int price) {
		//자기 자신을 부름
		this(sno, code, nal, ea, price);
		//중복코드 최소화
		this.codeName = codeName;
		this.spec = spec;
		
	}
		
	//DefaultTableModel에 셋팅할 vector 생성
	Vector<String> getVector(){
		Vector<String> v = new Vector<String>();
		v.add(sno+"");
		v.add(code);
		v.add(codeName);
		v.add(spec);
		v.add(nal);
		v.add(df.format(ea));
		v.add(df.format(price));
		v.add(df.format(amt));
		return v;
	}
	
	//getter&setter 부르기
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
	
	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
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
