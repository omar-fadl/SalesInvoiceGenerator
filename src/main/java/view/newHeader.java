
package view;

import javax.swing.JTextField;


public class newHeader extends javax.swing.JDialog {

    myGui superClass;


    public newHeader(myGui superClass) {
        super(superClass);
        this.superClass = superClass;
        componentsInitiation();
    }



// this method to initiate components
    private void componentsInitiation() {

        Label1 = new javax.swing.JLabel();
        Label1.setText("Invoice Number");
        Label2 = new javax.swing.JLabel();
        Label2.setText("Invoice Date");
        Label3 = new javax.swing.JLabel();
        Label3.setText("Customer Name");
        newInvoiceCreate = new javax.swing.JButton();
        newInvoiceCreate.addActionListener(this.getParent().getHandler());
        newInvoiceCreate.setText("Create");
        newInvoiceCreate.setActionCommand("Create");
        newInvoiceCancel = new javax.swing.JButton();
        newInvoiceCancel.addActionListener(this.getParent().getHandler());
        newInvoiceCancel.setText("Cancel");
        newInvoiceCancel.setActionCommand("Cancel");
        newInvoiceCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {newHeaderCancelActionPerformed(evt);}
        });
        invoiceID = new javax.swing.JTextField();
        invoiceDate = new javax.swing.JTextField();
        invoiceCust = new javax.swing.JTextField();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Label2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(newInvoiceCreate)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(Label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(newInvoiceCancel))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(invoiceCust, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(invoiceDate, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                        .addComponent(invoiceID)))))))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label1)
                    .addComponent(invoiceID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label2)
                    .addComponent(invoiceDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Label3)
                    .addComponent(invoiceCust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newInvoiceCreate)
                    .addComponent(newInvoiceCancel))
                .addContainerGap(157, Short.MAX_VALUE))
        );

        pack();
    }

    private void newHeaderCancelActionPerformed(java.awt.event.ActionEvent evt) {}


    // Componenet declaration
    private javax.swing.JTextField invoiceCust;
    private javax.swing.JTextField invoiceDate;
    private javax.swing.JTextField invoiceID;
    private javax.swing.JLabel Label1;
    private javax.swing.JLabel Label2;
    private javax.swing.JLabel Label3;
    private javax.swing.JButton newInvoiceCancel;
    private javax.swing.JButton newInvoiceCreate;


    @Override
    public myGui getParent() {
        return superClass;
    }

    public void setSuperClass(myGui superClass) {
        this.superClass = superClass;
    }

    public JTextField getInvoiceCust() {
        return invoiceCust;
    }

    public void setInvoiceCust(JTextField invoiceCust) {
        this.invoiceCust = invoiceCust;
    }

    public JTextField getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(JTextField invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public JTextField getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(JTextField invoiceID) {
        this.invoiceID = invoiceID;
    }

}
