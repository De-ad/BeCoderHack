import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Визуализация на Swing
 */

public class GUI {

    private JFrame frame;
    private final int TEXT_SIZE = 20;
    private final int ANS_TEXT_SIZE = 15;
    private final String FONT_FAMILY = "Impact";
    private final String TASK = "Каких местоимений больше?";

    private JLabel createTaskLabel(String content) {
        JLabel label = new JLabel(content);
        label.setFont(new Font(FONT_FAMILY, Font.PLAIN, TEXT_SIZE - 3));
        label.setBounds(10, 10, 400, 15);
        return label;
    }

    private JLabel createLabel(String content) {
        JLabel label = new JLabel(content);
        label.setFont(new Font(FONT_FAMILY, Font.PLAIN, TEXT_SIZE));
        label.setBounds(20, 0, 100, 100);
        return label;
    }

    private JLabel answerLabel;

    private JLabel createAnswerLabel() {
        answerLabel = new JLabel();
        answerLabel.setForeground(Color.MAGENTA);
        answerLabel.setBounds(20, 160, 300, 25);
        answerLabel.setFont(new Font(FONT_FAMILY, Font.PLAIN, ANS_TEXT_SIZE));
        return answerLabel;
    }

    private JTextField textField;

    private JTextField createTextField(String placeholder) {
        textField = new JTextField(placeholder);
        textField.setBounds(20, 70, 300, 25);
        textField.setForeground(Color.BLACK);
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                textField.setForeground(Color.BLACK);
                textField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                textField.setForeground(Color.GRAY);
                lastData = textField.getText();
                textField.setText("https://");
            }
        });
        return textField;
    }

    private String lastData;

    private String getTextFieldData() {
        return lastData;
    }

    private JButton createButton(String title) {
        JButton btn = new JButton(title);
        btn.setBounds(20, 105, 150, 50);

        /**
         * Говнокод
         */
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    URL url = new URL(getTextFieldData());
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(url.openConnection().getInputStream(), "UTF-8")
                    );

                    long[] ans = CountSolutions.isSelfMore(reader);
                    answerLabel.setForeground(Color.MAGENTA);
                    answerLabel.setText(ans[0] == 1 ?
                            "Личных местоимений больше (" + ans[1] + "vs" + ans[2] + ")" :
                            "Личных местоимений меньше (" + ans[1] + "vs" + ans[2] + ")");

                } catch (IOException ex) {
                    answerLabel.setForeground(Color.RED);
                    answerLabel.setText("Неправильно задана ссылка");
                }
            }
        });
        return btn;
    }

    public GUI() {
        init();
        JPanel panel = new JPanel();
        frame.add(panel);
        placeFillComponents(panel);
        frame.setVisible(true);
    }

    private void placeFillComponents(JPanel panel) {
        panel.setLayout(null);
        panel.add(createTaskLabel(TASK));
        panel.add(createLabel("Website url:"));
        panel.add(createTextField("https://..."));
        panel.add(createButton("Ответ"));
        panel.add(createAnswerLabel());
    }

    private void init() {
        frame = new JFrame("task 3");
        frame.setSize(400, 300);
        frame.setLocation(100, 100);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
