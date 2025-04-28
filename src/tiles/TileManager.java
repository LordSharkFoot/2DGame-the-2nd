package tiles;

import java.awt.Graphics2D;
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
    int mapTileNum[][];
    
    public TileManager(GamePanel gp) {
        
        this.gp = gp;
        
        tile = new Tile[192];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        
        getTileImage();
        loadMap("/maps/map.txt");
    }
    
   public void getTileImage() {
       
       try {
           
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tile/0.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tile/1.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tile/2.png"));

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tile/3.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tile/4.png"));

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tile/5.png"));

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tile/6.png"));

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tile/7.png"));

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tile/8.png"));

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tile/9.png"));

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tile/10.png"));

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tile/11.png"));

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tile/12.png"));

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tile/13.png"));

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/tile/14.png"));

            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/tile/15.png"));

            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/tile/16.png"));

            tile[17] = new Tile();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/tile/17.png"));

            tile[18] = new Tile();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/tile/18.png"));

            tile[19] = new Tile();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/tile/19.png"));

            tile[20] = new Tile();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/tile/20.png"));

            tile[21] = new Tile();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/tile/21.png"));

            tile[22] = new Tile();
            tile[22].image = ImageIO.read(getClass().getResourceAsStream("/tile/22.png"));

            tile[23] = new Tile();
            tile[23].image = ImageIO.read(getClass().getResourceAsStream("/tile/23.png"));

            tile[24] = new Tile();
            tile[24].image = ImageIO.read(getClass().getResourceAsStream("/tile/24.png"));

            tile[25] = new Tile();
            tile[25].image = ImageIO.read(getClass().getResourceAsStream("/tile/25.png"));

            tile[26] = new Tile();
            tile[26].image = ImageIO.read(getClass().getResourceAsStream("/tile/26.png"));

            tile[27] = new Tile();
            tile[27].image = ImageIO.read(getClass().getResourceAsStream("/tile/27.png"));

            tile[28] = new Tile();
            tile[28].image = ImageIO.read(getClass().getResourceAsStream("/tile/28.png"));

            tile[29] = new Tile();
            tile[29].image = ImageIO.read(getClass().getResourceAsStream("/tile/29.png"));

            tile[30] = new Tile();
            tile[30].image = ImageIO.read(getClass().getResourceAsStream("/tile/30.png"));

            tile[31] = new Tile();
            tile[31].image = ImageIO.read(getClass().getResourceAsStream("/tile/31.png"));

            tile[32] = new Tile();
            tile[32].image = ImageIO.read(getClass().getResourceAsStream("/tile/32.png"));

            tile[33] = new Tile();
            tile[33].image = ImageIO.read(getClass().getResourceAsStream("/tile/33.png"));

            tile[34] = new Tile();
            tile[34].image = ImageIO.read(getClass().getResourceAsStream("/tile/34.png"));

            tile[35] = new Tile();
            tile[35].image = ImageIO.read(getClass().getResourceAsStream("/tile/35.png"));

            tile[36] = new Tile();
            tile[36].image = ImageIO.read(getClass().getResourceAsStream("/tile/36.png"));

            tile[37] = new Tile();
            tile[37].image = ImageIO.read(getClass().getResourceAsStream("/tile/37.png"));

            tile[38] = new Tile();
            tile[38].image = ImageIO.read(getClass().getResourceAsStream("/tile/38.png"));

            tile[39] = new Tile();
            tile[39].image = ImageIO.read(getClass().getResourceAsStream("/tile/39.png"));

            tile[40] = new Tile();
            tile[40].image = ImageIO.read(getClass().getResourceAsStream("/tile/40.png"));

            tile[41] = new Tile();
            tile[41].image = ImageIO.read(getClass().getResourceAsStream("/tile/41.png"));

            tile[42] = new Tile();
            tile[42].image = ImageIO.read(getClass().getResourceAsStream("/tile/42.png"));

            tile[43] = new Tile();
            tile[43].image = ImageIO.read(getClass().getResourceAsStream("/tile/43.png"));

            tile[44] = new Tile();
            tile[44].image = ImageIO.read(getClass().getResourceAsStream("/tile/44.png"));

            tile[45] = new Tile();
            tile[45].image = ImageIO.read(getClass().getResourceAsStream("/tile/45.png"));

            tile[46] = new Tile();
            tile[46].image = ImageIO.read(getClass().getResourceAsStream("/tile/46.png"));

            tile[47] = new Tile();
            tile[47].image = ImageIO.read(getClass().getResourceAsStream("/tile/47.png"));

            tile[48] = new Tile();
            tile[48].image = ImageIO.read(getClass().getResourceAsStream("/tile/48.png"));

            tile[49] = new Tile();
            tile[49].image = ImageIO.read(getClass().getResourceAsStream("/tile/49.png"));

            tile[50] = new Tile();
            tile[50].image = ImageIO.read(getClass().getResourceAsStream("/tile/50.png"));

            tile[51] = new Tile();
            tile[51].image = ImageIO.read(getClass().getResourceAsStream("/tile/51.png"));

            tile[52] = new Tile();
            tile[52].image = ImageIO.read(getClass().getResourceAsStream("/tile/52.png"));

            tile[53] = new Tile();
            tile[53].image = ImageIO.read(getClass().getResourceAsStream("/tile/53.png"));

            tile[54] = new Tile();
            tile[54].image = ImageIO.read(getClass().getResourceAsStream("/tile/54.png"));

            tile[55] = new Tile();
            tile[55].image = ImageIO.read(getClass().getResourceAsStream("/tile/55.png"));

            tile[56] = new Tile();
            tile[56].image = ImageIO.read(getClass().getResourceAsStream("/tile/56.png"));

            tile[57] = new Tile();
            tile[57].image = ImageIO.read(getClass().getResourceAsStream("/tile/57.png"));

            tile[58] = new Tile();
            tile[58].image = ImageIO.read(getClass().getResourceAsStream("/tile/58.png"));

            tile[59] = new Tile();
            tile[59].image = ImageIO.read(getClass().getResourceAsStream("/tile/59.png"));

            tile[60] = new Tile();
            tile[60].image = ImageIO.read(getClass().getResourceAsStream("/tile/60.png"));

            tile[61] = new Tile();
            tile[61].image = ImageIO.read(getClass().getResourceAsStream("/tile/61.png"));

            tile[62] = new Tile();
            tile[62].image = ImageIO.read(getClass().getResourceAsStream("/tile/62.png"));

            tile[63] = new Tile();
            tile[63].image = ImageIO.read(getClass().getResourceAsStream("/tile/63.png"));

            tile[64] = new Tile();
            tile[64].image = ImageIO.read(getClass().getResourceAsStream("/tile/64.png"));

            tile[65] = new Tile();
            tile[65].image = ImageIO.read(getClass().getResourceAsStream("/tile/65.png"));

            tile[66] = new Tile();
            tile[66].image = ImageIO.read(getClass().getResourceAsStream("/tile/66.png"));

            tile[67] = new Tile();
            tile[67].image = ImageIO.read(getClass().getResourceAsStream("/tile/67.png"));

            tile[68] = new Tile();
            tile[68].image = ImageIO.read(getClass().getResourceAsStream("/tile/68.png"));

            tile[69] = new Tile();
            tile[69].image = ImageIO.read(getClass().getResourceAsStream("/tile/69.png"));

            tile[70] = new Tile();
            tile[70].image = ImageIO.read(getClass().getResourceAsStream("/tile/70.png"));

            tile[71] = new Tile();
            tile[71].image = ImageIO.read(getClass().getResourceAsStream("/tile/71.png"));

            tile[72] = new Tile();
            tile[72].image = ImageIO.read(getClass().getResourceAsStream("/tile/72.png"));

            tile[73] = new Tile();
            tile[73].image = ImageIO.read(getClass().getResourceAsStream("/tile/73.png"));

            tile[74] = new Tile();
            tile[74].image = ImageIO.read(getClass().getResourceAsStream("/tile/74.png"));

            tile[75] = new Tile();
            tile[75].image = ImageIO.read(getClass().getResourceAsStream("/tile/75.png"));

            tile[76] = new Tile();
            tile[76].image = ImageIO.read(getClass().getResourceAsStream("/tile/76.png"));

            tile[77] = new Tile();
            tile[77].image = ImageIO.read(getClass().getResourceAsStream("/tile/77.png"));

            tile[78] = new Tile();
            tile[78].image = ImageIO.read(getClass().getResourceAsStream("/tile/78.png"));

            tile[79] = new Tile();
            tile[79].image = ImageIO.read(getClass().getResourceAsStream("/tile/79.png"));

            tile[80] = new Tile();
            tile[80].image = ImageIO.read(getClass().getResourceAsStream("/tile/80.png"));

            tile[81] = new Tile();
            tile[81].image = ImageIO.read(getClass().getResourceAsStream("/tile/81.png"));

            tile[82] = new Tile();
            tile[82].image = ImageIO.read(getClass().getResourceAsStream("/tile/82.png"));

            tile[83] = new Tile();
            tile[83].image = ImageIO.read(getClass().getResourceAsStream("/tile/83.png"));

            tile[84] = new Tile();
            tile[84].image = ImageIO.read(getClass().getResourceAsStream("/tile/84.png"));

            tile[85] = new Tile();
            tile[85].image = ImageIO.read(getClass().getResourceAsStream("/tile/85.png"));

            tile[86] = new Tile();
            tile[86].image = ImageIO.read(getClass().getResourceAsStream("/tile/86.png"));

            tile[87] = new Tile();
            tile[87].image = ImageIO.read(getClass().getResourceAsStream("/tile/87.png"));

            tile[88] = new Tile();
            tile[88].image = ImageIO.read(getClass().getResourceAsStream("/tile/88.png"));

            tile[89] = new Tile();
            tile[89].image = ImageIO.read(getClass().getResourceAsStream("/tile/89.png"));

            tile[90] = new Tile();
            tile[90].image = ImageIO.read(getClass().getResourceAsStream("/tile/90.png"));

            tile[91] = new Tile();
            tile[91].image = ImageIO.read(getClass().getResourceAsStream("/tile/91.png"));

            tile[92] = new Tile();
            tile[92].image = ImageIO.read(getClass().getResourceAsStream("/tile/92.png"));

            tile[93] = new Tile();
            tile[93].image = ImageIO.read(getClass().getResourceAsStream("/tile/93.png"));

            tile[94] = new Tile();
            tile[94].image = ImageIO.read(getClass().getResourceAsStream("/tile/94.png"));

            tile[95] = new Tile();
            tile[95].image = ImageIO.read(getClass().getResourceAsStream("/tile/95.png"));

            tile[96] = new Tile();
            tile[96].image = ImageIO.read(getClass().getResourceAsStream("/tile/96.png"));

            tile[97] = new Tile();
            tile[97].image = ImageIO.read(getClass().getResourceAsStream("/tile/97.png"));

            tile[98] = new Tile();
            tile[98].image = ImageIO.read(getClass().getResourceAsStream("/tile/98.png"));

            tile[99] = new Tile();
            tile[99].image = ImageIO.read(getClass().getResourceAsStream("/tile/99.png"));
           
           
           
           
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
            
           while(col < gp.maxScreenCol && row < gp.maxScreenRow) {
               String line = br.readLine();
               
               while(col < gp.maxScreenCol) {
                   
                   String numbers[] = line.split(" ");
                   int num = Integer.parseInt(numbers[col]);
                   
                   mapTileNum[col][row] = num;
                   col++;
                   
           }
               if(col == gp.maxScreenCol) {
                   col = 0;
                   row++;
               }
         }  
           br.close();
           
        } catch (Exception e) {
            
        }
        
    }
   
   
   
   public void draw(Graphics2D g2) {
        
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        
        while(col < gp.maxScreenCol && row < gp.maxScreenRow) {
            
            int tileNum = mapTileNum[col][row];
            
            g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;
            
            if(col == gp.maxScreenCol) {
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }
    }
    
}
