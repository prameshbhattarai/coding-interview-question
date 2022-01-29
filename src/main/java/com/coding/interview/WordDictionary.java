package com.coding.interview;

/**
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 *
 * Implement the WordDictionary class:
 *
 * WordDictionary() Initializes the object.
 * void addWord(word) Adds word to the data structure, it can be matched later.
 * bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 *
 * Input
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * Output
 * [null,null,null,null,false,true,true,true]
 */
public class WordDictionary {

    private final TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void add(String word) {
        add(word.toCharArray(), 0, root);
    }

    public void add(char[] chars, int index, TrieNode currentNode) {
        char c = chars[index];
        int idx = c - 'a';

        TrieNode node = currentNode.children[idx];
        if (node == null) {
            // if we do not have node for idx char, then create it and assign
            // it as children of currentNode
            node = new TrieNode();
            currentNode.children[idx] = node;
        }

        // check if node for idx char is last char or not
        if (chars.length == index + 1) {
            node.isLeafNode = true;
            return;
        }
        // recursively create and attach node for each chars
        add(chars, index + 1, node);
    }

    public boolean search(String word) {
        return search(word.toCharArray(), 0, root);
    }

    private boolean search(char[] chars, int index, TrieNode currentNode) {
        if (chars.length == index) {
            // base condition, if we have searched every characters in chars
            // and the last char node is leafNode, then we have found the word in dictionary
            return currentNode.isLeafNode;
        }

        char c = chars[index];
        int idx = c - 'a';

        TrieNode[] children = currentNode.children;

        if (c == '.') {
            // if current char is dot then search into all the node tree
            for (TrieNode node : children) {
                if (node != null && search(chars, index + 1, node)) return true;
            }
            return false;
        }


        TrieNode node = children[idx];
        // if we do not have node in children index, then we dont have word
        if (node == null) return false;

        // recursively search next character into the dictionary
        return search(chars, index + 1, node);
    }

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26]; // we are assuming we will have lowercase letters only
        boolean isLeafNode;
    }
}
