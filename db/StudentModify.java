// 0428_4

package db;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentModify extends JPanel {
	
	StudentDao dao;
	
	private JLabel lblNewLabel;
	private JTextField tfId;
	private JTextField tfName;
	private JTextField tfPwd;
	private JTextField tfEmail;
	private JTextField tfPhone;
	private JButton btnSearch;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_1_1;
	private JLabel lblNewLabel_1_1_1_1;
	private JLabel lblNewLabel_1_1_1_1_1;
	private JButton btnUpdate;
	private JButton btnDelete;

	/**
	 * Create the panel.
	 */
	public StudentModify() {
		setBackground(Color.WHITE);
		setLayout(null);
		add(getLblNewLabel());
		add(getTfId());
		add(getTfName());
		add(getTfPwd());
		add(getTfEmail());
		add(getTfPhone());
		add(getBtnSearch());
		add(getLblNewLabel_1());
		add(getLblNewLabel_1_1());
		add(getLblNewLabel_1_1_1());
		add(getLblNewLabel_1_1_1_1());
		add(getLblNewLabel_1_1_1_1_1());
		add(getBtnUpdate());
		add(getBtnDelete());
		
		dao = new StudentDao();
		//맨위에 해도 된다고는 하심

	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("학생 정보 수정");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("나눔고딕", Font.PLAIN, 15));
			lblNewLabel.setBounds(163, 32, 223, 36);
		}
		return lblNewLabel;
	}
	public JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setColumns(10);
			tfId.setBounds(188, 92, 173, 21);
		}
		return tfId;
	}
	public JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setColumns(10);
			tfName.setBounds(188, 123, 173, 21);
		}
		return tfName;
	}
	public JTextField getTfPwd() {
		if (tfPwd == null) {
			tfPwd = new JTextField();
			tfPwd.setColumns(10);
			tfPwd.setBounds(188, 149, 173, 21);
		}
		return tfPwd;
	}
	public JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setColumns(10);
			tfEmail.setBounds(188, 175, 173, 21);
		}
		return tfEmail;
	}
	public JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setColumns(10);
			tfPhone.setBounds(188, 206, 173, 21);
		}
		return tfPhone;
	}
	public JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("검 색");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				//
				String id = tfId.getText().trim();
				StudentVo vo = dao.selectOne(id);
				if(vo!=null) {
					tfName.setText(vo.getmName());
					//암호 패스
					tfEmail.setText(vo.getEmail());
					tfPhone.setText(vo.getPhone());
				}else {
					ScoreFrame.status.setText("해당 자료가 없습니다.");
					tfName.setText("");
					tfEmail.setText("");
					tfPhone.setText("");
				}
				//
					
				}
			});
			btnSearch.setBackground(Color.GRAY);
			btnSearch.setForeground(Color.WHITE);
			btnSearch.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			btnSearch.setBounds(373, 91, 91, 23);
		}
		return btnSearch;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("아이디");
			lblNewLabel_1.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(126, 95, 50, 15);
		}
		return lblNewLabel_1;
	}
	public JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("성 명");
			lblNewLabel_1_1.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1.setBounds(126, 126, 50, 15);
		}
		return lblNewLabel_1_1;
	}
	public JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("암 호");
			lblNewLabel_1_1_1.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_1.setBounds(126, 152, 50, 15);
		}
		return lblNewLabel_1_1_1;
	}
	public JLabel getLblNewLabel_1_1_1_1() {
		if (lblNewLabel_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1 = new JLabel("이메일");
			lblNewLabel_1_1_1_1.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_1_1.setBounds(126, 178, 50, 15);
		}
		return lblNewLabel_1_1_1_1;
	}
	public JLabel getLblNewLabel_1_1_1_1_1() {
		if (lblNewLabel_1_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1_1 = new JLabel("연락처");
			lblNewLabel_1_1_1_1_1.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_1_1_1.setBounds(126, 209, 50, 15);
		}
		return lblNewLabel_1_1_1_1_1;
	}
	public JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("수 정");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//
					String id = tfId.getText().trim();
					String mName = tfName.getText().trim();
					String pwd = tfPwd.getText().trim();
					String email = tfEmail.getText().trim();
					String phone = tfPhone.getText().trim();
								
					StudentVo vo = new StudentVo(id, mName, pwd, email, phone);
				
					boolean b = dao.update(vo);
					
					if(b) {
						ScoreFrame.status.setText("자료가 수정되었습니다.");
						
					}else {
						ScoreFrame.status.setText("자료 수정중 오류가 발생했습니다.");	
					}
					
				}
			});
			btnUpdate.setBackground(Color.GRAY);
			btnUpdate.setForeground(Color.WHITE);
			btnUpdate.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			btnUpdate.setBounds(163, 251, 91, 23);
		}
		return btnUpdate;
	}
	public JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭 제");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String id = tfId.getText().trim();
					String pwd = tfPwd.getText().trim();
					
					boolean b = dao.delete(id, pwd);
					
					if(b) {
						ScoreFrame.status.setText("자료가 삭제 되었습니다.");
						
						//자료 삭제
						//id는 놔두신다심
						tfPwd.setText("");
						tfName.setText("");
						tfEmail.setText("");
						tfPhone.setText("");
						
						tfId.requestFocus(); // 커서를 id로 !
						
					}else {
						ScoreFrame.status.setText("자료 삭제중 오류가 발생되었습니다.");
					}
					//
				}
				
			});
			btnDelete.setBackground(Color.GRAY);
			btnDelete.setForeground(Color.WHITE);
			btnDelete.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			btnDelete.setBounds(281, 251, 91, 23);
		}
		return btnDelete;
	}
}
