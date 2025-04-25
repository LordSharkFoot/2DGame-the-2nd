
package entity.newpackage;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import my2dgame.GamePanel;
import my2dgame.KeyHandler;

public class Player extends Entity{
    
    GamePanel gp;
    KeyHandler keyH;
    
    public final int screenX;
    public final int screenY;
    
    public Player(GamePanel gp, KeyHandler keyH){
        
        this.gp = gp;
        this.keyH = keyH;
        
        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);
        
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 32;
        solidArea.height = 32;
        
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues() {
        
        worldX = gp.tileSize * 13;
        worldY = gp.tileSize * 11;
        speed = 6;
        direction = "up";
    }
    public void getPlayerImage(){
        
        try {
            
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/sprite_4.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/sprite_5.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/sprite_0.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/sprite_1.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/sprite_2.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/sprite_3.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/sprite_0.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/sprite_1.png"));
            
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void update() {
    if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
        
        if(keyH.upPressed) {
            direction = "up";
        }
        if(keyH.downPressed) {
            direction = "down";
        }
        if(keyH.leftPressed) {
            direction = "left";
        }
        if(keyH.rightPressed) {
            direction = "right";
        }
        
        // Check if moving diagonally
        boolean movingDiagonally = (keyH.upPressed || keyH.downPressed) && (keyH.leftPressed || keyH.rightPressed);
        
        // Adjust speed for diagonal movement
        int moveSpeed = speed;
        if(movingDiagonally) {
            moveSpeed = (int)(speed * 0.75);
        }
        
        // Check collision
        collisionOn = false;
        gp.dDetector.checkTile(this);
        
        // If collision is false, player can move
        if(!collisionOn) {
            int originalWorldX = worldX;
            int originalWorldY = worldY;
            
            // Handle vertical movement
            if(keyH.upPressed) {
                if(worldY - moveSpeed >= 0) {
                    worldY -= moveSpeed;
                }
            }
            if(keyH.downPressed) {
                if(worldY + moveSpeed < gp.maxWorldRow * gp.tileSize) {
                    worldY += moveSpeed;
                }
            }
            
            // Check collision after vertical movement
            collisionOn = false;
            gp.dDetector.checkTile(this);
            if(collisionOn) {
                worldY = originalWorldY; // Reset Y position if collision
            }
            
            // Handle horizontal movement
            if(keyH.leftPressed) {
                if(worldX - moveSpeed >= 0) {
                    worldX -= moveSpeed;
                }
            }
            if(keyH.rightPressed) {
                if(worldX + moveSpeed < gp.maxWorldCol * gp.tileSize) {
                    worldX += moveSpeed;
                }
            }
            
            // Check collision after horizontal movement
            collisionOn = false;
            gp.dDetector.checkTile(this);
            if(collisionOn) {
                worldX = originalWorldX; // Reset X position if collision
            }
        }
        
        // Boundary checking
        if(worldX < 0) worldX = 0;
        if(worldY < 0) worldY = 0;
        if(worldX > gp.maxWorldCol * gp.tileSize - gp.tileSize) 
            worldX = gp.maxWorldCol * gp.tileSize - gp.tileSize;
        if(worldY > gp.maxWorldRow * gp.tileSize - gp.tileSize) 
            worldY = gp.maxWorldRow * gp.tileSize - gp.tileSize;
        
        // Animation
        spriteCounter++;
        if(spriteCounter > 12) {
            spriteNum = (spriteNum == 1) ? 2 : 1;
            spriteCounter = 0;
        }
    }
}
        
    public void draw(Graphics2D g2) {
        
          //g2.setColor(Color.white);
          //g2.fillRect(x, y, gp.tileSize, gp.tileSize);
          
          BufferedImage image = null;
          
          switch(direction) {
          case "up":
              if(spriteNum == 1) {
                  image = up1;
              }
              if(spriteNum == 2) {
                  image = up2;
              }
              break;
          case "down":
              if(spriteNum == 1) {
                  image = down1;
              }
              if(spriteNum == 2) {
                  image = down2;
              }
              break;
          case "left":
              if(spriteNum == 1) {
                  image = left1;
              }
              if(spriteNum == 2) {
                  image = left2;
              }
              break;
          case "right":
              if(spriteNum == 1) {
                  image = right1;
              }
              if(spriteNum == 2) {
                  image = right2;
              }
              break;   
          }
          g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
 }