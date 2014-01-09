package com.jediminer543.util.camera;

import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.vector.Vector3f;

public class StaticCamera extends Camera {

	public StaticCamera(float eyeX, float eyeY, float eyeZ, float lookX, float lookY, float lookZ)
	{
		super(eyeX, eyeY, eyeZ, lookX, lookY, lookZ);
	}

	public StaticCamera(float eyeX, float eyeY, float eyeZ, float lookX, float lookY, float lookZ, float upX, float upY, float upZ) {
		super(eyeX, eyeY, eyeZ, lookX, lookY, lookZ, upX, upY, upZ);
	}

	public StaticCamera(Vector3f eye, Vector3f lookAt, Vector3f up)
	{
		super(eye, lookAt, up);
	}

	@Override
	public void repos()
	{
		GLU.gluLookAt(eye.x, eye.y, eye.z, lookAt.x, lookAt.y, lookAt.z, up.x, up.y, up.z);
	}

}
