package waffles.utils.sys.video.graphics.cmds;

import waffles.utils.geom.bounds.Bounds2D;
import waffles.utils.geom.collidable.axial.cuboid.Rectangle;
import waffles.utils.tools.patterns.semantics.Resettable;

/**
 * The {@code GFXViewports} interface defines viewport options for {@code GFXGraphics}.
 * The viewport specifies how normalized device coördinates are
 * translated to window coördinates.
 * 
 * @author Waffles
 * @since Sep 12, 2016
 * @version 1.0
 * 
 * 
 * @see Resettable
 */
public interface GFXViewports extends Resettable
{
	/**
	 * Changes the window bounds of the {@code GFXViewports}.
	 * 
	 * @param x  a top-left x-coördinate
	 * @param y  a top-left y-coördinate
	 * @param w  a viewport width
	 * @param h  a viewport height
	 */
	public abstract void setBounds(int x, int y, int w, int h);
	
	/**
	 * Changes the window bounds of the {@code GFXViewports}.
	 * Passing a null value disables the viewport.
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
	 * Changes the window bounds of the {@code GFXViewports}.
	 * Passing a null value disables the viewport.
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