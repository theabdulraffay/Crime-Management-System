
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PoliceSearchByIDForm extends JFrame
{
    JLabel searchId;
    JTextField searchIdText;
    JButton search;
    JButton back;


    PoliceSearchByIDForm()
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
                JOptionPane.showMessageDialog(null,Police.searchByID(id).toString());
                dispose();
                PoliceIntermediateForm pi = new PoliceIntermediateForm();
            }
            else if(ae.getActionCommand().equals("Back"))
            {
                dispose();
                PoliceIntermediateForm p1 = new PoliceIntermediateForm();
            }
        }
    }

} 
    

