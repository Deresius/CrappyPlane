package edu.westga.cs3212.app.model;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 * Defines the Sprite class, to be used for all moving objects on the screen.
 * 
 * @author Team 4
 *
 */
public abstract class Sprite {

	/* locations */
	protected double x;
	protected double y;

	/* boundaries */
	protected int width;
	protected int height;

	protected Image image;

	/**
	 * Creates a new Sprite, at location x, y, and sets visibility to true.
	 * 
	 * @param x
	 *            The horizontal location of the Sprite
	 * @param y
	 *            The vertical location of the Sprite
	 */
	public Sprite(int x, int y) {

		if (x < 0) {
			throw new IllegalArgumentException("Sprite X cannot be negative.");
		}
		if (y < 0) {
			throw new IllegalArgumentException("Sprite Y cannot be negative.");
		}

		this.x = x;
		this.y = y;
	}

	/**
	 * @return The horizontal location of the Sprite
	 */
	public double getX() {
		return this.x;
	}

	/**
	 * @return The vertical location of the Sprite
	 */
	public double getY() {
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
		return new Rectangle((int) this.x + (int) (.1 * this.width), (int) this.y + (int) (.1 * this.height),
				(int) (.8 * this.width), (int) (.8 * this.height));
	}

	/**
	 * Sets the image width and height.
	 */
	protected void getImageDimensions() {

		this.width = this.image.getWidth(null);
		this.height = this.image.getHeight(null);
	}

	/**
	 * Loads the selected image.
	 * 
	 * @param imageName
	 *            The image to load.
	 */
	protected void loadImage(String imageName) {

		ImageIcon ii = new ImageIcon(imageName);
		this.image = ii.getImage();
	}

	/**
	 * Abstract method to move the object on the screen.
	 */
	public abstract void move();
}
