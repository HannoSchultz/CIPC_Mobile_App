/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.cipc.webservices;

//import pojos.User; 
import com.codename1.components.InfiniteProgress;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.NetworkManager;
import com.codename1.io.rest.RequestBuilder;
import com.codename1.io.rest.Response;
import com.codename1.io.rest.Rest;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.processing.Result;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.util.StringUtil;
import com.codename1.xml.Element;
import com.codename1.xml.XMLParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;
import org.littlemonkey.connectivity.Connectivity;
import userclasses.Constants;
import userclasses.EnterpriseDetails;
import userclasses.NameReservation;
import userclasses.NameSearchObject;
import za.co.cipc.pojos.AuthObject;
import za.co.cipc.pojos.Country;
import za.co.cipc.pojos.User;

/**
 *
 * @author blessingmobile
 */
public class UserWebServices {

    String AR_BODY;

    public ArrayList Get_AR_ent_type_mobi(String dataset) {

        ArrayList list = new ArrayList<>();

        final String SOAP_BODY = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cipc=\"CIPC_WEB_SERVICES\">\n"
                + "\n"
                + "   <soapenv:Header/>\n"
                + "\n"
                + "   <soapenv:Body>\n"
                + "\n"
                + "      <cipc:Get_AR_ent_type_mobi>\n"
                + "\n"
                + "         <!--Optional:-->\n"
                + "\n"
                + "          <cipc:sUserName>wBAA7LAkWIs=</cipc:sUserName>\n"
                + "\n"
                + "         <cipc:sPassword>nhXSFLH3xKlrDYYKEWHlVw==</cipc:sPassword>\n"
                + "\n"
                + "         <cipc:sBankID>wBAA7LAkWIs=</cipc:sBankID>\n"
                + "\n"
                + "         <cipc:Sent_Type></cipc:Sent_Type>\n"
                + "\n"
                + "      </cipc:Get_AR_ent_type_mobi>\n"
                + "\n"
                + "   </soapenv:Body>\n"
                + "\n"
                + "</soapenv:Envelope>";

        ConnectionRequest httpRequest = new ConnectionRequest() {
            Element h;

            @Override
            protected void buildRequestBody(OutputStream os) throws IOException {
                super.buildRequestBody(os);
                os.write(SOAP_BODY.getBytes("utf-8"));

            }

            protected void postResponse() {

                super.postResponse();
            }

            protected void readResponse(InputStream input) throws IOException {
                super.readResponse(input);

            }

            @Override
            protected void handleException(Exception err) {
                Log.p("Exception: " + err.toString());
                Dialog.show("No Internet", "There is no internet connection. Please switch your connection on.", "Okay", null);

            }
        };

        httpRequest.setUrl("https://testwebservices4.cipc.co.za/enterprise.asmx");
        httpRequest.addRequestHeader("Content-Type", "text/xml; charset=utf-8");
        httpRequest.addRequestHeader("Content-Length", SOAP_BODY.length() + "");
        httpRequest.setPost(true);

//        InfiniteProgress prog = new InfiniteProgress();
//        Dialog dlg = prog.showInifiniteBlocking();
//        httpRequest.setDisposeOnCompletion(dlg);
        NetworkManager.getInstance().addToQueueAndWait(httpRequest);
        String data = new String(httpRequest.getResponseData());
        Log.p("CalculateARTranData=" + data, Log.DEBUG);

        try {

            Result result = Result.fromContent(data, Result.XML);

            Log.p("Element e: " + result, Log.DEBUG);

            XMLParser parser = new XMLParser();
            parser.setCaseSensitive(true);
            Element element = parser.parse(convertStringtoInputStreamReader(result.getAsString("//DataSet")));

            for (int i = 0; i < element.getNumChildren(); i++) {

                Element child = element.getChildAt(i);

                String ent_type_code = RSM(((Element) child.getTextChildren(null, true).get(0)).toString());
                Log.p("ent_type_code = " + ent_type_code, Log.DEBUG);
                list.add(ent_type_code);

            }

        } catch (IllegalArgumentException e) {
            Log.p(e.toString());
        }

        return list;

    }//end Get_AR_ent_type_mobi

    //AR
    public EnterpriseDetails soap_GetEnterpriseDetails(String entNumber) {

        EnterpriseDetails enterpriseDetails = null;

        final String SOAP_BODY
                = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cipc=\"CIPC_WEB_SERVICES\">\n"
                + "   <soapenv:Header/>\n"
                + "   <soapenv:Body>\n"
                + "      <cipc:GetEnterpriseDetails_ent_no_mobi>\n"
                + "       <cipc:sUserName>wBAA7LAkWIs=</cipc:sUserName>\n"
                + "         <cipc:sPassword>nhXSFLH3xKlrDYYKEWHlVw==</cipc:sPassword>\n"
                + "         <cipc:sBankID>wBAA7LAkWIs=</cipc:sBankID>\n"
                + "         <cipc:Sent_no>" + entNumber + "</cipc:Sent_no>\n"
                + "      </cipc:GetEnterpriseDetails_ent_no_mobi>\n"
                + "   </soapenv:Body>\n"
                + "</soapenv:Envelope>";

        ConnectionRequest httpRequest = new ConnectionRequest() {
            Element h;

            @Override
            protected void buildRequestBody(OutputStream os) throws IOException {
                super.buildRequestBody(os);
                os.write(SOAP_BODY.getBytes("utf-8"));

            }

            protected void postResponse() {

                super.postResponse();
            }

            protected void readResponse(InputStream input) throws IOException {
                super.readResponse(input);

            }

            @Override
            protected void handleException(Exception err) {
                Log.p("Exception: " + err.toString());
                Dialog.show("No Internet", "There is no internet connection. Please switch your connection on.", "Okay", null);

            }
        };

        httpRequest.setUrl("https://testwebservices4.cipc.co.za/enterprise.asmx");
        httpRequest.addRequestHeader("Content-Type", "text/xml; charset=utf-8");
        httpRequest.addRequestHeader("Content-Length", SOAP_BODY.length() + "");
        httpRequest.setPost(true);

        InfiniteProgress prog = new InfiniteProgress();
        Dialog dlg = prog.showInifiniteBlocking();
        httpRequest.setDisposeOnCompletion(dlg);

        NetworkManager.getInstance().addToQueueAndWait(httpRequest);
        //TODO null
        String data = new String(httpRequest.getResponseData());

        try {

            Result result = Result.fromContent(data, Result.XML);
            Log.p("soap_GetEnterpriseDetails" + result, Log.DEBUG);

            if (result.getAsString("//table") != null) {
                Element e = Utility.parseXML(result.getAsString("//table"));//dataset

                Log.p("Element e: " + e, Log.DEBUG);

                enterpriseDetails = new EnterpriseDetails();

                enterpriseDetails.setEnt_no(result.getAsString("//ent_no"));
                enterpriseDetails.setEnt_name(result.getAsString("//ent_name"));
                enterpriseDetails.setReg_date(result.getAsString("//reg_date"));
                enterpriseDetails.setEnt_type_descr(result.getAsString("//ent_type_descr"));
                enterpriseDetails.setEnt_status_descr(result.getAsString("//ent_status_descr"));
                enterpriseDetails.setEnt_status_code(result.getAsString("//ent_status_code"));
            }

        } catch (IllegalArgumentException e) {
            Log.p(e.toString());
        }

        return enterpriseDetails;

    }//end name reservation

    public ArrayList<EnterpriseDetails> GetAREntTranDetails(String enterpriseNumber, String agentCode) {

        ArrayList<EnterpriseDetails> arrayList = new ArrayList<EnterpriseDetails>();

        if (Display.getInstance().isSimulator()
                && enterpriseNumber == null && agentCode == null) {
            enterpriseNumber = "2011/100088/07";
            agentCode = "KD7788";
        }

        final String SOAP_BODY
                = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cipc=\"CIPC_WEB_SERVICES\">\n"
                + "   <soapenv:Header/>\n"
                + "   <soapenv:Body>\n"
                + "      <cipc:GetAREntTranDetails>\n"
                + "<cipc:sUserName>wBAA7LAkWIs=</cipc:sUserName>\n"
                + "         <cipc:sPassword>nhXSFLH3xKlrDYYKEWHlVw==</cipc:sPassword>\n"
                + "         <cipc:sBankID>wBAA7LAkWIs=</cipc:sBankID>\n"
                + "         <cipc:sEntNo>" + enterpriseNumber + "</cipc:sEntNo>\n"
                + "         <!--Optional:-->\n"
                + "         <cipc:sCust_Code>" + agentCode + "</cipc:sCust_Code>\n"
                + "      </cipc:GetAREntTranDetails>\n"
                + "   </soapenv:Body>\n"
                + "</soapenv:Envelope>\n"
                + " ";

        ConnectionRequest httpRequest = new ConnectionRequest() {
            Element h;

            @Override
            protected void buildRequestBody(OutputStream os) throws IOException {
                super.buildRequestBody(os);
                os.write(SOAP_BODY.getBytes("utf-8"));

            }

            protected void postResponse() {

                super.postResponse();
            }

            protected void readResponse(InputStream input) throws IOException {
                super.readResponse(input);

            }

            @Override
            protected void handleException(Exception err) {
                Log.p("Exception: " + err.toString());
                Dialog.show("No Internet", "There is no internet connection. Please switch your connection on.", "Okay", null);

            }
        };

        httpRequest.setUrl("https://testwebservices4.cipc.co.za/enterprise.asmx");
        httpRequest.addRequestHeader("Content-Type", "text/xml; charset=utf-8");
        httpRequest.addRequestHeader("Content-Length", SOAP_BODY.length() + "");
        httpRequest.setPost(true);

        InfiniteProgress prog = new InfiniteProgress();
        Dialog dlg = prog.showInifiniteBlocking();
        httpRequest.setDisposeOnCompletion(dlg);

        NetworkManager.getInstance().addToQueueAndWait(httpRequest);
        String data = new String(httpRequest.getResponseData());
        Log.p("GetAREntTranDetails" + data, Log.DEBUG);

        try {

            Result result = Result.fromContent(data, Result.XML);

            Log.p("GetAREntTranDetails=" + result, Log.DEBUG);

            XMLParser parser = new XMLParser();
            parser.setCaseSensitive(true);
            Element element = parser.parse(convertStringtoInputStreamReader(result.getAsString("//newdataset")));

            for (int i = 0; i < element.getNumChildren(); i++) {
                Element child = element.getChildAt(i);
                if (child.getTextChildren(null, true).size() == 9) {

                    Log.p("i=" + i + " " + child.getTextChildren(null, true).size(), Log.DEBUG);

                    String ent_no = RSM(((Element) child.getTextChildren(null, true).get(0)).toString());
                    String ar_year = RSM(((Element) child.getTextChildren(null, true).get(1)).toString());
                    int intAr_year = Integer.parseInt(ar_year);
                    //String trak_no = RSM(((Element) child.getTextChildren(null, true).get(2)).toString());
                    String turnover = RSM(((Element) child.getTextChildren(null, true).get(2)).toString());
                    double dblTurnover = Double.parseDouble(turnover);
                    String amt_paid = RSM(((Element) child.getTextChildren(null, true).get(3)).toString());
                    //String date_paid = RSM(((Element) child.getTextChildren(null, true).get(5)).toString());
                    String reg_date = RSM(((Element) child.getTextChildren(null, true).get(4)).toString());
                    String ar_start_date = RSM(((Element) child.getTextChildren(null, true).get(5)).toString());
                    String due_date = RSM(((Element) child.getTextChildren(null, true).get(6)).toString());
                    String ent_type_code = RSM(((Element) child.getTextChildren(null, true).get(7)).toString());
                    String ar_month = RSM(((Element) child.getTextChildren(null, true).get(8)).toString());
                    //String  cust_code_old = RSM(((Element) child.getTextChildren(null, true).get(11)).toString());

                    EnterpriseDetails e = new EnterpriseDetails();

                    e.setEnt_no(ent_no);
                    e.setAr_year(intAr_year);
                    e.setTurnover(dblTurnover);
                    e.setAmt_paid(amt_paid);
                    e.setReg_date(reg_date);
                    e.setAr_start_date(ar_start_date);
                    e.setDue_date(due_date);
                    e.setEnt_type_code(ent_type_code);
                    e.setAr_month(ar_month);

                    arrayList.add(e);

                }
            }

        } catch (IllegalArgumentException e) {
            Log.p(e.toString());
        }

        return arrayList;

    }//end name reservation

