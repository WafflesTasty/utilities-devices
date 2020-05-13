package zeno.util.gfx.system.memory.buffers;

import zeno.util.data.memory.Buffer;
import zeno.util.gfx.system.GFXMemory;
import zeno.util.gfx.system.memory.buffers.GFXBuffer.Layout.Access;

/**
 * The {@code GFXBuffer} interface handles raw byte data in a graphics buffer.
 * 
 * @author Zeno
 * @since Sep 15, 2016
 * @version 1.0
 * 
 * 
 * @see GFXMemory
 * @see Buffer
 */
public interface GFXBuffer extends GFXMemory.Data, Buffer
{		
	/**
	 * The {@code Hints} interface defines the layout for a {@code GFXBuffer}.
	 *
	 * @author Zeno
	 * @since 12 May 2020
	 * @version 1.0
	 */
	public static interface Layout
	{
		/**
		 * Creates a {@code Layout} with the given parameters.
		 * 
		 * @param access  a buffer access hint
		 * @param rate    a buffer rate hint
		 * @param type    a buffer type
		 * @param size    a buffer size
		 * @return  a buffer layout
		 * 
		 * 
		 * @see Access
		 * @see Rate
		 * @see Type
		 */
		public static Layout create(Access access, Rate rate, Type type, int size)
		{
			return new Layout()
			{				
				@Override
				public Rate Rate()
				{
					return rate;
				}
			
				@Override
				public Access Access()
				{
					return access;
				}
				
				@Override
				public Type Type()
				{
					return type;
				}
				
				@Override
				public int Size()
				{
					return size;
				}
			};
		}
		
		/**
		 * Creates a {@code Layout} with the given parameters.
		 * </br> Access is set to draw by default.
		 * 
		 * @param rate   a buffer rate hint
		 * @param type   a buffer type
		 * @param size   a buffer size
		 * @return  a buffer layout
		 * 
		 * 
		 * @see Rate
		 * @see Type
		 */
		public static Layout create(Rate rate, Type type, int size)
		{
			return create(Access.WRITE, rate, type, size);
		}
		
		/**
		 * Creates a {@code Layout} with the given parameters.
		 * </br> Access is set to draw by default.
		 * Rate is set to dynamic by default.
		 * 
		 * @param type   a buffer type
		 * @param size   a buffer size
		 * @return  a buffer layout
		 * 
		 * 
		 * @see Type
		 */
		public static Layout create(Type type, int size)
		{
			return create(Access.WRITE, Rate.DYNAMIC, type, size);
		}		
		
		
		/**
		 * The {@code Rate} enum defines rate hints for a {@code GFXBuffer}.
		 * 
		 * @author Zeno
		 * @since Sep 15, 2016
		 * @version 1.0
		 * 
		 * 
		 * @see GFXBuffer
		 */
		public static enum Rate
		{
			/**
			 * The buffer is only updated once.
			 */
			STATIC,
			/**
			 * The buffer is updated occasionally.
			 */
			DYNAMIC,
			/**
			 * The buffer is constantly updated.
			 */
			STREAM;
		}
		
		/**
		 * The {@code Access} enum defines access hints for a {@code GFXBuffer}.
		 * 
		 * @author Zeno
		 * @since Sep 12, 2016
		 * @version 1.0
		 * 
		 * 
		 * @see GFXBuffer
		 */
		public static enum Access
		{
			/**
			 * The data is used for copy operations.
			 */
			COPY,
			/**
			 * The data is used for draw operations.
			 */
			WRITE,
			/**
			 * The data is used for read operations.
			 */
			READ;
		}
				
		/**
		 * The {@code Type} enum defines the type of a {@code GFXBuffer}.
		 * 
		 * @author Zeno
		 * @since Sep 15, 2016
		 * @version 1.0
		 * 
		 * 
		 * @see GFXBuffer
		 */
		public static enum Type
		{
			/**
			 * A buffer used as an atomic counter.
			 */
			COUNTER,
			/**
			 * A buffer used to store a shader block.
			 */
			SHADER,
			/**
			 * A buffer used for indexed rendering.
			 */
			INDEX,
			/**
			 * A buffer used to store a texture.
			 */
			TEXTURE,
			/**
			 * A buffer used as a shader uniform.
			 */
			UNIFORM,
			/**
			 * A buffer used to store vertex data.
			 */
			VERTEX;
		}
	
		
		/**
		 * Returns the buffer rate of the {@code Layout}.
		 * 
		 * @return  a buffer rate
		 * 
		 * 
		 * @see Rate
		 */
		public default Rate Rate()
		{
			return Rate.DYNAMIC;
		}
		
		/**
		 * Returns the buffer access of the {@code Layout}.
		 * 
		 * @return  a buffer access
		 * 
		 * 
		 * @see Access
		 */
		public default Access Access()
		{
			return Access.WRITE;
		}
		
		/**
		 * Returns the buffer type of the {@code Layout}.
		 * 
		 * @return  a buffer type
		 * 
		 * 
		 * @see Type
		 */
		public abstract Type Type();
		
		/**
		 * Returns the size of the {@code Layout}.
		 * 
		 * @return  a buffer size
		 */
		public abstract int Size();
	}
	
			
	/**
	 * Creates a map into client space from this {@code GFXBuffer}.
	 * </br> If this returns {@code false}, the buffer
	 * was unable to map and cannot be accessed.
	 * 
	 * @param access  a buffer access method
	 * @param start   a mapping start index
	 * @param size    a mapping size
	 * @return  {@code true} if successful
	 * 
	 * 
	 * @see Access
	 */
	public abstract boolean map(Access access, int start, int size);
	
	/**
	 * Creates a map into client space from this {@code GFXBuffer}.
	 * </br> If this returns {@code false}, the buffer
	 * was unable to map and cannot be accessed.
	 * 
	 * @param access  a buffer access method
	 * @return  {@code true} if successful
	 * 
	 * 
	 * @see Access
	 */
	public abstract boolean map(Access access);
		
	/**
	 * Unmaps the client space from this {@code GFXBuffer}.
	 * <br> If this returns {@code false}, the buffer has
	 * corrupted contents needs to be updated.
	 * 
	 * @return  {@code true} if data is valid
	 */
	public abstract boolean unmap();
}