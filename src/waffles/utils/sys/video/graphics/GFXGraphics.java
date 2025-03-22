package waffles.utils.sys.video.graphics;

import waffles.utils.sys.video.graphics.cmds.GFXColorBlend;
import waffles.utils.sys.video.graphics.cmds.GFXColorEraser;
import waffles.utils.sys.video.graphics.cmds.GFXDepthCheck;
import waffles.utils.sys.video.graphics.cmds.GFXFrameBuffers;
import waffles.utils.sys.video.graphics.cmds.GFXRenderer;
import waffles.utils.sys.video.graphics.cmds.GFXScissorCheck;
import waffles.utils.sys.video.graphics.cmds.GFXTesselator;
import waffles.utils.sys.video.graphics.cmds.GFXViewports;
import waffles.utils.tools.patterns.semantics.Resettable;

/**
 * A {@code GFXGraphics} object provides various rendering commands for a {@code GFXWindow}.
 * Each set of commands is grouped together in a {@code GFXGraphics} component.
 * The following components are available for use.
 * <ul>
 * 	<li> {@link #Draw()}: defines GPU rendering commands. </li>
 *  <li> {@link #Blender()}: defines color blend commands. </li>
 *  <li> {@link #Eraser()}: defines color eraser commands. </li>
 *  <li> {@link #Frames()}: defines framebuffer commands. </li>
 *  <li> {@link #DepthCheck()}: defines depth check commands. </li>
 *  <li> {@link #ScissorCheck()}: defines scissor check commands. </li>
 *  <li> {@link #Tesselator()}: defines tesselator commands. </li>
 *  <li> {@link #Viewports()}: defines viewport commands. </li>
 * </ul>
 * 
 * @author Waffles
 * @since Sep 12, 2016
 * @version 1.0
 * 
 * 
 * @see Resettable
 */
public interface GFXGraphics extends Resettable
{
	/**
	 * Returns draw options of the {@code GFXGraphics}.
	 * 
	 * @return  a renderer
	 * 
	 * 
	 * @see GFXRenderer
	 */
	public abstract GFXRenderer Draw();
	
	/**
	 * Returns blender options of the {@code GFXGraphics}.
	 * 
	 * @return  blending options
	 * 
	 * 
	 * @see GFXColorBlend
	 */
	public abstract GFXColorBlend Blender();

	/**
	 * Returns erasing options of the {@code GFXGraphics}.
	 * 
	 * @return  erasing options
	 */
	public abstract GFXColorEraser Eraser();
	
	/**
	 * Returns framebuffer options of the {@code GFXGraphics}.
	 * 
	 * @return  framebuffer options
	 * 
	 * 
	 * @see GFXFrameBuffers
	 */
	public abstract GFXFrameBuffers Frames();
	
	/**
	 * Returns depth check options of the {@code GFXGraphics}.
	 * 
	 * @return  depth check options
	 * 
	 * 
	 * @see GFXDepthCheck
	 */
	public abstract GFXDepthCheck DepthCheck();
			
	/**
	 * Returns scissor check options of the {@code GFXGraphics}.
	 * 
	 * @return  scissor check options
	 * 
	 * 
	 * @see GFXScissorCheck
	 */
	public abstract GFXScissorCheck ScissorCheck();

	/**
	 * Returns tesselation options of the {@code GFXGraphics}.
	 * 
	 * @return  tesselation options
	 * 
	 * 
	 * @see GFXTesselator
	 */
	public abstract GFXTesselator Tesselator();
		
	/**
	 * Returns viewport options of the {@code GFXGraphics}.
	 * 
	 * @return  viewport options
	 * 
	 * 
	 * @see GFXViewports
	 */
	public abstract GFXViewports Viewports();


	@Override
	public default void reset()
	{
		Draw().reset();
		Blender().reset();
		DepthCheck().reset();
		ScissorCheck().reset();
		Tesselator().reset();
		Viewports().reset();
	}
}