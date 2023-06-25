package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import controller.MenuMouseController;
import controller.MenubarController;

public class MenuExamleView extends JFrame {
	private JLabel jLabel;
	public JPopupMenu jPopupMenu;
	private JToolBar jToolBar;

	public MenuExamleView() {
		this.setTitle("Jmenu bar");

		this.setSize(600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		JMenuBar jMenuBar = new JMenuBar();
		MenubarController menubarController = new MenubarController(this);

		JMenu jMenu_file = new JMenu("File");

		JMenu jMenu_help = new JMenu("Help");

		JMenuItem jMenuItem_open = new JMenuItem("Open", KeyEvent.VK_O);
		jMenuItem_open.addActionListener(menubarController);
		jMenuItem_open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		JMenuItem jMenuItem_exit = new JMenuItem("Exit", KeyEvent.VK_E);
		jMenuItem_exit.addActionListener(menubarController);
//		jMenuItem_exit.setMnemonic(KeyEvent.VK_P);

		jMenu_file.add(jMenuItem_open);
		jMenu_file.addSeparator();
//		jMenu_file.add(jMenu_help);
		jMenu_file.add(jMenuItem_exit);

		JMenuItem jMenuItem_wellcome = new JMenuItem("Well come");
		jMenu_help.add(jMenuItem_wellcome);
		jMenu_help.setMnemonic(KeyEvent.VK_L);

		jMenu_file.setMnemonic(KeyEvent.VK_A);
		jMenuBar.add(jMenu_file);
		jMenuBar.add(jMenu_help);

		Font font = new Font("arial", Font.ITALIC, 50);
		jLabel = new JLabel();
		jLabel.setFont(font);

		// Tạo toolbar thanh công cụ
		jToolBar = new JToolBar();
		JButton jButton_1 = new JButton("1");
		jButton_1.setToolTipText("Quay lại đi bạn êi");
		jButton_1.addActionListener(menubarController);
		JButton jButton_2 = new JButton("2");
		jButton_2.addActionListener(menubarController);
		JButton jButton_3 = new JButton("3");
		jButton_3.addActionListener(menubarController);
		JButton jButton_4 = new JButton("4");
		jButton_4.addActionListener(menubarController);
		JButton jButton_5 = new JButton("5");
		jButton_5.addActionListener(menubarController);

		jToolBar.add(jButton_1);
		jToolBar.add(jButton_2);
		jToolBar.add(jButton_3);
		jToolBar.add(jButton_4);
		jToolBar.add(jButton_5);

		JMenu jMenu_view = new JMenu("View");
		JCheckBoxMenuItem jCheckBoxMenuItem_1 = new JCheckBoxMenuItem("Toolbar");
		jCheckBoxMenuItem_1.addActionListener(menubarController);
		JCheckBoxMenuItem jCheckBoxMenuItem_2 = new JCheckBoxMenuItem("Tool");
		jMenu_view.add(jCheckBoxMenuItem_1);
		jMenu_view.add(jCheckBoxMenuItem_2);
		
		jMenuBar.add(jMenu_view);

		// Menu chuột phải
		jPopupMenu = new JPopupMenu();
		JMenu jMenu_pop_1 = new JMenu("Font");
		JMenu jMenu_pop_2 = new JMenu("Size");
		JMenuItem jMenuItem_pop_1 = new JMenuItem("1");
		JMenuItem jMenuItem_pop_2 = new JMenuItem("2");
		JMenuItem jMenuItem_pop_3 = new JMenuItem("3");
		JMenuItem jMenuItem_pop_4 = new JMenuItem("4");
		JMenuItem jMenuItem_pop_5 = new JMenuItem("Cut");
		jMenuItem_pop_5.addActionListener(menubarController);
		JMenuItem jMenuItem_pop_6 = new JMenuItem("Paste");
		jMenuItem_pop_6.addActionListener(menubarController);

		jMenu_pop_1.add(jMenuItem_pop_1);
		jMenu_pop_1.add(jMenuItem_pop_2);

		jMenu_pop_2.add(jMenuItem_pop_3);
		jMenu_pop_2.add(jMenuItem_pop_4);

		jPopupMenu.add(jMenu_pop_1);
		jPopupMenu.addSeparator();
		jPopupMenu.add(jMenu_pop_2);
		jPopupMenu.add(jMenuItem_pop_5);
		jPopupMenu.add(jMenuItem_pop_6);
		MenuMouseController menuMouseController = new MenuMouseController(this);
		this.addMouseListener(menuMouseController);
		this.add(jPopupMenu);
		this.setJMenuBar(jMenuBar);
		this.setLayout(new BorderLayout());
		this.add(jLabel, BorderLayout.CENTER);
		this.setVisible(true);
	}

	public void updateLabel(String s) {
		this.jLabel.setText(s);
	}
	
	public void  endabledToolbar() {
		this.add(jToolBar, BorderLayout.NORTH);
		this.refesh();
	}
	
	public void disableToolbar() {
		this.remove(jToolBar);
		this.refesh();
	}
	
	public void refesh() {
		// pack() đóng gói toàn bộ chương trình
		this.pack();
		this.setSize(600,600);
	}
}
