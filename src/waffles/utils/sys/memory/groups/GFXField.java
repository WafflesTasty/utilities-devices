package waffles.utils.sys.memory.groups;

import waffles.utils.tools.patterns.persistence.Data;
import waffles.utils.tools.patterns.semantics.Activator;

/**
 * A {@code GFXField} defines a data field in a {@code GFXFormat}.
 *
 * @author Waffles
 * @since 17 Mar 2025
 * @version 1.1
 *
 * 
 * @param <O>  a data type
 * @see Activator
 * @see GFXGlobal
 * @see Data
 */
public interface GFXField<O> extends GFXGlobal<O>, Activator, Data
{
	/**
	 * The {@code Type} enum defines data types of a {@code GFXField}.
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
	 * Returns the data type of the {@code GFXField}.
	 * 
	 * @return  a data type
	 */
	public abstract Type Type();
	
	
	@Override
	public default int DataSize()
	{
		return Dimension() * Type().ByteSize();
	}
}