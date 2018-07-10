package tests;

import com.codename1.testing.AbstractTest;

import com.codename1.ui.Display;

public class LoginTest extends AbstractTest {
    public boolean runTest() throws Exception {
        assertTitle("");
        assertLabel("Label", "");
        assertLabel("Label1", "Customer Code");
        assertLabel("Label11", "Password");
        assertLabel("btnLogin", "Login");
        assertLabel("btnRegister", "Register as a user");
        assertLabel("btnForgotPassword", "Forgot Login Details");
        assertTextArea("txtCustomerCode", "NEWLNE");
        assertTextArea("txtPassword", "PleaseWork1!");
        screenshotTest("LoginTest_1");
        clickButtonByName("btnLogin");
        assertTitle("");
        waitForFormName("Main");
        assertTitle("Dashboard");
        assertLabel("Line2", "Lodge Name(s)");
        assertLabel("Line3", "");
        assertLabel("Line4", "");
        assertLabel("Line1", "Name Reservations");
        assertLabel("Label", "");
        assertLabel("emblem", "");
        assertLabel(new int[]{0, 0, 1, 0, 0, 0}, "Submit Enterprise Returns");
        assertLabel(new int[]{0, 0, 1, 0, 0, 1}, "");
        assertLabel(new int[]{0, 0, 1, 0, 0, 2}, "");
        assertLabel(new int[]{0, 0, 1, 0, 1}, "Annual Returns");
        assertLabel("icon", "");
        assertLabel(new int[]{0, 0, 1, 2, 0}, "");
        assertLabel(new int[]{0, 0, 2, 0, 0, 0}, "Pay Now for CIPC Services");
        assertLabel(new int[]{0, 0, 2, 0, 0, 1}, "");
        assertLabel(new int[]{0, 0, 2, 0, 0, 2}, "");
        assertLabel(new int[]{0, 0, 2, 0, 1}, "Shopping Cart");
        assertLabel(new int[]{0, 0, 2, 1, 0}, "");
        assertLabel(new int[]{0, 0, 2, 2, 0}, "");
        screenshotTest("LoginTest_2");
        return true;
    }
}
