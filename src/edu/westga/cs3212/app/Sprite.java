package edu.westga.cs3212.app;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;



/**
 * Defines the sprite class, to be used for all moving objects on the screen.
 *
 */
public class Sprite {

	/*locations*/
    protected int x; 
    protected int y;
    
    /*boundaries*/
    protected int width;
    protected int height;
        
    protected Image image;

    protected boolean visibility;
    
    
    /**
     * Creates a new sprite, at location x, y, and sets visibility to true.
     * @param x the horizontal location of the sprite
     * @param y the vertical location of the sprite
     */
    public Sprite(int x, int y) {

        this.x = x;
        this.y = y;
        visibility = true;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return visibility;
    }

    public void setVisible(Boolean visible) {
        visibility = visible;
    }
    
    protected void getImageDimensions() {

        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    protected void loadImage(String imageName) {

        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
    }

    /** Gets the image of the sprite.
     * @return the image of the sprite
     */
    public Image getImage() {
        return image;
    }
    
    
    /** Gets the boundaries of the sprite (by location and size/dimensions)
     * @return
     */
    public Rectangle getBoundaries() {
        return new Rectangle(x, y, width, height);
    }

    public int getWidth() {
    	return this.width;
    }
    
    public int getHeight() {
    	return this.height;
    }
    
}
