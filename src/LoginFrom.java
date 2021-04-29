import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sat Apr 24 20:37:06 CST 2021
 */



/**
 * @author 1
 */
public class LoginFrom extends JFrame {
    public static void main(String[] args) {
        new LoginFrom();
    }
    public LoginFrom() {
        initComponents();
    }

    private void button1MouseClicked(MouseEvent e) {
        String username=textField1.getText();
        String password=textField2.getText();

        Connection conn=null;
        String url="jdbc:oracle:thin:@120.77.203.216:1521:orcl";
        Statement stmt=null;
        String sql="SELECT * FROM USERS WHERE USERNAME='"+username+"' AND PASSWORD='"+password+"'";
        ResultSet rs=null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn= DriverManager.getConnection(url,"scott","tiger");
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            if(rs.next()){
                System.out.println("登陆成功");
            }else{
                System.out.println("登录失败");
            }
        } catch (ClassNotFoundException ee) {
            ee.printStackTrace();
        } catch (SQLException ee) {
            ee.printStackTrace();
        }finally{
            try {
                conn.close();
                stmt.close();
                rs.close();
            } catch (SQLException ee) {
                ee.printStackTrace();
            }
        }
    }

    private void button2MousePressed(MouseEvent e) {
        this.setVisible(false);
        new RigisterFrom();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- 用户名 ----
        label1.setText("\u7528\u6237\u540d\uff1a");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(40, 40), label1.getPreferredSize()));

        //---- 密码 ----
        label2.setText("\u5bc6\u7801\uff1a");
        contentPane.add(label2);
        label2.setBounds(45, 70, label2.getPreferredSize().width, 20);
        contentPane.add(textField1);
        textField1.setBounds(95, 40, 175, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(95, 75, 175, textField2.getPreferredSize().height);

        //---- 登录按钮 ----
        button1.setText("\u767b\u5f55");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(100, 135), button1.getPreferredSize()));

        //---- 注册按钮 ----
        button2.setText("\u6ce8\u518c\u8d26\u6237");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button2MousePressed(e);
            }
        });
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(185, 135), button2.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(370, 240));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
