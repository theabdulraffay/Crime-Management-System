
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PrisonerIntermediateForm extends JFrame
{

    JButton addPrisoner;
    JButton searchByID;
    JButton showAll;
    JButton updateInfo;
    JButton delete;
    JButton home;


    PrisonerIntermediateForm()
    {
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6,1));


        addPrisoner = new JButton("Add Prisoner");
        searchByID = new JButton("Search Prisoner");
        showAll = new JButton("Display All");
        updateInfo = new JButton("Update");
        delete = new JButton("Delete");
        home = new JButton("Home");
        MyActionListener listener = new MyActionListener();
        addPrisoner.addActionListener(listener);
        searchByID.addActionListener(listener);
        showAll.addActionListener(listener);
        updateInfo.addActionListener(listener);
        delete.addActionListener(listener);
        home.addActionListener(listener);
        add(addPrisoner);
        add(searchByID);
        add(showAll);
        add(updateInfo);
        add(delete);
        add(home);
        setVisible(true);
    } 

    class MyActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getActionCommand().equals("Add Prisoner"))   // completed
            {
                PrisonerForm pf = new PrisonerForm();
            }
            else if(ae.getActionCommand().equals("Search Prisoner"))
            {
                dispose();
                PrisonerSearchByIDForm h = new PrisonerSearchByIDForm();
            }
            else if(ae.getActionCommand().equals("Display All"))    //completed
            {
                //dispose();
                ArrayList<Prisoner> arr = Prisoner.readFromFile();
                for(int i = 0 ; i<arr.size(); i++)
                {
                    JOptionPane.showMessageDialog(null, arr.get(i).toString());
                }
            }
            else if(ae.getActionCommand().equals("Update"))
            {
                dispose();
                PrisonerUpdateForm h = new PrisonerUpdateForm();
            }
            else if(ae.getActionCommand().equals("Delete"))
            {
                dispose();
                PrisonerDeleteForm h = new PrisonerDeleteForm();
            }
            else if(ae.getActionCommand().equals("Home"))
            {
                dispose();
                HomeForm h = new HomeForm();
            }
            else
            {
                //JOptionPane.showMessageDialog(null,"aaaaa");
            }
        }
    }

}