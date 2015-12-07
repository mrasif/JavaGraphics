import java.awt.*;
import javax.swing.*;

class Sample extends JFrame {
	Sample(){
		setTitle("Sample Window");
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setAlwaysOnTop(false);
		setSize(500,400);
		setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
	}
	public static void main(String[] args) {
		new Sample().setVisible(true);
	}
	public void paint(Graphics g){
		g.clearRect(0,0,500,400);
		g.setColor(new Color(10,2,200));
		g.drawString("Hello World !",10,50);
	}
}