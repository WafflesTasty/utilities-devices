package waffles.utils.sys.video.assets;

import java.nio.ByteBuffer;

import waffles.utils.dacs.files.assets.Image;
import waffles.utils.dacs.utilities.Buffers;

/**
 * A {@code GFXFlat} defines a flat hardware-accelerated image.
 * 
 * @author Waffles
 * @since Sep 18, 2016
 * @version 1.0
 * 
 * 
 * @see GFXAsset
 */
public interface GFXFlat extends GFXAsset
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
	 * Loads data into a detail level of the {@code GFXFlat}.
	 * 
	 * @param data  a data buffer to load
	 * @param size  an asset size
	 * 
	 * 
	 * @see ByteBuffer
	 */
	public default void load(ByteBuffer data, int... size)
	{
		load(data, 0, size);
	}
	
	/**
	 * Loads an image into a detail level of the {@code GFXFlat}.
	 * 
	 * @param image  an image to load
	 * @param lod    a level of detail
	 * 
	 * 
	 * @see Image
	 */
	public default void load(Image image, int lod)
	{
		byte[] data = image.Array();
		int[] dims  = image.Dimensions();
		int size = data.length;

		ByteBuffer buffer = Buffers.create(size);
		buffer = buffer.put(data).flip();
		load(buffer, lod, dims);
	}
	
	/**
	 * Loads an image into a detail level of the {@code GFXFlat}.
	 * 
	 * @param image  an image to load
	 * 
	 * 
	 * @see Image
	 */
	public default void load(Image image)
	{
		load(image, 0);
	}
}