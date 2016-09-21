package zeno.util.gfx;

import zeno.util.gfx.memory.GFXData;
import zeno.util.gfx.memory.buffers.GFXAsset;
import zeno.util.gfx.memory.buffers.GFXBuffer;
import zeno.util.gfx.memory.formats.GFXField;
import zeno.util.gfx.memory.formats.GFXFormat;
import zeno.util.gfx.memory.formats.GFXGlobal;
import zeno.util.gfx.memory.shaders.GFXProgram;
import zeno.util.gfx.memory.shaders.GFXShader;

/**
 * The {@code GFXMemory} interface handles the allocation of objects in the {@link GFXSystem}.
 * 
 * @since Sep 12, 2016
 * @author Zeno
 */
public interface GFXMemory
{		
	/**
	 * Allocates a global data field into the {@code GFXMemory}.
	 * 
	 * @param data  a data source
	 * @param type  a data type
	 * @return  a new global
	 * @see GFXGlobal
	 * @see Class
	 */
	public abstract <O> GFXGlobal<O> createGlobal(GFXData data, Class<O> type);
	
	/**
	 * Allocates a program shader stage into the {@code Memory}.
	 * 
	 * @param type  the shader's type
	 * @return  a shader stage
	 * @see GFXShader
	 */
	public abstract GFXShader createShader(GFXShader.Type type);
	
	/**
	 * Allocates a global asset texture into the {@code GFXMemory}.
	 * 
	 * @param type  the asset's type
	 * @return  a new asset
	 * @see GFXAsset
	 */
	public abstract GFXAsset createAsset(GFXAsset.Type type);
	
	/**
	 * Allocates a vertex data format into the {@code GFXMemory}.
	 * 
	 * @param data  a data source
	 * @return  a new data format
	 * @see GFXFormat
	 * @see GFXData
	 */
	public abstract GFXFormat createFormat(GFXData data);
	
	/**
	 * Allocates a vertex data field into the {@code GFXMemory}.
	 * 
	 * @param data  a data source
	 * @return  a new data field
	 * @see GFXField
	 * @see GFXData
	 */
	public abstract GFXField createField(GFXData data);
		
	/**
	 * Allocates a shader program into the {@code GFXMemory}.
	 * 
	 * @return  a new shader program
	 * @see GFXProgram
	 */
	public abstract GFXProgram createProgram();
	
	/**
	 * Allocates a data buffer into the {@code GFXMemory}.
	 * 
	 * @return  a new data buffer
	 * @see GFXBuffer
	 */
	public abstract GFXBuffer createBuffer();
	
	/**
	 * Allocates a data object into the {@code GFXMemory}.
	 * 
	 * @return  a new data object
	 * @see GFXData
	 */
	public abstract GFXData createData();
}