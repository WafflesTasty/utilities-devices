package zeno.util.gfx.system.memory.assets;

import java.nio.ByteBuffer;

import zeno.util.data.handlers.Image;

/**
 * The {@code GFXAtlas} interface defines a sprite atlas generated in {@code GFXMemory}.
 * 
 * @author Waffles
 * @since Sep 18, 2016
 * @version 1.0
 * 
 * 
 * @see GFXTexture
 */
public interface GFXAtlas extends GFXTexture
{	
	/**
	 * Loads data into a detail level of the {@code GFXAtlas}.
	 * 
	 * @param data   a data buffer to load
	 * @param lod    a level of detail
	 * @param index  a sprite index
	 * @param size   an asset size
	 * 
	 * 
	 * @see ByteBuffer
	 */
	public abstract void load(ByteBuffer data, int lod, int index, int... size);
	
	/**
	 * Loads an image into a detail level of the {@code GFXAtlas}.
	 * 
	 * @param image  an image to load
	 * @param lod    a level of detail
	 * @param index  a sprite index
	 * 
	 * 
	 * @see Image
	 */
	public abstract void load(Image image, int lod, int index);
}