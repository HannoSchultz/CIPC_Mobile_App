/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.cipc.webservices;

import java.text.DateFormat;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.codename1.components.InfiniteProgress;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.Log;
import com.codename1.io.NetworkManager;
import com.codename1.processing.Result;
import com.codename1.ui.Dialog;
import com.codename1.xml.Element;
import com.codename1.xml.XMLParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.text.DateFormat;
import services.User;
import userclasses.BEEDetail;
import userclasses.Const;
import userclasses.Constants;
import userclasses.DHA_Detail;
import userclasses.Name_Workflow;
import userclasses.DIR_Detail;
import userclasses.DirectorDetails;
import userclasses.EnterpriseDetails;
import userclasses.NameReserved;
import userclasses.NameSearchObject;
import userclasses.Name_Workflow;
import userclasses.ValidIdandRelative;

/**
 *
 * @author HanSchultz
 */
public class UserWebServicesNewReg {

    public ArrayList<DHA_Detail> ArlDHA_Detail;

    public ArrayList<Name_Workflow> getArl_name_workflow_Detail() {
        return Arl_name_workflow_Detail;
    }

    public void setArl_name_workflow_Detail(ArrayList<Name_Workflow> Arl_name_workflow_Detail) {
        this.Arl_name_workflow_Detail = Arl_name_workflow_Detail;
    }
    public ArrayList<Name_Workflow> Arl_name_workflow_Detail;

    public ArrayList<DIR_Detail> getArlDIR_Detail() {
        return ArlDIR_Detail;
    }

    public void setArlDIR_Detail(ArrayList<DIR_Detail> ArlDIR_Detail) {
        this.ArlDIR_Detail = ArlDIR_Detail;
    }
    public ArrayList<DIR_Detail> ArlDIR_Detail;
    public ArrayList<BEEDetail> ArlBEE_Detail;
    public ArrayList<NameReserved> ArlNameReserved;
    public ArrayList<DirectorDetails> ArlDirectorDetails;
    public ArrayList<EnterpriseDetails> ArlEnterpriseDetails;
    public ArrayList<ValidIdandRelative> ArlValidRelative;
    //public DirectorDetails directordetails;
    //public EnterpriseDetails enterprisedetails;
    private String agent_code; //= "INKE01";
    private String name_reservation_no;
    private String Surname;
    private String FirstNames;
    private String trak_no;
    //   private String sUserName = "wBAA7LAkWIs=";
    //   private String sPassword = "6EGQAUzYJlhvffhZ+gUFfg==";
    //   private String sBankID = "wBAA7LAkWIs=";
    private String OTP = "";
    private static boolean isIncorporator = false;

    public static boolean isIsIncorporator() {
        return isIncorporator;
    }

    public static void setIsIncorporator(boolean isIncorporator) {
        UserWebServicesNewReg.isIncorporator = isIncorporator;
    }
    private static boolean isnamereserved = false;
    private static boolean isnamefiled = false;
    private static boolean Info_Allowed = true;
    private static boolean Names_Allowed = false;
    private static boolean Enterprise_Allowed = false;
    private static boolean Directors_Allowed = false;

    public static boolean isIsnamefiled() {
        return isnamefiled;
    }

    public static void setIsnamefiled(boolean isnamefiled) {
        UserWebServicesNewReg.isnamefiled = isnamefiled;
    }

    public static boolean isInfo_Allowed() {
        return Info_Allowed;
    }

    public static void setInfo_Allowed(boolean Info_Allowed) {
        UserWebServicesNewReg.Info_Allowed = Info_Allowed;
    }

    public static boolean isNames_Allowed() {
        return Names_Allowed;
    }

    public static void setNames_Allowed(boolean Names_Allowed) {
        UserWebServicesNewReg.Names_Allowed = Names_Allowed;
    }

    public static boolean isEnterprise_Allowed() {
        return Enterprise_Allowed;
    }

    public static void setEnterprise_Allowed(boolean Enterprise_Allowed) {
        UserWebServicesNewReg.Enterprise_Allowed = Enterprise_Allowed;
    }

    public static boolean isDirectors_Allowed() {
        return Directors_Allowed;
    }

    public static void setDirectors_Allowed(boolean Directors_Allowed) {
        UserWebServicesNewReg.Directors_Allowed = Directors_Allowed;
    }

    public ArrayList<DHA_Detail> getArlDHA_Detail() {
        return ArlDHA_Detail;
    }

    public void setArlDHA_Detail(ArrayList<DHA_Detail> ArlDHA_Detail) {
        this.ArlDHA_Detail = ArlDHA_Detail;
    }

    public ArrayList<NameReserved> getArlNameReserved() {
        return ArlNameReserved;
    }

    public void setArlNameReserved(ArrayList<NameReserved> ArlNameReserved) {
        this.ArlNameReserved = ArlNameReserved;
    }

    public ArrayList<DirectorDetails> getArlDirectorDetails() {
        return ArlDirectorDetails;
    }

    public void setArlDirectorDetails(ArrayList<DirectorDetails> ArlDirectorDetails) {
        this.ArlDirectorDetails = ArlDirectorDetails;
    }

    public ArrayList<EnterpriseDetails> getArlEnterpriseDetails() {
        return ArlEnterpriseDetails;
    }

    public void setArlEnterpriseDetails(ArrayList<EnterpriseDetails> ArlEnterpriseDetails) {
        this.ArlEnterpriseDetails = ArlEnterpriseDetails;
    }

    public ArrayList<ValidIdandRelative> getArlValidRelative() {
        return ArlValidRelative;
    }

    public void setArlValidRelative(ArrayList<ValidIdandRelative> ArlValidRelative) {
        this.ArlValidRelative = ArlValidRelative;
    }

//    public DirectorDetails getDirectordetails() {
//        return directordetails;
//    }
//
//    public void setDirectordetails(DirectorDetails directordetails) {
//        this.directordetails = directordetails;
//    }
    public String getAgent_code() {
        return agent_code;
    }

    public void setAgent_code(String agent_code) {
        this.agent_code = agent_code;
    }

    public String getName_reservation_no() {
        return name_reservation_no;
    }

