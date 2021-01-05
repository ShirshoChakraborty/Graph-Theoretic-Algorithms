import java.util.*;

class Gfloyd
{
	int V;
	int A[][];
	Gfloyd(int v)
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
	
	void Floyd()
	{
		int D[][] = new int[V][V];
		String path[][] = new String[V][V];
		String P,P1,P2;
		for(int i = 0; i < V; i++)
		{
			for(int j = 0; j < V; j++)
			{
				if(A[i][j] == 0)
				{
					D[i][j] = 999;
					path[i][j] = null;
				}
				else
				{
					D[i][j] = A[i][j];
					P = Integer.toString(i)+"-"+Integer.toString(j);
					path[i][j] = P;
				}
			}
		}
		for(int k = 0; k < V; k++)
		{
			for(int i = 0; i < V; i++)
			{
				for(int j = 0; j < V; j++)
				{
					if(D[i][k] + D[k][j] < D[i][j])
					{
						D[i][j] = D[i][k] + D[k][j];
						P1 = path[i][k];
						P2 = path[k][j];
						path[i][j] = P1.substring(0,P1.length()-2)+"-"+P2;
					}
				}
			}
		}
		System.out.println("Distance Matrix :");
		for(int i = 0; i < V; i++)
		{
			for(int j = 0; j < V; j++)
			{
				System.out.print(D[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("Path Matrix :");
		for(int i = 0; i < V; i++)
		{
			for(int j = 0; j < V; j++)
			{
				System.out.printf("%-15s",path[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no. of vertices in the graph :");
		int ver = sc.nextInt();
		Gfloyd ob = new Gfloyd(ver);
		System.out.println("After applying Floyd Algorithm :");
		ob.Floyd();
	}
}