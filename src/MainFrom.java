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

    private void button1MouseClicked(MouseEvent e) {
        DefaultTableModel tableModel = new DefaultTableModel(queryData(), head) {
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
    }

    private void button3MouseClicked(MouseEvent e) {
        int count=table1.getSelectedRow();//选中的行数
        int userid= (int) table1.getValueAt(count,0);//选中行数第一列的数据
        System.out.println(userid);

        Connection conn=null;
        String url="jdbc:oracle:thin:@120.77.203.216:1521:orcl";
        Statement stmt=null;//SQL语句对象
        String sql="DELETE FROM users WHERE userid="+userid;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");//
            conn= DriverManager.getConnection(url,"daming1","dm1234");
            stmt=conn.createStatement();
            stmt.executeUpdate(sql);//a=1
            System.out.println("删除成功");
        } catch (ClassNotFoundException ee) {
            ee.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            //释放资源：数据库连接很昂贵
            try {
                stmt.close();
                conn.close();//关连接
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    private void button4MouseClicked(MouseEvent e) {
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(true);
        panel4.setVisible(false);
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
                    rs = stmt.executeQuery("SELECT * FROM users WHERE rownum=1 ORDER BY userid DESC");
                    if (rs.next()) {
                        int ID = rs.getInt("userid");
                        ID++;
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
        String userName=textField4.getText();
        String newPassWord=textField5.getText();
        String confirmNewPassWord=textField6.getText();

        Connection conn=null;
        String url="jdbc:oracle:thin:@120.77.203.216:1521:orcl";
        Statement stmt=null;
        ResultSet rs=null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn= DriverManager.getConnection(url,"daming1","dm1234");
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT * FROM USERS WHERE USERNAME='"+userName+"'");
            if(rs.next()){
                if(newPassWord.length()!=0&&confirmNewPassWord.length()!=0) {
                    if (newPassWord.equals(confirmNewPassWord)) {
                        stmt.executeUpdate("UPDATE users set password='" + MD5.encoderByMd5(newPassWord) + "' WHERE username='" + userName + "'");
                        System.out.println("修改成功");
                    } else {
                        System.out.println("用户名或密码错误");
                    }
                }else{
                    System.out.println("密码不能为空");
                }
            }else{
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
        } finally{
            try {
                conn.close();
                stmt.close();
                rs.close();
            } catch (SQLException ee) {
                ee.printStackTrace();
            }
        }
    }

    private void menuItem2MousePressed(MouseEvent e) {
        panel1.setVisible(true);
        panel2.setVisible(false);
        panel3.setVisible(false);
        panel4.setVisible(false);
        DefaultTableModel tableModel = new DefaultTableModel(queryData(), head) {
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
    }

    private void menuItem4MousePressed(MouseEvent e) {
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(true);
        panel4.setVisible(false);
    }

    private void button1MousePressed(MouseEvent e) {
        DefaultTableModel tableModel = new DefaultTableModel(queryData(), head) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setModel(tableModel);
    }

    private void initComponents() {

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
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

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

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
                menu2.setText("\u5546\u54c1\u7ba1\u7406");

                //---- menuItem5 ----
                menuItem5.setText("\u67e5\u770b\u5546\u54c1");
                menu2.add(menuItem5);

                //---- menuItem6 ----
                menuItem6.setText("\u6dfb\u52a0\u5546\u54c1");
                menu2.add(menuItem6);

                //---- menuItem7 ----
                menuItem7.setText("\u4fee\u6539\u5546\u54c1");
                menu2.add(menuItem7);
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("\u9500\u552e\u7ba1\u7406");

                //---- menuItem8 ----
                menuItem8.setText("\u9500\u552e\u754c\u9762");
                menu3.add(menuItem8);

                //---- menuItem9 ----
                menuItem9.setText("\u67e5\u770b\u5229\u6da6");
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
        panel2.setBounds(0, 0, 700, 385);

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
    }

    //显示用户
    public Object[][] queryData() {

        java.util.List<Users> list=new ArrayList<Users>();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@120.77.203.216:1521:orcl";
        Statement stmt = null;//SQL语句对象，拼SQL
        String sql = "SELECT * FROM users";
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");//
            conn = DriverManager.getConnection(url, "daming1", "dm1234");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //每循环一次就是一个对象，把这个对象放入容器（List（有序可重复）、Set（无序不可重复）、Map（key、value结构）
                Users user=new Users();
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
        data = new Object[list.size()][head.length];
        //把集合里的数据放入Obejct这个二维数组
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < head.length; j++) {
                data[i][0] = list.get(i).getUserid();
                data[i][1] = list.get(i).getUsername();
                data[i][2] = list.get(i).getPassword();
            }
        }
        return data;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private Object[][] data = null;
    private String head[] = {"id", "username", "password"};
}
