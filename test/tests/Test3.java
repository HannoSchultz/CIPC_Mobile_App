package tests;

import com.codename1.testing.AbstractTest;
import com.codename1.testing.TestUtils;

import com.codename1.ui.Display;

public class Test3 extends AbstractTest {

    public boolean runTest() throws Exception {
        TestUtils.setVerboseMode(true);
        screenshotTest(System.currentTimeMillis()+"");
        clickButtonByName("btnLogin");
        waitForFormName("Main");
        screenshotTest(System.currentTimeMillis()+"");
        pointerPress(0.5743243f, 0.45918366f, "mbTasks");
        waitFor(122);
        pointerRelease(0.5743243f, 0.45918366f, "mbTasks");
        screenshotTest(System.currentTimeMillis()+"");
        assertEqual(getToolbarCommands().length, 2);
        executeToolbarCommandAtOffset(0);

        goBack();
        waitForFormName("Main");

        pointerPress(0.5810811f, 0.5102041f, "mbCurrency");
        waitFor(245);
        pointerRelease(0.5810811f, 0.5102041f, "mbCurrency");
        screenshotTest(System.currentTimeMillis()+"");
        
        float yDiff =  0.5102041f - 0.45918366f;
        
        float yCart = 0.5102041f + yDiff;

        assertEqual(getToolbarCommands().length, 2);
        executeToolbarCommandAtOffset(0);
        pointerPress(0.41216215f, yCart, "mbCart");
        waitFor(178);
        pointerRelease(0.41216215f, yCart, "mbCart");
        waitFor(178);
        screenshotTest(System.currentTimeMillis()+"");
        waitForFormTitle("No Items");
        //Display.getInstance().getCurrent().setName("Form_1");
        screenshotTest(System.currentTimeMillis()+"");
        return true;
    }
}
