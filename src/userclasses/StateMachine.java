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
import com.codename1.ui.validation.Constraint;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.RegexConstraint;
import com.codename1.ui.validation.Validator;
import com.codename1.util.StringUtil;
import com.codename1.util.regex.RE;

import com.sun.prism.paint.Color;
import java.io.ByteArrayInputStream;
//import com.pmovil.nativega.GANative;
//import com.pmovil.nativega.HitBuilders;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import org.bouncycastle.crypto.InvalidCipherTextException;
import services.Utility;
import za.co.cipc.webservices.UserWebServices;
import ui.FormProgress;
import za.co.cipc.pojos.AnnualReturns;
import za.co.cipc.pojos.Dashboard;
import za.co.cipc.pojos.User;
//TESTING UPLOAD

/**
 *
 * @author Your name here
 */
public class StateMachine extends StateMachineBase {

    final String KEY_FOR_T_AND_CS = "CIPC_T_AND_Cs";
    final String KEY_FOR_T_AND_CS_Accepted = "CIPC_T_AND_Cs_Accepted";

    static za.co.cipc.pojos.User responseUser;

    Container contSideMenu;

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

    static String ENT_NUMBER;
    ArrayList annualReturnsEntDetails;

    ArrayList<EnterpriseDetails> listEnterpriseDetails;
    ArrayList<TextArea> listTextEnterpriseDetails;
    ArrayList<EnterpriseDetails> listCalculateARTran;

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

//        Display.getInstance().addEdtErrorHandler(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                evt.consume();
//                if (Display.getInstance().isSimulator()) {
//                    Log.p("Environment is Simulator");
//                } else {
//                    Log.p("Environment is Device");
//                }
//                Log.p("User " + AGENT_CODE);
//                Log.p("Exception in AppName version " + Display.getInstance().getProperty("AppVersion", "Unknown"));
//                Log.p("OS " + Display.getInstance().getPlatformName());
//                Log.p("Error " + evt.getSource());
//                Log.p("Current Form " + Display.getInstance().getCurrent().getName());
//                Log.e((Throwable) evt.getSource());
//                if (!Display.getInstance().isSimulator()) {
//                    Log.sendLog();
//                }
//            }
//        });
        if (Display.getInstance().isSimulator()) {

            AGENT_CODE = "NEWLNE";

            Log.p("isCellPhoneValid=" + isCellPhoneValid("0833598094"), Log.DEBUG);
            Log.p("isEmailValid=" + isEmailValid("blessing@mfactory.mobi"), Log.DEBUG);
            Log.p("isUrlValid=" + isUrlValid("www.mfactory.mobi"), Log.DEBUG);

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
            //         UserWebServices u = new UserWebServices();
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
//            uw.update_app_version("0.22");
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
            defaultPassword = "PleaseWork1!";
            //defaultEmail = "SARBIA";
            //defaultPassword = "barend";

            Log.setLevel(Log.DEBUG);
            Log.p("issimulator", Log.DEBUG);

            return "Login";
            //return "Splash";

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

            if (name1.length() == 0 && name2.length() == 0
                    && name3.length() == 0 && name4.length() == 0) {
                msg += "Please submit at least one Name. ";
            }

            if (isAlphaNumeric(name1) == false
                    || isAlphaNumeric(name2) == false
                    || isAlphaNumeric(name3) == false || isAlphaNumeric(name4) == false) {
                msg += "Names may only contain alphabetical letters and numbers. ";
            }

            if (msg.length() > 0) {
                Dialog.show("Error", msg, "Ok", null);
            } else {

                UserWebServices u = new UserWebServices();
                arrayListNameReservation = u.search_name_MOBI(AGENT_CODE, name1, name2, name3, name4);
                Log.p("arrayListNameReservation size: " + arrayListNameReservation.size(), Log.DEBUG);

                if (arrayListNameReservation.size() == 0) {
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
        });

        btnLodge.addActionListener((ActionListener) (ActionEvent evt) -> {

            formProgress = new FormProgress(f);

            String name1 = txtName1.getText();
            String name2 = txtName2.getText();
            String name3 = txtName3.getText();
            String name4 = txtName4.getText();

            String msg = "";

            if (arrayListNameReservation == null || arrayListNameReservation.size() == 0) {

                msg += "Please validate Names before clicking on Add to Cart and ensure you have at least one name that might be available. ";

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

            if (isAlphaNumeric(name1) == false
                    || isAlphaNumeric(name2) == false
                    || isAlphaNumeric(name3) == false || isAlphaNumeric(name4) == false) {
                msg += "Names may only contain alphabetical letters and numbers. ";
            }

            if (msg.length() > 0) {
                if (formProgress != null) {
                    formProgress.removeProgress();
                }
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
                    Dialog.show("Error", responseCall.getResponseMessage(), "Ok", null);//TODO scroll to top
                } else if (responseCall != null
                        && responseCall.getResponseMessage().indexOf("already filed") == -1) {

                    int indexStart = responseCall.getResponseMessage().indexOf("Reference No: ") + 14;
                    int indexEnd = responseCall.getResponseMessage().indexOf(". First proposed");

                    String ref = responseCall.getResponseMessage().substring(indexStart, indexEnd);

                    if (formProgress != null) {
                        formProgress.removeProgress();
                    }
                    Dialog.show("Success", "Dear Customer, Name Reservation Lodged successfully. Payment Reference No: " + ref + ".", "Ok", null);

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
                } else if (responseCall != null
                        && responseCall.getResponseMessage().indexOf("already filed") != -1) {
                    Dialog.show("Error", responseCall.getResponseMessage(), "Ok", null);//TODO scroll to top
                } else {
                    Dialog.show("Error", "Error occurred while processing your request. Please try again later or contact CIPC.", "Ok", null);
                }
            }

        });

        if (!Display.getInstance().isTablet()) {
            f.add(BorderLayout.CENTER, contTasks);
        }

        if (formProgress != null) {
            formProgress.removeProgress();
        }

    }
    ActionListener orientationListener = null;

