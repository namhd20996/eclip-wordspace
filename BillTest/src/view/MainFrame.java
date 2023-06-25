package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.event.ActionEvent;

import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtQuantity;
	private JTextField txtPrice;
	private JTextField txtSubTotal;
	private JTextField txtTotalAmount;
	private JTextField txtCash;
	private JTextField txtBalance;

	private String billNo = "";
	private Double totalAmount = 0.0;
	private Double cash = 0.0;
	private Double balance = 0.0;
	private Double bHeight = 0.0;

	ArrayList<String> itemName = new ArrayList<>();
	ArrayList<String> quantity = new ArrayList<>();
	ArrayList<String> itemPrice = new ArrayList<>();
	ArrayList<String> subtotal = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Item name:");
		lblNewLabel.setBounds(10, 11, 73, 14);
		contentPane.add(lblNewLabel);

		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(10, 41, 46, 14);
		contentPane.add(lblQuantity);

		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(10, 76, 46, 14);
		contentPane.add(lblPrice);

		JLabel lblSubTitle = new JLabel("Sub total");
		lblSubTitle.setBounds(10, 113, 46, 14);
		contentPane.add(lblSubTitle);

		txtName = new JTextField();
		txtName.setBounds(118, 8, 317, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);

		txtQuantity = new JTextField();
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(118, 38, 317, 20);
		contentPane.add(txtQuantity);

		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(118, 73, 317, 20);
		contentPane.add(txtPrice);

		txtSubTotal = new JTextField();
		txtSubTotal.setColumns(10);
		txtSubTotal.setBounds(118, 110, 317, 20);
		contentPane.add(txtSubTotal);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getValuesForm();
			}
		});
		btnAdd.setBounds(346, 158, 89, 23);
		contentPane.add(btnAdd);

		txtTotalAmount = new JTextField();
		txtTotalAmount.setColumns(10);
		txtTotalAmount.setBounds(118, 204, 317, 20);
		contentPane.add(txtTotalAmount);

		txtCash = new JTextField();
		txtCash.setColumns(10);
		txtCash.setBounds(118, 234, 317, 20);
		contentPane.add(txtCash);

		txtBalance = new JTextField();
		txtBalance.setColumns(10);
		txtBalance.setBounds(118, 269, 317, 20);
		contentPane.add(txtBalance);

		JLabel lblBalane = new JLabel("Balance");
		lblBalane.setBounds(10, 272, 46, 14);
		contentPane.add(lblBalane);

		JLabel lblCash = new JLabel("Cash");
		lblCash.setBounds(10, 237, 46, 14);
		contentPane.add(lblCash);

		JLabel lblTotalAmount = new JLabel("Total amount");
		lblTotalAmount.setBounds(10, 207, 73, 14);
		contentPane.add(lblTotalAmount);

		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printTTT();
			}
		});
		btnPrint.setBounds(346, 327, 89, 23);
		contentPane.add(btnPrint);
	}

	public void clear() {
		txtName.setText("");
		txtQuantity.setText("");
		txtPrice.setText("");
		txtSubTotal.setText("");
	}

	public void getValuesForm() {
		itemName.add(txtName.getText());
		quantity.add(txtQuantity.getText());
		itemPrice.add(txtPrice.getText());
		subtotal.add(txtSubTotal.getText());
		totalAmount += Double.valueOf(txtSubTotal.getText());
		txtTotalAmount.setText(totalAmount + "");
		clear();

	}

	public PageFormat getPageFormat(PrinterJob pj) {
		PageFormat pf = pj.defaultPage();
		Paper paper = pf.getPaper();
		double bodyHeight = bHeight;
		double headerHeight = 5.0;
		double footerHeight = 5.0;
		double width = cm_to_pp(8);
		double height = cm_to_pp(headerHeight + bodyHeight + footerHeight);
		paper.setImageableArea(0, 10, width, height - cm_to_pp(1));

		pf.setOrientation(PageFormat.PORTRAIT);
		pf.setPaper(paper);
		return pf;

	}

	protected static double cm_to_pp(double cm) {
		return toPPI(cm * 0.393600787);
	}

	protected static double toPPI(double inch) {
		return inch * 72d;
	}

	public void printTTT() {
		bHeight = Double.valueOf(itemName.size());
		// JOptionPane.showMessageDialog(rootPane, bHeight);

		PrinterJob pj = PrinterJob.getPrinterJob();
		pj.setPrintable(new BillPrintable(), getPageFormat(pj));
		try {
			pj.print();

		} catch (PrinterException ex) {
			ex.printStackTrace();
		}
	}

	public class BillPrintable implements Printable {

		public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {

			int r = itemName.size();
			ImageIcon icon = new ImageIcon("D:\\eclipse-workspace\\BillTest\\src\\view\\BGToaNhaR.png");
			int result = NO_SUCH_PAGE;
			if (pageIndex == 0) {

				Graphics2D g2d = (Graphics2D) graphics;
				double width = pageFormat.getImageableWidth();
				g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());

				// FontMetrics metrics=g2d.getFontMetrics(new Font("Arial",Font.BOLD,7));

				try {
					int y = 20;
					int yShift = 10;
					int headerRectHeight = 15;
					// int headerRectHeighta=40;

					g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
					g2d.drawImage(icon.getImage(), 50, 20, 90, 30, rootPane);
					y += yShift + 30;
					g2d.drawString("-------------------------------------", 12, y);
					y += yShift;
					g2d.drawString("         CodeGuid.com        ", 12, y);
					y += yShift;
					g2d.drawString("   No 00000 Address Line One ", 12, y);
					y += yShift;
					g2d.drawString("   Address Line 02 SRI LANKA ", 12, y);
					y += yShift;
					g2d.drawString("   www.facebook.com/CodeGuid ", 12, y);
					y += yShift;
					g2d.drawString("        +94700000000      ", 12, y);
					y += yShift;
					g2d.drawString("-------------------------------------", 12, y);
					y += headerRectHeight;

					g2d.drawString(" Item Name                  Price   ", 10, y);
					y += yShift;
					g2d.drawString("-------------------------------------", 10, y);
					y += headerRectHeight;

					for (int s = 0; s < r; s++) {
						g2d.drawString(" " + itemName.get(s) + "                            ", 10, y);
						y += yShift;
						g2d.drawString("      " + quantity.get(s) + " * " + itemPrice.get(s), 10, y);
						g2d.drawString(subtotal.get(s), 160, y);
						y += yShift;

					}

					g2d.drawString("-------------------------------------", 10, y);
					y += yShift;
					g2d.drawString(" Total amount:               " + txtTotalAmount.getText() + "   ", 10, y);
					y += yShift;
					g2d.drawString("-------------------------------------", 10, y);
					y += yShift;
					g2d.drawString(" Cash      :                 " + txtCash.getText() + "   ", 10, y);
					y += yShift;
					g2d.drawString("-------------------------------------", 10, y);
					y += yShift;
					g2d.drawString(" Balance   :                 " + txtBalance.getText() + "   ", 10, y);
					y += yShift;

					g2d.drawString("*************************************", 10, y);
					y += yShift;
					g2d.drawString("       THANK YOU COME AGAIN            ", 10, y);
					y += yShift;
					g2d.drawString("*************************************", 10, y);
					y += yShift;
					g2d.drawString("       SOFTWARE BY:CODEGUID          ", 10, y);
					y += yShift;
					g2d.drawString("   CONTACT: contact@codeguid.com       ", 10, y);
					y += yShift;

				} catch (Exception e) {
					e.printStackTrace();
				}

				result = PAGE_EXISTS;
			}
			return result;
		}
	}

}