    public ArrayList<EnterpriseDetails> CalculateARTranData(String dataset) {

        ArrayList<EnterpriseDetails> enterpriseDetailses = new ArrayList<>();

        final String SOAP_BODY
                = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cipc=\"CIPC_WEB_SERVICES\">\n"
                + "   <soapenv:Header/>\n"
                + "   <soapenv:Body>\n"
                + "      <cipc:CalculateARTranData>\n"
                + "   <cipc:sUserName>wBAA7LAkWIs=</cipc:sUserName>\n"
                + "         <cipc:sPassword>nhXSFLH3xKlrDYYKEWHlVw==</cipc:sPassword>\n"
                + "         <cipc:sBankID>wBAA7LAkWIs=</cipc:sBankID>\n"
                + "         <!--Optional:-->\n"
                + "         <cipc:ds>\n"
                + "            <xs:schema id=\"NewDataSet\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:msdata=\"urn:schemas-microsoft-com:xml-msdata\">\n"
                + "               <xs:element name=\"NewDataSet\" msdata:IsDataSet=\"true\" msdata:UseCurrentLocale=\"true\">\n"
                + "                  <xs:complexType>\n"
                + "                     <xs:choice minOccurs=\"0\" maxOccurs=\"unbounded\">\n"
                + "                        <xs:element name=\"Table1\">\n"
                + "                           <xs:complexType>\n"
                + "                              <xs:sequence>\n"
                + "                                 <xs:element name=\"ent_no\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"ar_year\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"ar_month\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"turnover\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"ent_type_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                              </xs:sequence>\n"
                + "                           </xs:complexType>\n"
                + "                        </xs:element>\n"
                + "                     </xs:choice>\n"
                + "                  </xs:complexType>\n"
                + "               </xs:element>\n"
                + "            </xs:schema>\n"
                + "            <diffgr:diffgram xmlns:msdata=\"urn:schemas-microsoft-com:xml-msdata\" xmlns:diffgr=\"urn:schemas-microsoft-com:xml-diffgram-v1\">\n"
                + "               <NewDataSet>\n"
                + dataset + "\n"
                //                + "                  <Table1 diffgr:id=\"Table11\" msdata:rowOrder=\"0\" diffgr:hasChanges=\"inserted\">\n"
                //                + "                     <ent_no>K2012210312</ent_no>\n"
                //                + "                     <ar_year>2013</ar_year>\n"
                //                + "                     <ar_month>11</ar_month>\n"
                //                + "                     <turnover>0</turnover>\n"
                //                + "                     <ent_type_code>07</ent_type_code>\n"
                //                + "                  </Table1>\n"
                //                + "                   <Table1 diffgr:id=\"Table11\" msdata:rowOrder=\"0\" diffgr:hasChanges=\"inserted\">\n"
                //                + "                     <ent_no>K2012210312</ent_no>\n"
                //                + "                     <ar_year>2014</ar_year>\n"
                //                + "                     <ar_month>11</ar_month>\n"
                //                + "                     <turnover>100000</turnover>\n"
                //                + "                     <ent_type_code>07</ent_type_code>\n"
                //                + "                  </Table1>\n"
                //                + "                                                 <Table1 diffgr:id=\"Table11\" msdata:rowOrder=\"0\" diffgr:hasChanges=\"inserted\">\n"
                //                + "                     <ent_no>K2012210312</ent_no>\n"
                //                + "                     <ar_year>2015</ar_year>\n"
                //                + "                     <ar_month>11</ar_month>\n"
                //                + "                     <turnover>100000000</turnover>\n"
                //                + "                     <ent_type_code>07</ent_type_code>\n"
                //                + "                  </Table1>                 \n" 
                + "               </NewDataSet>\n"
                + "            </diffgr:diffgram>\n"
                + "            <!--You may enter ANY elements at this point-->\n"
                + "         </cipc:ds>\n"
                + "         <!--cipc:dtRegDate>2010-05-24T18:13:00</cipc:dtRegDate-->\n"
                + "         <cipc:dtRegDate>2012-11-27T12:00:00</cipc:dtRegDate> Format the date to look like this\n"
                + "         <!--Optional:-->\n"
                + "         <cipc:sCust_Code>test01</cipc:sCust_Code>\n"
                + "      </cipc:CalculateARTranData>\n"
                + "   </soapenv:Body>\n"
                + "</soapenv:Envelope>";

        ConnectionRequest httpRequest = new ConnectionRequest() {
            Element h;

            @Override
            protected void buildRequestBody(OutputStream os) throws IOException {
                super.buildRequestBody(os);
                os.write(SOAP_BODY.getBytes("utf-8"));

            }

            protected void postResponse() {

                super.postResponse();
            }

            protected void readResponse(InputStream input) throws IOException {
                super.readResponse(input);

            }

            @Override
            protected void handleException(Exception err) {
                Log.p("Exception: " + err.toString());
                Dialog.show("No Internet", "There is no internet connection. Please switch your connection on.", "Okay", null);

            }
        };

        httpRequest.setUrl("https://testwebservices4.cipc.co.za/enterprise.asmx");
        httpRequest.addRequestHeader("Content-Type", "text/xml; charset=utf-8");
        httpRequest.addRequestHeader("Content-Length", SOAP_BODY.length() + "");
        httpRequest.setPost(true);

        InfiniteProgress prog = new InfiniteProgress();
        Dialog dlg = prog.showInifiniteBlocking();
        httpRequest.setDisposeOnCompletion(dlg);

        NetworkManager.getInstance().addToQueueAndWait(httpRequest);
        String data = new String(httpRequest.getResponseData());
        Log.p("CalculateARTranData=" + data, Log.DEBUG);

        try {

            Result result = Result.fromContent(data, Result.XML);

            Log.p("Element e: " + result, Log.DEBUG);

            XMLParser parser = new XMLParser();
            parser.setCaseSensitive(true);
            Element element = parser.parse(convertStringtoInputStreamReader(result.getAsString("//newdataset")));

            for (int i = 0; i < element.getNumChildren(); i++) {
                Element child = element.getChildAt(i);
                // if (child.getTextChildren(null, true).size() == 9) {

                Log.p("i=" + i + " " + child.getTextChildren(null, true).size(), Log.DEBUG);

                String ent_no = RSM(((Element) child.getTextChildren(null, true).get(0)).toString());
                String ar_year = RSM(((Element) child.getTextChildren(null, true).get(1)).toString());
                int intAr_year = Integer.parseInt(ar_year);
                String ent_type_code = RSM(((Element) child.getTextChildren(null, true).get(2)).toString());
                String turnover = RSM(((Element) child.getTextChildren(null, true).get(3)).toString());
                double dblTurnover = Double.parseDouble(turnover);
                String ar_amount = RSM(((Element) child.getTextChildren(null, true).get(4)).toString());
                double dblAr_amount = Double.parseDouble(ar_amount);
                String ar_total = RSM(((Element) child.getTextChildren(null, true).get(5)).toString());
                double dblAr_total = Double.parseDouble(ar_total);
                String reference_no = RSM(((Element) child.getTextChildren(null, true).get(6)).toString());
                int intReference_no = Integer.parseInt(reference_no);
                String ar_penalty = RSM(((Element) child.getTextChildren(null, true).get(7)).toString());
                double dblAr_penalty = Double.parseDouble(ar_penalty);

                EnterpriseDetails e = new EnterpriseDetails();

                e.setEnt_no(ent_no);
                e.setAr_year(intAr_year);
                e.setEnt_type_code(ent_type_code);
                e.setTurnover(dblTurnover);
                e.setAr_amount(dblAr_amount);
                e.setAr_total(dblAr_total);
                e.setReference_no(intReference_no);
                e.setAr_penalty(dblAr_penalty);

                enterpriseDetailses.add(e);

                //}
            }

        } catch (IllegalArgumentException e) {
            Log.p(e.toString());
        }

        return enterpriseDetailses;

    }//end name reservation

    /////////Payments
    public AuthObject getToken(User user) {

        ConnectionRequest post = new ConnectionRequest();

        post.setUrl("https://apidev.cipc.co.za/token");
        post.setPost(true);
        post.setContentType("x-www-form-urlencoded");
        post.addArgument("username", "TEST");
        post.addArgument("password", "TEST");
        post.addArgument("grant_type", "password");

        NetworkManager.getInstance().addToQueueAndWait(post);
        byte[] responseData = post.getResponseData();
        if (responseData != null) {
            try {
                String data = new String(responseData);
                JSONParser json = new JSONParser();
                InputStreamReader is = convertStringtoInputStreamReader(data);
                Map<String, Object> map = json.parseJSON(is);
                Log.p("getToken=" + map.toString());
                AuthObject auth = new AuthObject();
                auth.setAccess_token(map.get("access_token").toString());
                auth.setExpires_in((long) (Double.parseDouble(map.get("expires_in").toString())));//TODO refactor
                auth.setToken_type(map.get("token_type").toString());

                return auth;
            } catch (IOException e) {
                Log.e(e);
            }
        }

        return null;
    }

    public String insertCartItemService(NameReservation nameReservation) {

        String END_POINT = "https://apidev.cipc.co.za/v1/payment/cartitem";

        /*String ref = nameReservation.getReferenceNumber()+"";
        ref = "1" + ref;
        nameReservation.setReferenceNumber(Integer.parseInt(ref));*/
        String BODY
                = "{\"ReferenceNumber\": " + nameReservation.getReferenceNumber() + ","
                + "\"Status\":0,"
                + "\"StatusDate\":\"" + nameReservation.getStatusDate() + "\","
                + "\"CustomerCode\":\"" + nameReservation.getCustomerCode() + "\","
                + "\"ItemType\":4,"
                + "\"ItemData\":\"{\\\"ReferenceNumber\\\": " + nameReservation.getReferenceNumber() + ",\\\"EnterpriseNumber\\\":\\\"\\\",\\\"FormCode\\\":\\\"COR9.1\\\",\\\"ChangeTypeCode\\\":\\\"30\\\",\\\"Description\\\":null,\\\"TotalAmount\\\":" + nameReservation.getTotalAmount() + "}\","
                + "\"Amount\":" + nameReservation.getAmount() + ""
                + "}";

//  String BODY
//                = "{\"ReferenceNumber\": " + nameReservation.getReferenceNumber() + ","
//                + "\"Status\":0,"
//                + "\"StatusDate\":\"2018-06-23T17:04:28.873\","
//                + "\"CustomerCode\":\"" + nameReservation.getCustomerCode() + "\","
//                + "\"ItemType\":4,"
//                + "\"ItemData\":\"{\\\"ReferenceNumber\\\": " + nameReservation.getReferenceNumber() + ",\\\"EnterpriseNumber\\\":\\\"\\\",\\\"FormCode\\\":\\\"COR9.1\\\",\\\"ChangeTypeCode\\\":\\\"30\\\",\\\"Description\\\":null,\\\"TotalAmount\\\":50.0}\","
//                + "\"Amount\":50.0"
//                + "}";
        Log.p("insertCartItemService request=" + BODY, Log.DEBUG);

        ConnectionRequest post = new ConnectionRequest() {
            @Override
            protected void buildRequestBody(OutputStream os) throws IOException {
                Log.p(BODY.toString().trim());
                os.write(BODY.toString().trim().getBytes("UTF-8"));
            }

            @Override
            protected void readResponse(InputStream input) throws IOException {
                // parse response data
            }
        };
        post.setUrl(END_POINT);
        post.setPost(true);
        post.setContentType("application/json");

        User user = new User();
        user.setAgent_code(nameReservation.getCustomerCode());
        AuthObject auth = getToken(user);

        post.addRequestHeader("Authorization", auth.getToken_type() + " " + auth.getAccess_token());

        NetworkManager.getInstance().addToQueueAndWait(post);
        byte[] raw = post.getResponseData();
        Log.p("raw=" + raw);
//        String data = new String(post.getResponseData());

        return null;
    }

