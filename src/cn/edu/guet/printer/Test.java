package cn.edu.guet.printer;

import cn.edu.guet.pay.Main;
import cn.edu.guet.ui.LoginFrom;
import cn.edu.guet.ui.MainFrom;

import java.util.*;

/**
 * 打印机的执行入口
 * 若使用则到
 * MainFrom的button22MouseClicked(MouseEvent e)取消Test.priter1(ActualPayment)注释
 * PayForm的jTextField1ActionListener(ActionEvent e)取消Test.priter2()注释
 * payFrom的paying(Double payTotalPrice)取消Test.priter2()注释
 */
public class Test {
	static String name = "";
	static String price = "";
	static String amount = "";
	static String totalPrice = "";

    public static void priter1(float ActualPayment) {//现金支付打印打印小票
        List<Goods> goods = new ArrayList<Goods>();
		String payTotalPrice = String.valueOf(MainFrom.payTotalPrice);//所有购物商品总价
		String actualPayment = String.valueOf(ActualPayment);//实付款
		String giveChange = String.valueOf(ActualPayment-MainFrom.payTotalPrice);//找零

        for (int i = 0; i < MainFrom.list.size(); i++) {
        	name = MainFrom.list.get(i).getProductName();
			System.out.println(name);
        	price = String.valueOf(MainFrom.list.get(i).getPrice());
            amount = String.valueOf(MainFrom.list.get(i).getAmount());
            totalPrice = String.valueOf(MainFrom.list.get(i).getTotalPrice());
            goods.add(new Goods(name, price, amount, totalPrice, ""));
        }
		int size = goods.size();
		String s = Integer.toString(size);
		Date date = new Date();
		SalesTicket stk = new SalesTicket(goods, LoginFrom.getUserName(), Main.outTradeNo, s, payTotalPrice, actualPayment, giveChange,date);
		Printer p = new Printer(stk);
		p.printer();
    }

	public static void priter2() {//二维码，条形码支付打印小票
		List<Goods> goods = new ArrayList<Goods>();
		String payTotalPrice = String.valueOf(MainFrom.payTotalPrice);
		for (int i = 0; i < MainFrom.list.size(); i++) {
			name = MainFrom.list.get(i).getProductName();
			price = String.valueOf(MainFrom.list.get(i).getPrice());
			amount = String.valueOf(MainFrom.list.get(i).getAmount());
			totalPrice = String.valueOf(MainFrom.list.get(i).getTotalPrice());
			goods.add(new Goods(name, price, amount, totalPrice, ""));
		}
		int size = goods.size();
		String s = Integer.toString(size);
		Date date = new Date();
		SalesTicket stk = new SalesTicket(goods, LoginFrom.getUserName(), Main.outTradeNo, s, payTotalPrice, payTotalPrice, "0",date);
		Printer p = new Printer(stk);
		p.printer();
	}
}