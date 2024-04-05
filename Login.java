
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
//import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
//import java.io.IOException;
import java.io.FileWriter;
import java.io.LineNumberReader ;
//import java.io.FileReader;

public class Login extends JFrame  implements ActionListener {

    Container c ;
    JPanel panel ;
    JLabel singin , name ,  entername,enterpass;
    JPasswordField password ;
    JTextField username, surename ;
    JButton enter ;
    Font myfont = new Font("Courier New", Font.BOLD, 30);
    Font secFont = new Font("Courier New", Font.BOLD,18);
    Information staff = new Information();


    
    public Login() {

        super ("Admin") ; 

        c = getContentPane();
        c.setLayout(new FlowLayout());
        c.setBackground(new Color(182, 182, 182));

        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
        panel.setBackground(Color.ORANGE);
        panel.setPreferredSize(new Dimension(350,350));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

        singin = new JLabel("Login");
        singin.setFont(myfont);
        singin.setHorizontalAlignment(JLabel.CENTER);

        panel.add(singin);

        name = new JLabel("firstname                  surname");
        //name.setFont(myfont);
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setPreferredSize(new Dimension(300,30));


        entername = new JLabel("Please enter your name ");
        entername.setFont(secFont);
        entername.setPreferredSize(new Dimension(400,50));
        entername.setHorizontalAlignment(JLabel.CENTER);

        username = new JTextField(8);
        username.setPreferredSize(new Dimension(100,50));
        surename = new JTextField(8);
        surename.setPreferredSize(new Dimension(100,50));
        enter = new JButton("Login");
        enter.addActionListener(this);
        enter.setPreferredSize(new Dimension(190,50));
        enter.setBackground(Color.CYAN);
        enterpass = new JLabel("..Enter password..");
        enterpass.setFont(secFont);
        enterpass.setHorizontalAlignment(JLabel.CENTER);


        password = new JPasswordField(17);
        password.setPreferredSize(new Dimension(70,50));


        panel.add(singin);
        panel.add(entername);
        panel.add(name);
        panel.add(username);
        panel.add(surename);
        panel.add(enterpass);
        panel.add(password);
        panel.add(enter);
        c.add(panel);

        setSize(400, 400);
        setLocation(500,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == enter ) {
            saveStaff();
        }
        

    }

    public void saveStaff() {
        String pass = new String(password.getPassword());
        String nameStaff = username.getText().trim();
        String sureStaff = surename.getText().trim();
        staff.setName(nameStaff);
        staff.setSureName(sureStaff);
 
    
        if (pass.equals(Information.password)) {
            System.out.println("Correct");

            if( nameStaff.matches("^\\d+(\\.\\d+)?") ){

                System.out.println("not string");
                JOptionPane.showMessageDialog(this,
                "Names can be just string.  Plese try again  " ,"Message", JOptionPane.INFORMATION_MESSAGE);
                username.setText("");
    }
   
               
           else if(sureStaff.matches("^\\d+(\\.\\d+)?")){
               System.out.println("not string");
               JOptionPane.showMessageDialog(this,
               "Surename can be just string.  Plese try again  " ,"Message", JOptionPane.INFORMATION_MESSAGE);
               surename.setText("");
           }
           
           else if (name.equals("")||sureStaff.equals("")){
               JOptionPane.showMessageDialog(this,
               "Please write your first and last name.  " ,"Message", JOptionPane.INFORMATION_MESSAGE);
               
   
           }
           else {
            saveToFile() ;
            

            username.setText("");
            surename.setText("");}
            password.setText("");
            


        }


        else {JOptionPane.showMessageDialog(this,
            "Password incorrect...  " ,"Message", JOptionPane.INFORMATION_MESSAGE);
            password.setText("");}

    }
    private void saveToFile(){
        try{
            FileWriter out = new FileWriter ("Admin.csv", true);
            FileReader fr = new FileReader ("Admin.csv");
            LineNumberReader ln = new LineNumberReader(fr);
            System.out.println(ln);
            int lineCount = 1 ;
            
            while(ln.readLine() != null){
                lineCount++;
            }
            staff.setID(lineCount);
            String line ="0000" + String.valueOf(lineCount);

            //ArrayList<String> people = new ArrayList<String>();
            //people.add(user.toString());       
            out.write(line+"," + staff.toString()+"\n");
            
            //out.write(people+"\n");
            //out.flush();
            out.close();
            
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
        JOptionPane.showMessageDialog(this,
            "succeed","Message", JOptionPane.INFORMATION_MESSAGE);
        new manage();
        dispose();
        //setVisible(false);
        
    }
}
