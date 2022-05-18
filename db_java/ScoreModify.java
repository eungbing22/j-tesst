// 0429~0502

package db;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScoreModify extends JPanel {
	
	ScoreDao dao;
	
	private JLabel lblNewLabel;
	private JTextField tfId;
	private JTextField tfName;
	private JTextField tfSubject;
	private JTextField tfScore;
	private JTextField tfNal;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_1_1_1_1_1;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JLabel lblNewLabel_0;
	private JTextField tfSno;
	private JButton btnSearch;

	/**
	 * Create the panel.
	 */
	public ScoreModify() {
		setBackground(Color.WHITE);
		setLayout(null);
		add(getLblNewLabel());
		add(getTfId());
		add(getTfName());
		add(getTfSubject());
		add(getTfScore());
		add(getTfNal());
		add(getLblNewLabel_1());
		add(getLblNewLabel_2());
		add(getLblNewLabel_3());
		add(getLblNewLabel_4());
		add(getLblNewLabel_1_1_1_1_1());
		add(getBtnUpdate());
		add(getBtnDelete());
		add(getLblNewLabel_0());
		add(getTextField_5_1());
		add(getBtnSearch());
		
		dao = new ScoreDao();
	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("성적 정보 수정");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("나눔고딕", Font.PLAIN, 15));
			lblNewLabel.setBounds(191, 27, 219, 15);
		}
		return lblNewLabel;
	}
	public JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			tfId.setColumns(10);
			tfId.setBounds(199, 108, 173, 21);
		}
		return tfId;
	}
	public JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			tfName.setColumns(10);
			tfName.setBounds(199, 136, 173, 21);
		}
		return tfName;
	}
	public JTextField getTfSubject() {
		if (tfSubject == null) {
			tfSubject = new JTextField();
			tfSubject.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			tfSubject.setColumns(10);
			tfSubject.setBounds(199, 162, 173, 21);
		}
		return tfSubject;
	}
	public JTextField getTfScore() {
		if (tfScore == null) {
			tfScore = new JTextField();
			tfScore.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			tfScore.setColumns(10);
			tfScore.setBounds(199, 191, 173, 21);
		}
		return tfScore;
	}
	public JTextField getTfNal() {
		if (tfNal == null) {
			tfNal = new JTextField();
			tfNal.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			tfNal.setColumns(10);
			tfNal.setBounds(199, 222, 173, 21);
		}
		return tfNal;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("아이디");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(137, 111, 50, 15);
		}
		return lblNewLabel_1;
	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("성 명");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			lblNewLabel_2.setBounds(137, 139, 50, 15);
		}
		return lblNewLabel_2;
	}
	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("과 목");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			lblNewLabel_3.setBounds(137, 165, 50, 15);
		}
		return lblNewLabel_3;
	}
	public JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("성 적");
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			lblNewLabel_4.setBounds(137, 194, 50, 15);
		}
		return lblNewLabel_4;
	}
	public JLabel getLblNewLabel_1_1_1_1_1() {
		if (lblNewLabel_1_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1_1 = new JLabel("응시일자");
			lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_1_1_1.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			lblNewLabel_1_1_1_1_1.setBounds(137, 225, 50, 15);
		}
		return lblNewLabel_1_1_1_1_1;
	}
	public JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("수 정");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int sno = Integer.parseInt(tfSno.getText().trim());
					String id = tfId.getText().trim();
					String mName = tfName.getText().trim();
					String subject = tfSubject.getText().trim();
					int score = Integer.parseInt(tfScore.getText().trim());
					String nal = tfNal.getText().trim();
					
					ScoreVo vo = new ScoreVo();
					
					vo.setSno(sno);
					vo.setId(id);
					vo.setmName(mName);
					vo.setSubject(subject);
					vo.setScore(score);
					vo.setNal(nal);

					boolean b = dao.update(vo);
				
					if(b) {
						ScoreFrame.status.setText("성적 정보를 수정하였습니다.");
						tfSno.requestFocus();
					}else {
						ScoreFrame.status.setText("수정 중 오류가 발생하였습니다.");
					}
				}
			});
			btnUpdate.setForeground(Color.WHITE);
			btnUpdate.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			btnUpdate.setBackground(Color.GRAY);
			btnUpdate.setBounds(192, 276, 91, 23);
		}
		return btnUpdate;
	}
	public JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭 제");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//
					int sno = Integer.parseInt(tfSno.getText().trim());
					boolean b = dao.delete(sno);
					if(b) {
						ScoreFrame.status.setText("성적 정보가 삭제되었습니다.");
						tfSno.setText("");
						tfSubject.setText("");
						tfScore.setText("");
						tfNal.setText("");
						tfSno.requestFocus();
					}else {
						ScoreFrame.status.setText("삭제 중 오류가 발생하였습니다.");
					}
				}
			});
			btnDelete.setForeground(Color.WHITE);
			btnDelete.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			btnDelete.setBackground(Color.GRAY);
			btnDelete.setBounds(307, 276, 91, 23);
		}
		return btnDelete;
	}
	public JLabel getLblNewLabel_0() {
		if (lblNewLabel_0 == null) {
			lblNewLabel_0 = new JLabel("순 번");
			lblNewLabel_0.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_0.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			lblNewLabel_0.setBounds(137, 83, 50, 15);
		}
		return lblNewLabel_0;
	}
	public JTextField getTextField_5_1() {
		if (tfSno == null) {
			tfSno = new JTextField();
			tfSno.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			tfSno.setColumns(10);
			tfSno.setBounds(199, 80, 173, 21);
		}
		return tfSno;
	}
	public JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("검 색");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//
					int sno = Integer.parseInt(tfSno.getText().trim());
					ScoreVo vo = dao.selectOne(sno);
					if(vo!=null) {
						ScoreFrame.status.setText("성적 정보를 수정해주세요.");
						
						tfId.setText(vo.getId());
						tfName.setText(vo.getmName());
						tfSubject.setText(vo.getSubject());
						tfScore.setText(vo.getScore()+"");
						tfNal.setText(vo.getNal());
						
						tfId.setEditable(false);
						tfName.setEditable(false);
						
					}else {
						ScoreFrame.status.setText(sno + " 에 해당하는 자료가 없습니다.");

						tfId.setText("");
						tfName.setText("");
						tfSubject.setText("");
						tfScore.setText("");
						tfNal.setText("");
					}
				}
			});
			btnSearch.setForeground(Color.WHITE);
			btnSearch.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			btnSearch.setBackground(Color.GRAY);
			btnSearch.setBounds(384, 79, 91, 23);
		}
		return btnSearch;
	}
}
