import java.util.*;

class Gkruskal
{
	int V;
	int A[][];
	Gkruskal(int v)
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
	
	void Kruskal()
	{
		int min, u = 0, v = 0, statusu, statusv;
		int min_cost = 0;
		int ne = 0;
		int status[] = new int[V];
		for(int i = 0; i < V; i++)
		{
			status[i] = i;
		}
		while(ne < V - 1)
		{
			min = 999;
			for(int i = 0; i < V; i++)
			{
				for(int j = 0; j < V; j++)
				{
					if(min > A[i][j] && A[i][j] != 0)
					{
						min = A[i][j];
						u = i;
						v = j;
					}
				}
			}
			if(status[u] == status[v])
			{
				A[u][v] = 999;
				A[v][u] = 999;
			}
			else
			{
				statusv = status[v];
				statusu = status[u];
				for(int i = 0; i < V; i++)
				{
					if(status[i] == statusv)
					{
						status[i] = statusu;
					}
				}
				System.out.println(u+","+v);
				ne++;
				min_cost = min_cost + A[u][v];
				A[u][v] = 999;
				A[v][u] = 999;
			}
		}
		System.out.println("Total Cost :"+min_cost);
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of vertices in the graph :");
		int ver = sc.nextInt();
		Gkruskal ob = new Gkruskal(ver);
		System.out.println("Minimum Spanning Tree :");
		ob.Kruskal();
	}
}