
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class headerTable extends AbstractTableModel {

    private ArrayList<invoiceHeader> invoiceHeaderList;

    private String[] headAttributes = {"ID", "Date", "Customer", "Total"};

    public headerTable(ArrayList<invoiceHeader> invoiceHeaderList) {
        this.invoiceHeaderList = invoiceHeaderList;
    }

    public ArrayList<invoiceHeader> getHeaderList() {
        return invoiceHeaderList;
    }

    public void setHeaderList(ArrayList<invoiceHeader> invoiceHeaderList) {
        this.invoiceHeaderList = invoiceHeaderList;
    }

    @Override
    public int getRowCount() {
        return this.invoiceHeaderList.size();
    }

    @Override
    public int getColumnCount() {
        return this.headAttributes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        invoiceHeader invoiceHeader = this.invoiceHeaderList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return invoiceHeader.getInvoiceNum();
            case 1:
                return invoiceHeader.getInvoiceDate();
            case 2:
                return invoiceHeader.getCustomerName();
            case 3:
                return invoiceHeader.getTotalCust();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Date";
            case 2:
                return "Customer";
            case 3:
                return "Total";
        }
        return "";
    }
}
