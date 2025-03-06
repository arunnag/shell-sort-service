package com.shellsort.sortingfloats.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Service class for shell sort
 */
@Service
public class ShellSortService {
    /**
     * Sorts the list of floats using shell sort algorithm
     * @param unSortedFloats list of floats to be sorted
     * @return sorted list of floats
     */
    public ArrayList<ArrayList<Float>> sort(ArrayList<Float> unSortedFloats) {
        return shellSort(unSortedFloats);
    }
    
    @SuppressWarnings("unchecked")
    ArrayList<ArrayList<Float>> shellSort(ArrayList<Float> floats) {
        int n = floats.size();
        ArrayList<ArrayList<Float>> result = new ArrayList<ArrayList<Float>>();

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                float temp = floats.get(i);
                int j;
                for (j = i; j >= gap && floats.get(j - gap) > temp; j -= gap) {
                    floats.set(j, floats.get(j - gap));
                }
                floats.set(j, temp);
            }


            result.add((ArrayList<Float>) floats.clone());
        }

        System.out.println("Reached here!!!");
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
        System.out.println("Done!!!");
        return result;
    }
}
