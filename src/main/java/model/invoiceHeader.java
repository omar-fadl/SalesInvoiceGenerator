
package model;

import java.util.ArrayList;
import java.util.Date;


public class invoiceHeader {

    private int invoiceNum;
    private Date InvoiceDate;
    private String customerName;
    private double totalCust;
    private ArrayList<invoiceLine> items;

    public invoiceHeader(int invoiceNum, Date InvoiceDate, String customerName) {
        this.invoiceNum = invoiceNum;
        this.InvoiceDate = InvoiceDate;
        this.customerName = customerName;
    }

    public static invoiceHeader getHeaderByID(ArrayList<invoiceHeader> list, int id) {
        for (invoiceHeader temp : list) {
            if (temp.getInvoiceNum() == id) {
                return temp;
            }
        }
        return null;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(int invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public Date getInvoiceDate() {
        return InvoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.InvoiceDate = invoiceDate;
    }

    public double getTotalCust() {
        totalCust = 0;
        for (invoiceLine l : this.getLines()) {
            totalCust += l.getTotal();
        }

        return totalCust;
    }

    public void setTotalCust(double totalCust) {
        this.totalCust = totalCust;
    }

    public ArrayList<invoiceLine> getLines() {
        if (this.items == null) {
            items = new ArrayList<invoiceLine>();
        }
        return items;
    }

    public void setLItems(ArrayList<invoiceLine> invoiceLines) {
        this.items = invoiceLines;
    }

    @Override
    public String toString() {
        return this.getInvoiceNum() + " " + this.getInvoiceDate() + " " + this.getCustomerName();

    }

}
