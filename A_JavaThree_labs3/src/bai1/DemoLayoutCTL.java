package bai1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoLayoutCTL implements ActionListener{
	private DemoLayout demoLayout;

	public DemoLayoutCTL(DemoLayout demoLayout) {
		this.demoLayout = demoLayout;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Red")) {
			this.demoLayout.changeColor(Color.RED);
		}else if(src.equals("Green")) {
			this.demoLayout.changeColor(Color.GREEN);
		}else if(src.equals("Yellow")) {
			this.demoLayout.changeColor(Color.YELLOW);
		}else if(src.equals("North")) {
			this.demoLayout.changeText("North", Color.BLUE);
		}else if(src.equals("South")) {
			this.demoLayout.changeText("South", Color.ORANGE);
		}else if(src.equals("Center")) {
			this.demoLayout.changeText("Center", Color.pink);
		}else if(src.equals("East")) {
			this.demoLayout.changeText("East", Color.yellow);
		}else if(src.equals("West")) {
			this.demoLayout.changeText("West", Color.red);
		}
	}
	
	
}
