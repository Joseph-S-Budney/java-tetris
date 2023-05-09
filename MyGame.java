import java.awt.Color;
//import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MyGame extends Game  {
    public static final String TITLE = "Tetris";
    public static final int SCREEN_WIDTH = 275;
    public static final int SCREEN_HEIGHT = 550;

    // declare variables here

    private Block[][] grid;
    private Piece activePiece;
    private ArrayList<Piece> pieces;
    private int speed;

    public MyGame() {
        // initialize variables here
        grid = new Block[25][10];
        activePiece = new Piece(grid);
        pieces = new ArrayList<Piece>();
        pieces.add(0, activePiece);
        speed = 1000;
    }
    
    public void update(){
        // updating logic
        int rowToCheck = 0;
        int streak = 0;
        boolean sentinal = false;
        if(activePiece.update(speed) == false){
            speed -= speed/20;
            //test for row clear here 
            activePiece = new Piece(grid);
            pieces.add(activePiece);
            for(int blockNum = 0; blockNum<4; blockNum++){
                rowToCheck = pieces.get(0).getBlocks().get(blockNum).getRow();
                for(Piece piece: pieces){
                    for(Block block: piece.getBlocks()){
                        if(block.getRow() == rowToCheck)streak++;
                        else{
                            sentinal = true;
                            break;
                        }
                    }
                    if(sentinal) break;
                }
                if(sentinal) break;
            }
            if(streak==10){
                for(Piece piece: pieces){
                    if(piece.getBlocks())
                }
            }
        }
        activePiece.update(speed);
    }
    
    public void draw(Graphics pen, int width, int height) {
        pen.setColor(Color.GRAY);
        for(int row = 1; row<grid.length; row++){
            for(int col = 0; col<grid[0].length; col++){
                pen.drawRect((height/26)*col, (height/26)*row, (height/26), (height/26));
            }
        }
        for(Piece piece: pieces){
            piece.draw(pen, width, height);
        }
    }
        
    @Override
    public void keyTyped(KeyEvent ke) {}

    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode() == 37){
            activePiece.left();
        }
        if(ke.getKeyCode() == 39){
            activePiece.right();
        }
        if(ke.getKeyCode() == 38){
            activePiece.rotate();
        }
        if(ke.getKeyCode() == 40){
            activePiece.down();
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {}

    @Override
    public void mouseClicked(MouseEvent ke) {}

    @Override
    public void mousePressed(MouseEvent me) {}
    
    @Override
    public void mouseReleased(MouseEvent me) {}

    @Override
    public void mouseEntered(MouseEvent me) {}

    @Override
    public void mouseExited(MouseEvent me) {}
        
        
    //Launches the Game
    public static void main(String[] args) { new MyGame().start(TITLE, SCREEN_WIDTH,SCREEN_HEIGHT); }
}