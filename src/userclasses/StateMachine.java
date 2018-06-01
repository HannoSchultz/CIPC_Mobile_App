package userclasses;

import ca.weblite.codename1.json.JSONArray;
import ca.weblite.codename1.json.JSONException;
import ca.weblite.codename1.json.JSONObject;
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
import com.parse4cn1.Parse;
import com.parse4cn1.ParseCloud;
import com.parse4cn1.ParseException;
import com.parse4cn1.ParseObject;
import com.parse4cn1.ParseQuery;
import com.parse4cn1.ParseUser;
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
    private ParseObject isAllowedObject = null;

    private String[] arrDevices;
    private String action = "";
    private Form current;
    private User oldUser;
    private String devicesString = "";

    private Container contCommunicationc;
    private ParseUser user;
    private Button btnProfilePic;
    private Button btnProfileName;
    private EncodedImage placeHolder;
    private Form newTask;
    private java.util.HashMap<String, ParseObject> taskUsers;

    private static String taskId = "";
    private ParseObject task;
    private static String defaultEmail = "";
    private static String defaultPassword = "";
    private static FormProgress formProgress;
    private String message = "";
    private java.util.List<ParseObject> listOfExistingMembers;
    private static ParseObject taskToAdd = null;
    private static java.util.List<Project> projects = null;

    public StateMachine(String resFile) {
        super(resFile);
        // do not modify, write code in initVars and initialize class members there,
        // the constructor might be invoked too late due to race conditions that might occur
    }

    protected void initVars(Resources res) {

        if (Display.getInstance().isTablet()) {
            Toolbar.setPermanentSideMenu(true);
        }

        //Log.setLevel(Log.INFO);
//        try{
//            String json = ParseCloud.callFunction("CloudJobTesting", null);//taskReport
//            Log.p("json: " +json, Log.DEBUG);
//        }
//        catch(ParseException e){
//            Log.p("Error CloudJobTesting: " + "", Log.DEBUG);
//        }
//
//        Display.getInstance().exitApplication();
//      //TaskService s = new TaskService();
//      //s.getTasks(null, Const.TASK_TODAY, false);

        /*GANative ga = GANative.getInstance();
        ga.setLocalDispatchPeriod(30);

        tracker = ga.newTracker(Const.GOOGLE_ANALYTICS_APP_ID);//MOBILE APP
        tracker.setAppName(Const.GOOGLE_ANALYTICS_APP_NAME);
        tracker.setAppVersion(Const.GOOGLE_ANALYTICS_APP_VERSION);*/
        String platform = Display.getInstance().getPlatformName();
  
               

    }

    @Override
    protected String getFirstFormName() {

        if (Display.getInstance().isSimulator()) {//Prepoluate with Debug info

            defaultEmail = "KD7788";
            defaultPassword = "fijiaudi";

//            try {
//                HashMap<String, String> hash = new HashMap<>();
//                hash.put("target", "blessing@mfactory.mobi");
//                hash.put("originator", "bless005@gmail.com");
//                hash.put("subject", "Hi");
//                hash.put("text", "Ok<br/>there<br/>");
//                final JSONArray helloWorld = ParseCloud.callFunction("mailSend", null);
//                Log.setLevel(Log.DEBUG);
//                Log.p("hello=" + helloWorld);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//
//            Display.getInstance().exitApplication();
            Log.setLevel(Log.DEBUG);
            Log.p("issimulator", Log.DEBUG);

            //if (Log.getLevel() == Log.DEBUG) {
            //}
            return "Login";
            //return super.getFirstFormName();

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

        //Image logoImage = fetchResourceFile().getImage("logo_title.png 1");
        /*if (toolbar.getTitleComponent() instanceof Label
                && (screenName.equals("Main") || screenName.equals("Dashboard"))) {//Home Screen
            Label title = (Label) toolbar.getTitleComponent();
            title.setUIID("ToolboxTitle");
            title.setIcon(logoImage);
            toolbar.setTitle("");
        } else */
        if (toolbar.getTitleComponent() instanceof Label) {

            Label title = (Label) toolbar.getTitleComponent();
            title.setUIID("LabelWhiteCenter");
            toolbar.setTitle(screenName);
            toolbar.setUIID("LabelWhiteCenter");
            title.setIcon(null);

        }

        //toolbar.
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

//        analytics(f, "Profile");
//
//        message = "";
//
//        Container contentPane = f.getContentPane();
//        contentPane.removeAll();
//        Container cont = (Container) createContainer("/theme", "ContProfile");
//
//        TextField txtEmail = (TextField) findByName("txtEmail", cont);
//        TextField txtFirstName = (TextField) findByName("txtFirstName", cont);
//        TextField txtLastName = (TextField) findByName("txtLastName", cont);
//
//        Button btnCamera = (Button) findByName("btnCamera", cont);
//        Button btnGallery = (Button) findByName("btnGallery", cont);
//        Button btnUpdate = (Button) findByName("btnUpdate", cont);
//
//        Label lblImage = (Label) findByName("lblImage", cont);
//        Label lblFullName = (Label) findByName("lblFullName", cont);
//
//        lblImage.setText("");
//        String profileImageUrl = user.getString("profileImageUrl");
//        String email = user.getString("email");
//        String firstName = user.getString("firstName");
//        String lastName = user.getString("lastName");
//
//        try {
//            InputStream is = Display.getInstance().getResourceAsStream(getClass(), "/placeholder.png");//TEMP
//            placeHolder = EncodedImage.create(is);
//
//            if (profileImageUrl != null) {
//                Image img = URLImage.createToStorage(placeHolder, profileImageUrl, profileImageUrl, URLImage.RESIZE_SCALE);
//                Utility u = new Utility();
//                img = u.maskImage(img);
//                if (btnProfilePic != null) {
//                    btnProfilePic.setIcon(img);
//                }
//                lblImage.setIcon(img);
//            }
//
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
//
//        txtEmail.setText(email);
//
//        if ((firstName != null && firstName.length() > 0)
//                && (lastName != null && lastName.length() > 0)) {
//            lblFullName.setText(firstName + " " + lastName);
//
//        } else if ((firstName == null || firstName.length() == 0)
//                && (lastName == null || lastName.length() == 0)) {
//            message = "Please complete First Name and Last Name below. The tap Update button.";
//            lblFullName.setText("");
//        } else if (firstName == null || firstName.length() == 0) {
//            message = "Please complete First Name. The tap Update button.";
//            lblFullName.setText("");
//        } else if (lastName == null || lastName.length() == 0) {
//            message = "Please complete Last Name below. The tap Update button.";
//            lblFullName.setText("");
//        }
//
//        txtFirstName.setText(firstName);
//        txtLastName.setText(lastName);
//
//        btnCamera.addActionListener((ActionListener) (ActionEvent evt) -> {
//            FormProgress progress = new FormProgress(f);
//            String path = Capture.capturePhoto(400, -1); //Get image path then code will do rest
//
//            if (path != null) {
//
//                uploadProfileImage("Camera", f, path, placeHolder, lblImage);
//
//            } else {
//                //TODO
//            }
//            progress.removeProgress();
//        });
//
//        btnGallery.addActionListener((ActionListener) (ActionEvent evt) -> {
//            Display.getInstance().openGallery(new ActionListener() {
//
//                public void actionPerformed(ActionEvent evt) {
//                    FormProgress progress = new FormProgress(f);
//
//                    String path = evt.getSource().toString();
//                    if (evt != null && evt.getSource() != null) {
//                        //lblImage
//                        uploadProfileImage("Gallery", f, path, placeHolder, lblImage);
//
//                    } else {
//                        //TODO
//                    }
//                    progress.removeProgress();
//                }
//            }, Display.GALLERY_IMAGE);
//        });
//
//        btnUpdate.addActionListener((ActionListener) (ActionEvent evt) -> {
//            FormProgress progress = new FormProgress(f);
//
//            message = "";
//
//            if (txtFirstName.getText().length() == 0) {
//                message += "Please enter First Name. ";
//            }
//
//            if (txtLastName.getText().length() == 0) {
//                message += "Enter Last Name. ";
//            }
//
//            try {
//
//                if (message.length() > 0) {
//                    Utility.showDialog("Error", message);
//                } else {
//                    user.put("firstName", txtFirstName.getText());
//                    user.put("lastName", txtLastName.getText());
//                    user.save();
//
//                    lblFullName.setText(txtFirstName.getText() + " " + txtLastName.getText());
//
//                    Utility.showDialog("Update", "Profile Updated");
//                    if (btnProfileName != null) {
//                        btnProfileName.setText(txtFirstName.getText() + " " + txtLastName.getText());
//                    }
//
//                }
//
//            } catch (ParseException e) {
//                progress.removeProgress();
//                Utility.showDialog("Error", "");
//
//            }
//            progress.removeProgress();
//
//        });
//
//        f.add(cont);
//
//        if (formProgress != null) {
//            formProgress.removeProgress();
//        }
//
//        if (message.length() > 0) {
//            Utility.showDialog("Update", message);
//
//        }
    }

    public void uploadProfileImage(String title, Form f, String path, EncodedImage placeHolder, Label lblImage) {

        formProgress = new FormProgress(f);
        Image newImage = Utility.uploadImage(path, placeHolder);
        formProgress.removeProgress();

        if (newImage != null) {
            lblImage.setIcon(newImage);
            btnProfilePic.setIcon(newImage);
            f.revalidate();
            Utility.showDialog(title, "Image uploaded.");

        }
    }

    public void fetchTasks(Form f, String taskType) {
        formProgress = new FormProgress(f);
        closeMenu(f, true);

        Container contentPane = f.getContentPane();
        contentPane.removeAll();
        Container contTasks = (Container) createContainer("/theme", "ContTasks");

        //Tabs tabs = (Tabs) findByName("Tabs", contTasks);
        //tabs.setSwipeActivated(false);

        //analytics(f, "Name Reservation");

//        Container contContent = (Container) findByName("contContent", contTasks);
//        contContent.removeAll();
//
//        contContent.add(new TextField(""));
        f.add(contTasks);
        
        if (formProgress != null) {
            formProgress.removeProgress();
        }

    }

    public void showViewTask(Form prev, Task task) {

        //taskUsersClear();
        final ParseObject selectedTask = task.getParseObject();
        taskToAdd = selectedTask;

        newTask = (Form) createContainer("/theme", "Task New");
        Toolbar bar = analytics(newTask, "View Task");
        bar.setUIID("LabelWhiteCenter");
        bar.getTitleComponent().setUIID("LabelWhiteCenter");
        newTask.setToolbar(bar);
        Container content = (Container) findByName("content", newTask);
        newTask.setTitle(selectedTask.getString("title"));

        final TextField txtTaskTitle = (TextField) findByName("txtTaskTitle", newTask);
        Button btnAssign = (Button) findByName("btnAssign", newTask);
        Button btnCreateTask = (Button) findByName("btnCreateTask", newTask);
        Button btnUpdateTask = new Button("Update Task");
        Button btnDeleteTask = new Button("Delete Task");
        Picker pickerProjectName = (Picker) findByName("pickerProjectName", newTask);
        Picker pickerStatus = (Picker) findByName("pickerStatus", newTask);
        Picker pickerDate = (Picker) findByName("pickerDate", newTask);
        Picker pickerTime = (Picker) findByName("pickerTime", newTask);
        TextArea txtDescription = (TextArea) findByName("txtDescription", newTask);
        TextArea txtPhysicalAddress = (TextArea) findByName("txtPhysicalAddress", newTask);
        Picker pickerPriority = (Picker) findByName("pickerPriority", newTask);

        pickerPriority.setType(Display.PICKER_TYPE_STRINGS);
        pickerPriority.setStrings("Select Priority", "8 Hours", "16 Hours", "24 Hours");

        pickerProjectName.setType(Display.PICKER_TYPE_STRINGS);

        Date dueDate = selectedTask.getDate("dateDue");

        DateCustom custom = new DateCustom(dueDate);

        Button btnDescription = (Button) findByName("btnDescription", newTask);

        Button btnPhysicalAddress = (Button) findByName("btnPhysicalAddress", newTask);

        String physicalAddress = selectedTask.getString("physicalAddress");
        String description = selectedTask.getString("description");

        String inter = "(?:\\(\\d{3}\\)|\\d{3}[-]*)\\d{3}[-]*\\d{4}";
        RE p = new RE(inter);

        final ArrayList<String> numbers = new ArrayList<String>();

        if (description != null) {
            for (int i = 0; i < description.length() - 9; i++) {

                String temp = description.substring(i, i + 10);

                if (p.match(temp)) {
                    numbers.add(temp);
                }

            }
        }

        btnPhysicalAddress.addActionListener((ActionListener) (ActionEvent evt) -> {

            if (physicalAddress != null) {
                if (Dialog.show("Place", "Navigate to " + physicalAddress + "?", "Yes", "No")) {
                    Display.getInstance().openNativeNavigationApp(physicalAddress);
                }
            }

        });

        if (Display.getInstance().getPlatformName().equals("and")
                || Display.getInstance().getPlatformName().equals("ios")) {
            btnDescription.addActionListener((ActionListener) (ActionEvent evt) -> {
                if (description != null) {
                    Container cont = new Container();
                    for (int i = 0; i < numbers.size(); i++) {
                        String phone = numbers.get(i).toString();
                        Button temp = new Button("Call " + phone);
                        temp.addActionListener((ActionListener) (ActionEvent evt1) -> {
                            Display.getInstance().dial(phone);
                        });
                        cont.add(temp);
                    }
                    Command cmd = new Command("Close") {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            super.actionPerformed(evt); //To change body of generated methods, choose Tools | Templates.

                        }

                    };
                    Dialog.show("Phone numbers", cont, cmd);
                }
            });

        }

        pickerStatus.setType(Display.PICKER_TYPE_STRINGS);
        pickerStatus.setStrings("Select Status", "Not Started", "Started", "Completed");
        pickerStatus.setSelectedString(selectedTask.getString("status"));

        pickerDate.setType(Display.PICKER_TYPE_DATE);
        pickerDate.setDate(custom.getPickerDate());

        pickerTime.setType(Display.PICKER_TYPE_TIME);
        pickerTime.setTime(custom.getPickerTime()); //00:00AM = Minutes since midnight

        ProjectService projectService = new ProjectService();
        projects = projectService.getProjectsUI(ParseUser.getCurrent());
        String arrProjects[] = new String[projects.size()];
        //arrProjects[0] = "Select Project";
        for (int i = 0; i < projects.size(); i++) {
            Project proj = projects.get(i);
            //Log.p("proj=" + proj.getTitle()+" i=" + i);
            arrProjects[i] = proj.getTitle();
        }
        pickerProjectName.setStrings(arrProjects);

        //taskUsers = (java.util.HashMap<String,ParseObject>) selectedTask.get("taskUsers");
        taskUsers = task.getTaskUsers();

        updateAssignedLabel();

        int selectedIndex = 0;
        for (int i = 1; i < projects.size(); i++) {
            ParseObject projectParseObject = selectedTask.getParseObject("project");
            String selectedObjectId = projectParseObject.getObjectId();
            String projectsObjectId = projects.get(i).getParseObject().getObjectId();
            if (selectedObjectId.equals(projectsObjectId)) {
                selectedIndex = i;
                i = projects.size();//exit
            }

        }

        int priority = selectedTask.getInt("priority");
        String priorityString = "";

        switch (priority) {
            case 8:
                priorityString = "8 Hours";
                break;
            case 16:
                priorityString = "16 Hours";
                break;
            case 24:
                priorityString = "24 Hours";
                break;
        }

        pickerProjectName.setSelectedString(projects.get(selectedIndex).getTitle());
        txtDescription.setText(selectedTask.getString("description"));
        txtPhysicalAddress.setText(selectedTask.getString("physicalAddress"));
        pickerPriority.setSelectedString(priorityString);

        Date dateDue = selectedTask.getDate("dateDue");

        DateCustom dateCustom = new DateCustom(dateDue);

        txtTaskTitle.setText(selectedTask.getString("title"));
        btnCreateTask.setText("Update Task");

        Command back = new Command("Home") {

            @Override
            public void actionPerformed(ActionEvent evt) {
                super.actionPerformed(evt);
                prev.showBack();
            }

        };
        bar.addCommandToLeftBar(back);
        newTask.setBackCommand(back);
        newTask.show();

    }

    public void fetchDashboard(final Form f) {
        formProgress = new FormProgress(f);
        closeMenu(f, true);

        //String twitterHandle = ParseUser.getCurrent().getString("twitterHandle");
        analytics(f, "Dashboard");

        //TaskService tasks = new TaskService();
        //final java.util.List<Task> listTasks = tasks.getTasks(ParseUser.getCurrent(), Const.TASK_TODAY, true);
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

        mbTasks.setTextLine1("Name Reservations");
        mbTasks.setTextLine2("One Name Reservation pending");

        mbCurrency.setTextLine1("Annual Returns");
        mbCurrency.setTextLine2("Three Annual Returns due");

        f.add(cont);
        if (formProgress != null) {
            formProgress.removeProgress();
        }
        closeMenu(f, true);

    }

    public void fetchCommunicationTask(Form f) {
        formProgress = new FormProgress(f);
        analytics(f, "Communication");

        Container contentPane = f.getContentPane();
        contentPane.removeAll();
        Container contTasks = (Container) createContainer("/theme", "ContTasks");

        Label labelTitle = (Label) findByName("LabelTitle", contTasks);
        labelTitle.setText("Tasks This Month");

        //Container contContent = (Container) findByName("contContent", contTasks);
        contTasks.removeAll();

        ParseUser loggedInUser = ParseUser.getCurrent();

        //if (loggedInUser.getBoolean("isAdmin") == true) {
        java.util.List<ParseObject> listDeviceId = PushNotificationService.getPushDeviceIds(null);
        java.util.List<String> devices = new ArrayList<String>();
        for (ParseObject p : listDeviceId) {
            String deviceId = p.getString("deviceId");
            if (deviceId != null & deviceId.length() > 0) {
                devices.add(deviceId);
            }
        }

        final String[] arrDevices = devices.toArray(new String[devices.size()]);

        Label lblNotifications = new Label("Broadcast push notification");
        lblNotifications.setUIID("LabelWhite");
        TextArea txtPushMessage = new TextArea();
        txtPushMessage.setRows(2);
        txtPushMessage.setUIID("TextField");
        Button sendPush = new Button("Send Push");
        contTasks.add(lblNotifications);
        contTasks.add(txtPushMessage);
        contTasks.add(new Container(new GridLayout(1, 2)).add(sendPush));

        sendPush.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String token = "01146C39-BC54-4DAA-AFCD-71EB44DFC3D1";
                String body = txtPushMessage.getText();
                boolean production = false;
                String googleAuthKey = "AIzaSyDFJBYwk2FGaKgcFbcL-1s1ZRb7SxPVcXw";

                String iosCertificateURL = "https://codename-one-push-certificates.s3.amazonaws.com/mobi.mfactory.tm_DevelopmentPush9288bb3d-c9c6-4409-9f3a-084fa7a9f8bd.p12";
                String iosCertificatePassword = "dXw067BO";
                int pushType = 1;

                if (body == null || body.length() == 0) {
                    Utility.showDialog("Error", "Please type a message before tapping Send Push Message.");
                } else {
                    formProgress = new FormProgress(f);
                    Push.sendPushMessage(token, body, production, googleAuthKey, iosCertificateURL, iosCertificatePassword, pushType, arrDevices);
                    formProgress.removeProgress();
                    Utility.showDialog("Success", "Push notification sent.");

                }

            }
        });
        // }

