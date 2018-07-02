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
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TimeZone;
import org.bouncycastle.crypto.InvalidCipherTextException;
import services.Utility;
import za.co.cipc.webservices.UserWebServices;
import ui.FormProgress;
import za.co.cipc.pojos.User;
//TESTING UPLOAD

/**
 *
 * @author Your name here
 */
public class StateMachine extends StateMachineBase {

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

    static boolean isCartStep1Passed = false;

    String ENT_NUMBER;
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

    public StateMachine(String resFile) {
        super(resFile);
        // do not modify, write code in initVars and initialize class members there,
        // the constructor might be invoked too late due to race conditions that might occur
    }

    protected void initVars(Resources res) {

        NetworkManager.getInstance().addErrorListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        if (Display.getInstance().isTablet()) {
            Toolbar.setPermanentSideMenu(true);
        }

        if (Display.getInstance().isSimulator()) {

            AGENT_CODE = "BLE076";

            //Log.p("dateString = " + dateString, Log.DEBUG);
            //Test Name Service
//            UserWebServices u = new UserWebServices();
//            String randomName = getRandomString(10);
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
            //String entNo = getShortEnterpriseName("2011", "100088", "07");
            //System.out.println("enta=" + entNo);
//            //AGENT_CODE = "BLE076";
//            UserWebServices u = new UserWebServices();
//            User user = new User();
//            user.setAgent_code(AGENT_CODE);
            //u.getCustomerData(user);
            //u.pendingAnnualReturns(user, entNo);
//
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
//
//            //Step 1: check id if registered with CIPC. if exists show user customer code
//            tmpUser.setAgent_id_no("9001215598086");
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

            defaultEmail = "BLE076";
            defaultPassword = "Password12";

            Log.setLevel(Log.DEBUG);
            Log.p("issimulator", Log.DEBUG);

            return "Login";
            //return "Registration";

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

    public void showProfile(final Form f) {
        formProgress = new FormProgress(f);
        closeMenu(f, true);

    }

    public void uploadProfileImage(String title, Form f, String path, EncodedImage placeHolder, Label lblImage) {

        formProgress = new FormProgress(f);
        formProgress.removeProgress();

    }

    public void showNameReservation(Form f, String taskType) {
        formProgress = new FormProgress(f);
        closeMenu(f, true);

        Container contentPane = f.getContentPane();
        contentPane.removeAll();
        Container contTasks = (Container) createContainer("/theme", "ContTasks");

        Label lblLine1 = (Label) findByName("lblLine1", contTasks);

        TextField txtName1 = (TextField) findByName("txtName1", contTasks);
        TextField txtName2 = (TextField) findByName("txtName2", contTasks);
        TextField txtName3 = (TextField) findByName("txtName3", contTasks);
        TextField txtName4 = (TextField) findByName("txtName4", contTasks);

        Label lblName1Response = (Label) findByName("lblName1Response", contTasks);
        Label lblName2Response = (Label) findByName("lblName2Response", contTasks);
        Label lblName3Response = (Label) findByName("lblName3Response", contTasks);
        Label lblName4Response = (Label) findByName("lblName4Response", contTasks);

        Button btnVerify = (Button) findByName("btnVerify", contTasks);
        Button btnLodge = (Button) findByName("btnLodge", contTasks);
        
        if(Display.getInstance().isSimulator()){
            txtName1.setText(getRandomString(10));
        }

        btnVerify.addActionListener((ActionListener) (ActionEvent evt) -> {
            String name1 = txtName1.getText();
            String name2 = txtName2.getText();
            String name3 = txtName3.getText();
            String name4 = txtName4.getText();

            String msg = "";

            if (name1.length() == 0) {
                msg += "Please submit at least Name 1. ";
            }

            if (msg.length() > 0) {
                Dialog.show("Error", msg, "Ok", null);
            } else {

                UserWebServices u = new UserWebServices();
                arrayListNameReservation = u.search_name_MOBI(AGENT_CODE, name1, name2, name3, name4);

                for (int i = 0; i < arrayListNameReservation.size(); i++) {
                    int count = i + 1;
                    Label lblResponse = (Label) findByName("lblName" + count + "Response", contTasks);
                    NameSearchObject n = arrayListNameReservation.get(i);
                    if (n.isIsValid()) {
                        lblResponse.setText("Might be available");
                        lblResponse.setUIID("LabelGreen");
                    } else {
                        lblResponse.setText("Is not available");
                        lblResponse.setUIID("LabelRed");

                    }
                }

                //lblLine1.scrollRectToVisible(BACK_COMMAND_ID, BACK_COMMAND_ID, BACK_COMMAND_ID, BACK_COMMAND_ID, contentPane);
                contTasks.repaint();
            }
        });

        btnLodge.addActionListener((ActionListener) (ActionEvent evt) -> {
            String name1 = txtName1.getText();
            String name2 = txtName2.getText();
            String name3 = txtName3.getText();
            String name4 = txtName4.getText();

            String msg = "";

            if (arrayListNameReservation == null || arrayListNameReservation.size() == 0) {
                msg += "Please validate Names before clicking on Add to Cart. ";
            } else if (name1.length() == 0) {
                msg += "Please submit at least Name 1. ";
            }

            if (msg.length() > 0) {
                Dialog.show("Error", msg, "Ok", null);
            } else {
                UserWebServices u = new UserWebServices();

                //Dialog.show("Output 1", "AGENT_CODE=" + AGENT_CODE + " name1=" + name1
                //      + ", name2=" + name2 + ", name3=" + name3 + ", name4=" + name4, "Ok", null);
                NameReservation responseCall = u.Namereservation_MOBI(AGENT_CODE, name1, name2, name3, name4);

                //Dialog.show("Output 2", "AGENT_CODE=" + AGENT_CODE + " name1=" + name1
                //      + ", name2=" + name2 + ", name3=" + name3 + ", name4=" + name4, "Ok", null);
                if (responseCall != null
                        && responseCall.getResponseMessage().indexOf("already filed") == -1) {
                    Dialog.show("Success", responseCall.getResponseMessage(), "Ok", null);

                    Log.p("Name reservation responseCall=" + responseCall, Log.DEBUG);

                    User tempUser = new User();
                    tempUser.setAgent_code(AGENT_CODE);
                    //getReferenceNo
                    //NameReservation n = getNameReservationReferenceNo(responseCall);

                    // Dialog.show("Output 5 referenceNo", "AGENT_CODE=" + AGENT_CODE + " referenceNo="
                    //       + referenceNo, "Ok", null);
                    u.insertCartItemService(responseCall);

                    showCart(f);
                } else if (responseCall != null
                        && responseCall.getResponseMessage().indexOf("already filed") != -1) {
                    Dialog.show("Error", responseCall.getResponseMessage(), "Ok", null);//TODO scroll to top
                } else {
                    Dialog.show("Error", "Error occurred while processing your request. Please try again later or contact CIPC.", "Ok", null);
                }
            }

        });

        f.add(contTasks);

        if (formProgress != null) {
            formProgress.removeProgress();
        }

    }

    public void showDashboard(final Form f) {
        formProgress = new FormProgress(f);
        closeMenu(f, true);

        f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));

        analytics(f, "Dashboard");

        Container contentPane = f.getContentPane();
        contentPane.removeAll();
        Container cont = (Container) createContainer("/theme", "ContDashBoard");

        MultiButton mbTasks = (MultiButton) findByName("mbTasks", cont);

        mbTasks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                formProgress = new FormProgress(f);
                showNameReservation(f, Const.TASK_TODAY);
            }
        });

        MultiButton mbCurrency = (MultiButton) findByName("mbCurrency", cont);
        mbCurrency.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                formProgress = new FormProgress(f);
                showAnnualReturns(f);
            }
        });

        MultiButton mbCart = (MultiButton) findByName("mbCart", cont);
        mbCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                formProgress = new FormProgress(f);
                showCart(f);
            }
        });

        mbTasks.setTextLine1("Name Reservations");
        mbTasks.setTextLine2("Lodge Name(s)");

        mbCurrency.setTextLine1("Annual Returns");
        mbCurrency.setTextLine2("Submit Enterprise Returns");

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

    public void showAnnualReturns(final Form f) {

        f.setLayout(new BorderLayout());

        UserWebServices u = new UserWebServices();
        final ArrayList list = u.Get_AR_ent_type_mobi(null);

        formProgress = new FormProgress(f);
        closeMenu(f, true);
        analytics(f, "Annual Returns");
        current = f;
        Container contentPane = f.getContentPane();
        contentPane.removeAll();
        Container contProjects = (Container) createContainer("/theme", "ContProjects");
        Container contStep2 = (Container) findByName("contStep2", contProjects);

        Tabs tabs = (Tabs) findByName("Tabs", contProjects);
        tabs.setSwipeActivated(false);
        tabs.hideTabs();

        Button btn1 = new Button("1");
        Button btn2 = new Button("2");
        Button btn3 = new Button("3");
        Button btn4 = new Button("4");

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //Log.p("clicked btn1", Log.DEBUG);
                tabs.setSelectedIndex(0);
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //Log.p("clicked btn2, isRegStep1Passed=" + isRegStep1Passed
                //   + ", isRegStep2Passed=" + isRegStep2Passed, Log.DEBUG);
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

        if (Display.getInstance().isSimulator()) {//2011100088 & K2013064531 & 2014 004548 07
            //Not allowed: 1999/028585/07
            txtStep1a.setText("2011");
            txtStep1b.setText("100088");
            txtStep1c.setText("07");
        }

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

        btnStep1RetrieveDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                String msg = "";

                if (txtStep1a.getText().length() != 4
                        || txtStep1b.getText().length() != 6
                        || txtStep1c.getText().length() != 2) {
                    msg += "Please enter correct Enterprise Number.";
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
                    String entNo = getShortEnterpriseName(txtStep1a.getText(), txtStep1b.getText(),
                            txtStep1c.getText());
//                    Map map = u.pendingAnnualReturns(user, entNo);
//
//                    if (map != null & map.size() > 0) {
//                        Dialog.show("Error", "Annual Returns are already in a Shopping cart. "
//                                + "Please process payment or try again tomorrow.", "Ok", null);
//                        return; //TODO better way to exit
//                    }

                    enterpriseDetails = u.soap_GetEnterpriseDetails(ENT_NUMBER); //"K2013064531");//2014 / 016320 /  07

                    if (enterpriseDetails != null) {
                        lblStep2EnterpriseNumber.setText(enterpriseDetails.getEnt_no());
                        lblStep2EnterpriseName.setText(enterpriseDetails.getEnt_name());
                        lblStep2EnterpriseType.setText(enterpriseDetails.getEnt_type_descr());
                        lblStep2EnterpriseStatus.setText(enterpriseDetails.getEnt_status_descr());
                        lblStep2RegistrationDate.setText(enterpriseDetails.getReg_date());

                        tabs.setSelectedIndex(1);
                        isARStep1Passed = true;
                        btnStep2Confirm.setEnabled(true);

                        //Step 2
                        Log.p("code=" + enterpriseDetails.getEnt_status_code(), Log.DEBUG);

                        if (enterpriseDetails.getEnt_status_code().equals("03")
                                || enterpriseDetails.getEnt_status_code().equals("38")) {

                            btnStep2Confirm.setVisible(true);
                            btnStep2Confirm.repaint();

                        } else {
                            showDialog("Invalid Enterprise Status \"" + enterpriseDetails.getEnt_status_descr() + "\". Not allowed to file Annual Returns.");

                            btnStep2Confirm.setVisible(false);
                            btnStep2Confirm.repaint();
                        }

                    } else {
                        Dialog.show("Error", "Could not obtain enterprise details. Please ensure that your Enterprise number is valid", "Ok", null);
                    }

                }

            }
        });

        //Step 3//Please enter Annual Turnover for the current filing year, 2018:
        contStep3Turnovers = (Container) findByName("contStep3Turnovers", tabs);

        btnStep2Confirm.addActionListener((ActionListener) (ActionEvent evt) -> {
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
                    TextArea txt0b = new TextArea();
                    txt0b.setHint("Amount in rands");
                    txt0b.setConstraint(TextField.DECIMAL);
                    if (Display.getInstance().isSimulator()) {
                        txt0b.setText("0");
                    }
                    listTextEnterpriseDetails.add(txt0b);
                    cont0.add(txt0a).add(txt0b);
                    contStep3Turnovers.add(cont0);
                }
                contStep3Turnovers.repaint();

            }

            tabs.setSelectedIndex(2);
            isARStep2Passed = true;
            btnStep3CalcOutAmount.setEnabled(true);
        });

        Container contStep4AnnualReturns = (Container) findByName("contStep4AnnualReturns", tabs);

        Label lblTotalDue = (Label) findByName("lblTotalDue", tabs);

        btnStep3CalcOutAmount.addActionListener((ActionListener) (ActionEvent evt) -> {

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
                    mb.setTextLine1("Enterprise No: " + e.getEnt_no());
                    mb.setTextLine2("Reference No: " + e.getReference_no());
                    mb.setTextLine3("AR Year: " + e.getAr_year() + ", Turnover: R" + e.getTurnover());
                    mb.setTextLine4("AR Amount: R" + e.getAr_amount() + ", Penalty: R" + e.getAr_penalty());

                    contStep4AnnualReturns.add(mb);

                }

                if (listCalculateARTran.size() > 0) {
                    EnterpriseDetails lastObject = listCalculateARTran.get(listCalculateARTran.size() - 1);
                    lblTotalDue.setText("Total Due: R" + lastObject.getAr_total());
                    lblTotalDue.repaint();
                }

                contStep4AnnualReturns.repaint();

                tabs.setSelectedIndex(3);
                isARStep3Passed = true;
                btnStep4AddToCart.setEnabled(true);
            }

        });

        //Step 4
        btnStep4AddToCart.addActionListener((ActionListener) (ActionEvent evt) -> {

            User newUser = new User();
            newUser.setAgent_code(AGENT_CODE);

            EnterpriseDetails tempDetails = listCalculateARTran.get(0);

            tempDetails.setCustomerCode(AGENT_CODE);

            u.insertCartItemAR(newUser, listCalculateARTran);

            isARStep1Passed = false;
            isARStep2Passed = false;
            isARStep3Passed = false;

            Dialog.show("Success", "Annual Return (s) added to shopping cart", "Ok", null);
            showCart(f);

        });

        Container contTop = new Container();
        contTop.setUIID("LabelWhite");
        contTop.setLayout(new GridLayout(1, 4));
        contTop.add(btn1).add(btn2).add(btn3).add(btn4);

        f.add(BorderLayout.NORTH, contTop);

        f.add(BorderLayout.CENTER, contProjects);

        if (formProgress != null) {
            formProgress.removeProgress();
        }

    }

    public void showCart(final Form f) {
        Container cont = (Container) createContainer("/theme", "ContCart");

        Container contStep2 = (Container) findByName("contStep2", cont);
        contStep2.removeAll();
        contStep2.setLayout(new BorderLayout());

        Log.p("width=" + width + ", height=" + height, Log.DEBUG);
        //Dialog.show("", "width=" + width + ", height=" + height, "Ok", null);

        //String URL = "http://www.google.com";
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

        String URL = "https://paymenttest.cipc.co.za/Pay.aspx?custCode=" + encodedCustCode + "&custId=" + encodedCustCode + "&appId=6"
                + "&width=" + width + "&height=" + height;
        Log.p(URL, Log.DEBUG);

        hasGonePastACS = false;

        String directURL = "https://paymenttest.cipc.co.za/ACSRedirect.aspx";
        String errorURL = "https://paymenttest.cipc.co.za/PaymentError.aspx?error=1EwiapDpld0GrXoBVjnhEC52%2fRVCNKIi9Xsi%2fs9YpzA%3d&ref=T9122961860";

        BrowserComponent browser = new BrowserComponent();
        browser.setURL(URL);
        browser.setScrollableX(false);
        browser.setScrollableY(false);
        browser.setPinchToZoomEnabled(false);

        browser.addWebEventListener("onStart", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Log.p("onStart", Log.DEBUG);
            }
        });

        browser.addWebEventListener("onLoad", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Log.p("onLoad", Log.DEBUG);
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
                            showDashboard(f);
                            Dialog.show("Success", "Payment processed. Transaction Number " + trans, "Ok", null);

                        }
                    });

                } else if (url.indexOf("PaymentError") > -1) {

                    Display.getInstance().callSerially(new Runnable() {
                        @Override
                        public void run() {
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
            contentPane.setLayout(new GridLayout(1, 1));
            contentPane.removeAll();

            Tabs tabs = (Tabs) findByName("Tabs", cont);
            tabs.setSwipeActivated(false);
            tabs.hideTabs();

            Log.p("Cart agent=" + AGENT_CODE, Log.DEBUG);

            Container contStep1AnnualReturns = (Container) findByName("contStep1AnnualReturns", tabs);
            contStep1AnnualReturns.removeAll();
            Container contStep1EServices = (Container) findByName("contStep1EServices", tabs);
            contStep1EServices.removeAll();
            Label lblTotal = (Label) findByName("lblTotal", tabs);

            String CustomerCode = map.get("CustomerCode").toString();
            double AnnualReturnsTotalAmount = Double.parseDouble(map.get("AnnualReturnsTotalAmount").toString());
            double ItemDataTotalAmount = Double.parseDouble(map.get("ItemDataTotalAmount").toString());
            double TotalAmount = Double.parseDouble(map.get("TotalAmount").toString());
            double ItemsCount = Double.parseDouble(map.get("ItemsCount").toString());

            double eserviceTotal = 0.0;

            if (AnnualReturns != null) {
                Log.p("Annual Returns=" + AnnualReturns.size(), Log.DEBUG);

                if(!AnnualReturns.isEmpty()){
                    Label lbl = new Label("ANNUAL RETURNS");
                    contStep1EServices.add(lbl);
                }
                
                
                //Annual Returns
                for (Object o : AnnualReturns) {

                    Container contItem = new Container(BoxLayout.y());
                    contItem.setUIID("CalendarDay");
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
                    mb.setTextLine2("Enterprise No: " + EnterpriseNumber);
                    //mb.setTextLine3("Service: " + ItemType);
                    mb.setTextLine3("Item Cost: R" + TotalAmountItemType);

                    Container c0 = new Container();
                    Button btnRemove0 = new Button("REMOVE");
                    //c0.add(btnRemove0);
                    contItem.add(mb).add(c0);
                    contStep1EServices.add(contItem);

                }
            }

            if (CartItems != null) {
                Log.p("CartItems=" + CartItems.size(), Log.DEBUG);
                
                if(!CartItems.isEmpty()){
                    Label lbl = new Label("E-SERVICES");
                    contStep1EServices.add(lbl);
                }
                //CartItems
                for (Object o : CartItems) {

                    Container contItem = new Container(BoxLayout.y());
                    contItem.setUIID("CalendarDay");
                    Map m = (Map) o;
                    String ItemType = m.get("ItemType").toString();
                    String StatusDate = m.get("StatusDate").toString();
                    String ReferenceNumber = L10NManager.getInstance().format(Double.parseDouble(m.get("ReferenceNumber").toString()));
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
                    mb.setTextLine3("Item Cost: R" + TotalAmountItemType);

                    Container c0 = new Container();
                    Button btnRemove0 = new Button("REMOVE");
                    //c0.add(btnRemove0);
                    contItem.add(mb).add(c0);
                    contStep1EServices.add(contItem);

                }
            }

            lblTotal.setText("Total: R" + eserviceTotal);
            lblTotal.repaint();

            tabs.addSelectionListener(new SelectionListener() {
                @Override
                public void selectionChanged(int oldSelected, int newSelected) {
                    if (newSelected == 1) {

                    }
                }
            });

            Button btnCheckout = (Button) findByName("btnCheckout", tabs);
            btnCheckout.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    tabs.setSelectedIndex(1);
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
            f.add(cont);

        } else {
            Dialog.show("No Items", "You do not have any cart items. Please lodge a Name Reservation or submit Annual Returns.", "Ok", null);
            showDashboard(f);
        }

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

        Container contSideMenu = (Container) createContainer("/theme", "ContSideMenu");
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

            za.co.cipc.pojos.User responseUser = userWebServices.get_cust_MOBI(user);

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

        current = f;
        f.setScrollVisible(false);
        Container containerParent = (Container) findByName("containerParent", f);
        Container contentPane = f.getContentPane();
        contentPane.setScrollVisible(false);
        containerParent.setScrollVisible(false);

        f.repaint();

        if (Display.getInstance().isSimulator()) {
            TextField txtCustomerCode = (TextField) findByName("txtCustomerCode", f);
            //txtCustomerCode.setText("BLE076");
            TextField txtPassword = (TextField) findByName("txtPassword", f);
            //txtPassword.setText("Password12");

            txtCustomerCode.setText("BLE076");
            txtPassword.setText("Password1");

        }

    }

    public void checkRegButtonPressed() {

        String msg = "";

        if (isRegStep1Passed == false) {
            msg = "Please complete step 1 first.";
        } else if (isRegStep2Passed == false) {
            msg = "Please complete step 2 first.";
        } else if (isRegStep3Passed == false) {
            msg = "Please complete step 3 first.";
        }

        Dialog.show("Error", msg, "Ok", null);

    }

    public void checkARButtonPressed() {

        String msg = "";

        if (isARStep1Passed == false) {
            msg = "Please complete step 1 first.";
        } else if (isARStep2Passed == false) {
            msg = "Please complete step 2 first.";
        } else if (isARStep3Passed == false) {
            msg = "Please complete step 3 first.";
        }

        Dialog.show("Error", msg, "Ok", null);

    }

    @Override
    protected void beforeRegistration(Form f) {

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

        Picker pickerCountry = (Picker) findByName("pickerStep2Country", f);

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
        step3Province.setType(Display.PICKER_TYPE_STRINGS);
        String[] strProvinces = {"Select Province",
            "Eastern Cape", "Free State", "Gauteng", "Kwazulu Natal", "Limpopo",
            "Mpumlanga", "North West", "Northern Cape", "Western Cape"};
        step3Province.setStrings(strProvinces);
        step3Province.setSelectedStringIndex(0);

        TextArea txtStep3PostalAddress = new TextArea();
        Picker step3PostalProvince = new Picker();
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

                step3PostalCont.add("Postal Address").add(txtStep3PostalAddress);
                step3PostalCont.add("Postal Province").add(step3PostalProvince);
                step3PostalCont.add("Postal City").add(txtStep3PostalCity);
                step3PostalCont.add("Postal Code").add(txtStep3PostalPostalCode);
                //step3PostalCont.add("").add();

                if (Display.getInstance().isSimulator()) {
                    if (Display.getInstance().isSimulator()) {
                        step3PostalProvince.setSelectedStringIndex(3);
                        txtStep3PostalAddress.setText("Postal Address");
                        txtStep3PostalCity.setText("Pretoria");
                        txtStep3PostalPostalCode.setText("0001");
                    }
                }

                step3PostalCont.repaint();

            }

        });

        rdYes.addActionListener((ActionListener) (ActionEvent evt) -> {
            boolean isSelected = rdYes.isSelected();

            if (true == isSelected) {
                step3PostalCont.removeAll();
                step3PostalCont.repaint();
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
                Dialog.show("ID Number", "The CIPC App is only available to users that have valid South African IDs", "Ok", null);
            }
        });

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

            if (txtStep2CellPhone.getText().length() == 0) {
                msg += "Please enter Cell Phone Number. ";
            }
            if (txtStep2Email.getText().length() == 0) {
                msg += "Please enter Email. ";
            }

            if (txtStep2EmailRetype.getText().length() == 0) {
                msg += "Please retytpe Email. ";
            }

            if (txtStep2Email.getText()
                    .indexOf(txtStep2EmailRetype.getText()) < 0) {
                msg += "Emails are not the same.";

            }

            if (msg.length() == 0) {

                isRegStep2Passed = true;
                btnStep3Next.setEnabled(true);
                tabs.setSelectedIndex(2);
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
                tmpUser.setTel_no(txtStep2FaxNumber.getText());
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

        btnStep4ViewPasswordRules.addActionListener((ActionListener) (ActionEvent evt) -> {

            String text = "It must be a minimum of 8 characters.\n"
                    + "At least 1 UPPERCASE letter.\n"
                    + "At least 1 lowercase letter\n"
                    + "At least I number\n"
                    + "Special characters are optional\n"
                    + "Only these characters are allowed:@,$,=,!,#,%";

            Dialog.show("Password Rules", text, "Ok", null);

            //last validation and actual submission
        });

        Button btn1 = new Button("1");
        Button btn2 = new Button("2");
        Button btn3 = new Button("3");
        Button btn4 = new Button("4");

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //Log.p("clicked btn1", Log.DEBUG);
                tabs.setSelectedIndex(0);
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //Log.p("clicked btn2, isRegStep1Passed=" + isRegStep1Passed
                //   + ", isRegStep2Passed=" + isRegStep2Passed, Log.DEBUG);
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
        contTop.setUIID("LabelWhite");
        contTop.setLayout(new GridLayout(1, 4));
        contTop.add(btn1).add(btn2).add(btn3).add(btn4);

        f.add(BorderLayout.NORTH, contTop);

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

        Command back = new Command("Login") {

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
        height = Display.getInstance().getDisplayHeight();
        width = Display.getInstance().getDisplayWidth();
    }

    @Override
    protected void onForgotPassword_BtnRecoverPasswordAction(Component c, ActionEvent event) {

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
            if (res1.indexOf("not registered") > -1) {
                Dialog.show("Error", res1, "Ok", null);
                return true;
            } else {
                Dialog.show("Success", res1, "Ok", null);
            }

        } else {
            Dialog.show("Error", msg, "Ok", null);
            return true;
        }
        return false;
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

    public String getShortEnterpriseName(String year, String body, String type) {
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

}
