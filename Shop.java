import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.FileWriter;

public class Shop extends JFrame implements ActionListener{
    public int ordernumber ;
    

    Container c ;
    static public ArrayList<String> list = new ArrayList<String>();
    JPanel panel;
    JTextField file ;
    JLabel enterline ;
    public int total = 0;
    public int today = 0;
    JButton addchart,order,endday,close,clearOrder;
    
    

    public Shop() {
        super("shop");
        c = getContentPane();
        
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(300,300));
        panel.setLayout(new FlowLayout());
        enterline = new JLabel("enter number of products");
        enterline.setHorizontalAlignment(JLabel.CENTER);

        file = new JTextField(20);
        file.addActionListener(this);

        addchart = new JButton("ADD TO CHART");
        addchart.addActionListener(this);
        order = new JButton("ORDER");
        order.addActionListener(this);
        endday = new JButton("END DAY");
        endday.addActionListener(this);
        clearOrder = new JButton("ClearOrder");
        clearOrder.addActionListener(this);
        close = new JButton("Close");
        close.addActionListener(this);


        
        panel.add(enterline);
        panel.add(file);
        panel.add(addchart);
        panel.add(order);
        panel.add(endday);
        panel.add(clearOrder);
        panel.add(close);
        c.add(panel);
        setSize(300, 250);
        setLocationRelativeTo(null);
        
        setLocation(900,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == file){
            String line = file.getText().trim() ;
            int ordernumber = Integer.parseInt(line) - 1;
            int dam = Integer.parseInt(EDITPRODUCT.productlist.get(ordernumber).sid );
            total += dam;
            
            file.setText("");
        }
        else if (e.getSource() == addchart){
            
            
            

            String line = file.getText().trim() ;
             ordernumber = Integer.parseInt(line) - 1;
            int dam = Integer.parseInt(EDITPRODUCT.productlist.get(ordernumber).sid );
            total += dam;
            saveToFile();
            JOptionPane.showMessageDialog(this,
            "add "+  EDITPRODUCT.productlist.get(ordernumber).name + " alrady" ,"add", JOptionPane.INFORMATION_MESSAGE);
            
            
            file.setText("");

        }
        else if ( e.getSource()== order){
            
            JOptionPane.showMessageDialog(this,
            "Total price is "+  total ,"Thankyou", JOptionPane.INFORMATION_MESSAGE);
            today += total;
            total = 0 ;
        }
        else if ( e.getSource()== endday){
            JOptionPane.showMessageDialog(this,
            "Total of today : "+  today ,"GOODBUY", JOptionPane.INFORMATION_MESSAGE);
            today = 0 ;
            total = 0 ;

        }
        else if ( e.getSource()== clearOrder){
            total = 0 ;
            file.setText("");

        }
        else if ( e.getSource()==close){
            dispose();
        }
    }
    private void saveToFile() {
		try{
			FileWriter out = new FileWriter ("orderHis.csv", true);
				
			
			
			out.write(EDITPRODUCT.productlist.get(ordernumber).name .toString()+","+EDITPRODUCT.productlist.get(ordernumber).sid.toString()+"\n");
			
				
			out.close();
				
		}
		catch(IOException e){
				e.printStackTrace();
		}
		
	}
}
