import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton,equButton,delButton,clrButton,negButton;
    JPanel panel;

    Font myFont = new Font("Arial",Font.BOLD,20);

    double num1=0,num2=0,result=0;
    char operator;


    Calculator(){

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,600);
        // Set the layout manager to null to use absolute positioning
        frame.setLayout(null);

        textField = new JTextField();
        // The line below sets the position and size of the textField component
        // using absolute coordinates. The textField is placed at (50, 25) with
        // a width of 300 pixels and a height of 50 pixels.
        textField.setBounds(50,25,300,50);
        // The line below sets the border of the textField to a black line.
        textField.setBorder(BorderFactory.createLineBorder(Color.black));
        textField.setFont(myFont);
        // The line below makes the textField non-editable, so the user cannot modify its content.
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for(JButton i : functionButtons ){
            if(i==equButton) {
                i.addActionListener(this);
                i.setBounds(50, 420, 300, 50);
                i.setFont(myFont);
            }
            else {
                i.addActionListener(this);
                i.setFont(myFont);
                i.setFocusable(false);
            }
        }

        // Iterate over each index in the numberButtons array
        for (int i = 0; i < numberButtons.length; i++) {
            // Create a new JButton with the label as the index value
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);

        }

        negButton.setBounds(50,500,100,40);
        delButton.setBounds(90,500,100,40);
        clrButton.setBounds(220,500,100,40);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        //panel.setBackground(Color.gray);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(negButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(equButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<10;i++){
            if(e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decButton){
            textField.setText(textField.getText().concat((".")));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText((""));
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText((""));
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText((""));
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText((""));
        }
        if(e.getSource()==equButton){
            num2=Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            //display the result
            textField.setText(String.valueOf(result));
            //store the result in num1 so that the user can perform further operations on the result
            num1=result;

        }
        if(e.getSource()==clrButton){
            textField.setText("");
        }

        /*
        //delete the last character method1
        if(e.getSource()==delButton){
            String string = textField.getText();
            textField.setText("");
            for(int i=0;i<string.length()-1;i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
        */

        //delete the last character method2(using substring method)
        if (e.getSource()==delButton){
            String string=textField.getText();
            textField.setText((string.substring(0,string.length()-1)));

        }
        if(e.getSource()==negButton){
            if (textField.getText().isEmpty()){
                textField.setText("-");
            }
            else if (textField.getText().equals("-")){
                textField.setText("");
            }
            else {
            double temp = Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText( String.valueOf(temp));
        }
    }

    }
}