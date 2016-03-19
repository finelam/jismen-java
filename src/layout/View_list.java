package layout;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Finelam on 14/03/2016.
 */
public class View_list extends JPanel {

    protected JTable table;
    protected JPanel headerPanel = new JPanel();
    protected JLabel labelHeader = new JLabel();
    protected JScrollPane scroll;

    public View_list(Rectangle bounds){
        this.setBounds(bounds);
        this.setLayout(new BorderLayout());
        headerPanel.add(labelHeader);
        headerPanel.setBackground(Color.decode("#4EC67F"));
        labelHeader.setForeground(Color.white);
        labelHeader.setFont(new Font("Verdana", Font.BOLD, 14));
    }
}
