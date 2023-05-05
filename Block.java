import java.awt.Graphics;
import java.awt.Color;

public class Block{

    public int row;
    public int col;
    long start;
    long end;

    public Block(){
        row = 1;
        col = 4;
    }
    public Block(int rowOffset, int colOffset){
        row = 1+rowOffset;
        col = 4+colOffset;
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
        pen.fillRect((height/23)*col, (height/23)*row, (height/23), (height/23));
    }
}