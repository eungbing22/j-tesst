// 0428

package db;

import java.util.Vector;

public class StudentVo {
	
	String id ;
	String mName;
	String pwd;
	String email;
	String phone;
	
	public StudentVo() {}
	
	public StudentVo(String id, String mName, String pwd, String email, String phone) {
		this.id = id;
		this.mName = mName;
		this.pwd = pwd;
		this.email = email;
		this.phone = phone;		
	}
	
	//DefaultTableModel에 row를 추가하기 위한 메서드
	public Vector<String> getVector(){
		
		Vector v = new Vector();
		
		v.add(id);
		v.add(mName);
		v.add(email);
		v.add(phone);
		
		return v;
		
	}
	
	//getter&setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

};




