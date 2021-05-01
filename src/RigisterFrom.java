import java.awt.*;
import java.awt.event.*;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Wed Apr 28 22:24:46 CST 2021
 */


/**
 * @author 1
 */
public class RigisterFrom extends JFrame {
    public RigisterFrom() {
        initComponents();
    }

    private void button1MouseClicked(MouseEvent e) {
        String userName = textField1.getText();
        String passWord = textField2.getText();
        String confirmPassWord = textField3.getText();
        if (passWord.length() != 0 && confirmPassWord.length() != 0) {
            if (passWord.equals(confirmPassWord)) {
                Connection conn = null;
                String url = "jdbc:oracle:thin:@120.77.203.216:1521:orcl";
                Statement stmt = null;
                ResultSet rs = null;
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    conn = DriverManager.getConnection(url, "daming1", "dm1234");
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery("SELECT * FROM users WHERE rownum=1 ORDER BY userid DESC");
                    if (rs.next()) {
                        int ID = rs.getInt("userid");
                        ID++;
                        try {
                            stmt.executeUpdate("INSERT INTO users values('" + ID + "','" + userName + "','" + MD5.encoderByMd5(passWord) + "')");
                            System.out.println("×¢²á³É¹¦");
                        } catch (NoSuchAlgorithmException ex) {
                            ex.printStackTrace();
                        } catch (UnsupportedEncodingException ex) {
                            ex.printStackTrace();
                        }
                    }
                } catch (ClassNotFoundException ee) {
                    ee.printStackTrace();
                } catch (SQLException ee) {
                    ee.printStackTrace();
                } finally {
                    try {
                        conn.close();
                        stmt.close();
                    } catch (SQLException ee) {
                        ee.printStackTrace();
                    }
                }
            } else {
                System.out.println("×¢²áÊ§°Ü");
            }
        } else {
            System.out.println("ÃÜÂë²»ÄÜÎª¿Õ");
        }
    }

    private void button2MouseClicked(MouseEvent e) {
        this.setVisible(false);
        new LoginFrom();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(textField1);
        textField1.setBounds(150, 55, 195, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(150, 105, 195, textField2.getPreferredSize().height);
        contentPane.add(textField3);
        textField3.setBounds(150, 155, 195, textField3.getPreferredSize().height);

        //---- ÓÃ»§Ãû ----
        label1.setText("\u7528\u6237\u540d\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 7f));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(65, 55), label1.getPreferredSize()));

        //---- ÃÜÂë ----
        label2.setText("\u5bc6\u7801\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 7f));
        contentPane.add(label2);
        label2.setBounds(80, 100, label2.getPreferredSize().width, 30);

        //---- È·ÈÏÃÜÂë ----
        label3.setText("\u786e\u8ba4\u5bc6\u7801\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 7f));
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(50, 155), label3.getPreferredSize()));

        //---- ×¢²á ----
        button1.setText("\u6ce8\u518c");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 6f));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(155, 235), button1.getPreferredSize()));

        //---- ·µ»ØµÇÂ¼ ----
        button2.setText("\u8fd4\u56de\u767b\u9646");
        button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 6f));
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(240, 235), button2.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(500, 350));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
