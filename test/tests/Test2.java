package tests;

import com.codename1.testing.AbstractTest;
import com.codename1.testing.TestUtils;

import com.codename1.ui.Display;
import java.util.Random;

public class Test2 extends AbstractTest {

    public boolean runTest() throws Exception {
        TestUtils.setVerboseMode(true);
//        assertTextArea("txtCustomerCode", "NEWLNE");
//        assertTextArea("txtPassword", "PleaseWork1!");
//        screenshotTest("1 Login " + System.currentTimeMillis());
//        clickButtonByName("btnLogin");
//        waitForFormName("Main");
//
//        screenshotTest("2 Home " + +System.currentTimeMillis());
//        pointerPress(0.5282392f, 0.38513514f, "mbTasks");
//        waitFor(163);
//        pointerRelease(0.5282392f, 0.38513514f, "mbTasks");
//        clickButtonByName("btnVerify");
//        waitForUnnamedForm();
//        Display.getInstance().getCurrent().setName("Form_1");
//        waitForFormName("Main");
//        assertTextArea("txtLine1", "Please enter at least 1 (one) proposed name, a maximum of 4 (four), in order of preference. Proposed Names (s):");
//        assertTextArea("txtName1", "Croatia");
//        assertTextArea("txtName2", "c81e72c845");
//        assertTextArea("txtName3", "");
//        assertTextArea("txtName4", "");
//        assertTextArea("TextArea1", "Please note that the result as reflected on this screen is based on a preliminary search conducted on entity names and does not guarantee that the names about to be processed and shown above will be reserved. You will be notified of the final result via the email address as per your customer profile.");
//        
//        waitForUnnamedForm();
//        Display.getInstance().getCurrent().setName("Form_2");
//        
//        waitForFormName("Main");
//        clickButtonByName("btnVerify");
//        screenshotTest("3 Name Reservation " + +System.currentTimeMillis());
//        clickButtonByName("btnLodge");
//        waitForUnnamedForm();
//        Display.getInstance().getCurrent().setName("Form_3");
//        waitForFormName("Main");
//        waitForFormTitle("Error");
//        Display.getInstance().getCurrent().setName("Form_4");
//        screenshotTest("4 Name Reservation " + +System.currentTimeMillis());
//        goBack();
//        waitForFormName("Main");
//        assertEqual(getToolbarCommands().length, 2);
//        executeToolbarCommandAtOffset(0);
//        pointerPress(0.24086379f, 0.47297296f, "mbCurrency");
//        waitFor(125);
//        pointerRelease(0.24086379f, 0.47297296f, "mbCurrency");
//        assertTextArea("TextArea", "Please enter Enterprise Number:");
//        assertTextArea("txtStep1a", "2011");
//        assertTextArea("txtStep1b", "100088");
//        assertTextArea("txtStep1c", "07");
//        assertTextArea("Please enter Annual Turnover for the current filing year, 2018:");
//        assertTextArea("TextField3", "");
//        clickButtonByName("btnStep1RetrieveDetails");
//        waitForUnnamedForm();
//        Display.getInstance().getCurrent().setName("Form_5");
//        waitForFormName("Main");
//        screenshotTest("Test2_5");
//        clickButtonByName("btnStep2Confirm");
//        waitForUnnamedForm();
//        Display.getInstance().getCurrent().setName("Form_6");
//        waitForFormName("Main");
//        assertTextArea("TextArea", "Please enter Enterprise Number:");
//        assertTextArea("txtStep1a", "2011");
//        assertTextArea("txtStep1b", "100088");
//        assertTextArea("txtStep1c", "07");
//        assertTextArea("Please enter Annual Turnover for 2018");
//        assertTextArea("0");
//        screenshotTest("Test2_6");
//        clickButtonByName("btnStep3CalcOutAmount");
//        waitForUnnamedForm();
//        Display.getInstance().getCurrent().setName("Form_7");
//        waitForFormName("Main");
//        screenshotTest("Test2_7");
//        assertEqual(getToolbarCommands().length, 2);
//        executeToolbarCommandAtOffset(0);
//        assertEqual(getToolbarCommands().length, 2);
//        executeToolbarCommandAtOffset(0);
//        assertEqual(getToolbarCommands().length, 2);
//        executeToolbarCommandAtOffset(0);
//        assertEqual(getToolbarCommands().length, 2);
//        executeToolbarCommandAtOffset(0);
//        pointerPress(0.25747508f, 0.3716216f, "mbCart");
//        waitFor(165);
//        pointerRelease(0.25747508f, 0.3716216f, "mbCart");
//        waitForFormTitle("No Items");
//        Display.getInstance().getCurrent().setName("Form_8");
//        goBack();
//        waitForFormName("Main");
//        pointerPress(0.25415283f, 0.31756756f, "mbCart");
//        waitFor(122);
//        pointerRelease(0.25415283f, 0.31756756f, "mbCart");
//        waitForFormTitle("No Items");
//        Display.getInstance().getCurrent().setName("Form_9");
//        goBack();
//        waitForFormName("Main");
//        assertEqual(getToolbarCommands().length, 2);
//        executeToolbarCommandAtOffset(0);
//        clickButtonByName("btnLogout");
//        waitForFormName("Login");
        return true;
    }

    private String getRandomString(int numchars) {
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while (sb.length() < numchars) {
            sb.append(Integer.toHexString(r.nextInt()));
        }

        return sb.toString().substring(0, numchars);
    }
}