    public void setName_reservation_no(String name_reservation_no) {
        try {
            if (name_reservation_no == null) {
                this.name_reservation_no = "";
            } else {
                this.name_reservation_no = name_reservation_no;
            }
        } catch (Throwable err) {
            if ("java.lang.Nul".equals(err.toString().substring(0, 13))) {
                //if (err.toString() == "java.lang.NullPointerException") {
                this.name_reservation_no = "";
            }
        }

    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public String getFirstNames() {
        return FirstNames;
    }

    public void setFirstNames(String FirstNames) {
        this.FirstNames = FirstNames;
    }

    public String getTrak_no() {
        return trak_no;
    }

    public void setTrak_no(String trak_no) {
        this.trak_no = trak_no;
    }

//    public String getsUserName() {
//        return sUserName;
//    }
//    public void setsUserName(String sUserName) {
//        this.sUserName = sUserName;
//    }
//    public String getsPassword() {
//        return sPassword;
//    }
//    public void setsPassword(String sPassword) {
//        this.sPassword = sPassword;
//    }
//
//    public String getsBankID() {
//        return sBankID;
//    }
//
//    public void setsBankID(String sBankID) {
//        this.sBankID = sBankID;
//    }
    public String getOTP() {
        return OTP;
    }

    public void setOTP(String OTP) {
        this.OTP = OTP;
    }

    public static boolean isIsnamereserved() {
        return isnamereserved;
    }

    public static void setIsnamereserved(boolean isnamereserved) {
        UserWebServicesNewReg.isnamereserved = isnamereserved;
    }

    public Result AddEnterprise(EnterpriseDetails enterprise) {
        trak_no = getnexttrakno();
//          String myString = DateFormat.getDateInstance().format(enterprise.getReg_date().toString());
//          DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
//         String myDate = df.parse(myString);

        final String SOAP_BODY
                = "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\">\n"
                + "   <s:Body xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n"
                + "      <ReceiveNewEntData xmlns=\"CIPC_WEB_SERVICES\">\n"
                + "         <sUserName>" + Constants.sUserName + "=</sUserName>\n"
                + "         <sPassword>" + Constants.sPassword + "</sPassword>\n"
                + "         <sBankID>" + Constants.sBankID + "</sBankID>\n"
                + "         <ds>\n"
                + "            <xs:schema id=\"NewDataSet\" xmlns=\"\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:msdata=\"urn:schemas-microsoft-com:xml-msdata\">\n"
                + "               <xs:element name=\"NewDataSet\" msdata:IsDataSet=\"true\" msdata:UseCurrentLocale=\"true\">\n"
                + "                  <xs:complexType>\n"
                + "                     <xs:choice minOccurs=\"0\" maxOccurs=\"unbounded\">\n"
                + "                        <xs:element name=\"Table1\">\n"
                + "                           <xs:complexType>\n"
                + "                              <xs:sequence>\n"
                + "                                 <xs:element name=\"password\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"user_name\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"bank_ID\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"Reference_No\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"Cust_Code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"Ent_Name\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"Ent_Type_Code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"Ent_Status_Code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"Reg_Date\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"Phys_Addr1\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"Phys_Addr2\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"Phys_Addr3\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"Phys_Addr4\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"Phys_Code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"Postal_Addr1\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"Postal_Addr2\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"Postal_Addr3\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"Postal_Addr4\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"Postal_Code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"No_Auth_Shares\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"TranDate\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"Fin_Year_End\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                              </xs:sequence>\n"
                + "                           </xs:complexType>\n"
                + "                        </xs:element>\n"
                + "                     </xs:choice>\n"
                + "                  </xs:complexType>\n"
                + "               </xs:element>\n"
                + "            </xs:schema>\n"
                + "            <diffgr:diffgram xmlns:msdata=\"urn:schemas-microsoft-com:xml-msdata\" xmlns:diffgr=\"urn:schemas-microsoft-com:xml-diffgram-v1\">\n"
                + "               <NewDataSet xmlns=\"\">\n"
                + "                  <Table1 diffgr:id=\"Table11\" msdata:rowOrder=\"0\" diffgr:hasChanges=\"inserted\">\n"
                + "                     <password/>\n"
                + "                     <user_name>" + Constants.sUserName + "</user_name>\n"
                + "                     <bank_ID>" + Constants.sBankID + "</bank_ID>\n"
                + "                     <Reference_No>" + trak_no + "</Reference_No>\n"
                + "                     <Cust_Code>" + enterprise.getCust_code() + "</Cust_Code>\n"
                + "                     <Ent_Name/>\n"
                + "                     <Ent_Type_Code>" + enterprise.getEnt_type_code() + " </Ent_Type_Code>\n"
                + "                     <Ent_Status_Code>03</Ent_Status_Code>\n"
                + "                     <Reg_Date>" + enterprise.getReg_date() + "</Reg_Date>\n"
                + "                     <Phys_Addr1>" + enterprise.getPhysaddr1() + "</Phys_Addr1>\n"
                + "                     <Phys_Addr2>" + enterprise.getPhysaddr2() + "</Phys_Addr2>\n"
                + "                     <Phys_Addr3>" + enterprise.getPhysaddr3() + "t</Phys_Addr3>\n"
                + "                     <Phys_Addr4>" + enterprise.getPhysaddr4() + "</Phys_Addr4>\n"
                + "                     <Phys_Code>" + enterprise.getPhyscode() + " </Phys_Code>\n"
                + "                     <Postal_Addr1>" + enterprise.getPostaladdr1() + "</Postal_Addr1>\n"
                + "                     <Postal_Addr2>" + enterprise.getPhysaddr2() + "</Postal_Addr2>\n"
                + "                     <Postal_Addr3>" + enterprise.getPostaladdr3() + "</Postal_Addr3>\n"
                + "                     <Postal_Addr4>" + enterprise.getPostaladdr4() + "</Postal_Addr4>\n"
                + "                     <Postal_Code>" + enterprise.getPostalcode() + "</Postal_Code>\n"
                + "                     <No_Auth_Shares>" + enterprise.getShares() + "</No_Auth_Shares>\n"
                + "                     <TranDate></TranDate>\n"
                + "                     <Fin_Year_End>" + enterprise.getFYE() + "</Fin_Year_End>\n"
                + "                  </Table1>\n"
                + "               </NewDataSet>\n"
                + "            </diffgr:diffgram>\n"
                + "         </ds>\n"
                + "         <sCust_Code>" + enterprise.getCust_code() + "</sCust_Code>\n"
                + "      </ReceiveNewEntData>\n"
                + "   </s:Body>\n"
                + "</s:Envelope>";
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

        };

        httpRequest.setUrl(Constants.soapServicesEndPoint + "enterprise.asmx?wsdl");
        httpRequest.addRequestHeader("Content-Type", "text/xml; charset=utf-8");
        httpRequest.addRequestHeader("Content-Length", SOAP_BODY.length() + "");
        httpRequest.setPost(true);
        NetworkManager.getInstance().setTimeout(60000);
        NetworkManager.getInstance().addToQueueAndWait(httpRequest);
        String data = new String(httpRequest.getResponseData());
        Result result = Result.fromContent(data, Result.XML);
        return result;
    }
//<cipc:alowincorporator_mobi>
//                  <cipc:sUserName>ImJbvgnMVO0=</cipc:sUserName>
//         <!--Optional:-->
//         <cipc:sPassword>WViQlFqcunA=</cipc:sPassword>
//         <!--Optional:-->
//         <cipc:sBankID>WViQlFqcunA=</cipc:sBankID>
//
//         <!--Optional:-->
//         <cipc:reference_no>989124629</cipc:reference_no>
//         <!--Optional:-->
//         <cipc:sCust_Code>INKE01</cipc:sCust_Code>
//      </cipc:alowincorporator_mobi>

    public Result incorporatorcount(String trk_reg, String AGENT_CODE) {

        final String SOAP_BODY
                = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:cipc=\"CIPC_WEB_SERVICES\">\n"
                + "   <soap:Header/>\n"
                + "   <soap:Body>\n"
                + "      <cipc:alowincorporator_mobi>\n"
                + "         <cipc:sUserName>" + Constants.sUserName + "</cipc:sUserName>\n"
                + "         <cipc:sPassword>" + Constants.sPassword + "</cipc:sPassword>\n"
                + "         <cipc:sBankID>" + Constants.sBankID + "</cipc:sBankID>\n"
                + "         <cipc:reference_no>" + trk_reg + "</cipc:reference_no>\n"
                + "         <cipc:sCust_Code>" + AGENT_CODE + "</cipc:sCust_Code>\n"
                + "      </cipc:alowincorporator_mobi>\n"
                + "   </soap:Body>\n"
                + "</soap:Envelope>";
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

        };