    public String insertCartItemAR(User user, ArrayList<EnterpriseDetails> listCalculateARTran) {

        EnterpriseDetails ent = listCalculateARTran.get(0);//this can fail

        String END_POINT = "https://apidev.cipc.co.za/v1/payment/cartitem";

        int ReferenceNumber = ent.getReference_no();
        Log.p("insertCartItemAR ReferenceNumber=" + ReferenceNumber, Log.DEBUG);
        String dateNow = getAnnualReturnsDateNow();
        Log.p("insertCartItemAR dateNow=" + dateNow, Log.DEBUG);

        double total = 0.0;
        //refactor tot calc
        for (int i = 0; i < listCalculateARTran.size(); i++) {
            total += listCalculateARTran.get(i).getAr_total();
        }

        if (listCalculateARTran.size() == 1) {
            AR_BODY
                    = "{\n"
                    + "                \"ReferenceNumber\":" + ReferenceNumber + ",\n"
                    + "                \"Status\":0,\n"
                    + "                \"StatusDate\":\" " + getAnnualReturnsDateNow() + " \",\n"
                    + "                \"CustomerCode\":\"" + user.getAgent_code() + "\",\n"
                    + "                \"ItemType\":1,\n"
                    + "                \"ItemData\":\""
                    + "{\\\"ReferenceNumber\\\":" + ReferenceNumber + ",\\\"FormCode\\\":\\\"CK2B\\\",\\\"EnterpriseNumber\\\":\\\"" + ent.getEnt_no() + "\\\",\\\"EnterpriseType\\\":\\\"  " + ent.getEnt_type_code() + " \\\",\\\"EnterpriseStatus\\\":\\\"28\\\",\\\"EmailAddress\\\":\\\"  \\\",\\\"TelephoneCode\\\":\\\"012\\\",\\\"TelephoneNumber\\\":\\\"1234567\\\",\\\"CellphoneNumber\\\":\\\"\\\",\\\"WebsiteAddress\\\":\\\"\\\",\\\"BusinessDescription\\\":\\\"CARD PAYMENT\\\",\\\"PrincipalPlaceOfBusiness\\\":\\\"\\\",\\\"EnterpriseNameChanged\\\":0,\\\"FinancialYearEndChanged\\\":0,\\\"RegisteredOfficeChanged\\\":0,\\\"LocationOfRecordsChanged\\\":0,\\\"DirectorsChanged\\\":0,\\\"CompanySecretaryChanged\\\":0,\\\"AuditorsChanged\\\":0,\\\"TotalAmount\\\":" + total + ",\\\"YearData\\\":[";

            AR_BODY += "{\\\"ReferenceNumber\\\":" + ReferenceNumber + ",\\\"EnterpriseNumber\\\":\\\" " + ent.getEnt_no() + " \\\",\\\"Year\\\":" + ent.getAr_year() + ",\\\"Turnover\\\":" + ent.getTurnover() + ",\\\"Amount\\\":" + ent.getAr_amount() + ",\\\"PenaltyFee\\\":" + ent.getAr_penalty() + ",\\\"TotalAmount\\\": " + ent.getAr_total() + " ,\\\"Status\\\":null,\\\"StatusDate\\\":\\\" " + getAnnualReturnsDateNow() + "  \\\"}";

        } else {
            AR_BODY
                    = "{\n"
                    + "                \"ReferenceNumber\":" + ReferenceNumber + ",\n"
                    + "                \"Status\":0,\n"
                    + "                \"StatusDate\":\" " + getAnnualReturnsDateNow() + " \",\n"
                    + "                \"CustomerCode\":\"" + user.getAgent_code() + "\",\n"
                    + "                \"ItemType\":1,\n"
                    + "                \"ItemData\":\""
                    + "{\\\"ReferenceNumber\\\":" + ReferenceNumber + ",\\\"FormCode\\\":\\\"CK2B\\\",\\\"EnterpriseNumber\\\":\\\"" + ent.getEnt_no() + "\\\",\\\"EnterpriseType\\\":\\\"  " + ent.getEnt_type_code() + " \\\",\\\"EnterpriseStatus\\\":\\\"28\\\",\\\"EmailAddress\\\":\\\"  \\\",\\\"TelephoneCode\\\":\\\"012\\\",\\\"TelephoneNumber\\\":\\\"1234567\\\",\\\"CellphoneNumber\\\":\\\"\\\",\\\"WebsiteAddress\\\":\\\"\\\",\\\"BusinessDescription\\\":\\\"CARD PAYMENT\\\",\\\"PrincipalPlaceOfBusiness\\\":\\\"\\\",\\\"EnterpriseNameChanged\\\":0,\\\"FinancialYearEndChanged\\\":0,\\\"RegisteredOfficeChanged\\\":0,\\\"LocationOfRecordsChanged\\\":0,\\\"DirectorsChanged\\\":0,\\\"CompanySecretaryChanged\\\":0,\\\"AuditorsChanged\\\":0,\\\"TotalAmount\\\":" + total + ",\\\"YearData\\\":[";

            AR_BODY += "{\\\"ReferenceNumber\\\":" + ReferenceNumber + ",\\\"EnterpriseNumber\\\":\\\" " + ent.getEnt_no() + " \\\",\\\"Year\\\":" + ent.getAr_year() + ",\\\"Turnover\\\":" + ent.getTurnover() + ",\\\"Amount\\\":" + ent.getAr_amount() + ",\\\"PenaltyFee\\\":" + ent.getAr_penalty() + ",\\\"TotalAmount\\\": " + ent.getAr_total() + " ,\\\"Status\\\":null,\\\"StatusDate\\\":\\\" " + getAnnualReturnsDateNow() + "  \\\"}";

            for (int i = 1; i < listCalculateARTran.size(); i++) {
                ent = listCalculateARTran.get(i);//this can fail
                AR_BODY += "{\\\"ReferenceNumber\\\":" + ReferenceNumber + ",\\\"EnterpriseNumber\\\":\\\" " + ent.getEnt_no() + " \\\",\\\"Year\\\":" + ent.getAr_year() + ",\\\"Turnover\\\":" + ent.getTurnover() + ",\\\"Amount\\\":" + ent.getAr_amount() + ",\\\"PenaltyFee\\\":" + ent.getAr_penalty() + ",\\\"TotalAmount\\\": " + ent.getAr_total() + " ,\\\"Status\\\":null,\\\"StatusDate\\\":\\\" " + getAnnualReturnsDateNow() + "  \\\"}";

            }

        }

        AR_BODY += "],\\\"ItemsCount\\\":" + listCalculateARTran.size() + "}\",\n"
                + "\"Amount\":50.0\n"
                + "}";

//        working sample
//        AR_BODY
//                = "{\n"
//                + "                \"ReferenceNumber\":" + ReferenceNumber + ",\n"
//                + "                \"Status\":0,\n"
//                + "                \"StatusDate\":\" " + getAnnualReturnsDateNow() + " \",\n"
//                + "                \"CustomerCode\":\"" + user.getAgent_code() + "\",\n"
//                + "                \"ItemType\":1,\n"
//                + "                \"ItemData\":\""
//                + "{\\\"ReferenceNumber\\\":" + ReferenceNumber + ",\\\"FormCode\\\":\\\"CK2B\\\",\\\"EnterpriseNumber\\\":\\\""+ent.getEnt_no()+"\\\",\\\"EnterpriseType\\\":\\\"  "+ent.getEnt_type_code()+" \\\",\\\"EnterpriseStatus\\\":\\\"28\\\",\\\"EmailAddress\\\":\\\"  \\\",\\\"TelephoneCode\\\":\\\"012\\\",\\\"TelephoneNumber\\\":\\\"1234567\\\",\\\"CellphoneNumber\\\":\\\"\\\",\\\"WebsiteAddress\\\":\\\"\\\",\\\"BusinessDescription\\\":\\\"CARD PAYMENT\\\",\\\"PrincipalPlaceOfBusiness\\\":\\\"\\\",\\\"EnterpriseNameChanged\\\":0,\\\"FinancialYearEndChanged\\\":0,\\\"RegisteredOfficeChanged\\\":0,\\\"LocationOfRecordsChanged\\\":0,\\\"DirectorsChanged\\\":0,\\\"CompanySecretaryChanged\\\":0,\\\"AuditorsChanged\\\":0,\\\"TotalAmount\\\":" + total + ",\\\"YearData\\\":"
//                
//                
//                
//                + "[{\\\"ReferenceNumber\\\":" + ReferenceNumber + ",\\\"EnterpriseNumber\\\":\\\" "+ent.getEnt_no()+" \\\",\\\"Year\\\":" + ent.getAr_year() + ",\\\"Turnover\\\":" + ent.getTurnover() + ",\\\"Amount\\\":" + ent.getAr_amount() + ",\\\"PenaltyFee\\\":" + ent.getAr_penalty() + ",\\\"TotalAmount\\\": " + ent.getAr_total() + " ,\\\"Status\\\":null,\\\"StatusDate\\\":\\\" " + getAnnualReturnsDateNow() + "  \\\"}]"
//               
//                
//                
//                + ",\\\"ItemsCount\\\":" + size + "}\",\n"
//                + "\"Amount\":50.0\n"
//                + "}";
        //String ReferenceNumber = "589117789";
//          AR_BODY = 
//                "{\n"
//                + "                \"ReferenceNumber\":" + ReferenceNumber + ",\n"
//                + "                \"Status\":0,\n"
//                + "                \"StatusDate\":\" "+dateNow+"\",\n"
//                + "                \"CustomerCode\":\"" + user.getAgent_code() + "\",\n"
//                + "                \"ItemType\":1,\n"
//                + "                \"ItemData\":\""
//                + "{\\\"ReferenceNumber\\\":" + ReferenceNumber + ",\\\"FormCode\\\":\\\"CK2B\\\",\\\"EnterpriseNumber\\\":\\\"K2011100088\\\",\\\"EnterpriseType\\\":\\\"23\\\",\\\"EnterpriseStatus\\\":\\\"28\\\",\\\"EmailAddress\\\":\\\"jbruton@cipc.co.za\\\",\\\"TelephoneCode\\\":\\\"012\\\",\\\"TelephoneNumber\\\":\\\"1234567\\\",\\\"CellphoneNumber\\\":\\\"\\\",\\\"WebsiteAddress\\\":\\\"\\\",\\\"BusinessDescription\\\":\\\"CARD PAYMENT\\\",\\\"PrincipalPlaceOfBusiness\\\":\\\"\\\",\\\"EnterpriseNameChanged\\\":0,\\\"FinancialYearEndChanged\\\":0,\\\"RegisteredOfficeChanged\\\":0,\\\"LocationOfRecordsChanged\\\":0,\\\"DirectorsChanged\\\":0,\\\"CompanySecretaryChanged\\\":0,\\\"AuditorsChanged\\\":0,\\\"TotalAmount\\\":2250.00,\\\"YearData\\\":["
//                + "{\\\"ReferenceNumber\\\":" + ReferenceNumber + ",\\\"EnterpriseNumber\\\":\\\"K2011100088\\\",\\\"Year\\\":2009,\\\"Turnover\\\":0.0,\\\"Amount\\\":100.00,\\\"PenaltyFee\\\":150.00,\\\"TotalAmount\\\":250.00,\\\"Status\\\":null,\\\"StatusDate\\\":\\\"0001-01-01T00:00:00\\\"},{\\\"ReferenceNumber\\\":533549914,\\\"EnterpriseNumber\\\":\\\"K2011100088\\\",\\\"Year\\\":2010,\\\"Turnover\\\":0.0,\\\"Amount\\\":100.00,\\\"PenaltyFee\\\":150.00,\\\"TotalAmount\\\":250.00,\\\"Status\\\":null,\\\"StatusDate\\\":\\\"0001-01-01T00:00:00\\\"},"
//                + "{\\\"ReferenceNumber\\\":" + ReferenceNumber + ",\\\"EnterpriseNumber\\\":\\\"K2011100088\\\",\\\"Year\\\":2011,\\\"Turnover\\\":0.0,\\\"Amount\\\":100.00,\\\"PenaltyFee\\\":150.00,\\\"TotalAmount\\\":250.00,\\\"Status\\\":null,\\\"StatusDate\\\":\\\"0001-01-01T00:00:00\\\"},{\\\"ReferenceNumber\\\":533549914,\\\"EnterpriseNumber\\\":\\\"K2011100088\\\",\\\"Year\\\":2012,\\\"Turnover\\\":0.0,\\\"Amount\\\":100.00,\\\"PenaltyFee\\\":150.00,\\\"TotalAmount\\\":250.00,\\\"Status\\\":null,\\\"StatusDate\\\":\\\"0001-01-01T00:00:00\\\"},"
//                + "{\\\"ReferenceNumber\\\":" + ReferenceNumber + ",\\\"EnterpriseNumber\\\":\\\"K2011100088\\\",\\\"Year\\\":2013,\\\"Turnover\\\":0.0,\\\"Amount\\\":100.00,\\\"PenaltyFee\\\":150.00,\\\"TotalAmount\\\":250.00,\\\"Status\\\":null,\\\"StatusDate\\\":\\\"0001-01-01T00:00:00\\\"},{\\\"ReferenceNumber\\\":533549914,\\\"EnterpriseNumber\\\":\\\"K2011100088\\\",\\\"Year\\\":2014,\\\"Turnover\\\":0.0,\\\"Amount\\\":100.00,\\\"PenaltyFee\\\":150.00,\\\"TotalAmount\\\":250.00,\\\"Status\\\":null,\\\"StatusDate\\\":\\\"0001-01-01T00:00:00\\\"},"
//                + "{\\\"ReferenceNumber\\\":" + ReferenceNumber + ",\\\"EnterpriseNumber\\\":\\\"K2011100088\\\",\\\"Year\\\":2015,\\\"Turnover\\\":0.0,\\\"Amount\\\":100.00,\\\"PenaltyFee\\\":150.00,\\\"TotalAmount\\\":250.00,\\\"Status\\\":null,\\\"StatusDate\\\":\\\"0001-01-01T00:00:00\\\"},"
//                + "{\\\"ReferenceNumber\\\":" + ReferenceNumber + ",\\\"EnterpriseNumber\\\":\\\"K2011100088\\\",\\\"Year\\\":2016,\\\"Turnover\\\":0.0,\\\"Amount\\\":100.00,\\\"PenaltyFee\\\":150.00,\\\"TotalAmount\\\":250.00,\\\"Status\\\":null,\\\"StatusDate\\\":\\\"0001-01-01T00:00:00\\\"},"
//                + "{\\\"ReferenceNumber\\\":" + ReferenceNumber + ",\\\"EnterpriseNumber\\\":\\\"K2011100088\\\",\\\"Year\\\":2017,\\\"Turnover\\\":0.0,\\\"Amount\\\":100.00,\\\"PenaltyFee\\\":150.00,\\\"TotalAmount\\\":250.00,\\\"Status\\\":null,\\\"StatusDate\\\":\\\"0001-01-01T00:00:00\\\"}],\\\"ItemsCount\\\":9}\",\n"
//                + "                \"Amount\":50.0\n"
//                + "}";
//        String BODY
//                = "{\n"
//                + "                \"ReferenceNumber\":" + ent.getReference_no() + ",\n"
//                + "                \"Status\":0,\n"
//                + "                \"StatusDate\":\" "+getDateNow()+"\",\n"
//                + "                \"CustomerCode\":\"" + user.getAgent_code() + "\",\n"
//                + "                \"ItemType\":1,\n"
//                + "                \"ItemData\":\""
//                + "{\\\"ReferenceNumber\\\":" + ent.getReference_no() + ",\\\"FormCode\\\":\\\"CK2B\\\",\\\"EnterpriseNumber\\\":\\\"K2011100088\\\",\\\"EnterpriseType\\\":\\\"23\\\",\\\"EnterpriseStatus\\\":\\\"28\\\",\\\"EmailAddress\\\":\\\"jbruton@cipc.co.za\\\",\\\"TelephoneCode\\\":\\\"012\\\",\\\"TelephoneNumber\\\":\\\"1234567\\\",\\\"CellphoneNumber\\\":\\\"\\\",\\\"WebsiteAddress\\\":\\\"\\\",\\\"BusinessDescription\\\":\\\"CARD PAYMENT\\\",\\\"PrincipalPlaceOfBusiness\\\":\\\"\\\",\\\"EnterpriseNameChanged\\\":0,\\\"FinancialYearEndChanged\\\":0,\\\"RegisteredOfficeChanged\\\":0,\\\"LocationOfRecordsChanged\\\":0,\\\"DirectorsChanged\\\":0,\\\"CompanySecretaryChanged\\\":0,\\\"AuditorsChanged\\\":0,\\\"TotalAmount\\\":2250.00,\\\"YearData\\\":"
//                + "[{\\\"ReferenceNumber\\\":" + ent.getReference_no() + ",\\\"EnterpriseNumber\\\":\\\"K2011100088\\\",\\\"Year\\\":2009,\\\"Turnover\\\":0.0,\\\"Amount\\\":100.00,\\\"PenaltyFee\\\":150.00,\\\"TotalAmount\\\":250.00,\\\"Status\\\":null,\\\"StatusDate\\\":\\\"0001-01-01T00:00:00\\\"},{\\\"ReferenceNumber\\\":"+ ent.getReference_no() +" ,\\\"EnterpriseNumber\\\":\\\"K2011100088\\\",\\\"Year\\\":2010,\\\"Turnover\\\":0.0,\\\"Amount\\\":100.00,\\\"PenaltyFee\\\":150.00,\\\"TotalAmount\\\":250.00,\\\"Status\\\":null,\\\"StatusDate\\\":\\\"0001-01-01T00:00:00\\\"},"
//                + "{\\\"ReferenceNumber\\\":" + ent.getReference_no() + ",\\\"EnterpriseNumber\\\":\\\"K2011100088\\\",\\\"Year\\\":2011,\\\"Turnover\\\":0.0,\\\"Amount\\\":100.00,\\\"PenaltyFee\\\":150.00,\\\"TotalAmount\\\":250.00,\\\"Status\\\":null,\\\"StatusDate\\\":\\\"0001-01-01T00:00:00\\\"},{\\\"ReferenceNumber\\\":"+ ent.getReference_no() +",\\\"EnterpriseNumber\\\":\\\"K2011100088\\\",\\\"Year\\\":2012,\\\"Turnover\\\":0.0,\\\"Amount\\\":100.00,\\\"PenaltyFee\\\":150.00,\\\"TotalAmount\\\":250.00,\\\"Status\\\":null,\\\"StatusDate\\\":\\\"0001-01-01T00:00:00\\\"},"
//                + "{\\\"ReferenceNumber\\\":" + ent.getReference_no() + ",\\\"EnterpriseNumber\\\":\\\"K2011100088\\\",\\\"Year\\\":2013,\\\"Turnover\\\":0.0,\\\"Amount\\\":100.00,\\\"PenaltyFee\\\":150.00,\\\"TotalAmount\\\":250.00,\\\"Status\\\":null,\\\"StatusDate\\\":\\\"0001-01-01T00:00:00\\\"},{\\\"ReferenceNumber\\\":"+ ent.getReference_no() +",\\\"EnterpriseNumber\\\":\\\"K2011100088\\\",\\\"Year\\\":2014,\\\"Turnover\\\":0.0,\\\"Amount\\\":100.00,\\\"PenaltyFee\\\":150.00,\\\"TotalAmount\\\":250.00,\\\"Status\\\":null,\\\"StatusDate\\\":\\\"0001-01-01T00:00:00\\\"},"
//                + "{\\\"ReferenceNumber\\\":" + ent.getReference_no() + ",\\\"EnterpriseNumber\\\":\\\"K2011100088\\\",\\\"Year\\\":2015,\\\"Turnover\\\":0.0,\\\"Amount\\\":100.00,\\\"PenaltyFee\\\":150.00,\\\"TotalAmount\\\":250.00,\\\"Status\\\":null,\\\"StatusDate\\\":\\\"0001-01-01T00:00:00\\\"},"
//                + "{\\\"ReferenceNumber\\\":" + ent.getReference_no() + ",\\\"EnterpriseNumber\\\":\\\"K2011100088\\\",\\\"Year\\\":2016,\\\"Turnover\\\":0.0,\\\"Amount\\\":100.00,\\\"PenaltyFee\\\":150.00,\\\"TotalAmount\\\":250.00,\\\"Status\\\":null,\\\"StatusDate\\\":\\\"0001-01-01T00:00:00\\\"},"
//                + "{\\\"ReferenceNumber\\\":" + ent.getReference_no() + ",\\\"EnterpriseNumber\\\":\\\"K2011100088\\\",\\\"Year\\\":2017,\\\"Turnover\\\":0.0,\\\"Amount\\\":100.00,\\\"PenaltyFee\\\":150.00,\\\"TotalAmount\\\":250.00,\\\"Status\\\":null,\\\"StatusDate\\\":\\\"0001-01-01T00:00:00\\\"}],\\\"ItemsCount\\\":9}\",\n"
//                + "                \"Amount\":50.0\n"
//                + "}";
        Log.p("insertCartItemAR REQUEST=" + AR_BODY, Log.DEBUG);

        ConnectionRequest post = new ConnectionRequest() {
            @Override
            protected void buildRequestBody(OutputStream os) throws IOException {
                //Log.p(BODY.toString().trim());
                os.write(AR_BODY.toString().trim().getBytes("UTF-8"));
            }

            @Override
            protected void readResponse(InputStream input) throws IOException {
                // parse response data
            }
        };
        post.setUrl(END_POINT);
        post.setPost(true);
        post.setContentType("application/json");
        AuthObject auth = getToken(user);

        post.addRequestHeader("Authorization", auth.getToken_type() + " " + auth.getAccess_token());

        NetworkManager.getInstance().addToQueueAndWait(post);
        byte[] raw = post.getResponseData();
        Log.p("insertCartItemAR=" + raw);
//        String data = new String(post.getResponseData());

        return null;
    }

