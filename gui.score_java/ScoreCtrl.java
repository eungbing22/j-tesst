// 0420_GUI 구현

package gui.score;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ScoreCtrl extends JFrame {

	ScoreDao dao = new ScoreDao();

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField tfMid;
	private JTextField tfKor;
	private JTextField tfEng;
	private JTextField tfMat;
	private JButton btnSearch;
	private JButton btnSave;
	private JButton btnOutput;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel lblNewLabel_5;
	private JLabel status;
	private JSeparator separator;
	private JTextField tfTot;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JTextField tfAvg;
	private JButton btnModify;
	private JButton btnDelete;
	private JButton btnClear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreCtrl frame = new ScoreCtrl();
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
	public ScoreCtrl() {
		setTitle("성적 관리 프로그램(ver1.1)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 485);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getLblNewLabel_4());
		contentPane.add(getTfMid());
		contentPane.add(getTfKor());
		contentPane.add(getTfEng());
		contentPane.add(getTfMat());
		contentPane.add(getBtnSearch());
		contentPane.add(getBtnSave());
		contentPane.add(getBtnOutput());
		contentPane.add(getScrollPane_1());
		contentPane.add(getStatus());
		contentPane.add(getSeparator());
		contentPane.add(getTfTot());
		contentPane.add(getLblNewLabel_7());
		contentPane.add(getLblNewLabel_8());
		contentPane.add(getTfAvg());
		contentPane.add(getBtnModify());
		contentPane.add(getBtnDelete());
		contentPane.add(getBtnClear());
	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("성적 관리 시스템");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setForeground(Color.DARK_GRAY);
			lblNewLabel.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
			lblNewLabel.setBounds(276, 25, 199, 36);
		}
		return lblNewLabel;
	}

	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("아이디");
			lblNewLabel_1.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			lblNewLabel_1.setBounds(36, 89, 50, 15);
		}
		return lblNewLabel_1;
	}

	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("국어 성적");
			lblNewLabel_2.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			lblNewLabel_2.setBounds(36, 121, 50, 15);
		}
		return lblNewLabel_2;
	}

	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("영어 성적");
			lblNewLabel_3.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			lblNewLabel_3.setBounds(36, 152, 50, 15);
		}
		return lblNewLabel_3;
	}

	public JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("수학 성적");
			lblNewLabel_4.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			lblNewLabel_4.setBounds(36, 183, 50, 15);
		}
		return lblNewLabel_4;
	}

	public JTextField getTfMid() {
		if (tfMid == null) {
			tfMid = new JTextField();
			tfMid.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			tfMid.setBounds(98, 88, 96, 21);
			tfMid.setColumns(10);
		}
		return tfMid;
	}

	public JTextField getTfKor() {
		if (tfKor == null) {
			tfKor = new JTextField();
			tfKor.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			tfKor.setBounds(98, 118, 96, 21);
			tfKor.setColumns(10);
		}
		return tfKor;
	}

	public JTextField getTfEng() {
		if (tfEng == null) {
			tfEng = new JTextField();
			tfEng.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			tfEng.setBounds(98, 149, 96, 21);
			tfEng.setColumns(10);
		}
		return tfEng;
	}

	public JTextField getTfMat() {
		if (tfMat == null) {
			tfMat = new JTextField();
			tfMat.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			tfMat.setBounds(98, 180, 96, 21);
			tfMat.setColumns(10);
		}
		return tfMat;
	}

	public JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("조  회");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String mid = tfMid.getText().trim();
					ScoreVo vo = null;

					// 2. 검색시 데이터를 찾지 못한 경우 화면에 있는 데이터를 삭제
					tfKor.setText("");
					tfEng.setText("");
					tfMat.setText("");
					tfTot.setText("");
					tfAvg.setText("");

					if (mid.equals("")) {
						status.setText("검색할 아이디를 입력해주세요!");
						tfMid.requestFocus();

					} else {

						vo = dao.search(mid);

						if (vo == null) {
							status.setText("검색된 자료가 없습니다.");
						} else {
							// 참인 경우
							status.setText("자료가 조회되었습니다.");

							tfKor.setText(vo.kor + "");
							tfEng.setText(vo.eng + "");
							tfMat.setText(vo.mat + "");
							tfTot.setText(vo.tot + "");
							tfAvg.setText(vo.avg + "");

							btnSave.setEnabled(false); // 저장 비활성화
							btnModify.setEnabled(true);
							btnDelete.setEnabled(true);
						}
					}
				}
			});
			btnSearch.setBackground(SystemColor.textHighlightText);
			btnSearch.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			btnSearch.setBounds(206, 87, 91, 23);
		}
		return btnSearch;
	}

	public JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("저  장");
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 입력된 값들의 무결성 체크
					String mid = tfMid.getText().trim();

					int kor = 0, eng = 0, mat = 0, tot = 0;
					double avg = 0.0;
					String decimal = "";
					boolean b = false;

					try {
						kor = Integer.parseInt(tfKor.getText().trim());
						eng = Integer.parseInt(tfEng.getText().trim());
						mat = Integer.parseInt(tfMat.getText().trim());

						// 이름이 공백이 아니고, 성적이 0~100이 경우에만 저장
						if (!mid.equals("") && (kor >= 0 && kor <= 100) 
								&& (eng >= 0 && eng <= 100) && (mat >= 0 && mat <= 100)) {
						
							tot = kor + eng + mat;
							avg = tot / 3.0;

							decimal = String.format("%.1f", avg);

							tfTot.setText(tot + "");
							tfAvg.setText(decimal);

							ScoreVo vo = new ScoreVo(mid, kor, eng, mat);
							b = dao.append(vo);
							if (b) {
								status.setText("자료가 저장되었습니다."); // 정상인 경우
							} else {
								status.setText("저장 공간을 벗어났습니다.");
							}

						} else {
							status.setText("입력자료를 확인하세요.");
							tfMid.requestFocus();
						}

					} catch (NumberFormatException ex) {
						status.setText("성적이 잘못 입력되었습니다.");
						tfKor.requestFocus();
					} catch (Exception ex2) { // 또 다른 오류가 발생하면
						ex2.printStackTrace();
					}
				}
			});
			btnSave.setForeground(new Color(0, 0, 0));
			btnSave.setBackground(SystemColor.textHighlightText);
			btnSave.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			btnSave.setBounds(65, 294, 91, 23);
		}
		return btnSave;
	}

	public JButton getBtnOutput() {
		if (btnOutput == null) {
			btnOutput = new JButton("출  력");
			btnOutput.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String temp = dao.output();
					textArea.setText(temp);
					status.setText("자료가 출력되었습니다!");
				}
			});
			btnOutput.setBackground(SystemColor.textHighlightText);
			btnOutput.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			btnOutput.setBounds(168, 294, 91, 23);
		}
		return btnOutput;
	}

	public JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(309, 87, 406, 289);
			scrollPane.setViewportView(getTextArea());
			scrollPane.setColumnHeaderView(getLblNewLabel_5());
		}
		return scrollPane;
	}

	public JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}

	public JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			String str = String.format("%-20s %-10s %-10s %-10s %-10s %-10s", "아이디", "국어 성적", "영어 성적", "수학 성적", "총점",
					"평균");
			lblNewLabel_5 = new JLabel(str);
			lblNewLabel_5.setPreferredSize(new Dimension(390, 20));
			lblNewLabel_5.setForeground(SystemColor.windowBorder);
			lblNewLabel_5.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		}
		return lblNewLabel_5;
	}

	public JLabel getStatus() {
		if (status == null) {
			status = new JLabel("성적 관리 프로그램을 이용해 주셔서 감사합니다^^");
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setForeground(Color.WHITE);
			status.setOpaque(true);
			status.setBackground(Color.LIGHT_GRAY);
			status.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			status.setBounds(12, 396, 728, 21);
		}
		return status;
	}

	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBackground(Color.WHITE);
			separator.setBounds(36, 208, 259, 28);
		}
		return separator;
	}

	public JTextField getTfTot() {
		if (tfTot == null) {
			tfTot = new JTextField();
			tfTot.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			tfTot.setEditable(false);
			tfTot.setBounds(98, 225, 96, 21);
			tfTot.setColumns(10);
		}
		return tfTot;
	}

	public JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("총      점");
			lblNewLabel_7.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			lblNewLabel_7.setBounds(36, 228, 50, 15);
		}
		return lblNewLabel_7;
	}

	public JLabel getLblNewLabel_8() {
		if (lblNewLabel_8 == null) {
			lblNewLabel_8 = new JLabel("평      균");
			lblNewLabel_8.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			lblNewLabel_8.setBounds(36, 258, 50, 15);
		}
		return lblNewLabel_8;
	}

	public JTextField getTfAvg() {
		if (tfAvg == null) {
			tfAvg = new JTextField();
			tfAvg.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			tfAvg.setEditable(false);
			tfAvg.setBounds(98, 255, 96, 21);
			tfAvg.setColumns(10);
		}
		return tfAvg;
	}

	public JButton getBtnModify() {
		if (btnModify == null) {
			btnModify = new JButton("수  정");
			btnModify.setEnabled(false);
			btnModify.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String mid = tfMid.getText().trim();

					int kor = 0, eng = 0, mat = 0, tot = 0;
					double avg = 0.0;
					ScoreVo vo = null;
					boolean b = false;


					try { // 예외처리
						kor = Integer.parseInt(tfKor.getText()); 
						eng = Integer.parseInt(tfEng.getText());
						mat = Integer.parseInt(tfMat.getText());

						tot = kor + eng + mat;
						avg = tot / 3.0;

						tfTot.setText(tot + "");
						tfAvg.setText(String.format("%.1f", avg));
						btnOutput.doClick();

						vo = new ScoreVo(mid, kor, eng, mat);

						b = dao.modify(vo);

						if (b) {
							status.setText("자료가 수정되었습니다!");
						} else {
							status.setText("자료 수정중 오류가 발생했습니다!");
						}

					} catch (Exception ex) {
						status.setText("수정한 데이터를 확인하세요!");

					}

				}
			});
			btnModify.setForeground(Color.BLACK);
			btnModify.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			btnModify.setBackground(Color.WHITE);
			btnModify.setBounds(65, 327, 91, 23);
		}
		return btnModify;
	}

	public JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭  제");
			btnDelete.setEnabled(false);
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String mId = tfMid.getText().trim();

					boolean b = dao.delete(mId);
					if (b) {
						status.setText("자료가 삭제되었습니다.");
						tfKor.setText("");
						tfEng.setText("");
						tfMat.setText("");
						tfTot.setText("");
						tfAvg.setText("");
					} else {
						status.setText("자료 삭제 중 오류가 발생되었습니다.");
					}

				}
			});
			btnDelete.setForeground(Color.BLACK);
			btnDelete.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			btnDelete.setBackground(Color.WHITE);
			btnDelete.setBounds(168, 327, 91, 23);
		}
		return btnDelete;
	}

	public JButton getBtnClear() {
		if (btnClear == null) {
			btnClear = new JButton("검색취소");
			btnClear.setEnabled(false);
			btnClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					status.setText("검색이 취소되었습니다.");

					btnSave.setEnabled(true);
					btnModify.setEnabled(false);
					btnDelete.setEnabled(false);

					tfMid.setText("");
					tfKor.setText("");
					tfEng.setText("");
					tfMat.setText("");
					tfTot.setText("");
					tfAvg.setText("");

				}
			});
			btnClear.setForeground(Color.BLACK);
			btnClear.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			btnClear.setBackground(Color.WHITE);
			btnClear.setBounds(65, 360, 91, 23);
		}
		return btnClear;
	}
}
