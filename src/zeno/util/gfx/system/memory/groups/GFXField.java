package zeno.util.gfx.system.memory.groups;

import zeno.util.gfx.system.GFXMemory;
import zeno.util.tools.patterns.manipulators.Activator;

/**
 * The {@code GFXField} class defines a data field in a {@code GFXFormat}.
 * 
 * @author Zeno
 * @since Sep 17, 2016
 * @version 1.0
 * 
 * 
 * @see Activator
 * @see GFXMemory
 */
public interface GFXField extends GFXMemory.Data, Activator
{
	/**
	 * The {@code Type} enum defines types of a {@code GFXField}.
	 *
	 * @author Zeno
	 * @since 13 May 2020
	 * @version 1.0
	 */
	public static enum Type
	{
		/**
		 * A single precision floating-point type.
		 */
		FLOAT(4),
		/**
		 * A double precision floating-point type.
		 */
		DOUBLE(8),
		/**
		 * A 32-bit integer type.
		 */
		INTEGER(4),
		/**
		 * A matrix type.
		 */
		MATRIX(4);

		
		private int bytes;
		
		private Type(int bytes)
		{
			this.bytes = bytes;
		}
		
		/**
		 * Returns the byte size of the {@code Type}.
		 * 
		 * @return  a byte size
		 */
		public int ByteSize()
		{
			return bytes;
		}
	}
	
	/**
	 * Returns the byte size of the {@code GFXField}.
	 * 
	 * @return  a byte size
	 */
	public default int ByteSize()
	{
		return Count() * Type().ByteSize();
	}
	
	/**
	 * Changes the data offset of the {@code GFXField}.
	 * 
	 * @param offset  a byte offset
	 */
	public abstract void setOffset(int offset);	

	/**
	 * Returns the overflow of the {@code GFXField}.
	 * 
	 * @return  a field overflow
	 */
	public default GFXField[] Overflow()
	{
		return new GFXField[0];
	}
	

	/**
	 * Returns the count of the {@code GFXField}.
	 * 
	 * @return  a data count
	 */
	public abstract int Count();

	/**
	 * Returns the type of the {@code GFXField}.
	 * 
	 * @return  a data type
	 */
	public abstract Type Type();
}