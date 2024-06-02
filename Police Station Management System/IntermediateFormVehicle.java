
    
import java.util.*;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IntermediateFormVehicle extends JFrame
{

    JButton addVehicle;
    JButton searchBychasiNo;
    JButton showAll;
    // JButton updateInfo;
    JButton delete;
    JButton home;


    IntermediateFormVehicle()
    {
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5,1));


        addVehicle = new JButton("Add Vehicle");
        searchBychasiNo = new JButton("Search Vehicle");
        showAll = new JButton("Display All");
        // updateInfo = new JButton("Update");
        delete = new JButton("Delete");
        home = new JButton("Home");
        MyActionListener listener = new MyActionListener();
        addVehicle.addActionListener(listener);
        searchBychasiNo.addActionListener(listener);
        showAll.addActionListener(listener);
        // updateInfo.addActionListener(listener);
        delete.addActionListener(listener);
        home.addActionListener(listener);
        add(addVehicle);
        add(searchBychasiNo);
        add(showAll);
        // add(updateInfo);
        add(delete);
        add(home);
        setVisible(true);
    } 

    class MyActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getActionCommand().equals("Add Vehicle"))   // completed
            {
                VehicleForm pf = new VehicleForm();
            }
            else if(ae.getActionCommand().equals("Search Vehicle")) //complete
            {
                dispose();
                VehicleSearchForm ps = new VehicleSearchForm();
            }
            else if(ae.getActionCommand().equals("Display All"))    //completed
            {
                dispose();
                ArrayList<Vehicle> arr = Vehicle.readFromFile();
                for(int i = 0 ; i<arr.size(); i++)
                {
                    JOptionPane.showMessageDialog(null, arr.get(i).toString());
                }
                dispose();
                IntermediateFormVehicle p = new IntermediateFormVehicle();
            }
            // else if(ae.getActionCommand().equals("Update"))
            // {
            //     dispose();
            //     PoliceUpdateForm pf = new PoliceUpdateForm();
            // }
            else if(ae.getActionCommand().equals("Delete"))  //complete
            {
                dispose();
                VehicleDeleteForm a = new VehicleDeleteForm();
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