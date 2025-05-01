package tiles;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import main.GamePanel;
import tiles.Tile;

public class TileManager {
    
    GamePanel gp;
    Tile[] tile;
    
    // Number of layers in the map
    public final int maxLayers = 2; // You can adjust this number based on your needs
    
    // 3D array to store map data: [layer][col][row]
    int mapTileNum[][][];
    
    // File paths for each layer
    private String[] layerFiles = {
        "/maps/layer0.txt", // Base/ground layer
        "/maps/layer1.txt", // Objects/decorations layer
    };
    
    public TileManager(GamePanel gp) {
        this.gp = gp;
        
        tile = new Tile[192]; // Space for different tiles
        mapTileNum = new int[maxLayers][gp.maxScreenCol][gp.maxScreenRow];
        
        getTileImage();
        loadAllLayers();
    }
    
    public void getTileImage() {
        try {
            // Load your tile images
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tile/0.png"));
            tile[0].collision = false; // Changed to false - empty tiles shouldn't have collision

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tile/1.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tile/2.png"));
            tile[2].collision = true;
            
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/Tile/3.png"));
            tile[3].collision = true;

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/Tile/4.png"));
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/Tile/5.png"));
            tile[5].collision = true;

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/Tile/6.png"));
            tile[6].collision = false;

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/Tile/7.png"));
            tile[7].collision = false;

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/Tile/8.png"));
            tile[8].collision = false;

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/Tile/9.png"));
            tile[9].collision = false;

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/Tile/10.png"));
            tile[10].collision = true;

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/Tile/11.png"));
            tile[11].collision = false;

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/Tile/12.png"));
            tile[12].collision = false;

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/Tile/13.png"));
            tile[13].collision = false;

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/Tile/14.png"));
            tile[14].collision = false;

            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/Tile/15.png"));
            tile[15].collision = true;

            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/Tile/16.png"));
            tile[16].collision = false;

            tile[17] = new Tile();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/Tile/17.png"));
            tile[17].collision = false;

            tile[18] = new Tile();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/Tile/18.png"));
            tile[18].collision = false;

            tile[19] = new Tile();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/Tile/19.png"));
            tile[19].collision = false;

            tile[20] = new Tile();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/Tile/20.png"));
            tile[20].collision = true;

            tile[21] = new Tile();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/Tile/21.png"));

            tile[22] = new Tile();
            tile[22].image = ImageIO.read(getClass().getResourceAsStream("/Tile/22.png"));

            tile[23] = new Tile();
            tile[23].image = ImageIO.read(getClass().getResourceAsStream("/Tile/23.png"));

            tile[24] = new Tile();
            tile[24].image = ImageIO.read(getClass().getResourceAsStream("/Tile/24.png"));

            tile[25] = new Tile();
            tile[25].image = ImageIO.read(getClass().getResourceAsStream("/Tile/25.png"));
            tile[25].collision = true;

            tile[26] = new Tile();
            tile[26].image = ImageIO.read(getClass().getResourceAsStream("/Tile/26.png"));

            tile[27] = new Tile();
            tile[27].image = ImageIO.read(getClass().getResourceAsStream("/Tile/27.png"));

            tile[28] = new Tile();
            tile[28].image = ImageIO.read(getClass().getResourceAsStream("/Tile/28.png"));

            tile[29] = new Tile();
            tile[29].image = ImageIO.read(getClass().getResourceAsStream("/Tile/29.png"));

            tile[30] = new Tile();
            tile[30].image = ImageIO.read(getClass().getResourceAsStream("/Tile/30.png"));
            tile[30].collision = true;

            tile[31] = new Tile();
            tile[31].image = ImageIO.read(getClass().getResourceAsStream("/Tile/31.png"));

            tile[32] = new Tile();
            tile[32].image = ImageIO.read(getClass().getResourceAsStream("/Tile/32.png"));

            tile[33] = new Tile();
            tile[33].image = ImageIO.read(getClass().getResourceAsStream("/Tile/33.png"));

            tile[34] = new Tile();
            tile[34].image = ImageIO.read(getClass().getResourceAsStream("/Tile/34.png"));

            tile[35] = new Tile();
            tile[35].image = ImageIO.read(getClass().getResourceAsStream("/Tile/35.png"));
            tile[35].collision = true;

            tile[36] = new Tile();
            tile[36].image = ImageIO.read(getClass().getResourceAsStream("/Tile/36.png"));
            tile[36].collision = true;

            tile[37] = new Tile();
            tile[37].image = ImageIO.read(getClass().getResourceAsStream("/Tile/37.png"));
            tile[37].collision = true;

            tile[38] = new Tile();
            tile[38].image = ImageIO.read(getClass().getResourceAsStream("/Tile/38.png"));
            tile[38].collision = true;

            tile[39] = new Tile();
            tile[39].image = ImageIO.read(getClass().getResourceAsStream("/Tile/39.png"));
            tile[39].collision = true;

            tile[40] = new Tile();
            tile[40].image = ImageIO.read(getClass().getResourceAsStream("/Tile/40.png"));
            tile[40].collision = true;

            tile[41] = new Tile();
            tile[41].image = ImageIO.read(getClass().getResourceAsStream("/Tile/41.png"));
            tile[41].collision = true;

            tile[42] = new Tile();
            tile[42].image = ImageIO.read(getClass().getResourceAsStream("/Tile/42.png"));
            tile[42].collision = true;

            tile[43] = new Tile();
            tile[43].image = ImageIO.read(getClass().getResourceAsStream("/Tile/43.png"));
            tile[43].collision = true;

            tile[44] = new Tile();
            tile[44].image = ImageIO.read(getClass().getResourceAsStream("/Tile/44.png"));
            tile[44].collision = true;

            tile[45] = new Tile();
            tile[45].image = ImageIO.read(getClass().getResourceAsStream("/Tile/45.png"));
            tile[45].collision = true;

            tile[46] = new Tile();
            tile[46].image = ImageIO.read(getClass().getResourceAsStream("/Tile/46.png"));
            tile[46].collision = true;

            tile[47] = new Tile();
            tile[47].image = ImageIO.read(getClass().getResourceAsStream("/Tile/47.png"));
            tile[47].collision = true;
            
            tile[48] = new Tile();
            tile[48].image = ImageIO.read(getClass().getResourceAsStream("/Tile/48.png"));
            tile[48].collision = true;

            tile[49] = new Tile();
            tile[49].image = ImageIO.read(getClass().getResourceAsStream("/Tile/49.png"));

            tile[50] = new Tile();
            tile[50].image = ImageIO.read(getClass().getResourceAsStream("/Tile/50.png"));
            tile[50].collision = true;

            tile[51] = new Tile();
            tile[51].image = ImageIO.read(getClass().getResourceAsStream("/Tile/51.png"));
            tile[51].collision = true;

            tile[52] = new Tile();
            tile[52].image = ImageIO.read(getClass().getResourceAsStream("/Tile/52.png"));
            tile[52].collision = true;

            tile[53] = new Tile();
            tile[53].image = ImageIO.read(getClass().getResourceAsStream("/Tile/53.png"));
            tile[53].collision = true;

            tile[54] = new Tile();
            tile[54].image = ImageIO.read(getClass().getResourceAsStream("/Tile/54.png"));
            tile[54].collision = true;

            tile[55] = new Tile();
            tile[55].image = ImageIO.read(getClass().getResourceAsStream("/Tile/55.png"));
            tile[55].collision = true;

            tile[56] = new Tile();
            tile[56].image = ImageIO.read(getClass().getResourceAsStream("/Tile/56.png"));
            tile[56].collision = true;

            tile[57] = new Tile();
            tile[57].image = ImageIO.read(getClass().getResourceAsStream("/Tile/57.png"));
            tile[57].collision = true;

            tile[58] = new Tile();
            tile[58].image = ImageIO.read(getClass().getResourceAsStream("/Tile/58.png"));
            tile[58].collision = true;

            tile[59] = new Tile();
            tile[59].image = ImageIO.read(getClass().getResourceAsStream("/Tile/59.png"));

            tile[60] = new Tile();
            tile[60].image = ImageIO.read(getClass().getResourceAsStream("/Tile/60.png"));

            tile[61] = new Tile();
            tile[61].image = ImageIO.read(getClass().getResourceAsStream("/Tile/61.png"));

            tile[62] = new Tile();
            tile[62].image = ImageIO.read(getClass().getResourceAsStream("/Tile/62.png"));

            tile[63] = new Tile();
            tile[63].image = ImageIO.read(getClass().getResourceAsStream("/Tile/63.png"));

            tile[64] = new Tile();
            tile[64].image = ImageIO.read(getClass().getResourceAsStream("/Tile/64.png"));

            tile[65] = new Tile();
            tile[65].image = ImageIO.read(getClass().getResourceAsStream("/Tile/65.png"));

            tile[66] = new Tile();
            tile[66].image = ImageIO.read(getClass().getResourceAsStream("/Tile/66.png"));
            tile[66].collision = true;

            tile[67] = new Tile();
            tile[67].image = ImageIO.read(getClass().getResourceAsStream("/Tile/67.png"));
            tile[67].collision = true;

            tile[68] = new Tile();
            tile[68].image = ImageIO.read(getClass().getResourceAsStream("/Tile/68.png"));

            tile[69] = new Tile();
            tile[69].image = ImageIO.read(getClass().getResourceAsStream("/Tile/69.png"));

            tile[70] = new Tile();
            tile[70].image = ImageIO.read(getClass().getResourceAsStream("/Tile/70.png"));

            tile[71] = new Tile();
            tile[71].image = ImageIO.read(getClass().getResourceAsStream("/Tile/71.png"));

            tile[72] = new Tile();
            tile[72].image = ImageIO.read(getClass().getResourceAsStream("/Tile/72.png"));

            tile[73] = new Tile();
            tile[73].image = ImageIO.read(getClass().getResourceAsStream("/Tile/73.png"));

            tile[74] = new Tile();
            tile[74].image = ImageIO.read(getClass().getResourceAsStream("/Tile/74.png"));

            tile[75] = new Tile();
            tile[75].image = ImageIO.read(getClass().getResourceAsStream("/Tile/75.png"));

            tile[76] = new Tile();
            tile[76].image = ImageIO.read(getClass().getResourceAsStream("/Tile/76.png"));

            tile[77] = new Tile();
            tile[77].image = ImageIO.read(getClass().getResourceAsStream("/Tile/77.png"));

            tile[78] = new Tile();
            tile[78].image = ImageIO.read(getClass().getResourceAsStream("/Tile/78.png"));

            tile[79] = new Tile();
            tile[79].image = ImageIO.read(getClass().getResourceAsStream("/Tile/79.png"));

            tile[80] = new Tile();
            tile[80].image = ImageIO.read(getClass().getResourceAsStream("/Tile/80.png"));
            tile[80].collision = true;

            tile[81] = new Tile();
            tile[81].image = ImageIO.read(getClass().getResourceAsStream("/Tile/81.png"));
            tile[81].collision = true;

            tile[82] = new Tile();
            tile[82].image = ImageIO.read(getClass().getResourceAsStream("/Tile/82.png"));
            tile[82].collision = true;

            tile[83] = new Tile();
            tile[83].image = ImageIO.read(getClass().getResourceAsStream("/Tile/83.png"));
            tile[83].collision = true;

            tile[84] = new Tile();
            tile[84].image = ImageIO.read(getClass().getResourceAsStream("/Tile/84.png"));
            tile[84].collision = true;

            tile[85] = new Tile();
            tile[85].image = ImageIO.read(getClass().getResourceAsStream("/Tile/85.png"));
            tile[85].collision = true;

            tile[86] = new Tile();
            tile[86].image = ImageIO.read(getClass().getResourceAsStream("/Tile/86.png"));

            tile[87] = new Tile();
            tile[87].image = ImageIO.read(getClass().getResourceAsStream("/Tile/87.png"));

            tile[88] = new Tile();
            tile[88].image = ImageIO.read(getClass().getResourceAsStream("/Tile/88.png"));

            tile[89] = new Tile();
            tile[89].image = ImageIO.read(getClass().getResourceAsStream("/Tile/89.png"));

            tile[90] = new Tile();
            tile[90].image = ImageIO.read(getClass().getResourceAsStream("/Tile/90.png"));

            tile[91] = new Tile();
            tile[91].image = ImageIO.read(getClass().getResourceAsStream("/Tile/91.png"));

            tile[92] = new Tile();
            tile[92].image = ImageIO.read(getClass().getResourceAsStream("/Tile/92.png"));
            tile[92].collision = true;

            tile[93] = new Tile();
            tile[93].image = ImageIO.read(getClass().getResourceAsStream("/Tile/93.png"));
            tile[93].collision = true;

            tile[94] = new Tile();
            tile[94].image = ImageIO.read(getClass().getResourceAsStream("/Tile/94.png"));
            tile[94].collision = true;

            tile[95] = new Tile();
            tile[95].image = ImageIO.read(getClass().getResourceAsStream("/Tile/95.png"));
            tile[95].collision = true;

            tile[96] = new Tile();
            tile[96].image = ImageIO.read(getClass().getResourceAsStream("/Tile/96.png"));
            tile[96].collision = true;

            tile[97] = new Tile();
            tile[97].image = ImageIO.read(getClass().getResourceAsStream("/Tile/97.png"));

            tile[98] = new Tile();
            tile[98].image = ImageIO.read(getClass().getResourceAsStream("/Tile/98.png"));

            tile[99] = new Tile();
            tile[99].image = ImageIO.read(getClass().getResourceAsStream("/Tile/99.png"));
           
            
        } catch(IOException e) {
            e.printStackTrace();
        }               
    }
    
