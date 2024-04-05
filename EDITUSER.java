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

public class EDITUSER extends JFrame {
	

	private JFrame frame;
	private JTextField name;
	private JTextField sid;
	private JTextField section;
	private JTextField enrollment;
	private JTable table;
	
	int row;
	ArrayList<Employee> coustomerlist;
	DefaultTableModel dtm;
	String header[]= new String[]{"Customer Name","Customer ID","Tel","Age"};
	

	
	public void displayDetails(){
		dtm.setRowCount(0);
		for(int i=0; i<coustomerlist.size();i++){
			Object[] obj={coustomerlist.get(i).name,coustomerlist.get(i).sid,coustomerlist.get(i).tel,coustomerlist.get(i).age};
			//Object[] obj={AddUser.people.get(i),AddUser.gender.get(i),AddUser.phoneAr.get(i)};
			System.out.println(coustomerlist.get(i).sid);
			
			dtm.addRow(obj);

		}
	}

	/**
	 * Create the application.
	 */
	public EDITUSER() {
		super("edit user");
		initialize();
		coustomerlist=new ArrayList<>();
		dtm=new DefaultTableModel(header,0);
		table.setModel(dtm);
		frame.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Edit Customer");
		frame.getContentPane().setBackground(Color.PINK);
		frame.setBounds(100, 100, 1079, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblStudentName = new JLabel("Customer name");
		lblStudentName.setForeground(new Color(0, 0, 128));
		lblStudentName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStudentName.setBounds(29, 29, 102, 26);
		frame.getContentPane().add(lblStudentName);
		
		name = new JTextField();
		name.setBounds(127, 35, 111, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblStudentId = new JLabel("Customer  ID");
		lblStudentId.setForeground(new Color(0, 0, 128));
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStudentId.setBounds(29, 66, 102, 26);
		frame.getContentPane().add(lblStudentId);
		
		sid = new JTextField();
		sid.setColumns(10);
		sid.setBounds(127, 72, 111, 20);
		frame.getContentPane().add(sid);
		
		JLabel lblSection = new JLabel("tel");
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
		frame.getContentPane().add(lblEnrollment);
		
		enrollment = new JTextField();
		enrollment.setColumns(10);
		enrollment.setBounds(127, 146, 111, 20);
		frame.getContentPane().add(enrollment);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Employee data=new Employee(name.getText(),sid.getText(),section.getText(),enrollment.getText());
				coustomerlist.add(data);
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
					coustomerlist.remove(row);
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
				coustomerlist.get(row).name=name.getText();
				coustomerlist.get(row).sid=sid.getText();
				coustomerlist.get(row).tel=section.getText();
				coustomerlist.get(row).age=enrollment.getText();
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
			FileWriter out = new FileWriter ("USERNEW.csv", true);
				
			
			//for(int i=0; i< coustomerlist.size(); i++) {
			out.write(coustomerlist.get(coustomerlist.size()-1).name.toString()+","+coustomerlist.get(coustomerlist.size()-1).sid.toString()+","+"(+66)"+coustomerlist.get(coustomerlist.size()-1).tel.toString()+","+coustomerlist.get(coustomerlist.size()-1).age.toString()+"\n");
			//}
				
			out.close();
				
		}
		catch(IOException e){
				e.printStackTrace();
		}
		
	}

}
