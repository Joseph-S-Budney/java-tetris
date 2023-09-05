import java.awt.Color;
//import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MyGame extends Game  {
    public static final String TITLE = "Tetris";
    public static final int SCREEN_WIDTH = 1000;
    public static final int SCREEN_HEIGHT = 1000;

    // declare variables here

    private Block[][] grid;
    private Piece activePiece;
    private ArrayList<Piece> pieces;
    private int speed;
    public boolean moveAllDown;

    public MyGame() {
        // initialize variables here
        grid = new Block[31][10];
        activePiece = new Piece(grid);
        pieces = new ArrayList<Piece>();
        pieces.add(0, activePiece);
        speed = 1000;
    }
    
    public void update(){
        // updating logic
        int rowToCheck = 0;
        if(activePiece.update(speed) == false){
            speed -= speed/20;
            //test for row clear here 
            activePiece = new Piece(grid);
            pieces.add(activePiece);
            if(moveAllDown){
                moveAllDown = false;
                for(int piece = 0;piece<pieces.size()-1;piece++){
                    pieces.get(piece).down();
                }
            }
//            for(int blockNum = 0; blockNum<4; blockNum++){//remove row
//                   int streak = 0;
//                    boolean removeRow = false;
//                    Block[] toRemove = new Block[10];
//                    rowToCheck = 20;
//                for(int pieceIndex = 0; pieceIndex<pieces.size(); pieceIndex++){
//                    for(int blockIndex = 0; blockIndex<pieces.get(pieceIndex).getBlocks().size(); blockIndex++){
//                        if(pieces.get(pieceIndex).getBlocks().get(blockIndex).getRow()==rowToCheck && removeRow)pieces.get(pieceIndex).getBlocks().remove(blockIndex);
//                        else if(pieces.get(pieceIndex).getBlocks().get(blockIndex).getRow()==rowToCheck){
//                           toRemove[streak] = pieces.get(pieceIndex).getBlocks().get(blockIndex);
//                            streak++;
//                        }
//                        if(streak==10){
//                            removeRow = true;
//                            streak = 0;
//                            pieceIndex = -1;
//                            break;
//                       }
//                   }
//              }
//          }
        }
        activePiece.update(speed);
    }
    
    public void draw(Graphics pen, int width, int height) {
        pen.setColor(Color.GRAY);
        for(int row = 0; row<20; row++){
            for(int col = 0; col<grid[0].length; col++){
                pen.drawRect((height/20)*col, (height/20)*row, (height/20), (height/20));
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
        if(ke.getKeyCode() == 32){
            moveAllDown = true;
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