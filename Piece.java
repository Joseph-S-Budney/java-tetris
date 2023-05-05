import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Piece{
    ArrayList<Block> blocks;
    Color color;
    int randNum;
    int x,y;
    Block[][] grid;
    long end;
    long start;
    float red;
    float green;
    float blue;
    boolean stop;
    Random rand;
    
    public Piece(Block[][] grid){
        this.grid = grid;
        x = 5;
        y = 1;
        blocks = new ArrayList<Block>();
        rand = new Random();
        red = rand.nextFloat();
        green = rand.nextFloat();
        blue = rand.nextFloat();
        randNum = (int)((Math.random()*7)+1);
        if(randNum == 1) iPiece();
        else if(randNum == 2) jPiece();
        else if(randNum == 3) lPiece();
        else if(randNum == 4) oPiece();
        else if(randNum == 5) sPiece();
        else if(randNum == 6) tPiece();
        else if(randNum == 7) zPiece();

    }
    public boolean update(int speed){
        for(Block block: blocks){
            grid[block.getRow()][block.getCol()] = block;
            end = System.currentTimeMillis();
        }
        if(end-start>speed){
            for(Block block: blocks){
                if(block.getRow() == 20 || !(blocks.contains(grid[block.getRow()+1][block.getCol()])) && grid[block.getRow()+1][block.getCol()] != null) return false;
            }
            for(Block block: blocks){
                grid[block.getRow()][block.getCol()] = null;
                block.setRow(block.getRow()+1);
            }
            y++;
            start = System.currentTimeMillis();
        }
        return true;
    }
    public void draw(Graphics pen, int width, int height){
        for(Block block: blocks){
            block.draw(pen, grid, new Color(red, green, blue), width, height);
        }
    }
    public void rotate(){
        System.out.println("("+x+","+y+")");
        for(Block block: blocks){
            block.setCol((1*block.getRow()));
            block.setRow((-1*block.getCol()));
        }
    }
    public void iPiece(){
        blocks.add(new Block(0,0));
        blocks.add(new Block(0,1));
        blocks.add(new Block(0,-1));
        blocks.add(new Block(0,-2));
    }
    public void jPiece(){  
        blocks.add(new Block());
        blocks.add(new Block(1, 0));
        blocks.add(new Block(1,1));
        blocks.add(new Block(1,2));
    }
    public void lPiece(){
        blocks.add(new Block());
        blocks.add(new Block(1, 0));
        blocks.add(new Block(1,-1));
        blocks.add(new Block(1,-2));
    }
    public void oPiece(){
        blocks.add(new Block());
        blocks.add(new Block(0,1));
        blocks.add(new Block(1,0));
        blocks.add(new Block(1,1));
    }
    public void sPiece(){
        blocks.add(new Block());
        blocks.add(new Block(0,1));
        blocks.add(new Block(1,0));
        blocks.add(new Block(1,-1));
    }
    public void tPiece(){
        blocks.add(new Block());
        blocks.add(new Block(-1,0));
        blocks.add(new Block(0,-1));
        blocks.add(new Block(0,1));
    }
    public void zPiece(){
        blocks.add(new Block());
        blocks.add(new Block(0,-1));
        blocks.add(new Block(1,0));
        blocks.add(new Block(1,1));
    }
    public void left(){
        for(Block block: blocks){
            if(block.getCol()==0 || !(blocks.contains(grid[block.getRow()][block.getCol()-1])) && grid[block.getRow()][block.getCol()-1] != null){
                stop = true;
                break;
            }
        }
        if(!stop){
            for(Block block: blocks){
                grid[block.getRow()][block.getCol()] = null;
                block.setCol(block.getCol()-1);
                grid[block.getRow()][block.getCol()] = block;
            }
            x--;
        }
        stop = false;
    }
    public void right(){
        for(Block block: blocks){
            if(block.getCol()==9 || !(blocks.contains(grid[block.getRow()][block.getCol()+1])) && grid[block.getRow()][block.getCol()+1] != null){
                stop = true;
                break;
            }
        }
        if(!stop){
            for(Block block: blocks){
                grid[block.getRow()][block.getCol()] = null;
                block.setCol(block.getCol()+1);
                grid[block.getRow()][block.getCol()] = block;
            }
            x++;
        }
        stop = false;
    }
}