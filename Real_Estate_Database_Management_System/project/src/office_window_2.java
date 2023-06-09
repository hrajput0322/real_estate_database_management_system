import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;

class office_window_2 extends JFrame implements ActionListener {
  JButton button1 = new JButton();
  JButton button2 = new JButton();

  office_window_2() {
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();

    this.setLayout(null);

    ImageIcon background = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\window.png"
    );
    ImageIcon icon = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\report.png"
    );
    ImageIcon black_report = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\black_report.png"
    );
    ImageIcon white_report = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\white_report.png"
    );

    button1.setText("Get Sales Report Of Each Agent");
    button1.setOpaque(false);
    button1.setContentAreaFilled(false);
    button1.setBounds(525, 350, 500, 50);
    button1.setFont(new Font("Serif", Font.PLAIN, 24));
    button1.setFocusable(false);
    button1.setBorder(BorderFactory.createLineBorder(Color.white, 1));
    button1.setIcon(white_report);
    button1.setIconTextGap(10);
    button1.setForeground(Color.white);
    button1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    button1.addActionListener(this);
    button1.addMouseListener(
      new java.awt.event.MouseAdapter() {

        public void mouseEntered(java.awt.event.MouseEvent evt) {
          button1.setIcon(black_report);
          button1.setForeground(Color.BLACK);
          button1.setContentAreaFilled(true);
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
          button1.setIcon(white_report);
          button1.setForeground(Color.WHITE);
          button1.setContentAreaFilled(false);
        }
      }
    );

    button2.setText("Get Rent Property Report of Each Agent");
    button2.setOpaque(false);
    button2.setContentAreaFilled(false);
    button2.setForeground(Color.WHITE);
    button2.setBounds(525, 450, 500, 50);
    button2.setFont(new Font("Serif", Font.PLAIN, 24));
    button2.setFocusable(false);
    button2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
    button2.setIcon(white_report);
    button2.setIconTextGap(10);
    button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    button2.addActionListener(this);
    button2.addMouseListener(
      new java.awt.event.MouseAdapter() {

        public void mouseEntered(java.awt.event.MouseEvent evt) {
          button2.setIcon(black_report);
          button2.setForeground(Color.BLACK);
          button2.setContentAreaFilled(true);
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
          button2.setIcon(white_report);
          button2.setForeground(Color.WHITE);
          button2.setContentAreaFilled(false);
        }
      }
    );

    this.add(button1);
    this.add(button2);

    JLabel label1 = new JLabel();
    label1.setIcon(background);
    label1.setBounds(0, 0, screenSize.width, screenSize.height);

    JLabel label2 = new JLabel("WELCOME", SwingConstants.CENTER);
    label2.setFont(new Font("Serif", Font.PLAIN, 64));
    label2.setBounds((screenSize.width) / 2 - 400, 20, 800, 300);
    label2.setForeground(Color.white);

    this.add(label2);
    this.add(label1);
    this.setIconImage(icon.getImage());
    this.setTitle("Welcome ");
    this.setSize(screenSize.width, screenSize.height);
    // this.setResizable(false);
    this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    this.setVisible(true);
  }

  public static void main(String[] args) {
    new window1();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == button1) {
      try {
        new office_window_3();
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
    }
    if (e.getSource() == button2) {
      try {
        new office_window_4();
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
    }
  }
}
