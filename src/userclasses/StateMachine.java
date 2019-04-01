package userclasses;

import com.codename1.capture.Capture;
import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.models.SeriesSelection;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.ext.codescan.CodeScanner;
import com.codename1.ext.codescan.ScanResult;
import com.codename1.ext.codescan.NativeCodeScanner;
import com.codename1.components.FloatingActionButton;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.MultiButton;
import com.codename1.components.OnOffSwitch;
import com.codename1.components.SpanButton;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.io.Storage;
import com.codename1.io.Util;
import com.codename1.io.services.TwitterRESTService;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.L10NManager;
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
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UITimer;
import com.codename1.ui.validation.Constraint;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.RegexConstraint;
import com.codename1.ui.validation.Validator;
import com.codename1.util.StringUtil;
import com.codename1.util.regex.RE;
import static com.codename1.ui.CN.*;
import com.codename1.ui.table.Table;

import com.sun.prism.paint.Color;
import java.io.ByteArrayInputStream;
//import com.pmovil.nativega.GANative;
//import com.pmovil.nativega.HitBuilders;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TimeZone;
//import java.util.function.Function;
import org.bouncycastle.crypto.InvalidCipherTextException;
import services.Utility;
import za.co.cipc.webservices.UserWebServices;
import ui.FormProgress;
import za.co.cipc.pojos.AnnualReturns;
import za.co.cipc.pojos.Dashboard;
import za.co.cipc.pojos.User;
import za.co.cipc.webservices.UserWebServicesNewReg;
//TESTING UPLOAD

/**
 *
 * @author Your name here
 */
public class StateMachine extends StateMachineBase {

    UserWebServicesNewReg uws = new UserWebServicesNewReg();
    final String PROCESSING = "Processing...";
    String PREVTEXT = "";

    final String KEY_FOR_T_AND_CS = "CIPC_T_AND_Cs";
    final String KEY_FOR_T_AND_CS_Accepted = "CIPC_T_AND_Cs_Accepted";

    static za.co.cipc.pojos.User responseUser;

    Container contSideMenu;
    Container contDashBoard;
    String ReferenceNumber;
    int j = 0;
    Map map;

    static int width;
    static int height;

    static boolean hasGonePastACS = false;
    static boolean isRegStep1Passed = false;
    static boolean isRegStep2Passed = false;
    static boolean isRegStep3Passed = false;

    static boolean isARStep1Passed = false;
    static boolean isARStep2Passed = false;
    static boolean isARStep3Passed = false;
    public static boolean DisplayCart = false;

    static String ENT_NUMBER;
    ArrayList annualReturnsEntDetails;

    ArrayList<EnterpriseDetails> listEnterpriseDetails;
    ArrayList<TextArea> listTextEnterpriseDetails;
    ArrayList<EnterpriseDetails> listCalculateARTran;
    ArrayList<BEEDetail> listBEEDetail;
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

    private static String AGENT_CODE = "";
    private Container contStep3Turnovers;

    EnterpriseDetails enterpriseDetails;
    ArrayList<NameSearchObject> arrayListNameReservation;

    public boolean isEmailValid(String text) {
        //String expression = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        String expression = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        //String expression = "^(?(\"\")(\"\"[^\"\"]+?\"\"@)|(([0-9a-z]((\\.(?!\\.))|[-!#\\$%&'\\*\\+/=\\?\\^`\\{\\}\\|~\\w])*)(?<=[0-9a-z])@))(?(\\[)(\\[(\\d{1,3}\\.){3}\\d{1,3}\\])|(([0-9a-z][-\\w]*[0-9a-z]*\\.)+[a-z0-9]{2,17}))$";
        //String expression = "/^([\\w-]+(?:.[\\w-]+))@((?:[\\w-]+.)\\w[\\w-]{0,66}).([a-z]{2,10}(?:.[a-z]{2})?)$/i";        

        int indexOfDot = text.indexOf(".");
        int indexOfAt = text.indexOf("@");
        if (indexOfDot == (indexOfAt - 1)) {// .@ scenario
            return false;
        }

        int countDots = 0;

        for (int i = indexOfAt; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '.') {
                countDots++;
            }
        }

        if (countDots == 1) {
            return true;// 
        }

        RE r = new RE(expression); // Create new pattern 
        if (r.match(text)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isUrlValid(String text) {
        String expression = "^(?:http(s)?:\\/\\/)?[\\w.-]+(?:\\.[\\w\\.-]+)+[\\w\\-\\._~:/?#[\\]@!\\$&'\\(\\)\\*\\+,;=.]+$";

        RE r = new RE(expression); // Create new pattern 
        if (r.match(text)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isCellPhoneValid(String text) {
        String expression = "^((?:\\+27|27)|0)(=72|82|73|83|74|84|81|78|79|71|72|61|60|62|63|64|65|66|67|68|69|72|61|76)(\\d{7})$";

        RE r = new RE(expression); // Create new pattern 
        if (r.match(text)) {
            return true;
        } else {
            return false;
        }
    }

    public StateMachine(String resFile) {
        super(resFile);
        // do not modify, write code in initVars and initialize class members there,
        // the constructor might be invoked too late due to race conditions that might occur
    }

    protected void initVars(Resources res) {
        Display.getInstance().setProperty("l10n.currency", "ZAR");//force only rand currency when using Localisation Manager. Don't remove this!

//        String d = "1976-06-16T00:00:00+02:00";
//        d = StringUtil.replaceAll(d, "T", "_");
//        d = d.substring(0, 19);
//        
//        SimpleDateFormat dateString = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
//        Date dateObject = dateString.parse(d);
        Button.setCapsTextDefault(false);

        Display.getInstance().setProperty("WebLoadingHidden", "true");

        NetworkManager.getInstance().setTimeout(30000);

        Display.getInstance().addEdtErrorHandler(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                evt.consume();
                if (Display.getInstance().isSimulator()) {
                    Log.p("Environment is Simulator");
                } else {
                    Log.p("Environment is Device");
                }
                Log.p("User " + AGENT_CODE);
                Log.p("Exception in AppName version " + Display.getInstance().getProperty("AppVersion", "Unknown"));
                Log.p("OS " + Display.getInstance().getPlatformName());
                Log.p("Error " + evt.getSource());
                Log.p("Current Form " + Display.getInstance().getCurrent().getName());
                Log.e((Throwable) evt.getSource());
                if (!Display.getInstance().isSimulator()) {
                    Log.sendLog();
                }
            }
        });

        if (Display.getInstance().isSimulator()) {

            AGENT_CODE = "INKE01";

            Log.p("isCellPhoneValid=" + isCellPhoneValid("0827786881"), Log.DEBUG);
            Log.p("isEmailValid=" + isEmailValid("blessing@mfactory.mobi"), Log.DEBUG);
            Log.p("isUrlValid=" + isUrlValid("www.mfactory.mobi"), Log.DEBUG);

            Log.p("isEmailValid blessing.@mfactory.mobi=" + isEmailValid("blessing.@mfactory.mobi"), Log.DEBUG);
            Log.p("isEmailValid blessing@mfactory.africa=" + isEmailValid("blessing@mfactory.africa"), Log.DEBUG);
            Log.p("isEmailValid blessing.mahlala@cipc.co.za=" + isEmailValid("blessing.mahlala@cipc.co.za"), Log.DEBUG);

            //Log.p("dateString = " + dateString, Log.DEBUG);
            //Test Name Service
            //Log.p("table=" + table, Log.DEBUG);
//  
//            NameReservation n = u.Namereservation_MOBI(AGENT_CODE, randomName, "", "", "");
//            Log.p("randomName=" + randomName, Log.DEBUG);
//            User user = new User();
//            user.setAgent_code(n.getCustomerCode());
//            u.insertCartItemService(n);
            //ReferenceNumber
            //StatusDate
            //CustomerCode
            //Amount
            //TotalAmount
//            String entNo = getShortEnterpriseName("2011", "100088", "07");
//            System.out.println("enta=" + entNo);
//            AGENT_CODE = "NEWLNE";
            //     UserWebServices u = new UserWebServices();
            //u.update_terms("http://139.162.223.194:8080/CIPC2/TermsandConditions_version_Final_3.0.pdf");
            //u.get_terms(null);
//            boolean isPending = u.pendingAnnualReturns(user, entNo);
//            Log.p("isPending=" + isPending, Log.DEBUG);
//            Map mapCart = u.getCart(user);
//
//            ArrayList items = (ArrayList) mapCart.get("AnnualReturns");
//            Log.p("Annual Returns=" + items.size(), Log.DEBUG);
//
//            ArrayList CartItems = (ArrayList) mapCart.get("CartItems");
//            Log.p("CartItems=" + CartItems.size(), Log.DEBUG);
//            mapCart = u.getCart(user);
//            items = (ArrayList) mapCart.get("CartItems");//ItemData
//            Log.p("CartItems Size after insert=" + items.size(), Log.DEBUG);
//
//            ArrayList CartItems = (ArrayList) mapCart.get("CartItems");
//            Map mapCartItem = (Map) CartItems.get(0);
//            String ReferenceNumber = mapCartItem.get("ReferenceNumber").toString();
//            int Status = 2;//delete
//            String StatusDate = mapCartItem.get("StatusDate").toString();
//            String CustomerCode = mapCart.get("CustomerCode").toString();
//            String ItemType = mapCart.get("ItemType").toString();//4 Name Reservation
//
//            //How many items???
//                              //  + "\"Item   Data\":\"{\\\"ReferenceNumber\\\":9118779575,\\\"EnterpriseNumber\\\":\\\"\\\",\\\"FormCode\\\":\\\"CoR9.1\\\",\\\"ChangeTypeCode\\\":\\\"30\\\",\\\"Description\\\":null,\\\"TotalAmount\\\":50.0}\","
//
//
//
//            double TotalAmount = Double.parseDouble(mapCart.get("TotalAmount").toString());
//
//            String BODY
//                    = "{\"ReferenceNumber\":8118779575,"
//                    + "\"Status\":2,"
//                    + "\"StatusDate\":\"2018-04-23T13:04:28.873\","
//                    + "\"CustomerCode\":\"" + user.getAgent_code() + "\","
//                    + "\"ItemType\":4,"
//                    + "\"Item   Data\":\"{\\\"ReferenceNumber\\\":9118779575,\\\"EnterpriseNumber\\\":\\\"\\\",\\\"FormCode\\\":\\\"CoR9.1\\\",\\\"ChangeTypeCode\\\":\\\"30\\\",\\\"Description\\\":null,\\\"TotalAmount\\\":50.0}\","
//                    + "\"Amount\":50.0"
//                    + "}";
//
////
//            User tmpUser = new User();
//            tmpUser.setAgent_code("NEWLNE");
//            UserWebServices uw = new UserWebServices();
//            //uw.get_cust_MOBI_2(tmpUser);
//            
//            uw.update_app_version("0.31");
//            uw.get_app_version(tmpUser);
//
//            //step2
//            tmpUser.setFirst_name("Blessing");
//            tmpUser.setLast_name("Mahlalela");
//            tmpUser.setCell_no("07635908094");
//            tmpUser.setEmail("blessing@mfactory.mobi");
//            tmpUser.setTel_code("");
//            tmpUser.setTel_no("");
//            tmpUser.setFax_code("");
//            tmpUser.setFax_no("");
//
//            //step 3
//            tmpUser.setPhys_addr1("Hotel Street");//Street
//            tmpUser.setPhys_addr2("Pretoria");//City
//            tmpUser.setPhys_addr3("Gauteng");//Province
//            tmpUser.setPost_code("0001");
//
//            //step 4
//            tmpUser.setPassword("Password01");
//
//            //u.get_countries(tmpUser);
//            String response = u.ReceiveNewCustData_Reg_MOBI(tmpUser);
//            Log.p("response =" + response);
            //Step 2: if not exist. create user.
            //tmpUser.setAgent_id_no("7104085085085");
            //u.ReceiveNewCustData_Reg_MOBI(tmpUser);
            //Step 3 forgot password
            //u.forget_password_MOBI(null);
        }

    }

    @Override
    protected String getFirstFormName() {

        if (Display.getInstance().isSimulator()) {//Pre populate with Debug info

            defaultEmail = "NEWLNE";
            defaultPassword = "";
            //defaultEmail = "SARBIA";
            //defaultPassword = "barend";

            Log.setLevel(Log.DEBUG);
            Log.p("issimulator", Log.DEBUG);

            //return "testlist";
            //return "BEE";
            return "Splash";

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

    public void showProfile(final Form f) {
        hideLogout();
        formProgress = new FormProgress(f);
        closeMenu(f, true);

    }

    static Command logout = null;

    public void uploadProfileImage(String title, Form f, String path, EncodedImage placeHolder, Label lblImage) {

        formProgress = new FormProgress(f);
        formProgress.removeProgress();

    }

    public void hideLogout() {
        if (logout != null) {
            logout.setCommandName("");
            logout.setEnabled(false);

        }
    }

    public void showLogout() {
        if (logout != null) {
            logout.setCommandName("Logout");
            logout.setEnabled(true);
        }
    }

    public void showNameReservation(Form f, String taskType) {

        hideLogout();

        if (arrayListNameReservation != null) {
            arrayListNameReservation.clear();
        }

        formProgress = new FormProgress(f);
        closeMenu(f, true);
        Toolbar bar = analytics(f, "Proposed Name Reservation");
        Toolbar.setEnableSideMenuSwipe(false);

        f.removeAllCommands();
        f.revalidate();

        Command back = new Command("") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                super.actionPerformed(evt); //To change body of generated methods, choose Tools | Templates.
                Log.p("Name Reservation back", Log.DEBUG);
                showDashboard(f);
            }

        };

        bar.setBackCommand(back);

        Container contentPane = f.getContentPane();
        contentPane.removeAll();
        Container contTasks = (Container) createContainer("/theme", "ContTasks");
        f.setScrollableX(false);
        f.setScrollableX(false);
        contentPane.setScrollableX(false);
        contentPane.setScrollableX(false);
        contTasks.setScrollableX(false);
        contTasks.setScrollableX(false);
        contTasks.setName("NameReservation");

        if (orientationListener != null) {
            f.removeOrientationListener(orientationListener);
        }

        orientationListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                updateLayoutRegistration(f, contTasks);
            }
        };

        f.addOrientationListener(orientationListener);

        updateLayoutRegistration(f, contTasks);

        Label lblLine1 = (Label) findByName("lblLine1", contTasks);

        TextField txtName1 = (TextField) findByName("txtName1", contTasks);
        TextField txtName2 = (TextField) findByName("txtName2", contTasks);
        TextField txtName3 = (TextField) findByName("txtName3", contTasks);
        TextField txtName4 = (TextField) findByName("txtName4", contTasks);

        Label lblName1Response = (Label) findByName("lblResponse1", contTasks);
        Label lblName2Response = (Label) findByName("lblResponse2", contTasks);
        Label lblName3Response = (Label) findByName("lblResponse3", contTasks);
        Label lblName4Response = (Label) findByName("lblResponse4", contTasks);

        Button btnVerify = (Button) findByName("btnVerify", contTasks);
        Button btnLodge = (Button) findByName("btnLodge", contTasks);
        btnLodge.setUIID("ButtonNameSearchDisabled");
        btnLodge.repaint();

        if (Display.getInstance().isSimulator()) {
            txtName1.setText(getRandomString(10));
            //txtName1.setText("Croatia");
            //txtName2.setText(getRandomString(10));
        }

        btnVerify.addActionListener((ActionListener) (ActionEvent evt) -> {

            PREVTEXT = btnVerify.getText();
            btnVerify.setEnabled(false);
            btnVerify.setText(PROCESSING);

            lblName1Response.setText("");
            lblName2Response.setText("");
            lblName3Response.setText("");
            lblName4Response.setText("");

            lblName1Response.repaint();
            lblName2Response.repaint();
            lblName3Response.repaint();
            lblName4Response.repaint();

            String name1 = txtName1.getText();
            String name2 = txtName2.getText();
            String name3 = txtName3.getText();
            String name4 = txtName4.getText();

            String msg = "";

            if (name1.length() == 0) {
                msg += "Please complete Name 1. ";
            }

            if (isAlphaNumeric(name1) == false
                    || isAlphaNumeric(name2) == false
                    || isAlphaNumeric(name3) == false || isAlphaNumeric(name4) == false) {
                msg += "Names may only contain alphabetical letters and numbers. ";
            }

            if (msg.length() > 0) {
                btnVerify.setEnabled(true);
                btnVerify.setText(PREVTEXT);
                Dialog.show("Error", msg, "Ok", null);
            } else {

                UserWebServices u = new UserWebServices();
                arrayListNameReservation = u.search_name_MOBI(AGENT_CODE, name1, name2, name3, name4);
                Log.p("arrayListNameReservation size: " + arrayListNameReservation.size(), Log.DEBUG);

                if (arrayListNameReservation.size() == 0) {
                    btnVerify.setEnabled(true);
                    btnVerify.setText(PREVTEXT);
                    Dialog.show("Error", "Error occurred while processing your request. Please contact CIPC.", "Ok", null);
                }

                String currentName = "";

                //Dialog.show("0", "aa", "Ok", null);
                for (int i = 0; i < arrayListNameReservation.size(); i++) {
                    NameSearchObject n = arrayListNameReservation.get(i);
                    //Dialog.show("1.1", n.getName(), "Ok", null);
                    String txt = n.getName();
                    String name = "";
                    if (txt.indexOf("|") > -1) {
                        java.util.List<String> list = StringUtil.tokenize(n.getName(), "|");
                        if (list != null && list.size() > 0) {
                            txt = list.get(0);
                        }
                        name = txt;
                    } else {
                        name = n.getName();
                    }
                    //Log.p("name=" + n.getName() + "after name=" + name, Log.DEBUG);

                    // Dialog.show("1.2", name, "Ok", null);
                    //Dialog.show("1.3", "name="+name + " name1" + name1, "Ok", null);
                    Label lblResponse = null;

                    name = name.toLowerCase();
                    name1 = name1.toLowerCase();
                    name2 = name2.toLowerCase();
                    name3 = name3.toLowerCase();
                    name4 = name4.toLowerCase();

                    if (name1.equals(name)) {
                        //Dialog.show("1.6", "name1=" + name1, "Ok", null);
                        //lblResponse = (Label) findByName("lblResponse1", contTasks);

                        if (n.isIsValid()) {
                            //Dialog.show("1.7", "name1=" + name1, "Ok", null);

                            btnLodge.setUIID("ButtonNameSearch");
                            btnLodge.repaint();
                            lblName1Response.setText("Might be available");
                            lblName1Response.setUIID("LabelGreen");
                            lblName1Response.getComponentForm().revalidate();

                        } else if (n.isIsValid() == false) {
                            //Dialog.show("1.8", "name1=" + name1, "Ok", null);

                            lblName1Response.setText("Is not available");
                            lblName1Response.setUIID("LabelRed");
                            lblName1Response.getComponentForm().revalidate();

                        }

                    }
                    if (name2.equals(name)) {
                        if (n.isIsValid()) {
                            //Dialog.show("1.7", "name1=" + name1, "Ok", null);

                            btnLodge.setUIID("ButtonNameSearch");
                            btnLodge.repaint();
                            lblName2Response.setText("Might be available");
                            lblName2Response.setUIID("LabelGreen");
                            lblName2Response.getComponentForm().revalidate();

                        } else if (n.isIsValid() == false) {
                            //Dialog.show("1.8", "name1=" + name1, "Ok", null);

                            lblName2Response.setText("Is not available");
                            lblName2Response.setUIID("LabelRed");
                            lblName2Response.getComponentForm().revalidate();

                        }
                    }
                    if (name3.equals(name)) {
                        if (n.isIsValid()) {
                            //Dialog.show("1.7", "name1=" + name1, "Ok", null);

                            btnLodge.setUIID("ButtonNameSearch");
                            btnLodge.repaint();
                            lblName3Response.setText("Might be available");
                            lblName3Response.setUIID("LabelGreen");
                            lblName3Response.getComponentForm().revalidate();

                        } else if (n.isIsValid() == false) {
                            //Dialog.show("1.8", "name1=" + name1, "Ok", null);

                            lblName3Response.setText("Is not available");
                            lblName3Response.setUIID("LabelRed");
                            lblName3Response.getComponentForm().revalidate();

                        }
                    }
                    if (name4.equals(name)) {
                        if (n.isIsValid()) {
                            //Dialog.show("1.7", "name1=" + name1, "Ok", null);

                            btnLodge.setUIID("ButtonNameSearch");
                            btnLodge.repaint();
                            lblName4Response.setText("Might be available");
                            lblName4Response.setUIID("LabelGreen");
                            lblName4Response.getComponentForm().revalidate();

                        } else if (n.isIsValid() == false) {
                            //Dialog.show("1.8", "name1=" + name1, "Ok", null);

                            lblName4Response.setText("Is not available");
                            lblName4Response.setUIID("LabelRed");
                            lblName4Response.getComponentForm().revalidate();

                        }
                    }

                    Log.p("lblResponse=" + lblResponse, Log.DEBUG);
                    //Dialog.show("2", "lblResponse=" + lblResponse, "Ok", null);

//                    if (lblResponse != null) {
//                        Container parent = lblResponse.getParent();
//                        Dialog.show("Updated", "Refresh=" + lblResponse.getText(), "Ok", null);
//                    } else {
//                        Dialog.show("Not Updated", "Refresh=" + lblResponse.getText(), "Ok", null);
//
//                    }
                    // Dialog.show("3", "lblResponse=" + lblResponse, "Ok", null);
                }

                // btnVerify.getComponentForm().revalidate();
//                for (int i = 0; i < arrayListNameReservation.size(); i++) {
//                    int count = i + 1;
//                    Label lblResponse = (Label) findByName("lblName" + count + "Response", contTasks);
//                    Container parent = lblResponse.getParent();
//                    NameSearchObject n = arrayListNameReservation.get(i);
//                    Log.p("name=" + n.getName(), Log.DEBUG);
//                    
//                    if (n.isIsValid()) {
//                        btnLodge.setUIID("ButtonNameSearch");
//                        btnLodge.repaint();
//                        lblResponse.setText("Might be available");
//                        lblResponse.setUIID("LabelGreen");
//                    } else {
//                        lblResponse.setText("Is not available");
//                        lblResponse.setUIID("LabelRed");
//
//                    }
//
//                }
                // contTasks.revalidate();
                lblLine1.scrollRectToVisible(0, 0, 0, 0, lblLine1);
                f.revalidate();

            }

            btnVerify.setEnabled(true);
            btnVerify.setText(PREVTEXT);
        });

        btnLodge.addActionListener((ActionListener) (ActionEvent evt) -> {

            PREVTEXT = btnLodge.getText();
            btnLodge.setEnabled(false);
            btnLodge.setText(PROCESSING);

            formProgress = new FormProgress(f);

            String name1 = txtName1.getText();
            String name2 = txtName2.getText();
            String name3 = txtName3.getText();
            String name4 = txtName4.getText();

            String msg = "";

            if (arrayListNameReservation == null || arrayListNameReservation.size() == 0) {

                msg += "Please validate Names before clicking on Add to Cart and ensure you have at least one name that might be available. ";
                btnLodge.setEnabled(true);
                btnLodge.setText(PREVTEXT);
            } else {

                boolean atleastOneNameAvailable = false;

                for (int i = 0; i < arrayListNameReservation.size(); i++) {
                    NameSearchObject n = arrayListNameReservation.get(i);
                    if (n.isIsValid()) {
                        atleastOneNameAvailable = true;
                    }
                }

                if (atleastOneNameAvailable == false) {
                    msg += "Please validate Names before clicking on Add to Cart and ensure you have at least one name that might be available. ";
                }
            }

            if (name1.length() == 0) {
                msg += "Please complete Name 1. ";
            }

            if (isAlphaNumeric(name1) == false
                    || isAlphaNumeric(name2) == false
                    || isAlphaNumeric(name3) == false || isAlphaNumeric(name4) == false) {
                msg += "Names may only contain alphabetical letters and numbers. ";
            }

            if (msg.length() > 0) {
                if (formProgress != null) {
                    formProgress.removeProgress();
                }
                btnLodge.setText(PREVTEXT);
                btnLodge.setVisible(true);
                Dialog.show("Error", msg, "Ok", null);
            } else {
                UserWebServices u = new UserWebServices();

                NameReservation responseCall = u.Namereservation_MOBI2(AGENT_CODE, name1, name2, name3, name4);

                Log.p("responseCall = " + responseCall, Log.DEBUG);

                if (responseCall != null
                        && responseCall.getResponseMessage() != null
                        && responseCall.getResponseMessage().indexOf("Error 500") > -1) {
                    if (formProgress != null) {
                        formProgress.removeProgress();
                    }
                    btnLodge.setText(PREVTEXT);
                    btnLodge.setVisible(true);
                    Dialog.show("Error", responseCall.getResponseMessage(), "Ok", null);//TODO scroll to top
                } else if (responseCall != null && responseCall.getResponseMessage() != null
                        && responseCall.getResponseMessage().indexOf("already filed") == -1) {

                    int indexStart = responseCall.getResponseMessage().indexOf("Reference No: ") + 14;
                    int indexEnd = responseCall.getResponseMessage().indexOf(". First proposed");

                    String ref = responseCall.getResponseMessage().substring(indexStart, indexEnd);

                    if (formProgress != null) {
                        formProgress.removeProgress();
                    }
                    Dialog.show("Success", "Dear Customer, Name Reservation Lodged successfully. Tracking Number: " + ref + ".", "Ok", null);

                    formProgress = new FormProgress(f);
                    //Dialog.show("Success", responseCall.getResponseMessage(), "Ok", null); do not remove
                    Log.p("Name reservation responseCall=" + responseCall, Log.DEBUG);

                    User tempUser = new User();
                    tempUser.setAgent_code(AGENT_CODE);
                    //getReferenceNo
                    //NameReservation n = getNameReservationReferenceNo(responseCall);

                    // Dialog.show("Output 5 referenceNo", "AGENT_CODE=" + AGENT_CODE + " referenceNo="
                    //       + referenceNo, "Ok", null);
                    u.insertCartItemService(responseCall);

                    showCart2(f);
                } else if (responseCall != null && responseCall.getResponseMessage() != null
                        && responseCall.getResponseMessage().indexOf("already filed") != -1) {
                    btnLodge.setText(PREVTEXT);
                    btnLodge.setVisible(true);
                    Dialog.show("Error", responseCall.getResponseMessage(), "Ok", null);//TODO scroll to top
                } else {
                    btnLodge.setText(PREVTEXT);
                    btnLodge.setVisible(true);
                    Dialog.show("Error", "Error occurred while processing your request. Please try again later or contact CIPC.", "Ok", null);
                }
            }

            btnLodge.setText(PREVTEXT);
            btnLodge.setVisible(true);

        });

