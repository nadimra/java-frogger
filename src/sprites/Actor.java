package sprites;

import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import model.World;

import java.util.ArrayList;

/**
 * This class controls the specific actor to be displayed on screen
 * @author Nad
 *
 */
public abstract class Actor extends ImageView{

	/**
	 * Move the position of the actor
	 * @param dx pixels horizontally moved
	 * @param dy pixels vertically moved
	 */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    public World getWorld() {
        return (World) getParent();
    }

    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    /**
     * Gets the objects that collide with the object
     * @param <A> objects of class Actor
     * @param cls 
     * @return someArray a list of actors that intersect with the object
     */
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    
    public void manageInput(InputEvent e) {
        
    }

    /**
     * Gets the first intersecting object
     * @param <A> objects of class Actor
     * @param cls 
     * @return the first intersecting actor
     */
    public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
                break;
            }
        }
        return someArray.get(0);
    }

    public abstract void act(long now);

}
