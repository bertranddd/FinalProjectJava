import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Home extends JFrame implements ActionListener {

	private JLabel label1;

	private JMenuBar menuBar;
	
	private JMenuItem insertmenubaru , viewMenu, updateMenu, deleteMenu;
	
	
	public Home() {
		initLabel();
		ImageIcon image = new ImageIcon("bobaicon.png");
		this.setIconImage(image.getImage());
		
		initMenuBar();

		this.setTitle("BobaCool");
//		this.setSize(500, 500);
		this.pack(); // supaya size nya sesuai dengan isi didalam
		this.setLocationRelativeTo(null); // supaya posisi window berada di tengah
		this.setResizable(false);
//		this.setSize(new Dimension(500, 500));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true); // munculin , biar nampak

		// default layout -> BorderLayout
	}

	private void initLabel() {
		label1 = new JLabel();

		label1.setHorizontalAlignment(JLabel.CENTER);
		label1.setVerticalAlignment(JLabel.CENTER);
		label1.setHorizontalTextPosition(JLabel.CENTER);
		label1.setVerticalTextPosition(JLabel.TOP);
		label1.setText("Admin Database");

		label1.setForeground(new Color(0, 0, 0));
		label1.setFont(new Font("Perpetua", Font.BOLD, 30));
		label1.setBackground(Color.white);
		label1.setOpaque(true);

		try {
			Image image2 = ImageIO.read(new File("bobaicon.png"));
			Image image3 = image2.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(image3);
			label1.setIcon(icon);
		} catch (IOException e) {
//			 TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.add(label1);

	}

	private void initMenuBar() {

		menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		insertmenubaru = new JMenuItem("Insert");
		viewMenu = new JMenuItem("View");
		updateMenu = new JMenuItem("Update");
		deleteMenu = new JMenuItem("Delete");
		
//		kodeMenu = new JMenuItem("Kode Menu");
//		viewItem = new JMenuItem("View Pets");
//		exitItem = new JMenuItem("Exit");
//		aboutItem = new JMenuItem("About");
		
//		exitItem.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.exit(0);
//			}
//		});
		
		insertmenubaru.addActionListener(this);
		viewMenu.addActionListener(this);
		updateMenu.addActionListener(this);
		deleteMenu.addActionListener(this);
//		JMenu test = new JMenu("Test");
//		test.add(new JMenuItem("Test1"));
//		test.add(new JMenuItem("Test2"));
		
//		menuHome.add(test);
		
//		menuHome.add(addItem);
//		menuHome.add(viewItem);
//		menuHome.add(exitItem);
//		
//		menuHelp.add(aboutItem);
		
		menuBar.add(insertmenubaru);
		menuBar.add(viewMenu);
		menuBar.add(updateMenu);
		menuBar.add(deleteMenu);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == insertmenubaru) {
			new insert();
			this.dispose();
		}else if(e.getSource() == viewMenu) {
			new view();
			this.dispose(); //biar yg di home ke close
		}else if(e.getSource() == updateMenu) {
			new update();
			this.dispose();
		}else if(e.getSource() == deleteMenu) {
			new delete();
			this.dispose(); //biar yg di home ke close
		}
		
	}
}

