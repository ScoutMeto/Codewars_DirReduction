package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DirReduction {
    public static String[] dirReduc(String[] arr) {
        List<String> arrForReduction = new ArrayList<>(Arrays.asList(arr));
        boolean reduced; // Variable for tracking, if a list was reduced

        String north = "NORTH";
        String south = "SOUTH";
        String east = "EAST";
        String west = "WEST";

        //Using "for" loop in "do-while" loop
        do {
            reduced = false; // False at the start of iteration do-while loop
            for (int i = 0; i < arrForReduction.size() - 1; i++) {
                String current = arrForReduction.get(i);
                String next = arrForReduction.get(i + 1);

                // Pairs checking
                if ((current.equals(north) && next.equals(south)) ||
                        (current.equals(south) && next.equals(north)) ||
                        (current.equals(east) && next.equals(west)) ||
                        (current.equals(west) && next.equals(east))) {

                    arrForReduction.remove(i + 1); // Delete opposite ways
                    arrForReduction.remove(i);
                    reduced = true; // Reduced is true if reduction was activated
                    break; // Break the do-while loop and start again
                }
            }
        } while (reduced); // Continue again and again the reduction is essential

        return arrForReduction.toArray(new String[0]); // List to array
    }
}

/*
TESTING

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runners.JUnit4;

public class DirReductionTest {
  @Test
  public void testSimpleDirReduc() {
    assertArrayEquals("\"NORTH\", \"SOUTH\", \"SOUTH\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\"",
          new String[]{"WEST"},
          DirReduction.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));
    assertArrayEquals("\"NORTH\",\"SOUTH\",\"SOUTH\",\"EAST\",\"WEST\",\"NORTH\"",
          new String[]{},
          DirReduction.dirReduc(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH"}));
  }
}
 */