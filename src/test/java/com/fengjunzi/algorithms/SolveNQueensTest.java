package com.fengjunzi.algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SolveNQueensTest {

    @InjectMocks
    private SolveNQueens solveNQueens;

    @Test
    public void testSolveNQueens() {
       solveNQueens.solveNQueens(4);
    }
}
