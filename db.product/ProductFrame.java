//0502

package db.product;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Dimension;

public class ProductFrame extends JFrame {

	private JDesktopPane contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JLabel status;
	private JLabel lblNewLabel;
	private JLabel status_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductFrame frame = new ProductFrame();
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
	public ProductFrame() {

		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(70, 30, 952, 757);
		setJMenuBar(getMenuBar_1());
		contentPane = new JDesktopPane();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getStatus());
		contentPane.add(getLblNewLabel());
		contentPane.add(getStatus_1());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_1_1());
	}

	public JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnNewMenu());
		}
		return menuBar;
	}

	public JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("관리");
			mnNewMenu.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			mnNewMenu.add(getMntmNewMenuItem());
			mnNewMenu.add(getMntmNewMenuItem_1());
		}
		return mnNewMenu;
	}

	public JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("제품관리");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					//
					PartsInternalFrame f = new PartsInternalFrame();
					contentPane.add(f);
					f.toFront();
				}
			});
			mntmNewMenuItem.setFont(new Font("나눔고딕", Font.PLAIN, 11));
		}
		return mntmNewMenuItem;
	}

	public JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("판매관리");
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//
					ProductInternalFrame pf = new ProductInternalFrame();
					contentPane.add(pf);
					pf.toFront();

				}
			});
			mntmNewMenuItem_1.setFont(new Font("나눔고딕", Font.PLAIN, 11));
		}
		return mntmNewMenuItem_1;
	}

	public JLabel getStatus() {
		if (status == null) {
			status = new JLabel("안녕하세요. B-SG.COM의 관리 프로그램에 방문해주신 것을 환영합니다.");
			status.setPreferredSize(new Dimension(344, 22));
			status.setOpaque(true);
			status.setBackground(Color.LIGHT_GRAY);
			status.setForeground(Color.WHITE);
			status.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setBounds(12, 10, 913, 22);
		}
		return status;
	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("B-SG.COM PRODUCT MANAGEMENT SYSTEM");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 17));
			lblNewLabel.setBounds(187, 42, 564, 40);
		}
		return lblNewLabel;
	}

	public JLabel getStatus_1() {
		if (status_1 == null) {
			status_1 = new JLabel("");
			status_1.setPreferredSize(new Dimension(344, 2));
			status_1.setOpaque(true);
			status_1.setHorizontalAlignment(SwingConstants.CENTER);
			status_1.setForeground(Color.WHITE);
			status_1.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			status_1.setBackground(Color.LIGHT_GRAY);
			status_1.setBounds(12, 651, 914, 2);
		}
		return status_1;
	}

	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Copyright. B.Corporation 2022.05 (ver 1.0.1) / HELP : 02) 1234-5678 (담당자 : 이은빈 / bbetterthana@naver.com)");
			lblNewLabel_1.setPreferredSize(new Dimension(623, 16));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			lblNewLabel_1.setBounds(95, 663, 747, 13);
		}
		return lblNewLabel_1;
	}
	public JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("업무시간 : 월~금 09:30~18:30 (점심시간 12:30~1:30) 법정공휴일 등 업무시간 외에는 이메일 문의 부탁드립니다.");
			lblNewLabel_1_1.setPreferredSize(new Dimension(621, 16));
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			lblNewLabel_1_1.setBounds(95, 676, 747, 13);
		}
		return lblNewLabel_1_1;
	}
}
