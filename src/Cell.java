import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

public class Cell extends Actor {

    private GreenfootImage dead;
    private GreenfootImage alive;
    private GreenfootImage deadStill;
    private GreenfootImage aliveStill;
    private boolean state;
    private int c = 0;

    public Cell(boolean state) {
        this.state = state;
        dead = new GreenfootImage(15,15);
        dead.setColor(Color.WHITE);
        dead.fillRect(0,0,15,15);
        alive = new GreenfootImage(15,15);
        alive.setColor(Color.BLACK);
        alive.fillRect(0,0,15,15);
        deadStill = new GreenfootImage(15,15);
        deadStill.setColor(Color.WHITE);
        deadStill.fillRect(0,0,15,15);
        deadStill.setColor(Color.LIGHT_GRAY);
        deadStill.drawRect(0,0,15,15);
        aliveStill = new GreenfootImage(15,15);
        aliveStill.setColor(Color.BLACK);
        aliveStill.fillRect(0,0,15,15);
        aliveStill.setColor(Color.LIGHT_GRAY);
        aliveStill.drawRect(0,0,15,15);
    }

    public void check(){
        c = 0;
        if(!((Main) getWorld()).getObjectsAt(getX() + 1, getY() + 1, Cell.class).isEmpty() && (((Main) getWorld()).getObjectsAt(getX() + 1, getY() + 1, Cell.class).get(0).getState())){c++;}
        if(!((Main) getWorld()).getObjectsAt(getX() + 1, getY(), Cell.class).isEmpty() && (((Main) getWorld()).getObjectsAt(getX() + 1, getY(), Cell.class).get(0).getState())){c++;}
        if(!((Main) getWorld()).getObjectsAt(getX() + 1, getY() - 1, Cell.class).isEmpty() && (((Main) getWorld()).getObjectsAt(getX() + 1, getY() - 1, Cell.class).get(0).getState())){c++;}
        if(!((Main) getWorld()).getObjectsAt(getX(), getY() - 1, Cell.class).isEmpty() && (((Main) getWorld()).getObjectsAt(getX(), getY() - 1, Cell.class).get(0).getState())){c++;}
        if(!((Main) getWorld()).getObjectsAt(getX() - 1, getY() - 1, Cell.class).isEmpty() && (((Main) getWorld()).getObjectsAt(getX()- 1, getY() - 1, Cell.class).get(0).getState())){c++;}
        if(!((Main) getWorld()).getObjectsAt(getX() - 1, getY(), Cell.class).isEmpty() && (((Main) getWorld()).getObjectsAt(getX() - 1, getY(), Cell.class).get(0).getState())){c++;}
        if(!((Main) getWorld()).getObjectsAt(getX() - 1, getY() + 1, Cell.class).isEmpty() &&(((Main) getWorld()).getObjectsAt(getX() - 1, getY() + 1, Cell.class).get(0).getState())){c++;}
        if(!((Main) getWorld()).getObjectsAt(getX(), getY() + 1, Cell.class).isEmpty() && (((Main) getWorld()).getObjectsAt(getX(), getY() + 1, Cell.class).get(0).getState())){c++;}
    }

    public void update(){
        if(state && c < 2) {
            state = false;
        } else if(state && (c == 2 || c == 3)) {
            state = true;
        } else if (!state && c == 3) {
            state = true;
        } else if (state && c > 3){
            state = false;
        }
        if (state) {
            setImage(alive);
        } else {
            setImage(dead);
        }
    }

    public void act() {
        if (!((Main) getWorld()).isStart()) {
            if(Greenfoot.mouseClicked(this)){
                state = !state;
            }
            if (state) {
                setImage(aliveStill);
            } else {
                setImage(deadStill);
            }
        } else {
            if (state) {
                setImage(alive);
            } else {
                setImage(dead);
            }
        }
    }

    public void setState(boolean newState){
        state = newState;
    }

    public boolean getState(){
        return state;
    }
}
