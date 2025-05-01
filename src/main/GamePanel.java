package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
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
  
    
    public Rectangle solidArea;
    public int solidAreaDefaultX;
    public int solidAreaDefaultY;
    
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
        
        // Initialize player collision (solid area)
        // Smaller collision box positioned at the character's feet
        int boxWidth = 30; // Smaller width than character
        int boxHeight = 20; // Small height for feet area
        
        solidAreaDefaultX = (180 - boxWidth) / 2; // Center horizontally
        solidAreaDefaultY = 120 - boxHeight; // Position at the bottom of the sprite
        solidArea = new Rectangle(solidAreaDefaultX, solidAreaDefaultY, boxWidth, boxHeight);
        
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
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
            playerAction = RUNNING; // Set player to running animation
            
            // Check collision and move player
            boolean collisionOn = false;
            
            // Set solidArea to player's current position
            solidArea.x = playerX + solidAreaDefaultX;
            solidArea.y = playerY + solidAreaDefaultY;
            
            // Create a temp collision box for checking potential movement
            Rectangle tempCollision = new Rectangle(solidArea);
            
            // Check collision in potential new position
            if (dx != 0 && dy != 0) {
                // Diagonal movement - normalize speed
                double length = Math.sqrt(dx * dx + dy * dy);
                int newX = (int)(dx / length * playerSpeed);
                int newY = (int)(dy / length * playerSpeed);
                
                // Check X direction
                tempCollision.x = solidArea.x + newX;
                collisionOn = tileM.checkTileCollision(tempCollision);
                
                if (!collisionOn) {
                    // If no collision, move X
                    playerX += newX;
                }
                
                // Check Y direction
                tempCollision.x = solidArea.x; // Reset X to current position
                tempCollision.y = solidArea.y + newY;
                collisionOn = tileM.checkTileCollision(tempCollision);
                
                if (!collisionOn) {
                    // If no collision, move Y
                    playerY += newY;
                }
            } else {
                // Cardinal movement
                if (dx != 0) {
                    // Check X direction
                    tempCollision.x = solidArea.x + (dx * playerSpeed);
                    collisionOn = tileM.checkTileCollision(tempCollision);
                    
                    if (!collisionOn) {
                        // If no collision, move X
                        playerX += dx * playerSpeed;
                    }
                }
                
                if (dy != 0) {
                    // Check Y direction
                    tempCollision.y = solidArea.y + (dy * playerSpeed);
                    collisionOn = tileM.checkTileCollision(tempCollision);
                    
                    if (!collisionOn) {
                        // If no collision, move Y
                        playerY += dy * playerSpeed;
                    }
                }
            }
        } else {
            playerAction = IDLE; // Set player to idle animation
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
        
        updateAnimationTick();
        
        //ANIMATIONS
        g.drawImage(animations[playerAction][aniIndex], playerX, playerY, 180, 120, null);
        
      
        g2.dispose();
    }
}