        if (!Display.getInstance().isTablet()) {
            f.add(BorderLayout.CENTER, contTasks);
        }

        if (formProgress != null) {
            formProgress.removeProgress();
        }

    }
    ActionListener orientationListener = null;

    static boolean isFromDash = false;

    public void showDashboard(final Form f) {

        if (DisplayCart == true) {
            showCart2(f);
            DisplayCart = false;
            return;
        }
        f.removeAllCommands();
//contDashBoard = (Container) findByName("ContDashBoard", f);
        Command back = new Command("") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                super.actionPerformed(evt); //To change body of generated methods, choose Tools | Templates.
                Log.p("back", Log.DEBUG);
                Display.getInstance().minimizeApplication();
            }

        };

        f.setBackCommand(back);
        //formProgress = new FormProgress(f);
        closeMenu(f, true);

        f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));

        Toolbar tb = analytics(f, "Dashboard");

//        if(logout == null){
//            Log.p("logout == null", Log.DEBUG);
//            logout = new Command("Logout") {
//                @Override
//                public void actionPerformed(ActionEvent evt) {
//                    super.actionPerformed(evt); //To change body of generated methods, choose Tools | Templates.
//                    Log.p("logout actionPerformed", Log.DEBUG);
//                    showLogin(null);
//                }
//
//            };
//            tb.addCommandToRightBar(logout);
//        }
//        else if(logout != null){
//             showLogout();
        logout = new Command("Logout") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                super.actionPerformed(evt); //To change body of generated methods, choose Tools | Templates.
                Log.p("logout actionPerformed", Log.DEBUG);
                showLogin(null);
            }

        };
        tb.addCommandToRightBar(logout);
//        }

        Toolbar.setEnableSideMenuSwipe(true);
        addSideMenu(f, tb);

        Container contentPane = f.getContentPane();
        contentPane.removeAll();
        Container cont = (Container) createContainer("/theme", "ContDashBoard");
        Container dashContent = (Container) findByName("DashContent", cont);

        String currentAppVersion = Display.getInstance().getProperty("AppVersion", "Unknown");

        Label lblVersion = (Label) findByName("appVersion", cont);
        lblVersion.setText("v" + currentAppVersion);
        lblVersion.repaint();

        if (orientationListener != null) {
            f.removeOrientationListener(orientationListener);
        }

        orientationListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                updateLayoutRegistration(f, cont);
            }
        };

        f.addOrientationListener(orientationListener);

        updateLayoutRegistration(f, cont);

        Style labelForm = UIManager.getInstance().getComponentStyle("LabelWhite");
        labelForm.setMargin(0, 0, 0, 0);
        labelForm.setPadding(0, 0, 0, 0);
        int sizeLabel = 6;

        Label lblIcon1 = (Label) findByName("lblIcon1", cont);
        Label lblIcon2 = (Label) findByName("lblIcon2", cont);
        Label lblIcon3 = (Label) findByName("lblIcon3", cont);
        Label lblIcon4 = (Label) findByName("lblIcon4", cont);
        Label lblIcon5 = (Label) findByName("lblIcon5", cont);
        Label lblIcon6 = (Label) findByName("lblIcon6", cont);
        //Label lblIcon4 = (Label) findByName("lblIcon4", cont);
        //  hsz;
        Image img1 = FontImage.createMaterial(FontImage.MATERIAL_STORE, labelForm, sizeLabel);
        Image img2 = FontImage.createMaterial(FontImage.MATERIAL_CREDIT_CARD, labelForm, sizeLabel);
        Image img3 = FontImage.createMaterial(FontImage.MATERIAL_SHOPPING_CART, labelForm, sizeLabel);
        Image img4 = FontImage.createMaterial(FontImage.MATERIAL_BUSINESS, labelForm, sizeLabel);
        Image img5 = FontImage.createMaterial(FontImage.MATERIAL_DEVELOPER_BOARD, labelForm, sizeLabel);
        Image img6 = FontImage.createMaterial(FontImage.MATERIAL_DESCRIPTION, labelForm, sizeLabel);
        lblIcon1.setIcon(img1);
        lblIcon2.setIcon(img2);
        lblIcon3.setIcon(img3);
        lblIcon4.setIcon(img4);
        lblIcon5.setIcon(img5);
        lblIcon6.setIcon(img6);

        //lblIcon4.setIcon(img1);
        Button mbNameReservations = (Button) findByName("mbTasks", cont);
        mbNameReservations.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                mbNameReservations.setEnabled(false);

                //formProgress = new FormProgress(f);
                showNameReservation(f, Const.TASK_TODAY);
                mbNameReservations.setEnabled(true);
            }
        });

        Button mbAnnualReturns = (Button) findByName("mbCurrency", cont);
        mbAnnualReturns.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                mbAnnualReturns.setEnabled(false);
                //formProgress = new FormProgress(f);
                showAnnualReturns(f);
                mbAnnualReturns.setEnabled(true);
            }
        });

        Button mbCardPayments = (Button) findByName("mbButton", cont);
        mbCardPayments.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                mbCardPayments.setEnabled(false);
                isFromDash = true;
                Log.p("mbCardPayments start", Log.DEBUG);
                showCart2(f);
                Log.p("mbCardPayments end", Log.DEBUG);
                mbCardPayments.setEnabled(true);
            }
        });
//hsz;

        Button mbReg = (Button) findByName("mbRegistration", cont);
        mbReg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                mbReg.setEnabled(false);
                showForm("frmNewEntReg1", null);
                mbReg.setEnabled(true);
            }
        });
        Button mbBEE = (Button) findByName("mbBEE", cont);

        mbBEE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                mbBEE.setEnabled(false);
                showForm("BEE", null);
                mbBEE.setEnabled(true);
            }
        });
        Button mbDisclosure = (Button) findByName("mbDisclosure", cont);

        mbDisclosure.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                mbDisclosure.setEnabled(false);
                showForm("Disclosure", null);
                mbDisclosure.setEnabled(true);
            }
        });
        UserWebServices u = new UserWebServices();
        Hashtable<String, Dashboard> table = u.get_mobi_permissions(AGENT_CODE);

        if (table == null || table.size() == 0) {
            cont.setUIID("Container");
            cont.repaint();
            Dialog.show("Error", "An Error Occured while fetching CIPC Dashboard information.", "Ok", null);
            //cont.remove();
            //f.reva
        } else {
            // String[] names = {"AR", "NR", "CP"};
            String[] names = {"AR", "NR", "CP", "CR", "BE", "DC"};

            for (int i = 0; i < names.length; i++) {
                String key = names[i];

                Dashboard d = table.get(key);
                //key = key.toLowerCase();
                if (d != null) {
                    //hsz;
                    Container dynamicCont = (Container) findByName(key, cont);
                    Log.p("dynamicCont=" + dynamicCont, Log.DEBUG);
                    Log.p("key=" + key + " visbile=" + d.getB_visible(), Log.DEBUG);
                    if (d.getB_visible() != null && d.getB_visible().indexOf("true") > -1) {
                        dynamicCont.setVisible(true);
                    } else {
                        dynamicCont.remove();
                    }
                } else {
                    Container dynamicCont = (Container) findByName(key, cont);
                    dynamicCont.remove();
                }
            }

            if (dashContent.getComponentCount() == 0) {
                cont.setUIID("Container");
                cont.repaint();
                Dialog.show("Notice", "Your Customer Code is not linked to any services available on the mobile app", "Ok", null);
            }

        }

        if (!Display.getInstance().isTablet()) {
            f.setLayout(new BorderLayout());
            Container north = new Container(BoxLayout.y());
            if (Display.getInstance().getPlatformName().equals("and")) {
                north.add(" ").add(" ").add(" ");
            } else {
                north.add(" ");
            }

            f.add(BorderLayout.NORTH, north);
            f.add(BorderLayout.CENTER, cont);

        }
        if (formProgress != null) {
            formProgress.removeProgress();
        }
        f.revalidate();
        closeMenu(f, true);
//contDashBoard = (Container) findByName("ContDashBoard", f);
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

    //validate ar
    static String ar2EmailAddress;
    static String ar2TelCode;
    static String ar2TelNumber;
    static String ar2CellNumber;
    static String ar2WebAddress;
    static String ar2BusinessDescription;
    static String ar2PlaceOfBusiness;

    public void showAnnualReturns(final Form f) {

        Style labelForm = UIManager.getInstance().getComponentStyle("CIPC_DARK");
        labelForm.setMargin(0, 0, 0, 0);
        labelForm.setPadding(0, 0, 0, 0);
        int sizeLabel = 6;

        Image img1 = FontImage.createMaterial(FontImage.MATERIAL_PERSON, labelForm, sizeLabel);
        Image img2 = FontImage.createMaterial(FontImage.MATERIAL_BUSINESS, labelForm, sizeLabel);
        Image img3 = FontImage.createMaterial(FontImage.MATERIAL_PAYMENT, labelForm, sizeLabel);
        Image img4 = FontImage.createMaterial(FontImage.MATERIAL_INFO, labelForm, sizeLabel);

        Button btn1 = new Button("");
        Button btn2 = new Button("");
        Button btn3 = new Button("");
        Button btn4 = new Button("");

        btn1.setUIID("CIPC_DARK_SELECTED");
        btn2.setUIID("CIPC_DARK");
        btn3.setUIID("CIPC_DARK");
        btn4.setUIID("CIPC_DARK");

        btn1.setIcon(img1);
        btn2.setIcon(img2);
        btn3.setIcon(img3);
        btn4.setIcon(img4);

        hideLogout();

        isARStep1Passed = false;
        isARStep2Passed = false;
        isARStep3Passed = false;

        //f.setLayout(new BorderLayout());
        UserWebServices u = new UserWebServices();
        final ArrayList list = u.Get_AR_ent_type_mobi(null);

        formProgress = new FormProgress(f);
        closeMenu(f, true);
        Toolbar toolBar = analytics(f, "Annual Returns");

        Toolbar.setEnableSideMenuSwipe(false);
        current = f;
        Container contentPane = f.getContentPane();
        contentPane.removeAll();
        Container contProjects = (Container) createContainer("/theme", "ContProjects");

        Container contStep2 = (Container) findByName("contStep2", contProjects);

        Tabs tabs = (Tabs) findByName("Tabs", contProjects);
        tabs.setSwipeActivated(false);
        tabs.hideTabs();

        Command back = new Command("") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                super.actionPerformed(evt); //To change body of generated methods, choose Tools | Templates.
                Log.p("AR back", Log.DEBUG);

                if (isARStep1Passed == false && isARStep2Passed == false
                        && isARStep3Passed == false) {//Step 1
                    showDashboard(f);
                } else if (isARStep1Passed == true && isARStep2Passed == false
                        && isARStep3Passed == false) {//Step 2
                    tabs.setSelectedIndex(0);
                    btn1.setUIID("CIPC_DARK_SELECTED");
                    btn2.setUIID("CIPC_DARK");
                    btn3.setUIID("CIPC_DARK");
                    btn4.setUIID("CIPC_DARK");
                    isARStep1Passed = false;
                } else if (isARStep1Passed == true && isARStep2Passed == true
                        && isARStep3Passed == false) {//Step 3
                    tabs.setSelectedIndex(1);
                    btn1.setUIID("CIPC_DARK");
                    btn2.setUIID("CIPC_DARK_SELECTED");
                    btn3.setUIID("CIPC_DARK");
                    btn4.setUIID("CIPC_DARK");
                    isARStep2Passed = false;
                } else if (isARStep1Passed == true && isARStep2Passed == true
                        && isARStep3Passed == true) {//Step 4
                    tabs.setSelectedIndex(2);
                    btn1.setUIID("CIPC_DARK");
                    btn2.setUIID("CIPC_DARK");
                    btn3.setUIID("CIPC_DARK_SELECTED");
                    btn4.setUIID("CIPC_DARK");
                    isARStep3Passed = false;
                }

            }

        };
        f.removeAllCommands();
        f.getToolbar().setBackCommand(back);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (isARStep1Passed == true) {
                    btn1.setUIID("CIPC_DARK_SELECTED");
                    btn2.setUIID("CIPC_DARK");
                    btn3.setUIID("CIPC_DARK");
                    btn4.setUIID("CIPC_DARK");
                }
                //Log.p("clicked btn1", Log.DEBUG);
                tabs.setSelectedIndex(0);
                isARStep1Passed = false;
                isARStep2Passed = false;
                isARStep3Passed = false;
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (isARStep2Passed == true) {
                    btn1.setUIID("CIPC_DARK");
                    btn2.setUIID("CIPC_DARK_SELECTED");
                    btn3.setUIID("CIPC_DARK");
                    btn4.setUIID("CIPC_DARK");
                }
                //Log.p("clicked btn2, isRegStep1Passed=" + isRegStep1Passed
                //   + ", isRegStep2Passed=" + isRegStep2Passed, Log.DEBUG);
                isARStep2Passed = false;
                isARStep3Passed = false;

                if (isARStep1Passed == true) {
                    tabs.setSelectedIndex(1);
                } else {
                    checkARButtonPressed();
                }
            }
        });

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //Log.p("clicked btn3", Log.DEBUG);
                if (isARStep3Passed == true) {
                    btn1.setUIID("CIPC_DARK");
                    btn2.setUIID("CIPC_DARK");
                    btn3.setUIID("CIPC_DARK_SELECTED");
                    btn4.setUIID("CIPC_DARK");
                }

                isARStep3Passed = false;
                if (isARStep1Passed == true && isARStep2Passed == true) {
                    tabs.setSelectedIndex(2);
                } else {
                    checkARButtonPressed();
                }
            }
        });

        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //Log.p("clicked btn4", Log.DEBUG);

