package zeno.util.gfx.system.memory.assets;

import java.nio.ByteBuffer;

import zeno.util.data.handlers.Image;

/**
 * The {@code GFXFlat} interface defines a flat image generated in {@code GFXMemory}.
 * 
 * @author Waffles
 * @since Sep 18, 2016
 * @version 1.0
 * 
 * 
 * @see GFXTexture
 */
public interface GFXFlat extends GFXTexture
{	
	/**
	 * Loads data into a detail level of the {@code GFXFlat}.
	 * 
	 * @param data  a data buffer to load
	 * @param lod   a level of detail
	 * @param size  an asset size
	 * 
	 * 
	 * @see ByteBuffer
	 */
	public abstract void load(ByteBuffer data, int lod, int... size);
	
	/**
	 * Loads an image into a detail level of the {@code GFXFlat}.
	 * 
	 * @param image  an image to load
	 * @param lod    a level of detail
	 * 
	 * 
	 * @see Image
	 */
	public abstract void load(Image image, int lod);
}