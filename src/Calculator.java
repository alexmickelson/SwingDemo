import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    static JTextField num1;
    static JTextField num2;
    static JTextField result;

    public static void main(String[] args){
        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));

        fillFrame(frame);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        frame.pack();
        frame.setVisible(true);
    }



    private static void fillFrame(JFrame frame) {
        frame.setLayout(new GridBagLayout());

        //sets options to be added with each element of the frame
        GridBagConstraints c = new GridBagConstraints();

        //some variables
        JButton button;
        JTextField text;
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        //set the two text boxes on first row
        //numbers only
        /*
        NumberFormatter formatter = new NumberFormatter(NumberFormat.getInstance());
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        */


        //first field
        num1 = new JTextField("", 10);
        c.ipadx = 50;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(num1, c);


        num2 = new JTextField("", 10);
        c.ipadx = 50;
        c.gridx = 1;
        c.gridy = 0;
        panel.add(num2, c);

        frame.add(panel);


        //next section
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        //set options for a button
        button= new JButton("Do Both");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                result.setText("Sum: " + (Integer.parseInt(num1.getText()) + Integer.parseInt(num2.getText())
                            +  ", Difference: " + (Integer.parseInt(num1.getText()) - Integer.parseInt(num2.getText()))));
            }
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 0;
        c.ipady = 30;
        c.gridheight = 2;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(button, c);

        button = new JButton("Add");
        button.addActionListener(e -> result.setText("Sum: " + (Integer.parseInt(num1.getText()) + Integer.parseInt(num2.getText()))));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.ipady = 0;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        panel.add(button, c);

        button = new JButton("Subtract");
        button.addActionListener(e -> result.setText("Difference: " + (Integer.parseInt(num1.getText()) - Integer.parseInt(num2.getText()))));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 1;
        panel.add(button, c);

        //add section 2 to frame
        c.gridx = 0;
        c.gridy = 1;
        frame.add(panel, c);

        //section 3
        result = new JTextField("Result");
        result.setEditable(false);
        c.gridy = 2;
        c.fill = GridBagConstraints.BOTH;
        frame.add(result, c);


    }

}
