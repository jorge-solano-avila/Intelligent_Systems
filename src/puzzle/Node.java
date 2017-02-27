package puzzle;

public class Node
{
	private byte[][] configuration;
	private int x;
	private int y;
	private int weight;
	
	public int correctDistance( byte tile, int i, int j )
	{
		int size = configuration.length;
		switch( tile )
		{
			case 1:
				return Math.abs( 0 - i ) + Math.abs( 0 - j );
			case 2:
				return Math.abs( 0 - i ) + Math.abs( 1 - j );
			case 3:
				return Math.abs( 0 - i ) + Math.abs( size - 1 - j );
			case 4:
				return Math.abs( 1 - i ) + Math.abs( 0 - j );
			case 5:
				return Math.abs( 1 - i ) + Math.abs( 1 - j );
			case 6:
				return Math.abs( 1 - i ) + Math.abs( size - 1 - j );
			case 7:
				return Math.abs( size - 1 - i ) + Math.abs( 0 - j );
			case 8:
				return Math.abs( size - 1 - i ) + Math.abs( 1 - j );
			case 0:
				return Math.abs( size - 1 - i ) + Math.abs( size - 1 - j );
		}
		
		return 0;
	}
	
	public byte sumCorrectDistances( byte[][] configuration )
	{
		byte sum = 0;
		for( int i = 0; i < configuration.length; ++i )
			for( int j = 0; j < configuration.length; ++j )
			{
				byte tile = configuration[i][j];
				sum += correctDistance( tile, i, j );
			}

		//System.out.println( this.toString() );
		//System.out.println( sum );
		return sum;
	}

	public Node( byte[][] configuration )
	{
		this.configuration = configuration;
	}
	
	public Node( byte[][] configuration, int x, int y )
	{
		this.configuration = configuration;
		this.x = x;
		this.y = y;
		this.weight = sumCorrectDistances( configuration );
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}

	public int getWeight()
	{
		return weight;
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