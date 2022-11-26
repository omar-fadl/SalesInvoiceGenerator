
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.invoiceHeader;
import model.invoiceLine;
import view.myGui;
import view.newHeader;
import view.newLine;


public class actionHandler implements ActionListener, ListSelectionListener {

    private myGui gui;
    private newHeader headerDialog;
    private newLine lineDialog;
    private int saveF = 0;

    public actionHandler(myGui gui) {
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "Load File": {
                try {
                    try {
                        loadFile();
                    } catch (ParseException ex) {
                        Logger.getLogger(actionHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(actionHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case "Save File": {
                try {
                    saveF = 0;
                    saveFile();

                } catch (IOException ex) {
                    Logger.getLogger(actionHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;


            case "Create New Invoice":
                getNewInvoice();
                break;
            case "Delete Invoice":
                deleteInvoice();
                break;
            case "Add New Item":
                getNewLine();
                break;
            case "Cancel":
                deleteLine();
                break;
            case "Create": {
                postNewInvoice();
            }
            break;

            case "Cancel ":
                cancelNewHeader();
                break;
            case "Add":

                postNewLine();
                break;
            case "Cancel Line":
                cancelNewLine();
                break;


        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) throws ArrayIndexOutOfBoundsException {
        try {
            int choice = this.gui.getHeadersTable().getSelectedRow();
            if (choice != -1) {
                invoiceHeader selectedInvoiceHeader = this.gui.getHeadList().get(choice);
                ArrayList<invoiceLine> myInvoiceLines = selectedInvoiceHeader.getLines();
                this.gui.setLineList(myInvoiceLines);

                this.gui.getInvoiceID().setText(String.valueOf(selectedInvoiceHeader.getInvoiceNum()));
                this.gui.getInvoiceDate().setText(String.valueOf(selectedInvoiceHeader.getInvoiceDate()));
                this.gui.getInvoiceCust().setText(selectedInvoiceHeader.getCustomerName());
                this.gui.getInvoiceTotal().setText(String.valueOf(selectedInvoiceHeader.getTotalCust()));
            }
        } catch (ArrayIndexOutOfBoundsException exp) {
            JOptionPane.showMessageDialog(this.gui, "plz select a valid  header", "invalid selection", JOptionPane.ERROR_MESSAGE);

        }
    }

    private void saveFile() throws IOException {
        if (saveF == 0)
        {
        if (this.gui.getHeadTableModel() == null ) {
            
                
            JOptionPane.showMessageDialog(this.gui, " plz load a file first  and create new item then save changes", "No thing to save", JOptionPane.ERROR_MESSAGE);

        } else {
            try {

                JFileChooser f = new JFileChooser();
                int choice = f.showSaveDialog(this.gui);
                if (choice == JFileChooser.APPROVE_OPTION) {
                    File headerFile = f.getSelectedFile();
                    if (!".csv".equals((headerFile.toString()).substring((headerFile.toString()).lastIndexOf(".")))) {
                        throw new Exception();
                    }
                    FileWriter fileWriter = new FileWriter(headerFile);
                    ArrayList<invoiceHeader> headersList = this.gui.getHeadList();
                    String saveHeaders = "";
                    String saveLines = "";

                    for (invoiceHeader invoiceHeader : headersList) {
                        saveHeaders += invoiceHeader.toString();
                        saveHeaders += "\n";
                        for (invoiceLine invoiceLine : invoiceHeader.getLines()) {
                            saveLines += invoiceLine.toString();
                            saveLines += "\n";
                        }
                    }
                    choice = f.showSaveDialog(this.gui);
                    if (choice == JFileChooser.APPROVE_OPTION) {
                        File linesFile = f.getSelectedFile();
                        if (!".csv".equals((linesFile.toString()).substring((linesFile.toString()).lastIndexOf(".")))) {
                            throw new Exception();
                        }
                        FileWriter lineWriter = new FileWriter(linesFile);
                        fileWriter.write(saveHeaders);
                        fileWriter.close();
                        lineWriter.write(saveLines);
                        lineWriter.close();
                    }

                }
            } catch (IOException e1) {
                JOptionPane.showMessageDialog(this.gui, "File name with correct format not found", "File not found", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(this.gui, "File format should be .csv", "Incorrect format", JOptionPane.ERROR_MESSAGE);

            }
        }
        }
        else{
        JOptionPane.showMessageDialog(this.gui, "Exiting! Goodbye", "Exit", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    private void loadFile() throws IOException, ParseException {
        try {
            JFileChooser f = new JFileChooser();
            int choice = f.showOpenDialog(this.gui);
            if (choice == JFileChooser.APPROVE_OPTION) {
                File headerFile = f.getSelectedFile();
                if (!".csv".equals((headerFile.toString()).substring((headerFile.toString()).lastIndexOf(".")))) {
                    throw new Exception();
                }
                Path headerPath = Paths.get(headerFile.getAbsolutePath());
                ArrayList<invoiceHeader> headersList = new ArrayList<>();
                List<String> headers = Files.readAllLines(headerPath);

                for (String headerStr : headers) {
                    String[] components = headerStr.split(",");
                    int id = Integer.parseInt(components[0]);
                    Date date = new SimpleDateFormat("dd-MM-yyyy").parse(components[1]);
                    String name = components[2];
                    invoiceHeader temp = new invoiceHeader(id, date, name);
                    headersList.add(temp);

                }
                this.gui.setHeadList(headersList);
                choice = f.showOpenDialog(this.gui);
                if (choice == JFileChooser.APPROVE_OPTION) {
                    File linesFile = f.getSelectedFile();
                    if (!".csv".equals((linesFile.toString()).substring((linesFile.toString()).lastIndexOf(".")))) {
                        throw new Exception();
                    }
                    Path linePath = Paths.get(linesFile.getAbsolutePath());
                    ArrayList<invoiceLine> linesList = new ArrayList<>();
                    List<String> lines = Files.readAllLines(linePath);
                    for (String lineStr : lines) {
                        String[] components = lineStr.split(",");
                        int id = Integer.parseInt(components[0]);
                        String item = components[1];
                        double price = Double.parseDouble(components[2]);
                        int count = Integer.parseInt(components[3]);
                        invoiceHeader tempInvoiceHeader = invoiceHeader.getHeaderByID(headersList, id);
                        invoiceLine myInvoiceLine = new invoiceLine(tempInvoiceHeader, item, price, count);
                        tempInvoiceHeader.getLines().add(myInvoiceLine);
                        linesList.add(myInvoiceLine);
                    }
                    this.gui.setLineList(linesList);

                }
            }
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(this.gui, "File name not found", "File not found", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException e2) {
            JOptionPane.showMessageDialog(this.gui, "Incorrect date format. Date must be 'dd-mm-yyyy'", "Parse Error", JOptionPane.ERROR_MESSAGE);

        } catch (Exception e3) {
            JOptionPane.showMessageDialog(this.gui, "File format should be .csv", "invalid format", JOptionPane.ERROR_MESSAGE);

        }
    }

    private void getNewInvoice() {
        if (this.gui.getHeadTableModel() != null) {
            this.headerDialog = new newHeader(this.gui);
            this.headerDialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this.gui, "Please load a file first", "No data", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void deleteInvoice() {
        if (this.gui.getHeadTableModel() != null) {
            int choice = this.gui.getHeadersTable().getSelectedRow();
            if (choice != -1) {
                ArrayList<invoiceHeader> tempInvoiceHeaderList = new ArrayList<invoiceHeader>();
                this.gui.getHeadList().remove(choice);
                tempInvoiceHeaderList = this.gui.getHeadList();
                this.gui.setHeadList(tempInvoiceHeaderList);
                this.gui.setLineList(new ArrayList<>());
                this.gui.getInvoiceID().setText("");
                this.gui.getInvoiceDate().setText("");
                this.gui.getInvoiceCust().setText("");
                this.gui.getInvoiceTotal().setText("");

            } else {
                JOptionPane.showMessageDialog(this.gui, "Please Select a customer first", "No data", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this.gui, "Please load a file first", "No data", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void getNewLine() {

        if (this.gui.getHeadTableModel() != null) {
            int headerChoice = this.gui.getHeadersTable().getSelectedRow();
            int choice = this.gui.getHeadersTable().getSelectedRow();

            if (headerChoice != -1) {
                if (choice != -1) {
                    this.lineDialog = new newLine(this.gui);
                    this.lineDialog.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this.gui, "PLZ Select a Item first", "No selection", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this.gui, "Plz Select a customer first", "No selection", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this.gui, "PLZ Load file first", "No file selcted", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteLine() {
        if (this.gui.getHeadTableModel() != null) {
            int choice = this.gui.getLinesTable().getSelectedRow();
            int headerChoice = this.gui.getHeadersTable().getSelectedRow();
            if (headerChoice != -1) {
                if (choice != -1) {
                    invoiceLine removedInvoiceLine = this.gui.getLineList().remove(choice);
                    ArrayList<invoiceLine> tempInvoiceLineList = this.gui.getLineList();
                    this.gui.setLineList(tempInvoiceLineList);
                    this.gui.getHeadTableModel().fireTableDataChanged();
                    //this.gui.getHeadersTable().setRowSelectionInterval(choice, choice);
                    this.gui.getLineTableModel().fireTableDataChanged();
                    invoiceHeader invoiceHeader = removedInvoiceLine.getHeader();
                    this.gui.getInvoiceID().setText(String.valueOf(invoiceHeader.getInvoiceNum()));
                    this.gui.getInvoiceDate().setText(String.valueOf(invoiceHeader.getInvoiceDate()));
                    this.gui.getInvoiceCust().setText(invoiceHeader.getCustomerName());
                    this.gui.getInvoiceTotal().setText(String.valueOf(invoiceHeader.getTotalCust()));
                } else {
                    JOptionPane.showMessageDialog(this.gui, "PLZ Select a item first", "No slection", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this.gui, "PLZ Select a customer first", "No selction", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this.gui, "PLZ Load file  first", "No file slected", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void postNewInvoice() {

        int id = Integer.parseInt(this.headerDialog.getInvoiceID().getText());
        String name = this.headerDialog.getInvoiceCust().getText();

        if (id < 0) {
            JOptionPane.showMessageDialog(this.gui, "Invoice num must not be negative number PLZ enter a valid id", "Invalid invoice id", JOptionPane.ERROR_MESSAGE);
            cancelNewHeader();
        } else if ((invoiceHeader.getHeaderByID(this.gui.getHeadList(), id)) != null) {
            JOptionPane.showMessageDialog(this.gui, "this Invoice num  is already exist", "Repetition id", JOptionPane.ERROR_MESSAGE);
            cancelNewHeader();
        } else if ("".equals(name)) {
            JOptionPane.showMessageDialog(this.gui, " name of Customer can not be  empty", "Invalid Customer name", JOptionPane.ERROR_MESSAGE);
            cancelNewHeader();
        } else {
            try {
                Date date = new SimpleDateFormat("dd-MM-yyyy").parse(this.headerDialog.getInvoiceDate().getText());
                invoiceHeader invoiceHeader = new invoiceHeader(id, date, name);
                this.gui.getHeadList().add(invoiceHeader);
                this.gui.setHeadList(this.gui.getHeadList());
            } catch (ParseException exp) {
                JOptionPane.showMessageDialog(this.gui, "It is a Wrong date format. Date format must be 'dd-mm-yyyy'", "data format Error", JOptionPane.ERROR_MESSAGE);
                cancelNewHeader();

            }
            cancelNewHeader();
        }

    }

    private void cancelNewHeader() {
        this.headerDialog.setVisible(false);
        this.headerDialog.dispose();
        this.headerDialog = null;
    }

    private void postNewLine() {
        int billId = 0;
        int choice = this.gui.getHeadersTable().getSelectedRow();
        if (choice != -1) {
            invoiceHeader selectedInvoiceHeader = this.gui.getHeadList().get(choice);
            for (invoiceLine invoiceLine : selectedInvoiceHeader.getLines()) {
                if (invoiceLine.getBillId() > billId) {
                    billId = invoiceLine.getBillId();
                }
            }
            billId++;
            String name = this.lineDialog.getItemName().getText();
            int count = Integer.parseInt(this.lineDialog.getItemCount().getText());
            double price = Double.parseDouble(this.lineDialog.getItemPrice().getText());

            if ("".equals(name)) {
                JOptionPane.showMessageDialog(this.gui, "Item name can not be  empty", "Invalid item name", JOptionPane.ERROR_MESSAGE);
                cancelNewLine();
            } else if (count <= 0) {
                JOptionPane.showMessageDialog(this.gui, "Count can not be negative PLZ enter postive number  ", "Invalid count", JOptionPane.ERROR_MESSAGE);
                cancelNewLine();

            } else if (price <= 0) {
                JOptionPane.showMessageDialog(this.gui, "Price should be greater than 0", "Invalid price", JOptionPane.ERROR_MESSAGE);
                cancelNewLine();

            } else {
                invoiceLine invoiceLine = new invoiceLine(selectedInvoiceHeader, name, price, count);
                this.gui.getLineList().add(invoiceLine);
                this.gui.setLineList(this.gui.getLineList());
                this.gui.getHeadTableModel().fireTableDataChanged();
                this.gui.getInvoiceID().setText(String.valueOf(selectedInvoiceHeader.getInvoiceNum()));
                this.gui.getInvoiceDate().setText(String.valueOf(selectedInvoiceHeader.getInvoiceDate()));
                this.gui.getInvoiceCust().setText(selectedInvoiceHeader.getCustomerName());
                this.gui.getInvoiceTotal().setText(String.valueOf(selectedInvoiceHeader.getTotalCust()));
                cancelNewLine();
            }
        }

    }

    private void cancelNewLine() {
        this.lineDialog.setVisible(false);
        this.lineDialog.dispose();
        this.lineDialog = null;
    }

}
