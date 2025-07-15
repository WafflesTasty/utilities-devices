package waffles.utils.sys.utilities.scripts.vars.params;

import waffles.utils.sys.memory.groups.GFXValue;
import waffles.utils.sys.memory.shaders.GFXShader.Type;
import waffles.utils.sys.utilities.scripts.vars.Variable.Binding;
import waffles.utils.sys.utilities.scripts.vars.ValueType;

/**
 * An {@code Outlet} defines a {@code ValueType} as an output {@code Binding}.
 *
 * @author Waffles
 * @since 09 Jun 2025
 * @version 1.1
 *
 * 
 * @see Binding
 */
public class Outlet extends Binding
{
	private boolean perPatch;
	
	/**
	 * Creates a new {@code Outlet}.
	 * No index is needed for the
	 * fragment shader stage.
	 * 
	 * @param v  a binding value
	 * @param l  a binding label
	 * 
	 * 
	 * @see ValueType
	 */
	public Outlet(ValueType v, String l)
	{
		this(v, l, -1);
	}
	
	/**
	 * Creates a new {@code Outlet}.
	 * 
	 * @param v  a binding value
	 * @param l  a binding label
	 * @param i  a binding index
	 * 
	 * 
	 * @see GFXValue
	 */
	public Outlet(ValueType v, String l, int i)
	{
		super(v, l, i);
		perPatch = false;
	}
	
	/**
	 * Changes the patch mode of the {@code Outlet}.
	 * 
	 * @param patch  a per-patch mode
	 */
	public void setPerPatch(boolean patch)
	{
		perPatch = patch;
	}
	
	/**
	 * Returns the patch mode of the {@code Outlet}.
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
		src += "out " + Field() + " " + Label();
		Type next = type.next();
		if(next == null)
		{
			src += ";" + "\r\n";
			return src;
		}
		
		
		switch(type)
		{
		case TES_CONTROL:
		{
			if(isPerPatch())
				src = "patch " + src;
			else
				src += "[]";
			break;
		}
		case VERTEX:
		case TES_EVAL:
		case GEOMETRY:
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
		return "o_" + super.Label();
	}
}