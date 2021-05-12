package cn.edu.guet.pay;


import cn.edu.guet.ui.MainFrom;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
/*
 * Created by JFormDesigner on Thu Apr 29 20:37:46 CST 2021
 */


/**
 * @author 1
 */
public class PayForm extends JFrame {

    public PayForm() {

        initComponents();

        setLocationRelativeTo(null);

        setSize(314, 340);//二维码弹窗框体大小

        setResizable(false);

        getContentPane().setLayout(null);

        JPanel panel = new ImagePanel();

        panel.setBounds(0, 0, 400, 350);

        getContentPane().add(panel);

        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                t=1;
            }
        });


    }


    class ImagePanel extends JPanel {
        public void paint(Graphics g) {
            super.paint(g);

            java.util.List<File> qrCodeList = ShowQRCode.getFileSort("D:/QR code");//二维码文件夹
            //System.out.println("最后一个图片的路径：" + qrCodeList.get(qrCodeList.size() - 1).getAbsolutePath());
            ImageIcon icon = new ImageIcon(qrCodeList.get(qrCodeList.size() - 1).getAbsolutePath()/*图片路径*/);
            g.drawImage(icon.getImage(), 0, 0, 300, 300, ImagePanel.this);

        }

    }


    private void frameWindowClosing (ContainerEvent e) {
        t = 1;
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


    public void paying(Double payTotalPrice){
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
                        while(true){
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

                                label1.setVisible(true);

                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                                label1.setVisible(false);
                                setVisible(false);

                                //=========================更新数据库============================
                                MainFrom mf = new MainFrom();
                                mf.UPDATESQL();

                                break;
                            }
                            if(t == 1){

                                //关闭窗口 停止循环
                                break;
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

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    Main main = new Main();
    JLabel label1 = new JLabel();
    JPanel panel1 = new JPanel();
    int  t;
}


