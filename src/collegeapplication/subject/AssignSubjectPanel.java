package collegeapplication.subject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

import collegeapplication.admin.AdminMain;
import collegeapplication.common.ResultSetToTableModel;
import collegeapplication.faculty.Faculty;
import collegeapplication.faculty.FacultyData;
import collegeapplication.faculty.FacultyMain;
import collegeapplication.student.StudentMain;



@SuppressWarnings("serial")
public class AssignSubjectPanel extends JPanel {

	private JPanel tableviewpanel;
	private JTable table;
	String condition="";
	/**
	 * Create the panel.
	 */
	public AssignSubjectPanel(AdminMain am)
	{
		this();
		table.addMouseListener(new MouseAdapter()
			{
				public void mousePressed(MouseEvent e)
				{
					if(e.getClickCount()>1  && e.getButton()==MouseEvent.BUTTON1)
					{
					
					JTable t=(JTable) e.getSource();
					Faculty f=new FacultyData().getFacultyInfo(t.getSelectedRow()+1);
					AssignSubjectDialog as=new AssignSubjectDialog(f,am);
					as.setLocationRelativeTo(null);
					as.setVisible(true);
					
					}
					
				}
			});
		 condition="";
	}
	public AssignSubjectPanel(FacultyMain fm)
	{
		this();
		condition=" where courcecode='"+fm.f.getCourceCode()+"' and semoryear="+fm.f.getSemorYear()+" ";
		table.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		this.createtablemodel();
		
	}
	public AssignSubjectPanel(StudentMain sm)
	{
		this();
		condition=" where courcecode='"+sm.s.getCourceCode()+"' and semoryear="+sm.s.getSemorYear()+" ";
		table.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		this.createtablemodel();

		
	}
	private AssignSubjectPanel() {
		
		setBackground(Color.WHITE);
		this.setSize(1116, 705);
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(37, 170, 119));
		panel.setBounds(10, 0, 1096, 183);
		add(panel);
		panel.setLayout(null);
		JLabel allfaculitieslabel = new JLabel("Subject Faculties");
		allfaculitieslabel.setIcon(null);
		allfaculitieslabel.setBounds(10, 65, 272, 44);
		panel.add(allfaculitieslabel);
		allfaculitieslabel.setBackground(new Color(37, 170, 119));
		allfaculitieslabel.setHorizontalAlignment(SwingConstants.LEFT);
		allfaculitieslabel.setForeground(Color.WHITE);
		allfaculitieslabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		allfaculitieslabel.setOpaque(true);
		   tableviewpanel = new JPanel();
			  tableviewpanel.setBackground(Color.WHITE);
			  tableviewpanel.setBounds(0, 189, 1116, 528);
			  add(tableviewpanel);
			  tableviewpanel.setLayout(null);
			  
			  JScrollPane scrollPane = new JScrollPane();
			  scrollPane.setBounds(10, 11, 1095, 483);
			  scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
				for(Component c : scrollPane.getComponents())
				{
					c.setBackground(Color.white);
				}
			  tableviewpanel.add(scrollPane);
			  
			  table = new JTable();
			  createtablemodel();
				table.setBorder(new LineBorder(Color.LIGHT_GRAY));
				table.getTableHeader().setBackground(new Color(37, 170, 119));
				table.setCursor(new Cursor(Cursor.HAND_CURSOR));
				table.getTableHeader().setForeground(Color.white);
				table.getTableHeader().setFont(new Font("Arial",Font.BOLD,20));
				table.setFont(new Font("Segoe UI",Font.PLAIN,20));
				table.getTableHeader().setPreferredSize(new Dimension(50,40));
				table.setDragEnabled(false);
				table.setRowHeight(40);
				
				table.setSelectionBackground(new Color(240, 255, 255));
				table.setFocusable(false);
//				table.setEnabled(false);
				table.setDefaultEditor(Object.class,null);
			
				table.setGridColor(Color.LIGHT_GRAY);
				table.getTableHeader().setReorderingAllowed(false);	
			  scrollPane.setViewportView(table);
			  
			  
			 
				

	}
	public void createtablemodel()
	{
		ResultSet rs=new FacultyData().getFacultySubjectInfo(condition);

		if(rs!=null)
		{
            try {
                table.setModel(ResultSetToTableModel.buildTableModel(rs));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
		table.getColumnModel().getColumn(0).setMaxWidth(200);
		table.getColumnModel().getColumn(1).setMaxWidth(300);
		table.getColumnModel().getColumn(2).setMaxWidth(180);
		table.getColumnModel().getColumn(3).setMaxWidth(180);
		table.getColumnModel().getColumn(4).setMaxWidth(300);
		table.getColumnModel().getColumn(5).setMaxWidth(300);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		DefaultTableCellRenderer cellrenderer=new DefaultTableCellRenderer();
		cellrenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(cellrenderer);
		for(int i=0; i<table.getRowCount(); i++)
		  {
			  if (Objects.equals(table.getModel().getValueAt(i, 3), 0))
			  {
				  table.getModel().setValueAt("Not Assigned",i, 3);


			  }
			 
		  }
	}

}
