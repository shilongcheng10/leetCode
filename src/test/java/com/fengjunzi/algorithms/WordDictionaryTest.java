package com.fengjunzi.algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class WordDictionaryTest {

    @InjectMocks
    private WordDictionary wordDictionary;

    @Test
    public void testWordDictionary() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.search("pad"); // 返回 False
        wordDictionary.search("bad"); // 返回 True
        wordDictionary.search(".ad"); // 返回 True
        wordDictionary.search("b..");
    }
}
