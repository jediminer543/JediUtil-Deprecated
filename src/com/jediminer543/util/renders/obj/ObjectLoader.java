package com.jediminer543.util.renders.obj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.lwjgl.util.vector.Vector3f;

public class ObjectLoader {


	public static Model load(File f) throws IOException
	{
        BufferedReader reader = new BufferedReader(new FileReader(f));
        Model m = new Model();
        String line;
			while ((line = reader.readLine()) != null) {
			    String prefix = line.split(" ")[0];
			    if (prefix.equals("#")) {
			        continue;
			    } else if (prefix.equals("v")) {
			    	parseVertex(line);
			    } else if (prefix.equals("vn")) {
			    } else if (prefix.equals("f")) {
			    }
			}
		reader.close();
		return m;
	}
	
	public static Vector3f  parseVertex(String line)
	{
		
		
		return null;
		
	}
}
