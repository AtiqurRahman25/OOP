import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TypingSpeedCalculator extends JFrame implements ActionListener {
    JTextArea textArea, inputArea;
    JButton startButton, doneButton;
    JLabel wpmLabel;
    long startTime, endTime;

    TypingSpeedCalculator() {
        setTitle("Typing Speed Calculator");
        setSize(500, 400);
        setLayout(null);

        textArea = new JTextArea("Type this text as fast as you can in the input area below.");
        textArea.setBounds(50, 30, 400, 60);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        add(textArea);

        inputArea = new JTextArea();
        inputArea.setBounds(50, 110, 400, 100);
        inputArea.setLineWrap(true);
        inputArea.setWrapStyleWord(true);
        add(inputArea);

        startButton = new JButton("Start");
        startButton.setBounds(100, 230, 100, 30);
        startButton.addActionListener(this);
        add(startButton);

        doneButton = new JButton("Done");
        doneButton.setBounds(300, 230, 100, 30);
        doneButton.addActionListener(this);
        add(doneButton);

        wpmLabel = new JLabel("");
        wpmLabel.setBounds(180, 280, 200, 30);
        add(wpmLabel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            inputArea.setText("");
            wpmLabel.setText("");
            startTime = System.currentTimeMillis();
        } else if (e.getSource() == doneButton) {
            endTime = System.currentTimeMillis();
            String typedText = inputArea.getText().trim();
            int wordCount = typedText.isEmpty() ? 0 : typedText.split("\\s+").length;
            double minutes = (endTime - startTime) / 60000.0;
            int wpm = (int)(wordCount / minutes);
            wpmLabel.setText("WPM: " + wpm);
        }
    }

    public static void main(String[] args) {
        new TypingSpeedCalculator();
    }
}
