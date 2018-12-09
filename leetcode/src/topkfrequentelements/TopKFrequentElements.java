package topkfrequentelements;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/*
347:
 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]
说明：

你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。*/

public class TopKFrequentElements  {
	private interface Queue<E> {
	    int getSize();

	    boolean isEmpty();

	    void enqueue(E e);

	    E dequeue();

	    E getFront();
	}
	
	private class Array<E> {
	    //数组
	    private E[] data;
	    //下标，数组的真实数量
	    private int size;

	    /**
	     * 构造函数，传入数组容量capacity构造Array
	     *
	     * @param capacity
	     */
	    public Array(int capacity) {
	        data = (E[])new Object[capacity];
	        size = 0;
	    }

	    public Array(E[] arr){
	    	
	    	data = (E[])new Object[arr.length];
	    	for (int i = 0; i < arr.length; i++) {
				data[i] = arr[i];
			}
	    	size = data.length;
	    }
	    /**
	     * 无参构造函数，默认容量为10
	     */
	    public Array() {
	        this(10);
	    }

	    /**
	     * 获取数组中的元素个数
	     *
	     * @return
	     */
	    public int getSize() {
	        return size;
	    }

	    /**
	     * 获取数组容量
	     *
	     * @return
	     */
	    public int getCapacity() {
	        return data.length;
	    }

	    /**
	     * 返回数组是是否为空
	     *
	     * @return
	     */
	    public boolean isEmpty() {
	        return size == 0;
	    }

	    /**
	     * 向所有元素后添加一个新元素
	     *
	     * @param e
	     */
	    public void addLast(E e) {
			/*if(size==data.length){
				throw new IllegalArgumentException("超出数组容量~");
			}
			data[size] = e;
			size++;*/
	        add(size, e);
	    }

	    /**
	     * 在所有元素前添加一个新元素
	     *
	     * @param e
	     */
	    public void addFirst(E e) {
	        add(0, e);
	    }


	    /**
	     * 在第index个位置插入一个新元素e
	     *
	     * @param index
	     * @param e
	     */
	    public void add(int index, E e) {
	        if (index < 0 || index > size) {
	            throw new IllegalArgumentException("超出数组容量~ index >= 0|| index <= size");
	        }

	        if (size == data.length) {
	            //throw new IllegalArgumentException("超出数组容量~");
	            resize(2 * data.length);
	        }

	        for (int i = size - 1; i >= index; i--) {
	            data[i + 1] = data[i];
	        }
	        data[index] = e;
	        size++;
	    }

	    /**
	     * 获取index索引的位置元素
	     * @param index
	     * @return
	     */
	    public E get(int index){
	        if (index<0||index>=size){
	            throw new IllegalArgumentException("Get failed . index is illegal");
	        }
	        return data[index];
	    }

	    public E getLast(){
	        return get(size-1);
	    }

	    public E getFirst(){
	        return get(0);
	    }

	    /**
	     * 修改index索引的位置元素为e
	     * @param index
	     * @param e
	     */
	    public void set(int index , E e){
	        if (index<0||index>=size){
	            throw new IllegalArgumentException("Get failed . index is illegal");
	        }
	        data[index]=e;
	    }

	    /**
	     * 查找数组中是否有元素e
	     * @param e
	     * @return
	     */
	    public boolean contains (E e){
	        for (int i= 0; i<size; i++){
	            if(data[i].equals(e)){
	                return true;
	            }
	        }
	        return false;
	    }

	    /**
	     * 查找数组中元素e的索引，如果不存在元素e，则返回-1
	     * @param e
	     * @return
	     */
	    public int find (E e){
	        for (int i= 0; i<size; i++){
	            if(data[i].equals(e)){
	                return i;
	            }
	        }
	        return -1;
	    }

	    /**
	     * 从数组中删除index位置的元素，返回删除的元素
	     * @param index
	     * @return
	     */
	    public E remove (int index){
	        if (index<0||index>=size){
	            throw new IllegalArgumentException("remove failed . index is illegal");
	        }
	        E ret = data[index];
	        for (int i = index + 1; i < size ; i++){
	            data[i-1]=data[i];
	        }
	        size--;
	        data[size]=null;
	        if(size<=data.length/4 && data.length/2!=0){
	            resize(data.length/2);
	        }
	        return ret;
	    }

	    /**
	     * 从数组中删除第一个元素，返回删除的元素
	     * @return
	     */
	    public E removeFirst(){
	        return remove(0);
	    }

	    /**
	     * 从数组中删除最后一个元素，返回删除的元素
	     * @return
	     */
	    public E removeLast(){
	        return remove(size-1);
	    }

	    /**
	     * 从数组删除元素e
	     * @param e
	     */
	    public void removeElement (E e){
	        int index = find(e);
	        if (index!=-1){
	            remove(index);
	        }
	    }


	    private void resize(int newCapacity){
	        E[] newdata = (E[]) new Object[newCapacity];
	        for (int i=0; i<size ; i++){
	            newdata[i]=data[i];
	        }
	        data=newdata;

	    }

