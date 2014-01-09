package com.jediminer543.util.camera;

import org.lwjgl.util.vector.Vector3f;

public abstract class Camera
{
	public Vector3f eye;
	public Vector3f lookAt;
	public Vector3f up;
	
	public Camera(float eyeX, float eyeY, float eyeZ, float lookX, float lookY, float lookZ)
	{
		this(new Vector3f(eyeX,eyeY,eyeZ),new Vector3f(lookX,lookY,lookZ),new Vector3f(0,1,0));
	}
	
	public Camera(float eyeX, float eyeY, float eyeZ, float lookX, float lookY, float lookZ, float upX, float upY, float upZ)
	{
		this(new Vector3f(eyeX,eyeY,eyeZ),new Vector3f(lookX,lookY,lookZ),new Vector3f(upX,upY,upZ));
	}
	
	public Camera(Vector3f eye, Vector3f lookAt, Vector3f up)
	{
		this.eye = eye;
		this.lookAt = lookAt;
		this.up = up;
		
	}
	
	/**
	 * Called every frame to recalculate the position of the camera
	 */
	public abstract void repos();

}
