import javax.swing.*;
import java.awt.*;
import java.text.*;
import java.util.*;
public class DigitalWatch implements Runnable

{
  JFrame f;
  Thread t=null;
  int hours=0, minutes=0, seconds=0;
   String timeString = "";
   JButton b;

DigitalWatch()
{
	f=new JFrame();
	Container c = f.getContentPane();
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	t = new Thread(this);
         t.start();
	
	b=new JButton();
	
        b.setBounds(850,100,100,50);
      
        b.setBackground(Color.YELLOW);
        c.add(b);
	
	f.add(b);
	f.setBounds(500,500,1000,1000);
	f.setLayout(null);
	f.setVisible(true);
	c.setBackground(Color.GRAY);
}

 public void run()
  {
      try
       {
          while (true)
        {

            Calendar cal = Calendar.getInstance();
            hours = cal.get( Calendar.HOUR_OF_DAY );
            if ( hours > 12 ) 
            hours -= 12;
            minutes = cal.get( Calendar.MINUTE );
            seconds = cal.get( Calendar.SECOND );

            SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
            Date date = cal.getTime();
            timeString = formatter.format( date );

            printTime();

            t.sleep( 1000 );  // interval given in milliseconds
         }
      }
      
      catch (Exception e) { }
 }

public void printTime()
{
     b.setText(timeString);
}

public static void main(String[] args)
 {
	new DigitalWatch();
        

}
}
