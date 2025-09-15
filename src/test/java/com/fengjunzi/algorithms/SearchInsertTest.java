package com.fengjunzi.algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SearchInsertTest {

    @InjectMocks
    private SearchInsert searchInsert;

    @Test
    public void testSearchInsert() {
       searchInsert.searchInsert(new int[]{1,3}, 2);
    }
}
