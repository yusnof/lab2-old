import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage image;
    // To keep track of a single car's position
    BufferedImage WorkshopImage;
    Point WorkshopPoint = new Point(300,300);

    CarController  carController = new CarController();

    // TODO: Make this general for all cars
    void moveit(int x, int y, GUIComponents car){   // TODO Called and changes kords, image does not move.
        car.setX(x);
        car.setY(y);
        System.out.println("moveit Called!");
        System.out.println(car.getPoint().x + " " + car.getPoint().y);
    }
    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        try {

           // volvoimage = ImageIO.read(DrawPanel.class.getResourceAsStream(test.getIsaabImage);
            image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            WorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (GUIComponents c : carController.getCars()) {
            g.drawImage(image, c.getPoint().x, c.getPoint().y, null);
        }
        //g.drawImage(image, point.x, point.y, null); // see javadoc for more info on the parameters
        //g.drawImage(WorkshopImage, WorkshopPoint.x, WorkshopPoint.y, null);
    }
}