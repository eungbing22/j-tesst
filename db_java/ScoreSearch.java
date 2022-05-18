// 0429~0502

package db;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import db.ScoreVo;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ScoreSearch extends JPanel {

	ScoreDao dao;
	DefaultTableModel smodel;
	
	private JLabel lblNewLabel;
	private JTextField tfFindStr;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ScoreSearch() {
		setBackground(Color.WHITE);
		setLayout(null);
		add(getLblNewLabel());
		add(getTfFindStr());
		add(getBtnSearch());
		add(getScrollPane());

		dao = new ScoreDao();
	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("성적 정보 조회");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("나눔고딕", Font.PLAIN, 15));
			lblNewLabel.setBounds(207, 21, 179, 15);
		}
		return lblNewLabel;
	}
	public JTextField getTfFindStr() {
		if (tfFindStr == null) {
			tfFindStr = new JTextField();
			tfFindStr.setFont(new Font("나눔고딕", Font.PLAIN, 12));
			tfFindStr.setColumns(10);
			tfFindStr.setBounds(133, 57, 222, 21);
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
					List<ScoreVo> list = dao.select(findStr);
					smodel.setNumRows(0);
				
					for(ScoreVo v : list) {
						smodel.addRow(v.getVector()); 
					}
				}
			});
			btnSearch.setForeground(Color.WHITE);
			btnSearch.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			btnSearch.setBackground(Color.GRAY);
			btnSearch.setBounds(367, 56, 91, 23);
		}
		return btnSearch;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setFont(new Font("나눔고딕", Font.PLAIN, 10));
			scrollPane.setBackground(Color.WHITE);
			scrollPane.setBounds(12, 88, 568, 209);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	public JTable getTable() {
		if (table == null) {
			//
			String[] header = { "순 번", "성 명", "과 목", "성 적", "응시일자" }; 
			
			smodel = new DefaultTableModel(header,0);
			table = new JTable(smodel);
			table.setBackground(Color.WHITE);
			
			table.setFont(new Font("나눔고딕", Font.PLAIN, 10));
		}
		return table;
	}
}
