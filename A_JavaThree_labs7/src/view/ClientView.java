package view;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControllerView;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class ClientView extends JFrame implements Runnable {

	private JPanel contentPane;
	private JTextField textField_Port;
	private DefaultListModel model;
	private JList list;
	private Socket socket;
	private DataOutputStream outputStream;
	private DataInputStream inputStream;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					ClientView frame = new ClientView();
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
	public ClientView() {
		this.setTitle("Client");
		ControllerView ctl = new ControllerView(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Text Sending");
		lblNewLabel.setBounds(46, 178, 89, 14);
		contentPane.add(lblNewLabel);

		JLabel lblServer = new JLabel("Server");
		lblServer.setBounds(46, 39, 48, 14);
		contentPane.add(lblServer);

		JButton btnConnect = new JButton("Connect");
		btnConnect.setActionCommand("Connect cl");
		btnConnect.addActionListener(ctl);
		btnConnect.setBounds(328, 10, 89, 23);
		contentPane.add(btnConnect);

		JLabel lblPort = new JLabel("Port:");
		lblPort.setBounds(46, 14, 48, 14);
		contentPane.add(lblPort);

		textField_Port = new JTextField();
		textField_Port.setColumns(10);
		textField_Port.setBounds(86, 11, 233, 20);
		contentPane.add(textField_Port);

		JButton btnSend = new JButton("Send");
		btnSend.setActionCommand("Send cl");
		btnSend.addActionListener(ctl);
		btnSend.setBounds(328, 205, 89, 47);
		contentPane.add(btnSend);

		list = new JList();

		this.model = new DefaultListModel();

		textArea = new JTextArea();
		textArea.setBounds(46, 205, 273, 49);
		contentPane.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(46, 64, 382, 103);
		contentPane.add(scrollPane);
		this.setLocationRelativeTo(null);
	}

	public void connectServerPort() {
		try {
			int port = Integer.valueOf(this.textField_Port.getText());
			this.model.addElement("Connect client...");
			this.list.setModel(model);
			this.socket = new Socket("localhost", port);
			this.model.addElement("Connect server success...");
			this.list.setModel(model);
			Thread t = new Thread(ClientView.this);
			t.start();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void sendMessage() {
		try {
			this.outputStream = new DataOutputStream(this.socket.getOutputStream());
			String message = this.textArea.getText();
			this.outputStream.writeUTF(message);
			this.outputStream.flush();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void run() {
		try {
			this.inputStream = new DataInputStream(this.socket.getInputStream());
			while (true) {
				if (this.socket != null) {
					this.model.addElement("Server: " + this.inputStream.readUTF());
					this.list.setModel(model);
				}
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