//        CommunicationService service = new CommunicationService();
//        java.util.List<Communication> list = service.getAllCommunication(ParseUser.getCurrent());
//
//        for (Communication object : list) {
//
//            //Button button = new Button(task.getTitle() + " " + task.getDate());
//            String title = object.getTitle();
//            String date = Utility.convertToDateString(object.getDate());
//            MultiButton mb = new MultiButton();
//            mb.setUIID("MultiButtonColor");
//            mb.setTextLine1(title);
//            mb.setTextLine2(date);
//            contTasks.add(mb);
//        }
        f.add(contTasks);
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
        //s.setLayout(new Flo);

        //s.openToRight();
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

//        Button btnNewProject = (Button) findByName("btnNewProject", contProjects);
//
//        //NEW PROJECT
//        btnNewProject.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//
//                action = "newProject";
//
//            }
//        });
//
//        Label labelTitle = (Label) findByName("LabelTitle", contProjects);
//        labelTitle.setText("Projects");
//
//        Container contContent = (Container) findByName("contContent", contProjects);
//        contContent.removeAll();
//        contContent.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
//
//        ProjectService service = new ProjectService();
//        java.util.List<ParseObject> list = service.getProjects(ParseUser.getCurrent());
//
//        for (ParseObject object : list) {
//
//            Date dateDue = object.getDate("dateDue");
//            String strDate = Utility.convertToDateString(dateDue);
//
//            ActionListener clickAction = new ActionListener() {
//
//                @Override
//                public void actionPerformed(ActionEvent evt) {
//                    action = "viewProject";
//
//                    showViewProject(object);
//                }
//            };
//
//            SwipeableContainer cont = createRankWidget(object.getString("title"), strDate, clickAction);
//            MultiButton button = (MultiButton) findByName("MultiButtonColor", cont);
//
//            //button.setTextLine1();
//            //button.setTextLine2(strDate);
//            //VIEW PROJECT
//            contContent.add(cont);
//        }
        f.add(contProjects);
        if (formProgress != null) {
            formProgress.removeProgress();
        }

    }

    public void showViewProject(ParseObject project) {

        Form formProjectNew = (Form) createContainer("/theme", "Project New");
        Toolbar bar = new Toolbar();

        formProjectNew.setToolbar(bar);
        bar.setUIID("LabelWhiteCenter");
        bar.getTitleComponent().setUIID("LabelWhiteCenter");
        Container content = (Container) findByName("content", formProjectNew);
        formProjectNew.setTitle(project.getString("title"));

        final TextField txtTitle = (TextField) findByName("txtTitle", formProjectNew);
        final TextArea txtDescription = (TextArea) findByName("txtDescription", formProjectNew);
        Button btnProjectAction = (Button) findByName("btnProjectAction", formProjectNew);
        Button updateProject = new Button("Update Project");
        Button deleteProject = new Button("Delete Project");

        Picker dateTimePicker = (Picker) findByName("dateTimePicker", formProjectNew);

        Date dueDate = project.getDate("dateDue");

        DateCustom custom = new DateCustom(dueDate);

        Picker timePicker = (Picker) findByName("timePicker", formProjectNew);
        dateTimePicker.setType(Display.PICKER_TYPE_DATE);
        dateTimePicker.setDate(custom.getPickerDate());

        timePicker.setType(Display.PICKER_TYPE_TIME);
        timePicker.setTime(custom.getPickerTime()); //00:00AM = Minutes since midnight

        DateCustom dateCustom = new DateCustom();
        Date dateDue = dateCustom.getDateTimeObject(dateTimePicker, timePicker);
        final DateCustom currentDate = new DateCustom(dateDue);

        String message = "";

        txtTitle.setText(project.getString("title"));
        txtDescription.setText(project.getString("description"));

        content.removeComponent(btnProjectAction);
        content.add(updateProject);

        updateProject.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                String title = txtTitle.getText();
                String description = txtDescription.getText();
                //Date not older than current
                String message = "";

                if (title.length() == 0 || description.length() == 0) {
                    message += "All fields must be filled in. ";
                }

                if (currentDate.isDateValid() == false) {
                    message += "Project Due Date can only be due from today and in future. ";
                }

                if (currentDate.isTimeValid() == false) {
                    message += "Project Time due can only be due from " + currentDate.getTimeNow() + " till Midnight (23h59). ";
                }

                if (message.length() == 0) {

                    project.put("title", title);
                    project.put("description", description);
                    project.put("dateDue", dateDue);
                    String msg = ProjectService.updateProject(project);

                    Utility.showDialog("Update Project", msg);
                } else {
                    Utility.showDialog("Error", message);
                }

            }
        });

        deleteProject.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

            }
        });