//                   if (isARStep4Passed == true) {
//                    btn1.setUIID("CIPC_DARK");
//                    btn2.setUIID("CIPC_DARK");
//                    btn3.setUIID("CIPC_DARK");
//                    btn4.setUIID("CIPC_DARK_SELECTED");
//                }
                if (isARStep1Passed == true && isARStep2Passed == true
                        && isARStep3Passed == true) {
                    tabs.setSelectedIndex(3);
                    enableincorporator(uws.getTrak_no(), f);
                } else {
                    checkARButtonPressed();
                }
            }
        });

        //Step 1
        TextField txtStep1a = (TextField) findByName("txtStep1a", tabs);
        TextField txtStep1b = (TextField) findByName("txtStep1b", tabs);
        TextField txtStep1c = (TextField) findByName("txtStep1c", tabs);

        automoveToNext(txtStep1a, txtStep1b, 4);
        automoveToNext(txtStep1b, txtStep1c, 6);

        txtStep1c.addDataChangedListener(new DataChangedListener() {
            @Override
            public void dataChanged(int type, int index) {
                String text = txtStep1c.getText();
                if (text.length() == 2 && list.contains(text) == false) {
                    showDialog(text + " is an invalid Enterprise Type.");
                }
            }
        });

        txtStep1a.getParent().repaint();

        Button btnStep1RetrieveDetails = (Button) findByName("btnStep1RetrieveDetails", tabs);
        Button btnStep2Confirm = (Button) findByName("btnStep2Confirm", tabs);
        Button btnStep3CalcOutAmount = (Button) findByName("btnStep3CalcOutAmount", tabs);
        Button btnStep4AddToCart = (Button) findByName("btnStep4AddToCart", tabs);

        //Step 2
        Label lblStep2EnterpriseNumber = (Label) findByName("lblStep2EnterpriseNumber", contStep2);
        Label lblStep2EnterpriseName = (Label) findByName("lblStep2EnterpriseName", contStep2);
        Label lblStep2EnterpriseType = (Label) findByName("lblStep2EnterpriseType", contStep2);
        Label lblStep2EnterpriseStatus = (Label) findByName("lblStep2EnterpriseStatus", contStep2);
        Label lblStep2RegistrationDate = (Label) findByName("lblStep2RegistrationDate", contStep2);

        TextField txtARStep2EmailAddress = (TextField) findByName("txtARStep2EmailAddress", contStep2);
        TextField txtARStep2TelCode = (TextField) findByName("txtARStep2TelCode", contStep2);
        TextField txtARStep2TelNo = (TextField) findByName("txtARStep2TelNo", contStep2);

        automoveToNext(txtARStep2TelCode, txtARStep2TelNo, 3);

        TextField txtARStep2CellNumber = (TextField) findByName("txtARStep2CellNumber", contStep2);
        TextArea txtARStep2WebAddress = (TextArea) findByName("txtARStep2WebAddress", contStep2);
        TextArea txtARStep2BusinessDescription = (TextArea) findByName("txtARStep2BusinessDescription", contStep2);
        TextArea txtARStep2PrincipalPlace = (TextArea) findByName("txtARStep2PrincipalPlace", contStep2);

        if (Display.getInstance().isSimulator()) {//2011100088 & K2013064531 & 2014 004548 07
            //Not allowed: 1999/028585/07
            txtStep1a.setText("2016");
            txtStep1b.setText("282743");
            txtStep1c.setText("07");

//            txtARStep2EmailAddress.setText("blessing@mfactory.mobi");
//            txtARStep2TelCode.setText("012");
//            txtARStep2TelNo.setText("3598094");
//            txtARStep2CellNumber.setText("0761111111");
//            txtARStep2WebAddress.setText("www.mfactory.mobi");
//            txtARStep2BusinessDescription.setText("1111a");
//            txtARStep2PrincipalPlace.setText("1111a");
        }

        btnStep1RetrieveDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                PREVTEXT = btnStep1RetrieveDetails.getText();
                btnStep1RetrieveDetails.setText(PROCESSING);
                btnStep1RetrieveDetails.setEnabled(false);

                String msg = "";

                if (txtStep1a.getText().length() != 4
                        || txtStep1b.getText().length() != 6
                        || txtStep1c.getText().length() != 2) {
                    msg += "Please enter correct Enterprise Number. ";
                }

                if (msg.length() > 0) {
                    btnStep1RetrieveDetails.setText(PREVTEXT);
                    btnStep1RetrieveDetails.setEnabled(true);
                    Dialog.show("Error", msg, "Ok", null);
                } else {

                    ENT_NUMBER = txtStep1a.getText() + "/" + txtStep1b.getText()
                            + "/" + txtStep1c.getText();
                    //ENT_NUMBER  = "K2013064531";

                    UserWebServices u = new UserWebServices();

                    User user = new User();
                    user.setAgent_code(AGENT_CODE);
                    formProgress = new FormProgress(f);
                    String entNo = getShortEnterpriseName(txtStep1a.getText(), txtStep1b.getText(),
                            txtStep1c.getText());

                    boolean isPending = u.pendingAnnualReturns(user, entNo);
                    Log.p("isPending=" + isPending, Log.DEBUG);

                    if (isPending) {
                        if (formProgress != null) {
                            formProgress.removeProgress();
                        }
                        btnStep1RetrieveDetails.setText(PREVTEXT);
                        btnStep1RetrieveDetails.setEnabled(true);
                        Dialog.show("Error", "There is already an Annual Return in the Cart for Enterprise.\n\n"
                                + "If this is incorrect please remove from the Cart and try again. ", "Ok", null);
                        return; //TODO better way to exit
                    }

                    enterpriseDetails = u.soap_GetEnterpriseDetails(ENT_NUMBER); //"K2013064531");//2014 / 016320 /  07

                    if (enterpriseDetails != null) {
                        //lblStep2EnterpriseNumber.setText(enterpriseDetails.getEnt_no());
                        lblStep2EnterpriseNumber.setText(ENT_NUMBER);
                        lblStep2EnterpriseName.setText(enterpriseDetails.getEnt_name());
                        lblStep2EnterpriseType.setText(enterpriseDetails.getEnt_type_descr());
                        lblStep2EnterpriseStatus.setText(enterpriseDetails.getEnt_status_descr());
                        lblStep2RegistrationDate.setText(enterpriseDetails.getReg_date());

                        AnnualReturns annualReturns = u.get_ar_info_mobi(AGENT_CODE, ENT_NUMBER);
                        Log.p(annualReturns.toString(), Log.DEBUG);

                        formProgress.removeProgress();
                        // formProgress.removeProgress();
                        Log.p("refresh", Log.DEBUG);

                        txtARStep2EmailAddress.setText(annualReturns.getEnt_email());
                        txtARStep2TelCode.setText(annualReturns.getEnt_tel_code());
                        txtARStep2TelNo.setText(annualReturns.getEnt_tel_no());
                        txtARStep2CellNumber.setText(annualReturns.getEnt_cell());
                        txtARStep2WebAddress.setText(annualReturns.getEnt_website());
                        txtARStep2BusinessDescription.setText(annualReturns.getBus_desc());
                        txtARStep2PrincipalPlace.setText(annualReturns.getPrinc_bus_place());

                        tabs.repaint();

                        btn1.setUIID("CIPC_DARK");
                        btn2.setUIID("CIPC_DARK_SELECTED");
                        btn3.setUIID("CIPC_DARK");
                        btn4.setUIID("CIPC_DARK");
                        isARStep1Passed = true;
                        btnStep2Confirm.setEnabled(true);

                        //Step 2
                        Log.p("code=" + enterpriseDetails.getEnt_status_code(), Log.DEBUG);

                        if (enterpriseDetails.getEnt_status_code().equals("03")
                                || enterpriseDetails.getEnt_status_code().equals("10")
                                || enterpriseDetails.getEnt_status_code().equals("28")
                                || enterpriseDetails.getEnt_status_code().equals("38")) {

                            btnStep2Confirm.setVisible(true);
                            btnStep2Confirm.repaint();

                        } else {
                            btnStep1RetrieveDetails.setText(PREVTEXT);
                            btnStep1RetrieveDetails.setEnabled(true);
                            //showDialog("Invalid Enterprise Status \"" + enterpriseDetails.getEnt_status_descr() + "\". Not allowed to file Annual Returns.");
                            showDialog("Invalid Enterprise Status. Not allowed to file Annual Returns. Please contact CIPC.");

                            if (formProgress != null) {
                                formProgress.removeProgress();
                            }
                            btnStep2Confirm.setVisible(false);
                            btnStep2Confirm.repaint();
                        }

                        if (formProgress != null) {
                            formProgress.removeProgress();
                        }

                        tabs.setSelectedIndex(1);

                    } else {

                        if (formProgress != null) {
                            formProgress.removeProgress();
                        }
                        btnStep1RetrieveDetails.setText(PREVTEXT);
                        btnStep1RetrieveDetails.setEnabled(true);
                        Dialog.show("Error", "Could not obtain enterprise details. Please ensure that your Enterprise number is valid. ", "Ok", null);
                    }

                }
                btnStep1RetrieveDetails.setText(PREVTEXT);
                btnStep1RetrieveDetails.setEnabled(true);
                f.revalidate();

            }

        });

        //Step 3//Please enter Annual Turnover for the current filing year, 2018:
        contStep3Turnovers = (Container) findByName("contStep3Turnovers", tabs);

        btnStep2Confirm.addActionListener((ActionListener) (ActionEvent evt) -> {
            PREVTEXT = btnStep2Confirm.getText();
            btnStep2Confirm.setText(PROCESSING);
            btnStep2Confirm.setEnabled(false);

            ar2EmailAddress = txtARStep2EmailAddress.getText();
            ar2TelCode = txtARStep2TelCode.getText();
            ar2TelNumber = txtARStep2TelNo.getText();
            ar2CellNumber = txtARStep2CellNumber.getText();
            ar2WebAddress = txtARStep2WebAddress.getText();
            ar2BusinessDescription = txtARStep2BusinessDescription.getText();
            ar2PlaceOfBusiness = txtARStep2PrincipalPlace.getText();

            boolean flag = false;

            if (ar2EmailAddress.length() == 0) {
                flag = true;
            }
            if (ar2TelCode.length() == 0) {
                flag = true;
            }
            if (ar2TelNumber.length() == 0) {
                flag = true;
            }

            if (ar2BusinessDescription.length() == 0) {
                flag = true;
            }

            String message = "";

            if (flag == true) {
                message += "Please complete Email, Telephone and Business Description. ";
            }

            if (ar2WebAddress.length() > 0 && isUrlValid(ar2WebAddress) == false) {
                message += "Please enter a valid website URL. ";
            }

            if (ar2CellNumber.length() > 0 && ar2CellNumber.length() < 10) {
                message += "Please enter a valid cell phone number. ";
            } else if (ar2CellNumber != null && ar2CellNumber.length() == 10 && (isCellPhoneValid(ar2CellNumber) == false)) {
                message += "Please enter a valid cell phone number. ";
            }

            if (ar2EmailAddress.length() > 0 && isEmailValid(ar2EmailAddress) == false) {
                message += "Please enter a valid email address. ";
            }

            if (ar2BusinessDescription.length() > 0 && isAlpha(ar2BusinessDescription) == false) {
                message += "Business description must contain alphabetical characters. ";
            } else if (ar2PlaceOfBusiness.length() > 0 && isAlpha(ar2PlaceOfBusiness) == false) {
                message += "Principal place of business must contain alphabetical characters. ";
            }

//            if (isAlpha(ar2BusinessDescription) == false && isAlpha(ar2PlaceOfBusiness) == false) {
//                message += "Business description and Principal place of business must contain alphabetical characters. ";
//            } else if (isAlpha(ar2BusinessDescription) == true && isAlpha(ar2PlaceOfBusiness) == false) {
//                message += "Principal place of business must contain alphabetical characters. ";
//            } else if (isAlpha(ar2BusinessDescription) == false && isAlpha(ar2PlaceOfBusiness) == true) {
//                message += "Business description must contain alphabetical characters. ";
//            }
            if (message.length() > 0) {
                btnStep2Confirm.setText(PREVTEXT);
                btnStep2Confirm.setEnabled(true);
                Dialog.show("Error", message, "Ok", null);
                return;
            }

            formProgress = new FormProgress(f);

            contStep3Turnovers.removeAll();
            listEnterpriseDetails = u.GetAREntTranDetails(ENT_NUMBER, AGENT_CODE);

            if (listEnterpriseDetails.size() > 0) {

                listTextEnterpriseDetails = new ArrayList<>();//store turnover textfields
                for (EnterpriseDetails ent : listEnterpriseDetails) {
                    Container cont0 = new Container(BoxLayout.y());
                    cont0.setUIID("CalendarDay");
                    TextArea txt0a = new TextArea();
                    txt0a.setText("Please enter Annual Turnover for " + ent.getAr_year());
                    txt0a.setEnabled(false);
                    txt0a.setEditable(false);
                    TextField txt0b = new TextField();
                    txt0b.setUIID("TextFieldNameSearch");
                    txt0b.setHint("Amount in rands");
                    txt0b.setConstraint(TextField.NUMERIC);
                    if (Display.getInstance().isSimulator()) {
                        txt0b.setText("0");
                    }
                    txt0a.setUIID("LabelBlackCenter");

                    listTextEnterpriseDetails.add(txt0b);
                    cont0.add(txt0a).add(txt0b);
                    contStep3Turnovers.add(cont0);
                }
                contStep3Turnovers.repaint();

                String messageForDialog = "\"I confirm that the information remains as shown on the Companies Registry, in terms of:\n"
                        + "\n"
                        + "o Registered Office\n"
                        + "\n"
                        + "o Location of Records (if applicable)\n"
                        + "\n"
                        + "o Directors of Company or members of Close Corporation\n"
                        + "\n"
                        + "o Company Secretary (if applicable)\n"
                        + "\n"
                        + "o Auditors and Audit Committees (if applicable)\n"
                        + "\n"
                        + "o Financial Year End\n"
                        + "\nAt completion of filing you will also receive the latest web disclosure with current details as per the Companies Registry.\"\n";
                boolean answer = Dialog.show("Notice", messageForDialog, "Confirm", "Decline");

                if (answer) {

                    tabs.setSelectedIndex(2);
                    btn1.setUIID("CIPC_DARK");
                    btn2.setUIID("CIPC_DARK");
                    btn3.setUIID("CIPC_DARK_SELECTED");
                    btn4.setUIID("CIPC_DARK");
                    isARStep2Passed = true;
                    btnStep3CalcOutAmount.setEnabled(true);
                    formProgress.removeProgress();
                } else {
                    formProgress.removeProgress();
                    btnStep2Confirm.setText(PREVTEXT);
                    btnStep2Confirm.setEnabled(true);
                    return;
                }

            } else {
                btnStep2Confirm.setText(PREVTEXT);
                btnStep2Confirm.setEnabled(true);
                formProgress.removeProgress();
                Dialog.show("No Annual Returns", "The Enterprise " + ENT_NUMBER + " has no pending Annual Returns. ", "Ok", null);
            }

            btnStep2Confirm.setText(PREVTEXT);
            btnStep2Confirm.setEnabled(true);

        });

        Container contStep4AnnualReturns = (Container) findByName("contStep4AnnualReturns", tabs);

        Label lblTotalDue = (Label) findByName("lblTotalDue", tabs);

        btnStep3CalcOutAmount.addActionListener((ActionListener) (ActionEvent evt) -> {

            PREVTEXT = btnStep3CalcOutAmount.getText();
            btnStep3CalcOutAmount.setText(PROCESSING);
            btnStep3CalcOutAmount.setEnabled(false);

            Log.p("listEnterpriseDetails=" + listEnterpriseDetails.size(), Log.DEBUG);

            String dataset = "";

            boolean flag = false;

            for (int i = 0; i < listEnterpriseDetails.size(); i++) {

                EnterpriseDetails entDetails = listEnterpriseDetails.get(i);
                TextArea txtTurnover = listTextEnterpriseDetails.get(i);

                if (txtTurnover.getText().length() == 0) {
                    flag = true;
                }

                dataset += "<Table1 diffgr:id=\"Table11\" msdata:rowOrder=\"0\" diffgr:hasChanges=\"inserted\">\n"
                        + "<ent_no>" + entDetails.getEnt_no() + "</ent_no>\n"
                        + "                     <ar_year>" + entDetails.getAr_year() + "</ar_year>\n"
                        + "                     <ar_month>" + entDetails.getAr_month() + "</ar_month>\n"
                        + "                     <turnover>" + txtTurnover.getText() + "</turnover>\n"
                        + "                     <ent_type_code>" + entDetails.getEnt_type_code() + "</ent_type_code>\n</Table1>\n";

            }

            if (flag == true) {
                btnStep3CalcOutAmount.setText(PREVTEXT);
                btnStep3CalcOutAmount.setEnabled(true);
                Dialog.show("Error", "Please complete all fields. ", "Ok", null);
            } else {

                Log.p("dataset=" + dataset, Log.DEBUG);

                listCalculateARTran = u.CalculateARTranData(dataset);
                contStep4AnnualReturns.removeAll();

                if (listCalculateARTran.isEmpty()) {
                    Log.p("listCalculateARTran=0", Log.DEBUG);
                } else {
                    Log.p("listCalculateARTran=" + listCalculateARTran.size(), Log.DEBUG);
                }

                for (int i = 0; i < listCalculateARTran.size(); i++) {

                    EnterpriseDetails e = listCalculateARTran.get(i);
                    MultiButton mb = new MultiButton();
                    mb.setUIID("CalendarDay");
                    mb.setUIIDLine1("MultiButtonBlack");
                    mb.setUIIDLine2("MultiButtonBlack");
                    mb.setUIIDLine3("MultiButtonBlack");
                    mb.setUIIDLine4("MultiButtonBlack");
                    //mb.setTextLine1("Enterprise No: " + e.getEnt_no()); ENT_NUMBER
                    mb.setTextLine1("Enterprise No: " + ENT_NUMBER);
                    mb.setTextLine2("Reference No: " + e.getReference_no());
                    String arYear = e.getAr_year() + "";
                    String arTurnover = L10NManager.getInstance().formatCurrency(e.getTurnover());
                    arTurnover = changeComma(arTurnover);
                    String arArAmount = L10NManager.getInstance().formatCurrency(e.getAr_amount());
                    arArAmount = changeComma(arArAmount);
                    String arArPenalty = L10NManager.getInstance().formatCurrency(e.getAr_penalty());
                    arArPenalty = changeComma(arArPenalty);

                    mb.setTextLine3("AR Year: " + arYear + " Turnover: " + arTurnover);
                    mb.setTextLine4("AR Amount: " + arArAmount + " Penalty: " + arArPenalty);

                    contStep4AnnualReturns.add(mb);

                }

                if (listCalculateARTran.size() > 0) {
                    EnterpriseDetails lastObject = listCalculateARTran.get(listCalculateARTran.size() - 1);
                    String totalDue = L10NManager.getInstance().formatCurrency(lastObject.getAr_total());
                    totalDue = changeComma(totalDue);
                    lblTotalDue.setText("Total Due: " + totalDue);
                    lblTotalDue.repaint();
                }

                contStep4AnnualReturns.repaint();

                tabs.setSelectedIndex(3);
                enableincorporator(uws.getTrak_no(), f);
                btn1.setUIID("CIPC_DARK");
                btn2.setUIID("CIPC_DARK");
                btn3.setUIID("CIPC_DARK");
                btn4.setUIID("CIPC_DARK_SELECTED");
                isARStep3Passed = true;
                btnStep4AddToCart.setEnabled(true);
            }

            btnStep3CalcOutAmount.setText(PREVTEXT);
            btnStep3CalcOutAmount.setEnabled(true);

        });

        //Step 4
        btnStep4AddToCart.addActionListener((ActionListener) (ActionEvent evt) -> {

            PREVTEXT = btnStep4AddToCart.getText();
            btnStep4AddToCart.setText(PROCESSING);
            btnStep4AddToCart.setEnabled(false);

            EnterpriseDetails tempDetails = listCalculateARTran.get(0);

            tempDetails.setCustomerCode(AGENT_CODE);

            String message = "In terms of Section 33 of the Companies Act 71 of 2008, and regulations 28, 29 and 30 of the Companies Regulations of 2011, a set of criteria is defined for entities to submit Annual Financial Statements (AFSs) together with Annual Returns (ARs). Alternatively, if the set of criteria is not met, entities must submit Financial Accountability Supplements (FASs) together with Annual Returns, as prescribed by Regulation 33 of the Companies Act.\n"
                    + "\n"
                    + " \n"
                    + "By law you are therefore required to either submit AFSs via XBRL or FASs. By clicking \"Accept\" below, you declare that you understand these requirements of the Companies Act. Failure to file either an AFS or FAS will attract an investigation process which can lead to an administrative fine or prosecution. See Section 168(2) and 214 of the Companies Act.\n"
                    + "\n"
                    + " \n"
                    + "Please note that the requirements to submit either FASs or AFSs together with ARs as referenced above don\'t apply to external companies.\n\n\n"
                    + "Please go to the CIPC website after completing this AR payment for more details on both AFS and FAS.";

            boolean arFlag = Dialog.show("Compliance Notice", message, "Accept", "I do not Accept");

            if (arFlag == true) {

                formProgress = new FormProgress(f);

                EnterpriseDetails enterpriseDetails = new EnterpriseDetails();
                enterpriseDetails.setEmailAddress(ar2EmailAddress);
                enterpriseDetails.setTelephoneCode(ar2TelCode);
                enterpriseDetails.setTelephoneNumber(ar2TelNumber);
                enterpriseDetails.setCellphoneNumber(ar2CellNumber);
                enterpriseDetails.setWebsiteAddress(ar2WebAddress);
                enterpriseDetails.setBusinessDescription(ar2BusinessDescription);
                enterpriseDetails.setPrincipalPlaceOfBusiness(ar2PlaceOfBusiness);
                enterpriseDetails.setEnt_type_code(txtStep1c.getText());

                u.insertCartItemAR(responseUser, listCalculateARTran, enterpriseDetails);

                isARStep1Passed = false;
                isARStep2Passed = false;
                isARStep3Passed = false;

                if (formProgress != null) {
                    formProgress.removeProgress();
                }

                Dialog.show("Success", "Annual Return (s) added to Shopping Cart. ", "Ok", null);
                showCart2(f);
            } else {
                btnStep4AddToCart.setText(PREVTEXT);
                btnStep4AddToCart.setEnabled(true);
                //do nothing
            }

            btnStep4AddToCart.setText(PREVTEXT);
            btnStep4AddToCart.setEnabled(true);

        });

        Container contTop = new Container();
        contTop.setUIID("ContainerWhite");
        contProjects.setUIID("ContainerWhite");
        contTop.setLayout(new GridLayout(1, 4));
        contTop.add(btn1).add(btn2).add(btn3).add(btn4);

        Container border = new Container(new BorderLayout());
        border.setUIID("ContainerWhite");

        border.add(BorderLayout.NORTH, contTop);

        border.add(BorderLayout.CENTER, contProjects);

        if (orientationListener != null) {
            f.removeOrientationListener(orientationListener);
        }

        orientationListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                updateLayoutRegistration(f, border);
            }
        };

        f.addOrientationListener(orientationListener);

        updateLayoutRegistration(f, border);

        if (!Display.getInstance().isTablet()) {
            f.setLayout(new GridLayout(1, 1));
            f.add(border);
        }

        if (formProgress != null) {
            formProgress.removeProgress();
        }

    }

    static boolean isCartStep2 = false;
    static boolean isCartStep3 = false;
    static boolean isCartStep4 = false;

    BrowserComponent browser;

    public void showCart2(final Form f) {

        hideLogout();

        //String directURL = Constants.paymentEndPoint + "ACSRedirect.aspx";
        //String errorURL = Constants.paymentEndPoint + "PaymentError.aspx?error=1EwiapDpld0GrXoBVjnhEC52%2fRVCNKIi9Xsi%2fs9YpzA%3d&ref=T9122961860";
        UserWebServices u = new UserWebServices();
        User user = new User();
        user.setAgent_code(AGENT_CODE);
        map = u.getCart(user);

        ArrayList AnnualReturns = (ArrayList) map.get("AnnualReturns");

        ArrayList CartItems = (ArrayList) map.get("CartItems");

        if ((AnnualReturns != null && !AnnualReturns.isEmpty()) || (CartItems != null && !CartItems.isEmpty())) {

            isFromDash = false;

            formProgress = new FormProgress(f);

            if (formProgress == null) {
                formProgress = new FormProgress(f);
            }

            Container cont = (Container) createContainer("/theme", "ContCart");
            cont.setName("cont");
            Container contStep1AnnualReturns = (Container) findByName("contStep1AnnualReturns", cont);
            contStep1AnnualReturns.removeAll();
            Container contStep1EServices = (Container) findByName("contStep1EServices", cont);
            contStep1EServices.removeAll();
            Label lblTotal = (Label) findByName("lblTotal", cont);
            lblTotal.setText("");

            Container contStep1 = (Container) findByName("contStep1", cont);
            //contStep1.removeAll();

            if (!Display.getInstance().isTablet()) {
                f.removeAll();
                if (f.getLayout() instanceof BorderLayout) {
                    f.add(BorderLayout.CENTER, cont);
                } else {
                    f.add(cont);
                }

            }

            if (orientationListener != null) {
                f.removeOrientationListener(orientationListener);
            }

            orientationListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    updateLayoutRegistration(f, cont);
                }
            };

            f.addOrientationListener(orientationListener);

            updateLayoutRegistration(f, cont);

            Tabs Tabs = (Tabs) findByName("Tabs", cont);
            Tabs.setSwipeActivated(false);
            Tabs.hideTabs();

            Command back = new Command("") {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    super.actionPerformed(evt); //To change body of generated methods, choose Tools | Templates.
                    Log.p("AR back isCartStep2=" + isCartStep2 + " isCartStep3=" + isCartStep3 + "isCartStep4=" + isCartStep4, Log.DEBUG);

                    if (isCartStep4 == true) {
                        browser.back();
                        isCartStep4 = false;
                    } else if (isCartStep3 == true) {
                        Tabs.setSelectedIndex(0);
                        isCartStep3 = false;
                    } else if (isCartStep2 == true) {
                        Tabs.setSelectedIndex(0);
                        isCartStep2 = false;
                    } else {
                        showDashboard(f);
                    }
                }

            };
            f.removeAllCommands();
            f.getToolbar().setBackCommand(back);
            Toolbar.setEnableSideMenuSwipe(false);

            Container contStep2 = (Container) findByName("contStep2", cont);
            contStep2.removeAll();
            contStep2.setLayout(new BorderLayout());

            Log.p("width=" + width + ", height=" + height, Log.DEBUG);
            //Dialog.show("", "width=" + width + ", height=" + height, "Ok", null);

            String encodedCustCode = "";
            String filePath = FileSystemStorage.getInstance().getAppHomePath() + "/a.txt";
            String home = FileSystemStorage.getInstance().getAppHomePath();

            OutputStream fos = null;
            InputStream fis = null;
            try {

                DESede_BC encrypter = new DESede_BC();

                fos = FileSystemStorage.getInstance().openOutputStream(filePath);
                fis = new ByteArrayInputStream(AGENT_CODE.getBytes());
                encodedCustCode = encrypter.encrypt(fis, fos);
                Log.p("encodedCustCode=" + encodedCustCode, Log.DEBUG);
                fis.close();
                fos.close();

            } catch (InvalidCipherTextException ex) {
                Log.e(ex);
            } catch (IOException ex) {
                Log.e(ex);
            }

            String URL = Constants.paymentEndPoint + "Pay.aspx?custCode=" + encodedCustCode + "&custId=" + encodedCustCode + "&appId=6"
                    + "&width=" + width + "&height=" + height;

            /*
              String URL = "https://paymenttest.cipc.co.za:9443/MobileACSRedirect.aspx?custCode=" + encodedCustCode + "&custId=" + encodedCustCode + "&appId=6"
               + "&width=" + width + "&height=" + height;*/
            Log.p(URL, Log.DEBUG);

            hasGonePastACS = false;

            closeMenu(f, true);
            analytics(f, "Shopping Cart");
            current = f;
            Container contentPane = f.getContentPane();
