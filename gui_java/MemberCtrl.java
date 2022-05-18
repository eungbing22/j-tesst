// 0418-19

package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class MemberCtrl extends JFrame {
	
	MemberDao dao;
	
	private JPanel contentPane;
	private JTextField tfId;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField tfName;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField tfAddress;
	private JTextField tfPhone;
	private JLabel lblNewLabel_4;
	private JButton btnSave;
	private JButton btnPrint;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_5;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try { 
					MemberCtrl frame = new MemberCtrl();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MemberCtrl() {
		setFont(new Font("나눔고딕", Font.PLAIN, 10)); 
		
		dao= new MemberDao(); 
		
		setTitle("회원관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 746);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTfId());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getTfName());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getTfAddress());
		contentPane.add(getTfPhone());
		contentPane.add(getLblNewLabel_4());
		contentPane.add(getBtnSave());
		contentPane.add(getBtnPrint());
		contentPane.add(getScrollPane());

	}
	public JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			tfId.setBounds(104, 78, 96, 21);
			tfId.setColumns(10);
		}
		return tfId;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("아이디");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			lblNewLabel.setBounds(42, 81, 50, 15);
		}
		return lblNewLabel;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("성명");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			lblNewLabel_1.setBounds(42, 117, 50, 15);
		}
		return lblNewLabel_1;
	}
	public JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			tfName.setBounds(104, 114, 96, 21);
			tfName.setColumns(10);
		}
		return tfName;
	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("주소");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			lblNewLabel_2.setBounds(42, 151, 50, 15);
		}
		return lblNewLabel_2;
	}
	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("연락처");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			lblNewLabel_3.setBounds(42, 185, 50, 15);
		}
		return lblNewLabel_3;
	}
	public JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			tfAddress.setBounds(104, 148, 219, 21);
			tfAddress.setColumns(10);
		}
		return tfAddress;
	}
	public JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			tfPhone.setBounds(104, 182, 96, 21);
			tfPhone.setColumns(10);
		}
		return tfPhone;
	}
	public JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("회원관리");
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4.setFont(new Font("나눔고딕", Font.PLAIN, 15));
			lblNewLabel_4.setBounds(114, 26, 133, 33);
		}
		return lblNewLabel_4;
	}
	public JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("저장");
			btnSave.setForeground(Color.WHITE);
			btnSave.setBackground(Color.LIGHT_GRAY);
			btnSave.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// System.out.println("저장 OK!"); // tst 후 주석처리 
					
					String id=tfId.getText();
					String n=tfName.getText();
					String a=tfAddress.getText();
					String p=tfPhone.getText();
					
					MemberVo vo = new MemberVo(id,n,a,p);
					
					dao.add(vo);
					
					String str=dao.output();
					textArea.setText(str);
				}
			});
			btnSave.setBounds(87, 223, 91, 23);
		}
		return btnSave;
	}
	public JButton getBtnPrint() {
		if (btnPrint == null) {
			btnPrint = new JButton("출력");
			btnPrint.setBackground(Color.LIGHT_GRAY);
			btnPrint.setForeground(Color.WHITE);
			btnPrint.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			btnPrint.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String str=dao.output();
					textArea.setText(str);
					
				} 
			});
			btnPrint.setBounds(181, 223, 91, 23);
		}
		return btnPrint;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(24, 270, 314, 415);
			scrollPane.setColumnHeaderView(getLblNewLabel_5());
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	public JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("아이디      성명            주소                 연락처");
			lblNewLabel_5.setFont(new Font("나눔고딕", Font.PLAIN, 10));
		}
		return lblNewLabel_5;
	}
	public JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
}
