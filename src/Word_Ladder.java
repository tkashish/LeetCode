import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class Word_Ladder {
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		HashMap<String , Integer> map = new HashMap<String, Integer>();
		Iterator<String> it = wordList.iterator();
		while(it.hasNext()){
			String word = it.next();
			map.put(word, -1);
		}
		map.put(beginWord, 1);
		Queue<String> queue = new LinkedList<String>();
		String start = null;
		queue.add(beginWord);
		while(!queue.isEmpty()){
			start = queue.remove();
			if(this.checkSingleTransformation(start, endWord)){
				return map.get(start)+1;
			}
			for(int i = 0; i < start.length(); i++){
				char[] charArray = start.toCharArray();
				for(char c = 'a'; c<='z'; c++){
					charArray[i] = c;
					String newWord = new String(charArray);
					if(wordList.contains(newWord)){
						if(map.get(newWord) < 0){
							if(this.checkSingleTransformation(newWord, endWord)){
								return map.get(start)+2;
							}
							queue.add(newWord);
							map.put(newWord, map.get(start)+1);
						}
					}
				}
			}
		}
		return 0;
	}

	public boolean checkSingleTransformation(String word1, String word2){
		if(word1.equals(word2)) return false;
		int count = 0;
		for(int i = 0; i<word1.length(); i++){
			if(word1.charAt(i) != word2.charAt(i))count++;
			if(count > 1) return false;
		}
		return true;
	}
	public static void main(String[] args){
		Word_Ladder wl = new Word_Ladder();
		Set<String> set = new HashSet<String>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		System.out.println(wl.ladderLength("hit", "cog", set));
		
		Set<String> set1 = new HashSet<String>();
		set1.add("a");
		set1.add("d");
		set1.add("c");
		System.out.println(wl.ladderLength("a", "c", set1));
		
	}
}
/*
 * Iterator<String> it1 = wordList.iterator();
			while(it1.hasNext()){
				String word = it1.next();
				if(map.get(word) < 0){
					if(this.checkSingleTransformation(start, word)){
						if(this.checkSingleTransformation(word, endWord)){
							return map.get(start)+2;
						}
						queue.add(word);
						map.put(word, map.get(start)+1);
						it1.remove();
					}
				}
			}
 */
