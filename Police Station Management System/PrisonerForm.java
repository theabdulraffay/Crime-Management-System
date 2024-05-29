import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrisonerForm extends JFrame
{
    JLabel id;
    JTextField idText;
    JLabel name;
    JTextField nameText;
    JLabel age;
    JTextField ageText;
    JLabel gender;
    JTextField genderText;
    JLabel crime;
    JTextField crimeText;
    JLabel tenure;
    JTextField tenureText;
    JLabel cellNo;
    JTextField cellNoText;

    JButton submit;
    JButton home;


    PrisonerForm()
    {
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(8,1));
        id = new JLabel("ID");
        idText = new JTextField(20);
        name = new JLabel("Name");
        nameText = new JTextField(20);
        age = new JLabel("Age");
        ageText = new JTextField(20);
        gender = new JLabel("Gender");
        genderText = new JTextField(20);
        crime = new JLabel("Crime");
        crimeText = new JTextField(20);
        tenure = new JLabel("Tenure");
        tenureText = new JTextField(20);
        cellNo = new JLabel("Cell #");
        cellNoText = new JTextField(20);
        submit = new JButton("Submit");
        home = new JButton("Home");
        MyActionListener listener = new MyActionListener();
        submit.addActionListener(listener);
        home.addActionListener(listener);
        add(id);
        add(idText);
        add(name);
        add(nameText);
        add(age);
        add(ageText);
        add(gender);
        add(genderText);
        add(crime);
        add(crimeText);
        add(tenure);
        add(tenureText);
        add(cellNo);
        add(cellNoText);
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
                int id = Integer.parseInt(idText.getText());
                int age = Integer.parseInt(ageText.getText());
                int cellNo = Integer.parseInt(cellNoText.getText());
                Prisoner p = new Prisoner(nameText.getText(), age, genderText.getText(), id, crimeText.getText(), cellNoText.getText(), cellNo);
                Prisoner.writeFile(p);
                dispose();
                PrisonerForm p1 = new PrisonerForm();
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
