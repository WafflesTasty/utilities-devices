package waffles.utils.sys.memory.config;

import waffles.utils.sys.memory.GFXGroup;
import waffles.utils.sys.memory.groups.GFXField;
import waffles.utils.sys.memory.groups.GFXFormat;
import waffles.utils.sys.memory.groups.GFXField.Type;
import waffles.utils.sys.memory.shaders.GFXProgram;
import waffles.utils.sys.memory.shaders.GFXShader;
import waffles.utils.sys.memory.groups.GFXGlobal;

/**
 * The {@code ProgramConfig} manages the creation of various
 * hardware-accelerated objects for a {@code GFXProgram}.
 *
 * @author Waffles
 * @since 14 Mar 2025
 * @version 1.1
 */
public interface ProgramConfig
{
	/**
	 * Creates a new {@code GFXGroup}.
	 * 
	 * @return  a vertex group
	 * 
	 * 
	 * @see GFXGroup
	 */
	public abstract GFXGroup createGroup();

	/**
	 * Creates a new {@code GFXFormat}.
	 * 
	 * @param grp  a data group
	 * @param isInstanced  an instance state
	 * @return  a data format
	 * 
	 * 
	 * @see GFXFormat
	 * @see GFXGroup
	 */
	public abstract GFXFormat createFormat(GFXGroup grp, boolean isInstanced);
	
	/**
	 * Creates a new {@code GFXField}.
	 * 
	 * @param grp   a data group
	 * @param type  a data type
	 * @param dim   a data count
	 * @return  a vertex field
	 * 
	 * 
	 * @see GFXField
	 * @see GFXGroup
	 * @see Type
	 */
	public abstract GFXField<?> createField(GFXGroup grp, Type type, int dim);
	
	/**
	 * Creates a new {@code GFXGlobal} value.
	 * 
	 * @param grp   a data group
	 * @param type  a data type
	 * @param dim   a data count
	 * @return  a global field
	 * 
	 * 
	 * @see GFXGlobal
	 * @see GFXGroup
	 */
	public abstract GFXGlobal<?> createGlobal(GFXGroup grp, Class<?> type, int dim);
	
	/**
	 * Creates a new {@code GFXGlobal} sampler.
	 * 
	 * @param grp  a data group
	 * @param dim  a data count
	 * @param isAtlas  an atlas mode
	 * @return  a global sampler
	 * 
	 * 
	 * @see GFXGlobal
	 */
	public abstract GFXGlobal<?> createSampler(GFXGroup grp, int dim, boolean isAtlas);

	/**
	 * Creates a new {@code GFXShader}.
	 * 
	 * @param type  a shader type
	 * @param src   a source code
	 * @return  a shader stage
	 * 
	 * 
	 * @see GFXShader
	 */
	public abstract GFXShader createShader(GFXShader.Type type, String src);

	/**
	 * Creates a new {@code GFXProgram}.
	 * 
	 * @return  a shader program
	 * 
	 * 
	 * @see GFXProgram
	 */
	public abstract GFXProgram createProgram();
}