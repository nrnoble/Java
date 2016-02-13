package nrnoble;

public class Vars
{
	public final int a;
	public final int b;
	public final int c;
	public final int d;
	public final int r1_Numerator ;
	public final int r1_Demonator;
	public final String callingMethod;

	public Vars(int _a, int _b, int _c, int _d, int _r1_Numerator, int _r1_demonator, String _callingMethod)
	{
		super();
		this.a = _a;
		this.b = _b;
		this.c = _c;
		this.d = _d;
		this.r1_Numerator = _r1_Numerator;
		this.r1_Demonator = _r1_demonator;
		this.callingMethod = _callingMethod;
	}



	@Override
	public String toString()
	{
		return "Vars []";
	}

}
