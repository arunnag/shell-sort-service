package com.shellsort.sortingfloats.service;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ShellSortService {
    public List<Float> sort(List<Float> floats) {
        return shellSort(floats);
    }
    
    List<Float> shellSort(List<Float> floats) {
        int n = floats.size();
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                float temp = floats.get(i);
                int j;
                for (j = i; j >= gap && floats.get(j - gap) > temp; j -= gap) {
                    floats.set(j, floats.get(j - gap));
                }
                floats.set(j, temp);
            }
        }
        return floats;
    }
}
