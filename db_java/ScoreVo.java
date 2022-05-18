// 0428~0502

package db;

import java.util.Vector;

public class ScoreVo {
	
	//필드 선언
	int sno;
	String id;
	String mName;
	String subject;
	int score;
	String nal;
	
	//오버로딩
	public ScoreVo() {}
	
	//생성자 메서드
	public ScoreVo(String id, String mName, String subject, int score, String nal) {
		//this.sno=sno;	//자동		//int sno, 
		this.id=id;
		this.mName=mName;
		this.subject=subject;
		this.score=score;
		this.nal=nal;	
	}
	
	//DefaultTablemodel에 row를 추가하기 위한 메서드
	public Vector<String> getVector(){	
		Vector v = new Vector();
		
		v.add(sno);
		v.add(mName);
		v.add(subject);
		v.add(score);
		v.add(nal);
		
		return v;
	}

	//setter&getter
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getNal() {
		return nal;
	}
	public void setNal(String nal) {
		this.nal = nal;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	
}