////            contentPane.setLayout(new GridLayout(1, 1));
////            contentPane.removeAll();

            Log.p("Cart agent=" + AGENT_CODE, Log.DEBUG);

            String CustomerCode = map.get("CustomerCode").toString();
            double AnnualReturnsTotalAmount = Double.parseDouble(map.get("AnnualReturnsTotalAmount").toString());
            double ItemDataTotalAmount = Double.parseDouble(map.get("ItemDataTotalAmount").toString());
            double TotalAmount = Double.parseDouble(map.get("TotalAmount").toString());
            double ItemsCount = Double.parseDouble(map.get("ItemsCount").toString());

            double eserviceTotal = 0.0;

            if (AnnualReturns != null) {
                Log.p("Annual Returns=" + AnnualReturns.size(), Log.DEBUG);

                if (!AnnualReturns.isEmpty()) {
                    Label lbl = new Label("ANNUAL RETURNS");
                    lbl.setUIID("LabelCart");
                    contStep1EServices.add(lbl);
                }

                //Annual Returns
                for (Object o : AnnualReturns) {

                    Container contItem = new Container(new BorderLayout());
                    contItem.setUIID("ContainerBox");
                    Map m = (Map) o;
                    //String ItemType = m.get("ItemType").toString();
                    //String StatusDate = m.get("StatusDate").toString();
                    String ReferenceNumber = L10NManager.getInstance().format(Double.parseDouble(m.get("ReferenceNumber").toString()));
                    ReferenceNumber = ReferenceNumber.trim();
                    ReferenceNumber = StringUtil.replaceAll(ReferenceNumber, ",", "");//remove comma
                    ReferenceNumber = StringUtil.replaceAll(ReferenceNumber, " ", "");//remove spaces

                    String EnterpriseNumber = m.get("EnterpriseNumber").toString();
                    //String FormCode = m.get("FormCode").toString();
                    double TotalAmountItemType = Double.parseDouble(m.get("TotalAmount").toString());
                    eserviceTotal += TotalAmountItemType;

                    MultiButton mb = new MultiButton();
                    mb.setUIID("Label");
                    mb.setUIIDLine1("MultiButtonBlack");
                    mb.setUIIDLine2("MultiButtonBlack");
                    mb.setUIIDLine3("MultiButtonBlack");
                    mb.setUIIDLine4("MultiButtonBlack");

                    mb.setTextLine1("Reference No: " + ReferenceNumber);
                    //mb.setTextLine2("Enterprise No: " + EnterpriseNumber);
                    String formattedEnterpriseNumber = u.format_ent_no_mobi(EnterpriseNumber).getFull();
                    mb.setTextLine2("Enterprise No: " + formattedEnterpriseNumber);
                    Log.p("TotalAmountItemType=" + TotalAmountItemType, Log.DEBUG);
                    String strTotalAmountItemType = L10NManager.getInstance().formatCurrency(TotalAmountItemType);
                    strTotalAmountItemType = changeComma(strTotalAmountItemType);
                    Log.p("strTotalAmountItemType=" + strTotalAmountItemType, Log.DEBUG);
                    //mb.setTextLine3("Item Cost: " + strTotalAmountItemType);

                    Button btnEServiceItemCost = new Button("Transaction Cost: " + strTotalAmountItemType);
                    btnEServiceItemCost.setUIID("ButtonItemCost");
                    Container contEServiceItemCost = FlowLayout.encloseIn(btnEServiceItemCost);
                    contEServiceItemCost.setUIID("ContButtonItemCost");

                    Button btnRemove0 = new Button("REMOVE");
                    btnRemove0.setUIID("ButtonRemove");
                    Container c0 = FlowLayout.encloseRight(btnRemove0);
                    c0.setUIID("DeleteButtonCont");

                    btnRemove0.setName(ReferenceNumber);//ensure we have correct button
                    btnRemove0.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            btnRemove0.setEnabled(false);
                            ArrayList Items = (ArrayList) map.get("Items");
                            if (Items != null && Items.size() > 0) {
                                for (int k = 0; k < Items.size(); k++) {
                                    Map objectToDelete = (Map) Items.get(k);
                                    objectToDelete.put("Status", 2);
                                    String ReferenceNumberToDelete = L10NManager.getInstance().format(Double.parseDouble(objectToDelete.get("ReferenceNumber").toString()));
                                    ReferenceNumberToDelete = ReferenceNumberToDelete.trim();
                                    ReferenceNumberToDelete = StringUtil.replaceAll(ReferenceNumberToDelete, ",", "");//remove comma
                                    ReferenceNumberToDelete = StringUtil.replaceAll(ReferenceNumberToDelete, " ", "");//remove spaces

                                    if (btnRemove0.getName().equals(ReferenceNumberToDelete)) {
                                        Log.p("Delete AR ReferenceNumber=" + ReferenceNumberToDelete, Log.DEBUG);
                                        u.deleteCartItem(user, objectToDelete);
                                        showCart2(f);
                                    }
                                }
                            }
                            btnRemove0.setEnabled(true);
                        }
                    });
                    //c0.add(btnRemove0);

                    contItem.add(BorderLayout.CENTER, mb).add(BorderLayout.SOUTH, contEServiceItemCost).add(BorderLayout.EAST, c0);
                    contStep1EServices.add(contItem);

                }
            }

            if (CartItems != null) {
                Log.p("CartItems=" + CartItems.size(), Log.DEBUG);

                if (!CartItems.isEmpty()) {
                    Label lbl = new Label("E-SERVICES");
                    lbl.setUIID("LabelCart");
                    contStep1EServices.add(lbl);
                }
                //CartItems
                for (j = 0; j < CartItems.size(); j++) {
                    Object o = CartItems.get(j);
                    Container contItem = new Container(new BorderLayout());
                    contItem.setUIID("ContainerBox");
                    Map m = (Map) o;
                    String ItemType = m.get("ItemType").toString();
                    //String Status = m.get("Status").toString();
                    //String StatusDate = m.get("StatusDate").toString();

                    m.put("Status", 2);
                    m.put("StatusDate", getAnnualReturnsDateNow());

                    String rawReferenceNumber = m.get("ReferenceNumber").toString();
                    ReferenceNumber = L10NManager.getInstance().format(Double.parseDouble(m.get("ReferenceNumber").toString()));
                    ReferenceNumber = ReferenceNumber.trim();
                    ReferenceNumber = StringUtil.replaceAll(ReferenceNumber, ",", "");//remove comma
                    ReferenceNumber = StringUtil.replaceAll(ReferenceNumber, " ", "");//remove spaces

                    String EnterpriseNumber = m.get("EnterpriseNumber").toString();
                    String FormCode = m.get("FormCode").toString();
                    double TotalAmountItemType = Double.parseDouble(m.get("TotalAmount").toString());
                    eserviceTotal += TotalAmountItemType;

                    MultiButton mb = new MultiButton();
                    mb.setUIID("Label");
                    mb.setUIIDLine1("MultiButtonBlack");
                    mb.setUIIDLine2("MultiButtonBlack");
                    mb.setUIIDLine3("MultiButtonBlack");
                    mb.setUIIDLine4("MultiButtonBlack");

                    mb.setTextLine1("Reference No: " + ReferenceNumber);
                    //mb.setTextLine2("Enterprise No: " + EnterpriseNumber);
                    mb.setTextLine2("Service: " + ItemType);
                    String strTotalAmountItemType = L10NManager.getInstance().formatCurrency(TotalAmountItemType);
                    strTotalAmountItemType = changeComma(strTotalAmountItemType);
                    Log.p("strTotalAmountItemType=" + strTotalAmountItemType, Log.DEBUG);
                    Button btnEServiceItemCost = new Button("Transaction Cost: " + strTotalAmountItemType);
                    btnEServiceItemCost.setUIID("ButtonItemCost");
                    Container contEServiceItemCost = FlowLayout.encloseIn(btnEServiceItemCost);
                    contEServiceItemCost.setUIID("ContButtonItemCost");

                    Button btnRemove0 = new Button("REMOVE");
                    btnRemove0.setUIID("ButtonRemove");

                    Container c0 = FlowLayout.encloseRight(btnRemove0);
                    c0.setUIID("DeleteButtonCont");
                    btnRemove0.setName(ReferenceNumber);//ensure we have correct reference
                    //btnRemove0.setUIID("CalendarDay");

                    btnRemove0.addActionListener((ActionListener) (ActionEvent evt) -> {
                        btnRemove0.setEnabled(false);
                        ArrayList Items = (ArrayList) map.get("Items");
                        if (Items != null && Items.size() > 0) {
                            for (int k = 0; k < Items.size(); k++) {
                                Map objectToDelete = (Map) Items.get(k);
                                objectToDelete.put("Status", 2);
                                String ReferenceNumberToDelete = L10NManager.getInstance().format(Double.parseDouble(objectToDelete.get("ReferenceNumber").toString()));
                                ReferenceNumberToDelete = ReferenceNumberToDelete.trim();
                                ReferenceNumberToDelete = StringUtil.replaceAll(ReferenceNumberToDelete, ",", "");//remove comma
                                ReferenceNumberToDelete = StringUtil.replaceAll(ReferenceNumberToDelete, " ", "");//remove spaces

                                if (btnRemove0.getName().equals(ReferenceNumberToDelete)) {
                                    Log.p("Delete Name reservation ReferenceNumber=" + ReferenceNumberToDelete, Log.DEBUG);
                                    u.deleteCartItem(user, objectToDelete);
                                    showCart2(f);
                                }
                            }
                        }
                        btnRemove0.setEnabled(true);
                        //
                        //contItem.remove();
                        //contStep1EServices.repaint();
                    });

                    //c0.add(btnRemove0);
                    contItem.add(BorderLayout.CENTER, mb).add(BorderLayout.SOUTH, contEServiceItemCost).add(BorderLayout.EAST, c0);
                    contStep1EServices.add(contItem);

                }
            }

            String strEserviceTotal = L10NManager.getInstance().formatCurrency(eserviceTotal);
            strEserviceTotal = changeComma(strEserviceTotal);
            Log.p("strTotalAmountItemType=" + strEserviceTotal, Log.DEBUG);
            lblTotal.setText("Total: " + strEserviceTotal);
            lblTotal.repaint();

            Button btnCheckout = (Button) findByName("btnCheckout", cont);
            btnCheckout.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {

                    Object objectCheckout = Storage.getInstance().readObject("objectCheckout");

                    if (objectCheckout == null) {
                        Dialog d = (Dialog) createContainer("/theme", "Payment");
                        Button btnOk = (Button) findByName("btnOk", d);
                        btnOk.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent evt) {
                                Button chkNoShow = (Button) findByName("chkNoShow", d);
                                if (chkNoShow.isSelected()) {
                                    Log.p("Check box selected", Log.DEBUG);
                                    Storage.getInstance().writeObject("objectCheckout", "true");
                                } else {
                                    Log.p("Check box is not selected", Log.DEBUG);
                                }
                                d.dispose();
                            }
                        });
                        d.show();
                    }

                    PREVTEXT = btnCheckout.getText();
                    btnCheckout.setEnabled(false);
                    btnCheckout.setText(PROCESSING);
                    Log.p("checkout clicked", Log.DEBUG);
                    isCartStep2 = true;
                    Tabs.setSelectedIndex(1);

                    browser = new BrowserComponent();
                    browser.setURL(URL);
                    browser.setScrollableX(false);
                    browser.setScrollableY(false);
                    browser.setPinchToZoomEnabled(false);

                    browser.addWebEventListener("onStart", new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            Log.p("onStart: " + browser.getURL(), Log.DEBUG);

                            if (browser.getURL().indexOf("Pay.aspx") > -1) {
                                if (isCartStep2 == true) {
                                    isCartStep3 = true;
                                }
                                formProgress = new FormProgress(f);

                            }

                            if (browser.getURL().indexOf("ACSRedirect.aspx") > -1) {
                                isCartStep4 = true;

                                formProgress = new FormProgress(f);

//                                formProgress = new FormProgress(f);
//
//                                Display.getInstance().callSerially(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        UITimer t = new UITimer(new Runnable() {
//                                            public void run() {
//                                                if (formProgress != null) {
//                                                    formProgress.removeProgress();
//                                                }
//
//                                            }
//                                        });
//                                        t.schedule(5000, false, f);
//                                    }
//                                });
                            }
                        }
                    });

                    browser.addWebEventListener("onLoad", new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            Log.p("onLoad: " + browser.getURL(), Log.DEBUG);

                            if (browser != null && browser.getURL() != null && browser.getURL().indexOf("Pay.aspx") > -1) {
                                if (isCartStep2 == true) {
                                    isCartStep3 = true;
                                }

                                if (formProgress != null) {
                                    formProgress.removeProgress();
                                    formProgress = null;
                                }
                            }

                            if (browser != null && browser.getURL() != null && browser.getURL().indexOf("ACSRedirect.aspx") > -1) {
                                if (isCartStep3 == true) {
                                    isCartStep4 = true;
                                }

                                if (formProgress != null) {
                                    formProgress.removeProgress();
                                    formProgress = null;
                                }
                            }

                        }
                    });

                    browser.addWebEventListener("onError", new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            Log.p("onError", Log.DEBUG);
                        }
                    });

                    browser.addBrowserNavigationCallback(new BrowserNavigationCallback() {
                        @Override
                        public boolean shouldNavigate(String url) {

                            Log.p("url=" + url, Log.DEBUG);

                            String trans = getPaymentTransNoFromURL(url);

                            if (trans.length() > 0) {//trans successful

                                Display.getInstance().callSerially(new Runnable() {
                                    @Override
                                    public void run() {
                                        isCartStep2 = false;
                                        isCartStep3 = false;
                                        isCartStep4 = false;
                                        showDashboard(f);
                                        Dialog.show("Success", "Payment processed. Transaction Number " + trans + ". ", "Ok", null);

                                    }
                                });

                            } else if (url.indexOf("PaymentError") > -1) {

                                Display.getInstance().callSerially(new Runnable() {
                                    @Override
                                    public void run() {
                                        isCartStep2 = false;
                                        isCartStep3 = false;
                                        isCartStep4 = false;
                                        showCart2(f);
                                        Dialog.show("Error", "Payment error. Please contact CIPC.", "Ok", null);

                                    }
                                });
                                //showDashboard(f);
                            }

                            return true;
                        }
                    });

                    //browser.setProperty("useragent", "Mozilla/5.0 (Linux; Android 4.0.4; Galaxy Nexus Build/IMM76K) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");
                    //browser.setProperty("useragent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.45 Safari/535.19");
                    contStep2.add(BorderLayout.CENTER, browser);
                    contStep2.setScrollableX(false);
                    contStep2.setScrollableY(false);
                    f.setScrollableX(false);
                    f.setScrollableY(false);
                    f.revalidate();

                    btnCheckout.setEnabled(true);
                    btnCheckout.setText(PREVTEXT);
                }
            }
            );
            //        Button btnPayNow = (Button) findByName("btnPayNow", tabs);
            //        btnPayNow.addActionListener(new ActionListener() {
            //            @Override
            //            public void actionPerformed(ActionEvent evt) {
            //                formProgress = new FormProgress(f);
            //                try {
            //
            //                    Thread.sleep(3000L);
            //                } catch (InterruptedException e) {
            //                    Log.e(e);
            //                }
            //                formProgress.removeProgress();
            //
            //                Dialog.show("Processed", "Payment processed", "Ok", null);
            //            }
            //        });
        } else {
            Dialog.show("No Items", "You do not have any Cart items. Please perform a transaction first.", "Ok", null);
            if (isFromDash == false) {//avoid reload
                showDashboard(f);
            } else {
                isFromDash = false;
            }
        }
        f.revalidate();
        Log.p("2046", Log.DEBUG);

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
        //contDashBoard = (Container) findByName("ContDashBoard", f);
        showDashboard(f);

    }

    private void addSideMenu(Form f, Toolbar tb) {
        int sizeLabel = 5;

        if (contSideMenu == null) {

            contSideMenu = (Container) createContainer("/theme", "ContSideMenu");
            contSideMenu.setName("contSideMenu");

            contSideMenu.setScrollableX(false);//This fixed the side menu scroll issue
            contSideMenu.setScrollableY(false);

            Container contProfile = (Container) findByName("contProfile", contSideMenu);
            contProfile.setVisible(false);

            contSideMenu.removeComponent(contProfile);
            contSideMenu.repaint();
            btnProfilePic = (Button) findByName("btnProfilePic", contSideMenu);
            btnProfileName = (Button) findByName("btnProfileName", contSideMenu);

            btnProfileName.setText("Update Profile");

            btnProfilePic.addActionListener((ActionListener) (ActionEvent evt) -> {
                showProfile(f);
            });

            btnProfileName.addActionListener((ActionListener) (ActionEvent evt) -> {
                showProfile(f);
            });

            Button btnDashboard = (Button) findByName("btnDashboard", contSideMenu);
            btnDashboard.addActionListener((ActionListener) (ActionEvent evt) -> {
                closeMenu(f, true);
                showDashboard(f);
                closeMenu(f, true);
            });

            Button btnLogout = (Button) findByName("btnLogout", contSideMenu);
            btnLogout.addActionListener((ActionListener) (ActionEvent evt) -> {
                showLogin(null);
            });

            Style labelForm = UIManager.getInstance().getComponentStyle("LabelWhite");
            labelForm.setMargin(0, 0, 0, 0);
            labelForm.setPadding(0, 0, 0, 0);
            sizeLabel = 6;

            btnDashboard.setIcon(FontImage.createMaterial(FontImage.MATERIAL_DASHBOARD, labelForm, sizeLabel));
            btnLogout.setIcon(FontImage.createMaterial(FontImage.MATERIAL_EXIT_TO_APP, labelForm, sizeLabel));

            Command command = new Command("Update Photo");
            command.putClientProperty("SideComponent", contSideMenu);

            labelForm = UIManager.getInstance().getComponentStyle("ButtonLabel");

            FontImage img1 = FontImage.createMaterial(FontImage.MATERIAL_MENU, labelForm, sizeLabel);

            f.getToolbar().addCommandToLeftBar("", img1, new ActionListener<ActionEvent>() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    tb.openSideMenu();
                }
            }
            );
            f.getToolbar().addComponentToSideMenu(contSideMenu);
            f.revalidate();
        } else {

            Style labelForm = UIManager.getInstance().getComponentStyle("ButtonLabel");

            FontImage img1 = FontImage.createMaterial(FontImage.MATERIAL_MENU, labelForm, sizeLabel);

            f.getToolbar().addCommandToLeftBar("", img1, new ActionListener<ActionEvent>() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    tb.openSideMenu();
                }
            }
            );
            //f.getToolbar().addComponentToSideMenu(contSideMenu);
            f.revalidate();

        }

    }

    public void showLogin(Command back) {
        if (contSideMenu != null) {
            contSideMenu.removeAll();
            contSideMenu = null;
        }
        Form f = showForm("Login", back);
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

        Button btnLogin = (Button) findByName("btnLogin", f);
        PREVTEXT = btnLogin.getText();
        btnLogin.setEnabled(false);
        btnLogin.setText(PROCESSING);

        Container c = (Container) findByName("containerParent", f);

        String txtCustomerCode = ((TextField) findByName("txtCustomerCode", c)).getText();
        final String password = ((TextField) findByName("txtPassword", c)).getText();

        String msg = "";

        if (txtCustomerCode.length() == 0 || password.length() == 0) {
            msg += "Please complete all fields.";
        }

        if (msg.length() == 0) {

            za.co.cipc.pojos.User user = new za.co.cipc.pojos.User();
            user.setAgent_code(txtCustomerCode);
            user.setParamPassword(password);

            formProgress = new FormProgress(f);

            UserWebServices userWebServices = new UserWebServices();

            responseUser = userWebServices.get_cust_MOBI_2(user);

            if (responseUser != null && responseUser.getError() != null
                    && responseUser.getError().length() > 0) {
                btnLogin.setEnabled(true);
                btnLogin.setText(PREVTEXT);
                if (formProgress != null) {
                    formProgress.removeProgress();
                }
                Dialog.show("Error", responseUser.getError(), "Ok", null);
                return true;
            }

            //Log.p("responseUser name=" + responseUser.getAgent_code() + " password=" + responseUser.getPassword(), Log.DEBUG);
            String errorMessage = "";

            String responsePassword = null;
            if (responseUser == null) {
                formProgress.removeProgress();
                Log.p("exception" + "", Log.DEBUG);

                errorMessage += "Incorrect Customer Code or Password. ";

            } else {
                responsePassword = responseUser.getPassword();
            }

            //Log.p(password + ":" + responsePassword);
            if (errorMessage.length() == 0 && password != null && password.equals(responsePassword)) {
                AGENT_CODE = txtCustomerCode.toUpperCase();//CIPC web service expects uppercase customer code
                return false;
            } else {
                errorMessage += "Invalid Customer Code or Password. ";
            }

            formProgress.removeProgress();

            if (errorMessage != null && errorMessage.length() > 0) {
                showDialog(errorMessage);
                btnLogin.setEnabled(true);
                btnLogin.setText(PREVTEXT);
                return true;//block
            } else {
                return false;
            }

        } else {
            //error
            btnLogin.setEnabled(true);
            btnLogin.setText(PREVTEXT);
            Dialog.show("Error", msg, "Ok", null);
            return true;
        }

    }

    public void showDialog(String message) {
        ToastBar.Status status = ToastBar.getInstance().createStatus();
        status.setMessage(message);
        status.setExpires(5000);
        status.show();

    }

    private void automoveToNext(final TextField current, final TextField next, final int limit) {
        current.addDataChangedListener((type, index) -> {
            if (current.getText().length() == limit) {
                next.requestFocus();
                next.startEditing();
            }
        });
//        current.addDataChangedListener(new DataChangedListener() {
//            public void dataChanged(int type, int index) {
//                if (current.getText().length() == limit + 1) {
//                    Display.getInstance().stopEditing(current);
//                    String val = current.getText();
//                    current.setText(val.substring(0, limit));
//                    next.setText(val.substring(limit));
//                    Display.getInstance().editString(next, limit, current.getConstraint(), next.getText());
//                }
//            }
//        });
    }

    public void isTableInputForm(Form f) {
    }

    @Override
    protected void beforeLogin(final Form f) {

        f.setUIID("Background", "BackgroundLandscape");

        if (Display.getInstance().isTablet()) {
            f.setLayout(new GridLayout(1, 3));
            f.addComponent(0, new Label(" "));
            f.repaint();
        }

        Toolbar toolbar = analytics(f, " ");

        Command loginBack = new Command("") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                super.actionPerformed(evt); //To change body of generated methods, choose Tools | Templates.
                Log.p("Login back clicked", Log.DEBUG);
                boolean flag = Dialog.show("Exit", "Are you sure you want to Exit App?", "Yes", "No");
                if (flag) {
                    Display.getInstance().minimizeApplication();//Android
                }

            }

        };
        //toolbar.setBackCommand(loginBack);
        toolbar.addCommandToLeftBar(loginBack);
        toolbar.setBackCommand(loginBack);

        current = f;
        f.setScrollVisible(false);
        Container containerParent = (Container) findByName("containerParent", f);
        Container contentPane = f.getContentPane();
        contentPane.setScrollVisible(false);
        containerParent.setScrollVisible(false);
        Button btnForgotPassword = (Button) findByName("btnForgotPassword", f);
        //btnForgotPassword.remove();

        f.revalidate();

        if (Display.getInstance().isSimulator()) {
            TextField txtCustomerCode = (TextField) findByName("txtCustomerCode", f);
            //txtCustomerCode.setText("BLE076");
            TextField txtPassword = (TextField) findByName("txtPassword", f);
            //txtPassword.setText("Password12");

            txtCustomerCode.setText(defaultEmail);
            txtPassword.setText(defaultPassword);

        }

    }

    public void checkRegButtonPressed() {

        String msg = "";

        if (isRegStep1Passed == false) {
            msg = "Please complete step 1 first. ";
        } else if (isRegStep2Passed == false) {
            msg = "Please complete step 2 first. ";
        } else if (isRegStep3Passed == false) {
            msg = "Please complete step 3 first. ";
        }

        Dialog.show("Error", msg, "Ok", null);

    }

    public void checkARButtonPressed() {

        String msg = "";

        if (isARStep1Passed == false) {
            msg = "Please complete step 1 first. ";
        } else if (isARStep2Passed == false) {
            msg = "Please complete step 2 first. ";
        } else if (isARStep3Passed == false) {
            msg = "Please complete step 3 first. ";
        }

        Dialog.show("Error", msg, "Ok", null);

    }

    public void updateLayoutRegistration(Form f, Container contentParam) {

        boolean isPotrait = Display.getInstance().isPortrait();

        if (Display.getInstance().isTablet()) {

            TableLayout layout = new TableLayout(1, 3);

            Container content = null;
            if (contentParam == null) {
                content = (Container) findByName("content", f);
            } else {
                content = contentParam;
            }

            //content.setUIID("ContainerContentTabletPortrait");
            if (content != null && content.getName() != null && (content.getName().equals("NameReservation")
                    || content.getName().equals("Cart"))) {
                content.setUIID("BackgroundWhiteTabletPortrait", "BackgroundWhiteTabletLandscape");
            } else {
                content.setUIID("ContainerContentTabletPortrait", "ContainerContentTabletLandscape");

            }
            f.removeComponent(content);
            f.removeAll();
            // f.setLayout(new BorderLayout());

            //f.setUIID("BackgroundTableLandscape");
            //f.addComponent(BorderLayout.CENTER, content);
            f.setLayout(new GridLayout(1, 1));
            f.addComponent(content);

            f.revalidate();

//            if (isPotrait) {
//                f.addComponent(layout.createConstraint().widthPercentage(10), new Label(" "));
//                f.addComponent(layout.createConstraint().widthPercentage(80), content);
//                f.addComponent(layout.createConstraint().widthPercentage(10), new Label(" "));
//            } else {
//                f.addComponent(layout.createConstraint().widthPercentage(25), new Label(" "));
//                f.addComponent(layout.createConstraint().widthPercentage(50), content);
//                f.addComponent(layout.createConstraint().widthPercentage(25), new Label(" "));
//            }
        }

    }

    public void stylePicker(Picker picker) {
        picker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Log.p("picker.getSelectedStringIndex() =" + picker.getSelectedStringIndex(), Log.DEBUG);
                if (picker.getSelectedStringIndex() == 0) {
                    picker.setUIID("PickerIcon");
                    Log.p("PickerIcon", Log.DEBUG);
                } else {
                    Log.p("PickerIconBlack", Log.DEBUG);
                    picker.setUIID("PickerIconBlack");
                }
                picker.repaint();
            }
        });
    }

    @Override
    protected void beforeRegistration(Form f) {

        f.addOrientationListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                updateLayoutRegistration(f, null);

            }
        });

        updateLayoutRegistration(f, null);

        isRegStep1Passed = false;
        isRegStep2Passed = false;
        isRegStep3Passed = false;
//
//        Command back = new Command("") {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                super.actionPerformed(evt); //To change body of generated methods, choose Tools | Templates.
//                Form f = (Form) createContainer("Login", "/theme");
//                f.showBack();
//
//            }
//
//        };
//        f.setBackCommand(back);

        UserWebServices u = new UserWebServices();
        //String strCoutries[] = u.get_countries(null);

        Tabs tabs = (Tabs) findByName("Tabs", f);
        tabs.setSwipeActivated(false);
        tabs.hideTabs();

        Button btnStep1NoID = (Button) findByName("btnStep1NoID", tabs);

        Button btnStep1Continue = (Button) findByName("btnStep1Continue", tabs);
        Button btnStep2Continue = (Button) findByName("btnStep2Continue", tabs);
        Button btnStep3Next = (Button) findByName("btnStep3Next", tabs);
        Button btnStep4Register = (Button) findByName("btnStep4Register", tabs);

        Style labelForm = UIManager.getInstance().getComponentStyle("Button");
        labelForm.setMargin(0, 0, 0, 0);
        labelForm.setPadding(0, 0, 0, 0);
        int sizeLabel = 6;

        Image imgForward = FontImage.createMaterial(FontImage.MATERIAL_FORWARD, labelForm, sizeLabel);

//        btnStep1Continue.setText("");
//        btnStep2Continue.setText("");
//        btnStep3Next.setText("");
//
//        btnStep1Continue.setIcon(imgForward);
//        btnStep2Continue.setIcon(imgForward);
//        btnStep3Next.setIcon(imgForward);
//        
//        btnStep1Continue.repaint();
//        btnStep2Continue.repaint();
//        btnStep3Next.repaint();
        //btnStep1RetrieveDetails.setIcon(imgForward);