    public String deleteCartItem(User user, Map m) {

        String END_POINT = "https://apidev.cipc.co.za/v1/payment/cartitem/update";

        String BODY = Result.fromContent(m).toString();
        Log.p("deleteCartItem BODY=" + BODY, Log.DEBUG);

//        String BODY
//                = "{\"ReferenceNumber\":8118779575,"
//                + "\"Status\":2,"
//                + "\"StatusDate\":\"2018-04-23T13:04:28.873\","
//                + "\"CustomerCode\":\"" + user.getAgent_code() + "\","
//                + "\"ItemType\":4,"
//                + "\"ItemData\":\"{\\\"ReferenceNumber\\\":9118779575,\\\"EnterpriseNumber\\\":\\\"\\\",\\\"FormCode\\\":\\\"CoR9.1\\\",\\\"ChangeTypeCode\\\":\\\"30\\\",\\\"Description\\\":null,\\\"TotalAmount\\\":50.0}\","
//                + "\"Amount\":50.0"
//                + "}";
        ConnectionRequest post = new ConnectionRequest() {
            @Override
            protected void buildRequestBody(OutputStream os) throws IOException {
                Log.p(BODY.toString().trim());
                os.write(BODY.toString().trim().getBytes("UTF-8"));
            }

            @Override
            protected void readResponse(InputStream input) throws IOException {
                // parse response data
            }
        };
        AuthObject auth = getToken(user);

        post.addRequestHeader("Authorization", auth.getToken_type() + " " + auth.getAccess_token());
        post.setUrl(END_POINT);
        post.setPost(true);
        post.setContentType("application/json");

        NetworkManager.getInstance().addToQueueAndWait(post);
        byte[] raw = post.getResponseData();
        Log.p("deleteCartItem=" + raw);
//        String data = new String(post.getResponseData());

        return null;
    }

    public Map getCart(User user) {

        Map map = null;

        AuthObject auth = getToken(user);

        /* Map jsonData = Rest.get("https://apidev.cipc.co.za/v1/payment/cart/" + user.getAgent_code())
                .header("Authorization", auth.getToken_type() + " " + auth.getAccess_token()).jsonContent()
                .getAsJsonMap().getResponseData();

        Log.p("getCart=" + jsonData.toString());*/
        ConnectionRequest post = new ConnectionRequest();

        post.setUrl("https://apidev.cipc.co.za/v1/payment/cart/" + user.getAgent_code());
        post.setPost(false);
        post.addRequestHeader("Content-Type", "application/json; charset=utf-8");

        post.addRequestHeader("Authorization", auth.getToken_type() + " " + auth.getAccess_token());
        NetworkManager.getInstance().addToQueueAndWait(post);
        byte[] responseData = post.getResponseData();
        if (responseData != null) {
            String data = new String(responseData);
            try {
                JSONParser parser = new JSONParser();
                parser.setIncludeNulls(true);
                map = parser.parseJSON(convertStringtoInputStreamReader(data));
                Log.p("data=" + data, Log.DEBUG);
                Log.p("map=" + map, Log.DEBUG);

            } catch (IOException e) {
                Log.e(e);
            }

            //JSONParser
        }

        return map;
    }

    public Map getCustomerData(User user) {

        Map map = null;

        AuthObject auth = getToken(user);

        /* Map jsonData = Rest.get("https://apidev.cipc.co.za/v1/payment/cart/" + user.getAgent_code())
                .header("Authorization", auth.getToken_type() + " " + auth.getAccess_token()).jsonContent()
                .getAsJsonMap().getResponseData();

        Log.p("getCart=" + jsonData.toString());*/
        ConnectionRequest post = new ConnectionRequest();

        post.setUrl("https://apidev.cipc.co.za/v1/customer/customer/" + user.getAgent_code());
        post.setPost(false);
        post.addRequestHeader("Content-Type", "application/json; charset=utf-8");

        post.addRequestHeader("Authorization", auth.getToken_type() + " " + auth.getAccess_token());
        NetworkManager.getInstance().addToQueueAndWait(post);
        byte[] responseData = post.getResponseData();
        if (responseData != null) {
            String data = new String(responseData);
            try {
                JSONParser parser = new JSONParser();
                map = parser.parseJSON(convertStringtoInputStreamReader(data));
                Log.p("getCustomerData=" + data, Log.DEBUG);
                Log.p("getCustomerData=" + map, Log.DEBUG);

            } catch (IOException e) {
                Log.e(e);
            }

            //JSONParser
        }

        return map;
    }

    public Map pendingAnnualReturns(User user, String entNo) {

        Map map = null;

        AuthObject auth = getToken(user);

        /* Map jsonData = Rest.get("https://apidev.cipc.co.za/v1/payment/cart/" + user.getAgent_code())
                .header("Authorization", auth.getToken_type() + " " + auth.getAccess_token()).jsonContent()
                .getAsJsonMap().getResponseData();

        Log.p("getCart=" + jsonData.toString());*/
        ConnectionRequest post = new ConnectionRequest();

        post.setUrl("https://apidev.cipc.co.za/v1/payment/cartitem/enterprise/" + entNo);
        post.setPost(false);
        post.addRequestHeader("Content-Type", "application/json; charset=utf-8");

        post.addRequestHeader("Authorization", auth.getToken_type() + " " + auth.getAccess_token());
        NetworkManager.getInstance().addToQueueAndWait(post);
        byte[] responseData = post.getResponseData();
        if (responseData != null) {
            String data = new String(responseData);
            try {
                JSONParser parser = new JSONParser();
                map = parser.parseJSON(convertStringtoInputStreamReader(data));
                Log.p("pendingAnnualReturns data=" + data, Log.DEBUG);
                Log.p("pendingAnnualReturns map=" + map, Log.DEBUG);

            } catch (IOException e) {
                Log.e(e);
            }

            //JSONParser
        }

        return map;
    }

    public String getEnterpriseDetails(User user) {

        AuthObject auth = getToken(user);

        ConnectionRequest post = new ConnectionRequest();

        post.setUrl("https://apidev.cipc.co.za/v1/companies/enterprise/K2013064531");
        post.setPost(false);
        post.setContentType("application/json");

        post.addRequestHeader("Authorization", auth.getToken_type() + " " + auth.getAccess_token());
        NetworkManager.getInstance().addToQueueAndWait(post);
        byte[] responseData = post.getResponseData();
        if (responseData != null) {
            String data = new String(responseData);

            //JSONParser
            Log.p("getEnterpriseDetails=" + data);
        }

        return null;
    }

    ////////End payments
    public void get_otp_info_MOBI(User user) {

        final String SOAP_BODY
                = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cipc=\"CIPC_WEB_SERVICES\">\n"
                + "   <soapenv:Header/>\n"
                + "   <soapenv:Body>\n"
                + "      <cipc:get_otp_info_MOBI>\n"
                + "           <cipc:sUserName>wBAA7LAkWIs=</cipc:sUserName>\n"
                + "         <cipc:sPassword>nhXSFLH3xKlrDYYKEWHlVw==</cipc:sPassword>\n"
                + "         <cipc:sBankID>wBAA7LAkWIs=</cipc:sBankID>\n"
                + "         <cipc:Sent_no>K2016186748</cipc:Sent_no>\n"
                + "         <cipc:track_no>934388861</cipc:track_no>\n"
                + "      </cipc:get_otp_info_MOBI>\n"
                + "   </soapenv:Body>\n"
                + "</soapenv:Envelope>";

        ConnectionRequest httpRequest = new ConnectionRequest() {
            Element h;

            @Override
            protected void buildRequestBody(OutputStream os) throws IOException {
                super.buildRequestBody(os);
                os.write(SOAP_BODY.getBytes("utf-8"));

            }

            protected void postResponse() {

                super.postResponse();
            }

            protected void readResponse(InputStream input) throws IOException {
                super.readResponse(input);

            }

            @Override
            protected void handleException(Exception err) {
                Log.p("Exception: " + err.toString());
                Dialog.show("No Internet", "There is no internet connection. Please switch your connection on.", "Okay", null);

            }
        };

        httpRequest.setUrl("http://testwebservices4.cipc.co.za/enterprise.asmx?wsdl");
        httpRequest.addRequestHeader("Content-Type", "text/xml; charset=utf-8");
        httpRequest.addRequestHeader("Content-Length", SOAP_BODY.length() + "");
        httpRequest.setPost(true);

        NetworkManager.getInstance().addToQueueAndWait(httpRequest);
        String data = new String(httpRequest.getResponseData());

        try {

            Result result = Result.fromContent(data, Result.XML);

            Log.p("Result=" + result);

            XMLParser parser = new XMLParser();
            parser.setCaseSensitive(true);
            Element element = parser.parse(convertStringtoInputStreamReader(result.getAsString("//dataset")));

            for (int i = 0; i < element.getNumChildren(); i++) {

                Element child = element.getChildAt(i);

                Element elem_id_no = (Element) child.getTextChildren(null, true).get(0);
                String id_no = removeSpecialMarks(elem_id_no.getText());

                Element elem_otp = (Element) child.getTextChildren(null, true).get(1);
                String otp = removeSpecialMarks(elem_otp.getText());

                Element elem_ent_no = (Element) child.getTextChildren(null, true).get(2);
                String ent_no = removeSpecialMarks(elem_ent_no.getText());

                Element elem_first_names = (Element) child.getTextChildren(null, true).get(3);
                String first_names = removeSpecialMarks(elem_first_names.getText());

                Element elem_surname = (Element) child.getTextChildren(null, true).get(4);
                String surname = removeSpecialMarks(elem_surname.getText());

                Log.p(id_no + ", " + otp + ", " + ent_no + ", " + first_names + ", " + surname);

            }

        } catch (IllegalArgumentException e) {
            Log.e(e);

        }

    }

    private static InputStreamReader convertStringtoInputStreamReader(String data) {

        byte[] resultByte = data.getBytes();
        ByteArrayInputStream bis = new ByteArrayInputStream(resultByte);
        InputStreamReader is = new InputStreamReader(bis);
        return is;

    }

    private String removeSpecialMarks(String name) {
        name = name.trim();
        name = name.substring(1);
        name = name.substring(0, name.length() - 1);

        return name;

    }

    public User get_cust_MOBI(User user) {

        final String SOAP_BODY
                = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cipc=\"CIPC_WEB_SERVICES\">\n"
                + "\n"
                + "   <soapenv:Header/>\n"
                + "\n"
                + "   <soapenv:Body>\n"
                + "\n"
                + "      <cipc:get_cust_MOBI>\n"
                + "\n"
                + "         <cipc:sUserName>" + Constants.sUserName + "</cipc:sUserName>\n"
                + "\n"
                + "         <cipc:sPassword>" + Constants.sPassword + "</cipc:sPassword>\n"
                + "\n"
                + "         <cipc:sBankID>" + Constants.sBankID + "</cipc:sBankID>\n"
                + "\n"
                + "         <cipc:scustcode>" + user.getAgent_code().toUpperCase() + "</cipc:scustcode>\n"
                + "\n"
                + "      </cipc:get_cust_MOBI>\n"
                + "\n"
                + "   </soapenv:Body>\n"
                + "\n"
                + "</soapenv:Envelope>";

        ConnectionRequest httpRequest = new ConnectionRequest() {
            Element h;

            @Override
            protected void buildRequestBody(OutputStream os) throws IOException {
                super.buildRequestBody(os);
                os.write(SOAP_BODY.getBytes("utf-8"));

            }

            protected void postResponse() {

                super.postResponse();
            }

            protected void readResponse(InputStream input) throws IOException {
                super.readResponse(input);

            }

            @Override
            protected void handleIOException(IOException err) {
                super.handleIOException(err); //To change body of generated methods, choose Tools | Templates.
                Log.p("handleIOException: " + err.toString());
                Dialog.show("handleIOException 1", "", "Ok", null);
                
                if(Connectivity.isConnected()){
                Dialog.show("isConnected", "", "Ok", null);
                    
                }
                else{
                    //no connection
                            Dialog.show("no connection", "", "Ok", null);

                
                }
                Dialog.show("44444444444no connection", "", "Ok", null);
                
            }

            @Override
            protected void handleRuntimeException(RuntimeException err) {
                super.handleRuntimeException(err); //To change body of generated methods, choose Tools | Templates.
                Log.p("Exception: " + err.toString());
                Dialog.show("handleRuntimeException", "", "Ok", null);

            }

            @Override
            protected void handleException(Exception err) {
                Log.p("Exception: " + err.toString());
                //Dialog.show("No Internet", "There is no internet connection. Please switch your connection on.", "Okay", null);

            }
        };

        httpRequest.setUrl("https://testwebservices4.cipc.co.za/customer.asmx?wsdl");
        httpRequest.addRequestHeader("Content-Type", "text/xml; charset=utf-8");
        httpRequest.addRequestHeader("Content-Length", SOAP_BODY.length() + "");
        httpRequest.setPost(true);

//        InfiniteProgress prog = new InfiniteProgress();
//        Dialog dlg = prog.showInifiniteBlocking();
//        httpRequest.setDisposeOnCompletion(dlg);
        NetworkManager.getInstance().addToQueueAndWait(httpRequest);
        if (httpRequest.getResponseData() != null) {
            String data = new String(httpRequest.getResponseData());//TODO do null check

            try {

                Result result = Result.fromContent(data, Result.XML);
                User responseUser = new User();

                Log.p("get_cust_MOBI: " + result, Log.DEBUG);

                responseUser.setAgent_code(user.getAgent_code());
                responseUser.setPassword(result.getAsString("//get_cust_mobiresult"));

                return responseUser;

            } catch (IllegalArgumentException e) {
                Log.p(e.toString());
            }
        }

        return null;

    }//end login

