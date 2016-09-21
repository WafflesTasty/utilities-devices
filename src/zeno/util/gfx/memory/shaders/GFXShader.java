package zeno.util.gfx.memory.shaders;

import zeno.util.gfx.GFXMemory;
import zeno.util.tools.generic.manipulators.Disposable;
import zeno.util.tools.generic.manipulators.Loadable;
import zeno.util.tools.generic.properties.Discernible;

/**
 * The {@code GFXShader} interface defines a shader stage generated in {@link GFXMemory}.
 * 
 * @since Sep 18, 2016
 * @author Zeno
 * 
 * @see Discernible
 * @see Disposable
 * @see Loadable
 */
public interface GFXShader extends Discernible, Disposable, Loadable
{
	/**
	 * The {@code Type} enum defines the different types of shaders.
	 * 
	 * @since Sep 8, 2016
	 * @author Zeno
	 * 
	 * @see GFXShader
	 */
	public static enum Type
	{
		/**
		 * A vertex shader.
		 */
		VERTEX,
		/**
		 * A fragment shader.
		 */
		FRAGMENT,
		/**
		 * A geometry shader.
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
	 * Changes the source code of the {@code GFXShader}.
	 * 
	 * @param source  a new source code
	 */
	public abstract void setSource(String source);

	/**
	 * Returns the error message of the {@code GFXShader}.
	 * 
	 * @return  the shader's error message
	 */
	public abstract String getErrorMessage();
}