package zeno.util.gfx.system.memory.shaders;

import zeno.util.gfx.system.GFXMemory;

/**
 * The {@code GFXShader} interface defines a shader stage in a {@code GFXProgram}.
 * 
 * @author Zeno
 * @since Sep 18, 2016
 * @version 1.0
 * 
 * 
 * @see GFXMemory
 */
public interface GFXShader extends GFXMemory.Data
{
	/**
	 * The {@code Type} enum defines the type of a {@code GFXShader}.
	 * 
	 * @author Zeno
	 * @since Sep 8, 2016
	 * @version 1.0
	 * 
	 * 
	 * @see GFXShader
	 */
	public static enum Type
	{
		/**
		 * A vertex input shader.
		 */
		VERTEX,
		/**
		 * A fragment output shader.
		 */
		FRAGMENT,
		/**
		 * A vertex geometry shader.
		 */
		GEOMETRY,
		/**
		 * A tesselation control shader.
		 */
		TES_CONTROL,
		/**
		 * A tesselation evaluation shader.
		 */
		TES_EVAL,
		/**
		 * A computation shader.
		 */
		COMPUTE;
	}

	
	/**
	 * Loads a source code into the {@code GFXShader}.
	 * 
	 * @param source  a source code
	 * @return  {@code true} if successful
	 * 
	 * 
	 * @see String
	 */
	public abstract boolean load(String source);
	
	/**
	 * Returns an error from the {@code GFXShader}.
	 * 
	 * @return  the shader's error message
	 */
	public abstract String ErrorMessage();
}