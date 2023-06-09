import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class temp extends JFrame implements ActionListener{
    temp(){
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();

        data={}
        String[] col_name={"A","c","b"};
        JTable table = new JTable(, col_name);
        table.setBounds(0, 0, screenSize.width, screenSize.height/2);

        
        this.add(table);
        this.setLayout(getLayout());
        this.setSize(screenSize.width,screenSize.height);
        this.setDefaultCloseOperation(this.HIDE_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        this.setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }
    public static void main(String[] args) {
        new temp();
    }
    
}