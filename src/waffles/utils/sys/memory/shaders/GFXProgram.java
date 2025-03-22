package waffles.utils.sys.memory.shaders;

import waffles.utils.sys.memory.GFXMemory;
import waffles.utils.tools.patterns.semantics.Activator;
import waffles.utils.tools.patterns.semantics.Loadable;

/**
 * A {@code GFXProgram} defines a {@code GFXShader} pipeline.
 * 
 * @author Waffles
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
	 * @param s  a program shader
	 * 
	 * 
	 * @see GFXShader
	 */
	public abstract void add(GFXShader s);
	
	/**
	 * Removes a shader to the {@code GFXProgram}.
	 * 
	 * @param s  a program shader
	 * 
	 * 
	 * @see GFXShader
	 */
	public abstract void remove(GFXShader s);
	
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