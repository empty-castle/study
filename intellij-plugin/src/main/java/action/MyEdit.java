package action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import ui.TestForm;

public class MyEdit extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        new TestForm();
    }
}
