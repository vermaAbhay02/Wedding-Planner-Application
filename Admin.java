
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;

public class Admin extends JFrame implements ActionListener {

    JButton showUser, showfeed, showBuy,toHome;
    String url = "jdbc:mysql://localhost:3306/devil";
    String user = "root";
    String pass = "root";

    JTable userDetail = new JTable();
    JTable userfeed=new JTable();
    JTable userBuy=new JTable();
    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel model1 = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();
    JScrollPane pane,feeds,buy;
    Statement stm=null;
    Connection conn=null;
    ResultSet rs=null;
    ResultSet rs1=null;
    ResultSet rs2=null;
    JPanel dashboard=new JPanel(null);

    Admin() {

        setSize(800, 700);
        setLocation(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel label = new JLabel("Admin");
        label.setBounds(0, 0, 800, 50);
        label.setOpaque(true);
        label.setBackground(Color.black);
        label.setForeground(Color.white);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        add(label);

     toHome=new JButton("HOME");
        toHome.setBounds(100,5,100,35);
        toHome.setBackground(Color.yellow);
        toHome.setForeground(Color.black);
        label.add(toHome);

        dashboard.setBounds(0,50,200,600);
        dashboard.setBackground(Color.yellow);
        dashboard.setOpaque(true);
        add(dashboard);

        JLabel footer=new JLabel();
        footer.setBounds(0,650,800,50);
        footer.setOpaque(true);
        footer.setBackground(Color.black);
        add(footer);

        showUser = new JButton("Show User Details");
        showUser.setBounds(10, 50, 180, 40);
        showUser.setBackground(Color.black);
        showUser.setForeground(Color.white);
        dashboard.add(showUser);
        showUser.addActionListener(this);

        // ========table

        userDetail.setModel(model);
        add(userDetail);

        userfeed.setModel(model1);
        add(userfeed);

        userBuy.setModel(model2);
        add(userBuy);


        showfeed = new JButton("Show_User_Feeds");
        showfeed.setBounds(10, 100, 180, 40);
        showfeed.setBackground(Color.black);
        showfeed.setForeground(Color.white);
        dashboard.add(showfeed);
        showfeed.addActionListener(this);

        showBuy = new JButton("Show_User_Buy");
        showBuy.setBounds(10, 160, 180, 40);
        showBuy.setBackground(Color.black);
        showBuy.setForeground(Color.white);
        dashboard.add(showBuy);
        showBuy.addActionListener(this);

        //====================scrollpane

        pane = new JScrollPane(userDetail);
        pane.setBounds(300, 150, 400, 250);
        add(pane);
        pane.setVisible(false);
       
        feeds=new JScrollPane(userfeed);
        feeds.setBounds(300,150,400,250);
        add(feeds);
        feeds.setVisible(false);

        buy=new JScrollPane(userBuy);
        buy.setBounds(300,150,400,300);
        buy.setVisible(false);

        
        //========================
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == showUser) {
            feeds.setVisible(false);
            buy.setVisible(false);
            try {
                 conn = DriverManager.getConnection(url, user, pass);
                 stm = conn.createStatement();
                 rs = stm.executeQuery("select * from signup");
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();

                String[] columnNames = new String[columnCount];

                for (int i = 0; i < columnCount; i++) {
                    columnNames[i] = metaData.getColumnName(i + 1);
                    model.setColumnIdentifiers(columnNames);
                }

                while (rs.next()) {
                    String first = rs.getString(1);
                    String last = rs.getString(2);
                    String gender = rs.getString(3);
                    String user = rs.getString(4);
                    String pass = rs.getString(5);
                    String[] row = { first, last, gender, user, pass };
                    model.addRow(row);
                }
                pane.setVisible(true);
                conn.close();

            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }
        else if(e.getSource()==showfeed){
            pane.setVisible(false);
            buy.setVisible(false);
        
            try {
                 conn = DriverManager.getConnection(url, user, pass);
                 stm = conn.createStatement();
                 rs1 = stm.executeQuery("select * from feeds");
                ResultSetMetaData metaData = rs1.getMetaData();
                int columnCount = metaData.getColumnCount();

                String[] columnNames = new String[columnCount];

                for (int i = 0; i < columnCount; i++) {
                    columnNames[i] = metaData.getColumnName(i + 1);
                    model1.setColumnIdentifiers(columnNames);
                }

                while (rs1.next()) {
                    String name = rs1.getString(1);
                    String feed=rs1.getString(2);
                    String[] row = { name,feed };
                    model1.addRow(row);
                }
                feeds.setVisible(true);
                conn.close();

            } catch (SQLException sql) {
                sql.printStackTrace();
            }

        }
        else if(e.getSource()==showBuy){
            pane.setVisible(false);
            feeds.setVisible(false);

            if(rs2==null){
            try {
              
                 conn = DriverManager.getConnection(url, user, pass);
                 stm = conn.createStatement();
                rs2 = stm.executeQuery("select * from buyDetail");
                ResultSetMetaData metaData = rs2.getMetaData();
                int columnCount = metaData.getColumnCount();

                String[] columnNames = new String[columnCount];

                for (int i = 0; i < columnCount; i++) {
                    columnNames[i] = metaData.getColumnName(i + 1);
                    model2.setColumnIdentifiers(columnNames);
                }

                while (rs2.next()) {
                    String name = rs2.getString(1);
                    String venue=rs2.getString(2);
                    String groom=rs2.getString(3);
                    String bride=rs2.getString(4);
                    String budget=rs2.getString(5);
                    String food=rs2.getString(6);
                    String date=rs2.getString(7);
                    String[] row = { name,venue,groom,bride,budget,food,date};
                    model2.addRow(row);
                }
                buy.setVisible(true);
                conn.close();
            
            }
                catch(SQLException qe){
                qe.printStackTrace();
                }
        }
        else {
            buy.setVisible(true);
        }
    }
    else if(e.getSource()==toHome){

        new Main("");
    }
    
    }

    public static void main(String[] args) {
        new Admin();
    }
}
