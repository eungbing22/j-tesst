package db.product;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import javax.swing.JOptionPane;

public class PartsInternalFrame extends JInternalFrame {
	//JInternalFrame 을 상속받아 PartsInternalFrame class를 만듦
	DefaultTableModel model;
	PartsDao dao;
	DefaultTableCellRenderer rRender,cRender;

	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField tfCode;
	private JButton btSearch;
	private JLabel lblNewLabel_2;
	private JTextField tfCodeName;
	private JLabel lblNewLabel_3;
	private JTextField tfSpec;
	private JLabel lblNewLabel_4;
	private JTextField tfPrice;
	private JSeparator separator;
	private JButton btnInsert;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnUndo;
	private JTextField tfFindStr;
	private JButton btnFind;
	private JScrollPane scrollPane;
	private JTable table;
	static JLabel status;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PartsInternalFrame frame = new PartsInternalFrame();
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
	
	// 생성자메서드
	public PartsInternalFrame() {
		super("제품관리", true, true, true, true);

		setBounds(20, 80, 721, 429);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setFont(new Font("나눔고딕", Font.PLAIN, 10));
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getTfCode());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getTfCodeName());
		getContentPane().add(getLblNewLabel_4());
		getContentPane().add(getLblNewLabel_3());
		getContentPane().add(getTfSpec());
		getContentPane().add(getTfPrice());
		getContentPane().add(getBtnInsert());
		getContentPane().add(getBtnUpdate());
		getContentPane().add(getBtnDelete());
		getContentPane().add(getTfFindStr());
		getContentPane().add(getBtnFind());
		getContentPane().add(getScrollPane());
		getContentPane().add(getBtSearch());
		getContentPane().add(getStatus());
		getContentPane().add(getBtnUndo());
		getContentPane().add(getSeparator());
		setVisible(true);
		
		// table
		String[] header = { "No", "제품코드", "제품명", "제품정보", "단가" };
		model = new DefaultTableModel(header, 0);
		table.setModel(model);
		
		// 정렬 설정
		rRender = new DefaultTableCellRenderer();
		cRender = new DefaultTableCellRenderer();
		
		rRender.setHorizontalAlignment(SwingConstants.RIGHT);
		cRender.setHorizontalAlignment(SwingConstants.CENTER);
				
		// 셀 너비 설정
		table.getColumn("No").setPreferredWidth(18);
		table.getColumn("제품코드").setPreferredWidth(48);
		table.getColumn("제품명").setPreferredWidth(80);
		
		// 센터 정렬
		table.getColumn("No").setCellRenderer(cRender);
		table.getColumn("제품코드").setCellRenderer(cRender);

		// 우측 정렬
		table.getColumn("단가").setCellRenderer(rRender);
		
		dao = new PartsDao();
		
	}
	
	//clear 메서드
	public void clear() {
		tfCode.setText("");
		tfCodeName.setText("");
		tfSpec.setText("");
		tfPrice.setText("");
	}
	
	// getVo 메서드
	PartsVo getVo() {
		 String code = tfCode.getText().trim();
		 String codeName = tfCodeName.getText().trim();
		 String spec = tfSpec.getText().trim();
		 int price = Integer.parseInt(tfPrice.getText().trim());

		 PartsVo vo = new PartsVo(code, codeName, spec, price);
		
		return vo;
	}
	

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("제품 관리 시스템");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setForeground(Color.DARK_GRAY);
			lblNewLabel.setFont(new Font("나눔고딕", Font.BOLD, 17));
			lblNewLabel.setBackground(Color.WHITE);
			lblNewLabel.setBounds(189, 22, 304, 41);
		}
		return lblNewLabel;
	}

	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("제품 코드");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_1.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			lblNewLabel_1.setBounds(12, 90, 50, 15);
		}
		return lblNewLabel_1;
	}

	public JTextField getTfCode() {
		if (tfCode == null) {
			tfCode = new JTextField();
			tfCode.setSelectionColor(Color.LIGHT_GRAY);
			tfCode.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			tfCode.setColumns(10);
			tfCode.setBounds(65, 90, 122, 21);
		}
		return tfCode;
	}

	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("제품명");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_2.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			lblNewLabel_2.setBounds(12, 118, 50, 15);
		}
		return lblNewLabel_2;
	}

	public JTextField getTfCodeName() {
		if (tfCodeName == null) {
			tfCodeName = new JTextField();
			tfCodeName.setEnabled(false);
			tfCodeName.setSelectionColor(Color.LIGHT_GRAY);
			tfCodeName.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			tfCodeName.setColumns(10);
			tfCodeName.setBounds(65, 118, 122, 21);
		}
		return tfCodeName;
	}

	public JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("단  가");
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_4.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			lblNewLabel_4.setBounds(12, 174, 50, 15);
		}
		return lblNewLabel_4;
	}

	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("제품 정보");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_3.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			lblNewLabel_3.setBounds(12, 146, 50, 15);
		}
		return lblNewLabel_3;
	}

	public JTextField getTfSpec() {
		if (tfSpec == null) {
			tfSpec = new JTextField();
			tfSpec.setEnabled(false);
			tfSpec.setSelectionColor(Color.LIGHT_GRAY);
			tfSpec.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			tfSpec.setColumns(10);
			tfSpec.setBounds(65, 146, 122, 21);
		}
		return tfSpec;
	}

	public JTextField getTfPrice() {
		if (tfPrice == null) {
			tfPrice = new JTextField();
			tfPrice.setEnabled(false);
			tfPrice.setSelectionColor(Color.LIGHT_GRAY);
			tfPrice.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			tfPrice.setColumns(10);
			tfPrice.setBounds(65, 174, 122, 21);
		}
		return tfPrice;
	}

	public JButton getBtnInsert() {
		if (btnInsert == null) {
			btnInsert = new JButton("저 장");
			btnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						PartsVo vo = getVo();
						boolean b = dao.insert(vo);

						if (b) {
							status.setText("데이터가 저장되었습니다.");
							btnFind.doClick();	// 데이터 저장 바로 list에 반영하여 출력
							clear();
						    tfCode.requestFocus();
						 } 
						
					}catch(Exception ex) {
					status.setText("입력 데이터에 오류가 있습니다. 데이터를 확인해주세요.");

					}
				}
			});
			btnInsert.setForeground(Color.WHITE);
			btnInsert.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			btnInsert.setBackground(Color.BLACK);
			btnInsert.setBounds(12, 239, 63, 23);
		}
		return btnInsert;
	}

	public JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("수 정");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					try {
						
						PartsVo vo = getVo();
						boolean b = dao.update(vo);

						if (b) {
							status.setText("데이터가 수정되었습니다.");
							btnFind.doClick();
							clear();
							tfCode.requestFocus(); // 데이터 수정후 커서 위치를 code로 이동
							btnInsert.setEnabled(true); // 저장버튼 활성화
						} 
						
					}catch(Exception ex) {
						status.setText("수정중 오류가 발생되었습니다. 데이터를 확인해주세요.");
					}
				}
			});
			btnUpdate.setForeground(Color.WHITE);
			btnUpdate.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			btnUpdate.setBackground(Color.BLACK);
			btnUpdate.setBounds(77, 239, 63, 23);
		}
		return btnUpdate;
	}
	
	public JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭 제");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						
						PartsVo vo = getVo();
						
						// parentComponent : PartsInternalFrame.this || getFrame()
						int answer = JOptionPane.showConfirmDialog(getParent(), "정말로 삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION );
						if(answer==JOptionPane.YES_OPTION){  //yes option에만 적용
							
							boolean b = dao.delete(vo);
							
							if (b) {
								status.setText("데이터가 삭제되었습니다.");
								btnFind.doClick();
								clear();
								tfCode.requestFocus();
								btnInsert.setEnabled(true);
							}
						} 
						
					}catch(Exception ex) {
						status.setText("삭제중 오류가 발생되었습니다. 데이터를 확인해주세요.");
						//ex.printStackTrace();
					}
				}
			});
			btnDelete.setForeground(Color.WHITE);
			btnDelete.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			btnDelete.setBackground(Color.BLACK);
			btnDelete.setBounds(143, 239, 63, 23);
		}
		return btnDelete;
	}

	public JTextField getTfFindStr() {
		if (tfFindStr == null) {
			tfFindStr = new JTextField();
			tfFindStr.setSelectionColor(Color.LIGHT_GRAY);
			tfFindStr.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			tfFindStr.setColumns(10);
			tfFindStr.setBounds(489, 91, 122, 21);
		}
		return tfFindStr;
	}

	public JButton getBtnFind() {
		if (btnFind == null) {
			btnFind = new JButton("검 색");
			btnFind.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					//검색을 눌러야만 왼쪽 tf부분 true로 세팅
					tfCodeName.setEnabled(true);
					tfSpec.setEnabled(true);
					tfPrice.setEnabled(true);
					
					String findStr = tfFindStr.getText();
					List<PartsVo> list = dao.select(findStr);
					model.setNumRows(0);

					for (int i = 0; i < list.size(); i++) {
						list.get(i).setNo(i + 1); // no값
						model.addRow(list.get(i).getVector());
					}
				}
			});
			btnFind.setForeground(Color.WHITE);
			btnFind.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			btnFind.setBackground(Color.BLACK);
			btnFind.setBounds(623, 90, 74, 23);
		}
		return btnFind;
	}

	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBackground(Color.WHITE);
			scrollPane.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			scrollPane.setBounds(286, 117, 411, 233);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}

	public JTable getTable() {
		if (table == null) {
			table = new JTable(model);

			//자동으로 정렬
			table.setAutoCreateRowSorter(true);
			
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					int row = table.getSelectedRow();
					Object o = table.getValueAt(row, 1);
					String code = (String) o;
					PartsVo vo = dao.selectOne(code);

					if (vo != null) {
						status.setText("기존의 제품 정보가 확인되었습니다. 수정 또는 삭제가 진행가능합니다.");
						btnInsert.setEnabled(false);
						
						tfCode.setText(vo.getCode());
						tfCodeName.setText(vo.getCodeName());
						tfSpec.setText(vo.getSpec());
						tfPrice.setText(vo.getPrice() + "");
					}
				}
			});
			table.setSelectionForeground(Color.WHITE);
			table.setSelectionBackground(Color.LIGHT_GRAY);
			table.setGridColor(Color.LIGHT_GRAY);
			table.setFont(new Font("나눔고딕", Font.PLAIN, 10));
		}
		return table;
	}

	public JButton getBtSearch() {
		if (btSearch == null) {
			btSearch = new JButton("조 회");
			btSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String code = tfCode.getText().trim();
						PartsVo vo = dao.selectOne(code);
						
						//조회를 눌러야만 작성할 수 있게 세팅
						tfCodeName.setEnabled(true);
						tfSpec.setEnabled(true);
						tfPrice.setEnabled(true);						

						if (code != null) {
							tfCodeName.setText(vo.getCodeName());
							tfSpec.setText(vo.getSpec());
							tfPrice.setText(vo.getPrice() + "");
							status.setText("기존의 제품 정보가 확인되었습니다. "
							              + "수정이나 삭제를 계속해주세요.");
							btnInsert.setEnabled(false); // 정보가 있으면 수정, 삭제만
							
						} else {
							//
						}
					} catch (Exception ex) {
						status.setText("제품의 정보가 없습니다. "
								+ "등록을 원하실 경우 입력 후 저장해주세요. "
								+ "수정을 원하실 경우 제품 정보를 다시 확인해주세요.");
						tfCodeName.setText("");
						tfSpec.setText("");
						tfPrice.setText("");
						btnInsert.setEnabled(true); // 정보가 없으면 저장 가능
						// ex.printStackTrace();
					}
				}
			});
			btSearch.setForeground(Color.WHITE);
			btSearch.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			btSearch.setBackground(Color.BLACK);
			btSearch.setBounds(197, 90, 74, 23);
		}
		return btSearch;
	}

	public JLabel getStatus() {
		if (status == null) {
			status = new JLabel("안녕하세요. B-SG.COM 제품 관리 프로그램을 이용해주셔서 감사합니다^^");
			status.setOpaque(true);
			status.setForeground(Color.WHITE);
			status.setBackground(new Color(102, 205, 170));
			status.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setBounds(11, 363, 686, 15);
		}
		return status;
	}
	public JButton getBtnUndo() {
		if (btnUndo == null) {
			btnUndo = new JButton("취 소");
			btnUndo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					status.setText("제품 검색이 취소되었습니다.");
					clear();	
					
					tfCodeName.setEnabled(false);
					tfSpec.setEnabled(false);
					tfPrice.setEnabled(false);	
				}
			});
			btnUndo.setForeground(Color.WHITE);
			btnUndo.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			btnUndo.setBackground(Color.BLACK);
			btnUndo.setBounds(207, 239, 63, 23);
		}
		return btnUndo;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setForeground(Color.LIGHT_GRAY);
			separator.setBounds(12, 218, 258, 2);
		}
		return separator;
	}
}
