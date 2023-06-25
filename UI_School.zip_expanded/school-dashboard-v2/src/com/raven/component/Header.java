package com.raven.component;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Header extends javax.swing.JPanel {
	private com.raven.swing.ButtonBadges btnNotifi;
	private com.raven.swing.ButtonBadges bntEmail;
	private com.raven.swing.Button btnHeader;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JLabel lblRole;
	private javax.swing.JLabel lblUserName;
	private com.raven.swing.ImageAvatar lbl_IMG;

	public Header() {
		initComponents();
	}

	public void addMenuEvent(ActionListener event) {
		btnHeader.addActionListener(event);
	}

	private void initComponents() {

		btnHeader = new com.raven.swing.Button();
		btnHeader.setActionCommand("Header");
		lbl_IMG = new com.raven.swing.ImageAvatar();
		lblUserName = new javax.swing.JLabel();
		lblRole = new javax.swing.JLabel();
		jSeparator1 = new javax.swing.JSeparator();
		btnNotifi = new com.raven.swing.ButtonBadges();
		bntEmail = new com.raven.swing.ButtonBadges();

		setBackground(new Color(192, 192, 192));

		btnHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/menu.png"))); // NOI18N

		lbl_IMG.setIcon(new ImageIcon(Header.class.getResource("/com/raven/icon/IMG_2010.JPG"))); // NOI18N

		lblUserName.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
		lblUserName.setForeground(new java.awt.Color(127, 127, 127));
		lblUserName.setText("User Name");

		lblRole.setForeground(new java.awt.Color(127, 127, 127));
		lblRole.setText("Admin");

		jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

		btnNotifi.setForeground(new java.awt.Color(250, 49, 49));
		btnNotifi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/notification.png"))); // NOI18N
		btnNotifi.setBadges(12);

		bntEmail.setForeground(new java.awt.Color(63, 178, 232));
		bntEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/message.png"))); // NOI18N
		bntEmail.setBadges(5);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(btnHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 362, Short.MAX_VALUE)
						.addComponent(bntEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(3, 3, 3)
						.addComponent(btnNotifi, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblUserName, javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(lblRole, javax.swing.GroupLayout.Alignment.TRAILING))
						.addGap(18, 18, 18).addComponent(lbl_IMG, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addComponent(lblUserName)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblRole))
						.addComponent(btnHeader, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lbl_IMG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(jSeparator1)
						.addComponent(btnNotifi, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(bntEmail, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addContainerGap()));
	}
	
	
}
