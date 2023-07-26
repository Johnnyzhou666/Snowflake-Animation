import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class SnowPanel extends JPanel
{
    private int[] x=new int[100];
    private int[] y=new int[100];

    public SnowPanel()
    {
        setBackground(Color.black);
        for(int i=0;i<x.length;i++)
        {
            x[i]=(int)(Math.random()*728);
            y[i]=(int)(Math.random()*455);
        }
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        try {
            BufferedImage image = ImageIO.read(new File("src\\images.jpg"));
            g.drawImage(image,0,0,null);

            g.setColor(Color.white);
            g.setFont(new Font("",1,20));

            for(int i=0;i<x.length;i++)
            {
                g.drawString("*",x[i],y[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void startSnow()
    {
        new Thread()
        {
            public void run()
            {
                while(true)
                {
                    for(int i=0;i<y.length;i++)
                    {
                        y[i]++;
                        if(y[i]==455)
                            y[i]=0;

                        repaint();
                    }

                    try
                    {
                        Thread.sleep(10);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
