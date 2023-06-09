import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class agent_window_2 extends JFrame implements ActionListener{
    String agent_name;
    JButton b1= new JButton();
    JButton b2= new JButton();
    JButton b3= new JButton();
    JButton b4= new JButton();
    int agent_id;
    agent_window_2(int id){
        agent_id=id;
        try{
            String url = "jdbc:mysql://localhost:3306/real_estate_database";
            String username = "root";
            String pswd = "harsh123";
            Connection conn = DriverManager.getConnection(url, username, pswd);
            PreparedStatement psmt = conn.prepareStatement(
                "select a_name from agent where agent_id=?"
            );
            psmt.setInt(1, id);
            ResultSet rs = psmt.executeQuery();
            while(rs.next()){
                agent_name=rs.getString("a_name");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(
                null, "Some error has occured", "ERROR", JOptionPane.ERROR_MESSAGE
              );
        }
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();

        ImageIcon icon = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\colored_agent.png"
        );
        ImageIcon background = new ImageIcon("C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\window.png"
        );
        ImageIcon white_add_sell = new ImageIcon("C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\white_add_sell.png"
        );
        ImageIcon black_add_sell = new ImageIcon("C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\black_add_sell.png"
        );
        ImageIcon white_add_rent = new ImageIcon("C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\white_add_rent.png"
        );
        ImageIcon black_add_rent = new ImageIcon("C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\black_add_rent.png"
        );
        ImageIcon white_buy = new ImageIcon("C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\white_buy.png"
        );
        ImageIcon black_buy = new ImageIcon("C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\black_buy.png"
        );
        ImageIcon white_rent = new ImageIcon("C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\white_rent.png"
        );
        ImageIcon black_rent = new ImageIcon("C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\black_rent.png"
        );

        JLabel l1 = new JLabel("Hello "+ agent_name+" !", SwingConstants.CENTER);
        l1.setFont(new Font("Serif", Font.PLAIN, 48));
        l1.setBounds(screenSize.width/2 - 285, 5, 570, 200);
        l1.setForeground(Color.white);

        JLabel l2 = new JLabel();
        l2.setIcon(background);
        l2.setBounds(0, 0, screenSize.width, screenSize.height);

        b1.setText("List Property to SELL");
        b1.setOpaque(false);
        b1.setContentAreaFilled(false);
        b1.setForeground(Color.WHITE);
        b1.setBounds((screenSize.width / 2) - 250, 250, 500, 50);
        b1.setFont(new Font("Serif", Font.PLAIN, 24));
        b1.setFocusable(false);
        b1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        b1.setIcon(white_add_sell);
        b1.setIconTextGap(10);
        b1.addActionListener(this);
        b1.addMouseListener(
        new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b1.setIcon(black_add_sell);
                b1.setForeground(Color.BLACK);
                b1.setContentAreaFilled(true);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b1.setIcon(white_add_sell);
                b1.setForeground(Color.WHITE);
                b1.setContentAreaFilled(false);
            }
        }
    );

        b2.setText("List Property to RENT");
        b2.setOpaque(false);
        b2.setContentAreaFilled(false);
        b2.setForeground(Color.WHITE);
        b2.setBounds((screenSize.width / 2) - 250, 350, 500, 50);
        b2.setFont(new Font("Serif", Font.PLAIN, 24));
        b2.setFocusable(false);
        b2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        b2.setIcon(white_add_rent);
        b2.setIconTextGap(10);
        b2.addActionListener(this);
        b2.addMouseListener(
        new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b2.setIcon(black_add_rent);
                b2.setForeground(Color.BLACK);
                b2.setContentAreaFilled(true);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b2.setIcon(white_add_rent);
                b2.setForeground(Color.WHITE);
                b2.setContentAreaFilled(false);
            }
      }
    );

        b3.setText("BUY Property");
        b3.setOpaque(false);
        b3.setContentAreaFilled(false);
        b3.setForeground(Color.WHITE);
        b3.setBounds((screenSize.width / 2) - 250, 450, 500, 50);
        b3.setFont(new Font("Serif", Font.PLAIN, 24));
        b3.setFocusable(false);
        b3.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        b3.setIcon(white_buy);
        b3.setIconTextGap(10);
        b3.addActionListener(this);
        b3.addMouseListener(
        new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b3.setIcon(black_buy);
                b3.setForeground(Color.BLACK);
                b3.setContentAreaFilled(true);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b3.setIcon(white_buy);
                b3.setForeground(Color.WHITE);
                b3.setContentAreaFilled(false);
            }
      }
    );

        b4.setText("RENT Property");
        b4.setOpaque(false);
        b4.setContentAreaFilled(false);
        b4.setForeground(Color.WHITE);
        b4.setBounds((screenSize.width / 2) - 250, 550, 500, 50);
        b4.setFont(new Font("Serif", Font.PLAIN, 24));
        b4.setFocusable(false);
        b4.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        b4.setIcon(white_rent);
        b4.setIconTextGap(10);
        b4.addActionListener(this);
        b4.addMouseListener(
        new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b4.setIcon(black_rent);
                b4.setForeground(Color.BLACK);
                b4.setContentAreaFilled(true);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b4.setIcon(white_rent);
                b4.setForeground(Color.WHITE);
                b4.setContentAreaFilled(false);
            }
      }
    );

        b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        this.add(l1);
        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.add(b4);
        this.add(l2);
        this.setTitle("How can I help you?");
        this.setSize(screenSize.width,screenSize.height);
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(this.HIDE_ON_CLOSE);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            new add_sale(agent_id);
        }
        else if (e.getSource()==b2){
            new add_rent(agent_id);
        }
        else if (e.getSource()==b3){
            new buy_property(agent_id);
        }
        else {
            new rent_property(agent_id);
        }
    }
}
