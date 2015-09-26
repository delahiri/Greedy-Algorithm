import java.util.ArrayList;
import java.util.List;


public class ActivitySelection {

	public static void main(String[] args) {
		int s[] = {1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12};
		int f[] = {4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16};
		List<Integer> activities = new ArrayList<Integer>();
		int maxTillNow = 0;
		
		
		for(int i=0; i < s.length;i++)
		{
			if(s[i]>=maxTillNow)
			{
				activities.add(i);
				maxTillNow = f[i];
			}
			
		}
		for(int p: activities)
		{
			System.out.println(p+1+",");
		}
	}

}
