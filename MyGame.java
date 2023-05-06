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

    Block[][] grid;
    Piece activePiece;
    ArrayList<Piece> pieces;
    int speed;

    public MyGame() {
        // initialize variables here
        grid = new Block[21][10];
        activePiece = new Piece(grid);
        pieces = new ArrayList<Piece>();
        pieces.add(activePiece);
        speed = 1000;
        
    }
    
    public void update(){
        // updating logic
        if(activePiece.update(speed) == false){
            speed -= speed/20;
            //test for row clear here 
            activePiece = new Piece(grid);
            pieces.add(activePiece);
        }
        activePiece.update(speed);
    }
    
    public void draw(Graphics pen, int width, int height) {
        pen.setColor(Color.GRAY);
        for(int row = 1; row<grid.length; row++){
            for(int col = 0; col<grid[0].length; col++){
                pen.drawRect((height/23)*col, (height/23)*row, (height/23), (height/23));
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