        httpRequest.setUrl(Constants.soapServicesEndPoint + "director.asmx?wsdl");
        httpRequest.addRequestHeader("Content-Type", "text/xml; charset=utf-8");
        httpRequest.addRequestHeader("Content-Length", SOAP_BODY.length() + "");
        httpRequest.setPost(true);
        NetworkManager.getInstance().setTimeout(60000);
        NetworkManager.getInstance().addToQueueAndWait(httpRequest);
        String data = new String(httpRequest.getResponseData());
        Result result = Result.fromContent(data, Result.XML);
        return result;
    }

    public Result name_workflow(String trk_reg, String trk_name, String AGENT_CODE) {

        final String SOAP_BODY
                = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:cipc=\"CIPC_WEB_SERVICES\">\n"
                + "   <soap:Header/>\n"
                + "   <soap:Body>\n"
                + "      <cipc:Insert_Name_Workflow_mobi>\n"
                + "         <cipc:sUserName>" + Constants.sUserName + "</cipc:sUserName>\n"
                + "         <cipc:sPassword>" + Constants.sPassword + "</cipc:sPassword>\n"
                + "         <cipc:sBankID>" + Constants.sBankID + "</cipc:sBankID>\n"
                + "         <cipc:sTrk_Reg>" + trk_reg + "</cipc:sTrk_Reg>\n"
                + "         <cipc:sTrk_name>" + trk_name + " </cipc:sTrk_name>\n"
                + "         <cipc:sCust_Code>" + AGENT_CODE + "</cipc:sCust_Code>\n"
                + "         <cipc:sref_no>" + trk_reg + "</cipc:sref_no>\n"
                + "      </cipc:Insert_Name_Workflow_mobi>\n"
                + "   </soap:Body>\n"
                + "</soap:Envelope>";
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

        };

        httpRequest.setUrl(Constants.soapServicesEndPoint + "enterprise.asmx?wsdl");
        httpRequest.addRequestHeader("Content-Type", "text/xml; charset=utf-8");
        httpRequest.addRequestHeader("Content-Length", SOAP_BODY.length() + "");
        httpRequest.setPost(true);
        NetworkManager.getInstance().setTimeout(60000);
        NetworkManager.getInstance().addToQueueAndWait(httpRequest);
        String data = new String(httpRequest.getResponseData());
        Result result = Result.fromContent(data, Result.XML);
        return result;
    }

    public Result removedir(String dir_id, String AGENT_CODE) {

        final String SOAP_BODY
                = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:cipc=\"CIPC_WEB_SERVICES\">\n"
                + "   <soap:Header/>\n"
                + "   <soap:Body>\n"
                + "      <cipc:remove_dir_mobi>\n"
                + "         <cipc:sUserName>" + Constants.sUserName + "</cipc:sUserName>\n"
                + "         <cipc:sPassword>" + Constants.sPassword + "</cipc:sPassword>\n"
                + "         <cipc:sBankID>" + Constants.sBankID + "</cipc:sBankID>\n"
                + "         <cipc:dir_id>" + dir_id + "</cipc:dir_id>\n"
                + "         <cipc:sCust_Code>" + AGENT_CODE + "</cipc:sCust_Code>\n"
                + "      </cipc:remove_dir_mobi>\n"
                + "   </soap:Body>\n"
                + "</soap:Envelope>";
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

        };

        httpRequest.setUrl(Constants.soapServicesEndPoint + "director.asmx?wsdl");
        httpRequest.addRequestHeader("Content-Type", "text/xml; charset=utf-8");
        httpRequest.addRequestHeader("Content-Length", SOAP_BODY.length() + "");
        httpRequest.setPost(true);
        NetworkManager.getInstance().setTimeout(60000);
        NetworkManager.getInstance().addToQueueAndWait(httpRequest);
        String data = new String(httpRequest.getResponseData());
        Result result = Result.fromContent(data, Result.XML);
        return result;
    }

    public Result AddDirector(DirectorDetails directordetails) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = directordetails.getDir_appoint_date();
