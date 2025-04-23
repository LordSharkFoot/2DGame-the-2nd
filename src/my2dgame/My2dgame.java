package my2dgame;

import javax.swing.JFrame;


public class My2dgame {

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("AHHHHHHH");
        
        GamePanel  gamePanel = new GamePanel();
        window.add(gamePanel);
        
        window.pack();
                
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        gamePanel.startGameThread();

    }
    
}
