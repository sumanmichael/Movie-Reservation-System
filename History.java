import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import net.proteanit.sql.*;
public class History {

	private JFrame frame;
	private JTable table;
	String username;
	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// 	EventQueue.invokeLater(new Runnable() {
	// 		public void run() {
	// 			try {
	// 				History window = new History();
	// 				window.frame.setVisible(true);
	// 			} catch (Exception e) {
	// 				e.printStackTrace();
	// 			}
	// 		}
	// 	});
	// }

	/**
	 * Create the application.
	 */
	public History(String username) {
		this.username=username;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 796, 448);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setContentPane(new JLabel(new ImageIcon("images//historypat.jpg")));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0,50,1366, 700);
		frame.getContentPane().add(scrollPane);
		
		JButton logout = new JButton("Home");
		logout.setBounds(1100,5,80,40);
		frame.add(logout);

		table = new JTable();
		table.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(table);
		try{
		    	Class.forName("oracle.jdbc.driver.OracleDriver");  
			  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","rgukt123");  
			  PreparedStatement ps = con.prepareStatement("select * from (select * from screen1 union select * from screen2 union select * from screen3 union select * from screen4) t where username=?");
			  ps.setString(1, username);
			  ResultSet rs = ps.executeQuery();
			  table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(table.getSelectedRow()>-1) {
					new Ticket(table.getValueAt(table.getSelectedRow(), 2).toString(),table.getValueAt(table.getSelectedRow(), 1).toString(),table.getValueAt(table.getSelectedRow(), 5).toString(),table.getValueAt(table.getSelectedRow(), 4).toString(),table.getValueAt(table.getSelectedRow(), 3).toString(),Double.parseDouble(table.getValueAt(table.getSelectedRow(), 6).toString()));
				}
			}
		});

		 logout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               frame.dispose();
               new Login();
            }
        });

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		//btnLoad.addActionListener((ActionListener) this);
		
		
		
	}
}