//Date now = 
        Date parsed = new Date();
        try {
            parsed = format.parse(dateString);
        } catch (ParseException pe) {
            System.out.println("ERROR: Cannot parse \"" + dateString + "\"");
        }
        String app_date = parsed.toString();
        final String SOAP_BODY
                = "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\">\n"
                + "   <s:Body xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n"
                + "      <ReceiveNewDirData_mobi xmlns=\"CIPC_WEB_SERVICES\">\n"
                + "         <sUserName>" + Constants.sUserName + "</sUserName>\n"
                + "         <sPassword>" + Constants.sPassword + "</sPassword>\n"
                + "         <sBankID>" + Constants.sBankID + "</sBankID>\n"
                + "         <ds>\n"
                + "            <xs:schema id=\"NewDataSet\" xmlns=\"\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:msdata=\"urn:schemas-microsoft-com:xml-msdata\">\n"
                + "               <xs:element name=\"NewDataSet\" msdata:IsDataSet=\"true\" msdata:UseCurrentLocale=\"true\">\n"
                + "                  <xs:complexType>\n"
                + "                     <xs:choice minOccurs=\"0\" maxOccurs=\"unbounded\">\n"
                + "                        <xs:element name=\"Table1\">\n"
                + "                           <xs:complexType>\n"
                + "                              <xs:sequence>\n"
                + "                                 <xs:element name=\"country_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"Dir_Type_Code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"Dir_Status_Code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"surname\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"first_names\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"initials\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"id_no\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"member_size_int\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"mem_con\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"res_addr1\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"res_addr2\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"res_addr3\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"res_addr4\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"res_post_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"res_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"bus_addr1\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"bus_addr2\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"bus_addr3\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"bus_addr4\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"bus_post_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"bus_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"post_addr1\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"post_addr2\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"post_addr3\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"post_addr4\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"post_post_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"post_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"rsa_citizen\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"rsa_resident\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"dir_birth_date\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"birth_date\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"dir_appoint_date\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"appoint_date\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"profession\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"cell_no\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"tel_no\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"tel_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"fax_no\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"fax_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"email_address\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"reg_addr1\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"reg_addr2\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"reg_addr3\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"reg_addr4\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"reg_post_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"reg_code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"dir_id\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"trak_no\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"dir_res_date\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"ent_no\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"cm29_date\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"receive_date\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"resolution_date\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"TranDate\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"user_name\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"password\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"bank_ID\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"Reference_No\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"Cust_Code\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                                 <xs:element name=\"IsIncorporator\" type=\"xs:string\" minOccurs=\"0\"/>\n"
                + "                              </xs:sequence>\n"
                + "                           </xs:complexType>\n"
                + "                        </xs:element>\n"
                + "                     </xs:choice>\n"
                + "                  </xs:complexType>\n"
                + "               </xs:element>\n"
                + "            </xs:schema>\n"
                + "            <diffgr:diffgram xmlns:msdata=\"urn:schemas-microsoft-com:xml-msdata\" xmlns:diffgr=\"urn:schemas-microsoft-com:xml-diffgram-v1\">\n"
                + "               <NewDataSet xmlns=\"\">\n"
                + "                  <Table1 diffgr:id=\"Table11\" msdata:rowOrder=\"0\" diffgr:hasChanges=\"inserted\">\n"
                + "                     <country_code>ZA</country_code>\n"
                + "                     <Dir_Type_Code>" + directordetails.getDir_type_code() + "</Dir_Type_Code>\n"
                + "                     <Dir_Status_Code>A</Dir_Status_Code>\n"
                + "                     <surname>" + directordetails.getSurname() + "</surname>\n"
                + "                     <first_names>" + directordetails.getFirst_names() + "</first_names>\n"
                + "                     <initials>CD</initials>\n"
                + "                     <id_no>" + directordetails.getId_no() + "</id_no>\n"
                + "                     <member_size_int>0</member_size_int>\n"
                + "                     <mem_con>0</mem_con>\n"
                + "                     <res_addr1>" + directordetails.getRes_addr1() + "</res_addr1>\n"
                + "                     <res_addr2>" + directordetails.getRes_addr2() + "</res_addr2>\n"
                + "                     <res_addr3>" + directordetails.getRes_addr3() + "</res_addr3>\n"
                + "                     <res_addr4>" + directordetails.getRes_addr4() + "</res_addr4>\n"
                + "                     <res_post_code>" + directordetails.getRes_post_code() + "</res_post_code>\n"
                + "                     <res_code>" + directordetails.getRes_post_code() + "</res_code>\n"
                + "                     <bus_addr1>" + directordetails.getBus_addr1() + "</bus_addr1>\n"
                + "                     <bus_addr2>" + directordetails.getBus_addr2() + "</bus_addr2>\n"
                + "                     <bus_addr3>" + directordetails.getBus_addr3() + "</bus_addr3>\n"
                + "                     <bus_addr4>" + directordetails.getBus_addr4() + "</bus_addr4>\n"
                + "                     <bus_post_code>" + directordetails.getBus_post_code() + "</bus_post_code>\n"
                + "                     <bus_code>" + directordetails.getBus_post_code() + "</bus_code>\n"
                + "                     <post_addr1>" + directordetails.getPost_addr1() + "</post_addr1>\n"
                + "                     <post_addr2>" + directordetails.getPost_addr2() + "</post_addr2>\n"
                + "                     <post_addr3>" + directordetails.getPost_addr3() + "</post_addr3>\n"
                + "                     <post_addr4>" + directordetails.getPost_addr4() + "</post_addr4>\n"
                + "                     <post_post_code>" + directordetails.getPost_post_code() + "</post_post_code>\n"
                + "                     <post_code>" + directordetails.getPost_post_code() + "</post_code>\n"
                + "                     <rsa_citizen>1</rsa_citizen>\n"
                + "                     <rsa_resident>1</rsa_resident>\n"
                + "                     <dir_birth_date>" + directordetails.getDir_birth_date() + "</dir_birth_date>\n"
                + "                     <birth_date>" + directordetails.getDir_birth_date() + "</birth_date>\n"
                + "                     <dir_appoint_date>" + app_date.toString() + "</dir_appoint_date>\n"
                + "                     <appoint_date>" + directordetails.getDir_appoint_date() + "</appoint_date>\n"
                + "                     <profession>OWNER</profession>\n"
                + "                     <cell_no>" + directordetails.getCell_no() + "</cell_no>\n"
                + "                     <tel_no/>\n"
                + "                     <tel_code/>\n"
                + "                     <fax_no/>\n"
                + "                     <fax_code/>\n"
                + "                     <email_address>" + directordetails.getEmail_address() + "</email_address>\n"
                + "                     <reg_addr1></reg_addr1>\n"
                + "                     <reg_addr2></reg_addr2>\n"
                + "                     <reg_addr3></reg_addr3>\n"
                + "                     <reg_addr4></reg_addr4>\n"
                + "                     <reg_post_code>" + directordetails.getRes_post_code() + "</reg_post_code>\n"
                + "                     <reg_code></reg_code>\n"
                + "                     <dir_id>" + directordetails.getId_no() + "</dir_id>\n"
                + "                     <trak_no>" + trak_no + "</trak_no>\n"
                + "                     <dir_res_date></dir_res_date>\n"
                + "                     <ent_no></ent_no>\n"
                + "                     <cm29_date></cm29_date>\n"
                + "                     <receive_date></receive_date>\n"
                + "                     <resolution_date></resolution_date>\n"
                + "                     <TranDate></TranDate>\n"
                + "                     <user_name>" + Constants.sUserName + "</user_name>\n"
                + "                     <password>" + Constants.sPassword + "</password>\n"
                + "                     <bank_ID>" + Constants.sBankID + "</bank_ID>\n"
                + "                     <Reference_No>" + trak_no + "</Reference_No>\n"
                + "                     <Cust_Code>" + directordetails.getCust_code() + "</Cust_Code>\n"
                + "                     <IsIncorporator>" + directordetails.isIsIncorporator() + "</IsIncorporator>\n"
                + "                  </Table1>\n"
                + "               </NewDataSet>\n"
                + "            </diffgr:diffgram>\n"
                + "         </ds>\n"
                + "         <sCust_Code>" + directordetails.getCust_code() + "</sCust_Code>\n"
                + "         <sDir_Type>" + directordetails.getDir_type_code() + "</sDir_Type>\n"
                + "      </ReceiveNewDirData_mobi>\n"
                + "   </s:Body>\n"
                + "</s:Envelope>";
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

        };

        httpRequest.setUrl(Constants.soapServicesEndPoint + "director.asmx?wsdl");
        httpRequest.addRequestHeader("Content-Type", "text/xml; charset=utf-8");
        httpRequest.addRequestHeader("Content-Length", SOAP_BODY.length() + "");
        httpRequest.setPost(true);
        NetworkManager.getInstance().setTimeout(60000);
        NetworkManager.getInstance().addToQueueAndWait(httpRequest);
        String data = new String(httpRequest.getResponseData());
        Result result = Result.fromContent(data, Result.XML);
        return result;
    }

    public String getnexttrakno() {

        String response = "";

        final String SOAP_BODY
                = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:cipc=\"CIPC_WEB_SERVICES\">\n"
                + "   <soap:Header/>\n"
                + "   <soap:Body>\n"
                + "      <cipc:GetNextTrakNo>\n"
                + "          <cipc:sUserName>" + Constants.sUserName + "</cipc:sUserName>\n"
                + "         <cipc:sPassword>" + Constants.sPassword + "</cipc:sPassword>\n"
                + "         <cipc:sBankID>" + Constants.sBankID + "</cipc:sBankID>\n"
                + "      </cipc:GetNextTrakNo>\n"
                + "   </soap:Body>\n"
                + "</soap:Envelope>";

        ConnectionRequest httpRequest = new ConnectionRequest() {
            Element h;

            @Override
            protected void handleErrorResponseCode(int code, String message) {
                super.handleErrorResponseCode(code, message); //To change body of generated methods, choose Tools | Templates.
                if (500 == code) {
                    Dialog.show("Error", "Error 500 Contact CIPC.", "Ok", null);
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
        httpRequest.setUrl(Constants.soapServicesEndPoint + "enterprise.asmx");
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
            String trak_no_Response = result.getAsString("//GetNextTrakNoResult");
            response = trak_no_Response;
            if (response != null) {
                response = response.trim();
            }
        } catch (IllegalArgumentException e) {
            Log.p(e.toString());
        }
        return response;
    }

    public Result get_directors_stage(String ref_no) {

        final String SOAP_BODY
                = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cipc=\"CIPC_WEB_SERVICES\">\n"
                + "   <soapenv:Header/>\n"
                + "   <soapenv:Body>\n"
                + "      <cipc:get_dir_register>\n"
                + "       <cipc:sUserName>" + Constants.sUserName + "</cipc:sUserName>\n"
                + "         <cipc:sPassword>" + Constants.sPassword + "</cipc:sPassword>\n"
                + "         <cipc:sBankID>" + Constants.sBankID + "</cipc:sBankID>\n"
                + "         <cipc:reference_no>" + ref_no + "</cipc:reference_no>\n"
                + "      </cipc:get_dir_register>\n"
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
        };

        httpRequest.setUrl(Constants.soapServicesEndPoint + "director.asmx?wsdl");
        httpRequest.addRequestHeader("Content-Type", "text/xml; charset=utf-8");
        httpRequest.addRequestHeader("Content-Length", SOAP_BODY.length() + "");
        httpRequest.setPost(true);
        NetworkManager.getInstance().setTimeout(60000);
        NetworkManager.getInstance().addToQueueAndWait(httpRequest);
        String data = new String(httpRequest.getResponseData());
        Result result = Result.fromContent(data, Result.XML);
        return result;
    }

    public Result get_dha_data(String id_no) {

        final String SOAP_BODY
                = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cipc=\"CIPC_WEB_SERVICES\">\n"
                + "   <soapenv:Header/>\n"
                + "   <soapenv:Body>\n"
                + "      <cipc:get_id_detail_dha_http>\n"
                + "       <cipc:sUserName>" + Constants.sUserName + "</cipc:sUserName>\n"
                + "         <cipc:sPassword>" + Constants.sPassword + "</cipc:sPassword>\n"
                + "         <cipc:sBankID>" + Constants.sBankID + "</cipc:sBankID>\n"
                + "         <cipc:ID_no>" + id_no + "</cipc:ID_no>\n"
                + "      </cipc:get_id_detail_dha_http>\n"
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
        };

        httpRequest.setUrl(Constants.soapServicesEndPoint + "director.asmx?wsdl");
        httpRequest.addRequestHeader("Content-Type", "text/xml; charset=utf-8");
        httpRequest.addRequestHeader("Content-Length", SOAP_BODY.length() + "");
        httpRequest.setPost(true);
        NetworkManager.getInstance().setTimeout(60000);
        NetworkManager.getInstance().addToQueueAndWait(httpRequest);
        String data = new String(httpRequest.getResponseData());
        Result result = Result.fromContent(data, Result.XML);
        return result;
    }

    public Result get_name_workflow(String sRef_no, String sCust_Code) {

        final String SOAP_BODY
                = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cipc=\"CIPC_WEB_SERVICES\">\n"
                + "   <soapenv:Header/>\n"
                + "   <soapenv:Body>\n"
                + "      <cipc:Getname_workflow_mobi>\n"
                + "       <cipc:sUserName>" + Constants.sUserName + "</cipc:sUserName>\n"
                + "         <cipc:sPassword>" + Constants.sPassword + "</cipc:sPassword>\n"
                + "         <cipc:sBankID>" + Constants.sBankID + "</cipc:sBankID>\n"
                + "         <cipc:ref_no>" + sRef_no + "</cipc:ref_no>\n"
                + "         <cipc:sCust_Code>" + sCust_Code + "</cipc:sCust_Code>\n"
                + "      </cipc:Getname_workflow_mobi>\n"
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
        };

        httpRequest.setUrl(Constants.soapServicesEndPoint + "enterprise.asmx?wsdl");
        httpRequest.addRequestHeader("Content-Type", "text/xml; charset=utf-8");
        httpRequest.addRequestHeader("Content-Length", SOAP_BODY.length() + "");
        httpRequest.setPost(true);
        NetworkManager.getInstance().setTimeout(60000);
        NetworkManager.getInstance().addToQueueAndWait(httpRequest);
        String data = new String(httpRequest.getResponseData());
        Result result = Result.fromContent(data, Result.XML);
        return result;
    }

    public Result ReservedName_Name_Mobi(String customerCode, String Name_Res_no) {

        final String SOAP_BODY
                = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cipc=\"CIPC_WEB_SERVICES\">\n"
                + "   <soapenv:Header/>\n"
                + "   <soapenv:Body>\n"
                + "      <cipc:Get_Approved_Name_MObi>\n"
                + "        <cipc:sUserName>" + Constants.sUserName + " </cipc:sUserName>\n"
                + "          <cipc:sPassword>" + Constants.sPassword + "</cipc:sPassword>\n"
                + "          <cipc:sBankID>" + Constants.sBankID + "</cipc:sBankID>\n"
                + "         <cipc:sRefNo>" + Name_Res_no + "</cipc:sRefNo>\n"
                + "         <cipc:sCust_Code>" + customerCode + "</cipc:sCust_Code>\n"
                + "      </cipc:Get_Approved_Name_MObi>\n"
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
        };

        httpRequest.setUrl(Constants.soapServicesEndPoint + "enterprise.asmx?wsdl");
        httpRequest.addRequestHeader("Content-Type", "text/xml; charset=utf-8");
        httpRequest.addRequestHeader("Content-Length", SOAP_BODY.length() + "");
        httpRequest.setPost(true);
        NetworkManager.getInstance().setTimeout(60000);
        NetworkManager.getInstance().addToQueueAndWait(httpRequest);
        String data = new String(httpRequest.getResponseData());
        Result result = Result.fromContent(data, Result.XML);
        return result;
    }

    public String ReservedName_Name_Mobi_old(String customerCode, String Name_Res_no) {

        String response = "";
        Log.p("Reservename_Mobi", Log.DEBUG);
        final String SOAP_BODY
                = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cipc=\"CIPC_WEB_SERVICES\">\n"
                + "   <soapenv:Header/>\n"
                + "   <soapenv:Body>\n"
                + "      <cipc:Get_Approved_Name_MObi>\n"
                + "        <cipc:sUserName>" + Const.sUserName + "</cipc:sUserName>\n"
                + "          <cipc:sPassword>" + Const.sPassword + "</cipc:sPassword>\n"
                + "          <cipc:sBankID>" + Const.sBankID + "</cipc:sBankID>\n"
                + "         <cipc:sRefNo>" + Name_Res_no + "</cipc:sRefNo>\n"
                + "         <cipc:sCust_Code>" + customerCode + "</cipc:sCust_Code>\n"
                + "      </cipc:Get_Approved_Name_MObi>\n"
                + "   </soapenv:Body>\n"
                + "</soapenv:Envelope>";
        Log.p("Reservename_Mobi1", Log.DEBUG);
        ConnectionRequest httpRequest = new ConnectionRequest() {
            Element h;

            @Override
            protected void handleErrorResponseCode(int code, String message) {
                super.handleErrorResponseCode(code, message); //To change body of generated methods, choose Tools | Templates.
                if (500 == code) {
                    Dialog.show("Error", "An Error occured", "Ok", null);
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
        Log.p("Reservename_Mobi2", Log.DEBUG);
        httpRequest.setUrl(Constants.soapServicesEndPoint + "enterprise.asmx");
        httpRequest.addRequestHeader("Content-Type", "text/xml; charset=utf-8");
        httpRequest.addRequestHeader("Content-Length", SOAP_BODY.length() + "");
        httpRequest.setPost(true);
        httpRequest.setFailSilently(true);
        Log.p("Reservename_Mobi3", Log.DEBUG);
        InfiniteProgress prog = new InfiniteProgress();
        Dialog dlg = prog.showInifiniteBlocking();
        httpRequest.setDisposeOnCompletion(dlg);
        Log.p("Reservename_Mobi4", Log.DEBUG);
        NetworkManager.getInstance().addToQueueAndWait(httpRequest);
        Log.p("Reservename_Mobi5", Log.DEBUG);
        String data = new String(httpRequest.getResponseData());
        Log.p("Reservename_Mobi6", Log.DEBUG);
        Log.p("Data d: " + data, Log.DEBUG);

        try {

            Result result = Result.fromContent(data, Result.XML);
            String Namereservation_MOBI_traknoresult = result.getAsString("//Get_Approved_Name_MObiResult");

            response = Namereservation_MOBI_traknoresult;
            if (response != null) {
                response = response.trim();
            }

            //Log.p("result: " + result, Log.DEBUG);
            //Log.p("namereservation_mobiresult: " + namereservation_mobiresult, Log.DEBUG);
        } catch (IllegalArgumentException e) {
            Log.p(e.toString());
        }

        return response;
    }
    public String ValidateCelNo(String customerCode, String Track_no, String cell_no, String id_no) {

        String response = "";

        final String SOAP_BODY
                = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:cipc=\"CIPC_WEB_SERVICES\">\n"
                + "   <soap:Header/>\n"
                + "   <soap:Body>\n"
                + "      <cipc:generate_otp_mobi>\n"
                + "       <cipc:sUserName>" + Constants.sUserName + "</cipc:sUserName>\n"
                + "         <cipc:sPassword>" + Constants.sPassword + "</cipc:sPassword>\n"
                + "         <cipc:sBankID>" + Constants.sBankID + "</cipc:sBankID>\n"
                + "         <!--Optional:-->\n"
                + "         <cipc:track_no>" + Track_no + "</cipc:track_no>\n"
                + "         <!--Optional:-->\n"
                + "         <cipc:sCust_Code>" + customerCode + "</cipc:sCust_Code>\n"
                + "         <!--Optional:-->\n"
                + "         <cipc:form_code></cipc:form_code>\n"
                + "         <!--Optional:-->\n"
                + "         <cipc:cell_no>" + cell_no + "</cipc:cell_no>\n"
                + "         <!--Optional:-->\n"
                + "         <cipc:Id_no>" + id_no + "</cipc:Id_no>\n"
                + "      </cipc:generate_otp_mobi>\n"
                + "   </soap:Body>\n"
                + "</soap:Envelope>";

        ConnectionRequest httpRequest = new ConnectionRequest() {
            Element h;

            @Override
            protected void handleErrorResponseCode(int code, String message) {
                super.handleErrorResponseCode(code, message); //To change body of generated methods, choose Tools | Templates.
                if (500 == code) {
                    Dialog.show("Error", "Error 500 Contact CIPC.", "Ok", null);
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

        httpRequest.setUrl(Constants.soapServicesEndPoint + "enterprise.asmx");
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
            String OTP_Response = result.getAsString("//generate_otp_mobiResult");
            //         if ("|".equals(Namereservation_MOBI_traknoresult.substring(0, 1))) {
//                response = RSM_1(Namereservation_MOBI_traknoresult);
//
//            } else {
            response = OTP_Response;
//            }

            if (response != null) {
                response = response.trim();
            }

            //Log.p("result: " + result, Log.DEBUG);
            //Log.p("namereservation_mobiresult: " + namereservation_mobiresult, Log.DEBUG);
        } catch (IllegalArgumentException e) {
            Log.p(e.toString());
        }

        return response;
    }

         public String ValidateNameForPayment(String customerCode, String Track_no) {

        String response = "";

        final String SOAP_BODY
                = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:cipc=\"CIPC_WEB_SERVICES\">\n"
                + "   <soap:Header/>\n"
                + "   <soap:Body>\n"
                + "      <cipc:ValidateNameForPayment>\n"
                + "       <cipc:sUserName>" + Constants.sUserName + "</cipc:sUserName>\n"
                + "         <cipc:sPassword>" + Constants.sPassword + "</cipc:sPassword>\n"
                + "         <cipc:sBankID>" + Constants.sBankID + "</cipc:sBankID>\n"
                + "         <!--Optional:-->\n"
                + "         <cipc:track_no>" + Track_no + "</cipc:track_no>\n"
                + "         <!--Optional:-->\n"
                + "         <cipc:sCust_Code>" + customerCode + "</cipc:sCust_Code>\n"
                + "      </cipc:ValidateNameForPayment>\n"
                + "   </soap:Body>\n"
                + "</soap:Envelope>";

        ConnectionRequest httpRequest = new ConnectionRequest() {
            Element h;

            @Override
            protected void handleErrorResponseCode(int code, String message) {
                super.handleErrorResponseCode(code, message); //To change body of generated methods, choose Tools | Templates.
                if (500 == code) {
                    Dialog.show("Error", "Error 500 Contact CIPC.", "Ok", null);
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

        httpRequest.setUrl(Constants.soapServicesEndPoint + "enterprise.asmx");
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
//hsz1
            Result result = Result.fromContent(data, Result.XML);
            String validdir = result.getAsString("//ValidateNameForPaymentResult");
            //         if ("|".equals(Namereservation_MOBI_traknoresult.substring(0, 1))) {
//                response = RSM_1(Namereservation_MOBI_traknoresult);
//
//            } else {
            response = validdir;
//            }

            if (response != null) {
                response = response.trim();
            }

            //Log.p("result: " + result, Log.DEBUG);
            //Log.p("namereservation_mobiresult: " + namereservation_mobiresult, Log.DEBUG);
        } catch (IllegalArgumentException e) {
            Log.p(e.toString());
        }

        return response;
    }

        
    public String ValidateDirector(String customerCode, String Track_no) {

        String response = "";

        final String SOAP_BODY
                = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:cipc=\"CIPC_WEB_SERVICES\">\n"
                + "   <soap:Header/>\n"
                + "   <soap:Body>\n"
                + "      <cipc:ValidateDirectors>\n"
                + "       <cipc:sUserName>" + Constants.sUserName + "</cipc:sUserName>\n"
                + "         <cipc:sPassword>" + Constants.sPassword + "</cipc:sPassword>\n"
                + "         <cipc:sBankID>" + Constants.sBankID + "</cipc:sBankID>\n"
                + "         <!--Optional:-->\n"
                + "         <cipc:track_no>" + Track_no + "</cipc:track_no>\n"
                + "         <!--Optional:-->\n"
                + "         <cipc:sCust_Code>" + customerCode + "</cipc:sCust_Code>\n"
                + "      </cipc:ValidateDirectors>\n"
                + "   </soap:Body>\n"
                + "</soap:Envelope>";

        ConnectionRequest httpRequest = new ConnectionRequest() {
            Element h;

            @Override
            protected void handleErrorResponseCode(int code, String message) {
                super.handleErrorResponseCode(code, message); //To change body of generated methods, choose Tools | Templates.
                if (500 == code) {
                    Dialog.show("Error", "Error 500 Contact CIPC.", "Ok", null);
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

        httpRequest.setUrl(Constants.soapServicesEndPoint + "enterprise.asmx");
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
//hsz1
            Result result = Result.fromContent(data, Result.XML);
            String validdir = result.getAsString("//ValidateDirectorsResult");
            //         if ("|".equals(Namereservation_MOBI_traknoresult.substring(0, 1))) {
//                response = RSM_1(Namereservation_MOBI_traknoresult);
//
//            } else {
            response = validdir;
//            }

            if (response != null) {
                response = response.trim();
            }

            //Log.p("result: " + result, Log.DEBUG);
            //Log.p("namereservation_mobiresult: " + namereservation_mobiresult, Log.DEBUG);
        } catch (IllegalArgumentException e) {
            Log.p(e.toString());
        }

        return response;
    }

    public String Namereservation_MOBI(String customerCode, String name1, String name2, String name3, String name4) {

        String response = "";

        final String SOAP_BODY
                = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cipc=\"CIPC_WEB_SERVICES\">\n"
                + "\n"
                + "   <soapenv:Header/>\n"
                + "\n"
                + "   <soapenv:Body>\n"
                + "\n"
                + "      <cipc:Namereservation_MOBI_trakno>\n"
                + "\n"
                + "        <cipc:sUserName>" + Const.sUserName + "</cipc:sUserName>       \n"
                + "\n"
                + "         <cipc:sPassword>" + Const.sPassword + "</cipc:sPassword>\n"
                + "\n"
                + "         <cipc:sBankID>" + Const.sBankID + "</cipc:sBankID>\n"
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
                + "      </cipc:Namereservation_MOBI_trakno>\n"
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
                    Dialog.show("Error", "Error 500 Contact CIPC.", "Ok", null);
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

        httpRequest.setUrl(Constants.soapServicesEndPoint + "enterprise.asmx");
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
            String Namereservation_MOBI_traknoresult = result.getAsString("//Namereservation_MOBI_traknoresult");
            //         if ("|".equals(Namereservation_MOBI_traknoresult.substring(0, 1))) {
//                response = RSM_1(Namereservation_MOBI_traknoresult);
//
//            } else {
            response = Namereservation_MOBI_traknoresult;
//            }

            if (response != null) {
                response = response.trim();
            }

            //Log.p("result: " + result, Log.DEBUG);
            //Log.p("namereservation_mobiresult: " + namereservation_mobiresult, Log.DEBUG);
        } catch (IllegalArgumentException e) {
            Log.p(e.toString());
        }

        return response;
    }

    public void DIR_Data(Result result) {
        try {
            XMLParser parser = new XMLParser();
            parser.setCaseSensitive(true);
            Element element = parser.parse(convertStringtoInputStreamReader(result.getAsString("//DataSet")));
            ArlDIR_Detail = new ArrayList();
            for (int i = 0; i < element.getNumChildren(); i++) {
                Element child = element.getChildAt(i);
                Element elem_dir_id = ((Element) child.getTextChildren(null, true).get(0));
                String dir_id = elem_dir_id.getText();
                Element elem_first_names = ((Element) child.getTextChildren(null, true).get(1));
                String first_names = elem_first_names.getText();
                Element elem_surname = ((Element) child.getTextChildren(null, true).get(2));
                String surname = elem_surname.getText();
                Element elem_id_no = ((Element) child.getTextChildren(null, true).get(3));
                String id_no = elem_id_no.getText();

                DIR_Detail dir_detail = new DIR_Detail();
                dir_detail.setDir_id(dir_id);
                dir_detail.setFirs_names(first_names);
                dir_detail.setSurname(surname);
                dir_detail.setId_no(id_no);

                ArlDIR_Detail.add(dir_detail);
            }
        } catch (Throwable err) {
            // Dialog.show("DIR_Data", err.toString(), "OK", null);
            if ("java.lang.Nul".equals(err.toString().substring(0, 13))) {
                //if (err.toString() == "java.lang.NullPointerException") {
                ArlDIR_Detail = new ArrayList();
            } else {
                Dialog.show("DIR_Data", err.toString(), "OK", null);
            }
        }

    }
  public void BEE_Data(Result result) {
        try {
            XMLParser parser = new XMLParser();
            parser.setCaseSensitive(true);
            Element element = parser.parse(convertStringtoInputStreamReader(result.getAsString("//DataSet")));
            ArlBEE_Detail = new ArrayList();
            
            for (int i = 0; i < element.getNumChildren(); i++) {
                Element child = element.getChildAt(i);
                Element elem_ent_no = ((Element) child.getTextChildren(null, true).get(0));
                String ent_no = elem_ent_no.getText();
                Element elem_ent_name = ((Element) child.getTextChildren(null, true).get(1));
                String ent_name = elem_ent_name.getText();
//                Element elem_surname = ((Element) child.getTextChildren(null, true).get(2));
//                String surname = elem_surname.getText();
//                Element elem_id_no = ((Element) child.getTextChildren(null, true).get(3));
//                String id_no = elem_id_no.getText();

                BEEDetail bee_detail = new BEEDetail();
                bee_detail.setEnt_no(ent_no);
                bee_detail.setEnt_name(ent_name);
               

                ArlBEE_Detail.add(bee_detail);
            }
        } catch (Throwable err) {
            // Dialog.show("DIR_Data", err.toString(), "OK", null);
            if ("java.lang.Nul".equals(err.toString().substring(0, 13))) {
                //if (err.toString() == "java.lang.NullPointerException") {
                ArlBEE_Detail = new ArrayList();
            } else {
                Dialog.show("BEE_Data", err.toString(), "OK", null);
            }
        }

    }
    public String qtyincorporator(Result result) {
        try {
            // String OTP_Response = result.getAsString("//generate_otp_mobiResult");
//            XMLParser parser = new XMLParser();
//            parser.setCaseSensitive(true);
//            Element element = parser.parse(convertStringtoInputStreamReader(result.getAsString("//DataSet")));
//            ArlDIR_Detail = new ArrayList();
//            for (int i = 0; i < element.getNumChildren(); i++) {
//                Element child = element.getChildAt(i);
//                Element elem_qty = ((Element) child.getTextChildren(null, true).get(0));
            //String qty = elem_qty.getText();
            String qty = result.getAsString("//alowincorporator_mobiresult");
            return qty;
//                Element elem_first_names = ((Element) child.getTextChildren(null, true).get(1));
//                String first_names = elem_first_names.getText();
//                Element elem_surname = ((Element) child.getTextChildren(null, true).get(2));
//                String surname = elem_surname.getText();
//                Element elem_id_no = ((Element) child.getTextChildren(null, true).get(3));
//                String id_no = elem_id_no.getText();

//                DIR_Detail dir_detail = new DIR_Detail();
//                dir_detail.setDir_id(dir_id);
//                dir_detail.setFirs_names(first_names);
//                dir_detail.setSurname(surname);
//                dir_detail.setId_no(id_no);
//
//                ArlDIR_Detail.add(dir_detail);
        } catch (Throwable err) {
            return "0";
        }
        // return "0";
    }

    public void name_workflow(Result result) {
        try {
            XMLParser parser = new XMLParser();
            parser.setCaseSensitive(true);
            Element element = parser.parse(convertStringtoInputStreamReader(result.getAsString("//dataset")));
            Arl_name_workflow_Detail = new ArrayList();
            for (int i = 0; i < element.getNumChildren(); i++) {
                Element child = element.getChildAt(i);
                Element elem_cust_code = ((Element) child.getTextChildren(null, true).get(0));
                String cust_code = elem_cust_code.getText();
                Element elem_trk_reg_no = ((Element) child.getTextChildren(null, true).get(1));
                String trk_reg_no = elem_trk_reg_no.getText();
                // Element elem_application_no = ((Element) child.getTextChildren(null, true).get(2));
                // String application_no = elem_application_no.getText();
                Name_Workflow name_workflow = new Name_Workflow();
                name_workflow.setCust_code(cust_code);
                name_workflow.setRef_no(trk_reg_no);
                //  name_workflow.setApplication_no(application_no);
                Arl_name_workflow_Detail.add(name_workflow);
            }
        } catch (Throwable err) {
//            if ("java.lang.Nul".equals(err.toString().substring(0, 13))) {
//                Dialog.show("name_workflow", err.toString().substring(0, 13), "OK", null);
//            } else {
//                Dialog.show("name_workflow", err.toString().substring(0, 13), "OK", null);
//            }
            if ("java.lang.Nul".equals(err.toString().substring(0, 13))) {
                // if (err.toString() == "java.lang.NullPointerException") {

                Arl_name_workflow_Detail = new ArrayList();
            } else {
                Dialog.show("name_workflow", err.toString(), "OK", null);
            }
        }
    }

    public String DHA_Data(Result result) {
        try {
            XMLParser parser = new XMLParser();
            parser.setCaseSensitive(true);
            Element element = parser.parse(convertStringtoInputStreamReader(result.getAsString("//newdataset")));
            ArlDHA_Detail = new ArrayList();
            for (int i = 0; i < element.getNumChildren(); i++) {
                Element child = element.getChildAt(i);
                Element elem_IDNUMBER = ((Element) child.getTextChildren(null, true).get(0));
                String IDNUMBER = elem_IDNUMBER.getText();
                Element elem_SURNAME = ((Element) child.getTextChildren(null, true).get(1));
                String SURNAME = elem_SURNAME.getText();
                Element elem_NAMES = ((Element) child.getTextChildren(null, true).get(2));
                String NAMES = elem_NAMES.getText();
                Element elem_DEATH_STATUS = ((Element) child.getTextChildren(null, true).get(3));
                String DEATH_STATUS = elem_DEATH_STATUS.getText();
                Element elem_DOB = ((Element) child.getTextChildren(null, true).get(4));
                String DOB = elem_DOB.getText();
                Element elem_ADDR_LINE1 = ((Element) child.getTextChildren(null, true).get(5));
                String ADDR_LINE1 = elem_ADDR_LINE1.getText();
                Element elem_ADDR_LINE2 = ((Element) child.getTextChildren(null, true).get(6));
                String ADDR_LINE2 = elem_ADDR_LINE2.getText();

                DHA_Detail dha_detail = new DHA_Detail();
                dha_detail.setADDR_LINE1(ADDR_LINE1);
                dha_detail.setADDR_LINE2(ADDR_LINE2);
                dha_detail.setDEATH_STATUS(DEATH_STATUS);
                dha_detail.setIDNUMBER(IDNUMBER);
                dha_detail.setNAMES(NAMES);
                dha_detail.setSURNAME(SURNAME);
                dha_detail.setDOB(DOB);
                ArlDHA_Detail.add(dha_detail);
                return "";
            }
        } catch (Throwable err) {
            // Dialog.show("Scan ID error i", err.toString(), "OK", null);
            if ("java.lang.Arr".equals(err.toString().substring(0, 13))) {
                Dialog.show("Scan ID ", "The Document scaned does not contain a vaild ID Number. Please contact DHA or rescan the document", "OK", null);
                return "Error";
            }
            return "Error";
        }
        return "Error";
    }

    private static InputStreamReader convertStringtoInputStreamReader(String data) {

        byte[] resultByte = data.getBytes();
        ByteArrayInputStream bis = new ByteArrayInputStream(resultByte);
        InputStreamReader is = new InputStreamReader(bis);
        return is;

    }

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
                + "          <cipc:sUserName>" + Const.sUserName + "</cipc:sUserName>\n"
                + "\n"
                + "          <cipc:sPassword> " + Const.sPassword + "</cipc:sPassword>\n"
                + "\n"
                + "          <cipc:sBankID>" + Const.sBankID + "</cipc:sBankID>\n"
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

        httpRequest.setUrl(Constants.soapServicesEndPoint + "enterprise.asmx");
        httpRequest.addRequestHeader("Content-Type", "text/xml; charset=utf-8");
        httpRequest.addRequestHeader("Content-Length", SOAP_BODY.length() + "");
        httpRequest.setPost(true);

        InfiniteProgress prog = new InfiniteProgress();
        Dialog dlg = prog.showInifiniteBlocking();
        httpRequest.setDisposeOnCompletion(dlg);

        httpRequest.setTimeout(600000);//milli seconds
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
                Element name = (Element) child.getTextChildren(null, true).get(0);
                String elemName = RSM(name.toString());
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

    public void ReservedName(Result result) {
        try {
            XMLParser parser = new XMLParser();
            parser.setCaseSensitive(true);
            Element element = parser.parse(convertStringtoInputStreamReader(result.getAsString("//newdataset")));
            ArlNameReserved = new ArrayList();
            for (int i = 0; i < element.getNumChildren(); i++) {
                Element child = element.getChildAt(i);
                Element elem_error_desc = ((Element) child.getTextChildren(null, true).get(0));
                String error_desc = elem_error_desc.getText();
                Element elem_application_no = ((Element) child.getTextChildren(null, true).get(1));
                String reserved_no = elem_application_no.getText();
                Element elem_approved_name = ((Element) child.getTextChildren(null, true).get(2));
                String approvedname = elem_approved_name.getText();
                NameReserved namereserved = new NameReserved();
                namereserved.setApprovedName(approvedname);
                namereserved.setReserved_NO(reserved_no);
                namereserved.setError_Desc(error_desc);
                ArlNameReserved.add(namereserved);
            }
        } catch (Throwable err) {
            Dialog.show("Change Name", err.toString(), "OK", null);
        }

    }

    public void get_DirectorDetails(Result result) {
        try {
            XMLParser parser = new XMLParser();
            parser.setCaseSensitive(true);
            Element element = parser.parse(convertStringtoInputStreamReader(result.getAsString("//newdataset")));
            ArlDirectorDetails = new ArrayList();
            DirectorDetails directordetails = new DirectorDetails();

            for (int i = 0; i < element.getNumChildren(); i++) {
                Element child = element.getChildAt(i);
                Element elem_ent_no = ((Element) child.getTextChildren(null, true).get(0));
                Element elem_country_code = ((Element) child.getTextChildren(null, true).get(2));
                Element elem_dir_type_code = ((Element) child.getTextChildren(null, true).get(3));
                Element elem_dir_status_code = ((Element) child.getTextChildren(null, true).get(4));
                Element elem_surname = ((Element) child.getTextChildren(null, true).get(5));
                Element elem_first_names = ((Element) child.getTextChildren(null, true).get(6));
                Element elem_initials = ((Element) child.getTextChildren(null, true).get(7));
                Element elem_id_no = ((Element) child.getTextChildren(null, true).get(8));
                Element elem_member_size_int = ((Element) child.getTextChildren(null, true).get(9));
                Element elem_mem_con = ((Element) child.getTextChildren(null, true).get(1));
                Element elem_res_addr1 = ((Element) child.getTextChildren(null, true).get(11));
                Element elem_res_addr2 = ((Element) child.getTextChildren(null, true).get(12));
                Element elem_res_addr3 = ((Element) child.getTextChildren(null, true).get(13));
                Element elem_res_addr4 = ((Element) child.getTextChildren(null, true).get(14));
                Element elem_res_post_code = ((Element) child.getTextChildren(null, true).get(15));
                Element elem_bus_addr1 = ((Element) child.getTextChildren(null, true).get(16));
                Element elem_bus_addr2 = ((Element) child.getTextChildren(null, true).get(17));
                Element elem_bus_addr3 = ((Element) child.getTextChildren(null, true).get(18));
                Element elem_bus_addr4 = ((Element) child.getTextChildren(null, true).get(19));
                Element elem_bus_post_code = ((Element) child.getTextChildren(null, true).get(20));
                Element elem_post_addr1 = ((Element) child.getTextChildren(null, true).get(21));
                Element elem_post_addr2 = ((Element) child.getTextChildren(null, true).get(22));
                Element elem_post_addr3 = ((Element) child.getTextChildren(null, true).get(23));
                Element elem_post_addr4 = ((Element) child.getTextChildren(null, true).get(24));
                Element elem_post_post_code = ((Element) child.getTextChildren(null, true).get(25));
                Element elem_rsa_resident = ((Element) child.getTextChildren(null, true).get(26));
                Element elem_dir_birth_date = ((Element) child.getTextChildren(null, true).get(27));
                Element elem_dir_appoint_date = ((Element) child.getTextChildren(null, true).get(28));
                Element elem_profession = ((Element) child.getTextChildren(null, true).get(29));
                Element elem_cell_no = ((Element) child.getTextChildren(null, true).get(30));
                Element elem_tel_no = ((Element) child.getTextChildren(null, true).get(31));
                Element elem_tel_code = ((Element) child.getTextChildren(null, true).get(32));
                Element elem_fax_no = ((Element) child.getTextChildren(null, true).get(33));
                Element elem_fax_code = ((Element) child.getTextChildren(null, true).get(34));
                Element elem_email_address = ((Element) child.getTextChildren(null, true).get(35));
                String ent_no = elem_ent_no.getText();
                String country_code = elem_country_code.getText();
                String dir_type_code = elem_dir_type_code.getText();
                String dir_status_code = elem_dir_status_code.getText();
                String surname = elem_surname.getText();
                String first_names = elem_first_names.getText();
                String initials = elem_initials.getText();
                String id_no = elem_id_no.getText();
                String member_size_int = elem_member_size_int.getText();
                String mem_con = elem_mem_con.getText();
                String res_addr1 = elem_res_addr1.getText();
                String res_addr2 = elem_res_addr2.getText();
                String res_addr3 = elem_res_addr3.getText();
                String res_addr4 = elem_res_addr4.getText();
                String res_post_code = elem_res_post_code.getText();
                String bus_addr1 = elem_bus_addr1.getText();
                String bus_addr2 = elem_bus_addr2.getText();
                String bus_addr3 = elem_bus_addr3.getText();
                String bus_addr4 = elem_bus_addr4.getText();
                String bus_post_code = elem_bus_post_code.getText();
                String post_addr1 = elem_post_addr1.getText();
                String post_addr2 = elem_post_addr2.getText();
                String post_addr3 = elem_post_addr3.getText();
                String post_addr4 = elem_post_addr4.getText();
                String post_post_code = elem_post_post_code.getText();
                String rsa_resident = elem_rsa_resident.getText();
                String dir_birth_date = elem_dir_birth_date.getText();
                String dir_appoint_date = elem_dir_appoint_date.getText();
                String profession = elem_profession.getText();
                String cell_no = elem_cell_no.getText();
                String tel_no = elem_tel_no.getText();
                String tel_code = elem_tel_code.getText();
                String fax_no = elem_fax_no.getText();
                String fax_code = elem_fax_code.getText();
                String email_address = elem_email_address.getText();

                directordetails.setEnt_no(ent_no);
                directordetails.setCountry_code(country_code);
                directordetails.setDir_type_code(dir_type_code);
                directordetails.setDir_status_code(dir_status_code);
                directordetails.setSurname(surname);
                directordetails.setFirst_names(first_names);
                directordetails.setInitials(initials);
                directordetails.setId_no(id_no);
                directordetails.setMember_size_int(member_size_int);
                directordetails.setMem_con(mem_con);
                directordetails.setRes_addr1(res_addr1);
                directordetails.setRes_addr2(res_addr2);
                directordetails.setRes_addr3(res_addr3);
                directordetails.setRes_addr4(res_addr4);
                directordetails.setRes_post_code(res_post_code);
                directordetails.setBus_addr1(bus_addr1);
                directordetails.setBus_addr2(bus_addr2);
                directordetails.setBus_addr3(bus_addr3);
                directordetails.setBus_addr4(bus_addr4);
                directordetails.setBus_post_code(bus_post_code);
                directordetails.setPost_addr1(post_addr1);
                directordetails.setPost_addr2(post_addr2);
                directordetails.setPost_addr3(post_addr3);
                directordetails.setPost_addr4(post_addr4);
                directordetails.setPost_post_code(post_post_code);
                directordetails.setRsa_resident(rsa_resident);
                directordetails.setDir_birth_date(dir_birth_date);
                directordetails.setDir_appoint_date(dir_appoint_date);
                directordetails.setProfession(profession);
                directordetails.setCell_no(cell_no);
                directordetails.setTel_no(tel_no);
                directordetails.setTel_code(tel_code);
                directordetails.setFax_no(fax_no);
                directordetails.setFax_code(fax_code);
                directordetails.setEmail_address(email_address);
                ArlDirectorDetails.add(directordetails);
            }
        } catch (Throwable err) {
            Dialog.show("Director details error", err.toString(), "OK", null);
        }
    }

    public String RSM_1(String name) {

        name = name.trim();
        name = name.substring(1);
        //name = name.substring(0, name.length() - 1);

//        name = name.trim();
//        name = name.substring(1);
//        name = name.substring(0, name.length() - 1);
        return name;
    }

    public String RSM(String name) {

        name = name.trim();
        name = name.substring(1);
        name = name.substring(0, name.length() - 1);

        name = name.trim();
        name = name.substring(1);
        name = name.substring(0, name.length() - 1);

        return name;
    }
}
