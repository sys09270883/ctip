package GUI;

import Logic.Title;
import Logic.DVM;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;

public class ManTitleMenu extends JFrame implements ActionListener {

    private Timer timer = new Timer(180000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            timer.stop();
            return_value = -2;
        }
    });

    private JButton[] Title_list;
    private JButton exit;
    private ArrayList<Title> temp;
    private int return_value = -1;

    public ManTitleMenu(ArrayList<Title> tlist) {
        timer.start();
        temp = tlist;

        this.setPreferredSize(new Dimension(600, 800));
        this.setTitle("DVM " + DVM.getCurrentID());

        //라벨 패널
        JPanel labelpanel = new JPanel();
        labelpanel.setPreferredSize(new Dimension(600, 30));
        JLabel label = new JLabel("재고를 변경할 음료를 선택하세요");
        label.setFont(label.getFont().deriveFont(15.0f));
        labelpanel.add(label);

        //타이틀 패널
        JPanel titlelistpanel = new JPanel(new GridLayout(tlist.size(), 1));
        JScrollPane titlepanel = new JScrollPane(titlelistpanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        titlepanel.getVerticalScrollBar().setUnitIncrement(8);
        titlelistpanel.setPreferredSize(new Dimension(600, 70 * tlist.size()));
        Title_list = new JButton[tlist.size()];
        for (int i = 0; i < tlist.size(); i++) {
            Title_list[i] = new JButton(
                    "<html><center><strong>" + tlist.get(i).getName() + "</strong><br>재고수량 : " +
                            tlist.get(i).getItem_List().size() + "</center></html>");
            Title_list[i].addActionListener(this);
            titlelistpanel.add(Title_list[i]);
        }

        //취소패널
        JPanel exitpanel = new JPanel();
        exit = new JButton("나가기");
        exit.setPreferredSize(new Dimension(600, 70));
        exit.addActionListener(this);
        exitpanel.add(exit, BorderLayout.SOUTH);

        add(labelpanel, BorderLayout.NORTH);
        add(titlepanel, BorderLayout.CENTER);
        add(exitpanel, BorderLayout.SOUTH);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < temp.size(); i++) {
            if (e.getSource() == Title_list[i]) {
                timer.stop();
                return_value = i + 1;
            }
        }
        if (e.getSource() == exit) {
            timer.stop();
            return_value = 0;
            this.setVisible(false);
        }
    }

    public int getReturn_value() { return return_value; }

    public void setReturn_value(int return_value) { this.return_value = return_value; }

}

