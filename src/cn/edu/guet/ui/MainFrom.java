package cn.edu.guet.ui;

import cn.edu.guet.pay.Main;
import cn.edu.guet.pay.PayForm;
import cn.edu.guet.printer.Test;
import cn.edu.guet.util.*;
import javafx.scene.text.Text;
import oracle.jdbc.OracleDriver;

import java.awt.*;
import java.awt.event.*;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        }catch(Exception e) {
//            System.out.println(e);
//        }
        initComponents();
    }

    private void thisWindowClosing(WindowEvent e) {
        int option = JOptionPane.showConfirmDialog(this, "确定退出?", "提示", JOptionPane.YES_NO_OPTION);

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
        if(count!=-1){
            int option = JOptionPane.showConfirmDialog(this, "确定删除?", "提示", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION)
            {
                String userID = String.valueOf(table1.getValueAt(count, 0));//选中行数第一列的数据
                deleteData("USERS", "USERID", userID);//调用自定义的方法，删除数据

                //刷新表1
                DefaultTableModel tableModel = new DefaultTableModel(queryData1(), head1) {
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
                table1.setModel(tableModel);
            }
            else if(option == JOptionPane.NO_OPTION){
                    return;
            }
        }else{
            Error(label12);
            System.out.println("请选中需要删除的用户信息");
        }
    }

    private void button4MouseClicked(MouseEvent e) {
        overallUserId = 0;//全局变量，指用户id，为后边修改用户信息使用
        int count = table1.getSelectedRow();//如果没有选中数据则，count的值为-1
        if (count != -1) {
            overallUserId = (int) table1.getValueAt(count, 0);
            String username = String.valueOf(table1.getValueAt(count, 1));
            String password = String.valueOf(table1.getValueAt(count, 2));
            textField4.setText(username);
            textField5.setText(password);
            textField6.setText(password);

            panel1.setVisible(false);
            panel2.setVisible(false);
            panel3.setVisible(true);
            panel4.setVisible(false);
            panel5.setVisible(false);
            panel6.setVisible(false);
            panel7.setVisible(false);
            panel8.setVisible(false);
            panel9.setVisible(false);
        } else {
            Error(label21);
            System.out.println("请选中需要修改的数据");
        }
    }

    private void button5MouseClicked(MouseEvent e) {
        String userName = textField1.getText();
        String passWord = textField2.getText();
        String confirmPassWord = textField3.getText();

        if (userName.length()!=0) {
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
                                Error(label30);
                                System.out.println("添加成功");
                            } catch (NoSuchAlgorithmException ex) {
                                ex.printStackTrace();
                            } catch (UnsupportedEncodingException ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            try {
                                stmt.executeUpdate("INSERT INTO users values('" + 1 + "','" + userName + "','" + MD5.encoderByMd5(passWord) + "')");
                                Error(label30);
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
                    Error(label29);
                    System.out.println("密码输入不一致");
                }
            } else {
                Error(label22);
                System.out.println("密码不能为空");
            }
        }else{
            Error(label45);
            System.out.println("请输入用户名！！！");
        }
    }

    private void button6MouseClicked(MouseEvent e) {
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

    private void button7MouseClicked(MouseEvent e) {
        String userName = textField4.getText();
        String newPassWord = textField5.getText();
        String confirmNewPassWord = textField6.getText();

        if (newPassWord.length() != 0 && confirmNewPassWord.length() != 0) {
            if (newPassWord.equals(confirmNewPassWord)) {
                Connection conn = null;
                Statement stmt = null;
                try {
                    Class.forName(Driver);
                    conn = DriverManager.getConnection(url, OracleUserName, OraclePassWord);
                    stmt = conn.createStatement();
                    stmt.executeUpdate("UPDATE users set username='" + userName + "', password='" + MD5.encoderByMd5(newPassWord) + "' WHERE userid='"+overallUserId+"'" );
                    Error(label33);
                    System.out.println("修改成功");
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
                    } catch (SQLException ee) {
                        ee.printStackTrace();
                    }
                }
            } else {
                Error(label32);
                System.out.println("密码错误");
            }
        } else {
            Error(label31);
            System.out.println("密码不能为空");
        }
    }

    private void button8MouseClicked(MouseEvent e) {
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

    private void button9MouseClicked(MouseEvent e) {
        DefaultTableModel tableModel = new DefaultTableModel(queryData2(), head2) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table2.setModel(tableModel);
    }

    private void button10MouseClicked(MouseEvent e) {
        int count = table2.getSelectedRow();//获取选中行数,未选中则count为-1
        if (count!=-1){
            int option = JOptionPane.showConfirmDialog(this, "确定删除?", "提示", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION)
            {
                String product_id = (String) table2.getValueAt(count, 0);//获取选中行的第一个数据
                deleteData("PRODUCTS", "product_id", product_id);//调用自定义的删除数据的方法

                //刷新表2
                DefaultTableModel tableModel = new DefaultTableModel(queryData2(), head2) {
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
                table2.setModel(tableModel);
            } else if(option == JOptionPane.NO_OPTION){
                return;
            }
        }else{
            Error(label34);
            System.out.println("请选中需要删除的数据");
        }
    }

    private void button11MouseClicked(MouseEvent e) {
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

    private void button12MouseClicked(MouseEvent e) {
        overallProductId = "";//全局变量，指商品id，为后边修改商品信息使用
        int count = table2.getSelectedRow();
        if (count!=-1){
            overallProductId = (String) table2.getValueAt(count,0);
            String product_name = String.valueOf(table2.getValueAt(count,1));
            int stock = (int) table2.getValueAt(count,2);
            float price = (float) table2.getValueAt(count,3);
            textField12.setText(product_name);//将商品信息显示在新界面的这几个文本框内
            textField13.setText(String.valueOf(stock));
            textField14.setText(String.valueOf(price));

            panel1.setVisible(false);
            panel2.setVisible(false);
            panel3.setVisible(false);
            panel4.setVisible(false);
            panel5.setVisible(false);
            panel6.setVisible(false);
            panel7.setVisible(true);
            panel8.setVisible(false);
            panel9.setVisible(false);
        }else{
            Error(label35);
            System.out.println("请选中需要修改的数据");
        }
    }

    private void button13MouseClicked(MouseEvent e) {
        String product_id = textField7.getText();
        String product_name = textField8.getText();
        String stock = textField9.getText();
        String price = textField10.getText();
        if (product_id.length() != 0 ) {
            if ( product_name.length() != 0 ) {
                if ( stock.length() != 0 ) {
                    if ( price.length() != 0) {
                        //int stock = Integer.valueOf(st);
                        //float price = Float.valueOf(pr);
                        Connection conn = null;
                        PreparedStatement pstmt = null;
                        try {
                            Class.forName(Driver);
                            conn = DriverManager.getConnection(url, OracleUserName, OraclePassWord);
                            pstmt = conn.prepareStatement("INSERT INTO products VALUES(?,?,?,?)");
                            pstmt.setString(1, product_id);
                            pstmt.setString(2, product_name);
                            pstmt.setString(3, stock);
                            pstmt.setString(4, price);
                            pstmt.executeUpdate();
                            Error(label37);
                            System.out.println("添加成功");
                        } catch (ClassNotFoundException ee) {
                            ee.printStackTrace();
                        } catch (SQLIntegrityConstraintViolationException ee) {
                            Error(label38);
                            System.out.println("该商品号已存在");
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
                    }else{
                        Error(label51);
                        System.out.println("请输入商品单价");
                    }
                }else{
                    Error(label50);
                    System.out.println("请输入库存数量");
                }
            }else{
                Error(label26);
                System.out.println("请输入商品名称");
            }
        } else {
            Error(label36);
            System.out.println("请输入商品号");
        }
    }

    private void button14MouseClicked(MouseEvent e) {
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

    private void button15MouseClicked(MouseEvent e) {
        String product_name = textField12.getText();
        String stock = textField13.getText();
        String price = textField14.getText();

        if(product_name.length()!=0&&stock.length()!=0&&price.length()!=0) {//判断输入的数据都不为空
            Connection conn = null;
            Statement stmt = null;
            try {
                Class.forName(Driver);
                conn = DriverManager.getConnection(url, OracleUserName, OraclePassWord);
                stmt = conn.createStatement();
                stmt.executeUpdate("UPDATE products SET product_name='" + product_name + "' ,stock='" + stock + "' , price='" + price + "' WHERE product_id='" + overallProductId + "'");
                Error(label40);
                System.out.println("修改成功");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    conn.close();
                    stmt.close();
                } catch (SQLException ee) {
                    ee.printStackTrace();
                }
            }
        }else{
            Error(label39);
            System.out.println("请输入商品信息");
        }
    }

    private void button16MouseClicked(MouseEvent e) {
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

    private void button17MouseClicked(MouseEvent e) {//按年月日查询流水
        String time = null;
        String date = null;
        int year = (int)comboBoxYear.getSelectedItem();
        int month = (int)comboBoxMonth.getSelectedItem();
        int day = (int)comboBoxDay.getSelectedItem();
        if (year!= 0 && month == 0 && day == 0) {//输入年份
            time = String.valueOf(year);
            date = "yyyy";
        } else if (year != 0 && month!= 0 && day == 0) {//输入年份、月份
            time = year + "/" + month;
            date = "yyyy-mm";
        } else if (year != 0 && month!= 0 && day != 0) {//输入年月日
            time = year + "/" + month + "/" + day;
            date = "yyyy-mm-dd";
        } else {
            System.out.println("请输入日期,由年月日的顺序");
        }
        DefaultTableModel tableModel = new DefaultTableModel(queryData3(time, date), head3) {//queryData3参数列表为获取输入时间time和时间格式date
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table3.setModel(tableModel);
    }

    private void button18MouseClicked(MouseEvent e) {
        String username = LoginFrom.getUserName();//获取当前登录的用户名，用于查询其用户ID
        String product_id = textField18.getText();//获取商品ID
        String amounts = textField19.getText();//获取购买商品数量

        if (product_id.length()!=0&&amounts.length()!=0) {
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            try {
                Class.forName(Driver);
                conn = DriverManager.getConnection(url, OracleUserName, OraclePassWord);
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT * FROM products WHERE product_id='" + product_id + "'");//根据输入的商品ID查询该商品是否存在
                if (rs.next()) {
                    rs = stmt.executeQuery("SELECT userid FROM users WHERE username='" + username + "'");//根据当前用户名查询此用户ID
                    if (rs.next()) {
                        int userid = rs.getInt("userid");
                        rs = stmt.executeQuery("SELECT * FROM products WHERE product_id='" + product_id + "' AND stock>='" + amounts + "'");//根据输入的商品数量查询该商品数量是否充足
                        int amount = Integer.parseInt(amounts);
                        if (rs.next()) {
                            Order order = new Order();
                            order.setUserID(userid);
                            order.setProductID(rs.getString("product_id"));
                            order.setProductName(rs.getString("product_name"));
                            order.setAmount(amount);
                            order.setPrice(rs.getFloat("price"));
                            order.setTotalPrice(amount * rs.getFloat("price"));
                            list.add(order);//将Order对象加入List对象

                            //显示table4内容
                            DefaultTableModel tableModel = new DefaultTableModel(queryData4(list), head4) {
                                public boolean isCellEditable(int row, int column) {
                                    return false;
                                }
                            };
                            table4.setModel(tableModel);

                            Error(label42);
                            System.out.println("添加成功");
                        } else {
                            Error(label41);
                            System.out.println("商品库存不足");
                        }
                    }
                } else {
                    System.out.println("商品号输入错误");
                    Error(label27);//调用方法进行错误提示
                }
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {

            } finally {
                try {
                    conn.close();
                    stmt.close();
                    rs.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }else{
            Error(label47);
            System.out.println("请输入商品和数量！！！");
        }
    }

    private void button19MouseClicked(MouseEvent e) {
        frame1.setVisible(true);
        textArea2.setText("" + payTotalPrice + "");
    }

    private void button20MouseClicked(MouseEvent e) {
        int count = table4.getSelectedRow();
        if(count!=-1){
            list.remove(count);

            //刷新表4
            DefaultTableModel tableModel = new DefaultTableModel(queryData4(list), head4) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            table4.setModel(tableModel);
        }else{
            Error(label46);
            System.out.println("请选中需要删除的商品");
        }

    }

    private void button21MouseClicked(MouseEvent e) {
        list.removeAll(list);//从列表list中删除与list列表相同的元素

        //刷新表4
        DefaultTableModel tableModel = new DefaultTableModel(queryData4(list), head4) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table4.setModel(tableModel);
    }

    private void button22MouseClicked(MouseEvent e) {
        //java.util.Date date = new java.util.Date();//定义日期
        String Actualpayments = textField20.getText();

        if (Actualpayments.length()!=0) {//确保输入付款金额
            float ActualPayment = Float.parseFloat(Actualpayments);
            if (ActualPayment >= payTotalPrice) {
                textArea3.setText("" + (ActualPayment - payTotalPrice) + "");

                Test.priter1(ActualPayment);
               UPDATESQL();//向数据库插入订单信息
            } else {
                Error(label43);
                System.out.println("付款余额不足，无法支付");
            }
        }else{
            Error(label48);
            System.out.println("请输入付款金额");
        }
    }

    private void button23MouseClicked(MouseEvent e) {
        //二维码支付
        new PayForm(1).paying(payTotalPrice);
        //UPDATESQL();//更新数据库信息：将临时订单信息存入数据库
    }

    private void button24MouseClicked(MouseEvent e) {
        //扫码支付
        new PayForm(2).paying2(payTotalPrice);
    }

    public void comboBoxMonthItemStateChanged(ItemEvent e) {
        Object obj = comboBoxMonth.getSelectedItem();// 取得选中月份
        if (obj != null) {
            comboBoxDay.removeAllItems();//清空日的下拉列表框
            int month = Integer.valueOf(obj.toString());
            int days = 32;
            if (month == 4 || month == 6 || month == 9 || month == 11) {
                days = 31;
            } else if (month == 2) {//取得选中年份
                int year = Integer.parseInt(comboBoxYear.getSelectedItem().toString());
                if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {//是闰年
                    days = 30;
                } else {//不是闰年
                    days = 29;
                }
            }
            for (int j = 0; j < days; j++) {
                comboBoxDay.addItem(j);
            }
        }
    }

    private void menu5MousePressed(MouseEvent e) {
        this.setVisible(false);
        new LoginFrom();
    }

    private void initComponents() {

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menu4 = new JMenu();
        menu1 = new JMenu();
        menuItem2 = new JMenuItem();
        menuItem3 = new JMenuItem();
        menu2 = new JMenu();
        menuItem5 = new JMenuItem();
        menuItem6 = new JMenuItem();
        menu3 = new JMenu();
        menuItem8 = new JMenuItem();
        menuItem9 = new JMenuItem();
        menu5 = new JMenu();
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        label12 = new JLabel();
        label21 = new JLabel();
        label49 = new JLabel();
        panel2 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        button5 = new JButton();
        button6 = new JButton();
        label22 = new JLabel();
        label29 = new JLabel();
        label30 = new JLabel();
        label45 = new JLabel();
        panel3 = new JPanel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        textField4 = new JTextField();
        textField5 = new JTextField();
        textField6 = new JTextField();
        button7 = new JButton();
        button8 = new JButton();
        label31 = new JLabel();
        label32 = new JLabel();
        label33 = new JLabel();
        panel4 = new JPanel();
        label7 = new JLabel();
        panel5 = new JPanel();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        button9 = new JButton();
        button10 = new JButton();
        button11 = new JButton();
        button12 = new JButton();
        label34 = new JLabel();
        label35 = new JLabel();
        panel6 = new JPanel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        textField7 = new JTextField();
        textField8 = new JTextField();
        textField9 = new JTextField();
        textField10 = new JTextField();
        button13 = new JButton();
        button14 = new JButton();
        label36 = new JLabel();
        label37 = new JLabel();
        label38 = new JLabel();
        label26 = new JLabel();
        label50 = new JLabel();
        label51 = new JLabel();
        panel7 = new JPanel();
        label13 = new JLabel();
        label14 = new JLabel();
        label15 = new JLabel();
        textField12 = new JTextField();
        textField13 = new JTextField();
        textField14 = new JTextField();
        button15 = new JButton();
        button16 = new JButton();
        label39 = new JLabel();
        label40 = new JLabel();
        panel8 = new JPanel();
        label16 = new JLabel();
        label17 = new JLabel();
        label18 = new JLabel();
        scrollPane3 = new JScrollPane();
        table3 = new JTable();
        button17 = new JButton();
        label28 = new JLabel();
        comboBoxYear = new JComboBox();
        comboBoxMonth = new JComboBox();
        comboBoxDay = new JComboBox();
        panel9 = new JPanel();
        label19 = new JLabel();
        button18 = new JButton();
        label20 = new JLabel();
        button19 = new JButton();
        scrollPane4 = new JScrollPane();
        table4 = new JTable();
        textField18 = new JTextField();
        textField19 = new JTextField();
        button20 = new JButton();
        button21 = new JButton();
        label27 = new JLabel();
        label41 = new JLabel();
        label42 = new JLabel();
        label46 = new JLabel();
        label47 = new JLabel();
        frame1 = new JFrame();
        label23 = new JLabel();
        label24 = new JLabel();
        label25 = new JLabel();
        scrollPane6 = new JScrollPane();
        textArea2 = new JTextArea();
        textField20 = new JTextField();
        scrollPane7 = new JScrollPane();
        textArea3 = new JTextArea();
        button22 = new JButton();
        button23 = new JButton();
        button24 = new JButton();
        label43 = new JLabel();
        label44 = new JLabel();
        label48 = new JLabel();

        //======== this ========
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
        });
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
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("\u9500\u552e\u7ba1\u7406");

                //---- menuItem8 ----
                menuItem8.setText("\u9500\u552e\u5546\u54c1");
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

            //======== menu5 ========
            {
                menu5.setText("\u9000\u51fa\u5f53\u524d\u7528\u6237");
                menu5.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        menu5MousePressed(e);
                    }
                });
            }
            menuBar1.add(menu5);
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
            scrollPane1.setBounds(35, 35, 630, 235);

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
            button2.setBounds(new Rectangle(new Point(380, 305), button2.getPreferredSize()));

            //---- button3 ----
            button3.setText("\u5220\u9664\u7528\u6237");
            button3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button3MouseClicked(e);
                }
            });
            panel1.add(button3);
            button3.setBounds(new Rectangle(new Point(230, 305), button3.getPreferredSize()));

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

            //---- label12 ----
            label12.setText("\u8bf7\u9009\u4e2d\u9700\u8981\u5220\u9664\u7684\u7528\u6237\u4fe1\u606f");
            label12.setForeground(Color.red);
            label12.setFont(label12.getFont().deriveFont(label12.getFont().getSize() + 2f));
            panel1.add(label12);
            label12.setBounds(new Rectangle(new Point(255, 0), label12.getPreferredSize()));

            //---- label21 ----
            label21.setText("\u8bf7\u9009\u4e2d\u9700\u8981\u4fee\u6539\u7684\u6570\u636e");
            label21.setForeground(Color.red);
            label21.setFont(label21.getFont().deriveFont(label21.getFont().getSize() + 2f));
            panel1.add(label21);
            label21.setBounds(new Rectangle(new Point(260, 0), label21.getPreferredSize()));

            //---- label49 ----
            label49.setText("\u5220\u9664\u6210\u529f");
            label49.setForeground(Color.red);
            label49.setFont(label49.getFont().deriveFont(label49.getFont().getSize() + 2f));
            panel1.add(label49);
            label49.setBounds(new Rectangle(new Point(315, 0), label49.getPreferredSize()));
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

            //---- button6 ----
            button6.setText("\u67e5\u770b\u7528\u6237");
            button6.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button6MouseClicked(e);
                }
            });
            panel2.add(button6);
            button6.setBounds(290, 315, 145, 25);

            //---- label22 ----
            label22.setText("\u5bc6\u7801\u4e0d\u80fd\u4e3a\u7a7a");
            label22.setForeground(Color.red);
            label22.setFont(label22.getFont().deriveFont(label22.getFont().getSize() + 2f));
            panel2.add(label22);
            label22.setBounds(new Rectangle(new Point(320, 0), label22.getPreferredSize()));

            //---- label29 ----
            label29.setText("\u5bc6\u7801\u8f93\u5165\u4e0d\u4e00\u81f4");
            label29.setForeground(Color.red);
            label29.setFont(label29.getFont().deriveFont(label29.getFont().getSize() + 2f));
            panel2.add(label29);
            label29.setBounds(new Rectangle(new Point(310, 0), label29.getPreferredSize()));

            //---- label30 ----
            label30.setText("\u6dfb\u52a0\u6210\u529f");
            label30.setForeground(Color.red);
            label30.setFont(label30.getFont().deriveFont(label30.getFont().getSize() + 2f));
            panel2.add(label30);
            label30.setBounds(new Rectangle(new Point(330, 0), label30.getPreferredSize()));

            //---- label45 ----
            label45.setText("\u8bf7\u8f93\u5165\u7528\u6237\u540d");
            label45.setForeground(Color.red);
            label45.setFont(label45.getFont().deriveFont(label45.getFont().getSize() + 2f));
            panel2.add(label45);
            label45.setBounds(new Rectangle(new Point(320, 0), label45.getPreferredSize()));
        }
        contentPane.add(panel2);
        panel2.setBounds(0, 0, 700, 400);

        //======== panel3 ========
        {
            panel3.setLayout(null);

            //---- label4 ----
            label4.setText("\u7528\u6237\u540d\uff1a");
            panel3.add(label4);
            label4.setBounds(210, 100, label4.getPreferredSize().width, 25);

            //---- label5 ----
            label5.setText("\u5bc6\u7801\uff1a");
            panel3.add(label5);
            label5.setBounds(220, 145, 40, label5.getPreferredSize().height);

            //---- label6 ----
            label6.setText("\u786e\u8ba4\u65b0\u5bc6\u7801\uff1a");
            panel3.add(label6);
            label6.setBounds(185, 190, 80, label6.getPreferredSize().height);
            panel3.add(textField4);
            textField4.setBounds(285, 100, 155, textField4.getPreferredSize().height);
            panel3.add(textField5);
            textField5.setBounds(285, 140, 155, textField5.getPreferredSize().height);
            panel3.add(textField6);
            textField6.setBounds(285, 185, 155, textField6.getPreferredSize().height);

            //---- button7 ----
            button7.setText("\u786e\u8ba4\u4fee\u6539");
            button7.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button7MouseClicked(e);
                }
            });
            panel3.add(button7);
            button7.setBounds(285, 240, 155, button7.getPreferredSize().height);

            //---- button8 ----
            button8.setText("\u67e5\u770b\u7528\u6237");
            button8.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button8MouseClicked(e);
                }
            });
            panel3.add(button8);
            button8.setBounds(285, 295, 155, button8.getPreferredSize().height);

            //---- label31 ----
            label31.setText("\u5bc6\u7801\u4e0d\u80fd\u4e3a\u7a7a");
            label31.setForeground(Color.red);
            label31.setFont(label31.getFont().deriveFont(label31.getFont().getSize() + 2f));
            panel3.add(label31);
            label31.setBounds(new Rectangle(new Point(320, 0), label31.getPreferredSize()));

            //---- label32 ----
            label32.setText("\u5bc6\u7801\u9519\u8bef");
            label32.setForeground(Color.red);
            label32.setFont(label32.getFont().deriveFont(label32.getFont().getSize() + 2f));
            panel3.add(label32);
            label32.setBounds(new Rectangle(new Point(320, 0), label32.getPreferredSize()));

            //---- label33 ----
            label33.setText("\u4fee\u6539\u6210\u529f");
            label33.setForeground(Color.red);
            label33.setFont(label33.getFont().deriveFont(label33.getFont().getSize() + 2f));
            panel3.add(label33);
            label33.setBounds(new Rectangle(new Point(320, 0), label33.getPreferredSize()));
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
            scrollPane2.setBounds(30, 35, 640, 305);

            //---- button9 ----
            button9.setText("\u5237\u65b0");
            button9.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button9MouseClicked(e);
                }
            });
            panel5.add(button9);
            button9.setBounds(new Rectangle(new Point(75, 350), button9.getPreferredSize()));

            //---- button10 ----
            button10.setText("\u5220\u9664\u5546\u54c1");
            button10.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button10MouseClicked(e);
                }
            });
            panel5.add(button10);
            button10.setBounds(new Rectangle(new Point(210, 350), button10.getPreferredSize()));

            //---- button11 ----
            button11.setText("\u6dfb\u52a0\u5546\u54c1");
            button11.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button11MouseClicked(e);
                }
            });
            panel5.add(button11);
            button11.setBounds(new Rectangle(new Point(350, 350), button11.getPreferredSize()));

            //---- button12 ----
            button12.setText("\u4fee\u6539\u5546\u54c1");
            button12.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button12MouseClicked(e);
                }
            });
            panel5.add(button12);
            button12.setBounds(new Rectangle(new Point(510, 350), button12.getPreferredSize()));

            //---- label34 ----
            label34.setText("\u8bf7\u9009\u4e2d\u9700\u8981\u5220\u9664\u7684\u6570\u636e");
            label34.setForeground(Color.red);
            label34.setFont(label34.getFont().deriveFont(label34.getFont().getSize() + 2f));
            panel5.add(label34);
            label34.setBounds(new Rectangle(new Point(255, 0), label34.getPreferredSize()));

            //---- label35 ----
            label35.setText("\u8bf7\u9009\u4e2d\u9700\u8981\u4fee\u6539\u7684\u6570\u636e");
            label35.setForeground(Color.red);
            label35.setFont(label35.getFont().deriveFont(label35.getFont().getSize() + 2f));
            panel5.add(label35);
            label35.setBounds(new Rectangle(new Point(255, 0), label35.getPreferredSize()));
        }
        contentPane.add(panel5);
        panel5.setBounds(0, 0, 700, 400);

        //======== panel6 ========
        {
            panel6.setLayout(null);

            //---- label8 ----
            label8.setText("\u5546\u54c1\u53f7\uff1a");
            panel6.add(label8);
            label8.setBounds(new Rectangle(new Point(205, 75), label8.getPreferredSize()));

            //---- label9 ----
            label9.setText("\u5546\u54c1\u540d\uff1a");
            panel6.add(label9);
            label9.setBounds(new Rectangle(new Point(205, 115), label9.getPreferredSize()));

            //---- label10 ----
            label10.setText("\u5e93\u5b58\uff1a");
            panel6.add(label10);
            label10.setBounds(215, 160, 40, label10.getPreferredSize().height);

            //---- label11 ----
            label11.setText("\u5355\u4ef7\uff1a");
            panel6.add(label11);
            label11.setBounds(new Rectangle(new Point(215, 205), label11.getPreferredSize()));
            panel6.add(textField7);
            textField7.setBounds(280, 70, 140, textField7.getPreferredSize().height);
            panel6.add(textField8);
            textField8.setBounds(280, 115, 140, textField8.getPreferredSize().height);
            panel6.add(textField9);
            textField9.setBounds(280, 160, 140, textField9.getPreferredSize().height);
            panel6.add(textField10);
            textField10.setBounds(280, 205, 140, textField10.getPreferredSize().height);

            //---- button13 ----
            button13.setText("\u786e\u8ba4\u6dfb\u52a0");
            button13.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button13MouseClicked(e);
                }
            });
            panel6.add(button13);
            button13.setBounds(280, 250, 140, button13.getPreferredSize().height);

            //---- button14 ----
            button14.setText("\u67e5\u770b\u5546\u54c1");
            button14.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button14MouseClicked(e);
                }
            });
            panel6.add(button14);
            button14.setBounds(280, 295, 140, button14.getPreferredSize().height);

            //---- label36 ----
            label36.setText("\u8bf7\u8f93\u5165\u5546\u54c1\u53f7");
            label36.setForeground(Color.red);
            label36.setFont(label36.getFont().deriveFont(label36.getFont().getSize() + 2f));
            panel6.add(label36);
            label36.setBounds(new Rectangle(new Point(305, 0), label36.getPreferredSize()));

            //---- label37 ----
            label37.setText("\u6dfb\u52a0\u6210\u529f");
            label37.setForeground(Color.red);
            label37.setFont(label37.getFont().deriveFont(label37.getFont().getSize() + 2f));
            panel6.add(label37);
            label37.setBounds(new Rectangle(new Point(315, 0), label37.getPreferredSize()));

            //---- label38 ----
            label38.setText("\u8be5\u5546\u54c1\u53f7\u5df2\u5b58\u5728");
            label38.setForeground(Color.red);
            label38.setFont(label38.getFont().deriveFont(label38.getFont().getSize() + 2f));
            panel6.add(label38);
            label38.setBounds(new Rectangle(new Point(300, 0), label38.getPreferredSize()));

            //---- label26 ----
            label26.setText("\u8bf7\u8f93\u5165\u5546\u54c1\u540d\u79f0");
            label26.setForeground(Color.red);
            label26.setFont(label26.getFont().deriveFont(label26.getFont().getSize() + 2f));
            panel6.add(label26);
            label26.setBounds(new Rectangle(new Point(295, 0), label26.getPreferredSize()));

            //---- label50 ----
            label50.setText("\u8bf7\u8f93\u5165\u5e93\u5b58\u6570\u91cf");
            label50.setForeground(Color.red);
            label50.setFont(label50.getFont().deriveFont(label50.getFont().getSize() + 2f));
            panel6.add(label50);
            label50.setBounds(new Rectangle(new Point(300, 0), label50.getPreferredSize()));

            //---- label51 ----
            label51.setText("\u8bf7\u8f93\u5165\u5546\u54c1\u5355\u4ef7");
            label51.setForeground(Color.red);
            label51.setFont(label51.getFont().deriveFont(label51.getFont().getSize() + 2f));
            panel6.add(label51);
            label51.setBounds(new Rectangle(new Point(295, 0), label51.getPreferredSize()));
        }
        contentPane.add(panel6);
        panel6.setBounds(0, 0, 700, 400);

        //======== panel7 ========
        {
            panel7.setLayout(null);

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
            panel7.add(textField12);
            textField12.setBounds(285, 90, 155, textField12.getPreferredSize().height);
            panel7.add(textField13);
            textField13.setBounds(285, 135, 155, textField13.getPreferredSize().height);
            panel7.add(textField14);
            textField14.setBounds(285, 185, 155, textField14.getPreferredSize().height);

            //---- button15 ----
            button15.setText("\u786e\u8ba4\u4fee\u6539");
            button15.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button15MouseClicked(e);
                }
            });
            panel7.add(button15);
            button15.setBounds(285, 245, 155, button15.getPreferredSize().height);

            //---- button16 ----
            button16.setText("\u67e5\u770b\u5546\u54c1");
            button16.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button16MouseClicked(e);
                }
            });
            panel7.add(button16);
            button16.setBounds(285, 300, 155, button16.getPreferredSize().height);

            //---- label39 ----
            label39.setText("\u8bf7\u8f93\u5165\u5546\u54c1\u4fe1\u606f");
            label39.setForeground(Color.red);
            label39.setFont(label39.getFont().deriveFont(label39.getFont().getSize() + 2f));
            panel7.add(label39);
            label39.setBounds(new Rectangle(new Point(300, 0), label39.getPreferredSize()));

            //---- label40 ----
            label40.setText("\u4fee\u6539\u6210\u529f");
            label40.setForeground(Color.red);
            label40.setFont(label40.getFont().deriveFont(label40.getFont().getSize() + 2f));
            panel7.add(label40);
            label40.setBounds(new Rectangle(new Point(325, 0), label40.getPreferredSize()));
        }
        contentPane.add(panel7);
        panel7.setBounds(0, 0, 700, 400);

        //======== panel8 ========
        {
            panel8.setLayout(null);

            //---- label16 ----
            label16.setText("\u5e74");
            panel8.add(label16);
            label16.setBounds(190, 330, 25, 22);

            //---- label17 ----
            label17.setText("\u6708");
            panel8.add(label17);
            label17.setBounds(330, 335, 20, 17);

            //---- label18 ----
            label18.setText("\u65e5");
            panel8.add(label18);
            label18.setBounds(new Rectangle(new Point(460, 335), label18.getPreferredSize()));

            //======== scrollPane3 ========
            {
                scrollPane3.setViewportView(table3);
            }
            panel8.add(scrollPane3);
            scrollPane3.setBounds(40, 20, 620, 258);

            //---- button17 ----
            button17.setText("\u67e5\u8be2");
            button17.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button17MouseClicked(e);
                }
            });
            panel8.add(button17);
            button17.setBounds(new Rectangle(new Point(510, 330), button17.getPreferredSize()));

            //---- label28 ----
            label28.setText("\u9500\u552e\u989d:");
            label28.setFont(label28.getFont().deriveFont(Font.ITALIC, label28.getFont().getSize() + 3f));
            panel8.add(label28);
            label28.setBounds(265, 290, 155, label28.getPreferredSize().height);
            panel8.add(comboBoxYear);
            comboBoxYear.setBounds(90, 330, 90, comboBoxYear.getPreferredSize().height);

            //---- comboBoxMonth ----
            comboBoxMonth.addItemListener(e -> comboBoxMonthItemStateChanged(e));
            panel8.add(comboBoxMonth);
            comboBoxMonth.setBounds(230, 330, 90, comboBoxMonth.getPreferredSize().height);
            panel8.add(comboBoxDay);
            comboBoxDay.setBounds(360, 330, 90, comboBoxDay.getPreferredSize().height);
        }
        contentPane.add(panel8);
        panel8.setBounds(0, 0, 700, 400);

        //======== panel9 ========
        {
            panel9.setLayout(null);

            //---- label19 ----
            label19.setText("\u5546\u54c1\u53f7\uff1a");
            panel9.add(label19);
            label19.setBounds(40, 50, 60, 20);

            //---- button18 ----
            button18.setText("\u6dfb\u52a0\u8d2d\u7269\u8f66");
            button18.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button18MouseClicked(e);
                }
            });
            panel9.add(button18);
            button18.setBounds(new Rectangle(new Point(380, 50), button18.getPreferredSize()));

            //---- label20 ----
            label20.setText("\u6570\u91cf\uff1a");
            panel9.add(label20);
            label20.setBounds(210, 50, 40, 22);

            //---- button19 ----
            button19.setText("\u7ed3\u8d26");
            button19.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button19MouseClicked(e);
                }
            });
            panel9.add(button19);
            button19.setBounds(505, 50, 85, button19.getPreferredSize().height);

            //======== scrollPane4 ========
            {
                scrollPane4.setViewportView(table4);
            }
            panel9.add(scrollPane4);
            scrollPane4.setBounds(35, 90, 635, 260);
            panel9.add(textField18);
            textField18.setBounds(105, 50, 84, textField18.getPreferredSize().height);
            panel9.add(textField19);
            textField19.setBounds(260, 50, 80, textField19.getPreferredSize().height);

            //---- button20 ----
            button20.setText("\u5220\u9664\u5546\u54c1");
            button20.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button20MouseClicked(e);
                }
            });
            panel9.add(button20);
            button20.setBounds(new Rectangle(new Point(220, 360), button20.getPreferredSize()));

            //---- button21 ----
            button21.setText("\u6e05\u7a7a\u8d2d\u7269\u8f66");
            button21.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button21MouseClicked(e);
                }
            });
            panel9.add(button21);
            button21.setBounds(new Rectangle(new Point(385, 360), button21.getPreferredSize()));

            //---- label27 ----
            label27.setText("\u5546\u54c1\u53f7\u8f93\u5165\u9519\u8bef");
            label27.setForeground(Color.red);
            label27.setFont(label27.getFont().deriveFont(label27.getFont().getSize() + 2f));
            panel9.add(label27);
            label27.setBounds(250, 0, 115, 17);

            //---- label41 ----
            label41.setText("\u5546\u54c1\u5e93\u5b58\u4e0d\u8db3");
            label41.setForeground(Color.red);
            label41.setFont(label41.getFont().deriveFont(label41.getFont().getSize() + 2f));
            panel9.add(label41);
            label41.setBounds(new Rectangle(new Point(260, 0), label41.getPreferredSize()));

            //---- label42 ----
            label42.setText("\u6dfb\u52a0\u6210\u529f");
            label42.setForeground(Color.red);
            label42.setFont(label42.getFont().deriveFont(label42.getFont().getSize() + 2f));
            panel9.add(label42);
            label42.setBounds(new Rectangle(new Point(285, 0), label42.getPreferredSize()));

            //---- label46 ----
            label46.setText("\u8bf7\u9009\u4e2d\u9700\u8981\u5220\u9664\u7684\u5546\u54c1");
            label46.setForeground(Color.red);
            label46.setFont(label46.getFont().deriveFont(label46.getFont().getSize() + 2f));
            panel9.add(label46);
            label46.setBounds(new Rectangle(new Point(230, 0), label46.getPreferredSize()));

            //---- label47 ----
            label47.setText("\u8bf7\u8f93\u5165\u5546\u54c1\u548c\u6570\u91cf");
            label47.setForeground(Color.red);
            label47.setFont(label47.getFont().deriveFont(label47.getFont().getSize() + 2f));
            panel9.add(label47);
            label47.setBounds(new Rectangle(new Point(260, 0), label47.getPreferredSize()));
        }
        contentPane.add(panel9);
        panel9.setBounds(0, 0, 700, 400);

        contentPane.setPreferredSize(new Dimension(700, 460));
        pack();
        setLocationRelativeTo(getOwner());

        //======== frame1 ========
        {
            Container frame1ContentPane = frame1.getContentPane();
            frame1ContentPane.setLayout(null);

            //---- label23 ----
            label23.setText("\u603b\u4ef7\uff1a");
            frame1ContentPane.add(label23);
            label23.setBounds(135, 50, 45, label23.getPreferredSize().height);

            //---- label24 ----
            label24.setText("\u5b9e\u4ed8\uff1a");
            frame1ContentPane.add(label24);
            label24.setBounds(135, 95, 45, 25);

            //---- label25 ----
            label25.setText("\u627e\u96f6\uff1a");
            frame1ContentPane.add(label25);
            label25.setBounds(135, 135, 45, 20);

            //======== scrollPane6 ========
            {
                scrollPane6.setViewportView(textArea2);
            }
            frame1ContentPane.add(scrollPane6);
            scrollPane6.setBounds(205, 50, 165, scrollPane6.getPreferredSize().height);
            frame1ContentPane.add(textField20);
            textField20.setBounds(205, 95, 165, textField20.getPreferredSize().height);

            //======== scrollPane7 ========
            {
                scrollPane7.setViewportView(textArea3);
            }
            frame1ContentPane.add(scrollPane7);
            scrollPane7.setBounds(205, 135, 165, scrollPane7.getPreferredSize().height);

            //---- button22 ----
            button22.setText("\u73b0\u91d1\u652f\u4ed8");
            button22.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button22MouseClicked(e);
                }
            });
            frame1ContentPane.add(button22);
            button22.setBounds(new Rectangle(new Point(135, 215), button22.getPreferredSize()));

            //---- button23 ----
            button23.setText("\u4ed8\u6b3e\u7801");
            button23.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button23MouseClicked(e);
                }
            });
            frame1ContentPane.add(button23);
            button23.setBounds(new Rectangle(new Point(245, 215), button23.getPreferredSize()));

            //---- button24 ----
            button24.setText("\u6761\u5f62\u7801");
            button24.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button24MouseClicked(e);
                }
            });
            frame1ContentPane.add(button24);
            button24.setBounds(new Rectangle(new Point(350, 215), button24.getPreferredSize()));

            //---- label43 ----
            label43.setText("\u4ed8\u6b3e\u4f59\u989d\u4e0d\u8db3\uff0c\u65e0\u6cd5\u652f\u4ed8");
            label43.setForeground(Color.red);
            label43.setFont(label43.getFont().deriveFont(label43.getFont().getSize() + 2f));
            frame1ContentPane.add(label43);
            label43.setBounds(new Rectangle(new Point(205, 0), label43.getPreferredSize()));

            //---- label44 ----
            label44.setText("\u652f\u4ed8\u6210\u529f,\u6570\u636e\u5df2\u5b58\u5165\u6570\u636e\u5e93");
            label44.setForeground(Color.red);
            label44.setFont(label44.getFont().deriveFont(label44.getFont().getSize() + 2f));
            frame1ContentPane.add(label44);
            label44.setBounds(new Rectangle(new Point(205, 0), label44.getPreferredSize()));

            //---- label48 ----
            label48.setText("\u8bf7\u8f93\u5165\u4ed8\u6b3e\u91d1\u989d");
            label48.setForeground(Color.red);
            label48.setFont(label48.getFont().deriveFont(label48.getFont().getSize() + 2f));
            frame1ContentPane.add(label48);
            label48.setBounds(new Rectangle(new Point(235, 0), label48.getPreferredSize()));

            frame1ContentPane.setPreferredSize(new Dimension(520, 330));
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        AddDate();//调用此函数给下拉框输入日期

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(false);
        panel4.setVisible(true);
        panel5.setVisible(false);
        panel6.setVisible(false);
        panel7.setVisible(false);
        panel8.setVisible(false);
        panel9.setVisible(false);

        //错误提示
        label27.setVisible(false);
        label12.setVisible(false);
        label21.setVisible(false);
        label22.setVisible(false);
        label26.setVisible(false);
        label29.setVisible(false);
        label30.setVisible(false);
        label31.setVisible(false);
        label32.setVisible(false);
        label33.setVisible(false);
        label34.setVisible(false);
        label35.setVisible(false);
        label36.setVisible(false);
        label37.setVisible(false);
        label38.setVisible(false);
        label39.setVisible(false);
        label40.setVisible(false);
        label41.setVisible(false);
        label42.setVisible(false);
        label43.setVisible(false);
        label44.setVisible(false);
        label45.setVisible(false);
        label46.setVisible(false);
        label47.setVisible(false);
        label48.setVisible(false);
        label49.setVisible(false);
        label50.setVisible(false);
        label51.setVisible(false);
    }

    //删除数据
    public void deleteData(String tableName, String tableID, String ID) {
        Connection conn = null;
        Statement stmt = null;//SQL语句对象
        String sql = "DELETE FROM " + tableName + " WHERE " + tableID + "=" + ID;
        try {
            Class.forName(Driver);
            conn = DriverManager.getConnection(url, OracleUserName, OraclePassWord);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            Error(label49);
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
        Statement stmt = null;//SQL语句对象，拼SQL
        String sql = "SELECT * FROM users ORDER BY userid";
        ResultSet rs = null;
        try {
            Class.forName(Driver);//
            conn = DriverManager.getConnection(url, OracleUserName, OraclePassWord);
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
        Statement stmt = null;//SQL语句对象，拼SQL
        String sql = "SELECT * FROM products ORDER BY product_id";
        ResultSet rs = null;
        try {
            Class.forName(Driver);//
            conn = DriverManager.getConnection(url, OracleUserName, OraclePassWord);
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
        double sum = new Double(0);

        java.util.List<Sales> list = new ArrayList<Sales>();
        Connection conn = null;
        String sql = "SELECT * \n" +
                "FROM(SELECT product_id id,product_name name,SUM(NVL(amount,0))totalamount,SUM(NVL(total_price,0))totalprice \n" +
                "FROM(SELECT p.product_id,p.product_name,s.amount,s.total_price\n" +
                "FROM products p LEFT JOIN sales s ON p.product_id=s.product_id AND to_char(sale_date,?)=to_char(to_date(?,?),?)) \n" +
                "GROUP BY product_id,product_name) ORDER BY totalprice desc\n";
        PreparedStatement pstmt = null;//SQL语句对象，拼SQL
        ResultSet rs = null;
        try {
            Class.forName(Driver);
            conn = DriverManager.getConnection(url, OracleUserName, OraclePassWord);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, date);
            pstmt.setString(2, time);
            pstmt.setString(3, date);
            pstmt.setString(4, date);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                //每循环一次就是一个对象，把这个对象放入容器（List（有序可重复）、Set（无序不可重复）、Map（key、value结构）
                Sales sales = new Sales();
                sales.setID(rs.getString("ID"));
                sales.setName(rs.getString("NAME"));
                sales.setTotalAmount(rs.getInt("TOTALAMOUNT"));
                sales.setTotalPrice(rs.getFloat("TOTALPRICE"));
                sum += rs.getFloat("TOTALPRICE");
                list.add(sales);
            }
            label28.setText("销售额为" + sum + "元");
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

    //显示购物清单
    public Object[][] queryData4(List<Order> list) {
        payTotalPrice = 0;//初始化订单总价
        data = new Object[list.size()][head4.length];
        //把集合里的数据放入Obejct这个二维数组
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).getUserID();
            data[i][1] = list.get(i).getProductID();
            data[i][2] = list.get(i).getProductName();
            data[i][3] = list.get(i).getAmount();
            data[i][4] = list.get(i).getPrice();
            data[i][5] = list.get(i).getTotalPrice();
            payTotalPrice += list.get(i).getTotalPrice();//统计订单总价
        }
        return data;
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

    //显示日期
    private void AddDate() {
        for (int i = STARTYEAR; i < ENDYEAR; i++) {//年下拉选择框
            comboBoxYear.addItem(i);
        }
        for (int i = 0; i <= 12; i++) {//月下拉选择框
            comboBoxMonth.addItem(i);
        }
        for (int j = 0; j <= 31; j++) { //日下拉选择框
            comboBoxDay.addItem(j);
        }
    }

    //向数据库插入订单信息
    public void UPDATESQL() {
        java.util.Date date = new java.util.Date();//定义日期
        Connection conn = null;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        String sql = "";
        try {
            Class.forName(Driver);
            conn = DriverManager.getConnection(url, OracleUserName, OraclePassWord);
            stmt = conn.createStatement();
            pstmt = conn.prepareStatement("INSERT INTO sales values(?,?,?,?,?,?,?)");
            for (int i = 0; i < list.size(); i++) {
                pstmt.setInt(1, list.get(i).getUserID());//获取用户ID
                pstmt.setString(2, list.get(i).getProductID());//获取商品ID
                pstmt.setString(3, list.get(i).getProductName());//获取商品名称
                pstmt.setInt(4, list.get(i).getAmount());//获取商品数量
                pstmt.setFloat(5, list.get(i).getPrice());//获取商品单价
                pstmt.setFloat(6, list.get(i).getTotalPrice());//获取此商品购物总价
                pstmt.setDate(7, new java.sql.Date(date.getTime()));//获取当前日期
                pstmt.executeUpdate();//执行插入数据SQL
                stmt.executeUpdate("UPDATE products set stock=stock-'" + list.get(i).getAmount() + "' where product_id='" + list.get(i).getProductID() + "'");
            }
            Error(label44);
            System.out.println("支付成功,数据已存入数据库");
        } catch (ClassNotFoundException ee) {
            ee.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //释放资源：数据库连接很昂贵
            try {
                pstmt.close();
                stmt.close();
                conn.close();//关连接
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenu menu4;
    private JMenu menu1;
    private JMenuItem menuItem2;
    private JMenuItem menuItem3;
    private JMenu menu2;
    private JMenuItem menuItem5;
    private JMenuItem menuItem6;
    private JMenu menu3;
    private JMenuItem menuItem8;
    private JMenuItem menuItem9;
    private JMenu menu5;
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JLabel label12;
    private JLabel label21;
    private JLabel label49;
    private JPanel panel2;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button5;
    private JButton button6;
    private JLabel label22;
    private JLabel label29;
    private JLabel label30;
    private JLabel label45;
    private JPanel panel3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton button7;
    private JButton button8;
    private JLabel label31;
    private JLabel label32;
    private JLabel label33;
    private JPanel panel4;
    private JLabel label7;
    private JPanel panel5;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JButton button9;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JLabel label34;
    private JLabel label35;
    private JPanel panel6;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JButton button13;
    private JButton button14;
    private JLabel label36;
    private JLabel label37;
    private JLabel label38;
    private JLabel label26;
    private JLabel label50;
    private JLabel label51;
    private JPanel panel7;
    private JLabel label13;
    private JLabel label14;
    private JLabel label15;
    private JTextField textField12;
    private JTextField textField13;
    private JTextField textField14;
    private JButton button15;
    private JButton button16;
    private JLabel label39;
    private JLabel label40;
    private JPanel panel8;
    private JLabel label16;
    private JLabel label17;
    private JLabel label18;
    private JScrollPane scrollPane3;
    private JTable table3;
    private JButton button17;
    private JLabel label28;
    private JComboBox comboBoxYear;
    private JComboBox comboBoxMonth;
    private JComboBox comboBoxDay;
    private JPanel panel9;
    private JLabel label19;
    private JButton button18;
    private JLabel label20;
    private JButton button19;
    private JScrollPane scrollPane4;
    private JTable table4;
    private JTextField textField18;
    private JTextField textField19;
    private JButton button20;
    private JButton button21;
    private JLabel label27;
    private JLabel label41;
    private JLabel label42;
    private JLabel label46;
    private JLabel label47;
    private JFrame frame1;
    private JLabel label23;
    private JLabel label24;
    private JLabel label25;
    private JScrollPane scrollPane6;
    private JTextArea textArea2;
    private JTextField textField20;
    private JScrollPane scrollPane7;
    private JTextArea textArea3;
    private JButton button22;
    private JButton button23;
    private JButton button24;
    private JLabel label43;
    private JLabel label44;
    private JLabel label48;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    //JDBC相关
    private String Driver = "oracle.jdbc.driver.OracleDriver";//驱动
    private String url = "jdbc:oracle:thin:@120.77.203.216:1521:orcl";//Oracle的URL
    private String OracleUserName = "daming1";//数据库用户名
    private String OraclePassWord = "dm1234";//数据库密码

    //变量
    private final int STARTYEAR = 2020;//年份的开始值
    private final int ENDYEAR = 2100;//年份的结束值
    public static double payTotalPrice;//订单的总价
    private static int overallUserId;
    private static String overallProductId;
    public  static java.util.List<Order> list = new ArrayList<Order>();//定义一个存储Order类的List集合

    //显示table相关
    private Object[][] data = null;
    private String head1[] = {"ID", "用户名", "密码"};
    private String head2[] = {"商品号", "商品名", "库存", "单价"};
    private String head3[] = {"商品号", "商品名", "数量", "总价"};
    private String head4[] = {"用户ID", "商品ID", "商品名称", "数量", "单价", "总价"};
}

