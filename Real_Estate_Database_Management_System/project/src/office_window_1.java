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

public class office_window_1 extends JFrame implements ActionListener {
  Toolkit tk = Toolkit.getDefaultToolkit();
  Dimension screenSize = tk.getScreenSize();
  JButton b1 = new JButton();
  JTextField tf1 = new JTextField();
  JTextField tf2 = new JTextField();
  String password = "123456789";

  office_window_1() {
    this.setLayout(null);
    ImageIcon office = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\big_white_office.png"
    );
    ImageIcon icon = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\colored_office.png"
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
    l1.setIcon(office);
    l1.setBounds(350, 200, 256, 256);

    JLabel l3 = new JLabel("Office Login");
    l3.setForeground(Color.white);
    l3.setFont(new Font("Serif", Font.PLAIN, 30));
    l3.setBounds(404, 450, 200, 50);

    JLabel l2 = new JLabel();
    l2.setIcon(background);
    l2.setBounds(0, 0, screenSize.width, screenSize.height);

    JLabel l5 = new JLabel("Password");
    l5.setForeground(Color.white);
    l5.setFont(new Font("Serif", Font.PLAIN, 30));
    l5.setBounds((screenSize.width / 2) + 50, 320, 200, 50);

    tf2.setFont(new Font("San Serif", Font.PLAIN, 24));
    tf2.setForeground(Color.white);
    tf2.setBounds((screenSize.width / 2) + 200, 325, 200, 40);
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
    this.add(l5);
    this.add(tf2);
    this.add(b1);
    this.add(l2);
    this.setTitle("Office Login");
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
      if (tf2.getText().equals("")) {
        JOptionPane.showMessageDialog(
          null,
          "Kindly enter some value",
          "Warning",
          JOptionPane.WARNING_MESSAGE
        );
      } else {
        String passwd = tf2.getText();
        if (password.equals(passwd)) {
          new office_window_2();
        } else {
          JOptionPane.showMessageDialog(
            null,
            "Incorrect Password",
            "Error",
            JOptionPane.ERROR_MESSAGE
          );
        }
      }
    }
  }
}
