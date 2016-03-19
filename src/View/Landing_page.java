package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Finelam on 19/03/2016.
 */
public class Landing_page extends JPanel {

    public Landing_page(Rectangle bounds){
        this.setBounds(bounds);
        this.setBackground(Color.decode("#4EC67F"));
        this.setLayout(new BorderLayout());
        BufferedImage logo = null;
        try {
            logo = ImageIO.read(new File("img/Jismen.png"));
            JLabel picLabel = new JLabel(new ImageIcon(logo));
            this.add(picLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
