package tests;

import com.codename1.testing.AbstractTest;

import com.codename1.ui.Display;

public class LoginTest extends AbstractTest {

    public boolean runTest() throws Exception {
        waitForFormName("Login");
        assertTitle("Login");
        assertTextArea("txtEmail", "blessing@mfactory.mobi");
        assertTextArea("txtPassword", "12345");
        clickButtonByName("btnLogin");
        waitForFormName("Main");
        return true;
    }
}
