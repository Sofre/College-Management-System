package collegeapplication.common;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import collegeapplication.admin.Admin;
import collegeapplication.course.CourceData;
import collegeapplication.faculty.Faculty;
import collegeapplication.faculty.FacultyData;
import collegeapplication.student.Student;
import collegeapplication.student.StudentData;
import collegeapplication.subject.SubjectData;

public class HomePanel extends JPanel implements ActionListener {
	private JLabel totalstudentlabel = new JLabel();
	private JLabel totalfaculitieslabel = new JLabel();
	private JLabel totalcourcelabel = new JLabel();
	private JLabel totallectureslabel = new JLabel();
	public JLabel lastloginlabel = new JLabel();
	private JLabel timedifflabel = new JLabel();
	private JLabel welcomelabel = new JLabel();
	private JLabel totalnotificationlabel = new JLabel();

	private JPanel notificationpanel;
	private JPanel courcespanel;
	private JPanel faculitiespanel;
	private JPanel studentspanel;
	private JPanel subjectpanel;

	public HomePanel(Admin a) {
		initUI();
		totalfaculitieslabel.setText(String.valueOf(new FacultyData().getTotalFaculaty()));
		totalstudentlabel.setText(String.valueOf(new StudentData().getTotalStudents()));
		totalcourcelabel.setText(String.valueOf(new CourceData().getTotalCource()));
		welcomelabel.setText("Welcome Administrator");
		totallectureslabel.setText(String.valueOf(new SubjectData().getTotalSubject()));
	}

	public HomePanel(Faculty f) {
		initUI();
		totalfaculitieslabel.setText(String.valueOf(new FacultyData().getFaculaty(f.getCourceCode(), f.getSemorYear())));
		totalstudentlabel.setText(String.valueOf(new StudentData().getTotalStudentInCource(f.getCourceCode(), f.getSemorYear())));
		totalnotificationlabel.setText(String.valueOf(new NotificationData().getUnreadNotification(f.getFacultyId() + "", "Faculty", f.getCourceCode(), f.getSemorYear(), f.getJoinedDate())));
		courcespanel.setVisible(false);
		notificationpanel.setVisible(true);
		welcomelabel.setText("Welcome " + f.getFacultyName());
		totallectureslabel.setText(String.valueOf(new SubjectData().getTotalSubjectinCource(f.getCourceCode(), f.getSemorYear())));
	}

	public HomePanel(Student s) {
		initUI();
		totalfaculitieslabel.setText(String.valueOf(new FacultyData().getFaculaty(s.getCourceCode(), s.getSemorYear())));
		totalstudentlabel.setText(String.valueOf(new StudentData().getTotalStudentInCource(s.getCourceCode(), s.getSemorYear())));
		totalnotificationlabel.setText(String.valueOf(new NotificationData().getUnreadNotification(s.getUserId() + "", "Student", s.getCourceCode(), s.getSemorYear(), s.getAdmissionDate())));
		courcespanel.setVisible(false);
		notificationpanel.setVisible(true);
		welcomelabel.setText("Welcome " + s.getFullName());
		totallectureslabel.setText(String.valueOf(new SubjectData().getTotalSubjectinCource(s.getCourceCode(), s.getSemorYear())));
	}

	private void initUI() {
		setLayout(null);
		setBackground(new Color(245, 245, 250));
		setSize(1116, 705);

		JPanel header = new JPanel(null);
		header.setBounds(10, 0, 1096, 100);
		header.setBackground(new Color(35, 50, 100));

		welcomelabel.setBounds(20, 10, 1056, 30);
		welcomelabel.setFont(new Font("FlowRiders UI", Font.BOLD, 26));
		welcomelabel.setForeground(Color.WHITE);
		header.add(welcomelabel);

		lastloginlabel.setBounds(20, 45, 1056, 20);
		lastloginlabel.setFont(new Font("FlowRiders UI", Font.PLAIN, 14));
		lastloginlabel.setForeground(Color.WHITE);
		header.add(lastloginlabel);

		add(header);

		JPanel container = new JPanel(new GridLayout(1, 4, 15, 0));
		container.setBounds(20, 150, 1076, 250);
		container.setBackground(getBackground());
		add(container);

		studentspanel = createInfoPanel("Students", "./assets/studenthomepage.png", totalstudentlabel);
		faculitiespanel = createInfoPanel("Faculties", "./assets/facultyhomepage.png", totalfaculitieslabel);
		subjectpanel = createInfoPanel("Subjects", "./assets/subjects2.png", totallectureslabel);
		courcespanel = createInfoPanel("Courses", "./assets/courceshomepage.png", totalcourcelabel);
		notificationpanel = createInfoPanel("Notifications", "./assets/notificationhomepage.png", totalnotificationlabel);
		notificationpanel.setVisible(false);

		container.add(studentspanel);
		container.add(faculitiespanel);
		container.add(subjectpanel);
		container.add(courcespanel);
	}

	private JPanel createInfoPanel(String title, String iconPath, JLabel countLabel) {
		JPanel panel = new JPanel(null);
		panel.setBackground(Color.WHITE);
		panel.setBorder(new CompoundBorder(new LineBorder(new Color(200, 200, 200), 2, true), new EmptyBorder(10, 10, 10, 10)));

		countLabel.setText("0");
		countLabel.setHorizontalAlignment(SwingConstants.CENTER);
		countLabel.setForeground(new Color(60, 60, 60));
		countLabel.setFont(new Font("FlowRiders UI", Font.BOLD, 24));
		countLabel.setBounds(10, 170, 233, 30);
		panel.add(countLabel);

		JLabel iconLabel = new JLabel(title, SwingConstants.CENTER);
		iconLabel.setForeground(new Color(60, 60, 60));
		iconLabel.setFont(new Font("FlowRiders UI", Font.BOLD, 22));
		iconLabel.setHorizontalTextPosition(JLabel.CENTER);
		iconLabel.setVerticalTextPosition(JLabel.BOTTOM);
		iconLabel.setBounds(10, 20, 233, 140);

		try {
			Image image = ImageIO.read(new File(iconPath));
			iconLabel.setIcon(new ImageIcon(image.getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
		} catch (IOException e) {
			e.printStackTrace();
		}

		panel.add(iconLabel);
		panel.setPreferredSize(new Dimension(250, 230));
		return panel;
	}

	public void setLastLogin(String lastlogin) {
		if (lastlogin == null || lastlogin.isEmpty()) {
			this.lastloginlabel.setText("Last login: First Time");
		} else {
			this.lastloginlabel.setText("Last login: " + lastlogin);
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// Reserved for future use
	}
}
