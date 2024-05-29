
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrisonerDeleteForm extends JFrame
{
    JLabel deleteId;
    JTextField deleteIdText;
    JButton delete;
    JButton back;


    PrisonerDeleteForm()
    {
        setSize(500,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(2,1));

        deleteId = new JLabel("ID to Delete");
        deleteIdText = new JTextField(20);
        delete = new JButton("Delete");
        back = new JButton("Back");

        MyActionListener listener = new MyActionListener();
        delete.addActionListener(listener);
        back.addActionListener(listener);

        add(deleteId);
        add(deleteIdText);
        add(delete);
        add(back);
        setVisible(true);
    } 

    class MyActionListener implements ActionListener           
    {
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getActionCommand().equals("Delete"))
            {
                int id = Integer.parseInt(deleteIdText.getText());
                Prisoner.delete(id);
                JOptionPane.showMessageDialog(null,"Deleted Successfully...");
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