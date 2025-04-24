package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import javax.imageio.ImageIO;
import my2dgame.GamePanel;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    
    GamePanel gp;
    public Tiles[] tile;
    public int mapTileNum[][];
    
    public TileManager(GamePanel gp) {
        
        this.gp = gp;
        
        tile = new Tiles[50];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        
        getTileImage();
        loadMap("/maps/pondMap.txt");
    }
    
    public void getTileImage() {
                   
        try {
            
            tile[0] = new Tiles();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass00.png"));
            
            tile[1] = new Tiles();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass01.png"));
            
            tile[2] = new Tiles();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));
            
            tile[3] = new Tiles();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road00.png"));
            
            tile[4] = new Tiles();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road01.png"));
            
            tile[5] = new Tiles();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road02.png"));
            
            tile[6] = new Tiles();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road03.png"));
            
            tile[7] = new Tiles();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road04.png"));
            
            tile[8] = new Tiles();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road05.png"));
            
            tile[10] = new Tiles();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road06.png"));
            
            tile[9] = new Tiles();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road07.png"));
            
            tile[11] = new Tiles();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road08.png"));
            
            tile[12] = new Tiles();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road09.png"));
            
            tile[13] = new Tiles();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road10.png"));
            
            tile[14] = new Tiles();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road11.png"));
            
            tile[15] = new Tiles();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road12.png"));
            
            tile[18] = new Tiles();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
            tile[18].collision = true;
            
            tile[17] = new Tiles();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/tiles/hut.png"));
            tile[17].collision = true;
            
            tile[16] = new Tiles();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
            tile[16].collision = true;
            
            tile[19] = new Tiles();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/tiles/table01.png"));
            
            tile[20] = new Tiles();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water00.png"));
            tile[20].collision = true;
            
            tile[21] = new Tiles();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water01.png"));
            tile[21].collision = true;
            
            tile[22] = new Tiles();
            tile[22].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water02.png"));
            tile[22].collision = true;
            
            tile[23] = new Tiles();
            tile[23].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water03.png"));
            tile[23].collision = true;
            
            tile[24] = new Tiles();
            tile[24].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water04.png"));
            tile[24].collision = true;
            
            tile[25] = new Tiles();
            tile[25].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water05.png"));
            tile[25].collision = true;
            
            tile[26] = new Tiles();
            tile[26].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water06.png"));
            tile[26].collision = true;
            
            tile[27] = new Tiles();
            tile[27].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water07.png"));
            tile[27].collision = true;
            
            tile[28] = new Tiles();
            tile[28].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water08.png"));
            tile[28].collision = true;
            
            tile[29] = new Tiles();
            tile[29].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water09.png"));
            tile[29].collision = true;
            
            tile[30] = new Tiles();
            tile[30].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water10.png"));
            tile[30].collision = true;
            
            tile[31] = new Tiles();
            tile[31].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water11.png"));
            tile[31].collision = true;
            
            tile[32] = new Tiles();
            tile[32].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water12.png"));
            tile[32].collision = true;
            
            tile[33] = new Tiles();
            tile[33].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water13.png"));
            tile[33].collision = true;
            
        }catch(IOException e) {
            e.printStackTrace();
            
        }
    }
        public void loadMap(String filePath) {
            
            try {
                InputStream is = getClass().getResourceAsStream(filePath);
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
                int col = 0;
                int row = 0;
                
                while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
                    
                    String line = br.readLine();
                    
                    while(col <gp.maxWorldCol){
                        
                        String numbers[] = line.split(" ");
                        
                        int num = Integer.parseInt(numbers[col]);
                        
                        mapTileNum[col][row] = num;
                        col++;
                    }
                    if(col == gp.maxWorldCol) {
                        col = 0;
                        row++;
                    }
                } 
                br.close();
                
        }catch (Exception e) {
            
        }
}
        public void draw(Graphics2D g2) {
            
             int worldCol = 0;
             int worldRow = 0;
             
             while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
                 
                 int tileNum = mapTileNum[worldCol][worldRow];
                 
                 int worldX = worldCol * gp.tileSize;
                 int worldY = worldRow * gp.tileSize;
                 int screenX = worldX - gp.player.worldX + gp.player.screenX;
                 int screenY = worldY - gp.player.worldY + gp.player.screenY;
                 
                 if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                    worldX - gp.tileSize < gp.player.worldX + gp.player.screenX + gp.screenWidth &&
                    worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                    worldY - gp.tileSize < gp.player.worldY + gp.player.screenY + gp.screenHeight) {
                     
                 
                 g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
                 }
                 worldCol++;

                 
                 if(worldCol == gp.maxWorldCol) {
                     worldCol = 0;
                     worldRow++;
            }
        }
    }
}    


  
    

    
    

