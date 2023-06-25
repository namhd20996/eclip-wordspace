package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ClientView;
import view.ServerView;

public class ControllerView implements ActionListener {
	private ClientView clientView;
	private ServerView serverView;

	public ControllerView(ClientView clientView) {
		this.clientView = clientView;
	}

	public ControllerView(ServerView serverView) {
		this.serverView = serverView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Connect sv")) {
			this.serverView.connectPort();
		}else if(src.equals("Connect cl")) {
			this.clientView.connectServerPort();
		}else if(src.equals("Send cl")) {
			this.clientView.sendMessage();
		}else if(src.equals("Send sv")) {
			this.serverView.sendMessage();
		}
	}

}
