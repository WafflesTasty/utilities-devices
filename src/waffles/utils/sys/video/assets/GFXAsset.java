package waffles.utils.sys.video.assets;

import waffles.utils.sys.memory.GFXMemory;
import waffles.utils.sys.video.graphics.cmds.GFXDepthCheck.Method;

/**
 * A {@code GFXAssetOld} defines a hardware-accelerated graphics texture.
 *
 * @author Waffles
 * @since 09 Feb 2023
 * @version 1.0
 * 
 * 
 * @see GFXMemory
 */
public interface GFXAsset extends GFXMemory.Data
{
	/**
	 * A {@code Border} defines a border method for a {@code GFXAssetOld}.
	 * 
	 * @author Waffles
	 * @since Sep 18, 2016
	 * @version 1.0
	 */
	public static enum Border
	{
		/**
		 * Do not draw beyond the edge of the {@code GFXAssetOld}.
		 */
		NONE,
		/**
		 * Clamp coordinates to the edge of the {@code GFXAssetOld}.
		 */
		CLAMP_TO_EDGE,
		/**
		 * Mirror and repeat coordinates of the {@code GFXAssetOld}.
		 */
		MIRROR_REPEAT,
		/**
		 * Repeat coordinates of the {@code GFXAssetOld}.
		 */
		REPEAT,
	}
	
	/**
	 * A {@code Scaling} defines a scaling method for a {@code GFXAssetOld}.
	 * 
	 * @author Waffles
	 * @since Sep 18, 2016
	 * @version 1.0
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
	 * The {@code Hints} define settings for a {@code GFXAssetOld}.
	 *
	 * @author Waffles
	 * @since 12 May 2020
	 * @version 1.0
	 */
	public static interface Hints
	{
		/**
		 * Returns the compare method of the {@code Hints}.
		 * 
		 * @return  a compare method
		 * 
		 * 
		 * @see Method
		 */
		public default Method CompareMethod()
		{
			return Method.LEQUAL;
		}
		
		/**
		 * Returns the minimum scaling of the {@code Hints}.
		 * 
		 * @return  a minimum scaling
		 * 
		 * 
		 * @see Scaling
		 */
		public default Scaling MinScaling()
		{
			return Scaling.NEAREST;
		}
		
		/**
		 * Returns the maximum scaling of the {@code Hints}.
		 * 
		 * @return  a maximum scaling
		 * 
		 * 
		 * @see Scaling
		 */
		public default Scaling MaxScaling()
		{
			return Scaling.NEAREST;
		}
		
		/**
		 * Returns the x-coord border of the {@code Hints}.
		 * 
		 * @return  an x-coord border
		 * 
		 * 
		 * @see Border
		 */
		public default Border XBorder()
		{
			return Border.NONE;
		}

		/**
		 * Returns the y-coord border of the {@code Hints}.
		 * 
		 * @return  an y-coord border
		 * 
		 * 
		 * @see Border
		 */
		public default Border YBorder()
		{
			return Border.NONE;
		}
		
		/**
		 * Returns the z-coord border of the {@code Hints}.
		 * 
		 * @return  an z-coord border
		 * 
		 * 
		 * @see Border
		 */
		public default Border ZBorder()
		{
			return Border.NONE;
		}

		/**
		 * Returns the asset size of the {@code Hints}.
		 * 
		 * @return  an asset size
		 */
		public abstract int[] AssetSize();
		
		/**
		 * Returns the LOD count of the {@code Hints}.
		 * 
		 * @return  an lod count
		 */
		public default int LODCount()
		{
			return 1;  
		}
		
		/**
		 * Returns the minimum lod of the {@code Hints}.
		 * 
		 * @return  a minimum lod
		 */
		public default int MinLOD()
		{
			return 0;
		}
		
		/**
		 * Returns the maximum lod of the {@code Hints}.
		 * 
		 * @return  a maximum lod
		 */
		public default int MaxLOD()
		{
			return LODCount() - 1;
		}
	}
	
	/**
	 * Returns the hints of the {@code GFXAssetOld}.
	 * 
	 * @return  asset hints
	 * 
	 * 
	 * @see Hints
	 */
	public abstract Hints Hints();
}