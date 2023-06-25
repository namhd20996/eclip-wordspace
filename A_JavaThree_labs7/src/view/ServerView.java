package view;

import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import controller.ControllerView;
import server.ServerSocket;
import javax.swing.JScrollPane;

public class ServerView extends JFrame implements Runnable {

	private JPanel contentPane;
	private JTextField textField_Port;
	private JList list;
	private java.net.ServerSocket server;
	private Socket socket;
	private DefaultListModel model;
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
					ServerView frame = new ServerView();
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
	public ServerView() {
		this.setTitle("Server");
		ControllerView clt = new ControllerView(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Text Sending");
		lblNewLabel.setBounds(46, 178, 89, 14);
		contentPane.add(lblNewLabel);

		JLabel lblServer = new JLabel("Client");
		lblServer.setBounds(46, 39, 48, 14);
		contentPane.add(lblServer);

		JButton btnConnect = new JButton("Connect");
		btnConnect.setActionCommand("Connect sv");
		btnConnect.addActionListener(clt);
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
		btnSend.setActionCommand("Send sv");
		btnSend.addActionListener(clt);
		btnSend.setBounds(328, 205, 89, 47);
		contentPane.add(btnSend);

		list = new JList();
		
		textArea = new JTextArea();
		textArea.setBounds(46, 205, 273, 49);
		contentPane.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(46, 63, 382, 104);
		contentPane.add(scrollPane);

		model = new DefaultListModel();

//		this.setLocationRelativeTo(null);
	}

	public void connectPort() {
		try {
			int port = Integer.valueOf(this.textField_Port.getText());
			this.model.addElement("Server connecting..");
			this.list.setModel(model);
			this.server = new java.net.ServerSocket(port);
			this.socket = this.server.accept();
			this.model.addElement("Connect client success...");
			this.list.setModel(model);
			Thread t = new Thread(ServerView.this);
			t.start();
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
					this.model.addElement("Client: " + this.inputStream.readUTF());
					this.list.setModel(model);
				}
				Thread.sleep(1000);
			}
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
}
