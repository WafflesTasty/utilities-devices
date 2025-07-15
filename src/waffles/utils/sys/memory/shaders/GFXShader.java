package waffles.utils.sys.memory.shaders;

import waffles.utils.sys.memory.GFXMemory;
import waffles.utils.sys.utilities.Sourced;
import waffles.utils.tools.patterns.semantics.Loadable;

/**
 * A {@code GFXShader} defines a single shader stage in a {@code GFXProgram}.
 * 
 * @author Waffles
 * @since Sep 18, 2016
 * @version 1.0
 * 
 * 
 * @see GFXMemory
 * @see Loadable
 * @see Sourced
 */
public interface GFXShader extends GFXMemory.Data, Loadable, Sourced
{
	/**
	 * The {@code Type} enum defines the type of a {@code GFXShader}.
	 * 
	 * @author Waffles
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
		
		
		/**
		 * Returns the previous {@code Type}.
		 * 
		 * @return  a previous type
		 */
		public Type prev()
		{
			switch(this)
			{
			case VERTEX:
				return null;
			case TES_CONTROL:
				return VERTEX;
			case TES_EVAL:
				return TES_CONTROL;
			case GEOMETRY:
				return TES_EVAL;
			case FRAGMENT:
				return GEOMETRY;
			case COMPUTE:
			default:
				return null;
			}
		}
		
		/**
		 * Returns the next {@code Type}.
		 * 
		 * @return  a next type
		 */
		public Type next()
		{
			switch(this)
			{
			case VERTEX:
				return TES_CONTROL;
			case TES_CONTROL:
				return TES_EVAL;
			case TES_EVAL:
				return GEOMETRY;
			case GEOMETRY:
				return FRAGMENT;
			case FRAGMENT:
			case COMPUTE:
			default:
				return null;
			}
		}
	}

		
	/**
	 * Returns an error from the {@code GFXShader}.
	 * 
	 * @return  the shader's error message
	 */
	public abstract String ErrorMessage();
}