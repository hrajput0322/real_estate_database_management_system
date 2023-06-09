import com.mysql.cj.jdbc.result.ResultSetMetaData;
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
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class rent_property_2 extends JFrame implements ActionListener {
  int a_id;
  JTextField tf1 = new JTextField();
  JButton b1 = new JButton();
  rent_property_2(int agent_id,String loc,int ar,int bhk,int min_p,int max_p)
    throws SQLException {
    this.setLayout(null);
    a_id = agent_id;
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();

    ImageIcon background = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\window.png"
    );

    ImageIcon rent = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\rent.png"
    );

    ImageIcon white_buy = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\white_buy.png"
    );

    ImageIcon black_buy = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\black_buy.png"
    );

    ImageIcon rent_icon = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\rent_icon.png"
    );

    JLabel l2 = new JLabel();
    l2.setIcon(background);
    l2.setBounds(0, 0, screenSize.width, screenSize.height);

    JLabel l3 = new JLabel("<html>Enter the Property ID of the<br>property you wish to Rent</html>");
    l3.setForeground(Color.white);
    l3.setFont(new Font("Serif", Font.PLAIN, 30));
    l3.setBounds(screenSize.width/4 + 50, 450, 500, 100);

    tf1.setFont(new Font("San Serif", Font.PLAIN, 24));
    tf1.setForeground(Color.white);
    tf1.setBounds(3 * (screenSize.width/4) - 250, 480, 300, 40);
    tf1.setOpaque(false);
    tf1.setForeground(Color.WHITE);
    tf1.setCaretColor(Color.white);

    JLabel l1 = new JLabel();
    l1.setIcon(rent);
    l1.setBounds(screenSize.width/2 - 128, 150, 256, 256);

    String url = "jdbc:mysql://localhost:3306/real_estate_database";
    String username = "root";
    String pswd = "harsh123";
    Connection conn = DriverManager.getConnection(url, username, pswd);
    PreparedStatement psmt1 = conn.prepareStatement(
      "select property_id, address, p_area, bhk, listing_price, listing_date, built_date from property_to_rent where address like ? and p_area>=? and bhk>=? and listing_price between ? and ? and agent_id=? and p_status='active'",
      ResultSet.TYPE_SCROLL_SENSITIVE,
      ResultSet.CONCUR_UPDATABLE
    );
    // System.out.println(agent_id);

    psmt1.setString(1, loc);
    psmt1.setInt(2, ar);
    psmt1.setInt(3, bhk);
    psmt1.setInt(4, min_p);
    psmt1.setInt(5, max_p);
    psmt1.setInt(6, agent_id);
    ResultSet rs = psmt1.executeQuery();

    ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
    DefaultTableModel model = new DefaultTableModel();
    int col = rsmd.getColumnCount();
    // String[] colNames = new String[col];
    // for (int i = 0; i < col; i++) {
    //   colNames[i] = rsmd.getColumnName(i + 1);
    // }
    String[] colNames = {"Property ID", "ADDRESS", "AREA", "BHK", "LISTING PRICE", "LISTING DATE", "BUILT DATE"};
    model.setColumnIdentifiers(colNames);
    while (rs.next()) {
      String[] row = new String[col];
      for (int i = 0; i < col; i++) {
        row[i] = rs.getString(i + 1);
      }
      model.addRow(row);
    }
    JTable table = new JTable(model);
    table.setEnabled(false);
    table.setFont(new Font("Serif", Font.PLAIN, 24));
    table.setForeground(Color.white);
    table.setRowHeight(36);
    JScrollPane sp = new JScrollPane(table);
    sp.setBounds(0,0,screenSize.width,Math.min(36 * model.getRowCount() + 23, 650));
    // sp.setVerticalScrollBarPolicy(20);
    // table.getTableHeader().setFont(new Font("Serif", Font.PLAIN, 24));
    // table.getTableHeader().setPreferredSize(new Dimension(screenSize.width, 50));
    sp.setOpaque(false);
    sp.getViewport().setOpaque(false);
    table.getColumnModel().getColumn(0).setPreferredWidth(20);
    table.getColumnModel().getColumn(1).setPreferredWidth(500);
    table.getColumnModel().getColumn(2).setPreferredWidth(20);
    table.getColumnModel().getColumn(3).setPreferredWidth(10);

    table.setOpaque(false);
    ((DefaultTableCellRenderer) table.getDefaultRenderer(getClass())).setOpaque(
        false
      );

    
    b1.setText("Rent Property");
    b1.setOpaque(false);
    b1.setContentAreaFilled(false);
    b1.setForeground(Color.WHITE);
    b1.setBounds((screenSize.width / 2) - 200, 650, 400, 50);
    b1.setFont(new Font("Serif", Font.PLAIN, 24));
    b1.setFocusable(false);
    b1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
    b1.setIcon(white_buy);
    b1.setIconTextGap(10);
    b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    b1.addActionListener(this);
    b1.addMouseListener(
      new java.awt.event.MouseAdapter() {

        public void mouseEntered(java.awt.event.MouseEvent evt) {
            b1.setIcon(black_buy);
          b1.setForeground(Color.BLACK);
          b1.setContentAreaFilled(true);
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
            b1.setIcon(white_buy);
          b1.setForeground(Color.WHITE);
          b1.setContentAreaFilled(false);
        }
      }
    );

    this.add(tf1);
    this.add(l1);
    this.add(l3);
    this.add(b1);
    this.add(sp);
    this.add(l2);
    this.setTitle("Available Properties");
    this.setIconImage(rent_icon.getImage());
    this.setDefaultCloseOperation(this.HIDE_ON_CLOSE);
    this.setSize(screenSize.width, screenSize.height);
    this.setVisible(true);
    conn.close();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    int flag=1;
    if (e.getSource()==b1){
      if (tf1.getText().equals("")){
        JOptionPane.showMessageDialog(null,"Kindly enter property id of the property to be bought", "WARNING", JOptionPane.WARNING_MESSAGE);
      }
      else {
        for (int i=0; i<tf1.getText().length();i++){
          if (!Character.isDigit(tf1.getText().charAt(i))){
            flag=0;
            break;
          }
        }
      }
      if (flag==0){
        JOptionPane.showMessageDialog(null,"Kindly enter valid ID", "ERROR", JOptionPane.ERROR_MESSAGE);
      }
      else {
        int property_id = Integer.parseInt(tf1.getText());
        new rent_property_3(a_id, property_id);
      }
    }
  }

  // public static void main(String[] args) throws SQLException {
  //   new rent_property_2(1, "%", 0, 0, 0, 2500000);
  // }
}
