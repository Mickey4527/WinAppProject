/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package WinApp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;




public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    SaveInfo info = new SaveInfo();
    
    
    public MainFrame() {   
        initComponents();
        show_user();
    }
    
    
    private ArrayList<showInfo> UserList(){
        
        ArrayList<showInfo> userlist = new ArrayList<>();
        
        try{
            FileReader reader = new FileReader("Config.properties");
            Properties properties = new Properties();
            properties.load(reader);
            
            getConfig config;
            
            config = new getConfig();
            config.setConfigServer(properties.getProperty("class"), properties.getProperty("conn_db"), properties.getProperty("user_name"), properties.getProperty("password"));
            Class.forName(properties.getProperty("class"));   
           
            
            String mysqlConnUrl = "jdbc:mysql://localhost:3306/" + properties.getProperty("conn_db");
            String mysqlUserName = properties.getProperty("user_name");
            String mysqlPassword = properties.getProperty("password");
            
            Connection conn = DriverManager.getConnection(mysqlConnUrl, mysqlUserName , mysqlPassword);
            
            String query = "SELECT * FROM Info_Product";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            showInfo showinfo;
            while(rs.next()){
                showinfo = new showInfo(rs.getString("Date"),rs.getString("Name"), rs.getString("Company"), rs.getString("Type"), rs.getString("Counter"), rs.getDouble("Price"), rs.getInt("Qua"),rs.getString("More"));
                userlist.add(showinfo);
            }
        }
        
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
      
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return userlist;
    }
    
    private void show_user(){
        
        ArrayList<showInfo> list = UserList();
        DefaultTableModel model = (DefaultTableModel) jTable_ShowInfo.getModel();
        
        Object[] row = new Object[8];
        
        for(int i = 0; i < list.size(); i++){
            row[0] = list.get(i).getDate();
            row[1] = list.get(i).getType();
            row[2] = list.get(i).getName();
            row[3] = list.get(i).getCompany();
            row[4] = list.get(i).getCounter();
            row[5] = list.get(i).getQua();
            row[6] = list.get(i).getPrice();
            row[7] = list.get(i).getMore();
            
            model.addRow(row);
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

        lblHeader = new javax.swing.JLabel();
        lblGithub = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        lblPrice = new javax.swing.JLabel();
        spnQua = new javax.swing.JSpinner();
        lblQua = new javax.swing.JLabel();
        txtCompany = new javax.swing.JTextField();
        txtProductName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        lblNameProduct = new javax.swing.JLabel();
        lblCompany = new javax.swing.JLabel();
        lblCounter = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        cmbType = new javax.swing.JComboBox<>();
        cmbCounter = new javax.swing.JComboBox<>();
        spnDate = new javax.swing.JSpinner();
        lblDate = new javax.swing.JLabel();
        lblMore = new javax.swing.JLabel();
        txtMore = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_ShowInfo = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        mubHeader = new javax.swing.JMenuBar();
        meuFile = new javax.swing.JMenu();
        mutExit = new javax.swing.JMenuItem();
        menOption = new javax.swing.JMenu();
        mnuConfigServer = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("บันทึกสินค้า");
        setAutoRequestFocus(false);
        setIconImages(null);

        lblHeader.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        lblHeader.setText("บันทึกสินค้า");

        lblGithub.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/GitHub-Mark-32px.png"))); // NOI18N
        lblGithub.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblGithub.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGithubMouseClicked(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Save-icon.png"))); // NOI18N
        btnSave.setText("บันทึกข้อมูล");
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        lblPrice.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        lblPrice.setText("ราคาสินค้า");

        spnQua.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        lblQua.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        lblQua.setText("จำนวนสินค้า");

        txtCompany.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N

        txtProductName.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N

        txtPrice.setText("0");
        txtPrice.setActionCommand("<Not Set>");

        lblNameProduct.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        lblNameProduct.setText("ชื่อสินค้า");

        lblCompany.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        lblCompany.setText("ยี่ห้อ");

        lblCounter.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        lblCounter.setText("หน่วยนับสินค้า");

        lblType.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        lblType.setText("ประเภทสินค้า");

        cmbType.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        cmbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ไม่มี", "เครื่องดื่ม", "อาหาร", "เครื่องใช้", "ยารักษาโรค", "อุปกรณ์อิเล็กทรอนิกส์" }));

        cmbCounter.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        cmbCounter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ชิ้น", "ก้อน", "กล่อง", "ขวด", "กระป๋อง", "แก้ว", "ชุด", "เครื่อง", "อัน" }));

        spnDate.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        spnDate.setModel(new javax.swing.SpinnerDateModel());
        spnDate.setEnabled(false);
        spnDate.setInheritsPopupMenu(true);

        lblDate.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        lblDate.setText("บันทึกวันที่");

        lblMore.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        lblMore.setText("หมายเหตุ");

        txtMore.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N

        jTable_ShowInfo.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        jTable_ShowInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "วัน/เดือน/ปี", "ประเภทสินค้า", "ชื่อสินค้า", "ยี่ห้อ", "หน่วยนับ", "จำนวนสินค้า", "ราคา", "หมายเหตุ"
            }
        ));
        jTable_ShowInfo.setEnabled(false);
        jScrollPane2.setViewportView(jTable_ShowInfo);
        jTable_ShowInfo.getTableHeader().setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14));

        btnRefresh.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Button-Refresh-icon (1).png"))); // NOI18N
        btnRefresh.setText("รีเฟรช");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        meuFile.setText("File");

        mutExit.setText("Exit");
        mutExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mutExitActionPerformed(evt);
            }
        });
        meuFile.add(mutExit);

        mubHeader.add(meuFile);

        menOption.setText("Option");

        mnuConfigServer.setText("Config server");
        mnuConfigServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConfigServerActionPerformed(evt);
            }
        });
        menOption.add(mnuConfigServer);

        mubHeader.add(menOption);

        setJMenuBar(mubHeader);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblQua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spnQua, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblPrice)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblHeader)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNameProduct)
                                    .addComponent(lblDate)
                                    .addComponent(lblCompany))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCompany)
                                    .addComponent(txtProductName)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(spnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblGithub)
                                .addGap(19, 19, 19))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblType)
                                    .addComponent(lblMore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(lblCounter)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbCounter, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtMore))
                                .addGap(125, 125, 125))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRefresh)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSave)))
                        .addGap(37, 37, 37))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHeader)
                    .addComponent(lblGithub, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNameProduct)
                            .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblType)
                            .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCounter)
                            .addComponent(cmbCounter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMore)
                            .addComponent(txtMore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblCompany))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQua)
                    .addComponent(lblPrice)
                    .addComponent(spnQua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRefresh)
                        .addGap(6, 6, 6)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblGithubMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGithubMouseClicked
        try
        {
            String url = "www.github.com/Saran458/WinAppProject";
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        }
        catch (java.io.IOException e)
        {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_lblGithubMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        try
        {
            double price;
            
            //Connect to Database
            FileReader reader = new FileReader("Config.properties");
            Properties properties = new Properties();
            properties.load(reader);
            
            getConfig config;
            
            config = new getConfig();
            config.setConfigServer(properties.getProperty("class"), properties.getProperty("conn_db"), properties.getProperty("user_name"), properties.getProperty("password"));
            Class.forName(properties.getProperty("class"));   
           
            
            String mysqlConnUrl = "jdbc:mysql://localhost:3306/" + properties.getProperty("conn_db");
            String mysqlUserName = properties.getProperty("user_name");
            String mysqlPassword = properties.getProperty("password");
            
            
           Connection conn = DriverManager.getConnection(mysqlConnUrl, mysqlUserName , mysqlPassword);
           
           //Upload data to Database
           
            Statement stmt = conn.createStatement();    
                                         
            price = Double.parseDouble(txtPrice.getText());
                    
            String sql = "INSERT INTO Info_Product (Date ,Name, Company, Type, Counter, Price, Qua, More) "
                            + "VALUES ( '"+ spnDate.getValue() +"','"+ txtProductName.getText() +"', '"+txtCompany.getText()+"', "
                            + "'"+ cmbType.getSelectedItem() +"', '"+ cmbCounter.getSelectedItem() +"', '"+price+"', '"+spnQua.getValue()+"', '"+ txtMore.getText() +"')";
            stmt.execute(sql);
            
            //pint complete to user
                   
            JOptionPane.showMessageDialog(this, "Save complete!");
   
            txtProductName.setText("");
            txtCompany.setText("");
            txtMore.setText("");
            txtPrice.setText("");           
                    
            DefaultTableModel model = (DefaultTableModel) jTable_ShowInfo.getModel();
            model.setRowCount(0);
            show_user();
                        
        }
           
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
      
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
       
  
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
         DefaultTableModel model = (DefaultTableModel) jTable_ShowInfo.getModel();
         model.setRowCount(0);
         show_user();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void mnuConfigServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConfigServerActionPerformed
        // TODO add your handling code here:
        ConfigServer config = new ConfigServer();
        config.show();
    }//GEN-LAST:event_mnuConfigServerActionPerformed

    private void mutExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mutExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_mutExitActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbCounter;
    private javax.swing.JComboBox<String> cmbType;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_ShowInfo;
    private javax.swing.JLabel lblCompany;
    private javax.swing.JLabel lblCounter;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblGithub;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblMore;
    private javax.swing.JLabel lblNameProduct;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblQua;
    private javax.swing.JLabel lblType;
    private javax.swing.JMenu menOption;
    private javax.swing.JMenu meuFile;
    private javax.swing.JMenuItem mnuConfigServer;
    private javax.swing.JMenuBar mubHeader;
    private javax.swing.JMenuItem mutExit;
    private javax.swing.JSpinner spnDate;
    private javax.swing.JSpinner spnQua;
    private javax.swing.JTextField txtCompany;
    private javax.swing.JTextField txtMore;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProductName;
    // End of variables declaration//GEN-END:variables
}
