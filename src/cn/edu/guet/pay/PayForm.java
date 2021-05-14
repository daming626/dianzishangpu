package cn.edu.guet.pay;


import cn.edu.guet.printer.Test;
import cn.edu.guet.ui.MainFrom;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
/*
 * Created by JFormDesigner on Thu Apr 29 20:37:46 CST 2021
 */


/**
 * @author 1
 */
public class PayForm extends JFrame {
    public PayForm(int paymentWay) {
        initComponents();
        setTitle("\u652f\u4ed8");
        setLocationRelativeTo(null);
        setSize(355, 375);//二维码弹窗框体大小
        setResizable(false);
        getContentPane().setLayout(null);

        this.setVisible(true);
        if (paymentWay == 1) {
            JPanel panel = new ImagePanel();

            panel.setBounds(0, 0, 400, 350);

            getContentPane().add(panel);
        }

        if (paymentWay == 2) {
            aaa();
        }
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                t = 1;
            }
        });
    }

    class ImagePanel extends JPanel {
        public void paint(Graphics g) {
            super.paint(g);
            java.util.List<File> qrCodeList = ShowQRCode.getFileSort(Main.QRcodepath);//二维码文件夹
            //System.out.println("最后一个图片的路径：" + qrCodeList.get(qrCodeList.size() - 1).getAbsolutePath());
            ImageIcon icon = new ImageIcon(qrCodeList.get(qrCodeList.size() - 1).getAbsolutePath()/*图片路径*/);
            g.drawImage(icon.getImage(), 0, 0, 300, 300, ImagePanel.this);
        }
    }

    public void aaa() {

        Container contentPane1 = getContentPane();
        contentPane1.setLayout(null);

        panel2 = new JPanel();
        panel2.setLayout(null);

        jTextField1 = new JTextField();
        label1 = new JLabel();

        label1.setText("\u626b\u7801\u652f\u4ed8\uff0c\u8bf7\u8ba9\u5ba2\u6237\u51fa\u793a\u6761\u5f62\u7801");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));
        label1.setBounds(30, 70, label1.getPreferredSize().width, label1.getPreferredSize().height);

        jTextField1.setBounds(100, 130, 150, 50);
        jTextField1.setBorder(new EmptyBorder(0, 0, 0, 0));
        jTextField1.setBackground(getBackground());
        jTextField1.setForeground(getBackground());
        jTextField1.setCaretColor(getBackground());
        panel2.setBounds(0, 0, 400, 350);
        panel2.add(label1,BorderLayout.CENTER);
        panel2.add(jTextField1);

        jTextField1.getText();
        jTextField1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1ActionListener(e);
            }
        });

        contentPane1.add(panel2);

        label1.setVisible(true);
        jTextField1.setVisible(true);
    }

    private void frameWindowClosing(ContainerEvent e) {
        t = 1;
    }

    private void jTextField1ActionListener(ActionEvent e) {

        String authCode = jTextField1.getText();
        System.out.println(jTextField1.getText());

        main.test_trade(payTotalPrice,authCode);
        Thread t1 = new Thread(
            new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        main.test_trade_query(main.outTradeNo);
                        if (Main.flag == 1) {

                            //==============显示支付成功=====================
                            Container contentPane1 = getContentPane();
                            contentPane1.setLayout(null);

                            panel1 = new JPanel();
                            panel1.setLayout(null);

                            label1 = new JLabel();

                            label1.setText("\u652f\u4ed8\u6210\u529f\uff01");
                            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));
                            label1.setBounds(100, 130, 150, label1.getPreferredSize().height);
                            panel1.add(label1);
                            contentPane1.add(panel1);
                            panel1.setBounds(0, 0, 400, 350);

                            label1.setVisible(true);//显示支付成功

                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            label1.setVisible(false);
                            setVisible(false);//显示支付成功的弹窗关闭
                            MainFrom.frame1.setVisible(false);

                            //打印小票
                            Test.priter2();
                            //=========================更新数据库============================
                            MainFrom.UPDATESQL();
                            //清空list(购物车)
                            MainFrom.list.removeAll(MainFrom.list);

                            break;
                        }
                       // break;
                    }
                }
            }
        );
        t1.start();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        contentPane.setPreferredSize(new Dimension(400, 350));
        pack();
        setLocationRelativeTo(getOwner());

        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }



    public void paying(Double payTotalPrice) {
        Thread t1 = new Thread(
            new Runnable() {
                @Override
                public void run() {
                    main.test_trade_precreate(payTotalPrice);
                    System.out.println("1234");
                }
            }
        );
        Thread t2 = new Thread(
            new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        main.test_trade_query(main.outTradeNo);
                        if (Main.flag == 1) {

                            //==============显示支付成功=====================
                            Container contentPane1 = getContentPane();
                            contentPane1.setLayout(null);

                            panel1 = new JPanel();
                            panel1.setLayout(null);

                            label1 = new JLabel();

                            label1.setText("\u652f\u4ed8\u6210\u529f\uff01");
                            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));
                            label1.setBounds(100, 130, 150, label1.getPreferredSize().height);
                            panel1.add(label1);
                            contentPane1.add(panel1);
                            panel1.setBounds(0, 0, 400, 350);

                            label1.setVisible(true);//显示支付成功

                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            label1.setVisible(false);
                            setVisible(false);//显示支付成功的弹窗关闭
                            MainFrom.frame1.setVisible(false);

                            //打印小票
                            Test.priter2();
                            //=========================更新数据库============================
                            MainFrom.UPDATESQL();
                            //清空list
                            MainFrom.list.removeAll(MainFrom.list);

                            break;
                        }
                        if (t == 1) {
                            break; //关闭窗口 停止循环
                        }
                    }
                }
            }
        );

        t1.start();
        try {
            t1.join();//必须等t1执行完毕
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        t2.start();
    }

    public void paying2(Double payTotalPrice) {

        this.payTotalPrice = payTotalPrice;
        System.out.println("1234");

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    Main main = new Main();
    JLabel label1 = new JLabel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    public static String authCode = "";
    JTextField jTextField1 = new JTextField();
    public static Double payTotalPrice;
    int t;
}


