package component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import net.miginfocom.swing.MigLayout;
import util.EventMenu;
import util.EventMenuSelected;
import util.EventShowPopupMenu;
import util.MenuAnimation;
import util.MenuItem;
import util.ModelMenu;
import util.ScrollBarCustom;

@SuppressWarnings("serial")
public class Menu extends javax.swing.JPanel {
	private final MigLayout ml_pnlMenu;
	private EventMenuSelected event;
	private EventShowPopupMenu eventShowPopup;
	private boolean enableMenu = true;
	private boolean showMenu = true;
	private JPanel pnlMenu;

	public Menu() {
		setBounds(new Rectangle(0, 0, 0, 500));
		setForeground(new Color(255, 255, 255));
		setOpaque(false);
		setLayout(null);

		pnlMenu = new JPanel();
		pnlMenu.setBorder(null);
		pnlMenu.setForeground(new Color(255, 255, 255));
		pnlMenu.setOpaque(false);

		JScrollPane scrollPane = new JScrollPane(pnlMenu);
		scrollPane.setForeground(new Color(255, 255, 255));

		scrollPane.setOpaque(false);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(null);
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(0, 107, 177, 539);

		scrollPane.getViewport().setOpaque(false);
		scrollPane.setVerticalScrollBar(new ScrollBarCustom());
		ml_pnlMenu = new MigLayout("wrap, fillx, insets 0", "[fill]", "[]0[]");
		pnlMenu.setLayout(ml_pnlMenu);
		add(scrollPane);

		JLabel lblNewLabel = new JLabel("  Duy Nam");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/com/raven/icon/logo.png")));
		lblNewLabel.setBounds(10, 11, 157, 85);
		add(lblNewLabel);
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
//		System.out.println(pnlMenu.getComponentCount());
	}

	public void initMenuItem() {
		addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/10.png")), "Tòa nhà",
				"Danh sách tòa nhà"));
		addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/1.png")), "Phòng", "Quản lý phòng",
				"Chuyển phòng"));
		addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/2.png")), "Dịch vụ",
				"Quản lý dịch vụ"));
		addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/3.png")), "Phiếu thu/chi",
				"Phiếu thu tiền phòng", "Phiếu chi"));
		addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/6.png")), "Khách thuê",
				"Danh sách khách", "Đối tượng"));
		addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/7.png")), "Mail/SMS",
				"Lịch sử gửi mail/SMS"));
		addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/8.png")), "Thống kê",
				"Báo cáo doanh thu", "Báo cáo thu chi"));
		addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/9.png")), "Nhân viên",
				"Quản lý nhân viên"));
		addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/10.png")), "Tài sản",
				"Danh sách tài sản"));
		addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/10.png")), "Đăng xuất"));
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

	public void hideallMenu() {
		for (Component com : pnlMenu.getComponents()) {
			MenuItem item = (MenuItem) com;
			if (item.isOpen()) {
				new MenuAnimation(ml_pnlMenu, com, 500).closeMenu();
				item.setOpen(false);
			}
		}
	}
}
