import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class office_window_4 extends JFrame implements ActionListener {
    office_window_4() throws SQLException {
    this.setLayout(null);
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();

    ImageIcon background = new ImageIcon(
      "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\agent_login_background.png"
    );

    ImageIcon icon = new ImageIcon(
        "C:\\Users\\hrajp\\OneDrive\\Desktop\\Real_Estate_Database_Management_System\\project\\src\\images\\black_report1.png"
      );
    JLabel l2 = new JLabel();
    l2.setIcon(background);
    l2.setBounds(0, 0, screenSize.width, screenSize.height);

    String url = "jdbc:mysql://localhost:3306/real_estate_database";
    String username = "root";
    String pswd = "harsh123";
    Connection conn = DriverManager.getConnection(url, username, pswd);
    String str= "select agent_id,property_id,address,p_area, bhk,transaction_date,lease_period, transaction_amount selling_price from transactions  join property_to_rent using(agent_id,property_id)  where transaction_type='rent' ";
    PreparedStatement psmt1 = conn.prepareStatement(str,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE
    );
    ResultSet rs = psmt1.executeQuery();
    ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
    DefaultTableModel model = new DefaultTableModel();
    int col = rsmd.getColumnCount();
    String[] colNames={"AGENT_ID","PROPERTY_ID","ADDRESS","AREA","BHK","TRANSACTION DATE","LEASE_PERIOD","SELLING_PRICE"};
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
    sp.setBounds(
      0,
      0,
      screenSize.width - 18,
      Math.min(36 * model.getRowCount() + 23, 650)
    );
    sp.setVerticalScrollBarPolicy(20);
    sp.setOpaque(false);
    sp.getViewport().setOpaque(false);
    table.getColumnModel().getColumn(0).setPreferredWidth(10);
    table.getColumnModel().getColumn(1).setPreferredWidth(10);
    table.getColumnModel().getColumn(2).setPreferredWidth(500);
    table.getColumnModel().getColumn(3).setPreferredWidth(10);
    table.getColumnModel().getColumn(4).setPreferredWidth(10);
    table.getColumnModel().getColumn(5).setPreferredWidth(100);
    table.getColumnModel().getColumn(6).setPreferredWidth(10);
    //table.getColumnModel().getColumn(7).setPreferredWidth(10);

    table.setOpaque(false);
    ((DefaultTableCellRenderer) table.getDefaultRenderer(getClass())).setOpaque(
        false
      );

    this.add(sp);
    this.add(l2);
    this.setTitle("Available Properties");
    this.setIconImage(icon.getImage());
    this.setDefaultCloseOperation(this.HIDE_ON_CLOSE);
    this.setIconImage(icon.getImage());
    this.setSize(screenSize.width, screenSize.height);
    this.setVisible(true);
    conn.close();
  }

  @Override
  public void actionPerformed(ActionEvent e) {}

  // public static void main(String[] args) throws SQLException {
  //   new office_window_4();
  // }
}