//        
//        Command command = new Command("Update Photo");
//        command.putClientProperty("SideComponent", contSideMenu);
//        f.addCommand(command);
        formProjectNew.removeAllCommands();
        Command back = new Command("Home") {

            @Override
            public void actionPerformed(ActionEvent evt) {
                super.actionPerformed(evt);
                current.showBack();
            }

        };
        bar.addCommandToLeftBar(back);
        formProjectNew.setBackCommand(back);
        formProjectNew.show();

    }

//    public void fetchCommunication(Form f) {
//        Container contentPane = f.getContentPane();
//        contentPane.removeAll();
//        Container contCommunication = (Container) createContainer("/theme", "ContCommunication");
//
//        Container contContent = (Container) findByName("contContent", contCommunication);
//        contContent.removeAll();
//
//        ParseUser currentUser = ParseUser.getCurrent();
//
//        CommunicationService com_service = new CommunicationService();
//        java.util.List<Communication> tasks = com_service.getAllCommunication(currentUser);
//
//        for (Communication task : tasks) {
//            String title = task.getTitle();
//            String date = Utility.convertToDateString(task.getDate());
//            MultiButton button = new MultiButton();
//            button.setTextLine1("test");
//            button.setTextLine2(date);
//            contContent.add(button);
//        }
//        f.revalidate();
////            button.addActionListener((ActionListener) (ActionEvent evt) -> {
////
////                Container contentPane1 = f.getContentPane();
////                contentPane1.removeAll();
////
////                contCommunicationc = (Container) createContainer("/theme", "ContCommunication");
////                Container contContentc = (Container) findByName("Comment", contCommunicationc);
////                //contContentc.removeAll();
////
////                Button btnSend = (Button) findByName("btnSendComment", contCommunicationc);
//
//    }
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

    public void fetchReports(Form f) {

        formProgress = new FormProgress(f);
        closeMenu(f, true);
        analytics(f, "Task Report");
        Font largeFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.SIZE_LARGE, Font.STYLE_BOLD);

        Container contentPane = f.getContentPane();
        contentPane.removeAll();
        Container contTasks = (Container) createContainer("/theme", "ContReports");
        contTasks.removeAll();

        Map<String, Integer> hash = ReportsService.getTaskReport();
        int notStarted = Integer.parseInt(hash.get("notStarted").toString());
        int started = Integer.parseInt(hash.get("started").toString());
        int completed = Integer.parseInt(hash.get("completed").toString());

        double[] values = new double[]{notStarted, started, completed};
        int[] colors = new int[]{ColorUtil.BLUE, ColorUtil.GREEN, ColorUtil.YELLOW};
        final DefaultRenderer renderer = buildCategoryRenderer(colors);
        renderer.setZoomButtonsVisible(true);
        renderer.setZoomEnabled(true);
        renderer.setChartTitleTextFont(largeFont);
        renderer.setDisplayValues(true);
        renderer.setShowLabels(true);
        renderer.setLabelsColor(ColorUtil.BLACK);

        //final CategorySeries seriesSet = buildCategoryDataset("Tasks", values);
        CategorySeries series = new CategorySeries("Tasks");

        series.add("Taks Not Started", notStarted);
        series.add("Tasks Started", started);
        series.add("Tasks Completed", completed);

        final PieChart chart = new PieChart(series, renderer);

        ChartComponent comp = new ChartComponent(chart) {

            private boolean inDrag = false;

            @Override
            public void pointerPressed(int x, int y) {
                inDrag = false;
                super.pointerPressed(x, y); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void pointerDragged(int x, int y) {
                inDrag = true;
                super.pointerDragged(x, y); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            protected void seriesReleased(SeriesSelection sel) {

                if (inDrag) {
                    // Don't do this if it was a drag operation
                    return;
                }

                for (SimpleSeriesRenderer r : renderer.getSeriesRenderers()) {
                    r.setHighlighted(false);
                }
                SimpleSeriesRenderer r = renderer.getSeriesRendererAt(sel.getPointIndex());
                r.setHighlighted(true);

                Shape seg = chart.getSegmentShape(sel.getPointIndex());
                Rectangle bounds = seg.getBounds();
                bounds = new Rectangle(
                        bounds.getX() - 40,
                        bounds.getY() - 40,
                        bounds.getWidth() + 80,
                        bounds.getHeight() + 80
                );

                this.zoomToShapeInChartCoords(bounds, 500);

                int index = sel.getPointIndex();
                String status = series.getCategory(index);

                showReportTasks(f, status);

            }

        };
        comp.setZoomEnabled(true);
        comp.setPanEnabled(true);

        comp.setUIID("Label");
        contTasks.add(comp);
        f.add(contTasks);
        if (formProgress != null) {
            formProgress.removeProgress();
        }
    }

    public void showReportTasks(Form prev, String status) {

        Form f = new Form(new BoxLayout(BoxLayout.Y_AXIS));
        analytics(f, "Tasks " + status);

        java.util.List<Task> list = TaskService.getTasks(status);

        for (Task taskClass : list) {
            task = taskClass.getParseObject();
            taskId = task.getObjectId();

            String date = Utility.convertToDateString(taskClass.getDate());
            String title = taskClass.getTitle();

            MultiButton mb = new MultiButton();
            mb.setUIID("MultiButtonColor");
            mb.setTextLine1(title);
            mb.setTextLine2(date);

            mb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    showViewTask(f, taskClass);
                }
            });

            f.add(mb);
        }

        addBack(f, prev);
        f.show();
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

    public void fetchManageProjects(Form f) {
        formProgress = new FormProgress(f);
        closeMenu(f, true);
        analytics(f, "Manage Projects");
        Container contentPane = f.getContentPane();
        contentPane.removeAll();
        Container contTasks = (Container) createContainer("/theme", "ContProjects");

        Label labelTitle = (Label) findByName("LabelTitle", contTasks);
        labelTitle.setText("Manage Projects");

        Container contContent = (Container) findByName("contContent", contTasks);
        contContent.removeAll();

        ProjectService service = new ProjectService();
        java.util.List<ParseObject> list = service.getProjects(ParseUser.getCurrent());

        for (ParseObject object : list) {
            Button button = new Button(object.getString("title"));
            contContent.add(button);
        }

        f.add(contTasks);
        if (formProgress != null) {
            formProgress.removeProgress();
        }
    }

    public void fetchManageContacts(Form f) {
        formProgress = new FormProgress(f);
        closeMenu(f, true);

        analytics(f, "Manage Users");

        UserService service = new UserService();
        final Hashtable[] users = service.getUsersHashtable();

        Container contentPane = f.getContentPane();
        contentPane.removeAll();
        Container contTasks = (Container) createContainer("/theme", "ContContacts");

        TextField txtSearch = (TextField) findByName("txtSearch", contTasks);

        Label labelTitle = (Label) findByName("LabelTitle", contTasks);
        labelTitle.setText("Manage Contacts");
        f.add(contTasks);

        List list = (List) findByName("List", contTasks);
        ListModel model = new DefaultListModel(users);//users
        NewFilterProxyModel n = new NewFilterProxyModel(model);

        txtSearch.addDataChangedListener(new DataChangedListener() {
            @Override
            public void dataChanged(int type, int index) {
                n.filter(txtSearch.getText());

            }
        });

        list.setModel(n);

        list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Hashtable selectedHashtable = (Hashtable) list.getSelectedItem();

                ParseUser selectedUser = (ParseUser) selectedHashtable.get("parseObject");

                Form editUser = showForm("User New", null);

                TextField txtFirstname = (TextField) findByName("txtFirstname", editUser);
                TextField txtLastname = (TextField) findByName("txtLastname", editUser);
                TextField txtEmail = (TextField) findByName("txtEmail", editUser);
                Button btnAddUser = (Button) findByName("btnAddUser", editUser);
                Button btnDeleteUser = (Button) findByName("btnDeleteUser", editUser);
                TextField txtPassword = (TextField) findByName("txtPassword", editUser);
                OnOffSwitch isAdmin = (OnOffSwitch) findByName("isAdmin", editUser);
                final OnOffSwitch isAllowed = (OnOffSwitch) findByName("isAllowed", editUser);

                txtFirstname.setEnabled(false);
                txtLastname.setEnabled(false);
                txtEmail.setEnabled(false);
                txtPassword.setEnabled(false);
                txtFirstname.setEditable(false);
                txtLastname.setEditable(false);
                txtEmail.setEditable(false);
                txtPassword.setEditable(false);

                btnAddUser.setEnabled(false);
                isAdmin.setEnabled(false);
                //isAllowed.setEnabled(false);

                txtFirstname.setText(selectedUser.getString("firstName"));
                txtLastname.setText(selectedUser.getString("lastName"));
                txtEmail.setText(selectedUser.getUsername());
                //txtPassword.setText(selectedUser.getString("firstName"));
                isAdmin.setValue(selectedUser.getBoolean("isAdmin"));

                try {

                    ParseQuery<ParseObject> query1 = ParseQuery.getQuery("UserAccess");
                    query1.include("user").whereEqualTo("user", selectedUser);

                    java.util.List<ParseObject> list = query1.find();
                    if (list != null && list.size() == 1) {
                        isAllowedObject = (ParseObject) list.get(0);
                        isAllowed.setValue(isAllowedObject.getBoolean("isAllowed"));
                    } else {
                        isAllowedObject = ParseObject.create("UserAccess");
                        isAllowedObject.put("user", selectedUser);
                        isAllowedObject.put("isAllowed", true);
                        isAllowed.setValue(true);
                        isAllowedObject.save();
                    }

                } catch (ParseException ex) {
                    Log.e(ex);
                }

                editUser.getToolbar().setTitle("Edit User");
                btnAddUser.setText("Update User");

                isAllowed.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {

                        try {
                            isAllowedObject.put("user", selectedUser);
                            isAllowedObject.put("isAllowed", isAllowed.isValue());
                            //isAllowed.setValue(true);
                            isAllowedObject.save();
                            Dialog.show("Updated", "User Allowed to Access App Rights Updated.", "Ok", null);

                        } catch (ParseException ex) {
                            Log.e(ex);
                        }
                    }
                });