////        final Picker pickerCountry = (Picker) findByName("pickerStep2Country", f);
////        stylePicker(pickerCountry);
//        pickerCountry.setType(Display.PICKER_TYPE_STRINGS);
//        pickerCountry.setStrings(strCoutries);
//        pickerCountry.setSelectedStringIndex(0);
        TextField txtStep2FirstName = (TextField) findByName("txtStep2FirstName", tabs);
        TextField txtStep2LastName = (TextField) findByName("txtStep2LastName", tabs);
        TextField txtStep2CellPhone = (TextField) findByName("txtStep2CellPhone", tabs);
        TextField txtStep2Email = (TextField) findByName("txtStep2Email", tabs);
        TextField txtStep2EmailRetype = (TextField) findByName("txtStep2EmailRetype", tabs);
        TextField txtStep2TelephoneNumber = (TextField) findByName("txtStep2TelephoneNumber", tabs);
        TextField txtStep2FaxNumber = (TextField) findByName("txtStep2FaxNumber", tabs);

        TextArea txtStep3Address = (TextArea) findByName("txtStep3Address", tabs);
        TextArea txtStep3Address2 = (TextArea) findByName("txtStep3Address2", tabs);
        TextField txtStep3City = (TextField) findByName("txtStep3City", tabs);
        TextField txtStep3PhysicalPostalCode = (TextField) findByName("txtStep3PostalCode", tabs);
        //Picker step3Province = (Picker) findByName("step3Province", f);
        //stylePicker(step3Province);
        //step3Province.setType(Display.PICKER_TYPE_STRINGS);
        String[] strProvinces = {"Select Province",
            "Eastern Cape", "Free State", "Gauteng", "Kwazulu Natal", "Limpopo",
            "Mpumlanga", "North West", "Northern Cape", "Western Cape"};
        //step3Province.setStrings(strProvinces);
        //step3Province.setSelectedStringIndex(0);

        TextArea txtStep3PostalAddress = new TextArea();
        TextArea txtStep3PostalAddress2 = new TextArea();
        //Picker step3PostalProvince = new Picker();
        //stylePicker(step3PostalProvince);
        TextField txtStep3PostalCity = new TextField();
        TextField txtStep3PostalPostalCode = new TextField();

        RadioButton rdYes = (RadioButton) findByName("rdYes", tabs);
        RadioButton rdNo = (RadioButton) findByName("rdNo", tabs);

        Container step3PostalCont = (Container) findByName("step3PostalCont", tabs);

        rdNo.addActionListener((ActionListener) (ActionEvent evt) -> {
            boolean isSelected = rdNo.isSelected();
            step3PostalCont.removeAll();

            if (true == isSelected) {

//                step3PostalProvince.setType(Display.PICKER_TYPE_STRINGS);
//                String[] strPostalProvinces = {"Select Province",
//                    "Eastern Cape", "Free State", "Gauteng", "Kwazulu Natal", "Limpopo",
//                    "Mpumlanga", "North West", "Northern Cape", "Western Cape"};
//                step3PostalProvince.setStrings(strPostalProvinces);
//                step3PostalProvince.setSelectedStringIndex(0);
                txtStep3PostalAddress.setName("txtStep3PostalAddress");
                txtStep3PostalAddress2.setName("txtStep3PostalAddress2");
//                step3PostalProvince.setName("step3PostalProvince");
                txtStep3PostalCity.setName("txtStep3PostalCity");
                txtStep3PostalPostalCode.setName("txtStep3PostalPostalCode");

                Container contStep3PostalProvince = new Container(BoxLayout.y());
                contStep3PostalProvince.setUIID("TextFieldNameSearch");
//                step3PostalProvince.setUIID("PickerIcon");
//                contStep3PostalProvince.add(step3PostalProvince);
                txtStep3PostalAddress.setUIID("TextFieldNameSearch");
                txtStep3PostalAddress2.setUIID("TextFieldNameSearch");
                txtStep3PostalCity.setUIID("TextFieldNameSearch");
                txtStep3PostalPostalCode.setUIID("TextFieldNameSearch");

                Label lbl1 = new Label("Postal Address Line 1");
                Label lbl2 = new Label("Postal Address Line 2");
                Label lbl3 = new Label("Postal City");
                Label lbl4 = new Label("Postal Code");

                lbl1.setUIID("LabelRegistration");
                lbl2.setUIID("LabelRegistration");
                lbl3.setUIID("LabelRegistration");
                lbl4.setUIID("LabelRegistration");

                step3PostalCont.add(lbl1).add(txtStep3PostalAddress);
                step3PostalCont.add(lbl2).add(txtStep3PostalAddress2);
                step3PostalCont.add(lbl3).add(txtStep3PostalCity);
                step3PostalCont.add(lbl4).add(txtStep3PostalPostalCode);
                //step3PostalCont.add("").add();

                if (Display.getInstance().isSimulator()) {
                    if (Display.getInstance().isSimulator()) {
                        //step3PostalProvince.setSelectedStringIndex(3);
                        txtStep3PostalAddress.setText("Postal Address");
                        txtStep3PostalCity.setText("Pretoria");
                        txtStep3PostalPostalCode.setText("0001");
                    }
                }

                f.repaint();

            }

        });

        rdYes.addActionListener((ActionListener) (ActionEvent evt) -> {
            boolean isSelected = rdYes.isSelected();

            if (true == isSelected) {
                step3PostalCont.removeAll();
                f.repaint();
            }

        });

        Button btnStep4ViewPasswordRules = (Button) findByName("btnStep4ViewPasswordRules", tabs);
        TextField txtStep4Password = (TextField) findByName("txtStep4Password", tabs);
        TextField txtStep4PasswordRetype = (TextField) findByName("txtStep4PasswordRetype", tabs);

        Toolbar bar = analytics(f, "Registration");

        isTableInputForm(f);

        //initialy false
        btnStep2Continue.setEnabled(false);
        btnStep3Next.setEnabled(false);
        btnStep4Register.setEnabled(false);

        TextField txtStep1IDNumber = (TextField) findByName("txtStep1IDNumber", tabs);

        btnStep1NoID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Dialog.show("ID Number", "The CIPC App is only available to users that have valid South African IDs. ", "Ok", null);
            }
        });

        labelForm = UIManager.getInstance().getComponentStyle("CIPC_DARK");
        labelForm.setMargin(0, 0, 0, 0);
        labelForm.setPadding(0, 0, 0, 0);
        sizeLabel = 6;

        Image img1 = FontImage.createMaterial(FontImage.MATERIAL_PERSON, labelForm, sizeLabel);
        Image img2 = FontImage.createMaterial(FontImage.MATERIAL_EMAIL, labelForm, sizeLabel);
        Image img3 = FontImage.createMaterial(FontImage.MATERIAL_HOME, labelForm, sizeLabel);
        Image img4 = FontImage.createMaterial(FontImage.MATERIAL_SECURITY, labelForm, sizeLabel);

        Button btn1 = new Button("");
        Button btn2 = new Button("");
        Button btn3 = new Button("");
        Button btn4 = new Button("");

        btn1.setUIID("CIPC_DARK_SELECTED");
        btn2.setUIID("CIPC_DARK");
        btn3.setUIID("CIPC_DARK");
        btn4.setUIID("CIPC_DARK");

        btn1.setIcon(img1);
        btn2.setIcon(img2);
        btn3.setIcon(img3);
        btn4.setIcon(img4);

        btnStep1Continue.addActionListener((ActionListener) (ActionEvent evt) -> {
            btnStep1Continue.setEnabled(false);
            PREVTEXT = btnStep1Continue.getText();
            btnStep1Continue.setText("Processing...");
            String msg = "";
            if (txtStep1IDNumber.getText().length() != 13) {
                msg += "Please enter 13 character ID Number. ";
                btnStep1Continue.setEnabled(true);
                btnStep1Continue.setText(PREVTEXT);
                Dialog.show("Error", msg, "Ok", null);

                return;
            }

            //verify id
            User responseUser = u.Get_Cust_code_id_MOBI(txtStep1IDNumber.getText());
            String customer_code = responseUser.getAgent_code();
            String error = responseUser.getError();

            if (customer_code != null && customer_code.length() == 6) {
                msg += "The ID number " + txtStep1IDNumber.getText() + " is already registered with the following Customer Code: " + customer_code;
            }

            if (error != null && error.length() > 0) {
                msg += error;
            }

            if (msg.length() == 0) {
                isRegStep1Passed = true;
                btnStep2Continue.setEnabled(true);
                tabs.setSelectedIndex(1);
                btn1.setUIID("CIPC_DARK");
                btn2.setUIID("CIPC_DARK_SELECTED");
                btn3.setUIID("CIPC_DARK");
                btn4.setUIID("CIPC_DARK");
            } else {
                btnStep1Continue.setEnabled(true);
                btnStep1Continue.setText(PREVTEXT);
                Dialog.show("Error", msg, "Ok", null);
            }

            btnStep1Continue.setEnabled(true);
            btnStep1Continue.setText(PREVTEXT);

        });

        if (Display.getInstance().isSimulator()) {
            //Step 1
            // txtStep1IDNumber.setText("6501045920080"); deceased
            txtStep1IDNumber.setText("9212260612082"); // not registered
            //Step 2
//            pickerCountry.setSelectedStringIndex(1);
            txtStep2FirstName.setText("Blessing");
            txtStep2LastName.setText("Mahlalela");
            txtStep2CellPhone.setText("0763598094");
            txtStep2Email.setText("blessing@mfactory.mobi");
            txtStep2EmailRetype.setText("blessing@mfactory.mobi");
            //Step 3
            //step3Province.setSelectedStringIndex(3);
            txtStep3Address.setText("Address Line 1");
            txtStep3Address2.setText("Address Line 2");
            txtStep3City.setText("Pretoria");
            txtStep3PhysicalPostalCode.setText("0001");
            //Step 4
            txtStep4Password.setText("Password12");
            txtStep4PasswordRetype.setText("Password12");

        }

        btnStep2Continue.addActionListener((ActionListener) (ActionEvent evt) -> {
            PREVTEXT = btnStep2Continue.getText();

            btnStep2Continue.setEnabled(false);
            btnStep2Continue.setText(PROCESSING);

//            Log.p("pickerCountry=" + pickerCountry.getSelectedString(), Log.DEBUG);
            String msg = "";
//            if (pickerCountry.getSelectedString() == null
//                    || pickerCountry.getSelectedStringIndex() == 0
//                    || pickerCountry.getSelectedString().equals("Select Country")) {
//                msg += "Please select a country. ";
//            }

            if (txtStep2FirstName.getText().length() == 0) {
                msg += "Please enter First Name. ";
            }

            if (txtStep2LastName.getText().length() == 0) {
                msg += "Please enter Last Name. ";
            }

            if ((txtStep2CellPhone.getText().length() >= 0 && txtStep2CellPhone.getText().length() != 10)
                    || isCellPhoneValid(txtStep2CellPhone.getText()) == false) {
                msg += "Please enter a valid Cell Phone Number. ";
            }
            if (txtStep2Email.getText().length() == 0 || isEmailValid(txtStep2Email.getText()) == false) {
                msg += "Please enter Email. ";
            } else if (isEmailValid(txtStep2Email.getText()) == false) {
                msg += "Please enter a valid Email Address. ";
            }

            if (txtStep2EmailRetype.getText().length() == 0) {
                msg += "Please retytpe Email. ";
            }

            if (txtStep2Email.getText()
                    .indexOf(txtStep2EmailRetype.getText()) < 0) {
                msg += "Emails are not the same. ";

            }

            if (msg.length() == 0) {

                isRegStep2Passed = true;
                btnStep3Next.setEnabled(true);
                tabs.setSelectedIndex(2);
                btn1.setUIID("CIPC_DARK");
                btn2.setUIID("CIPC_DARK");
                btn3.setUIID("CIPC_DARK_SELECTED");
                btn4.setUIID("CIPC_DARK");
            } else {
                btnStep2Continue.setEnabled(true);
                btnStep2Continue.setText(PREVTEXT);
                Dialog.show("Error", msg, "Ok", null);
            }

            btnStep2Continue.setEnabled(true);
            btnStep2Continue.setText(PREVTEXT);

        });

        btnStep3Next.addActionListener((ActionListener) (ActionEvent evt) -> {
            PREVTEXT = btnStep3Next.getText();
            btnStep3Next.setEnabled(false);
            btnStep3Next.setText(PROCESSING);

            //Log.p("pickerStep3Province=" + step3Province.getSelectedString(), Log.DEBUG);
            String msg = "";
//            if (step3Province.getSelectedString() == null
//                    || step3Province.getSelectedStringIndex() == 0
//                    || step3Province.getSelectedString().equals("Select Province")) {
//                msg += "Please select Physical Province. ";
//            }

            if (txtStep3Address.getText().length() == 0) {
                msg += "Please complete Physical Address Line 1. ";
            }
            if (txtStep3Address2.getText().length() == 0) {
                msg += "Please complete Physical Address Line 2. ";
            }
            if (txtStep3City.getText().length() == 0) {
                msg += "Please complete Physical City. ";
            }

            if (txtStep3PhysicalPostalCode.getText().length() == 0) {
                msg += "Please complete Physical Code. ";
            }

            if (rdNo.isSelected()) {
                //POSTAL VALIDATIONS
//                if (step3PostalProvince.getSelectedString() == null
//                        || step3PostalProvince.getSelectedStringIndex() == 0
//                        || step3PostalProvince.getSelectedString().equals("Select Postal Province")) {
//                    msg += "Please select Postal Province. ";
//                }

                if (txtStep3PostalAddress.getText().length() == 0) {
                    msg += "Please complete Postal Address Line 1. ";
                }
                if (txtStep3PostalAddress2.getText().length() == 0) {
                    msg += "Please complete Postal Address Line 2. ";
                }
                if (txtStep3PostalCity.getText().length() == 0) {
                    msg += "Please complete Postal City. ";
                }

                if (txtStep3PostalPostalCode.getText().length() == 0) {
                    msg += "Please complete Postal Code. ";
                }

            }

            if (msg.length() == 0) {
                isRegStep3Passed = true;
                btnStep4Register.setEnabled(true);
                tabs.setSelectedIndex(3);
                enableincorporator(uws.getTrak_no(), f);
                btn1.setUIID("CIPC_DARK");
                btn2.setUIID("CIPC_DARK");
                btn3.setUIID("CIPC_DARK");
                btn4.setUIID("CIPC_DARK_SELECTED");

            } else {
                btnStep3Next.setEnabled(true);
                btnStep3Next.setText(PREVTEXT);
                Dialog.show("Error", msg, "Ok", null);
            }

            btnStep3Next.setEnabled(true);
            btnStep3Next.setText(PREVTEXT);

        });

        btnStep4Register.addActionListener((ActionListener) (ActionEvent evt) -> {
            PREVTEXT = btnStep4Register.getText();
            btnStep4Register.setEnabled(false);
            btnStep4Register.setText(PROCESSING);
            String msg = "";

            String password = txtStep4Password.getText();
            String passwordRetype = txtStep4PasswordRetype.getText();

            if (txtStep4Password.getText().length() == 0) {
                msg += "Please enter Password. ";
            }
            if (txtStep4PasswordRetype.getText().length() == 0) {
                msg += "Please retype Password. ";
            }
            if (password.indexOf(passwordRetype) < 0) {
                msg += "Passwords are not the same.";

            }

            Utility utility = new Utility();

            String errorResponse = utility.isPasswordValid(password);

            if (errorResponse.length() > 0) {
                msg += errorResponse;
            }

            /*String errorResponseConfirm = utility.isPasswordValid(passwordRetype);

            if (errorResponseConfirm.length() > 0) {
                msg += errorResponseConfirm;
            }*/
            if (msg.length() == 0) {
                Log.p("Success Registration", Log.DEBUG);

                User tmpUser = new User();

                //Step 1: check id if registered with CIPC. if exists show user customer code
                tmpUser.setAgent_id_no(txtStep1IDNumber.getText());

                //step2
                tmpUser.setFirst_name(txtStep2FirstName.getText().trim());
                tmpUser.setLast_name(txtStep2LastName.getText().trim());
                tmpUser.setCell_no(txtStep2CellPhone.getText().trim());
                tmpUser.setEmail(txtStep2Email.getText().trim());
                tmpUser.setTel_code("");
                tmpUser.setTel_no(txtStep2TelephoneNumber.getText().trim());
                tmpUser.setFax_code("");
                tmpUser.setFax_no(txtStep2FaxNumber.getText().trim());

                //step 3
                tmpUser.setPhys_addr1(txtStep3Address.getText().trim());
                tmpUser.setPhys_addr2(txtStep3Address2.getText().trim());
                tmpUser.setPhys_addr3(txtStep3City.getText().trim());
                tmpUser.setPhys_code(txtStep3PhysicalPostalCode.getText().trim());

                if (rdNo.isSelected()) {//only when radio button is selected
                    tmpUser.setPost_addr1(txtStep3PostalAddress.getText().trim());
                    tmpUser.setPost_addr2(txtStep3PostalAddress2.getText().trim());
                    tmpUser.setPost_addr3(txtStep3PostalCity.getText().trim());
                    tmpUser.setPost_code(txtStep3PostalPostalCode.getText().trim());
                } else {
                    //Because address is same as postal
                    tmpUser.setPost_addr1(txtStep3Address.getText().trim());
                    tmpUser.setPost_addr2(txtStep3Address2.getText().trim());
                    tmpUser.setPost_addr3(txtStep3City.getText().trim());
                    tmpUser.setPost_code(txtStep3PhysicalPostalCode.getText().trim());
                }

                //step 4
                tmpUser.setPassword(txtStep4Password.getText());

                //u.get_countries(tmpUser);
                String result = u.ReceiveNewCustData_Reg_MOBI(tmpUser);

                if (result.indexOf("exists") > -1 || result.indexOf("Transaction Rejected") > -1
                        || result.indexOf("Invalid") > -1
                        || result.indexOf("already registered") > -1
                        || result.indexOf("customer code does not") > -1
                        || result.indexOf("Transaction Rejected") > -1
                        || result.indexOf("existing") > -1) {//error
                    btnStep4Register.setEnabled(true);
                    btnStep4Register.setText(PREVTEXT);
                    Dialog.show("Error", result, "Ok", null);
                } else {
                    Dialog.show("Success", result, "Ok", null);
                    showForm("Login", null);
                    isRegStep1Passed = false;
                    isRegStep2Passed = false;
                    isRegStep3Passed = false;
                }

            } else {
                btnStep4Register.setEnabled(true);
                btnStep4Register.setText(PREVTEXT);
                Dialog.show("Error", msg, "Ok", null);
            }

            btnStep4Register.setEnabled(true);
            btnStep4Register.setText(PREVTEXT);

        });

//        btnStep4ViewPasswordRules.addActionListener((ActionListener) (ActionEvent evt) -> {
//
//            String text = "Note that your password must meeting the following. It must be a minimum of 8 characters.\n"
//                    + "At least 1 UPPERCASE letter.\n"
//                    + "At least 1 lowercase letter\n"
//                    + "At least I number\n"
//                    + "Special characters are optional\n"
//                    + "Only these characters are allowed:@,$,=,!,#,%";
//
//            Dialog.show("Password Rules", text, "Ok", null);
//
//            //last validation and actual submission
//        });
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //Log.p("clicked btn1", Log.DEBUG);
                if (isRegStep1Passed == true) {
                    btn1.setUIID("CIPC_DARK_SELECTED");
                    btn2.setUIID("CIPC_DARK");
                    btn3.setUIID("CIPC_DARK");
                    btn4.setUIID("CIPC_DARK");
                }
                isRegStep1Passed = false;
                isRegStep2Passed = false;
                isRegStep3Passed = false;
                tabs.setSelectedIndex(0);
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //Log.p("clicked btn2, isRegStep1Passed=" + isRegStep1Passed
                //   + ", isRegStep2Passed=" + isRegStep2Passed, Log.DEBUG);
                if (isRegStep2Passed == true) {
                    btn1.setUIID("CIPC_DARK");
                    btn2.setUIID("CIPC_DARK_SELECTED");
                    btn3.setUIID("CIPC_DARK");
                    btn4.setUIID("CIPC_DARK");
                }
                isRegStep2Passed = false;
                isRegStep3Passed = false;
                if (isRegStep1Passed == true) {
                    tabs.setSelectedIndex(1);
                } else {
                    checkRegButtonPressed();
                }
            }
        });

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //Log.p("clicked btn3", Log.DEBUG);
                if (isRegStep3Passed == true) {
                    btn1.setUIID("CIPC_DARK");
                    btn2.setUIID("CIPC_DARK");
                    btn3.setUIID("CIPC_DARK_SELECTED");
                    btn4.setUIID("CIPC_DARK");
                }

                isRegStep3Passed = false;
                if (isRegStep1Passed == true && isRegStep2Passed == true) {
                    tabs.setSelectedIndex(2);
                } else {
                    checkRegButtonPressed();
                }
            }
        });

        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //Log.p("clicked btn4", Log.DEBUG);

                if (isRegStep1Passed == true && isRegStep2Passed == true
                        && isRegStep3Passed == true) {
                    tabs.setSelectedIndex(3);
                    enableincorporator(uws.getTrak_no(), f);
                } else {
                    checkRegButtonPressed();
                }
            }
        });

        Container contTop = new Container();
        contTop.setUIID("ContainerWhite");
        contTop.setLayout(new GridLayout(1, 4));
        contTop.add(btn1).add(btn2).add(btn3).add(btn4);

        Container content = (Container) findByName("content", f);
        content.add(BorderLayout.NORTH, contTop);

        tabs.addSelectionListener(new SelectionListener() {
            @Override
            public void selectionChanged(int oldSelected, int newSelected) {

            }
        });

        Container contRadioButtons = (Container) findByName("contRadioButtons", f);

        ButtonGroup btButtonGroup = new ButtonGroup();

        btButtonGroup.add(rdYes);
        btButtonGroup.add(rdNo);

        rdYes.setSelected(true);

        Command b = new Command("") {

            @Override
            public void actionPerformed(ActionEvent evt) {
                super.actionPerformed(evt);
                if (current != null) {
                    current.showBack();
                } else {
                    showForm("Login", null);
                }
            }

        };
        //bar.addCommandToLeftBar(b);

        Command physicalBackButton = new Command("") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                super.actionPerformed(evt); //To change body of generated methods, choose Tools | Templates.

                Log.p("Registration back button", Log.DEBUG);
                if (isRegStep1Passed == false && isRegStep2Passed == false
                        && isRegStep3Passed == false) {//Step 1
                    showLogin(this);
                } else if (isRegStep1Passed == true && isRegStep2Passed == false
                        && isRegStep3Passed == false) {//Step 2
                    tabs.setSelectedIndex(0);
                    btn1.setUIID("CIPC_DARK_SELECTED");
                    btn2.setUIID("CIPC_DARK");
                    btn3.setUIID("CIPC_DARK");
                    btn4.setUIID("CIPC_DARK");
                    isRegStep1Passed = false;
                } else if (isRegStep1Passed == true && isRegStep2Passed == true
                        && isRegStep3Passed == false) {//Step 3
                    tabs.setSelectedIndex(1);
                    btn1.setUIID("CIPC_DARK");
                    btn2.setUIID("CIPC_DARK_SELECTED");
                    btn3.setUIID("CIPC_DARK");
                    btn4.setUIID("CIPC_DARK");
                    isRegStep2Passed = false;
                } else if (isRegStep1Passed == true && isRegStep2Passed == true
                        && isRegStep3Passed == true) {//Step 4
                    tabs.setSelectedIndex(2);
                    btn1.setUIID("CIPC_DARK");
                    btn2.setUIID("CIPC_DARK");
                    btn3.setUIID("CIPC_DARK_SELECTED");
                    btn4.setUIID("CIPC_DARK");
                    isRegStep3Passed = false;
                }

            }

        };

        bar.setBackCommand(physicalBackButton);

    }

    @Override
    protected void beforeForgotPassword(Form f) {

        f.addOrientationListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                updateLayoutRegistration(f, null);

            }
        });

        updateLayoutRegistration(f, null);

        Toolbar bar = analytics(f, "Forgot Password");

        //isTableInputForm(f);
        Command back = new Command("") {

            @Override
            public void actionPerformed(ActionEvent evt) {
                super.actionPerformed(evt);
                current.showBack();
            }

        };
        //bar.addCommandToLeftBar(back);
        bar.setBackCommand(back);
    }

    @Override
    protected void beforeSplash(Form f) {

        String currentAppVersion = Display.getInstance().getProperty("AppVersion", "Unknown");

        Label lblVersion = (Label) findByName("lblVersion", f);
        SpanLabel SpanLabel = (SpanLabel) findByName("SpanLabel", f);
        lblVersion.setText("v" + currentAppVersion);
        lblVersion.repaint();

        if (Display.getInstance().getPlatformName().equals("ios")) {
            lblVersion.setText("");
            SpanLabel.setText("");
        }

    }

    public String getDateNowString() {
        long dateNow = System.currentTimeMillis();
        Date newDate = new Date(dateNow);
        String dateString = new SimpleDateFormat("yyyy-MM-dd_HH").format(newDate);
        return dateString;
    }

    @Override
    protected void postLogin(Form f) {
        height = Display.getInstance().getDisplayHeight();
        width = Display.getInstance().getDisplayWidth();

        Object hasViewedTaCs_Accepted = Storage.getInstance().readObject(KEY_FOR_T_AND_CS_Accepted);

        if (hasViewedTaCs_Accepted == null) {
            Dialog d = (Dialog) createContainer("/theme", "TermsAndConditions");
            Button btnViewTerms = (Button) findByName("btnViewTerms", d);
            btnViewTerms.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {

                    UserWebServices u = new UserWebServices();
                    String url = null;
//                    try{
//                       url =  u.get_terms(null);
//                    }
//                    catch(Exception e){
//                        //do nothing
//                    }

                    if (url == null) {
                        url = "http://139.162.223.194:8080/CIPC2/TermsandConditions_version_Final_3.0.pdf";
                    }

                    //url = "https://drive.google.com/file/d/1XKmFRBcgEn0iY1vV18jRgpbgfXfQbQBy/view?usp=sharing";
                    //url = "https://www.dropbox.com/s/shsokeklu20gwc8/TermsandConditions_version_Final%203.0.pdf?dl=0";
                    FileSystemStorage fs = FileSystemStorage.getInstance();
                    String currentAppVersion = "app_version_" + Display.getInstance().getProperty("AppVersion", "Unknown");
                    String name = "TermsandConditions_version_Final_3.0.pdf";
                    String fileName = fs.getAppHomePath() + "cipcterms" + currentAppVersion + ".pdf";
                    if (!fs.exists(fileName)) {
                        try {
                            Util.downloadUrlToFile(url, fileName, true);

                            if (fs.exists(fileName)) {
                                Display.getInstance().execute(fileName);
                                Storage.getInstance().writeObject(KEY_FOR_T_AND_CS, "Viewed on_" + getDateNowString());

                            } else {
                                Dialog.show("Error", "File is currently not available. Please contact CIPC.", "Ok", null);
                            }
                        } catch (Exception e) {
                            Dialog.show("Error", "File is currently not available. Please contact CIPC.", "Ok", null);
                            //Log.e(e);

                        }
                    } else {
                        Display.getInstance().execute(fileName);
                    }

                }

            });

            CheckBox chkTerms = (CheckBox) findByName("chkTerms", d);
            Button btnAcceptTerms = (Button) findByName("btnAcceptTerms", d);

            btnAcceptTerms.addActionListener(
                    new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {

                    Object hasViewedTaCs = Storage.getInstance().readObject(KEY_FOR_T_AND_CS);

                    if (chkTerms.isSelected()) {
                        Storage.getInstance().writeObject(KEY_FOR_T_AND_CS_Accepted, "Accepted_on_" + getDateNowString());
                        d.dispose();
                    } else if (hasViewedTaCs == null) {
                        Dialog.show("Notice", "Please view CIPC\'s Terms and Conditions. ", "Ok", null);

                    } else if (!chkTerms.isSelected()) {
                        Dialog.show("Notice", "Please accept CIPC\'s Terms and Conditions. ", "Ok", null);
                    }
                }
            }
            );

            Button btnDoNotAccept = (Button) findByName("btnDoNotAccept", d);

            btnDoNotAccept.addActionListener(
                    new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    Display.getInstance().exitApplication();

                }
            }
            );

            d.show();
