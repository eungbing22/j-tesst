// 0428_2
// 오후 1시반부터 여러개 혼합중

// DBConn
// StudentInterface, StudentDao, StudentVo, StudentInput, StudentModify, StudentDelete;
// ScoreInterface, ScoreDao, ScoreVo, ScoreInput, ScoreModify, ScoreDelete;
 
package db;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;

public class ScoreFrame extends JFrame {

	private JPanel my;

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenuItem mntmNewMenuItem_6;

	static JLabel status;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreFrame frame = new ScoreFrame();
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
	public ScoreFrame() {
		setBackground(Color.WHITE);
		setTitle("성적관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 426);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getStatus(), BorderLayout.SOUTH);
	}

	public JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setForeground(Color.WHITE);
			menuBar.setFont(new Font("나눔고딕", Font.PLAIN, 14));
			menuBar.setBackground(new Color(173, 216, 230));
			menuBar.add(getMnNewMenu());
			menuBar.add(getMnNewMenu_2());
		}
		return menuBar;
	}

	public JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("학생관리");
			mnNewMenu.setBackground(Color.LIGHT_GRAY);
			mnNewMenu.setForeground(Color.DARK_GRAY);
			mnNewMenu.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			mnNewMenu.add(getMntmNewMenuItem());
			mnNewMenu.add(getMntmNewMenuItem_1());
			mnNewMenu.add(getMntmNewMenuItem_6());
		}
		return mnNewMenu;
	}

	public JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("추가");
			mntmNewMenuItem.setForeground(Color.DARK_GRAY);
			mntmNewMenuItem.setBackground(Color.LIGHT_GRAY);
			mntmNewMenuItem.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//
					if (my != null) { // not null이면
						contentPane.remove(my);
						// my를 지워줘
					}
					my = new StudentInput();
					// 새로 만들어서 생성해서 넣고 그걸 my라고 하자
					contentPane.add(my);
					// 부모 타입의 거기다가 넣어줘? => 다형성
					contentPane.updateUI();
					// 바뀐 UI를 바로 적용해줘!

				}
			});
		}
		return mntmNewMenuItem;
	}

	public JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("수정|삭제");
			mntmNewMenuItem_1.setForeground(Color.DARK_GRAY);
			mntmNewMenuItem_1.setBackground(Color.LIGHT_GRAY);
			mntmNewMenuItem_1.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					//
					if (my != null) {
						contentPane.remove(my);
					}
					my = new StudentModify();
					contentPane.add(my);
					contentPane.updateUI();

				}
			});
		}
		return mntmNewMenuItem_1;
	}

	public JMenuItem getMntmNewMenuItem_6() {
		if (mntmNewMenuItem_6 == null) {
			mntmNewMenuItem_6 = new JMenuItem("조회");
			mntmNewMenuItem_6.setForeground(Color.DARK_GRAY);
			mntmNewMenuItem_6.setBackground(Color.LIGHT_GRAY);
			mntmNewMenuItem_6.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			mntmNewMenuItem_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					//
					if (my != null) {
						contentPane.remove(my);
					}
					my = new StudentSearch();
					contentPane.add(my);
					contentPane.updateUI();

				}
			});
		}
		return mntmNewMenuItem_6;
	}

	public JMenu getMnNewMenu_2() {
		if (mnNewMenu_2 == null) {
			mnNewMenu_2 = new JMenu("성적관리");
			mnNewMenu_2.setForeground(Color.DARK_GRAY);
			mnNewMenu_2.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			mnNewMenu_2.setBackground(Color.LIGHT_GRAY);
			mnNewMenu_2.add(getMntmNewMenuItem_3());
			mnNewMenu_2.add(getMntmNewMenuItem_4());
			mnNewMenu_2.add(getMntmNewMenuItem_5());
		}
		return mnNewMenu_2;
	}

	public JMenuItem getMntmNewMenuItem_3() {
		if (mntmNewMenuItem_3 == null) {
			mntmNewMenuItem_3 = new JMenuItem("추가");
			mntmNewMenuItem_3.setForeground(Color.DARK_GRAY);
			mntmNewMenuItem_3.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			mntmNewMenuItem_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (my != null) {
						contentPane.remove(my);
					}

					my = new ScoreInput();

					contentPane.add(my);
					contentPane.updateUI();

				}
			});
		}
		return mntmNewMenuItem_3;
	}

	public JMenuItem getMntmNewMenuItem_4() {
		if (mntmNewMenuItem_4 == null) {
			mntmNewMenuItem_4 = new JMenuItem("수정|삭제");
			mntmNewMenuItem_4.setForeground(Color.DARK_GRAY);
			mntmNewMenuItem_4.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			mntmNewMenuItem_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					//
					if (my != null) {
						contentPane.remove(my);
					}
					my = new ScoreModify();
					contentPane.add(my);
					contentPane.updateUI();

				}
			});
		}
		return mntmNewMenuItem_4;
	}

	public JMenuItem getMntmNewMenuItem_5() {
		if (mntmNewMenuItem_5 == null) {
			mntmNewMenuItem_5 = new JMenuItem("조회");
			mntmNewMenuItem_5.setForeground(Color.DARK_GRAY);
			mntmNewMenuItem_5.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			mntmNewMenuItem_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (my != null) {
						contentPane.remove(my);
					}
					my = new ScoreSearch();
					contentPane.add(my);
					contentPane.updateUI();

				}
			});
		}
		return mntmNewMenuItem_5;
	}

	public JLabel getStatus() {
		if (status == null) {
			status = new JLabel("오늘도 활기찬 하루 보내세요^-^!!");
			status.setForeground(Color.WHITE);
			status.setBackground(new Color(173, 216, 230));
			status.setOpaque(true);
			status.setPreferredSize(new Dimension(182, 18));
			status.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			status.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return status;
	}

}
