import java.util.*;

class Gprims
{
	int V;
	int A[][];
	Gprims(int v)
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
	
	void Prims(int vstart)
	{
		int min_cost = 0;
		int ne = 0;
		int min, u = 0, v = 0;
		int status[] = new int[V];
		for(int i = 0; i < V; i++)
		{
			status[i] = 0;
		}
		status[vstart] = 1;
		while(ne < V - 1)
		{
			min = 999;
			for(int i = 0; i < V; i++)
			{
				for(int j = 0; j < V; j++)
				{
					if(status[i] == 1 && status[j] == 0)
					{
						if(min > A[i][j] && A[i][j] != 0)
						{
							min = A[i][j];
							u = i;
							v = j;
						}
					}
				}
			}
			System.out.println(u+","+v);
			ne++;
			min_cost = min_cost + A[u][v];
			A[u][v] = 999;
			A[v][u] = 999;
			status[v] = 1;
		}
		System.out.println("Total Cost :"+min_cost);
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of vertices in the graph :");
		int ver = sc.nextInt();
		Gprims ob = new Gprims(ver);
		System.out.println("Enter the source vertex :");
		int source = sc.nextInt();
		System.out.println("Minimum Spanning Tree :");
		ob.Prims(source);
	}
}