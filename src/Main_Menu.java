
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Menu extends JFrame implements ActionListener {
    JLabel label = new JLabel();
    JButton playButton = new JButton("Play Game");
    JButton helpButton = new JButton("Help");
    JButton exitButton = new JButton("Exit");
    JButton scoresButton = new JButton("Player's Scores");

    Main_Menu() {
        playButton.setBounds(620,100,200,120);
        scoresButton.setBounds(620,300,200,120);
        helpButton.setBounds(620,500,200,120);
        exitButton.setBounds(620,700,200,120);
        playButton.addActionListener(this);
        scoresButton.addActionListener(this);
        helpButton.addActionListener(this);
        exitButton.addActionListener(this);
        this.add(playButton);
        this.add(scoresButton);
        this.add(helpButton);
        this.add(exitButton);
        this.add(label);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.yellow);
        this.setResizable(false);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("STOP");
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            this.dispose();
            new LaunchGame();
        }
        if (e.getSource() == helpButton) {
            this.dispose();
            new HelpFrame();
        }
        if (e.getSource() == exitButton) {
            System.exit(0);
        }
        if(e.getSource()==scoresButton){
            this.dispose();
            new ScoresFrame();
        }
    }
}