    public void showDashboard(final Form f) {

        f.removeAllCommands();

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

        Image img1 = FontImage.createMaterial(FontImage.MATERIAL_STORE, labelForm, sizeLabel);
        Image img2 = FontImage.createMaterial(FontImage.MATERIAL_CREDIT_CARD, labelForm, sizeLabel);
        Image img3 = FontImage.createMaterial(FontImage.MATERIAL_SHOPPING_CART, labelForm, sizeLabel);

        lblIcon1.setIcon(img1);
        lblIcon2.setIcon(img2);
        lblIcon3.setIcon(img3);

        Button mbNameReservations = (Button) findByName("mbTasks", cont);

        mbNameReservations.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //formProgress = new FormProgress(f);
                showNameReservation(f, Const.TASK_TODAY);
            }
        });

        Button mbAnnualReturns = (Button) findByName("mbCurrency", cont);
        mbAnnualReturns.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //formProgress = new FormProgress(f);
                showAnnualReturns(f);
            }
        });

        Button mbCardPayments = (Button) findByName("mbButton", cont);
        mbCardPayments.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //formProgress = new FormProgress(f);
                showCart2(f);
            }
        });

        UserWebServices u = new UserWebServices();
        Hashtable<String, Dashboard> table = u.get_mobi_permissions(AGENT_CODE);

        if (table == null || table.size() == 0) {
            //cont.remove();
            //f.reva
        } else {
            String[] names = {"AR", "NR", "CP"};

            for (int i = 0; i < names.length; i++) {
                String key = names[i];

                Dashboard d = table.get(key);
                //key = key.toLowerCase();
                if (d != null) {
                    ;
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
        }

//        mbTasks.setTextLine1("Name Reservations");
//        mbTasks.setTextLine2("Submit Proposed Name (s)");
//
//        mbCurrency.setTextLine1("Annual Returns");
//        mbCurrency.setTextLine2("Submit Enterprise Annual Returns");
//
//        mbCart.setTextLine1("Shopping Cart");
//        mbCart.setTextLine2("Pay Now for CIPC Services");
        if (!Display.getInstance().isTablet()) {

//            TableLayout layout = new TableLayout(2, 1);
//            f.setLayout(layout);
//            f.addComponent(layout.createConstraint().heightPercentage(15).widthPercentage(100), new Label(" "));
//            f.addComponent(layout.createConstraint().heightPercentage(85).widthPercentage(100), cont);
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
            txtStep1a.setText("2012");
            txtStep1b.setText("123460");
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

                String msg = "";

                if (txtStep1a.getText().length() != 4
                        || txtStep1b.getText().length() != 6
                        || txtStep1c.getText().length() != 2) {
                    msg += "Please enter correct Enterprise Number. ";
                }

                if (msg.length() > 0) {
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
                            showDialog("Invalid Enterprise Status \"" + enterpriseDetails.getEnt_status_descr() + "\". Not allowed to file Annual Returns.");

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
                        Dialog.show("Error", "Could not obtain enterprise details. Please ensure that your Enterprise number is valid. ", "Ok", null);
                    }

                }
                f.revalidate();
            }

        });

        //Step 3//Please enter Annual Turnover for the current filing year, 2018:
        contStep3Turnovers = (Container) findByName("contStep3Turnovers", tabs);

        btnStep2Confirm.addActionListener((ActionListener) (ActionEvent evt) -> {

            if (txtARStep2EmailAddress != null
                    && txtARStep2TelCode != null
                    && txtARStep2TelNo != null
                    && txtARStep2BusinessDescription != null) {
                ar2EmailAddress = txtARStep2EmailAddress.getText();
                ar2TelCode = txtARStep2TelCode.getText();
                ar2TelNumber = txtARStep2TelNo.getText();
                ar2CellNumber = txtARStep2CellNumber.getText();
                ar2WebAddress = txtARStep2WebAddress.getText();
                ar2BusinessDescription = txtARStep2BusinessDescription.getText();
                ar2PlaceOfBusiness = txtARStep2PrincipalPlace.getText();
            } else {
                ar2EmailAddress = "";
                ar2TelCode = "";
                ar2TelNumber = "";
                ar2CellNumber = "";
                ar2WebAddress = "";
                ar2BusinessDescription = "";
                ar2PlaceOfBusiness = "";
            }

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

            if ((ar2CellNumber.length() > 0 && isCellPhoneValid(ar2CellNumber))
                    || ar2CellNumber.length() > 0 && ar2CellNumber.length() == 10) {
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
                        + "o   Registered Office\n"
                        + "\n"
                        + "o   Location of Records (if applicable)\n"
                        + "\n"
                        + "o   Directors of Company or members of Close Corporation\n"
                        + "\n"
                        + "o   Company Secretary (if applicable)\n"
                        + "\n"
                        + "o   Auditors and Audit Committees (if applicable)\n"
                        + "\n"
                        + "o   Financial Year End\n"
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
                    return;
                }

            } else {
                formProgress.removeProgress();
                Dialog.show("No Annual Returns", "The Enterprise " + ENT_NUMBER + " has no pending Annual Returns. ", "Ok", null);
            }

        });

        Container contStep4AnnualReturns = (Container) findByName("contStep4AnnualReturns", tabs);

        Label lblTotalDue = (Label) findByName("lblTotalDue", tabs);

        btnStep3CalcOutAmount.addActionListener((ActionListener) (ActionEvent evt) -> {

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
                btn1.setUIID("CIPC_DARK");
                btn2.setUIID("CIPC_DARK");
                btn3.setUIID("CIPC_DARK");
                btn4.setUIID("CIPC_DARK_SELECTED");
                isARStep3Passed = true;
                btnStep4AddToCart.setEnabled(true);
            }

        });

        //Step 4
        btnStep4AddToCart.addActionListener((ActionListener) (ActionEvent evt) -> {

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
                //do nothing
            }

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

        if (formProgress == null) {
            formProgress = new FormProgress(f);
        }

        hideLogout();

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

        //String directURL = Constants.paymentEndPoint + "ACSRedirect.aspx";
        //String errorURL = Constants.paymentEndPoint + "PaymentError.aspx?error=1EwiapDpld0GrXoBVjnhEC52%2fRVCNKIi9Xsi%2fs9YpzA%3d&ref=T9122961860";
        UserWebServices u = new UserWebServices();
        User user = new User();
        user.setAgent_code(AGENT_CODE);
        map = u.getCart(user);

        ArrayList AnnualReturns = (ArrayList) map.get("AnnualReturns");

        ArrayList CartItems = (ArrayList) map.get("CartItems");

        if ((AnnualReturns != null && !AnnualReturns.isEmpty()) || (CartItems != null && !CartItems.isEmpty())) {

            formProgress = new FormProgress(f);
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

                            }
                        }
                    });

                    browser.addWebEventListener("onLoad", new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            Log.p("onLoad: " + browser.getURL(), Log.DEBUG);
                            if (formProgress != null) {
                                formProgress.removeProgress();
                                formProgress = null;

                                Display.getInstance().callSerially(new Runnable() {
                                    @Override
                                    public void run() {
                                        f.revalidate();
                                        Log.p("after revalidate", Log.DEBUG);

                                    }
                                });
                            }

                            if (browser != null && browser.getURL() != null && browser.getURL().indexOf("Pay.aspx") > -1) {
                                if (isCartStep2 == true) {
                                    isCartStep3 = true;
                                }
                            }

                            if (browser != null && browser.getURL() != null && browser.getURL().indexOf("ACSRedirect.aspx") > -1) {
                                if (isCartStep3 == true) {
                                    isCartStep4 = true;
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
                                        Dialog.show("Error", "Payment error. Please contact CIPC.", "Ok", null);
                                        showCart2(f);
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
                }
            });

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
            showDashboard(f);
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

        current = f;

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

            responseUser = userWebServices.get_cust_MOBI(user);

            String errorMessage = "";

            String responsePassword = null;
            if (responseUser == null) {
                formProgress.removeProgress();
                Log.p("exception" + "", Log.DEBUG);

                errorMessage += "Incorrect Customer Code or password. ";

            } else {
                responsePassword = responseUser.getPassword();
            }

            //Log.p(password + ":" + responsePassword);
            if (password != null && password.equals(responsePassword)) {
                AGENT_CODE = txtCustomerCode.toUpperCase();//CIPC web service expects uppercase customer code
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

        } else {
            //error
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
        String strCoutries[] = u.get_countries(null);

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
        final Picker pickerCountry = (Picker) findByName("pickerStep2Country", f);
        stylePicker(pickerCountry);

        pickerCountry.setType(Display.PICKER_TYPE_STRINGS);
        pickerCountry.setStrings(strCoutries);
        pickerCountry.setSelectedStringIndex(0);

        TextField txtStep2FirstName = (TextField) findByName("txtStep2FirstName", tabs);
        TextField txtStep2LastName = (TextField) findByName("txtStep2LastName", tabs);
        TextField txtStep2CellPhone = (TextField) findByName("txtStep2CellPhone", tabs);
        TextField txtStep2Email = (TextField) findByName("txtStep2Email", tabs);
        TextField txtStep2EmailRetype = (TextField) findByName("txtStep2EmailRetype", tabs);
        TextField txtStep2TelephoneNumber = (TextField) findByName("txtStep2TelephoneNumber", tabs);
        TextField txtStep2FaxNumber = (TextField) findByName("txtStep2FaxNumber", tabs);

        TextArea txtStep3Address = (TextArea) findByName("txtStep3Address", tabs);
        TextField txtStep3City = (TextField) findByName("txtStep3City", tabs);
        TextField txtStep3PostalCode = (TextField) findByName("txtStep3PostalCode", tabs);
        Picker step3Province = (Picker) findByName("step3Province", f);
        stylePicker(step3Province);
        step3Province.setType(Display.PICKER_TYPE_STRINGS);
        String[] strProvinces = {"Select Province",
            "Eastern Cape", "Free State", "Gauteng", "Kwazulu Natal", "Limpopo",
            "Mpumlanga", "North West", "Northern Cape", "Western Cape"};
        step3Province.setStrings(strProvinces);
        step3Province.setSelectedStringIndex(0);

        TextArea txtStep3PostalAddress = new TextArea();
        Picker step3PostalProvince = new Picker();
        stylePicker(step3PostalProvince);
        TextField txtStep3PostalCity = new TextField();
        TextField txtStep3PostalPostalCode = new TextField();

        RadioButton rdYes = (RadioButton) findByName("rdYes", tabs);
        RadioButton rdNo = (RadioButton) findByName("rdNo", tabs);

        Container step3PostalCont = (Container) findByName("step3PostalCont", tabs);

        rdNo.addActionListener((ActionListener) (ActionEvent evt) -> {
            boolean isSelected = rdNo.isSelected();
            step3PostalCont.removeAll();

            if (true == isSelected) {

                step3PostalProvince.setType(Display.PICKER_TYPE_STRINGS);
                String[] strPostalProvinces = {"Select Province",
                    "Eastern Cape", "Free State", "Gauteng", "Kwazulu Natal", "Limpopo",
                    "Mpumlanga", "North West", "Northern Cape", "Western Cape"};
                step3PostalProvince.setStrings(strPostalProvinces);
                step3PostalProvince.setSelectedStringIndex(0);

                txtStep3PostalAddress.setName("txtStep3PostalAddress");
                step3PostalProvince.setName("step3PostalProvince");
                txtStep3PostalCity.setName("txtStep3PostalCity");
                txtStep3PostalPostalCode.setName("txtStep3PostalPostalCode");

                Container contStep3PostalProvince = new Container(BoxLayout.y());
                contStep3PostalProvince.setUIID("TextFieldNameSearch");
                step3PostalProvince.setUIID("PickerIcon");
                contStep3PostalProvince.add(step3PostalProvince);
                txtStep3PostalAddress.setUIID("TextFieldNameSearch");
                txtStep3PostalCity.setUIID("TextFieldNameSearch");
                txtStep3PostalPostalCode.setUIID("TextFieldNameSearch");

                Label lbl1 = new Label("Postal Address");
                Label lbl2 = new Label("Postal Province");
                Label lbl3 = new Label("Postal City");
                Label lbl4 = new Label("Postal Code");

                lbl1.setUIID("LabelRegistration");
                lbl2.setUIID("LabelRegistration");
                lbl3.setUIID("LabelRegistration");
                lbl4.setUIID("LabelRegistration");

                step3PostalCont.add(lbl1).add(txtStep3PostalAddress);
                step3PostalCont.add(lbl2).add(contStep3PostalProvince);
                step3PostalCont.add(lbl3).add(txtStep3PostalCity);
                step3PostalCont.add(lbl4).add(txtStep3PostalPostalCode);
                //step3PostalCont.add("").add();

                if (Display.getInstance().isSimulator()) {
                    if (Display.getInstance().isSimulator()) {
                        step3PostalProvince.setSelectedStringIndex(3);
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
            String msg = "";
            if (txtStep1IDNumber.getText().length() != 13) {
                msg += "Please enter 13 character ID Number. ";
            }

            //verify id
            String customer_code = u.Get_Cust_code_id_MOBI(txtStep1IDNumber.getText());

            if (customer_code != null && customer_code.length() == 6) {
                msg += "The ID number " + txtStep1IDNumber.getText() + " is already registered with the following Customer Code: " + customer_code;
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
                Dialog.show("Error", msg, "Ok", null);
            }

        });

        if (Display.getInstance().isSimulator()) {
            //Step 1
            txtStep1IDNumber.setText("9001215598085");
            //Step 2
            pickerCountry.setSelectedStringIndex(1);
            txtStep2FirstName.setText("Blessing");
            txtStep2LastName.setText("Mahlalela");
            txtStep2CellPhone.setText("0763598094");
            txtStep2Email.setText("blessing@mfactory.mobi");
            txtStep2EmailRetype.setText("blessing@mfactory.mobi");
            //Step 3
            step3Province.setSelectedStringIndex(3);
            txtStep3Address.setText("Address will go here");
            txtStep3City.setText("Pretoria");
            txtStep3PostalCode.setText("0001");
            //Step 4
            txtStep4Password.setText("Password12");
            txtStep4PasswordRetype.setText("Password12");

        }

        btnStep2Continue.addActionListener((ActionListener) (ActionEvent evt) -> {

            Log.p("pickerCountry=" + pickerCountry.getSelectedString(), Log.DEBUG);

            String msg = "";
            if (pickerCountry.getSelectedString() == null
                    || pickerCountry.getSelectedStringIndex() == 0
                    || pickerCountry.getSelectedString().equals("Select Country")) {
                msg += "Please select a country. ";
            }

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
                Dialog.show("Error", msg, "Ok", null);
            }

        });

        btnStep3Next.addActionListener((ActionListener) (ActionEvent evt) -> {

            Log.p("pickerStep3Province=" + step3Province.getSelectedString(), Log.DEBUG);

            String msg = "";
            if (step3Province.getSelectedString() == null
                    || step3Province.getSelectedStringIndex() == 0
                    || step3Province.getSelectedString().equals("Select Province")) {
                msg += "Please select Physical Province. ";
            }

            if (txtStep3Address.getText().length() == 0) {
                msg += "Please enter Physical Address. ";
            }
            if (txtStep3City.getText().length() == 0) {
                msg += "Please enter Physical City. ";
            }

            if (txtStep3PostalCode.getText().length() == 0) {
                msg += "Please select Physical Code. ";
            }

            if (rdNo.isSelected()) {
                //POSTAL VALIDATIONS
                if (step3PostalProvince.getSelectedString() == null
                        || step3PostalProvince.getSelectedStringIndex() == 0
                        || step3PostalProvince.getSelectedString().equals("Select Postal Province")) {
                    msg += "Please select Postal Province. ";
                }

                if (txtStep3PostalAddress.getText().length() == 0) {
                    msg += "Please enter Postal Address. ";
                }
                if (txtStep3PostalCity.getText().length() == 0) {
                    msg += "Please enter Physical City. ";
                }

                if (txtStep3PostalPostalCode.getText().length() == 0) {
                    msg += "Please postal Code. ";
                }

            }

            if (msg.length() == 0) {
                isRegStep3Passed = true;
                btnStep4Register.setEnabled(true);
                tabs.setSelectedIndex(3);
                btn1.setUIID("CIPC_DARK");
                btn2.setUIID("CIPC_DARK");
                btn3.setUIID("CIPC_DARK");
                btn4.setUIID("CIPC_DARK_SELECTED");
            } else {
                Dialog.show("Error", msg, "Ok", null);
            }

        });

        btnStep4Register.addActionListener((ActionListener) (ActionEvent evt) -> {
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
                tmpUser.setFirst_name(txtStep2FirstName.getText());
                tmpUser.setLast_name(txtStep2LastName.getText());
                tmpUser.setCell_no(txtStep2CellPhone.getText());
                tmpUser.setEmail(txtStep2Email.getText());
                tmpUser.setTel_code("");
                tmpUser.setTel_no(txtStep2TelephoneNumber.getText());
                tmpUser.setFax_code("");
                tmpUser.setFax_no(txtStep2FaxNumber.getText());

                //step 3
                tmpUser.setPhys_addr1(txtStep3Address.getText());//Street
                tmpUser.setPhys_addr2(txtStep3City.getText());//City
                tmpUser.setPhys_addr3(step3Province.getSelectedString());//Province
                tmpUser.setPost_code(txtStep3PostalCode.getText());

                if (rdNo.isSelected()) {//only when radio button is selected
                    tmpUser.setPost_addr1(txtStep3PostalAddress.getText());
                    tmpUser.setPost_addr2(txtStep3PostalCity.getText());
                    tmpUser.setPost_addr3(step3PostalProvince.getSelectedString());
                    tmpUser.setPost_code(txtStep3PostalPostalCode.getText());
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
                    Dialog.show("Error", result, "Ok", null);
                } else {
                    Dialog.show("Success", result, "Ok", null);
                    showForm("Login", null);
                    isRegStep1Passed = false;
                    isRegStep2Passed = false;
                    isRegStep3Passed = false;
                }

            } else {
                Dialog.show("Error", msg, "Ok", null);
            }

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

        isTableInputForm(f);

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
        lblVersion.setText("v" + currentAppVersion);
        lblVersion.repaint();

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
                    String url = u.get_terms(null);

                    //url = "https://drive.google.com/file/d/1XKmFRBcgEn0iY1vV18jRgpbgfXfQbQBy/view?usp=sharing";
                    //url = "https://www.dropbox.com/s/shsokeklu20gwc8/TermsandConditions_version_Final%203.0.pdf?dl=0";
                    FileSystemStorage fs = FileSystemStorage.getInstance();
                    String currentAppVersion = "app_version_" + Display.getInstance().getProperty("AppVersion", "Unknown");
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

        //Dialog.show("Title", "Body", "Yes", null);
    }

    @Override
    protected boolean onForgotPasswordRequest() {
        String customerCode = findTxtCustomerCode().getText();

        String msg = "";

        if (customerCode.length() == 0) {
            msg += "Enter Customer Code. ";

        }

        if (msg.length() == 0) {
            UserWebServices u = new UserWebServices();
            String res1 = u.forget_password_MOBI(customerCode);
            //Log.p("res1 len=" + res1.length(), Log.DEBUG);
            if (res1.indexOf("The Password was sent to the registered") > -1) {
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

    public static String changeComma(String s) {
        String original = s.substring(0, s.length() - 3);
        s = s.substring(s.length() - 3, s.length());
        if (s.indexOf(",") > -1) {
            s = StringUtil.replaceAll(s, ",", ".");
        }
        s = original + s;
        return s;
    }

}
