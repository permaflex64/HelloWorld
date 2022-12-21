package chatGPT;

import java.applet.Applet;
//Import the necessary Java libraries
import java.awt.Color;
import java.awt.Graphics;

//Extend the Applet class
public class BouncingBallApplet extends Applet {

// Declare variables for the ball's position and speed
	int ballX = 50;
	int ballY = 50;
	int ballSpeedX = 5;
	int ballSpeedY = 3;

// Override the paint() method from the Applet class
	public void paint(Graphics g) {
		// Set the background color to white
		setBackground(Color.WHITE);

		// Set the color of the ball to black
		g.setColor(Color.BLACK);

		// Draw the ball at its current position
		g.fillOval(ballX, ballY, 50, 50);

		// Update the ball's position based on its speed
		ballX += ballSpeedX;
		ballY += ballSpeedY;

		// Check if the ball has reached the edge of the applet
		if (ballX > getWidth() - 50) {
			// Reverse the direction of the ball's horizontal movement
			ballSpeedX = -ballSpeedX;
		}
		if (ballY > getHeight() - 50) {
			// Reverse the direction of the ball's vertical movement
			ballSpeedY = -ballSpeedY;
		}
		if (ballX < 0) {
			// Reverse the direction of the ball's horizontal movement
			ballSpeedX = -ballSpeedX;
		}
		if (ballY < 0) {
			// Reverse the direction of the ball's vertical movement
			ballSpeedY = -ballSpeedY;
		}

		// Request that the applet be repainted
		repaint();
	}
}