    public String forget_password_MOBI(String customerCode) {

        String responseString = null;

        final String SOAP_BODY
                = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cipc=\"CIPC_WEB_SERVICES\">\n"
                + "\n"
                + "   <soapenv:Header/>\n"
                + "\n"
                + "   <soapenv:Body>\n"
                + "\n"
                + "      <cipc:forget_password_MOBI>\n"
                + "\n"
                + "         <cipc:sUserName>wBAA7LAkWIs=</cipc:sUserName>\n"
                + "\n"
                + "          <cipc:sPassword>6EGQAUzYJlhvffhZ+gUFfg==</cipc:sPassword>\n"
                + "\n"
                + "          <cipc:sBankID>wBAA7LAkWIs=</cipc:sBankID>\n"
                + "\n"
                + "         <cipc:sCust_Code>" + customerCode + "</cipc:sCust_Code>\n"
                + "\n"
                + "      </cipc:forget_password_MOBI>\n"
                + "\n"
                + "   </soapenv:Body>\n"
                + "\n"
                + "</soapenv:Envelope>";

        ConnectionRequest httpRequest = new ConnectionRequest() {
            Element h;

            @Override
            protected void buildRequestBody(OutputStream os) throws IOException {
                super.buildRequestBody(os);
                os.write(SOAP_BODY.getBytes("utf-8"));

            }

            protected void postResponse() {

                super.postResponse();
            }

            protected void readResponse(InputStream input) throws IOException {
                super.readResponse(input);

            }

            @Override
            protected void handleException(Exception err) {
                Log.p("Exception: " + err.toString());
                Dialog.show("No Internet", "There is no internet connection. Please switch your connection on.", "Okay", null);

            }
        };

        httpRequest.setUrl("https://testwebservices4.cipc.co.za/customer.asmx?wsdl");
        httpRequest.addRequestHeader("Content-Type", "text/xml; charset=utf-8");
        httpRequest.addRequestHeader("Content-Length", SOAP_BODY.length() + "");
        httpRequest.setPost(true);

        InfiniteProgress prog = new InfiniteProgress();
        Dialog dlg = prog.showInifiniteBlocking();
        httpRequest.setDisposeOnCompletion(dlg);

        NetworkManager.getInstance().addToQueueAndWait(httpRequest);
        String data = new String(httpRequest.getResponseData());

        try {

            Result result = Result.fromContent(data, Result.XML);

            Log.p("forget_password_MOBI: " + result, Log.DEBUG);

            responseString = result.getAsString("//forget_password_mobiresult");

            return responseString;

        } catch (IllegalArgumentException e) {
            Log.p(e.toString());
        }

        return responseString;

    }//end forget_password_MOBI

    public String[] get_countries(User user) {

        ArrayList<Country> list = new ArrayList<Country>();

        final String SOAP_BODY
                = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cipc=\"CIPC_WEB_SERVICES\">\n"
                + "\n"
                + "   <soapenv:Header/>\n"
                + "\n"
                + "   <soapenv:Body>\n"
                + "\n"
                + "      <cipc:get_countries>\n"
                + "\n"
                + "         <!--Optional:-->\n"
                + "\n"
                + "          <cipc:sUserName>wBAA7LAkWIs=</cipc:sUserName>\n"
                + "\n"
                + "          <cipc:sPassword>6EGQAUzYJlhvffhZ+gUFfg==</cipc:sPassword>\n"
                + "\n"
                + "          <cipc:sBankID>wBAA7LAkWIs=</cipc:sBankID>\n"
                + "\n"
                + "         <!--Optional:-->\n"
                + "\n"
                + "         <cipc:sRefNo></cipc:sRefNo>\n"
                + "\n"
                + "         <!--Optional:-->\n"
                + "\n"
                + "         <cipc:sCust_Code>KD7788</cipc:sCust_Code>\n"
                + "\n"
                + "      </cipc:get_countries>\n"
                + "\n"
                + "   </soapenv:Body>\n"
                + "\n"
                + "</soapenv:Envelope>";

        ConnectionRequest httpRequest = new ConnectionRequest() {
            Element h;

            @Override
            protected void buildRequestBody(OutputStream os) throws IOException {
                super.buildRequestBody(os);
                os.write(SOAP_BODY.getBytes("utf-8"));

            }

            protected void postResponse() {

                super.postResponse();
            }

            protected void readResponse(InputStream input) throws IOException {
                super.readResponse(input);

            }

            @Override
            protected void handleException(Exception err) {
                Log.p("Exception: " + err.toString());
                Dialog.show("No Internet", "There is no internet connection. Please switch your connection on.", "Okay", null);

            }
        };

        httpRequest.setUrl("https://testwebservices4.cipc.co.za/customer.asmx?wsdl");
        httpRequest.addRequestHeader("Content-Type", "text/xml; charset=utf-8");
        httpRequest.addRequestHeader("Content-Length", SOAP_BODY.length() + "");
        httpRequest.setPost(true);

        InfiniteProgress prog = new InfiniteProgress();
        Dialog dlg = prog.showInifiniteBlocking();
        httpRequest.setDisposeOnCompletion(dlg);

        NetworkManager.getInstance().addToQueueAndWait(httpRequest);
        String data = new String(httpRequest.getResponseData());

        try {

            Result result = Result.fromContent(data, Result.XML);

            //Log.p("get_countries: " + result, Log.DEBUG);
            XMLParser parser = new XMLParser();
            parser.setCaseSensitive(true);
            Element element = parser.parse(convertStringtoInputStreamReader(result.getAsString("//dataset")));

            for (int i = 0; i < element.getNumChildren(); i++) {
                Element child = element.getChildAt(i);
                // if (child.getTextChildren(null, true).size() == 9) {

                String country = RSM(((Element) child.getTextChildren(null, true).get(0)).toString());
                String countr_code = RSM(((Element) child.getTextChildren(null, true).get(1)).toString());

                //Log.p("country=" + country + ", countr_code=" + countr_code, Log.DEBUG);
                Country c = new Country();
                c.setCountr_code(countr_code);
                c.setCountry(country);
                list.add(c);

            }

            String countriesArray[] = new String[list.size() + 1];
            countriesArray[0] = "Select Country";
            for (int i = 0; i < list.size(); i++) {
                countriesArray[i + 1] = list.get(i).getCountry();
            }

            return countriesArray;

        } catch (IllegalArgumentException e) {
            Log.p(e.toString());
        }

        return null;

    }//end get_countries

    public String Get_Cust_code_id_MOBI(String id) {

        final String SOAP_BODY
                = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cipc=\"CIPC_WEB_SERVICES\">\n"
                + "\n"
                + "   <soapenv:Header/>\n"
                + "\n"
                + "   <soapenv:Body>\n"
                + "\n"
                + "      <cipc:Get_Cust_code_id_MOBI>\n"
                + "\n"
                + "         <cipc:sUserName>wBAA7LAkWIs=</cipc:sUserName>\n"
                + "\n"
                + "         <cipc:sPassword>6EGQAUzYJlhvffhZ+gUFfg==</cipc:sPassword>\n"
                + "\n"
                + "         <cipc:sBankID>wBAA7LAkWIs=</cipc:sBankID>\n"
                + "\n"
                + "         <cipc:sid_no>" + id + "</cipc:sid_no>\n"
                + "\n"
                + "      </cipc:Get_Cust_code_id_MOBI>\n"
                + "\n"
                + "   </soapenv:Body>\n"
                + "\n"
                + "</soapenv:Envelope>";

        ConnectionRequest httpRequest = new ConnectionRequest() {
            Element h;

            @Override
            protected void buildRequestBody(OutputStream os) throws IOException {
                super.buildRequestBody(os);
                os.write(SOAP_BODY.getBytes("utf-8"));

            }

            protected void postResponse() {

                super.postResponse();
            }

            protected void readResponse(InputStream input) throws IOException {
                super.readResponse(input);

            }

            @Override
            protected void handleException(Exception err) {
                Log.p("Exception: " + err.toString());
                Dialog.show("No Internet", "There is no internet connection. Please switch your connection on.", "Okay", null);

            }
        };

        httpRequest.setUrl("https://testwebservices4.cipc.co.za/customer.asmx?wsdl");
        httpRequest.addRequestHeader("Content-Type", "text/xml; charset=utf-8");
        httpRequest.addRequestHeader("Content-Length", SOAP_BODY.length() + "");
        httpRequest.setPost(true);

        InfiniteProgress prog = new InfiniteProgress();
        Dialog dlg = prog.showInifiniteBlocking();
        httpRequest.setDisposeOnCompletion(dlg);

        NetworkManager.getInstance().addToQueueAndWait(httpRequest);
        String data = new String(httpRequest.getResponseData());

        try {

            Result result = Result.fromContent(data, Result.XML);
            User responseUser = new User();

            String customer_code = result.getAsString("//customer_code");

            Log.p("Get_Cust_code_id_MOBI -> customer_code= " + customer_code, Log.DEBUG);

            return customer_code;

        } catch (IllegalArgumentException e) {
            Log.p(e.toString());
        }

        return null;

    }//end Get_Cust_code_id_MOBI

    public User ReceiveNewCustData_Update(User user) {

        final String SOAP_BODY
                = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cipc=\"CIPC_WEB_SERVICES\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\">\n"
                + "\n"
                + "   <soapenv:Header/>\n"
                + "\n"
                + "   <soapenv:Body>\n"
                + "\n"
                + "            <cipc:ReceiveNewCustData_UPDATE_MOBI>\n"
                + "\n"
                + "        <cipc:sUserName>wBAA7LAkWIs=</cipc:sUserName>\n"
                + "\n"
                + "          <cipc:sPassword>6EGQAUzYJlhvffhZ+gUFfg==</cipc:sPassword>\n"
                + "\n"
                + "          <cipc:sBankID>wBAA7LAkWIs=</cipc:sBankID>\n"
                + "\n"
                + "         <cipc:ds>\n"
                + "\n"
                + "            <xs:schema id=\"NewDataSet\" xmlns:msdata=\"urn:schemas?microsoft?com:xml?msdata\">\n"
                + "\n"
                + "               <xs:element name=\"NewDataSet\" msdata:IsDataSet=\"true\" msdata:UseCurrentLocale=\"true\">\n"
                + "\n"
                + "                  <xs:complexType>\n"
                + "\n"
                + "                     <xs:choice minOccurs=\"0\" maxOccurs=\"unbounded\">\n"
                + "\n"
                + "                        <xs:element name=\"Table1\">\n"
                + "\n"
                + "                           <xs:complexType>\n"
                + "\n"
                + "                              <xs:sequence>\n"
                + "\n"
                + "                                 <xs:element name=\"password\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"bank_ID\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"reference_no\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"id_no\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"cust_name\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"agent_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"id_type\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"ent_no\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"cust_type\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"tel_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"tel_no\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"fax_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"fax_no\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"cell_no\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"email_address\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"docex\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"phys_add1\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"phys_add2\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"phys_add3\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"phys_add4\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"phys_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"postal_add1\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"postal_add2\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"postal_add3\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"postal_add4\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"postal_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"comm_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"corresp_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"deliv_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"status_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"org_type\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"naturalPerson\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                              </xs:sequence>\n"
                + "\n"
                + "                           </xs:complexType>\n"
                + "\n"
                + "                        </xs:element>\n"
                + "\n"
                + "                     </xs:choice>\n"
                + "\n"
                + "                  </xs:complexType>\n"
                + "\n"
                + "               </xs:element>\n"
                + "\n"
                + "            </xs:schema>\n"
                + "\n"
                + "            <diffgr:diffgram xmlns:msdata=\"urn:schemas-microsoft-com:xml-msdata\" xmlns:diffgr=\"urn:schemas-microsoft-com:xml-diffgram-v1\">\n"
                + "\n"
                + "               <NewDataSet>\n"
                + "\n"
                + "                  <Table1 diffgr:id=\"Table11\" msdata:rowOrder=\"0\" diffgr:hasChanges=\"inserted\">\n"
                + "\n"
                + "                     <password>Password1</password>>\n"
                + "\n"
                + "                     <bank_ID>wBAA7LAkWIs=</bank_ID>\n"
                + "\n"
                + "                     <reference_no></reference_no>\n"
                + "\n"
                + "                     <id_no>7104085085085</id_no>\n"
                + "\n"
                + "                     <cust_name>Hanno Schultz</cust_name>\n"
                + "\n"
                + "                     <agent_code>INKE01</agent_code>\n"
                + "\n"
                + "                     <id_type>1</id_type>\n"
                + "\n"
                + "                     <ent_no/>\n"
                + "\n"
                + "                     <cust_type>N</cust_type>\n"
                + "\n"
                + "                     <tel_code/>\n"
                + "\n"
                + "                     <tel_no/>\n"
                + "\n"
                + "                     <fax_code/>\n"
                + "\n"
                + "                     <fax_no/>\n"
                + "\n"
                + "                     <cell_no>0782567791</cell_no>\n"
                + "\n"
                + "                     <email_address>hsz@mweb.co.za</email_address>\n"
                + "\n"
                + "                     <docex/>\n"
                + "\n"
                + "                     <phys_add1>STREET</phys_add1>\n"
                + "\n"
                + "                     <phys_add2>SUBURB</phys_add2>\n"
                + "\n"
                + "                     <phys_add3>CITY</phys_add3>\n"
                + "\n"
                + "                     <phys_add4>GAUTENG</phys_add4>\n"
                + "\n"
                + "                     <phys_code>1313</phys_code>\n"
                + "\n"
                + "                     <postal_add1>STREET</postal_add1>\n"
                + "\n"
                + "                     <postal_add2>SUBURB</postal_add2>\n"
                + "\n"
                + "                     <postal_add3>CITY</postal_add3>\n"
                + "\n"
                + "                     <postal_add4>GAUTENG</postal_add4>\n"
                + "\n"
                + "                     <postal_code>1313</postal_code>\n"
                + "\n"
                + "                     <comm_code>1</comm_code>\n"
                + "\n"
                + "                     <corresp_code>3</corresp_code>\n"
                + "\n"
                + "                     <deliv_code>1</deliv_code>\n"
                + "\n"
                + "                     <status_code>A</status_code>\n"
                + "\n"
                + "                     <org_type>6</org_type>\n"
                + "\n"
                + "                     <naturalPerson>1</naturalPerson>\n"
                + "\n"
                + "                  </Table1>\n"
                + "\n"
                + "               </NewDataSet>\n"
                + "\n"
                + "            </diffgr:diffgram>\n"
                + "\n"
                + "         </cipc:ds>\n"
                + "\n"
                + " </cipc:ReceiveNewCustData_UPDATE_MOBI>\n"
                + "\n"
                + "   </soapenv:Body>\n"
                + "\n"
                + "</soapenv:Envelope>";

        ConnectionRequest httpRequest = new ConnectionRequest() {
            Element h;

            @Override
            protected void buildRequestBody(OutputStream os) throws IOException {
                super.buildRequestBody(os);
                os.write(SOAP_BODY.getBytes("utf-8"));

            }

            protected void postResponse() {

                super.postResponse();
            }

            protected void readResponse(InputStream input) throws IOException {
                super.readResponse(input);

            }

            @Override
            protected void handleException(Exception err) {
                Log.p("Exception: " + err.toString());
                Dialog.show("No Internet", "There is no internet connection. Please switch your connection on.", "Okay", null);

            }
        };

        httpRequest.setUrl("https://testwebservices4.cipc.co.za/customer.asmx?wsdl");
        httpRequest.addRequestHeader("Content-Type", "text/xml; charset=utf-8");
        httpRequest.addRequestHeader("Content-Length", SOAP_BODY.length() + "");
        httpRequest.setPost(true);

        InfiniteProgress prog = new InfiniteProgress();
        Dialog dlg = prog.showInifiniteBlocking();
        httpRequest.setDisposeOnCompletion(dlg);

        NetworkManager.getInstance().addToQueueAndWait(httpRequest);
        String data = new String(httpRequest.getResponseData());

        try {

            Result result = Result.fromContent(data, Result.XML);
            User responseUser = new User();

            Log.p("result: " + result, Log.DEBUG);

            responseUser.setAgent_code(result.getAsString("//agent_code"));
            responseUser.setAgent_type(result.getAsString("//agent_type"));
            responseUser.setPassword(result.getAsString("//password"));
            responseUser.setAgent_name(result.getAsString("//agent_name"));
            responseUser.setTel_no(result.getAsString("//tel_code"));
            responseUser.setTel_no(result.getAsString("//tel_no"));
            responseUser.setFax_code(result.getAsString("//fax_code"));
            responseUser.setFax_no(result.getAsString("//fax_no"));
            responseUser.setPhys_addr1(result.getAsString("//phys_addr1"));
            responseUser.setPhys_addr2(result.getAsString("//phys_addr2"));
            responseUser.setPhys_addr3(result.getAsString("//phys_addr3"));
            responseUser.setPhys_addr4(result.getAsString("//phys_addr4"));
            responseUser.setPhys_code(result.getAsString("//phys_code"));
            responseUser.setPost_addr1(result.getAsString("//post_addr1"));
            responseUser.setPost_addr2(result.getAsString("//post_addr2"));
            responseUser.setPost_addr3(result.getAsString("//post_addr3"));
            responseUser.setPost_addr4(result.getAsString("//post_addr4"));
            responseUser.setPost_code(result.getAsString("//post_code"));
            responseUser.setEmail(result.getAsString("//email"));
            responseUser.setDocex(result.getAsString("//docex"));
            responseUser.setCorresp_code(result.getAsString("//corresp_code"));
            responseUser.setComm_code(result.getAsString("//comm_code"));
            responseUser.setDeliv_code(result.getAsString("//deliv_code"));
            responseUser.setModify_date(result.getAsString("//modify_date"));
            responseUser.setBalance(result.getAsString("//balance"));
            responseUser.setStatus(result.getAsString("//status"));
            responseUser.setCurrent_login(result.getAsString("//current_login"));
            responseUser.setPrevious_login(result.getAsString("//previous_login"));
            responseUser.setId_type(result.getAsString("//id_type"));
            responseUser.setAgent_id_no(result.getAsString("//agent_id_no"));
            responseUser.setRegistration_no(result.getAsString("//registration_no"));
            responseUser.setCell_no(result.getAsString("//cell_no"));
            responseUser.setSms(result.getAsString("//sms"));
            responseUser.setStatus_desc(result.getAsString("//status_desc"));

            return responseUser;

        } catch (IllegalArgumentException e) {
            Log.p(e.toString());
        }

        return null;

    }//end login

