import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.awt.*;
import java.awt.event.*;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/*
 * Created by JFormDesigner on Wed Apr 28 22:22:59 CST 2021
 */


/**
 * @author 1
 */
public class MainFrom extends JFrame {
    public MainFrom() {
        initComponents();
    }


    private void menu4MousePressed(MouseEvent e) {
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(false);
        panel4.setVisible(true);
        panel5.setVisible(false);
        panel6.setVisible(false);
        panel7.setVisible(false);
        panel8.setVisible(false);
        panel9.setVisible(false);
    }

    private void menuItem2MousePressed(MouseEvent e) {
        panel1.setVisible(true);
        panel2.setVisible(false);
        panel3.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        panel7.setVisible(false);
        panel8.setVisible(false);
        panel9.setVisible(false);
        DefaultTableModel tableModel = new DefaultTableModel(queryData1(), head1) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setModel(tableModel);
    }

    private void menuItem3MousePressed(MouseEvent e) {
        panel1.setVisible(false);
        panel2.setVisible(true);
        panel3.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        panel7.setVisible(false);
        panel8.setVisible(false);
        panel9.setVisible(false);
    }

    private void menuItem4MousePressed(MouseEvent e) {
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(true);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        panel7.setVisible(false);
        panel8.setVisible(false);
        panel9.setVisible(false);
    }

    private void menuItem5MousePressed(MouseEvent e) {
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(true);
        panel6.setVisible(false);
        panel7.setVisible(false);
        panel8.setVisible(false);
        panel9.setVisible(false);
        DefaultTableModel tableModel = new DefaultTableModel(queryData2(), head2) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table2.setModel(tableModel);
    }

    private void menuItem6MousePressed(MouseEvent e) {
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(true);
        panel7.setVisible(false);
        panel8.setVisible(false);
        panel9.setVisible(false);
    }

    private void menuItem7MousePressed(MouseEvent e) {
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        panel7.setVisible(true);
        panel8.setVisible(false);
        panel9.setVisible(false);
    }

    private void menuItem8MousePressed(MouseEvent e) {
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        panel7.setVisible(false);
        panel8.setVisible(false);
        panel9.setVisible(true);
    }

    private void menuItem9MousePressed(MouseEvent e) {
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        panel7.setVisible(false);
        panel8.setVisible(true);
        panel9.setVisible(false);
    }

    private void button1MouseClicked(MouseEvent e) {
        DefaultTableModel tableModel = new DefaultTableModel(queryData1(), head1) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setModel(tableModel);
    }

    private void button2MouseClicked(MouseEvent e) {
        panel1.setVisible(false);
        panel2.setVisible(true);
        panel3.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        panel7.setVisible(false);
        panel8.setVisible(false);
        panel9.setVisible(false);
    }

    private void button3MouseClicked(MouseEvent e) {
        int count = table1.getSelectedRow();//选中的行数
        String userID = String.valueOf(table1.getValueAt(count, 0));//选中行数第一列的数据

        deleteData("USERS", "USERID", userID);//调用自定义的方法，删除数据
    }

    private void button4MouseClicked(MouseEvent e) {
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(true);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        panel7.setVisible(false);
        panel8.setVisible(false);
        panel9.setVisible(false);
    }

    private void button5MouseClicked(MouseEvent e) {
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
                    rs = stmt.executeQuery("SELECT * FROM users WHERE rownum=1 ORDER BY userid DESC");//将用户ID最大的元组选出
                    if (rs.next()) {
                        int ID = rs.getInt("userid");//拿到最大的用户ID
                        ID++;//用户ID+1，然将其作为添加用户的ID
                        try {
                            stmt.executeUpdate("INSERT INTO users values('" + ID + "','" + userName + "','" + MD5.encoderByMd5(passWord) + "')");
                            System.out.println("添加成功");
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
                System.out.println("添加失败");
            }
        } else {
            System.out.println("密码不能为空");
        }
    }

