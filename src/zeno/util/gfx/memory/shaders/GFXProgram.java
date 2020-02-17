package zeno.util.gfx.memory.shaders;

import zeno.util.gfx.GFXMemory;
import zeno.util.tools.patterns.manipulators.Activator;
import zeno.util.tools.patterns.manipulators.Disposable;
import zeno.util.tools.patterns.manipulators.Loadable;
import zeno.util.tools.patterns.properties.Discernible;

/**
 * The {@code GFXProgram} interface defines a shader pipeline generated in {@link GFXMemory}.
 * 
 * @since Sep 8, 2016
 * @author Zeno
 * 
 * @see Discernible
 * @see Disposable
 * @see Activator
 * @see Loadable
 */
public interface GFXProgram extends Activator, Discernible, Disposable, Loadable
{
	/**
	 * Removes a shader from the {@code GFXProgram}.
	 * 
	 * @param shader  a shader to remove
	 * @see GFXShader
	 */
	public abstract void removeShader(GFXShader shader);

	/**
	 * Adds a shader to the {@code GFXProgram}.
	 * 
	 * @param shader  a shader to add
	 * @see GFXShader
	 */
	public abstract void addShader(GFXShader shader);

	/**
	 * Returns a generated error message.
	 * 
	 * @return  an error message
	 * @see String
	 */
	public abstract String getErrorMessage();
}