package com.jediminer.util;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

import static org.lwjgl.opengl.GL11.*;

public class Game {
	
	/**
	 * The size of the screen
	 */
	int SX, SY;
	private int maxFPS;
	private String Title;
	

	/**
	 * 
	 * @param SizeX The width of the screen
	 * @param SizeY The height of the screen
	 * @param MaxFPS The max FPS
	 * @param Title The Text to be displayed in the top bar
	 */
	public Game(int SizeX, int SizeY, int MaxFPS, String Title)
	{
		this.maxFPS = MaxFPS;
		this.Title = Title;
		this.SY = SizeY;
		this.SX = SizeX;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	
	public void start()
	   {
		
		
			try
			{
				Display.setDisplayMode(new DisplayMode(SX, SY));
				Display.setTitle(Title);
				Display.create();
			} catch (LWJGLException e)
			{
				e.printStackTrace();
			}
			
			glShadeModel(GL_SMOOTH);

			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glLoadIdentity();
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glEnable(GL11.GL_DEPTH_TEST);
			
		
			while (!Display.isCloseRequested())
			{
				
				glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
				glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
				glShadeModel(GL_SMOOTH);
				glMatrixMode(GL_PROJECTION);
				glEnable(GL_CULL_FACE);
			    glCullFace(GL_BACK);
				glLoadIdentity();
				GLU.gluPerspective(50f, SX/ SY, 0.01f, 100f);
				GLU.gluLookAt(-25, 5, 0, 0, 0, 0, 0, 1, 0);
				
				glMatrixMode(GL_MODELVIEW);
				glLoadIdentity();
				glEnable(GL_DEPTH_TEST);
				

				/*
				for (IRenderable r : DataStorage.Renders)
				{
					try
					{
					r.Render();
					}catch(Exception e)
					{
					System.out.println("Error At Render");
					e.printStackTrace();
					}
					
				}
				*/
				
				
				Display.sync(maxFPS);
				
			    Display.update();
			}
			
			Display.destroy();
	   }

}
