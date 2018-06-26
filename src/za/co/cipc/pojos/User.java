/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.cipc.pojos;

/**
 *
 * @author Blessing
 */
public class User {

    String sUserName;
    String sPassword;
    String sBankID;
    String sCustID;
    String agent_code;
    String agent_type;
    String password;
    String agent_name;
    String tel_code;
    String tel_no;
    String fax_code;
    String fax_no;
    String phys_addr1;
    String phys_addr2;
    String phys_addr3;
    String phys_addr4;
    String phys_code;
    String post_addr1;
    String post_addr2;
    String post_addr3;
    String post_addr4;
    String post_code;
    String email;
    String docex;
    String corresp_code;
    String comm_code;
    String deliv_code;
    String modify_date;
    String balance;
    String status;
    String current_login;
    String previous_login;
    String id_type;
    String agent_id_no;
    String registration_no;
    String cell_no;
    String sms;
    String status_desc;
    private String first_name;
    private String last_name;

    String paramCustomerCode;
    String paramPassword;

    public User() {
    }

    public User(String sUserName, String sPassword, String sBankID) {
        this.sUserName = sUserName;
        this.sPassword = sPassword;
        this.sBankID = sBankID;
    }

    public String getsUserName() {
        return sUserName;
    }

    public void setsUserName(String sUserName) {
        this.sUserName = sUserName;
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }

    public String getsBankID() {
        return sBankID;
    }

    public void setsBankID(String sBankID) {
        this.sBankID = sBankID;
    }

    public String getsCustID() {
        return sCustID;
    }

    public void setsCustID(String sCustID) {
        this.sCustID = sCustID;
    }

    public String getAgent_code() {
        return agent_code;
    }

    public void setAgent_code(String agent_code) {
        this.agent_code = agent_code;
    }

    public String getAgent_type() {
        return agent_type;
    }

    public void setAgent_type(String agent_type) {
        this.agent_type = agent_type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAgent_name() {
        return agent_name;
    }

    public void setAgent_name(String agent_name) {
        this.agent_name = agent_name;
    }

    public String getTel_code() {
        return tel_code;
    }

    public void setTel_code(String tel_code) {
        this.tel_code = tel_code;
    }

    public String getTel_no() {
        return tel_no;
    }

    public void setTel_no(String tel_no) {
        this.tel_no = tel_no;
    }

    public String getFax_code() {
        return fax_code;
    }

    public void setFax_code(String fax_code) {
        this.fax_code = fax_code;
    }

    public String getFax_no() {
        return fax_no;
    }

    public void setFax_no(String fax_no) {
        this.fax_no = fax_no;
    }

    public String getPhys_addr1() {
        return phys_addr1;
    }

    public void setPhys_addr1(String phys_addr1) {
        this.phys_addr1 = phys_addr1;
    }

    public String getPhys_addr2() {
        return phys_addr2;
    }

    public void setPhys_addr2(String phys_addr2) {
        this.phys_addr2 = phys_addr2;
    }

    public String getPhys_addr3() {
        return phys_addr3;
    }

    public void setPhys_addr3(String phys_addr3) {
        this.phys_addr3 = phys_addr3;
    }

    public String getPhys_addr4() {
        return phys_addr4;
    }

    public void setPhys_addr4(String phys_addr4) {
        this.phys_addr4 = phys_addr4;
    }

    public String getPhys_code() {
        return phys_code;
    }

    public void setPhys_code(String phys_code) {
        this.phys_code = phys_code;
    }

    public String getPost_addr1() {
        return post_addr1;
    }

    public void setPost_addr1(String post_addr1) {
        this.post_addr1 = post_addr1;
    }

    public String getPost_addr2() {
        return post_addr2;
    }

    public void setPost_addr2(String post_addr2) {
        this.post_addr2 = post_addr2;
    }

    public String getPost_addr3() {
        return post_addr3;
    }

    public void setPost_addr3(String post_addr3) {
        this.post_addr3 = post_addr3;
    }

    public String getPost_addr4() {
        return post_addr4;
    }

    public void setPost_addr4(String post_addr4) {
        this.post_addr4 = post_addr4;
    }

    public String getPost_code() {
        return post_code;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocex() {
        return docex;
    }

    public void setDocex(String docex) {
        this.docex = docex;
    }

    public String getCorresp_code() {
        return corresp_code;
    }

    public void setCorresp_code(String corresp_code) {
        this.corresp_code = corresp_code;
    }

    public String getComm_code() {
        return comm_code;
    }

    public void setComm_code(String comm_code) {
        this.comm_code = comm_code;
    }

    public String getDeliv_code() {
        return deliv_code;
    }

    public void setDeliv_code(String deliv_code) {
        this.deliv_code = deliv_code;
    }

    public String getModify_date() {
        return modify_date;
    }

    public void setModify_date(String modify_date) {
        this.modify_date = modify_date;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrent_login() {
        return current_login;
    }

    public void setCurrent_login(String current_login) {
        this.current_login = current_login;
    }

    public String getPrevious_login() {
        return previous_login;
    }

    public void setPrevious_login(String previous_login) {
        this.previous_login = previous_login;
    }

    public String getId_type() {
        return id_type;
    }

    public void setId_type(String id_type) {
        this.id_type = id_type;
    }

    public String getAgent_id_no() {
        return agent_id_no;
    }

    public void setAgent_id_no(String agent_id_no) {
        this.agent_id_no = agent_id_no;
    }

    public String getRegistration_no() {
        return registration_no;
    }

    public void setRegistration_no(String registration_no) {
        this.registration_no = registration_no;
    }

    public String getCell_no() {
        return cell_no;
    }

    public void setCell_no(String cell_no) {
        this.cell_no = cell_no;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public String getStatus_desc() {
        return status_desc;
    }

    public void setStatus_desc(String status_desc) {
        this.status_desc = status_desc;
    }

    public String getParamCustomerCode() {
        return paramCustomerCode;
    }

    public void setParamCustomerCode(String paramCustomerCode) {
        this.paramCustomerCode = paramCustomerCode;
    }

    public String getParamPassword() {
        return paramPassword;
    }

    public void setParamPassword(String paramPassword) {
        this.paramPassword = paramPassword;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

}
