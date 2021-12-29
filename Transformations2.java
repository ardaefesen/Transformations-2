import java.awt.*;
import java.awt.event.*;

public class Transformations2 extends Frame implements ActionListener,MouseListener {

 // Initialize coordinates of the rectangle
 int[] x = {400,600,600,400};
 int[] y = {400,400,200,200};
 static final int windowWidth = 800;
 static final int windowHeight = 800;
 public static void main(String[] args) {
	 // Set Frame s ize to 800x800
	 // Set background color
	 // Set visibility
	 Transformations2 f = new Transformations2();
	 f.setTitle("Transformations");
	 f.setSize(windowWidth, windowHeight);        
	 f.setVisible(true);

 }
 public Transformations2() {
 // Set title
 // Create menu
 // Add WindowListener to exit the program when window is closed
 // Set layout
 // Add control panel
 // Add buttons
	 
	 
	    MenuBar menu_bar = new MenuBar();             // Creating Menu Bar
		Menu def = new Menu("File");
		def.add(new MenuItem("Set Default"));
		def.addActionListener(this);
		menu_bar.add(def);
		setMenuBar(menu_bar);
		
		
		 Panel panel=new Panel();  						// creating panel
	     panel.setBounds(0,40,windowWidth,40); 
	     
	     
	     	Button button_shx = new Button();
			button_shx.setLabel("Shear in X");        // Set up Shear in X button
			button_shx.addActionListener(this);
			
			Button button_shy = new Button();
			button_shy.addActionListener(this);			// Set up Shear in Y button
			button_shy.setLabel("Shear in Y");
			
			
			Button button_stx = new Button();
			button_stx.addActionListener(this);			//  Set up Stretch in X button
			button_stx.setLabel("Stretch in X");
			
			Button button_sty = new Button();
			button_sty.addActionListener(this);          //  Set up Stretch in Y button
			button_sty.setLabel("Stretch in Y");
			
			Button button_scu = new Button();
			button_scu.addActionListener(this);          // Set up Scale Up button
			button_scu.setLabel("Scale Up");
			
			Button button_scd = new Button();			// Set up Scale Down button
			button_scd.addActionListener(this);
			button_scd.setLabel("Scale Down");
			
			panel.add(button_shx);
			panel.add(button_shy);						//add the buttons to panel we create
			panel.add(button_stx);
			panel.add(button_sty);
			panel.add(button_scu);
			panel.add(button_scd);
			
			panel.setBackground(Color.black); 
			add(panel);
			setLayout(null);								// setting background colors
			addWindowListener(new MyFinishWindow());
			addMouseListener(this);
			setBackground(Color.getHSBColor(0.55f, 0.2f, 0.9f));

 }
 
 public class MyFinishWindow extends WindowAdapter
	{
		     public void windowClosing(WindowEvent e)
		     {
		       System.exit(0);
		     }
	}
 // Draw 2 lines and paint 1 filled rectangle
 public void paint(Graphics g) {
	 Graphics2D g2d = (Graphics2D) g;
	 
	 g2d.drawLine(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight()); // Drawing Vertical line
	 g2d.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2); // Drawing Horizontal Line
	 g2d.fillPolygon(x,y,4);

 }

 // Action listener
 public void actionPerformed(ActionEvent evt) {            //x,y[0] left bottom point    1.point
	 													   //x,y[1] right bottom point	 2.point
	 													  // x,y[2] right top point		 3.point
	 													  // x.y[3] left top point		 4.point
	 
	 String str = evt.getActionCommand();
	 if(str.equals("Shear in X")) {							// Shear in X  for 20 unit
		 	 x[2] = x[2] + 20;							    // for the invariant line, only 3. and 4. x points change 
		 	 x[3] = x[3] + 20;								// the others will default
		 
		 repaint();
	 }
	 else if(str.equals("Shear in Y")) {
		 													// Shear in Y for 20 unit
		 													// for the invariant line, only  2. and 3. y points change
			y[1] = y[1] - 20;								// the others will default						
			y[2] = y[2] - 20;
		 
		 repaint();
	 }
	 else if(str.equals("Stretch in X")) {
		  													// Stretch X for 20 unit
			 x[1] = x[1] + 20;								// for the invariant line, only  2. and 3. x points change
			 x[2] = x[2] + 20;								// the others will default
			
		 
		 repaint();
	 }
	 else if(str.equals("Stretch in Y")) {					// Stretch Y for 20 unit
		 	y[2] = y[2] -20;								// for the invariant line, only  3. and 4. y points change
		 	y[3] = y[3] - 20;								// the others will default
		 	repaint();
		 }
		 
 
	 else if(str.equals("Scale Up")) {
		 y[3] = y[3] -20;									// Scale Up for 20 unit
		 x[1] = x[1] + 20;									// for the invariant line,  2. and 3. x points change
		 													// for the invariant line,   3. and 4. y points change
		 x[2] = x[2] + 20;									// the others will default
		 y[2] = y[2] - 20;
		
		repaint();
		 }
		 
	 
	 
	 else if(str.equals("Scale Down")) {					// Scale Down for 20 unit
		 y[3] = y[3] + 20;
		 x[1] = x[1] - 20;									// for the invariant line,  2. and 3. x points change
		 													// for the invariant line,   3. and 4. y points change
		 x[2] = x[2] - 20;									// the others will default
		 y[2] = y[2] + 20;
		 repaint();
	 }
	 
	 else if(str.equals("Set Default")) {
		 x[0] = 400;
		 x[1] = 600;		// x default values 
		 x[2] = 600;
		 x[3] =	400;
		 
		 y[0] = 400;
		 y[1] = 400;		// y default values
		 y[2] = 200;
		 y[3] = 200;
		
		 repaint();
	 }
 }
@Override
public void mouseClicked(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseEntered(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseExited(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mousePressed(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
} 
