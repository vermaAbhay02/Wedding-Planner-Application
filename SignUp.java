import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SignUp extends JFrame implements ActionListener{
  
JRadioButton male,female;
JTextField namel,namef,userfield;
JPasswordField passfield,confirmfield;
String url="jdbc:mysql://localhost:3306/devil";
String u="root";
String p="root";
Connection conn=null;
Statement stm=null;

JButton submit;
    SignUp() {

        setTitle("Sign Up Form");
        setSize(650,700);
        setLocation(400, 100);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel bg=new JLabel();
        ImageIcon i=new ImageIcon("project\\images\\pexels-jess-bailey-designs-1172849.jpg");
        Image img=i.getImage().getScaledInstance(650,700,Image.SCALE_DEFAULT);
        ImageIcon ii=new ImageIcon(img);
        bg.setIcon(ii);
        bg.setBounds(0,0,650,700);
        add(bg);

        JLabel head=new JLabel("SignUp Form");
        head.setBounds(190,50,300,50);
        head.setFont(new Font("Serif",Font.BOLD,40));
        bg.add(head);
           
        JLabel fname=new JLabel("FirstName:");
        fname.setBounds(130,150,100,30); 
        fname.setFont(new Font("Raleway",Font.BOLD,19));
        bg.add(fname);

        namef=new JTextField();
        namef.setBounds(260,150,200,30);
        namef.setFont(new Font("Raleway",Font.BOLD,15));
        bg.add(namef);

        JLabel lname =new JLabel("LastName:");
        lname.setBounds(130,220,100,30); 
        lname.setFont(new Font("Raleway",Font.BOLD,19));
        bg.add(lname);

        namel=new JTextField();
        namel.setBounds(260,220,200,30);
        namel.setFont(new Font("Raleway",Font.BOLD,15));
        bg.add(namel);

        JLabel gender =new JLabel("Gender:");
        gender.setBounds(152,290,100,30); 
        gender.setFont(new Font("Raleway",Font.BOLD,19));
        bg.add(gender);
   
        male=new JRadioButton("Male");
        male.setFont(new Font("Raleway",Font.BOLD,15));
        male.setBounds(270,290,100,30);
       // male.setBackground(Color.);
        male.addActionListener(this);
        bg.add(male);

        female=new JRadioButton("Female");
        female.setBounds(370,290,100,30);
        female.setFont(new Font("Raleway",Font.BOLD,15));
    //    female.setBackground(Color.WHITE);
        male.addActionListener(this);
        bg.add(female);

        ButtonGroup gengroup=new ButtonGroup();
        gengroup.add(male);
        gengroup.add(female);

        JLabel user=new JLabel("Set Username:");
        user.setBounds(92,370,290,30);
        user.setFont(new Font("Raleway",Font.BOLD,19));
        bg.add(user);

        userfield=new JTextField();
        userfield.setBounds(260,370,200,30);
        userfield.setFont(new Font("Raleway",Font.BOLD,19));
        bg.add(userfield);

        JLabel pass=new JLabel("Set Password:");
        pass.setBounds(92,420,290,30);
        pass.setFont(new Font("Raleway",Font.BOLD,19));
        bg.add(pass);

        passfield=new JPasswordField();
        passfield.setBounds(260,420,200,30);
        passfield.setFont(new Font("Raleway",Font.BOLD,19));
        bg.add(passfield);

        JLabel confirm=new JLabel("Confirm Password:");
        confirm.setBounds(48,470,180,30);
        confirm.setFont(new Font("Raleway",Font.BOLD,19));
        bg.add(confirm);

        confirmfield=new JPasswordField();
        confirmfield.setBounds(260,470,200,30);
        confirmfield.setFont(new Font("Raleway",Font.BOLD,19));
        bg.add(confirmfield);

        submit=new JButton("SignUp");
        submit.setBounds(220,580,150,30);
        submit.setFont(new Font("Arial",Font.BOLD,18));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        bg.add(submit);
        
        
        setVisible(true);
    }
public void actionPerformed(ActionEvent e){
if(e.getSource()==submit) 
{  
    String first=namef.getText();
    String last=namel.getText();
    String user=userfield.getText();
    String pass=passfield.getText();
    String conpass=confirmfield.getText();
    String gender=null;
    if(!conpass.equals(pass)){
        JOptionPane.showMessageDialog(this,"Password does not match!");

    }
    else{
    if(male.isSelected())
    {
        gender="Male";
    }
    else if(female.isSelected()){
        gender="Female";
    }
    
     try{
                if(first.equals("")||last.equals("")||user.equals("")||pass.equals(""))
                {
                JOptionPane.showMessageDialog(this,"Please fill every field");
                
                }
            
            conn=DriverManager.getConnection(url,u,p);
            stm=conn.createStatement(); 
            stm.execute("insert into signup values('"+first+"','"+last+"','"+gender+"','"+user+"','"+pass+"')");
            stm.execute("insert into signin values('"+user+"','"+pass+"')");   
            
            JOptionPane.showMessageDialog(this,"SignUp done moving to login page");
            setVisible(false);
            new First().setVisible(true);
            
            conn.close();
        }
    
       catch(SQLException a)
       {         
              a.printStackTrace();
       }
    }

}

}
    public static void main(String[] args) {
        new SignUp();
    }

}
