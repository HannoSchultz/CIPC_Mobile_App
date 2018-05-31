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
import com.codename1.processing.Result;
import com.codename1.ui.Dialog;
import com.codename1.xml.Element;
import com.codename1.xml.XMLParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Map;
import userclasses.Constants;
import za.co.cipc.pojos.AuthObject;
import za.co.cipc.pojos.User;

/**
 *
 * @author blessingmobile
 */
public class UserWebServices {

    //AR
    public void soap_GetEnterpriseDetails(User user) {

        final String SOAP_BODY
                = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cipc=\"CIPC_WEB_SERVICES\">\n"
                + "   <soapenv:Header/>\n"
                + "   <soapenv:Body>\n"
                + "      <cipc:GetEnterpriseDetails_ent_no_mobi>\n"
                + "       <cipc:sUserName>wBAA7LAkWIs=</cipc:sUserName>\n"
                + "         <cipc:sPassword>nhXSFLH3xKlrDYYKEWHlVw==</cipc:sPassword>\n"
                + "         <cipc:sBankID>wBAA7LAkWIs=</cipc:sBankID>\n"
                + "         <cipc:Sent_no>2014/288527/07</cipc:Sent_no>\n"
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
        String data = new String(httpRequest.getResponseData());
        Log.p("soap_GetEnterpriseDetails" + data, Log.DEBUG);

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

    public void GetAREntTranDetails(User user) {

        final String SOAP_BODY
                = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cipc=\"CIPC_WEB_SERVICES\">\n"
                + "   <soapenv:Header/>\n"
                + "   <soapenv:Body>\n"
                + "      <cipc:GetAREntTranDetails>\n"
                + "<cipc:sUserName>wBAA7LAkWIs=</cipc:sUserName>\n"
                + "         <cipc:sPassword>nhXSFLH3xKlrDYYKEWHlVw==</cipc:sPassword>\n"
                + "         <cipc:sBankID>wBAA7LAkWIs=</cipc:sBankID>\n"
                + "         <cipc:sEntNo>2011/100088/07</cipc:sEntNo>\n"
                + "         <!--Optional:-->\n"
                + "         <cipc:sCust_Code>INKE01</cipc:sCust_Code>\n"
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

    public void CalculateARTranData(User user) {

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
                + "                  <Table1 diffgr:id=\"Table11\" msdata:rowOrder=\"0\" diffgr:hasChanges=\"inserted\">\n"
                + "                     <ent_no>K2012210312</ent_no>\n"
                + "                     <ar_year>2013</ar_year>\n"
                + "                     <ar_month>11</ar_month>\n"
                + "                     <turnover>0</turnover>\n"
                + "                     <ent_type_code>07</ent_type_code>\n"
                + "                  </Table1>\n"
                + "                   <Table1 diffgr:id=\"Table11\" msdata:rowOrder=\"0\" diffgr:hasChanges=\"inserted\">\n"
                + "                     <ent_no>K2012210312</ent_no>\n"
                + "                     <ar_year>2014</ar_year>\n"
                + "                     <ar_month>11</ar_month>\n"
                + "                     <turnover>100000</turnover>\n"
                + "                     <ent_type_code>07</ent_type_code>\n"
                + "                  </Table1>\n"
                + "                                                 <Table1 diffgr:id=\"Table11\" msdata:rowOrder=\"0\" diffgr:hasChanges=\"inserted\">\n"
                + "                     <ent_no>K2012210312</ent_no>\n"
                + "                     <ar_year>2015</ar_year>\n"
                + "                     <ar_month>11</ar_month>\n"
                + "                     <turnover>100000000</turnover>\n"
                + "                     <ent_type_code>07</ent_type_code>\n"
                + "                  </Table1>                 \n"
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
        Log.p("CalculateARTranData" + data, Log.DEBUG);

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

    public String insertCartItemService(User user) {

        String END_POINT = "https://apidev.cipc.co.za/v1/payment/cartitem";

        String BODY
                = "{\"ReferenceNumber\":3118779575,"
                + "\"Status\":0,"
                + "\"StatusDate\":\"2018-04-23T13:04:28.873\","
                + "\"CustomerCode\":\"" + user.getAgent_code() + "\","
                + "\"ItemType\":4,"
                + "\"ItemData\":\"{\\\"ReferenceNumber\\\":9118779575,\\\"EnterpriseNumber\\\":\\\"\\\",\\\"FormCode\\\":\\\"CoR9.1\\\",\\\"ChangeTypeCode\\\":\\\"30\\\",\\\"Description\\\":null,\\\"TotalAmount\\\":50.0}\","
                + "\"Amount\":50.0"
                + "}";

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

        AuthObject auth = getToken(user);

        post.addRequestHeader("Authorization", auth.getToken_type() + " " + auth.getAccess_token());

        NetworkManager.getInstance().addToQueueAndWait(post);
        byte[] raw = post.getResponseData();
        Log.p("raw=" + raw);
//        String data = new String(post.getResponseData());

        return null;
    }

    public String insertCartItemAR(User user) {

        String END_POINT = "https://apidev.cipc.co.za/v1/payment/cartitem";

        String BODY
                = "{\n"
                + "                \"ReferenceNumber\":1118779571,\n"
                + "                \"Status\":0,\n"
                + "                \"StatusDate\":\"2018-04-23T13:04:28.873\",\n"
                + "                \"CustomerCode\":\"" + user.getAgent_code() + "\",\n"
                + "                \"ItemType\":4,\n"
                + "                \"ItemData\":\"{\\\"ReferenceNumber\\\":533549914,\\\"FormCode\\\":\\\"CK2B\\\",\\\"EnterpriseNumber\\\":\\\"B1988003406\\\",\\\"EnterpriseType\\\":\\\"23\\\",\\\"EnterpriseStatus\\\":\\\"28\\\",\\\"EmailAddress\\\":\\\"jbruton@cipc.co.za\\\",\\\"TelephoneCode\\\":\\\"012\\\",\\\"TelephoneNumber\\\":\\\"1234567\\\",\\\"CellphoneNumber\\\":\\\"\\\",\\\"WebsiteAddress\\\":\\\"\\\",\\\"BusinessDescription\\\":\\\"CARD PAYMENT\\\",\\\"PrincipalPlaceOfBusiness\\\":\\\"\\\",\\\"EnterpriseNameChanged\\\":0,\\\"FinancialYearEndChanged\\\":0,\\\"RegisteredOfficeChanged\\\":0,\\\"LocationOfRecordsChanged\\\":0,\\\"DirectorsChanged\\\":0,\\\"CompanySecretaryChanged\\\":0,\\\"AuditorsChanged\\\":0,\\\"TotalAmount\\\":2250.00,\\\"YearData\\\":[{\\\"ReferenceNumber\\\":533549914,\\\"EnterpriseNumber\\\":\\\"B1988003406\\\",\\\"Year\\\":2009,\\\"Turnover\\\":0.0,\\\"Amount\\\":100.00,\\\"PenaltyFee\\\":150.00,\\\"TotalAmount\\\":250.00,\\\"Status\\\":null,\\\"StatusDate\\\":\\\"0001-01-01T00:00:00\\\"},{\\\"ReferenceNumber\\\":533549914,\\\"EnterpriseNumber\\\":\\\"B1988003406\\\",\\\"Year\\\":2010,\\\"Turnover\\\":0.0,\\\"Amount\\\":100.00,\\\"PenaltyFee\\\":150.00,\\\"TotalAmount\\\":250.00,\\\"Status\\\":null,\\\"StatusDate\\\":\\\"0001-01-01T00:00:00\\\"},{\\\"ReferenceNumber\\\":533549914,\\\"EnterpriseNumber\\\":\\\"B1988003406\\\",\\\"Year\\\":2011,\\\"Turnover\\\":0.0,\\\"Amount\\\":100.00,\\\"PenaltyFee\\\":150.00,\\\"TotalAmount\\\":250.00,\\\"Status\\\":null,\\\"StatusDate\\\":\\\"0001-01-01T00:00:00\\\"},{\\\"ReferenceNumber\\\":533549914,\\\"EnterpriseNumber\\\":\\\"B1988003406\\\",\\\"Year\\\":2012,\\\"Turnover\\\":0.0,\\\"Amount\\\":100.00,\\\"PenaltyFee\\\":150.00,\\\"TotalAmount\\\":250.00,\\\"Status\\\":null,\\\"StatusDate\\\":\\\"0001-01-01T00:00:00\\\"},{\\\"ReferenceNumber\\\":533549914,\\\"EnterpriseNumber\\\":\\\"B1988003406\\\",\\\"Year\\\":2013,\\\"Turnover\\\":0.0,\\\"Amount\\\":100.00,\\\"PenaltyFee\\\":150.00,\\\"TotalAmount\\\":250.00,\\\"Status\\\":null,\\\"StatusDate\\\":\\\"0001-01-01T00:00:00\\\"},{\\\"ReferenceNumber\\\":533549914,\\\"EnterpriseNumber\\\":\\\"B1988003406\\\",\\\"Year\\\":2014,\\\"Turnover\\\":0.0,\\\"Amount\\\":100.00,\\\"PenaltyFee\\\":150.00,\\\"TotalAmount\\\":250.00,\\\"Status\\\":null,\\\"StatusDate\\\":\\\"0001-01-01T00:00:00\\\"},{\\\"ReferenceNumber\\\":533549914,\\\"EnterpriseNumber\\\":\\\"B1988003406\\\",\\\"Year\\\":2015,\\\"Turnover\\\":0.0,\\\"Amount\\\":100.00,\\\"PenaltyFee\\\":150.00,\\\"TotalAmount\\\":250.00,\\\"Status\\\":null,\\\"StatusDate\\\":\\\"0001-01-01T00:00:00\\\"},{\\\"ReferenceNumber\\\":533549914,\\\"EnterpriseNumber\\\":\\\"B1988003406\\\",\\\"Year\\\":2016,\\\"Turnover\\\":0.0,\\\"Amount\\\":100.00,\\\"PenaltyFee\\\":150.00,\\\"TotalAmount\\\":250.00,\\\"Status\\\":null,\\\"StatusDate\\\":\\\"0001-01-01T00:00:00\\\"},{\\\"ReferenceNumber\\\":533549914,\\\"EnterpriseNumber\\\":\\\"B1988003406\\\",\\\"Year\\\":2017,\\\"Turnover\\\":0.0,\\\"Amount\\\":100.00,\\\"PenaltyFee\\\":150.00,\\\"TotalAmount\\\":250.00,\\\"Status\\\":null,\\\"StatusDate\\\":\\\"0001-01-01T00:00:00\\\"}],\\\"ItemsCount\\\":9}\",\n"
                + "                \"Amount\":50.0\n"
                + "}";

        ConnectionRequest post = new ConnectionRequest() {
            @Override
            protected void buildRequestBody(OutputStream os) throws IOException {
                //Log.p(BODY.toString().trim());
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
        AuthObject auth = getToken(user);

        post.addRequestHeader("Authorization", auth.getToken_type() + " " + auth.getAccess_token());

        NetworkManager.getInstance().addToQueueAndWait(post);
        byte[] raw = post.getResponseData();
        Log.p("insertCartItemAR=" + raw);
//        String data = new String(post.getResponseData());

        return null;
    }

    public String deleteCartItem(User user) {

        String END_POINT = "https://apidev.cipc.co.za/v1/payment/cartitem/update";

        String BODY
                = "{\"ReferenceNumber\":8118779575,"
                + "\"Status\":2,"
                + "\"StatusDate\":\"2018-04-23T13:04:28.873\","
                + "\"CustomerCode\":\"" + user.getAgent_code() + "\","
                + "\"ItemType\":4,"
                + "\"ItemData\":\"{\\\"ReferenceNumber\\\":9118779575,\\\"EnterpriseNumber\\\":\\\"\\\",\\\"FormCode\\\":\\\"CoR9.1\\\",\\\"ChangeTypeCode\\\":\\\"30\\\",\\\"Description\\\":null,\\\"TotalAmount\\\":50.0}\","
                + "\"Amount\":50.0"
                + "}";

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

    public String getCart(User user) {

        /*Map jsonData = Rest.get("http://apidev.cipc.co.za/v1/payment/cart/" + user.getAgent_code())
                .acceptJson().getAsJsonMap().getResponseData();

        Log.p("getCart=" + jsonData.toString());*/
        AuthObject auth = getToken(user);

        ConnectionRequest post = new ConnectionRequest();

        post.setUrl("https://apidev.cipc.co.za/v1/payment/cart/" + user.getAgent_code());
        post.setPost(false);
        post.setContentType("application/json");

        post.addRequestHeader("Authorization", auth.getToken_type() + " " + auth.getAccess_token());
        NetworkManager.getInstance().addToQueueAndWait(post);
        byte[] responseData = post.getResponseData();
        if (responseData != null) {
            String data = new String(responseData);

            //JSONParser
            Log.p("getCart=" + data);
        }

        return null;
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
                + "         <cipc:sUserName>"+Constants.sUserName+"</cipc:sUserName>\n"
                + "\n"
                + "         <cipc:sPassword>"+Constants.sPassword+"</cipc:sPassword>\n"
                + "\n"
                + "         <cipc:sBankID>"+Constants.sBankID+"</cipc:sBankID>\n"
                + "\n"
                + "         <cipc:scustcode>"+user.getAgent_code()+"</cipc:scustcode>\n"
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

            Log.p("get_cust_MOBI: " + result, Log.DEBUG);

            responseUser.setAgent_code(user.getAgent_code());
            responseUser.setPassword(result.getAsString("//get_cust_mobiresult"));
           

            return responseUser;

        } catch (IllegalArgumentException e) {
            Log.p(e.toString());
        }

        return null;

    }//end login

    public User forget_password_MOBI(User user) {

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
                + "         <cipc:sCust_Code>INKE01</cipc:sCust_Code>\n"
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

    }//end forget_password_MOBI

    public User get_countries(User user) {

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
                + "         <cipc:sCust_Code>INKE01</cipc:sCust_Code>\n"
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

    }//end get_countries

    public User Get_Cust_code_id_MOBI(User user) {

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
                + "         <cipc:sid_no>7104085085085</cipc:sid_no>\n"
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
                + "         <cipc:sCustID>" + user.getParamCustomerCode()+ "</cipc:sCustID>\n\n"
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

    public void Namereservation_MOBI(User user) {

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
                + "         <cipc:S_name1>blessing1</cipc:S_name1>\n"
                + "\n"
                + "         <!--Optional:-->\n"
                + "\n"
                + "         <cipc:S_name2>blessing2</cipc:S_name2>\n"
                + "\n"
                + "         <!--Optional:-->\n"
                + "\n"
                + "         <cipc:S_name3>blessing3</cipc:S_name3>\n"
                + "\n"
                + "         <!--Optional:-->\n"
                + "\n"
                + "         <cipc:S_name4>blessing4</cipc:S_name4>\n"
                + "\n"
                + "         <!--Optional:-->\n"
                + "\n"
                + "         <cipc:sCust_Code>INKE01</cipc:sCust_Code>\n"
                + "\n"
                + "      </cipc:Namereservation_MOBI>\n"
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

    public void search_name_MOBI(User user) {

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
                + "         <cipc:sCust_Code>INKE01</cipc:sCust_Code>\n"
                + "\n"
                + "         <!--Optional:-->\n"
                + "\n"
                + "         <cipc:S_name1>ABSA</cipc:S_name1>\n"
                + "\n"
                + "         <!--Optional:-->\n"
                + "\n"
                + "         <cipc:S_name2>NEDBANK</cipc:S_name2>\n"
                + "\n"
                + "         <!--Optional:-->\n"
                + "\n"
                + "         <cipc:S_name3>Blessing Mobile Shop</cipc:S_name3>\n"
                + "\n"
                + "         <!--Optional:-->\n"
                + "\n"
                + "         <cipc:S_name4>CAR</cipc:S_name4>\n"
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

    }//end search_name_MOBI

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

            String receivenewcustdata_regresult = result.getAsString("//receivenewcustdata_regresult");

            Log.p("result: " + result, Log.DEBUG);
            Log.p("receivenewcustdata_regresult: " + receivenewcustdata_regresult, Log.DEBUG);

            return receivenewcustdata_regresult;

        } catch (IllegalArgumentException e) {
            Log.p(e.toString());
        }

        return null;

    }//end register

}
