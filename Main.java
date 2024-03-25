import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Main extends JFrame implements ActionListener {

    JMenuItem plan, limt, con, us, hom, login,order;
    JMenu home;
    JLabel image;
    JButton one, two, three, four, five, six, submit;
    JPanel toplan, detail1, contact, aboutus, Addtails,orderInfo;
    JTextArea feed;
    String url = "jdbc:mysql://localhost:3306/devil";
    String u = "root";
    String p = "root";
    String uname;

    JTable tablebuy=new JTable();
    DefaultTableModel model=new DefaultTableModel();
    Main(String username) {
        this.uname = username;

        setSize(1200, 700);
        setLocation(140, 50);
        setLayout(null);
        setResizable(false);
        setTitle("Wedding Plannar Application!");

        image = new JLabel();
        ImageIcon back = new ImageIcon("project\\images\\Untitled design.png");
        Image scale = back.getImage().getScaledInstance(1200, 700, Image.SCALE_DEFAULT);
        ImageIcon icon = new ImageIcon(scale);
        image.setIcon(icon);
        image.setBounds(0, 0, 1200, 700);
        add(image);

        JTextArea mainlabel = new JTextArea(
                "Congratulations on your upcoming wedding! A wedding planner can be an invaluable asset in ensuring that your special day is perfect and stress-free. From choosing the venue to selecting the flowers, a wedding planner can help you navigate the numerous decisions and details involved in planning a wedding.");
        mainlabel.setBounds(20, 200, 500, 400);
        mainlabel.setOpaque(false);
        mainlabel.setFont(new Font("Raleway", Font.BOLD, 23));
        mainlabel.setForeground(Color.green);
        mainlabel.setWrapStyleWord(true);
        mainlabel.setLineWrap(true);
        mainlabel.setEditable(false);
        image.add(mainlabel);

        JMenuBar bar = new JMenuBar();
        bar.setSize(1200, 100);
        setJMenuBar(bar);

        home = new JMenu("HOME");
        home.setFont(new Font("Tahoma", Font.BOLD, 15));
        home.setForeground(Color.red);
        bar.add(home);

        hom = new JMenuItem("HOME");
        hom.setFont(new Font("Tahoma", Font.BOLD, 15));
        hom.setForeground(Color.red);
        home.add(hom);
        hom.addActionListener(this);

        login = new JMenuItem("LOG_IN");
        login.setFont(new Font("Tahoma", Font.BOLD, 15));
        login.setForeground(Color.red);
        home.add(login);
        login.addActionListener(this);



        // ==================================//
        JMenu book = new JMenu("BOOK");
        book.setFont(new Font("Tahoma", Font.BOLD, 15));
        book.setForeground(Color.red);
        bar.add(book);

        plan = new JMenuItem("TOP_PLANS");
        plan.setFont(new Font("Tahoma", Font.BOLD, 15));
        plan.setForeground(Color.red);
        plan.addActionListener(this);
        book.add(plan);

        limt = new JMenuItem("LIMITED_OFFER");
        limt.setFont(new Font("Tahoma", Font.BOLD, 15));
        limt.setForeground(Color.red);
        book.add(limt);
        limt.addActionListener(this);

        // ================================//

        JMenu help = new JMenu("HELP");
        help.setFont(new Font("Tahoma", Font.BOLD, 15));
        help.setForeground(Color.red);
        bar.add(help);

        con = new JMenuItem("CONTACT");
        con.setFont(new Font("Tahoma", Font.BOLD, 15));
        con.setForeground(Color.red);
        con.addActionListener(this);
        help.add(con);

        us = new JMenuItem("ABOUT_US");
        us.setFont(new Font("Tahoma", Font.BOLD, 15));
        us.setForeground(Color.red);
        us.addActionListener(this);
        help.add(us);

        // ================================//

        JLabel iimmaaggee = new JLabel();
        ImageIcon iimm = new ImageIcon("project\\images\\icons8-wedding-100.png");
        Image iimmaa = iimm.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon iimmaagg = new ImageIcon(iimmaa);
        iimmaaggee.setIcon(iimmaagg);
        iimmaaggee.setBounds(130,30,70,100);
        image.add(iimmaaggee);
        JLabel title = new JLabel("Wedding Planner Welcomes You!");
        title.setBounds(180, 10, 1000, 150);
        title.setFont(new Font("Tahoma", Font.BOLD, 50));
        title.setForeground(Color.darkGray);
        image.add(title);

        // ====================================================
        // =====================================================

        toplan = new JPanel(null);
        toplan.setBounds(0, 0, 1200, 700);
        toplan.setBackground(Color.LIGHT_GRAY);
        add(toplan);

        JLabel lab1 = new JLabel();
        ImageIcon i1 = new ImageIcon("project\\images\\out.png");
        Image img = i1.getImage().getScaledInstance(400, 270, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(img);
        lab1.setIcon(i2);
        toplan.add(lab1);

        JLabel lab2 = new JLabel();
        ImageIcon i10 = new ImageIcon("project\\images\\ab.jpg");
        Image img10 = i10.getImage().getScaledInstance(400, 270, Image.SCALE_DEFAULT);
        ImageIcon i11 = new ImageIcon(img10);
        lab2.setIcon(i11);

        JLabel lab3 = new JLabel();
        ImageIcon i20 = new ImageIcon("project\\images\\pexels-jonathan-borba-6544769.jpg");
        Image img20 = i20.getImage().getScaledInstance(400, 270, Image.SCALE_DEFAULT);
        ImageIcon i21 = new ImageIcon(img20);
        lab3.setIcon(i21);
        // toplan.add(lab3);

        JLabel lab4 = new JLabel();
        ImageIcon i30 = new ImageIcon("project\\images\\pexels-atul-maurya-1042152.jpg");
        Image img30 = i30.getImage().getScaledInstance(400, 270, Image.SCALE_DEFAULT);
        ImageIcon i31 = new ImageIcon(img30);
        lab4.setIcon(i31);

        JLabel heading = new JLabel("These are our top plans ,click for more information!", JLabel.CENTER);

        heading.setFont(new Font("Serif", Font.BOLD, 24));
        heading.setBounds(0, 0, 1200, 50);
        heading.setOpaque(true);
        heading.setBackground(Color.black);
        heading.setForeground(Color.yellow);
        toplan.add(heading);

        one = new JButton();
        one.setBackground(Color.white);
        one.add(lab1);
        toplan.add(one);
        one.setBounds(150, 50, 400, 270);
        one.addActionListener(this);

        two = new JButton();
        two.setBackground(Color.white);
        two.add(lab2);
        toplan.add(two);
        two.setBounds(650, 50, 400, 270);
        two.addActionListener(this);

        three = new JButton();
        three.setBackground(Color.white);
        three.add(lab3);
        toplan.add(three);
        three.setBounds(150, 350, 400, 270);
        three.addActionListener(this);

        four = new JButton();
        four.setBackground(Color.white);
        four.add(lab4);
        toplan.add(four);
        four.setBounds(650, 350, 400, 270);
        four.addActionListener(this);

        

        toplan.setVisible(false);

        // ================================================
            
        // =================================================

        contact = new JPanel(null);
        contact.setBounds(0, 0, 1300, 700);
        add(contact);

        // ===========================================
        JPanel headcon = new JPanel(null);
        headcon.setBounds(0, 0, 1200, 100);
        headcon.setBackground(Color.black);
        contact.add(headcon);

        JLabel contitle = new JLabel("Contact For Booking Related Queries");
        contitle.setFont(new Font("Serif", Font.BOLD, 40));
        contitle.setBounds(40, 10, 1200, 80);
        contitle.setForeground(Color.white);
        // contitle.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        headcon.add(contitle);

        JLabel header = new JLabel("Contact Us");
        header.setBounds(50, 60, 900, 70);
        header.setFont(new Font("Serif", Font.BOLD, 25));
        header.setForeground(Color.white);

        JPanel conus = new JPanel(null);
        conus.setBounds(0, 100, 1200, 500);
        conus.add(header);
        conus.setBackground(new Color(233, 181, 2));
        contact.add(conus);
        // header.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel abhay = new JLabel("Mobile No. :+91 85807-14580  Abhay Verma");
        abhay.setFont(new Font("Serif", Font.BOLD, 25));
        abhay.setBounds(50, 150, 600, 50);
        conus.add(abhay);

        JLabel nikhil = new JLabel("Mobile No. :+91 91994-40746  Nikhil Nitin");
        nikhil.setFont(new Font("Serif", Font.BOLD, 25));
        nikhil.setBounds(50, 220, 600, 50);
        conus.add(nikhil);

        JLabel email = new JLabel("Email us :");
        email.setBounds(50, 310, 600, 50);
        email.setFont(new Font("Serif", Font.BOLD, 25));
        email.setForeground(Color.white);
        conus.add(email);

        JLabel abhayemail = new JLabel("www.abhayaturdoor@gmail.com");
        abhayemail.setBounds(50, 380, 600, 50);
        abhayemail.setFont(new Font("Serif", Font.BOLD, 25));
        conus.add(abhayemail);

        JLabel nikhilemail = new JLabel("www.nikhil12@gmail.com");
        nikhilemail.setBounds(50, 450, 600, 50);
        nikhilemail.setFont(new Font("Serif", Font.BOLD, 25));
        conus.add(nikhilemail);

        JPanel couple = new JPanel(null);
        couple.setBounds(750, 75, 351, 351);
        JLabel laade = new JLabel();
        ImageIcon iconimage = new ImageIcon("project\\images\\couple.jpg");
        Image imgcouple = iconimage.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
        ImageIcon icon10 = new ImageIcon(imgcouple);
        laade.setSize(350, 350);
        laade.setIcon(icon10);
        couple.add(laade);
        conus.add(couple);

        JPanel footer = new JPanel(null);
        footer.setBounds(0, 600, 1200, 100);
        footer.setBackground(Color.black);

        contact.add(footer);
        contact.setVisible(false);

        aboutus = new JPanel(null);
        aboutus.setBackground(Color.black);
        aboutus.setBounds(0, 0, 1200, 700);
        add(aboutus);

        JLabel line = new JLabel("About Us!");
        line.setBounds(50, 20, 1200, 50);
        line.setFont(new Font("DIALOG_INPUT", Font.BOLD, 30));
        line.setForeground(Color.yellow);
        aboutus.add(line);

        JPanel history = new JPanel(null);
        history.setBounds(0, 100, 1200, 600);
        history.setBackground(Color.yellow);

        JTextArea ta = new JTextArea(
                "Welcome to our wedding planning system! Our purpose is to help engaged couples plan their dream wedding with ease and convenience. Our target audience is anyone who is planning a wedding, whether it's a small and intimate gathering or a grand celebration.Using our system offers a range of benefits, including saving time and reducing stress. With everything in one place, you can easily keep track of your wedding planning progress and have peace of mind knowing that all the details are taken care of. We are constantly updating and improving our system to ensure that it remains the best wedding planning tool on the market. Thank you for considering our system for your special day!");
        ta.setEditable(false);
        ta.setForeground(Color.black);
        ta.setFont(new Font("Serif", Font.BOLD, 20));
        ta.setLineWrap(true);
        ta.setOpaque(true);
        ta.setBackground(Color.yellow);
        ta.setWrapStyleWord(true);
        ta.setBounds(10, 50, 680, 380);
        history.add(ta);

        JTextArea socials = new JTextArea();
        socials.setBounds(750, 50, 300, 50);
        socials.setText("Insta Handle : abhayverma@2002");
        socials.setEditable(false);

        socials.setOpaque(true);
        socials.setBackground(Color.yellow);
        socials.setForeground(Color.black);
        socials.setFont(new Font("Serif", Font.BOLD, 20));
        history.add(socials);

        feed = new JTextArea();
        feed.setBounds(750, 160, 270, 300);
        feed.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        feed.setForeground(Color.black);
        feed.setFont(new Font("Serif", Font.BOLD, 20));
        feed.setLineWrap(true);
        feed.setWrapStyleWord(true);
        feed.setOpaque(true);
        feed.setBackground(Color.yellow);
        history.add(feed);

        submit = new JButton("Submit");
        submit.setBounds(850, 470, 100, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.yellow);
        submit.addActionListener(this);
        history.add(submit);

        JLabel share = new JLabel("Share feedback here!");
        share.setBounds(750, 100, 250, 50);
        share.setForeground(Color.black);
        share.setFont(new Font("DIALOG_INPUT", Font.BOLD, 25));
        history.add(share);

        aboutus.add(history);
        aboutus.setVisible(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent w) {

         String feedback=feed.getText();

        if (w.getSource() == plan) {
            image.setVisible(false);
            toplan.setVisible(true);
            contact.setVisible(false);
            aboutus.setVisible(false);
            // new Toplan();

        } else if (w.getSource() == limt) {

            JOptionPane.showMessageDialog(this,"Sorry,No offers for now!");

        } else if (w.getSource() == con) {
            image.setVisible(false);
            toplan.setVisible(false);
            contact.setVisible(true);

        } else if (w.getSource() == us) {
            image.setVisible(false);
            contact.setVisible(false);
            toplan.setVisible(false);

            aboutus.setVisible(true);

        } else if (w.getSource() == hom) {
            image.setVisible(true);
            contact.setVisible(false);
            aboutus.setVisible(false);
            toplan.setVisible(false);
        } else if (w.getSource() == login) {
            new First();
            setVisible(false);
        }

        else if (w.getSource() == one || w.getSource() == two || w.getSource() == three || w.getSource() == three
                || w.getSource() == four || w.getSource() == five || w.getSource() == six) {

         new WeddingPlanning(uname);

        } else if (w.getSource() == submit) {

            JOptionPane.showMessageDialog(this, "Thank you for sharing your valuable feedback!");
            try {

                Connection con = DriverManager.getConnection(url, u, p);
                Statement stm = con.createStatement();
                stm.execute("insert into feeds values('" + uname + "','" + feedback + "')");
                con.close();

            } catch (SQLException excep) {
                excep.printStackTrace();
            }
           
            feed.setText("");
        }

    }

    public static void main(String[] args) {
        new Main("");
    }
}