//                btnDeleteUser.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent evt) {
//                        Log.p("Deleting selectedUser=" + selectedUser.getObjectId(), Log.DEBUG);
//                        if (Dialog.show("Delete User", "Delete user " + selectedUser.getUsername() + " ?", "Yes", "No")) {
//
//                            try {
//                                selectedUser.delete();
//                            } catch (ParseException ex) {
//                                Log.e(ex);
//                            }
//                        }
//
//                    }
//                });
            }
        });

        if (formProgress != null) {
            formProgress.removeProgress();
        }

    }

    public void fetchSettings(final Form f) {
        formProgress = new FormProgress(f);
        closeMenu(f, true);
        analytics(f, "Settings");

        final ParseUser loggedInUser = ParseUser.getCurrent();
        String currentHandle = loggedInUser.getString("twitterHandle");

        Container contentPane = f.getContentPane();
        contentPane.removeAll();
        Container cont = (Container) createContainer("/theme", "ContSettings");

        TextField txtHandle = (TextField) findByName("txtHandle", cont);

        txtHandle.setText(currentHandle);

        Button btnSettingsSave = (Button) findByName("btnSettingsSave", cont);

        btnSettingsSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String twitterHandle = txtHandle.getText();

                String message = "";

                if (twitterHandle != null && twitterHandle.length() == 0) {
                    message += "Twitter handle may not be empty.";
                }

                if (message.length() > 0) {
                    Utility.showDialog("Error", message);
                } else {
                    try {
                        formProgress = new FormProgress(f);
                        loggedInUser.put("twitterHandle", twitterHandle);;
                        loggedInUser.save();
                        formProgress.removeProgress();
                        Utility.showDialog("Success", "Twitter handle updated.");

                    } catch (ParseException e) {
                        formProgress.removeProgress();
                        Log.p("[Statemachine.fetchSettings(.) save] ParseException e=" + "", Log.DEBUG);

                        String errorMessage = "";
                        Utility.showDialog("Error", errorMessage);

                    }
                }

            }
        });

        java.util.List<ParseObject> listDeviceId = PushNotificationService.getPushDeviceIds(null);
        java.util.List<String> devices = new ArrayList<String>();
        for (ParseObject p : listDeviceId) {
            String deviceId = p.getString("deviceId");
            if (deviceId != null & deviceId.length() > 0) {
                devices.add(deviceId);
            }
        }

