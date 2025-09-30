package com.fengjunzi.algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class MinimumTotalTest {
    @InjectMocks
    private MinimumTotal minimumTotal;
    @Test
    public void test() {
        List<List<Integer>> args = new ArrayList<>();
        List<Integer> firstLevel = new ArrayList<>();
        firstLevel.add(-1);
        args.add(firstLevel);
        List<Integer> secondLevel = new ArrayList<>();
        secondLevel.add(2);
        secondLevel.add(3);
        args.add(secondLevel);
        List<Integer> thirdLevel = new ArrayList<>();
        thirdLevel.add(1);
        thirdLevel.add(-1);
        thirdLevel.add(-3);
        args.add(thirdLevel);
        System.out.println(minimumTotal.minimumTotal(args));
    }
}
