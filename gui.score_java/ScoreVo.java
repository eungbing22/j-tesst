// 0420

package gui.score;

public class ScoreVo {

	// 필드
	String mId;
	int kor, eng, mat, tot;
	double avg;

	// 생성자 메서드
	ScoreVo(String mId, int kor, int eng, int mat) {
		this.mId = mId;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		compute();
	}

	public void compute() { // 총점, 평균
		this.tot = this.kor + this.eng + this.mat;
		this.avg = this.tot / 3.0;
	}

	@Override
	public String toString() {
		String str = String.format("%-20s %-10s %-10s %-10s %-10s %-10.1f", 
				this.mId, this.kor, this.eng, this.mat, this.tot, this.avg);
		return str;
	}

}
