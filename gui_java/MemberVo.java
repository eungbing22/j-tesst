// 0418-19
// Value Object

package gui;

public class MemberVo {

	// 필드
	String mId;
	String mName;
	String address;
	String phone;

	// 생성자 메서드
	public MemberVo(String id, String mName, String addr, String pho) {
		this.mId=id;
		this.mName=mName;
		this.address=addr;
		this.phone=pho;
	}

	@Override	//재정의
	public String toString() {
		String str=String.format("%-10s %-10s %-20s %-15s",
				this.mId,this.mName,this.address, this.phone);
		return str;
	}
	
  }