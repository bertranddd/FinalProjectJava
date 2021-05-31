import java.awt.FlowLayout;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import package2.MENU;



public class Form extends JPanel {
	
	private JPanel panel1, panel2, panel3, panel4;

	private JTextField namaText, hargaText, stokText;


	public Form() {

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		panel1 = createPanel();
		panel2 = createPanel();
		panel3 = createPanel();

		namaText = new JTextField(20);

		panel1.add(new JLabel("Nama Menu"));
		panel1.add(namaText);

		hargaText = new JTextField(20);
		panel2.add(new JLabel("Harga Menu"));
		panel2.add(hargaText);
		
		stokText = new JTextField(20);
		panel3.add(new JLabel("Stok Menu"));
		panel3.add(stokText);

		this.add(panel1);
		this.add(panel2);
		this.add(panel3);

	}

	public void clearForm() {

		namaText.setText("");
		hargaText.setText("");
		stokText.setText("");
	}

	public MENU getNewMenu() {
		boolean valid = true;

		String nama = namaText.getText();
		if (nama.trim().isEmpty()) {
			valid = false;
		}
		
		String harga = hargaText.getText();
		if (harga.trim().isEmpty()) {
			valid = false;
		}
		
		String stok = stokText.getText();
		if (stok.trim().isEmpty()) {
			valid = false;
		}

		if (valid) {
			return new MENU(nama, harga, stok); //kode
		} else {
			return null;
		}
	}

	private JPanel createPanel() {
		return new JPanel(new FlowLayout(FlowLayout.LEADING, 20, 10));
	}

	public JTextField getNamaText() {
		return namaText;
	}
	
	public JTextField getHargaText() {
		return hargaText;
	}
	
	public JTextField getStokText() {
		return stokText;
	}
}

