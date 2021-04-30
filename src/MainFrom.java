import java.awt.*;
import javax.swing.*;
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
        label1 = new JLabel();

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
                menu1.add(menuItem2);

                //---- menuItem3 ----
                menuItem3.setText("\u6dfb\u52a0\u7528\u6237");
                menu1.add(menuItem3);

                //---- menuItem4 ----
                menuItem4.setText("\u4fee\u6539\u5bc6\u7801");
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

        //---- label1 ----
        label1.setText("asas ");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(330, -60), label1.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(625, 440));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
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
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
