package chatGPT;

/**
 
 This code uses the JPanel and Graphics2D classes to draw the fractal tree on the screen. The drawFractal() method uses recursion
 to draw the branches and leaves of the tree. The drawBranch() and drawLeaf() methods are used to draw each branch and leaf,
 respectively. The calculateEndPoint() method is used to calculate the end points of the branches. 
  
 */



/**

 A fractal is a mathematical object that exhibits self-similarity at different scales. This means that the same pattern 
 or structure repeats itself at different levels of magnification. The concept of self-similarity is at the heart of 
 fractal geometry, and it is what gives fractals their distinctive and often intricate shapes.
 One of the most famous examples of a fractal is the Mandelbrot set, named after the mathematician Benoît Mandelbrot who 
 first studied it in the 1980s. The Mandelbrot set is a set of complex numbers that satisfy a certain mathematical condition.
 When plotted on the complex plane, the numbers in the Mandelbrot set form a distinctive and intricate pattern that repeats 
 itself at different scales.
 The fractal tree shown in the previous example is a simple example of a fractal. The tree is created by recursively drawing 
 branches and leaves at different levels of magnification. The same branching pattern is repeated at each level, giving the 
 tree its self-similar structure.
 Fractals are found in many natural phenomena, such as the branching patterns of trees and rivers, the shape of coastlines and 
 mountains, and the distribution of galaxies in the universe. They are also used in many fields, such as computer graphics, data 
 compression, and finance.
 
 */



import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class FractalTree extends JPanel {
  private final int PANEL_WIDTH = 400;
  private final int PANEL_HEIGHT = 400;

  private final double BRANCH_ANGLE = Math.PI / 6;
  private final int BRANCH_LENGTH = 120;
  private final int MAX_LEVELS = 8;

  private final Color BRANCH_COLOR = Color.BLACK;
  private final Color LEAF_COLOR = new Color(0, 128, 0);

  private int currentLevel;
  private double currentAngle;
  private Point2D.Double currentPoint;
  private Graphics2D g2;

  public FractalTree() {
    setBackground(Color.WHITE);
    setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
  }

  public void drawFractal(int level, double angle, Point2D.Double point) {
    if (level >= MAX_LEVELS) {
      // Draw a leaf
      drawLeaf(point);
    } else {
      // Draw a branch
      drawBranch(angle, point);

      // Calculate the end point of the left branch
      double newAngle = angle + BRANCH_ANGLE;
      Point2D.Double newPoint = calculateEndPoint(point, newAngle);

      // Draw the left branch recursively
      drawFractal(level + 1, newAngle, newPoint);

      // Calculate the end point of the right branch
      newAngle = angle - BRANCH_ANGLE;
      newPoint = calculateEndPoint(point, newAngle);

      // Draw the right branch recursively
      drawFractal(level + 1, newAngle, newPoint);
    }
  }

  public void drawBranch(double angle, Point2D.Double point) {
    // Calculate the end point of the branch
    Point2D.Double endPoint = calculateEndPoint(point, angle);

    // Set the color of the branch
    g2.setColor(BRANCH_COLOR);

    // Draw the branch
    g2.draw(new Line2D.Double(point, endPoint));
  }

  public void drawLeaf(Point2D.Double point) {
    // Set the color of the leaf
    g2.setColor(LEAF_COLOR);

    // Draw the leaf
    g2.fill(new Ellipse2D.Double(point.x, point.y, 5, 5));
  }

  public Point2D.Double calculateEndPoint(Point2D.Double point, double angle) {
    // Calculate the x and y coordinates of the end point
    double x = point.x + BRANCH_LENGTH * Math.cos(angle);
    double y = point.y + BRANCH_LENGTH * Math.sin(angle);

    // Return the end point
    return new Point2D.Double(x, y);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    
        // Set up the graphics object
    g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    // Set the initial level and angle
    currentLevel = 0;
    currentAngle = Math.PI / 2;

    // Set the initial point
    currentPoint = new Point2D.Double(PANEL_WIDTH / 2, PANEL_HEIGHT);

    // Draw the fractal
    drawFractal(currentLevel, currentAngle, currentPoint);
  }

  public static void main(String[] args) {
    JFrame window = new JFrame("Fractal Tree");
    window.setContentPane(new FractalTree());
    window.pack();
    window.setResizable(false);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    window.setLocation((screen.width - window.getWidth()) / 2, (screen.height - window.getHeight()) / 2);
    window.setVisible(true);
  }
}

