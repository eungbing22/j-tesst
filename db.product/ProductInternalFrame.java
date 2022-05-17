package db.product;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductInternalFrame extends JInternalFrame {

	DefaultTableModel model;
	ProductDao dao;
	DefaultTableCellRenderer rRender,cRender;
	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField tfSno;
	private JLabel lblNewLabel_2;
	private JTextField tfCode;
	private JButton btnSearch;
	private JLabel lblNewLabel_3;
	private JTextField tfSpec;
	private JLabel lblNewLabel_4;
	private JTextField tfCodeName;
	private JLabel lblNewLabel_5;
	private JTextField tfNal;
	private JLabel lblNewLabel_6;
	private JTextField tfEa;
	private JLabel lblNewLabel_7;
	private JTextField tfPrice;
	private JSeparator separator;
	private JTextField tfAmt;
	private JLabel lblNewLabel_8;
	private JButton btnInsert;
	private JButton btnModify;
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
					ProductInternalFrame frame = new ProductInternalFrame();
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
	public ProductInternalFrame() {
		super("판매관리",true,true,true,true);
		
		setBounds(50, 90, 884, 532);
		setBackground(Color.WHITE);
		getContentPane().setFont(new Font("나눔고딕", Font.PLAIN, 10));
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getTfSno());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getTfCode());
		getContentPane().add(getLblNewLabel_5());
		getContentPane().add(getLblNewLabel_3());
		getContentPane().add(getTfCodeName());
		getContentPane().add(getTfNal());
		getContentPane().add(getBtnInsert());
		getContentPane().add(getTfFindStr());
		getContentPane().add(getBtnFind());
		getContentPane().add(getScrollPane());
		getContentPane().add(getBtnModify());
		getContentPane().add(getBtnDelete());
		getContentPane().add(getBtnUndo());
		getContentPane().add(getBtnSearch());
		getContentPane().add(getLblNewLabel_7());
		getContentPane().add(getLblNewLabel_6());
		getContentPane().add(getTfEa());
		getContentPane().add(getTfPrice());
		getContentPane().add(getSeparator());
		getContentPane().add(getTfAmt());
		getContentPane().add(getLblNewLabel_8());
		getContentPane().add(getTfSpec());
		getContentPane().add(getLblNewLabel_4());
		getContentPane().add(getStatus());
		setVisible(true);

		// table
		String[] header = {"순번", "제품코드", "제품명", "제품정보", "판매일자", "수량", "단가", "금액"};
		model = new DefaultTableModel(header, 0);
		table.setModel(model);
		
		// 정렬 설정
		rRender = new DefaultTableCellRenderer();
		cRender = new DefaultTableCellRenderer();
		
		rRender.setHorizontalAlignment(JLabel.RIGHT);
		cRender.setHorizontalAlignment(JLabel.CENTER);

		// 셀 너비 설정
		table.getColumn("순번").setPreferredWidth(30);
		table.getColumn("제품코드").setPreferredWidth(53);
		table.getColumn("제품명").setPreferredWidth(92);    
		table.getColumn("제품정보").setPreferredWidth(60);
		table.getColumn("판매일자").setPreferredWidth(53);
		table.getColumn("수량").setPreferredWidth(28);      
		table.getColumn("단가").setPreferredWidth(70);
		table.getColumn("금액").setPreferredWidth(75);

		// 센터 정렬
		table.getColumn("순번").setCellRenderer(cRender);
		table.getColumn("제품코드").setCellRenderer(cRender);
		table.getColumn("판매일자").setCellRenderer(cRender);

		// 우측 정렬
		table.getColumn("수량").setCellRenderer(rRender);
		table.getColumn("단가").setCellRenderer(rRender);
		table.getColumn("금액").setCellRenderer(rRender);

		// 날짜 설정
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String nalTemp = sdf.format(new Date());	
		tfNal.setText(nalTemp);
	
		dao = new ProductDao();
		initData();
	}	
	
	//initData 메서드
	public void initData() {
		int no = dao.getSno()+1; //max(sno) 가장 마지막에 사용된 sno에 +1
		tfSno.setText(no+"");
	}
	
	//clear 메서드
	public void clear() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String nalTemp = sdf.format(new Date());
		
		tfSno.setText(dao.getSno()+1+"");
		tfCode.setText("");
		tfCodeName.setText("");
		tfSpec.setText("");
		tfNal.setText(nalTemp);
		tfEa.setText("");
		tfPrice.setText("");
		tfAmt.setText("");
	}

	// tfAmt에서 ea*price를 자동계산하여 
	// 저장버튼을 누르지 않아도 바로 값을 보이게 하는 computeAmt 메서드
	public void computeAmt() {
		String tempEa = tfEa.getText().trim();
		String tempPrice = tfPrice.getText().trim();
		
		try {
			int ea = Integer.parseInt(tempEa);
			int price = Integer.parseInt(tempPrice);
			int amt = ea*price;
			
			tfAmt.setText(amt+"");	
			
		}catch(NumberFormatException ex) {
			status.setText("수량이나 금액을 확인해주세요.");
			tfAmt.setText("");
		}
	}
	
	// getVo 메서드
	ProductVo getVo() {
		int sno = Integer.parseInt(tfSno.getText().trim());
		String code = tfCode.getText().trim();
		String codeName = tfCodeName.getText().trim();
		String spec = tfSpec.getText().trim();
		String nal = tfNal.getText().trim();
		int ea = Integer.parseInt(tfEa.getText().trim());
		int price = Integer.parseInt(tfPrice.getText().trim());
	
		ProductVo vo = new ProductVo(sno, code, codeName, spec, nal, ea, price);
	
		return vo;
	}
	
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("판매 관리 시스템");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setForeground(Color.DARK_GRAY);
			lblNewLabel.setFont(new Font("나눔고딕", Font.BOLD, 17));
			lblNewLabel.setBackground(Color.WHITE);
			lblNewLabel.setBounds(284, 20, 304, 41);
		}
		return lblNewLabel;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("순 번");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_1.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			lblNewLabel_1.setBounds(21, 85, 50, 15);
		}
		return lblNewLabel_1;
	}
	public JTextField getTfSno() {
		if (tfSno == null) {
			tfSno = new JTextField();
			tfSno.setEditable(false);
			tfSno.setSelectionColor(Color.LIGHT_GRAY);
			tfSno.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			tfSno.setColumns(10);
			tfSno.setBounds(83, 82, 122, 21);
		}
		return tfSno;
	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("제품 코드");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_2.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			lblNewLabel_2.setBounds(21, 113, 50, 15);
		}
		return lblNewLabel_2;
	}
	public JTextField getTfCode() {
		if (tfCode == null) {
			tfCode = new JTextField();
			tfCode.setDisabledTextColor(Color.GRAY);
			tfCode.setSelectionColor(Color.LIGHT_GRAY);
			tfCode.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			tfCode.setColumns(10);
			tfCode.setBounds(83, 110, 122, 21);
		}
		return tfCode;
	}
	public JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("판매일자");
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_5.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			lblNewLabel_5.setBounds(21, 197, 50, 15);
		}
		return lblNewLabel_5;
	}
	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("제품명");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_3.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			lblNewLabel_3.setBounds(21, 141, 50, 15);
		}
		return lblNewLabel_3;
	}
	public JTextField getTfCodeName() {
		if (tfCodeName == null) {
			tfCodeName = new JTextField();
			tfCodeName.setDisabledTextColor(Color.DARK_GRAY);
			tfCodeName.setBackground(Color.WHITE);
			tfCodeName.setSelectedTextColor(Color.LIGHT_GRAY);
			tfCodeName.setEnabled(false);
			tfCodeName.setSelectionColor(Color.LIGHT_GRAY);
			tfCodeName.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			tfCodeName.setColumns(10);
			tfCodeName.setBounds(83, 138, 122, 21);
		}
		return tfCodeName;
	}
	public JTextField getTfNal() {
		if (tfNal == null) {
			tfNal = new JTextField();
			tfNal.setDisabledTextColor(Color.GRAY);
			tfNal.setSelectionColor(Color.LIGHT_GRAY);
			tfNal.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			tfNal.setColumns(10);
			tfNal.setBounds(83, 194, 122, 21);
		}
		return tfNal;
	}
	public JButton getBtnInsert() {
		if (btnInsert == null) {
			btnInsert = new JButton("저 장");
			btnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						ProductVo vo = getVo();
						boolean b = dao.insert(vo);
						if(b) {
							status.setText("판매 정보가 저장되었습니다.");
							btnFind.doClick();
							clear();
							tfCode.requestFocus();
						}else {
							status.setText("저장중 오류가 발생했습니다.");
						}
					}catch(Exception ex) {
						status.setText("저장중 오류가 발생했습니다. 데이터를 확인해주세요.");
					}
				}
			});
			btnInsert.setForeground(Color.WHITE);
			btnInsert.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			btnInsert.setBackground(Color.BLACK);
			btnInsert.setBounds(21, 330, 65, 23);
		}
		return btnInsert;
	}
	public JTextField getTfFindStr() {
		if (tfFindStr == null) {
			tfFindStr = new JTextField();
			tfFindStr.setSelectionColor(Color.LIGHT_GRAY);
			tfFindStr.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			tfFindStr.setColumns(10);
			tfFindStr.setBounds(652, 78, 122, 21);
		}
		return tfFindStr;
	}
	public JButton getBtnFind() {
		if (btnFind == null) {
			btnFind = new JButton("검 색");
			btnFind.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String findStr = tfFindStr.getText();
					List<ProductVo> list = dao.select(findStr);
					model.setNumRows(0);
					for(ProductVo v : list) {
						model.addRow(v.getVector());
					}
				}
			});
			btnFind.setForeground(Color.WHITE);
			btnFind.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			btnFind.setBackground(Color.BLACK);
			btnFind.setBounds(786, 77, 74, 23);
		}
		return btnFind;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			scrollPane.setBounds(301, 106, 559, 362);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	public JButton getBtnModify() {
		if (btnModify == null) {
			btnModify = new JButton("수 정");
			btnModify.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						ProductVo vo = getVo();
						boolean b = dao.update(vo);
						if(b) {
							status.setText("판매 정보가 수정되었습니다.");
							btnFind.doClick();
							clear();
							tfCode.requestFocus();
						}else {
							status.setText("수정중 오류가 발생하였습니다.");
						}
					}catch(Exception ex) {
						status.setText("수정중 오류가 발생했습니다. 데이터를 확인해주세요.");
					}
				}
			});
			btnModify.setForeground(Color.WHITE);
			btnModify.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			btnModify.setBackground(Color.BLACK);
			btnModify.setBounds(89, 330, 65, 23);
		}
		return btnModify;
	}
	public JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭 제");
			btnDelete.setEnabled(false);
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {	
					try {
						int sno = Integer.parseInt(tfSno.getText().trim());
						//JOptionPane을 활용한 dialog
						int answer = JOptionPane.showConfirmDialog(null, "정말로 삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION );
						if(answer==JOptionPane.YES_OPTION){  //yes option에만 적용
							boolean b = dao.delete(sno);
							if(b) {
								status.setText("판매 정보가 삭제되었습니다.");
								btnFind.doClick(); // 결과 바로 list에 출력
								clear(); // 초기화
								tfCode.requestFocus();
							}else {
								status.setText("삭제중 오류가 발생했습니다.");
							}
						}
						
					}catch(Exception ex) {
						status.setText("삭제중 오류가 발생했습니다. 데이터를 확인해주세요.");
					}
				}
			});
			btnDelete.setForeground(Color.WHITE);
			btnDelete.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			btnDelete.setBackground(Color.BLACK);
			btnDelete.setBounds(156, 330, 65, 23);
		}
		return btnDelete;
	}
	public JButton getBtnUndo() {
		if (btnUndo == null) {
			btnUndo = new JButton("취 소");
			btnUndo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clear(); // 초기화
					tfCode.requestFocus();
					status.setText("검색이 초기화 되었습니다.");
					btnInsert.setEnabled(true);
				}
			});
			btnUndo.setForeground(Color.WHITE);
			btnUndo.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			btnUndo.setBackground(Color.BLACK);
			btnUndo.setBounds(224, 330, 65, 23);
		}
		return btnUndo;
	}
	public JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("조 회");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String code = tfCode.getText().trim();
						ProductVo vo = dao.selectOne(code);
					
						if(code != null) {
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							String nal = sdf.format(new Date());	
							
							tfCodeName.setText(vo.getCodeName());
							tfSpec.setText(vo.getSpec());
							tfPrice.setText(vo.getPrice()+"");
							status.setText( code + " 에 대한 정보가 확인되었습니다. 입력을 계속해주세요.");
							tfEa.setText("");
							tfEa.requestFocus();
							
							btnInsert.setEnabled(true);
							btnDelete.setEnabled(true);
						}
					}catch(Exception ex) {
						clear();						
						status.setText("제품 정보가 없습니다. 정보를 확인해주세요.");	
					}
				}
			});
			btnSearch.setForeground(Color.WHITE);
			btnSearch.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			btnSearch.setBackground(Color.BLACK);
			btnSearch.setBounds(217, 109, 65, 23);
		}
		return btnSearch;
	}
	public JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("단 가");
			lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_7.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			lblNewLabel_7.setBounds(21, 253, 50, 15);
		}
		return lblNewLabel_7;
	}
	public JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("수 량");
			lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_6.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			lblNewLabel_6.setBounds(21, 225, 50, 15);
		}
		return lblNewLabel_6;
	}
	public JTextField getTfEa() {
		if (tfEa == null) {
			tfEa = new JTextField();
			tfEa.setDisabledTextColor(Color.GRAY);
			tfEa.setBackground(Color.WHITE);
			tfEa.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					computeAmt();
				}
			});
			tfEa.setSelectionColor(Color.LIGHT_GRAY);
			tfEa.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			tfEa.setColumns(10);
			tfEa.setBounds(83, 222, 122, 21);
		}
		return tfEa;
	}
	public JTextField getTfPrice() {
		if (tfPrice == null) {
			tfPrice = new JTextField();
			tfPrice.setBackground(Color.WHITE);
			tfPrice.setDisabledTextColor(Color.DARK_GRAY);
			tfPrice.setEnabled(false);
			tfPrice.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					computeAmt();
				}
			});
			tfPrice.setSelectionColor(Color.LIGHT_GRAY);
			tfPrice.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			tfPrice.setColumns(10);
			tfPrice.setBounds(83, 250, 122, 21);
		}
		return tfPrice;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(21, 280, 257, 2);
		}
		return separator;
	}
	public JTextField getTfAmt() {
		if (tfAmt == null) {
			tfAmt = new JTextField();
			tfAmt.setEditable(false);
			tfAmt.setSelectionColor(Color.LIGHT_GRAY);
			tfAmt.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			tfAmt.setColumns(10);
			tfAmt.setBounds(83, 288, 122, 21);
		}
		return tfAmt;
	}
	public JLabel getLblNewLabel_8() {
		if (lblNewLabel_8 == null) {
			lblNewLabel_8 = new JLabel("금 액");
			lblNewLabel_8.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_8.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			lblNewLabel_8.setBounds(21, 291, 50, 15);
		}
		return lblNewLabel_8;
	}
	
	public JTable getTable() {
		if (table == null) {		
			table = new JTable(model);
		           
			// 자동으로 정렬
			table.setAutoCreateRowSorter(true);
			
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int row = table.getSelectedRow();
					Object o = table.getValueAt(row, 0);
					int sno = Integer.parseInt((String)o);
					ProductVo vo = dao.selectOne(sno);
					
					if(vo!= null) {
						status.setText("기존의 판매 정보가 확인되었습니다. 수정 또는 삭제 진행이 가능합니다.");
						tfSno.setText(vo.getSno()+"");
						tfCode.setText(vo.getCode());
						tfCodeName.setText(vo.getCodeName());
						tfSpec.setText(vo.getSpec());
						tfNal.setText(vo.getNal());
						tfEa.setText(vo.getEa()+"");
						tfPrice.setText(vo.getPrice()+"");
						tfAmt.setText(vo.getAmt()+"");
						tfEa.requestFocus();
						
						btnInsert.setEnabled(false);
						btnDelete.setEnabled(true);
					}
				}
			});
			table.setFont(new Font("나눔고딕", Font.PLAIN, 10));
		}
		return table;
	}
	public JLabel getStatus() {
		if (status == null) {
			status = new JLabel("안녕하세요 B닷컴 판매 관리 프로그램을 이용해주셔서 감사합니다^^");
			status.setOpaque(true);
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setForeground(Color.WHITE);
			status.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			status.setBackground(new Color(102, 205, 170));
			status.setBounds(12, 478, 848, 15);
		}
		return status;
	}
	public JTextField getTfSpec() {
		if (tfSpec == null) {
			tfSpec = new JTextField();
			tfSpec.setEnabled(false);
			tfSpec.setBackground(Color.WHITE);
			tfSpec.setDisabledTextColor(Color.DARK_GRAY);
			tfSpec.setSelectionColor(Color.LIGHT_GRAY);
			tfSpec.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			tfSpec.setColumns(10);
			tfSpec.setBounds(83, 166, 122, 21);
		}
		return tfSpec;
	}
	public JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("제품 정보");
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_4.setFont(new Font("나눔고딕", Font.PLAIN, 11));
			lblNewLabel_4.setBounds(21, 169, 50, 15);
		}
		return lblNewLabel_4;
	}
}
