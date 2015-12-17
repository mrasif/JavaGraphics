import java.awt.*;
import java.net.URL;
import javax.swing.*;
import java.util.*;

class TrafficSignal extends javax.swing.JFrame{
	int s=0;
	int t=0;
	private int MAX=5;
	TrafficSignal(){
		init();
	}

	private void init(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("TrafficSignal");
        setAlwaysOnTop(false);
        setSize(500,400);
        setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
	}

	public static void main(String[] args) {
		TrafficSignal trafic=new TrafficSignal();
        trafic.setVisible(true);

	}

	public void update(){}
	
	public void paint(Graphics g){
		g.clearRect(0,0,500,400);

		g.setColor(Color.BLACK);
		g.fillRect(50,50,400,300);
		g.setColor(Color.WHITE);
		g.fillOval(100,75,40,40);
		g.fillOval(100,160,40,40);
		g.fillOval(100,240,40,40);
		switch(s){
			case 0:
				g.setColor(Color.RED);
				g.fillOval(100,75,40,40);
				g.drawString("Stop Now  "+(MAX-t), 200,200);
				break;
			case 1:
				g.setColor(Color.YELLOW);
				g.fillOval(100,160,40,40);
				g.drawString("Go Slow  "+(MAX-t), 200,200);
				break;
			case 2:
				g.setColor(Color.GREEN);
				g.fillOval(100,240,40,40);
				g.drawString("Go Now  "+(MAX-t), 200,200);
				break;
			default:
				s=0;
		}

		try{
			Thread.sleep(1000);
		}
		catch(Exception e){}
		finally{
			t=t+1;
			if(t>=MAX){
				t=0;
				s+=1;
			}
			if(s>2){
				s=0;
			}
			repaint();
		}

		/*
		Thread t=new Thread(new Thread(){
			public void run() {
				System.out.println("New thread...");
		 	}
		});
		t.start();
		*/
		
	}

}