package waffles.utils.sys.memory.groups;

import waffles.utils.sys.memory.GFXMemory;
import waffles.utils.sys.utilities.scripts.vars.ValueType;
import waffles.utils.tools.patterns.persistence.Data;
import waffles.utils.tools.patterns.semantics.Countable;

/**
 * A {@code GFXValue} defines a global data value for a {@code GFXGroup}.
 * 
 * @author Waffles
 * @since Sep 17, 2016
 * @version 1.0
 * 
 * 
 * @param <O>  a data type
 * @see ValueType
 * @see GFXMemory
 * @see Countable
 * @see Data
 */
public interface GFXValue<O> extends GFXMemory.Data, Data, ValueType
{	
	/**
	 * The {@code Type} enum defines data types of a {@code GFXValue}.
	 *
	 * @author Waffles
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
		 * A sampler type.
		 */
		SAMPLER(4),
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
	 * Changes the value of the {@code GFXValue}.
	 * 
	 * @param value  a value array
	 */
	public abstract void set(O... value);
	
	@Override
	public default int DataSize()
	{
		return Dimension() * Type().ByteSize();
	}
}