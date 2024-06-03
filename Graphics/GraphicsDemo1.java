import java.awt.*;
import javax.swing.JFrame;

// 1. How big is the window that appears? How many pixels wide? How many pixels tall?
// It is a window that is 800 pixels wide and 600 pixels tall.
//
// 2. In the call to the function g.drawRect(), there are four numbers. What do they mean? Try changing them to figure it out.
// x, the x coordinate of the rectangle to be drawn.
// y, the y coordinate of the rectangle to be drawn.
// width, the width of the rectangle to be drawn.
// height, the height of the rectangle to be drawn.
//
// 3. What about the call to fillOval()? What do the four numbers mean here?
// x, the x coordinate of the upper left corner of the oval to be filled.
// y, the y coordinate of the upper left corner of the oval to be filled.
// width, the width of the oval to be filled.
// height, the height of the oval to be filled.
//
// 4. What are the two numbers in the call to drawString()?
// The x and y coordinate of the string, starting at the leftmost character
//
// 5. What happens when two objects overlap? Which one is drawn on top?
// The one that is drawn later is on top.
//
// 6. Add a red, filled-in square somewhere in the lower-right of the canvas.
// OK
//
// 7. Create a new program, drawing your name using only g.drawLine, you may use any colors you like.
// OK - Check Program.java


public class GraphicsDemo1 extends Canvas {
	public void paint(Graphics g) {
		g.setColor(Color.green);
		g.drawRect(50, 20, 100, 200); // draw a rectangle
		g.fillOval(160, 20, 100, 200); // draw a filled-in oval
		g.setColor(Color.blue);
		g.fillRect(200, 400, 200, 20); // a filled-in rectangle
		g.drawOval(200, 430, 200, 100);
		g.drawLine(0, 0, 100, 100);
		g.setColor(Color.yellow);// resets the color
		g.drawLine(0, 300, 800, 300); // a line

		g.setColor(Color.black);
		g.drawString("Graphics are pretty neat.", 500, 100);
		int x = getWidth() / 2;
		int y = getHeight() / 2;
		g.drawString("The first letter of this string is at (" + x + "," + y + ")", x, y);
		
		g.setColor(Color.red);
		g.drawRect(550, 350, 200, 200);
		g.fillRect(550, 350, 200, 200);
	}

	public static void main(String[] args) {
		// You can change the title or size here if you want.
		JFrame win = new JFrame("GraphicsDemo1");
		win.setSize(800, 600);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GraphicsDemo1 canvas = new GraphicsDemo1();
		win.add(canvas);
		win.setVisible(true);
	}
}