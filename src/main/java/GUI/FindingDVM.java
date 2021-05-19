package GUI;

import Logic.DVM;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FindingDVM extends JFrame implements ActionListener {
    
    private int s = 32;
    private Timer timer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (s <= 3) {
                label.setText("남은 시간: 0");
                infolabel.setText("<html><center>자판기를 찾는 것에 실패하였습니다<br>"
                        + s + "초 후 메인화면으로 돌아갑니다.</center></html>");
                if (s == 0) {
                    return_value = 0;
                    timer.stop();
                }
            } else {
                label.setText("남은 시간: " + (s - 3));
            }
            s--;
        }
    });

    private JLabel label;
    private JLabel infolabel;
    private JButton cancel;
    private int return_value = -1;

    public FindingDVM(String name) {
        timer.start();

        this.setPreferredSize(new Dimension(600, 800));
        this.setTitle("DVM " + DVM.getCurrentID());

        //라벨패널
        JPanel labelpanel = new JPanel();
        labelpanel.setPreferredSize(new Dimension(600, 300));
        label = new JLabel("남은시간:20");
        label.setFont(label.getFont().deriveFont(15.0f));
        labelpanel.add(label);
        
        //안내패널
        JPanel informpanel = new JPanel();
        infolabel = new JLabel("<html><center><strong>" + name + "</strong>"
                + "<br>해당 음료가 있는 자판기를 검색중입니다.</center></html>");
        infolabel.setFont(infolabel.getFont().deriveFont(20.0f));
        informpanel.add(infolabel);
        
        //버튼패널
        JPanel buttonpanel = new JPanel();
        cancel = new JButton("취소");
        cancel.setPreferredSize(new Dimension(300, 70));
        cancel.addActionListener(this);
        buttonpanel.add(cancel);

        add(labelpanel, BorderLayout.NORTH);
        add(informpanel, BorderLayout.CENTER);
        add(buttonpanel, BorderLayout.SOUTH);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel) {
            timer.stop();
            return_value = 0;
        }
    }

    public int getReturn_value() {return return_value; }

    public void setReturn_value(int return_value) { this.return_value = return_value; }
}
