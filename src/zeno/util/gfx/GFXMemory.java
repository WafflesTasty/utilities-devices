package zeno.util.gfx;

/**
 * The {@code GFXMemory} interface handles the allocation of graphics memory.
 * 
 * @author Zeno
 * @since Sep 12, 2016
 * @version 1.0
 */
public interface GFXMemory
{		
	/**
	 * The {@code Type} enum defines different types of graphics memory.
	 *
	 * @author Zeno
	 * @since 12 May 2020
	 * @version 1.0
	 */
	public static enum Type
	{
		/**
		 * An asset contains image data.
		 */
		ASSET,
		/**
		 * A buffer contains vertex data.
		 */
		BUFFER,
		/**
		 * A field defines a format type.
		 */
		FIELD,
		/**
		 * A format defines a buffer layout.
		 */
		FORMAT,
		/**
		 * A global defines a shader uniform.
		 */
		GLOBAL,
		/**
		 * A group a program format specification.
		 */
		GROUP,
		/**
		 * A program compiles a complete set of shaders.
		 */
		PROGRAM,
		/**
		 * A shader defines a single stage in a program.
		 */
		SHADER
	}


	/**
	 * Generates a data object in the {@code GFXMemory}.
	 * 
	 * @param <P>   a data class type
	 * @param type  a data memory type
	 * @param data  a parameter set
	 * @return  a data object
	 * 
	 * 
	 * @see Object
	 * @see Type
	 */
	public abstract <P> P generate(Type type, Object... data);
}