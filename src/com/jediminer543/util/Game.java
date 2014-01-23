package com.jediminer543.util;

import java.util.ArrayList;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

import com.jediminer543.util.camera.Camera;
import com.jediminer543.util.renders.ColourRGB;
import com.jediminer543.util.renders.IRenderable;

import static org.lwjgl.opengl.GL11.*;

public class Game {
	
	/**
	 * The size of the screen
	 */
	int SX, SY;
	
	/**
	 * The maximum fps to sync to
	 */
	private int maxFPS;
	private String Title;
	
	public static ColourRGB bgcolour = new ColourRGB(25,25,250);
	
	public static int activeCamera = 0;
	public static ArrayList<IInit> init = new ArrayList<IInit>(); 
	public static ArrayList<IRenderable> renders = new ArrayList<IRenderable>(); 
	public static ArrayList<Camera> cameras = new ArrayList<Camera>();
	

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
	
	public void init()
	{
		initDisplay();
		initgl();
		for (IInit Init:init)
		{
			try
			{
			Init.init();
			System.out.println("Initialising " + IInit.debugName);
			}catch(Exception e)
			{
				System.out.println("Error occured when initialising " + IInit.debugName);
				e.printStackTrace();
			}
		}
	}
	
	public void initgl()
	{
		glShadeModel(GL_SMOOTH);

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		//GLU.gluPerspective(50f, SX/ SY, 0.01f, 100f);
	}
	
	public void initDisplay()
	{
		try
		{
			Display.setDisplayMode(new DisplayMode(SX, SY));
			Display.setTitle(Title);
			Display.setInitialBackground(bgcolour.R, bgcolour.G, bgcolour.B);
			Display.create();
		} catch (LWJGLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void mainLoop()
	{
		while (!Display.isCloseRequested())
		{
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			//perFrameGL();
			
			// set the color of the quad (R,G,B,A)
			GL11.glColor3f(0.5f,0.5f,1.0f);
				
			// draw quad
			GL11.glBegin(GL11.GL_QUADS);
			    GL11.glVertex2f(100,100);
			    GL11.glVertex2f(100+200,100);
			    GL11.glVertex2f(100+200,100+200);
			    GL11.glVertex2f(100,100+200);
			GL11.glEnd();

			Display.sync(maxFPS);
			
		    Display.update();
		}
	}
	
	public void perFrameGL()
	{
		
		glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
		glShadeModel(GL_SMOOTH);
		glMatrixMode(GL_PROJECTION);
		glEnable(GL_CULL_FACE);
	    glCullFace(GL_BACK);
		glLoadIdentity();
		GLU.gluPerspective(50f, SX/ SY, 0.01f, 100f);
		GLU.gluLookAt(-10,0,0,0,0,0,0,0,0);
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		glEnable(GL_DEPTH_TEST);
		
	}
	
	public void calcCamera()
	{
		cameras.get(activeCamera).repos();
	}
	
	public void start()
	   {
		

		init();
		
		mainLoop();
				
		Display.destroy();
	   }
}

