import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;

public class manage extends JFrame implements ActionListener{
    Container c ;
    JPanel panel , toppanel,belowPanel;
    JLabel announce ;
    JButton addUser , addStaff , addProduct , Shop , editProduct ,editStaff,exit;
    Font myfont = new Font("Courier New", Font.BOLD, 22);


    public manage(){
        super(" >>>> manage manu <<<<") ;
        c = getContentPane() ;
        
        c.setLayout(new FlowLayout());
        c.setBackground(Color.PINK);
        panel = new JPanel();
        toppanel = new JPanel();
        toppanel.setPreferredSize(new Dimension(650,80));
        toppanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        announce = new JLabel("maneger manu");
        announce.setFont(myfont);
        announce.setHorizontalAlignment(JLabel.CENTER);
        toppanel.add(announce);

        panel.setPreferredSize(new Dimension(650,550));
        panel.setLayout(new GridLayout(2,2));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panel.setBackground(Color.WHITE);

        addUser = new JButton("User");
        addUser.setPreferredSize(new Dimension(100,100));
        addUser.setBackground(Color.YELLOW);
        addUser.setFont(myfont);
        addUser.addActionListener(this);


        addStaff = new JButton("Staff");
        addStaff.setPreferredSize(new Dimension(100,100));
        addStaff.setBackground(Color.YELLOW);
        addStaff.setFont(myfont);
        addStaff.addActionListener(this);

        addProduct = new JButton("Product");
        addProduct.setPreferredSize(new Dimension(100,100));
        addProduct.setBackground(Color.YELLOW);
        addProduct.setFont(myfont);
        addProduct.addActionListener(this);

        exit = new JButton("Exit");
        exit.setPreferredSize(new Dimension(100,100));
        exit.setBackground(Color.ORANGE);
        exit.setFont(myfont);
        exit.addActionListener(this);
        

        

        
        panel.add(addUser);
        
        panel.add(addStaff);
        
        panel.add(addProduct);
        panel.add(exit);
        //panel.add(editProduct);

        belowPanel = new JPanel();
        belowPanel.setPreferredSize(new Dimension(200,200));
        belowPanel.setBackground(Color.PINK);
        

        
        

        c.add(toppanel);
        c.add(panel);
        c.add(belowPanel);
        setLocationRelativeTo(null);
        setSize(700, 760);
        setLocation(500,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        System.out.println(EDITPRODUCT.productlist);

    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == addUser){
            new EDITUSER();
            
            dispose();
        }
        else if (e.getSource() == addStaff){
            new EDITSTAFF();
            dispose();
        }
        else if (e.getSource() == addProduct){
            new EDITPRODUCT();
            
            dispose();
        }
        
        else if (e.getSource() == exit){
            
            dispose();
        }
        /*
        else if (e.getSource() == editStaff){
            new EditStaff();
            dispose();
        }
        else if (e.getSource() == shop){
            new USEREDIT();
            dispose();
        }
        */

    }

    
}
