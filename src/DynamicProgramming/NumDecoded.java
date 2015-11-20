package DynamicProgramming;

public class NumDecoded {
	public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        int[] array = new int[s.length()+1];
        array[0] = 1;
        if(s.charAt(0) != '0'){
            array[1] = 1;
        }else{
            array[1] = 0;
        }
        for(int i = 2; i < array.length; i++){
            if(s.charAt(i-1) != '0'){
                array[i] += array[i-1];
            }
            int j = Integer.parseInt(s.substring(i-2,i));
            if(j<27 && j>=10){
                array[i] += array[i-2];
            }
        }
        return array[array.length-1];
    }
}
