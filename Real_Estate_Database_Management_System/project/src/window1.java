import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;

import javax.swing.*;


class window1 extends JFrame implements ActionListener {
  JButton button1 = new JButton();
  JButton button2 = new JButton();

  window1() {
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();

    this.setLayout(null);

    ImageIcon background = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\window.png");
    ImageIcon office = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\office.png");
    ImageIcon agent = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\agent.png"
    );
    ImageIcon icon = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\icon.png"
    );
    ImageIcon black_office = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\black_office.png"
    );
    ImageIcon black_agent = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\black_agent.png"
    );

    button1.setText("Login As Office");
    button1.setOpaque(false);
    button1.setContentAreaFilled(false);
    button1.setBounds(525, 350, 500, 50);
    button1.setFont(new Font("Serif", Font.PLAIN, 24));
    button1.setFocusable(false);
    button1.setBorder(BorderFactory.createLineBorder(Color.white, 1));
    button1.setIcon(office);
    button1.setIconTextGap(10);
    button1.setForeground(Color.white);
    button1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    button1.addActionListener(this);
    button1.addMouseListener(
      new java.awt.event.MouseAdapter() {

        public void mouseEntered(java.awt.event.MouseEvent evt) {
          button1.setIcon(black_office);
          button1.setForeground(Color.BLACK);
          button1.setContentAreaFilled(true);
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
          button1.setIcon(office);
          button1.setForeground(Color.WHITE);
          button1.setContentAreaFilled(false);
        }
      }
    );

    button2.setText("Login As Agent");
    button2.setOpaque(false);
    button2.setContentAreaFilled(false);
    button2.setForeground(Color.WHITE);
    button2.setBounds(525, 450, 500, 50);
    button2.setFont(new Font("Serif", Font.PLAIN, 24));
    button2.setFocusable(false);
    button2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
    button2.setIcon(agent);
    button2.setIconTextGap(10);
    button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    button2.addActionListener(this);
    button2.addMouseListener(
      new java.awt.event.MouseAdapter() {

        public void mouseEntered(java.awt.event.MouseEvent evt) {
          button2.setIcon(black_agent);
          button2.setForeground(Color.BLACK);
          button2.setContentAreaFilled(true);
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
          button2.setIcon(agent);
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

    JLabel label2 = new JLabel(
      "<html>Real Estate Database <br/>Management System</html>", SwingConstants.CENTER
    );
    label2.setFont(new Font("Serif", Font.PLAIN, 64));
    label2.setBounds((screenSize.width)/2-400, 20, 800, 300);
    label2.setForeground(Color.white);

    this.add(label2);
    this.add(label1);
    this.setIconImage(icon.getImage());
    this.setTitle("Real Estate Database Management System");
    this.setSize(screenSize.width, screenSize.height);
    // this.setResizable(false);
    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  public static void main(String[] args) {
    new window1();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == button1) {
      new office_window_1();
    }
    if (e.getSource() == button2) {
      new agent_window_1();
    }
  }
}