//                                

        }

        UserWebServices u = new UserWebServices();
        User user = new User();
        String serverVersion = u.get_app_version(user);
        Log.p("serverVersion=" + serverVersion, Log.DEBUG);

        String currentAppVersion = Display.getInstance().getProperty("AppVersion", "Unknown");

        if (serverVersion != null && currentAppVersion != null) {
            double server = Double.parseDouble(serverVersion);
            double device = Double.parseDouble(currentAppVersion);

            Log.p("server=" + server + " device=" + device, Log.DEBUG);

            if (server <= device) {
                Log.p("app version is fine", Log.DEBUG);

            } else {
                Dialog.show("App Version", "The current CIPC App Version is: " + serverVersion + " and "
                        + "your  app version is " + currentAppVersion + " Please update your CIPC App to the latest version in order to use the CIPC App.", "Ok", null);
                Display.getInstance().exitApplication();
                //System.exit(0);

            }
        }

        //Dialog.show("Title", "Body", "Yes", null);
    }

    @Override
    protected boolean onForgotPasswordRequest() {
        String customerCode = findTxtCustomerCode().getText();

        String msg = "";

        if (customerCode.length() == 0) {
            msg += "Enter Customer Code. ";

        }

        customerCode = customerCode.toUpperCase();

        if (msg.length() == 0) {
            UserWebServices u = new UserWebServices();
            String res1 = u.forget_password_MOBI(customerCode);
            //Log.p("res1 len=" + res1.length(), Log.DEBUG);
            if (res1.indexOf("Password was sent via") > -1) {
                Dialog.show("Success", res1, "Ok", null);
                return false;

            } else {
                Dialog.show("Error", res1, "Ok", null);
                return true;

            }

        } else {
            Dialog.show("Error", msg, "Ok", null);
            return true;
        }
    }

    public String getPaymentTransNoFromURL(String url) {
        String paymentTransNo = "";
        String trans = "trans=";

        if (url != null && url.indexOf(trans) > -1) {
            int transIndex = url.indexOf(trans) + 6;
            paymentTransNo = url.substring(transIndex);
        }

        return paymentTransNo;
    }

    public static String getShortEnterpriseName(String year, String body, String type) {
        String entNo = "";
        int yearInt = Integer.parseInt(year);
        if (type.equals("23")) {

            entNo = "B" + year + body;

        } else if (type.equals("06") || type.equals("07") || type.equals("30") || type.equals("08") || type.equals("10") || type.equals("12") || type.equals("21")) {

            if (body.startsWith("0") && yearInt == 2011) {

                entNo = "M" + year + body;

            } else if (yearInt < 2011) {

                entNo = "M" + year + body;

            } else {

                entNo = "K" + year + body;

            }

        }

        return entNo;
    }

    private String RSM_A(String name) {

        name = name.trim();
        name = name.substring(1);
        name = name.substring(0, name.length() - 1);
        return name;
    }

    private static String getRandomString(int numchars) {
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while (sb.length() < numchars) {
            sb.append(Integer.toHexString(r.nextInt()));
        }

        return sb.toString().substring(0, numchars);
    }

    @Override
    protected void setBackCommand(Form f, Command backCommand) {
        super.setBackCommand(f, backCommand); //To change body of generated methods, choose Tools | Templates.

        Log.p("f=" + f.getTitle() + ", backCommand=" + backCommand.getCommandName(), Log.DEBUG);

    }

    @Override
    public void back(Component sourceComponent) {
        super.back(sourceComponent); //To change body of generated methods, choose Tools | Templates.
        Log.p("back=" + sourceComponent.getName(), Log.DEBUG);
    }

    public String getAnnualReturnsDateNow() {
        long dateNow = System.currentTimeMillis();
        Date newDate = new Date(dateNow);
        String dateString = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS").format(newDate);
        dateString = StringUtil.replaceAll(dateString, "_", "T");
        return dateString;
    }

    public static boolean isAlpha(String letters) {
        boolean flag = false;
        for (int i = 0; i < letters.length(); i++) {
            char c = letters.charAt(i);
            if ((c >= 'A' && c <= 'Z')
                    || (c >= 'a' && c <= 'z')) {

                flag = true;

            }
        }

        return flag;
    }

    public static boolean isAlphaNumeric(String letters) {
        boolean flag = true;
        if (letters == null || letters.length() == 0) {
            return true;
        }
        for (int i = 0; i < letters.length(); i++) {

            char c = letters.charAt(i);
            int ci = (int) c;
            //Log.p("c=" + c + " and ci=" + ci, Log.DEBUG);

            if ((ci >= 65 && ci <= 90)
                    || (ci >= 97 && ci <= 122)
                    || (ci >= 48 && ci <= 57)
                    || (c == 32)) {
                //do nothing
            } else {
                flag = false;
            }

        }

        return flag;
    }

    private void Hide_Director_Fields(Form f) {
        Container condirinfo = (Container) findByName("Condirinfo", f);
        condirinfo.setHidden(true);
        Container conregister = (Container) findByName("Conregister", f);
        conregister.setHidden(true);
        Container conaddDirector = (Container) findByName("ConaddDirector", f);
        conaddDirector.setHidden(true);
//        Table tbl = (Table) findByName("Tablememinfo", f);
        //       tbl.setHidden(false);
//        Container Containermem = (Container) findByName("Containermem", f);
//        Containermem.setHidden(false);

        f.repaint();
    }

    private void Show_Director_Fields(Form f) {
        Container condirinfo = (Container) findByName("Condirinfo", f);
        condirinfo.setHidden(false);
        Container conaddDirector = (Container) findByName("ConaddDirector", f);
        conaddDirector.setHidden(false);
        //ConaddDirector
//        Container conappointdate = (Container) findByName("ConAppointDate", f);
//        //Container contdateofbirth = (Container) findByName("ContDateofBirth", f);
//        Container concell = (Container) findByName("ConCell", f);
//        Container conemail = (Container) findByName("ConEmail", f);
//        Container conphysaddress = (Container) findByName("ConPhysAddress", f);
//        Container conpostaladdress = (Container) findByName("ConPostalAddress", f);
//        conappointdate.setVisible(true);
//        conappointdate.setHidden(false);
//        //contdateofbirth.setVisible(true);
//        concell.setVisible(true);
//        concell.setHidden(false);
//        conemail.setVisible(true);
//        conemail.setHidden(false);
//        conphysaddress.setVisible(true);
//        conphysaddress.setHidden(false);
//        conpostaladdress.setVisible(true);
//        conpostaladdress.setHidden(false);
        f.repaint();
    }

    public static String changeComma(String s) {
        String original = s.substring(0, s.length() - 3);
        s = s.substring(s.length() - 3, s.length());
        if (s.indexOf(",") > -1) {
            s = StringUtil.replaceAll(s, ",", ".");
        }
        s = original + s;
        return s;
    }

    protected void onFrmtest_ButtonAction(Component c, ActionEvent event) {

        Dialog.show("Error", "Error occurred while processing your request. Please contact CIPC.", "Ok", null);
    }

    protected void onFrmNewEntReg1_BtnStartNewRegAction(Component c, ActionEvent event) {

        Form f = c.getComponentForm();
//        CheckBox CHB = (CheckBox) findByName("ChkBApprovedName", f);
//        CHB.setSelected(false);
//        CheckBox RDB = (CheckBox) findByName("ChBSubmitNameReservation", f);
//        RDB.setSelected(false);

        uws.setIsnamereserved(false);
        uws.setInfo_Allowed(true);
        uws.setNames_Allowed(false);
        uws.setEnterprise_Allowed(false);
        uws.setDirectors_Allowed(false);
        uws.setName_reservation_no("");
        uws.setTrak_no("");
        Tabs tabs = (Tabs) findByName("Tabs", f);
        tabs.setSwipeActivated(false);
        tabs.hideTabs();
        f.setTitle("Enterprise Details");
        Label lblname_no = (Label) findByName("LbLNameResNo", f);
        lblname_no.setText("No Name attached to new registration.");
        tabs.setSelectedIndex(2);
        //Container conttop = (Container) findByName("conttop", f);
    }

    @Override
    protected void beforeFrmNewEntReg1(Form f) {
        Tabs tabs = (Tabs) findByName("Tabs", f);
        tabs.setSwipeActivated(false);
        tabs.hideTabs();
        Container cond = (Container) findByName("Containerd", f);
        cond.setHidden(false);
//        //################
        Style labelForm = UIManager.getInstance().getComponentStyle("CIPC_DARK");
        labelForm.setMargin(0, 0, 0, 0);
        labelForm.setPadding(0, 0, 0, 0);
        int sizeLabel = 6;
//        
        Image img1 = FontImage.createMaterial(FontImage.MATERIAL_PERSON, labelForm, sizeLabel);
        Image img2 = FontImage.createMaterial(FontImage.MATERIAL_ACCESS_TIME, labelForm, sizeLabel);
        Image img3 = FontImage.createMaterial(FontImage.MATERIAL_ASSESSMENT, labelForm, sizeLabel);
        Image img4 = FontImage.createMaterial(FontImage.MATERIAL_INFO, labelForm, sizeLabel);
//
        Button btnnr1 = new Button("");
        Button btnnr2 = new Button("");
        Button btnnr3 = new Button("");
        Button btnnr4 = new Button("");
//

//
        btnnr1.setIcon(img4);
        btnnr2.setIcon(img2);
        btnnr3.setIcon(img3);
        btnnr4.setIcon(img1);
//        //################

        //      Button btn1 = new Button("Info");
        //btn1.setName("btn1");
        //String x = btn1.getName();
//        Button btn2 = new Button("Name");
        //      Button btn3 = new Button("CO Detail");
        //     Button btn4 = new Button("Dir");
        btnnr1.setUIID("CIPC_DARK_SELECTED");
        btnnr2.setUIID("CIPC_DARK");
        btnnr3.setUIID("CIPC_DARK");
        btnnr4.setUIID("CIPC_DARK");
        uws.setIsnamereserved(false);
        uws.setIsnamefiled(false);
        uws.setInfo_Allowed(true);
        uws.setNames_Allowed(true);
        uws.setEnterprise_Allowed(false);
        uws.setDirectors_Allowed(false);
        Hide_Director_Fields(f);
        Picker dtpic = (Picker) findByName("dtAppDate", f);
        //   dtpic.setType(Display.PICKER_TYPE_CALENDAR);
        //.PICKER_TYPE_DATE);
        Date now = new Date();

        dtpic.setDate(now);

//        Container connameres = (Container) findByName("ConNameres", f);
//        connameres.setVisible(false);
//        connameres.repaint();
        btnnr1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //Log.p("clicked btn1", Log.DEBUG);
                f.setTitle("New Registration. ");
                if (uws.isInfo_Allowed() == true) {
                    //clear Names
                    uws.setIsnamereserved(false);
                    uws.setIsnamefiled(false);
                    uws.setInfo_Allowed(true);
                    uws.setNames_Allowed(true);
                    uws.setEnterprise_Allowed(false);
                    uws.setDirectors_Allowed(false);
                    //
                    f.setTitle("New Registration. ");
                    tabs.setSelectedIndex(0);
                    btnnr1.setUIID("CIPC_DARK_SELECTED");
                    btnnr2.setUIID("CIPC_DARK");
                    btnnr3.setUIID("CIPC_DARK");
                    btnnr4.setUIID("CIPC_DARK");
                } else {
                    if (uws.isDirectors_Allowed() == true) {
                        String msg = "Please complete capturing of all directors and submit current transactions first before you can start a new transaction.";
                        Dialog.show("Error", msg, "Ok", null);
                    }
                    if (uws.isEnterprise_Allowed() == true) {
                        String msg = "Please complete capturing of all enterprise details and submit current transactions first before you can start a new transaction.";
                        Dialog.show("Error", msg, "Ok", null);
                    }
                    //checkRegButtonPressed();
                    //String msg = "Please complete current transaction with name that was submitted for approval. You can't go back now.";
                    //Dialog.show("Error", msg, "Ok", null);
                }
            }
        });

        btnnr2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //Log.p("clicked btn2, isRegStep1Passed=" + isRegStep1Passed
                //   + ", isRegStep2Passed=" + isRegStep2Passed, Log.DEBUG);
                if (uws.isNames_Allowed() == true) {
                    f.setTitle("File Name Reservation");
                    tabs.setSelectedIndex(1);
                    btnnr1.setUIID("CIPC_DARK");
                    btnnr2.setUIID("CIPC_DARK_SELECTED");
                    btnnr3.setUIID("CIPC_DARK");
                    btnnr4.setUIID("CIPC_DARK");
                } else {
                    if (uws.isEnterprise_Allowed() == true) {
                        String msg = "Please complete capturing of all Enterprise details and Director details and submit current transactions first before you can start a new transaction.";
                        Dialog.show("Error", msg, "Ok", null);
                    }
                    if (uws.isDirectors_Allowed() == true) {
                        String msg = "Please complete capturing of all directors details and submit current transactions first before you can start a new transaction.";
                        Dialog.show("Error", msg, "Ok", null);
                    }
                    //checkRegButtonPressed();
                    //String msg = "You are not allowed to file a name reservation at this time of th eprocess. Please complete current transaction first.";
                    //Dialog.show("Error", msg, "Ok", null);
                    //return;
                };
//                if (uws.isInfo_Allowed() == false) {
//                    String msg = "Please complete current transaction with name that was submitted for approval. You can't go back now.";
//                    Dialog.show("Error", msg, "Ok", null);
//                    return;
//                }
//                if (uws.isIsRegStep1Passed() == true) {
//                    f.setTitle("File Name Reservation");
//                    tabs.setSelectedIndex(1);
//                    btn1.setUIID("Button");
//                    // btn2.setUIID("btnselected");
//                    btn3.setUIID("Button");
//                    btn4.setUIID("Button");
//                } else {
//                    checkRegButtonPressed();
//                }

            }
        });

        btnnr3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //Log.p("clicked btn3", Log.DEBUG);
                //if (isnamereserved == true || isRegStep2Passed == true) {
                if (uws.isEnterprise_Allowed() == true) {
                    f.setTitle("Enterprise Details");
                    tabs.setSelectedIndex(2);
                    btnnr1.setUIID("CIPC_DARK");
                    btnnr2.setUIID("CIPC_DARK");
                    btnnr3.setUIID("CIPC_DARK_SELECTED");
                    btnnr4.setUIID("CIPC_DARK");
                } else {
                    if (uws.isDirectors_Allowed() == true) {
                        String msg = "Please complete capturing of all directors details and submit current transactions. You can't change the enterprise detail now it was already submitted.";
                        Dialog.show("Error", msg, "Ok", null);
                    }
                    if (uws.isNames_Allowed() == true) {
                        String msg = "You selected to reserve a name with the application. Please complete the name reservation or select to continue with no name from Info.";
                        Dialog.show("Error", msg, "Ok", null);
                    }
                    //   checkRegButtonPressed();
                }
            }
        });

        btnnr4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //Log.p("clicked btn4", Log.DEBUG);
//                if (isnamereserved == true && isRegStep2Passed == true
//                        && isRegStep3Passed == true) {
                if (uws.isDirectors_Allowed() == true) {
                    f.setTitle("Director Details");
                    tabs.setSelectedIndex(3);
                    enableincorporator(uws.getTrak_no(), f);
                    btnnr1.setUIID("CIPC_DARK");
                    btnnr2.setUIID("CIPC_DARK");
                    btnnr3.setUIID("CIPC_DARK");
                    btnnr4.setUIID("CIPC_DARK_SELECTED");

                } else {
                    if (uws.isEnterprise_Allowed() == true) {
                        String msg = "Please complete capturing of all enterprise details before you can continue to capture directors details.";
                        Dialog.show("Error", msg, "Ok", null);
                        return;
                    }
                    if (uws.isNames_Allowed() == true) {
                        String msg = "You selected to reserve a name with the application. Please complete the name reservation or select to continue with no name from Info.";
                        Dialog.show("Error", msg, "Ok", null);
                        return;
                    } else {
                        String msg = "Please select an option from the Info tab to continue.";
                        Dialog.show("Error", msg, "Ok", null);
                    }
//                    checkRegButtonPressed();
                }

            }
        });
        TextField txtotp = (TextField) findByName("TxtOtp", f);
        txtotp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //Log.p("clicked btn4", Log.DEBUG);
//                if (isnamereserved == true && isRegStep2Passed == true
//                        && isRegStep3Passed == true) {
                if (txtotp.getText().trim().equals(uws.getOTP().toString())) {
                    f.setTitle("Director Details");
                    //tabs.setSelectedIndex(3);
                    //txtotp.setUIID("TextFieldcorrect");
                    txtotp.setUIID("TextFieldNameSearchcorrect");
                    txtotp.repaint();

                    // btn4.setUIID("btnselected");
                } else {
                    //txtotp.setUIID("TextFieldwrong");
                    txtotp.setUIID("TextFieldNameSearcherror");

                    //checkRegButtonPressed();
                    Dialog.show("Invalid OTP", "Please enter a Valid OTP", "OK", null);
                    //txtotp.requestFocus();
                }

            }
        });

//        txtotp.addActionListener((ActionListener) (ActionEvent evt) -> {
//            //Log.p("clicked btn4", Log.DEBUG);
////                if (isnamereserved == true && isRegStep2Passed == true
////                        && isRegStep3Passed == true) {
//           
//        });
//#########################
//       Container contTop = new Container();
//        contTop.setUIID("ContainerWhite");
//        contProjects.setUIID("ContainerWhite");
//        contTop.setLayout(new GridLayout(1, 4));
//        contTop.add(btn1).add(btn2).add(btn3).add(btn4);
//
//        Container border = new Container(new BorderLayout());
//        border.setUIID("ContainerWhite");
//
//        border.add(BorderLayout.NORTH, contTop);
//
//        border.add(BorderLayout.CENTER, contProjects);
//#########################
        Container contTop = new Container();
        contTop.setUIID("ContainerWhite");
        contTop.setLayout(new GridLayout(1, 4));
        contTop.add(btnnr1).add(btnnr2).add(btnnr3).add(btnnr4);
//        Container border = new Container(new BorderLayout());
//        border.setUIID("ContainerWhite");
//        border.add(BorderLayout.NORTH, contTop);       
        btnnr1.setUIID("CIPC_DARK_SELECTED");
        btnnr2.setUIID("CIPC_DARK");
        btnnr3.setUIID("CIPC_DARK");
        btnnr4.setUIID("CIPC_DARK");
        f.add(BorderLayout.NORTH, contTop);
        //f.add(border);

        tabs.addSelectionListener(new SelectionListener() {
            @Override
            public void selectionChanged(int oldSelected, int newSelected) {
                if (newSelected == 0) {
                    btnnr1.setUIID("CIPC_DARK_SELECTED");
                    btnnr2.setUIID("CIPC_DARK");
                    btnnr3.setUIID("CIPC_DARK");
                    btnnr4.setUIID("CIPC_DARK");;
                }
                if (newSelected == 1) {
                    btnnr1.setUIID("CIPC_DARK");
                    btnnr2.setUIID("CIPC_DARK_SELECTED");
                    btnnr3.setUIID("CIPC_DARK");
                    btnnr4.setUIID("CIPC_DARK");;
                }

                if (newSelected == 2) {
                    btnnr1.setUIID("CIPC_DARK");
                    btnnr2.setUIID("CIPC_DARK");
                    btnnr3.setUIID("CIPC_DARK_SELECTED");
                    btnnr4.setUIID("CIPC_DARK");;
                }
                if (newSelected == 3) {
                    btnnr1.setUIID("CIPC_DARK");
                    btnnr2.setUIID("CIPC_DARK");
                    btnnr3.setUIID("CIPC_DARK");
                    btnnr4.setUIID("CIPC_DARK_SELECTED");;
                }
            }
        }
        );
