package waffles.utils.sys.utilities.scripts.vars.params;

import waffles.utils.sys.memory.groups.GFXGlobal;
import waffles.utils.sys.memory.groups.GFXValue;
import waffles.utils.sys.memory.shaders.GFXShader.Type;
import waffles.utils.sys.utilities.scripts.vars.Parameter;
import waffles.utils.tools.patterns.semantics.Countable;

/**
 * A {@code Uniform} defines a global as a {@code Parameter} for shaders.
 *
 * @author Waffles
 * @since 08 Jun 2025
 * @version 1.1
 *
 * 
 * @see Countable
 * @see Parameter
 */
public class Uniform extends Parameter.Base implements Countable
{	
	/**
	 * Creates a new {@code Uniform}.
	 * 
	 * @param g  a uniform global
	 * @param l  a uniform label
	 * 
	 * 
	 * @see GFXGlobal
	 */
	public Uniform(GFXGlobal<?> g, String l)
	{
		super(g, l);
	}

	
	@Override
	public String define(Type type)
	{
		String array = "";
		if(Field().Count() > 1)
		{
			array = "[" + Field().Count() + "]";
		}
		
		String binding = "location";
		if(Field().Type() == GFXValue.Type.SAMPLER)
		{
			binding = "binding";
		}

		String src = "\r\n";
		src += "layout(" + binding + " = " + Field().ID() + ")" + "\r\n";
		src += "uniform " + Field() + " " + Label() + array + ";" + "\r\n";
		return src;
	}
	
	@Override
	public GFXGlobal<?> Field()
	{
		return (GFXGlobal<?>) super.Field();
	}

	@Override
	public String Label()
	{
		return "u_" + super.Label();
	}
	
	@Override
	public int Count()
	{
		return Field().Count();
	}
}