    public User GetCustLoginDetails_ID_NO(User user) {

        final String SOAP_BODY
                = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cipc=\"CIPC_WEB_SERVICES\">\n\n"
                + "   <soapenv:Header/>\n\n"
                + "   <soapenv:Body>\n"
                + "      <cipc:GetCustLoginDetails_ID_NO>\n\n"
                + "         <!--Optional:-->\n\n"
                + "         <cipc:sUserName>" + Constants.sUserName + "</cipc:sUserName>\n\n"
                + "         <!--Optional:-->\n\n"
                + "         <cipc:sPassword>" + Constants.sPassword + "</cipc:sPassword>\n\n"
                + "         <!--Optional:-->\n\n"
                + "         <cipc:sBankID>" + Constants.sBankID + "</cipc:sBankID>\n\n"
                + "         <!--Optional:-->\n\n"
                + "         <cipc:sCustID>" + user.getAgent_id_no() + "</cipc:sCustID>\n\n"
                + "      </cipc:GetCustLoginDetails_ID_NO>\n\n"
                + "   </soapenv:Body>\n\n"
                + "</soapenv:Envelope>";

        ConnectionRequest httpRequest = new ConnectionRequest() {
            Element h;

            @Override
            protected void buildRequestBody(OutputStream os) throws IOException {
                super.buildRequestBody(os);
                os.write(SOAP_BODY.getBytes("utf-8"));

            }

            protected void postResponse() {

                super.postResponse();
            }

            protected void readResponse(InputStream input) throws IOException {
                super.readResponse(input);

            }

            @Override
            protected void handleException(Exception err) {
                Log.p("Exception: " + err.toString());
                Dialog.show("No Internet", "There is no internet connection. Please switch your connection on.", "Okay", null);

            }
        };

        httpRequest.setUrl("https://testwebservices4.cipc.co.za/customer.asmx?wsdl");
        httpRequest.addRequestHeader("Content-Type", "text/xml; charset=utf-8");
        httpRequest.addRequestHeader("Content-Length", SOAP_BODY.length() + "");
        httpRequest.setPost(true);

//        InfiniteProgress prog = new InfiniteProgress();
//        Dialog dlg = prog.showInifiniteBlocking();
//        httpRequest.setDisposeOnCompletion(dlg);
        NetworkManager.getInstance().addToQueueAndWait(httpRequest);
        String data = new String(httpRequest.getResponseData());

        try {

            Result result = Result.fromContent(data, Result.XML);
            User responseUser = new User();

            Log.p("GetCustLoginDetails_ID_NO=" + result, Log.DEBUG);

            responseUser.setAgent_code(result.getAsString("//agent_code"));
            responseUser.setAgent_type(result.getAsString("//agent_type"));
            responseUser.setPassword(result.getAsString("//password"));
            responseUser.setAgent_name(result.getAsString("//agent_name"));
            responseUser.setTel_no(result.getAsString("//tel_code"));
            responseUser.setTel_no(result.getAsString("//tel_no"));
            responseUser.setFax_code(result.getAsString("//fax_code"));
            responseUser.setFax_no(result.getAsString("//fax_no"));
            responseUser.setPhys_addr1(result.getAsString("//phys_addr1"));
            responseUser.setPhys_addr2(result.getAsString("//phys_addr2"));
            responseUser.setPhys_addr3(result.getAsString("//phys_addr3"));
            responseUser.setPhys_addr4(result.getAsString("//phys_addr4"));
            responseUser.setPhys_code(result.getAsString("//phys_code"));
            responseUser.setPost_addr1(result.getAsString("//post_addr1"));
            responseUser.setPost_addr2(result.getAsString("//post_addr2"));
            responseUser.setPost_addr3(result.getAsString("//post_addr3"));
            responseUser.setPost_addr4(result.getAsString("//post_addr4"));
            responseUser.setPost_code(result.getAsString("//post_code"));
            responseUser.setEmail(result.getAsString("//email"));
            responseUser.setDocex(result.getAsString("//docex"));
            responseUser.setCorresp_code(result.getAsString("//corresp_code"));
            responseUser.setComm_code(result.getAsString("//comm_code"));
            responseUser.setDeliv_code(result.getAsString("//deliv_code"));
            responseUser.setModify_date(result.getAsString("//modify_date"));
            responseUser.setBalance(result.getAsString("//balance"));
            responseUser.setStatus(result.getAsString("//status"));
            responseUser.setCurrent_login(result.getAsString("//current_login"));
            responseUser.setPrevious_login(result.getAsString("//previous_login"));
            responseUser.setId_type(result.getAsString("//id_type"));
            responseUser.setAgent_id_no(result.getAsString("//agent_id_no"));
            responseUser.setRegistration_no(result.getAsString("//registration_no"));
            responseUser.setCell_no(result.getAsString("//cell_no"));
            responseUser.setSms(result.getAsString("//sms"));
            responseUser.setStatus_desc(result.getAsString("//status_desc"));

            return responseUser;

        } catch (IllegalArgumentException e) {
            Log.p(e.toString());
        }

        return null;

    }//end login

    public User GetCustLoginDetails_ID_NO_MOBI(User user) {

        final String SOAP_BODY
                = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cipc=\"CIPC_WEB_SERVICES\">\n\n"
                + "   <soapenv:Header/>\n\n"
                + "   <soapenv:Body>\n"
                + "      <cipc:GetCustLoginDetails_ID_NO_MOBI>\n\n"
                + "         <!--Optional:-->\n\n"
                + "         <cipc:sUserName>" + Constants.sUserName + "</cipc:sUserName>\n\n"
                + "         <!--Optional:-->\n\n"
                + "         <cipc:sPassword>" + Constants.sPassword + "</cipc:sPassword>\n\n"
                + "         <!--Optional:-->\n\n"
                + "         <cipc:sBankID>" + Constants.sBankID + "</cipc:sBankID>\n\n"
                + "         <!--Optional:-->\n\n"
                + "         <cipc:sCustID>" + user.getAgent_id_no() + "</cipc:sCustID>\n\n"
                + "      </cipc:GetCustLoginDetails_ID_NO_MOBI>\n\n"
                + "   </soapenv:Body>\n\n"
                + "</soapenv:Envelope>";

        ConnectionRequest httpRequest = new ConnectionRequest() {
            Element h;

            @Override
            protected void buildRequestBody(OutputStream os) throws IOException {
                super.buildRequestBody(os);
                os.write(SOAP_BODY.getBytes("utf-8"));

            }

            protected void postResponse() {

                super.postResponse();
            }

            protected void readResponse(InputStream input) throws IOException {
                super.readResponse(input);

            }

            @Override
            protected void handleException(Exception err) {
                Log.p("Exception: " + err.toString());
                Dialog.show("No Internet", "There is no internet connection. Please switch your connection on.", "Okay", null);

            }
        };

        httpRequest.setUrl("https://testwebservices4.cipc.co.za/customer.asmx?wsdl");
        httpRequest.addRequestHeader("Content-Type", "text/xml; charset=utf-8");
        httpRequest.addRequestHeader("Content-Length", SOAP_BODY.length() + "");
        httpRequest.setPost(true);

//        InfiniteProgress prog = new InfiniteProgress();
//        Dialog dlg = prog.showInifiniteBlocking();
//        httpRequest.setDisposeOnCompletion(dlg);
        NetworkManager.getInstance().addToQueueAndWait(httpRequest);
        String data = new String(httpRequest.getResponseData());

        try {

            Result result = Result.fromContent(data, Result.XML);
            User responseUser = new User();

            Log.p("GetCustLoginDetails_ID_NO=" + result, Log.DEBUG);

            responseUser.setAgent_code(result.getAsString("//agent_code"));
            responseUser.setAgent_type(result.getAsString("//agent_type"));
            responseUser.setPassword(result.getAsString("//password"));
            responseUser.setAgent_name(result.getAsString("//agent_name"));
            responseUser.setTel_no(result.getAsString("//tel_code"));
            responseUser.setTel_no(result.getAsString("//tel_no"));
            responseUser.setFax_code(result.getAsString("//fax_code"));
            responseUser.setFax_no(result.getAsString("//fax_no"));
            responseUser.setPhys_addr1(result.getAsString("//phys_addr1"));
            responseUser.setPhys_addr2(result.getAsString("//phys_addr2"));
            responseUser.setPhys_addr3(result.getAsString("//phys_addr3"));
            responseUser.setPhys_addr4(result.getAsString("//phys_addr4"));
            responseUser.setPhys_code(result.getAsString("//phys_code"));
            responseUser.setPost_addr1(result.getAsString("//post_addr1"));
            responseUser.setPost_addr2(result.getAsString("//post_addr2"));
            responseUser.setPost_addr3(result.getAsString("//post_addr3"));
            responseUser.setPost_addr4(result.getAsString("//post_addr4"));
            responseUser.setPost_code(result.getAsString("//post_code"));
            responseUser.setEmail(result.getAsString("//email"));
            responseUser.setDocex(result.getAsString("//docex"));
            responseUser.setCorresp_code(result.getAsString("//corresp_code"));
            responseUser.setComm_code(result.getAsString("//comm_code"));
            responseUser.setDeliv_code(result.getAsString("//deliv_code"));
            responseUser.setModify_date(result.getAsString("//modify_date"));
            responseUser.setBalance(result.getAsString("//balance"));
            responseUser.setStatus(result.getAsString("//status"));
            responseUser.setCurrent_login(result.getAsString("//current_login"));
            responseUser.setPrevious_login(result.getAsString("//previous_login"));
            responseUser.setId_type(result.getAsString("//id_type"));
            responseUser.setAgent_id_no(result.getAsString("//agent_id_no"));
            responseUser.setRegistration_no(result.getAsString("//registration_no"));
            responseUser.setCell_no(result.getAsString("//cell_no"));
            responseUser.setSms(result.getAsString("//sms"));
            responseUser.setStatus_desc(result.getAsString("//status_desc"));

            return responseUser;

        } catch (IllegalArgumentException e) {
            Log.p(e.toString());
        }

        return null;

    }//end login

