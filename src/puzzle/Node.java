package puzzle;

public class Node
{
	private byte[][] configuration;
	private int x;
	private int y;
	private int manhattanDistance;
	private int childrenDistance;
	
	private int correctDistance( byte tile, int i, int j )
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
	
	private byte sumCorrectDistances()
	{
		byte sum = 0;
		for( int i = 0; i < configuration.length; ++i )
			for( int j = 0; j < configuration.length; ++j )
			{
				byte tile = configuration[i][j];
				sum += correctDistance( tile, i, j );
			}

		return sum;
	}
	
	private int correctTile( byte tile, int i, int j )
	{
		int size = configuration.length;
		switch( tile )
		{
			case 1:
				return ( i == 0 && j == 0 )? 1: 0;
			case 2:
				return ( i == 0 && j == 1 )? 1: 0;
			case 3:
				return ( i == 0 && j == size - 1 )? 1: 0;
			case 4:
				return ( i == 1 && j == 0 )? 1: 0;
			case 5:
				return ( i == 1 && j == 1 )? 1: 0;
			case 6:
				return ( i == 1 && j == size - 1 )? 1: 0;
			case 7:
				return ( i == size - 1 && j == 0 )? 1: 0;
			case 8:
				return ( i == size - 1 && j == 1 )? 1: 0;
			case 0:
				return ( i == size - 1 && j == size - 1 )? 1: 0;
		}
		
		return 0;
	}
	
	private byte sumCorrectTiles()
	{
		byte sum = 0;
		for( int i = 0; i < configuration.length; ++i )
			for( int j = 0; j < configuration.length; ++j )
			{
				byte tile = configuration[i][j];
				sum += correctTile( tile, i, j );
			}

		return sum;
	}

	public Node( byte[][] configuration )
	{
		this.configuration = configuration;
	}
	
	public Node( byte[][] configuration, int x, int y, int weight )
	{
		this.configuration = configuration;
		this.x = x;
		this.y = y;
		this.manhattanDistance = sumCorrectDistances() + weight;
		this.childrenDistance = sumCorrectTiles() + weight;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}

	public int getManhattanDistance()
	{
		return manhattanDistance;
	}
	
	public int getChildrenDistance()
	{
		return childrenDistance;
	}
	
	public byte[][] getConfiguration()
	{
		return configuration;
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