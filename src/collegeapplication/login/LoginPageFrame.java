package collegeapplication.login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import collegeapplication.admin.Admin;
import collegeapplication.admin.AdminData;
import collegeapplication.common.DataBaseConnection;


@SuppressWarnings("serial")
public class LoginPageFrame extends JFrame implements ActionListener 
{

	private JPanel contentPane;
	private JButton facultybutton;
	private JButton studentbutton;
	private JButton adminbutton;
	private LoginPanel studentloginpanel,facultyloginpanel,adminloginpanel;
	private boolean adminchanging=false,studentchanging=false,facultychanging=false;
	private int adminpanelx=-2300,adminpanely=240;
	private int facultypanelx=-900,facultypanely=240;
	private int studentpanelx=500,studentpanely=240;
	private int underlinelabelx=280,underlinelabelwidth=140;
	public Timer timer;
	private int imagenumber=1;
	private JLabel bgimagelabel;
	private JLabel underlinelabel;
	private JPanel loginbuttonpanel;
	public Timer imagetimer;
	private BufferedImage bufferedImage = null;


	/**	
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if(DataBaseConnection.checkconnection())
					{
					LoginPageFrame frame = new LoginPageFrame();
					frame.setVisible(true);
					frame.setLocation(-7, 0);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Start the Database Server first","Error",JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPageFrame() {
		timer=new Timer(5,this);
		imagetimer=new Timer(5000,this);
		imagetimer.start();
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1380,733);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		Admin ad=new AdminData().getAdminData();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(35, 95, 175, 255));
		panel.setBounds(0, 26, 1364, 159);
		contentPane.add(panel);
		panel.setLayout(null);



		


        try {
           bufferedImage = ImageIO.read(new File("./assets/dev logo.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
		JLabel cmsPanel = new JLabel();
		cmsPanel.setForeground(Color.WHITE);
		cmsPanel.setText("Welcome to College Management System");
		cmsPanel.setFont(new Font("FlowRiders UI",Font.BOLD,32));
		cmsPanel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
		cmsPanel.setBounds(160,43,749,57);

		JLabel cms_logo = new JLabel("logo");
		cms_logo.setBounds(10,10,140,140);
		cms_logo.setVisible(true);
		Image scaled = bufferedImage.getScaledInstance(cms_logo.getWidth(), cms_logo.getHeight(), Image.SCALE_SMOOTH);
		cms_logo.setIcon(new ImageIcon(scaled));


		
		panel.add(cms_logo);
		panel.add(cmsPanel);
		
		studentloginpanel=new LoginPanel("Student",new ImageIcon("./assets/studentlogin.png"),this);
		studentloginpanel.setVisible(true);
		studentloginpanel.setLocation(studentpanelx,studentpanely);
	
		facultyloginpanel=new LoginPanel("Faculty",new ImageIcon("./assets/facultylogin.png"),this);
		facultyloginpanel.setVisible(true);
		facultyloginpanel.setLocation(facultypanelx, facultypanely);
		
		adminloginpanel=new LoginPanel("Admin",new ImageIcon("./assets/adminlogin.png"),this);
		adminloginpanel.setVisible(true);
		adminloginpanel.setLocation(adminpanelx, adminpanely);
		
		
		contentPane.add(studentloginpanel);
		contentPane.add(facultyloginpanel);
		contentPane.add(adminloginpanel);
			
			
			loginbuttonpanel = new JPanel()
					{
						protected void paintComponent(Graphics g)
					    {
					        g.setColor( getBackground() );
					        g.fillRect(0, 0, getWidth(), getHeight());
					        super.paintComponent(g);
					    }
					};
					loginbuttonpanel.setOpaque(false);
					loginbuttonpanel.setBackground(new Color(0,0,0,120));
			loginbuttonpanel.setBounds(500, 189, 420, 40);
			loginbuttonpanel.setLayout(null);
			contentPane.add(loginbuttonpanel);
		
			
		
			adminbutton = new JButton("Admin");
			adminbutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					activeButton(adminbutton,"admin");
					disableButton(facultybutton);
					disableButton(studentbutton);
					adminchanging=true;
					studentchanging=false;
					facultychanging=false;
					timer.start();
				}
			});
			this.buttonStyle(adminbutton);
			adminbutton.setBounds(0, 0, 140, 35);
			loginbuttonpanel.add(adminbutton);
			
			
			facultybutton = new JButton("Faculty");
			facultybutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					activeButton(facultybutton,"faculty");
					disableButton(studentbutton);
					disableButton(adminbutton);
					facultychanging=true;
					adminchanging=false;
					studentchanging=false;
					timer.start();
				}
			});
			this.buttonStyle(facultybutton);
			facultybutton.setBounds(140, 0, 140, 35);
			loginbuttonpanel.add(facultybutton);
			
			studentbutton = new JButton("Student");
			studentbutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					activeButton(studentbutton,"student");
					disableButton(facultybutton);
					disableButton(adminbutton);
					studentchanging=true;
					adminchanging=false;
					facultychanging=false;
					timer.start();

				}
				
			});
			studentbutton.setBounds(280, 0, 140, 35);
			this.buttonStyle(studentbutton);
			loginbuttonpanel.add(studentbutton);


			underlinelabel = new JLabel("underline color ");
			underlinelabel.setBorder(new MatteBorder(3, 0, 0, 0, (Color)Color.ORANGE));
			underlinelabel.setBounds(underlinelabelx, 37, underlinelabelwidth, 4);
			loginbuttonpanel.add(underlinelabel);





		
			
			bgimagelabel = new JLabel("image");
			bgimagelabel.setBounds(0, 11, 1380, 683);
			contentPane.add(bgimagelabel);
			this.setBackgroundImage();
			
		
		
	}

	private void shiftPanels(int panelShift, int underlineShift) {
		adminpanelx += panelShift;
		studentpanelx += panelShift;
		facultypanelx += panelShift;
		underlinelabelx += underlineShift;
	}

	private void changeUnderlineColor(Color color) {
		underlinelabel.setBorder(new MatteBorder(3, 0, 0, 0, color));
	}




	@Override
	public void actionPerformed(ActionEvent e)
	{

		// TODO Auto-generated method stub
			if(!adminchanging&&!studentchanging&&!facultychanging)
			{

				imagenumber++;
				if(imagenumber>5)
				{
					imagenumber=1;

				}
				this.setBackgroundImage();
			}

			if(adminchanging)
			{
				if(adminpanelx==500)
				{
					adminchanging=false;
					timer.stop();
				}
				else
				{

					adminpanelx+=50;
					studentpanelx+=50;
					facultypanelx+=50;
					underlinelabelx-=5;
					if (underlinelabelx < 275) {
						changeUnderlineColor(Color.RED);
						System.out.println(underlinelabelx);
					}
				}
			}
			else if(facultychanging)
			{
				if(facultypanelx==500)
				{
					facultychanging=false;
					timer.stop();
				}
				else
				{
					if(facultypanelx>500)
					{
						adminpanelx-=50;
						studentpanelx-=50;
						facultypanelx-=50;
						underlinelabelx+=5;
						if (underlinelabelx > 5) {
							changeUnderlineColor(Color.BLUE);
							System.out.println(underlinelabelx);
						}
					}
					else
					{
						adminpanelx+=50;
						studentpanelx+=50;
						facultypanelx+=50;
						underlinelabelx-=5;
						if (underlinelabelx == 275) {
							changeUnderlineColor(Color.BLUE);
							System.out.println(underlinelabelx);
						}

					}
				}
			}
			else if(studentchanging)
			{
				if(studentpanelx==500)
				{
					studentchanging=false;
					timer.stop();
				}
				else
				{

						adminpanelx-=50;
						studentpanelx-=50;
						facultypanelx-=50;
						underlinelabelx+=5;
					if (underlinelabelx == 280) {
						changeUnderlineColor(Color.ORANGE);
						System.out.println(underlinelabelx);
					}


				}
			}
			
			studentloginpanel.setLocation(studentpanelx,studentpanely);
			facultyloginpanel.setLocation(facultypanelx, facultypanely);
			adminloginpanel.setLocation(adminpanelx, adminpanely);
			underlinelabel.setLocation(underlinelabelx, underlinelabel.getY());

			this.repaint();
			
		
	}
	public void buttonStyle(JButton button)
	{
		button.setFocusable(true);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Segoe UI", Font.BOLD, 15));
		button.setBorder(new EmptyBorder(0,0,0,0));
		button.setBackground(Color.black);
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setOpaque(false);
	
	}
	public void activeButton(JButton button,String option)
	{
		switch (option){
			case "student":
				button.setForeground(Color.ORANGE);
				break;
			case "faculty": button.setForeground(Color.BLUE);
				break;
			case "admin":   button.setForeground(Color.RED);
				break;
		}


		
	}



	public void disableButton(JButton button)
	{
		button.setForeground(Color.white);
	}
	public void setBackgroundImage()
	{
		try {
			System.out.println(imagenumber);
				Image image=ImageIO.read(new File(".//assets//backgroundimage"+imagenumber+".jpg"));
			bgimagelabel.setIcon(new ImageIcon(image.getScaledInstance(bgimagelabel.getWidth(), bgimagelabel.getHeight(), Image.SCALE_SMOOTH)));
			
		} catch (IOException e) {
	

			e.printStackTrace();
		}
	}
}