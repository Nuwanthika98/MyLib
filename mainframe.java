
package intrfce;

import codes.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class mainframe extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
            
    public mainframe() {
        initComponents();
        conn = DBconnect.connect();
        tableload();
    }
    
    public void tableload(){
        try {
            String sql = "SELECT BID AS ID,BName AS Title,BAuthor AS Author,BCategory AS Category,BPrice AS Price FROM books";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void tabledata(){
        int r = table1.getSelectedRow();
        
        String id = table1.getValueAt(r, 0).toString();
        String title = table1.getValueAt(r, 1).toString();
        String author = table1.getValueAt(r, 2).toString();
        String category = table1.getValueAt(r, 3).toString();
        String price = table1.getValueAt(r, 4).toString();
        
        idbox.setText(id);
        titlebox.setText(title);
        authorbox.setText(author);
        categorybox.setSelectedItem(category);
        pricebox.setText(price);
    }
    
    public void search(){
        String srch = searchbox.getText();
         try {
            String sql = "SELECT * FROM books WHERE BID LIKE '%"+srch+"%' OR BName LIKE '%"+srch+"%' OR BAuthor LIKE '%"+srch+"%' OR BCategory LIKE '%"+srch+"%' OR BPrice LIKE '%"+srch+"%'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void update(){
        String id = idbox.getText();
        String title = titlebox.getText();
        String author = authorbox.getText();
        String category = categorybox.getSelectedItem().toString();
        String price = pricebox.getText();
        
        try {
            String sql = "UPDATE books SET BName='"+title+"',BAuthor='"+author+"',BCategory='"+category+"',BPrice='"+price+"' WHERE BID='"+id+"'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Updated Successfully!!");
            tableload();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    public void clear(){
        searchbox.setText("");
        idbox.setText("ID");
        titlebox.setText("");
        authorbox.setText("");
        categorybox.setSelectedIndex(0);
        pricebox.setText("");
    }
    


    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        searchbox = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        titlebox = new javax.swing.JTextField();
        authorbox = new javax.swing.JTextField();
        categorybox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        pricebox = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        idbox = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        insertbtn = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        clearbtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(153, 153, 0), new java.awt.Color(51, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 0, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11), new java.awt.Color(153, 153, 0))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchbox.setBackground(new java.awt.Color(153, 153, 0));
        searchbox.setForeground(new java.awt.Color(51, 0, 0));
        searchbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchboxActionPerformed(evt);
            }
        });
        searchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchboxKeyReleased(evt);
            }
        });
        jPanel3.add(searchbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 190, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 60));

        jPanel4.setBackground(new java.awt.Color(51, 0, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 0)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 0));
        jLabel1.setText("Title : ");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 0));
        jLabel2.setText("Author : ");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 0));
        jLabel3.setText("Category : ");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        titlebox.setBackground(new java.awt.Color(51, 0, 0));
        titlebox.setForeground(new java.awt.Color(153, 153, 0));
        titlebox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.add(titlebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 140, 30));

        authorbox.setBackground(new java.awt.Color(51, 0, 0));
        authorbox.setForeground(new java.awt.Color(153, 153, 0));
        authorbox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.add(authorbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 140, 30));

        categorybox.setBackground(new java.awt.Color(51, 0, 0));
        categorybox.setForeground(new java.awt.Color(153, 153, 0));
        categorybox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Educationl", "Novel", "Children", "Poem" }));
        categorybox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.add(categorybox, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 0));
        jLabel4.setText("Price : ");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        pricebox.setBackground(new java.awt.Color(51, 0, 0));
        pricebox.setForeground(new java.awt.Color(153, 153, 0));
        pricebox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.add(pricebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 110, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 0));
        jLabel5.setText("ID : ");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        idbox.setBackground(new java.awt.Color(51, 0, 0));
        idbox.setForeground(new java.awt.Color(153, 153, 0));
        idbox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.add(idbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 80, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 210, 210));

        jPanel5.setBackground(new java.awt.Color(51, 0, 0));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        insertbtn.setBackground(new java.awt.Color(51, 0, 0));
        insertbtn.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        insertbtn.setForeground(new java.awt.Color(153, 153, 0));
        insertbtn.setText("Insert");
        insertbtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        insertbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertbtnActionPerformed(evt);
            }
        });
        jPanel5.add(insertbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 70, -1));

        updatebtn.setBackground(new java.awt.Color(51, 0, 0));
        updatebtn.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        updatebtn.setForeground(new java.awt.Color(153, 153, 0));
        updatebtn.setText("Update");
        updatebtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });
        jPanel5.add(updatebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 70, -1));

        deletebtn.setBackground(new java.awt.Color(51, 0, 0));
        deletebtn.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        deletebtn.setForeground(new java.awt.Color(153, 153, 0));
        deletebtn.setText("Delete");
        deletebtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });
        jPanel5.add(deletebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 70, -1));

        clearbtn.setBackground(new java.awt.Color(51, 0, 0));
        clearbtn.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        clearbtn.setForeground(new java.awt.Color(153, 153, 0));
        clearbtn.setText("Clear");
        clearbtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtnActionPerformed(evt);
            }
        });
        jPanel5.add(clearbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 70, -1));

        jButton1.setBackground(new java.awt.Color(51, 0, 0));
        jButton1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 153, 0));
        jButton1.setText("Exit");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 80, -1));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 180, 120));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 440));

        jScrollPane1.setBackground(new java.awt.Color(153, 153, 0));

        table1.setBackground(new java.awt.Color(51, 0, 0));
        table1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0)));
        table1.setForeground(new java.awt.Color(153, 153, 0));
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Author", "Category", "Price"
            }
        ));
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        table1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 430, 400));

        jLabel6.setBackground(new java.awt.Color(51, 0, 0));
        jLabel6.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Books Details");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 150, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 450));

        pack();
        setLocationRelativeTo(null);
    }

    private void searchboxActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void insertbtnActionPerformed(java.awt.event.ActionEvent evt) {
        
        String title;
        String author;
        String category;
        int price;
        
        title = titlebox.getText();
        author = authorbox.getText();
        category = categorybox.getSelectedItem().toString();
        price = Integer.parseInt(pricebox.getText());
        
        try {
            String sql = "INSERT INTO books (BName, BAuthor, BCategory, BPrice) VALUES('"+title+"','"+author+"','"+category+"','"+price+"')";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Successfully added!!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        
        tableload();
        
    }

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {
        tabledata();
    }
    private void table1KeyReleased(java.awt.event.KeyEvent evt) {
        tabledata();
    }

    private void searchboxKeyReleased(java.awt.event.KeyEvent evt) {
        search();
    }

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {
        update();
        
    }

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {
        int check = JOptionPane.showConfirmDialog(null, "Do you want to delete selected item?"); //Values - yes:0, no:1 cancel:2
         if (check == 0){
             String id = idbox.getText();
             try {
                 String sql = "DELETE FROM books WHERE BID='"+id+"'";
                 pst=conn.prepareStatement(sql);
                 pst.execute();
                 JOptionPane.showMessageDialog(null,"Deleted!!");
             } catch (Exception e) {
                 JOptionPane.showMessageDialog(null,e);
             }
         }
         tableload();
    }

    private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {
        clear();
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainframe().setVisible(true);
            }
        });
    }

    private javax.swing.JTextField authorbox;
    private javax.swing.JComboBox<String> categorybox;
    private javax.swing.JButton clearbtn;
    private javax.swing.JButton deletebtn;
    private javax.swing.JTextField idbox;
    private javax.swing.JButton insertbtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField pricebox;
    private javax.swing.JTextField searchbox;
    private javax.swing.JTable table1;
    private javax.swing.JTextField titlebox;
    private javax.swing.JButton updatebtn;
}
