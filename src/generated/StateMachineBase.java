/**
 * This class contains generated code from the Codename One Designer, DO NOT MODIFY!
 * This class is designed for subclassing that way the code generator can overwrite it
 * anytime without erasing your changes which should exist in a subclass!
 * For details about this file and how it works please read this blog post:
 * http://codenameone.blogspot.com/2010/10/ui-builder-class-how-to-actually-use.html
*/
package generated;

import com.codename1.ui.*;
import com.codename1.ui.util.*;
import com.codename1.ui.plaf.*;
import java.util.Hashtable;
import com.codename1.ui.events.*;

public abstract class StateMachineBase extends UIBuilder {
    private Container aboutToShowThisContainer;
    /**
     * this method should be used to initialize variables instead of
     * the constructor/class scope to avoid race conditions
     */
    /**
    * @deprecated use the version that accepts a resource as an argument instead
    
**/
    protected void initVars() {}

    protected void initVars(Resources res) {}

    public StateMachineBase(Resources res, String resPath, boolean loadTheme) {
        startApp(res, resPath, loadTheme);
    }

    public Container startApp(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("Container", com.codename1.ui.Container.class);
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("TextArea", com.codename1.ui.TextArea.class);
        UIBuilder.registerCustomComponent("Picker", com.codename1.ui.spinner.Picker.class);
        UIBuilder.registerCustomComponent("Label", com.codename1.ui.Label.class);
        UIBuilder.registerCustomComponent("TextField", com.codename1.ui.TextField.class);
        UIBuilder.registerCustomComponent("Tabs", com.codename1.ui.Tabs.class);
        UIBuilder.registerCustomComponent("SpanLabel", com.codename1.components.SpanLabel.class);
        UIBuilder.registerCustomComponent("RadioButton", com.codename1.ui.RadioButton.class);
        UIBuilder.registerCustomComponent("MultiButton", com.codename1.components.MultiButton.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    if(resPath.endsWith(".res")) {
                        res = Resources.open(resPath);
                        System.out.println("Warning: you should construct the state machine without the .res extension to allow theme overlays");
                    } else {
                        res = Resources.openLayered(resPath);
                    }
                } catch(java.io.IOException err) { err.printStackTrace(); }
            }
            initTheme(res);
        }
        if(res != null) {
            setResourceFilePath(resPath);
            setResourceFile(res);
            initVars(res);
            return showForm(getFirstFormName(), null);
        } else {
            Form f = (Form)createContainer(resPath, getFirstFormName());
            initVars(fetchResourceFile());
            beforeShow(f);
            f.show();
            postShow(f);
            return f;
        }
    }

    protected String getFirstFormName() {
        return "Main";
    }

    public Container createWidget(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("Container", com.codename1.ui.Container.class);
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("TextArea", com.codename1.ui.TextArea.class);
        UIBuilder.registerCustomComponent("Picker", com.codename1.ui.spinner.Picker.class);
        UIBuilder.registerCustomComponent("Label", com.codename1.ui.Label.class);
        UIBuilder.registerCustomComponent("TextField", com.codename1.ui.TextField.class);
        UIBuilder.registerCustomComponent("Tabs", com.codename1.ui.Tabs.class);
        UIBuilder.registerCustomComponent("SpanLabel", com.codename1.components.SpanLabel.class);
        UIBuilder.registerCustomComponent("RadioButton", com.codename1.ui.RadioButton.class);
        UIBuilder.registerCustomComponent("MultiButton", com.codename1.components.MultiButton.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    res = Resources.openLayered(resPath);
                } catch(java.io.IOException err) { err.printStackTrace(); }
            }
            initTheme(res);
        }
        return createContainer(resPath, "Main");
    }

    protected void initTheme(Resources res) {
            String[] themes = res.getThemeResourceNames();
            if(themes != null && themes.length > 0) {
                UIManager.getInstance().setThemeProps(res.getTheme(themes[0]));
            }
    }

    public StateMachineBase() {
    }

    public StateMachineBase(String resPath) {
        this(null, resPath, true);
    }

    public StateMachineBase(Resources res) {
        this(res, null, true);
    }

    public StateMachineBase(String resPath, boolean loadTheme) {
        this(null, resPath, loadTheme);
    }

    public StateMachineBase(Resources res, boolean loadTheme) {
        this(res, null, loadTheme);
    }

    public com.codename1.ui.Container findContSettings(Component root) {
        return (com.codename1.ui.Container)findByName("ContSettings", root);
    }

    public com.codename1.ui.Container findContSettings() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ContSettings", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ContSettings", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtStep4Password(Component root) {
        return (com.codename1.ui.TextField)findByName("txtStep4Password", root);
    }

    public com.codename1.ui.TextField findTxtStep4Password() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtStep4Password", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtStep4Password", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextArea findTextArea1(Component root) {
        return (com.codename1.ui.TextArea)findByName("TextArea1", root);
    }

    public com.codename1.ui.TextArea findTextArea1() {
        com.codename1.ui.TextArea cmp = (com.codename1.ui.TextArea)findByName("TextArea1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextArea)findByName("TextArea1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLblName1Response(Component root) {
        return (com.codename1.ui.Label)findByName("lblName1Response", root);
    }

    public com.codename1.ui.Label findLblName1Response() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("lblName1Response", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("lblName1Response", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextArea findTxtStep3Address(Component root) {
        return (com.codename1.ui.TextArea)findByName("txtStep3Address", root);
    }

    public com.codename1.ui.TextArea findTxtStep3Address() {
        com.codename1.ui.TextArea cmp = (com.codename1.ui.TextArea)findByName("txtStep3Address", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextArea)findByName("txtStep3Address", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnStep1NoID(Component root) {
        return (com.codename1.ui.Button)findByName("btnStep1NoID", root);
    }

    public com.codename1.ui.Button findBtnStep1NoID() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnStep1NoID", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnStep1NoID", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContStep1(Component root) {
        return (com.codename1.ui.Container)findByName("contStep1", root);
    }

    public com.codename1.ui.Container findContStep1() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("contStep1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("contStep1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContStep2(Component root) {
        return (com.codename1.ui.Container)findByName("contStep2", root);
    }

    public com.codename1.ui.Container findContStep2() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("contStep2", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("contStep2", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findButton(Component root) {
        return (com.codename1.ui.Button)findByName("Button", root);
    }

    public com.codename1.ui.Button findButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Button", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Button", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnRecoverPassword(Component root) {
        return (com.codename1.ui.Button)findByName("btnRecoverPassword", root);
    }

    public com.codename1.ui.Button findBtnRecoverPassword() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnRecoverPassword", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnRecoverPassword", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLblStep2EnterpriseName(Component root) {
        return (com.codename1.ui.Label)findByName("lblStep2EnterpriseName", root);
    }

    public com.codename1.ui.Label findLblStep2EnterpriseName() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("lblStep2EnterpriseName", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("lblStep2EnterpriseName", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.spinner.Picker findPickerStep3Province(Component root) {
        return (com.codename1.ui.spinner.Picker)findByName("pickerStep3Province", root);
    }

    public com.codename1.ui.spinner.Picker findPickerStep3Province() {
        com.codename1.ui.spinner.Picker cmp = (com.codename1.ui.spinner.Picker)findByName("pickerStep3Province", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.spinner.Picker)findByName("pickerStep3Province", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContProfile(Component root) {
        return (com.codename1.ui.Container)findByName("ContProfile", root);
    }

    public com.codename1.ui.Container findContProfile() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ContProfile", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ContProfile", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContStep1AnnualReturns1(Component root) {
        return (com.codename1.ui.Container)findByName("contStep1AnnualReturns1", root);
    }

    public com.codename1.ui.Container findContStep1AnnualReturns1() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("contStep1AnnualReturns1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("contStep1AnnualReturns1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtStep2Email(Component root) {
        return (com.codename1.ui.TextField)findByName("txtStep2Email", root);
    }

    public com.codename1.ui.TextField findTxtStep2Email() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtStep2Email", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtStep2Email", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.RadioButton findRdYes(Component root) {
        return (com.codename1.ui.RadioButton)findByName("rdYes", root);
    }

    public com.codename1.ui.RadioButton findRdYes() {
        com.codename1.ui.RadioButton cmp = (com.codename1.ui.RadioButton)findByName("rdYes", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.RadioButton)findByName("rdYes", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnLogout(Component root) {
        return (com.codename1.ui.Button)findByName("btnLogout", root);
    }

    public com.codename1.ui.Button findBtnLogout() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnLogout", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnLogout", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel41(Component root) {
        return (com.codename1.ui.Label)findByName("Label41", root);
    }

    public com.codename1.ui.Label findLabel41() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label41", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label41", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnStep4AddToCart(Component root) {
        return (com.codename1.ui.Button)findByName("btnStep4AddToCart", root);
    }

    public com.codename1.ui.Button findBtnStep4AddToCart() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnStep4AddToCart", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnStep4AddToCart", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtName4(Component root) {
        return (com.codename1.ui.TextField)findByName("txtName4", root);
    }

    public com.codename1.ui.TextField findTxtName4() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtName4", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtName4", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtName3(Component root) {
        return (com.codename1.ui.TextField)findByName("txtName3", root);
    }

    public com.codename1.ui.TextField findTxtName3() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtName3", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtName3", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtName2(Component root) {
        return (com.codename1.ui.TextField)findByName("txtName2", root);
    }

    public com.codename1.ui.TextField findTxtName2() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtName2", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtName2", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtName1(Component root) {
        return (com.codename1.ui.TextField)findByName("txtName1", root);
    }

    public com.codename1.ui.TextField findTxtName1() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtName1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtName1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtStep2FaxNumber(Component root) {
        return (com.codename1.ui.TextField)findByName("txtStep2FaxNumber", root);
    }

    public com.codename1.ui.TextField findTxtStep2FaxNumber() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtStep2FaxNumber", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtStep2FaxNumber", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnStep4Register(Component root) {
        return (com.codename1.ui.Button)findByName("btnStep4Register", root);
    }

    public com.codename1.ui.Button findBtnStep4Register() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnStep4Register", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnStep4Register", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtStep3PostalCode(Component root) {
        return (com.codename1.ui.TextField)findByName("txtStep3PostalCode", root);
    }

    public com.codename1.ui.TextField findTxtStep3PostalCode() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtStep3PostalCode", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtStep3PostalCode", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnStep3Next(Component root) {
        return (com.codename1.ui.Button)findByName("btnStep3Next", root);
    }

    public com.codename1.ui.Button findBtnStep3Next() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnStep3Next", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnStep3Next", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnGallery(Component root) {
        return (com.codename1.ui.Button)findByName("btnGallery", root);
    }

    public com.codename1.ui.Button findBtnGallery() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnGallery", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnGallery", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLblFullName(Component root) {
        return (com.codename1.ui.Label)findByName("lblFullName", root);
    }

    public com.codename1.ui.Label findLblFullName() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("lblFullName", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("lblFullName", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtStep2CellPhone(Component root) {
        return (com.codename1.ui.TextField)findByName("txtStep2CellPhone", root);
    }

    public com.codename1.ui.TextField findTxtStep2CellPhone() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtStep2CellPhone", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtStep2CellPhone", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtLastName(Component root) {
        return (com.codename1.ui.TextField)findByName("txtLastName", root);
    }

    public com.codename1.ui.TextField findTxtLastName() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtLastName", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtLastName", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnProfileName(Component root) {
        return (com.codename1.ui.Button)findByName("btnProfileName", root);
    }

    public com.codename1.ui.Button findBtnProfileName() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnProfileName", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnProfileName", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTextField3(Component root) {
        return (com.codename1.ui.TextField)findByName("TextField3", root);
    }

    public com.codename1.ui.TextField findTextField3() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("TextField3", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("TextField3", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLblStep2EnterpriseType(Component root) {
        return (com.codename1.ui.Label)findByName("lblStep2EnterpriseType", root);
    }

    public com.codename1.ui.Label findLblStep2EnterpriseType() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("lblStep2EnterpriseType", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("lblStep2EnterpriseType", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContStep3Turnovers(Component root) {
        return (com.codename1.ui.Container)findByName("contStep3Turnovers", root);
    }

    public com.codename1.ui.Container findContStep3Turnovers() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("contStep3Turnovers", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("contStep3Turnovers", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnStep3CalcOutAmount(Component root) {
        return (com.codename1.ui.Button)findByName("btnStep3CalcOutAmount", root);
    }

    public com.codename1.ui.Button findBtnStep3CalcOutAmount() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnStep3CalcOutAmount", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnStep3CalcOutAmount", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContStep1AnnualReturns(Component root) {
        return (com.codename1.ui.Container)findByName("contStep1AnnualReturns", root);
    }

    public com.codename1.ui.Container findContStep1AnnualReturns() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("contStep1AnnualReturns", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("contStep1AnnualReturns", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLblTotalDue(Component root) {
        return (com.codename1.ui.Label)findByName("lblTotalDue", root);
    }

    public com.codename1.ui.Label findLblTotalDue() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("lblTotalDue", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("lblTotalDue", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLblStep2EnterpriseNumber(Component root) {
        return (com.codename1.ui.Label)findByName("lblStep2EnterpriseNumber", root);
    }

    public com.codename1.ui.Label findLblStep2EnterpriseNumber() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("lblStep2EnterpriseNumber", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("lblStep2EnterpriseNumber", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtCustomerCode(Component root) {
        return (com.codename1.ui.TextField)findByName("txtCustomerCode", root);
    }

    public com.codename1.ui.TextField findTxtCustomerCode() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtCustomerCode", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtCustomerCode", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContDashBoard(Component root) {
        return (com.codename1.ui.Container)findByName("ContDashBoard", root);
    }

    public com.codename1.ui.Container findContDashBoard() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ContDashBoard", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ContDashBoard", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnVerify(Component root) {
        return (com.codename1.ui.Button)findByName("btnVerify", root);
    }

    public com.codename1.ui.Button findBtnVerify() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnVerify", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnVerify", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.components.MultiButton findMbCurrency(Component root) {
        return (com.codename1.components.MultiButton)findByName("mbCurrency", root);
    }

    public com.codename1.components.MultiButton findMbCurrency() {
        com.codename1.components.MultiButton cmp = (com.codename1.components.MultiButton)findByName("mbCurrency", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.components.MultiButton)findByName("mbCurrency", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.components.MultiButton findMultiButton(Component root) {
        return (com.codename1.components.MultiButton)findByName("MultiButton", root);
    }

    public com.codename1.components.MultiButton findMultiButton() {
        com.codename1.components.MultiButton cmp = (com.codename1.components.MultiButton)findByName("MultiButton", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.components.MultiButton)findByName("MultiButton", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtPassword(Component root) {
        return (com.codename1.ui.TextField)findByName("txtPassword", root);
    }

    public com.codename1.ui.TextField findTxtPassword() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtPassword", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtPassword", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnForgotPassword(Component root) {
        return (com.codename1.ui.Button)findByName("btnForgotPassword", root);
    }

    public com.codename1.ui.Button findBtnForgotPassword() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnForgotPassword", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnForgotPassword", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContProjects(Component root) {
        return (com.codename1.ui.Container)findByName("ContProjects", root);
    }

    public com.codename1.ui.Container findContProjects() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ContProjects", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ContProjects", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContTasks(Component root) {
        return (com.codename1.ui.Container)findByName("ContTasks", root);
    }

    public com.codename1.ui.Container findContTasks() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ContTasks", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ContTasks", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtStep1IDNumber(Component root) {
        return (com.codename1.ui.TextField)findByName("txtStep1IDNumber", root);
    }

    public com.codename1.ui.TextField findTxtStep1IDNumber() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtStep1IDNumber", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtStep1IDNumber", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel21(Component root) {
        return (com.codename1.ui.Label)findByName("Label21", root);
    }

    public com.codename1.ui.Label findLabel21() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label21", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label21", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContCart(Component root) {
        return (com.codename1.ui.Container)findByName("ContCart", root);
    }

    public com.codename1.ui.Container findContCart() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ContCart", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ContCart", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLblLine1(Component root) {
        return (com.codename1.ui.Label)findByName("lblLine1", root);
    }

    public com.codename1.ui.Label findLblLine1() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("lblLine1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("lblLine1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtEmail1(Component root) {
        return (com.codename1.ui.TextField)findByName("txtEmail1", root);
    }

    public com.codename1.ui.TextField findTxtEmail1() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtEmail1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtEmail1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextArea findTxtLine1(Component root) {
        return (com.codename1.ui.TextArea)findByName("txtLine1", root);
    }

    public com.codename1.ui.TextArea findTxtLine1() {
        com.codename1.ui.TextArea cmp = (com.codename1.ui.TextArea)findByName("txtLine1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextArea)findByName("txtLine1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLblStep2RegistrationDate(Component root) {
        return (com.codename1.ui.Label)findByName("lblStep2RegistrationDate", root);
    }

    public com.codename1.ui.Label findLblStep2RegistrationDate() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("lblStep2RegistrationDate", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("lblStep2RegistrationDate", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLblName4Response(Component root) {
        return (com.codename1.ui.Label)findByName("lblName4Response", root);
    }

    public com.codename1.ui.Label findLblName4Response() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("lblName4Response", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("lblName4Response", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer51(Component root) {
        return (com.codename1.ui.Container)findByName("Container51", root);
    }

    public com.codename1.ui.Container findContainer51() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container51", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container51", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtStep2TelephoneNumber(Component root) {
        return (com.codename1.ui.TextField)findByName("txtStep2TelephoneNumber", root);
    }

    public com.codename1.ui.TextField findTxtStep2TelephoneNumber() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtStep2TelephoneNumber", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtStep2TelephoneNumber", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtStep4PasswordRetype(Component root) {
        return (com.codename1.ui.TextField)findByName("txtStep4PasswordRetype", root);
    }

    public com.codename1.ui.TextField findTxtStep4PasswordRetype() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtStep4PasswordRetype", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtStep4PasswordRetype", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtStep3City(Component root) {
        return (com.codename1.ui.TextField)findByName("txtStep3City", root);
    }

    public com.codename1.ui.TextField findTxtStep3City() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtStep3City", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtStep3City", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnLodge(Component root) {
        return (com.codename1.ui.Button)findByName("btnLodge", root);
    }

    public com.codename1.ui.Button findBtnLodge() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnLodge", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnLodge", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtStep4CustomerCode(Component root) {
        return (com.codename1.ui.TextField)findByName("txtStep4CustomerCode", root);
    }

    public com.codename1.ui.TextField findTxtStep4CustomerCode() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtStep4CustomerCode", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtStep4CustomerCode", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnStep1RetrieveDetails(Component root) {
        return (com.codename1.ui.Button)findByName("btnStep1RetrieveDetails", root);
    }

    public com.codename1.ui.Button findBtnStep1RetrieveDetails() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnStep1RetrieveDetails", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnStep1RetrieveDetails", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel11(Component root) {
        return (com.codename1.ui.Label)findByName("Label11", root);
    }

    public com.codename1.ui.Label findLabel11() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label11", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label11", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel12(Component root) {
        return (com.codename1.ui.Label)findByName("Label12", root);
    }

    public com.codename1.ui.Label findLabel12() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label12", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label12", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel13(Component root) {
        return (com.codename1.ui.Label)findByName("Label13", root);
    }

    public com.codename1.ui.Label findLabel13() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label13", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label13", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer9(Component root) {
        return (com.codename1.ui.Container)findByName("Container9", root);
    }

    public com.codename1.ui.Container findContainer9() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container9", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container9", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel14(Component root) {
        return (com.codename1.ui.Label)findByName("Label14", root);
    }

    public com.codename1.ui.Label findLabel14() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label14", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label14", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findButton1(Component root) {
        return (com.codename1.ui.Button)findByName("Button1", root);
    }

    public com.codename1.ui.Button findButton1() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Button1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Button1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextArea findTextArea(Component root) {
        return (com.codename1.ui.TextArea)findByName("TextArea", root);
    }

    public com.codename1.ui.TextArea findTextArea() {
        com.codename1.ui.TextArea cmp = (com.codename1.ui.TextArea)findByName("TextArea", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextArea)findByName("TextArea", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel10(Component root) {
        return (com.codename1.ui.Label)findByName("Label10", root);
    }

    public com.codename1.ui.Label findLabel10() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label10", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label10", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel(Component root) {
        return (com.codename1.ui.Label)findByName("Label", root);
    }

    public com.codename1.ui.Label findLabel() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer3(Component root) {
        return (com.codename1.ui.Container)findByName("Container3", root);
    }

    public com.codename1.ui.Container findContainer3() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container3", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container3", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer11(Component root) {
        return (com.codename1.ui.Container)findByName("Container11", root);
    }

    public com.codename1.ui.Container findContainer11() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container11", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container11", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer4(Component root) {
        return (com.codename1.ui.Container)findByName("Container4", root);
    }

    public com.codename1.ui.Container findContainer4() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container4", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container4", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer10(Component root) {
        return (com.codename1.ui.Container)findByName("Container10", root);
    }

    public com.codename1.ui.Container findContainer10() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container10", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container10", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer1(Component root) {
        return (com.codename1.ui.Container)findByName("Container1", root);
    }

    public com.codename1.ui.Container findContainer1() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer13(Component root) {
        return (com.codename1.ui.Container)findByName("Container13", root);
    }

    public com.codename1.ui.Container findContainer13() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container13", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container13", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer2(Component root) {
        return (com.codename1.ui.Container)findByName("Container2", root);
    }

    public com.codename1.ui.Container findContainer2() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container2", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container2", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer12(Component root) {
        return (com.codename1.ui.Container)findByName("Container12", root);
    }

    public com.codename1.ui.Container findContainer12() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container12", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container12", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer7(Component root) {
        return (com.codename1.ui.Container)findByName("Container7", root);
    }

    public com.codename1.ui.Container findContainer7() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container7", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container7", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer8(Component root) {
        return (com.codename1.ui.Container)findByName("Container8", root);
    }

    public com.codename1.ui.Container findContainer8() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container8", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container8", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer5(Component root) {
        return (com.codename1.ui.Container)findByName("Container5", root);
    }

    public com.codename1.ui.Container findContainer5() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container5", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container5", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel101(Component root) {
        return (com.codename1.ui.Label)findByName("Label101", root);
    }

    public com.codename1.ui.Label findLabel101() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label101", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label101", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer6(Component root) {
        return (com.codename1.ui.Container)findByName("Container6", root);
    }

    public com.codename1.ui.Container findContainer6() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container6", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container6", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer(Component root) {
        return (com.codename1.ui.Container)findByName("Container", root);
    }

    public com.codename1.ui.Container findContainer() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnProfilePic(Component root) {
        return (com.codename1.ui.Button)findByName("btnProfilePic", root);
    }

    public com.codename1.ui.Button findBtnProfilePic() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnProfilePic", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnProfilePic", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.spinner.Picker findPickerStep2Country(Component root) {
        return (com.codename1.ui.spinner.Picker)findByName("pickerStep2Country", root);
    }

    public com.codename1.ui.spinner.Picker findPickerStep2Country() {
        com.codename1.ui.spinner.Picker cmp = (com.codename1.ui.spinner.Picker)findByName("pickerStep2Country", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.spinner.Picker)findByName("pickerStep2Country", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtFirstName(Component root) {
        return (com.codename1.ui.TextField)findByName("txtFirstName", root);
    }

    public com.codename1.ui.TextField findTxtFirstName() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtFirstName", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtFirstName", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContRadioButtons(Component root) {
        return (com.codename1.ui.Container)findByName("contRadioButtons", root);
    }

    public com.codename1.ui.Container findContRadioButtons() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("contRadioButtons", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("contRadioButtons", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContStep4AnnualReturns(Component root) {
        return (com.codename1.ui.Container)findByName("contStep4AnnualReturns", root);
    }

    public com.codename1.ui.Container findContStep4AnnualReturns() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("contStep4AnnualReturns", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("contStep4AnnualReturns", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtStep2EmailRetype(Component root) {
        return (com.codename1.ui.TextField)findByName("txtStep2EmailRetype", root);
    }

    public com.codename1.ui.TextField findTxtStep2EmailRetype() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtStep2EmailRetype", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtStep2EmailRetype", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnStep2Confirm(Component root) {
        return (com.codename1.ui.Button)findByName("btnStep2Confirm", root);
    }

    public com.codename1.ui.Button findBtnStep2Confirm() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnStep2Confirm", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnStep2Confirm", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.RadioButton findRdNo(Component root) {
        return (com.codename1.ui.RadioButton)findByName("rdNo", root);
    }

    public com.codename1.ui.RadioButton findRdNo() {
        com.codename1.ui.RadioButton cmp = (com.codename1.ui.RadioButton)findByName("rdNo", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.RadioButton)findByName("rdNo", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnCamera(Component root) {
        return (com.codename1.ui.Button)findByName("btnCamera", root);
    }

    public com.codename1.ui.Button findBtnCamera() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnCamera", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnCamera", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer22(Component root) {
        return (com.codename1.ui.Container)findByName("Container22", root);
    }

    public com.codename1.ui.Container findContainer22() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container22", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container22", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer21(Component root) {
        return (com.codename1.ui.Container)findByName("Container21", root);
    }

    public com.codename1.ui.Container findContainer21() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container21", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container21", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.components.SpanLabel findSpanLabel(Component root) {
        return (com.codename1.components.SpanLabel)findByName("SpanLabel", root);
    }

    public com.codename1.components.SpanLabel findSpanLabel() {
        com.codename1.components.SpanLabel cmp = (com.codename1.components.SpanLabel)findByName("SpanLabel", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.components.SpanLabel)findByName("SpanLabel", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLblName3Response(Component root) {
        return (com.codename1.ui.Label)findByName("lblName3Response", root);
    }

    public com.codename1.ui.Label findLblName3Response() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("lblName3Response", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("lblName3Response", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnDashboard(Component root) {
        return (com.codename1.ui.Button)findByName("btnDashboard", root);
    }

    public com.codename1.ui.Button findBtnDashboard() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnDashboard", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnDashboard", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtStep1a4(Component root) {
        return (com.codename1.ui.TextField)findByName("txtStep1a4", root);
    }

    public com.codename1.ui.TextField findTxtStep1a4() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtStep1a4", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtStep1a4", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtStep1c(Component root) {
        return (com.codename1.ui.TextField)findByName("txtStep1c", root);
    }

    public com.codename1.ui.TextField findTxtStep1c() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtStep1c", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtStep1c", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtStep1a1(Component root) {
        return (com.codename1.ui.TextField)findByName("txtStep1a1", root);
    }

    public com.codename1.ui.TextField findTxtStep1a1() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtStep1a1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtStep1a1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Tabs findTabs(Component root) {
        return (com.codename1.ui.Tabs)findByName("Tabs", root);
    }

    public com.codename1.ui.Tabs findTabs() {
        com.codename1.ui.Tabs cmp = (com.codename1.ui.Tabs)findByName("Tabs", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Tabs)findByName("Tabs", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel81(Component root) {
        return (com.codename1.ui.Label)findByName("Label81", root);
    }

    public com.codename1.ui.Label findLabel81() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label81", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label81", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnStep1Continue(Component root) {
        return (com.codename1.ui.Button)findByName("btnStep1Continue", root);
    }

    public com.codename1.ui.Button findBtnStep1Continue() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnStep1Continue", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnStep1Continue", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtStep1a(Component root) {
        return (com.codename1.ui.TextField)findByName("txtStep1a", root);
    }

    public com.codename1.ui.TextField findTxtStep1a() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtStep1a", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtStep1a", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtStep1a3(Component root) {
        return (com.codename1.ui.TextField)findByName("txtStep1a3", root);
    }

    public com.codename1.ui.TextField findTxtStep1a3() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtStep1a3", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtStep1a3", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtStep1b(Component root) {
        return (com.codename1.ui.TextField)findByName("txtStep1b", root);
    }

    public com.codename1.ui.TextField findTxtStep1b() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtStep1b", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtStep1b", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtStep1a2(Component root) {
        return (com.codename1.ui.TextField)findByName("txtStep1a2", root);
    }

    public com.codename1.ui.TextField findTxtStep1a2() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtStep1a2", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtStep1a2", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findButton2(Component root) {
        return (com.codename1.ui.Button)findByName("Button2", root);
    }

    public com.codename1.ui.Button findButton2() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Button2", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Button2", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLblStep2EnterpriseStatus(Component root) {
        return (com.codename1.ui.Label)findByName("lblStep2EnterpriseStatus", root);
    }

    public com.codename1.ui.Label findLblStep2EnterpriseStatus() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("lblStep2EnterpriseStatus", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("lblStep2EnterpriseStatus", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnUpdate(Component root) {
        return (com.codename1.ui.Button)findByName("btnUpdate", root);
    }

    public com.codename1.ui.Button findBtnUpdate() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnUpdate", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnUpdate", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContSideMenu(Component root) {
        return (com.codename1.ui.Container)findByName("ContSideMenu", root);
    }

    public com.codename1.ui.Container findContSideMenu() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ContSideMenu", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ContSideMenu", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLblName2Response(Component root) {
        return (com.codename1.ui.Label)findByName("lblName2Response", root);
    }

    public com.codename1.ui.Label findLblName2Response() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("lblName2Response", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("lblName2Response", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel9(Component root) {
        return (com.codename1.ui.Label)findByName("Label9", root);
    }

    public com.codename1.ui.Label findLabel9() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label9", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label9", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.components.MultiButton findMbCart(Component root) {
        return (com.codename1.components.MultiButton)findByName("mbCart", root);
    }

    public com.codename1.components.MultiButton findMbCart() {
        com.codename1.components.MultiButton cmp = (com.codename1.components.MultiButton)findByName("mbCart", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.components.MultiButton)findByName("mbCart", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel8(Component root) {
        return (com.codename1.ui.Label)findByName("Label8", root);
    }

    public com.codename1.ui.Label findLabel8() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label8", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label8", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnSettingsSave(Component root) {
        return (com.codename1.ui.Button)findByName("btnSettingsSave", root);
    }

    public com.codename1.ui.Button findBtnSettingsSave() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnSettingsSave", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnSettingsSave", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel5(Component root) {
        return (com.codename1.ui.Label)findByName("Label5", root);
    }

    public com.codename1.ui.Label findLabel5() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label5", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label5", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel4(Component root) {
        return (com.codename1.ui.Label)findByName("Label4", root);
    }

    public com.codename1.ui.Label findLabel4() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label4", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label4", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel7(Component root) {
        return (com.codename1.ui.Label)findByName("Label7", root);
    }

    public com.codename1.ui.Label findLabel7() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label7", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label7", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel6(Component root) {
        return (com.codename1.ui.Label)findByName("Label6", root);
    }

    public com.codename1.ui.Label findLabel6() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label6", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label6", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLblImage(Component root) {
        return (com.codename1.ui.Label)findByName("lblImage", root);
    }

    public com.codename1.ui.Label findLblImage() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("lblImage", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("lblImage", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainerParent(Component root) {
        return (com.codename1.ui.Container)findByName("containerParent", root);
    }

    public com.codename1.ui.Container findContainerParent() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("containerParent", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("containerParent", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel1(Component root) {
        return (com.codename1.ui.Label)findByName("Label1", root);
    }

    public com.codename1.ui.Label findLabel1() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtEmail(Component root) {
        return (com.codename1.ui.TextField)findByName("txtEmail", root);
    }

    public com.codename1.ui.TextField findTxtEmail() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtEmail", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtEmail", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel3(Component root) {
        return (com.codename1.ui.Label)findByName("Label3", root);
    }

    public com.codename1.ui.Label findLabel3() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label3", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label3", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel131(Component root) {
        return (com.codename1.ui.Label)findByName("Label131", root);
    }

    public com.codename1.ui.Label findLabel131() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label131", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label131", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel2(Component root) {
        return (com.codename1.ui.Label)findByName("Label2", root);
    }

    public com.codename1.ui.Label findLabel2() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label2", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label2", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnRegister(Component root) {
        return (com.codename1.ui.Button)findByName("btnRegister", root);
    }

    public com.codename1.ui.Button findBtnRegister() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnRegister", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnRegister", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtHandle(Component root) {
        return (com.codename1.ui.TextField)findByName("txtHandle", root);
    }

    public com.codename1.ui.TextField findTxtHandle() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtHandle", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtHandle", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnLogin(Component root) {
        return (com.codename1.ui.Button)findByName("btnLogin", root);
    }

    public com.codename1.ui.Button findBtnLogin() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnLogin", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnLogin", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.components.SpanLabel findSpanLabel1(Component root) {
        return (com.codename1.components.SpanLabel)findByName("SpanLabel1", root);
    }

    public com.codename1.components.SpanLabel findSpanLabel1() {
        com.codename1.components.SpanLabel cmp = (com.codename1.components.SpanLabel)findByName("SpanLabel1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.components.SpanLabel)findByName("SpanLabel1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.components.MultiButton findMbTasks(Component root) {
        return (com.codename1.components.MultiButton)findByName("mbTasks", root);
    }

    public com.codename1.components.MultiButton findMbTasks() {
        com.codename1.components.MultiButton cmp = (com.codename1.components.MultiButton)findByName("mbTasks", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.components.MultiButton)findByName("mbTasks", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel61(Component root) {
        return (com.codename1.ui.Label)findByName("Label61", root);
    }

    public com.codename1.ui.Label findLabel61() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label61", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label61", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnStep2Continue(Component root) {
        return (com.codename1.ui.Button)findByName("btnStep2Continue", root);
    }

    public com.codename1.ui.Button findBtnStep2Continue() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnStep2Continue", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnStep2Continue", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnStep4ViewPasswordRules(Component root) {
        return (com.codename1.ui.Button)findByName("btnStep4ViewPasswordRules", root);
    }

    public com.codename1.ui.Button findBtnStep4ViewPasswordRules() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnStep4ViewPasswordRules", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnStep4ViewPasswordRules", aboutToShowThisContainer);
        }
        return cmp;
    }

    public static final int COMMAND_ContProfileUpdate = 4;
    public static final int COMMAND_LoginRegisterAsAUser = 12;
    public static final int COMMAND_ForgotPasswordResetPassword = 13;
    public static final int COMMAND_LoginLogin = 5;
    public static final int COMMAND_LoginForgotLoginDetails = 14;
    public static final int COMMAND_ContDashBoardCommand19 = 19;

    protected boolean onContProfileUpdate() {
        return false;
    }

    protected boolean onLoginRegisterAsAUser() {
        return false;
    }

    protected boolean onForgotPasswordResetPassword() {
        return false;
    }

    protected boolean onLoginLogin() {
        return false;
    }

    protected boolean onLoginForgotLoginDetails() {
        return false;
    }

    protected boolean onContDashBoardCommand19() {
        return false;
    }

    protected void processCommand(ActionEvent ev, Command cmd) {
        switch(cmd.getId()) {
            case COMMAND_ContProfileUpdate:
                if(onContProfileUpdate()) {
                    ev.consume();
                    return;
                }
                break;

            case COMMAND_LoginRegisterAsAUser:
                if(onLoginRegisterAsAUser()) {
                    ev.consume();
                    return;
                }
                break;

            case COMMAND_ForgotPasswordResetPassword:
                if(onForgotPasswordResetPassword()) {
                    ev.consume();
                    return;
                }
                break;

            case COMMAND_LoginLogin:
                if(onLoginLogin()) {
                    ev.consume();
                    return;
                }
                break;

            case COMMAND_LoginForgotLoginDetails:
                if(onLoginForgotLoginDetails()) {
                    ev.consume();
                    return;
                }
                break;

            case COMMAND_ContDashBoardCommand19:
                if(onContDashBoardCommand19()) {
                    ev.consume();
                    return;
                }
                break;

        }
        if(ev.getComponent() != null) {
            handleComponentAction(ev.getComponent(), ev);
        }
    }

    protected void exitForm(Form f) {
        if("ContSettings".equals(f.getName())) {
            exitContSettings(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Registration".equals(f.getName())) {
            exitRegistration(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContProfile".equals(f.getName())) {
            exitContProfile(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Login".equals(f.getName())) {
            exitLogin(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ForgotPassword".equals(f.getName())) {
            exitForgotPassword(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContSideMenu".equals(f.getName())) {
            exitContSideMenu(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContDashBoard".equals(f.getName())) {
            exitContDashBoard(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContProjects".equals(f.getName())) {
            exitContProjects(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContTasks".equals(f.getName())) {
            exitContTasks(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContCart".equals(f.getName())) {
            exitContCart(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Splash".equals(f.getName())) {
            exitSplash(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(f.getName())) {
            exitMain(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void exitContSettings(Form f) {
    }


    protected void exitRegistration(Form f) {
    }


    protected void exitContProfile(Form f) {
    }


    protected void exitLogin(Form f) {
    }


    protected void exitForgotPassword(Form f) {
    }


    protected void exitContSideMenu(Form f) {
    }


    protected void exitContDashBoard(Form f) {
    }


    protected void exitContProjects(Form f) {
    }


    protected void exitContTasks(Form f) {
    }


    protected void exitContCart(Form f) {
    }


    protected void exitSplash(Form f) {
    }


    protected void exitMain(Form f) {
    }

    protected void beforeShow(Form f) {
    aboutToShowThisContainer = f;
        if("ContSettings".equals(f.getName())) {
            beforeContSettings(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Registration".equals(f.getName())) {
            beforeRegistration(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContProfile".equals(f.getName())) {
            beforeContProfile(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Login".equals(f.getName())) {
            beforeLogin(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ForgotPassword".equals(f.getName())) {
            beforeForgotPassword(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContSideMenu".equals(f.getName())) {
            beforeContSideMenu(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContDashBoard".equals(f.getName())) {
            beforeContDashBoard(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContProjects".equals(f.getName())) {
            beforeContProjects(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContTasks".equals(f.getName())) {
            beforeContTasks(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContCart".equals(f.getName())) {
            beforeContCart(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Splash".equals(f.getName())) {
            beforeSplash(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(f.getName())) {
            beforeMain(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void beforeContSettings(Form f) {
    }


    protected void beforeRegistration(Form f) {
    }


    protected void beforeContProfile(Form f) {
    }


    protected void beforeLogin(Form f) {
    }


    protected void beforeForgotPassword(Form f) {
    }


    protected void beforeContSideMenu(Form f) {
    }


    protected void beforeContDashBoard(Form f) {
    }


    protected void beforeContProjects(Form f) {
    }


    protected void beforeContTasks(Form f) {
    }


    protected void beforeContCart(Form f) {
    }


    protected void beforeSplash(Form f) {
    }


    protected void beforeMain(Form f) {
    }

    protected void beforeShowContainer(Container c) {
        aboutToShowThisContainer = c;
        if("ContSettings".equals(c.getName())) {
            beforeContainerContSettings(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Registration".equals(c.getName())) {
            beforeContainerRegistration(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContProfile".equals(c.getName())) {
            beforeContainerContProfile(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Login".equals(c.getName())) {
            beforeContainerLogin(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ForgotPassword".equals(c.getName())) {
            beforeContainerForgotPassword(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContSideMenu".equals(c.getName())) {
            beforeContainerContSideMenu(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContDashBoard".equals(c.getName())) {
            beforeContainerContDashBoard(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContProjects".equals(c.getName())) {
            beforeContainerContProjects(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContTasks".equals(c.getName())) {
            beforeContainerContTasks(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContCart".equals(c.getName())) {
            beforeContainerContCart(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Splash".equals(c.getName())) {
            beforeContainerSplash(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(c.getName())) {
            beforeContainerMain(c);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void beforeContainerContSettings(Container c) {
    }


    protected void beforeContainerRegistration(Container c) {
    }


    protected void beforeContainerContProfile(Container c) {
    }


    protected void beforeContainerLogin(Container c) {
    }


    protected void beforeContainerForgotPassword(Container c) {
    }


    protected void beforeContainerContSideMenu(Container c) {
    }


    protected void beforeContainerContDashBoard(Container c) {
    }


    protected void beforeContainerContProjects(Container c) {
    }


    protected void beforeContainerContTasks(Container c) {
    }


    protected void beforeContainerContCart(Container c) {
    }


    protected void beforeContainerSplash(Container c) {
    }


    protected void beforeContainerMain(Container c) {
    }

    protected void postShow(Form f) {
        if("ContSettings".equals(f.getName())) {
            postContSettings(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Registration".equals(f.getName())) {
            postRegistration(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContProfile".equals(f.getName())) {
            postContProfile(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Login".equals(f.getName())) {
            postLogin(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ForgotPassword".equals(f.getName())) {
            postForgotPassword(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContSideMenu".equals(f.getName())) {
            postContSideMenu(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContDashBoard".equals(f.getName())) {
            postContDashBoard(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContProjects".equals(f.getName())) {
            postContProjects(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContTasks".equals(f.getName())) {
            postContTasks(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContCart".equals(f.getName())) {
            postContCart(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Splash".equals(f.getName())) {
            postSplash(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(f.getName())) {
            postMain(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void postContSettings(Form f) {
    }


    protected void postRegistration(Form f) {
    }


    protected void postContProfile(Form f) {
    }


    protected void postLogin(Form f) {
    }


    protected void postForgotPassword(Form f) {
    }


    protected void postContSideMenu(Form f) {
    }


    protected void postContDashBoard(Form f) {
    }


    protected void postContProjects(Form f) {
    }


    protected void postContTasks(Form f) {
    }


    protected void postContCart(Form f) {
    }


    protected void postSplash(Form f) {
    }


    protected void postMain(Form f) {
    }

    protected void postShowContainer(Container c) {
        if("ContSettings".equals(c.getName())) {
            postContainerContSettings(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Registration".equals(c.getName())) {
            postContainerRegistration(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContProfile".equals(c.getName())) {
            postContainerContProfile(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Login".equals(c.getName())) {
            postContainerLogin(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ForgotPassword".equals(c.getName())) {
            postContainerForgotPassword(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContSideMenu".equals(c.getName())) {
            postContainerContSideMenu(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContDashBoard".equals(c.getName())) {
            postContainerContDashBoard(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContProjects".equals(c.getName())) {
            postContainerContProjects(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContTasks".equals(c.getName())) {
            postContainerContTasks(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContCart".equals(c.getName())) {
            postContainerContCart(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Splash".equals(c.getName())) {
            postContainerSplash(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(c.getName())) {
            postContainerMain(c);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void postContainerContSettings(Container c) {
    }


    protected void postContainerRegistration(Container c) {
    }


    protected void postContainerContProfile(Container c) {
    }


    protected void postContainerLogin(Container c) {
    }


    protected void postContainerForgotPassword(Container c) {
    }


    protected void postContainerContSideMenu(Container c) {
    }


    protected void postContainerContDashBoard(Container c) {
    }


    protected void postContainerContProjects(Container c) {
    }


    protected void postContainerContTasks(Container c) {
    }


    protected void postContainerContCart(Container c) {
    }


    protected void postContainerSplash(Container c) {
    }


    protected void postContainerMain(Container c) {
    }

    protected void onCreateRoot(String rootName) {
        if("ContSettings".equals(rootName)) {
            onCreateContSettings();
            aboutToShowThisContainer = null;
            return;
        }

        if("Registration".equals(rootName)) {
            onCreateRegistration();
            aboutToShowThisContainer = null;
            return;
        }

        if("ContProfile".equals(rootName)) {
            onCreateContProfile();
            aboutToShowThisContainer = null;
            return;
        }

        if("Login".equals(rootName)) {
            onCreateLogin();
            aboutToShowThisContainer = null;
            return;
        }

        if("ForgotPassword".equals(rootName)) {
            onCreateForgotPassword();
            aboutToShowThisContainer = null;
            return;
        }

        if("ContSideMenu".equals(rootName)) {
            onCreateContSideMenu();
            aboutToShowThisContainer = null;
            return;
        }

        if("ContDashBoard".equals(rootName)) {
            onCreateContDashBoard();
            aboutToShowThisContainer = null;
            return;
        }

        if("ContProjects".equals(rootName)) {
            onCreateContProjects();
            aboutToShowThisContainer = null;
            return;
        }

        if("ContTasks".equals(rootName)) {
            onCreateContTasks();
            aboutToShowThisContainer = null;
            return;
        }

        if("ContCart".equals(rootName)) {
            onCreateContCart();
            aboutToShowThisContainer = null;
            return;
        }

        if("Splash".equals(rootName)) {
            onCreateSplash();
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(rootName)) {
            onCreateMain();
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void onCreateContSettings() {
    }


    protected void onCreateRegistration() {
    }


    protected void onCreateContProfile() {
    }


    protected void onCreateLogin() {
    }


    protected void onCreateForgotPassword() {
    }


    protected void onCreateContSideMenu() {
    }


    protected void onCreateContDashBoard() {
    }


    protected void onCreateContProjects() {
    }


    protected void onCreateContTasks() {
    }


    protected void onCreateContCart() {
    }


    protected void onCreateSplash() {
    }


    protected void onCreateMain() {
    }

    protected Hashtable getFormState(Form f) {
        Hashtable h = super.getFormState(f);
        if("ContSettings".equals(f.getName())) {
            getStateContSettings(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("Registration".equals(f.getName())) {
            getStateRegistration(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("ContProfile".equals(f.getName())) {
            getStateContProfile(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("Login".equals(f.getName())) {
            getStateLogin(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("ForgotPassword".equals(f.getName())) {
            getStateForgotPassword(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("ContSideMenu".equals(f.getName())) {
            getStateContSideMenu(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("ContDashBoard".equals(f.getName())) {
            getStateContDashBoard(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("ContProjects".equals(f.getName())) {
            getStateContProjects(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("ContTasks".equals(f.getName())) {
            getStateContTasks(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("ContCart".equals(f.getName())) {
            getStateContCart(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("Splash".equals(f.getName())) {
            getStateSplash(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("Main".equals(f.getName())) {
            getStateMain(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

            return h;
    }


    protected void getStateContSettings(Form f, Hashtable h) {
    }


    protected void getStateRegistration(Form f, Hashtable h) {
    }


    protected void getStateContProfile(Form f, Hashtable h) {
    }


    protected void getStateLogin(Form f, Hashtable h) {
    }


    protected void getStateForgotPassword(Form f, Hashtable h) {
    }


    protected void getStateContSideMenu(Form f, Hashtable h) {
    }


    protected void getStateContDashBoard(Form f, Hashtable h) {
    }


    protected void getStateContProjects(Form f, Hashtable h) {
    }


    protected void getStateContTasks(Form f, Hashtable h) {
    }


    protected void getStateContCart(Form f, Hashtable h) {
    }


    protected void getStateSplash(Form f, Hashtable h) {
    }


    protected void getStateMain(Form f, Hashtable h) {
    }

    protected void setFormState(Form f, Hashtable state) {
        super.setFormState(f, state);
        if("ContSettings".equals(f.getName())) {
            setStateContSettings(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("Registration".equals(f.getName())) {
            setStateRegistration(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContProfile".equals(f.getName())) {
            setStateContProfile(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("Login".equals(f.getName())) {
            setStateLogin(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("ForgotPassword".equals(f.getName())) {
            setStateForgotPassword(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContSideMenu".equals(f.getName())) {
            setStateContSideMenu(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContDashBoard".equals(f.getName())) {
            setStateContDashBoard(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContProjects".equals(f.getName())) {
            setStateContProjects(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContTasks".equals(f.getName())) {
            setStateContTasks(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContCart".equals(f.getName())) {
            setStateContCart(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("Splash".equals(f.getName())) {
            setStateSplash(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(f.getName())) {
            setStateMain(f, state);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void setStateContSettings(Form f, Hashtable state) {
    }


    protected void setStateRegistration(Form f, Hashtable state) {
    }


    protected void setStateContProfile(Form f, Hashtable state) {
    }


    protected void setStateLogin(Form f, Hashtable state) {
    }


    protected void setStateForgotPassword(Form f, Hashtable state) {
    }


    protected void setStateContSideMenu(Form f, Hashtable state) {
    }


    protected void setStateContDashBoard(Form f, Hashtable state) {
    }


    protected void setStateContProjects(Form f, Hashtable state) {
    }


    protected void setStateContTasks(Form f, Hashtable state) {
    }


    protected void setStateContCart(Form f, Hashtable state) {
    }


    protected void setStateSplash(Form f, Hashtable state) {
    }


    protected void setStateMain(Form f, Hashtable state) {
    }

    protected void handleComponentAction(Component c, ActionEvent event) {
        Container rootContainerAncestor = getRootAncestor(c);
        if(rootContainerAncestor == null) return;
        String rootContainerName = rootContainerAncestor.getName();
        Container leadParentContainer = c.getParent().getLeadParent();
        if(leadParentContainer != null && leadParentContainer.getClass() != Container.class) {
            c = c.getParent().getLeadParent();
        }
        if(rootContainerName == null) return;
        if(rootContainerName.equals("ContSettings")) {
            if("txtHandle".equals(c.getName())) {
                onContSettings_TxtHandleAction(c, event);
                return;
            }
            if("btnSettingsSave".equals(c.getName())) {
                onContSettings_BtnSettingsSaveAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("Registration")) {
            if("txtStep1IDNumber".equals(c.getName())) {
                onRegistration_TxtStep1IDNumberAction(c, event);
                return;
            }
            if("btnStep1NoID".equals(c.getName())) {
                onRegistration_BtnStep1NoIDAction(c, event);
                return;
            }
            if("btnStep1Continue".equals(c.getName())) {
                onRegistration_BtnStep1ContinueAction(c, event);
                return;
            }
            if("pickerStep2Country".equals(c.getName())) {
                onRegistration_PickerStep2CountryAction(c, event);
                return;
            }
            if("txtStep2CellPhone".equals(c.getName())) {
                onRegistration_TxtStep2CellPhoneAction(c, event);
                return;
            }
            if("txtStep2Email".equals(c.getName())) {
                onRegistration_TxtStep2EmailAction(c, event);
                return;
            }
            if("txtStep2EmailRetype".equals(c.getName())) {
                onRegistration_TxtStep2EmailRetypeAction(c, event);
                return;
            }
            if("txtStep2TelephoneNumber".equals(c.getName())) {
                onRegistration_TxtStep2TelephoneNumberAction(c, event);
                return;
            }
            if("txtStep2FaxNumber".equals(c.getName())) {
                onRegistration_TxtStep2FaxNumberAction(c, event);
                return;
            }
            if("btnStep2Continue".equals(c.getName())) {
                onRegistration_BtnStep2ContinueAction(c, event);
                return;
            }
            if("txtStep3Address".equals(c.getName())) {
                onRegistration_TxtStep3AddressAction(c, event);
                return;
            }
            if("pickerStep3Province".equals(c.getName())) {
                onRegistration_PickerStep3ProvinceAction(c, event);
                return;
            }
            if("txtStep3City".equals(c.getName())) {
                onRegistration_TxtStep3CityAction(c, event);
                return;
            }
            if("txtStep3PostalCode".equals(c.getName())) {
                onRegistration_TxtStep3PostalCodeAction(c, event);
                return;
            }
            if("rdYes".equals(c.getName())) {
                onRegistration_RdYesAction(c, event);
                return;
            }
            if("rdNo".equals(c.getName())) {
                onRegistration_RdNoAction(c, event);
                return;
            }
            if("btnStep3Next".equals(c.getName())) {
                onRegistration_BtnStep3NextAction(c, event);
                return;
            }
            if("txtStep4CustomerCode".equals(c.getName())) {
                onRegistration_TxtStep4CustomerCodeAction(c, event);
                return;
            }
            if("btnStep4ViewPasswordRules".equals(c.getName())) {
                onRegistration_BtnStep4ViewPasswordRulesAction(c, event);
                return;
            }
            if("txtStep4Password".equals(c.getName())) {
                onRegistration_TxtStep4PasswordAction(c, event);
                return;
            }
            if("txtStep4PasswordRetype".equals(c.getName())) {
                onRegistration_TxtStep4PasswordRetypeAction(c, event);
                return;
            }
            if("btnStep4Register".equals(c.getName())) {
                onRegistration_BtnStep4RegisterAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("ContProfile")) {
            if("btnCamera".equals(c.getName())) {
                onContProfile_BtnCameraAction(c, event);
                return;
            }
            if("btnGallery".equals(c.getName())) {
                onContProfile_BtnGalleryAction(c, event);
                return;
            }
            if("txtEmail".equals(c.getName())) {
                onContProfile_TxtEmailAction(c, event);
                return;
            }
            if("txtFirstName".equals(c.getName())) {
                onContProfile_TxtFirstNameAction(c, event);
                return;
            }
            if("txtLastName".equals(c.getName())) {
                onContProfile_TxtLastNameAction(c, event);
                return;
            }
            if("btnUpdate".equals(c.getName())) {
                onContProfile_BtnUpdateAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("Login")) {
            if("txtCustomerCode".equals(c.getName())) {
                onLogin_TxtCustomerCodeAction(c, event);
                return;
            }
            if("txtPassword".equals(c.getName())) {
                onLogin_TxtPasswordAction(c, event);
                return;
            }
            if("btnLogin".equals(c.getName())) {
                onLogin_BtnLoginAction(c, event);
                return;
            }
            if("btnRegister".equals(c.getName())) {
                onLogin_BtnRegisterAction(c, event);
                return;
            }
            if("btnForgotPassword".equals(c.getName())) {
                onLogin_BtnForgotPasswordAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("ForgotPassword")) {
            if("txtEmail".equals(c.getName())) {
                onForgotPassword_TxtEmailAction(c, event);
                return;
            }
            if("txtEmail1".equals(c.getName())) {
                onForgotPassword_TxtEmail1Action(c, event);
                return;
            }
            if("btnRecoverPassword".equals(c.getName())) {
                onForgotPassword_BtnRecoverPasswordAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("ContSideMenu")) {
            if("btnProfilePic".equals(c.getName())) {
                onContSideMenu_BtnProfilePicAction(c, event);
                return;
            }
            if("btnProfileName".equals(c.getName())) {
                onContSideMenu_BtnProfileNameAction(c, event);
                return;
            }
            if("btnDashboard".equals(c.getName())) {
                onContSideMenu_BtnDashboardAction(c, event);
                return;
            }
            if("btnLogout".equals(c.getName())) {
                onContSideMenu_BtnLogoutAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("ContDashBoard")) {
            if("mbTasks".equals(c.getName())) {
                onContDashBoard_MbTasksAction(c, event);
                return;
            }
            if("mbCurrency".equals(c.getName())) {
                onContDashBoard_MbCurrencyAction(c, event);
                return;
            }
            if("mbCart".equals(c.getName())) {
                onContDashBoard_MbCartAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("ContProjects")) {
            if("TextArea".equals(c.getName())) {
                onContProjects_TextAreaAction(c, event);
                return;
            }
            if("txtStep1a".equals(c.getName())) {
                onContProjects_TxtStep1aAction(c, event);
                return;
            }
            if("txtStep1b".equals(c.getName())) {
                onContProjects_TxtStep1bAction(c, event);
                return;
            }
            if("txtStep1c".equals(c.getName())) {
                onContProjects_TxtStep1cAction(c, event);
                return;
            }
            if("btnStep1RetrieveDetails".equals(c.getName())) {
                onContProjects_BtnStep1RetrieveDetailsAction(c, event);
                return;
            }
            if("btnStep2Confirm".equals(c.getName())) {
                onContProjects_BtnStep2ConfirmAction(c, event);
                return;
            }
            if("TextField3".equals(c.getName())) {
                onContProjects_TextField3Action(c, event);
                return;
            }
            if("btnStep3CalcOutAmount".equals(c.getName())) {
                onContProjects_BtnStep3CalcOutAmountAction(c, event);
                return;
            }
            if("MultiButton".equals(c.getName())) {
                onContProjects_MultiButtonAction(c, event);
                return;
            }
            if("btnStep4AddToCart".equals(c.getName())) {
                onContProjects_BtnStep4AddToCartAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("ContTasks")) {
            if("txtLine1".equals(c.getName())) {
                onContTasks_TxtLine1Action(c, event);
                return;
            }
            if("txtName1".equals(c.getName())) {
                onContTasks_TxtName1Action(c, event);
                return;
            }
            if("txtName2".equals(c.getName())) {
                onContTasks_TxtName2Action(c, event);
                return;
            }
            if("txtName3".equals(c.getName())) {
                onContTasks_TxtName3Action(c, event);
                return;
            }
            if("txtName4".equals(c.getName())) {
                onContTasks_TxtName4Action(c, event);
                return;
            }
            if("TextArea1".equals(c.getName())) {
                onContTasks_TextArea1Action(c, event);
                return;
            }
            if("btnVerify".equals(c.getName())) {
                onContTasks_BtnVerifyAction(c, event);
                return;
            }
            if("btnLodge".equals(c.getName())) {
                onContTasks_BtnLodgeAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("ContCart")) {
            if("MultiButton".equals(c.getName())) {
                onContCart_MultiButtonAction(c, event);
                return;
            }
            if("Button1".equals(c.getName())) {
                onContCart_Button1Action(c, event);
                return;
            }
            if("Button".equals(c.getName())) {
                onContCart_ButtonAction(c, event);
                return;
            }
            if("txtStep1a".equals(c.getName())) {
                onContCart_TxtStep1aAction(c, event);
                return;
            }
            if("txtStep1a2".equals(c.getName())) {
                onContCart_TxtStep1a2Action(c, event);
                return;
            }
            if("txtStep1a3".equals(c.getName())) {
                onContCart_TxtStep1a3Action(c, event);
                return;
            }
            if("txtStep1a4".equals(c.getName())) {
                onContCart_TxtStep1a4Action(c, event);
                return;
            }
            if("txtStep1a1".equals(c.getName())) {
                onContCart_TxtStep1a1Action(c, event);
                return;
            }
            if("Button2".equals(c.getName())) {
                onContCart_Button2Action(c, event);
                return;
            }
        }
    }

      protected void onContSettings_TxtHandleAction(Component c, ActionEvent event) {
      }

      protected void onContSettings_BtnSettingsSaveAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_TxtStep1IDNumberAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_BtnStep1NoIDAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_BtnStep1ContinueAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_PickerStep2CountryAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_TxtStep2CellPhoneAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_TxtStep2EmailAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_TxtStep2EmailRetypeAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_TxtStep2TelephoneNumberAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_TxtStep2FaxNumberAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_BtnStep2ContinueAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_TxtStep3AddressAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_PickerStep3ProvinceAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_TxtStep3CityAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_TxtStep3PostalCodeAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_RdYesAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_RdNoAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_BtnStep3NextAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_TxtStep4CustomerCodeAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_BtnStep4ViewPasswordRulesAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_TxtStep4PasswordAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_TxtStep4PasswordRetypeAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_BtnStep4RegisterAction(Component c, ActionEvent event) {
      }

      protected void onContProfile_BtnCameraAction(Component c, ActionEvent event) {
      }

      protected void onContProfile_BtnGalleryAction(Component c, ActionEvent event) {
      }

      protected void onContProfile_TxtEmailAction(Component c, ActionEvent event) {
      }

      protected void onContProfile_TxtFirstNameAction(Component c, ActionEvent event) {
      }

      protected void onContProfile_TxtLastNameAction(Component c, ActionEvent event) {
      }

      protected void onContProfile_BtnUpdateAction(Component c, ActionEvent event) {
      }

      protected void onLogin_TxtCustomerCodeAction(Component c, ActionEvent event) {
      }

      protected void onLogin_TxtPasswordAction(Component c, ActionEvent event) {
      }

      protected void onLogin_BtnLoginAction(Component c, ActionEvent event) {
      }

      protected void onLogin_BtnRegisterAction(Component c, ActionEvent event) {
      }

      protected void onLogin_BtnForgotPasswordAction(Component c, ActionEvent event) {
      }

      protected void onForgotPassword_TxtEmailAction(Component c, ActionEvent event) {
      }

      protected void onForgotPassword_TxtEmail1Action(Component c, ActionEvent event) {
      }

      protected void onForgotPassword_BtnRecoverPasswordAction(Component c, ActionEvent event) {
      }

      protected void onContSideMenu_BtnProfilePicAction(Component c, ActionEvent event) {
      }

      protected void onContSideMenu_BtnProfileNameAction(Component c, ActionEvent event) {
      }

      protected void onContSideMenu_BtnDashboardAction(Component c, ActionEvent event) {
      }

      protected void onContSideMenu_BtnLogoutAction(Component c, ActionEvent event) {
      }

      protected void onContDashBoard_MbTasksAction(Component c, ActionEvent event) {
      }

      protected void onContDashBoard_MbCurrencyAction(Component c, ActionEvent event) {
      }

      protected void onContDashBoard_MbCartAction(Component c, ActionEvent event) {
      }

      protected void onContProjects_TextAreaAction(Component c, ActionEvent event) {
      }

      protected void onContProjects_TxtStep1aAction(Component c, ActionEvent event) {
      }

      protected void onContProjects_TxtStep1bAction(Component c, ActionEvent event) {
      }

      protected void onContProjects_TxtStep1cAction(Component c, ActionEvent event) {
      }

      protected void onContProjects_BtnStep1RetrieveDetailsAction(Component c, ActionEvent event) {
      }

      protected void onContProjects_BtnStep2ConfirmAction(Component c, ActionEvent event) {
      }

      protected void onContProjects_TextField3Action(Component c, ActionEvent event) {
      }

      protected void onContProjects_BtnStep3CalcOutAmountAction(Component c, ActionEvent event) {
      }

      protected void onContProjects_MultiButtonAction(Component c, ActionEvent event) {
      }

      protected void onContProjects_BtnStep4AddToCartAction(Component c, ActionEvent event) {
      }

      protected void onContTasks_TxtLine1Action(Component c, ActionEvent event) {
      }

      protected void onContTasks_TxtName1Action(Component c, ActionEvent event) {
      }

      protected void onContTasks_TxtName2Action(Component c, ActionEvent event) {
      }

      protected void onContTasks_TxtName3Action(Component c, ActionEvent event) {
      }

      protected void onContTasks_TxtName4Action(Component c, ActionEvent event) {
      }

      protected void onContTasks_TextArea1Action(Component c, ActionEvent event) {
      }

      protected void onContTasks_BtnVerifyAction(Component c, ActionEvent event) {
      }

      protected void onContTasks_BtnLodgeAction(Component c, ActionEvent event) {
      }

      protected void onContCart_MultiButtonAction(Component c, ActionEvent event) {
      }

      protected void onContCart_Button1Action(Component c, ActionEvent event) {
      }

      protected void onContCart_ButtonAction(Component c, ActionEvent event) {
      }

      protected void onContCart_TxtStep1aAction(Component c, ActionEvent event) {
      }

      protected void onContCart_TxtStep1a2Action(Component c, ActionEvent event) {
      }

      protected void onContCart_TxtStep1a3Action(Component c, ActionEvent event) {
      }

      protected void onContCart_TxtStep1a4Action(Component c, ActionEvent event) {
      }

      protected void onContCart_TxtStep1a1Action(Component c, ActionEvent event) {
      }

      protected void onContCart_Button2Action(Component c, ActionEvent event) {
      }

}
