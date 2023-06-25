package bai2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

public class ProductView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_MSP;
	private JTextField textField_TSP;
	private JTextField textField_DonGia;
	private JTextField textField_NhaCungCap;
	private JComboBox comboBox;
	private ListProductModel list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					ProductView frame = new ProductView();
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
	public ProductView() {
		this.list = new ListProductModel();
		this.setTitle("Product");
		ProductController ctl = new ProductController(this);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(ProductView.class.getResource("/img/color-catalog-icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 464);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);

		JMenuItem mnItem_Open = new JMenuItem("Open");
		mnItem_Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		mnItem_Open.setIcon(new ImageIcon(ProductView.class.getResource("/img/open-file-icon.png")));
		mnNewMenu.add(mnItem_Open);

		JMenuItem mnitem_Save = new JMenuItem("Save");
		mnitem_Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		mnitem_Save.setIcon(new ImageIcon(ProductView.class.getResource("/img/Save-icon.png")));
		mnNewMenu.add(mnitem_Save);

		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);

		JMenuItem mnitem_Exit = new JMenuItem("Exit");
		mnitem_Exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		mnitem_Exit.setIcon(new ImageIcon(ProductView.class.getResource("/img/ModernXP-02-System-Power-icon.png")));
		mnNewMenu.add(mnitem_Exit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 255, 255));
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh S\u00E1ch S\u1EA3n Ph\u1EA9m", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 418, 179);
		contentPane.add(panel);
		panel.setLayout(null);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã sản phẩm", "Tên sản phẩm", "Đơn vị tính", "Đơn giá", "Nhà cung cấp" }));
		table.addMouseListener(ctl);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 22, 398, 135);
		panel.add(scrollPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(null, "Nh\u1EADp Th\u00F4ng Tin", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_1.setBackground(new Color(255, 255, 128));
		panel_1.setBounds(10, 201, 418, 131);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblMaSanPham = new JLabel("Mã sản phầm:");
		lblMaSanPham.setBounds(10, 25, 96, 14);
		panel_1.add(lblMaSanPham);

		JLabel lblTSP = new JLabel("Tên sản phẩm:");
		lblTSP.setBounds(10, 61, 96, 14);
		panel_1.add(lblTSP);

		JLabel lblNewLabel_2 = new JLabel("Đơn vị tính:");
		lblNewLabel_2.setBounds(10, 93, 96, 14);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Đơn giá:");
		lblNewLabel_3.setBounds(228, 25, 65, 14);
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Nhà cung cấp:");
		lblNewLabel_4.setBounds(228, 61, 77, 14);
		panel_1.add(lblNewLabel_4);

		textField_MSP = new JTextField();
		textField_MSP.setBounds(99, 22, 96, 20);
		panel_1.add(textField_MSP);
		textField_MSP.setColumns(10);

		textField_TSP = new JTextField();
		textField_TSP.setColumns(10);
		textField_TSP.setBounds(99, 58, 96, 20);
		panel_1.add(textField_TSP);

		textField_DonGia = new JTextField();
		textField_DonGia.setColumns(10);
		textField_DonGia.setBounds(302, 22, 96, 20);
		panel_1.add(textField_DonGia);

		textField_NhaCungCap = new JTextField();
		textField_NhaCungCap.setColumns(10);
		textField_NhaCungCap.setBounds(302, 58, 96, 20);
		panel_1.add(textField_NhaCungCap);

		String[] arr = { "Chai", "Thùng", "Kg", "Lon", "Cái" };
		comboBox = new JComboBox();
		comboBox.addItem("");
		for (String string : arr) {
			comboBox.addItem(string);
		}
		comboBox.setBounds(99, 89, 96, 22);
		panel_1.add(comboBox);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\u0110i\u1EC1u H\u01B0\u1EDBng", TitledBorder.CENTER,
				TitledBorder.TOP, null, null));
		panel_2.setBackground(Color.PINK);
		panel_2.setBounds(10, 343, 418, 58);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JButton btn_Add = new JButton("Add");
		btn_Add.addActionListener(ctl);
		btn_Add.setBounds(10, 24, 89, 23);
		panel_2.add(btn_Add);

		JButton btn_Delete = new JButton("Delete");
		btn_Delete.addActionListener(ctl);
		btn_Delete.setBounds(109, 24, 89, 23);
		panel_2.add(btn_Delete);

		JButton btn_Update = new JButton("Update");
		btn_Update.addActionListener(ctl);
		btn_Update.setBounds(220, 24, 89, 23);
		panel_2.add(btn_Update);

		JButton btn_Reset = new JButton("Reset");
		btn_Reset.addActionListener(ctl);
		btn_Reset.setBounds(319, 24, 89, 23);
		panel_2.add(btn_Reset);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void resetForm() {
		this.textField_MSP.setText("");
		this.textField_TSP.setText("");
		this.textField_DonGia.setText("");
		this.textField_NhaCungCap.setText("");
		this.comboBox.setSelectedIndex(-1);
	}

	public void addTable(ProductModel pd) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] { pd.getMaSP(), pd.getTenSP(), pd.getdVT(), pd.getDonGia(), pd.getnCungCap() });
	}

	public void getValueForm() {
		try {
			String maSp = this.textField_MSP.getText();
			String tenSP = this.textField_TSP.getText();
			String dVT = this.comboBox.getSelectedItem().toString();
			double donGia = Double.valueOf(this.textField_DonGia.getText());
			String nCungCap = this.textField_NhaCungCap.getText();
			ProductModel pd = new ProductModel(maSp, tenSP, dVT, donGia, nCungCap);
			this.addOrUpdate(pd);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void addOrUpdate(ProductModel pd) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if (!this.list.checkContainer(pd)) {
			this.list.insert(pd);
			this.addTable(pd);
			int rowCount = model_table.getRowCount();
			System.out.println(rowCount);
			table.setRowSelectionInterval(rowCount - 1, rowCount - 1);
		} else {
			int rowCount = model_table.getRowCount();
			for (int i = 0; i < rowCount; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (id.equals(pd.getMaSP())) {
					this.list.update(i, pd);
					model_table.setValueAt(pd.getMaSP(), i, 0);
					model_table.setValueAt(pd.getTenSP(), i, 1);
					model_table.setValueAt(pd.getdVT(), i, 2);
					model_table.setValueAt(pd.getDonGia(), i, 3);
					model_table.setValueAt(pd.getnCungCap(), i, 4);
					table.setRowSelectionInterval(i, i);
				}
			}
		}
	}

	public ProductModel getProductOnClick() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		String maSP = model_table.getValueAt(i_row, 0) + "";
		String tenSP = model_table.getValueAt(i_row, 1) + "";
		String dVT = model_table.getValueAt(i_row, 2) + "";
		double donGia = Double.valueOf(model_table.getValueAt(i_row, 3) + "");
		String nCungCap = model_table.getValueAt(i_row, 4) + "";
		ProductModel pd = new ProductModel(maSP, tenSP, dVT, donGia, nCungCap);
		return pd;
	}

	public void deleteProduct() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int select = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa Product này?", "Delete",
				JOptionPane.YES_NO_OPTION);
		if (select == JOptionPane.YES_OPTION) {
			ProductModel pd = this.getProductOnClick();
			this.list.delete(pd);
			model_table.removeRow(i_row);
			i_row--;
			if(i_row > 0) {
				table.setRowSelectionInterval(i_row, i_row);
				this.updateForm();
			}else {
				table.setRowSelectionInterval(0, 0);
				this.updateForm();
			}
		}
	}
	
	public void updateForm() {
		ProductModel pd = this.getProductOnClick();
		this.textField_MSP.setText(pd.getMaSP());
		this.textField_TSP.setText(pd.getTenSP());
		this.textField_DonGia.setText(pd.getDonGia()+"");
		this.textField_NhaCungCap.setText(pd.getnCungCap());
		this.comboBox.setSelectedItem(pd.getdVT());
	}
}
