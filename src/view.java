import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.DAO;

public class view extends JFrame implements ActionListener{

	private JTable table;
	
	private JPanel panel;
	
	private DefaultTableModel model;
	
	private JButton cancelBtn;
	
	private JScrollPane scroll;
	private DAO dao;
	public view() {
		
		dao = new DAO();
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		panel = new JPanel(new FlowLayout(FlowLayout.TRAILING, 20, 10));
		
		cancelBtn = new JButton("Back");
		cancelBtn.addActionListener(this);
		
		panel.add(cancelBtn);
		
		
		initTable();
		this.add(panel);
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void initTable() {
		
		Vector<String> titleColumn = new Vector<String>();
		titleColumn.add("Kode Menu");
		titleColumn.add("Nama Menu");
		titleColumn.add("Harga Menu");
		titleColumn.add("Stok Menu");
		
		
		model = new DefaultTableModel(dao.getMenus(), titleColumn) {
	
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		table = new JTable(model);
		
		scroll = new JScrollPane(table);
		
		this.add(scroll);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			if(e.getSource() == cancelBtn) {
				new Home();
				this.dispose();
	}
}
}