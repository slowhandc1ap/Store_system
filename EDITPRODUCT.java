import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.FileWriter;

public class EDITPRODUCT extends JFrame {

	private JFrame frame;
	private JTextField name;
	private JTextField sid;
	private JTextField section;
	private JTextField enrollment;
	private JTable table;
	int row;

	static public ArrayList<Employee> productlist;
	 
	
	DefaultTableModel dtm;
	String header[]= new String[]{"N.o","Product Name","Price","product type"};
	

	
	public void displayDetails(){
		dtm.setRowCount(0);
		for(int i=0; i<productlist.size();i++){
			Object[] obj={i+1,productlist.get(i).name,productlist.get(i).sid,productlist.get(i).tel,productlist.get(i).age};
			//Object[] obj={AddUser.people.get(i),AddUser.gender.get(i),AddUser.phoneAr.get(i)};
			//System.out.println(productlist.get(i).name);
			
			dtm.addRow( obj);

		}
	}

	
	public EDITPRODUCT() {
		
       	
		initialize();
		productlist=new ArrayList<Employee>();
		dtm=new DefaultTableModel(header,0);
		table.setModel(dtm);
		frame.setVisible(true);
        
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setTitle("Edit Product");
		frame.getContentPane().setBackground(Color.GREEN);
		frame.setBounds(100, 100, 1079, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblStudentName = new JLabel("Product name");
		lblStudentName.setForeground(new Color(0, 0, 128));
		lblStudentName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStudentName.setBounds(29, 29, 102, 26);
		frame.getContentPane().add(lblStudentName);
		
		name = new JTextField();
		name.setBounds(127, 35, 111, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblStudentId = new JLabel("Price");
		lblStudentId.setForeground(new Color(0, 0, 128));
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStudentId.setBounds(29, 66, 102, 26);
		frame.getContentPane().add(lblStudentId);
		
		sid = new JTextField();
		sid.setColumns(10);
		sid.setBounds(127, 72, 111, 20);
		frame.getContentPane().add(sid);
		
		JLabel lblSection = new JLabel("type");
		lblSection.setForeground(new Color(0, 0, 128));
		lblSection.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSection.setBounds(29, 103, 102, 26);
		frame.getContentPane().add(lblSection);
		
		section = new JTextField();
		section.setColumns(10);
		section.setBounds(127, 109, 111, 20);
		frame.getContentPane().add(section);
		
		JLabel lblEnrollment = new JLabel("customer age");
		lblEnrollment.setForeground(new Color(0, 0, 128));
		lblEnrollment.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEnrollment.setBounds(29, 140, 102, 26);
		//frame.getContentPane().add(lblEnrollment);
		
		enrollment = new JTextField();
		enrollment.setColumns(10);
		enrollment.setBounds(127, 146, 111, 20);
		//frame.getContentPane().add(enrollment);
		
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Employee data=new Employee(name.getText(),sid.getText(),section.getText(),enrollment.getText());
				productlist.add(data);
				saveToFile();

				displayDetails();
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdd.setBounds(29, 194, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice=JOptionPane.showConfirmDialog(null, "Delete this data ?", "Delete",JOptionPane.YES_NO_OPTION);
				if(choice==0){
					dtm.removeRow(row);
					productlist.remove(row);
					displayDetails();
				}
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.setBounds(142, 194, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productlist.get(row).name=name.getText();
				productlist.get(row).sid=sid.getText();
				productlist.get(row).tel=section.getText();
				productlist.get(row).age=enrollment.getText();
				displayDetails();
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdate.setBounds(29, 232, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				name.setText("");
				sid.setText("");
				section.setText("");
				enrollment.setText("");
			}
		});
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRefresh.setBounds(142, 232, 89, 23);
		frame.getContentPane().add(btnRefresh);

		JButton back = new JButton("manu");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new manage();
				
			}

		});
		back.setFont(new Font("Tahoma", Font.BOLD, 12));
		back.setBounds(29, 260, 89, 23);
		frame.getContentPane().add(back);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdd.setBounds(29, 194, 89, 23);
		frame.getContentPane().add(btnAdd);

		JButton shop = new JButton("shop");
		shop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new Shop();
			}

		});
		shop.setFont(new Font("Tahoma", Font.BOLD, 12));
		shop.setBounds(29, 300, 89, 23);
		shop.setBackground(Color.CYAN);
		frame.getContentPane().add(shop);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(279, 36, 737, 339);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				row=table.getSelectedRow();
				
				name.setText(dtm.getValueAt(row, 0).toString());
				sid.setText(dtm.getValueAt(row, 1).toString());
				section.setText(dtm.getValueAt(row, 2).toString());
				enrollment.setText(dtm.getValueAt(row, 3).toString());
				
			}
		});
		scrollPane.setViewportView(table);
		
	}
	private void saveToFile() {
		try{
			FileWriter out = new FileWriter ("PRODUCTNEW.csv", true);
				
			
			out.write(productlist.get(productlist.size()-1).name.toString()+","+productlist.get(productlist.size()-1).sid.toString()+","+
			productlist.get(productlist.size()-1).tel.toString()+","+productlist.get(productlist.size()-1).age.toString()+"\n");
				
			out.close();
				
		}
		catch(IOException e){
				e.printStackTrace();
		}

	}
}
