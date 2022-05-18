// 0428~0502

package db;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentInput extends JPanel {
	
	StudentDao dao;
	
	private JLabel lblNewLabel;
	private JTextField tfId;
	private JLabel lblNewLabel1;
	private JLabel lblNewLabel2;
	private JTextField tfName;
	private JLabel lblNewLabel3;
	private JTextField tfPwd;
	private JLabel lblNewLabel4;
	private JTextField tfEmail;
	private JLabel lblNewLabel5;
	private JTextField tfPhone;
	private JButton btnInsert;

	/**
	 * Create the panel.
	 */
	public StudentInput() {
		
		dao = new StudentDao();
		
		setBackground(Color.WHITE);
		setLayout(null);
		add(getLblNewLabel());
		add(getTfId());
		add(getLblNewLabel1());
		add(getLblNewLabel2());
		add(getTfName());
		add(getLblNewLabel3());
		add(getTfPwd());
		add(getLblNewLabel4());
		add(getTfEmail());
		add(getLblNewLabel5());
		add(getTfPhone());
		add(getBtnInsert());

	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("학생 정보 입력");
			lblNewLabel.setFont(new Font("나눔고딕", Font.PLAIN, 15));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(168, 10, 215, 34);
		}
		return lblNewLabel;
	}
	public JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setBounds(220, 88, 183, 21);
			tfId.setColumns(10);
		}
		return tfId;
	}
	public JLabel getLblNewLabel1() {
		if (lblNewLabel1 == null) {
			lblNewLabel1 = new JLabel("아이디");
			lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel1.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			lblNewLabel1.setBounds(158, 91, 50, 15);
		}
		return lblNewLabel1;
	}
	public JLabel getLblNewLabel2() {
		if (lblNewLabel2 == null) {
			lblNewLabel2 = new JLabel("성 명");
			lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel2.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			lblNewLabel2.setBounds(158, 122, 50, 15);
		}
		return lblNewLabel2;
	}
	public JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setColumns(10);
			tfName.setBounds(220, 119, 183, 21);
		}
		return tfName;
	}
	public JLabel getLblNewLabel3() {
		if (lblNewLabel3 == null) {
			lblNewLabel3 = new JLabel("암 호");
			lblNewLabel3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel3.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			lblNewLabel3.setBounds(158, 150, 50, 15);
		}
		return lblNewLabel3;
	}
	public JTextField getTfPwd() {
		if (tfPwd == null) {
			tfPwd = new JTextField();
			tfPwd.setColumns(10);
			tfPwd.setBounds(220, 147, 183, 21);
		}
		return tfPwd;
	}
	public JLabel getLblNewLabel4() {
		if (lblNewLabel4 == null) {
			lblNewLabel4 = new JLabel("이메일");
			lblNewLabel4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel4.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			lblNewLabel4.setBounds(158, 178, 50, 15);
		}
		return lblNewLabel4;
	}
	public JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setColumns(10);
			tfEmail.setBounds(220, 175, 183, 21);
		}
		return tfEmail;
	}
	public JLabel getLblNewLabel5() {
		if (lblNewLabel5 == null) {
			lblNewLabel5 = new JLabel("연락처");
			lblNewLabel5.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel5.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			lblNewLabel5.setBounds(158, 206, 50, 15);
		}
		return lblNewLabel5;
	}
	public JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setColumns(10);
			tfPhone.setBounds(220, 203, 183, 21);
		}
		return tfPhone;
	}
	public JButton getBtnInsert() {
		if (btnInsert == null) {
			btnInsert = new JButton("저 장");
			btnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//
					String id = tfId.getText().trim();
					String mName = tfName.getText().trim();
					String pwd = tfPwd.getText().trim();
					String email = tfEmail.getText().trim();
					String phone = tfPhone.getText().trim();
								
					StudentVo vo = new StudentVo(id, mName, pwd, email, phone);
				
					boolean b = dao.insert(vo);
				
					if(b) {
						ScoreFrame.status.setText("학생 정보가 저장되었습니다.");
						// 값 초기화
						tfId.setText("");
						tfName.setText("");
						tfPwd.setText("");
						tfEmail.setText("");
						tfPhone.setText("");	
					}else {
						ScoreFrame.status.setText("저장 중 오류가 발생했습니다.");
					}
				}
			});
			btnInsert.setBackground(Color.GRAY);
			btnInsert.setForeground(Color.WHITE);
			btnInsert.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			btnInsert.setBounds(188, 248, 91, 23);
		}
		return btnInsert;
	}
}
