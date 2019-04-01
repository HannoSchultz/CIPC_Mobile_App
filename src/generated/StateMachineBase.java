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
        UIBuilder.registerCustomComponent("Table", com.codename1.ui.table.Table.class);
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("TextArea", com.codename1.ui.TextArea.class);
        UIBuilder.registerCustomComponent("ComboBox", com.codename1.ui.ComboBox.class);
        UIBuilder.registerCustomComponent("Label", com.codename1.ui.Label.class);
        UIBuilder.registerCustomComponent("SpanLabel", com.codename1.components.SpanLabel.class);
        UIBuilder.registerCustomComponent("RadioButton", com.codename1.ui.RadioButton.class);
        UIBuilder.registerCustomComponent("Container", com.codename1.ui.Container.class);
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("CheckBox", com.codename1.ui.CheckBox.class);
        UIBuilder.registerCustomComponent("Dialog", com.codename1.ui.Dialog.class);
        UIBuilder.registerCustomComponent("Picker", com.codename1.ui.spinner.Picker.class);
        UIBuilder.registerCustomComponent("Tabs", com.codename1.ui.Tabs.class);
        UIBuilder.registerCustomComponent("TextField", com.codename1.ui.TextField.class);
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
        return "Registration";
    }

    public Container createWidget(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("Table", com.codename1.ui.table.Table.class);
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("TextArea", com.codename1.ui.TextArea.class);
        UIBuilder.registerCustomComponent("ComboBox", com.codename1.ui.ComboBox.class);
        UIBuilder.registerCustomComponent("Label", com.codename1.ui.Label.class);
        UIBuilder.registerCustomComponent("SpanLabel", com.codename1.components.SpanLabel.class);
        UIBuilder.registerCustomComponent("RadioButton", com.codename1.ui.RadioButton.class);
        UIBuilder.registerCustomComponent("Container", com.codename1.ui.Container.class);
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("CheckBox", com.codename1.ui.CheckBox.class);
        UIBuilder.registerCustomComponent("Dialog", com.codename1.ui.Dialog.class);
        UIBuilder.registerCustomComponent("Picker", com.codename1.ui.spinner.Picker.class);
        UIBuilder.registerCustomComponent("Tabs", com.codename1.ui.Tabs.class);
        UIBuilder.registerCustomComponent("TextField", com.codename1.ui.TextField.class);
        UIBuilder.registerCustomComponent("MultiButton", com.codename1.components.MultiButton.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    res = Resources.openLayered(resPath);
                } catch(java.io.IOException err) { err.printStackTrace(); }
            }
            initTheme(res);
        }
        return createContainer(resPath, "Registration");
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

    public com.codename1.ui.Label findLblEntNo(Component root) {
        return (com.codename1.ui.Label)findByName("lbl_ent_no", root);
    }

    public com.codename1.ui.Label findLblEntNo() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("lbl_ent_no", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("lbl_ent_no", aboutToShowThisContainer);
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

    public com.codename1.ui.TextField findTxtARStep2CellNumber(Component root) {
        return (com.codename1.ui.TextField)findByName("txtARStep2CellNumber", root);
    }

    public com.codename1.ui.TextField findTxtARStep2CellNumber() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtARStep2CellNumber", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtARStep2CellNumber", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findMbRegistration(Component root) {
        return (com.codename1.ui.Button)findByName("mbRegistration", root);
    }

    public com.codename1.ui.Button findMbRegistration() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("mbRegistration", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("mbRegistration", aboutToShowThisContainer);
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

    public com.codename1.ui.Label findLblVersion(Component root) {
        return (com.codename1.ui.Label)findByName("lblVersion", root);
    }

    public com.codename1.ui.Label findLblVersion() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("lblVersion", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("lblVersion", aboutToShowThisContainer);
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

    public com.codename1.ui.spinner.Picker findDtAppDate(Component root) {
        return (com.codename1.ui.spinner.Picker)findByName("dtAppDate", root);
    }

    public com.codename1.ui.spinner.Picker findDtAppDate() {
        com.codename1.ui.spinner.Picker cmp = (com.codename1.ui.spinner.Picker)findByName("dtAppDate", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.spinner.Picker)findByName("dtAppDate", aboutToShowThisContainer);
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

    public com.codename1.ui.Container findCondirinfo(Component root) {
        return (com.codename1.ui.Container)findByName("Condirinfo", root);
    }

    public com.codename1.ui.Container findCondirinfo() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Condirinfo", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Condirinfo", aboutToShowThisContainer);
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

    public com.codename1.ui.Button findBtncopyphysicaladdress(Component root) {
        return (com.codename1.ui.Button)findByName("Btncopyphysicaladdress", root);
    }

    public com.codename1.ui.Button findBtncopyphysicaladdress() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Btncopyphysicaladdress", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Btncopyphysicaladdress", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findConEmail(Component root) {
        return (com.codename1.ui.Container)findByName("ConEmail", root);
    }

    public com.codename1.ui.Container findConEmail() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ConEmail", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ConEmail", aboutToShowThisContainer);
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

    public com.codename1.ui.Container findAR(Component root) {
        return (com.codename1.ui.Container)findByName("AR", root);
    }

    public com.codename1.ui.Container findAR() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("AR", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("AR", aboutToShowThisContainer);
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

    public com.codename1.ui.Container findConCell(Component root) {
        return (com.codename1.ui.Container)findByName("ConCell", root);
    }

    public com.codename1.ui.Container findConCell() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ConCell", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ConCell", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findConMenu(Component root) {
        return (com.codename1.ui.Container)findByName("ConMenu", root);
    }

    public com.codename1.ui.Container findConMenu() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ConMenu", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ConMenu", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtStep2FirstName(Component root) {
        return (com.codename1.ui.TextField)findByName("txtStep2FirstName", root);
    }

    public com.codename1.ui.TextField findTxtStep2FirstName() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtStep2FirstName", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtStep2FirstName", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findBE(Component root) {
        return (com.codename1.ui.Container)findByName("BE", root);
    }

    public com.codename1.ui.Container findBE() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("BE", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("BE", aboutToShowThisContainer);
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

    public com.codename1.ui.TextField findTxtAuthShares(Component root) {
        return (com.codename1.ui.TextField)findByName("TxtAuthShares", root);
    }

    public com.codename1.ui.TextField findTxtAuthShares() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("TxtAuthShares", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("TxtAuthShares", aboutToShowThisContainer);
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

    public com.codename1.ui.Container findConPhysAddr(Component root) {
        return (com.codename1.ui.Container)findByName("ConPhysAddr", root);
    }

    public com.codename1.ui.Container findConPhysAddr() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ConPhysAddr", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ConPhysAddr", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnStartNewReg(Component root) {
        return (com.codename1.ui.Button)findByName("BtnStartNewReg", root);
    }

    public com.codename1.ui.Button findBtnStartNewReg() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("BtnStartNewReg", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("BtnStartNewReg", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLblApprovedName(Component root) {
        return (com.codename1.ui.Label)findByName("LblApprovedName", root);
    }

    public com.codename1.ui.Label findLblApprovedName() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("LblApprovedName", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("LblApprovedName", aboutToShowThisContainer);
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

    public com.codename1.ui.Container findConSubmitName(Component root) {
        return (com.codename1.ui.Container)findByName("ConSubmitName", root);
    }

    public com.codename1.ui.Container findConSubmitName() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ConSubmitName", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ConSubmitName", aboutToShowThisContainer);
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

    public com.codename1.ui.Button findBtnRegisterenterpris(Component root) {
        return (com.codename1.ui.Button)findByName("BtnRegisterenterpris", root);
    }

    public com.codename1.ui.Button findBtnRegisterenterpris() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("BtnRegisterenterpris", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("BtnRegisterenterpris", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findConaddDirector(Component root) {
        return (com.codename1.ui.Container)findByName("ConaddDirector", root);
    }

    public com.codename1.ui.Container findConaddDirector() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ConaddDirector", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ConaddDirector", aboutToShowThisContainer);
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

    public com.codename1.ui.ComboBox findCmbFyeMonth(Component root) {
        return (com.codename1.ui.ComboBox)findByName("CmbFyeMonth", root);
    }

    public com.codename1.ui.ComboBox findCmbFyeMonth() {
        com.codename1.ui.ComboBox cmp = (com.codename1.ui.ComboBox)findByName("CmbFyeMonth", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.ComboBox)findByName("CmbFyeMonth", aboutToShowThisContainer);
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

    public com.codename1.ui.Container findConmemlist(Component root) {
        return (com.codename1.ui.Container)findByName("Conmemlist", root);
    }

    public com.codename1.ui.Container findConmemlist() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Conmemlist", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Conmemlist", aboutToShowThisContainer);
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

    public com.codename1.ui.Container findCP(Component root) {
        return (com.codename1.ui.Container)findByName("CP", root);
    }

    public com.codename1.ui.Container findCP() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("CP", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("CP", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findCR(Component root) {
        return (com.codename1.ui.Container)findByName("CR", root);
    }

    public com.codename1.ui.Container findCR() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("CR", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("CR", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnCheckout(Component root) {
        return (com.codename1.ui.Button)findByName("btnCheckout", root);
    }

    public com.codename1.ui.Button findBtnCheckout() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnCheckout", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnCheckout", aboutToShowThisContainer);
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

    public com.codename1.ui.Container findContStep1EServices(Component root) {
        return (com.codename1.ui.Container)findByName("contStep1EServices", root);
    }

    public com.codename1.ui.Container findContStep1EServices() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("contStep1EServices", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("contStep1EServices", aboutToShowThisContainer);
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

    public com.codename1.ui.Container findConENtType(Component root) {
        return (com.codename1.ui.Container)findByName("ConENtType", root);
    }

    public com.codename1.ui.Container findConENtType() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ConENtType", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ConENtType", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextArea findTxtARStep2WebAddress(Component root) {
        return (com.codename1.ui.TextArea)findByName("txtARStep2WebAddress", root);
    }

    public com.codename1.ui.TextArea findTxtARStep2WebAddress() {
        com.codename1.ui.TextArea cmp = (com.codename1.ui.TextArea)findByName("txtARStep2WebAddress", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextArea)findByName("txtARStep2WebAddress", aboutToShowThisContainer);
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

    public com.codename1.ui.Container findDC(Component root) {
        return (com.codename1.ui.Container)findByName("DC", root);
    }

    public com.codename1.ui.Container findDC() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("DC", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("DC", aboutToShowThisContainer);
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

    public com.codename1.ui.Button findMbBEE(Component root) {
        return (com.codename1.ui.Button)findByName("mbBEE", root);
    }

    public com.codename1.ui.Button findMbBEE() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("mbBEE", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("mbBEE", aboutToShowThisContainer);
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

    public com.codename1.ui.Label findLabel19(Component root) {
        return (com.codename1.ui.Label)findByName("Label19", root);
    }

    public com.codename1.ui.Label findLabel19() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label19", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label19", aboutToShowThisContainer);
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

    public com.codename1.ui.TextField findTxtEntPhysAddr2(Component root) {
        return (com.codename1.ui.TextField)findByName("txtEntPhysAddr2", root);
    }

    public com.codename1.ui.TextField findTxtEntPhysAddr2() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtEntPhysAddr2", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtEntPhysAddr2", aboutToShowThisContainer);
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

    public com.codename1.ui.TextField findTxtEntPhysAddr3(Component root) {
        return (com.codename1.ui.TextField)findByName("txtEntPhysAddr3", root);
    }

    public com.codename1.ui.TextField findTxtEntPhysAddr3() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtEntPhysAddr3", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtEntPhysAddr3", aboutToShowThisContainer);
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

    public com.codename1.ui.Label findLabel15(Component root) {
        return (com.codename1.ui.Label)findByName("Label15", root);
    }

    public com.codename1.ui.Label findLabel15() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label15", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label15", aboutToShowThisContainer);
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

    public com.codename1.ui.TextField findTxtEntPhysAddr1(Component root) {
        return (com.codename1.ui.TextField)findByName("txtEntPhysAddr1", root);
    }

    public com.codename1.ui.TextField findTxtEntPhysAddr1() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtEntPhysAddr1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtEntPhysAddr1", aboutToShowThisContainer);
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

    public com.codename1.ui.Label findLabel17(Component root) {
        return (com.codename1.ui.Label)findByName("Label17", root);
    }

    public com.codename1.ui.Label findLabel17() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label17", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label17", aboutToShowThisContainer);
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

    public com.codename1.ui.Label findLabel18(Component root) {
        return (com.codename1.ui.Label)findByName("Label18", root);
    }

    public com.codename1.ui.Label findLabel18() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label18", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label18", aboutToShowThisContainer);
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

    public com.codename1.ui.Label findLblNames(Component root) {
        return (com.codename1.ui.Label)findByName("LblNames", root);
    }

    public com.codename1.ui.Label findLblNames() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("LblNames", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("LblNames", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtOtp(Component root) {
        return (com.codename1.ui.TextField)findByName("TxtOtp", root);
    }

    public com.codename1.ui.TextField findTxtOtp() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("TxtOtp", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("TxtOtp", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContProfile(Component root) {
        return (com.codename1.ui.Container)findByName("contProfile", root);
    }

    public com.codename1.ui.Container findContProfile() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("contProfile", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("contProfile", aboutToShowThisContainer);
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

    public com.codename1.ui.TextArea findTxtARStep2BusinessDescription(Component root) {
        return (com.codename1.ui.TextArea)findByName("txtARStep2BusinessDescription", root);
    }

    public com.codename1.ui.TextArea findTxtARStep2BusinessDescription() {
        com.codename1.ui.TextArea cmp = (com.codename1.ui.TextArea)findByName("txtARStep2BusinessDescription", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextArea)findByName("txtARStep2BusinessDescription", aboutToShowThisContainer);
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

    public com.codename1.ui.Button findBtnOk(Component root) {
        return (com.codename1.ui.Button)findByName("btnOk", root);
    }

    public com.codename1.ui.Button findBtnOk() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnOk", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnOk", aboutToShowThisContainer);
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

    public com.codename1.ui.Container findContent(Component root) {
        return (com.codename1.ui.Container)findByName("content", root);
    }

    public com.codename1.ui.Container findContent() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("content", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("content", aboutToShowThisContainer);
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

    public com.codename1.ui.Button findBtnverifyOtp(Component root) {
        return (com.codename1.ui.Button)findByName("BtnverifyOtp", root);
    }

    public com.codename1.ui.Button findBtnverifyOtp() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("BtnverifyOtp", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("BtnverifyOtp", aboutToShowThisContainer);
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

    public com.codename1.ui.Container findConAppointDate(Component root) {
        return (com.codename1.ui.Container)findByName("ConAppointDate", root);
    }

    public com.codename1.ui.Container findConAppointDate() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ConAppointDate", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ConAppointDate", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnexit(Component root) {
        return (com.codename1.ui.Button)findByName("Btnexit", root);
    }

    public com.codename1.ui.Button findBtnexit() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Btnexit", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Btnexit", aboutToShowThisContainer);
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

    public com.codename1.ui.TextField findTxtApprovedNo(Component root) {
        return (com.codename1.ui.TextField)findByName("TxtApprovedNo", root);
    }

    public com.codename1.ui.TextField findTxtApprovedNo() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("TxtApprovedNo", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("TxtApprovedNo", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnGetIdInfo(Component root) {
        return (com.codename1.ui.Button)findByName("BtnGetIdInfo", root);
    }

    public com.codename1.ui.Button findBtnGetIdInfo() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("BtnGetIdInfo", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("BtnGetIdInfo", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtARStep2TelNo(Component root) {
        return (com.codename1.ui.TextField)findByName("txtARStep2TelNo", root);
    }

    public com.codename1.ui.TextField findTxtARStep2TelNo() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtARStep2TelNo", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtARStep2TelNo", aboutToShowThisContainer);
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

    public com.codename1.ui.Button findBtnViewTerms(Component root) {
        return (com.codename1.ui.Button)findByName("btnViewTerms", root);
    }

    public com.codename1.ui.Button findBtnViewTerms() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnViewTerms", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnViewTerms", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findDashContent(Component root) {
        return (com.codename1.ui.Container)findByName("DashContent", root);
    }

    public com.codename1.ui.Container findDashContent() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("DashContent", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("DashContent", aboutToShowThisContainer);
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

    public com.codename1.ui.Button findBtnFileNamereservation(Component root) {
        return (com.codename1.ui.Button)findByName("BtnFileNamereservation", root);
    }

    public com.codename1.ui.Button findBtnFileNamereservation() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("BtnFileNamereservation", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("BtnFileNamereservation", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.ComboBox findCmbdirectortype(Component root) {
        return (com.codename1.ui.ComboBox)findByName("Cmbdirectortype", root);
    }

    public com.codename1.ui.ComboBox findCmbdirectortype() {
        com.codename1.ui.ComboBox cmp = (com.codename1.ui.ComboBox)findByName("Cmbdirectortype", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.ComboBox)findByName("Cmbdirectortype", aboutToShowThisContainer);
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

    public com.codename1.ui.TextField findTxtEntPhysCode(Component root) {
        return (com.codename1.ui.TextField)findByName("txtEntPhysCode", root);
    }

    public com.codename1.ui.TextField findTxtEntPhysCode() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtEntPhysCode", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtEntPhysCode", aboutToShowThisContainer);
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

    public com.codename1.ui.Label findLblResponse4(Component root) {
        return (com.codename1.ui.Label)findByName("lblResponse4", root);
    }

    public com.codename1.ui.Label findLblResponse4() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("lblResponse4", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("lblResponse4", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtEntEmail(Component root) {
        return (com.codename1.ui.TextField)findByName("TxtEntEmail", root);
    }

    public com.codename1.ui.TextField findTxtEntEmail() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("TxtEntEmail", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("TxtEntEmail", aboutToShowThisContainer);
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

    public com.codename1.ui.Label findLblResponse3(Component root) {
        return (com.codename1.ui.Label)findByName("lblResponse3", root);
    }

    public com.codename1.ui.Label findLblResponse3() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("lblResponse3", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("lblResponse3", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findConInfo(Component root) {
        return (com.codename1.ui.Container)findByName("ConInfo", root);
    }

    public com.codename1.ui.Container findConInfo() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ConInfo", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ConInfo", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtEmail(Component root) {
        return (com.codename1.ui.TextField)findByName("TxtEmail", root);
    }

    public com.codename1.ui.TextField findTxtEmail() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("TxtEmail", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("TxtEmail", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLblResponse2(Component root) {
        return (com.codename1.ui.Label)findByName("lblResponse2", root);
    }

    public com.codename1.ui.Label findLblResponse2() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("lblResponse2", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("lblResponse2", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLblResponse1(Component root) {
        return (com.codename1.ui.Label)findByName("lblResponse1", root);
    }

    public com.codename1.ui.Label findLblResponse1() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("lblResponse1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("lblResponse1", aboutToShowThisContainer);
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

    public com.codename1.ui.Button findMbDisclosure(Component root) {
        return (com.codename1.ui.Button)findByName("mbDisclosure", root);
    }

    public com.codename1.ui.Button findMbDisclosure() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("mbDisclosure", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("mbDisclosure", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findConNames(Component root) {
        return (com.codename1.ui.Container)findByName("ConNames", root);
    }

    public com.codename1.ui.Container findConNames() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ConNames", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ConNames", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findButtoncondir(Component root) {
        return (com.codename1.ui.Button)findByName("Buttoncondir", root);
    }

    public com.codename1.ui.Button findButtoncondir() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Buttoncondir", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Buttoncondir", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findMbTasks(Component root) {
        return (com.codename1.ui.Button)findByName("mbTasks", root);
    }

    public com.codename1.ui.Button findMbTasks() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("mbTasks", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("mbTasks", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtncopyphysaddress(Component root) {
        return (com.codename1.ui.Button)findByName("btncopyphysaddress", root);
    }

    public com.codename1.ui.Button findBtncopyphysaddress() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btncopyphysaddress", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btncopyphysaddress", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnDoNotAccept(Component root) {
        return (com.codename1.ui.Button)findByName("btnDoNotAccept", root);
    }

    public com.codename1.ui.Button findBtnDoNotAccept() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnDoNotAccept", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnDoNotAccept", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.CheckBox findChbIncorporator(Component root) {
        return (com.codename1.ui.CheckBox)findByName("chbIncorporator", root);
    }

    public com.codename1.ui.CheckBox findChbIncorporator() {
        com.codename1.ui.CheckBox cmp = (com.codename1.ui.CheckBox)findByName("chbIncorporator", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.CheckBox)findByName("chbIncorporator", aboutToShowThisContainer);
        }
        return cmp;
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

    public com.codename1.ui.TextField findTxtCell(Component root) {
        return (com.codename1.ui.TextField)findByName("TxtCell", root);
    }

    public com.codename1.ui.TextField findTxtCell() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("TxtCell", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("TxtCell", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtARStep2TelCode(Component root) {
        return (com.codename1.ui.TextField)findByName("txtARStep2TelCode", root);
    }

    public com.codename1.ui.TextField findTxtARStep2TelCode() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtARStep2TelCode", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtARStep2TelCode", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findAppVersion(Component root) {
        return (com.codename1.ui.Label)findByName("appVersion", root);
    }

    public com.codename1.ui.Label findAppVersion() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("appVersion", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("appVersion", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.table.Table findTableEntBee(Component root) {
        return (com.codename1.ui.table.Table)findByName("Table_ent_Bee", root);
    }

    public com.codename1.ui.table.Table findTableEntBee() {
        com.codename1.ui.table.Table cmp = (com.codename1.ui.table.Table)findByName("Table_ent_Bee", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.table.Table)findByName("Table_ent_Bee", aboutToShowThisContainer);
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

    public com.codename1.ui.Container findConApprovedName(Component root) {
        return (com.codename1.ui.Container)findByName("ConApprovedName", root);
    }

    public com.codename1.ui.Container findConApprovedName() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ConApprovedName", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ConApprovedName", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findConPhysAddress(Component root) {
        return (com.codename1.ui.Container)findByName("ConPhysAddress", root);
    }

    public com.codename1.ui.Container findConPhysAddress() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ConPhysAddress", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ConPhysAddress", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findConIDandnames(Component root) {
        return (com.codename1.ui.Container)findByName("ConIDandnames", root);
    }

    public com.codename1.ui.Container findConIDandnames() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ConIDandnames", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ConIDandnames", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findCont(Component root) {
        return (com.codename1.ui.Container)findByName("cont", root);
    }

    public com.codename1.ui.Container findCont() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("cont", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("cont", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer134(Component root) {
        return (com.codename1.ui.Container)findByName("Container134", root);
    }

    public com.codename1.ui.Container findContainer134() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container134", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container134", aboutToShowThisContainer);
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

    public com.codename1.ui.Button findBtnvalno(Component root) {
        return (com.codename1.ui.Button)findByName("btnvalno", root);
    }

    public com.codename1.ui.Button findBtnvalno() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnvalno", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnvalno", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContAutShares(Component root) {
        return (com.codename1.ui.Container)findByName("ContAutShares", root);
    }

    public com.codename1.ui.Container findContAutShares() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ContAutShares", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ContAutShares", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer133(Component root) {
        return (com.codename1.ui.Container)findByName("Container133", root);
    }

    public com.codename1.ui.Container findContainer133() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container133", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container133", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer135(Component root) {
        return (com.codename1.ui.Container)findByName("Container135", root);
    }

    public com.codename1.ui.Container findContainer135() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container135", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container135", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLbldirbirthdate(Component root) {
        return (com.codename1.ui.Label)findByName("lbldirbirthdate", root);
    }

    public com.codename1.ui.Label findLbldirbirthdate() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("lbldirbirthdate", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("lbldirbirthdate", aboutToShowThisContainer);
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

    public com.codename1.ui.Button findBtnFileName(Component root) {
        return (com.codename1.ui.Button)findByName("BtnFileName", root);
    }

    public com.codename1.ui.Button findBtnFileName() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("BtnFileName", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("BtnFileName", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.CheckBox findChkNoShow(Component root) {
        return (com.codename1.ui.CheckBox)findByName("chkNoShow", root);
    }

    public com.codename1.ui.CheckBox findChkNoShow() {
        com.codename1.ui.CheckBox cmp = (com.codename1.ui.CheckBox)findByName("chkNoShow", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.CheckBox)findByName("chkNoShow", aboutToShowThisContainer);
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

    public com.codename1.ui.Container findConPostalAddress(Component root) {
        return (com.codename1.ui.Container)findByName("ConPostalAddress", root);
    }

    public com.codename1.ui.Container findConPostalAddress() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ConPostalAddress", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ConPostalAddress", aboutToShowThisContainer);
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

    public com.codename1.ui.Container findContainer132(Component root) {
        return (com.codename1.ui.Container)findByName("Container132", root);
    }

    public com.codename1.ui.Container findContainer132() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container132", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container132", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.ComboBox findCmbenttype(Component root) {
        return (com.codename1.ui.ComboBox)findByName("Cmbenttype", root);
    }

    public com.codename1.ui.ComboBox findCmbenttype() {
        com.codename1.ui.ComboBox cmp = (com.codename1.ui.ComboBox)findByName("Cmbenttype", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.ComboBox)findByName("Cmbenttype", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer131(Component root) {
        return (com.codename1.ui.Container)findByName("Container131", root);
    }

    public com.codename1.ui.Container findContainer131() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container131", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container131", aboutToShowThisContainer);
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

    public com.codename1.ui.TextField findTxtname3(Component root) {
        return (com.codename1.ui.TextField)findByName("Txtname3", root);
    }

    public com.codename1.ui.TextField findTxtname3() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("Txtname3", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("Txtname3", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtname4(Component root) {
        return (com.codename1.ui.TextField)findByName("Txtname4", root);
    }

    public com.codename1.ui.TextField findTxtname4() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("Txtname4", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("Txtname4", aboutToShowThisContainer);
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

    public com.codename1.ui.Button findBtnconreg(Component root) {
        return (com.codename1.ui.Button)findByName("btnconreg", root);
    }

    public com.codename1.ui.Button findBtnconreg() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnconreg", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnconreg", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtname1(Component root) {
        return (com.codename1.ui.TextField)findByName("Txtname1", root);
    }

    public com.codename1.ui.TextField findTxtname1() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("Txtname1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("Txtname1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtname2(Component root) {
        return (com.codename1.ui.TextField)findByName("Txtname2", root);
    }

    public com.codename1.ui.TextField findTxtname2() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("Txtname2", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("Txtname2", aboutToShowThisContainer);
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

    public com.codename1.ui.Container findContainerd(Component root) {
        return (com.codename1.ui.Container)findByName("Containerd", root);
    }

    public com.codename1.ui.Container findContainerd() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Containerd", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Containerd", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLblIdNo(Component root) {
        return (com.codename1.ui.Label)findByName("LblIdNo", root);
    }

    public com.codename1.ui.Label findLblIdNo() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("LblIdNo", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("LblIdNo", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findMbCurrency(Component root) {
        return (com.codename1.ui.Button)findByName("mbCurrency", root);
    }

    public com.codename1.ui.Button findMbCurrency() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("mbCurrency", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("mbCurrency", aboutToShowThisContainer);
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

    public com.codename1.ui.Container findStep3PostalCont(Component root) {
        return (com.codename1.ui.Container)findByName("step3PostalCont", root);
    }

    public com.codename1.ui.Container findStep3PostalCont() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("step3PostalCont", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("step3PostalCont", aboutToShowThisContainer);
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

    public com.codename1.ui.Label findLblIcon1(Component root) {
        return (com.codename1.ui.Label)findByName("lblIcon1", root);
    }

    public com.codename1.ui.Label findLblIcon1() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("lblIcon1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("lblIcon1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLblIcon2(Component root) {
        return (com.codename1.ui.Label)findByName("lblIcon2", root);
    }

    public com.codename1.ui.Label findLblIcon2() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("lblIcon2", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("lblIcon2", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.table.Table findTable(Component root) {
        return (com.codename1.ui.table.Table)findByName("Table", root);
    }

    public com.codename1.ui.table.Table findTable() {
        com.codename1.ui.table.Table cmp = (com.codename1.ui.table.Table)findByName("Table", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.table.Table)findByName("Table", aboutToShowThisContainer);
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

    public com.codename1.ui.Label findLblIcon3(Component root) {
        return (com.codename1.ui.Label)findByName("lblIcon3", root);
    }

    public com.codename1.ui.Label findLblIcon3() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("lblIcon3", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("lblIcon3", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLblIcon4(Component root) {
        return (com.codename1.ui.Label)findByName("lblIcon4", root);
    }

    public com.codename1.ui.Label findLblIcon4() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("lblIcon4", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("lblIcon4", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel20(Component root) {
        return (com.codename1.ui.Label)findByName("Label20", root);
    }

    public com.codename1.ui.Label findLabel20() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label20", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label20", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLblIcon5(Component root) {
        return (com.codename1.ui.Label)findByName("lblIcon5", root);
    }

    public com.codename1.ui.Label findLblIcon5() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("lblIcon5", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("lblIcon5", aboutToShowThisContainer);
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

    public com.codename1.ui.Label findLblIcon6(Component root) {
        return (com.codename1.ui.Label)findByName("lblIcon6", root);
    }

    public com.codename1.ui.Label findLblIcon6() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("lblIcon6", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("lblIcon6", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findConDir(Component root) {
        return (com.codename1.ui.Container)findByName("ConDir", root);
    }

    public com.codename1.ui.Container findConDir() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ConDir", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ConDir", aboutToShowThisContainer);
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

    public com.codename1.ui.Container findConDirectors(Component root) {
        return (com.codename1.ui.Container)findByName("ConDirectors", root);
    }

    public com.codename1.ui.Container findConDirectors() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ConDirectors", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ConDirectors", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLblTotal(Component root) {
        return (com.codename1.ui.Label)findByName("lblTotal", root);
    }

    public com.codename1.ui.Label findLblTotal() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("lblTotal", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("lblTotal", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findMbButton(Component root) {
        return (com.codename1.ui.Button)findByName("mbButton", root);
    }

    public com.codename1.ui.Button findMbButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("mbButton", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("mbButton", aboutToShowThisContainer);
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

    public com.codename1.ui.TextField findTxtrefno(Component root) {
        return (com.codename1.ui.TextField)findByName("txtrefno", root);
    }

    public com.codename1.ui.TextField findTxtrefno() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtrefno", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtrefno", aboutToShowThisContainer);
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

    public com.codename1.ui.CheckBox findChkTerms(Component root) {
        return (com.codename1.ui.CheckBox)findByName("chkTerms", root);
    }

    public com.codename1.ui.CheckBox findChkTerms() {
        com.codename1.ui.CheckBox cmp = (com.codename1.ui.CheckBox)findByName("chkTerms", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.CheckBox)findByName("chkTerms", aboutToShowThisContainer);
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

    public com.codename1.ui.Container findContainer15(Component root) {
        return (com.codename1.ui.Container)findByName("Container15", root);
    }

    public com.codename1.ui.Container findContainer15() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container15", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container15", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer14(Component root) {
        return (com.codename1.ui.Container)findByName("Container14", root);
    }

    public com.codename1.ui.Container findContainer14() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container14", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container14", aboutToShowThisContainer);
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

    public com.codename1.ui.Container findContainer16(Component root) {
        return (com.codename1.ui.Container)findByName("Container16", root);
    }

    public com.codename1.ui.Container findContainer16() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container16", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container16", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnAddDirector(Component root) {
        return (com.codename1.ui.Button)findByName("BtnAddDirector", root);
    }

    public com.codename1.ui.Button findBtnAddDirector() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("BtnAddDirector", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("BtnAddDirector", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findConFye(Component root) {
        return (com.codename1.ui.Container)findByName("ConFye", root);
    }

    public com.codename1.ui.Container findConFye() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ConFye", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ConFye", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextArea findTxtStep3Address2(Component root) {
        return (com.codename1.ui.TextArea)findByName("txtStep3Address2", root);
    }

    public com.codename1.ui.TextArea findTxtStep3Address2() {
        com.codename1.ui.TextArea cmp = (com.codename1.ui.TextArea)findByName("txtStep3Address2", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextArea)findByName("txtStep3Address2", aboutToShowThisContainer);
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

    public com.codename1.ui.Label findLblSurname(Component root) {
        return (com.codename1.ui.Label)findByName("LblSurname", root);
    }

    public com.codename1.ui.Label findLblSurname() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("LblSurname", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("LblSurname", aboutToShowThisContainer);
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

    public com.codename1.ui.TextField findPhysaddrcode(Component root) {
        return (com.codename1.ui.TextField)findByName("Physaddrcode", root);
    }

    public com.codename1.ui.TextField findPhysaddrcode() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("Physaddrcode", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("Physaddrcode", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtentPostalcode(Component root) {
        return (com.codename1.ui.TextField)findByName("TxtentPostalcode", root);
    }

    public com.codename1.ui.TextField findTxtentPostalcode() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("TxtentPostalcode", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("TxtentPostalcode", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnPayNow(Component root) {
        return (com.codename1.ui.Button)findByName("btnPayNow", root);
    }

    public com.codename1.ui.Button findBtnPayNow() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnPayNow", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnPayNow", aboutToShowThisContainer);
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

    public com.codename1.ui.Label findLbLNameResNo(Component root) {
        return (com.codename1.ui.Label)findByName("LbLNameResNo", root);
    }

    public com.codename1.ui.Label findLbLNameResNo() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("LbLNameResNo", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("LbLNameResNo", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextArea findTxtARStep2PrincipalPlace(Component root) {
        return (com.codename1.ui.TextArea)findByName("txtARStep2PrincipalPlace", root);
    }

    public com.codename1.ui.TextArea findTxtARStep2PrincipalPlace() {
        com.codename1.ui.TextArea cmp = (com.codename1.ui.TextArea)findByName("txtARStep2PrincipalPlace", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextArea)findByName("txtARStep2PrincipalPlace", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtStep2LastName(Component root) {
        return (com.codename1.ui.TextField)findByName("txtStep2LastName", root);
    }

    public com.codename1.ui.TextField findTxtStep2LastName() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtStep2LastName", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtStep2LastName", aboutToShowThisContainer);
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

    public com.codename1.ui.TextField findTxtdirPostalCode(Component root) {
        return (com.codename1.ui.TextField)findByName("TxtdirPostalCode", root);
    }

    public com.codename1.ui.TextField findTxtdirPostalCode() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("TxtdirPostalCode", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("TxtdirPostalCode", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnAcceptTerms(Component root) {
        return (com.codename1.ui.Button)findByName("btnAcceptTerms", root);
    }

    public com.codename1.ui.Button findBtnAcceptTerms() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnAcceptTerms", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnAcceptTerms", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnItemCost(Component root) {
        return (com.codename1.ui.Button)findByName("btnItemCost", root);
    }

    public com.codename1.ui.Button findBtnItemCost() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnItemCost", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnItemCost", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findNR(Component root) {
        return (com.codename1.ui.Container)findByName("NR", root);
    }

    public com.codename1.ui.Container findNR() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("NR", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("NR", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtPostaladdr3(Component root) {
        return (com.codename1.ui.TextField)findByName("TxtPostaladdr3", root);
    }

    public com.codename1.ui.TextField findTxtPostaladdr3() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("TxtPostaladdr3", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("TxtPostaladdr3", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtPostaladdr2(Component root) {
        return (com.codename1.ui.TextField)findByName("TxtPostaladdr2", root);
    }

    public com.codename1.ui.TextField findTxtPostaladdr2() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("TxtPostaladdr2", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("TxtPostaladdr2", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtPostaladdr1(Component root) {
        return (com.codename1.ui.TextField)findByName("TxtPostaladdr1", root);
    }

    public com.codename1.ui.TextField findTxtPostaladdr1() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("TxtPostaladdr1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("TxtPostaladdr1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findPhysAddr2(Component root) {
        return (com.codename1.ui.TextField)findByName("PhysAddr2", root);
    }

    public com.codename1.ui.TextField findPhysAddr2() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("PhysAddr2", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("PhysAddr2", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findPhysAddr1(Component root) {
        return (com.codename1.ui.TextField)findByName("PhysAddr1", root);
    }

    public com.codename1.ui.TextField findPhysAddr1() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("PhysAddr1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("PhysAddr1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnTestNames(Component root) {
        return (com.codename1.ui.Button)findByName("BtnTestNames", root);
    }

    public com.codename1.ui.Button findBtnTestNames() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("BtnTestNames", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("BtnTestNames", aboutToShowThisContainer);
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

    public com.codename1.ui.Container findConEnterprise(Component root) {
        return (com.codename1.ui.Container)findByName("ConEnterprise", root);
    }

    public com.codename1.ui.Container findConEnterprise() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ConEnterprise", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ConEnterprise", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtARStep2EmailAddress(Component root) {
        return (com.codename1.ui.TextField)findByName("txtARStep2EmailAddress", root);
    }

    public com.codename1.ui.TextField findTxtARStep2EmailAddress() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtARStep2EmailAddress", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtARStep2EmailAddress", aboutToShowThisContainer);
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

    public com.codename1.ui.Container findConregister(Component root) {
        return (com.codename1.ui.Container)findByName("Conregister", root);
    }

    public com.codename1.ui.Container findConregister() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Conregister", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Conregister", aboutToShowThisContainer);
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

    public com.codename1.ui.Container findCon4Names(Component root) {
        return (com.codename1.ui.Container)findByName("Con4Names", root);
    }

    public com.codename1.ui.Container findCon4Names() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Con4Names", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Con4Names", aboutToShowThisContainer);
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

    public com.codename1.ui.TextField findPhysAddr3(Component root) {
        return (com.codename1.ui.TextField)findByName("PhysAddr3", root);
    }

    public com.codename1.ui.TextField findPhysAddr3() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("PhysAddr3", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("PhysAddr3", aboutToShowThisContainer);
        }
        return cmp;
    }

    public static final int COMMAND_ForgotPasswordRequest = 13;
    public static final int COMMAND_ContProfileUpdate = 4;
    public static final int COMMAND_LoginLogin = 5;
    public static final int COMMAND_LoginForgotPassword = 14;
    public static final int COMMAND_LoginRegisterACustomer = 12;

    protected boolean onForgotPasswordRequest() {
        return false;
    }

    protected boolean onContProfileUpdate() {
        return false;
    }

    protected boolean onLoginLogin() {
        return false;
    }

    protected boolean onLoginForgotPassword() {
        return false;
    }

    protected boolean onLoginRegisterACustomer() {
        return false;
    }

    protected void processCommand(ActionEvent ev, Command cmd) {
        switch(cmd.getId()) {
            case COMMAND_ForgotPasswordRequest:
                if(onForgotPasswordRequest()) {
                    ev.consume();
                    return;
                }
                break;

            case COMMAND_ContProfileUpdate:
                if(onContProfileUpdate()) {
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

            case COMMAND_LoginForgotPassword:
                if(onLoginForgotPassword()) {
                    ev.consume();
                    return;
                }
                break;

            case COMMAND_LoginRegisterACustomer:
                if(onLoginRegisterACustomer()) {
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
        if("BEE".equals(f.getName())) {
            exitBEE(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContCart".equals(f.getName())) {
            exitContCart(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("frmNewEntReg1".equals(f.getName())) {
            exitFrmNewEntReg1(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(f.getName())) {
            exitMain(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContSideMenu".equals(f.getName())) {
            exitContSideMenu(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContSettings".equals(f.getName())) {
            exitContSettings(f);
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

        if("ContProjects".equals(f.getName())) {
            exitContProjects(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("TermsAndConditions".equals(f.getName())) {
            exitTermsAndConditions(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContTasks".equals(f.getName())) {
            exitContTasks(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Splash".equals(f.getName())) {
            exitSplash(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Registration".equals(f.getName())) {
            exitRegistration(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Payment".equals(f.getName())) {
            exitPayment(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContProfile".equals(f.getName())) {
            exitContProfile(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContDashBoard".equals(f.getName())) {
            exitContDashBoard(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Disclosure".equals(f.getName())) {
            exitDisclosure(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("testlist".equals(f.getName())) {
            exitTestlist(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void exitBEE(Form f) {
    }


    protected void exitContCart(Form f) {
    }


    protected void exitFrmNewEntReg1(Form f) {
    }


    protected void exitMain(Form f) {
    }


    protected void exitContSideMenu(Form f) {
    }


    protected void exitContSettings(Form f) {
    }


    protected void exitLogin(Form f) {
    }


    protected void exitForgotPassword(Form f) {
    }


    protected void exitContProjects(Form f) {
    }


    protected void exitTermsAndConditions(Form f) {
    }


    protected void exitContTasks(Form f) {
    }


    protected void exitSplash(Form f) {
    }


    protected void exitRegistration(Form f) {
    }


    protected void exitPayment(Form f) {
    }


    protected void exitContProfile(Form f) {
    }


    protected void exitContDashBoard(Form f) {
    }


    protected void exitDisclosure(Form f) {
    }


    protected void exitTestlist(Form f) {
    }

    protected void beforeShow(Form f) {
    aboutToShowThisContainer = f;
        if("BEE".equals(f.getName())) {
            beforeBEE(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContCart".equals(f.getName())) {
            beforeContCart(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("frmNewEntReg1".equals(f.getName())) {
            beforeFrmNewEntReg1(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(f.getName())) {
            beforeMain(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContSideMenu".equals(f.getName())) {
            beforeContSideMenu(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContSettings".equals(f.getName())) {
            beforeContSettings(f);
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

        if("ContProjects".equals(f.getName())) {
            beforeContProjects(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("TermsAndConditions".equals(f.getName())) {
            beforeTermsAndConditions(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContTasks".equals(f.getName())) {
            beforeContTasks(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Splash".equals(f.getName())) {
            beforeSplash(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Registration".equals(f.getName())) {
            beforeRegistration(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Payment".equals(f.getName())) {
            beforePayment(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContProfile".equals(f.getName())) {
            beforeContProfile(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContDashBoard".equals(f.getName())) {
            beforeContDashBoard(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Disclosure".equals(f.getName())) {
            beforeDisclosure(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("testlist".equals(f.getName())) {
            beforeTestlist(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void beforeBEE(Form f) {
    }


    protected void beforeContCart(Form f) {
    }


    protected void beforeFrmNewEntReg1(Form f) {
    }


    protected void beforeMain(Form f) {
    }


    protected void beforeContSideMenu(Form f) {
    }


    protected void beforeContSettings(Form f) {
    }


    protected void beforeLogin(Form f) {
    }


    protected void beforeForgotPassword(Form f) {
    }


    protected void beforeContProjects(Form f) {
    }


    protected void beforeTermsAndConditions(Form f) {
    }


    protected void beforeContTasks(Form f) {
    }


    protected void beforeSplash(Form f) {
    }


    protected void beforeRegistration(Form f) {
    }


    protected void beforePayment(Form f) {
    }


    protected void beforeContProfile(Form f) {
    }


    protected void beforeContDashBoard(Form f) {
    }


    protected void beforeDisclosure(Form f) {
    }


    protected void beforeTestlist(Form f) {
    }

    protected void beforeShowContainer(Container c) {
        aboutToShowThisContainer = c;
        if("BEE".equals(c.getName())) {
            beforeContainerBEE(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContCart".equals(c.getName())) {
            beforeContainerContCart(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("frmNewEntReg1".equals(c.getName())) {
            beforeContainerFrmNewEntReg1(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(c.getName())) {
            beforeContainerMain(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContSideMenu".equals(c.getName())) {
            beforeContainerContSideMenu(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContSettings".equals(c.getName())) {
            beforeContainerContSettings(c);
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

        if("ContProjects".equals(c.getName())) {
            beforeContainerContProjects(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("TermsAndConditions".equals(c.getName())) {
            beforeContainerTermsAndConditions(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContTasks".equals(c.getName())) {
            beforeContainerContTasks(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Splash".equals(c.getName())) {
            beforeContainerSplash(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Registration".equals(c.getName())) {
            beforeContainerRegistration(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Payment".equals(c.getName())) {
            beforeContainerPayment(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContProfile".equals(c.getName())) {
            beforeContainerContProfile(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContDashBoard".equals(c.getName())) {
            beforeContainerContDashBoard(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Disclosure".equals(c.getName())) {
            beforeContainerDisclosure(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("testlist".equals(c.getName())) {
            beforeContainerTestlist(c);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void beforeContainerBEE(Container c) {
    }


    protected void beforeContainerContCart(Container c) {
    }


    protected void beforeContainerFrmNewEntReg1(Container c) {
    }


    protected void beforeContainerMain(Container c) {
    }


    protected void beforeContainerContSideMenu(Container c) {
    }


    protected void beforeContainerContSettings(Container c) {
    }


    protected void beforeContainerLogin(Container c) {
    }


    protected void beforeContainerForgotPassword(Container c) {
    }


    protected void beforeContainerContProjects(Container c) {
    }


    protected void beforeContainerTermsAndConditions(Container c) {
    }


    protected void beforeContainerContTasks(Container c) {
    }


    protected void beforeContainerSplash(Container c) {
    }


    protected void beforeContainerRegistration(Container c) {
    }


    protected void beforeContainerPayment(Container c) {
    }


    protected void beforeContainerContProfile(Container c) {
    }


    protected void beforeContainerContDashBoard(Container c) {
    }


    protected void beforeContainerDisclosure(Container c) {
    }


    protected void beforeContainerTestlist(Container c) {
    }

    protected void postShow(Form f) {
        if("BEE".equals(f.getName())) {
            postBEE(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContCart".equals(f.getName())) {
            postContCart(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("frmNewEntReg1".equals(f.getName())) {
            postFrmNewEntReg1(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(f.getName())) {
            postMain(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContSideMenu".equals(f.getName())) {
            postContSideMenu(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContSettings".equals(f.getName())) {
            postContSettings(f);
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

        if("ContProjects".equals(f.getName())) {
            postContProjects(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("TermsAndConditions".equals(f.getName())) {
            postTermsAndConditions(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContTasks".equals(f.getName())) {
            postContTasks(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Splash".equals(f.getName())) {
            postSplash(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Registration".equals(f.getName())) {
            postRegistration(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Payment".equals(f.getName())) {
            postPayment(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContProfile".equals(f.getName())) {
            postContProfile(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContDashBoard".equals(f.getName())) {
            postContDashBoard(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Disclosure".equals(f.getName())) {
            postDisclosure(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("testlist".equals(f.getName())) {
            postTestlist(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void postBEE(Form f) {
    }


    protected void postContCart(Form f) {
    }


    protected void postFrmNewEntReg1(Form f) {
    }


    protected void postMain(Form f) {
    }


    protected void postContSideMenu(Form f) {
    }


    protected void postContSettings(Form f) {
    }


    protected void postLogin(Form f) {
    }


    protected void postForgotPassword(Form f) {
    }


    protected void postContProjects(Form f) {
    }


    protected void postTermsAndConditions(Form f) {
    }


    protected void postContTasks(Form f) {
    }


    protected void postSplash(Form f) {
    }


    protected void postRegistration(Form f) {
    }


    protected void postPayment(Form f) {
    }


    protected void postContProfile(Form f) {
    }


    protected void postContDashBoard(Form f) {
    }


    protected void postDisclosure(Form f) {
    }


    protected void postTestlist(Form f) {
    }

    protected void postShowContainer(Container c) {
        if("BEE".equals(c.getName())) {
            postContainerBEE(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContCart".equals(c.getName())) {
            postContainerContCart(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("frmNewEntReg1".equals(c.getName())) {
            postContainerFrmNewEntReg1(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(c.getName())) {
            postContainerMain(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContSideMenu".equals(c.getName())) {
            postContainerContSideMenu(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContSettings".equals(c.getName())) {
            postContainerContSettings(c);
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

        if("ContProjects".equals(c.getName())) {
            postContainerContProjects(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("TermsAndConditions".equals(c.getName())) {
            postContainerTermsAndConditions(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContTasks".equals(c.getName())) {
            postContainerContTasks(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Splash".equals(c.getName())) {
            postContainerSplash(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Registration".equals(c.getName())) {
            postContainerRegistration(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Payment".equals(c.getName())) {
            postContainerPayment(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContProfile".equals(c.getName())) {
            postContainerContProfile(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContDashBoard".equals(c.getName())) {
            postContainerContDashBoard(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Disclosure".equals(c.getName())) {
            postContainerDisclosure(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("testlist".equals(c.getName())) {
            postContainerTestlist(c);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void postContainerBEE(Container c) {
    }


    protected void postContainerContCart(Container c) {
    }


    protected void postContainerFrmNewEntReg1(Container c) {
    }


    protected void postContainerMain(Container c) {
    }


    protected void postContainerContSideMenu(Container c) {
    }


    protected void postContainerContSettings(Container c) {
    }


    protected void postContainerLogin(Container c) {
    }


    protected void postContainerForgotPassword(Container c) {
    }


    protected void postContainerContProjects(Container c) {
    }


    protected void postContainerTermsAndConditions(Container c) {
    }


    protected void postContainerContTasks(Container c) {
    }


    protected void postContainerSplash(Container c) {
    }


    protected void postContainerRegistration(Container c) {
    }


    protected void postContainerPayment(Container c) {
    }


    protected void postContainerContProfile(Container c) {
    }


    protected void postContainerContDashBoard(Container c) {
    }


    protected void postContainerDisclosure(Container c) {
    }


    protected void postContainerTestlist(Container c) {
    }

    protected void onCreateRoot(String rootName) {
        if("BEE".equals(rootName)) {
            onCreateBEE();
            aboutToShowThisContainer = null;
            return;
        }

        if("ContCart".equals(rootName)) {
            onCreateContCart();
            aboutToShowThisContainer = null;
            return;
        }

        if("frmNewEntReg1".equals(rootName)) {
            onCreateFrmNewEntReg1();
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(rootName)) {
            onCreateMain();
            aboutToShowThisContainer = null;
            return;
        }

        if("ContSideMenu".equals(rootName)) {
            onCreateContSideMenu();
            aboutToShowThisContainer = null;
            return;
        }

        if("ContSettings".equals(rootName)) {
            onCreateContSettings();
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

        if("ContProjects".equals(rootName)) {
            onCreateContProjects();
            aboutToShowThisContainer = null;
            return;
        }

        if("TermsAndConditions".equals(rootName)) {
            onCreateTermsAndConditions();
            aboutToShowThisContainer = null;
            return;
        }

        if("ContTasks".equals(rootName)) {
            onCreateContTasks();
            aboutToShowThisContainer = null;
            return;
        }

        if("Splash".equals(rootName)) {
            onCreateSplash();
            aboutToShowThisContainer = null;
            return;
        }

        if("Registration".equals(rootName)) {
            onCreateRegistration();
            aboutToShowThisContainer = null;
            return;
        }

        if("Payment".equals(rootName)) {
            onCreatePayment();
            aboutToShowThisContainer = null;
            return;
        }

        if("ContProfile".equals(rootName)) {
            onCreateContProfile();
            aboutToShowThisContainer = null;
            return;
        }

        if("ContDashBoard".equals(rootName)) {
            onCreateContDashBoard();
            aboutToShowThisContainer = null;
            return;
        }

        if("Disclosure".equals(rootName)) {
            onCreateDisclosure();
            aboutToShowThisContainer = null;
            return;
        }

        if("testlist".equals(rootName)) {
            onCreateTestlist();
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void onCreateBEE() {
    }


    protected void onCreateContCart() {
    }


    protected void onCreateFrmNewEntReg1() {
    }


    protected void onCreateMain() {
    }


    protected void onCreateContSideMenu() {
    }


    protected void onCreateContSettings() {
    }


    protected void onCreateLogin() {
    }


    protected void onCreateForgotPassword() {
    }


    protected void onCreateContProjects() {
    }


    protected void onCreateTermsAndConditions() {
    }


    protected void onCreateContTasks() {
    }


    protected void onCreateSplash() {
    }


    protected void onCreateRegistration() {
    }


    protected void onCreatePayment() {
    }


    protected void onCreateContProfile() {
    }


    protected void onCreateContDashBoard() {
    }


    protected void onCreateDisclosure() {
    }


    protected void onCreateTestlist() {
    }

    protected Hashtable getFormState(Form f) {
        Hashtable h = super.getFormState(f);
        if("BEE".equals(f.getName())) {
            getStateBEE(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("ContCart".equals(f.getName())) {
            getStateContCart(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("frmNewEntReg1".equals(f.getName())) {
            getStateFrmNewEntReg1(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("Main".equals(f.getName())) {
            getStateMain(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("ContSideMenu".equals(f.getName())) {
            getStateContSideMenu(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("ContSettings".equals(f.getName())) {
            getStateContSettings(f, h);
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

        if("ContProjects".equals(f.getName())) {
            getStateContProjects(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("TermsAndConditions".equals(f.getName())) {
            getStateTermsAndConditions(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("ContTasks".equals(f.getName())) {
            getStateContTasks(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("Splash".equals(f.getName())) {
            getStateSplash(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("Registration".equals(f.getName())) {
            getStateRegistration(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("Payment".equals(f.getName())) {
            getStatePayment(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("ContProfile".equals(f.getName())) {
            getStateContProfile(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("ContDashBoard".equals(f.getName())) {
            getStateContDashBoard(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("Disclosure".equals(f.getName())) {
            getStateDisclosure(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("testlist".equals(f.getName())) {
            getStateTestlist(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

            return h;
    }


    protected void getStateBEE(Form f, Hashtable h) {
    }


    protected void getStateContCart(Form f, Hashtable h) {
    }


    protected void getStateFrmNewEntReg1(Form f, Hashtable h) {
    }


    protected void getStateMain(Form f, Hashtable h) {
    }


    protected void getStateContSideMenu(Form f, Hashtable h) {
    }


    protected void getStateContSettings(Form f, Hashtable h) {
    }


    protected void getStateLogin(Form f, Hashtable h) {
    }


    protected void getStateForgotPassword(Form f, Hashtable h) {
    }


    protected void getStateContProjects(Form f, Hashtable h) {
    }


    protected void getStateTermsAndConditions(Form f, Hashtable h) {
    }


    protected void getStateContTasks(Form f, Hashtable h) {
    }


    protected void getStateSplash(Form f, Hashtable h) {
    }


    protected void getStateRegistration(Form f, Hashtable h) {
    }


    protected void getStatePayment(Form f, Hashtable h) {
    }


    protected void getStateContProfile(Form f, Hashtable h) {
    }


    protected void getStateContDashBoard(Form f, Hashtable h) {
    }


    protected void getStateDisclosure(Form f, Hashtable h) {
    }


    protected void getStateTestlist(Form f, Hashtable h) {
    }

    protected void setFormState(Form f, Hashtable state) {
        super.setFormState(f, state);
        if("BEE".equals(f.getName())) {
            setStateBEE(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContCart".equals(f.getName())) {
            setStateContCart(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("frmNewEntReg1".equals(f.getName())) {
            setStateFrmNewEntReg1(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(f.getName())) {
            setStateMain(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContSideMenu".equals(f.getName())) {
            setStateContSideMenu(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContSettings".equals(f.getName())) {
            setStateContSettings(f, state);
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

        if("ContProjects".equals(f.getName())) {
            setStateContProjects(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("TermsAndConditions".equals(f.getName())) {
            setStateTermsAndConditions(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContTasks".equals(f.getName())) {
            setStateContTasks(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("Splash".equals(f.getName())) {
            setStateSplash(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("Registration".equals(f.getName())) {
            setStateRegistration(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("Payment".equals(f.getName())) {
            setStatePayment(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContProfile".equals(f.getName())) {
            setStateContProfile(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContDashBoard".equals(f.getName())) {
            setStateContDashBoard(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("Disclosure".equals(f.getName())) {
            setStateDisclosure(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("testlist".equals(f.getName())) {
            setStateTestlist(f, state);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void setStateBEE(Form f, Hashtable state) {
    }


    protected void setStateContCart(Form f, Hashtable state) {
    }


    protected void setStateFrmNewEntReg1(Form f, Hashtable state) {
    }


    protected void setStateMain(Form f, Hashtable state) {
    }


    protected void setStateContSideMenu(Form f, Hashtable state) {
    }


    protected void setStateContSettings(Form f, Hashtable state) {
    }


    protected void setStateLogin(Form f, Hashtable state) {
    }


    protected void setStateForgotPassword(Form f, Hashtable state) {
    }


    protected void setStateContProjects(Form f, Hashtable state) {
    }


    protected void setStateTermsAndConditions(Form f, Hashtable state) {
    }


    protected void setStateContTasks(Form f, Hashtable state) {
    }


    protected void setStateSplash(Form f, Hashtable state) {
    }


    protected void setStateRegistration(Form f, Hashtable state) {
    }


    protected void setStatePayment(Form f, Hashtable state) {
    }


    protected void setStateContProfile(Form f, Hashtable state) {
    }


    protected void setStateContDashBoard(Form f, Hashtable state) {
    }


    protected void setStateDisclosure(Form f, Hashtable state) {
    }


    protected void setStateTestlist(Form f, Hashtable state) {
    }

    protected boolean setListModel(List cmp) {
        String listName = cmp.getName();
        if("CmbFyeMonth".equals(listName)) {
            return initListModelCmbFyeMonth(cmp);
        }
        if("Cmbdirectortype".equals(listName)) {
            return initListModelCmbdirectortype(cmp);
        }
        if("Cmbenttype".equals(listName)) {
            return initListModelCmbenttype(cmp);
        }
        return super.setListModel(cmp);
    }

    protected boolean initListModelCmbFyeMonth(List cmp) {
        return false;
    }

    protected boolean initListModelCmbdirectortype(List cmp) {
        return false;
    }

    protected boolean initListModelCmbenttype(List cmp) {
        return false;
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
        if(rootContainerName.equals("ContCart")) {
            if("Button1".equals(c.getName())) {
                onContCart_Button1Action(c, event);
                return;
            }
            if("MultiButton".equals(c.getName())) {
                onContCart_MultiButtonAction(c, event);
                return;
            }
            if("btnItemCost".equals(c.getName())) {
                onContCart_BtnItemCostAction(c, event);
                return;
            }
            if("btnCheckout".equals(c.getName())) {
                onContCart_BtnCheckoutAction(c, event);
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
            if("btnPayNow".equals(c.getName())) {
                onContCart_BtnPayNowAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("frmNewEntReg1")) {
            if("BtnStartNewReg".equals(c.getName())) {
                onFrmNewEntReg1_BtnStartNewRegAction(c, event);
                return;
            }
            if("BtnFileNamereservation".equals(c.getName())) {
                onFrmNewEntReg1_BtnFileNamereservationAction(c, event);
                return;
            }
            if("TxtApprovedNo".equals(c.getName())) {
                onFrmNewEntReg1_TxtApprovedNoAction(c, event);
                return;
            }
            if("btnvalno".equals(c.getName())) {
                onFrmNewEntReg1_BtnvalnoAction(c, event);
                return;
            }
            if("txtrefno".equals(c.getName())) {
                onFrmNewEntReg1_TxtrefnoAction(c, event);
                return;
            }
            if("btnconreg".equals(c.getName())) {
                onFrmNewEntReg1_BtnconregAction(c, event);
                return;
            }
            if("TextArea1".equals(c.getName())) {
                onFrmNewEntReg1_TextArea1Action(c, event);
                return;
            }
            if("Txtname1".equals(c.getName())) {
                onFrmNewEntReg1_Txtname1Action(c, event);
                return;
            }
            if("Txtname2".equals(c.getName())) {
                onFrmNewEntReg1_Txtname2Action(c, event);
                return;
            }
            if("Txtname3".equals(c.getName())) {
                onFrmNewEntReg1_Txtname3Action(c, event);
                return;
            }
            if("Txtname4".equals(c.getName())) {
                onFrmNewEntReg1_Txtname4Action(c, event);
                return;
            }
            if("TextArea".equals(c.getName())) {
                onFrmNewEntReg1_TextAreaAction(c, event);
                return;
            }
            if("BtnTestNames".equals(c.getName())) {
                onFrmNewEntReg1_BtnTestNamesAction(c, event);
                return;
            }
            if("BtnFileName".equals(c.getName())) {
                onFrmNewEntReg1_BtnFileNameAction(c, event);
                return;
            }
            if("Cmbenttype".equals(c.getName())) {
                onFrmNewEntReg1_CmbenttypeAction(c, event);
                return;
            }
            if("CmbFyeMonth".equals(c.getName())) {
                onFrmNewEntReg1_CmbFyeMonthAction(c, event);
                return;
            }
            if("TxtAuthShares".equals(c.getName())) {
                onFrmNewEntReg1_TxtAuthSharesAction(c, event);
                return;
            }
            if("TxtEntEmail".equals(c.getName())) {
                onFrmNewEntReg1_TxtEntEmailAction(c, event);
                return;
            }
            if("txtEntPhysAddr1".equals(c.getName())) {
                onFrmNewEntReg1_TxtEntPhysAddr1Action(c, event);
                return;
            }
            if("txtEntPhysAddr2".equals(c.getName())) {
                onFrmNewEntReg1_TxtEntPhysAddr2Action(c, event);
                return;
            }
            if("txtEntPhysAddr3".equals(c.getName())) {
                onFrmNewEntReg1_TxtEntPhysAddr3Action(c, event);
                return;
            }
            if("txtEntPhysCode".equals(c.getName())) {
                onFrmNewEntReg1_TxtEntPhysCodeAction(c, event);
                return;
            }
            if("Btncopyphysicaladdress".equals(c.getName())) {
                onFrmNewEntReg1_BtncopyphysicaladdressAction(c, event);
                return;
            }
            if("TxtPostaladdr1".equals(c.getName())) {
                onFrmNewEntReg1_TxtPostaladdr1Action(c, event);
                return;
            }
            if("TxtPostaladdr2".equals(c.getName())) {
                onFrmNewEntReg1_TxtPostaladdr2Action(c, event);
                return;
            }
            if("TxtPostaladdr3".equals(c.getName())) {
                onFrmNewEntReg1_TxtPostaladdr3Action(c, event);
                return;
            }
            if("TxtentPostalcode".equals(c.getName())) {
                onFrmNewEntReg1_TxtentPostalcodeAction(c, event);
                return;
            }
            if("Buttoncondir".equals(c.getName())) {
                onFrmNewEntReg1_ButtoncondirAction(c, event);
                return;
            }
            if("BtnGetIdInfo".equals(c.getName())) {
                onFrmNewEntReg1_BtnGetIdInfoAction(c, event);
                return;
            }
            if("chbIncorporator".equals(c.getName())) {
                onFrmNewEntReg1_ChbIncorporatorAction(c, event);
                return;
            }
            if("Cmbdirectortype".equals(c.getName())) {
                onFrmNewEntReg1_CmbdirectortypeAction(c, event);
                return;
            }
            if("dtAppDate".equals(c.getName())) {
                onFrmNewEntReg1_DtAppDateAction(c, event);
                return;
            }
            if("TxtCell".equals(c.getName())) {
                onFrmNewEntReg1_TxtCellAction(c, event);
                return;
            }
            if("BtnverifyOtp".equals(c.getName())) {
                onFrmNewEntReg1_BtnverifyOtpAction(c, event);
                return;
            }
            if("TxtOtp".equals(c.getName())) {
                onFrmNewEntReg1_TxtOtpAction(c, event);
                return;
            }
            if("TxtEmail".equals(c.getName())) {
                onFrmNewEntReg1_TxtEmailAction(c, event);
                return;
            }
            if("PhysAddr1".equals(c.getName())) {
                onFrmNewEntReg1_PhysAddr1Action(c, event);
                return;
            }
            if("PhysAddr2".equals(c.getName())) {
                onFrmNewEntReg1_PhysAddr2Action(c, event);
                return;
            }
            if("PhysAddr3".equals(c.getName())) {
                onFrmNewEntReg1_PhysAddr3Action(c, event);
                return;
            }
            if("Physaddrcode".equals(c.getName())) {
                onFrmNewEntReg1_PhysaddrcodeAction(c, event);
                return;
            }
            if("btncopyphysaddress".equals(c.getName())) {
                onFrmNewEntReg1_BtncopyphysaddressAction(c, event);
                return;
            }
            if("TxtPostalAddr1".equals(c.getName())) {
                onFrmNewEntReg1_TxtPostalAddr1Action(c, event);
                return;
            }
            if("TxtPostalAddr2".equals(c.getName())) {
                onFrmNewEntReg1_TxtPostalAddr2Action(c, event);
                return;
            }
            if("TxtPostalAddr3".equals(c.getName())) {
                onFrmNewEntReg1_TxtPostalAddr3Action(c, event);
                return;
            }
            if("TxtdirPostalCode".equals(c.getName())) {
                onFrmNewEntReg1_TxtdirPostalCodeAction(c, event);
                return;
            }
            if("BtnAddDirector".equals(c.getName())) {
                onFrmNewEntReg1_BtnAddDirectorAction(c, event);
                return;
            }
            if("Btnexit".equals(c.getName())) {
                onFrmNewEntReg1_BtnexitAction(c, event);
                return;
            }
            if("BtnRegisterenterpris".equals(c.getName())) {
                onFrmNewEntReg1_BtnRegisterenterprisAction(c, event);
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
            if("txtCustomerCode".equals(c.getName())) {
                onForgotPassword_TxtCustomerCodeAction(c, event);
                return;
            }
            if("btnRecoverPassword".equals(c.getName())) {
                onForgotPassword_BtnRecoverPasswordAction(c, event);
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
            if("txtARStep2EmailAddress".equals(c.getName())) {
                onContProjects_TxtARStep2EmailAddressAction(c, event);
                return;
            }
            if("txtARStep2TelCode".equals(c.getName())) {
                onContProjects_TxtARStep2TelCodeAction(c, event);
                return;
            }
            if("txtARStep2TelNo".equals(c.getName())) {
                onContProjects_TxtARStep2TelNoAction(c, event);
                return;
            }
            if("txtARStep2BusinessDescription".equals(c.getName())) {
                onContProjects_TxtARStep2BusinessDescriptionAction(c, event);
                return;
            }
            if("txtARStep2WebAddress".equals(c.getName())) {
                onContProjects_TxtARStep2WebAddressAction(c, event);
                return;
            }
            if("txtARStep2CellNumber".equals(c.getName())) {
                onContProjects_TxtARStep2CellNumberAction(c, event);
                return;
            }
            if("txtARStep2PrincipalPlace".equals(c.getName())) {
                onContProjects_TxtARStep2PrincipalPlaceAction(c, event);
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
        if(rootContainerName.equals("TermsAndConditions")) {
            if("btnViewTerms".equals(c.getName())) {
                onTermsAndConditions_BtnViewTermsAction(c, event);
                return;
            }
            if("chkTerms".equals(c.getName())) {
                onTermsAndConditions_ChkTermsAction(c, event);
                return;
            }
            if("btnAcceptTerms".equals(c.getName())) {
                onTermsAndConditions_BtnAcceptTermsAction(c, event);
                return;
            }
            if("btnDoNotAccept".equals(c.getName())) {
                onTermsAndConditions_BtnDoNotAcceptAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("ContTasks")) {
            if("TextArea1".equals(c.getName())) {
                onContTasks_TextArea1Action(c, event);
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
            if("TextArea".equals(c.getName())) {
                onContTasks_TextAreaAction(c, event);
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
            if("txtStep2FirstName".equals(c.getName())) {
                onRegistration_TxtStep2FirstNameAction(c, event);
                return;
            }
            if("txtStep2LastName".equals(c.getName())) {
                onRegistration_TxtStep2LastNameAction(c, event);
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
            if("txtStep3Address2".equals(c.getName())) {
                onRegistration_TxtStep3Address2Action(c, event);
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
            if("txtLine1".equals(c.getName())) {
                onRegistration_TxtLine1Action(c, event);
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
        if(rootContainerName.equals("Payment")) {
            if("TextArea".equals(c.getName())) {
                onPayment_TextAreaAction(c, event);
                return;
            }
            if("chkNoShow".equals(c.getName())) {
                onPayment_ChkNoShowAction(c, event);
                return;
            }
            if("btnOk".equals(c.getName())) {
                onPayment_BtnOkAction(c, event);
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
        if(rootContainerName.equals("ContDashBoard")) {
            if("mbTasks".equals(c.getName())) {
                onContDashBoard_MbTasksAction(c, event);
                return;
            }
            if("mbCurrency".equals(c.getName())) {
                onContDashBoard_MbCurrencyAction(c, event);
                return;
            }
            if("mbButton".equals(c.getName())) {
                onContDashBoard_MbButtonAction(c, event);
                return;
            }
            if("mbRegistration".equals(c.getName())) {
                onContDashBoard_MbRegistrationAction(c, event);
                return;
            }
            if("mbBEE".equals(c.getName())) {
                onContDashBoard_MbBEEAction(c, event);
                return;
            }
            if("mbDisclosure".equals(c.getName())) {
                onContDashBoard_MbDisclosureAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("testlist")) {
            if("Button".equals(c.getName())) {
                onTestlist_ButtonAction(c, event);
                return;
            }
        }
    }

      protected void onContCart_Button1Action(Component c, ActionEvent event) {
      }

      protected void onContCart_MultiButtonAction(Component c, ActionEvent event) {
      }

      protected void onContCart_BtnItemCostAction(Component c, ActionEvent event) {
      }

      protected void onContCart_BtnCheckoutAction(Component c, ActionEvent event) {
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

      protected void onContCart_BtnPayNowAction(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_BtnStartNewRegAction(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_BtnFileNamereservationAction(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_TxtApprovedNoAction(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_BtnvalnoAction(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_TxtrefnoAction(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_BtnconregAction(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_TextArea1Action(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_Txtname1Action(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_Txtname2Action(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_Txtname3Action(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_Txtname4Action(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_TextAreaAction(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_BtnTestNamesAction(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_BtnFileNameAction(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_CmbenttypeAction(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_CmbFyeMonthAction(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_TxtAuthSharesAction(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_TxtEntEmailAction(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_TxtEntPhysAddr1Action(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_TxtEntPhysAddr2Action(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_TxtEntPhysAddr3Action(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_TxtEntPhysCodeAction(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_BtncopyphysicaladdressAction(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_TxtPostaladdr1Action(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_TxtPostaladdr2Action(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_TxtPostaladdr3Action(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_TxtentPostalcodeAction(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_ButtoncondirAction(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_BtnGetIdInfoAction(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_ChbIncorporatorAction(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_CmbdirectortypeAction(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_DtAppDateAction(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_TxtCellAction(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_BtnverifyOtpAction(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_TxtOtpAction(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_TxtEmailAction(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_PhysAddr1Action(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_PhysAddr2Action(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_PhysAddr3Action(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_PhysaddrcodeAction(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_BtncopyphysaddressAction(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_TxtPostalAddr1Action(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_TxtPostalAddr2Action(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_TxtPostalAddr3Action(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_TxtdirPostalCodeAction(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_BtnAddDirectorAction(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_BtnexitAction(Component c, ActionEvent event) {
      }

      protected void onFrmNewEntReg1_BtnRegisterenterprisAction(Component c, ActionEvent event) {
      }

      protected void onContSideMenu_BtnProfilePicAction(Component c, ActionEvent event) {
      }

      protected void onContSideMenu_BtnProfileNameAction(Component c, ActionEvent event) {
      }

      protected void onContSideMenu_BtnDashboardAction(Component c, ActionEvent event) {
      }

      protected void onContSideMenu_BtnLogoutAction(Component c, ActionEvent event) {
      }

      protected void onContSettings_TxtHandleAction(Component c, ActionEvent event) {
      }

      protected void onContSettings_BtnSettingsSaveAction(Component c, ActionEvent event) {
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

      protected void onForgotPassword_TxtCustomerCodeAction(Component c, ActionEvent event) {
      }

      protected void onForgotPassword_BtnRecoverPasswordAction(Component c, ActionEvent event) {
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

      protected void onContProjects_TxtARStep2EmailAddressAction(Component c, ActionEvent event) {
      }

      protected void onContProjects_TxtARStep2TelCodeAction(Component c, ActionEvent event) {
      }

      protected void onContProjects_TxtARStep2TelNoAction(Component c, ActionEvent event) {
      }

      protected void onContProjects_TxtARStep2BusinessDescriptionAction(Component c, ActionEvent event) {
      }

      protected void onContProjects_TxtARStep2WebAddressAction(Component c, ActionEvent event) {
      }

      protected void onContProjects_TxtARStep2CellNumberAction(Component c, ActionEvent event) {
      }

      protected void onContProjects_TxtARStep2PrincipalPlaceAction(Component c, ActionEvent event) {
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

      protected void onTermsAndConditions_BtnViewTermsAction(Component c, ActionEvent event) {
      }

      protected void onTermsAndConditions_ChkTermsAction(Component c, ActionEvent event) {
      }

      protected void onTermsAndConditions_BtnAcceptTermsAction(Component c, ActionEvent event) {
      }

      protected void onTermsAndConditions_BtnDoNotAcceptAction(Component c, ActionEvent event) {
      }

      protected void onContTasks_TextArea1Action(Component c, ActionEvent event) {
      }

      protected void onContTasks_TxtName1Action(Component c, ActionEvent event) {
      }

      protected void onContTasks_TxtName2Action(Component c, ActionEvent event) {
      }

      protected void onContTasks_TxtName3Action(Component c, ActionEvent event) {
      }

      protected void onContTasks_TxtName4Action(Component c, ActionEvent event) {
      }

      protected void onContTasks_TextAreaAction(Component c, ActionEvent event) {
      }

      protected void onContTasks_BtnVerifyAction(Component c, ActionEvent event) {
      }

      protected void onContTasks_BtnLodgeAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_TxtStep1IDNumberAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_BtnStep1NoIDAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_BtnStep1ContinueAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_TxtStep2FirstNameAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_TxtStep2LastNameAction(Component c, ActionEvent event) {
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

      protected void onRegistration_TxtStep3Address2Action(Component c, ActionEvent event) {
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

      protected void onRegistration_TxtLine1Action(Component c, ActionEvent event) {
      }

      protected void onRegistration_TxtStep4PasswordAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_TxtStep4PasswordRetypeAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_BtnStep4RegisterAction(Component c, ActionEvent event) {
      }

      protected void onPayment_TextAreaAction(Component c, ActionEvent event) {
      }

      protected void onPayment_ChkNoShowAction(Component c, ActionEvent event) {
      }

      protected void onPayment_BtnOkAction(Component c, ActionEvent event) {
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

      protected void onContDashBoard_MbTasksAction(Component c, ActionEvent event) {
      }

      protected void onContDashBoard_MbCurrencyAction(Component c, ActionEvent event) {
      }

      protected void onContDashBoard_MbButtonAction(Component c, ActionEvent event) {
      }

      protected void onContDashBoard_MbRegistrationAction(Component c, ActionEvent event) {
      }

      protected void onContDashBoard_MbBEEAction(Component c, ActionEvent event) {
      }

      protected void onContDashBoard_MbDisclosureAction(Component c, ActionEvent event) {
      }

      protected void onTestlist_ButtonAction(Component c, ActionEvent event) {
      }

}
