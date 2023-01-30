import java.awt.*;
import java.awt.event.*;

class MyDialogue extends Dialog implements ActionListener{

	Button add, sub, mul, div;
	MyFrame f;
	
	MyDialogue(MyFrame f, String name, Boolean modal){
		super(f, name, modal);
		
		this.f = f;
		
		add = new Button(" + ");
		sub = new Button(" - ");
		mul = new Button(" * ");
		div = new Button(" / ");
		
		//registratoin ...
		add.addActionListener(this);
		sub.addActionListener(this);
		mul.addActionListener(this);
		div.addActionListener(this);
		
		this.add(add);
		this.add(sub);
		this.add(mul);
		this.add(div);
	}

	public void actionPerformed(ActionEvent ae){
		if(ae.getSource() == add) f.op = new String("+");
		else if(ae.getSource() == sub) f.op = new String("-");
		else if(ae.getSource() == mul) f.op = new String("*");
		else if(ae.getSource() == div) f.op = new String("/");
		
		f.operation.setText(f.op);
		setFrame();
		this.dispose();
	}
	
	public void setFrame(){
		//create Frame...
		f.md = this;
		f.setVisible(true);
		f.setSize(800, 200);
		f.setLayout(new FlowLayout());
	}
}

class MyFrame extends Frame implements ActionListener{
	Label ip1, ip2, operation;
	String op;
	TextField input1, input2, res;
	Button submit, call;
	MyDialogue md;
	
	MyFrame(String t){
		super(t);
		
		ip1 = new Label("Operand 1 : ");
		ip2 = new Label("Operand 2 : "); 
		input2 = new TextField(20);
		input1 = new TextField(20);
		operation = new Label(" "); 

		
		submit = new Button("Submit");
		call = new Button("Call");

		
		res = new TextField(20);
		res.setEditable(false);

		
		//registratoin
		submit.addActionListener(this);
		call.addActionListener(this);
		
		this.add(ip1);
		this.add(input1);
		this.add(operation);
		this.add(ip2);
		this.add(input2);
		this.add(submit);
		this.add(res);
		this.add(call);
	}
	
	public void actionPerformed(ActionEvent ae){
		
		if(ae.getSource() == submit){
			double n1 = Double.parseDouble(input1.getText().trim());
			double n2 = Double.parseDouble(input2.getText().trim());
			double ans = 0.0;
			if(op.equals("+")){
				ans  = n1+n2;
			}
			else if(op.equals("-")){
				ans  = n1-n2;
			}
			else if(op.equals("*")){
				ans  = n1*n2;
			}
			else if(op.equals("/")){
				ans  = n1/n2;
			}
			res.setText(""+ans);
			input1.setText("");
			input2.setText("");
		}
		
		if(ae.getSource() == call){
			MyDialogue md = new MyDialogue(this, "Choose option ...", false);
			md.setVisible(true);
			md.setSize(400, 150);
			md.setLayout(new FlowLayout());
			res.setText("");
		}
	}
}

class Calc_dialog{
	public static void main(String[] args){
		MyFrame f = new MyFrame("Calc + Dialog");

		MyDialogue md = new MyDialogue(f, "Choose option ...", false);
		md.setVisible(true);
		md.setSize(400, 150);
		md.setLayout(new FlowLayout());
	}
}