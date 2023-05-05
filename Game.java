import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class Game implements KeyListener, MouseListener
{
    private JFrame frame;
    private GamePanel gamePanel;
    boolean running;
    private MyGame game;    
    int width;
    int height;

    protected void start(String title, int width, int height)
    {
    	this.game = (MyGame)this;
    	running = true;
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gamePanel = new GamePanel();
        frame.getContentPane().add(BorderLayout.CENTER, gamePanel);
        frame.setResizable(true);
        frame.setSize(width, height);
        frame.setBackground(Color.BLACK);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.addKeyListener(this);
        frame.addMouseListener(this);
        run();
    }


    class GamePanel extends JPanel
    {
        private static final long serialVersionUID = 1L;
        @Override
        public void paintComponent(Graphics g) { game.draw(g, width, height); }
    }

    private void run()
    {
        while (true)
        {
           game.update();
            try { Thread.sleep(10); }
            catch (InterruptedException e) {}
            width = frame.getWidth();
            height = frame.getHeight();
            frame.repaint();
        }
    }
}