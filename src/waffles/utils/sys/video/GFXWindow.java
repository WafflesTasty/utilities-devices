package waffles.utils.sys.video;

import waffles.utils.algebra.elements.linear.vector.fixed.Vector2;
import waffles.utils.geom.bounds.Bounded2D;
import waffles.utils.geom.bounds.Bounds2D;
import waffles.utils.sys.IODevice;
import waffles.utils.sys.utilities.video.VideoMode;
import waffles.utils.sys.video.graphics.GFXGraphics;
import waffles.utils.tools.patterns.semantics.Disposable;

/**
 * A {@code GFXWindow} defines a rendering window in an {@link IODevice}.
 * 
 * @author Waffles
 * @since Sep 12, 2016
 * @version 1.0
 * 
 * 
 * @see Disposable
 * @see Bounded2D
 */
public interface GFXWindow extends Disposable, Bounds2D
{
	/**
	 * Returns the video mode of the {@code GFXWindow}.
	 * 
	 * @return  a video mode
	 * 
	 * 
	 * @see VideoMode
	 */
	public abstract VideoMode VideoMode();
	
	/**
	 * Returns the graphics of the {@code GFXWindow}.
	 * 
	 * @return  a graphics object
	 * 
	 * 
	 * @see GFXGraphics
	 */
	public abstract GFXGraphics Graphics();
	
	
	@Override
	public default float Radius()
	{
		return Center().norm();
	}
	
	@Override
	public default Vector2 Center()
	{
		return Size().times(0.5f);
	}
	
	@Override
	public default Vector2 Size()
	{
		int h = VideoMode().Height();
		int w = VideoMode().Width();
		return new Vector2(w, h);
	}
}