package waffles.utils.sys.video.assets;

import java.nio.ByteBuffer;

import waffles.utils.dacs.files.assets.Image;
import waffles.utils.dacs.utilities.Buffers;
import waffles.utils.sys.video.frames.GFXFrame;

/**
 * A {@code GFXCube} defines a hardware-accelerated cube map.
 * 
 * @author Waffles
 * @since Sep 18, 2016
 * @version 1.0
 * 
 * 
 * @see GFXAsset
 */
public interface GFXCube extends GFXAsset
{	
	/**
	 * A {@code Face} defines a single face in a {@code GFXCube}.
	 *
	 * @author Waffles
	 * @since 25 Jan 2023
	 * @version 1.0
	 */
	public static enum Face
	{
		/**
		 * Positive x-aligned face.
		 */
		X_POS(0),
		/**
		 * Negative x-aligned face.
		 */
		X_NEG(1),
		/**
		 * Positive y-aligned face.
		 */
		Y_POS(2),
		/**
		 * Negative y-aligned face.
		 */
		Y_NEG(3),
		/**
		 * Positive z-aligned face.
		 */
		Z_POS(4),
		/**
		 * Negative z-aligned face.
		 */
		Z_NEG(5);
		
		
		private int layer;
		
		private Face(int layer)
		{
			this.layer = layer;
		}
		
		/**
		 * Returns the face index.
		 * 
		 * @return  a face index
		 */
		public int Layer()
		{
			return layer;
		}
	}
	
	/**
	 * The {@code Hints} define settings for a {@code GFXCube}.
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
		 * Returns the type of the {@code Hints}.
		 * 
		 * @return  a data type
		 * 
		 * 
		 * @see GFXFrame
		 */
		public abstract GFXFrame.Target Type();
	}
	
		
	/**
	 * Loads data into a detail level of the {@code GFXCube}.
	 * 
	 * @param data  a data buffer to load
	 * @param lod   a level of detail
	 * @param face  a cube map face
	 * @param size  an asset size
	 * 
	 * 
	 * @see ByteBuffer
	 * @see Face
	 */
	public abstract void load(ByteBuffer data, int lod, Face face, int... size);
	
	/**
	 * Loads data into a detail level of the {@code GFXCube}.
	 * 
	 * @param data  a data buffer to load
	 * @param face  a cube map face
	 * @param size  an asset size
	 * 
	 * 
	 * @see ByteBuffer
	 * @see Face
	 */
	public default void load(ByteBuffer data, Face face, int... size)
	{
		load(data, 0, face, size);
	}
	
	/**
	 * Loads an image into a level of the {@code GFXCube}.
	 * 
	 * @param image  an image to load
	 * @param lod    a level of detail
	 * @param face   a cube map face
	 * 
	 * 
	 * @see Image
	 */
	public default void load(Image image, int lod, Face face)
	{
		byte[] data = image.Array();
		int[] dims  = image.Dimensions();
		int size = data.length;

		ByteBuffer buffer = Buffers.create(size);
		buffer = buffer.put(data).flip();
		load(buffer, lod, face, dims);
	}
	
	/**
	 * Loads an image into a level of the {@code GFXCubeMap}.
	 * 
	 * @param image  an image to load
	 * @param face   a cube map face
	 * 
	 * 
	 * @see Image
	 */
	public default void load(Image image, Face face)
	{
		load(image, 0, face);
	}


	@Override
	public abstract GFXCube.Hints Hints();
}