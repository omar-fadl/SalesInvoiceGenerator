
package model;


public class invoiceLine {

    private invoiceHeader invoiceHeader;
    private int billId;
    private String itemName;
    private double itemPrice;
    private int count;

    public invoiceLine(invoiceHeader invoiceHeader, String itemName, double itemPrice, int count) {
        this.invoiceHeader = invoiceHeader;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.count = count;
    }

    public invoiceHeader getHeader() {
        return invoiceHeader;
    }

    public void setHeader(invoiceHeader invoiceHeader) {
        this.invoiceHeader = invoiceHeader;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {

        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getTotal() {
        return this.itemPrice * this.count;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    @Override
    public String toString() {
        return this.getHeader().getInvoiceNum() + " " + this.getItemName() + " " + this.getItemPrice() + " " + this.getCount();

    }

}
