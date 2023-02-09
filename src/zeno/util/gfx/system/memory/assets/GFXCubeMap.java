package zeno.util.gfx.system.memory.assets;

import java.nio.ByteBuffer;

import zeno.util.data.handlers.Image;

/**
 * The {@code GFXCubeMap} interface defines a cube map generated in {@code GFXMemory}.
 * 
 * @author Waffles
 * @since Sep 18, 2016
 * @version 1.0
 * 
 * 
 * @see GFXTexture
 */
public interface GFXCubeMap extends GFXTexture
{	
	/**
	 * The {@code Face} enum defines the faces of a {@code GFXCubeMap}.
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
		 * Returns the layer index.
		 * 
		 * @return  a layer index
		 */
		public int Layer()
		{
			return layer;
		}
	}
	
	
	/**
	 * Loads data into a detail level of the {@code GFXTexture}.
	 * 
	 * @param data  a data buffer to load
	 * @param lod   a level of detail
	 * @param face   a cubemap face
	 * @param size  an asset size
	 * 
	 * 
	 * @see ByteBuffer
	 */
	public abstract void load(ByteBuffer data, int lod, Face face, int... size);
	
	/**
	 * Loads an image into a detail level of the {@code GFXTexture}.
	 * 
	 * @param image  an image to load
	 * @param lod    a level of detail
	 * @param face   a cubemap face
	 * 
	 * 
	 * @see Image
	 */
	public abstract void load(Image image, int lod, Face face);
}