	    public void swap(int i,int j){
	    	
	    	if(i < 0 || i >= size || j < 0 || j >= size ){
	    		throw new IllegalArgumentException("Index is illegal");
	    	}
	    	
	    	E t = data[i];
	    	data[i] = data[j];
	    	data[j] = t;
	    }
	    
	    @Override
	    public String toString (){
	        StringBuilder res =new StringBuilder();
	        res.append(String.format("Array: size = %d , capacity = %d\n",size,data.length));
	        res.append('[');
	        for (int i = 0; i <size ; i++) {
	            res.append(data[i]);
	            if(i != size -1){
	                res.append(",");
	            }else {
	                res.append(']');
	            }
	        }
	        return res.toString();
	    }
	}
	
	private class MaxHeap<E extends Comparable<E>> {
		private Array<E> data;
		
		public MaxHeap(int capactiy){
			data = new Array<E>(capactiy);
		}
		
		public MaxHeap(){
			data = new Array<>();
		}
		
		public MaxHeap(E[] arr){
			data = new Array<>(arr);
			for (int i = parent(data.getSize() - 1); i >= 0; i--) {
				siftDown(i);
			}
		}
		
		//返回堆中的元素个数
		public int size(){
			return data.getSize();
		}
		
		//返回一个布尔值，表示堆中是否为空
		public boolean isEmpty(){
			return data.isEmpty();
		}
		
		/**
		 * 返回完全二叉树数组表示中，一个索引所表示的元素的父亲节点的索引
		 * @param index
		 * @return
		 */
		private int parent(int index){
			if(index == 0){
				throw new IllegalArgumentException("index-0 not have parent.");
			}
			return (index-1)/2;
		}
		
		/**
		 * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
		 * @param index
		 * @return
		 */
		private int leftChild(int index){
			return index * 2 + 1;
		}
		
		/**
		 * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
		 * @param index
		 * @return
		 */
		private int rightChild(int index){
			return index * 2 + 2;
		}
		/**
		 * 向堆中添加元素
		 * @param e
		 */
		public void add(E e){
			data.addLast(e);
			siftUp(data.getSize()-1);
		}
		
		/**
		 * 上浮
		 * @param k
		 */
		private void siftUp(int k){
			while(k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
				data.swap(k, parent(k));
				k = parent(k);
			}
		}
		/**
		 * 查看堆中最大的元素
		 * @return
		 */
		public E findMax(){
			if(data.getSize() == 0){
				throw new IllegalArgumentException("Can not findMax when heap is emtpy~");
			}
			return data.get(0);
		}
		
		/**
		 * 取出堆中最大元素
		 * @return
		 */
		public E extractMax(){
			
			E ret = findMax();
			
			data.swap(0, data.getSize()-1);
			data.removeLast();
			siftDown(0);
			return ret;
		}
		
		private void siftDown(int k){
			
			while (leftChild(k) < data.getSize()) {
				int j = leftChild(k);
				if(j + 1 < data.getSize() && 
						data.get(j + 1).compareTo(data.get(j)) > 0){
					j =rightChild(k);
				}
				//data[j] 是左右孩子的最大值
				if(data.get(k).compareTo(data.get(j)) >= 0){
					break;
				}
				data.swap(k, j);
				k = j;
			}
		}
		
		/**
		 * 取出堆中的最大元素，并且替换成元素e 
		 * @param e
		 * @return
		 */
		public E replace(E e){
			
			E ret = findMax();
			data.set(0, e);
			siftDown(0);
			return ret;
		}
		
	}
	
	private class PriorityQueues<E extends Comparable<E>> implements Queue<E> {

		private MaxHeap<E> maxHeap;
		
		private PriorityQueues(){
			maxHeap = new MaxHeap<>();
		}
		
		@Override
		public int getSize() {
			return maxHeap.size();
		}

		@Override
		public boolean isEmpty() {
			return maxHeap.isEmpty();
		}

		@Override
		public void enqueue(E e) {
			maxHeap.add(e);
		}

		@Override
		public E dequeue() {
			return maxHeap.extractMax();
		}

		@Override
		public E getFront() {
			return maxHeap.findMax();
		}
	
	}

	private class Freq implements Comparable<Freq>{
		public int e, freq;
		
		public Freq(int e, int freq){
			this.e = e;
			this.freq = freq;
		}
		
		@Override
		public int compareTo(Freq another) {
			if(this.freq < another.freq){
				return 1;
			}else if(this.freq > another.freq){
				return -1;
			}else{
				return 0;
			}
		}
	}
	
	public List<Integer> TopKFrequentElements (int[] nums, int k){
		
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int num : nums) {
			if(map.containsKey(num)){
				map.put(num, map.get(num)+1);
			}else{
				map.put(num, 1);
			}
		}
		
		PriorityQueues<Freq> pq = new PriorityQueues<>();
		for (int key : map.keySet()) {
			if(pq.getSize() < k){
				pq.enqueue(new Freq(key, map.get(key)));
			}else if(map.get(key) > pq.getFront().freq){
				pq.dequeue();
				pq.enqueue(new Freq(key, map.get(key)));
			}
		}
		
		LinkedList<Integer> res = new LinkedList<>();
		while (!pq.isEmpty()) {
			res.add(pq.dequeue().e);
		}
		
		return res;
	}
	
	
}
