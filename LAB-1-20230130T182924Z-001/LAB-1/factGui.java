import java.awt.*;
import java.awt.event.*;
class MyDialogue extends Dialog implements ActionListener{

	Button ok;
	MyDialogue(MyFrame f, String name, Boolean modal){
		super(f, name, modal);
		
		ok = new Button("OK");
		ok.addActionListener(this);
		add(ok);
	}
	
	public void paint(Graphics g){
		g.setColor(Color.RED);
		g.setFont(new Font("consolas", Font.BOLD, 20));
		g.drawString("Welcome To My Application ...", 50, 150);
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("consolas", Font.BOLD, 15));
		g.drawString("for continue press OK btn...", 50, 180);
		
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource() == ok) this.dispose();
	}
}
class MyFrame extends Frame implements ActionListener{
	Label l;
	TextField input, res;
	Button get;
	MyDialogue md;
	
	MyFrame(String t){
		super(t);
			
		l = new Label("Enter Number : ");
		input = new TextField(20);
		res = new TextField(20);
		res.setEditable(false);
		
		get = new Button("Factorial ===>");
		
		md = new MyDialogue(this, "Welcome Box", false);
		md.setVisible(true);
		md.setSize(400, 200);
		md.setLayout(new FlowLayout());
		
		get.addActionListener(this);
		
		this.add(l);
		this.add(input);
		this.add(get);
		this.add(res);
	}
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource() == get){
			int n = Integer.parseInt(input.getText().trim());
			int ans  = fact(n);
			res.setText(ans+"");
			input.setText("");
		}
	}
	
	public int fact(int n){
		int ans = 1;
		for(int i=2; i<=n; i++) ans *= i;
		return ans;
	}
}

class FactGui{
	public static void main(String[] args){
		MyFrame f = new MyFrame("FactGui");
		f.setVisible(true);
		f.setSize(400, 400);
		f.setLayout(new FlowLayout());
	}
}