package girdbaglayout;

import javax.swing.Icon;
import javax.swing.JOptionPane;

/**
 *
 * @author Hoang Nam
 */
public class Productinfor extends javax.swing.JPanel {
    public Productinfor() {
        initComponents();
        btnCancel.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_IMG = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        txtProductName = new javax.swing.JTextField();
        lblPrice = new javax.swing.JLabel();
        btnBuy = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_IMG.setText("lbl_IMG");

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        txtProductName.setText("Product name:");

        lblPrice.setText("Price:");

        btnBuy.setText("Buy");
        btnBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbl_IMG, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(btnCancel)
                .addGap(12, 12, 12)
                .addComponent(btnBuy))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lbl_IMG, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblPrice)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancel)
                    .addComponent(btnBuy)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyActionPerformed
        JOptionPane.showMessageDialog(this, "Product name: "+pName+" Price: "+price);
        btnCancel.setVisible(true);
    }//GEN-LAST:event_btnBuyActionPerformed

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
        txtProductName.setText("Product name: "+pName);
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
        lblPrice.setText("Price: "+price);
    }

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
        lbl_IMG.setIcon(image);
    }

    private String pName;
    private String price;
    private Icon image;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuy;
    private javax.swing.JButton btnCancel;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lbl_IMG;
    private javax.swing.JTextField txtProductName;
    // End of variables declaration//GEN-END:variables
}
