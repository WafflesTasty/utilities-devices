package waffles.utils.sys.memory.config;

import waffles.utils.dacs.files.assets.Image;
import waffles.utils.sys.memory.buffer.GFXBuffer;
import waffles.utils.sys.memory.buffer.hints.BufferHints;
import waffles.utils.sys.video.assets.GFXAsset;
import waffles.utils.sys.video.frames.GFXCanvas;
import waffles.utils.sys.video.frames.GFXFrame;
import waffles.utils.sys.video.graphics.GFXCursor;

/**
 * The {@code AssetConfig} manages the creation of various
 * hardware-accelerated assets for a {@code GFXWindow}.
 *
 * @author Waffles
 * @since 14 Mar 2025
 * @version 1.1
 */
public interface AssetConfig
{		
	/**
	 * Creates a new {@code GFXCanvas}.
	 * 
	 * @param layer  a target layer
	 * @param hints  canvas hints
	 * @return  a frame canvas
	 * 
	 * 
	 * @see GFXCanvas
	 * @see GFXFrame
	 */
	public abstract GFXCanvas createCanvas(GFXFrame layer, GFXCanvas.Hints hints);
	
	/**
	 * Creates a new {@code GFXAsset}.
	 * 
	 * @param hints  asset hints
	 * @param type   an asset type
	 * @return  a graphics asset
	 * 
	 * 
	 * @see GFXAsset
	 */
	public abstract GFXAsset createAsset(GFXAsset.Hints hints, Class<?> type);
		
	/**
	 * Creates a new {@code GFXCursor}.
	 * 
	 * @param icon  a cursor icon
	 * @param xhot  a hotspot x-coordinate
	 * @param yhot  a hotspot y-coordinate
	 * @return  a new cursor
	 * 
	 * 
	 * @see GFXCursor
	 * @see Image
	 */
	public abstract GFXCursor createCursor(Image icon, int xhot, int yhot);
	
	/**
	 * Creates a new {@code GFXBuffer}.
	 * 
	 * @param hints  buffer hints
	 * @return  a graphics buffer
	 * 
	 * 
	 * @see BufferHints
	 * @see GFXBuffer
	 */
	public abstract GFXBuffer createBuffer(BufferHints hints);
}