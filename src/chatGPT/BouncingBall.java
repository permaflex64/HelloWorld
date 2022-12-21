package chatGPT;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BouncingBall {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Bouncing Ball");
    frame.setSize(400, 400);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create a new BouncingBallPanel and add it to the frame
    BouncingBallPanel panel = new BouncingBallPanel();
    frame.add(panel);
  }
}

class BouncingBallPanel extends JPanel {
  // Add fields for the ball's position and velocity
  int x = 0;
  int y = 0;
  int vx = 1;
  int vy = 1;

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    try {
		Thread.sleep(10);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

    // Draw the ball at its current position
    g.fillOval(x, y, 20, 20);

    // Update the ball's position based on its velocity
    x += vx;
    y += vy;

    // If the ball hits a wall, reverse its velocity
    if (x < 0 || x > getWidth() - 20) {
      vx *= -1;
    }
    if (y < 0 || y > getHeight() - 20) {
      vy *= -1;
    }

    // Repaint the panel with the ball in its new position
    repaint();
  }
}
