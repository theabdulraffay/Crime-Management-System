
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrisonerSearchByIDForm extends JFrame
{
    JLabel searchId;
    JTextField searchIdText;
    JButton search;
    JButton back;


    PrisonerSearchByIDForm()
    {
        setSize(500,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(2,1));

        searchId = new JLabel("ID to Search");
        searchIdText = new JTextField(20);
        search = new JButton("Search");
        back = new JButton("Back");

        MyActionListener listener = new MyActionListener();
        search.addActionListener(listener);
        back.addActionListener(listener);

        add(searchId);
        add(searchIdText);
        add(search);
        add(back);
        setVisible(true);
    } 

    class MyActionListener implements ActionListener           
    {
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getActionCommand().equals("Search"))
            {
                int id = Integer.parseInt(searchIdText.getText());
                
                JOptionPane.showMessageDialog(null,Prisoner.searchByID(id).toString());
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
    

