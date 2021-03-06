/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package my.cafe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nural
 */
public class menu extends javax.swing.JFrame {
    popUpDrink popupdrink = null;
    popUpFood popupfood = null;
    DefaultTableModel model;
    /**
     * Creates new form menu
     */
    
    
    public menu(String username) {
        initComponents();
        
        tUsername.setText(username);
        tUsername.setEditable(false);
        tTC.setEditable(false);
        tTotal.setEditable(false);
        tPrice.setEditable(false);
        tItemName.setEditable(false);
        id_auto();
        
        String [] judul ={"Transaction Code","Username","Item","Price","QTY","Total"};
        model = new DefaultTableModel(judul,0);
        tblOrdered.setModel(model);
        
    }
    
    public void id_auto() {
        
        try {
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/mycafe","root","");
            Statement stat = koneksi.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM tbtransaction order by transactioncode desc");
            if  (rs.next()) {
                String kode = rs.getString("transactioncode").substring(1);
                String AN = "" +(Integer.parseInt(kode) + 1);
                String Nol = "";
                
                if(AN.length()==1) 
                {Nol = "00";}
                else if (AN.length()==2)
                {Nol = "0";}
                else if (AN.length()==3) 
                {Nol = "";}
                
                tTC.setText("TC" + Nol + AN);
                
            } else {
                tTC.setText("TC001");
            }
        } catch (Exception e) {
        }
        
    }
        
    public void order() {
        
        model.addRow(new Object[]{tTC.getText(),tUsername.getText(),tItemName.getText(),tPrice.getText(),tQty.getText(),tTotal.getText()});
    
    }
    
    public void pay() {
    
        int total = Integer.parseInt(tTotalPrice.getText());
        int money = Integer.parseInt(tMoney.getText());
        int sum;
        
        if(total > money ) {
            JOptionPane.showMessageDialog(null, "Uang Anda Kurang");
        } else if(total == money){
            sum = money - total;
            tMoneyBack.setText(String.valueOf(sum));
            
            tItemName.setText("");
            tPrice.setText("");
            tQty.setText("");
            tTotal.setText("");
            
            JOptionPane.showMessageDialog(null, "Pembayaran Berhasil");
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnBack = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        tTC = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tItemName = new javax.swing.JTextField();
        tPrice = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tQty = new javax.swing.JTextField();
        btnDrink = new javax.swing.JToggleButton();
        btnOrder = new javax.swing.JToggleButton();
        btnFood = new javax.swing.JToggleButton();
        jLabel7 = new javax.swing.JLabel();
        tTotal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JToggleButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrdered = new javax.swing.JTable();
        btnReset = new javax.swing.JToggleButton();
        jLabel6 = new javax.swing.JLabel();
        tMoney = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tTotalPrice = new javax.swing.JTextField();
        btnSave = new javax.swing.JToggleButton();
        jLabel9 = new javax.swing.JLabel();
        tMoneyBack = new javax.swing.JTextField();
        btnPay = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        btnBack.setBackground(new java.awt.Color(102, 255, 102));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(720, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 780));

        jPanel3.setBackground(new java.awt.Color(253, 203, 110));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(tTC, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 158, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("USERNAME");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, -1, -1));
        jPanel3.add(tUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 158, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ITEM NAME");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, -1, -1));
        jPanel3.add(tItemName, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 80, 158, -1));
        jPanel3.add(tPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 158, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PRICE");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, -1, -1));
        jPanel3.add(tQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 140, 158, -1));

