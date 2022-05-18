// 0422~0425

package gui.product;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductFrame extends JFrame {

	DefaultTableModel model;
	ProductDao dao;

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_sno;
	private JTextField tfSno;
	private JLabel lblNewLabel_code;
	private JTextField tfCode;
	private JLabel lblNewLabel_codeName;
	private JTextField tfCodeName;
	private JLabel lblNewLabel_nal;
	private JTextField tfNal;
	private JLabel lblNewLabel_ea;
	private JTextField tfEa;
	private JLabel lblNewLabel_price;
	private JTextField tfPrice;
	private JLabel lblNewLabel_amt;
	private JTextField tfAmt;
	private JButton btnSearch;
	private JButton btnSave;
	private JButton btnDelete;
	private JButton btnModify;
	private JButton btnClear;
	private JSeparator separator;
	private JScrollPane scrollPane;
	private JTextField tfFindStr;
	private JButton btnFind;
	private JLabel status;
	private JTable table;

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

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 846, 504);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_sno());
		contentPane.add(getTfSno());
		contentPane.add(getLblNewLabel_code());
		contentPane.add(getTfCode());
		contentPane.add(getLblNewLabel_codeName());
		contentPane.add(getTfCodeName());
		contentPane.add(getLblNewLabel_nal());
		contentPane.add(getTfNal());
		contentPane.add(getLblNewLabel_ea());
		contentPane.add(getTfEa());
		contentPane.add(getLblNewLabel_price());
		contentPane.add(getTfPrice());
		contentPane.add(getLblNewLabel_amt());
		contentPane.add(getTfAmt());
		contentPane.add(getBtnSearch());
		contentPane.add(getBtnNewButton_1_1());
		contentPane.add(getBtnNewButton_1_1_1());
		contentPane.add(getBtnModify());
		contentPane.add(getBtnClear());
		contentPane.add(getSeparator());
		contentPane.add(getScrollPane());
		contentPane.add(getTfFindStr());
		contentPane.add(getBtnFind());
		contentPane.add(getStatus());

		initData(); // 생성자영역
	}

	public void initData() {
		
		this.dao = new ProductDao();

		Vector<ProductVo> data = dao.getData();
		for (int i = 0; i < data.size(); i++) {
			model.addRow(data.get(i).getVector());
		}
		
		tfSno.setText(dao.getSno() + "");
	}

	// 금액 계산 메서드
	public void computeAmt() {
		String tempEa = tfEa.getText().trim(); 
		String tempPrice = tfPrice.getText().trim();
		
		try {
			
			int ea = Integer.parseInt(tempEa);
			int price = Integer.parseInt(tempPrice);
			int amt = ea * price;

			tfAmt.setText(amt + "");

		} catch (NumberFormatException ex) {
			
			status.setText("수량이나 단가를 확인해 주세요.");
			tfAmt.setText("");
		}
	}
	
	//clear
	public void clear() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String nal = sdf.format(new Date());
		
		tfSno.setText(dao.getSno()+"");
		tfCode.setText("");
		tfCodeName.setText("");
		tfNal.setText("");
		tfEa.setText("");
		tfPrice.setText("");
		tfAmt.setText("");
	}
	

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("생산 관리 프로그램");
			lblNewLabel.setOpaque(true);
			lblNewLabel.setBackground(new Color(169, 169, 169));
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(38, 25, 755, 31);
		}
		return lblNewLabel;
	}

	public JLabel getLblNewLabel_sno() {
		if (lblNewLabel_sno == null) {
			lblNewLabel_sno = new JLabel("순 번");
			lblNewLabel_sno.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			lblNewLabel_sno.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_sno.setBounds(56, 120, 50, 15);
		}
		return lblNewLabel_sno;
	}

	public JTextField getTfSno() {
		if (tfSno == null) {
			tfSno = new JTextField();
			tfSno.setEditable(false);
			tfSno.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			tfSno.setColumns(10);
			tfSno.setBounds(114, 117, 96, 21);
		}
		return tfSno;
	}

	public JLabel getLblNewLabel_code() {
		if (lblNewLabel_code == null) {
			lblNewLabel_code = new JLabel("제품코드");
			lblNewLabel_code.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_code.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			lblNewLabel_code.setBounds(56, 148, 50, 15);
		}
		return lblNewLabel_code;
	}

	public JTextField getTfCode() {
		if (tfCode == null) {
			tfCode = new JTextField();
			tfCode.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			tfCode.setColumns(10);
			tfCode.setBounds(114, 145, 96, 21);
		}
		return tfCode;
	}

	public JLabel getLblNewLabel_codeName() {
		if (lblNewLabel_codeName == null) {
			lblNewLabel_codeName = new JLabel("제품명");
			lblNewLabel_codeName.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_codeName.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			lblNewLabel_codeName.setBounds(56, 176, 50, 15);
		}
		return lblNewLabel_codeName;
	}

	public JTextField getTfCodeName() {
		if (tfCodeName == null) {
			tfCodeName = new JTextField();
			tfCodeName.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			tfCodeName.setColumns(10);
			tfCodeName.setBounds(114, 173, 96, 21);
		}
		return tfCodeName;
	}

	public JLabel getLblNewLabel_nal() {
		if (lblNewLabel_nal == null) {
			lblNewLabel_nal = new JLabel("생산일자");
			lblNewLabel_nal.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_nal.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			lblNewLabel_nal.setBounds(56, 203, 50, 15);
		}
		return lblNewLabel_nal;
	}

	public JTextField getTfNal() {
		if (tfNal == null) {
			tfNal = new JTextField();
			tfNal.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			tfNal.setColumns(10);
			tfNal.setBounds(114, 200, 96, 21);

			// 오늘 날짜로 표기
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String nal = sdf.format(new Date());
			tfNal.setText(nal);

		}
		return tfNal;
	}

	public JLabel getLblNewLabel_ea() {
		if (lblNewLabel_ea == null) {
			lblNewLabel_ea = new JLabel("수 량");
			lblNewLabel_ea.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_ea.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			lblNewLabel_ea.setBounds(56, 231, 50, 15);
		}
		return lblNewLabel_ea;
	}

	public JTextField getTfEa() {
		if (tfEa == null) {
			tfEa = new JTextField();
			tfEa.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					computeAmt();	// 상단의 금액 계산 메서드를 활용
				}
			});
			tfEa.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			tfEa.setColumns(10);
			tfEa.setBounds(114, 228, 96, 21);
		}
		return tfEa;
	}

	public JLabel getLblNewLabel_price() {
		if (lblNewLabel_price == null) {
			lblNewLabel_price = new JLabel("단 가");
			lblNewLabel_price.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_price.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			lblNewLabel_price.setBounds(56, 259, 50, 15);
		}
		return lblNewLabel_price;
	}

	public JTextField getTfPrice() {
		if (tfPrice == null) {
			tfPrice = new JTextField();
			tfPrice.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
				}

			});
			tfPrice.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			tfPrice.setColumns(10);
			tfPrice.setBounds(114, 256, 96, 21);
		}
		return tfPrice;
	}

	public JLabel getLblNewLabel_amt() {
		if (lblNewLabel_amt == null) {
			lblNewLabel_amt = new JLabel("금 액");
			lblNewLabel_amt.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_amt.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			lblNewLabel_amt.setBounds(56, 311, 50, 15);
		}
		return lblNewLabel_amt;
	}

	public JTextField getTfAmt() {
		if (tfAmt == null) {
			tfAmt = new JTextField();
			tfAmt.setEditable(false);
			tfAmt.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			tfAmt.setColumns(10);
			tfAmt.setBounds(114, 308, 96, 21);
		}
		return tfAmt;
	}

	public JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("조 회");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String code = tfCode.getText();
					String codeName = dao.map.get(code);
					if (codeName == null) {
						tfCodeName.setText("");
						status.setText(code + " 에 해당하는 제품이 없습니다.");
					} else {
						tfCodeName.setText(codeName);
						status.setText("수량, 단가를 입력해 주세요."); // 해당값 존재하여 다음 상황 진행 요청
						tfEa.requestFocus(); // 커서 이동
					}

				}
			});
			btnSearch.setBackground(new Color(72, 209, 204));
			btnSearch.setForeground(new Color(255, 255, 255));
			btnSearch.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			btnSearch.setBounds(215, 144, 65, 23);
		}
		return btnSearch;
	}

	public JButton getBtnNewButton_1_1() {
		if (btnSave == null) {
			btnSave = new JButton("저 장");
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					// 예외처리
					try {

						int sno = Integer.parseInt(tfSno.getText());
						String code = tfCode.getText();
						String codeName = tfCodeName.getText();
						String nal = tfNal.getText();
						int ea = Integer.parseInt(tfEa.getText());
						int price = Integer.parseInt(tfPrice.getText());

						ProductVo vo = new ProductVo(sno, code, codeName, nal, ea, price);

						boolean b = dao.append(vo);
						
						if (b) {
							status.setText("데이터가 저장되었습니다.");
							tfSno.setText(dao.getSno() + "");
							btnFind.doClick();
						} else {
							status.setText("저장중 오류가 발생되었습니다.");
						}
					} catch (Exception ex) {
						status.setText("입력 데이터에 오류가 있습니다.");
					}

				}
			});
			btnSave.setForeground(Color.WHITE);
			btnSave.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			btnSave.setBackground(new Color(72, 209, 204));
			btnSave.setBounds(56, 351, 65, 23);
		}
		return btnSave;
	}

	public JButton getBtnNewButton_1_1_1() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭 제");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int sno = Integer.parseInt(tfSno.getText());
					ProductVo vo = new ProductVo();
					vo.setSno(sno) ;
					boolean b = dao.delete(vo); 
					
					if(b) {
						status.setText("데이터가 삭제되었습니다.");
						btnFind.doClick();
						clear();
						btnSave.setEnabled(true);
					}else {
						status.setText("삭제중 오류가 발생되었습니다.");
					}
				}
			});
			btnDelete.setForeground(Color.WHITE);
			btnDelete.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			btnDelete.setBackground(new Color(72, 209, 204));
			btnDelete.setBounds(126, 351, 65, 23);
		}
		return btnDelete;
	}

	public JButton getBtnModify() {
		if (btnModify == null) {
			btnModify = new JButton("수 정");
			btnModify.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int sno = Integer.parseInt(tfSno.getText());
					String code = tfCode.getText();
					String codeName = tfCodeName.getText();
					String nal = tfNal.getText();
					int ea = Integer.parseInt(tfEa.getText());
					int price = Integer.parseInt(tfPrice.getText());

					ProductVo vo = new ProductVo(sno, code, codeName, nal, ea, price);

					boolean b = dao.modify(vo);
					if (b) {
						status.setText("데이터가 수정되었습니다.");
						btnFind.doClick();
					} else {
						status.setText("데이터 수정중 오류가 발생되었습니다.");
					}
				}
			});
			btnModify.setForeground(Color.WHITE);
			btnModify.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			btnModify.setBackground(new Color(72, 209, 204));
			btnModify.setBounds(195, 351, 65, 23);
		}
		return btnModify;
	}

	public JButton getBtnClear() {
		if (btnClear == null) {
			btnClear = new JButton("취 소");
			btnClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					status.setText("검색이 취소되었습니다.");

					btnSave.setEnabled(true);
					btnModify.setEnabled(false);
					btnDelete.setEnabled(false);
					
					clear();
					
				}
			});
			btnClear.setForeground(Color.WHITE);
			btnClear.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			btnClear.setBackground(new Color(72, 209, 204));
			btnClear.setBounds(265, 351, 65, 23);
		}
		return btnClear;
	}

	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setForeground(new Color(192, 192, 192));
			separator.setBounds(56, 294, 269, 2);
		}
		return separator;
	}

	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(342, 132, 452, 242);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}

	public JTextField getTfFindStr() {
		if (tfFindStr == null) {
			tfFindStr = new JTextField();
			tfFindStr.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			tfFindStr.setColumns(10);
			tfFindStr.setBounds(625, 100, 96, 21);
		}
		return tfFindStr;
	}

	public JButton getBtnFind() {
		if (btnFind == null) {
			btnFind = new JButton("검 색");
			btnFind.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					model.setNumRows(0);

					Vector<ProductVo> data = dao.getData();

					String findStr = tfFindStr.getText();
					if (findStr.equals("")) {
						for (int i = 0; i < data.size(); i++) {
							model.addRow(data.get(i).getVector());
						}
						status.setText("값을 입력해주세요.");

					} else {
						for (int i = 0; i < data.size(); i++) {
							
							ProductVo temp = data.get(i);
							
							if (temp.getCode().indexOf(findStr) >= 0 ||
							temp.getCodeName().indexOf(findStr) >= 0) {
								model.addRow(temp.getVector());
							}
						}
					}

				}
			});
			btnFind.setForeground(Color.WHITE);
			btnFind.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			btnFind.setBackground(new Color(72, 209, 204));
			btnFind.setBounds(729, 99, 65, 23);
		}
		return btnFind;
	}

	public JLabel getStatus() {
		if (status == null) {
			status = new JLabel("안녕하세요. 생산관리 프로그램입니다.");
			status.setOpaque(true);
			status.setBackground(new Color(211, 211, 211));
			status.setForeground(new Color(255, 255, 255));
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			status.setBounds(38, 418, 755, 21);
		}
		return status;
	}

	public JTable getTable() {
		if (table == null) {

			String[] header = { "순번", "제품코드", "제품명", "생산일자", "수량", "단가", "금액" };

			model = new DefaultTableModel(header, 0);
			table = new JTable(model);
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

					int row = table.getSelectedRow(); // 선택한 행번호
					//int col = table.getSelectedColumn(); // tst
					//System.out.println(row + "," + col); // tst

					Object o = table.getValueAt(row, 0);

					int sno = (Integer) o;
					//System.out.println(sno);

					ProductVo vo = dao.getVo(sno);

					if (vo != null) {
						tfSno.setText(vo.getSno() + "");
						tfCode.setText(vo.getCode());
						tfCodeName.setText(vo.getCodeName());
						tfNal.setText(vo.getNal());
						tfEa.setText(vo.getEa() + "");
						tfPrice.setText(vo.getPrice() + "");
						tfAmt.setText(vo.getAmt() + "");

						btnModify.setEnabled(true);
						btnDelete.setEnabled(true);
						btnSave.setEnabled(false);
					} 
				}
			});
			table.setSelectionBackground(Color.LIGHT_GRAY);
			table.setFont(new Font("나눔고딕", Font.PLAIN, 11));

		}
		return table;
	}
}