    private void button6MouseClicked(MouseEvent e) {
        String userName = textField4.getText();
        String newPassWord = textField5.getText();
        String confirmNewPassWord = textField6.getText();

        Connection conn = null;
        String url = "jdbc:oracle:thin:@120.77.203.216:1521:orcl";
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "daming1", "dm1234");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM USERS WHERE USERNAME='" + userName + "'");//根据输入的username查询数据库中是否有这个人
            if (rs.next()) {
                if (newPassWord.length() != 0 && confirmNewPassWord.length() != 0) {
                    if (newPassWord.equals(confirmNewPassWord)) {
                        stmt.executeUpdate("UPDATE users set password='" + MD5.encoderByMd5(newPassWord) + "' WHERE username='" + userName + "'");
                        System.out.println("修改成功");
                    } else {
                        System.out.println("用户名或密码错误");
                    }
                } else {
                    System.out.println("密码不能为空");
                }
            } else {
                System.out.println("用户名或密码错误");
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
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

    private void button7MouseClicked(MouseEvent e) {
        DefaultTableModel tableModel = new DefaultTableModel(queryData2(), head2) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table2.setModel(tableModel);
    }

    private void button8MouseClicked(MouseEvent e) {
        int count = table2.getSelectedRow();//获取选中行数
        String product_id = (String) table2.getValueAt(count, 0);//获取选中行的第一个数据

        deleteData("PRODUCTS", "product_id", product_id);//调用自定义的删除数据的方法
    }

    private void button9MouseClicked(MouseEvent e) {
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(true);
        panel7.setVisible(false);
        panel8.setVisible(false);
        panel9.setVisible(false);
    }

    private void button10MouseClicked(MouseEvent e) {
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        panel7.setVisible(true);
        panel8.setVisible(false);
        panel9.setVisible(false);
    }

    private void button11MouseClicked(MouseEvent e) {
        String product_id = textField7.getText();
        String product_name = textField8.getText();
        String st = textField9.getText();
        String pr = textField10.getText();
        if (product_id.length() != 0 && product_name.length() != 0 && st.length() != 0 && pr.length() != 0) {
            int stock = Integer.valueOf(st);
            float price = Float.valueOf(pr);
            Connection conn = null;
            String url = "jdbc:oracle:thin:@120.77.203.216:1521:orcl";
            PreparedStatement pstmt = null;
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn = DriverManager.getConnection(url, "daming1", "dm1234");
                pstmt = conn.prepareStatement("INSERT INTO products VALUES(?,?,?,?)");
                pstmt.setString(1, product_id);
                pstmt.setString(2, product_name);
                pstmt.setInt(3, stock);
                pstmt.setFloat(4, price);
                pstmt.executeUpdate();
                System.out.println("添加成功");
            } catch (ClassNotFoundException ee) {
                ee.printStackTrace();
            } catch (SQLException ee) {
                ee.printStackTrace();
            } finally {
                try {
                    conn.close();
                    pstmt.close();
                } catch (SQLException ee) {
                    ee.printStackTrace();
                }
            }
        } else {
            System.out.println("请输入商品信息");
        }
    }

    private void button12MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void button13MouseClicked(MouseEvent e) {//按年月日查询流水
        String time = null;
        String date = null;
        String year = textField16.getText();
        String month = textField17.getText();
        String day = textField18.getText();
        if (year.length() != 0 && month.length() == 0 && day.length() == 0) {//输入年份
            time = year;
            date = "yyyy";
        } else if (year.length() != 0 && month.length() != 0 && day.length() == 0) {//输入年份、月份
            time = year + "/" + month;
            date = "yyyy-mm";
        } else if (year.length() != 0 && month.length() != 0 && day.length() != 0) {//输入年月日
            time = year + "/" + month + "/" + day;
            date = "yyyy-mm-dd";
        } else {
            System.out.println("请输入日期,由年月日的顺序");
        }
        DefaultTableModel tableModel = new DefaultTableModel(queryData3(time, date), head3) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table3.setModel(tableModel);
    }

