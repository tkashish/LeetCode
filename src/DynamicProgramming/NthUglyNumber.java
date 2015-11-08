package DynamicProgramming;
//http://www.geeksforgeeks.org/ugly-numbers/
public class NthUglyNumber {
	public int ugly(int n){
		int[] ugly = new int[n];
		ugly[0] = 1;
		for(int i = 1; i < n; i++){
			int nextMax = ugly[i-1]*ugly(2);
			for(int j = i-2; j >= 0; j--){
				for(int k = 1; k < j; k++){
					if(ugly[j]*ugly[k] > nextMax){
						break;
					}else if(ugly[j]*ugly[k] < nextMax && ugly[j]*ugly[k] > ugly[i-1]){
						nextMax = ugly[j]*ugly[k];
						break;
					}
				}
			}
			ugly[i] = nextMax;
		}
		return ugly[n-1];
	}
	public int ugly1(int n){
		int[] ugly = new int[n];
		ugly[0] = 1;
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;
		for(int i = 1; i < n; i++){
//			int nextMax = Math.min(2*ugly[i2], Math.min(3*ugly[i3], 5*ugly[i5]));
			int m2 = 2*ugly[i2]; int m3 = 3*ugly[i3]; int m5 = 5*ugly[i5];
			if(m2 < m3 && m2 < m5){
				ugly[i] = m2;
				i2++;
			}else if(m3 < m2 && m3 < m5){
				ugly[i] = m3;
				i3++;
			}else{
				ugly[i] = m5;
				i5++;
			}
		}
		return ugly[n-1];
	}
	
}

