package ProgrammingPractice;

//all imports needed in this project
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;



public class Calculator implements ActionListener {
	
	JFrame frame;
	JTextField tf;
	JButton[] numButtons = new JButton[10];
	JButton[] funcButtons = new JButton[9];
	JButton addButton, subButton, mulButton, divButton;   // This data types is for the function Buttons on the calculator
	JButton decButton, equButton, delButton, clrButton, negButton; // This data types is for the other functions on the calculator
	JPanel panel; // This data type is used for the face of the calculator
	
	Font myFont = new Font("Bebas Neue", Font.BOLD,30); // Personal font created and can be used anywhere in the code.
	double num1 = 0, num2 = 0, result = 0; // Number 1 and Number 2 is for users input
	char operator; //char variable is for the Operator used ( + , - , / , * )
	
	// This method parameters is for creating and executing the process of calculating numbers.
	Calculator(){
		frame = new JFrame("My Calculator");                  // Title of the frame.
		frame.setResizable(false);                            // The size cannot be resized.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // It has default close operation
		frame.setSize(420,545);                               // The size of the frame (Height and Width)
		frame.getContentPane().setLayout(null);               

		tf = new JTextField();                                      
		tf.setBounds(50,25,300,50);
		tf.setFont(myFont);
		tf.setEditable(false);
		
	    addButton = new JButton("+");  // addition sign will be added to the frame created
	    subButton = new JButton("-");  // subtraction sign will be added to the frame created
	    mulButton = new JButton("*");  // multiplication sign will be added to the frame created 
	    divButton = new JButton("/");  // division sign will be added to the frame created
	    decButton = new JButton(".");  // decimal sign will be added to the frame created
	    equButton = new JButton("=");  // equal sign will be added to the frame created
	    delButton = new JButton("Delete");
	    clrButton = new JButton("Clear");
	    negButton =new JButton("(-)");
	    
	    funcButtons[0] = addButton; //this variables is for the function buttons needed.
	    funcButtons[1] = subButton;
	    funcButtons[2] = mulButton;
	    funcButtons[3] = divButton;
	    funcButtons[4] = decButton;
	    funcButtons[5] = equButton;
	    funcButtons[6] = delButton;
	    funcButtons[7] = clrButton;
	    funcButtons[8] = negButton;
	    
	    for(int i = 0; i < 9; i++) {
	    	 funcButtons[i].addActionListener(this);
	    	 funcButtons[i].setFont(myFont);
	    	 funcButtons[i].setFocusable(false);
	    }
	    for(int i = 0; i < 10; i++) {
	    	 numButtons[i] = new JButton(String.valueOf(i));
	    	 numButtons[i].addActionListener(this);
	    	 numButtons[i].setFont(myFont);
	    	 numButtons[i].setFocusable(false);
	    }
	    negButton.setBounds(50,430,100,50);
	    delButton.setBounds(150,430,100,50);
	    clrButton.setBounds(250,430,100,50);
	    
	    panel = new JPanel();
	    panel.setBounds(50,100,300,300);
	    panel.setLayout(new GridLayout(4,4,10,10));
	    
	    panel.add(numButtons[1]); // This will be added to the view of the calculator.
	    panel.add(numButtons[2]);
	    panel.add(numButtons[3]);
	    panel.add(addButton);
	    
	    panel.add(numButtons[4]);
	    panel.add(numButtons[5]);
	    panel.add(numButtons[6]);
	    panel.add(subButton);
	    
	    panel.add(numButtons[7]);
	    panel.add(numButtons[8]);
	    panel.add(numButtons[9]);
	    
	    panel.add(mulButton);
	    panel.add(decButton);
	    panel.add(numButtons[0]);
	    panel.add(equButton);
	    panel.add(divButton);
	    
	    
	    frame.add(panel);  // The variables inside will be added inside the frame.
	    frame.add(negButton);
	    frame.add(delButton);
	    frame.add(clrButton);
		frame.add(tf);
		frame.setVisible(true); // The frame is set to be Visible.
		
	}

	public static void main(String[] args) {
	
		Calculator calc = new Calculator();
		// This is for the Function of the variables and data types in the Calculator method.
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0;  i < 10; i++) {                       // This "for loop" is for the number buttons that are added to the frame. numbers from 0-9
			if(e.getSource() == numButtons[i]){
				tf.setText(tf.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource() == decButton) {                    // If the user put decimal point to the number, it will add a "." to the panel that shows the input number
			tf.setText(tf.getText().concat("."));
		}
		if(e.getSource() == addButton) {                   // If the user put "+" to the number it will add the next number the user will input.
			num1 = Double.parseDouble(tf.getText());
			operator = '+';
			tf.setText("");
		}
		if(e.getSource() == subButton) {
			num1 = Double.parseDouble(tf.getText());       // If the user put "-" to the number it will add the next number the user will input.
			operator = '-';
			tf.setText("");
		}
		if(e.getSource() == mulButton) {
			num1 = Double.parseDouble(tf.getText());       // If the user put " * " to the number it will add the next number the user will input.
			operator = '*';
			tf.setText("");
		}
		if(e.getSource() == divButton) {                  // If the user put "/" to the number it will add the next number the user will input.
			num1 = Double.parseDouble(tf.getText());
			operator = '/';
			tf.setText("");
		}                  
		if(e.getSource() == equButton) {                 // If the user press the "=" it will show the output from the users input.
			num2 = Double.parseDouble(tf.getText());     // Retrieve the second numerical operand from the JTextField and parse it to a double.
			switch(operator){                            // Use a switch statement to perform the operation based on the operator previously selected.          
			case '+':
				result = num1+num2;
				break;
			case '-':
				result = num1-num2;
				break;
			case '*':
				result = num1*num2;
				break;
			case '/':
				result = num1/num2;
				break;
			}
			
			tf.setText(String.valueOf(result));
			num1 = result;
		}
		if(e.getSource() == clrButton) {                     // If the user used clear button , it will clear all inputs in the panel that shows the users number inputs.
			tf.setText("");
		}
		if(e.getSource() == delButton) {                     // If the user used delete button, it will delete the input number in the panel.
			String string = tf.getText();                    // Retrieve the text from the JTextField (presumably named tf) and store it in the 'string' variable.
			tf.setText("");                                  // Set the text of the JTextField to an empty string, effectively clearing its content.

			for(int i = 0; i <string.length()-1; i++) {      // Iterate through each character in the 'string', excluding the last character.
				tf.setText(tf.getText() + string.charAt(i)); // Append each character to the JTextField, effectively removing the last character.
			}
			
		}
		if(e.getSource() == negButton) {                     // If the event source is the negation button (negButton), execute the following code block.
			double temp = Double.parseDouble(tf.getText());  // Retrieve the numerical value from the JTextField (presumably named tf) and parse it to a double.
			temp *= -1;                                      // Multiply the parsed value by -1, effectively negating it.
			tf.setText(String.valueOf(temp));                // Set the text of the JTextField to the string representation of the negated value.
			}
			
		}
		
	}

