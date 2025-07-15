package waffles.utils.sys.utilities.scripts.vars;

import waffles.utils.sys.memory.groups.GFXField;
import waffles.utils.sys.memory.shaders.GFXShader;
import waffles.utils.sys.memory.shaders.GFXShader.Type;
import waffles.utils.sys.utilities.scripts.Allocation;
import waffles.utils.sys.utilities.scripts.vars.params.Inlet;
import waffles.utils.sys.utilities.scripts.vars.params.Outlet;

/**
 * A {@code Couple} defines a {@code GFXField} coupled across multiple shader stages.
 *
 * @author Waffles
 * @since 30 Jun 2025
 * @version 1.1
 *
 * 
 * @see Allocation
 */
public class Couple extends Allocation.Base
{	
	private int[] index;
	private boolean isPerPatch;
	
	/**
	 * Creates a new {@code Couple}.
	 * 
	 * @param f  a parameter field
	 * @param l  a parameter label
	 * @param i  a parameter index
	 * 
	 * 
	 * @see GFXField
	 */
	public Couple(GFXField<?> f, String l, int[] i)
	{
		super(f, l);
		index = i;
	}
	
	/**
	 * Constructs a connect string for the {@code Couple}.
	 * 
	 * @param type  a shader type
	 * @param o  an output type
	 * @param i  an input type
	 * @return  a connection string
	 */
	public String connect(Type type, int o, int i)
	{
		Inlet input = input(type);
		Outlet output = output(type);
		String src = output.Label();

		
		if(o >= 0)
			src += "[" + o + "]";
		else if(type == Type.TES_CONTROL
		&& !isPerPatch())
			src += "[gl_InvocationID]";

		src += " = " + input.Label();
		
		if(i >= 0)
			src += "[" + i + "]";
		else if(type == Type.TES_CONTROL)
			src += "[gl_InvocationID]";
		
		return src;
	}

	/**
	 * Changes the per patch mode of the {@code Couple}.
	 * 
	 * @param perPatch  a patch mode
	 */
	public void setPatchMode(boolean perPatch)
	{
		isPerPatch = perPatch;
	}
	
	/**
	 * Constructs a connection for the {@code Couple}.
	 * 
	 * @param type  a shader type
	 * @return  a connection string
	 */
	public String connect(Type type)
	{
		return connect(type, -1, -1);
	}
	
	
	/**
	 * Returns the patch of the {@code Couple}.
	 * 
	 * @return  a patch mode
	 */
	public boolean isPerPatch()
	{
		return isPerPatch;
	}
	
	/**
	 * Returns an input from the {@code Couple}.
	 * 
	 * @param type  a shader type
	 * @return  an input binding
	 * 
	 * 
	 * @see Inlet
	 */
	public Inlet input(Type type)
	{
		Inlet in = new Inlet(Field(), Label(), index(type));
		in.setPerPatch(isPerPatch());
		return in;
	}
	
	/**
	 * Returns an output from the {@code Couple}.
	 * 
	 * @param type  a shader type
	 * @return  an output binding
	 * 
	 * 
	 * @see Outlet
	 */
	public Outlet output(Type type)
	{
		Outlet out = new Outlet(Field(), Label(), index(type.next()));
		out.setPerPatch(isPerPatch());
		return out;
	}
		
	/**
	 * Returns an index for the {@code Couple}.
	 * 
	 * @param type  a shader type
	 * @return  a location index
	 * 
	 * 
	 * @see GFXShader
	 */
	public int index(Type type)
	{
		if(type == null)
			return -1;
		
		switch(type)
		{
		case VERTEX:
			return Field().ID();
		case TES_CONTROL:
			return index[0];
		case TES_EVAL:
			return index[1];
		case GEOMETRY:
			return index[2];
		case FRAGMENT:
			return index[3];
		case COMPUTE:
		default:
			return -1;
		}
	}
		
	
	@Override
	public GFXField<?> Field()
	{
		return (GFXField<?>) super.Field();
	}
}