// 0418-19
// Data Access Object

package gui;

public class MemberDao {
	MemberVo[] data;
	int cnt = 0; // 저장된 데이터의 건수 저장

	public MemberDao() {
		data = new MemberVo[50];
	}

	public void add(MemberVo vo) {
		if (cnt >= data.length) {
			System.out.println("저장공간이 이미 꽉 찼습니다.");

		} else {
			data[cnt] = vo;
			cnt++;
		}
	}

	public String output() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cnt; i++) {
			MemberVo v = data[i];
			sb.append(v.toString());
			sb.append("\n");
		}
		return sb.toString();
	}
}
