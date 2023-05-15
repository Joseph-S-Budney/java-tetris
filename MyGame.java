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
        grid = new Block[21][10];
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
            for(int blockNum = 0; blockNum<pieces.get(0).getBlocks().size(); blockNum++){//remove row
                    int streak = 0;
                    boolean removeRow = false;
                    Block[] toRemove = new Block[10];
                    rowToCheck = pieces.get(0).getBlocks().get(blockNum).getRow();
                for(int pieceIndex = 0; pieceIndex<pieces.size(); pieceIndex++){
                    for(int blockIndex = 0; blockIndex<pieces.get(pieceIndex).getBlocks().size(); blockIndex++){
                        if(pieces.get(pieceIndex).getBlocks().get(blockIndex).getRow()==rowToCheck && removeRow)pieces.get(pieceIndex).getBlocks().remove(blockIndex);
                        else if(pieces.get(pieceIndex).getBlocks().get(blockIndex).getRow()==rowToCheck){
                            toRemove[streak] = pieces.get(pieceIndex).getBlocks().get(blockIndex);
                            streak++;
                        }
                        if(streak==10){
                            removeRow = true;
                            streak = 0;
                            pieceIndex = -1;
                            break;
                        }
                    }
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