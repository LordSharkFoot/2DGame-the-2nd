package utilz;

public class Constants {
    
    public static class PlayerConstants{
        //ANIMATIONS PER ROW BASED ON THE SPRITESHEET
        public static final int ATTACK = 0;
        public static final int DEATH = 1;
        public static final int IDLE = 2;
        public static final int RUNNING = 3;
        
        //AMOUNT OF ANIMATIONS/COLUMNS ON THE SPRITESHEET
        public static int GetSpriteAmount(int player_action) {
            switch(player_action) {
                case RUNNING:
                    return 10;
                case IDLE:
                    return 10;
                case DEATH:
                    return 10;
                case ATTACK:
                    return 10;
                default:
                    return 1;
            }
        }
        
    }
}
