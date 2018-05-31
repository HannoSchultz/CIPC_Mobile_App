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
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("TextArea", com.codename1.ui.TextArea.class);
        UIBuilder.registerCustomComponent("Label", com.codename1.ui.Label.class);
        UIBuilder.registerCustomComponent("SpanLabel", com.codename1.components.SpanLabel.class);
        UIBuilder.registerCustomComponent("RadioButton", com.codename1.ui.RadioButton.class);
        UIBuilder.registerCustomComponent("OnOffSwitch", com.codename1.components.OnOffSwitch.class);
        UIBuilder.registerCustomComponent("Container", com.codename1.ui.Container.class);
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("Dialog", com.codename1.ui.Dialog.class);
        UIBuilder.registerCustomComponent("CheckBox", com.codename1.ui.CheckBox.class);
        UIBuilder.registerCustomComponent("Picker", com.codename1.ui.spinner.Picker.class);
        UIBuilder.registerCustomComponent("TextField", com.codename1.ui.TextField.class);
        UIBuilder.registerCustomComponent("Tabs", com.codename1.ui.Tabs.class);
        UIBuilder.registerCustomComponent("List", com.codename1.ui.List.class);
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
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("TextArea", com.codename1.ui.TextArea.class);
        UIBuilder.registerCustomComponent("Label", com.codename1.ui.Label.class);
        UIBuilder.registerCustomComponent("SpanLabel", com.codename1.components.SpanLabel.class);
        UIBuilder.registerCustomComponent("RadioButton", com.codename1.ui.RadioButton.class);
        UIBuilder.registerCustomComponent("OnOffSwitch", com.codename1.components.OnOffSwitch.class);
        UIBuilder.registerCustomComponent("Container", com.codename1.ui.Container.class);
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("Dialog", com.codename1.ui.Dialog.class);
        UIBuilder.registerCustomComponent("CheckBox", com.codename1.ui.CheckBox.class);
        UIBuilder.registerCustomComponent("Picker", com.codename1.ui.spinner.Picker.class);
        UIBuilder.registerCustomComponent("TextField", com.codename1.ui.TextField.class);
        UIBuilder.registerCustomComponent("Tabs", com.codename1.ui.Tabs.class);
        UIBuilder.registerCustomComponent("List", com.codename1.ui.List.class);
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

    public com.codename1.components.OnOffSwitch findIsAllowed(Component root) {
        return (com.codename1.components.OnOffSwitch)findByName("isAllowed", root);
    }

    public com.codename1.components.OnOffSwitch findIsAllowed() {
        com.codename1.components.OnOffSwitch cmp = (com.codename1.components.OnOffSwitch)findByName("isAllowed", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.components.OnOffSwitch)findByName("isAllowed", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabelTitle(Component root) {
        return (com.codename1.ui.Label)findByName("LabelTitle", root);
    }

    public com.codename1.ui.Label findLabelTitle() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("LabelTitle", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("LabelTitle", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel51(Component root) {
        return (com.codename1.ui.Label)findByName("Label51", root);
    }

    public com.codename1.ui.Label findLabel51() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label51", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label51", aboutToShowThisContainer);
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

    public com.codename1.ui.spinner.Picker findPickerDate(Component root) {
        return (com.codename1.ui.spinner.Picker)findByName("pickerDate", root);
    }

    public com.codename1.ui.spinner.Picker findPickerDate() {
        com.codename1.ui.spinner.Picker cmp = (com.codename1.ui.spinner.Picker)findByName("pickerDate", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.spinner.Picker)findByName("pickerDate", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.components.SpanLabel findSpanLabel11(Component root) {
        return (com.codename1.components.SpanLabel)findByName("SpanLabel11", root);
    }

    public com.codename1.components.SpanLabel findSpanLabel11() {
        com.codename1.components.SpanLabel cmp = (com.codename1.components.SpanLabel)findByName("SpanLabel11", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.components.SpanLabel)findByName("SpanLabel11", aboutToShowThisContainer);
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

    public com.codename1.components.OnOffSwitch findIsAdmin(Component root) {
        return (com.codename1.components.OnOffSwitch)findByName("isAdmin", root);
    }

    public com.codename1.components.OnOffSwitch findIsAdmin() {
        com.codename1.components.OnOffSwitch cmp = (com.codename1.components.OnOffSwitch)findByName("isAdmin", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.components.OnOffSwitch)findByName("isAdmin", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.spinner.Picker findPickerTime(Component root) {
        return (com.codename1.ui.spinner.Picker)findByName("pickerTime", root);
    }

    public com.codename1.ui.spinner.Picker findPickerTime() {
        com.codename1.ui.spinner.Picker cmp = (com.codename1.ui.spinner.Picker)findByName("pickerTime", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.spinner.Picker)findByName("pickerTime", aboutToShowThisContainer);
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

    public com.codename1.ui.spinner.Picker findTimePicker(Component root) {
        return (com.codename1.ui.spinner.Picker)findByName("timePicker", root);
    }

    public com.codename1.ui.spinner.Picker findTimePicker() {
        com.codename1.ui.spinner.Picker cmp = (com.codename1.ui.spinner.Picker)findByName("timePicker", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.spinner.Picker)findByName("timePicker", aboutToShowThisContainer);
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

    public com.codename1.ui.spinner.Picker findPickerStatus(Component root) {
        return (com.codename1.ui.spinner.Picker)findByName("pickerStatus", root);
    }

    public com.codename1.ui.spinner.Picker findPickerStatus() {
        com.codename1.ui.spinner.Picker cmp = (com.codename1.ui.spinner.Picker)findByName("pickerStatus", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.spinner.Picker)findByName("pickerStatus", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.spinner.Picker findPickerProjectName(Component root) {
        return (com.codename1.ui.spinner.Picker)findByName("pickerProjectName", root);
    }

    public com.codename1.ui.spinner.Picker findPickerProjectName() {
        com.codename1.ui.spinner.Picker cmp = (com.codename1.ui.spinner.Picker)findByName("pickerProjectName", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.spinner.Picker)findByName("pickerProjectName", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findMessages(Component root) {
        return (com.codename1.ui.Container)findByName("messages", root);
    }

    public com.codename1.ui.Container findMessages() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("messages", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("messages", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnDescription(Component root) {
        return (com.codename1.ui.Button)findByName("btnDescription", root);
    }

    public com.codename1.ui.Button findBtnDescription() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnDescription", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnDescription", aboutToShowThisContainer);
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

    public com.codename1.ui.Button findButton11(Component root) {
        return (com.codename1.ui.Button)findByName("Button11", root);
    }

    public com.codename1.ui.Button findButton11() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Button11", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Button11", aboutToShowThisContainer);
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

    public com.codename1.ui.TextField findTextField4(Component root) {
        return (com.codename1.ui.TextField)findByName("TextField4", root);
    }

    public com.codename1.ui.TextField findTextField4() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("TextField4", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("TextField4", aboutToShowThisContainer);
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

    public com.codename1.ui.TextField findTextField2(Component root) {
        return (com.codename1.ui.TextField)findByName("TextField2", root);
    }

    public com.codename1.ui.TextField findTextField2() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("TextField2", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("TextField2", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel31(Component root) {
        return (com.codename1.ui.Label)findByName("Label31", root);
    }

    public com.codename1.ui.Label findLabel31() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label31", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label31", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTextField1(Component root) {
        return (com.codename1.ui.TextField)findByName("TextField1", root);
    }

    public com.codename1.ui.TextField findTextField1() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("TextField1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("TextField1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnCreateTask(Component root) {
        return (com.codename1.ui.Button)findByName("btnCreateTask", root);
    }

    public com.codename1.ui.Button findBtnCreateTask() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnCreateTask", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnCreateTask", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTextField8(Component root) {
        return (com.codename1.ui.TextField)findByName("TextField8", root);
    }

    public com.codename1.ui.TextField findTextField8() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("TextField8", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("TextField8", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTextField7(Component root) {
        return (com.codename1.ui.TextField)findByName("TextField7", root);
    }

    public com.codename1.ui.TextField findTextField7() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("TextField7", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("TextField7", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTextField6(Component root) {
        return (com.codename1.ui.TextField)findByName("TextField6", root);
    }

    public com.codename1.ui.TextField findTextField6() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("TextField6", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("TextField6", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTextField5(Component root) {
        return (com.codename1.ui.TextField)findByName("TextField5", root);
    }

    public com.codename1.ui.TextField findTextField5() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("TextField5", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("TextField5", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnSendComment(Component root) {
        return (com.codename1.ui.Button)findByName("btnSendComment", root);
    }

    public com.codename1.ui.Button findBtnSendComment() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnSendComment", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnSendComment", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContContent(Component root) {
        return (com.codename1.ui.Container)findByName("contContent", root);
    }

    public com.codename1.ui.Container findContContent() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("contContent", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("contContent", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTextField9(Component root) {
        return (com.codename1.ui.TextField)findByName("TextField9", root);
    }

    public com.codename1.ui.TextField findTextField9() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("TextField9", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("TextField9", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.spinner.Picker findDateTimePicker(Component root) {
        return (com.codename1.ui.spinner.Picker)findByName("dateTimePicker", root);
    }

    public com.codename1.ui.spinner.Picker findDateTimePicker() {
        com.codename1.ui.spinner.Picker cmp = (com.codename1.ui.spinner.Picker)findByName("dateTimePicker", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.spinner.Picker)findByName("dateTimePicker", aboutToShowThisContainer);
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

    public com.codename1.ui.spinner.Picker findPickerProvince(Component root) {
        return (com.codename1.ui.spinner.Picker)findByName("pickerProvince", root);
    }

    public com.codename1.ui.spinner.Picker findPickerProvince() {
        com.codename1.ui.spinner.Picker cmp = (com.codename1.ui.spinner.Picker)findByName("pickerProvince", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.spinner.Picker)findByName("pickerProvince", aboutToShowThisContainer);
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

    public com.codename1.ui.TextArea findTxtDescription(Component root) {
        return (com.codename1.ui.TextArea)findByName("txtDescription", root);
    }

    public com.codename1.ui.TextArea findTxtDescription() {
        com.codename1.ui.TextArea cmp = (com.codename1.ui.TextArea)findByName("txtDescription", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextArea)findByName("txtDescription", aboutToShowThisContainer);
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

    public com.codename1.ui.TextField findTxtSearch(Component root) {
        return (com.codename1.ui.TextField)findByName("txtSearch", root);
    }

    public com.codename1.ui.TextField findTxtSearch() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtSearch", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtSearch", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLblTitle(Component root) {
        return (com.codename1.ui.Label)findByName("lblTitle", root);
    }

    public com.codename1.ui.Label findLblTitle() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("lblTitle", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("lblTitle", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTxtTitle(Component root) {
        return (com.codename1.ui.TextField)findByName("txtTitle", root);
    }

    public com.codename1.ui.TextField findTxtTitle() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtTitle", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtTitle", aboutToShowThisContainer);
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

    public com.codename1.ui.Container findContainer19(Component root) {
        return (com.codename1.ui.Container)findByName("Container19", root);
    }

    public com.codename1.ui.Container findContainer19() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container19", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container19", aboutToShowThisContainer);
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

    public com.codename1.ui.Container findContainer18(Component root) {
        return (com.codename1.ui.Container)findByName("Container18", root);
    }

    public com.codename1.ui.Container findContainer18() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container18", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container18", aboutToShowThisContainer);
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

    public com.codename1.ui.Container findContContacts(Component root) {
        return (com.codename1.ui.Container)findByName("ContContacts", root);
    }

    public com.codename1.ui.Container findContContacts() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ContContacts", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ContContacts", aboutToShowThisContainer);
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

    public com.codename1.ui.Label findLabel16(Component root) {
        return (com.codename1.ui.Label)findByName("Label16", root);
    }

    public com.codename1.ui.Label findLabel16() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label16", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label16", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextArea findTxtComment(Component root) {
        return (com.codename1.ui.TextArea)findByName("txtComment", root);
    }

    public com.codename1.ui.TextArea findTxtComment() {
        com.codename1.ui.TextArea cmp = (com.codename1.ui.TextArea)findByName("txtComment", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextArea)findByName("txtComment", aboutToShowThisContainer);
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

    public com.codename1.ui.Container findContainer17(Component root) {
        return (com.codename1.ui.Container)findByName("Container17", root);
    }

    public com.codename1.ui.Container findContainer17() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container17", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container17", aboutToShowThisContainer);
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

    public com.codename1.ui.TextField findTextField10(Component root) {
        return (com.codename1.ui.TextField)findByName("TextField10", root);
    }

    public com.codename1.ui.TextField findTextField10() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("TextField10", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("TextField10", aboutToShowThisContainer);
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

    public com.codename1.ui.Container findContReports(Component root) {
        return (com.codename1.ui.Container)findByName("ContReports", root);
    }

    public com.codename1.ui.Container findContReports() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ContReports", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ContReports", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer20(Component root) {
        return (com.codename1.ui.Container)findByName("Container20", root);
    }

    public com.codename1.ui.Container findContainer20() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container20", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container20", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel91(Component root) {
        return (com.codename1.ui.Label)findByName("Label91", root);
    }

    public com.codename1.ui.Label findLabel91() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label91", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label91", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnProjectAction(Component root) {
        return (com.codename1.ui.Button)findByName("btnProjectAction", root);
    }

    public com.codename1.ui.Button findBtnProjectAction() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnProjectAction", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnProjectAction", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTextField(Component root) {
        return (com.codename1.ui.TextField)findByName("TextField", root);
    }

    public com.codename1.ui.TextField findTextField() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("TextField", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("TextField", aboutToShowThisContainer);
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

    public com.codename1.ui.Button findBtnEmail(Component root) {
        return (com.codename1.ui.Button)findByName("btnEmail", root);
    }

    public com.codename1.ui.Button findBtnEmail() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnEmail", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnEmail", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.List findList(Component root) {
        return (com.codename1.ui.List)findByName("List", root);
    }

    public com.codename1.ui.List findList() {
        com.codename1.ui.List cmp = (com.codename1.ui.List)findByName("List", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.List)findByName("List", aboutToShowThisContainer);
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

    public com.codename1.ui.Button findBtnCommunication(Component root) {
        return (com.codename1.ui.Button)findByName("btnCommunication", root);
    }

    public com.codename1.ui.Button findBtnCommunication() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnCommunication", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnCommunication", aboutToShowThisContainer);
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

    public com.codename1.ui.TextArea findTxtPhysicalAddress(Component root) {
        return (com.codename1.ui.TextArea)findByName("txtPhysicalAddress", root);
    }

    public com.codename1.ui.TextArea findTxtPhysicalAddress() {
        com.codename1.ui.TextArea cmp = (com.codename1.ui.TextArea)findByName("txtPhysicalAddress", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextArea)findByName("txtPhysicalAddress", aboutToShowThisContainer);
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

    public com.codename1.ui.Label findLabel111(Component root) {
        return (com.codename1.ui.Label)findByName("Label111", root);
    }

    public com.codename1.ui.Label findLabel111() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label111", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label111", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnIcon(Component root) {
        return (com.codename1.ui.Button)findByName("btnIcon", root);
    }

    public com.codename1.ui.Button findBtnIcon() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnIcon", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnIcon", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnAddUser(Component root) {
        return (com.codename1.ui.Button)findByName("btnAddUser", root);
    }

    public com.codename1.ui.Button findBtnAddUser() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnAddUser", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnAddUser", aboutToShowThisContainer);
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

    public com.codename1.ui.CheckBox findCheckBox(Component root) {
        return (com.codename1.ui.CheckBox)findByName("CheckBox", root);
    }

    public com.codename1.ui.CheckBox findCheckBox() {
        com.codename1.ui.CheckBox cmp = (com.codename1.ui.CheckBox)findByName("CheckBox", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.CheckBox)findByName("CheckBox", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.spinner.Picker findPickerPriority(Component root) {
        return (com.codename1.ui.spinner.Picker)findByName("pickerPriority", root);
    }

    public com.codename1.ui.spinner.Picker findPickerPriority() {
        com.codename1.ui.spinner.Picker cmp = (com.codename1.ui.spinner.Picker)findByName("pickerPriority", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.spinner.Picker)findByName("pickerPriority", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findButton5(Component root) {
        return (com.codename1.ui.Button)findByName("Button5", root);
    }

    public com.codename1.ui.Button findButton5() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Button5", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Button5", aboutToShowThisContainer);
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

    public com.codename1.ui.Button findButton4(Component root) {
        return (com.codename1.ui.Button)findByName("Button4", root);
    }

    public com.codename1.ui.Button findButton4() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Button4", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Button4", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findButton3(Component root) {
        return (com.codename1.ui.Button)findByName("Button3", root);
    }

    public com.codename1.ui.Button findButton3() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Button3", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Button3", aboutToShowThisContainer);
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

    public com.codename1.ui.spinner.Picker findPickerCountry(Component root) {
        return (com.codename1.ui.spinner.Picker)findByName("pickerCountry", root);
    }

    public com.codename1.ui.spinner.Picker findPickerCountry() {
        com.codename1.ui.spinner.Picker cmp = (com.codename1.ui.spinner.Picker)findByName("pickerCountry", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.spinner.Picker)findByName("pickerCountry", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContCommunication(Component root) {
        return (com.codename1.ui.Container)findByName("ContCommunication", root);
    }

    public com.codename1.ui.Container findContCommunication() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ContCommunication", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ContCommunication", aboutToShowThisContainer);
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

    public com.codename1.ui.TextField findTxtTaskTitle(Component root) {
        return (com.codename1.ui.TextField)findByName("txtTaskTitle", root);
    }

    public com.codename1.ui.TextField findTxtTaskTitle() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("txtTaskTitle", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("txtTaskTitle", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel71(Component root) {
        return (com.codename1.ui.Label)findByName("Label71", root);
    }

    public com.codename1.ui.Label findLabel71() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label71", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label71", aboutToShowThisContainer);
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

    public com.codename1.ui.Container findComment(Component root) {
        return (com.codename1.ui.Container)findByName("Comment", root);
    }

    public com.codename1.ui.Container findComment() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Comment", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Comment", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLblAssigned(Component root) {
        return (com.codename1.ui.Label)findByName("lblAssigned", root);
    }

    public com.codename1.ui.Label findLblAssigned() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("lblAssigned", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("lblAssigned", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnClose(Component root) {
        return (com.codename1.ui.Button)findByName("btnClose", root);
    }

    public com.codename1.ui.Button findBtnClose() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnClose", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnClose", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.CheckBox findCheckBox2(Component root) {
        return (com.codename1.ui.CheckBox)findByName("CheckBox2", root);
    }

    public com.codename1.ui.CheckBox findCheckBox2() {
        com.codename1.ui.CheckBox cmp = (com.codename1.ui.CheckBox)findByName("CheckBox2", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.CheckBox)findByName("CheckBox2", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.CheckBox findCheckBox1(Component root) {
        return (com.codename1.ui.CheckBox)findByName("CheckBox1", root);
    }

    public com.codename1.ui.CheckBox findCheckBox1() {
        com.codename1.ui.CheckBox cmp = (com.codename1.ui.CheckBox)findByName("CheckBox1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.CheckBox)findByName("CheckBox1", aboutToShowThisContainer);
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

    public com.codename1.ui.Container findContactItem(Component root) {
        return (com.codename1.ui.Container)findByName("ContactItem", root);
    }

    public com.codename1.ui.Container findContactItem() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("ContactItem", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("ContactItem", aboutToShowThisContainer);
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

    public com.codename1.ui.Button findBtnAssign(Component root) {
        return (com.codename1.ui.Button)findByName("btnAssign", root);
    }

    public com.codename1.ui.Button findBtnAssign() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnAssign", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnAssign", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnPhysicalAddress(Component root) {
        return (com.codename1.ui.Button)findByName("btnPhysicalAddress", root);
    }

    public com.codename1.ui.Button findBtnPhysicalAddress() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("btnPhysicalAddress", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("btnPhysicalAddress", aboutToShowThisContainer);
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

    public com.codename1.components.SpanLabel findSpanLabel2(Component root) {
        return (com.codename1.components.SpanLabel)findByName("SpanLabel2", root);
    }

    public com.codename1.components.SpanLabel findSpanLabel2() {
        com.codename1.components.SpanLabel cmp = (com.codename1.components.SpanLabel)findByName("SpanLabel2", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.components.SpanLabel)findByName("SpanLabel2", aboutToShowThisContainer);
        }
        return cmp;
    }

    public static final int COMMAND_FormCommunicationSend = 10;
    public static final int COMMAND_TaskNewMembersAddMembers = 8;
    public static final int COMMAND_LoginRegisterAsAUser = 12;
    public static final int COMMAND_TaskNewAssignMembers = 9;
    public static final int COMMAND_ForgotPasswordResetPassword = 13;
    public static final int COMMAND_LoginLogin = 5;
    public static final int COMMAND_TaskNewCreateTask = 4;
    public static final int COMMAND_LoginForgotLoginDetails = 14;
    public static final int COMMAND_ContDashBoardCommand19 = 19;
    public static final int COMMAND_TaskNewTaskDiary = 18;

    protected boolean onFormCommunicationSend() {
        return false;
    }

    protected boolean onTaskNewMembersAddMembers() {
        return false;
    }

    protected boolean onLoginRegisterAsAUser() {
        return false;
    }

    protected boolean onTaskNewAssignMembers() {
        return false;
    }

    protected boolean onForgotPasswordResetPassword() {
        return false;
    }

    protected boolean onLoginLogin() {
        return false;
    }

    protected boolean onTaskNewCreateTask() {
        return false;
    }

    protected boolean onLoginForgotLoginDetails() {
        return false;
    }

    protected boolean onContDashBoardCommand19() {
        return false;
    }

    protected boolean onTaskNewTaskDiary() {
        return false;
    }

    protected void processCommand(ActionEvent ev, Command cmd) {
        switch(cmd.getId()) {
            case COMMAND_FormCommunicationSend:
                if(onFormCommunicationSend()) {
                    ev.consume();
                    return;
                }
                break;

            case COMMAND_TaskNewMembersAddMembers:
                if(onTaskNewMembersAddMembers()) {
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

            case COMMAND_TaskNewAssignMembers:
                if(onTaskNewAssignMembers()) {
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

            case COMMAND_TaskNewCreateTask:
                if(onTaskNewCreateTask()) {
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

            case COMMAND_TaskNewTaskDiary:
                if(onTaskNewTaskDiary()) {
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

        if("ContTasksList".equals(f.getName())) {
            exitContTasksList(f);
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

        if("User New".equals(f.getName())) {
            exitUserNew(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ForgotPassword".equals(f.getName())) {
            exitForgotPassword(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Help".equals(f.getName())) {
            exitHelp(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContDashBoard".equals(f.getName())) {
            exitContDashBoard(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Task Add Members".equals(f.getName())) {
            exitTaskAddMembers(f);
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

        if("Splash".equals(f.getName())) {
            exitSplash(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContContacts".equals(f.getName())) {
            exitContContacts(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("FormSocial".equals(f.getName())) {
            exitFormSocial(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("DialogOk".equals(f.getName())) {
            exitDialogOk(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("FormCommunication".equals(f.getName())) {
            exitFormCommunication(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContReports".equals(f.getName())) {
            exitContReports(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Project New".equals(f.getName())) {
            exitProjectNew(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Registration".equals(f.getName())) {
            exitRegistration(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Task New Members".equals(f.getName())) {
            exitTaskNewMembers(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("FormCurrency".equals(f.getName())) {
            exitFormCurrency(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("FormWeather".equals(f.getName())) {
            exitFormWeather(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContCommunication".equals(f.getName())) {
            exitContCommunication(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContSideMenu".equals(f.getName())) {
            exitContSideMenu(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Task New".equals(f.getName())) {
            exitTaskNew(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContactItem".equals(f.getName())) {
            exitContactItem(f);
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


    protected void exitContTasksList(Form f) {
    }


    protected void exitContProfile(Form f) {
    }


    protected void exitLogin(Form f) {
    }


    protected void exitUserNew(Form f) {
    }


    protected void exitForgotPassword(Form f) {
    }


    protected void exitHelp(Form f) {
    }


    protected void exitContDashBoard(Form f) {
    }


    protected void exitTaskAddMembers(Form f) {
    }


    protected void exitContProjects(Form f) {
    }


    protected void exitContTasks(Form f) {
    }


    protected void exitSplash(Form f) {
    }


    protected void exitContContacts(Form f) {
    }


    protected void exitFormSocial(Form f) {
    }


    protected void exitDialogOk(Form f) {
    }


    protected void exitFormCommunication(Form f) {
    }


    protected void exitContReports(Form f) {
    }


    protected void exitProjectNew(Form f) {
    }


    protected void exitRegistration(Form f) {
    }


    protected void exitTaskNewMembers(Form f) {
    }


    protected void exitFormCurrency(Form f) {
    }


    protected void exitFormWeather(Form f) {
    }


    protected void exitContCommunication(Form f) {
    }


    protected void exitContSideMenu(Form f) {
    }


    protected void exitTaskNew(Form f) {
    }


    protected void exitContactItem(Form f) {
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

        if("ContTasksList".equals(f.getName())) {
            beforeContTasksList(f);
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

        if("User New".equals(f.getName())) {
            beforeUserNew(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ForgotPassword".equals(f.getName())) {
            beforeForgotPassword(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Help".equals(f.getName())) {
            beforeHelp(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContDashBoard".equals(f.getName())) {
            beforeContDashBoard(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Task Add Members".equals(f.getName())) {
            beforeTaskAddMembers(f);
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

        if("Splash".equals(f.getName())) {
            beforeSplash(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContContacts".equals(f.getName())) {
            beforeContContacts(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("FormSocial".equals(f.getName())) {
            beforeFormSocial(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("DialogOk".equals(f.getName())) {
            beforeDialogOk(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("FormCommunication".equals(f.getName())) {
            beforeFormCommunication(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContReports".equals(f.getName())) {
            beforeContReports(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Project New".equals(f.getName())) {
            beforeProjectNew(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Registration".equals(f.getName())) {
            beforeRegistration(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Task New Members".equals(f.getName())) {
            beforeTaskNewMembers(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("FormCurrency".equals(f.getName())) {
            beforeFormCurrency(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("FormWeather".equals(f.getName())) {
            beforeFormWeather(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContCommunication".equals(f.getName())) {
            beforeContCommunication(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContSideMenu".equals(f.getName())) {
            beforeContSideMenu(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Task New".equals(f.getName())) {
            beforeTaskNew(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContactItem".equals(f.getName())) {
            beforeContactItem(f);
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


    protected void beforeContTasksList(Form f) {
    }


    protected void beforeContProfile(Form f) {
    }


    protected void beforeLogin(Form f) {
    }


    protected void beforeUserNew(Form f) {
    }


    protected void beforeForgotPassword(Form f) {
    }


    protected void beforeHelp(Form f) {
    }


    protected void beforeContDashBoard(Form f) {
    }


    protected void beforeTaskAddMembers(Form f) {
    }


    protected void beforeContProjects(Form f) {
    }


    protected void beforeContTasks(Form f) {
    }


    protected void beforeSplash(Form f) {
    }


    protected void beforeContContacts(Form f) {
    }


    protected void beforeFormSocial(Form f) {
    }


    protected void beforeDialogOk(Form f) {
    }


    protected void beforeFormCommunication(Form f) {
    }


    protected void beforeContReports(Form f) {
    }


    protected void beforeProjectNew(Form f) {
    }


    protected void beforeRegistration(Form f) {
    }


    protected void beforeTaskNewMembers(Form f) {
    }


    protected void beforeFormCurrency(Form f) {
    }


    protected void beforeFormWeather(Form f) {
    }


    protected void beforeContCommunication(Form f) {
    }


    protected void beforeContSideMenu(Form f) {
    }


    protected void beforeTaskNew(Form f) {
    }


    protected void beforeContactItem(Form f) {
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

        if("ContTasksList".equals(c.getName())) {
            beforeContainerContTasksList(c);
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

        if("User New".equals(c.getName())) {
            beforeContainerUserNew(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ForgotPassword".equals(c.getName())) {
            beforeContainerForgotPassword(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Help".equals(c.getName())) {
            beforeContainerHelp(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContDashBoard".equals(c.getName())) {
            beforeContainerContDashBoard(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Task Add Members".equals(c.getName())) {
            beforeContainerTaskAddMembers(c);
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

        if("Splash".equals(c.getName())) {
            beforeContainerSplash(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContContacts".equals(c.getName())) {
            beforeContainerContContacts(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("FormSocial".equals(c.getName())) {
            beforeContainerFormSocial(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("DialogOk".equals(c.getName())) {
            beforeContainerDialogOk(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("FormCommunication".equals(c.getName())) {
            beforeContainerFormCommunication(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContReports".equals(c.getName())) {
            beforeContainerContReports(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Project New".equals(c.getName())) {
            beforeContainerProjectNew(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Registration".equals(c.getName())) {
            beforeContainerRegistration(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Task New Members".equals(c.getName())) {
            beforeContainerTaskNewMembers(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("FormCurrency".equals(c.getName())) {
            beforeContainerFormCurrency(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("FormWeather".equals(c.getName())) {
            beforeContainerFormWeather(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContCommunication".equals(c.getName())) {
            beforeContainerContCommunication(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContSideMenu".equals(c.getName())) {
            beforeContainerContSideMenu(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Task New".equals(c.getName())) {
            beforeContainerTaskNew(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContactItem".equals(c.getName())) {
            beforeContainerContactItem(c);
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


    protected void beforeContainerContTasksList(Container c) {
    }


    protected void beforeContainerContProfile(Container c) {
    }


    protected void beforeContainerLogin(Container c) {
    }


    protected void beforeContainerUserNew(Container c) {
    }


    protected void beforeContainerForgotPassword(Container c) {
    }


    protected void beforeContainerHelp(Container c) {
    }


    protected void beforeContainerContDashBoard(Container c) {
    }


    protected void beforeContainerTaskAddMembers(Container c) {
    }


    protected void beforeContainerContProjects(Container c) {
    }


    protected void beforeContainerContTasks(Container c) {
    }


    protected void beforeContainerSplash(Container c) {
    }


    protected void beforeContainerContContacts(Container c) {
    }


    protected void beforeContainerFormSocial(Container c) {
    }


    protected void beforeContainerDialogOk(Container c) {
    }


    protected void beforeContainerFormCommunication(Container c) {
    }


    protected void beforeContainerContReports(Container c) {
    }


    protected void beforeContainerProjectNew(Container c) {
    }


    protected void beforeContainerRegistration(Container c) {
    }


    protected void beforeContainerTaskNewMembers(Container c) {
    }


    protected void beforeContainerFormCurrency(Container c) {
    }


    protected void beforeContainerFormWeather(Container c) {
    }


    protected void beforeContainerContCommunication(Container c) {
    }


    protected void beforeContainerContSideMenu(Container c) {
    }


    protected void beforeContainerTaskNew(Container c) {
    }


    protected void beforeContainerContactItem(Container c) {
    }


    protected void beforeContainerMain(Container c) {
    }

    protected void postShow(Form f) {
        if("ContSettings".equals(f.getName())) {
            postContSettings(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContTasksList".equals(f.getName())) {
            postContTasksList(f);
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

        if("User New".equals(f.getName())) {
            postUserNew(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ForgotPassword".equals(f.getName())) {
            postForgotPassword(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Help".equals(f.getName())) {
            postHelp(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContDashBoard".equals(f.getName())) {
            postContDashBoard(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Task Add Members".equals(f.getName())) {
            postTaskAddMembers(f);
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

        if("Splash".equals(f.getName())) {
            postSplash(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContContacts".equals(f.getName())) {
            postContContacts(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("FormSocial".equals(f.getName())) {
            postFormSocial(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("DialogOk".equals(f.getName())) {
            postDialogOk(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("FormCommunication".equals(f.getName())) {
            postFormCommunication(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContReports".equals(f.getName())) {
            postContReports(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Project New".equals(f.getName())) {
            postProjectNew(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Registration".equals(f.getName())) {
            postRegistration(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Task New Members".equals(f.getName())) {
            postTaskNewMembers(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("FormCurrency".equals(f.getName())) {
            postFormCurrency(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("FormWeather".equals(f.getName())) {
            postFormWeather(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContCommunication".equals(f.getName())) {
            postContCommunication(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContSideMenu".equals(f.getName())) {
            postContSideMenu(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Task New".equals(f.getName())) {
            postTaskNew(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContactItem".equals(f.getName())) {
            postContactItem(f);
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


    protected void postContTasksList(Form f) {
    }


    protected void postContProfile(Form f) {
    }


    protected void postLogin(Form f) {
    }


    protected void postUserNew(Form f) {
    }


    protected void postForgotPassword(Form f) {
    }


    protected void postHelp(Form f) {
    }


    protected void postContDashBoard(Form f) {
    }


    protected void postTaskAddMembers(Form f) {
    }


    protected void postContProjects(Form f) {
    }


    protected void postContTasks(Form f) {
    }


    protected void postSplash(Form f) {
    }


    protected void postContContacts(Form f) {
    }


    protected void postFormSocial(Form f) {
    }


    protected void postDialogOk(Form f) {
    }


    protected void postFormCommunication(Form f) {
    }


    protected void postContReports(Form f) {
    }


    protected void postProjectNew(Form f) {
    }


    protected void postRegistration(Form f) {
    }


    protected void postTaskNewMembers(Form f) {
    }


    protected void postFormCurrency(Form f) {
    }


    protected void postFormWeather(Form f) {
    }


    protected void postContCommunication(Form f) {
    }


    protected void postContSideMenu(Form f) {
    }


    protected void postTaskNew(Form f) {
    }


    protected void postContactItem(Form f) {
    }


    protected void postMain(Form f) {
    }

    protected void postShowContainer(Container c) {
        if("ContSettings".equals(c.getName())) {
            postContainerContSettings(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContTasksList".equals(c.getName())) {
            postContainerContTasksList(c);
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

        if("User New".equals(c.getName())) {
            postContainerUserNew(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ForgotPassword".equals(c.getName())) {
            postContainerForgotPassword(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Help".equals(c.getName())) {
            postContainerHelp(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContDashBoard".equals(c.getName())) {
            postContainerContDashBoard(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Task Add Members".equals(c.getName())) {
            postContainerTaskAddMembers(c);
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

        if("Splash".equals(c.getName())) {
            postContainerSplash(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContContacts".equals(c.getName())) {
            postContainerContContacts(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("FormSocial".equals(c.getName())) {
            postContainerFormSocial(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("DialogOk".equals(c.getName())) {
            postContainerDialogOk(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("FormCommunication".equals(c.getName())) {
            postContainerFormCommunication(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContReports".equals(c.getName())) {
            postContainerContReports(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Project New".equals(c.getName())) {
            postContainerProjectNew(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Registration".equals(c.getName())) {
            postContainerRegistration(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Task New Members".equals(c.getName())) {
            postContainerTaskNewMembers(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("FormCurrency".equals(c.getName())) {
            postContainerFormCurrency(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("FormWeather".equals(c.getName())) {
            postContainerFormWeather(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContCommunication".equals(c.getName())) {
            postContainerContCommunication(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContSideMenu".equals(c.getName())) {
            postContainerContSideMenu(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Task New".equals(c.getName())) {
            postContainerTaskNew(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContactItem".equals(c.getName())) {
            postContainerContactItem(c);
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


    protected void postContainerContTasksList(Container c) {
    }


    protected void postContainerContProfile(Container c) {
    }


    protected void postContainerLogin(Container c) {
    }


    protected void postContainerUserNew(Container c) {
    }


    protected void postContainerForgotPassword(Container c) {
    }


    protected void postContainerHelp(Container c) {
    }


    protected void postContainerContDashBoard(Container c) {
    }


    protected void postContainerTaskAddMembers(Container c) {
    }


    protected void postContainerContProjects(Container c) {
    }


    protected void postContainerContTasks(Container c) {
    }


    protected void postContainerSplash(Container c) {
    }


    protected void postContainerContContacts(Container c) {
    }


    protected void postContainerFormSocial(Container c) {
    }


    protected void postContainerDialogOk(Container c) {
    }


    protected void postContainerFormCommunication(Container c) {
    }


    protected void postContainerContReports(Container c) {
    }


    protected void postContainerProjectNew(Container c) {
    }


    protected void postContainerRegistration(Container c) {
    }


    protected void postContainerTaskNewMembers(Container c) {
    }


    protected void postContainerFormCurrency(Container c) {
    }


    protected void postContainerFormWeather(Container c) {
    }


    protected void postContainerContCommunication(Container c) {
    }


    protected void postContainerContSideMenu(Container c) {
    }


    protected void postContainerTaskNew(Container c) {
    }


    protected void postContainerContactItem(Container c) {
    }


    protected void postContainerMain(Container c) {
    }

    protected void onCreateRoot(String rootName) {
        if("ContSettings".equals(rootName)) {
            onCreateContSettings();
            aboutToShowThisContainer = null;
            return;
        }

        if("ContTasksList".equals(rootName)) {
            onCreateContTasksList();
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

        if("User New".equals(rootName)) {
            onCreateUserNew();
            aboutToShowThisContainer = null;
            return;
        }

        if("ForgotPassword".equals(rootName)) {
            onCreateForgotPassword();
            aboutToShowThisContainer = null;
            return;
        }

        if("Help".equals(rootName)) {
            onCreateHelp();
            aboutToShowThisContainer = null;
            return;
        }

        if("ContDashBoard".equals(rootName)) {
            onCreateContDashBoard();
            aboutToShowThisContainer = null;
            return;
        }

        if("Task Add Members".equals(rootName)) {
            onCreateTaskAddMembers();
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

        if("Splash".equals(rootName)) {
            onCreateSplash();
            aboutToShowThisContainer = null;
            return;
        }

        if("ContContacts".equals(rootName)) {
            onCreateContContacts();
            aboutToShowThisContainer = null;
            return;
        }

        if("FormSocial".equals(rootName)) {
            onCreateFormSocial();
            aboutToShowThisContainer = null;
            return;
        }

        if("DialogOk".equals(rootName)) {
            onCreateDialogOk();
            aboutToShowThisContainer = null;
            return;
        }

        if("FormCommunication".equals(rootName)) {
            onCreateFormCommunication();
            aboutToShowThisContainer = null;
            return;
        }

        if("ContReports".equals(rootName)) {
            onCreateContReports();
            aboutToShowThisContainer = null;
            return;
        }

        if("Project New".equals(rootName)) {
            onCreateProjectNew();
            aboutToShowThisContainer = null;
            return;
        }

        if("Registration".equals(rootName)) {
            onCreateRegistration();
            aboutToShowThisContainer = null;
            return;
        }

        if("Task New Members".equals(rootName)) {
            onCreateTaskNewMembers();
            aboutToShowThisContainer = null;
            return;
        }

        if("FormCurrency".equals(rootName)) {
            onCreateFormCurrency();
            aboutToShowThisContainer = null;
            return;
        }

        if("FormWeather".equals(rootName)) {
            onCreateFormWeather();
            aboutToShowThisContainer = null;
            return;
        }

        if("ContCommunication".equals(rootName)) {
            onCreateContCommunication();
            aboutToShowThisContainer = null;
            return;
        }

        if("ContSideMenu".equals(rootName)) {
            onCreateContSideMenu();
            aboutToShowThisContainer = null;
            return;
        }

        if("Task New".equals(rootName)) {
            onCreateTaskNew();
            aboutToShowThisContainer = null;
            return;
        }

        if("ContactItem".equals(rootName)) {
            onCreateContactItem();
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


    protected void onCreateContTasksList() {
    }


    protected void onCreateContProfile() {
    }


    protected void onCreateLogin() {
    }


    protected void onCreateUserNew() {
    }


    protected void onCreateForgotPassword() {
    }


    protected void onCreateHelp() {
    }


    protected void onCreateContDashBoard() {
    }


    protected void onCreateTaskAddMembers() {
    }


    protected void onCreateContProjects() {
    }


    protected void onCreateContTasks() {
    }


    protected void onCreateSplash() {
    }


    protected void onCreateContContacts() {
    }


    protected void onCreateFormSocial() {
    }


    protected void onCreateDialogOk() {
    }


    protected void onCreateFormCommunication() {
    }


    protected void onCreateContReports() {
    }


    protected void onCreateProjectNew() {
    }


    protected void onCreateRegistration() {
    }


    protected void onCreateTaskNewMembers() {
    }


    protected void onCreateFormCurrency() {
    }


    protected void onCreateFormWeather() {
    }


    protected void onCreateContCommunication() {
    }


    protected void onCreateContSideMenu() {
    }


    protected void onCreateTaskNew() {
    }


    protected void onCreateContactItem() {
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

        if("ContTasksList".equals(f.getName())) {
            getStateContTasksList(f, h);
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

        if("User New".equals(f.getName())) {
            getStateUserNew(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("ForgotPassword".equals(f.getName())) {
            getStateForgotPassword(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("Help".equals(f.getName())) {
            getStateHelp(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("ContDashBoard".equals(f.getName())) {
            getStateContDashBoard(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("Task Add Members".equals(f.getName())) {
            getStateTaskAddMembers(f, h);
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

        if("Splash".equals(f.getName())) {
            getStateSplash(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("ContContacts".equals(f.getName())) {
            getStateContContacts(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("FormSocial".equals(f.getName())) {
            getStateFormSocial(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("DialogOk".equals(f.getName())) {
            getStateDialogOk(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("FormCommunication".equals(f.getName())) {
            getStateFormCommunication(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("ContReports".equals(f.getName())) {
            getStateContReports(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("Project New".equals(f.getName())) {
            getStateProjectNew(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("Registration".equals(f.getName())) {
            getStateRegistration(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("Task New Members".equals(f.getName())) {
            getStateTaskNewMembers(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("FormCurrency".equals(f.getName())) {
            getStateFormCurrency(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("FormWeather".equals(f.getName())) {
            getStateFormWeather(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("ContCommunication".equals(f.getName())) {
            getStateContCommunication(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("ContSideMenu".equals(f.getName())) {
            getStateContSideMenu(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("Task New".equals(f.getName())) {
            getStateTaskNew(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("ContactItem".equals(f.getName())) {
            getStateContactItem(f, h);
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


    protected void getStateContTasksList(Form f, Hashtable h) {
    }


    protected void getStateContProfile(Form f, Hashtable h) {
    }


    protected void getStateLogin(Form f, Hashtable h) {
    }


    protected void getStateUserNew(Form f, Hashtable h) {
    }


    protected void getStateForgotPassword(Form f, Hashtable h) {
    }


    protected void getStateHelp(Form f, Hashtable h) {
    }


    protected void getStateContDashBoard(Form f, Hashtable h) {
    }


    protected void getStateTaskAddMembers(Form f, Hashtable h) {
    }


    protected void getStateContProjects(Form f, Hashtable h) {
    }


    protected void getStateContTasks(Form f, Hashtable h) {
    }


    protected void getStateSplash(Form f, Hashtable h) {
    }


    protected void getStateContContacts(Form f, Hashtable h) {
    }


    protected void getStateFormSocial(Form f, Hashtable h) {
    }


    protected void getStateDialogOk(Form f, Hashtable h) {
    }


    protected void getStateFormCommunication(Form f, Hashtable h) {
    }


    protected void getStateContReports(Form f, Hashtable h) {
    }


    protected void getStateProjectNew(Form f, Hashtable h) {
    }


    protected void getStateRegistration(Form f, Hashtable h) {
    }


    protected void getStateTaskNewMembers(Form f, Hashtable h) {
    }


    protected void getStateFormCurrency(Form f, Hashtable h) {
    }


    protected void getStateFormWeather(Form f, Hashtable h) {
    }


    protected void getStateContCommunication(Form f, Hashtable h) {
    }


    protected void getStateContSideMenu(Form f, Hashtable h) {
    }


    protected void getStateTaskNew(Form f, Hashtable h) {
    }


    protected void getStateContactItem(Form f, Hashtable h) {
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

        if("ContTasksList".equals(f.getName())) {
            setStateContTasksList(f, state);
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

        if("User New".equals(f.getName())) {
            setStateUserNew(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("ForgotPassword".equals(f.getName())) {
            setStateForgotPassword(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("Help".equals(f.getName())) {
            setStateHelp(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContDashBoard".equals(f.getName())) {
            setStateContDashBoard(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("Task Add Members".equals(f.getName())) {
            setStateTaskAddMembers(f, state);
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

        if("Splash".equals(f.getName())) {
            setStateSplash(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContContacts".equals(f.getName())) {
            setStateContContacts(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("FormSocial".equals(f.getName())) {
            setStateFormSocial(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("DialogOk".equals(f.getName())) {
            setStateDialogOk(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("FormCommunication".equals(f.getName())) {
            setStateFormCommunication(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContReports".equals(f.getName())) {
            setStateContReports(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("Project New".equals(f.getName())) {
            setStateProjectNew(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("Registration".equals(f.getName())) {
            setStateRegistration(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("Task New Members".equals(f.getName())) {
            setStateTaskNewMembers(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("FormCurrency".equals(f.getName())) {
            setStateFormCurrency(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("FormWeather".equals(f.getName())) {
            setStateFormWeather(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContCommunication".equals(f.getName())) {
            setStateContCommunication(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContSideMenu".equals(f.getName())) {
            setStateContSideMenu(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("Task New".equals(f.getName())) {
            setStateTaskNew(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("ContactItem".equals(f.getName())) {
            setStateContactItem(f, state);
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


    protected void setStateContTasksList(Form f, Hashtable state) {
    }


    protected void setStateContProfile(Form f, Hashtable state) {
    }


    protected void setStateLogin(Form f, Hashtable state) {
    }


    protected void setStateUserNew(Form f, Hashtable state) {
    }


    protected void setStateForgotPassword(Form f, Hashtable state) {
    }


    protected void setStateHelp(Form f, Hashtable state) {
    }


    protected void setStateContDashBoard(Form f, Hashtable state) {
    }


    protected void setStateTaskAddMembers(Form f, Hashtable state) {
    }


    protected void setStateContProjects(Form f, Hashtable state) {
    }


    protected void setStateContTasks(Form f, Hashtable state) {
    }


    protected void setStateSplash(Form f, Hashtable state) {
    }


    protected void setStateContContacts(Form f, Hashtable state) {
    }


    protected void setStateFormSocial(Form f, Hashtable state) {
    }


    protected void setStateDialogOk(Form f, Hashtable state) {
    }


    protected void setStateFormCommunication(Form f, Hashtable state) {
    }


    protected void setStateContReports(Form f, Hashtable state) {
    }


    protected void setStateProjectNew(Form f, Hashtable state) {
    }


    protected void setStateRegistration(Form f, Hashtable state) {
    }


    protected void setStateTaskNewMembers(Form f, Hashtable state) {
    }


    protected void setStateFormCurrency(Form f, Hashtable state) {
    }


    protected void setStateFormWeather(Form f, Hashtable state) {
    }


    protected void setStateContCommunication(Form f, Hashtable state) {
    }


    protected void setStateContSideMenu(Form f, Hashtable state) {
    }


    protected void setStateTaskNew(Form f, Hashtable state) {
    }


    protected void setStateContactItem(Form f, Hashtable state) {
    }


    protected void setStateMain(Form f, Hashtable state) {
    }

    protected boolean setListModel(List cmp) {
        String listName = cmp.getName();
        if("List".equals(listName)) {
            return initListModelList(cmp);
        }
        return super.setListModel(cmp);
    }

    protected boolean initListModelList(List cmp) {
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
        if(rootContainerName.equals("ContTasksList")) {
            if("Button".equals(c.getName())) {
                onContTasksList_ButtonAction(c, event);
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
        if(rootContainerName.equals("User New")) {
            if("txtFirstname".equals(c.getName())) {
                onUserNew_TxtFirstnameAction(c, event);
                return;
            }
            if("txtLastname".equals(c.getName())) {
                onUserNew_TxtLastnameAction(c, event);
                return;
            }
            if("txtEmail".equals(c.getName())) {
                onUserNew_TxtEmailAction(c, event);
                return;
            }
            if("txtPassword".equals(c.getName())) {
                onUserNew_TxtPasswordAction(c, event);
                return;
            }
            if("btnAddUser".equals(c.getName())) {
                onUserNew_BtnAddUserAction(c, event);
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
        if(rootContainerName.equals("Help")) {
            if("btnEmail".equals(c.getName())) {
                onHelp_BtnEmailAction(c, event);
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
        }
        if(rootContainerName.equals("Task Add Members")) {
            if("CheckBox2".equals(c.getName())) {
                onTaskAddMembers_CheckBox2Action(c, event);
                return;
            }
            if("CheckBox1".equals(c.getName())) {
                onTaskAddMembers_CheckBox1Action(c, event);
                return;
            }
            if("CheckBox".equals(c.getName())) {
                onTaskAddMembers_CheckBoxAction(c, event);
                return;
            }
            if("Button1".equals(c.getName())) {
                onTaskAddMembers_Button1Action(c, event);
                return;
            }
        }
        if(rootContainerName.equals("ContProjects")) {
            if("TextField".equals(c.getName())) {
                onContProjects_TextFieldAction(c, event);
                return;
            }
            if("TextField1".equals(c.getName())) {
                onContProjects_TextField1Action(c, event);
                return;
            }
            if("TextField2".equals(c.getName())) {
                onContProjects_TextField2Action(c, event);
                return;
            }
            if("Button".equals(c.getName())) {
                onContProjects_ButtonAction(c, event);
                return;
            }
            if("Button11".equals(c.getName())) {
                onContProjects_Button11Action(c, event);
                return;
            }
            if("TextField3".equals(c.getName())) {
                onContProjects_TextField3Action(c, event);
                return;
            }
            if("Button2".equals(c.getName())) {
                onContProjects_Button2Action(c, event);
                return;
            }
            if("Button1".equals(c.getName())) {
                onContProjects_Button1Action(c, event);
                return;
            }
        }
        if(rootContainerName.equals("ContTasks")) {
            if("TextField".equals(c.getName())) {
                onContTasks_TextFieldAction(c, event);
                return;
            }
            if("Button".equals(c.getName())) {
                onContTasks_ButtonAction(c, event);
                return;
            }
            if("Button4".equals(c.getName())) {
                onContTasks_Button4Action(c, event);
                return;
            }
        }
        if(rootContainerName.equals("ContContacts")) {
            if("txtSearch".equals(c.getName())) {
                onContContacts_TxtSearchAction(c, event);
                return;
            }
            if("Button".equals(c.getName())) {
                onContContacts_ButtonAction(c, event);
                return;
            }
            if("btnIcon".equals(c.getName())) {
                onContContacts_BtnIconAction(c, event);
                return;
            }
            if("List".equals(c.getName())) {
                onContContacts_ListAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("FormCommunication")) {
            if("txtComment".equals(c.getName())) {
                onFormCommunication_TxtCommentAction(c, event);
                return;
            }
            if("btnSendComment".equals(c.getName())) {
                onFormCommunication_BtnSendCommentAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("Project New")) {
            if("txtTitle".equals(c.getName())) {
                onProjectNew_TxtTitleAction(c, event);
                return;
            }
            if("txtDescription".equals(c.getName())) {
                onProjectNew_TxtDescriptionAction(c, event);
                return;
            }
            if("dateTimePicker".equals(c.getName())) {
                onProjectNew_DateTimePickerAction(c, event);
                return;
            }
            if("timePicker".equals(c.getName())) {
                onProjectNew_TimePickerAction(c, event);
                return;
            }
            if("btnProjectAction".equals(c.getName())) {
                onProjectNew_BtnProjectActionAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("Registration")) {
            if("TextField".equals(c.getName())) {
                onRegistration_TextFieldAction(c, event);
                return;
            }
            if("Button".equals(c.getName())) {
                onRegistration_ButtonAction(c, event);
                return;
            }
            if("Button1".equals(c.getName())) {
                onRegistration_Button1Action(c, event);
                return;
            }
            if("pickerCountry".equals(c.getName())) {
                onRegistration_PickerCountryAction(c, event);
                return;
            }
            if("TextField2".equals(c.getName())) {
                onRegistration_TextField2Action(c, event);
                return;
            }
            if("TextField3".equals(c.getName())) {
                onRegistration_TextField3Action(c, event);
                return;
            }
            if("TextField4".equals(c.getName())) {
                onRegistration_TextField4Action(c, event);
                return;
            }
            if("TextField5".equals(c.getName())) {
                onRegistration_TextField5Action(c, event);
                return;
            }
            if("TextField1".equals(c.getName())) {
                onRegistration_TextField1Action(c, event);
                return;
            }
            if("Button2".equals(c.getName())) {
                onRegistration_Button2Action(c, event);
                return;
            }
            if("TextArea".equals(c.getName())) {
                onRegistration_TextAreaAction(c, event);
                return;
            }
            if("pickerProvince".equals(c.getName())) {
                onRegistration_PickerProvinceAction(c, event);
                return;
            }
            if("TextField6".equals(c.getName())) {
                onRegistration_TextField6Action(c, event);
                return;
            }
            if("TextField8".equals(c.getName())) {
                onRegistration_TextField8Action(c, event);
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
            if("Button3".equals(c.getName())) {
                onRegistration_Button3Action(c, event);
                return;
            }
            if("TextField7".equals(c.getName())) {
                onRegistration_TextField7Action(c, event);
                return;
            }
            if("Button5".equals(c.getName())) {
                onRegistration_Button5Action(c, event);
                return;
            }
            if("TextField9".equals(c.getName())) {
                onRegistration_TextField9Action(c, event);
                return;
            }
            if("TextField10".equals(c.getName())) {
                onRegistration_TextField10Action(c, event);
                return;
            }
            if("Button4".equals(c.getName())) {
                onRegistration_Button4Action(c, event);
                return;
            }
        }
        if(rootContainerName.equals("Task New Members")) {
            if("CheckBox".equals(c.getName())) {
                onTaskNewMembers_CheckBoxAction(c, event);
                return;
            }
            if("CheckBox1".equals(c.getName())) {
                onTaskNewMembers_CheckBox1Action(c, event);
                return;
            }
            if("CheckBox2".equals(c.getName())) {
                onTaskNewMembers_CheckBox2Action(c, event);
                return;
            }
            if("btnClose".equals(c.getName())) {
                onTaskNewMembers_BtnCloseAction(c, event);
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
        if(rootContainerName.equals("Task New")) {
            if("btnCommunication".equals(c.getName())) {
                onTaskNew_BtnCommunicationAction(c, event);
                return;
            }
            if("pickerProjectName".equals(c.getName())) {
                onTaskNew_PickerProjectNameAction(c, event);
                return;
            }
            if("txtTaskTitle".equals(c.getName())) {
                onTaskNew_TxtTaskTitleAction(c, event);
                return;
            }
            if("pickerPriority".equals(c.getName())) {
                onTaskNew_PickerPriorityAction(c, event);
                return;
            }
            if("pickerStatus".equals(c.getName())) {
                onTaskNew_PickerStatusAction(c, event);
                return;
            }
            if("pickerDate".equals(c.getName())) {
                onTaskNew_PickerDateAction(c, event);
                return;
            }
            if("pickerTime".equals(c.getName())) {
                onTaskNew_PickerTimeAction(c, event);
                return;
            }
            if("btnDescription".equals(c.getName())) {
                onTaskNew_BtnDescriptionAction(c, event);
                return;
            }
            if("txtDescription".equals(c.getName())) {
                onTaskNew_TxtDescriptionAction(c, event);
                return;
            }
            if("btnPhysicalAddress".equals(c.getName())) {
                onTaskNew_BtnPhysicalAddressAction(c, event);
                return;
            }
            if("txtPhysicalAddress".equals(c.getName())) {
                onTaskNew_TxtPhysicalAddressAction(c, event);
                return;
            }
            if("btnAssign".equals(c.getName())) {
                onTaskNew_BtnAssignAction(c, event);
                return;
            }
            if("btnCreateTask".equals(c.getName())) {
                onTaskNew_BtnCreateTaskAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("ContactItem")) {
            if("btnIcon".equals(c.getName())) {
                onContactItem_BtnIconAction(c, event);
                return;
            }
        }
    }

      protected void onContSettings_TxtHandleAction(Component c, ActionEvent event) {
      }

      protected void onContSettings_BtnSettingsSaveAction(Component c, ActionEvent event) {
      }

      protected void onContTasksList_ButtonAction(Component c, ActionEvent event) {
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

      protected void onUserNew_TxtFirstnameAction(Component c, ActionEvent event) {
      }

      protected void onUserNew_TxtLastnameAction(Component c, ActionEvent event) {
      }

      protected void onUserNew_TxtEmailAction(Component c, ActionEvent event) {
      }

      protected void onUserNew_TxtPasswordAction(Component c, ActionEvent event) {
      }

      protected void onUserNew_BtnAddUserAction(Component c, ActionEvent event) {
      }

      protected void onForgotPassword_TxtEmailAction(Component c, ActionEvent event) {
      }

      protected void onForgotPassword_TxtEmail1Action(Component c, ActionEvent event) {
      }

      protected void onForgotPassword_BtnRecoverPasswordAction(Component c, ActionEvent event) {
      }

      protected void onHelp_BtnEmailAction(Component c, ActionEvent event) {
      }

      protected void onContDashBoard_MbTasksAction(Component c, ActionEvent event) {
      }

      protected void onContDashBoard_MbCurrencyAction(Component c, ActionEvent event) {
      }

      protected void onTaskAddMembers_CheckBox2Action(Component c, ActionEvent event) {
      }

      protected void onTaskAddMembers_CheckBox1Action(Component c, ActionEvent event) {
      }

      protected void onTaskAddMembers_CheckBoxAction(Component c, ActionEvent event) {
      }

      protected void onTaskAddMembers_Button1Action(Component c, ActionEvent event) {
      }

      protected void onContProjects_TextFieldAction(Component c, ActionEvent event) {
      }

      protected void onContProjects_TextField1Action(Component c, ActionEvent event) {
      }

      protected void onContProjects_TextField2Action(Component c, ActionEvent event) {
      }

      protected void onContProjects_ButtonAction(Component c, ActionEvent event) {
      }

      protected void onContProjects_Button11Action(Component c, ActionEvent event) {
      }

      protected void onContProjects_TextField3Action(Component c, ActionEvent event) {
      }

      protected void onContProjects_Button2Action(Component c, ActionEvent event) {
      }

      protected void onContProjects_Button1Action(Component c, ActionEvent event) {
      }

      protected void onContTasks_TextFieldAction(Component c, ActionEvent event) {
      }

      protected void onContTasks_ButtonAction(Component c, ActionEvent event) {
      }

      protected void onContTasks_Button4Action(Component c, ActionEvent event) {
      }

      protected void onContContacts_TxtSearchAction(Component c, ActionEvent event) {
      }

      protected void onContContacts_ButtonAction(Component c, ActionEvent event) {
      }

      protected void onContContacts_BtnIconAction(Component c, ActionEvent event) {
      }

      protected void onContContacts_ListAction(Component c, ActionEvent event) {
      }

      protected void onFormCommunication_TxtCommentAction(Component c, ActionEvent event) {
      }

      protected void onFormCommunication_BtnSendCommentAction(Component c, ActionEvent event) {
      }

      protected void onProjectNew_TxtTitleAction(Component c, ActionEvent event) {
      }

      protected void onProjectNew_TxtDescriptionAction(Component c, ActionEvent event) {
      }

      protected void onProjectNew_DateTimePickerAction(Component c, ActionEvent event) {
      }

      protected void onProjectNew_TimePickerAction(Component c, ActionEvent event) {
      }

      protected void onProjectNew_BtnProjectActionAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_TextFieldAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_ButtonAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_Button1Action(Component c, ActionEvent event) {
      }

      protected void onRegistration_PickerCountryAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_TextField2Action(Component c, ActionEvent event) {
      }

      protected void onRegistration_TextField3Action(Component c, ActionEvent event) {
      }

      protected void onRegistration_TextField4Action(Component c, ActionEvent event) {
      }

      protected void onRegistration_TextField5Action(Component c, ActionEvent event) {
      }

      protected void onRegistration_TextField1Action(Component c, ActionEvent event) {
      }

      protected void onRegistration_Button2Action(Component c, ActionEvent event) {
      }

      protected void onRegistration_TextAreaAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_PickerProvinceAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_TextField6Action(Component c, ActionEvent event) {
      }

      protected void onRegistration_TextField8Action(Component c, ActionEvent event) {
      }

      protected void onRegistration_RdYesAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_RdNoAction(Component c, ActionEvent event) {
      }

      protected void onRegistration_Button3Action(Component c, ActionEvent event) {
      }

      protected void onRegistration_TextField7Action(Component c, ActionEvent event) {
      }

      protected void onRegistration_Button5Action(Component c, ActionEvent event) {
      }

      protected void onRegistration_TextField9Action(Component c, ActionEvent event) {
      }

      protected void onRegistration_TextField10Action(Component c, ActionEvent event) {
      }

      protected void onRegistration_Button4Action(Component c, ActionEvent event) {
      }

      protected void onTaskNewMembers_CheckBoxAction(Component c, ActionEvent event) {
      }

      protected void onTaskNewMembers_CheckBox1Action(Component c, ActionEvent event) {
      }

      protected void onTaskNewMembers_CheckBox2Action(Component c, ActionEvent event) {
      }

      protected void onTaskNewMembers_BtnCloseAction(Component c, ActionEvent event) {
      }

      protected void onContSideMenu_BtnProfilePicAction(Component c, ActionEvent event) {
      }

      protected void onContSideMenu_BtnProfileNameAction(Component c, ActionEvent event) {
      }

      protected void onContSideMenu_BtnDashboardAction(Component c, ActionEvent event) {
      }

      protected void onContSideMenu_BtnLogoutAction(Component c, ActionEvent event) {
      }

      protected void onTaskNew_BtnCommunicationAction(Component c, ActionEvent event) {
      }

      protected void onTaskNew_PickerProjectNameAction(Component c, ActionEvent event) {
      }

      protected void onTaskNew_TxtTaskTitleAction(Component c, ActionEvent event) {
      }

      protected void onTaskNew_PickerPriorityAction(Component c, ActionEvent event) {
      }

      protected void onTaskNew_PickerStatusAction(Component c, ActionEvent event) {
      }

      protected void onTaskNew_PickerDateAction(Component c, ActionEvent event) {
      }

      protected void onTaskNew_PickerTimeAction(Component c, ActionEvent event) {
      }

      protected void onTaskNew_BtnDescriptionAction(Component c, ActionEvent event) {
      }

      protected void onTaskNew_TxtDescriptionAction(Component c, ActionEvent event) {
      }

      protected void onTaskNew_BtnPhysicalAddressAction(Component c, ActionEvent event) {
      }

      protected void onTaskNew_TxtPhysicalAddressAction(Component c, ActionEvent event) {
      }

      protected void onTaskNew_BtnAssignAction(Component c, ActionEvent event) {
      }

      protected void onTaskNew_BtnCreateTaskAction(Component c, ActionEvent event) {
      }

      protected void onContactItem_BtnIconAction(Component c, ActionEvent event) {
      }

}
