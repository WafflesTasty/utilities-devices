package waffles.utils.sys.video.graphics.cmds;

import waffles.utils.geom.bounds.Bounds2D;
import waffles.utils.geom.collidable.axial.cuboid.Rectangle;
import waffles.utils.tools.patterns.semantics.Resettable;

/**
 * The {@code GFXScissorCheck} interface defines scissor test options for {@code GFXGraphics}.
 * The scissor check limits the bounds of the screen that is being rendered to.
 * 
 * @author Waffles
 * @since Sep 12, 2016
 * @version 1.0
 * 
 * 
 * @see Resettable
 */
public interface GFXScissorCheck extends Resettable
{
	/**
	 * Changes the bounds of the {@code GFXScissorCheck}.
	 * 
	 * @param x  a top-left x-coördinate
	 * @param y  a top left y-coördinate
	 * @param w  a scissor bounds width
	 * @param h  a scissor bounds height
	 */
	public abstract void setBounds(int x, int y, int w, int h);
	
	/**
	 * Changes the bounds of the {@code GFXScissorCheck}.
	 * Passing a null value disables the test.
	 * 
	 * @param r  a bounding rectangle
	 * 
	 * 
	 * @see Rectangle
	 */
	public default void setBounds(Rectangle r)
	{
		if(r == null)
			setBounds(0, 0, 0, 0);
		else
			setBounds(r.Bounds());
	}
	
	/**
	 * Changes the bounds of the {@code GFXScissorCheck}.
	 * Passing a null value disables the test.
	 * 
	 * @param b  a boundary
	 * 
	 * 
	 * @see Bounds2D
	 */
	public default void setBounds(Bounds2D b)
	{
		if(b == null)
			setBounds(0, 0, 0, 0);
		else
		{
			int x = (int) (b.XMin()   - 0.5f);
			int y = (int) (b.YMin()   - 0.5f);
			int w = (int) (b.Width()  + 0.5f);
			int h = (int) (b.Height() + 0.5f);
			
			setBounds(x, y, w, h);
		}
	}
}