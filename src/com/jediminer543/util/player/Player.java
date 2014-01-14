package com.jediminer543.util.player;

import org.lwjgl.util.vector.Vector3f;

import com.jediminer543.util.IInit;
import com.jediminer543.util.IUpdatable;

public interface Player extends IUpdatable,IInit
{
	
	public Vector3f origen = new Vector3f();
	public Vector3f center = new Vector3f();
	public Vector3f eye = new Vector3f();
	
}
