import java.util.ArrayList;
import java.util.List;


public class FractionalKnapsack {

	public static void main(String[] args) {
		
		double[] w = {60.0,40.0,75.0};
		double[] v = {5.0,3.0,7.0};
		double[] d = new double[w.length];
		
		double W = 150.0;
		
		for(int i=0;i<w.length;i++)
			d[i] = v[i]/w[i];
		
		quickSort(d,w,v,0,w.length-1);
		
		List<String> wts = fillWeight(d, w, v, W);
		for(String s:wts)
		{
			System.out.println(s);
		}
		
		
	}

	private static void quickSort(double d[], double[] w, double[] v, int start, int end) 
	{
		int i=start;
		int j = end;
		double pivot = d[(start+end)/2];
		while(i<=j)
		{
			while(d[i] > pivot  )
			{
				i++;
			}
			
			while(d[j] < pivot)
			{
				j--;
			}
			
			if(i<=j)
			{
				double temp = d[i];
				d[i] = d[j];
				d[j] = temp;
				
				temp = w[i];
				w[i] = w[j];
				w[j] = temp;
				
				temp = v[i];
				v[i] = v[j];
				v[j] = temp;
				
				i++;
				j--;
				
				
			}
			
			
		}
		if(start < i-1)
			quickSort(d, w, v, start, i-1);
		if(end > i)
			quickSort(d, w, v, i, end);

		
	}
	
	
	private static List<String> fillWeight(double[] d, double[] w, double[] v, double W)
	{
		List<String> weights = new ArrayList<String>();
		int i=0;
		while(W>0)
		{
			if(w[i] < W)
			{
				weights.add(""+w[i]);
			}
			else
			{
				weights.add(W+"/"+w[i]+"th fraction of "+w[i]);
			}
			
			W-=w[i];
			i++;
		}
		return weights;
	}

	

}
