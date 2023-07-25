import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ScoresFrame extends JFrame implements ActionListener {
    JButton menuButton = new JButton("Main Menu");
    JTextArea textArea = new JTextArea();

    ScoresFrame() {
        textArea.setEditable(false);
        textArea.setFont(new Font("Verdana", Font.PLAIN, 24));
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(460, 60, 530, 520);
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Player's Scores.txt"));
            try {
                StringBuilder allScores = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    allScores.append(line).append("\n");
                }
                textArea.setText(allScores.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        menuButton.addActionListener(this);
        menuButton.setBounds(620, 620, 200, 120);
        this.add(scrollPane);
        this.add(menuButton);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Player's Scores");
        this.setLayout(null);
        this.getContentPane().setBackground(Color.green);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuButton) {
            this.dispose();
            new Main_Menu();
        }
    }
}