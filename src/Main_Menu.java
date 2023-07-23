/*import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Menu extends JFrame implements ActionListener {
    JLabel label = new JLabel();
    Timer timer;
    int xVel=10;
    int yVel=10;
    int x=0;
    int y=0;
    JPanel panel = new JPanel();
    JButton playButton = new JButton("Play Game");
    JButton helpButton = new JButton("Help");
    JButton exitButton = new JButton("Exit");
    Image stopImage = new ImageIcon("stop.jpeg").getImage();
    Image stopResized = stopImage.getScaledInstance(100,100,Image.SCALE_SMOOTH);
    Image scaled = new ImageIcon(stopResized).getImage();

    Main_Menu(){
        timer = new Timer(1000,this);
        timer.start();
        panel.setBounds(0,0,500,500);
        playButton.setBounds(160,80,160,80);
        helpButton.setBounds(160,180,160,80);
        exitButton.setBounds(160,280,160,80);
        playButton.addActionListener(this);
        helpButton.addActionListener(this);
        exitButton.addActionListener(this);
        this.add(playButton);
        this.add(helpButton);
        this.add(exitButton);
        this.add(label);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.yellow);
        this.setSize(500,500);
        this.setTitle("STOP");
        this.setVisible(true);
    }
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(scaled, x, y,null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        x=x+xVel;
        y=y+yVel;
        repaint();
    if(e.getSource()==playButton){
        this.dispose();
        new LaunchGame();
    }
    if(e.getSource()==helpButton){
        this.dispose();
        new HelpFrame();
    }
    if(e.getSource()==exitButton){
        System.exit(0);
    }
    }
}
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Menu extends JFrame implements ActionListener {
    JLabel label = new JLabel();
    Timer timer;
    int xVel = 10;
    int yVel = 10;
    int x = 0;
    int y = 0;
    JPanel panel = new JPanel();
    JButton playButton = new JButton("Play Game");
    JButton helpButton = new JButton("Help");
    JButton exitButton = new JButton("Exit");
    Image stopImage = new ImageIcon("stop.jpeg").getImage();
    Image stopResized = stopImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    Image scaled = new ImageIcon(stopResized).getImage();

    Main_Menu() {
       /* public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(scaled, x, y, null);
        }*/
        timer = new Timer(40, this); // 25 frames per second (1000 ms / 25 fps = 40 ms per frame)
        timer.start();
        panel.setBounds(0, 0, 500, 500);
        panel.setLayout(null);
        panel.setBackground(Color.yellow);
        playButton.setBounds(160, 80, 160, 80);
        helpButton.setBounds(160, 180, 160, 80);
        exitButton.setBounds(160, 280, 160, 80);
        playButton.addActionListener(this);
        helpButton.addActionListener(this);
        exitButton.addActionListener(this);
        this.add(playButton);
        this.add(helpButton);
        this.add(exitButton);
        this.add(label);
        this.add(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.yellow);
        this.setSize(500, 500);
        this.setTitle("STOP");
        this.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        x = x + xVel;
        y = y + yVel;

        // Reverse direction if the image reaches the boundaries of the panel
        if (x + scaled.getWidth(null) > panel.getWidth() || x < 0) {
            xVel = -xVel;
        }
        if (y + scaled.getHeight(null) > panel.getHeight() || y < 0) {
            yVel = -yVel;
        }

        repaint();
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
    }
}
