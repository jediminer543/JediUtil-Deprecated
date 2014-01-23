package com.jediminer543.util.renders.obj;

import static org.lwjgl.opengl.GL11.*;

import java.util.ArrayList;

import org.lwjgl.util.vector.Vector3f;

import com.jediminer543.util.renders.IRenderable;

public class Model implements IRenderable {

	public ArrayList<Vector3f> vertices = new ArrayList<Vector3f>();
	public ArrayList<Vector3f> normals = new ArrayList<Vector3f>();
	public ArrayList<Face> faces = new ArrayList<Face>();
	@Override
	public void render()
	{
		glBegin(GL_TRIANGLES);

		for (Face f : faces)
		{
			if (f.normals)
			{
			Vector3f n1 = normals.get((int) f.normal.x -1);
			glNormal3f(n1.x, n1.y, n1.z);
			Vector3f v1 = vertices.get((int) f.vertex.x -1);
			glVertex3f(v1.x, v1.y, v1.z);
			Vector3f n2 = normals.get((int) f.normal.x -1);
			glNormal3f(n2.x, n2.y, n2.z);
			Vector3f v2 = vertices.get((int) f.vertex.x -1);
			glVertex3f(v2.x, v2.y, v2.z);
			Vector3f n3 = normals.get((int) f.normal.x -1);
			glNormal3f(n3.x, n3.y, n3.z);
			Vector3f v3 = vertices.get((int) f.vertex.x -1);
			glVertex3f(v3.x, v3.y, v3.z);
			}
			Vector3f v1 = vertices.get((int) f.vertex.x -1);
			glVertex3f(v1.x, v1.y, v1.z);
			Vector3f v2 = vertices.get((int) f.vertex.x -1);
			glVertex3f(v2.x, v2.y, v2.z);
			Vector3f v3 = vertices.get((int) f.vertex.x -1);
			glVertex3f(v3.x, v3.y, v3.z);
		}
		glEnd();
	}

}
