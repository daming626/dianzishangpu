package cn.edu.guet.ui;

import cn.edu.guet.util.MD5;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import java.awt.*;
import java.awt.event.*;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
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
        FormOptimization();//调用优化方法
        new LoginFrom();
    }

    public LoginFrom() {
        /*//优化界面
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch(Exception e) {
            System.out.println(e);
        }*/
        initComponents();
        setTitle("\u767b\u5f55");

        URL url=MainFrom.class.getResource("iab.png");
        ImageIcon imageIcon = new ImageIcon(url);
        Image image = imageIcon.getImage();
        this.setIconImage(image);
    }

    //窗口美化方法，需要导入相应jar
    public static void FormOptimization(){
        try
        {
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }
        catch(Exception e)
        {
            //TODO exception
        }
        //设置此开关量为false即表示关闭之，BeautyEye LNF中默认是true
        BeautyEyeLNFHelper.translucencyAtFrameInactive = false;
    }

    private void button1MouseClicked(MouseEvent e) {//登录
        String username = textField1.getText();
        String password = new String(passwordField1.getPassword());

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName(Driver);
            conn = DriverManager.getConnection(url, OracleUserName, OraclePassWord);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM USERS WHERE USERNAME='" + username + "' AND PASSWORD='" + MD5.encoderByMd5(password) + "'");
            if (rs.next()) {
                Error(label4);
                System.out.println("\u767b\u9646\u6210\u529f");//登陆成功
                new MainFrom();
                this.setVisible(false);
            } else {
                Error(label3);
                System.out.println("\u767b\u5f55\u5931\u8d25\uff0c\u7528\u6237\u540d\u6216\u5bc6\u7801\u9519\u8bef");//登录失败，用户名或密码错误
            }
        } catch (ClassNotFoundException ee) {
            ee.printStackTrace();
        } catch (SQLException ee) {
            ee.printStackTrace();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        } finally {
            try {
                conn.close();
                stmt.close();
                rs.close();
            } catch (SQLException ee) {
                ee.printStackTrace();
            }
        }
    }

    private void button2MousePressed(MouseEvent e) {//登录
        this.setVisible(false);
        new RigisterFrom();
    }

    public static String getUserName() {
        return textField1.getText();
    }

    private void thisWindowClosing(WindowEvent e) {
        int option = JOptionPane.showConfirmDialog(this, "\u786e\u5b9a\u9000\u51fa?", "\u63d0\u793a", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION)
        {
            if (e.getWindow() == this) {
                this.dispose();
                System.exit(0);
            } else {
                return;
            }
        }
        else if(option == JOptionPane.NO_OPTION){
            if (e.getWindow() == this) {
                return;
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        passwordField1 = new JPasswordField();
        button1 = new JButton();
        button2 = new JButton();
        label3 = new JLabel();
        label4 = new JLabel();
        panel1 = new JPanel();

        //======== this ========
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u7528\u6237\u540d\uff1a");
        contentPane.add(label1);
        label1.setBounds(40, 50, label1.getPreferredSize().width, 22);

        //---- label2 ----
        label2.setText("\u5bc6\u7801\uff1a");
        contentPane.add(label2);
        label2.setBounds(50, 90, label2.getPreferredSize().width, 20);
        contentPane.add(textField1);
        textField1.setBounds(95, 50, 175, textField1.getPreferredSize().height);
        contentPane.add(passwordField1);
        passwordField1.setBounds(95, 90, 175, passwordField1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u767b\u5f55");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        contentPane.add(button1);
        button1.setBounds(95, 130, 175, button1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("\u6ce8\u518c\u8d26\u6237");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button2MousePressed(e);
            }
        });
        contentPane.add(button2);
        button2.setBounds(95, 165, 175, button2.getPreferredSize().height);

        //---- label3 ----
        label3.setText("\u767b\u5f55\u5931\u8d25\uff0c\u7528\u6237\u540d\u6216\u5bc6\u7801\u9519\u8bef");
        label3.setForeground(Color.red);
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 2f));
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(90, 0), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText("\u767b\u9646\u6210\u529f");
        label4.setForeground(Color.red);
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 2f));
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(150, 0), label4.getPreferredSize()));

        //======== panel1 ========
        {
            panel1.setLayout(null);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(0, 0, 370, 250);

        contentPane.setPreferredSize(new Dimension(370, 240));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        label3.setVisible(false);
        label4.setVisible(false);
    }

    //线程控制错误弹窗
    public void Error(JLabel labelnum) {
        Thread thread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        labelnum.setVisible(true);
                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        labelnum.setVisible(false);
                    }
                }
        );
        thread.start();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private static JTextField textField1;
    private JPasswordField passwordField1;
    private JButton button1;
    private JButton button2;
    private JLabel label3;
    private JLabel label4;
    private JPanel panel1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private String Driver="oracle.jdbc.driver.OracleDriver";//驱动
    private String url = "jdbc:oracle:thin:@120.77.203.216:1521:orcl";//Oracle的URL
    private String OracleUserName = "daming1";
    private String OraclePassWord = "dm1234";
}
