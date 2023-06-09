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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class agent_window_1 extends JFrame implements ActionListener {
  Toolkit tk = Toolkit.getDefaultToolkit();
  Dimension screenSize = tk.getScreenSize();
  JButton b1 = new JButton();
  JTextField tf1 = new JTextField();
  JTextField tf2 = new JTextField();
  int id;
  String password;

  agent_window_1() {
    this.setLayout(null);
    ImageIcon agent = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\big_white_agent.png"
    );
    ImageIcon icon = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\colored_agent.png"
    );
    ImageIcon login = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\login.png"
    );
    ImageIcon background = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\window.png"
    );
    ImageIcon black_login = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\black_login.png"
    );

    JLabel l1 = new JLabel();
    l1.setIcon(agent);
    l1.setBounds(350, 200, 256, 256);

    JLabel l3 = new JLabel("Agent Login");
    l3.setForeground(Color.white);
    l3.setFont(new Font("Serif", Font.PLAIN, 30));
    l3.setBounds(404, 450, 200, 50);

    JLabel l2 = new JLabel();
    l2.setIcon(background);
    l2.setBounds(0, 0, screenSize.width, screenSize.height);

    JLabel l4 = new JLabel("Agent ID");
    l4.setForeground(Color.white);
    l4.setFont(new Font("Serif", Font.PLAIN, 30));
    l4.setBounds((screenSize.width / 2) + 50, 250, 200, 50);

    JLabel l5 = new JLabel("Password");
    l5.setForeground(Color.white);
    l5.setFont(new Font("Serif", Font.PLAIN, 30));
    l5.setBounds((screenSize.width / 2) + 50, 350, 200, 50);

    tf1.setFont(new Font("San Serif", Font.PLAIN, 24));
    tf1.setForeground(Color.white);
    tf1.setBounds((screenSize.width / 2) + 200, 255, 200, 40);
    tf1.setOpaque(false);
    tf1.setForeground(Color.WHITE);
    tf1.setCaretColor(Color.white);

    tf2.setFont(new Font("San Serif", Font.PLAIN, 24));
    tf2.setForeground(Color.white);
    tf2.setBounds((screenSize.width / 2) + 200, 355, 200, 40);
    tf2.setOpaque(false);
    tf2.setForeground(Color.WHITE);
    tf2.setForeground(Color.WHITE);
    tf2.setCaretColor(Color.white);

    b1.setText("Login In");
    b1.setOpaque(false);
    b1.setContentAreaFilled(false);
    b1.setForeground(Color.WHITE);
    b1.setBounds((screenSize.width / 2) - 125, 550, 250, 50);
    b1.setFont(new Font("Serif", Font.PLAIN, 24));
    b1.setFocusable(false);
    b1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
    b1.setIcon(login);
    b1.setIconTextGap(10);
    b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    b1.addActionListener(this);
    b1.addMouseListener(
      new java.awt.event.MouseAdapter() {

        public void mouseEntered(java.awt.event.MouseEvent evt) {
          b1.setIcon(black_login);
          b1.setForeground(Color.BLACK);
          b1.setContentAreaFilled(true);
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
          b1.setIcon(login);
          b1.setForeground(Color.WHITE);
          b1.setContentAreaFilled(false);
        }
      }
    );

    this.add(l1);
    this.add(l3);
    this.add(l4);
    this.add(l5);
    this.add(tf1);
    this.add(tf2);
    this.add(b1);
    this.add(l2);
    this.setTitle("Agent Login");
    this.setIconImage(icon.getImage());
    this.setBackground(new Color(0xe7e1dd));
    this.setSize(screenSize.width, screenSize.height);
    // this.setResizable(false);
    this.setDefaultCloseOperation(this.HIDE_ON_CLOSE);
    this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e2) {
    if (e2.getSource() == b1) {
      if (tf1.getText().equals("") || tf2.getText().equals("")) {
        JOptionPane.showMessageDialog(
          null,
          "Both fields are required, DO NOT leave any field blank!",
          "Warning",
          JOptionPane.WARNING_MESSAGE
        );
      } else {
        id = Integer.parseInt(tf1.getText());
        password = tf2.getText();
        try {
          String url = "jdbc:mysql://localhost:3306/real_estate_database";
          String username = "root";
          String pswd = "harsh123";
          Connection conn = DriverManager.getConnection(url, username, pswd);
          PreparedStatement psmt = conn.prepareStatement(
            "select * from agent where agent_id=? and a_password=?"
          );
          psmt.setInt(1, id);
          psmt.setString(2, password);
          ResultSet rs = psmt.executeQuery();

          if (rs.next()) {
            new agent_window_2(id);
          } else {
            JOptionPane.showMessageDialog(
              null,
              "Invalid ID or Password",
              "ERROR in Logging In",
              JOptionPane.ERROR_MESSAGE
            );
          }
          conn.close();
        } catch (Exception e1) {
          JOptionPane.showMessageDialog(
            null,
            "Invalid ID or Password",
            "ERROR in Logging In",
            JOptionPane.ERROR_MESSAGE
          );
        }
      }
    }
  }
}
