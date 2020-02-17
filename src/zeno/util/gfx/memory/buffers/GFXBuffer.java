package zeno.util.gfx.memory.buffers;

import java.nio.ByteBuffer;

import zeno.util.data.memory.Buffer;
import zeno.util.tools.patterns.manipulators.Disposable;
import zeno.util.tools.patterns.manipulators.Loadable;
import zeno.util.tools.patterns.properties.Discernible;

/**
 * The {@code GFXBuffer} interface defines a low-level mechanism to handle {@link ByteBuffer} data.
 * 
 * @since Sep 15, 2016
 * @author Zeno
 * 
 * @see Discernible
 * @see Disposable
 * @see Loadable
 * @see Buffer
 */
public interface GFXBuffer extends Buffer, Discernible, Disposable, Loadable
{	
	/**
	 * The {@code Access} enum defines access methods for a {@link GFXBuffer}.
	 * 
	 * @since Sep 18, 2016
	 * @author Zeno
	 * 
	 * @see GFXBuffer
	 */
	public static enum Access
	{
		/**
		 * A write operation.
		 */
		WRITE,
		/**
		 * A read operation.
		 */
		READ;
	}
	
	/**
	 * The {@code Usage} enum defines usage hints for a {@link GFXBuffer}.
	 * 
	 * @since Sep 12, 2016
	 * @author Zeno
	 * 
	 * @see GFXBuffer
	 */
	public static enum Usage
	{
		/**
		 * The data is used for copy operations.
		 */
		COPY,
		/**
		 * The data is used for draw operations.
		 */
		DRAW,
		/**
		 * The data is used for read operations.
		 */
		READ;
	}
	
	/**
	 * The {@code Rate} enum defines rate hints for a {@link GFXBuffer}.
	 * 
	 * @since Sep 15, 2016
	 * @author Zeno
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
	 * The {@code Type} enum defines the types of a {@link GFXBuffer}.
	 * 
	 * @since Sep 15, 2016
	 * @author Zeno
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
	 * Changes the maximum size of the {@code GFXBuffer}.
	 * 
	 * @param size  a new buffer size
	 */
	public abstract void setMaxSize(int size);
	
	/**
	 * Changes the usage hint of the {@code GFXBuffer}.
	 * 
	 * @param use  a new usage hint
	 * @see Usage
	 */
	public abstract void setUsage(Usage use);

	/**
	 * Changes the rate hint of the {@code GFXBuffer}.
	 * 
	 * @param rate  a new rate hint
	 * @see Rate
	 */
	public abstract void setRate(Rate rate);
	
	/**
	 * Changes the type of the {@code GFXBuffer}.
	 * 
	 * @param type  a new type
	 * @see Type
	 */
	public abstract void setType(Type type);
	
		
	/**
	 * Maps the target data buffer to this {@code GFXBuffer}.
	 * <br> If this returns {@code false}, the buffer
	 * was unable to map and can't be accessed.
	 * 
	 * @param access  an access method to use
	 * @param start  the start index to map to
	 * @param size  the total size to map to
	 * @return  {@code true} if successful
	 */
	public abstract boolean map(Access access, int start, int size);
	
	/**
	 * Maps the target data buffer to this {@code GFXBuffer}.
	 * <br> If this returns {@code false}, the buffer
	 * was unable to map and can't be accessed.
	 * 
	 * @param access  an access method to use
	 * @return  {@code true} if successful
	 */
	public abstract boolean map(Access access);
		
	/**
	 * Unmaps the {@code GFXBuffer} from its target.
	 * <br> If this returns {@code false}, the buffer's
	 * contents is corrupt and needs to be renewed.
	 * 
	 * @return  {@code true} if the data is valid
	 */
	public abstract boolean unmap();
}