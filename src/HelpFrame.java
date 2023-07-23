import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpFrame extends JFrame implements ActionListener {
    JLabel label = new JLabel("<html>This is a simple word game called STOP.<br>"
            + "Your objective is to type in each box words that begin with the random picked letter.<br>"
            + "Each box is a category (Name, Country, Fruit, Animal, and Color)<br>"
            + "If you guess it correctly you get 10 points. There will be a total of 5 rounds.<br>"
            + "To enter the values press the next round button, it will generate a new letter and enter all the answers in the<br>"
            + " current row you are.<br>"
            + "Make sure you fill all the words you know before clicking the next round button<br>"
            + "...there's no way back...<br>"
            + "GOOD LUCK :)</html>");
    JPanel panel = new JPanel();
    JButton backButton = new JButton("Main Menu");

    HelpFrame(){
        label.setFont(new Font("Verdana",Font.PLAIN, 15));
        label.setForeground(Color.black);
        label.setBounds(0, 0, 480, 140);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.TOP);
        label.setVerticalTextPosition(SwingConstants.TOP);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(480, 340));
        panel.setPreferredSize(new Dimension(500,295));
        panel.setBackground(Color.white);
        panel.setLayout(new FlowLayout());
        panel.add(label);
        backButton.setPreferredSize(new Dimension(160,80));
        backButton.addActionListener(this);
        this.add(panel);
        this.add(backButton);
        this.getContentPane().setBackground(Color.blue);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Help");
        this.setLayout(new FlowLayout());
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            this.dispose();
            new Main_Menu();
        }
    }
}
