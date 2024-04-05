import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;

public class Manu extends JFrame implements ActionListener {
    Container c ;
    JButton guestButt , staffButt ,exitButt ;
    JPanel panel1 ;
    JLabel welcome ;
    Font myfont = new Font("Courier New", Font.BOLD, 22);
    
    Login staff ;

    

    public Manu() {
    super("Shoping online Programe"); // title
    c = getContentPane() ;
    c.setLayout(new FlowLayout());
    c.setBackground(Color.MAGENTA);
    panel1 = new JPanel();
    panel1.setBackground(Color.PINK);
    panel1.setPreferredSize(new Dimension(250,250));
    panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    welcome = new JLabel(">> Welcome <<");
    welcome.setPreferredSize(new Dimension(200, 50));
   // welcome.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    welcome.setHorizontalAlignment(JLabel.CENTER);
    welcome.setBounds(20,30,200,40);
    welcome.setFont(myfont);

    /*guestButt = new JButton("Guest");
    guestButt.setPreferredSize(new Dimension(90,100));
    guestButt.setBackground(new Color(255, 178, 102));
    guestButt.setBounds(50,100,70,70);
    guestButt.addActionListener(this); */
    staffButt = new JButton("Login");
    staffButt.setPreferredSize(new Dimension(90,100));
    staffButt.setBackground(Color.YELLOW);
    staffButt.addActionListener(this);
    staffButt.setBounds(60,100,120,70);
    exitButt = new JButton("Exit");
    exitButt.setBackground(Color.WHITE); 
    Dimension size = exitButt.getPreferredSize();
    exitButt.setBounds(200, 250, size.width, size.height);
    exitButt.addActionListener(this);
    exitButt.setBounds(90,190,70,40);

    panel1.setLayout(null);
    panel1.add(welcome);
   // panel1.add(guestButt);
    panel1.add(staffButt);
    panel1.add(exitButt);
    c.add(panel1);

    setLocationRelativeTo(null);
    setSize(300, 300);
    setLocation(500,200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

    

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== guestButt){
            
            //new AddUser();
            dispose();
            System.out.println("user");
        }

        else if (e.getSource()== staffButt){
            new Login();
            dispose();
            System.out.println("staff");
        }
        else if (e.getSource()== exitButt){
            dispose();
            System.out.println("exit");
        }

    }

 
    public static void main(String[] args) throws Exception {
      
        new Manu();
    } 
}



