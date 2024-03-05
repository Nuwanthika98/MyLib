package intrfce;

import javax.swing.JOptionPane;

/**
 *
 * @author nuwanthika
 */
public class login extends javax.swing.JFrame {

    
    public login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        usernameinput = new javax.swing.JTextField();
        passwordinput = new javax.swing.JPasswordField();
        loginbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 0));
        jLabel1.setText("LogIn Form");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 0));
        jLabel2.setText("User Name : ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 0));
        jLabel3.setText("Password : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        usernameinput.setBackground(new java.awt.Color(51, 0, 0));
        usernameinput.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        usernameinput.setForeground(new java.awt.Color(153, 153, 0));
        usernameinput.setToolTipText("Enter username here");
        usernameinput.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        usernameinput.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(usernameinput, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 200, 30));

        passwordinput.setBackground(new java.awt.Color(51, 0, 0));
        passwordinput.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        passwordinput.setForeground(new java.awt.Color(153, 153, 0));
        passwordinput.setToolTipText("Enter password here");
        passwordinput.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        passwordinput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordinputActionPerformed(evt);
            }
        });
        jPanel1.add(passwordinput, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 200, 30));

        loginbtn.setBackground(new java.awt.Color(51, 0, 0));
        loginbtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        loginbtn.setForeground(new java.awt.Color(153, 153, 0));
        loginbtn.setText("LogIn");
        loginbtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        loginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbtnActionPerformed(evt);
            }
        });
        jPanel1.add(loginbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, 50, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 350));

        setSize(new java.awt.Dimension(441, 388));
        setLocationRelativeTo(null);
    }

    private void passwordinputActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void loginbtnActionPerformed(java.awt.event.ActionEvent evt) {
        
        String uname; 
        String pword; 
        
        uname = usernameinput.getText();
        pword = passwordinput.getText();
        
        if(uname.equals("nuwanthika") && pword.equals("nuwi98")){
            mainframe m1 = new mainframe();
            m1.setVisible(true);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null,"Invalid username or password");
        }
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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginbtn;
    private javax.swing.JPasswordField passwordinput;
    private javax.swing.JTextField usernameinput;
}
