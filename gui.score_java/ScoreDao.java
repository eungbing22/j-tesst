// 0420

package gui.score;

public class ScoreDao {
	// 필드
	ScoreVo[] data;
	int cnt; // 입력된 데이터의 건수

	// 생성자 메서드
	ScoreDao() {
		data = new ScoreVo[50];

		// data를 미리 넣어두고 테스트
		data[0] = new ScoreVo("hong", 40, 50, 60);
		data[1] = new ScoreVo("kim", 40, 50, 60);
		data[2] = new ScoreVo("lee", 40, 50, 60);
		data[3] = new ScoreVo("park", 40, 50, 60);
		data[4] = new ScoreVo("nam", 40, 50, 60);
		cnt = 5;
	}

	// 성적정보 입력
	public boolean append(ScoreVo vo) {
		boolean b = false;
		if (cnt < data.length) {
			data[cnt] = vo;
			cnt++;
			b = true;
			System.out.println("데이터가 저장되었다.");
		}

		return b;

	}

	// 성적정보 출력
	public String output() {
		StringBuilder sb = new StringBuilder(); // 속도 향상을 위해 사용
		for (int i = 0; i < cnt; i++) {
			
			sb.append(data[i].toString());
			sb.append("\n");
		}
		return sb.toString();

	}

	// search
	ScoreVo search(String mId) {
		ScoreVo vo = null;
		for (int i = 0; i < cnt; i++) {
			ScoreVo temp = data[i];
			if (temp.mId.equals(mId)) {
				vo = temp;
				break;
			}
		}
		return vo;

	}

	// 조회된 데이터 수정
	public boolean modify(ScoreVo vo) {
		boolean b = false;

		int index = -1; // 검색될 위치 => 배열의 첫번째값이 0이니까 1이 아니라 -1로 해두었음

		// 수정될 위치 검색
		for (int i = 0; i < cnt; i++) {
			if (data[i].mId.equals(vo.mId)) {
				index = i;
				break;
			}

		}
		// 매개변수로 전달된 vo을 검색 위치에 대입
		if (index > -1) {
			data[index] = vo;
			b = true;
		}
		return b;
	}

	// 삭제
	public boolean delete(String mId) {
	// mid 가 고유값이니까 이 값을 가지고 와서 삭제
		boolean b = false;
		int index = -1;
		int i=0;
		
		// 삭제될 mId의 위치를 검색(index)
		for(i=0; i<cnt; i++) {
			if(data[i].mId.equals(mId)) {
				index=i;
				break;				
			}
			
		}
		// index값이 -1보다 클 때 
		//해당 위치의 값부터 배열의 크기까지 순환하면서
		// index 뒤의 값을 index에 대입.
		// 작업후 cnt 감소.
		if(index>-1) {
			for(i=index; i<cnt-1; i++) {
				//배열의 cnt 크기까지
				data[i]=data[i+1];
			}
			data[i]=null;
			cnt--;	// 다 작업하고 -1 처리
			b= true;
		}
		return b;
	}

}
