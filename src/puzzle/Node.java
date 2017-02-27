package puzzle;
public class Node
{
	private byte[][] configuration;
	private int x;
	private int y;	

	public Node( byte[][] configuration )
	{
		this.configuration = configuration;
	}
	
	public Node( byte[][] configuration, int x, int y )
	{
		this.configuration = configuration;
		this.x = x;
		this.y = y;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}

	@Override
	public String toString()
	{
		StringBuilder values = new StringBuilder();
		for( int i = 0; i < configuration.length; ++i )
			for( int j = 0; j < configuration.length; ++j )
				if( i == configuration.length - 1 && j == configuration.length - 1 )
					values.append( new Byte( configuration[i][j] ).toString() );
				else
					values.append( new Byte( configuration[i][j] ).toString() + "-" );
		return values.toString();
	}
}