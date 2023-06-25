import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class JPanelDraw extends JPanel {

	public JPanelDraw() {
		this.setBackground(Color.white);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setColor(Color.red);
		g.drawLine(15, 15, 50, 150);

		g.setColor(Color.blue);
		g.drawOval(255, 255, 50, 50);
		
		g.setColor(Color.green);
		g.drawRect(45, 150, 30, 90);
		
		g.setColor(Color.CYAN);
		g.drawString("Hello Duy Nam", 300, 300);
	}

}
