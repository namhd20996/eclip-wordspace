package bai_them;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainCTL implements ChangeListener {
	private MainJslider mainJslider;

	public MainCTL(MainJslider mainJslider) {
		this.mainJslider = mainJslider;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource().toString().contains("sldNgay")) {
			this.mainJslider.displayDate();
		} else if (e.getSource().toString().contains("sldThang")) {
			this.mainJslider.displayDate();
		} else if (e.getSource().toString().contains("sldNam")) {
			this.mainJslider.displayDate();
		}
	}

}
