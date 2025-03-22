package waffles.utils.sys.video.assets;

import java.nio.ByteBuffer;

import waffles.utils.dacs.files.assets.Image;
import waffles.utils.dacs.utilities.Buffers;

/**
 * A {@code GFXAtlas} defines a hardware-accelerated sprite atlas.
 * 
 * @author Waffles
 * @since Sep 18, 2016
 * @version 1.0
 * 
 * 
 * @see GFXAsset
 */
public interface GFXAtlas extends GFXAsset
{	
	/**
	 * The {@code Hints} define settings for a {@code GFXAtlas}.
	 *
	 * @author Waffles
	 * @since 17 Mar 2025
	 * @version 1.1
	 *
	 * 
	 * @see GFXAsset
	 */
	public static interface Hints extends GFXAsset.Hints
	{
		/**
		 * Returns the asset count of the {@code Hints}.
		 * 
		 * @return  a sprite count
		 */
		public abstract int AssetCount();
	}
	
	
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
	 * Loads data into a detail level of the {@code GFXAtlas}.
	 * 
	 * @param data   a data buffer to load
	 * @param index  a sprite index
	 * @param size   an asset size
	 * 
	 * 
	 * @see ByteBuffer
	 */
	public default void load(ByteBuffer data, int index, int... size)
	{
		load(data, 0, index, size);
	}
	
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
	public default void load(Image image, int lod, int index)
	{
		byte[] data = image.Array();
		int[] dims  = image.Dimensions();
		int size = data.length;

		ByteBuffer buffer = Buffers.create(size);
		buffer = buffer.put(data).flip();
		load(buffer, lod, index, dims);
	}
	
	/**
	 * Loads an image into a detail level of the {@code GFXAtlas}.
	 * 
	 * @param image  an image to load
	 * @param index  a sprite index
	 * 
	 * 
	 * @see Image
	 */
	public default void load(Image image, int index)
	{
		load(image, 0, index);
	}

	
	@Override
	public abstract GFXAtlas.Hints Hints();
}