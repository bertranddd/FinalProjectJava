
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.DAO;

public class update extends JFrame implements ActionListener {

	private JTable table;

	private JScrollPane scroll;

	private DAO dao;

	private JPanel panel1, panel2, panel3, panel4;

	private DefaultTableModel model;

	private JTextField nameText, HargaText, StockText;

	private JButton cancelBtn, updateBtn;
	
	private Vector<String> titleColumn;
	
	public update() {
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

		initTable();

		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

		panel1 = createPanel();
		panel2 = createPanel();
		panel3 = createPanel();
		panel4 = createPanel();

		nameText = new JTextField(20);

		panel1.add(new JLabel("Nama menu"));
		panel1.add(nameText);

		HargaText = new JTextField(20);
		panel2.add(new JLabel("Harga Menu"));
		panel2.add(HargaText);

		StockText = new JTextField(20);
		panel3.add(new JLabel("Stock Menu"));
		panel3.add(StockText);

		cancelBtn = new JButton("Back");
		updateBtn = new JButton("Update");
		cancelBtn.addActionListener(this);
		updateBtn.addActionListener(this);

		panel4.add(cancelBtn);
		panel4.add(updateBtn);

		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		this.add(panel4);

		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	private void initTable() {

		titleColumn = new Vector<String>();
		titleColumn.add("Kode Menu");
		titleColumn.add("Nama Menu");
		titleColumn.add("Harga Menu");
		titleColumn.add("Stok Menu");

		model = new DefaultTableModel(dao.getMenus(), titleColumn) {
	 static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(model);
		
		scroll = new JScrollPane(table);

		this.add(scroll);

	}

	private JPanel createPanel() {
		return new JPanel(new FlowLayout(FlowLayout.LEADING, 20, 10));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancelBtn) {
			new Home();
			this.dispose();
		} else if (e.getSource() == updateBtn){
			
		}
	}
}
