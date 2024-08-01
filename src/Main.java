import greenfoot.Greenfoot;
import greenfoot.World;

public class Main extends World {

    private boolean start = true;

    public Main() {
        super(64, 64, 15, false);
        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                Cell cell = new Cell(false);
                addObject(cell, i, j);
            }
        }
        Greenfoot.setSpeed(40);
        Greenfoot.start();
    }
    public void act() {
        if(Greenfoot.isKeyDown("space")) {
            start = !start;
            Greenfoot.delay(1);
        }
        if(start){
            for (Cell cell :getObjects(Cell.class) ) {
                cell.check();
            }
            for (Cell cell :getObjects(Cell.class) ) {
                cell.update();
            }
        }
        Greenfoot.delay(1);
    }

    public void createPattern(int[] x, int[] y) {
        if (x.length == y.length) {
            for (int i = 0; i < x.length; i++) {
                getObjectsAt(x[i], y[i], Cell.class).get(0).setState(true);
            }
        }
    }

    public boolean isStart() {
        return start;
    }
}
