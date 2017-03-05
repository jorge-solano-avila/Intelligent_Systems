package puzzle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Searches
{
	public static int totalNodes;
	public static int totalNodesInStructure;

	public static void bfs( HashMap<Node, HashMap<Node, Byte>> tree, Node root, Node goal )
	{
		totalNodes = 0;
		totalNodesInStructure = 0;
		//System.out.println( "BFS" );
		ArrayList<Node> queue = new ArrayList<>();

		queue.add( root );
		while( !queue.isEmpty() )
		{
			if( queue.size() > totalNodesInStructure )
				totalNodesInStructure = queue.size();
			Node node = queue.remove( 0 );
			totalNodes++;
			if( node.toString().equals( goal.toString() ) )
			{
				//printPath( node );
				break;
			}
			if( tree.containsKey( node ) )
				for( Node children: tree.get( node ).keySet() )
					queue.add( children );
		}
	}
	
	public static void dfs( HashMap<Node, HashMap<Node, Byte>> tree, Node root, Node goal )
	{
		totalNodes = 0;
		totalNodesInStructure = 0;
		//System.out.println( "DFS" );
		ArrayList<Node> stack = new ArrayList<>();

		stack.add( root );
		while( !stack.isEmpty() )
		{
			if( stack.size() > totalNodesInStructure )
				totalNodesInStructure = stack.size();
			Node node = stack.remove( stack.size() - 1 );
			totalNodes++;
			if( node.toString().equals( goal.toString() ) )
			{
				//printPath( node );
				break;
			}
			if( tree.containsKey( node ) )
				for( Node children: tree.get( node ).keySet() )
					stack.add( children );
		}
	}
	
	public static void iterativeDFS( HashMap<Node, HashMap<Node, Byte>> tree, HashMap<Node, Integer> depths, Node root, Node goal )
	{
		totalNodes = 0;
		totalNodesInStructure = 0;
		//System.out.println( "Iterative DFS" );
		ArrayList<Node> stack = new ArrayList<>();

		for( int i = 0; i < 11; ++i )
		{
			totalNodes = 0;
			//System.out.println( "Limit " + i );
			stack.add( root );
			while( !stack.isEmpty() )
			{
				if( stack.size() > totalNodesInStructure )
					totalNodesInStructure = stack.size();
				Node node = stack.remove( stack.size() - 1 );
				if( depths.get( node ) == i + 1 )
					continue;
				else if( depths.get( node ) == i + 2 )
					break;
				totalNodes++;
				if( node.toString().equals( goal.toString() ) )
				{
					//printPath( node );
					break;
				}
				if( tree.containsKey( node ) )
					for( Node children: tree.get( node ).keySet() )
						stack.add( children );
			}
		}
	}

	public static void manhattanHeuristic( HashMap<Node, HashMap<Node, Byte>> tree, Node root, Node goal )
	{
		totalNodes = 0;
		totalNodesInStructure = 0;
		//System.out.println( "Manhattan heuristic" );
		PriorityQueue<Node> queue = new PriorityQueue<>( 1, new Comparator<Node>()
		{
			public int compare( Node node1, Node node2 )
			{
				if( node1.getManhattanDistance() < node2.getManhattanDistance() )
					return -1;
				if( node1.getManhattanDistance() > node2.getManhattanDistance() )
					return 1;
				return 0;
		    }
		} );

		queue.add( root );
		while( !queue.isEmpty() )
		{
			if( queue.size() > totalNodesInStructure )
				totalNodesInStructure = queue.size();
			Node node = queue.poll();
			totalNodes++;
			if( node.toString().equals( goal.toString() ) )
			{
				//printPath( node );
				break;
			}
			if( tree.containsKey( node ) )
				for( Node children: tree.get( node ).keySet() )
					queue.add( children );
		}
	}
	
	public static void childrenHeuristic( HashMap<Node, HashMap<Node, Byte>> tree, Node root, Node goal )
	{
		totalNodes = 0;
		totalNodesInStructure = 0;
		//System.out.println( "Children heuristic" );
		PriorityQueue<Node> queue = new PriorityQueue<>( 1, new Comparator<Node>()
		{
			public int compare( Node node1, Node node2 )
			{
				if( node1.getChildrenDistance() < node2.getChildrenDistance() )
					return -1;
				if( node1.getChildrenDistance() > node2.getChildrenDistance() )
					return 1;
				return 0;
		    }
		} );

		queue.add( root );
		while( !queue.isEmpty() )
		{
			if( queue.size() > totalNodesInStructure )
				totalNodesInStructure = queue.size();
			Node node = queue.poll();
			totalNodes++;
			if( node.toString().equals( goal.toString() ) )
			{
				//printPath( node );
				break;
			}
			if( tree.containsKey( node ) )
				for( Node children: tree.get( node ).keySet() )
					queue.add( children );
		}
	}
	
	public static void printPath( Node goal )
	{
		Node aux = goal;
		ArrayList<Node> path = new ArrayList<>(); 
		while( true )
		{
			path.add( aux );
			if( aux.getParent() == null )
				break;
			aux = aux.getParent();
		}
		for( int i = path.size() - 1; i >= 0; --i )
			System.out.println( path.get( i ) );
	}
}