/**
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * @author cassie9082
 * 
 */

/*
 * http://blog.csdn.net/lu597203933/article/details/44227431
 * 
 * Insert and search costs O(key_length), however the memory requirements of
 * trie isO(ALPHABET_SIZE * key_length * N) where N is number of keys in trie.
 * There are efficient representation of trie nodes (e.g. compressed trie,
 * ternary search tree, etc.) to minimize memory requirements of trie.
 */
class TrieNode {
	// Initialize your data structure here.
	TrieNode[] children;
	boolean leaf;

	public TrieNode() {
		children = new TrieNode[26];
	}
}

public class ImplementTrie {
	private TrieNode root;

	public ImplementTrie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		TrieNode p = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (p.children[c - 'a'] == null) {
				p.children[c - 'a'] = new TrieNode();
			}

			if (i == word.length() - 1) {
				p.children[c - 'a'].leaf = true;
			}

			p = p.children[c - 'a'];
		}
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode p = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (p.children[c - 'a'] == null) {
				return false;
			}

			p = p.children[c - 'a'];
		}

		if (!p.leaf) {
			return false;
		}
		return true;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		TrieNode p = root;
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if (p.children[c - 'a'] == null) {
				return false;
			}

			p = p.children[c - 'a'];
		}
		return true;
	}
}