//        TextField tx1 = (TextField) findByName("TxtApprovedNo", f);
//        tx1.setVisible(false);
//        tx1.repaint();
//        Button cmd = (Button) findByName("BtnStartNewReg", f);
//        cmd.setVisible(false);
//        cmd.repaint();
//                Container coninfo = (Container) findByName("ConInfo",tabs);
//                Container conApprovedname = (Container) findByName("ConApprovedName", coninfo);
//                Log.p (conApprovedname.getName(),Log.DEBUG);
//                //conApprovedname.setHidden(true);
//                conApprovedname.setVisible(false);
//                //conApprovedname.getParent().animateLayout(200);
//                conApprovedname.repaint();
    }

    protected void onFrmNewEntReg1_BtnFileNamereservationAction(Component c, ActionEvent event) {
        uws.setIsnamereserved(false);
        uws.setInfo_Allowed(true);
        uws.setNames_Allowed(true);
        uws.setEnterprise_Allowed(false);
        uws.setDirectors_Allowed(false);
        Form f = c.getComponentForm();
        Tabs tabs = (Tabs) findByName("Tabs", f);
        tabs.setSwipeActivated(false);
        tabs.hideTabs();
        f.setTitle("File Name Reservation");
        tabs.setSelectedIndex(1);

    }

    @Override
    protected void onFrmNewEntReg1_BtnvalnoAction(Component c, ActionEvent event) {
        Form f = c.getComponentForm();
        TextField txt1 = (TextField) findByName("TxtApprovedNo", f);
        String approvedname = "";
        String errdesc = "";
        String reserved_no = "";
        String TXTVAL = txt1.getText();
        Tabs tabs = (Tabs) findByName("Tabs", f);
        tabs.setSwipeActivated(false);
        tabs.hideTabs();
        if (TXTVAL.length() > 8) {
            Log.p("in" + txt1, Log.DEBUG);
            Dialog ip = new InfiniteProgress().showInifiniteBlocking();
            Result result = uws.ReservedName_Name_Mobi(AGENT_CODE, txt1.getText());
            uws.ReservedName(result);

            ip.dispose();
            for (int i = 0; i < uws.getArlNameReserved().size(); i++) {
                NameReserved nr = uws.ArlNameReserved.get(i);
                approvedname = nr.ApprovedName;
                errdesc = nr.Error_Desc;
                reserved_no = nr.Reserved_NO;
            }
            Log.p("in2" + txt1, Log.DEBUG);
            //Log.p (approvedname, Log.DEBUG);

            if ("Err".equals(errdesc.substring(2, 5))) {
                Dialog.show("Error", errdesc, "OK", null);
                return;
            } else {

                Label lblname_no = (Label) findByName("LbLNameResNo", f);
                uws.setName_reservation_no(RSM_A(reserved_no));
                lblname_no.setText("Name Reservation NO. " + RSM_A(reserved_no));
                uws.setIsnamereserved(true);
                uws.setIsnamefiled(false);
                uws.setNames_Allowed(false);
                uws.setInfo_Allowed(false);
                uws.setEnterprise_Allowed(true);
                uws.setDirectors_Allowed(false);
                //f.setTitle("Enterprise Details");
                f.setTitle("Enterprise Details");
                tabs.setSelectedIndex(2);
            }
        } else {
            uws.setIsnamereserved(false);
            uws.setInfo_Allowed(true);
            uws.setNames_Allowed(true);
            uws.setEnterprise_Allowed(false);
            uws.setDirectors_Allowed(false);
            tabs.setSelectedIndex(0);
//            Button cmd = (Button) findByName("BtnStartNewReg", f);
//            cmd.setVisible(false);
//            cmd.repaint();
            Dialog.show("Error", "Invalid Name reservation Number.", "OK", null);

        }

    }

    protected void onFrmNewEntReg1_BtnTestNamesAction(Component c, ActionEvent event) {

        Form f = c.getComponentForm();
        Container contTest = (Container) findByName("Con4Names", c);
        //Container contTasks = (Container) createContainer("/theme", "Con4Names");
        String name1 = findTxtname1().getText();
        String name2 = findTxtname2().getText();
        String name3 = findTxtname3().getText();
        String name4 = findTxtname4().getText();
        TextField txtname1 = (TextField) findByName("Txtname1", f);
        if (txtname1.getText().trim().equals("")) {
            Dialog.show("Error", "Please enter a valid Name in line 1", "OK", null);
            //TextField txtname1 = (TextField) findByName("Txtname1", f);
            txtname1.requestFocus();
            txtname1.startEditing();
            return;
        }
        ArrayList<NameSearchObject> arrayList = uws.search_name_MOBI(AGENT_CODE, name1, name2, name3, name4);
        for (int i = 0; i < 4; i++) {
            int count = i + 1;
            Label lblResponse = (Label) findByName("lblName" + count + "Response", contTest);
            lblResponse.setText("");
        }
        for (int i = 0; i < arrayList.size(); i++) {
            int count = i + 1;
            Label lblResponse = (Label) findByName("lblName" + count + "Response", contTest);
            NameSearchObject n = arrayList.get(i);
            lblResponse.setText("");
            if (n.isIsValid()) {
                lblResponse.setText("Might be available");
                lblResponse.setUIID("LabelGreen");
                lblResponse.repaint();
                c.repaint();
                f.repaint();
            } else {
                lblResponse.setText("Is not available");
                lblResponse.setUIID("LabelRed");
                lblResponse.repaint();
                c.repaint();
                f.repaint();
            }
        }
        f.repaint();
        contTest.repaint();
    }

    protected void onFrmNewEntReg1_BtnFileNameAction(Component c, ActionEvent event) {
UserWebServices u = new UserWebServices();
        Form f = c.getComponentForm();
        String name1 = findTxtname1().getText();
        String name2 = findTxtname2().getText();
        String name3 = findTxtname3().getText();
        String name4 = findTxtname4().getText();
        TextField txtname1 = (TextField) findByName("Txtname1", f);
        if (txtname1.getText().trim().equals("")) {
            Dialog.show("Error", "Please enter a valid Name in line 1", "OK", null);
            //TextField txtname1 = (TextField) findByName("Txtname1", f);
            txtname1.requestFocus();
            txtname1.startEditing();
            return;
        }
        // UserWebServicesNewReg u = new UserWebServicesNewReg();
        //String responseCall = Namereservation_MOBI(uws.getAgent_code(), name1, name2, name3, name4);
        //String responseCall = uws.Namereservation_MOBI(uws.getAgent_code(), name1, name2, name3, name4);
        String responseCall = uws.Namereservation_MOBI(AGENT_CODE, name1, name2, name3, name4);

        if ("|".equals(responseCall.substring(0, 1))) {
            responseCall = uws.RSM_1(responseCall);
        } else {
            StringTokenizer token = new StringTokenizer(responseCall, "|");
            uws.setName_reservation_no(token.nextToken());
            responseCall = token.nextToken();
        }

        if (responseCall != null && responseCall.length() > 0
                && responseCall.indexOf("already filed") == -1) {
            Dialog.show("Success", responseCall, "Ok", null);
               u.insertCartItemServiceName(uws.getName_reservation_no(), AGENT_CODE, "50");
            uws.setIsnamereserved(false);
            uws.setIsnamefiled(true);
            Label lblname_no = (Label) findByName("LbLNameResNo", f);
            lblname_no.setText("Name Reservation No. " + uws.getName_reservation_no());
            Tabs tabs = (Tabs) findByName("Tabs", f);
            f.setTitle("Enterprise Details");
           
            tabs.setSelectedIndex(2);

        } else if (responseCall != null && responseCall.length() > 0
                && responseCall.indexOf("already filed") != -1) {
            Dialog.show("Error", responseCall, "Ok", null);//TODO scroll to top
        } else {
            Dialog.show("Error", "Error occurred while processing your request. Please try again later or contact CIPC.", "Ok", null);
        }
    }

    @Override
    protected void onFrmNewEntReg1_BtncopyphysicaladdressAction(Component c, ActionEvent event) {
        Form f = c.getComponentForm();
//        CheckBox chbsame = (CheckBox) findByName("ChbIssameasPhys", f);
//        if (chbsame.isSelected()) {
        TextField txtpostaladdr1 = (TextField) findByName("TxtPostaladdr1", f);
        TextField txtpostaladdr2 = (TextField) findByName("TxtPostaladdr2", f);
        TextField txtpostaladdr3 = (TextField) findByName("TxtPostaladdr3", f);
        ComboBox cmbentpostalpr = (ComboBox) findByName("CmbEntPostalPr", f);
        TextField TxtentPostalcode = (TextField) findByName("TxtentPostalcode", f);
        TextField txtphysaddr1 = (TextField) findByName("txtEntPhysAddr1", f);
        txtpostaladdr1.setText(txtphysaddr1.getText().toString());
        TextField txtphysaddr2 = (TextField) findByName("txtEntPhysAddr2", f);
        txtpostaladdr2.setText(txtphysaddr2.getText().toString());
        TextField txtphysaddr3 = (TextField) findByName("txtEntPhysAddr3", f);
        txtpostaladdr3.setText(txtphysaddr3.getText().toString());
        TextField txtphyscode = (TextField) findByName("txtEntPhysCode", f);
        TxtentPostalcode.setText(txtphyscode.getText().toString());
        Button btnreg = (Button) findByName("Buttoncondir", c);
        //btnreg.setFocusable(true);
        btnreg.requestFocus();
        //  ComboBox CmbPhysProvince = (ComboBox) findByName("CmbEntPhysProvince", f);
        //  cmbentpostalpr.setSelectedIndex(CmbPhysProvince.getSelectedIndex());
//        } else {
//            TextField txtpostaladdr1 = (TextField) findByName("TxtPostaladdr1", f);
//            TextField txtpostaladdr2 = (TextField) findByName("TxtPostaladdr2", f);
//            TextField txtpostaladdr3 = (TextField) findByName("TxtPostaladdr3", f);
//            ComboBox cmbentpostalpr = (ComboBox) findByName("CmbEntPostalPr", f);
//            TextField txtpostalcode = (TextField) findByName("TxtPostalcode", f);
//            //TextField txtphysaddr1 = (TextField) findByName("txtPhysAddr1", f);
//            txtpostaladdr1.setText("");
//            //TextField txtphysaddr2 = (TextField) findByName("txtPhysAddr2", f);
//            txtpostaladdr2.setText("");
//            //TextField txtphysaddr3 = (TextField) findByName("txtPhysAddr3", f);
//            txtpostaladdr3.setText("");
//            //TextField txtphyscode = (TextField) findByName("txtPhysCode", f);
//            txtpostalcode.setText("");
//            //ComboBox CmbPhysProvince = (ComboBox) findByName("CmbPhysProvince", f);
//            cmbentpostalpr.setSelectedIndex(0);
        // }
    }

    protected boolean validentdata(Component c) {
        try {
            EnterpriseDetails enterprisedetails = new EnterpriseDetails();

            Form f = c.getComponentForm();
            TextField TxtAuthShares = (TextField) findByName("TxtAuthShares", f);
            //##########
            if (TxtAuthShares.getText().trim().equals("")) {
                Dialog.show("Error", "Please enter a valid number of shares.", "OK", null);
                TxtAuthShares.repaint();
                TxtAuthShares.requestFocus();
                TxtAuthShares.startEditing();
                return false;
            }
            enterprisedetails.setShares(TxtAuthShares.getText().trim());
            TextField TxtEntEmail = (TextField) findByName("TxtEntEmail", f);
            //##########
            if (TxtEntEmail.getText().trim().equals("")) {
                Dialog.show("Error", "Please enter a valid E-Mail.", "OK", null);
                TxtEntEmail.repaint();
                TxtEntEmail.requestFocus();
                TxtEntEmail.startEditing();
                return false;
            }
            if (isEmailValid(TxtEntEmail.getText().trim()) == false) {
                Dialog.show("Error", "Please enter a valid E-Mail format.", "OK", null);
                TxtEntEmail.repaint();
                TxtEntEmail.requestFocus();
                TxtEntEmail.startEditing();
                return false;
            }
            enterprisedetails.setMail(TxtEntEmail.getText().trim());
            TextField txtphysaddr1 = (TextField) findByName("txtEntPhysAddr1", f);
            //##########
            if (txtphysaddr1.getText().trim().equals("")) {
                Dialog.show("Error", "Please enter a valid physical address line 1.", "OK", null);
                txtphysaddr1.repaint();
                txtphysaddr1.requestFocus();
                txtphysaddr1.startEditing();
                return false;
            }
            enterprisedetails.setPhysaddr1(txtphysaddr1.getText().trim());
            TextField txtphysaddr2 = (TextField) findByName("txtEntPhysAddr2", f);
            //##########
            if (txtphysaddr2.getText().trim().equals("")) {
                Dialog.show("Error", "Please enter a valid physical address line 2.", "OK", null);
                txtphysaddr2.repaint();
                txtphysaddr2.requestFocus();
                txtphysaddr2.startEditing();
                return false;
            }
            enterprisedetails.setPhysaddr2(txtphysaddr2.getText().trim());
            TextField txtphysaddr3 = (TextField) findByName("txtEntPhysAddr3", f);
            //##########
            if (txtphysaddr3.getText().trim().equals("")) {
                Dialog.show("Error", "Please enter a valid physical address line 3.", "OK", null);
                txtphysaddr3.repaint();
                txtphysaddr3.requestFocus();
                txtphysaddr3.startEditing();
                return false;
            }
            enterprisedetails.setPhysaddr3(txtphysaddr3.getText().trim());

            //Cmbenttype
            ComboBox cmbenttype = (ComboBox) findByName("Cmbenttype", f);
            String ent_type_code = "";
            if (cmbenttype.getSelectedItem().toString().equals("Private Company")) {
                ent_type_code = "07";
            }
            enterprisedetails.setEnt_type_code(ent_type_code);

//            ComboBox CmbPhysProvince = (ComboBox) findByName("CmbEntPhysProvince", f);
//            if (CmbPhysProvince.getSelectedItem().toString().equals("Select Province")) {
//                Dialog.show("Error", "Please enter a valid province for physical address.", "OK", null);
//                CmbPhysProvince.repaint();
//                CmbPhysProvince.requestFocus();
//                
//                return false;
//            }
            //  enterprisedetails.setPhysaddr4(CmbPhysProvince.getSelectedItem().toString());
            TextField txtphyscode = (TextField) findByName("txtEntPhysCode", f);
            //##########
            if (txtphyscode.getText().trim().equals("")) {
                Dialog.show("Error", "Please enter a valid physical address code.", "OK", null);
                txtphyscode.repaint();
                txtphyscode.requestFocus();
                txtphyscode.startEditing();
                return false;
            }
            enterprisedetails.setPhyscode(txtphyscode.getText().trim());
            TextField txtpostaladdr1 = (TextField) findByName("TxtPostaladdr1", f);
            //##########
            if (txtpostaladdr1.getText().trim().equals("")) {
                Dialog.show("Error", "Please enter a valid postal address line 1.", "OK", null);
                txtpostaladdr1.repaint();
                txtpostaladdr1.requestFocus();
                txtpostaladdr1.startEditing();
                return false;
            }
            enterprisedetails.setPostaladdr1(txtpostaladdr1.getText().trim());
            TextField txtpostaladdr2 = (TextField) findByName("TxtPostaladdr2", f);
            //##########
            if (txtpostaladdr2.getText().trim().equals("")) {
                Dialog.show("Error", "Please enter a valid postal address line 2.", "OK", null);
                txtpostaladdr2.repaint();
                txtpostaladdr2.requestFocus();
                txtpostaladdr2.startEditing();
                return false;
            }
            enterprisedetails.setPostaladdr2(txtpostaladdr2.getText().trim());
            TextField txtpostaladdr3 = (TextField) findByName("TxtPostaladdr3", f);
            //##########
            if (txtpostaladdr3.getText().trim().equals("")) {
                Dialog.show("Error", "Please enter a valid postal address line 3.", "OK", null);
                txtpostaladdr3.repaint();
                txtpostaladdr3.requestFocus();
                txtpostaladdr3.startEditing();
                return false;
            }
            enterprisedetails.setPostaladdr3(txtpostaladdr3.getText().trim());
//            ComboBox cmbentpostalpr = (ComboBox) findByName("CmbEntPostalPr", f);
//            if (cmbentpostalpr.getSelectedItem().toString().equals("Select Province")) {
//                Dialog.show("Error", "Please enter a valid province for postal address.", "OK", null);
//                cmbentpostalpr.repaint();
//                cmbentpostalpr.requestFocus();
//                return false;
//            }
            //enterprisedetails.setPostaladdr4(cmbentpostalpr.getSelectedItem().toString());

            TextField txtentpostalcode = (TextField) findByName("TxtentPostalcode", f);
            //##########
            if (txtentpostalcode.getText().trim().equals("")) {
                Dialog.show("Error", "Please enter a valid postal address code.", "OK", null);
                txtentpostalcode.repaint();
                txtentpostalcode.requestFocus();
                txtentpostalcode.startEditing();
                return false;
            }
            enterprisedetails.setPostalcode(txtentpostalcode.getText().trim());
            //CmbFyeMonth
            ComboBox cmbfyemonth = (ComboBox) findByName("CmbFyeMonth", f);
            String FYE = "";
            if (cmbfyemonth.getSelectedItem().toString().equals("January")) {
                FYE = "1";
            }
            if (cmbfyemonth.getSelectedItem().toString().equals("February")) {
                FYE = "2";
            }
            if (cmbfyemonth.getSelectedItem().toString().equals("March")) {
                FYE = "3";
            }
            if (cmbfyemonth.getSelectedItem().toString().equals("April")) {
                FYE = "4";
            }
            if (cmbfyemonth.getSelectedItem().toString().equals("May")) {
                FYE = "5";
            }
            if (cmbfyemonth.getSelectedItem().toString().equals("June")) {
                FYE = "6";
            }
            if (cmbfyemonth.getSelectedItem().toString().equals("July")) {
                FYE = "7";
            }
            if (cmbfyemonth.getSelectedItem().toString().equals("August")) {
                FYE = "8";
            }
            if (cmbfyemonth.getSelectedItem().toString().equals("September")) {
                FYE = "9";
            }
            if (cmbfyemonth.getSelectedItem().toString().equals("October")) {
                FYE = "10";
            }
            if (cmbfyemonth.getSelectedItem().toString().equals("November")) {
                FYE = "11";
            }
            if (cmbfyemonth.getSelectedItem().toString().equals("December")) {
                FYE = "12";
            }
            enterprisedetails.setFYE(FYE);
            enterprisedetails.setCust_code(AGENT_CODE);
//            uws.enterprisedetails.setTrak_no(FYE);
            Result rs = uws.AddEnterprise(enterprisedetails);
            String Response = rs.getAsString("//ReceiveNewEntDataResult");
            if (Response == "") {
                return true;
            } else {//        if (Response != null) {
                Dialog.show("Error", Response, "OK", null);
                return false;
            }

        } catch (IllegalArgumentException e) {
            return false;
        }

        //return true;
    }

    public void scanCanceled_death() {
        System.out.println("cancelled");
        Dialog.show("Scan Cancelled", "According to DHA this person is Diseased.", "Ok", null);
    }

    protected void onFrmNewEntReg1_ButtonAction(Component c, ActionEvent event) {
        if (validentdata(c)) {
            uws.setInfo_Allowed(false);
            uws.setNames_Allowed(false);
            uws.setEnterprise_Allowed(false);
            uws.setDirectors_Allowed(true);
            Form f = c.getComponentForm();
            Tabs tabs = (Tabs) findByName("Tabs", f);
            tabs.setSwipeActivated(false);
            tabs.hideTabs();
            f.setTitle("Director Details");
            Result rs = uws.name_workflow(uws.getTrak_no(), uws.getName_reservation_no(), AGENT_CODE);
            String Response = rs.getAsString("//Insert_Name_Workflow_mobiResult");
            if (Response == "") {
                tabs.setSelectedIndex(3);
                enableincorporator(uws.getTrak_no(), f);
            } else {//        if (Response != null) {
                Dialog.show("Error", Response, "OK", null);
            }

// get traking no for new registration
        }

    }

    @Override
    protected void onFrmNewEntReg1_BtnGetIdInfoAction(Component c, ActionEvent event) {
        Form f = c.getComponentForm();
        //#########
        Container conregister = (Container) findByName("Conregister", f);
        conregister.setHidden(true);
        try {
            if (Display.getInstance().isSimulator()) {
                Dialog ip = new InfiniteProgress().showInifiniteBlocking();
                Result result = uws.get_dha_data("7104085085085");
                //Result result = uws.get_dha_data("444564506");
                //Result result = uws.get_dha_data("7611160016082");

                String retval = uws.DHA_Data(result);
                // Dialog.show("onFrmNewEntReg1_BtnGetIdInfoAction", retval.toString(), "OK", null);
                if (retval.toString().equals("Error")) {
                    ip.dispose();
                    // Dialog.show("Scan ID1", "Return val " + retval, "OK", null);
                    return;
                } else {
                    ip.dispose();
                    //  Dialog.show("Scan ID2", "Return val " + retval, "OK", null);
                }
                if (uws.ArlDHA_Detail.size() == 0) {
                    Dialog.show("Scan ID", "The Document scaned does not contain a vaild ID Number. Please contact DHA or rescan the document", "OK", null);
                    return;
                }
                ip.dispose();
                for (int i = 0; i < uws.ArlDHA_Detail.size(); i++) {
                    DHA_Detail DD = uws.ArlDHA_Detail.get(i);

                    String death_status = RSM_A(DD.getDEATH_STATUS());
                    if (!"ALIVE".equals(death_status)) {
                        scanCanceled_death();
                        return;
                    }
                    Label lblIdno = (Label) findByName("LblIdNo", f);
                    lblIdno.setText(RSM_A(DD.getIDNUMBER()));
                    lblIdno.repaint();

                    Label lblDirbirthdate = (Label) findByName("lbldirbirthdate", f);
                    lblDirbirthdate.setText(RSM_A(DD.getDOB()));
                    lblDirbirthdate.repaint();
                    //LblNames
                    Label lblnames = (Label) findByName("LblNames", f);
                    lblnames.setText(RSM_A(DD.getNAMES()));
                    lblnames.repaint();
                    //LblSurname
                    Label lblsurname = (Label) findByName("LblSurname", f);
                    lblsurname.setText(RSM_A(DD.getSURNAME()));
                    lblsurname.repaint();
                    //PhysAddr1
                    TextField physaddr1 = (TextField) findByName("PhysAddr1", f);
                    physaddr1.setText(RSM_A(DD.getADDR_LINE1()));
                    physaddr1.repaint();
                    TextField physaddr2 = (TextField) findByName("PhysAddr2", f);
                    physaddr2.setText(RSM_A(DD.getADDR_LINE2()));
                    physaddr2.repaint();
                }
                Show_Director_Fields(f);
                // Button btn = (Button) findByName("BtnverifyOtp", c);
                //btn.setEnabled(true);
                f.repaint();
                TextField txtcell = (TextField) findByName("TxtCell", f);
                txtcell.repaint();
                txtcell.requestFocus();
                txtcell.startEditing();
            } else {
                //########
                Dialog ip = new InfiniteProgress().showInifiniteBlocking();
                CodeScanner.getInstance().scanBarCode(new ScanResult() {
                    public void scanCompleted(String contents, String formatName, byte[] rawBytes) {
                        //Dialog.show("Bar code", "Bar code is: " + contents, "Ok", null);
//#################################disable barcode scanner
                        Dialog.show("ID Scanned: ", contents, "OK", null);
                        Result result = uws.get_dha_data(contents);

                        String retval = uws.DHA_Data(result);
                        if (retval.toString().equals("Error")) {
                            ip.dispose();
                            //Dialog.show("Scan ID1", "Return val " + retval, "OK", null);
                            return;
                        }
                        if (uws.ArlDHA_Detail.size() == 0) {
                            Dialog.show("Scan ID", "The Document scaned does not contain a vaild ID Number. Please contact DHA or rescan the document", "OK", null);
                            ip.dispose();
                            return;
                        }
                        for (int i = 0; i < uws.ArlDHA_Detail.size(); i++) {
                            DHA_Detail DD = uws.ArlDHA_Detail.get(i);
                            String death_status = RSM_A(DD.getDEATH_STATUS());
                            if (death_status != "ALIVE") {

                            }
                            Label lblIdno = (Label) findByName("LblIdNo", f);
                            lblIdno.setText(RSM_A(DD.getIDNUMBER()));
                            lblIdno.repaint();
                            //DOB
                            Label lblDirbirthdate = (Label) findByName("lbldirbirthdate", f);
                            lblDirbirthdate.setText(RSM_A(DD.getDOB()));
                            lblDirbirthdate.repaint();
                            //LblNames
                            Label lblnames = (Label) findByName("LblNames", f);
                            lblnames.setText(RSM_A(DD.getNAMES()));
                            lblnames.repaint();
                            //LblSurname
                            Label lblsurname = (Label) findByName("LblSurname", f);
                            lblsurname.setText(RSM_A(DD.getSURNAME()));
                            lblsurname.repaint();
                            //PhysAddr1
                            TextField physaddr1 = (TextField) findByName("PhysAddr1", f);
                            physaddr1.setText(RSM_A(DD.getADDR_LINE1()));
                            physaddr1.repaint();
                            TextField physaddr2 = (TextField) findByName("PhysAddr2", f);
                            physaddr2.setText(RSM_A(DD.getADDR_LINE2()));
                            physaddr2.repaint();
                            ;
                        }
                        Show_Director_Fields(f);
                        // Button btn = (Button) findByName("BtnverifyOtp", c);
                        //btn.setEnabled(true);
                        f.repaint();
                        TextField txtcell = (TextField) findByName("TxtCell", f);
                        txtcell.repaint();
                        txtcell.requestFocus();
                        txtcell.startEditing();
                        ip.dispose();
                        //#######disable barcode scanner
                    }

                    public void scanCanceled() {
                        System.out.println("cancelled");
                        Dialog.show("Scan Cancelled", "Please ensure that there is sufficient light when performing scan", "Ok", null);
                        ip.dispose();
                    }

                    public void scanError(int errorCode, String message) {
                        Dialog.show("Scan Error", "Please ensure that there is sufficient light when performing scan", "Ok", null);
                        ip.dispose();
                    }

                });
            }
        } catch (Exception ex) {

            Dialog.show("Scan Error", ex.toString(), "Ok", null);
        }
    }

    protected void onFrmNewEntReg1_ButtoncondirAction(Component c, ActionEvent event) {
        Dialog ip = new InfiniteProgress().showInifiniteBlocking();
        if (validentdata(c)) {
            uws.setInfo_Allowed(false);
            uws.setNames_Allowed(false);
            uws.setEnterprise_Allowed(false);
            uws.setDirectors_Allowed(true);
            Form f = c.getComponentForm();
            Tabs tabs = (Tabs) findByName("Tabs", f);
            tabs.setSwipeActivated(false);
            tabs.hideTabs();
            f.setTitle("Director Details");
            // Dialog ip = new InfiniteProgress().showInifiniteBlocking();
            Result rs = uws.name_workflow(uws.getTrak_no(), uws.getName_reservation_no(), AGENT_CODE);
            //   ip.dispose();
            String Response = rs.getAsString("//Insert_Name_Workflow_mobiResult");
            ip.dispose();
            if (Response == "") {
                //              Table tbl = (Table) findByName("Tablememinfo", f);
                //              tbl.setHidden(true);
//               Container Containermem = (Container) findByName("Containermem", f);
//               Containermem.setHidden(true);
                tabs.setSelectedIndex(3);
                enableincorporator(uws.getTrak_no(), f);
            } else {//        if (Response != null) {
                Dialog.show("Error", Response, "OK", null);
            }
// get traking no for new registration
        }
        ip.dispose();
    }

    @Override
    protected void onFrmNewEntReg1_BtnverifyOtpAction(Component c, ActionEvent event) {
        Form f = c.getComponentForm();
//TxtCell
        TextField txtcell = (TextField) findByName("TxtCell", f);
        if (txtcell.getText().trim().equals("")) {
            Dialog.show("Error", "Please enter a valid cell number", "OK", null);
            //loadlist(uws.getTrak_no(), c);
            f.repaint();
            return;
        } else {
            if (isCellPhoneValid(txtcell.getText()) == false) {
                Dialog.show("Error", "Please enter a valid cell number. Incorrect Cell number format", "OK", null);
                //loadlist(uws.getTrak_no(), c);
                f.repaint();
                return;
            }
        }
        Label lblidno = (Label) findByName("LblIdNo", f);
        if (lblidno.getText().trim().equals("")) {
            Dialog.show("Error", "Please Scan a valid ID Document", "OK", null);
            lblidno.repaint();
            lblidno.requestFocus();

            loadlist(uws.getTrak_no(), c);
            f.repaint();

            return;
        }
        Dialog ip = new InfiniteProgress().showInifiniteBlocking();
        uws.setOTP(uws.ValidateCelNo(AGENT_CODE, uws.getTrak_no(), txtcell.getText().trim(), lblidno.getText().trim().toString()));
//        Button btn = (Button) findByName("BtnverifyOtp", c);
//        btn.setEnabled(false);
        ip.dispose();
        //RSM_A(DD.getIDNUMBER()
        if ("ERR".equals(uws.getOTP().substring(0, 3))) {
            Dialog.show("Error", uws.getOTP(), "OK", null);
            txtcell.repaint();
            txtcell.requestFocus();
            txtcell.startEditing();

            //loadlist(uws.getTrak_no(), c);
            f.repaint();

            return;
        }

        // loadlist(uws.getTrak_no(), c);
        f.repaint();

    }

    protected void copydiraddress(Component c) {
        Form f = c.getComponentForm();
        TextField physaddr1 = (TextField) findByName("PhysAddr1", f);
        TextField physaddr2 = (TextField) findByName("PhysAddr2", f);
        TextField physaddr3 = (TextField) findByName("PhysAddr3", f);
        //ComboBox cmbprovince = (ComboBox) findByName("CmbProvince", f);
        //cmbprovince.setSelectedIndex(0);
        TextField physaddrcode = (TextField) findByName("Physaddrcode", f);
        TextField txtpostaladdr1 = (TextField) findByName("TxtPostalAddr1", f);
        txtpostaladdr1.setText(physaddr1.getText());
        TextField txtpostaladdr2 = (TextField) findByName("TxtPostalAddr2", f);
        txtpostaladdr2.setText(physaddr2.getText());
        TextField txtpostaladdr3 = (TextField) findByName("TxtPostalAddr3", f);
        txtpostaladdr3.setText(physaddr3.getText());
        // ComboBox cmbpostalprovince = (ComboBox) findByName("CmbPostalProvince", f);
        //  cmbpostalprovince.setSelectedIndex(cmbprovince.getSelectedIndex());
        TextField txtpostalcode = (TextField) findByName("TxtdirPostalCode", f);
        txtpostalcode.setText(physaddrcode.getText());
    }

    protected void onFrmNewEntReg1_BtncopyphysaddressAction(Component c, ActionEvent event) {
        copydiraddress(c);
        Button btnregdir = (Button) findByName("BtnAddDirector", c);
        btnregdir.requestFocus();

    }

    protected boolean validatedirdata(Component c) {
        //TxtIdNo

        //directordetails = new DirectorDetails();
        Form f = c.getComponentForm();
        CheckBox RDB = (CheckBox) findByName("chbIncorporator", f);
        if (RDB.isSelected()) {
            uws.setIsIncorporator(true);
        } else {
            uws.setIsIncorporator(false);
        }
        Label lbldirbirthdate = (Label) findByName("lbldirbirthdate", f);
        Label lblidNo = (Label) findByName("LblIdNo", f);
        if (lblidNo.getText().trim().equals("")) {
            Dialog.show("Error", "Please enter a valid Director ID Number", "OK", null);
            lblidNo.repaint();
            lblidNo.requestFocus();
            //lblidNo.startEditing();

            return false;
        }
        TextField txtotp = (TextField) findByName("TxtOtp", f);
        if (txtotp.getText().trim().equals("")) {
            Dialog.show("Error", "Please enter a valid otp for Director ID Number" + lblidNo.getText().trim(), "OK", null);
            txtotp.repaint();
            txtotp.requestFocus();
            txtotp.startEditing();

            return false;
        } else {
            if (txtotp.getText().trim().equals(uws.getOTP())) {
            } else {
                Dialog.show("Error", "Please enter a valid otp for Director ID Number" + lblidNo.getText().trim(), "OK", null);
                txtotp.repaint();
                txtotp.requestFocus();
                txtotp.startEditing();
                return false;
            }
        }
//LblNames
        Label lblnames = (Label) findByName("LblNames", f);
        if (lblnames.getText().trim().equals("")) {
            Dialog.show("Error", "Invalid first names", "OK", null);
            lblnames.repaint();
            lblnames.requestFocus();
            return false;
        }
//LblSurname

        Label lblsurname = (Label) findByName("LblSurname", f);
        if (lblsurname.getText().trim().equals("")) {
            Dialog.show("Error", "Invalid surnames names", "OK", null);
            lblsurname.repaint();
            lblsurname.requestFocus();
            return false;
        }

//DtDatofBirth
//TxtCell
        TextField txtcell = (TextField) findByName("TxtCell", f);
        if (txtcell.getText().trim().equals("")) {
            Dialog.show("Error", "Please enter a valid cell number", "OK", null);
            txtcell.repaint();
            txtcell.requestFocus();
            txtcell.startEditing();
            return false;
        }

//TxtEmail
        TextField txtemail = (TextField) findByName("TxtEmail", f);
        if (txtemail.getText().trim().equals("")) {
            Dialog.show("Error", "Please enter a valid email", "OK", null);
            txtemail.repaint();
            txtemail.requestFocus();
            txtemail.startEditing();
            return false;
        }
        if (isEmailValid(txtemail.getText().trim()) == false) {
            Dialog.show("Error", "Please enter a valid E-Mail format.", "OK", null);
            txtemail.repaint();
            txtemail.requestFocus();
            txtemail.startEditing();
            return false;
        }
//PhysAddr1
        TextField physaddr1 = (TextField) findByName("PhysAddr1", f);
        if (physaddr1.getText().trim().equals("")) {
            Dialog.show("Error", "Please enter a valid Physical Address line 1", "OK", null);
            physaddr1.repaint();
            physaddr1.requestFocus();
            physaddr1.startEditing();
            return false;
        }

//PhysAddr2
        TextField physaddr2 = (TextField) findByName("PhysAddr2", f);
        if (physaddr2.getText().trim().equals("")) {
            Dialog.show("Error", "Please enter a valid Physical Address line 2", "OK", null);
            physaddr2.repaint();
            physaddr2.requestFocus();
            physaddr2.startEditing();
            return false;
        }

//PhysAddr3
        TextField physaddr3 = (TextField) findByName("PhysAddr3", f);
        if (physaddr3.getText().trim().equals("")) {
            Dialog.show("Error", "Please enter a valid Physical Address line 3", "OK", null);
            physaddr3.repaint();
            physaddr3.requestFocus();
            physaddr3.startEditing();
            return false;
        }
//Cmbdirectortype
        ComboBox mbdirectortype = (ComboBox) findByName("Cmbdirectortype", f);
        if (mbdirectortype.getSelectedItem().toString().equals("")) {
            Dialog.show("Error", "Please enter a valid Director type.", "OK", null);
            mbdirectortype.repaint();
            mbdirectortype.requestFocus();
            return false;

        }

//CmbProvince
//        ComboBox cmbprovince = (ComboBox) findByName("CmbProvince", f);
//        if (cmbprovince.getSelectedItem().toString().equals("Select Province")) {
//            Dialog.show("Error", "Please enter a valid province for physical address.", "OK", null);
//            cmbprovince.repaint();
//            cmbprovince.requestFocus();
//            return false;
//        }
//Physaddrcode
        TextField physaddrcode = (TextField) findByName("Physaddrcode", f);
        if (physaddrcode.getText().trim().equals("")) {
            Dialog.show("Error", "Please enter a valid Physical Address Code", "OK", null);
            physaddrcode.repaint();
            physaddrcode.requestFocus();
            physaddrcode.startEditing();
            return false;
        }

//TxtPostalAddr1
        TextField txtpostaladdr1 = (TextField) findByName("TxtPostalAddr1", f);
        if (txtpostaladdr1.getText().trim().equals("")) {
            Dialog.show("Error", "Please enter a valid Postal Address line 1", "OK", null);
            txtpostaladdr1.repaint();
            txtpostaladdr1.requestFocus();
            txtpostaladdr1.startEditing();
            return false;
        }

//TxtPostalAddr2}
        TextField txtpostaladdr2 = (TextField) findByName("TxtPostalAddr2", f);
        if (txtpostaladdr2.getText().trim().equals("")) {
            Dialog.show("Error", "Please enter a valid Postal Address line 2", "OK", null);
            txtpostaladdr2.repaint();
            txtpostaladdr2.requestFocus();
            txtpostaladdr2.startEditing();
            return false;
        }

//TxtPostalAddr3
        TextField txtpostaladdr3 = (TextField) findByName("TxtPostalAddr3", f);
        if (txtpostaladdr3.getText().trim().equals("")) {
            Dialog.show("Error", "Please enter a valid Postal Address line 3", "OK", null);
            txtpostaladdr3.repaint();
            txtpostaladdr3.requestFocus();
            txtpostaladdr3.startEditing();
            return false;
        }

//CmbPostalProvince
//        ComboBox cmbpostalprovince = (ComboBox) findByName("CmbPostalProvince", f);
//        if (cmbpostalprovince.getSelectedItem().toString().equals("Select Province")) {
//            Dialog.show("Error", "Please enter a valid province for physical address.", "OK", null);
//            cmbpostalprovince.repaint();
//            cmbpostalprovince.requestFocus();
//            return false;
//        }
//TxtPostalCode
        TextField txtpostalcode = (TextField) findByName("TxtdirPostalCode", f);
        if (txtpostalcode.getText().trim().equals("")) {
            Dialog.show("Error", "Please enter a valid Postal Address Code", "OK", null);
            txtpostalcode.repaint();
            txtpostalcode.requestFocus();
            txtpostalcode.startEditing();
            return false;
        }
//dtAppDate
        Picker dtappdate = (Picker) findByName("dtAppDate", f);
        Date testdate = dtappdate.getDate();
        Date d = dtappdate.getDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);

        String m1 = Integer.toString(cal.get(Calendar.MONTH) + 1);
        if (m1.length() == 1) {
            m1 = "0" + m1;
        }
        String y1 = Integer.toString(cal.get(Calendar.YEAR));
        String d1 = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        String dateStringApp = y1 + "/" + m1 + "/" + d1;
