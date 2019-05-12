
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class Seats implements ActionListener {

	private JButton[] buts = new JButton[114];
	private JFrame frame;
	private JLabel lblSeats;
	private JLabel lblFare;
	private String username;
	private String seat_string;
	private String date;
	private String tslot;
	private String screen_no;
	private String movie_name;
	int seat_n=0;
	double fare=0;
	Vector<String> v = new Vector<String>();
	Vector<String> res = new Vector<String>();
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				//	new Seats("suman","screen1",1,"Majil");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public Seats(String username,String screen_no,String movie_name,String tslot,String date) {
		this.username=username;
		this.date=date;
		this.screen_no=screen_no;
		this.tslot=tslot;
		this.movie_name=movie_name;
		initialize();

		
		

		this.frame.setVisible(true);
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 1386, 737);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setContentPane(new JLabel(new ImageIcon("images//seatpat.jpg")));
		
		lblSeats = new JLabel("Selected Seats : "+seat_n);
		lblSeats.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblSeats.setForeground(Color.WHITE);
		lblSeats.setBounds(750, 10, 161, 49);
		frame.getContentPane().add(lblSeats);
		
		lblFare = new JLabel("Fare : Rs. "+fare);
		lblFare.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblFare.setBounds(750, 35, 161, 49);
		lblFare.setForeground(Color.WHITE);
		frame.getContentPane().add(lblFare);
		
		JLabel lblA = new JLabel("A");
		lblA.setFont(new Font("Royal Crescent", Font.PLAIN, 15));
		lblA.setBounds(80, 178, 19, 24);
		frame.getContentPane().add(lblA);
		
		JLabel lblB = new JLabel("B");
		lblB.setFont(new Font("Royal Crescent", Font.PLAIN, 15));
		lblB.setBounds(80, 242, 19, 24);
		frame.getContentPane().add(lblB);
		
		JLabel lblC = new JLabel("C");
		lblC.setFont(new Font("Royal Crescent", Font.PLAIN, 15));
		lblC.setBounds(80, 312, 19, 24);
		frame.getContentPane().add(lblC);
		
		JLabel lblD = new JLabel("D");
		lblD.setFont(new Font("Royal Crescent", Font.PLAIN, 15));
		lblD.setBounds(80, 380, 19, 24);
		frame.getContentPane().add(lblD);
		
		JLabel lblE = new JLabel("E");
		lblE.setFont(new Font("Royal Crescent", Font.PLAIN, 15));
		lblE.setBounds(80, 448, 19, 24);
		frame.getContentPane().add(lblE);
		
		JLabel lblF = new JLabel("F");
		
		lblF.setFont(new Font("Royal Crescent", Font.PLAIN, 15));
		lblF.setBounds(80, 516, 19, 24);
		frame.getContentPane().add(lblF);
		
		
		JButton btnBook = new JButton("BOOK");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				  Class.forName("oracle.jdbc.driver.OracleDriver");  
				  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","rgukt123");  
                  PreparedStatement ps = con.prepareStatement("insert into "+screen_no+" values(?,?,?,?,?,?,?)"); 
