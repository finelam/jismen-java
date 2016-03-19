package layout;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Finelam on 12/03/2016.
 */
public class View_add extends JPanel implements Observer {
    protected JPanel headerPanel = new JPanel();
    protected JPanel dataPanel = new JPanel();
    protected JPanel buttonPanel = new JPanel();
    protected JScrollPane scrollPane = new JScrollPane(dataPanel);
    protected JLabel labelHeader = new JLabel();
    protected JButton btnAdd = new JButton("Créer");

    public View_add(Rectangle bounds){
        this.setBounds(bounds);
        this.setLayout(new BorderLayout());
        headerPanel.add(labelHeader);
        headerPanel.setBackground(Color.decode("#4EC67F"));
        labelHeader.setForeground(Color.white);
        labelHeader.setFont(new Font("Verdana", Font.BOLD, 14));
        this.add(headerPanel,BorderLayout.NORTH);
        dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.PAGE_AXIS));
        this.add(scrollPane, BorderLayout.CENTER);
        buttonPanel.add(btnAdd);
        buttonPanel.setBackground(Color.decode("#4EC67F"));
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void update(Observable o, Object arg) {
        String msg = "";
        String header = "";
        int type = 0;
        if ((boolean)arg == true){
            msg = "Enregistrement effectué !";
            header = "Success";
            type = JOptionPane.INFORMATION_MESSAGE;
        } else {
            msg = "Une erreur est survenue";
            header = "Error";
            type = JOptionPane.ERROR_MESSAGE;
        }
        JOptionPane.showMessageDialog(
                this,
                msg,
                header,
                type
        );
    }
}
