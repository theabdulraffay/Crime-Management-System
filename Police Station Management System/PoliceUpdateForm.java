
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PoliceUpdateForm extends JFrame
{
    JLabel searchId;
    JTextField searchIdText;
    JLabel post;
    JTextField postText;
    JLabel salary;
    JTextField salaryText;
    JButton update;
    JButton back;


    PoliceUpdateForm()
    {
        setSize(500,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4,1));

        searchId = new JLabel("ID to Update");
        searchIdText = new JTextField(20);
        post = new JLabel("Enter new Post");
        postText = new JTextField(20);
        salary = new JLabel("Enter new Salary");
        salaryText = new JTextField(20);
        update = new JButton("Update");
        back = new JButton("Back");

        MyActionListener listener = new MyActionListener();
        update.addActionListener(listener);
        back.addActionListener(listener);

        add(searchId);
        add(searchIdText);
        add(post);
        add(postText);
        add(salary);
        add(salaryText);
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
                double salaryy = Double.parseDouble(salaryText.getText());
                Police.update(id, postText.getText(), salaryy);
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