
    
import java.util.*;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PoliceIntermediateForm extends JFrame
{

    JButton addPolice;
    JButton searchByID;
    JButton showAll;
    JButton updateInfo;
    JButton delete;
    JButton home;


    PoliceIntermediateForm()
    {
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6,1));


        addPolice = new JButton("Add Police");
        searchByID = new JButton("Search Police");
        showAll = new JButton("Display All");
        updateInfo = new JButton("Update");
        delete = new JButton("Delete");
        home = new JButton("Home");
        MyActionListener listener = new MyActionListener();
        addPolice.addActionListener(listener);
        searchByID.addActionListener(listener);
        showAll.addActionListener(listener);
        updateInfo.addActionListener(listener);
        delete.addActionListener(listener);
        home.addActionListener(listener);
        add(addPolice);
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
            if(ae.getActionCommand().equals("Add Police"))   // completed
            {
                PoliceForm pf = new PoliceForm();
            }
            else if(ae.getActionCommand().equals("Search Police"))
            {
                dispose();
                PoliceSearchByIDForm ps = new PoliceSearchByIDForm();
            }
            else if(ae.getActionCommand().equals("Display All"))    //completed
            {
                //dispose();
                ArrayList<Police> arr = Police.readFromFile();
                for(int i = 0 ; i<arr.size(); i++)
                {
                    JOptionPane.showMessageDialog(null, arr.get(i).toString());
                }
            }
            else if(ae.getActionCommand().equals("Update"))
            {
                dispose();
                PoliceUpdateForm pf = new PoliceUpdateForm();
            }
            else if(ae.getActionCommand().equals("Delete"))
            {
                dispose();
                PoliceDeleteForm a = new PoliceDeleteForm();
            }
            else if(ae.getActionCommand().equals("Home"))
            {
                dispose();
                HomeForm h = new HomeForm();
            }
            else
            {
            }
        }
    }

}