    public String ReceiveNewCustData_Reg(User requestUser) {

        //Step 1: Check if customer exists
        //TODO more validations needed
        User responseUser = GetCustLoginDetails_ID_NO(requestUser);

        Log.p(responseUser.toString(), Log.DEBUG);

        if (null == responseUser) {
            return null;
            //return null;//user does not exist?
        }

        //Step 2: Capture customer data. 
        final String SOAP_BODY
                = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cipc=\"CIPC_WEB_SERVICES\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\">\n"
                + "   <soapenv:Header/>\n"
                + "   <soapenv:Body>\n"
                + "      <cipc:ReceiveNewCustData_Reg>\n"
                + "         <cipc:sUserName>" + requestUser.getsUserName() + "</cipc:sUserName>\n"
                + "         <cipc:sPassword>" + requestUser.getsPassword() + "</cipc:sPassword>\n"
                + "         <cipc:sBankID>" + requestUser.getsBankID() + "</cipc:sBankID>\n"
                + "         <cipc:ds>\n"
                + "            <xs:schema id=\"NewDataSet\" xmlns:msdata=\"urn:schemas?microsoft?com:xml?msdata\">\n"
                + "               <xs:element name=\"NewDataSet\" msdata:IsDataSet=\"true\" msdata:UseCurrentLocale=\"true\">\n"
                + "                  <xs:complexType>\n"
                + "                     <xs:choice minOccurs=\"0\" maxOccurs=\"unbounded\">\n"
                + "                        <xs:element name=\"Table1\">\n"
                + "                           <xs:complexType>\n"
                + "                              <xs:sequence>\n"
                + "                                 <xs:element name=\"password\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"bank_ID\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"reference_no\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"id_no\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"cust_name\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"agent_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"id_type\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"ent_no\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"cust_type\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"tel_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"tel_no\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"fax_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"fax_no\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"cell_no\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"email_address\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"docex\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"phys_add1\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"phys_add2\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"phys_add3\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"phys_add4\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"phys_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"postal_add1\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"postal_add2\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"postal_add3\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"postal_add4\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"postal_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"comm_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"corresp_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"deliv_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"status_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"org_type\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"naturalPerson\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                              </xs:sequence>\n"
                + "                           </xs:complexType>\n"
                + "                        </xs:element>\n"
                + "                     </xs:choice>\n"
                + "                  </xs:complexType>\n"
                + "               </xs:element>\n"
                + "            </xs:schema>\n"
                + "            <diffgr:diffgram xmlns:msdata=\"urn:schemas-microsoft-com:xml-msdata\" xmlns:diffgr=\"urn:schemas-microsoft-com:xml-diffgram-v1\">\n"
                + "               <NewDataSet>\n"
                + "                  <Table1 diffgr:id=\"Table11\" msdata:rowOrder=\"0\" diffgr:hasChanges=\"inserted\">\n"
                + "                     <password>" + requestUser.getsPassword() + "</password>>\n"
                + "                     <bank_ID>" + requestUser.getsBankID() + "</bank_ID>\n"
                + "                     <reference_no>500009</reference_no>\n"
                + "                     <id_no>" + requestUser.getAgent_id_no() + "</id_no>\n"
                + "                     <cust_name>" + requestUser.getAgent_name() + "</cust_name>\n"
                + "                     <agent_code></agent_code>\n"
                + "                     <id_type>1</id_type>\n"
                + "                     <ent_no/>\n"
                + "                     <cust_type>N</cust_type>\n"
                + "                     <tel_code/>\n"
                + "                     <tel_no/>\n"
                + "                     <fax_code/>\n"
                + "                     <fax_no/>\n"
                + "                     <cell_no>" + requestUser.getCell_no() + "</cell_no>\n"
                + "                     <email_address>" + requestUser.getEmail() + "</email_address>\n"
                + "                     <docex/>\n"
                + "                     <phys_add1>" + requestUser.getPhys_addr1() + "</phys_add1>\n"
                + "                     <phys_add2>" + requestUser.getPhys_addr2() + "</phys_add2>\n"
                + "                     <phys_add3>" + requestUser.getPhys_addr3() + "</phys_add3>\n"
                + "                     <phys_add4>" + requestUser.getPhys_addr4() + "</phys_add4>\n"
                + "                     <phys_code>" + requestUser.getPhys_code() + "</phys_code>\n"
                + "                     <postal_add1>" + requestUser.getPost_addr1() + "</postal_add1>\n"
                + "                     <postal_add2>" + requestUser.getPost_addr2() + "</postal_add2>\n"
                + "                     <postal_add3>" + requestUser.getPost_addr3() + "</postal_add3>\n"
                + "                     <postal_add4>" + requestUser.getPost_addr4() + "</postal_add4>\n"
                + "                     <postal_code>" + requestUser.getPost_code() + "</postal_code>\n"
                + "                     <comm_code>" + requestUser.getComm_code() + "</comm_code>\n"
                + "                     <corresp_code>" + requestUser.getCorresp_code() + "</corresp_code>\n"
                + "                     <deliv_code>" + requestUser.getDeliv_code() + "</deliv_code>\n"
                + "                     <status_code>A</status_code>\n"
                + "                     <org_type>6</org_type>\n"
                + "                     <naturalPerson>1</naturalPerson>\n"
                + "                  </Table1>\n"
                + "               </NewDataSet>\n"
                + "            </diffgr:diffgram>\n"
                + "         </cipc:ds>\n"
                + "      </cipc:ReceiveNewCustData_Reg>\n"
                + "   </soapenv:Body>\n"
                + "</soapenv:Envelope>";

        ConnectionRequest httpRequest = new ConnectionRequest() {
            Element h;

            @Override
            protected void buildRequestBody(OutputStream os) throws IOException {
                super.buildRequestBody(os);
                os.write(SOAP_BODY.getBytes("utf-8"));

            }

            protected void postResponse() {

                super.postResponse();
            }

            protected void readResponse(InputStream input) throws IOException {
                super.readResponse(input);

            }

            @Override
            protected void handleException(Exception err) {
                Log.p("Exception: " + err.toString());
                Dialog.show("No Internet", "There is no internet connection. Please switch your connection on.", "Okay", null);

            }
        };

        httpRequest.setUrl("https://testwebservices4.cipc.co.za/customer.asmx?wsdl");
        httpRequest.addRequestHeader("Content-Type", "text/xml; charset=utf-8");
        httpRequest.addRequestHeader("Content-Length", SOAP_BODY.length() + "");
        httpRequest.setPost(true);

        InfiniteProgress prog = new InfiniteProgress();
        Dialog dlg = prog.showInifiniteBlocking();
        httpRequest.setDisposeOnCompletion(dlg);

        NetworkManager.getInstance().addToQueueAndWait(httpRequest);
        String data = new String(httpRequest.getResponseData());

        try {

            Result result = Result.fromContent(data, Result.XML);

            String receivenewcustdata_regresult = result.getAsString("//receivenewcustdata_regresult");

            Log.p("result: " + result, Log.DEBUG);
            Log.p("receivenewcustdata_regresult: " + receivenewcustdata_regresult, Log.DEBUG);

            return receivenewcustdata_regresult;

        } catch (IllegalArgumentException e) {
            Log.p(e.toString());
        }

        return null;

    }//end register

    public void Change_name_MOBI(User user) {

        final String SOAP_BODY
                = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cipc=\"CIPC_WEB_SERVICES\">\n"
                + "   <soapenv:Header/>\n"
                + "   <soapenv:Body>\n"
                + "      <cipc:Change_name_MOBI>\n"
                + "         <cipc:sUserName>wBAA7LAkWIs=</cipc:sUserName>\n"
                + "         <cipc:sPassword>nhXSFLH3xKlrDYYKEWHlVw==</cipc:sPassword>\n"
                + "         <cipc:sBankID>wBAA7LAkWIs=</cipc:sBankID>\n"
                + "         <cipc:Sent_no>K201422876</cipc:Sent_no>\n"
                + "         <cipc:Apllication_no>982326767</cipc:Apllication_no>\n"
                + "         <cipc:resolution_date>01/05/2018</cipc:resolution_date>\n"
                + "         <cipc:scustcode>INKE01</cipc:scustcode>\n"
                + "      </cipc:Change_name_MOBI>\n"
                + "   </soapenv:Body>\n"
                + "</soapenv:Envelope>";

        ConnectionRequest httpRequest = new ConnectionRequest() {
            Element h;

            @Override
            protected void buildRequestBody(OutputStream os) throws IOException {
                super.buildRequestBody(os);
                os.write(SOAP_BODY.getBytes("utf-8"));

            }

            protected void postResponse() {

                super.postResponse();
            }

            protected void readResponse(InputStream input) throws IOException {
                super.readResponse(input);

            }

            @Override
            protected void handleException(Exception err) {
                Log.p("Exception: " + err.toString());
                Dialog.show("No Internet", "There is no internet connection. Please switch your connection on.", "Okay", null);

            }
        };

        httpRequest.setUrl("https://testwebservices4.cipc.co.za/enterprise.asmx");
        httpRequest.addRequestHeader("Content-Type", "text/xml; charset=utf-8");
        httpRequest.addRequestHeader("Content-Length", SOAP_BODY.length() + "");
        httpRequest.setPost(true);

        InfiniteProgress prog = new InfiniteProgress();
        Dialog dlg = prog.showInifiniteBlocking();
        httpRequest.setDisposeOnCompletion(dlg);

        NetworkManager.getInstance().addToQueueAndWait(httpRequest);
        String data = new String(httpRequest.getResponseData());
        Log.p("Data d: " + data, Log.DEBUG);

        try {

            Result result = Result.fromContent(data, Result.XML);
            //Element e = Utility.parseXML(result.getAsString("//anyType"));
            //Element e = Utility.parseXML(result.getAsString("//User"));

            Log.p("Element e: " + result, Log.DEBUG);

//            u = new User();
//            u.setUserID(e.getChildrenByTagName("userid").toString());
//            u.setEmailAddress(e.getChildrenByTagName("emailaddress").toString());
//            u.setDateTimeUpdated(e.getChildrenByTagName("datetimeupdated").toString());
//            u.setFeedback(e.getChildrenByTagName("feedback").toString());
//
//            Log.p("Object: " + u.toString());
        } catch (IllegalArgumentException e) {
            Log.p(e.toString());
        }

    }//end name reservation

    public NameReservation Namereservation_MOBI(String customerCode, String name1, String name2, String name3, String name4) {

        String response = "";

        NameReservation n = null;

        final String SOAP_BODY
                = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cipc=\"CIPC_WEB_SERVICES\">\n"
                + "\n"
                + "   <soapenv:Header/>\n"
                + "\n"
                + "   <soapenv:Body>\n"
                + "\n"
                + "      <cipc:Namereservation_MOBI>\n"
                + "\n"
                + "        <cipc:sUserName>ImJbvgnMVO0=</cipc:sUserName>       \n"
                + "\n"
                + "         <cipc:sPassword>WViQlFqcunA=</cipc:sPassword>\n"
                + "\n"
                + "         <cipc:sBankID>WViQlFqcunA=</cipc:sBankID>\n"
                + "\n"
                + "         <cipc:S_name1>" + name1 + "</cipc:S_name1>\n"
                + "\n"
                + "         <!--Optional:-->\n"
                + "\n"
                + "         <cipc:S_name2>" + name2 + "</cipc:S_name2>\n"
                + "\n"
                + "         <!--Optional:-->\n"
                + "\n"
                + "         <cipc:S_name3>" + name3 + "</cipc:S_name3>\n"
                + "\n"
                + "         <!--Optional:-->\n"
                + "\n"
                + "         <cipc:S_name4>" + name4 + "</cipc:S_name4>\n"
                + "\n"
                + "         <!--Optional:-->\n"
                + "\n"
                + "         <cipc:sCust_Code>" + customerCode + "</cipc:sCust_Code>\n"
                + "\n"
                + "      </cipc:Namereservation_MOBI>\n"
                + "\n"
                + "   </soapenv:Body>\n"
                + "\n"
                + "</soapenv:Envelope>";

        ConnectionRequest httpRequest = new ConnectionRequest() {
            Element h;

            @Override
            protected void handleErrorResponseCode(int code, String message) {
                super.handleErrorResponseCode(code, message); //To change body of generated methods, choose Tools | Templates.
                if (500 == code) {
                    Dialog.show("Error", "Duplicate Name Reservation Error. Please try different names.", "Ok", null);
                }
            }

            @Override
            protected void handleIOException(IOException err) {
                //    super.handleIOException(err); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            protected void handleRuntimeException(RuntimeException err) {
                //super.handleRuntimeException(err); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            protected void buildRequestBody(OutputStream os) throws IOException {
                super.buildRequestBody(os);
                os.write(SOAP_BODY.getBytes("utf-8"));

            }

            protected void postResponse() {

                super.postResponse();
            }

            protected void readResponse(InputStream input) throws IOException {
                super.readResponse(input);

            }

            @Override
            protected void handleException(Exception err) {
                Log.p("Exception: " + err.toString());
                Dialog.show("No Internet", "There is no internet connection. Please switch your connection on.", "Okay", null);

            }
        };

        httpRequest.setUrl("https://testwebservices4.cipc.co.za/enterprise.asmx");
        httpRequest.addRequestHeader("Content-Type", "text/xml; charset=utf-8");
        httpRequest.addRequestHeader("Content-Length", SOAP_BODY.length() + "");
        httpRequest.setPost(true);
        httpRequest.setFailSilently(true);

        InfiniteProgress prog = new InfiniteProgress();
        Dialog dlg = prog.showInifiniteBlocking();
        httpRequest.setDisposeOnCompletion(dlg);

        NetworkManager.getInstance().addToQueueAndWait(httpRequest);
        String data = new String(httpRequest.getResponseData());
        Log.p("Data d: " + data, Log.DEBUG);

        try {

            Result result = Result.fromContent(data, Result.XML);
            //Dialog.show("Result", result.toString(), "Ok", null);
            String namereservation_mobiresult = result.getAsString("//namereservation_mobiresult");

            if (namereservation_mobiresult != null && namereservation_mobiresult.indexOf("Reference No:") > -1) {

                namereservation_mobiresult = namereservation_mobiresult.trim();
                String ReferenceNo = getNameReservationReferenceNo(namereservation_mobiresult);
                int intReferenceNo = Integer.parseInt(ReferenceNo);
                double Amount = 50.0;
                double Total = 50.0;
                String StatusDate = getNameReservationDateNow();

                n = new NameReservation();
                n.setReferenceNumber(intReferenceNo);
                n.setAmount(Amount);
                n.setTotalAmount(Total);
                n.setCustomerCode(customerCode);
                n.setStatusDate(StatusDate);
                n.setResponseMessage(namereservation_mobiresult);

            }

            //Log.p("result: " + result, Log.DEBUG);
            //Log.p("namereservation_mobiresult: " + namereservation_mobiresult, Log.DEBUG);
        } catch (IllegalArgumentException e) {
            Log.p(e.toString());
        }

        return n;
    }//end name reservation

