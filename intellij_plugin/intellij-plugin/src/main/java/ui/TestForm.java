package ui;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TestForm {

    private JDialog dialog = new JDialog();

    private JButton search;
    private JPanel TestForm;
    private JTextField inputText;
    private JTextField TEXT;

    public TestForm() {

        dialog.add(TestForm);
        dialog.pack();
        dialog.setLocation(200, 200);
        dialog.setVisible(true);

        search.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(inputText.getText());
                JOptionPane.showMessageDialog(null, inputText.getText());
                TEXT.setText(inputText.getText());
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