//                  ps.setString(1, screen_no);
                  ps.setString(1, username);
                  ps.setString(2, screen_no);
                  ps.setString(3,movie_name);
                  ps.setString(4,tslot);
                  ps.setString(5,date);
                  ps.setString(6,seat_string);
                  ps.setFloat(7,(float)fare);
                  
                  ps.executeUpdate();
                  new Ticket(movie_name,screen_no,seat_string,date,tslot,fare);
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				                   
				
				
				
			}
		});
		btnBook.setBounds(948, 23, 108, 40);
		frame.getContentPane().add(btnBook);
		
		buts[0] = new JButton("A1");
		buts[0].setBounds(109, 168, 52, 47);
		frame.getContentPane().add(buts[0]);
		
		buts[1] = new JButton("A2");
		buts[1].setBounds(164, 168, 52, 47);
		frame.getContentPane().add(buts[1]);
		
		buts[2] = new JButton("A3");
		buts[2].setBounds(219, 168, 52, 47);
		frame.getContentPane().add(buts[2]);
		
		buts[3] = new JButton("A4");
		buts[3].setBounds(274, 168, 52, 47);
		frame.getContentPane().add(buts[3]);
		
		buts[4] = new JButton("A8");
		buts[4].setBounds(564, 168, 52, 47);
		frame.getContentPane().add(buts[4]);
		
		buts[5] = new JButton("A7");
		buts[5].setBounds(509, 168, 52, 47);
		frame.getContentPane().add(buts[5]);
		
		buts[6] = new JButton("A6");
		buts[6].setBounds(454, 168, 52, 47);
		frame.getContentPane().add(buts[6]);
		
		buts[7] = new JButton("A5");
		buts[7].setBounds(329, 168, 52, 47);
		frame.getContentPane().add(buts[7]);
		
		buts[8] = new JButton("A12");
		buts[8].setBounds(784, 168, 52, 47);
		frame.getContentPane().add(buts[8]);
		
		buts[9] = new JButton("A11");
		buts[9].setBounds(729, 168, 52, 47);
		frame.getContentPane().add(buts[9]);
		
		buts[10] = new JButton("A10");
		buts[10].setBounds(674, 168, 52, 47);
		frame.getContentPane().add(buts[10]);
		
		buts[11] = new JButton("A9");
		buts[11].setBounds(619, 168, 52, 47);
		frame.getContentPane().add(buts[11]);
		
		buts[12] = new JButton("A16");
		buts[12].setBounds(1081, 168, 52, 47);
		frame.getContentPane().add(buts[12]);
		
		buts[13] = new JButton("A15");
		buts[13].setBounds(1026, 168, 52, 47);
		frame.getContentPane().add(buts[13]);
		
		buts[14] = new JButton("A14");
		buts[14].setBounds(894, 168, 52, 47);
		frame.getContentPane().add(buts[14]);
		
		buts[15] = new JButton("A13");
		buts[15].setBounds(839, 168, 52, 47);
		frame.getContentPane().add(buts[15]);
		
		buts[16] = new JButton("A19");
		buts[16].setBounds(1246, 168, 52, 47);
		frame.getContentPane().add(buts[16]);
		
		buts[17] = new JButton("A18");
		buts[17].setBounds(1191, 168, 52, 47);
		frame.getContentPane().add(buts[17]);
		
		buts[18] = new JButton("A17");
		buts[18].setBounds(1136, 168, 52, 47);
		frame.getContentPane().add(buts[18]);
		
		buts[19] = new JButton("B1");
		buts[19].setBounds(109, 236, 52, 47);
		frame.getContentPane().add(buts[19]);
		
		buts[20] = new JButton("B2");
		buts[20].setBounds(164, 236, 52, 47);
		frame.getContentPane().add(buts[20]);
		
		buts[21] = new JButton("B3");
		buts[21].setBounds(219, 236, 52, 47);
		frame.getContentPane().add(buts[21]);
		
		buts[22] = new JButton("B4");
		buts[22].setBounds(274, 236, 52, 47);
		frame.getContentPane().add(buts[22]);
		
		buts[23] = new JButton("B5");
		buts[23].setBounds(329, 236, 52, 47);
		frame.getContentPane().add(buts[23]);
		
		buts[24] = new JButton("B6");
		buts[24].setBounds(454, 236, 52, 47);
		frame.getContentPane().add(buts[24]);
		
		buts[25] = new JButton("B7");
		buts[25].setBounds(509, 236, 52, 47);
		frame.getContentPane().add(buts[25]);
		
		buts[26] = new JButton("B8");
		buts[26].setBounds(564, 236, 52, 47);
		frame.getContentPane().add(buts[26]);
		
		buts[27] = new JButton("B9");
		buts[27].setBounds(619, 236, 52, 47);
		frame.getContentPane().add(buts[27]);
		
		buts[28] = new JButton("B10");
		buts[28].setBounds(674, 236, 52, 47);
		frame.getContentPane().add(buts[28]);
		
		buts[29] = new JButton("B11");
		buts[29].setBounds(729, 236, 52, 47);
		frame.getContentPane().add(buts[29]);
		
		buts[30] = new JButton("B12");
		buts[30].setBounds(784, 236, 52, 47);
		frame.getContentPane().add(buts[30]);
		
		buts[31] = new JButton("B13");
		buts[31].setBounds(839, 236, 52, 47);
		frame.getContentPane().add(buts[31]);
		
		buts[32] = new JButton("B14");
		buts[32].setBounds(894, 236, 52, 47);
		frame.getContentPane().add(buts[32]);
		
		buts[33] = new JButton("B15");
		buts[33].setBounds(1026, 236, 52, 47);
		frame.getContentPane().add(buts[33]);
		
		buts[34] = new JButton("B16");
		buts[34].setBounds(1081, 236, 52, 47);
		frame.getContentPane().add(buts[34]);
		
		buts[35] = new JButton("B17");
		buts[35].setBounds(1136, 236, 52, 47);
		frame.getContentPane().add(buts[35]);
		
		buts[36] = new JButton("B18");
		buts[36].setBounds(1191, 236, 52, 47);
		frame.getContentPane().add(buts[36]);
		
		buts[37] = new JButton("B19");
		buts[37].setBounds(1246, 236, 52, 47);
		frame.getContentPane().add(buts[37]);
		
		buts[38] = new JButton("C1");
		buts[38].setBounds(109, 306, 52, 47);
		frame.getContentPane().add(buts[38]);
		
		buts[39] = new JButton("C2");
		buts[39].setBounds(164, 306, 52, 47);
		frame.getContentPane().add(buts[39]);
		
		buts[40] = new JButton("C3");
		buts[40].setBounds(219, 306, 52, 47);
		frame.getContentPane().add(buts[40]);
		
		buts[41] = new JButton("C4");
		buts[41].setBounds(274, 306, 52, 47);
		frame.getContentPane().add(buts[41]);
		
		buts[45] = new JButton("C5");
		buts[45].setBounds(329, 306, 52, 47);
		frame.getContentPane().add(buts[45]);
		
		buts[42] = new JButton("C6");
		buts[42].setBounds(454, 306, 52, 47);
		frame.getContentPane().add(buts[42]);
		
		buts[43] = new JButton("C7");
		buts[43].setBounds(509, 306, 52, 47);
		frame.getContentPane().add(buts[43]);
		
		buts[44] = new JButton("C8");
		buts[44].setBounds(564, 306, 52, 47);
		frame.getContentPane().add(buts[44]);
		
		buts[46] = new JButton("C9");
		buts[46].setBounds(619, 306, 52, 47);
		frame.getContentPane().add(buts[46]);
		
		buts[47] = new JButton("C10");
		buts[47].setBounds(674, 306, 52, 47);
		frame.getContentPane().add(buts[47]);
		
		buts[48] = new JButton("C11");
		buts[48].setBounds(729, 306, 52, 47);
		frame.getContentPane().add(buts[48]);
		
		buts[49] = new JButton("C12");
		buts[49].setBounds(784, 306, 52, 47);
		frame.getContentPane().add(buts[49]);
		
		buts[52] = new JButton("C13");
		buts[52].setBounds(839, 306, 52, 47);
		frame.getContentPane().add(buts[52]);
		
		buts[53] = new JButton("C14");
		buts[53].setBounds(894, 306, 52, 47);
		frame.getContentPane().add(buts[53]);
		
		buts[50] = new JButton("C15");
		buts[50].setBounds(1026, 306, 52, 47);
		frame.getContentPane().add(buts[50]);
		
		buts[51] = new JButton("C16");
		buts[51].setBounds(1081, 306, 52, 47);
		frame.getContentPane().add(buts[51]);
		
		buts[54] = new JButton("C17");
		buts[54].setBounds(1136, 306, 52, 47);
		frame.getContentPane().add(buts[54]);
		
		buts[55] = new JButton("C18");
		buts[55].setBounds(1191, 306, 52, 47);
		frame.getContentPane().add(buts[55]);
		
		buts[56] = new JButton("C19");
		buts[56].setBounds(1246, 306, 52, 47);
		frame.getContentPane().add(buts[56]);
		
		buts[57] = new JButton("D1");
		buts[57].setBounds(109, 374, 52, 47);
		frame.getContentPane().add(buts[57]);
		
		buts[58] = new JButton("D2");
		buts[58].setBounds(164, 374, 52, 47);
		frame.getContentPane().add(buts[58]);
		
		buts[59] = new JButton("D3");
		buts[59].setBounds(219, 374, 52, 47);
		frame.getContentPane().add(buts[59]);
		
		buts[60] = new JButton("D4");
		buts[60].setBounds(274, 374, 52, 47);
		frame.getContentPane().add(buts[60]);
		
		buts[61] = new JButton("D8");
		buts[61].setBounds(564, 374, 52, 47);
		frame.getContentPane().add(buts[61]);
		
		buts[62] = new JButton("D7");
		buts[62].setBounds(509, 374, 52, 47);
		frame.getContentPane().add(buts[62]);
		
		buts[63] = new JButton("D6");
		buts[63].setBounds(454, 374, 52, 47);
		frame.getContentPane().add(buts[63]);
		
		buts[64] = new JButton("D5");
		buts[64].setBounds(329, 374, 52, 47);
		frame.getContentPane().add(buts[64]);
		
		buts[65] = new JButton("D12");
		buts[65].setBounds(784, 374, 52, 47);
		frame.getContentPane().add(buts[65]);
		
		buts[66] = new JButton("D11");
		buts[66].setBounds(729, 374, 52, 47);
		frame.getContentPane().add(buts[66]);
		
		buts[67] = new JButton("D10");
		buts[67].setBounds(674, 374, 52, 47);
		frame.getContentPane().add(buts[67]);
		
		buts[68] = new JButton("D9");
		buts[68].setBounds(619, 374, 52, 47);
		frame.getContentPane().add(buts[68]);
		
		buts[69] = new JButton("D16");
		buts[69].setBounds(1081, 374, 52, 47);
		frame.getContentPane().add(buts[69]);
		
		buts[70] = new JButton("D15");
		buts[70].setBounds(1026, 374, 52, 47);
		frame.getContentPane().add(buts[70]);
		
		buts[71] = new JButton("D14");
		buts[71].setBounds(894, 374, 52, 47);
		frame.getContentPane().add(buts[71]);
		
		buts[72] = new JButton("D13");
		buts[72].setBounds(839, 374, 52, 47);
		frame.getContentPane().add(buts[72]);
		
		buts[73] = new JButton("D19");
		buts[73].setBounds(1246, 374, 52, 47);
		frame.getContentPane().add(buts[73]);
		
		buts[74] = new JButton("D18");
		buts[74].setBounds(1191, 374, 52, 47);
		frame.getContentPane().add(buts[74]);
		
		buts[75] = new JButton("D17");
		buts[75].setBounds(1136, 374, 52, 47);
		frame.getContentPane().add(buts[75]);
		
		buts[76] = new JButton("E1");
		buts[76].setBounds(109, 442, 52, 47);
		frame.getContentPane().add(buts[76]);
		
		buts[77] = new JButton("E2");
		buts[77].setBounds(164, 442, 52, 47);
		frame.getContentPane().add(buts[77]);
		
		buts[78] = new JButton("E3");
		buts[78].setBounds(219, 442, 52, 47);
		frame.getContentPane().add(buts[78]);
		
		buts[79] = new JButton("E4");
		buts[79].setBounds(274, 442, 52, 47);
		frame.getContentPane().add(buts[79]);
		
		buts[80] = new JButton("E5");
		buts[80].setBounds(329, 442, 52, 47);
		frame.getContentPane().add(buts[80]);
		
		buts[81] = new JButton("E6");
		buts[81].setBounds(454, 442, 52, 47);
		frame.getContentPane().add(buts[81]);
		
		buts[82] = new JButton("E7");
		buts[82].setBounds(509, 442, 52, 47);
		frame.getContentPane().add(buts[82]);
		
		buts[83] = new JButton("E8");
		buts[83].setBounds(564, 442, 52, 47);
		frame.getContentPane().add(buts[83]);
		
		buts[84] = new JButton("E9");
		buts[84].setBounds(619, 442, 52, 47);
		frame.getContentPane().add(buts[84]);
		
		buts[85] = new JButton("E10");
		buts[85].setBounds(674, 442, 52, 47);
		frame.getContentPane().add(buts[85]);
		
		buts[86] = new JButton("E11");
		buts[86].setBounds(729, 442, 52, 47);
		frame.getContentPane().add(buts[86]);
		
		buts[87] = new JButton("E12");
		buts[87].setBounds(784, 442, 52, 47);
		frame.getContentPane().add(buts[87]);
		
		buts[88] = new JButton("E13");
		buts[88].setBounds(839, 442, 52, 47);
		frame.getContentPane().add(buts[88]);
		
		buts[89] = new JButton("E14");
		buts[89].setBounds(894, 442, 52, 47);
		frame.getContentPane().add(buts[89]);
		
		buts[90] = new JButton("E15");
		buts[90].setBounds(1026, 442, 52, 47);
		frame.getContentPane().add(buts[90]);
		
		buts[91] = new JButton("E16");
		buts[91].setBounds(1081, 442, 52, 47);
		frame.getContentPane().add(buts[91]);
		
		buts[92] = new JButton("E17");
		buts[92].setBounds(1136, 442, 52, 47);
		frame.getContentPane().add(buts[92]);
		
		buts[93] = new JButton("E18");
		buts[93].setBounds(1191, 442, 52, 47);
		frame.getContentPane().add(buts[93]);
		
		buts[94] = new JButton("E19");
		buts[94].setBounds(1246, 442, 52, 47);
		frame.getContentPane().add(buts[94]);
		
		buts[95] = new JButton("F1");
		buts[95].setBounds(110, 510, 52, 47);
		frame.getContentPane().add(buts[95]);
		
		buts[96] = new JButton("F2");
		buts[96].setBounds(164, 510, 52, 47);
		frame.getContentPane().add(buts[96]);
		
		buts[97] = new JButton("F3");
		buts[97].setBounds(219, 510, 52, 47);
		frame.getContentPane().add(buts[97]);
		
		buts[98] = new JButton("F4");
		buts[98].setBounds(274, 510, 52, 47);
		frame.getContentPane().add(buts[98]);
		
		buts[99] = new JButton("F5");
		buts[99].setBounds(329, 510, 52, 47);
		frame.getContentPane().add(buts[99]);
		
		buts[100] = new JButton("F6");
		buts[100].setBounds(454, 510, 52, 47);
		frame.getContentPane().add(buts[100]);
		
		buts[101] = new JButton("F7");
		buts[101].setBounds(509, 510, 52, 47);
		frame.getContentPane().add(buts[101]);
		
		buts[102] = new JButton("F8");
		buts[102].setBounds(564, 510, 52, 47);
		frame.getContentPane().add(buts[102]);
		
		buts[103] = new JButton("F9");
		buts[103].setBounds(619, 510, 52, 47);
		frame.getContentPane().add(buts[103]);
		
		buts[104] = new JButton("F10");
		buts[104].setBounds(674, 510, 52, 47);
		frame.getContentPane().add(buts[104]);
		
		buts[105] = new JButton("F11");
		buts[105].setBounds(729, 510, 52, 47);
		frame.getContentPane().add(buts[105]);
		
		buts[106] = new JButton("F12");
		buts[106].setBounds(784, 510, 52, 47);
		frame.getContentPane().add(buts[106]);
		
		buts[107] = new JButton("F13");
		buts[107].setBounds(839, 510, 52, 47);
		frame.getContentPane().add(buts[107]);
		
		buts[108] = new JButton("F14");
		buts[108].setBounds(894, 510, 52, 47);
		frame.getContentPane().add(buts[108]);
		
		buts[109] = new JButton("F15");
		buts[109].setBounds(1026, 510, 52, 47);
		frame.getContentPane().add(buts[109]);
		
		buts[110] = new JButton("F16");
		buts[110].setBounds(1081, 510, 52, 47);
		frame.getContentPane().add(buts[110]);
		
		buts[111] = new JButton("F17");
		buts[111].setBounds(1136, 510, 52, 47);
		frame.getContentPane().add(buts[111]);
		
		buts[112] = new JButton("F18");
		buts[112].setBounds(1191, 510, 52, 47);
		frame.getContentPane().add(buts[112]);
		
		buts[113] = new JButton("F19");
		buts[113].setBounds(1246, 510, 52, 47);
		frame.getContentPane().add(buts[113]);
		
				
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(JButton jb: buts) {
					jb.setBackground(null);
					seat_n=0;
					fare=0;
				}
				lblSeats.setText("Selected Seats : "+seat_n);
				lblFare.setText("Fare : Rs. "+fare);
				v = new Vector<String>();
			}
		});
		btnReset.setBounds(1124, 23, 108, 40);
		frame.getContentPane().add(btnReset);	
		for(JButton jb: buts) {
			jb.setFont(new Font("Arial", Font.BOLD, 9));
			jb.addActionListener(this);
		}
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","rgukt123");  
		  PreparedStatement ps = con.prepareStatement("select seat_str from "+screen_no+" where tslot=?");