//        if (loggedInUser.getBoolean("isAdmin") == true) {
//
//            final String[] arrDevices = devices.toArray(new String[devices.size()]);
//
//            Label lblNotifications = new Label("Broadcast push notification");
//            lblNotifications.setUIID("LabelWhite");
//            TextArea txtPushMessage = new TextArea();
//            txtPushMessage.setRows(2);
//            txtPushMessage.setUIID("TextField");
//            Button sendPush = new Button("Send Push");
//            cont.add(lblNotifications);
//            cont.add(txtPushMessage);
//            cont.add(new Container(new GridLayout(1, 2)).add(sendPush));
//
//            sendPush.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent evt) {
//                    String token = "01146C39-BC54-4DAA-AFCD-71EB44DFC3D1";
//                    String body = txtPushMessage.getText();
//                    boolean production = false;
//                    String googleAuthKey = "AIzaSyDFJBYwk2FGaKgcFbcL-1s1ZRb7SxPVcXw";
//
//                    String iosCertificateURL = "https://codename-one-push-certificates.s3.amazonaws.com/mobi.mfactory.tm_DevelopmentPush9288bb3d-c9c6-4409-9f3a-084fa7a9f8bd.p12";
//                    String iosCertificatePassword = "dXw067BO";
//                    int pushType = 1;
//
//                    if (body == null || body.length() == 0) {
//                        Utility.showDialog("Error", "Please type a message before tapping Send Push Message.");
//                    } else {
//                        formProgress = new FormProgress(f);
//                        Push.sendPushMessage(token, body, production, googleAuthKey, iosCertificateURL, iosCertificatePassword, pushType, arrDevices);
//                        formProgress.removeProgress();
//                        Utility.showDialog("Success", "Push notification sent.");
//
//                    }
//
//                }
//            });
//        }
        f.add(cont);
        if (formProgress != null) {
            formProgress.removeProgress();
        }
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

    public void bindGlobalActionButton(Container container) {

        FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        FloatingActionButton newTaskFloat = fab.createSubFAB(FontImage.MATERIAL_ASSIGNMENT, "New Task");
        FloatingActionButton newProjectFloat = fab.createSubFAB(FontImage.MATERIAL_WORK, "New Project");

        newTaskFloat.addActionListener(e -> showForm("Task New", null));
        newProjectFloat.addActionListener(e -> showForm("Project New", null));

        if (ParseUser.getCurrent().getBoolean("isAdmin")) {//Only admins can create users
            FloatingActionButton newUserFloat = fab.createSubFAB(FontImage.MATERIAL_PEOPLE, "New User");
            newUserFloat.addActionListener(e -> showForm("User New", null));
            changeFloatingButtonStyle(newUserFloat);
        }

        changeFloatingButtonStyle(newTaskFloat);
        changeFloatingButtonStyle(newProjectFloat);
        changeFloatingButtonStyle(fab);

        fab.bindFabToContainer(container);

    }

    @Override
    protected void beforeMain(Form f) {

        //bindGlobalActionButton(f.getContentPane());
        Toolbar toolbar = analytics(f, "Home");

        current = f;

        //fetchCommunicationTask(f);
        fetchDashboard(f);
        //fetchManageContacts(f);
        //fetchTasks(f, Const.TASK_TODAY);

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

        //Form f = findTxtEmail().getComponentForm();
        Form f = Display.getInstance().getCurrent();

        Container c = (Container) findByName("containerParent", f);

        String txtCustomerCode = ((TextField) findByName("txtCustomerCode", c)).getText();
        final String password = ((TextField) findByName("txtPassword", c)).getText();

        za.co.cipc.pojos.User user = new za.co.cipc.pojos.User();
        user.setAgent_code(txtCustomerCode);
        user.setParamPassword(password);


//        email = trimEmail(email);
//
//        String message = "";
//
//        if (email.length() == 0 | email.length() == 0) {
//            message += "All fields must be filled in. ";
//        }
//
//        RE regEmail = new RE(Const.validEmailRegex);
//        boolean isEmailValid = regEmail.match(email);
//
//        if (isEmailValid == false) {
//            message += "Please enter a valid email. ";
//        }
//
//        if (message.length() > 0) {
//            Utility.showDialog("Error", message);
//            return true;
//        }
        //Container progress = (Container)findByName("Progress", f);
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
            Utility.showDialog("Error", errorMessage);
            return true;//block
        } else {
            return false;
        }

