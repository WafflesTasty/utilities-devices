package waffles.utils.sys.utilities.scripts.vars.params;

import waffles.utils.sys.memory.groups.GFXField;
import waffles.utils.sys.memory.groups.GFXValue;
import waffles.utils.sys.memory.shaders.GFXShader.Type;
import waffles.utils.sys.utilities.scripts.vars.Variable.Binding;

/**
 * An {@code Inlet} defines a {@code GFXField} as an input {@code Binding}.
 *
 * @author Waffles
 * @since 09 Jun 2025
 * @version 1.1
 *
 * 
 * @see Binding
 */
public class Inlet extends Binding
{
	private boolean perPatch;
	
	/**
	 * Creates a new {@code Inlet}.
	 * No index is needed for the
	 * vertex shader stage.
	 * 
	 * @param f  a binding field
	 * @param l  a binding label
	 * 
	 * 
	 * @see GFXField
	 */
	public Inlet(GFXField<?> f, String l)
	{
		this(f, l, f.ID());
	}
	
	/**
	 * Creates a new {@code Inlet}.
	 * 
	 * @param v  a binding value
	 * @param l  a binding label
	 * @param i  a binding index
	 * 
	 * 
	 * @see GFXValue
	 */
	public Inlet(GFXValue<?> v, String l, int i)
	{
		super(v, l, i);
		perPatch = false;
	}
	
	/**
	 * Changes the patch mode of the {@code Inlet}.
	 * 
	 * @param patch  a per-patch mode
	 */
	public void setPerPatch(boolean patch)
	{
		perPatch = patch;
	}
	
	/**
	 * Returns the patch mode of the {@code Inlet}.
	 * 
	 * @return  a per-patch mode
	 */
	public boolean isPerPatch()
	{
		return perPatch;
	}
	
	
	@Override
	public String define(Type type)
	{
		String src = "\r\n";
		src += "in " + Field() + " " + Label();
		switch(type)
		{
		case TES_CONTROL:
		case GEOMETRY:
		{
			src += "[]";
			break;
		}
		case TES_EVAL:
		{
			if(isPerPatch())
				src = "patch " + src;
			else
				src += "[]";
			break;
		}
		case VERTEX:
		case FRAGMENT:
		case COMPUTE:
		default:
			break;
		
		}
		
		src += ";" + "\r\n";
		return super.define(type) + src;
	}
	
	@Override
	public String Label()
	{
		return "i_" + super.Label();
	}
}