//		  ps.setString(1, screen_no);
		  ps.setString(1, tslot);
		  ResultSet rs = ps.executeQuery();
		  while(rs.next()) {
			  res.addAll(Arrays.asList(rs.getString(1).split(", ")));
		  }
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
//		for(String st: res) {
//			for(JButton jb: buts) {
//				if(jb.getText().equals(st.trim())) {
//					jb.setEnabled(false);
//				}
//			}
//		}
		
		for(JButton jb : buts) {
			if(res.contains((String)jb.getText())){
				jb.setEnabled(false);
				jb.setBackground(Color.DARK_GRAY);
			}
		}
		frame.setLocationRelativeTo(null);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
//		if(e.getSource()==)
		
		for(JButton jb: buts) {
			if(e.getSource()==jb) {
				String seatno = jb.getText();
				if(jb.getBackground() != Color.DARK_GRAY) {
					if(seat_n>=6){
						JOptionPane.showMessageDialog(jb, "Limit exceeded");
						continue;
					}
					jb.setBackground(Color.DARK_GRAY);
					seat_n++;
					fare+=150;
					v.add(seatno);
				} else {
					jb.setBackground(null);
					seat_n--;
					fare-=150;
					v.remove(seatno);
				}
				lblSeats.setText("Selected Seats : "+seat_n);
				lblFare.setText("Fare : Rs. "+fare);
				v.sort(null);
				seat_string = v.toString().substring(1, v.toString().length()-1);
			}
		}
	}
	
}
