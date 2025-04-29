package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import tiles.TileManager;

import static utilz.Constants.PlayerConstants.*;

public class GamePanel extends JPanel implements Runnable{
    
    // SCREEN SETTINGS
    final int originalTileSize = 16; // 16x16 tiles
    final int scale = 3; // scaling the game
    
    public final int tileSize = originalTileSize * scale; //48x48 tiles 
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;
    
    // FPS
    int FPS = 60;
    
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
  
    
    //SETS PLAYER'S DEFAULT POSITION
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4; // You can change this value to any speed
    
    private BufferedImage img;
    private BufferedImage[][] animations; // THIS IS WHERE YOU CAN ADD MORE ANIMATIONS
    private int aniTick, aniIndex, aniSpeed = 4; // YOU CAN CHANGE THE ANIMATION SPEED HERE
    
    private int playerAction = IDLE;
    
    public GamePanel() throws IOException {
        
        importImg();
        loadAnimations();
        
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // rendering performance
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    
    private void importImg() throws IOException {
       InputStream is = getClass().getResourceAsStream("/sprite_sheet.png");
       
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void loadAnimations() {
        animations = new BufferedImage[4][10];
        
        for(int j = 0; j < animations.length; j++)
            for(int i = 0;i < animations[j].length; i++)
                animations[j][i] = img.getSubimage(i*120,j*80, 120, 80);
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
            
            if(delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
        
    }
    
    public void update() {
        // Calculate the direction of movement
        int dx = 0;
        int dy = 0;
        
        if(keyH.upPressed) {
            dy -= 1;
        }
        if(keyH.downPressed) {
            dy += 1;
        }
        if(keyH.leftPressed) {
            dx -= 1;
        }
        if(keyH.rightPressed) {
            dx += 1;
        }
        
        // Apply movement if there's any direction input
        if(dx != 0 || dy != 0) {
            // Normalize for diagonal movement
            if(dx != 0 && dy != 0) {
                // Calculate normalized vector length
                double length = Math.sqrt(dx * dx + dy * dy);
                // Apply speed after normalization
                playerX += (int)Math.round((dx / length) * playerSpeed);
                playerY += (int)Math.round((dy / length) * playerSpeed);
            } else {
                // Regular cardinal movement
                playerX += dx * playerSpeed;
                playerY += dy * playerSpeed;
            }
            
            playerAction = RUNNING;
        } else {
            playerAction = IDLE;
        }
    }
    
    private void updateAnimationTick() {
        aniTick++;
        if(aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if(aniIndex >= GetSpriteAmount(playerAction)) {
                aniIndex = 0;
            }
        }
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
             Graphics2D g2 = (Graphics2D)g;
        
             tileM.draw(g2);
        
            //g.drawImage(img.getSubimage(0, 0, 120, 80), playerX, playerY, null);
            updateAnimationTick();
            
           
            //ANIMATIONS
            g.drawImage(animations[playerAction][aniIndex], playerX, playerY, 180, 120, null); 
    }
}