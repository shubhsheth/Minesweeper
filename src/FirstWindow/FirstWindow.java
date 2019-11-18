package FirstWindow;
import javax.swing.JFrame;

public class FirstWindow {
	public static final int WIDTH = 300;
	public static final int HEIGHT = 200;
	
	public static void main(String[] args) {
		JFrame firstWindow = new JFrame("Window Title");
		firstWindow.setSize(WIDTH, HEIGHT);
		
		firstWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		firstWindow.setVisible(true);
	}

}
