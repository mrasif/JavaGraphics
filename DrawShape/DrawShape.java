import java.awt.*;
import javax.swing.*;

class DrawShape extends JFrame {
	DrawShape(){
		setTitle("Sample Window");
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setAlwaysOnTop(false);
		setSize(500,400);
		setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
	}
	public static void main(String[] args) {
		new DrawShape().setVisible(true);
	}
	public void paint(Graphics g){
		g.clearRect(0,0,500,400);

		g.setColor(new Color(10,2,200));
		g.drawRect(10,30,50,50);

		g.setColor(new Color(10,200,200));
		g.fillRect(70,80,50,50);

		g.setColor(new Color(100,60,200));
		g.drawArc(130,200,50,50,0,360);

		g.setColor(new Color(100,200,20));
		g.fillArc(200,300,50,50,0,360);
		
		g.setColor(new Color(200,20,20));
		g.fillArc(300,100,50,50,60,180);

		g.setColor(new Color(100,200,20));
		g.fillArc(300,200,50,50,0,360);
		
		g.setColor(new Color(200,20,20));
		g.fillArc(300,200,50,50,60,180);

		g.drawArc(350,300,50,50,60,180);

	}
}