//        try {
//
//            user = ParseUser.create(email, password);
//            user.login();
//            //formProgress.removeProgress();
//
//        } catch (ParseException e) {
//            formProgress.removeProgress();
//            Log.p("[Statemachine.onLoginLogin()] ParseException e=" + "", Log.DEBUG);
//
//            String errorMessage = e.getMessage();
//            Utility.showDialog("Error", errorMessage);
//            return true;
//
//        }
//        boolean isAllowed = false;
//
//        try {
//
//            ParseQuery<ParseObject> query1 = ParseQuery.getQuery("UserAccess");
//            query1.include("user").whereEqualTo("user", user);
//
//            java.util.List<ParseObject> list = query1.find();
//            if (list != null && list.size() == 1) {
//                isAllowedObject = (ParseObject) list.get(0);
//                isAllowed = isAllowedObject.getBoolean("isAllowed");
//
//                Log.p("isAllowed=" + isAllowed, Log.DEBUG);
//
//            }
//
//        } catch (ParseException ex) {
//            Log.e(ex);
//        }
//
//        if (isAllowed == false) {
//            Utility.showDialog("Error", "You are not allowed to access this app. Please contact System Administrator.");
//            return true;
//        }
//        if (user != null && user.isAuthenticated()) {
//            //UIFactory.showDialog("Success", "You have been registered successfully.", "Ok");
//            return false;
//        }
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

   

    public void taskUsersClear() {
        if (taskUsers != null) {
            taskUsers.clear();
        }
    }


    public void isTableInputForm(Form f) {
//        Container contentParent = (Container) findByName("containerParent", f);
//
//        if (Display.getInstance().isTablet()) {
//
//            f.setLayout(new GridLayout(1, 3));
//            f.removeComponent(contentParent);
//            f.add("");
//            f.add(contentParent);
//            f.setScrollableX(false);
//            f.setScrollableY(false);
//            contentParent.setUIID("ContainerMain");
//
//        } else {
//
//            contentParent.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
//            contentParent.setUIID("ContainerButton");
//
//        }
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

//        f.addOrientationListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                if(Display.getInstance().isPortrait()){
//                    f.setScrollableY(false);
//                }
//                else{
//                    f.setScrollableY(true);
//                }
//            }
//        });
//        Toolbar toolbar = analytics(f, "Login");
//        toolbar.setUIID("LabelWhiteCenter");
//        toolbar.getTitleComponent().setUIID("LabelWhiteCenter");
//        toolbar.setTitle("");
//        ((Label)toolbar.getTitleComponent()).setText("");
        //
    }

    @Override
    protected void beforeRegistration(Form f) {
        
        /*
              
        
        UserWebServices u = new UserWebServices();
        za.co.cipc.pojos.User user = new za.co.cipc.pojos.User();
        //verify ID number
        user.setAgent_id_no("7104085085085");
        //user.setAgent_id_no("9109055178081"); not 
        //1. empty = invalid ID
        //2. empty result set = valid ID but not a CIPC customer
        //3. full details existing customer
        
        //register user
        u.GetCustLoginDetails_ID_NO(user);
        */

        Toolbar bar = analytics(f, "Registration");

        isTableInputForm(f);

//        if (Log.getLevel() == Log.DEBUG) {
//            TextField txtEmail = (TextField) findByName("txtEmail", f);
//            TextField txtPassword = (TextField) findByName("txtPassword", f);
//            TextField txtPasswordConfirm = (TextField) findByName("txtPasswordConfirm", f);
//
//            txtEmail.setText(defaultEmail);
//            txtPassword.setText(defaultPassword);
//            txtPasswordConfirm.setText(defaultPassword);
//        }
        Tabs tabs = (Tabs) findByName("Tabs", f);
        tabs.setSwipeActivated(false);

        Picker pickerCountry = (Picker) findByName("pickerCountry", f);
        pickerCountry.setType(Display.PICKER_TYPE_STRINGS);
        pickerCountry.setStrings("Select Country", "Brazil", "South Africa", "Zimbabwe");

        Picker pickerProvince = (Picker) findByName("pickerProvince", f);
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

//    @Override
//    protected boolean onRegistrationRegistration() {
//
//        /* TextField txtEmail = findTxtEmail();
//        TextField txtPassword = findTxtPassword();
//        TextField txtPasswordConfirm = findTxtConfirmPassword();
//        Button btnRegistration = findBtnRegistration();
//           Validator v = new Validator();
//        v.addConstraint(txtEmail, RegexConstraint.validEmail())
//                .addConstraint(txtPassword, new LengthConstraint(5))
//                .addConstraint(txtPasswordConfirm, new LengthConstraint(5));
//          
//        v.addSubmitButtons(btnRegistration);*/
//        Form f = findTxtEmail().getComponentForm();
//
//        String email = findTxtEmail().getText();
//        String password = findTxtPassword().getText();
//        String passwordConfirm = findTxtLoginPassword().getText();
//
//        email = trimEmail(email);
//
//        String message = "";
//
//        RE regEmail = new RE(Const.validEmailRegex);
//        boolean isEmailValid = regEmail.match(email);
//
//        if (email.length() == 0 | isEmailValid == false) {
//            message += "Please enter a valid email. ";
//        }
//
//        if (password.equals(passwordConfirm) == false) {
//            message += "Passwords don\'t match. ";
//        }
//
//        if (password.length() < 5) {
//            message += "Password must be at least 5 characters long. ";
//        }
//
//        if (message.length() > 0) {
//            Utility.showDialog("Error", message);
//            return true;
//        }
//
//        formProgress = new FormProgress(f);
//
//        try {
//
//            user = ParseUser.create(email, password);
//            user.setEmail(email);
//            user.put("twitterHandle", "itweb");//default Twitter handle TODO move to online properties
//            user.put("isAllowed", true);
//            user.signUp();
//            //formProgress.removeProgress();
//
//        } catch (ParseException e) {
//            formProgress.removeProgress();
//            Log.p("[Statemachine.onRegistrationRegistration()] ParseException e=" + "", Log.DEBUG);
//
//            Utility.showDialog("Error", e.getMessage());
//            return true;
//
//        }
//
//        if (user != null && user.isAuthenticated()) {
//            Utility.showDialog("Success", "You have been registered successfully.");
//            return false;
//        }
//
//        return true;
//    }
    @Override
    protected void beforeForgotPassword(Form f) {
        Toolbar bar = analytics(f, "Forgot Login Details");

        isTableInputForm(f);

//        if (Log.getLevel() == Log.DEBUG) {
//
//            TextField txtEmail = (TextField) findByName("txtEmail", f);
//            txtEmail.setText(defaultPassword);
//
//        }
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

//    @Override
//    protected boolean onForgotPasswordRecoverPassword() {
//
//        String email = findTxtEmail().getText();
//
//        email = trimEmail(email);
//
//        Form f = findTxtEmail().getComponentForm();
//
//        String message = "";
//
//        RE regEmail = new RE(Const.validEmailRegex);
//        boolean isEmailValid = regEmail.match(email);
//
//        if (email.length() == 0 || isEmailValid == false) {
//            message += "Please enter a valid email. ";
//        }
//
//        if (message.length() > 0) {
//            Utility.showDialog("Error", message);
//            return true;
//        }
//
//        formProgress = new FormProgress(f);
//
//        try {
//
//            ParseUser.requestPasswordReset(email);
//            formProgress.removeProgress();
//
//        } catch (ParseException e) {
//            formProgress.removeProgress();
//            Log.p("[Statemachine.onForgotPasswordRecoverPassword()] ParseException e=" + "", Log.DEBUG);
//            String errorMessage = e.getMessage();
//            Utility.showDialog("Error", errorMessage);
//            return true;
//
//        }
//
//        Utility.showDialog("Success", "Your password request has been sent. You should receive an email. ");
//        return false;
//
//    }
    


    public void updateAssignedLabel() {
        Label lblAssigned = (Label) findByName("lblAssigned", newTask);
        lblAssigned.getStyle().setFgColor(Const.TASK_ADD_MEMBERS_COLOR);//RED
        int size = taskUsers.size();
        if (size == 0 || size > 1) {
            lblAssigned.setText(size + " Members Assigned.");
        } else {
            lblAssigned.setText(size + " Member Assigned.");
        }
        lblAssigned.repaint();

        Set<String> set = taskUsers.keySet();

        for (String s : set) {
            Log.p("username=" + taskUsers.get(s).getObjectId(), Log.DEBUG);
        }

    }

    public Label isItMe(String userName, String otherEmail, String message) {
        Label label;
        String loggedInEmail = ParseUser.getCurrent().getString("email");

        if (otherEmail.equals(loggedInEmail)) {
            label = new Label("Me: " + message);
        } else {
            label = new Label(userName + ": " + message);
        }
        return label;
    }

   
    @Override
    protected void beforeSplash(Form f) {
        //f
    }

    @Override
    protected void postLogin(Form f) {

    }
}
