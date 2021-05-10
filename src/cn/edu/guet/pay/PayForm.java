package cn.edu.guet.pay;



import java.awt.*;
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

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setSize(314, 340);//二维码弹窗框体大小

        setResizable(false);

        getContentPane().setLayout(null);

        JPanel panel = new ImagePanel();

        panel.setBounds(0, 0, 500, 500);

        getContentPane().add(panel);

        setVisible(true);
    }


    class ImagePanel extends JPanel {
        public void paint(Graphics g) {
            super.paint(g);

            Thread t1 = new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            //按时间顺序显示D盘下的所有png的图片
                            //在t1线程中把最后一个图片路径拿到，然后作为参数传入
                            java.util.List<File> qrCodeList = ShowQRCode.getFileSort("D:/QR code");//二维码文件夹
                            System.out.println("最后一个图片的路径：" + qrCodeList.get(qrCodeList.size() - 1).getAbsolutePath());
                            ImageIcon icon = new ImageIcon(qrCodeList.get(qrCodeList.size() - 1).getAbsolutePath()/*图片路径*/);
                            g.drawImage(icon.getImage(),0,0,300,300,ImagePanel.this);

                        }
                    }
            );
            Thread t2 = new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            //等待二维码生成后，才能调用下面的类去显示二维码
                            PayForm.this.setVisible(true);
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

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}


