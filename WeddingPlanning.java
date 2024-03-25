import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

public class WeddingPlanning implements ActionListener {
JFrame frame;
JLabel venueLabel, groomNameLabel, brideNameLabel, budgetLabel, foodLabel, dateLabel, personLabel, outputLabel;
JRadioButton venue1, venue2, venue3, venue4;
JTextField groomNameTextField, brideNameTextField, dateTextField;
JRadioButton budget1, budget2, budget3;
JCheckBox vegCheckBox, nonVegCheckBox;
JSlider personSlider;
JButton submitButton;
String uname;

String url = "jdbc:mysql://localhost:3306/devil";
String u = "root";
String p = "root";
Connection conn = null;
Statement stm = null;

public WeddingPlanning(String uname) {

   this.uname=uname;
frame = new JFrame("Wedding Planning Application");

frame.setTitle("Choosing Wedding theme"); 
frame.setVisible(true);
  

frame.setLayout(new GridLayout(30, 10));
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setBounds(100, 00, 1300, 800);

frame.getContentPane().setBackground(Color.CYAN);
               
Color color=new Color(155, 139 ,213);
frame.getContentPane().setBackground(color);

venueLabel = new JLabel("Select a venue:");
venue1 = new JRadioButton("Delhi");
venue2 = new JRadioButton("Mumbai");
venue3 = new JRadioButton("Patna");
venue4 = new JRadioButton("Jalandhar");
ButtonGroup venueGroup = new ButtonGroup();
venueGroup.add(venue1);
venueGroup.add(venue2);
venueGroup.add(venue3);
venueGroup.add(venue4);

groomNameLabel = new JLabel("Groom's name:");
groomNameTextField = new JTextField();
//groomNameTextField.setText("Enter Groom's Full Name");


brideNameLabel = new JLabel("Bride's name:");
brideNameTextField = new JTextField();
// brideNameTextField.setText("Enter Bride's Full Name");

budgetLabel = new JLabel("Select a budget:");
budget1 = new JRadioButton("50000");
budget2 = new JRadioButton("100000");
budget3 = new JRadioButton("150000");
ButtonGroup budgetGroup = new ButtonGroup();
budgetGroup.add(budget1);
budgetGroup.add(budget2);
budgetGroup.add(budget3);

foodLabel = new JLabel("Select food options:");
vegCheckBox = new JCheckBox("Vegetarian (600 per person)");
nonVegCheckBox = new JCheckBox("Non-vegetarian (800 per person)");

dateLabel = new JLabel("Enter the date of booking (DD/MM/YYYY):");
dateTextField = new JTextField();
dateTextField.setText("Enter DD/MM/YYYY");

personLabel = new JLabel( "Select number of Guest's (10-100):");
personSlider = new JSlider(JSlider.HORIZONTAL, 10, 100, 50);         
personSlider.setMajorTickSpacing(10);
personSlider.setPaintTicks(true);
personSlider.setLabelTable(personSlider.createStandardLabels(10));
personSlider.setPaintLabels(true);



submitButton = new JButton("Submit");
submitButton.addActionListener(this);

outputLabel = new JLabel("Booking");
frame.add(venueLabel);
frame.add(new JPanel());
frame.add(venue1);
frame.add(venue2);
frame.add(venue3);
frame.add(venue4);
frame.add(new JPanel());
frame.add(groomNameLabel);
frame.add(groomNameTextField);
frame.add(brideNameLabel);
frame.add(brideNameTextField);
frame.add(budgetLabel);
frame.add(new JPanel());
frame.add(budget1);
frame.add(budget2);
frame.add(budget3);
frame.add(new JPanel());
frame.add(foodLabel);
frame.add(new JPanel());
frame.add(vegCheckBox);
frame.add(nonVegCheckBox);
frame.add(dateLabel);
frame.add(dateTextField);
frame.add(personLabel);
frame.add(new JPanel());
frame.add(submitButton);

frame.setSize(1300, 700);
frame.setVisible(true);

}

public void actionPerformed(ActionEvent e) {
String venue = "";
if (venue1.isSelected()) {
venue =venue1.getText();
} else if (venue2.isSelected()) {
venue = venue2.getText();
} else if (venue3.isSelected()) {
venue = venue3.getText();
}else if (venue3.isSelected()) {
venue =venue3.getText();
}

String groomName = groomNameTextField.getText();
String brideName = brideNameTextField.getText();

int budget = 0;
if (budget1.isSelected()) {
budget = 50000;
} else if (budget2.isSelected()) {
budget = 100000;
} else if (budget3.isSelected()) {
budget = 150000;
}

int numGuests = personSlider.getValue();
String foodOptions = "";
if (vegCheckBox.isSelected()) {
foodOptions += "Vegetarian";
}
if (nonVegCheckBox.isSelected()) {
if (!foodOptions.equals("")) {
foodOptions += ", ";
}
foodOptions += "Non-Vegetarian";
}

String date = dateTextField.getText();

String output = "<html><body>";
output += "Venue: " + venue + "<br>";
output += "Groom's Name: " + groomName + "<br>";
output += "Bride's Name: " + brideName + "<br>";
output += "Budget: Rs. " + budget + "<br>";
output += "Number of Guests: " + numGuests + "<br>";
output += "Food Options: " + foodOptions + "<br>";
output += "Date of Booking: " + date + "<br>";
output += "</body></html>";

try{
    String query="insert into buyDetail values('"+uname+"','"+venue+"','"+groomName+"','"+brideName+"','"+budget+"','"+foodOptions+"','"+date+"')";
     conn=DriverManager.getConnection(url,u,p);
     stm=conn.createStatement();
     stm.execute(query);

     conn.close();
}
catch(SQLException qe){
    qe.printStackTrace();
}

JOptionPane.showMessageDialog(null, output);
JOptionPane.showMessageDialog(null,"Thankyou for choosing the theme , we'll contact with you soon for further process!\n\n          Returning to the home page");
outputLabel.setText(output);





frame.dispose();
new Main("");
}


public static void main(String[] args) {
new WeddingPlanning("");
}
}