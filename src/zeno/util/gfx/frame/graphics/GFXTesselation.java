package zeno.util.gfx.frame.graphics;

import zeno.util.tools.patterns.manipulators.Resettable;

public interface GFXTesselation extends Resettable
{
	public abstract void setPatchCount(int count);
}