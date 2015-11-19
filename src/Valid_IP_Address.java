import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Valid_IP_Address {
	public List<String> restoreIpAddresses(String s) {
		return helper(s,4);
	}
	public List<String> helper(String s, int num){
//		System.out.println(s + " " + num);
		List<String> ret = new ArrayList<String>();
		Collections.sort(ret);
		if(s.length() == 0) return ret;
		else if(s.length() < num) return ret;
		else if(num == 1 && s.length()>3) return ret;
		else if(num == 1 &&( (s.length()<=3 && s.charAt(0) != '0') || (s.length() == 1))){
			if(Integer.parseInt(s) <= 255){
				ret.add(s);
			}
			return ret;
		}else if(num == 1 && s.length()<=3 && s.charAt(0) == '0'){
			return ret;
		}
		
		for(int i = 1; i < 4; i++){
			if(i > s.length()){
				break;
			}
			String s1 = s.substring(0,i);
			if(Integer.parseInt(s1) > 255){
				return ret;
			}
			List<String> list = this.helper(s.substring(i,s.length()), num-1);
			for(String l : list){
				ret.add(s1+"."+l);
			}
			if(s1.equals("0")){
				break;
			}
		}
		return ret;
	}
	public static void main(String[] args){
		Valid_IP_Address via = new Valid_IP_Address();
		List<String> list = via.restoreIpAddresses("172162541");
		for(String s : list){
			System.out.println(s);
		}
	}
}
