package Application.Graphics;

import Application.Car_World.Car;
import Application.Car_World.CarWorld;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel {
    CarWorld model;
    Image volvoWorkshopImage;
    BufferedImage image;


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarWorld model) {
        this.model = model;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int counter = 0;
        for (Car car: model.getCarsList()) {
            try {
                image = ImageIO.read(DrawPanel.class.getResourceAsStream(car.getImageSource()));
                volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream(model.garage.getImageSource()));
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
            g.drawImage(image,car.getPosition().x,car.getPosition().y ,null);
            counter += 200;
        }
        g.drawImage(volvoWorkshopImage, 200, 400, null);
    }
}