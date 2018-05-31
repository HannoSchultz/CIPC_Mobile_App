package tests;

import com.codename1.testing.AbstractTest;

import com.codename1.ui.Display;

public class UnnamedTest2 extends AbstractTest {

    public boolean runTest() throws Exception {
        waitForFormName("Login");
        clickButtonByName("btnRegister");
        waitForFormName("Registration");
        return true;
    }
}
