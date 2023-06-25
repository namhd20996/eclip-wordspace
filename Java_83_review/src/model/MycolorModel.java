package model;

import java.awt.Color;

public class MycolorModel {
	private Color foreround;
	private Color background;
	private boolean opaque;
	
	public MycolorModel() {
		this.foreround = Color.black;
		this.background = Color.white;
		this.opaque = true;
	}

	public Color getForeround() {
		return foreround;
	}

	public void setForeround(Color foreround) {
		this.foreround = foreround;
	}

	public Color getBackground() {
		return background;
	}

	public void setBackground(Color background) {
		this.background = background;
	}

	public boolean isOpaque() {
		return opaque;
	}

	public void setOpaque(boolean opaque) {
		this.opaque = opaque;
	}
	
	
	
}
