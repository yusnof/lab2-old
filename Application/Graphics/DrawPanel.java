package Application.Graphics;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import Application.Car_World.CarWorld; 

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel {
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;
    // To keep track of a single car's position
    Point point;

    ArrayList<Point> points;

    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300,300);

    // TODO: Make this general for all cars
    void moveit(int x, int y, int index){
        points.set(index,new Point(x,y));
    }


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarWorld model) {
        this.model = model;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Car car: model.getCarsList()) {
            try {
                image = ImageIO.read(DrawPanel.class.getResourceAsStream(car.getImageSource()));
                volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream(model.garage.getImageSource()));
             }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
            System.out.println("Draw at "+car.getPosition().x);
            g.drawImage(image,car.getPosition().x,car.getPosition().y,null);
        }
        // see javadoc for more info on the parameters

        g.drawImage(volvoWorkshopImage, 100, 100, null);
    }
}