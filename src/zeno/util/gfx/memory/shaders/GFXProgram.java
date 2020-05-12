package zeno.util.gfx.memory.shaders;

import zeno.util.gfx.GFXMemory;
import zeno.util.tools.patterns.manipulators.Activator;
import zeno.util.tools.patterns.manipulators.Loadable;

/**
 * The {@code GFXProgram} interface defines a {@code GFXShader} pipeline program.
 * 
 * @author Zeno
 * @since Sep 8, 2016
 * @version 1.0
 * 
 * 
 * @see Activator
 * @see GFXMemory
 * @see Loadable
 */
public interface GFXProgram extends GFXMemory.Data, Activator, Loadable
{
	/**
	 * Adds a shader to the {@code GFXProgram}.
	 * 
	 * @param shader  a shader to add
	 * 
	 * 
	 * @see GFXShader
	 */
	public abstract void add(GFXShader shader);
	
	/**
	 * Removes a shader from the {@code GFXProgram}.
	 * 
	 * @param shader  a shader to remove
	 * 
	 * 
	 * @see GFXShader
	 */
	public abstract void remove(GFXShader shader);

	/**
	 * Returns an error from the {@code GFXProgram}.
	 * 
	 * @return  an error message
	 * 
	 * 
	 * @see String
	 */
	public abstract String ErrorMessage();
}