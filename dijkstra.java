import java.util.*;

class Gdijkstra
{
	int V;
	int A[][];
	Gdijkstra(int v)
	{
		Scanner sc = new Scanner(System.in);
		V = v;
		A = new int[v][v];
		System.out.println("Enter the graph in the form of adjacency matrix :");
		for(int i = 0; i < v; i++)
		{
			for(int j = 0; j < v; j++)
			{
				A[i][j] = sc.nextInt();
			}
		}
	}
	
	
	void Dijkstra(int vstart, int vend)
	{
		int j = 0, min, temp;
		int status[] = new int[V];
		int Length[] = new int[V];
		String path[] = new String[V];
		for(int i = 0; i < V; i++)
		{
			status[i] = 0;
		}
		for(int i = 0; i < V; i++)
		{
			if(A[vstart][i] == 0)
			{
				Length[i] = 999;
				path[i] = null;
			}
			else
			{
				Length[i] = A[vstart][i];
				path[i] = Integer.toString(vstart);
			}
		}
		status[vstart] = 1;
		Length[vstart] = 0;
		boolean complete = false;
		while(complete == false)
		{
			min = 999;
			for(int i = 0; i < V; i++)
			{
				if(status[i] == 0)
				{
					if(min > Length[i])
					{
						min = Length[i];
						j = i;
					}
				}
			}
			status[j] = 1;
			for(int i = 0; i < V; i++)
			{
				if(status[i] == 1)
					i = i + 1;
				else
				{
					if(A[i][j] != 0)
					{
						if(Length[j] + A[i][j] < Length[i])
						{
							Length[i] = Length[j] + A[i][j];
							path[i] = Integer.toString(j);
						}
					}
				}
			}
			complete = true;
			for(int i = 0; i < V; i++)
			{
				if(status[i] == 0)
				{
					complete = false;
					break;
				}
				else
					i = i + 1;
			}
		}
		System.out.print("Distance set from the starting vertex :");
		for(int i = 0; i < V; i++)
			System.out.printf("%15d",Length[i]);
		System.out.println();
		System.out.print("Path set from the starting vertex :");
		for(int i = 0; i < V; i++)
			System.out.printf("%15s",path[i]);
		System.out.println();
		System.out.println("The Shortest Path from the source to the destination is :");
		System.out.print(vend);
		temp = vend;
		while(temp != vstart)
		{
			System.out.print("<-"+path[temp]);
			temp = Integer.parseInt(path[temp]);
		}
		System.out.println();
		System.out.println("Distance from the source to the destination is :"+Length[vend]);
	}
	
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no. of vertices in the graph :");
		int ver = sc.nextInt();
		Gdijkstra ob = new Gdijkstra(ver);
		System.out.println("Enter the source vertex :");
		int source = sc.nextInt();
		System.out.println("Enter the destination vertex :");
		int destination = sc.nextInt();
		System.out.println("After applying Dijkstra Algorithm :");
		ob.Dijkstra(source,destination);
	}
}