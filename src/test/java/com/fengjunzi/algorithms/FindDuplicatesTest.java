package com.fengjunzi.algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FindDuplicatesTest {
    @InjectMocks
    FindDuplicates findDuplicates;
    @Test
    public void findDuplicates() {
        findDuplicates.findDuplicates(new int[]{4,3,2,7,8,2,3,1});
    }
}
