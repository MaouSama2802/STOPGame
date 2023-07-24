import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpFrame extends JFrame implements ActionListener {
    JLabel label = new JLabel("<html>This is a simple "
            + "word game called STOP.<br>"
            + "Your objective is to type in each box words <br>"
            + "that begin with the random picked letter.<br>"
            + "Each box is a category <br>"
            + "(Name, Country, Fruit, Animal, and Color)<br>"
            + "If you guess it correctly you get 10 points. <br>"
            + "There's also a timer, if you don't get your word<br>"
            + "in less than 30 seconds you won't get any points<br>"
            + "and you won't be able to edit any field of that<br>"
            + "round, you click next round to restart the timer<br>"
            + "and be able to place the next round's words.<br>"
            + "There will be a total of 5 rounds.<br>"
            + "To enter the values press the next round button,<br>"
            + " it will generate a new letter and enter <br>"
            + "all the answers in the current row you are.<br>"
            + "Make sure you fill all the words you know<br>"
            + " before clicking the next round button<br>"
            + "...there's no way back...<br>"
            + "GOOD LUCK :)</html>");
    JPanel panel = new JPanel();
    JButton backButton = new JButton("Main Menu");
    Border border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED,Color.BLACK,Color.blue);

    HelpFrame(){
        label.setFont(new Font("Verdana",Font.PLAIN, 20));
        label.setForeground(Color.black);
        label.setBounds(460,60,530,520);
        panel.setBounds(460,60,530,520);
        panel.setBackground(Color.white);
        panel.add(label);
        panel.setBorder(border);
        backButton.setBounds(620,620,200,120);
        backButton.addActionListener(this);
        backButton.setOpaque(true);
        backButton.setBackground(Color.white);
        backButton.setBorder(border);
        this.setLayout(null);
        this.add(panel);
        this.add(backButton);
        this.getContentPane().setBackground(Color.blue);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Help");
        this.setResizable(false);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