        btnDrink.setBackground(new java.awt.Color(102, 255, 102));
        btnDrink.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDrink.setForeground(new java.awt.Color(255, 255, 255));
        btnDrink.setText("DRINK");
        btnDrink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDrinkActionPerformed(evt);
            }
        });
        jPanel3.add(btnDrink, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 120, -1));

        btnOrder.setBackground(new java.awt.Color(102, 255, 102));
        btnOrder.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnOrder.setText("ORDER");
        btnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderActionPerformed(evt);
            }
        });
        jPanel3.add(btnOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 210, -1, -1));

        btnFood.setBackground(new java.awt.Color(102, 255, 102));
        btnFood.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnFood.setForeground(new java.awt.Color(255, 255, 255));
        btnFood.setText("FOOD");
        btnFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFoodActionPerformed(evt);
            }
        });
        jPanel3.add(btnFood, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 120, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("TOTAL");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, -1, -1));

        tTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tTotalKeyTyped(evt);
            }
        });
        jPanel3.add(tTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, 158, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("QUANTITY");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("TRANSACTION CODE");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, -1));

        btnCancel.setBackground(new java.awt.Color(102, 255, 102));
        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("CANCEL");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/food.jpg"))); // NOI18N
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/drink.jpg"))); // NOI18N
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 790, 250));

        jPanel4.setBackground(new java.awt.Color(255, 153, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ORDERED MENUS :");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 790, 40));

        jPanel5.setBackground(new java.awt.Color(253, 203, 110));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblOrdered.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblOrdered.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrderedMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblOrdered);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 16, 450, 233));

        btnReset.setBackground(new java.awt.Color(102, 255, 102));
        btnReset.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("RESET");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel5.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("MONEY");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, -1, -1));
        jPanel5.add(tMoney, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 190, 140, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("TOTAL PRICE");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, -1, -1));
        jPanel5.add(tTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 230, 140, -1));

        btnSave.setBackground(new java.awt.Color(102, 255, 102));
        btnSave.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel5.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 270, 90, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("MONEY BACK");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, -1, -1));
        jPanel5.add(tMoneyBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, 140, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, 790, 320));

        btnPay.setBackground(new java.awt.Color(102, 255, 102));
        btnPay.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnPay.setForeground(new java.awt.Color(255, 255, 255));
        btnPay.setText("PAY");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });
        jPanel1.add(btnPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 720, 80, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MY CAFE");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 780));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFoodActionPerformed
        // TODO add your handling code here:
        
        popUpFood popupfood = new popUpFood();        
        popupfood.Menu = this;
        popupfood.setVisible(true);
        
    }//GEN-LAST:event_btnFoodActionPerformed

    private void btnDrinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDrinkActionPerformed
        // TODO add your handling code here:
        
        popUpDrink popupdrink = new popUpDrink();        
        popupdrink.Menu = this;
        popupdrink.setVisible(true);
        
    }//GEN-LAST:event_btnDrinkActionPerformed

    private void tTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tTotalKeyTyped
        // TODO add your handling code here:
        
        int price =Integer.parseInt(tPrice.getText());
        int qty =Integer.parseInt(tQty.getText());  
        tTotal.setText(""+price*qty);
        
    }//GEN-LAST:event_tTotalKeyTyped
    
    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderActionPerformed
        // TODO add your handling code here:
        int sum;
        if(tTC.getText().equals("")){
                Random rand = new Random();
                int acak = rand.nextInt();
                String acak1 = Integer.toString(acak);
                tTC.setText(acak1);
        
        }
        if (tItemName.getText().equals("")|| tPrice.getText().equals("")|| tQty.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Masukkan Data Order Dengan Lengkap");
        } 
        else if (tTotalPrice.getText().isEmpty()){
            tTotalPrice.setText(tTotal.getText());
            order();
            tTotal.setText("");
            tItemName.setText("");
            tPrice.setText("");
            tQty.setText("");
        }
        else {
            int totalPrice = Integer.parseInt(tTotalPrice.getText());
            int total = Integer.parseInt(tTotal.getText());
            sum = totalPrice + total;
            tTotalPrice.setText(""+sum);
            order();
        }
        /*
        if (tTotalPrice.getText().isEmpty()){
            tTotalPrice.setText(tTotal.getText());
            notif();
            order();
            tTotal.setText("");
            tItemName.setText("");
            tPrice.setText("");
            tQty.setText("");
        } else {
            int totalPrice = Integer.parseInt(tTotalPrice.getText());
            int total = Integer.parseInt(tTotal.getText());
            notif();
            int sum = totalPrice + total;
            tTotalPrice.setText(""+sum);
            order();
        }*/
  
    }//GEN-LAST:event_btnOrderActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        
            tTotal.setText("");
            tItemName.setText("");
            tPrice.setText("");
            tQty.setText("");
            
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new home(tUsername.getText()).setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void tblOrderedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderedMouseClicked
        // TODO add your handling code here:
        int i = tblOrdered.getSelectedRow();
        String type;
        if(i>-1) {
            tItemName.setText(model.getValueAt(i, 2).toString());
            tPrice.setText(model.getValueAt(i, 3).toString());
            tQty.setText(model.getValueAt(i, 4).toString());
            tTotal.setText(model.getValueAt(i,5).toString());  
        }
    }//GEN-LAST:event_tblOrderedMouseClicked

    
    // untuk button delete
    private void delete(){
        int[] rows = tblOrdered.getSelectedRows();
        for(int i=0;i<rows.length;i++){
        model.removeRow(rows[i]-i);
        tItemName.setText("");
        tPrice.setText("");
        tQty.setText("");
        tTotal.setText("");
        }
    }    //untuk button edit
    private void edit(){
    int[] rows = tblOrdered.getSelectedRows();
        for(int i=0;i<rows.length;i++){
        model.removeRow(rows[i]-i);
        }
        String[] item={tTC.getText(),tUsername.getText(),tItemName.getText(),tPrice.getText(),tQty.getText(),tTotal.getText()};
        model.addRow(item);
        tItemName.setText("");
        tPrice.setText("");
        tQty.setText("");
        tTotal.setText("");
    }
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >=0;i--){
            model.removeRow(i);
        }
        tItemName.setText("");
        tPrice.setText("");
        tQty.setText("");
        tTotal.setText("");
        tTotalPrice.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        /*try {
            // TODO add your handling code here:
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/dbpegawai","root","");
            cn.createStatement().executeUpdate("insert into tbtransaction values"+"('"+model+"')");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"isi data dengan benar");
        }*/
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/mycafe","root","");
            Statement st = koneksi.createStatement();
            
            for (int i = 0; i < model.getRowCount();i++) {
                String tc = model.getValueAt(i, 0).toString();
                String username = model.getValueAt(i, 1).toString();
                String item = model.getValueAt(i, 2).toString();
                String price = model.getValueAt(i, 3).toString();
                String qty = model.getValueAt(i, 4).toString();
                String total = model.getValueAt(i, 5).toString();
                
                String sqlquery = "INSERT INTO `tbtransaction`(`transactioncode`, `username`, `item`, `price`, `qty`, `total`) VALUES ('"+tc+"','"+username+"','"+item+"','"+price+"','"+qty+"','"+total+"')";
                st.addBatch(sqlquery);
                int[] rowsInserted = st.executeBatch();
                
                JOptionPane.showMessageDialog(null, "Menu Berhasil di Pesan Silahkan Lakukan Pembayaran");
               id_auto();
            }
            
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"isi data dengan benar");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        // TODO add your handling code here:
        pay();
        tTC.setText("");
        tTotalPrice.setText("");
        tMoney.setText("");
        id_auto();
    }//GEN-LAST:event_btnPayActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnBack;
    private javax.swing.JToggleButton btnCancel;
    private javax.swing.JToggleButton btnDrink;
    private javax.swing.JToggleButton btnFood;
    private javax.swing.JToggleButton btnOrder;
    private javax.swing.JToggleButton btnPay;
    private javax.swing.JToggleButton btnReset;
    private javax.swing.JToggleButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField tItemName;
    private javax.swing.JTextField tMoney;
    private javax.swing.JTextField tMoneyBack;
    public javax.swing.JTextField tPrice;
    private javax.swing.JTextField tQty;
    private javax.swing.JTextField tTC;
    private javax.swing.JTextField tTotal;
    private javax.swing.JTextField tTotalPrice;
    private javax.swing.JTextField tUsername;
    private javax.swing.JTable tblOrdered;
    // End of variables declaration//GEN-END:variables
}
