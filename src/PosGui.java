/**
 * Created by Trenton on 3/6/2015.
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PosGui extends JFrame{

    private JSplitPane splitPane1;
    private JPanel rootPanel;
    private JPanel panelTop;
    private JPanel panelBottom;
    private JButton currentOrderButton;
    private JButton button2;
    private JPanel panelMenu;
    private JButton button1;
    private JButton button3;
    private JButton button5;
    private JButton button6;
    private JLabel label2;

    public PosGui()
    {
        setContentPane(rootPanel);
        setTitle("Restaurant POS");
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        currentOrderButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        setVisible(true);
        label2.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }
}
