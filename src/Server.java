import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import javax.swing.border.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.*;
import java.text.*;
import java.net.*;




public class Server implements ActionListener {
	
	
	JTextField text;
	static JPanel al;
	JPanel al2;
	JLabel timeLabel;

	
	static Box vertical = Box.createVerticalBox();
	static JFrame f = new JFrame();
	static DataOutputStream dout;
	
	
	Server() {
		
		f.setLayout(null);
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(245,245,245,255));
		p1.setBounds(0,0,450,100);
		p1.setLayout(null);
		f.add(p1);

		
		// settings for the back arrow icon
		
		ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/backarrow2.png"));
		Image i2 = il.getImage().getScaledInstance(15, 25, 50);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel back = new JLabel(i3);
		back.setBounds(15,50,25,25);
		p1.add(back);
		
		back.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ae) {
				System.exit(0);
			}
		});
		
		
		// settings for the profile picture icon
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/profilepic1.png"));
		Image i5 = i4.getImage().getScaledInstance(50, 50, 50);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel pic = new JLabel(i6);
		pic.setBounds(200, 25, 50, 50);
		p1.add(pic);
		
		
		// settings for the video icon
		ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
		Image i8 = i7.getImage().getScaledInstance(30, 30, 50);
		ImageIcon i9 = new ImageIcon(i8);
		JLabel video = new JLabel(i9);
		video.setBounds(370, 40, 50, 50);
		p1.add(video);
		
		
		// settings for the status bar icon
		ImageIcon i16 = new ImageIcon(ClassLoader.getSystemResource("icons/status.png"));
		Image i17 = i16.getImage().getScaledInstance(90, 90, 90);
		ImageIcon i18 = new ImageIcon(i17);
		JLabel status = new JLabel(i18);
		status.setBounds(350, 5, 80, 50);
		p1.add(status);
	
		JLabel name = new JLabel ("Cathy > ");
		name.setBounds(205, 75, 100, 18);
		name.setForeground(Color.BLACK);
		name.setFont(new Font("San_Francisco", Font.PLAIN, 12));
		p1.add(name);
		
		
		// initializing the time settings for the Application 
	    timeLabel = new JLabel(); 
	    timeLabel.setFont(new Font("San_Francisco", Font.PLAIN, 12));
	    timeLabel.setHorizontalAlignment(JLabel.CENTER);
	    updateTimeLabel(timeLabel); 

	    al = new JPanel();
	    al.setLayout(new BorderLayout());
	    al.add(timeLabel, BorderLayout.NORTH); 
	    al.setBackground(new Color(255,255,255,255));
	    al.setBounds(5,115,440,30);
	    f.add(al);
	    
	    al2 = new JPanel();
	    al2.setLayout(new BorderLayout());
	    al2.setBackground(new Color(255,255,255,255));
	    al2.setBounds(5,160,440,500);
	    al2.setLayout(null);
	    f.add(al2);
	    
	    
		text = new JTextField();
		text.setBounds(50,668,360,25);
		text.setFont(new Font("San_Francisco", Font.PLAIN, 16));
		f.add(text);
		
		// settings for the camera icon
		ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/camera.png"));
		Image i11 = i10.getImage().getScaledInstance(30, 30, 50);
		ImageIcon i12 = new ImageIcon(i11);
		JLabel camera = new JLabel(i12);
		camera.setBounds(5, 655, 50, 50);
		f.add(camera);	
		
		
		// settings for the send button icon
		ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/send.png"));
		Image i14 = i13.getImage().getScaledInstance(25, 25, 50);
		ImageIcon i15 = new ImageIcon(i14);
		JLabel submit = new JLabel(i15);
		submit.setBounds(400, 655, 50, 50);
		f.add(submit);
		
		
		// Controls the action when the send button is clicked
		submit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ae) {
				try {
			    updateTimeLabel(timeLabel);

			    String out = text.getText();
			 	
				JPanel p2 = formatLabel(out);
				
				al2.setLayout(new BorderLayout());
				
				JPanel right = new JPanel(new BorderLayout());
				right.setBackground(new Color(255, 255, 255));
				right.add(p2, BorderLayout.LINE_END);
				vertical.add(right);
				vertical.add(Box.createVerticalStrut(10));
				
				al2.add(vertical, BorderLayout.PAGE_START);
				
				dout.writeUTF(out);
				
				text.setText("");
				
				f.repaint();
				f.invalidate();
				f.validate();			
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		
		// Controls how the Application is decorated and sized/located 
		f.setSize(450,700);
		f.setLocation(200,10);
		f.setUndecorated(true);
		f.getContentPane().setBackground(new Color(255,255,255,255));
		
		f.setVisible(true);
		
		


		
		
	}
	// settings for how the time is displayed
	private void updateTimeLabel(JLabel label) {
	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat("'Today at 'hh:mm a");
	    String labelText = "<html><div style='text-align: center;'>iMessage</div><div style='margin-top: -10px; text-align: center;'>" + sdf.format(cal.getTime()) + "</div></html>";
	    label.setText(labelText);
	}

	
	
	
	public void actionPerformed(ActionEvent ae) {

	}
	
	
	// settings for how the messages sent are displayed
	public static JPanel formatLabel(String out) {
	    RoundedPanel panel = new RoundedPanel(15);
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

	    JLabel output = new JLabel("<html><p style=\"width: 150px\">" + out + "</p></html>");
	    output.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    output.setForeground(new Color(255,255,255,255));
	    output.setOpaque(false);
	    output.setBorder(new EmptyBorder(15,15,15,50));

	    panel.add(output);
	    panel.setBackground(new Color(0,122,255,255)); 

	    return panel;
	}

	// Socket, responsible for connecting to the client and sending messages 
	public static void main(String[] args) {
		new Server();
		
		try {
				
			ServerSocket skt = new ServerSocket(6001);
			
			while(true) {
				Socket s = skt.accept();
				DataInputStream din = new DataInputStream(s.getInputStream());
				dout = new DataOutputStream(s.getOutputStream());
				
				
				
				while(true) {
					String msg = din.readUTF();
					JPanel panel = formatLabel(msg);
					
	                for (Component comp : panel.getComponents()) {
	                    if (comp instanceof JLabel) {
	                        ((JLabel) comp).setForeground(Color.BLACK);
	                        

	                    }
	                }
					
					JPanel left = new JPanel(new BorderLayout());
					left.add(panel, BorderLayout.LINE_START);
					left.setBackground(new Color(255, 255, 255));
					panel.setBackground(new Color(232,232,235,255)); 
					vertical.add(left);
					vertical.add(Box.createVerticalStrut(15));
					f.validate();
					
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
