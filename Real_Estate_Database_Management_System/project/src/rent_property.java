import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class rent_property extends JFrame implements ActionListener{
    int agent_id;
    JTextField tf1= new JTextField("none");
    JTextField tf2= new JTextField("none");
    JTextField tf3= new JTextField("none");
    JTextField tf4= new JTextField("none");
    JTextField tf5= new JTextField("none");
    String loc = "%";
    int ar = 0;
    int bhk = 0;
    int min_p = 0;
    int max_p = 2147483647;
    int flag3=1;
    int flag4=1;
    int flag5=1;
    int flag6=1;
    int flag7=1;
    int flag8=1;
    int flag9=1;
    int flag10=1;
    int flag11=1;
    int flag12=1;
    JButton b1= new JButton();
    rent_property(int id){
        agent_id=id;
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();

        ImageIcon background = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\window.png");
        ImageIcon icon = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\colored_rent.png");
      ImageIcon rent = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\for_rent.png");
      ImageIcon black_for_rent = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\black_buy_rent.png");
      ImageIcon white_for_rent = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\white_buy_rent.png");

        JLabel l5=new JLabel();
        l5.setIcon(background);
        l5.setBounds(0,0,screenSize.width,screenSize.height);

        JLabel l6 = new JLabel("Property Preferences", SwingConstants.CENTER);
        l6.setForeground(Color.white);
        l6.setFont(new Font("Serif", Font.PLAIN, 48));
        l6.setBounds(screenSize.width / 2 - 225, 30, 450, 75);

        JLabel l1 = new JLabel("Locality");
        l1.setForeground(Color.white);
        l1.setFont(new Font("Serif", Font.PLAIN, 36));
        l1.setBounds(screenSize.width / 2 - 100, 150, 300, 50);

        tf1.setFont(new Font("San Serif", Font.PLAIN, 24));
        tf1.setForeground(Color.white);
        tf1.setBounds(3 * (screenSize.width / 4) - 200, 150, 300, 40);
        tf1.setOpaque(false);
        tf1.setForeground(Color.WHITE);
        tf1.setCaretColor(Color.white);

        JLabel l2 = new JLabel("Area");
        l2.setForeground(Color.white);
        l2.setFont(new Font("Serif", Font.PLAIN, 36));
        l2.setBounds(screenSize.width / 2 - 100, 250, 300, 50);

        tf2.setFont(new Font("San Serif", Font.PLAIN, 24));
        tf2.setForeground(Color.white);
        tf2.setBounds(3 * (screenSize.width / 4) - 200, 250, 300, 40);
        tf2.setOpaque(false);
        tf2.setForeground(Color.WHITE);
        tf2.setCaretColor(Color.white);

        JLabel l3 = new JLabel("BHK");
        l3.setForeground(Color.white);
        l3.setFont(new Font("Serif", Font.PLAIN, 36));
        l3.setBounds(screenSize.width / 2 - 100, 350, 300, 50);

        tf3.setFont(new Font("San Serif", Font.PLAIN, 24));
        tf3.setForeground(Color.white);
        tf3.setBounds(3 * (screenSize.width / 4) - 200, 350, 300, 40);
        tf3.setOpaque(false);
        tf3.setForeground(Color.WHITE);
        tf3.setCaretColor(Color.white);

        JLabel l4 = new JLabel("Maximum Price");
        l4.setForeground(Color.white);
        l4.setFont(new Font("Serif", Font.PLAIN, 36));
        l4.setBounds(screenSize.width / 2 - 100, 450, 300, 50);

        tf4.setFont(new Font("San Serif", Font.PLAIN, 24));
        tf4.setForeground(Color.white);
        tf4.setBounds(3 * (screenSize.width / 4) - 200, 450, 300,40);
        tf4.setOpaque(false);
        tf4.setForeground(Color.WHITE);
        tf4.setCaretColor(Color.white);

        JLabel l7 = new JLabel("Minimum Price");
        l7.setForeground(Color.white);
        l7.setFont(new Font("Serif", Font.PLAIN, 36));
        l7.setBounds(screenSize.width / 2 - 100, 550, 300, 50);

        tf5.setFont(new Font("San Serif", Font.PLAIN, 24));
        tf5.setForeground(Color.white);
        tf5.setBounds(3 * (screenSize.width / 4) - 200, 550, 300,40);
        tf5.setOpaque(false);
        tf5.setForeground(Color.WHITE);
        tf5.setCaretColor(Color.white);

        JLabel l8= new JLabel();
        l8.setIcon(rent);
        l8.setBounds((screenSize.width/4)-128, 250, 256, 256);

        b1.setText("Show Properties");
        b1.setOpaque(false);
        b1.setContentAreaFilled(false);
        b1.setForeground(Color.WHITE);
        b1.setBounds((screenSize.width / 2) - 200, 700, 400, 50);
        b1.setFont(new Font("Serif", Font.PLAIN, 24));
        b1.setFocusable(false);
        b1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        b1.setIcon(white_for_rent);
        b1.setIconTextGap(10);
        b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b1.addActionListener(this);
        b1.addMouseListener(
        new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
            b1.setIcon(black_for_rent);
            b1.setForeground(Color.BLACK);
            b1.setContentAreaFilled(true);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
            b1.setIcon(white_for_rent);
            b1.setForeground(Color.WHITE);
            b1.setContentAreaFilled(false);
            }
        }
        );



        this.add(l1);
        this.add(l2);
        this.add(l3);
        this.add(l4);
        this.add(l6);
        this.add(l7);
        this.add(l8);
        this.add(b1);
        this.add(tf1);
        this.add(tf2);
        this.add(tf3);
        this.add(tf4);
        this.add(tf5);
        this.add(l5);
        this.setTitle("Rent Property");
        this.setIconImage(icon.getImage());
        this.setSize(screenSize.width,screenSize.height);
        this.setDefaultCloseOperation(this.HIDE_ON_CLOSE);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
          if (tf1.getText().equals("none") || tf1.getText().equals("")) {
            flag8=0;
          }
          if (tf2.getText().equals("none") || tf2.getText().equals("")) {
            flag9=0;
          }
          if (tf3.getText().equals("none") || tf3.getText().equals("")) {
            flag10=0;
          }
          if (tf4.getText().equals("none") || tf4.getText().equals("")) {
            flag11=0;
          }
          if (tf5.getText().equals("none") || tf5.getText().equals("")) {
            flag12=0;
          }
          for (int i=0; i<tf1.getText().length();i++){
            if (!Character.isLetter(tf1.getText().charAt(i))){
              flag3=0;
              break;
            }
          }
          
          if (flag3!=0 && !tf1.getText().equals("none") && !tf1.getText().equals("")) {
            String location = tf1.getText();
            loc="%"+location+"%";
          }

          for (int i=0; i<tf2.getText().length();i++){
            if (!Character.isDigit(tf2.getText().charAt(i))){
              flag4=0;
              break;
            }
          }
          
          if (flag4!=0 && !tf2.getText().equals("none") && !tf2.getText().equals("")) {
            int area = Integer.parseInt(tf2.getText());
            ar=area;
          }
      
          for (int i=0; i<tf3.getText().length();i++){
            if (!Character.isDigit(tf3.getText().charAt(i))){
              flag5=0;
              break;
            }
          }
          
          if (flag5!=0 && !tf3.getText().equals("none") && !tf3.getText().equals("")){
            int BHK = Integer.parseInt(tf3.getText());
            bhk=BHK;
          }
         
          for (int i=0; i<tf4.getText().length();i++){
            if (!Character.isDigit(tf4.getText().charAt(i))){
              flag6=0;
              break;
            }
          }
          
          if (flag6!=0 && !tf4.getText().equals("none") && !tf4.getText().equals("")){
            int max_price = Integer.parseInt(tf4.getText());
            max_p=max_price;
          }
          for (int i=0; i<tf5.getText().length();i++){
            if (!Character.isDigit(tf5.getText().charAt(i))){
              flag7=0;
              break;
            }
          }
          
          if (flag7!=0 && !tf5.getText().equals("none") && !tf5.getText().equals("")){
            int min_price = Integer.parseInt(tf5.getText());
            min_p=min_price;
          }
          if (((flag3==0 && flag8==1) || (flag4==0 && flag9==1) || (flag5==0 && flag10==1) || flag6==0 && flag7==1) || (flag7==0 && flag12==1)){
            JOptionPane.showMessageDialog(null,"Kindly enter valid values", "WARNING", JOptionPane.WARNING_MESSAGE);
          }
          else {
            try {
              new rent_property_2(agent_id, loc, ar, bhk, min_p, max_p);
            } catch (SQLException e1) {

            }
          }
          flag8=flag9=flag10=flag11=flag12=flag3=flag4=flag5=flag6=flag7=1;
        }
    }
    // public static void main(String[] args) {
    //     new rent_property(2);
    // }
}