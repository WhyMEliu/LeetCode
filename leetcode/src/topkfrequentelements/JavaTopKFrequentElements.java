package topkfrequentelements;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;


public class JavaTopKFrequentElements {
	
	public List<Integer> TopKFrequentElements (int[] nums, int k){
		
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int num : nums) {
			if(map.containsKey(num)){
				map.put(num, map.get(num)+1);
			}else{
				map.put(num, 1);
			}
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(
				(a, b) -> map.get(a) - map.get(b)
		);
		for (int key : map.keySet()) {
			if(pq.size() < k){
				pq.add(key);
			}else if(map.get(key) > map.get(pq.peek())){
				pq.remove();
				pq.add(key);
			}
		}
		
		LinkedList<Integer> res = new LinkedList<>();
		while (!pq.isEmpty()) {
			res.add(pq.remove());
		}
		
		return res;
	}
}
