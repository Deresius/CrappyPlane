package edu.westga.cs3212.app;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 * Defines the Sprite class, to be used for all moving objects on the screen.
 *
 */
public abstract class Sprite {

<<<<<<< HEAD
	/* locations */
	protected int x;
	protected int y;

	/* boundaries */
	protected int width;
	protected int height;

	protected Image image;

	protected boolean visibility;

	/**
	 * Creates a new Sprite, at location x, y, and sets visibility to true.
	 * 
	 * @param x
	 *            The horizontal location of the Sprite
	 * @param y
	 *            The vertical location of the Sprite
	 */
	public Sprite(int x, int y) {

		this.x = x;
		this.y = y;
		visibility = true;
	}

	/**
	 * @return The horizontal location of the Sprite
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * @return The vertical location of the Sprite
	 */
	public int getY() {
		return this.y;
	}
	
	/**
	 * @return The width of the Sprite
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * @return The height of the Sprite
	 */
	public int getHeight() {
		return this.height;
	}
	
	/**
	 * @return The image of the Sprite
	 */
	public Image getImage() {
		return this.image;
	}
	
	/**
	 * @return The boundaries of the sprite (by location and size/dimensions)
	 */
	public Rectangle getBoundaries() {
		return new Rectangle(this.x, this.y, this.width, this.height);
	}

	/**
	 * @return true if the Sprite is visible
	 */
	public boolean isVisible() {
		return this.visibility;
	}

	/**
	 * Sets the visibility of the Sprite
	 * 
	 * @param visible
	 *            true if the Sprite is to be set visible
	 */
	public void setVisible(Boolean visible) {
		this.visibility = visible;
	}
	
	protected void getImageDimensions() {

		this.width = this.image.getWidth(null);
		this.height = this.image.getHeight(null);
	}

	protected void loadImage(String imageName) {

		ImageIcon ii = new ImageIcon(imageName);
		this.image = ii.getImage();
	}

=======
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
    
    public abstract void move();
>>>>>>> 04ae569740c7d3443fc4cd7c9226de7131fc2615
}
