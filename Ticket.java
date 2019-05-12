import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Ticket {
	private String movie;
	private String screen;
	private String seat_str;
	private String date;
	private String time;
	private double fare;
	private JFrame f;
	public Ticket(String movie,String screen, String seat_str,String date, String time, double fare){
		this.movie=movie;
		this.screen=screen;
		this.seat_str=seat_str;
		this.date=date;
		this.time=time;
		this.fare=fare;
		f = new JFrame();
		f.setContentPane(new JLabel(new ImageIcon("images//ticketbg.jpg")));
		f.getContentPane().setLayout(null);
		
		
		JLabel label_4 = new JLabel(time);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(79, 395, 202, 36);
		f.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel(date);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(79, 355, 202, 36);
		f.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel(seat_str);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBounds(79, 318, 202, 36);
		f.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel(screen);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_7.setBounds(79, 285, 202, 36);
		f.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel(movie);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_8.setBounds(79, 255, 202, 36);
		f.getContentPane().add(label_8);


		JLabel label_9 = new JLabel("".valueOf(fare));
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_9.setBounds(79, 430, 202, 36);
		f.getContentPane().add(label_9);




		f.setSize(405,630);
		f.setResizable(false);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);

	}

	public static void main(String[] args) {
		// new Ticket("aaaaaaa","a","a","a","a",5);
	}
}