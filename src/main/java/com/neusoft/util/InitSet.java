package com.neusoft.util;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class InitSet {
    public static Set<String> initSet(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String str = br.readLine();
        Set<String> urls = new HashSet<>();
        while(str != null){
            urls.add(str);
            str = br.readLine();
        }
        return urls;
    }
}
