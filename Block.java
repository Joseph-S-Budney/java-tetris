import java.awt.Graphics;
import java.awt.Color;

public class Block{

    private int row;
    private int col;

    public Block(){
        row = 1;
        col = 5;
    }
    public Block(int rowOffset, int colOffset){
        row = 1+rowOffset;
        col = 5+colOffset;
    }
    public void setRow(int row){
        this.row = row;
    }
    public void setCol(int col){
        this.col = col;
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
    public void draw(Graphics pen, Block grid[][], Color color, int width, int height){
        pen.setColor(color);
        pen.fillRect((height/20)*col, (height/20)*row, (height/20), (height/20));
    }
}