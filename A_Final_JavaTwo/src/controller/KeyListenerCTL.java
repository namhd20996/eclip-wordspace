package controller;

import java.awt.event.KeyEvent;

import view.QLNVView;

public class KeyListenerCTL implements java.awt.event.KeyListener{
	private QLNVView qlnvView;
	
	public KeyListenerCTL(QLNVView qlnvView) {
		this.qlnvView = qlnvView;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		this.qlnvView.disEnabled();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}
