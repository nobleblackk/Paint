import java.util.*;
import java.awt.*;
import java.awt.event.*;
class Paint  implements ActionListener,MouseListener,MouseMotionListener
{
	private Frame f;
	private Button b1[]=new Button[5];
	private Button b[]=new Button[11];
	private Button custom;
	private Panel p1,p2,p3,p4,p5;
	private Graphics g;
	private int x2,y2;
	private boolean bool=true;
	private int x1,y1;
	private Object o;
	private Color cl=Color.BLACK;
	Paint()
	{
		p5=new Panel();
		f=new Frame("PAINT");
		f.setBounds(500,300,1050,800);
		p5.setBounds(450,250,1000,750);
		p1=new Panel(new GridLayout());
		p2=new Panel(new GridLayout());
		p3=new Panel(new GridLayout());
		p4=new Panel();
		for(int i=0;i<b.length;i++)
		{
			b[i]=new Button();
			b[i].addActionListener(this);
		}
		b[0].setBackground(Color.RED);
		b[1].setBackground(Color.GREEN);
		b[2].setBackground(Color.BLUE);
		b[3].setBackground(Color.YELLOW);
		b[4].setBackground(Color.WHITE);
		b[5].setBackground(Color.BLACK);
		b[6].setBackground(Color.CYAN);
		b[7].setBackground(Color.PINK);
		b[8].setBackground(Color.MAGENTA);
		b[9].setBackground(Color.GRAY);
		b[10].setBackground(Color.ORANGE);
		custom=new Button("CUSTOM");	
		p1.add(custom);
		for(int i=0;i<b.length;i++)
		{
			p2.add(b[i]);
		}
		for(int i=0;i<b1.length;i++)
		{
			b1[i]=new Button();
			b1[i].addActionListener(this);
		}
		b1[0].setLabel("DOT");
		b1[1].setLabel("LINE");
		b1[2].setLabel("RECT");
		b1[3].setLabel("OVAL");
		b1[4].setLabel("ZERO");
		b1[4].setBackground(Color.GREEN);
		for(int i=0;i<b1.length;i++)
		{
			p4.add(b1[i]);
		}
		/*b1[4].addActionListener(this);*/		
		
		p3.add(p1);
		p3.add(p2);
		p3.add(p4);
		f.add(p3,"South");
		f.add(p5,"Center");
		
		p5.addMouseListener(this);
		p5.addMouseMotionListener(this);
		
		f.setVisible(true);
		g=p5.getGraphics();
		g.setColor(Color.BLACK);
	}
	public void mousePressed(MouseEvent e)
	{
	}
	public void mouseReleased(MouseEvent e)
	{
		bool=true;
		
	}
	public void mouseEntered(MouseEvent e)
	{
	}
	public void mouseExited(MouseEvent e)
	{
	}
	public void mouseClicked(MouseEvent e)
	{
	}
	public void mouseMoved(MouseEvent e)
	{
		
	}
	public void mouseDragged(MouseEvent e)
	{
		if(o==b1[2])
		{	
		if(bool==true)
		{
			x1=e.getX();
			y1=e.getY();
			bool=false;
		}
		g.setColor(Color.WHITE);
		g.drawRect(x1,y1,(x2-x1),(y2-y1));
		x2=e.getX();
		y2=e.getY();
		g.setColor(cl);
		g.drawRect(x1,y1,(x2-x1),(y2-y1));
		}
		else if(o==b1[3])
		{
			if(bool==true)
		{
			x1=e.getX();
			y1=e.getY();
			bool=false;
		}
		g.setColor(Color.WHITE);
		g.drawOval(x1,y1,(x2-x1),(y2-y1));
		x2=e.getX();
		y2=e.getY();
		g.setColor(cl);
		g.drawOval(x1,y1,(x2-x1),(y2-y1));
		}
		else if(o==b1[1])
		{
			if(bool==true)
		{
			x1=e.getX();
			y1=e.getY();
			bool=false;
		}
		g.setColor(Color.WHITE);
		g.drawLine(x1,y1,x2,y2);
		x2=e.getX();
		y2=e.getY();
		g.setColor(cl);
		g.drawLine(x1,y1,x2,y2);
		}
		else if(o==b1[0])
		{
			x2=e.getX();
			y2=e.getY();
			g.drawLine(x2,y2,x2,y2);
		}	
		
	}
	public void actionPerformed(ActionEvent e)
	{	
		o=e.getSource();
		if(o==custom)
		{
			new ColorMixer();
		}	
		else if(o==b1[4])
		{
				
				
			while(true)
			{	
				int x,y;
				x=(int)(Math.random()*1000);
				y=(int)(Math.random()*750);
				g.drawLine(x,y,x,y);	
				while(true)
				{
					float q;
					q=(float)(Math.random());	
					//System.out.println(q);
					if(q>0&&q<=0.25)
					{	
						x++;
					}
					else if(q>0.25&&q<=0.50)
					{
						x--;	
					}
					else if(q>0.50&&q<=0.75)
					{
						y++;
					}
					else if(q>0.75&&q<=1)
					{
						y--;
					}
					if(x>750)
						x--;
					if(y>=1000)
						y--;
					g.drawLine(x,y,x,y);
		
				}	
			}
		}
		else if(o==b[0])
		{
			cl=Color.RED;
		}
		else if(o==b[1])
		{
			cl=Color.GREEN;
		}
		else if(o==b[2])
		{
			cl=Color.BLUE;
		}
		else if(o==b[3])
		{
			cl=Color.YELLOW;
		}
		else if(o==b[4])
		{
			cl=Color.WHITE;
		}
		else if(o==b[5])
		{
			cl=Color.BLACK;
		}
		else if(o==b[6])
		{
			cl=Color.CYAN;
		}
		else if(o==b[7])
		{
			cl=Color.PINK;
		}
		else if(o==b[8])
		{
			cl=Color.MAGENTA;
		}
		else if(o==b[9])
		{
			cl=Color.GRAY;
		}
		else if(o==b[10])
		{
			cl=Color.ORANGE;
		}
		else if(o==custom)
		{
			
	}	}				
	public static void main(String...hobo)
	{
		new Paint();
	}
}