    /**
     * Load all map layers
     */
    public void loadAllLayers() {
        for (int i = 0; i < maxLayers; i++) {
            loadLayer(i, layerFiles[i]);
        }
    }
    
    /**
     * Load a specific layer from a file
     * @param layerIndex The layer index to load (0, 1, 2, etc.)
     * @param filePath The file path of the layer map
     */
    public void loadLayer(int layerIndex, String filePath) {
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            
            // If the file doesn't exist, fill the layer with empty tiles
            if (is == null) {
                fillLayerWithEmptyTiles(layerIndex);
                System.out.println("Warning: Map file not found: " + filePath);
                return;
            }
            
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            int col = 0;
            int row = 0;
            
            while (row < gp.maxScreenRow) {
                String line = br.readLine();
                
                // If we reach the end of the file before filling the map,
                // fill the rest with empty tiles
                if (line == null) {
                    while (row < gp.maxScreenRow) {
                        while (col < gp.maxScreenCol) {
                            mapTileNum[layerIndex][col][row] = 0;
                            col++;
                        }
                        col = 0;
                        row++;
                    }
                    break;
                }
                
                // Skip comment lines
                if (line.trim().startsWith("#")) {
                    continue;
                }
                
                String[] numbers = line.split(" ");
                col = 0;
                
                while (col < gp.maxScreenCol) {
                    if (col < numbers.length) {
                        int num = Integer.parseInt(numbers[col]);
                        mapTileNum[layerIndex][col][row] = num;
                    } else {
                        mapTileNum[layerIndex][col][row] = 0; // Default to empty tile
                    }
                    col++;
                }
                row++;
            }
            
            br.close();
            
        } catch (Exception e) {
            System.out.println("Error loading layer " + layerIndex + " from " + filePath);
            e.printStackTrace();
            fillLayerWithEmptyTiles(layerIndex);
        }
    }
    
    /**
     * Fill a layer with empty tiles (0)
     * @param layerIndex The layer to fill
     */
    private void fillLayerWithEmptyTiles(int layerIndex) {
        for (int row = 0; row < gp.maxScreenRow; row++) {
            for (int col = 0; col < gp.maxScreenCol; col++) {
                mapTileNum[layerIndex][col][row] = 0;
            }
        }
    }
    
    /**
     * Change a layer's map file and reload it
     * @param layerIndex The layer to change
     * @param newFilePath The new file path
     */
    public void changeLayerMap(int layerIndex, String newFilePath) {
        if (layerIndex >= 0 && layerIndex < maxLayers) {
            layerFiles[layerIndex] = newFilePath;
            loadLayer(layerIndex, newFilePath);
        }
    }
    
    public void draw(Graphics2D g2) {
        // Draw each layer
        for (int layer = 0; layer < maxLayers; layer++) {
            drawLayer(g2, layer);
        }
    }
    
    private void drawLayer(Graphics2D g2, int layer) {
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        
        while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
            int tileNum = mapTileNum[layer][col][row];
            
            // Only draw if it's not tile 0 (assuming 0 is transparent/empty)
            // For the base layer (layer 0), we'll draw everything including 0 tiles
            if (tileNum > 0 || layer == 0) {
                if (tileNum < tile.length) {
                    g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
                }
            }
            
            col++;
            x += gp.tileSize;
            
            if (col == gp.maxScreenCol) {
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }
    }
    
    // Add this method to visualize collision boxes for debugging
    private void drawCollisionBoxes(Graphics2D g2) {
        g2.setColor(Color.RED);
        
        for (int row = 0; row < gp.maxScreenRow; row++) {
            for (int col = 0; col < gp.maxScreenCol; col++) {
                // Check all layers for collision tiles
                for (int layer = 0; layer < maxLayers; layer++) {
                    int tileNum = mapTileNum[layer][col][row];
                    
                    if (tileNum >= 0 && tileNum < tile.length && tile[tileNum].collision) {
                        // Draw a red outline for collidable tiles
                        g2.drawRect(col * gp.tileSize, row * gp.tileSize, gp.tileSize, gp.tileSize);
                    }
                }
            }
        }
    }
        
    public boolean checkTileCollision(Rectangle playerCollBox) {
        int playerLeftCol = playerCollBox.x / gp.tileSize;
        int playerRightCol = (playerCollBox.x + playerCollBox.width - 1) / gp.tileSize;
        int playerTopRow = playerCollBox.y / gp.tileSize;
        int playerBottomRow = (playerCollBox.y + playerCollBox.height - 1) / gp.tileSize;
        
        // Ensure we're checking within map bounds
        playerLeftCol = Math.max(0, Math.min(gp.maxScreenCol - 1, playerLeftCol));
        playerRightCol = Math.max(0, Math.min(gp.maxScreenCol - 1, playerRightCol));
        playerTopRow = Math.max(0, Math.min(gp.maxScreenRow - 1, playerTopRow));
        playerBottomRow = Math.max(0, Math.min(gp.maxScreenRow - 1, playerBottomRow));
        
        // Store the collision tile for debugging purposes if needed
        Rectangle collidedTile = null;
        
        // Check the tiles that the player's collision box overlaps
        for (int col = playerLeftCol; col <= playerRightCol; col++) {
            for (int row = playerTopRow; row <= playerBottomRow; row++) {
                // Check collision on both layers
                for (int layer = 0; layer < maxLayers; layer++) {
                    // Skip collision detection if we're out of bounds
                    if (col < 0 || col >= gp.maxScreenCol || row < 0 || row >= gp.maxScreenRow) {
                        continue;
                    }
                    
                    int tileNum = mapTileNum[layer][col][row];
                    
                    // Check if this tile has collision property and is a valid tile index
                    if (tileNum >= 0 && tileNum < tile.length && tile[tileNum].collision) {
                        // Create a rectangle for this tile
                        Rectangle tileCollBox = new Rectangle(
                            col * gp.tileSize,
                            row * gp.tileSize,
                            gp.tileSize,
                            gp.tileSize
                        );
                        
                        // Check if the player's collision box intersects with this tile
                        if (playerCollBox.intersects(tileCollBox)) {
                            collidedTile = tileCollBox;
                            return true; // Collision detected
                        }
                    }
                }
            }
        }
        
        return false; // No collision detected
    }
}