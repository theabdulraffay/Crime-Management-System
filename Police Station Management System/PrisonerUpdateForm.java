
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrisonerUpdateForm extends JFrame
{
    JLabel searchId;
    JTextField searchIdText;
    JLabel cell;
    JTextField cellText;
    JButton update;
    JButton back;


    PrisonerUpdateForm()
    {
        setSize(500,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4,1));

        searchId = new JLabel("ID to Update");
        searchIdText = new JTextField(20);
        cell = new JLabel("Enter new Cell #");
        cellText = new JTextField(20);
        update = new JButton("Update");
        back = new JButton("Back");

        MyActionListener listener = new MyActionListener();
        update.addActionListener(listener);
        back.addActionListener(listener);

        add(searchId);
        add(searchIdText);
        add(cell);
        add(cellText);
        add(update);
        add(back);
        setVisible(true);
    } 

    class MyActionListener implements ActionListener           
    {
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getActionCommand().equals("Update"))
            {
                int id = Integer.parseInt(searchIdText.getText());
                int cel = Integer.parseInt(cellText.getText());
                Prisoner.update(id, cel);
                dispose();
                PrisonerIntermediateForm pi = new PrisonerIntermediateForm();
            }
            else if(ae.getActionCommand().equals("Back"))
            {
                dispose();
                PrisonerIntermediateForm p1 = new PrisonerIntermediateForm();
            }
        }
    }

} 