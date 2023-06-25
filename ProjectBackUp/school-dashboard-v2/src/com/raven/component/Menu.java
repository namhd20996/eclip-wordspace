package com.raven.component;

import com.raven.event.EventMenu;
import com.raven.event.EventMenuSelected;
import com.raven.event.EventShowPopupMenu;
import com.raven.model.ModelMenu;
import com.raven.swing.MenuAnimation;
import com.raven.swing.MenuItem;
import com.raven.swing.scrollbar.ScrollBarCustom;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class Menu extends javax.swing.JPanel {
	private final MigLayout ml_pnlMenu;
	private EventMenuSelected event;
	private EventShowPopupMenu eventShowPopup;
	private boolean enableMenu = true;
	private boolean showMenu = true;
	private JPanel pnlMenu;

	public Menu() {
		setForeground(new Color(255, 255, 255));
		setOpaque(false);
		setLayout(null);

		pnlMenu = new JPanel();
		pnlMenu.setForeground(new Color(255, 255, 255));
		pnlMenu.setOpaque(false);

		JScrollPane scrollPane = new JScrollPane(pnlMenu);
		scrollPane.setForeground(new Color(255, 255, 255));
		
		scrollPane.setOpaque(false);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(null);
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(0, 107, 204, 474);

		scrollPane.getViewport().setOpaque(false);
		scrollPane.setVerticalScrollBar(new ScrollBarCustom());
		ml_pnlMenu = new MigLayout("wrap, fillx, insets 0", "[fill]", "[]0[]");
		pnlMenu.setLayout(ml_pnlMenu);
		add(scrollPane);
		
		JPanel pnlProfile = new JPanel();
		pnlProfile.setBackground(new Color(255, 255, 255));
		pnlProfile.setBounds(0, 0, 204, 107);
		add(pnlProfile);
		pnlProfile.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Duy Nam");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/com/raven/icon/logo.png")));
		lblNewLabel.setBounds(10, 11, 184, 85);
		pnlProfile.add(lblNewLabel);
	}

	public EventMenuSelected getEvent() {
		return event;
	}

	public void setEvent(EventMenuSelected event) {
		this.event = event;
	}

	public EventShowPopupMenu getEventShowPopup() {
		return eventShowPopup;
	}

	public void setEventShowPopup(EventShowPopupMenu eventShowPopup) {
		this.eventShowPopup = eventShowPopup;
	}

	public boolean isEnableMenu() {
		return enableMenu;
	}

	public void setEnableMenu(boolean enableMenu) {
		this.enableMenu = enableMenu;
	}

	public boolean isShowMenu() {
		return showMenu;
	}

	public void setShowMenu(boolean showMenu) {
		this.showMenu = showMenu;
	}

	public MigLayout getLayout() {
		return ml_pnlMenu;
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint gra = new GradientPaint(0, 0, new Color(33, 105, 249), getWidth(), 0, new Color(93, 58, 196));
		g2.setPaint(gra);
		g2.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}

	private void addMenu(ModelMenu menu) {
		pnlMenu.add(new MenuItem(menu, getEventMenu(), event, pnlMenu.getComponentCount()), "h 40!");
		
//		System.out.println(getEventMenu());
		
		// Lấy ra sự kiện của các đối tượng khi được add vào panel
//		System.out.println(event);
		
		// Lấy ra số lượng đối tượng được add vào panel
		System.out.println(pnlMenu.getComponentCount());
	}

	 public void initMenuItem() {
	        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/1.png")), "Dashboard", "Home", "Buttons", "Cards", "Tabs", "Accordions"));
	        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/2.png")), "Charts", "Morris", "Flot", "Line"));
	        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/3.png")), "Report", "Income", "Expense", "Profit"));
	        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/4.png")), "Message", "Sender", "Inbox", "User"));
	        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/5.png")), "Staff", "Sender", "Inbox", "User"));
	        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/6.png")), "Student", "Menu 001", "Menu 002", "Menu 003"));
	        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/7.png")), "Library", "Menu 001", "Menu 002", "Menu 003"));
	        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/8.png")), "Holiday", "Menu 001", "Menu 002", "Menu 003"));
	        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/9.png")), "Calendar", "Menu 001", "Menu 002", "Menu 003"));
	        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/10.png")), "Chat App", "Menu 001", "Menu 002", "Menu 003"));
	        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/11.png")), "Contace", "Menu 001", "Menu 002", "Menu 003"));
	        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/12.png")), "File Manager", "Menu 001", "Menu 002", "Menu 003"));
	        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/13.png")), "Our Centres"));
	        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/14.png")), "Gallery"));
	    }
	
	 // Lấy ra sự kiện click trên coponent nào và trả về giá trị boolean
	 // Cho menuItem xử lí tiếp
	private EventMenu getEventMenu() {
		return new EventMenu() {
			@Override
			public boolean menuPressed(Component com, boolean open) {
				if (enableMenu) {
					if (isShowMenu()) {
						if (open) {
							new MenuAnimation(ml_pnlMenu, com).openMenu();
						} else {
							new MenuAnimation(ml_pnlMenu, com).closeMenu();
						}
						return true;
					} else {
						eventShowPopup.showPopup(com);
					}
				}
				return false;
			}
		};
	}
}
