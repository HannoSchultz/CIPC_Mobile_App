package userclasses;

import com.codename1.capture.Capture;
import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.models.SeriesSelection;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.components.FloatingActionButton;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.MultiButton;
import com.codename1.components.OnOffSwitch;
import com.codename1.components.SpanButton;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.Log;
import com.codename1.io.NetworkManager;
import com.codename1.io.Util;
import com.codename1.io.services.TwitterRESTService;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.messaging.Message;
import com.codename1.processing.Result;
import com.codename1.push.Push;
import com.codename1.push.PushCallback;
import generated.StateMachineBase;
import com.codename1.ui.*;
import com.codename1.ui.events.*;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.geom.Shape;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.list.ContainerList;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.FilterProxyListModel;
import com.codename1.ui.list.ListModel;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.DateSpinner;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.Constraint;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.RegexConstraint;
import com.codename1.ui.validation.Validator;
import com.codename1.util.regex.RE;

import com.sun.prism.paint.Color;
//import com.pmovil.nativega.GANative;
//import com.pmovil.nativega.HitBuilders;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TimeZone;
import za.co.cipc.webservices.UserWebServices;
import ui.FormProgress;

/**
 *
 * @author Your name here
 */
public class StateMachine extends StateMachineBase {

    //private com.pmovil.nativega.Tracker tracker;
    private String[] arrDevices;
    private String action = "";
    private Form current;
    private User oldUser;
    private String devicesString = "";

    private Container contCommunicationc;
    private Button btnProfilePic;
    private Button btnProfileName;
    private EncodedImage placeHolder;
    private Form newTask;

    private static String taskId = "";
    private static String defaultEmail = "";
    private static String defaultPassword = "";
    private static FormProgress formProgress;
    private String message = "";

    public StateMachine(String resFile) {
        super(resFile);
        // do not modify, write code in initVars and initialize class members there,
        // the constructor might be invoked too late due to race conditions that might occur
    }

    protected void initVars(Resources res) {

        if (Display.getInstance().isTablet()) {
            Toolbar.setPermanentSideMenu(true);
        }

    }

    @Override
    protected String getFirstFormName() {

        if (Display.getInstance().isSimulator()) {//Prepoluate with Debug info

            defaultEmail = "KD7788";
            defaultPassword = "fijiaudi";

            Log.setLevel(Log.DEBUG);
            Log.p("issimulator", Log.DEBUG);

            return "Login";

        } else {
            Log.setLevel(Log.REPORTING_PRODUCTION);//To disable debug information
            return "Splash";

        }

    }

    public Toolbar analytics(Form f, String screenName) {

        Toolbar toolbar = f.getToolbar();
        if (toolbar == null) {
            toolbar = new Toolbar();
            f.setToolbar(toolbar);
        }

        if (toolbar.getTitleComponent() instanceof Label) {

            Label title = (Label) toolbar.getTitleComponent();
            title.setUIID("LabelWhiteCenter");
            toolbar.setTitle(screenName);
            toolbar.setUIID("LabelWhiteCenter");
            title.setIcon(null);

        }

        return toolbar;
    }

    public void closeMenu(Form f, boolean isClose) {

        Toolbar tb = f.getToolbar();

        if (isClose) {
            tb.closeSideMenu();

        } else {
            tb.openSideMenu();

        }
    }

    public void fetchProfile(final Form f) {
        formProgress = new FormProgress(f);
        closeMenu(f, true);

    }

    public void uploadProfileImage(String title, Form f, String path, EncodedImage placeHolder, Label lblImage) {

        formProgress = new FormProgress(f);
        formProgress.removeProgress();

    }

    public void fetchTasks(Form f, String taskType) {
        formProgress = new FormProgress(f);
        closeMenu(f, true);

        Container contentPane = f.getContentPane();
        contentPane.removeAll();
        Container contTasks = (Container) createContainer("/theme", "ContTasks");

        f.add(contTasks);

        if (formProgress != null) {
            formProgress.removeProgress();
        }

    }

