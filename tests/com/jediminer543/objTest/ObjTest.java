package com.jediminer543.objTest;

import java.io.File;
import java.io.IOException;

import com.jediminer543.util.Game;
import com.jediminer543.util.camera.StaticCamera;
import com.jediminer543.util.renders.obj.Model;
import com.jediminer543.util.renders.obj.ObjectLoader;

public class ObjTest extends Game {

	public ObjTest(int SizeX, int SizeY) {
		super(SizeX, SizeY, 500, "Object Loading Test");
	}

	
	
	public static void main(String[] args) {
		ObjTest game = new ObjTest(800, 600);
		Model m;
			try {
				m = ObjectLoader.load(new File("Res/Isosphere Test.obj"));
				ObjTest.renders.add(m);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
			ObjTest.activeCamera = 0;
			ObjTest.cameras.add(new StaticCamera(0,0,-10,0,0,0));
		game.start();

	}

}
