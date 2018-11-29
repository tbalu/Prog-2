import java.awt.*;
import javax.swing.JFrame;

public class FullScreen extends JFrame{
	public static void main(String[] args) {
		
		
		DisplayMode dm = new DisplayMode(800,600,16, DisplayMode.REFRESH_RATE_UNKNOWN);
		FullScreen F = new FullScreen();
		
		F.run(dm);
	}
	
	public void run(DisplayMode dm) {
		
		setBackground(Color.CYAN);
		setForeground(Color.WHITE);
		setFont(new Font("Arial", Font.PLAIN,24));
		Screen s = new Screen();
		try {
		
			s.setFullScreen(dm, this);
			try {
				Thread.sleep(5000);
			} catch(Exception ex) {}
		}finally {
			s.restoreScreen();
		}
	}
	
	public void paint(Graphics g) {
		g.drawString("Text...",200, 200);
	}
}
