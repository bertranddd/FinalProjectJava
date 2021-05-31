import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.DAO;

public class delete extends JFrame implements ActionListener, MouseListener {
	private JTable table;

	private JScrollPane scroll;

	private DefaultTableModel model;

	private Vector<String> titleColumn;

	private JPanel panel1,panel2;

	private JTextField NamaMenuText;

	private JButton cancelBtn, deleteBtn;

	private DAO dao;

	public delete() {
		dao = new DAO();
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

		initTable();

		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

		panel1 = createPanel();
		panel2 = createPanel();

		NamaMenuText = new JTextField(20);

		panel1.add(new JLabel("Nama Menu"));
		panel1.add(NamaMenuText);

		cancelBtn = new JButton("Back");
		deleteBtn = new JButton("Delete");

		cancelBtn.addActionListener(this);
		deleteBtn.addActionListener(this);

		panel2.add(Box.createHorizontalStrut(250));
		panel2.add(deleteBtn);
		panel2.add(cancelBtn);
		
		this.add(panel1);
		this.add(panel2);

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
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(model);
		
		table.addMouseListener(this);
		
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
		} else if (e.getSource() == deleteBtn) {
			String NamaMenu = periksaNamaMenu();

			if (NamaMenu == null) {
				JOptionPane.showMessageDialog(null, "Error !! \nNama Menu must be fill!");
			} else {

				dao.delete(NamaMenu);

				JOptionPane.showMessageDialog(null, "Success to delete " + NamaMenu + " !");

				NamaMenuText.setText("");

				model.setDataVector(dao.getMenus(), titleColumn);
			}
		}
	}

	public String periksaNamaMenu() {
		boolean valid = true;
		String NamaMenu = NamaMenuText.getText();
		if (NamaMenu.trim().isEmpty()) {
			valid = false;
		}

		if (!valid) {
			return null;
		}

		return NamaMenu;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}