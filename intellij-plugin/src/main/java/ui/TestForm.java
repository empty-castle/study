package ui;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TestForm {
    private JButton search;
    private JPanel TestForm;
    private JTextField inputText;
    private JLabel label;

    public TestForm() {
        search.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(inputText.getText());
                JOptionPane.showMessageDialog(null, inputText.getText());
                label.setText(inputText.getText());
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        JFrame jFrame = new JFrame();
        jFrame.setContentPane(TestForm);

    }
}
