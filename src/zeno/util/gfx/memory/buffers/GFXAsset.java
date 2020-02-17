package zeno.util.gfx.memory.buffers;

import java.nio.ByteBuffer;

import zeno.util.algebra.linear.vector.fixed.Vector2;
import zeno.util.data.handlers.Image;
import zeno.util.gfx.GFXMemory;
import zeno.util.tools.patterns.manipulators.Disposable;
import zeno.util.tools.patterns.properties.Discernible;

/**
 * The {@code GFXAsset} interface defines an asset generated in {@link GFXMemory}.
 * 
 * @since Sep 18, 2016
 * @author Zeno
 * 
 * @see Discernible
 * @see Disposable
 */
public interface GFXAsset extends Discernible, Disposable
{
	/**
	 * The {@code Scaling} enum defines scaling methods for a {@link GFXAsset}.
	 * 
	 * @since Sep 18, 2016
	 * @author Zeno
	 * 
	 * @see GFXAsset
	 */
	public static enum Scaling
	{
		/**
		 * Find the nearest pixel of the average between mipmaps.
		 */
		AVG_MIPMAP_NEAREST,
		/**
		 * Interpolate pixels of the average between mipmaps.
		 */
		AVG_MIPMAP_LINEAR,
		/**
		 * Find the nearest pixel of the nearest mipmap.
		 */
		MIPMAP_NEAREST,
		/**
		 * Interpolate pixels of the nearest mipmap.
		 */
		MIPMAP_LINEAR,
		/**
		 * Find the nearest pixel on the asset.
		 */
		NEAREST,
		/**
		 * Interpolate pixels on the asset.
		 */
		LINEAR;
	}

	/**
	 * The {@code Border} enum defines border methods for a {@link GFXAsset}.
	 * 
	 * @since Sep 18, 2016
	 * @author Zeno
	 * 
	 * @see GFXAsset
	 */
	public static enum Border
	{
		/**
		 * Clamp co�rdinates to the edge of the {@code GFXAsset}.
		 */
		CLAMP_TO_EDGE,
		/**
		 * Mirror and repeat co�rdinates of the {@code GFXAsset}.
		 */
		MIRROR_REPEAT,
		/**
		 * Repeat co�rdinates of the {@code GFXAsset}.
		 */
		REPEAT,
	}

	/**
	 * The {@code Type} enum defines the types of a {@link GFXAsset}.
	 * 
	 * @since Sep 18, 2016
	 * @author Zeno
	 * 
	 * @see GFXAsset
	 */
	public static enum Type
	{
		/**
		 * A 1-dimensional asset.
		 */
		ASSET_1D,
		/**
		 * A 2-dimensional asset.
		 */
		ASSET_2D,
		/**
		 * A 3-dimensional asset.
		 */
		ASSET_3D;
	}

	
	public abstract Vector2 Size();
	
	/**
	 * Loads a data buffer into a detail level of the {@code GFXAsset}.
	 * 
	 * @param data  a data buffer to load
	 * @param lod  a level of detail to load
	 * @param size  the dimensions of the asset
	 * @see ByteBuffer
	 */
	public abstract void load(ByteBuffer data, int lod, int... size);
	
	/**
	 * Loads an image into a detail level of the {@code GFXAsset}.
	 * 
	 * @param image  an image to load
	 * @param lod  a level of detail to load
	 * @see Image
	 */
	public abstract void load(Image image, int lod);
	
		
	/**
	 * Changes the scaling method of the {@code GFXAsset}.
	 * 
	 * @param min  a minimum scaling method
	 * @param max  a maximum scaling method
	 */
	public abstract void setScaling(Scaling min, Scaling max);
		
	/**
	 * Changes the level of detail of the {@code GFXAsset}.
	 * 
	 * @param min  a minimum level of detail
	 * @param max  a maximum level of detail
	 */
	public abstract void setLevelOfDetail(int min, int max);
	
	/**
	 * Changes the border method of the {@code GFXAsset}.
	 * 
	 * @param border  a new border method
	 * @see Border
	 */
	public abstract void setBorder(Border... border);
	
	
	/**
	 * Changes the scaling method of the {@code GFXAsset}.
	 * 
	 * @param scale  a new scaling method
	 * @see Scaling
	 */
	public default void setScaling(Scaling scale)
	{
		setScaling(scale, scale);
	}
	
	/**
	 * Changes the level of detail of the {@code GFXAsset}.
	 * 
	 * @param lod  a maximum level of detail
	 */
	public default void setLevelOfDetail(int lod)
	{
		setLevelOfDetail(0, lod);
	}

	/**
	 * Changes the border method of the {@code GFXAsset}.
	 * 
	 * @param border  a new border method
	 * @see Border
	 */
	public default void setBorder(Border border)
	{
		setBorder(border, border, border);
	}
}