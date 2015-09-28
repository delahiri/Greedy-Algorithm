import java.util.ArrayList;
import java.util.List;


public class MinimumStopsAtGasStations {

	public static void main(String[] args) {
		int d[] = {20,70,80,100,140,190,250};
		int m=50;
		int canTravelUpto = m;
		List<Integer> stopAt = new ArrayList<Integer>();
		for(int i=0;i<d.length-1;i++)
		{
			if(d[i] <= canTravelUpto && d[i+1]>canTravelUpto)
			{
				stopAt.add(i+1);
				canTravelUpto = d[i]+m;
			}
		}
		for(int n:stopAt) 
		System.out.println(n);
		
		
		
	}

}
