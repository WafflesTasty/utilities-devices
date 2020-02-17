package zeno.util.gfx.memory.formats;

import zeno.util.gfx.memory.GFXData;
import zeno.util.tools.patterns.properties.Discernible;
import zeno.util.tools.primitives.VarType;

/**
 * The {@code GFXField} class defines a data field in a {@link GFXData} object.
 * 
 * @since Sep 17, 2016
 * @author Zeno
 * 
 * @see Discernible
 */
public abstract class GFXField implements Discernible
{
	private int id;
	private int count;
	private VarType type;
	private GFXData parent;
	
	/**
	 * Creates a new {@code GFXField}.
	 * 
	 * @param data  a data source
	 * @see GFXData
	 */
	public GFXField(GFXData data)
	{
		id = data.generateFieldID();
		parent = data;
	}
	
	/**
	 * Returns the parent of the {@code GFXField}.
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
	 * Changes the offset of the {@code GFXField}.
	 * 
	 * @param offset  a new byte offset
	 */
	public abstract void setOffset(int offset);
		
	/**
	 * Changes the data type of the {@code GFXField}.
	 * 
	 * @param type  a new data type
	 * @see VarType
	 */
	public void setDataType(VarType type)
	{
		this.type = type;
	}
	
	/**
	 * Changes the data count of the {@code GFXField}.
	 * 
	 * @param count  a new count
	 */
	public void setCount(int count)
	{
		this.count = count;
	}
	
	
	/**
	 * Disables use of data from the {@code GFXField}.
	 */
	public abstract void disable();
	
	/**
	 * Enables use of data from the {@code GFXField}.
	 */
	public abstract void enable();

	
	/**
	 * Returns the data type of the {@code GFXField}.
	 * 
	 * @return  the value's data type
	 * @see VarType
	 */
	public VarType Type()
	{
		return type;
	}
	
	/**
	 * Returns the byte size of the {@code GFXField}.
	 * 
	 * @return  the value's byte size
	 */
	public int ByteSize()
	{
		return count * type.ByteSize();
	}
	
	/**
	 * Returns the count of the {@code GFXField}.
	 * 
	 * @return  the value's count
	 */
	public int Count()
	{
		return count;
	}

	
	@Override
	public int getID()
	{
		return id;
	}
}