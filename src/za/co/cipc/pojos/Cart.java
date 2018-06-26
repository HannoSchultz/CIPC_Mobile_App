/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.cipc.pojos;

import java.util.ArrayList;

/**
 *
 * @author HanSchultz
 */
public class Cart {

    private String CustomerCode;
    private double AnnualReturnsTotalAmount;
    private double ItemDataTotalAmount;
    private double TotalAmount;
    private double ItemsCount;

    private ArrayList<AnnualReturns> AnnualReturns;
    private ArrayList<CartItems> CartItems;
    private ArrayList<Items> Items;

    public Cart() {
    }

    public String getCustomerCode() {
        return CustomerCode;
    }

    public void setCustomerCode(String CustomerCode) {
        this.CustomerCode = CustomerCode;
    }

    public double getAnnualReturnsTotalAmount() {
        return AnnualReturnsTotalAmount;
    }

    public void setAnnualReturnsTotalAmount(double AnnualReturnsTotalAmount) {
        this.AnnualReturnsTotalAmount = AnnualReturnsTotalAmount;
    }

    public double getItemDataTotalAmount() {
        return ItemDataTotalAmount;
    }

    public void setItemDataTotalAmount(double ItemDataTotalAmount) {
        this.ItemDataTotalAmount = ItemDataTotalAmount;
    }

    public double getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(double TotalAmount) {
        this.TotalAmount = TotalAmount;
    }

    public double getItemsCount() {
        return ItemsCount;
    }

    public void setItemsCount(double ItemsCount) {
        this.ItemsCount = ItemsCount;
    }

    public ArrayList<AnnualReturns> getAnnualReturns() {
        return AnnualReturns;
    }

    public void setAnnualReturns(ArrayList<AnnualReturns> AnnualReturns) {
        this.AnnualReturns = AnnualReturns;
    }

    public ArrayList<CartItems> getCartItems() {
        return CartItems;
    }

    public void setCartItems(ArrayList<CartItems> CartItems) {
        this.CartItems = CartItems;
    }

    public ArrayList<Items> getItems() {
        return Items;
    }

    public void setItems(ArrayList<Items> Items) {
        this.Items = Items;
    }

}