    public void fetchDashboard(final Form f) {
        formProgress = new FormProgress(f);
        closeMenu(f, true);

        analytics(f, "Dashboard");

        Container contentPane = f.getContentPane();
        contentPane.removeAll();
        Container cont = (Container) createContainer("/theme", "ContDashBoard");

        MultiButton mbTasks = (MultiButton) findByName("mbTasks", cont);

        mbTasks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                formProgress = new FormProgress(f);
                fetchTasks(f, Const.TASK_TODAY);
            }
        });

        MultiButton mbCurrency = (MultiButton) findByName("mbCurrency", cont);
        mbCurrency.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                formProgress = new FormProgress(f);
                fetchProjects(f);
            }
        });

        MultiButton mbCart = (MultiButton) findByName("mbCart", cont);
        mbCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                formProgress = new FormProgress(f);
                fetchCart(f);
            }
        });

        mbTasks.setTextLine1("Name Reservations");
        mbTasks.setTextLine2("One Name Reservation pending");

        mbCurrency.setTextLine1("Annual Returns");
        mbCurrency.setTextLine2("Three Annual Returns due");
        
        mbCart.setTextLine1("Shopping Cart");
        mbCart.setTextLine2("Pay Now for CIPC Services");

        f.add(cont);
        if (formProgress != null) {
            formProgress.removeProgress();
        }
        closeMenu(f, true);

    }

    public static SwipeableContainer createRankWidget(String line1, String line2, ActionListener action) {
        MultiButton button = new MultiButton(line1);
        button.addActionListener(action);
        button.setUIID("MultiButtonColor");
        button.setName("MultiButtonColor");
        button.setTextLine2(line2);
        SwipeableContainer s = new SwipeableContainer(null, createActionsProject(), button);

        return s;
    }

    private static Container createActionsProject() {
        Container flow = new Container(new FlowLayout());
        Button delete = new Button("Delete");
        delete.addActionListener(e -> ToastBar.showMessage("Not implemented yet", FontImage.MATERIAL_MESSAGE, 5000));
        flow.add(delete);
        return flow;
    }

    public void fetchProjects(final Form f) {
        formProgress = new FormProgress(f);
        closeMenu(f, true);
        analytics(f, "Annual Returns");
        current = f;
        Container contentPane = f.getContentPane();
        contentPane.removeAll();
        Container contProjects = (Container) createContainer("/theme", "ContProjects");

        Tabs tabs = (Tabs) findByName("Tabs", contProjects);
        tabs.setSwipeActivated(false);

        f.add(contProjects);
        if (formProgress != null) {
            formProgress.removeProgress();
        }

    }
    
        public void fetchCart(final Form f) {
        formProgress = new FormProgress(f);
        closeMenu(f, true);
        analytics(f, "Shopping Cart");
        current = f;
        Container contentPane = f.getContentPane();
        contentPane.removeAll();
        Container contProjects = (Container) createContainer("/theme", "ContCart");

        Tabs tabs = (Tabs) findByName("Tabs", contProjects);
        tabs.setSwipeActivated(false);

        f.add(contProjects);
        if (formProgress != null) {
            formProgress.removeProgress();
        }

    }

    protected DefaultRenderer buildCategoryRenderer(int[] colors) {
        Font smallFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.SIZE_SMALL, Font.STYLE_BOLD);
        Font medFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.SIZE_MEDIUM, Font.STYLE_BOLD);
        DefaultRenderer renderer = new DefaultRenderer();
        renderer.setLabelsTextSize(smallFont.getHeight() * 0.5f);
        renderer.setLegendTextSize(smallFont.getHeight() * 0.5f);
        renderer.setMargins(new int[]{medFont.getHeight(), medFont.getHeight(), medFont.getHeight(), medFont.getHeight()});
        for (int color : colors) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(color);
            renderer.addSeriesRenderer(r);
        }
        return renderer;
    }

    public void addBack(Form f, Form prev) {
        Toolbar toolbar = f.getToolbar();
        Command back = new Command("Back") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                super.actionPerformed(evt); //To change body of generated methods, choose Tools | Templates.
                prev.showBack();
            }

        };
        toolbar.setBackCommand(back);
    }

    public void changeFloatingButtonStyle(FloatingActionButton floatingButton) {

        floatingButton.getSelectedStyle().setBgColor(Const.FLOATING_BUTTON_PRESSED);
        floatingButton.getUnselectedStyle().setBgColor(Const.FLOATING_BUTTON);
        floatingButton.getPressedStyle().setBgColor(Const.FLOATING_BUTTON_PRESSED);

        floatingButton.getUnselectedStyle().setFgColor(Const.FLOATING_BUTTON_TEXT);
        floatingButton.getPressedStyle().setFgColor(Const.FLOATING_BUTTON_TEXT);
        floatingButton.getSelectedStyle().setFgColor(Const.FLOATING_BUTTON_TEXT);
        floatingButton.getStyle().setFgColor(Const.FLOATING_BUTTON_TEXT);

    }

    @Override
    protected void beforeMain(Form f) {

        Toolbar toolbar = analytics(f, "Home");

        current = f;

        fetchDashboard(f);

        Container contSideMenu = (Container) createContainer("/theme", "ContSideMenu");
        contSideMenu.setScrollableX(false);//This fixed the side menu scroll issue
        contSideMenu.setScrollableY(false);

        btnProfilePic = (Button) findByName("btnProfilePic", contSideMenu);
        btnProfileName = (Button) findByName("btnProfileName", contSideMenu);

        btnProfileName.setText("Update Profile");

        btnProfilePic.addActionListener((ActionListener) (ActionEvent evt) -> {
            fetchProfile(f);
        });

        btnProfileName.addActionListener((ActionListener) (ActionEvent evt) -> {
            fetchProfile(f);
        });

        Button btnDashboard = (Button) findByName("btnDashboard", contSideMenu);
        btnDashboard.addActionListener((ActionListener) (ActionEvent evt) -> {
            closeMenu(f, true);
            fetchDashboard(f);
            closeMenu(f, true);
        });

        Button btnLogout = (Button) findByName("btnLogout", contSideMenu);
        btnLogout.addActionListener((ActionListener) (ActionEvent evt) -> {
            showForm("Login", null);
        });

        Command command = new Command("Update Photo");
        command.putClientProperty("SideComponent", contSideMenu);

        f.getToolbar().addComponentToSideMenu(contSideMenu);

    }

    public String trimEmail(String email) {
        if (email != null) {
            email = email.toLowerCase().trim();
        }
        return email;
    }

    @Override
    protected boolean onLoginLogin() {

        Form f = Display.getInstance().getCurrent();

        Container c = (Container) findByName("containerParent", f);

        String txtCustomerCode = ((TextField) findByName("txtCustomerCode", c)).getText();
        final String password = ((TextField) findByName("txtPassword", c)).getText();

        za.co.cipc.pojos.User user = new za.co.cipc.pojos.User();
        user.setAgent_code(txtCustomerCode);
        user.setParamPassword(password);

        formProgress = new FormProgress(f);

        UserWebServices userWebServices = new UserWebServices();

        za.co.cipc.pojos.User responseUser = userWebServices.get_cust_MOBI(user);

        String errorMessage = "";

        if (responseUser == null) {
            formProgress.removeProgress();
            Log.p("exception" + "", Log.DEBUG);

            errorMessage += "Incorrect Customer Code or password. ";

        }

        String responsePassword = responseUser.getPassword();

        Log.p(password + ":" + responsePassword);

        if (password.equals(responsePassword)) {

            return false;
        } else {
            errorMessage += "Invalid Customer Code or Password. ";
        }

        formProgress.removeProgress();

        if (errorMessage != null && errorMessage.length() > 0) {
            showDialog(errorMessage);
            return true;//block
        } else {
            return false;
        }

    }
    
     public  void showDialog(String message) {
        ToastBar.Status status = ToastBar.getInstance().createStatus();
        status.setMessage(message);
        status.setExpires(5000);
        status.show();

    }

    private void automoveToNext(final TextField current, final TextField next) {
        current.addDataChangeListener(new DataChangedListener() {
            public void dataChanged(int type, int index) {
                if (current.getText().length() == 5) {
                    Display.getInstance().stopEditing(current);
                    String val = current.getText();
                    current.setText(val.substring(0, 4));
                    next.setText(val.substring(4));
                    Display.getInstance().editString(next, 5, current.getConstraint(), next.getText());
                }
            }
        });
    }

    public void addComment() {

        Container contContent = (Container) findByName("Comment", contCommunicationc);
        TextField txtComment = (TextField) findByName("txtTaskComment", contContent);

        String comment = txtComment.getText();

        int user_id = 2;
        int task_id = 1;

        String url = "http://localhost/TaskManagementApp/taskmanagementservices.php";
        ConnectionRequest cr = new ConnectionRequest(url);
        cr.addArgument("actionType", "communications");
        cr.addArgument("user_id", Integer.toString(user_id));
        cr.addArgument("task_id", Integer.toString(task_id));
        cr.addArgument("com_message", comment);
        cr.setPost(true);

        System.out.println("Print:" + comment);

        NetworkManager.getInstance().addToQueueAndWait(cr);
        if (cr.getResponseData() != null) {
            String data = new String(cr.getResponseData());
            Dialog.show("Ok", data, "Ok", null);

            Result result = Result.fromContent(data, Result.JSON);
            String status = result.getAsString("/status");
            String msg = result.getAsString("/msg");
            if (msg.startsWith("Comm")) {
                Dialog.show("Results", status, "Ok", null);
            }
        }
    }

    public void isTableInputForm(Form f) {
    }

    @Override
    protected void beforeLogin(final Form f) {

        current = f;

        if (Display.getInstance().isSimulator()) {
            TextField txtCustomerCode = (TextField) findByName("txtCustomerCode", f);
            txtCustomerCode.setText("KD7788");
            TextField txtPassword = (TextField) findByName("txtPassword", f);
            txtPassword.setText("fijiaudi");

        }

    }

    @Override
    protected void beforeRegistration(Form f) {

        Toolbar bar = analytics(f, "Registration");

        isTableInputForm(f);

        Tabs tabs = (Tabs) findByName("Tabs", f);
        tabs.setSwipeActivated(false);

        Picker pickerCountry = (Picker) findByName("pickerStep2Country", f);
        pickerCountry.setType(Display.PICKER_TYPE_STRINGS);
        pickerCountry.setStrings("Select Country", "Brazil", "South Africa", "Zimbabwe");

        Picker pickerProvince = (Picker) findByName("pickerStep3Province", f);
        pickerProvince.setType(Display.PICKER_TYPE_STRINGS);
        pickerProvince.setStrings("Select Province", "Gauteng", "Kwazulu Natal");

        Container contRadioButtons = (Container) findByName("contRadioButtons", f);

        RadioButton rdYes = (RadioButton) findByName("rdYes", contRadioButtons);
        RadioButton rdNo = (RadioButton) findByName("rdNo", contRadioButtons);

        ButtonGroup btButtonGroup = new ButtonGroup();

        btButtonGroup.add(rdYes);
        btButtonGroup.add(rdNo);

        Command back = new Command("Login") {

            @Override
            public void actionPerformed(ActionEvent evt) {
                super.actionPerformed(evt);
                current.showBack();
            }

        };
        bar.addCommandToLeftBar(back);
        bar.setBackCommand(back);

    }

    @Override
    protected void beforeForgotPassword(Form f) {
        Toolbar bar = analytics(f, "Forgot Login Details");

        isTableInputForm(f);

        Command back = new Command("Login") {

            @Override
            public void actionPerformed(ActionEvent evt) {
                super.actionPerformed(evt);
                current.showBack();
            }

        };
        bar.addCommandToLeftBar(back);
        bar.setBackCommand(back);
    }

    @Override
    protected void beforeSplash(Form f) {

    }

    @Override
    protected void postLogin(Form f) {

    }
}
