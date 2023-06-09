import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class add_rent extends JFrame implements ActionListener {
  int agent_id;
  JTextField tf11 = new JTextField();
  JTextField tf12 = new JTextField("");
  JTextField tf13 = new JTextField();
  JTextField tf14 = new JTextField("");
  JButton b1= new JButton();
  add_rent(int id) {
    agent_id = id;
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();

    ImageIcon background = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\window.png"
    );
    ImageIcon icon = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\colored_rent.png"
    );
    ImageIcon seller = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\seller.png"
    );
    ImageIcon white_save = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\white_save.png"
    );
    ImageIcon black_save = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\black_save.png"
    );

    JLabel l1 = new JLabel("Seller Details", SwingConstants.CENTER);
    l1.setForeground(Color.white);
    l1.setFont(new Font("Serif", Font.PLAIN, 48));
    l1.setBounds(screenSize.width / 2 - 125, 30, 300, 50);

    JLabel l11 = new JLabel("Seller ID");
    l11.setForeground(Color.white);
    l11.setFont(new Font("Serif", Font.PLAIN, 36));
    l11.setBounds(screenSize.width / 2 - 100, 200, 300, 50);

    tf11.setFont(new Font("San Serif", Font.PLAIN, 24));
    tf11.setForeground(Color.white);
    tf11.setBounds(3 * (screenSize.width / 4) - 200, 200, 300, 40);
    tf11.setOpaque(false);
    tf11.setForeground(Color.WHITE);
    tf11.setCaretColor(Color.white);

    JLabel l12 = new JLabel("Seller Name");
    l12.setForeground(Color.white);
    l12.setFont(new Font("Serif", Font.PLAIN, 36));
    l12.setBounds(screenSize.width / 2 - 100, 300, 300, 50);

    tf12.setFont(new Font("San Serif", Font.PLAIN, 24));
    tf12.setForeground(Color.white);
    tf12.setBounds(3 * (screenSize.width / 4) - 200, 300, 300, 40);
    tf12.setOpaque(false);
    tf12.setForeground(Color.WHITE);
    tf12.setCaretColor(Color.white);

    JLabel l13 = new JLabel("Phone Number");
    l13.setForeground(Color.white);
    l13.setFont(new Font("Serif", Font.PLAIN, 36));
    l13.setBounds(screenSize.width / 2 - 100, 400, 300, 50);

    tf13.setFont(new Font("San Serif", Font.PLAIN, 24));
    tf13.setForeground(Color.white);
    tf13.setBounds(3 * (screenSize.width / 4) - 200, 400, 300, 40);
    tf13.setOpaque(false);
    tf13.setForeground(Color.WHITE);
    tf13.setCaretColor(Color.white);

    JLabel l14 = new JLabel("E-Mail");
    l14.setForeground(Color.white);
    l14.setFont(new Font("Serif", Font.PLAIN, 36));
    l14.setBounds(screenSize.width / 2 - 100, 500, 300, 50);

    tf14.setFont(new Font("San Serif", Font.PLAIN, 24));
    tf14.setForeground(Color.white);
    tf14.setBounds(3 * (screenSize.width / 4) - 200, 500, 300, 40);
    tf14.setOpaque(false);
    tf14.setForeground(Color.WHITE);
    tf14.setCaretColor(Color.white);

    JLabel l2 = new JLabel();
    l2.setIcon(background);
    l2.setBounds(0, 0, screenSize.width, screenSize.height);

    JLabel l3= new JLabel();
    l3.setIcon(seller);
    l3.setBounds((screenSize.width/4)-128, 250, 256, 256);

    b1.setText("Save and next");
    b1.setOpaque(false);
    b1.setContentAreaFilled(false);
    b1.setForeground(Color.WHITE);
    b1.setBounds((screenSize.width / 2) - 200, 650, 400, 50);
    b1.setFont(new Font("Serif", Font.PLAIN, 24));
    b1.setFocusable(false);
    b1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
    b1.setIcon(white_save);
    b1.setIconTextGap(10);
    b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    b1.addActionListener(this);
    b1.addMouseListener(
      new java.awt.event.MouseAdapter() {

        public void mouseEntered(java.awt.event.MouseEvent evt) {
          b1.setIcon(black_save);
          b1.setForeground(Color.BLACK);
          b1.setContentAreaFilled(true);
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
          b1.setIcon(white_save);
          b1.setForeground(Color.WHITE);
          b1.setContentAreaFilled(false);
        }
      }
    );


    this.add(l1);
    this.add(l3);
    this.add(l11);
    this.add(l12);
    this.add(l13);
    this.add(l14);
    this.add(tf11);
    this.add(tf12);
    this.add(tf13);
    this.add(tf14);
    this.add(b1);
    this.add(l2);
    this.setTitle("List your Property for rent");
    this.setIconImage(icon.getImage());
    this.setSize(screenSize.width, screenSize.height);
    this.setDefaultCloseOperation(this.HIDE_ON_CLOSE);
    this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource()==b1){
      int flag1=1;
      int flag2=1;
      int flag3=1;
      int flag4=1;
      if (tf11.getText().equals("") || tf12.getText().equals("") || tf13.getText().equals("") || tf14.getText().equals("")){
        JOptionPane.showMessageDialog(null,"All fields are required, DO NOT leave any field blank!", "WARNING", JOptionPane.WARNING_MESSAGE);
      }
      else {
        String seller_id = tf11.getText();
        String seller_name = tf12.getText();
        String phone_number = tf13.getText();
        String email = tf14.getText();
        for (int i=0; i<seller_id.length();i++){
          if (!Character.isDigit(seller_id.charAt(i))){
            flag1=0;
            break;
          }
        }
        for (int i=0; i<seller_name.length();i++){
          if (!Character.isLetter(seller_name.charAt(i)) && (seller_name.charAt(i)!=' ')){
            flag2=0;
            break;
          }
        }
        if (seller_name.matches("\s+")){
          flag2=0;
        }
        if (!phone_number.matches("[1-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]")){
          flag3=0;
        }
        if (!email.contains("@") || !email.contains(".com")){
          flag4=0;
        }
        if (email.length()<7){
          flag4=0;
        }
        // System.out.println(flag1);
        // System.out.println(flag2);
        // System.out.println(flag3);
        // System.out.println(flag4);
        if (flag1==0 || flag2==0 || flag3==0 || flag4==0){
          JOptionPane.showMessageDialog(null,"Kindly enter VALID values", "ERROR", JOptionPane.ERROR_MESSAGE);
          flag1=flag2=flag3=flag4=1;
        }
        else {
          new property_details_rent(seller_id,agent_id,seller_name,phone_number,email);
        }
      }
    }
  }
}
