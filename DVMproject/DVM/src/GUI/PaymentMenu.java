package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PaymentMenu extends JFrame implements ActionListener{
	
	private JButton cardpay;
	private JButton smartpay;
	private JButton cancel;
	
	private static int return_value=-1;

	public PaymentMenu(Title title) {
		this.setPreferredSize(new Dimension(600,800));
		this.setTitle("DVM");
		
		//라벨 패널
		JPanel labelpanel = new JPanel();
		labelpanel.setPreferredSize(new Dimension(600,150));
		JLabel label = new JLabel("결제 수단을 선택하세요");
		label.setFont(label.getFont().deriveFont(15.0f));
		labelpanel.add(label);
		
		//결제수단 패널
		JPanel paymentpanel = new JPanel();
		paymentpanel.setPreferredSize(new Dimension(600,350));
		JLabel bev = new JLabel("<html><center>선택한 음료 : <strong>"+title.name+
				"</strong><br>가격 : <strong>"+title.price+ "원</strong></center></html>");
		bev.setPreferredSize(new Dimension(600,50));
		bev.setHorizontalAlignment(JLabel.CENTER);
		bev.setFont(label.getFont().deriveFont(15.0f));
		cardpay = new JButton("카드 결제");
		smartpay = new JButton("간편 결제");
		cardpay.setPreferredSize(new Dimension(270,200));
		smartpay.setPreferredSize(new Dimension(270,200));
		cardpay.addActionListener(this);
		smartpay.addActionListener(this);
		paymentpanel.add(bev,BorderLayout.NORTH);
		paymentpanel.add(cardpay,BorderLayout.WEST);
		paymentpanel.add(smartpay,BorderLayout.EAST);
		
		
		//취소
		JPanel cancelpanel = new JPanel();
		cancelpanel.setPreferredSize(new Dimension(600,200));
		cancel = new JButton("취소");
		cancel.setPreferredSize(new Dimension(300,100));
		cancel.addActionListener(this);
		cancelpanel.add(cancel,BorderLayout.SOUTH);
		
		add(labelpanel,BorderLayout.NORTH);
		add(paymentpanel,BorderLayout.CENTER);
		add(cancelpanel,BorderLayout.SOUTH);
		
		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		Title a= new Title("코카콜라",1,700);
		new PaymentMenu(a);
		

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cardpay) {
			return_value = 1;
			this.setVisible(false);
		}
		if(e.getSource()==smartpay) {
			return_value = 2;
			this.setVisible(false);
		}
		if(e.getSource()==cancel) {
			return_value = 0;
			this.setVisible(false);
		}
	}


}

class Title{
	String name;
	int ID;
	int price;
	Title(String name,int ID,int price){
		this.name=name;
		this.ID =ID;
		this.price=price;
	}

}