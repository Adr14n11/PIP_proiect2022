package gui_CTP;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class ProgressBar extends JFrame{
	private static final long serialVersionUID = 1L;
	JProgressBar progress;
	public ProgressBar() throws IOException {
		super();
		// Create the progressBar
		progress = new JProgressBar(0,1000);
	    // Set the position of the progressBar
	    progress.setBounds(10,10,200,30);
	    // Initialize the progressBar to 0   
	    progress.setValue(0);  
	    // Show the progress string
	    progress.setStringPainted(true);  
	    // Add the progressBar to the frame
	    add(progress);
	    setSize(250,150);  
	    setLayout(null);  
	}

	public void loop()
	  {
	    int i=0; 
	    while(i <= 1000)
	    {
	      // fills the bar
	      progress.setValue(i);  
	      i = i + 10;  
	      try
	      {
	        Thread.sleep(160);
	      }
	      catch(Exception e){}
	    }
	    
	  }
	public static void main(String[] args) throws IOException {
		
		/*ProgressBar pb = new ProgressBar();  
	    pb.setVisible(true);  
	    pb.loop();
	    */ 
	}
	

}