    public ArrayList search_name_MOBI(String customerCode, String name1, String name2, String name3, String name4) {

        ArrayList arrayList = new ArrayList();

        final String SOAP_BODY
                = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cipc=\"CIPC_WEB_SERVICES\">\n"
                + "\n"
                + "   <soapenv:Header/>\n"
                + "\n"
                + "   <soapenv:Body>\n"
                + "\n"
                + "      <cipc:search_name_MOBI>\n"
                + "\n"
                + "          <cipc:sUserName>wBAA7LAkWIs=</cipc:sUserName>\n"
                + "\n"
                + "          <cipc:sPassword>6EGQAUzYJlhvffhZ+gUFfg==</cipc:sPassword>\n"
                + "\n"
                + "          <cipc:sBankID>wBAA7LAkWIs=</cipc:sBankID>\n"
                + "\n"
                + "         <cipc:sCust_Code>" + customerCode + "</cipc:sCust_Code>\n"
                + "\n"
                + "         <!--Optional:-->\n"
                + "\n"
                + "         <cipc:S_name1>" + name1 + "</cipc:S_name1>\n"
                + "\n"
                + "         <!--Optional:-->\n"
                + "\n"
                + "         <cipc:S_name2>" + name2 + "</cipc:S_name2>\n"
                + "\n"
                + "         <!--Optional:-->\n"
                + "\n"
                + "         <cipc:S_name3>" + name3 + "</cipc:S_name3>\n"
                + "\n"
                + "         <!--Optional:-->\n"
                + "\n"
                + "         <cipc:S_name4>" + name4 + "</cipc:S_name4>\n"
                + "\n"
                + "      </cipc:search_name_MOBI>\n"
                + "\n"
                + "   </soapenv:Body>\n"
                + "\n"
                + "</soapenv:Envelope>";

        ConnectionRequest httpRequest = new ConnectionRequest() {
            Element h;

            @Override
            protected void buildRequestBody(OutputStream os) throws IOException {
                super.buildRequestBody(os);
                os.write(SOAP_BODY.getBytes("utf-8"));

            }

            protected void postResponse() {

                super.postResponse();
            }

            protected void readResponse(InputStream input) throws IOException {
                super.readResponse(input);

            }

            @Override
            protected void handleException(Exception err) {
                Log.p("Exception: " + err.toString());
                Dialog.show("No Internet", "There is no internet connection. Please switch your connection on.", "Okay", null);

            }
        };

        httpRequest.setUrl("https://testwebservices4.cipc.co.za/enterprise.asmx");
        httpRequest.addRequestHeader("Content-Type", "text/xml; charset=utf-8");
        httpRequest.addRequestHeader("Content-Length", SOAP_BODY.length() + "");
        httpRequest.setPost(true);

        InfiniteProgress prog = new InfiniteProgress();
        Dialog dlg = prog.showInifiniteBlocking();
        httpRequest.setDisposeOnCompletion(dlg);

        httpRequest.setTimeout(100000);//milli seconds
        NetworkManager.getInstance().addToQueueAndWait(httpRequest);
        String data = new String(httpRequest.getResponseData());
        Log.p("Data d: " + data, Log.DEBUG);

        try {

            Result result = Result.fromContent(data.toLowerCase(), Result.XML);

            Log.p("Element e: " + result, Log.DEBUG);

            XMLParser parser = new XMLParser();
            parser.setCaseSensitive(true);
            Element element = parser.parse(convertStringtoInputStreamReader(result.getAsString("//dataset")));

            for (int i = 0; i < element.getNumChildren(); i++) {

                Element child = element.getChildAt(i);

                Log.p("chiled=" + child, Log.DEBUG);
                Element name = (Element) child.getTextChildren(null, true).get(0);
                String elemName = RSM(name.toString());
                Log.p("elemName=" + elemName, Log.DEBUG);

                StringTokenizer st = new StringTokenizer(elemName, "|");

                NameSearchObject n = new NameSearchObject();
                n.setName(elemName);

                if (st != null && st.countTokens() > 1) {
                    n.setIsValid(false);
                } else {
                    n.setIsValid(true);
                }
                arrayList.add(n);
            }

        } catch (IllegalArgumentException e) {
            Log.p(e.toString());
        }

        return arrayList;
    }//end search_name_MOBI

    private String RSM(String name) {

        name = name.trim();
        name = name.substring(1);
        name = name.substring(0, name.length() - 1);

        name = name.trim();
        name = name.substring(1);
        name = name.substring(0, name.length() - 1);

        return name;
    }

    public String GetInternalRefNo(User user) {

        final String SOAP_BODY
                = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cipc=\"CIPC_WEB_SERVICES\">\n"
                + "   <soapenv:Header/>\n"
                + "   <soapenv:Body>\n"
                + "      <cipc:GetInternalRefNo>\n"
                + "         <!--Optional:-->\n"
                + "          <cipc:sUserName>" + user.getsUserName() + "</cipc:sUserName>\n"
                + "         <cipc:sPassword>" + user.getsPassword() + "</cipc:sPassword>\n"
                + "         <cipc:sBankID>" + user.getsBankID() + "</cipc:sBankID>\n"
                + "         <cipc:sCust_Code></cipc:sCust_Code>\n"
                + "      </cipc:GetInternalRefNo>\n"
                + "   </soapenv:Body>\n"
                + "</soapenv:Envelope>";

        ConnectionRequest httpRequest = new ConnectionRequest() {
            Element h;

            @Override
            protected void buildRequestBody(OutputStream os) throws IOException {
                super.buildRequestBody(os);
                os.write(SOAP_BODY.getBytes("utf-8"));

            }

            protected void postResponse() {

                super.postResponse();
            }

            protected void readResponse(InputStream input) throws IOException {
                super.readResponse(input);

            }

            @Override
            protected void handleException(Exception err) {
                Log.p("Exception: " + err.toString());
                Dialog.show("No Internet", "There is no internet connection. Please switch your connection on.", "Okay", null);

            }
        };

        httpRequest.setUrl("https://testwebservices4.cipc.co.za/customer.asmx?wsdl");
        httpRequest.addRequestHeader("Content-Type", "text/xml; charset=utf-8");
        httpRequest.addRequestHeader("Content-Length", SOAP_BODY.length() + "");
        httpRequest.setPost(true);

        InfiniteProgress prog = new InfiniteProgress();
        Dialog dlg = prog.showInifiniteBlocking();
        httpRequest.setDisposeOnCompletion(dlg);

        NetworkManager.getInstance().addToQueueAndWait(httpRequest);
        String data = new String(httpRequest.getResponseData());

        try {

            Result result = Result.fromContent(data, Result.XML);

            String internalRefNoResult = result.getAsString("//getinternalrefnoresult");

            Log.p("result: " + result, Log.DEBUG);
            Log.p("internalRefNoResult: " + internalRefNoResult, Log.DEBUG);

            return internalRefNoResult;

        } catch (IllegalArgumentException e) {
            Log.p(e.toString());
        }

        return null;

    }//end login

    public String ReceiveNewCustData_Reg_MOBI(User requestUser) {

        //Step 1: Check if customer exists
        //TODO more validations needed
        User responseUser = GetCustLoginDetails_ID_NO(requestUser);

        Log.p(responseUser.toString(), Log.DEBUG);

        if (null == responseUser) {
            return null;
            //return null;//user does not exist?
        }

        //Step 2: Capture customer data. 
        final String SOAP_BODY
                = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cipc=\"CIPC_WEB_SERVICES\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\">\n"
                + "\n"
                + "   <soapenv:Header/>\n"
                + "\n"
                + "   <soapenv:Body>\n"
                + "\n"
                + "      <cipc:ReceiveNewCustData_Reg_MOBI>\n"
                + "\n"
                + "        <cipc:sUserName>wBAA7LAkWIs=</cipc:sUserName>\n"
                + "\n"
                + "          <cipc:sPassword>6EGQAUzYJlhvffhZ+gUFfg==</cipc:sPassword>\n"
                + "\n"
                + "          <cipc:sBankID>wBAA7LAkWIs=</cipc:sBankID>\n"
                + "\n"
                + "         <cipc:ds>\n"
                + "\n"
                + "            <xs:schema id=\"NewDataSet\" xmlns:msdata=\"urn:schemas?microsoft?com:xml?msdata\">\n"
                + "\n"
                + "               <xs:element name=\"NewDataSet\" msdata:IsDataSet=\"true\" msdata:UseCurrentLocale=\"true\">\n"
                + "\n"
                + "                  <xs:complexType>\n"
                + "\n"
                + "                     <xs:choice minOccurs=\"0\" maxOccurs=\"unbounded\">\n"
                + "\n"
                + "                        <xs:element name=\"Table1\">\n"
                + "\n"
                + "                           <xs:complexType>\n"
                + "\n"
                + "                              <xs:sequence>\n"
                + "\n"
                + "                                 <xs:element name=\"password\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"bank_ID\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"reference_no\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"id_no\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"cust_name\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"agent_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"id_type\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"ent_no\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"cust_type\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"tel_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"tel_no\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"fax_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"fax_no\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"cell_no\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"email_address\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"docex\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"phys_add1\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"phys_add2\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"phys_add3\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"phys_add4\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"phys_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"postal_add1\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"postal_add2\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"postal_add3\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"postal_add4\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"postal_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"comm_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"corresp_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"deliv_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"status_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"org_type\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                                 <xs:element name=\"naturalPerson\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "\n"
                + "                              </xs:sequence>\n"
                + "\n"
                + "                           </xs:complexType>\n"
                + "\n"
                + "                        </xs:element>\n"
                + "\n"
                + "                     </xs:choice>\n"
                + "\n"
                + "                  </xs:complexType>\n"
                + "\n"
                + "               </xs:element>\n"
                + "\n"
                + "            </xs:schema>\n"
                + "\n"
                + "            <diffgr:diffgram xmlns:msdata=\"urn:schemas-microsoft-com:xml-msdata\" xmlns:diffgr=\"urn:schemas-microsoft-com:xml-diffgram-v1\">\n"
                + "\n"
                + "               <NewDataSet>\n"
                + "\n"
                + "                  <Table1 diffgr:id=\"Table11\" msdata:rowOrder=\"0\" diffgr:hasChanges=\"inserted\">\n"
                + "\n"
                + "                     <password>" + requestUser.getPassword() + "</password>>\n"
                + "\n"
                + "                     <bank_ID>wBAA7LAkWIs=</bank_ID>\n"
                + "\n"
                + "                     <reference_no></reference_no>\n"
                + "\n"
                + "                     <id_no>" + requestUser.getAgent_id_no() + "</id_no>\n"
                + "\n"
                + "                     <cust_name>" + requestUser.getFirst_name() + " " + requestUser.getLast_name() + "</cust_name>\n"
                + "\n"
                + "                     <agent_code></agent_code>\n"
                + "\n"
                + "                     <id_type>1</id_type>\n"
                + "\n"
                + "                     <ent_no/>\n"
                + "\n"
                + "                     <cust_type>N</cust_type>\n"
                + "\n"
                + "                     <tel_code/>\n"
                + "\n"
                + "                     <tel_no>" + requestUser.getTel_no() + "</tel_no>\n"
                + "\n"
                + "                     <fax_code/>\n"
                + "\n"
                + "                     <fax_no>" + requestUser.getFax_no() + "</fax_no>\n"
                + "\n"
                + "                     <cell_no>" + requestUser.getCell_no() + "</cell_no>\n"
                + "\n"
                + "                     <email_address>" + requestUser.getEmail() + "</email_address>\n"
                + "\n"
                + "                     <docex/>\n"
                + "\n"
                + "                     <phys_add1>" + requestUser.getPhys_addr1() + "</phys_add1>\n"
                + "\n"
                + "                     <phys_add2>" + requestUser.getPhys_addr2() + "</phys_add2>\n"
                + "\n"
                + "                     <phys_add3>" + requestUser.getPhys_addr3() + "</phys_add3>\n"
                + "\n"
                + "                     <phys_add4>GAUTENG</phys_add4>\n"
                + "\n"
                + "                     <phys_code>" + requestUser.getPhys_code() + "</phys_code>\n"
                + "\n"
                + "                     <postal_add1>" + requestUser.getPost_addr1() + "</postal_add1>\n"
                + "\n"
                + "                     <postal_add2>" + requestUser.getPost_addr2() + "</postal_add2>\n"
                + "\n"
                + "                     <postal_add3>" + requestUser.getPost_addr3() + "</postal_add3>\n"
                + "\n"
                + "                     <postal_add4>GAUTENG</postal_add4>\n"
                + "\n"
                + "                     <postal_code>" + requestUser.getPost_code() + "</postal_code>\n"
                + "\n"
                + "                     <comm_code>1</comm_code>\n"
                + "\n"
                + "                     <corresp_code>3</corresp_code>\n"
                + "\n"
                + "                     <deliv_code>1</deliv_code>\n"
                + "\n"
                + "                     <status_code>A</status_code>\n"
                + "\n"
                + "                     <org_type>6</org_type>\n"
                + "\n"
                + "                     <naturalPerson>1</naturalPerson>\n"
                + "\n"
                + "                  </Table1>\n"
                + "\n"
                + "               </NewDataSet>\n"
                + "\n"
                + "            </diffgr:diffgram>\n"
                + "\n"
                + "         </cipc:ds>\n"
                + "\n"
                + "      </cipc:ReceiveNewCustData_Reg_MOBI>\n"
                + "\n"
                + "   </soapenv:Body>\n"
                + "\n"
                + "</soapenv:Envelope>";

        ConnectionRequest httpRequest = new ConnectionRequest() {
            Element h;

            @Override
            protected void buildRequestBody(OutputStream os) throws IOException {
                super.buildRequestBody(os);
                os.write(SOAP_BODY.getBytes("utf-8"));

            }

            protected void postResponse() {

                super.postResponse();
            }

            protected void readResponse(InputStream input) throws IOException {
                super.readResponse(input);

            }

            @Override
            protected void handleException(Exception err) {
                Log.p("Exception: " + err.toString());
                Dialog.show("No Internet", "There is no internet connection. Please switch your connection on.", "Okay", null);

            }
        };

        httpRequest.setUrl("https://testwebservices4.cipc.co.za/customer.asmx");
        httpRequest.addRequestHeader("Content-Type", "text/xml; charset=utf-8");
        httpRequest.addRequestHeader("Content-Length", SOAP_BODY.length() + "");
        httpRequest.setPost(true);

        InfiniteProgress prog = new InfiniteProgress();
        Dialog dlg = prog.showInifiniteBlocking();
        httpRequest.setDisposeOnCompletion(dlg);

        NetworkManager.getInstance().addToQueueAndWait(httpRequest);
        String data = new String(httpRequest.getResponseData());

        try {

            Result result = Result.fromContent(data, Result.XML);

            String receivenewcustdata_regresult = result.getAsString("//receivenewcustdata_reg_mobiresult");

            Log.p("ReceiveNewCustData_Reg_MOBI: " + result, Log.DEBUG);
            //Log.p("receivenewcustdata_regresult: " + receivenewcustdata_regresult, Log.DEBUG);

            return receivenewcustdata_regresult;

        } catch (IllegalArgumentException e) {
            Log.p(e.toString());
        }

        return null;

    }//end register

    public static String getNameReservationReferenceNo(String responseCall) {
        int startIndex = responseCall.indexOf("Reference No:") + 13;
        int endIndex = responseCall.indexOf(". First proposed");

        String newString = responseCall.substring(startIndex, endIndex).trim();
        return newString;
    }

    public String getNameReservationDateNow() {
        long dateNow = System.currentTimeMillis();
        Date newDate = new Date(dateNow);
        String dateString = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS").format(newDate);
        dateString = StringUtil.replaceAll(dateString, "_", "T");
        return dateString;
    }

    public String getAnnualReturnsDateNow() {
        long dateNow = System.currentTimeMillis();
        Date newDate = new Date(dateNow);
        String dateString = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS").format(newDate);
        dateString = StringUtil.replaceAll(dateString, "_", "T");
        return dateString;
    }

}
