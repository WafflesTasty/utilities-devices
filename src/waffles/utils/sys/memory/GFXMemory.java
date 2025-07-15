package waffles.utils.sys.memory;

import waffles.utils.dacs.files.assets.Image;
import waffles.utils.sys.memory.buffer.GFXBuffer;
import waffles.utils.sys.memory.buffer.hints.BufferHints;
import waffles.utils.sys.memory.config.AssetConfig;
import waffles.utils.sys.memory.config.ProgramConfig;
import waffles.utils.sys.memory.config.WindowConfig;
import waffles.utils.sys.memory.groups.GFXField;
import waffles.utils.sys.memory.groups.GFXFormat;
import waffles.utils.sys.memory.groups.GFXValue.Type;
import waffles.utils.sys.memory.shaders.GFXProgram;
import waffles.utils.sys.memory.shaders.GFXShader;
import waffles.utils.sys.memory.groups.GFXGlobal;
import waffles.utils.sys.memory.groups.GFXValue;
import waffles.utils.sys.video.assets.GFXAsset;
import waffles.utils.sys.video.frames.GFXCanvas;
import waffles.utils.sys.video.frames.GFXFrame;
import waffles.utils.sys.video.graphics.GFXCursor;
import waffles.utils.sys.video.graphics.GFXGraphics;
import waffles.utils.tools.patterns.semantics.Discernible;
import waffles.utils.tools.patterns.semantics.Disposable;

/**
 * The {@code GFXMemory} manages the creation of various
 * hardware-accelerated graphics objects.
 *
 * @author Waffles
 * @since 14 Mar 2025
 * @version 1.0
 */
public interface GFXMemory
{	
	/**
	 * A {@code Data} object can be generated from {@code GFXMemory}.
	 *
	 * @author Waffles
	 * @since 14 Mar 2025
	 * @version 1.1
	 *
	 * 
	 * @see Discernible
	 * @see Disposable
	 */
	public static interface Data extends Discernible, Disposable
	{
		// NOT APPLICABLE
	}

	/**
	 * Creates a hardware-accelerated object in the {@code GFXMemory}.
	 * 
	 * @param <D>   a data type
	 * @param type  an object class
	 * @param data  object data
	 * @return  a new object
	 */
	public default <D extends Data> D create(Class<D> type, Object... data)
	{
		if(type == GFXField.class)
		{
			GFXValue.Type val = (Type) data[0];
			GFXGroup grp = (GFXGroup) data[1];
			int cnt = (int) data[2];
			
			return (D) Program().createField(grp, val, cnt);
		}
		
		if(type == GFXGlobal.class)
		{
			Class<?> val = (Class<?>) data[0];
			GFXGroup grp = (GFXGroup) data[1];
			int dim = (int) data[2];
			int cnt = (int) data[3];
			
			if(val == GFXAsset.class)
			{	
				boolean isAtlas = (boolean) data[4];
				return (D) Program().createSampler(grp, dim, cnt, isAtlas);
			}
			
			return (D) Program().createGlobal(grp, val, dim, cnt);
		}
		
		if(type == GFXFormat.class)
		{
			GFXGroup grp = (GFXGroup) data[0];
			boolean isInstanced = (boolean) data[1];
			return (D) Program().createFormat(grp, isInstanced);
		}
		
		
		if(type == GFXGroup.class)
		{
			return (D) Program().createGroup();
		}
		
		if(type == GFXShader.class)
		{
			GFXShader.Type val = (GFXShader.Type) data[0];
			String src = (String) data[1];
			return (D) Program().createShader(val, src);
		}
		
		if(type == GFXProgram.class)
		{
			return (D) Program().createProgram();
		}
		
		
		if(type == GFXAsset.class)
		{
			GFXAsset.Hints h = (GFXAsset.Hints) data[0];
			Class<?> val  = (Class<?>) data[1];
			
			return (D) Assets().createAsset(h, val);
		}
		
		if(type == GFXBuffer.class)
		{
			BufferHints h = (BufferHints) data[0];
			return (D) Assets().createBuffer(h);
		}
		
		if(type == GFXCursor.class)
		{
			Image icon = (Image) data[0];
			int xhot = (int) data[1];
			int yhot = (int) data[2];
			
			return (D) Assets().createCursor(icon, xhot, yhot);
		}
		
		
		if(type == GFXCanvas.class)
		{
			GFXFrame layer = (GFXFrame) data[0];
			GFXCanvas.Hints hints = (GFXCanvas.Hints) data[1];
			
			return (D) Assets().createCanvas(layer, hints);
		}
		
		if(type == GFXGraphics.class)
		{
			return (D) Window().createGraphics();
		}
		
		if(type == GFXFrame.class)
		{
			return (D) Window().createFrame();
		}

		
		return null;
	}

	
	/**
	 * Returns the asset config of the {@code GFXMemory}.
	 * 
	 * @return  asset data
	 * 
	 * 
	 * @see AssetConfig
	 */
	public abstract AssetConfig Assets();
	
	/**
	 * Returns the program config of the {@code GFXMemory}.
	 * 
	 * @return  program data
	 * 
	 * 
	 * @see ProgramConfig
	 */
	public abstract ProgramConfig Program();
	
	/**
	 * Returns the window config of the {@code GFXMemory}.
	 * 
	 * @return  window data
	 * 
	 * 
	 * @see WindowConfig
	 */
	public abstract WindowConfig Window();
}