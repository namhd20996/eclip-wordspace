package util;

import java.awt.AlphaComposite;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import util.EventMenu;
import util.EventMenuSelected;
import util.MenuButton;
import util.ModelMenu;

public class MenuItem extends JPanel {
	private float alpha;
	private ModelMenu menu;
	private boolean open;
	private EventMenuSelected eventMenuSelected;
	private int index;
	private MenuButton firstItem;

	/**
	 * Create the panel.
	 */
	public MenuItem(ModelMenu menu, EventMenu eventMenu, EventMenuSelected eventMenuSelected, int index) {
		this.menu = menu;
		this.eventMenuSelected = eventMenuSelected;
		this.index = index;
		setOpaque(false);
		setLayout(new MigLayout("wrap, fillx, insets 0", "[fill]", "[fill, 40!]0[fill, 35!]"));
		firstItem = new MenuButton(menu.getIcon(), "      " + menu.getMenuName());
		firstItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Lấy sự kiện click vào menu sổ ra các tùy chọn bên trong
				// Lấy value từ form menu
				if (menu.getSubMenu().length > 0) {
					if (eventMenu.menuPressed(MenuItem.this, !open)) {
						open = !open;
					}
				}
				// Interface tự tạo để lấy index
				// index được lầy từ Menu gửi sang
				eventMenuSelected.menuSelected(index, -1);
			}
		});
		add(firstItem);
		int subMenuIndex = -1;
		for (String st : menu.getSubMenu()) {
			MenuButton item = new MenuButton(st);
			item.setIndex(++subMenuIndex);
			item.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					eventMenuSelected.menuSelected(index, item.getIndex());
				}
			});
			add(item);
		}
	}

	public float getAlpha() {
		return alpha;
	}

	public void setAlpha(float alpha) {
		this.alpha = alpha;
	}

	public ModelMenu getMenu() {
		return menu;
	}

	public void setMenu(ModelMenu menu) {
		this.menu = menu;
	}

	public EventMenuSelected getEventMenuSelected() {
		return eventMenuSelected;
	}

	public void setEventMenuSelected(EventMenuSelected eventMenuSelected) {
		this.eventMenuSelected = eventMenuSelected;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	// Tạo vùng chọn màu đen cho bảng điều khiển
	@Override
	protected void paintComponent(Graphics grphcs) {
		int width = getWidth();
		int height = getPreferredSize().height;
		Graphics2D g2 = (Graphics2D) grphcs;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// Tạo màu cho bảng điều khiển
		g2.setColor(new Color(100, 100, 100));
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		g2.fillRect(0, 2, width, 38);
		g2.setComposite(AlphaComposite.SrcOver);
		g2.fillRect(0, 40, width, height - 40);
		// Tạo màu cho thanh kẻ
		g2.setColor(Color.orange);
		g2.drawLine(30, 40, 30, height - 17);
		for (int i = 0; i < menu.getSubMenu().length; i++) {
			int y = ((i + 1) * 35 + 40) - 17;
			g2.drawLine(30, y, 38, y);
		}
		if (menu.getSubMenu().length > 0) {
			createArrowButton(g2);
		}
		super.paintComponent(grphcs);
	}

	// Tạo tạo dấu mũi tên cho item
	private void createArrowButton(Graphics2D g2) {
		int size = 4;
		int y = 19;
		int x = 150;
		g2.setColor(new Color(230, 230, 230));
		float ay = alpha * size;
		float ay1 = (1f - alpha) * size;
		g2.drawLine(x, (int) (y + ay), x + 4, (int) (y + ay1));
		g2.drawLine(x + 4, (int) (y + ay1), x + 8, (int) (y + ay));
	}
}
