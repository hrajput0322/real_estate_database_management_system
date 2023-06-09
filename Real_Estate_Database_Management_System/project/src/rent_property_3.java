import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.xml.transform.Source;

public class rent_property_3 extends JFrame implements ActionListener {
  JTextField tf11 = new JTextField("");
  JTextField tf12 = new JTextField("");
  JTextField tf13 = new JTextField("");
  JTextField tf14 = new JTextField("");
  JTextField tf15 = new JTextField("");
  JTextField tf16 = new JTextField("");
  JTextField tf17 = new JTextField("YYYY-MM-DD");
  JTextField tf18 = new JTextField(" in months");
  JTextField tf19 = new JTextField();
  JButton b1= new JButton();
  String seller_id;
  int p_id;
  int a_id;
  Float comm;  
  
  rent_property_3(int agent_id, int property_id) {
    a_id = agent_id;
    p_id = property_id;
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();

    ImageIcon background = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\window.png"
    );
    ImageIcon icon = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\property_icon.png"
    );
    ImageIcon property = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\property.png"
    );
    ImageIcon black_list = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\black_list.png"
    );
    ImageIcon white_list = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\white_list.png"
    );

    JLabel l1 = new JLabel("Enter Details", SwingConstants.CENTER);
    l1.setForeground(Color.white);
    l1.setFont(new Font("Serif", Font.PLAIN, 48));
    l1.setBounds(screenSize.width / 2 - 200, 30, 400, 60);

    JLabel l11 = new JLabel("Buyer ID");
    l11.setForeground(Color.white);
    l11.setFont(new Font("Serif", Font.PLAIN, 36));
    l11.setBounds(screenSize.width / 8 - 100, 200, 300, 50);

    tf11.setFont(new Font("San Serif", Font.PLAIN, 24));
    tf11.setForeground(Color.white);
    tf11.setBounds(3 * (screenSize.width / 8) - 200, 200, 300, 40);
    tf11.setOpaque(false);
    tf11.setForeground(Color.WHITE);
    tf11.setCaretColor(Color.white);

    JLabel l12 = new JLabel("Name");
    l12.setForeground(Color.white);
    l12.setFont(new Font("Serif", Font.PLAIN, 36));
    l12.setBounds(screenSize.width / 8 - 100, 300, 300, 50);

    tf12.setFont(new Font("San Serif", Font.PLAIN, 24));
    tf12.setForeground(Color.white);
    tf12.setBounds(3 * (screenSize.width / 8) - 200, 300, 300, 40);
    tf12.setOpaque(false);
    tf12.setForeground(Color.WHITE);
    tf12.setCaretColor(Color.white);

    JLabel l13 = new JLabel("Phone Number");
    l13.setForeground(Color.white);
    l13.setFont(new Font("Serif", Font.PLAIN, 36));
    l13.setBounds(screenSize.width / 8 - 100, 400, 300, 50);

    tf13.setFont(new Font("San Serif", Font.PLAIN, 24));
    tf13.setForeground(Color.white);
    tf13.setBounds(3 * (screenSize.width / 8) - 200, 400, 300, 40);
    tf13.setOpaque(false);
    tf13.setForeground(Color.WHITE);
    tf13.setCaretColor(Color.white);

    JLabel l14 = new JLabel("Email");
    l14.setForeground(Color.white);
    l14.setFont(new Font("Serif", Font.PLAIN, 36));
    l14.setBounds(screenSize.width / 8 - 100, 500, 300, 50);

    tf14.setFont(new Font("San Serif", Font.PLAIN, 24));
    tf14.setForeground(Color.white);
    tf14.setBounds(3 * (screenSize.width / 8) - 200, 500, 300, 40);
    tf14.setOpaque(false);
    tf14.setForeground(Color.WHITE);
    tf14.setCaretColor(Color.white);

    JLabel l15 = new JLabel("Transaction ID");
    l15.setForeground(Color.white);
    l15.setFont(new Font("Serif", Font.PLAIN, 36));
    l15.setBounds(5 * (screenSize.width / 8) - 150, 200, 300, 50);

    tf15.setFont(new Font("San Serif", Font.PLAIN, 24));
    tf15.setForeground(Color.white);
    tf15.setBounds(7 * (screenSize.width / 8) - 200, 200, 300, 40);
    tf15.setOpaque(false);
    tf15.setForeground(Color.WHITE);
    tf15.setCaretColor(Color.white);

    JLabel l16 = new JLabel("Transaction Amount");
    l16.setForeground(Color.white);
    l16.setFont(new Font("Serif", Font.PLAIN, 36));
    l16.setBounds(5* (screenSize.width / 8) - 150, 300, 300, 50);

    tf16.setFont(new Font("San Serif", Font.PLAIN, 24));
    tf16.setForeground(Color.white);
    tf16.setBounds(7 * (screenSize.width / 8) - 200, 300, 300, 40);
    tf16.setOpaque(false);
    tf16.setForeground(Color.WHITE);
    tf16.setCaretColor(Color.white);

    JLabel l17 = new JLabel("Transaction Date");
    l17.setForeground(Color.white);
    l17.setFont(new Font("Serif", Font.PLAIN, 36));
    l17.setBounds(5* (screenSize.width / 8) - 150, 400, 300, 50);

    tf17.setFont(new Font("San Serif", Font.PLAIN, 24));
    tf17.setForeground(Color.white);
    tf17.setBounds(7 * (screenSize.width / 8) - 200, 400, 300, 40);
    tf17.setOpaque(false);
    tf17.setForeground(Color.WHITE);
    tf17.setCaretColor(Color.white);

    JLabel l18 = new JLabel("Lease Period");
    l18.setForeground(Color.white);
    l18.setFont(new Font("Serif", Font.PLAIN, 36));
    l18.setBounds(5* (screenSize.width / 8) - 150, 500, 300, 50);

    tf18.setFont(new Font("San Serif", Font.PLAIN, 24));
    tf18.setForeground(Color.white);
    tf18.setBounds(7 * (screenSize.width / 8) - 200, 500, 300, 40);
    tf18.setOpaque(false);
    tf18.setForeground(Color.WHITE);
    tf18.setCaretColor(Color.white);

    JLabel l2 = new JLabel();
    l2.setIcon(background);
    l2.setBounds(0, 0, screenSize.width, screenSize.height);

    JLabel l3= new JLabel();
    l3.setIcon(property);
    l3.setBounds((screenSize.width/2) + 200, 25, 64, 64);

    b1.setText("Get Property for Rent");
    b1.setOpaque(false);
    b1.setContentAreaFilled(false);
    b1.setForeground(Color.WHITE);
    b1.setBounds((screenSize.width / 2) - 200, 700, 400, 50);
    b1.setFont(new Font("Serif", Font.PLAIN, 24));
    b1.setFocusable(false);
    b1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
    b1.setIcon(white_list);
    b1.setIconTextGap(10);
    b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    b1.addActionListener(this);
    b1.addMouseListener(
      new java.awt.event.MouseAdapter() {

        public void mouseEntered(java.awt.event.MouseEvent evt) {
          b1.setIcon(black_list);
          b1.setForeground(Color.BLACK);
          b1.setContentAreaFilled(true);
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
          b1.setIcon(white_list);
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
    this.add(l15);
    this.add(l16);
    this.add(l17);
    this.add(l18);
    this.add(tf11);
    this.add(tf12);
    this.add(tf13);
    this.add(tf14);
    this.add(tf15);
    this.add(tf19);
    this.add(tf16);
    this.add(tf17);
    this.add(tf18);
    this.add(b1);
    this.add(l2);
    this.setTitle("Rent Property");
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
      int flag5=1;
      int flag6=1;
      int flag7=1;
      int flag8=1;
      String buyer_id = tf11.getText();
      String name = tf12.getText();
      String phone_number = tf13.getText();
      String email = tf14.getText();
      String transaction_id = tf15.getText();
      String transaction_amount = tf16.getText();
      String transaction_date = tf17.getText();
      String lease_period = tf18.getText();

      if (buyer_id.equals("") || name.equals("") || phone_number.equals("") || email.equals("") || transaction_id.equals("") || transaction_amount.equals("") || transaction_date.equals("") || lease_period.equals("")){
        JOptionPane.showMessageDialog(null,"All fields are required, DO NOT leave any field blank!", "WARNING", JOptionPane.WARNING_MESSAGE);
      }

      else {
        for (int i=0; i<buyer_id.length();i++){
          if (!Character.isDigit(buyer_id.charAt(i))){
            flag1=0;
            break;
          }
        }
        for (int i=0; i<name.length();i++){
          if (!Character.isLetter(name.charAt(i))){
            flag2=0;
            break;
          }
        }
        if (name.matches("\s+")){
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
          
        for (int i=0; i<transaction_id.length();i++){
          if (!Character.isDigit(transaction_id.charAt(i))){
            flag5=0;
            break;
          }
        }
        for (int i=0; i<transaction_amount.length();i++){
          if (!Character.isDigit(transaction_amount.charAt(i))){
            flag6=0;
            break;
          }
        }
        for (int i=0;i<transaction_date.length();i++){
          if (!Character.isDigit(transaction_date.charAt(i)) && transaction_date.charAt(i)!='-'){
            flag7=0;
            break;
          }
        }
        if (transaction_date.charAt(transaction_date.length()-1)=='-'){
          flag7=0;
        }
        String[] arrOfDate = transaction_date.split("-");
        if (arrOfDate.length>3){
          flag7=0;
        }
        try {
          int year = Integer.parseInt(arrOfDate[0]);
          int month = Integer.parseInt(arrOfDate[1]);
          int date = Integer.parseInt(arrOfDate[2]);
          if (year>9999 || year<1000 || month>12 || month<1 || date>31 || date<1 || (date>29 && month==2) || (date>30 && (month==4 || month==6 || month==9 || month==11)) || (date==29 && year%4!=0 && month==2)){
            flag7=0;
          }
        }
        catch (Exception e1){
          flag7=0;
        }
      
        if (transaction_date.charAt(transaction_date.length()-1)=='-'){
          flag7=0;
        }

        for (int i=0; i<lease_period.length();i++){
            if (!Character.isDigit(lease_period.charAt(i))){
              flag8=0;
              break;
            }
          }
        if (flag1==0 || flag2==0 || flag3==0 || flag4==0 || flag5==0 || flag6==0 || flag7==0 || flag8==0){
          JOptionPane.showMessageDialog(null,"Kindly enter VALID values", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else {
          try {
            String url = "jdbc:mysql://localhost:3306/real_estate_database";
            String username = "root";
            String pswd = "harsh123";
            Connection conn = DriverManager.getConnection(url, username, pswd);   
                    

            // System.out.println(p_id);
            PreparedStatement q1 = conn.prepareStatement("select seller_id from seller natural join property_to_rent where property_id=?");
            q1.setInt(1, p_id);
            ResultSet rs1 = q1.executeQuery();
            if (rs1.next()){
                seller_id = rs1.getString("seller_id");
            }
            // System.out.println(seller_id);

            PreparedStatement q2 = conn.prepareStatement("select renting_commission from agent where agent_id=?");
            q2.setInt(1, a_id);
            ResultSet rs2 = q2.executeQuery();
            if (rs2.next()){
                comm = Float.parseFloat(rs2.getString("renting_commission"));
            }
            System.out.println(transaction_amount);
            System.out.println(comm);
            System.out.println(lease_period);
            Float total_comm = ((Integer.parseInt(transaction_amount) * comm * Integer.parseInt(lease_period))/100);

            PreparedStatement psmt2 = conn.prepareStatement("insert into buyer values (?,?,?,?,?)");
            psmt2.setInt(1, Integer.parseInt(buyer_id));
            psmt2.setInt(2,(a_id));
            psmt2.setString(3, name);
            psmt2.setLong(4, Long.parseLong(phone_number));
            psmt2.setString(5,email);
            psmt2.execute();

            PreparedStatement psmt1 = conn.prepareStatement("insert into transactions values (?,?,?,?,?,?,?,?,?,?)");
            psmt1.setInt(1, Integer.parseInt(transaction_id));
            psmt1.setInt(2,(p_id));
            psmt1.setInt(3, (a_id));
            psmt1.setInt(4, Integer.parseInt(buyer_id));
            psmt1.setInt(5, Integer.parseInt(seller_id));
            psmt1.setInt(6, Integer.parseInt(transaction_amount));
            psmt1.setFloat(7, total_comm);
            psmt1.setString(8,"rent");
            psmt1.setDate(9, Date.valueOf(transaction_date));
            psmt1.setInt(10, Integer.parseInt(lease_period));
            psmt1.execute();

            PreparedStatement psmt0 = conn.prepareStatement("update property_to_rent set p_status='inactive' where property_id=?");
            psmt0.setInt(1, p_id);
            psmt0.executeUpdate(); 
        
            JOptionPane.showMessageDialog(null,"this property is now yours!", "transaction successful", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e2){
          JOptionPane.showMessageDialog(null,"Some Error occured", "ERROR", JOptionPane.ERROR_MESSAGE);
          System.out.println(e2);
        }
      }
    }
  }
}
// public static void main(String[] args) {
//     new rent_property_3(1, 14);
// }
}
