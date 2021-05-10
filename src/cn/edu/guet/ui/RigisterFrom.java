package cn.edu.guet.ui;

import cn.edu.guet.util.MD5;

import java.awt.*;
import java.awt.event.*;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Enumeration;
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

        if (userName.length() != 0) {
            if (passWord.length() != 0 && confirmPassWord.length() != 0) {
                if (passWord.equals(confirmPassWord)) {
                    Connection conn = null;
                    Statement stmt = null;
                    ResultSet rs = null;
                    try {
                        Class.forName(Driver);
                        conn = DriverManager.getConnection(url, OracleUserName, OraclePassWord);
                        stmt = conn.createStatement();
                        rs = stmt.executeQuery("SELECT * FROM users WHERE rownum=1 ORDER BY userid DESC");//将用户ID最大的元组选出
                        if (rs.next()) {
                            int ID = rs.getInt("userid");//拿到最大的用户ID
                            ID++;//用户ID+1，然将其作为添加用户的ID
                            try {
                                stmt.executeUpdate("INSERT INTO users values('" + ID + "','" + userName + "','" + MD5.encoderByMd5(passWord) + "')");
                                Error(label6);
                                System.out.println("注册成功");
                            } catch (NoSuchAlgorithmException ex) {
                                ex.printStackTrace();
                            } catch (UnsupportedEncodingException ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            try {
                                stmt.executeUpdate("INSERT INTO users values('" + 1 + "','" + userName + "','" + MD5.encoderByMd5(passWord) + "')");
                                Error(label6);
                                System.out.println("注册成功");
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
                    Error(label5);
                    System.out.println("密码错误");
                }
            } else {
                Error(label4);
                System.out.println("密码不能为空");
            }
        }else{
            Error(label7);
            System.out.println("请输入用户名！！！");
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
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(textField1);
        textField1.setBounds(150, 55, 195, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(150, 105, 195, textField2.getPreferredSize().height);
        contentPane.add(textField3);
        textField3.setBounds(150, 155, 195, textField3.getPreferredSize().height);

        //---- label1 ----
        label1.setText("\u7528\u6237\u540d\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 7f));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(65, 55), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u5bc6\u7801\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 7f));
        contentPane.add(label2);
        label2.setBounds(80, 100, label2.getPreferredSize().width, 30);

        //---- label3 ----
        label3.setText("\u786e\u8ba4\u5bc6\u7801\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 7f));
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(50, 155), label3.getPreferredSize()));

        //---- button1 ----
        button1.setText("\u6ce8\u518c");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 6f));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(150, 235), button1.getPreferredSize()));

        //---- button2 ----
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

        //---- label4 ----
        label4.setText("\u5bc6\u7801\u4e0d\u80fd\u4e3a\u7a7a\uff01\uff01\uff01");
        label4.setForeground(Color.red);
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(185, 10), label4.getPreferredSize()));

        //---- label5 ----
        label5.setText("\u5bc6\u7801\u9519\u8bef\uff01\uff01\uff01");
        label5.setForeground(Color.red);
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(190, 10), label5.getPreferredSize()));

        //---- label6 ----
        label6.setText("\u6ce8\u518c\u6210\u529f");
        label6.setForeground(Color.red);
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(205, 10), label6.getPreferredSize()));

        //---- label7 ----
        label7.setText("\u8bf7\u8f93\u5165\u7528\u6237\u540d\uff01\uff01\uff01");
        label7.setForeground(Color.red);
        contentPane.add(label7);
        label7.setBounds(new Rectangle(new Point(180, 10), label7.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(500, 350));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //控制错误提示
        label4.setVisible(false);
        label5.setVisible(false);
        label6.setVisible(false);
        label7.setVisible(false);
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
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton button1;
    private JButton button2;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private String Driver = "oracle.jdbc.driver.OracleDriver";//驱动
    private String url = "jdbc:oracle:thin:@120.77.203.216:1521:orcl";//Oracle的URL
    private String OracleUserName = "daming1";
    private String OraclePassWord = "dm1234";
}
