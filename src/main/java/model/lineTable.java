
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class lineTable extends AbstractTableModel {

    private ArrayList<invoiceLine> invoiceLineList;

    private String[] itemsAtttibutes = {"ID", "Item", "Price", "Count", "Total"};

    public lineTable(ArrayList<invoiceLine> invoiceLineList) {
        this.invoiceLineList = invoiceLineList;
    }

    public ArrayList<invoiceLine> getLineList() {
        return invoiceLineList;
    }

    public void setLineList(ArrayList<invoiceLine> invoiceLineList) {
        this.invoiceLineList = invoiceLineList;
    }

    @Override
    public int getRowCount() {
        return this.invoiceLineList.size();
    }

    @Override
    public int getColumnCount() {
        return this.itemsAtttibutes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        invoiceLine invoiceLine = this.invoiceLineList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return invoiceLine.getItemName();
            case 2:
                return invoiceLine.getItemPrice();
            case 3:
                return invoiceLine.getCount();
            case 4:
                return invoiceLine.getTotal();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Item";
            case 2:
                return "Price";
            case 3:
                return "Count";
            case 4:
                return "Total";
        }
        return "";
    }
}
