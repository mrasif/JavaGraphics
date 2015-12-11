import java.awt.*;
import java.net.URL;
import javax.swing.*;
import java.util.*;

class SimpleAnimation extends javax.swing.JFrame{
	static Ball b[];
	SimpleAnimation(){
		init();
	}

	private void init(){
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("SimpleAnimation");
        setAlwaysOnTop(false);
        setSize(500,400);
        setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);


		Color clr;
		int r=40;
		for (int i=0; i<b.length; i++) {
			clr=new Color((int)(Math.random()*100 + 100),(int)(Math.random()*100 + 100),(int)(Math.random()*200 + 50));
			b[i]=new Ball((int)(Math.random()*(500-2*r)),(int)(Math.random()*(400-2*r)),r,clr);
		}
	}

	public static void main(String[] args) {
		System.out.print("Enter No of Ball:");
		b=new Ball[new Scanner(System.in).nextInt()];
		System.out.println("Prease Ctrl+C to exit...");
		SimpleAnimation ani=new SimpleAnimation();
        ani.setVisible(true);

	}

	public void update(){}
	
	public void paint(Graphics g){

		g.setColor(Color.black);
		//g.clearRect(0,0,500,400);
		g.fillRect(0,0,500,400);
		for (int i=0; i<b.length; i++) {
			b[i].render(g);
		}
		try{
			Thread.sleep(50);
		}
		catch(Exception e){}
		repaint();
	

		/*
		Thread t=new Thread(new Thread(){
			public void run() {
				System.out.println("New thread...");
		 	}
		});
		t.start();
		*/
		
	}

	private class Ball{
		public  int x=0;
		public  int y=0;
		public  int r=0;
		public  Color c=null;
		private  int xd=(int)((Math.random()*40)/10+1);
		private  int yd=(int)((Math.random()*40)/10+1);
		Graphics g;
		Ball(int x,int y, int r, Color c){
			this.x=x+Integer.valueOf(r/2);
			this.y=y+Integer.valueOf(r/2);
			this.r=r;
			this.c=c;
		}

		public void setColor(Color c){
			this.c=c;
		}

		public void render(Graphics g){
			this.g=g;
			g.setColor(c);
			g.fillArc(x,y,r,r,0,360);
			g.setColor(Color.green);
			g.fillArc(x+10,y+10,7,5,0,360);
			g.setColor(Color.black);
			g.fillArc(x+10,y+10,7,5,0,360);
			g.drawArc(x,y,r,r,0,720);
			g.fillArc(x+25,y+10,7,5,0,360);
			g.drawArc(x+5,y,30,30,240,60);
			//g.drawString("A",x+15,y+25);
			x+=xd;
			y+=yd;
			if(x>500-r || x<0){xd=-xd;}
			if(y>400-r || y<0){yd=-yd;}
		}
	}
}