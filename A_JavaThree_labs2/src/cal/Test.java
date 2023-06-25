package cal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test extends JFrame implements ActionListener {
    // Tao 1 textfield chua ket qua
    private JTextField tfResult;

    // Bien luu tru ket qua
    private double kq = 0;

    // Bien luu tru phep toan
    private String phep = "=";

    // Bien nhan biet chua co nut nao duoc an
    private boolean click = true;

    // Thiet lap giao dien
    public Test() {
        setTitle("Calculator");
        setSize(300, 400);
        setLayout(new BorderLayout());

        // Dat gia tri mac dinh khoi tao bang 0
        tfResult = new JTextField("0");
        // Dat thuoc tinh chi doc
        tfResult.setEditable(false);
        // Dat tai vi tri o tren cung cua giao dien
        add(tfResult, "North");

        // Tao panel chua cac nut may tinh
        Panel panel = new Panel();
        // Chia panel lam 16 oo bang nhau de chua 16 nut
        panel.setLayout(new GridLayout(4, 4));
        // Danh sach 16 nut
        String[] arr = {"7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"};
        // Dat cac nut vao panel, gan doi tuong listen
        for (int i = 0; i < arr.length; i++) {
            Button button = new Button(arr[i]);
            panel.add(button);
            button.addActionListener(this);
        }
        // Dat panel vao vi tri chinh giua
        add(panel, "Center");

        // Cho phep dong cua so bang chuot o goc phai tren
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Lay ten nut vua bi an
        String s = e.getActionCommand();

        // Neu nut la so hay dau cham
        if ('0' <= s.charAt(0) && s.charAt(0) <= '9'
                || s.equals(".")) {
            // Neu la so duoc click dau tien
            if (click) {
                // Hien thi so vao tfResult
                tfResult.setText(s);
            } else { // Neu khong phai so duoc bam dau tien
                // Lay cac so hien co cua tfResult va them vao sau cung so vua bam
                tfResult.setText(tfResult.getText() + s);
            }

            // Thiet lap lai de lam dau so dau tien duoc bam
            click = false;
        } else { // Neu khong phai la so hoac dau cham
            if (click) {
                // Neu la dau - ma lai la ky tu dau tien la dau am
                if (s.equals("-")) {
                    tfResult.setText(s);
                    click = false;
                } else {
                    phep = s;
                }
            } else { // Neu da co so, nut vua an la phep toan
                double x = Double.parseDouble(tfResult.getText());
                calculator(x);
                phep = s;
                click = true;
            }
        }
    }

    // Dinh nghia ham tinh toan
    public void calculator(double n) {
        if (phep.equals("+")) {
            kq += n;
        } else if (phep.equals("-")) {
            kq -= n;
        } else if (phep.equals("*")) {
            kq *= n;
        } else if (phep.equals("/")) {
            kq /= n;
        } else if (phep.equals("=")) {
            kq = n;
        }

        tfResult.setText(kq + "");
    }
}
