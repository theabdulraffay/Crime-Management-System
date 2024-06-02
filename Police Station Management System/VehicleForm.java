
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VehicleForm extends JFrame
{
    JLabel no;
    JTextField noText;
    JLabel type;
    JTextField typeText;
    JLabel cno;
    JTextField cnoText;
    

    JButton submit;
    JButton home;


    VehicleForm()
    {
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(8,1));
        no = new JLabel("NUmber");
        noText = new JTextField(20);
        type = new JLabel("Type");
        typeText = new JTextField(20);
        cno = new JLabel("Chasi No");
        cnoText = new JTextField(20);
        submit = new JButton("Submit");
        home = new JButton("Home");
        MyActionListener listener = new MyActionListener();
        submit.addActionListener(listener);
        home.addActionListener(listener);
        add(no);
        add(noText);
        add(type);
        add(typeText);
        add(cno);
        add(cnoText);
        add(submit);
        add(home);
        setVisible(true);
    } 

    class MyActionListener implements ActionListener         
    {
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getActionCommand().equals("Submit"))
            {
                int no = Integer.parseInt(noText.getText());
                int cno = Integer.parseInt(cnoText.getText());
                Vehicle p = new Vehicle(no, typeText.getText(), cno);
                Vehicle.writeFile(p);
                dispose();
                VehicleForm p1 = new VehicleForm();
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
