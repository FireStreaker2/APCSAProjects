import java.awt.*;
import javax.swing.JFrame;

public class Program extends Canvas {
	public void paint(Graphics g) {
		// M
		g.drawLine(100, 200, 100, 300);
		g.drawLine(100, 200, 150, 250);
		g.drawLine(200, 200, 150, 250);
		g.drawLine(200, 200, 200, 300);

		// C
		g.drawLine(300, 200, 350, 200);
		g.drawLine(300, 200, 300, 300);
		g.drawLine(300, 300, 350, 300);
	}

	public static void main(String[] args) {
		JFrame win = new JFrame("Program");
		win.setSize(800, 600);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Program canvas = new Program();
		win.add(canvas);
		win.setVisible(true);
	}
}
