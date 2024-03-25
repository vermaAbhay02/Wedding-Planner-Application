import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class First extends JFrame implements ActionListener {

  String url = "jdbc:mysql://localhost:3306/devil";
  String u = "root";
  String p = "root";
  Connection conn = null;
  Statement stm = null;
    JLabel img;
  // Toolkit tool=Toolkit.getDefaultToolkit();
  // Dimension d= tool.getScreenSize();
  JTextField userfield;
  
  JPasswordField passfield;
  JButton signin, signup, clear, close,admin,submitButton,closeButton;
  JPanel adminLogin;
  JTextField adminfield;JPasswordField adminpassf;
  First() {
    setTitle("Wedding Planner Application");
    setSize(850,680);
    setLayout(null);
    setLocation(400, 100);
    // setUndecorated(true);
    setResizable(false);

     img = new JLabel();
    ImageIcon image = new ImageIcon("project\\images\\pexels-evie-shaffer-2395249.jpg");
    Image i = image.getImage().getScaledInstance(850, 680, Image.SCALE_DEFAULT);
    ImageIcon image1 = new ImageIcon(i);
    img.setIcon(image1);
    img.setBounds(0, 0, 850, 680);
    add(img);

    JLabel heading = new JLabel("Wedding Planner Application");
    heading.setBounds(170, 15, 550, 50);
    heading.setFont(new Font("Serif", Font.BOLD, 40));
    heading.setForeground(Color.black);
    img.add(heading);

    JLabel user = new JLabel("UserName:");
    user.setBounds(300, 250, 100, 30);
    user.setFont(new Font("Arial", Font.BOLD, 19));
    user.setForeground(Color.black);
    img.add(user);

    JLabel pass = new JLabel("PassWord:");
    pass.setBounds(300, 300, 100, 30);
    pass.setFont(new Font("Arial", Font.BOLD, 19));
    pass.setForeground(Color.black);
    img.add(pass);

    userfield = new JTextField();
    userfield.setBounds(420, 250, 200, 30);
    userfield.setFont(new Font("Raleway", Font.BOLD, 17));
    img.add(userfield);

    passfield = new JPasswordField(16);
    passfield.setBounds(420, 300, 200, 30);
    img.add(passfield);
    

    signup = new JButton("SIGN UP");
    signup.setBounds(420, 350, 90, 35);
    signup.setBackground(Color.BLACK);
    signup.setForeground(Color.WHITE);
    signup.addActionListener(this);
    img.add(signup);

    clear = new JButton("CLEAR");
    clear.setBounds(530, 350, 90, 35);
    clear.setBackground(Color.BLACK);
    clear.setForeground(Color.WHITE);
    clear.addActionListener(this);
    img.add(clear);

    admin=new JButton("Admin_Login");
    admin.setBounds(420, 400, 200, 35);
    admin.setBackground(Color.BLACK);
    admin.setForeground(Color.WHITE);
    admin.addActionListener(this);
    img.add(admin);

    signin = new JButton("SIGN IN");
    signin.setBounds(420, 450, 200, 40);
    signin.setBackground(Color.BLACK);
    signin.setForeground(Color.WHITE);
    signin.addActionListener(this);
    img.add(signin);

    close = new JButton("CLOSE");
    close.setBounds(420, 510, 200, 40);
    close.setBackground(Color.black);
    close.setForeground(Color.WHITE);
    close.addActionListener(this);
    img.add(close);
   
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);


    // while(true){
    // try{
    // Thread.sleep(300);
    // }
    // catch(Exception e){
    // e.getMessage();
    // }
    // heading.setVisible(false);
    // try{
    // Thread.sleep(300);
    // }
    // catch(Exception e){
    // e.getMessage();
    // }
    // heading.setVisible(true);
    // }

  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == clear) {
      userfield.setText("");
      passfield.setText("");
    }

    else if(e.getSource()==admin)
    { try{
           String username = userfield.getText();
       String password = passfield.getText();
       conn = DriverManager.getConnection(url, u, p);
       stm = conn.createStatement();
      ResultSet rs=stm.executeQuery("select* from Admin");
       while (rs.next()) {

        if (username.equals(rs.getString(1)) && password.equals(rs.getString(2))) 
        {
          
          new Admin();
          setVisible(false);
        }
      
    }
  }catch(SQLException qe){
            qe.printStackTrace();
  }
  }
    else if (e.getSource() == signin) {
    

      String username = userfield.getText();
      String password = passfield.getText();

      try {
        conn = DriverManager.getConnection(url, u, p);
        stm = conn.createStatement(); 
        ResultSet rs = stm.executeQuery("select* from signin");

        while (rs.next()) {

          if (username.equals(rs.getString(1)) && password.equals(rs.getString(2))) {  
            new Main(username);
            setVisible(false);
                          } 
      
    }
  }
      catch (SQLException qe) {
        qe.getMessage();
      }
    }

     else if (e.getSource() == signup) {

      setVisible(false);
      new SignUp().setVisible(true);
    }

    else if (e.getSource() == close) {
      System.exit(0);
    }
  
   
  }

  public static void main(String[] args) {
    new First();
  }

}

