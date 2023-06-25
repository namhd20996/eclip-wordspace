package component;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Header extends javax.swing.JPanel {
	private com.raven.swing.ButtonBadges btnNotifi;
	private com.raven.swing.ButtonBadges bntEmail;
	private util.Button btnHeader;
	private javax.swing.JSeparator jSeparator;
	public javax.swing.JLabel lblRole;
	public javax.swing.JLabel lblUserName;
	public util.ImageAvatar lbl_IMG;
	private JLabel lbl_HeaderNT;

	public Header() {
		btnHeader = new util.Button();
		btnHeader.setActionCommand("Header");
		lbl_IMG = new util.ImageAvatar();
		lblUserName = new javax.swing.JLabel();
		lblRole = new javax.swing.JLabel();
		jSeparator = new javax.swing.JSeparator();
		btnNotifi = new com.raven.swing.ButtonBadges();
		bntEmail = new com.raven.swing.ButtonBadges();
	

		setBackground(new Color(255, 255, 255));

		btnHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/menu.png"))); // NOI18N

		lbl_IMG.setIcon(new ImageIcon(Header.class.getResource("/icon/IMG_2010.JPG"))); // NOI18N

		lblUserName.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
		lblUserName.setForeground(new java.awt.Color(127, 127, 127));
		lblUserName.setText("User Name");

		lblRole.setForeground(new java.awt.Color(127, 127, 127));
		lblRole.setText("Admin");

		jSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);

		btnNotifi.setForeground(new java.awt.Color(250, 49, 49));
		btnNotifi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/notification.png"))); // NOI18N
		btnNotifi.setBadges(12);

		bntEmail.setForeground(new java.awt.Color(63, 178, 232));
		bntEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/message.png"))); // NOI18N
		bntEmail.setBadges(5);
		
		lbl_HeaderNT = new JLabel("Quản Lý Nhà Trọ");
		lbl_HeaderNT.setForeground(new Color(0, 128, 255));
		lbl_HeaderNT.setFont(new Font("Tahoma", Font.BOLD, 22));
		lbl_HeaderNT.setHorizontalAlignment(SwingConstants.CENTER);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnHeader, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(107)
					.addComponent(lbl_HeaderNT, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
					.addGap(37)
					.addComponent(bntEmail, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(btnNotifi, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jSeparator, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUserName, Alignment.TRAILING)
						.addComponent(lblRole, Alignment.TRAILING))
					.addGap(18)
					.addComponent(lbl_IMG, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_HeaderNT, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup()
							.addComponent(lblUserName)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblRole))
						.addComponent(btnHeader, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
						.addComponent(lbl_IMG, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jSeparator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNotifi, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
						.addComponent(bntEmail, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
					.addContainerGap())
		);
		this.setLayout(layout);
	}

	public void addMenuEvent(ActionListener event) {
		btnHeader.addActionListener(event);
	}
	
	public void displayRole(String user, String role, ImageIcon icon) {
		lblUserName.setText(user.toUpperCase());
		lblRole.setText(role.toUpperCase());
		lbl_IMG.setIcon(icon);
	}
}