    private void initComponents() {

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menu4 = new JMenu();
        menu1 = new JMenu();
        menuItem2 = new JMenuItem();
        menuItem3 = new JMenuItem();
        menuItem4 = new JMenuItem();
        menu2 = new JMenu();
        menuItem5 = new JMenuItem();
        menuItem6 = new JMenuItem();
        menuItem7 = new JMenuItem();
        menu3 = new JMenu();
        menuItem8 = new JMenuItem();
        menuItem9 = new JMenuItem();
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        panel2 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        button5 = new JButton();
        panel3 = new JPanel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        textField4 = new JTextField();
        textField5 = new JTextField();
        textField6 = new JTextField();
        button6 = new JButton();
        panel4 = new JPanel();
        label7 = new JLabel();
        panel5 = new JPanel();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();
        button10 = new JButton();
        panel6 = new JPanel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        textField7 = new JTextField();
        textField8 = new JTextField();
        textField9 = new JTextField();
        textField10 = new JTextField();
        button11 = new JButton();
        panel7 = new JPanel();
        label12 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();
        label15 = new JLabel();
        textField11 = new JTextField();
        textField12 = new JTextField();
        textField13 = new JTextField();
        textField14 = new JTextField();
        button12 = new JButton();
        panel8 = new JPanel();
        label17 = new JLabel();
        label18 = new JLabel();
        label19 = new JLabel();
        textField16 = new JTextField();
        textField17 = new JTextField();
        textField18 = new JTextField();
        scrollPane3 = new JScrollPane();
        table3 = new JTable();
        button13 = new JButton();
        panel9 = new JPanel();
        button14 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //======== menu4 ========
            {
                menu4.setText("\u9996\u9875");
                menu4.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        menu4MousePressed(e);
                    }
                });
            }
            menuBar1.add(menu4);

            //======== menu1 ========
            {
                menu1.setText("\u7528\u6237\u7ba1\u7406");

                //---- menuItem2 ----
                menuItem2.setText("\u67e5\u770b\u7528\u6237");
                menuItem2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        menuItem2MousePressed(e);
                    }
                });
                menu1.add(menuItem2);

                //---- menuItem3 ----
                menuItem3.setText("\u6dfb\u52a0\u7528\u6237");
                menuItem3.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        menuItem3MousePressed(e);
                    }
                });
                menu1.add(menuItem3);

                //---- menuItem4 ----
                menuItem4.setText("\u4fee\u6539\u5bc6\u7801");
                menuItem4.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        menuItem4MousePressed(e);
                    }
                });
                menu1.add(menuItem4);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("\u5546\u54c1\u5e93\u5b58\u7ba1\u7406");

                //---- menuItem5 ----
                menuItem5.setText("\u67e5\u770b\u5546\u54c1");
                menuItem5.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        menuItem5MousePressed(e);
                    }
                });
                menu2.add(menuItem5);

                //---- menuItem6 ----
                menuItem6.setText("\u6dfb\u52a0\u5546\u54c1");
                menuItem6.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        menuItem6MousePressed(e);
                    }
                });
                menu2.add(menuItem6);

                //---- menuItem7 ----
                menuItem7.setText("\u4fee\u6539\u5546\u54c1");
                menuItem7.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        menuItem7MousePressed(e);
                    }
                });
                menu2.add(menuItem7);
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("\u9500\u552e\u7ba1\u7406");

                //---- menuItem8 ----
                menuItem8.setText("\u9500\u552e\u754c\u9762");
                menuItem8.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        menuItem8MousePressed(e);
                    }
                });
                menu3.add(menuItem8);

                //---- menuItem9 ----
                menuItem9.setText("\u67e5\u770b\u5229\u6da6");
                menuItem9.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        menuItem9MousePressed(e);
                    }
                });
                menu3.add(menuItem9);
            }
            menuBar1.add(menu3);
        }
        setJMenuBar(menuBar1);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(table1);
            }
            panel1.add(scrollPane1);
            scrollPane1.setBounds(35, 25, 630, 235);

            //---- button1 ----
            button1.setText("\u5237\u65b0");
            button1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button1MouseClicked(e);
                }
            });
            panel1.add(button1);
            button1.setBounds(new Rectangle(new Point(80, 305), button1.getPreferredSize()));

            //---- button2 ----
            button2.setText("\u6dfb\u52a0\u7528\u6237");
            button2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button2MouseClicked(e);
                }
            });
            panel1.add(button2);
            button2.setBounds(new Rectangle(new Point(230, 305), button2.getPreferredSize()));

            //---- button3 ----
            button3.setText("\u5220\u9664\u7528\u6237");
            button3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button3MouseClicked(e);
                }
            });
            panel1.add(button3);
            button3.setBounds(new Rectangle(new Point(385, 305), button3.getPreferredSize()));

            //---- button4 ----
            button4.setText("\u4fee\u6539\u7528\u6237");
            button4.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button4MouseClicked(e);
                }
            });
            panel1.add(button4);
            button4.setBounds(new Rectangle(new Point(535, 305), button4.getPreferredSize()));
        }
        contentPane.add(panel1);
        panel1.setBounds(0, 0, 700, 400);

        //======== panel2 ========
        {
            panel2.setLayout(null);

            //---- label1 ----
            label1.setText("\u7528\u6237\u540d\uff1a");
            panel2.add(label1);
            label1.setBounds(200, 75, 65, 30);

            //---- label2 ----
            label2.setText("\u5bc6\u7801\uff1a");
            panel2.add(label2);
            label2.setBounds(210, 130, 50, 30);

            //---- label3 ----
            label3.setText("\u786e\u8ba4\u5bc6\u7801\uff1a");
            panel2.add(label3);
            label3.setBounds(190, 195, 70, 30);
            panel2.add(textField1);
            textField1.setBounds(290, 80, 145, textField1.getPreferredSize().height);
            panel2.add(textField2);
            textField2.setBounds(290, 135, 145, textField2.getPreferredSize().height);
            panel2.add(textField3);
            textField3.setBounds(290, 195, 145, textField3.getPreferredSize().height);

            //---- button5 ----
            button5.setText("\u786e\u8ba4\u6dfb\u52a0");
            button5.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button5MouseClicked(e);
                }
            });
            panel2.add(button5);
            button5.setBounds(290, 260, 145, button5.getPreferredSize().height);
        }
        contentPane.add(panel2);
        panel2.setBounds(0, 0, 700, 400);

        //======== panel3 ========
        {
            panel3.setLayout(null);

            //---- label4 ----
            label4.setText("\u9700\u8981\u4fee\u6539\u5bc6\u7801\u7684\u7528\u6237\u540d\uff1a");
            panel3.add(label4);
            label4.setBounds(125, 100, label4.getPreferredSize().width, 25);

            //---- label5 ----
            label5.setText("\u65b0\u5bc6\u7801\uff1a");
            panel3.add(label5);
            label5.setBounds(205, 145, 55, label5.getPreferredSize().height);

            //---- label6 ----
            label6.setText("\u786e\u8ba4\u65b0\u5bc6\u7801\uff1a");
            panel3.add(label6);
            label6.setBounds(180, 190, 80, label6.getPreferredSize().height);
            panel3.add(textField4);
            textField4.setBounds(295, 100, 155, textField4.getPreferredSize().height);
            panel3.add(textField5);
            textField5.setBounds(295, 140, 155, textField5.getPreferredSize().height);
            panel3.add(textField6);
            textField6.setBounds(295, 185, 155, textField6.getPreferredSize().height);

            //---- button6 ----
            button6.setText("\u786e\u8ba4\u4fee\u6539");
            button6.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button6MouseClicked(e);
                }
            });
            panel3.add(button6);
            button6.setBounds(295, 255, 155, button6.getPreferredSize().height);
        }
        contentPane.add(panel3);
        panel3.setBounds(0, 0, 700, 400);

        //======== panel4 ========
        {
            panel4.setLayout(null);

            //---- label7 ----
            label7.setText("\u963f\u4e03\u7535\u5b50\u5546\u94fa");
            label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 35f));
            panel4.add(label7);
            label7.setBounds(205, 160, 320, 75);
        }
        contentPane.add(panel4);
        panel4.setBounds(0, 0, 700, 400);

        //======== panel5 ========
        {
            panel5.setLayout(null);

            //======== scrollPane2 ========
            {
                scrollPane2.setViewportView(table2);
            }
            panel5.add(scrollPane2);
            scrollPane2.setBounds(30, 15, 640, 305);

            //---- button7 ----
            button7.setText("\u5237\u65b0");
            button7.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button7MouseClicked(e);
                }
            });
            panel5.add(button7);
            button7.setBounds(new Rectangle(new Point(75, 350), button7.getPreferredSize()));

            //---- button8 ----
            button8.setText("\u5220\u9664\u5546\u54c1");
            button8.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button8MouseClicked(e);
                }
            });
            panel5.add(button8);
            button8.setBounds(new Rectangle(new Point(210, 350), button8.getPreferredSize()));

            //---- button9 ----
            button9.setText("\u6dfb\u52a0\u5546\u54c1");
            button9.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button9MouseClicked(e);
                }
            });
            panel5.add(button9);
            button9.setBounds(new Rectangle(new Point(350, 350), button9.getPreferredSize()));

            //---- button10 ----
            button10.setText("\u4fee\u6539\u5546\u54c1");
            button10.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button10MouseClicked(e);
                }
            });
            panel5.add(button10);
            button10.setBounds(new Rectangle(new Point(510, 350), button10.getPreferredSize()));
        }
        contentPane.add(panel5);
        panel5.setBounds(0, 0, 700, 400);

        //======== panel6 ========
        {
            panel6.setLayout(null);

            //---- label8 ----
            label8.setText("\u5546\u54c1\u53f7\uff1a");
            panel6.add(label8);
            label8.setBounds(new Rectangle(new Point(210, 55), label8.getPreferredSize()));

            //---- label9 ----
            label9.setText("\u5546\u54c1\u540d\uff1a");
            panel6.add(label9);
            label9.setBounds(new Rectangle(new Point(210, 95), label9.getPreferredSize()));

            //---- label10 ----
            label10.setText("\u5e93\u5b58\uff1a");
            panel6.add(label10);
            label10.setBounds(220, 140, 45, label10.getPreferredSize().height);

            //---- label11 ----
            label11.setText("\u5355\u4ef7\uff1a");
            panel6.add(label11);
            label11.setBounds(new Rectangle(new Point(220, 180), label11.getPreferredSize()));
            panel6.add(textField7);
            textField7.setBounds(290, 50, 140, textField7.getPreferredSize().height);
            panel6.add(textField8);
            textField8.setBounds(290, 90, 140, textField8.getPreferredSize().height);
            panel6.add(textField9);
            textField9.setBounds(290, 135, 140, textField9.getPreferredSize().height);
            panel6.add(textField10);
            textField10.setBounds(290, 175, 140, textField10.getPreferredSize().height);

            //---- button11 ----
            button11.setText("\u786e\u8ba4\u6dfb\u52a0");
            button11.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button11MouseClicked(e);
                }
            });
            panel6.add(button11);
            button11.setBounds(295, 225, 135, button11.getPreferredSize().height);
        }
        contentPane.add(panel6);
        panel6.setBounds(0, 0, 700, 400);

        //======== panel7 ========
        {
            panel7.setLayout(null);

            //---- label12 ----
            label12.setText("\u9700\u8981\u4fee\u6539\u7684\u5546\u54c1\u53f7\uff1a");
            panel7.add(label12);
            label12.setBounds(new Rectangle(new Point(130, 45), label12.getPreferredSize()));

            //---- label13 ----
            label13.setText("\u5546\u54c1\u540d\uff1a");
            panel7.add(label13);
            label13.setBounds(new Rectangle(new Point(190, 90), label13.getPreferredSize()));

            //---- label14 ----
            label14.setText("\u5e93\u5b58\uff1a");
            panel7.add(label14);
            label14.setBounds(200, 135, label14.getPreferredSize().width, 25);

            //---- label15 ----
            label15.setText("\u5355\u4ef7\uff1a");
            panel7.add(label15);
            label15.setBounds(200, 185, 45, label15.getPreferredSize().height);
            panel7.add(textField11);
            textField11.setBounds(285, 45, 155, textField11.getPreferredSize().height);
            panel7.add(textField12);
            textField12.setBounds(285, 90, 155, textField12.getPreferredSize().height);
            panel7.add(textField13);
            textField13.setBounds(285, 135, 155, textField13.getPreferredSize().height);
            panel7.add(textField14);
            textField14.setBounds(285, 185, 155, textField14.getPreferredSize().height);

            //---- button12 ----
            button12.setText("\u786e\u8ba4\u4fee\u6539");
            button12.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button12MouseClicked(e);
                }
            });
            panel7.add(button12);
            button12.setBounds(290, 245, 150, button12.getPreferredSize().height);
        }
        contentPane.add(panel7);
        panel7.setBounds(0, 0, 700, 400);

        //======== panel8 ========
        {
            panel8.setLayout(null);

            //---- label17 ----
            label17.setText("\u8f93\u5165\u5e74\u4efd\uff1a");
            panel8.add(label17);
            label17.setBounds(50, 330, label17.getPreferredSize().width, 22);

            //---- label18 ----
            label18.setText("\u8f93\u5165\u6708\u4efd\uff1a");
            panel8.add(label18);
            label18.setBounds(new Rectangle(new Point(195, 335), label18.getPreferredSize()));

            //---- label19 ----
            label19.setText("\u8f93\u5165\u65e5\u671f\uff1a");
            panel8.add(label19);
            label19.setBounds(new Rectangle(new Point(335, 335), label19.getPreferredSize()));
            panel8.add(textField16);
            textField16.setBounds(120, 330, 50, textField16.getPreferredSize().height);
            panel8.add(textField17);
            textField17.setBounds(260, 330, 55, textField17.getPreferredSize().height);
            panel8.add(textField18);
            textField18.setBounds(400, 330, 65, textField18.getPreferredSize().height);

            //======== scrollPane3 ========
            {
                scrollPane3.setViewportView(table3);
            }
            panel8.add(scrollPane3);
            scrollPane3.setBounds(40, 20, 620, 258);

            //---- button13 ----
            button13.setText("\u67e5\u8be2");
            button13.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button13MouseClicked(e);
                }
            });
            panel8.add(button13);
            button13.setBounds(new Rectangle(new Point(510, 330), button13.getPreferredSize()));
        }
        contentPane.add(panel8);
        panel8.setBounds(0, 0, 700, 400);

        //======== panel9 ========
        {
            panel9.setLayout(null);

            //---- button14 ----
            button14.setText("\u67e5\u8be2");
            panel9.add(button14);
            button14.setBounds(new Rectangle(new Point(275, 165), button14.getPreferredSize()));
        }
        contentPane.add(panel9);
        panel9.setBounds(0, 0, 700, 400);

        contentPane.setPreferredSize(new Dimension(700, 460));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(false);
        panel4.setVisible(true);
        panel5.setVisible(false);
        panel6.setVisible(false);
        panel7.setVisible(false);
        panel8.setVisible(false);
        panel9.setVisible(false);
    }

    //删除数据
    public void deleteData(String tableName, String tableID, String ID) {
        Connection conn = null;
        String url = "jdbc:oracle:thin:@120.77.203.216:1521:orcl";
        Statement stmt = null;//SQL语句对象
        String sql = "DELETE FROM " + tableName + " WHERE " + tableID + "=" + ID;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "daming1", "dm1234");
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("删除成功");
        } catch (ClassNotFoundException ee) {
            ee.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //释放资源：数据库连接很昂贵
            try {
                stmt.close();
                conn.close();//关连接
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    //table显示用户
    public Object[][] queryData1() {

        java.util.List<Users> list = new ArrayList<Users>();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@120.77.203.216:1521:orcl";
        Statement stmt = null;//SQL语句对象，拼SQL
        String sql = "SELECT * FROM users ORDER BY userid";
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");//
            conn = DriverManager.getConnection(url, "daming1", "dm1234");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //每循环一次就是一个对象，把这个对象放入容器（List（有序可重复）、Set（无序不可重复）、Map（key、value结构）
                Users user = new Users();
                user.setUserid(rs.getInt("USERID"));
                user.setUsername(rs.getString("USERNAME"));
                user.setPassword(rs.getString("PASSWORD"));
                list.add(user);
            }
        } catch (ClassNotFoundException ee) {
            ee.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //释放资源：数据库连接很昂贵
            try {
                rs.close();
                stmt.close();
                conn.close();//关连接
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        data = new Object[list.size()][head1.length];
        //把集合里的数据放入Obejct这个二维数组
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).getUserid();
            data[i][1] = list.get(i).getUsername();
            data[i][2] = list.get(i).getPassword();
        }
        return data;
    }

    //table显示商品
    public Object[][] queryData2() {

        java.util.List<Products> list = new ArrayList<Products>();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@120.77.203.216:1521:orcl";
        Statement stmt = null;//SQL语句对象，拼SQL
        String sql = "SELECT * FROM products ORDER BY product_id";
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");//
            conn = DriverManager.getConnection(url, "daming1", "dm1234");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //每循环一次就是一个对象，把这个对象放入容器（List（有序可重复）、Set（无序不可重复）、Map（key、value结构）
                Products product = new Products();
                product.setId(rs.getString("product_id"));
                product.setName(rs.getString("product_name"));
                product.setStock(rs.getInt("stock"));
                product.setPrice(rs.getFloat("price"));
                list.add(product);
            }
        } catch (ClassNotFoundException ee) {
            ee.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //释放资源：数据库连接很昂贵
            try {
                rs.close();
                stmt.close();
                conn.close();//关连接
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        data = new Object[list.size()][head2.length];
        //把集合里的数据放入Obejct这个二维数组
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).getId();
            data[i][1] = list.get(i).getName();
            data[i][2] = list.get(i).getStock();
            data[i][3] = list.get(i).getPrice();
        }
        return data;
    }

    //table显示流水
    public Object[][] queryData3(String time, String date) {

        java.util.List<Sales> list = new ArrayList<Sales>();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@120.77.203.216:1521:orcl";
        String sql = "SELECT * \n" +
                "FROM(SELECT product_id id,product_name name,SUM(NVL(amount,0))totalamount,SUM(NVL(total_price,0))totalprice \n" +
                "FROM(SELECT p.product_id,p.product_name,s.amount,s.total_price\n" +
                "FROM products p LEFT JOIN sales s ON p.product_id=s.product_id AND to_char(sale_date,?)=to_char(to_date(?,?),?)) \n" +
                "GROUP BY product_id,product_name) ORDER BY totalprice desc\n";
        PreparedStatement pstmt = null;//SQL语句对象，拼SQL
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");//
            conn = DriverManager.getConnection(url, "daming1", "dm1234");
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, date);
            pstmt.setString(2, time);
            pstmt.setString(3, date);
            pstmt.setString(4, date);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("ccc");
                //每循环一次就是一个对象，把这个对象放入容器（List（有序可重复）、Set（无序不可重复）、Map（key、value结构）
                Sales sales = new Sales();
                sales.setID(rs.getString("ID"));
                sales.setName(rs.getString("NAME"));
                sales.setTotalAmount(rs.getInt("TOTALAMOUNT"));
                sales.setTotalPrice(rs.getFloat("TOTALPRICE"));
                list.add(sales);
            }
        } catch (ClassNotFoundException ee) {
            ee.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //释放资源：数据库连接很昂贵
            try {
                rs.close();
                pstmt.close();
                conn.close();//关连接
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        data = new Object[list.size()][head3.length];
        //把集合里的数据放入Obejct这个二维数组
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).getID();
            data[i][1] = list.get(i).getName();
            data[i][2] = list.get(i).getTotalAmount();
            data[i][3] = list.get(i).getTotalPrice();
        }
        return data;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenu menu4;
    private JMenu menu1;
    private JMenuItem menuItem2;
    private JMenuItem menuItem3;
    private JMenuItem menuItem4;
    private JMenu menu2;
    private JMenuItem menuItem5;
    private JMenuItem menuItem6;
    private JMenuItem menuItem7;
    private JMenu menu3;
    private JMenuItem menuItem8;
    private JMenuItem menuItem9;
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JPanel panel2;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button5;
    private JPanel panel3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton button6;
    private JPanel panel4;
    private JLabel label7;
    private JPanel panel5;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JPanel panel6;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JButton button11;
    private JPanel panel7;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    private JLabel label15;
    private JTextField textField11;
    private JTextField textField12;
    private JTextField textField13;
    private JTextField textField14;
    private JButton button12;
    private JPanel panel8;
    private JLabel label17;
    private JLabel label18;
    private JLabel label19;
    private JTextField textField16;
    private JTextField textField17;
    private JTextField textField18;
    private JScrollPane scrollPane3;
    private JTable table3;
    private JButton button13;
    private JPanel panel9;
    private JButton button14;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private Object[][] data = null;
    private String head1[] = {"ID", "用户名", "密码"};
    private String head2[] = {"商品号", "商品名", "库存", "单价"};
    private String head3[] = {"商品号", "商品名", "数量", "总价"};
}
