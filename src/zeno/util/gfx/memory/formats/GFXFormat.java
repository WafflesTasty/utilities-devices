package zeno.util.gfx.memory.formats;

import zeno.util.gfx.memory.GFXData;
import zeno.util.gfx.memory.buffers.GFXBuffer;
import zeno.util.tools.patterns.properties.Discernible;

/**
 * The {@code GFXFormat} class defines a data format in a {@link GFXData} object.
 * 
 * @since Sep 8, 2016
 * @author Zeno
 * 
 * @see Discernible
 */
public abstract class GFXFormat implements Discernible
{
	private int id;
	private GFXData parent;
	
	/**
	 * Creates a new {@code GFXFormat}.
	 * 
	 * @param data  a data source
	 * @see GFXData
	 */
	public GFXFormat(GFXData data)
	{
		id = data.generateFormatID();
		parent = data;
	}
	
	/**
	 * Returns the parent of the {@code GFXFormat}.
	 * 
	 * @return  a parent data
	 * 
	 * 
	 * @see GFXData
	 */
	public GFXData Parent()
	{
		return parent;
	}
	
	
	/**
	 * Changes the instancing state of the {@code GFXFormat}.
	 * 
	 * @param isInstanced  a new instancing state
	 */
	public abstract void setInstanced(boolean isInstanced);
	
	/**
	 * Changes the target buffer of the {@code GFXFormat}.
	 * 
	 * @param buffer  a target buffer
	 * @see GFXBuffer
	 */
	public abstract void setBuffer(GFXBuffer buffer);
	
	/**
	 * Adds a vertex data field to the {@code GFXFormat}.
	 * 
	 * @param field  a new data field
	 * @see GFXField
	 */
	public abstract void addField(GFXField field);
	
	/**
	 * Returns the size of the {@code GFXFormat}.
	 * 
	 * @return  the format's size
	 */
	public abstract int getByteSize();
	
	
	@Override
	public int getID()
	{
		return id;
	}
}