//0429_오후 미션_2

// 다른분꺼 참고해서 일단은 완 근데 이해가 잘 안됌 ㅠ!
// 낼 리뷰해줄때 보기!

// 여러개 같이 사용중
// DBConn
// StudentInterface, StudentDao, StudentVo, StudentInput, StudentModify, StudentDelete;
// ScoreInterface, ScoreDao, ScoreVo, ScoreInput, ScoreModify, ScoreDelete;

package db;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class ScoreInput extends JPanel {

	ScoreDao dao;

	private JLabel lblNewLabel;
	private JLabel lblNewLabel1;
	private JTextField tfId;
	private JLabel lblNewLabel2;
	private JTextField tfName;
	private JLabel lblNewLabel3;
	private JTextField tfSubject;
	private JLabel lblNewLabel4;
	private JTextField tfScore;
	private JLabel lblNewLabel5;
	private JTextField tfNal;
	private JButton btnInsert;
	private JLabel lblNewLabel0;
	private JTextField tfSno;
	private JButton btnSearch;

	/**
	 * Create the panel.
	 */
	public ScoreInput() {
	
		dao = new ScoreDao();

		setBackground(Color.WHITE);
		setLayout(null);
		add(getLblNewLabel());
		add(getLblNewLabel1());
		add(getTfId());
		add(getLblNewLabel2());
		add(getTfName());
		add(getLblNewLabel3());
		add(getTfSubject());
		add(getLblNewLabel4());
		add(getTfScore());
		add(getLblNewLabel5());
		add(getTfNal());
		add(getBtnInsert());
		add(getLblNewLabel0());
		add(getTfSno());
		add(getBtnSearch());
		
		initData();		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String nalTemp = sdf.format(new Date());
		tfNal.setText(nalTemp);
	}
	
	public void initData() {
		int isno = dao.getSno()+1;
		tfSno.setText(isno+"");
	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("성적 입력 항목");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("나눔고딕", Font.PLAIN, 15));
			lblNewLabel.setBounds(138, 14, 284, 31);
		}
		return lblNewLabel;
	}

	public JLabel getLblNewLabel1() {
		if (lblNewLabel1 == null) {
			lblNewLabel1 = new JLabel("아이디");
			lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel1.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			lblNewLabel1.setBounds(143, 107, 50, 15);
		}
		return lblNewLabel1;
	}

	public JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setColumns(10);
			tfId.setBounds(205, 104, 183, 21);
		}
		return tfId;
	}

	public JLabel getLblNewLabel2() {
		if (lblNewLabel2 == null) {
			lblNewLabel2 = new JLabel("성 명");
			lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel2.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			lblNewLabel2.setBounds(143, 138, 50, 15);
		}
		return lblNewLabel2;
	}

	public JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setColumns(10);
			tfName.setBounds(205, 135, 183, 21);
		}
		return tfName;
	}

	public JLabel getLblNewLabel3() {
		if (lblNewLabel3 == null) {
			lblNewLabel3 = new JLabel("과 목");
			lblNewLabel3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel3.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			lblNewLabel3.setBounds(143, 166, 50, 15);
		}
		return lblNewLabel3;
	}

	public JTextField getTfSubject() {
		if (tfSubject == null) {
			tfSubject = new JTextField();
			tfSubject.setColumns(10);
			tfSubject.setBounds(205, 163, 183, 21);
		}
		return tfSubject;
	}

	public JLabel getLblNewLabel4() {
		if (lblNewLabel4 == null) {
			lblNewLabel4 = new JLabel("성 적");
			lblNewLabel4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel4.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			lblNewLabel4.setBounds(143, 194, 50, 15);
		}
		return lblNewLabel4;
	}

	public JTextField getTfScore() {
		if (tfScore == null) {
			tfScore = new JTextField();
			tfScore.setColumns(10);
			tfScore.setBounds(205, 191, 183, 21);
		}
		return tfScore;
	}

	public JLabel getLblNewLabel5() {
		if (lblNewLabel5 == null) {
			lblNewLabel5 = new JLabel("응시일자");
			lblNewLabel5.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel5.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			lblNewLabel5.setBounds(143, 222, 50, 15);
		}
		return lblNewLabel5;
	}

	public JTextField getTfNal() {
		if (tfNal == null) {
			tfNal = new JTextField();
			tfNal.setColumns(10);
			tfNal.setBounds(205, 219, 183, 21);
		}
		return tfNal;
	}

	public JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("검 색");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String id = tfId.getText().trim();
					String mName = dao.search(id);
	
				  if (mName != null) {
					ScoreFrame.status.setText("ID가 확인되었습니다. 성적 정보를 입력해주세요.");
					tfName.setText(mName);
				} else {
					ScoreFrame.status.setText("ID를 확인해주세요.");
					tfName.setText("");
					tfSubject.setText("");
					tfScore.setText("");
					}
				}
			});
			btnSearch.setForeground(Color.WHITE);
			btnSearch.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			btnSearch.setBackground(Color.DARK_GRAY);
			btnSearch.setBounds(400, 103, 66, 22);
		}
		return btnSearch;
	}
	
	public JButton getBtnInsert() {
		if (btnInsert == null) {
			btnInsert = new JButton("입 력");
			btnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//int sno = Integer.parseInt(tfSno.getText().trim());
					String id = tfId.getText().trim();
					String mName = tfName.getText().trim();
					String subject = tfSubject.getText().trim();
					int score = Integer.parseInt(tfScore.getText().trim());
					String nal = tfNal.getText().trim();
					
					ScoreVo vo = new ScoreVo (id, mName, subject, score, nal);

					boolean b = dao.insert(vo); //dao.insert가 boolean타입이라 boolean 타입의 b로 반환
					
					if(b) {
						ScoreFrame.status.setText("성적 정보가 저장되었습니다.");
						
						tfSno.setText(dao.getSno()+1+"");
						tfSubject.setText("");
						tfScore.setText("");
						//tfNal.setText("");
						
					}else {
						ScoreFrame.status.setText("저장 중 오류가 발생하였습니다.");
					}

				}
			});
			btnInsert.setForeground(Color.WHITE);
			btnInsert.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			btnInsert.setBackground(Color.GRAY);
			btnInsert.setBounds(235, 284, 91, 23);
		}
		return btnInsert;
	}

	public JLabel getLblNewLabel0() {
		if (lblNewLabel0 == null) {
			lblNewLabel0 = new JLabel("순 번");
			lblNewLabel0.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel0.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			lblNewLabel0.setBounds(143, 79, 50, 15);
		}
		return lblNewLabel0;
	}

	public JTextField getTfSno() {
		if (tfSno == null) {
			tfSno = new JTextField();
			tfSno.setEditable(false);
			tfSno.setColumns(10);
			tfSno.setBounds(205, 76, 183, 21);
		}
		return tfSno;
	}

}
