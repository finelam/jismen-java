package layout;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Finelam on 14/03/2016.
 */
public class View_show extends JPanel implements Observer {

    protected JPanel comboPanel   = new JPanel();
    protected JPanel dataPanel    = new JPanel();
    protected JPanel buttonPanel  = new JPanel();
    protected JButton btnReset    = new JButton("Réinitialiser");
    protected JButton btnEdit     = new JButton("Modifier");
    protected JButton btnDel      = new JButton("Supprimer");
    protected JComboBox combo     = new JComboBox();

    public View_show(Rectangle bounds){
        this.setBounds(bounds);
        this.setLayout(new BorderLayout());
        comboPanel.add(combo);
        comboPanel.setBackground(Color.decode("#4EC67F"));
        this.add(comboPanel, BorderLayout.NORTH);
        dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.PAGE_AXIS));
        this.add(dataPanel, BorderLayout.CENTER);
        buttonPanel.add(btnReset);
        buttonPanel.add(btnEdit);
        buttonPanel.add(btnDel);
        buttonPanel.setBackground(Color.decode("#4EC67F"));
        this.add(buttonPanel,BorderLayout.SOUTH);
    }

    @Override
    public void update(Observable o, Object arg) {
        String header = "";
        String msg = "";
        int type = 0;
        if ((boolean) arg == true){
            header = "Success";
            msg = "Modification effectuée !";
            type = JOptionPane.INFORMATION_MESSAGE;
        } else {
            header = "Error";
            msg = "Erreur lors de la modification";
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
