package implementtrieprefixtree208;

import java.util.TreeMap;

/*实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

示例:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // 返回 true
trie.search("app");     // 返回 false
trie.startsWith("app"); // 返回 true
trie.insert("app");   
trie.search("app");     // 返回 true
说明:

你可以假设所有的输入都是由小写字母 a-z 构成的。
保证所有输入均为非空字符串。*/

public class ImplementTriePrefixTree {
private class Node{
		
		public boolean isWord;
		public TreeMap<Character, Node> next;
		
		public Node(boolean isWord){
			this.isWord = isWord;
			next = new TreeMap<>();
		}
		
		public Node(){
			this(false);
		}
	}
	
	private Node root;
	
	
	public ImplementTriePrefixTree(){
		root = new Node();
	}
	
	/**
	 * 向Tire中添加一个新的单词word
	 * @param word
	 */
	public void add(String word){
		Node cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(cur.next.get(c) == null){
				cur.next.put(c,new Node());
			}
			cur = cur.next.get(c);
		}
		if(!cur.isWord){
			cur.isWord = true;
		}
	}
	
	/**
	 * 查询单词word是否在Trie中
	 * @param word
	 * @return
	 */
	public boolean contains(String word){
		
		Node cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(cur.next.get(c) == null){
				return false;
			}
			cur = cur.next.get(c);
		}
		
		return cur.isWord;
	}
	
	/**
	 * 查询是否在Tire中有单词以prefix为前缀
	 * @param word
	 * @return
	 */
	public boolean isPrefix(String prefix){
		
		Node cur = root;
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if(cur.next.get(c) == null){
				return false;
			}
			cur = cur.next.get(c);
		}
		
		return true;
	}
}
