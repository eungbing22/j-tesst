// 0428~0502

package db;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class StudentSearch extends JPanel {
	
	StudentDao dao;
	DefaultTableModel smodel;
	
	private JTextField tfFindStr;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public StudentSearch() {
				
		setBackground(Color.WHITE);
		setLayout(null);
		add(getTfFindStr());
		add(getBtnSearch());
		add(getScrollPane());
		add(getLblNewLabel());
		
		dao = new StudentDao();

	}

	public JTextField getTfFindStr() {
		if (tfFindStr == null) {
			tfFindStr = new JTextField();
			tfFindStr.setBounds(131, 59, 222, 21);
			tfFindStr.setColumns(10);
		}
		return tfFindStr;
	}
	public JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("조 회");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//
					String findStr = tfFindStr.getText();
					List<StudentVo> list = dao.select(findStr);
					smodel.setNumRows(0);
					
					for(int i=0; i<list.size(); i++) {
						smodel.addRow(list.get(i).getVector());
					}
				}
			});
			btnSearch.setBackground(Color.GRAY);
			btnSearch.setForeground(Color.WHITE);
			btnSearch.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			btnSearch.setBounds(365, 58, 91, 23);
		}
		return btnSearch;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(22, 102, 538, 212);
			scrollPane.setViewportView(getTable_1());
		}
		return scrollPane;
	}
	public JTable getTable_1() {
		if (table == null) {
			//
			String[] header = {"아이디","성 명","이메일","연락처"};	
			smodel = new DefaultTableModel(header,0);
			table = new JTable(smodel);
			
			table.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			
		}
		return table;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("학생 정보 조회");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("나눔고딕", Font.PLAIN, 15));
			lblNewLabel.setBounds(191, 10, 207, 21);
		}
		return lblNewLabel;
	}
}
