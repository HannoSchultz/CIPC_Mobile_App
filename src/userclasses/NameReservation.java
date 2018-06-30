/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userclasses;

import java.util.Date;

/**
 *
 * @author Blessing
 */
public class NameReservation {

    private int ReferenceNumber;
    private String StatusDate;
    private String CustomerCode;
    private double Amount;
    private double TotalAmount;
    private String responseMessage;

    public int getReferenceNumber() {
        return ReferenceNumber;
    }

    public void setReferenceNumber(int ReferenceNumber) {
        this.ReferenceNumber = ReferenceNumber;
    }

    public String getStatusDate() {
        return StatusDate;
    }

    public void setStatusDate(String StatusDate) {
        this.StatusDate = StatusDate;
    }

    public String getCustomerCode() {
        return CustomerCode;
    }

    public void setCustomerCode(String CustomerCode) {
        this.CustomerCode = CustomerCode;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }

    public double getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(double TotalAmount) {
        this.TotalAmount = TotalAmount;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

}
