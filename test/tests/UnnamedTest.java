package tests;

import com.codename1.testing.AbstractTest;

import com.codename1.ui.Display;

public class UnnamedTest extends AbstractTest {

    public boolean runTest() throws Exception {
        waitForFormName("Main");
        assertTitle("Tasks Today");
        assertLabel("LabelTitle", " ");
        assertLabel("btnNewTask", "New Task");
        assertLabel("LabelTitle", " ");
        assertLabel("btnNewTask", "New Task");
        assertTitle("Tasks Today");
        return true;
    }
}
