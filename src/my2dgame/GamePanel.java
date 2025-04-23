package my2dgame;

import entity.newpackage.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import main.CollisionDetector;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {
    
    //DISPLAY SETTINGS
    final int originalTileSize = 16;
    final int scale = 3;
            
     public final int tileSize = originalTileSize * scale;
     public final int maxScreenCol = 16;
     public int maxScreenRow = 12;
     public final int screenWidth = tileSize * maxScreenCol;
     public final int screenHeight = tileSize * maxScreenRow;
     
     //WORLD SETTINGS
     public final int maxWorldCol = 50;
     public final int maxWorldRow = 50;
     public final int worldWidth = tileSize * maxWorldCol;
     public final int worldHeight = tileSize * maxWorldRow;
     
     //FPS
     int FPS = 60;
     
     public TileManager tileM = new TileManager(this);
     KeyHandler keyH = new  KeyHandler();
     Thread gameThread;
     public CollisionDetector dDetector = new CollisionDetector(this);
     public Player player = new Player(this,keyH);
     
     
     public GamePanel() {
         
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
     }
      public void startGameThread() {  
    
         gameThread = new Thread(this);
         gameThread.start();
     }

    @Override
    public void run() {
        
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
      
        while(gameThread != null) {
            
            currentTime = System.nanoTime();
            
            delta += (currentTime - lastTime) / drawInterval;
            
            lastTime = currentTime;
            
           if(delta >= 1){ 
            update();
            repaint();
            delta--;
           }
        }
      }
    public void update() {
 
        player.update();
        }
    public void paintComponent(Graphics g) {
        
           super.paintComponent(g);
           
           Graphics2D g2 = (Graphics2D)g;
           
           tileM.draw(g2);
           
           player.draw(g2);
           
           g2.dispose();
      }
    }
     
    
    