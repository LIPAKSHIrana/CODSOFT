import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class WordCountGUI extends JFrame implements ActionListener {
    private JTextArea inputTextArea;
    private JButton countButton;
    private JLabel resultLabel;

    public WordCountGUI() {
        setTitle("Word Count Program");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);         
        inputTextArea = new JTextArea();
        inputTextArea.setBounds(10, 10, 380, 150);
        add(inputTextArea);

        countButton = new JButton("Count Words");
        countButton.setBounds(10, 170, 150, 30);
        countButton.addActionListener(this);
        add(countButton);

        resultLabel = new JLabel("Word Count: ");
        resultLabel.setBounds(10, 210, 200, 30);
        add(resultLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == countButton) {
            String inputText = inputTextArea.getText();
            String[] words = inputText.split("[\\s.,;!?()]+");
            
            int counter = 0;
            String[] stopWords = {"the", "a", "an", "and", "is", "of", "in", "to", "for"};
            
            for (String word : words) {
                if (!isStopWord(word, stopWords)) {
                    counter++;
                }
            }
            
            resultLabel.setText("Word Count: " + counter);
        }
    }
    
    private boolean isStopWord(String word, String[] stopWords) {
        for (String stopWord : stopWords) {
            if (word.equalsIgnoreCase(stopWord)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordCountGUI wordCountGUI = new WordCountGUI();
        wordCountGUI.setVisible(true);
    }
}
