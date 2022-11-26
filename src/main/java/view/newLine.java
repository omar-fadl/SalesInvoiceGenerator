
package view;

import javax.swing.JTextField;

public class newLine extends javax.swing.JDialog {

    myGui superClass;
    int invName = 1;
    int invCount = 1;
    int invPrice = 1;


    //Creates form  called newLine

    public newLine(myGui superClass) {
        // to be able to inherit the constructor use super
        super(superClass);
        this.superClass = superClass;
        componentsInitiation();
    }



    private void componentsInitiation() {
        Label1 = new javax.swing.JLabel();
        Label1.setText("Item Name");
        itemName = new javax.swing.JTextField();
        Label2 = new javax.swing.JLabel();
        Label2.setText("Price");
        itemPrice = new javax.swing.JTextField();
        Label3 = new javax.swing.JLabel();
        Label3.setText("Count");
        itemCount = new javax.swing.JTextField();
        newItemAdd = new javax.swing.JButton();
        newItemAdd.addActionListener(this.getParent().getHandler());
        newItemAdd.setText("Add");
        newItemAdd.setActionCommand("Add");
        newItemAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newLineOKActionPerformed(evt);
            }
        });
        newItemCancel = new javax.swing.JButton();
        newItemCancel.addActionListener(this.getParent().getHandler());
        newItemCancel.setText("Cancel");
        newItemCancel.setActionCommand("Cancel");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Label2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Label1)
                            .addComponent(Label3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(itemCount, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 82, Short.MAX_VALUE)
                        .addComponent(newItemAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(newItemCancel)
                        .addGap(185, 185, 185))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label1))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label3)
                    .addComponent(itemCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newItemAdd)
                    .addComponent(newItemCancel))
                .addContainerGap(146, Short.MAX_VALUE))
        );

        pack();
    }

    private void newLineOKActionPerformed(java.awt.event.ActionEvent evt) {}
    // components declaration
    private javax.swing.JTextField itemCount;
    private javax.swing.JTextField itemName;
    private javax.swing.JTextField itemPrice;
    private javax.swing.JLabel Label1;
    private javax.swing.JLabel Label2;
    private javax.swing.JLabel Label3;
    private javax.swing.JButton newItemCancel;
    private javax.swing.JButton newItemAdd;
    // End of variables declaration//GEN-END:variables

    public myGui getParent() {
        return superClass;
    }

    public void setSuperClass(myGui superClass) {
        this.superClass = superClass;
    }

    public JTextField getItemCount() {
        return itemCount;
    }

    public void setItemCount(JTextField itemCount) {this.itemCount = itemCount;}

    public JTextField getItemName() {
        return itemName;
    }

    public void setItemName(JTextField itemName) {
        this.itemName = itemName;
    }

    public JTextField getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(JTextField itemPrice) {
        this.itemPrice = itemPrice;
    }

}
