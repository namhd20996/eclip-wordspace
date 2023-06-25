import java.awt.BorderLayout;

import javax.swing.JFrame;

public class JPanelView extends JFrame{
	public JPanelView() {
		this.setTitle("Draw");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		JPanelDraw jPanelDraw = new JPanelDraw();
		
		this.setLayout(new BorderLayout());
		this.add(jPanelDraw, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		new JPanelView();
	}
}
