import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Janela extends JFrame{

	public Janela() {
		super("Calculadora");
		criarInterface();
	}
	
	JLabel resultado = new JLabel();
	JTextField textRes = new JTextField(25);
	
	public void criarInterface() {
		JPanel panel = new JPanel();		
		panel.setLayout(new BorderLayout());
		
		JPanel superior = new JPanel();
		superior.setLayout(new FlowLayout());
		superior.add(resultado);
		superior.add(textRes);
		panel.add(superior, BorderLayout.CENTER);
		
		JButton botao1 = new JButton("1");
		JButton botao2 = new JButton("2");
		JButton botao3 = new JButton("3");
		JButton botao4 = new JButton("4");
		JButton botao5 = new JButton("5");
		JButton botao6 = new JButton("6");
		JButton botao7 = new JButton("7");
		JButton botao8 = new JButton("8");
		JButton botao9 = new JButton("9");
		JButton botao0 = new JButton("0");
		JButton botaoSub = new JButton("-");
		JButton botaoSoma = new JButton("+");
		JButton botaoDiv = new JButton("/");
		JButton botaoMult = new JButton("*");
		JButton botaoIgual = new JButton("=");		
		JButton botaoC = new JButton("C");
		
		JPanel inferior = new JPanel();
		inferior.setLayout(new GridLayout(4,4));
		
		inferior.add(botao7);
		inferior.add(botao8);
		inferior.add(botao9);
		inferior.add(botaoDiv);
		inferior.add(botao4);
		inferior.add(botao5);
		inferior.add(botao6);
		inferior.add(botaoMult);
		inferior.add(botao1);
		inferior.add(botao2);
		inferior.add(botao3);
		inferior.add(botaoSub);
		inferior.add(botao0);
		inferior.add(botaoC);
		inferior.add(botaoIgual);
		inferior.add(botaoSoma);		
		
		botao1.addActionListener(e -> textRes.setText(textRes.getText() + "1"));	
		botao2.addActionListener(e -> textRes.setText(textRes.getText() + "2"));
		botao3.addActionListener(e -> textRes.setText(textRes.getText() + "3"));
		botao4.addActionListener(e -> textRes.setText(textRes.getText() + "4"));
		botao5.addActionListener(e -> textRes.setText(textRes.getText() + "5"));
		botao6.addActionListener(e -> textRes.setText(textRes.getText() + "6"));
		botao7.addActionListener(e -> textRes.setText(textRes.getText() + "7"));
		botao8.addActionListener(e -> textRes.setText(textRes.getText() + "8"));
		botao9.addActionListener(e -> textRes.setText(textRes.getText() + "9"));
		botao0.addActionListener(e -> textRes.setText(textRes.getText() + "0"));
		botaoSub.addActionListener(e -> textRes.setText(textRes.getText() + "-"));		
		botaoSoma.addActionListener(e -> textRes.setText(textRes.getText() + "+"));
		botaoDiv.addActionListener(e -> textRes.setText(textRes.getText() + "/"));
		botaoMult.addActionListener(e -> textRes.setText(textRes.getText() + "*"));
		botaoIgual.addActionListener(this::ActionListener);		
		botaoC.addActionListener(e -> textRes.setText(""));
		
		
		panel.add(inferior, BorderLayout.SOUTH);
		
		
		add(panel);
	}
	
    public static void main(String[] args) {
        JFrame frame = new Janela();
        
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);        
    }
    
    public void ActionListener(ActionEvent e) {   	
    	String digitado = textRes.getText();
    	String op = "";
    	Double[] numeros = new Double[2];
    	int c=0;
    	int i=0;
    	while( c < 2 ) {
    		
    		if( Character.isDigit(digitado.charAt(i))== false ) {
    			op = String.valueOf(digitado.charAt(i));
    		}else {
    			numeros[c] = ( Double.parseDouble( String.valueOf( digitado.charAt(i) ) ) );
    			c++;
    		}    	    		
    		i++;
    	}
    	
    	if( numeros != null || !op.isEmpty()) {
    		textRes.setText( calcular(numeros, op) );
    	}
    	
    	
    }
    
    public String calcular(Double[] num, String op) {    	    	
    	
    	double resultado = 0;
    	
    	if(op.equals("+")) {
    		resultado = num[0] + num[1] ;
    	}else if(op.equals("-")) {
    		resultado = num[0] - num[1];
    	}else if(op.equals("*")) {
    		resultado = num[0] * num[1];
    	}else if(op.equals("/")) {
    		resultado = num[0] / num[1];
    	}
    	return "" + resultado;
    }
     
}

    
