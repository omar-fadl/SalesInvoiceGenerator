
package view;
import model.invoiceHeader;
import model.headerTable;
import model.invoiceLine;
import model.lineTable;
import controller.actionHandler;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;


// create class myGui that inherit from jFrame class
public class myGui extends javax.swing.JFrame {

    private actionHandler handler;
    private ArrayList<invoiceHeader> headList;
    private headerTable headTableModel;
    private ArrayList<invoiceLine> invoiceLineList;
    private lineTable lineTableModel;
    private myGui frame;


     // Create new form called myGUI
//here I create constructor from class myGui
    public myGui() {
        handler = new actionHandler(this);
        
        componentsInitiation();
    }



// here I create method called componentsInitiation to intiate component of frame;
    private void componentsInitiation() {

        ScrollPane1 = new javax.swing.JScrollPane();
        headersTable = new javax.swing.JTable();
        headersTable.getSelectionModel().addListSelectionListener(this.handler);
        createNewInvoiceBtn = new javax.swing.JButton();
        createNewInvoiceBtn.addActionListener(this.handler);
        deleteInvoiceBtn = new javax.swing.JButton();
        deleteInvoiceBtn.addActionListener(this.handler);
        Label1 = new javax.swing.JLabel();
        Label2 = new javax.swing.JLabel();
        Label3 = new javax.swing.JLabel();
        Label4 = new javax.swing.JLabel();
        ScrollPane2 = new javax.swing.JScrollPane();
        linesTable = new javax.swing.JTable();
        addNewItemBtn = new javax.swing.JButton();
        addNewItemBtn.addActionListener(this.handler);
        deleteItemBtn = new javax.swing.JButton();
        deleteItemBtn.addActionListener(this.handler);
        invoiceID = new javax.swing.JTextField();
        invoiceDate = new javax.swing.JTextField();
        invoiceCust = new javax.swing.JTextField();
        invoiceTotal = new javax.swing.JTextField();
        Label5 = new javax.swing.JLabel();
        Label6 = new javax.swing.JLabel();
        MenuBar1 = new javax.swing.JMenuBar();
        Menu1 = new javax.swing.JMenu();
        loadFile = new javax.swing.JMenuItem();
        loadFile.addActionListener(this.handler);
        saveFile = new javax.swing.JMenuItem();
        saveFile.addActionListener(this.handler);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);//to close fram when press x button
        setTitle("Sales Invoice");//fram name that appear in the top of frame
        setBackground(new java.awt.Color(204, 204, 204));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        headersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "No.", "Date", "Customer", "Total"
            }
        ));
        ScrollPane1.setViewportView(headersTable);

        createNewInvoiceBtn.setText("Create New Invoice");
        createNewInvoiceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newHeaderbtnActionPerformed(evt);
            }
        });

        deleteInvoiceBtn.setText("Delete Invoice");

        Label1.setText("Invoice Number");

        Label2.setText("Invoice Date");

        Label3.setText("Customer Name");

        Label4.setText("Invoice Total");

        linesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Item Name", "Item Price", "Count", "Item Total"
            }
        ));
        linesTable.setRowMargin(1);

        ScrollPane2.setViewportView(linesTable);

        addNewItemBtn.setText("Add New Item");
        addNewItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newLineBtnActionPerformed(evt);
            }
        });

        deleteItemBtn.setText("Cancel");

        Label5.setText("Invoice Items");

        Label6.setText("Invoice Table");

        Menu1.setText("File");

        loadFile.setText("Load File");
        loadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadFileActionPerformed(evt);
            }
        });
        Menu1.add(loadFile);

        saveFile.setText("Save File");
        Menu1.addSeparator();
        Menu1.add(saveFile);

        MenuBar1.add(Menu1);

        setJMenuBar(MenuBar1);

        javax.swing.GroupLayout firstLayout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(firstLayout);
        firstLayout.setHorizontalGroup(
            firstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(firstLayout.createSequentialGroup()
                .addGroup(firstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(firstLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(Label6)))
                .addGap(18, 18, 18)
                .addGroup(firstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(firstLayout.createSequentialGroup()
                        .addGroup(firstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Label3, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(Label2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(firstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Label5)
                                .addComponent(Label4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(firstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, firstLayout.createSequentialGroup()
                                .addGroup(firstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(invoiceCust, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(invoiceDate))
                                .addContainerGap())
                            .addGroup(firstLayout.createSequentialGroup()
                                .addGroup(firstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(invoiceID, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(invoiceTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(firstLayout.createSequentialGroup()
                        .addComponent(ScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(firstLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(createNewInvoiceBtn)
                .addGap(39, 39, 39)
                .addComponent(deleteInvoiceBtn)
                .addGap(142, 142, 142)
                .addComponent(addNewItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(deleteItemBtn)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        firstLayout.setVerticalGroup(
            firstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(firstLayout.createSequentialGroup()
                .addGroup(firstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(firstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Label1)
                        .addComponent(invoiceID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Label6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(firstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(firstLayout.createSequentialGroup()
                        .addGroup(firstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Label2)
                            .addComponent(invoiceDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(firstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Label3)
                            .addComponent(invoiceCust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(firstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(invoiceTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Label4)))
                    .addComponent(ScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(Label5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addGroup(firstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createNewInvoiceBtn)
                    .addComponent(deleteInvoiceBtn)
                    .addComponent(addNewItemBtn)
                    .addComponent(deleteItemBtn))
                .addGap(60, 60, 60))
        );

        pack();
    }
    private void loadFileActionPerformed(java.awt.event.ActionEvent evt) {}
    private void newLineBtnActionPerformed(java.awt.event.ActionEvent evt) {}
    private void formWindowClosing(java.awt.event.WindowEvent evt) {}
    private void newHeaderbtnActionPerformed(java.awt.event.ActionEvent evt) {}



    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                myGui frame = new myGui();
                frame.setVisible(true);

                
             
    
            }
        });
    }

    // components declaration
    private javax.swing.JMenuBar MenuBar1;
    private javax.swing.JMenu Menu1;
    private javax.swing.JMenuItem loadFile;
    private javax.swing.JMenuItem saveFile;
    private javax.swing.JButton createNewInvoiceBtn;
    private javax.swing.JButton deleteInvoiceBtn;
    private javax.swing.JButton addNewItemBtn;
    private javax.swing.JButton deleteItemBtn;
    private javax.swing.JTextField invoiceCust;
    private javax.swing.JTextField invoiceDate;
    private javax.swing.JTextField invoiceID;
    private javax.swing.JTextField invoiceTotal;
    private javax.swing.JTable headersTable;
    private javax.swing.JTable linesTable;
    private javax.swing.JLabel Label1;
    private javax.swing.JLabel Label2;
    private javax.swing.JLabel Label3;
    private javax.swing.JLabel Label4;
    private javax.swing.JLabel Label5;
    private javax.swing.JLabel Label6;

    private javax.swing.JScrollPane ScrollPane1;
    private javax.swing.JScrollPane ScrollPane2;
 
    
     


    public ArrayList<invoiceHeader> getHeadList() {
        try {
            if (headList == null) {
                throw new Exception();
            }
        } catch (Exception exp) {
            JOptionPane.showMessageDialog(this, "Plz load a file first to be able to create new invoice", "No file ", JOptionPane.CLOSED_OPTION);

        }
        return headList;
    }
    public actionHandler getHandler() {
        return handler;
    }

    public void setHandler(actionHandler handler) {
        this.handler = handler;
    }
    public ArrayList<invoiceLine> getLineList() {

        try {
            if (headList == null) {
                throw new Exception();
            }
        } catch (Exception exp) {
            JOptionPane.showMessageDialog(this, "Plz select a customer invoice  first", "No invoice ", JOptionPane.CLOSED_OPTION);

        }
        return invoiceLineList;
    }
    public void setHeadersTable(JTable headersTable) {
        this.headersTable = headersTable;
    }
    public void setHeadList(ArrayList<invoiceHeader> headList) {
        this.headList = headList;
        this.headTableModel = new headerTable(this.headList);
        this.headTableModel.fireTableDataChanged();
        this.headersTable.setModel(headTableModel);
    }
    public void setLineList(ArrayList<invoiceLine> invoiceLineList) {
        this.invoiceLineList = invoiceLineList;
        this.lineTableModel = new lineTable(this.invoiceLineList);
        this.lineTableModel.fireTableDataChanged();
        this.linesTable.setModel(lineTableModel);
    }

    public JTable getHeadersTable() {
        return headersTable;
    }
    public JTextField getInvoiceCust() {
        return invoiceCust;
    }
    public JTextField getInvoiceID() {
        return invoiceID;
    }
    public JTextField getInvoiceTotal() {
        return invoiceTotal;
    }
    public headerTable getHeadTableModel() {
        return headTableModel;
    }
    public JTable getLinesTable() {
        return linesTable;
    }
    public void setLineTableModel(lineTable lineTableModel) {
        this.lineTableModel = lineTableModel;
    }
    public void setLinesTable(JTable linesTable) {
        this.linesTable = linesTable;
    }
    public void setHeadTableModel(headerTable headTableModel) {
        this.headTableModel = headTableModel;
    }
    public JTextField getInvoiceDate() {
        return invoiceDate;
    }
    public lineTable getLineTableModel() {
        return lineTableModel;
    }



}