//        String m1=Integer.toString(dtappdate.getDate().getMonth());
//        String d1=Integer.toString(dtappdate.getDate().getDay());
//        String y1=Integer.toString(dtappdate.getDate().getYear());

        //       String dateStringApp = new SimpleDateFormat("yyyy-MM-dd").format(dtappdate.getDate().toString());
        //       dtappdate.setType(Display.PICKER_TYPE_DATE);
//DtDatofBirth
        //Picker dtdatofbirth = (Picker) findByName("DtDatofBirth", f);
//perform test if date of birth is valid
        DirectorDetails directordetails = new DirectorDetails();
        if (mbdirectortype.getSelectedItem().toString().equals("Director")) {
            directordetails.setDir_type_code("D");
        }
        if (mbdirectortype.getSelectedItem().toString().equals("Non Executive Director")) {
            directordetails.setDir_type_code("K");
        }
        if (mbdirectortype.getSelectedItem().toString().equals("Alternate Director")) {
            directordetails.setDir_type_code("N");
        }

        //directordetails.setDir_appoint_date(dtappdate.getText().toString());
        directordetails.setDir_appoint_date(dateStringApp);
        String dateString = lbldirbirthdate.getText().trim();
        // dateString = dateString.substring(6,8) + "/" + dateString.substring(4, 6) +"/"+ dateString.substring(0, 4 );

        //        new SimpleDateFormat("dd-MM-yyyy").format(lbldirbirthdate.getText().trim());
        directordetails.setDir_birth_date(dateString);
        directordetails.setPost_post_code(txtpostalcode.getText().trim());
        //  directordetails.setPost_addr4(cmbpostalprovince.getSelectedItem().toString());
        directordetails.setPost_addr3(txtpostaladdr3.getText().trim());
        directordetails.setPost_addr2(txtpostaladdr2.getText().trim());
        directordetails.setPost_addr1(txtpostaladdr1.getText().trim());
        directordetails.setRes_post_code(physaddrcode.getText().trim());
        //directordetails.setRes_addr4(cmbprovince.getSelectedItem().toString());
        directordetails.setRes_addr3(physaddr3.getText().trim());
        directordetails.setRes_addr2(physaddr2.getText().trim());
        directordetails.setRes_addr1(physaddr1.getText().trim());
        directordetails.setEmail_address(txtemail.getText().trim());
        directordetails.setCell_no(txtcell.getText().trim());
        directordetails.setId_no(lblidNo.getText().trim());
        directordetails.setFirst_names(lblnames.getText().trim());
        directordetails.setSurname(lblsurname.getText().trim());
        //directordetails.setCust_code(uws.getAgent_code());
        directordetails.setCust_code(AGENT_CODE);
        directordetails.setIsIncorporator(uws.isIsIncorporator());

        uws.setFirstNames(lblnames.getText().trim());
        uws.setSurname(lblsurname.getText().trim());
        Result rs = uws.AddDirector(directordetails);

        String Response = rs.getAsString("//ReceiveNewDirData_mobiResult");
        if (Response == "") {
            RDB.setEnabled(true);
            RDB.setSelected(true);
            return true;
        } else {//        if (Response != null) {
            Dialog.show("Error", Response, "OK", null);
            return false;
        }
        //return true;
    }

    protected boolean cleardirdata(Component c) {
        //TxtIdNo
        Form f = c.getComponentForm();
        Label lblnames = (Label) findByName("LblNames", f);
        lblnames.setText("");
        Label lblsurname = (Label) findByName("LblSurname", f);
        lblsurname.setText("");
        Label lblidno = (Label) findByName("LblIdNo", f);
        lblidno.setText("");
//TxtrelativeID
//        TextField txtrelativeid = (TextField) findByName("TxtrelativeID", f);
//        txtrelativeid.setText("");
//DtDatofBirth
//TxtCell
        TextField txtcell = (TextField) findByName("TxtCell", f);
        txtcell.setText("");
        TextField txtotp = (TextField) findByName("TxtOtp", f);
        txtotp.setText("");
        uws.setOTP("");
//TxtEmail
        TextField txtemail = (TextField) findByName("TxtEmail", f);
        txtemail.setText("");
//PhysAddr1
        TextField physaddr1 = (TextField) findByName("PhysAddr1", f);
        physaddr1.setText("");
//PhysAddr2
        TextField physaddr2 = (TextField) findByName("PhysAddr2", f);
        physaddr2.setText("");
//PhysAddr3
        TextField physaddr3 = (TextField) findByName("PhysAddr3", f);
        physaddr3.setText("");
//CmbProvince
        //  ComboBox cmbprovince = (ComboBox) findByName("CmbProvince", f);
        //   cmbprovince.setSelectedIndex(0);
//Physaddrcode
        TextField physaddrcode = (TextField) findByName("Physaddrcode", f);
        physaddrcode.setText("");
//TxtPostalAddr1
        TextField txtpostaladdr1 = (TextField) findByName("TxtPostalAddr1", f);
        txtpostaladdr1.setText("");
//TxtPostalAddr2}
        TextField txtpostaladdr2 = (TextField) findByName("TxtPostalAddr2", f);
        txtpostaladdr2.setText("");
//TxtPostalAddr3
        TextField txtpostaladdr3 = (TextField) findByName("TxtPostalAddr3", f);
        txtpostaladdr3.setText("");
//CmbPostalProvince
        //   ComboBox cmbpostalprovince = (ComboBox) findByName("CmbPostalProvince", f);
        //   cmbpostalprovince.setSelectedIndex(0);
//TxtPostalCode
        TextField txtpostalcode = (TextField) findByName("TxtdirPostalCode", f);
        txtpostalcode.setText("");
        return true;
    }

    protected void onFrmNewEntReg1_BtnAddDirectorAction(Component c, ActionEvent event) {
        Form f = c.getComponentForm();
        Dialog ip = new InfiniteProgress().showInifiniteBlocking();
        if (validatedirdata(c)) {

            cleardirdata(c);
            Hide_Director_Fields(f);
            Container conregister = (Container) findByName("Conregister", f);
            conregister.setHidden(false);
            //####################
            //Form f = c.getComponentForm();
            String Strak_no = uws.getTrak_no();
            ip.dispose();
            loadlist(Strak_no, c);
//            Table tbl = (Table) findByName("Tablememinfo", c);
//            tbl.requestFocus();
            f.repaint();
            //####################
        } else {
            loadlist(uws.getTrak_no(), c);
        }
        enableincorporator(uws.getTrak_no(), f);
        ip.dispose();
        f.repaint();
    }

    public void loadlist(String ref_no, Component c) {
        Form f = c.getComponentForm();
        Container cntmemlist = (Container) findByName("Conmemlist", f);
        cntmemlist.removeAll();
        f.repaint();
        Dialog ip = new InfiniteProgress().showInifiniteBlocking();
        Result result = uws.get_directors_stage(ref_no);
        uws.DIR_Data(result);
        ip.dispose();
        if (uws.ArlDIR_Detail.size() == 0) {
            return;
        }
        //       Table tbl = (Table) findByName("Tablememinfo", c);
//       tbl.setModel(tbl.getModel());
        // Container cnt = (Container) findByName("Conmemlist", f);
        Container cnt = new Container(BoxLayout.y());

//     Container1.setLayout(new BoxLayout.y());
// Container1.addComponent(BoxLayout.y(), myComponent);
        //Container cnt = new Container(BoxLayout.y());
        //cnt.setLayout(BoxLayout.y());
        for (int i = 0; i < uws.ArlDIR_Detail.size(); i++) {
            DIR_Detail DD = uws.ArlDIR_Detail.get(i);
            String Dir_id = RSM_A(DD.getDir_id());
            String First_Names = (RSM_A(DD.getFirs_names()));
            String Surname = (RSM_A(DD.getSurname()));
            String Id_no = (RSM_A(DD.getId_no()));
            Button b = new Button(First_Names + " " + Surname + " - " + Id_no);
            //  hsz
            b.setName(Dir_id);
            b.setUIID("Button_small_L");
            cnt.add(b);
            b.addActionListener(e
                    -> {
                boolean answer = Dialog.show("Info", "Do You Want to  Change info for " + b.getText() + ". Then you must delete the info and add the director as a new director. Do you want to delete this information?", "Confirm", "Decline");
                if (answer) {
                    //Dialog.show("", "delete director from table with dir_id = " + b.getName(), "OK", null);
                    uws.removedir(b.getName(), AGENT_CODE);
                    //String Strak_no = uws.getTrak_no();
                    //loadlist(Strak_no, c);
                    //Table tbl = (Table) findByName("Tablememinfo", c);
                    //tbl.requestFocus();

                    //Form f = c.getComponentForm();
                    cleardirdata(c);
                    Hide_Director_Fields(f);
                    Container conregister = (Container) findByName("Conregister", f);
                    conregister.setHidden(false);
                    //####################
                    //Form f = c.getComponentForm();
                    String Strak_no = uws.getTrak_no();
                    loadlist(Strak_no, c);
//            Table tbl = (Table) findByName("Tablememinfo", c);
//            tbl.requestFocus();
                    f.repaint();

                    f.repaint();
                } else {
                    String Strak_no = uws.getTrak_no();
                    //loadlist(Strak_no, c);
                    //Table tbl = (Table) findByName("Tablememinfo", c);
                    //tbl.requestFocus();
                    f.repaint();
                }
            });
        }
        // Container cntmemlist = (Container) findByName("Conmemlist", f);
        cntmemlist.add(cnt);
        // cnt.setScrollableY(true);
        //f.add(cnt);
        f.repaint();
    }

    @Override
    protected void onFrmNewEntReg1_BtnRegisterenterprisAction(Component c, ActionEvent event) {
        UserWebServices u = new UserWebServices();
        Dialog ip = new InfiniteProgress().showInifiniteBlocking();
        String valdir = uws.ValidateDirector(AGENT_CODE, uws.getTrak_no());
        if (valdir == null) {
            return;
        }
        // hsz
        if (valdir.equals("false")) {
            Dialog.show("Director Info Missing. ", "Please capture information of at least one director and one incorporator.", "OK", null);
            ip.dispose();
            return;
        }
//validate information
        u.insertCartItemServiceCOREG(uws.getTrak_no(), AGENT_CODE, "125");

//        String Sreservation_no = uws.getName_reservation_no();
//
//        if (Sreservation_no.trim() != "") {
//            String rvalue = uws.ValidateNameForPayment(AGENT_CODE, Sreservation_no);
//            if (rvalue.equals("false")) {
//                u.insertCartItemServiceName(Sreservation_no, AGENT_CODE, "50");
//            }
//        }
        ip.dispose();
        String Strak_no = uws.getTrak_no();
        //if (Sreservation_no == "") {
            Dialog.show("Payment ", "Transaction for Enterprise Registration reference no: " + Strak_no + " Was added to the Cart", "OK", null);
       // } else {
       //     Dialog.show("Payment ", "Name reservation-" + Sreservation_no + " and Enterprise Registration reference no: - " + Strak_no + " Was added to the Cart", "OK", null);
       // }
        // Form concart = contDashBoard.getComponentForm();
        DisplayCart = true;
        showForm("Main", null);

        // showCart2(concart);
//        //Form f = Display.getInstance().getCurrent();
//       // Form f = (Form); // findByName("Login");
//        Container c1 = (Container) findByName("containerParent",f);
//        Form f = c1.getComponentForm();
        //    showDashboard(f);
        //Display.getInstance().get
    }

    @Override
    protected void onContTasks_BtnLodgeAction(Component c, ActionEvent event) {

    }

    @Override
    protected void onContTasks_BtnVerifyAction(Component c, ActionEvent event) {

    }

    @Override
    protected void onLogin_BtnLoginAction(Component c, ActionEvent event) {

    }

    @Override
    protected void onCreateMain() {

    }

    protected void beforeBEE(Form f) {
        load_bee_form(f);
//        UserWebServices u = new UserWebServices();
//        //AnnualReturns annualReturns = u.get_ar_info_mobi(AGENT_CODE, ENT_NUMBER);
//        listBEEDetail = u.Get_BEE_MOBI(AGENT_CODE);
//        //listBEEDetail = u.Get_BEE_MOBI(dataset);
//
//        if (listBEEDetail.isEmpty()) {
//            Log.p("listCalculateARTran=0", Log.DEBUG);
//        } else {
//            Log.p("listCalculateARTran=" + listBEEDetail.size(), Log.DEBUG);
//        }
//
//        for (int i = 0; i < listBEEDetail.size(); i++) {
//            //rm f = c.getComponentForm();
//            BEEDetail n = listBEEDetail.get(i);
//            //Dialog.show("1.1", n.getName(), "Ok", null);
//            String ent_no = n.getEnt_no();
//            String ent_name = n.getEnt_name();
////                    if (txt.indexOf("|") > -1) {
////                        java.util.List<String> list = StringUtil.tokenize(n.getName(), "|");
////                        if (list != null && list.size() > 0) {
////                            txt = list.get(0);
////                        }
////                        name = txt;
////                    } else {
////                        name = n.getName();
////                    }
//            List ListEnt = (List) findByName("ListEnt", f);
//            //TextField textfield = (TextField) findByName("TxtIdNo", f);
//            ListEnt.addItem(ent_no);
//            ListEnt.repaint();
//            List ListEntname = (List) findByName("ListEntname", f);
//            //TextField textfield = (TextField) findByName("TxtIdNo", f);
//            ListEntname.addItem(ent_no);
//            ListEntname.repaint();
//        }
    }

    @Override
    protected void onContTasks_TxtName4Action(Component c, ActionEvent event) {

    }

    @Override
    protected void onContCart_BtnPayNowAction(Component c, ActionEvent event) {

    }

    @Override
    protected void onContDashBoard_MbButtonAction(Component c, ActionEvent event) {

    }

    @Override
    protected void onFrmNewEntReg1_TxtOtpAction(Component c, ActionEvent event) {

    }

    @Override
    protected void onTestlist_ButtonAction(Component c, ActionEvent event) {

        Form f = c.getComponentForm();
        UserWebServicesNewReg uws = new UserWebServicesNewReg();
        Result result = uws.incorporatorcount("989124629", AGENT_CODE);
        String sqty = uws.qtyincorporator(result);
//        Dialog ip = new InfiniteProgress().showInifiniteBlocking();
//        Result result = uws.get_directors_stage("1-18UCACQ");
//        uws.DIR_Data(result);
//        ip.dispose();
//        loadlist("1-18UCACQ", c);
//        Container cnt = new Container(BoxLayout.y());
//        for (int i = 0; i < uws.ArlDIR_Detail.size(); i++) {
//            DIR_Detail DD = uws.ArlDIR_Detail.get(i);
//            String Dir_id = RSM_A(DD.getDir_id());
//            String First_Names = (RSM_A(DD.getFirs_names()));
//            String Surname = (RSM_A(DD.getSurname()));
//            String Id_no = (RSM_A(DD.getId_no()));
//            Button b = new Button(First_Names + " " + Surname + " - " + Id_no);
//            b.setName(Dir_id);
//            b.setUIID("Button_small");
//            cnt.add(b);
//            b.addActionListener(e
//                    -> {
//                boolean answer = Dialog.show("Info", "Do You Want to  Change info for " + b.getText() + ". Then you must delete the info and add the director as a new director. Do you want to delete this information?", "Confirm", "Decline");
//                if (answer) {
//                    Dialog.show("", "delete director from table with dir_id = " + b.getName(), "OK", null);
//                    Table tbl = (Table) findByName("Tablememinfo", c);
//                    tbl.add(cnt);
//                }
//            });
//        }
//        cnt.setScrollableY(true);
//        Table tbl = (Table) findByName("Tablememinfo", c);

        f.repaint();
//        cnt.repaint();
        //       tbl.repaint();
    }

    @Override
    protected void onFrmNewEntReg1_BtnconregAction(Component c, ActionEvent event) {

        TextField txtrefno = (TextField) findByName("txtrefno", c);
        Dialog ip = new InfiniteProgress().showInifiniteBlocking();

        Result result = uws.get_name_workflow(txtrefno.getText(), AGENT_CODE);
        uws.name_workflow(result);
        ip.dispose();
        // Dialog.show("BtnconregAction hsz1","Arl_name_workflow_Detail size " + uws.Arl_name_workflow_Detail.size() + " - " + txtrefno.getText() + ". Transaction might be completed for reference number.", "OK", null);
        if (uws.Arl_name_workflow_Detail.size() == 0) {
            Dialog.show("Notice", "No Information found for reference no - " + txtrefno.getText() + ". Transaction might be completed for reference number.", "OK", null);
            return;
        }
        String Application_no = "";
        String ref_no = "";
        String cust_code = "";
        for (int i = 0; i < uws.getArl_name_workflow_Detail().size(); i++) {
            Name_Workflow nw = uws.Arl_name_workflow_Detail.get(i);

            Application_no = nw.getApplication_no();
            ref_no = RSM_A(nw.getRef_no());
            cust_code = RSM_A(nw.getCust_code());
        }
        //   String scust_code = RSM_A(cust_code);
        if (!AGENT_CODE.equals(cust_code)) {
            Dialog.show("Notice", "Reference no " + txtrefno.getText() + " does not belong to customer code " + AGENT_CODE, "OK", null);
            return;
        }
        uws.setInfo_Allowed(false);
        uws.setNames_Allowed(false);
        uws.setEnterprise_Allowed(false);
        uws.setDirectors_Allowed(true);
        Form f = c.getComponentForm();
        Tabs tabs = (Tabs) findByName("Tabs", f);
        tabs.setSwipeActivated(false);
        tabs.hideTabs();
        f.setTitle("Director Details");
        uws.setTrak_no(ref_no);
        uws.setAgent_code(AGENT_CODE);
        uws.setName_reservation_no(Application_no);
        tabs.setSelectedIndex(3);
        enableincorporator(uws.getTrak_no(), f);
        // Form f = c.getComponentForm();
//            Result result = uws.get_directors_stage("1-18UCACQ");
//            uws.DIR_Data(result);
        loadlist(ref_no, c);
        Container conregister = (Container) findByName("Conregister", f);
        conregister.setHidden(false);
        f.repaint();
        //  kkkk

//            Result rs = uws.name_workflow(uws.getTrak_no(), uws.getName_reservation_no(), AGENT_CODE);
//            String Response = rs.getAsString("//Insert_Name_Workflow_mobiResult");
//            if (Response == "") {
//                tabs.setSelectedIndex(3);
//            } else {//        if (Response != null) {
//                Dialog.show("Error", Response, "OK", null);
//            }
//    
//    }
    }

    protected void enableincorporator(String reference_no, Form f) {
        UserWebServicesNewReg uws = new UserWebServicesNewReg();
        Result result = uws.incorporatorcount(reference_no, AGENT_CODE);
        String sqty = uws.qtyincorporator(result);
        CheckBox RDB = (CheckBox) findByName("chbIncorporator", f);
//Dialog.show("enable incorporator",  "qty = " + sqty, "OK", null);
        //type.equals("06")
        if (sqty.equals("0")) {

            RDB.setEnabled(false);
            RDB.setFocusable(false);

        } else {

            RDB.setEnabled(true);
            RDB.setFocusable(true);
        }

    }

    @Override
    protected void postFrmNewEntReg1(Form f) {

    }

    @Override
    protected void onFrmNewEntReg1_CmbdirectortypeAction(Component c, ActionEvent event) {
        Form f = c.getComponentForm();
        // loadlist(uws.getTrak_no(), c);
        f.repaint();
    }

    protected void onFrmNewEntReg1_BtnrefresdirAction(Component c, ActionEvent event) {

    }

    protected void onFrmNewEntReg1_BtnrefreshmemAction(Component c, ActionEvent event) {
        Form f = c.getComponentForm();
        loadlist(uws.getTrak_no(), c);
        f.repaint();

    }

    @Override
    protected void beforeContainerContProjects(Container c) {

    }

    @Override
    protected void onFrmNewEntReg1_CmbFyeMonthAction(Component c, ActionEvent event) {

    }

    @Override
    protected void onFrmNewEntReg1_TxtEmailAction(Component c, ActionEvent event) {

    }

    protected void onBEE_BtnShowBeeAction(Component c, ActionEvent event) {
        Form f = c.getComponentForm();
        UserWebServices u = new UserWebServices();
        UserWebServicesNewReg uws = new UserWebServicesNewReg();
        Result result = u.Get_BEE_MOBI(AGENT_CODE);
        uws.BEE_Data(result);
        Container cnt_Bee = new Container(BoxLayout.y());

        Table tbl = (Table) findByName("Table_ent_Bee", c);
        for (int i = 0; i < uws.ArlBEE_Detail.size(); i++) {
            //rm f = c.getComponentForm();
            BEEDetail n = uws.ArlBEE_Detail.get(i);
            //Dialog.show("1.1", n.getName(), "Ok", null);
            String ent_no = n.getEnt_no();
            String ent_name = n.getEnt_name();
            Button b = new Button(ent_no + " " + ent_name);
            b.setName(ent_no);
            b.setEnabled(true);
            b.setUIID("Button_small");
            b.addActionListener(e
                    -> {
                boolean answer = Dialog.show("Info", "Do You Want to apply for a B-BBEE Certificate for " + b.getText(), "Yes", "No");
                if (answer) {
                    //   Table tbl = (Table) findByName("Tablememinfo", c);
                    tbl.add(cnt_Bee);
                    // f.repaint();
                } else {
                    f.repaint();
                }
            });
            tbl.add(b);
        }
        f.repaint();
    }

    protected void load_bee_form(Form f) {
        // Form f = c.getComponentForm();
        UserWebServices u = new UserWebServices();
        UserWebServicesNewReg uws = new UserWebServicesNewReg();
        Result result = u.Get_BEE_MOBI(AGENT_CODE);
        uws.BEE_Data(result);
        Container cnt_Bee = new Container(BoxLayout.y());
        // Table tbl = (Table) findByName("Table_ent_Bee", f);
        for (int i = 0; i < uws.ArlBEE_Detail.size(); i++) {
            //rm f = c.getComponentForm();
            BEEDetail n = uws.ArlBEE_Detail.get(i);
            //Dialog.show("1.1", n.getName(), "Ok", null);
            String ent_no = RSM_A(n.getEnt_no());
            String ent_name = RSM_A(n.getEnt_name());
            Button b = new Button(ent_no + " " + ent_name);
            b.setName(ent_no);
            b.setUIID("Button_small_L");
            //b.setEnabled(true);
            b.addActionListener(e
                    -> {
                boolean answer = Dialog.show("Info", "Do You Want to apply for a B-BBEE Certificate for " + b.getText(), "Yes", "No");
                if (answer) {
                    //   showBEEStep1(b);
                }
//                    //   Table tbl = (Table) findByName("Tablememinfo", c);
//                     // tbl.add(cnt_Bee);
//                     Label lbl_ent_no = (Label) findByName("lbl_ent_no", f);
//                     lbl_ent_no.setText(b.getName());
//                    load_bee_form(f);
//                    f.repaint();
//                } else {
//                      Label lbl_ent_no = (Label) findByName("lbl_ent_no", f);
//                    lbl_ent_no.setText("");
//                    //load_bee_form(f);
//                    f.repaint();
//                }
            });
            cnt_Bee.addComponent(b);
            //  tbl.add(b);
        }
        f.addComponent(cnt_Bee);
        f.repaint();
    }

    @Override
    protected void onCreateBEE() {

    }

    @Override
    protected void postBEE(Form f) {
        //  load_bee_form(f);
    }

    public void showBEEStep1(Button buttonClicked) {

        Log.p("buttonClicked=" + buttonClicked.getText(), Log.DEBUG);

        Form form = new Form("Step 1");
        form.show();

    }

    @Override
    protected void onContProjects_BtnStep1RetrieveDetailsAction(Component c, ActionEvent event) {

    }

    protected void onFrmNewEntReg1_BtnexitAction(Component c, ActionEvent event) {
        Form f = c.getComponentForm();
        cleardirdata(c);
        Hide_Director_Fields(f);
        Container conregister = (Container) findByName("Conregister", f);
        conregister.setHidden(false);
        //####################
        //Form f = c.getComponentForm();
        String Strak_no = uws.getTrak_no();
        loadlist(Strak_no, c);
//            Table tbl = (Table) findByName("Tablememinfo", c);
//            tbl.requestFocus();
        f.repaint();

    }
}
