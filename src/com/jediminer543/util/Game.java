package com.jediminer543.util;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

import com.jediminer543.util.camera.Camera;
import com.jediminer543.util.renders.ColourRGB;

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
	
	public static ColourRGB bgcolour = new ColourRGB(0,0,250);
	
	public static int activeCamera = 0;
	public static IInit[] init = new IInit[100]; 
	public static Camera[] cameras = new Camera[50];
	

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
		GLU.gluPerspective(50f, SX/ SY, 0.01f, 100f);
	}
	
	public void initDisplay()
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
	}
	
	public void mainLoop()
	{
		while (!Display.isCloseRequested())
		{
			Display.sync(maxFPS);
			
		    Display.update();
		}
	}
	
	public void perFrameGL()
	{
		glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glShadeModel(GL_SMOOTH);
		glMatrixMode(GL_PROJECTION);
		glEnable(GL_CULL_FACE);
	    glCullFace(GL_BACK);
		glLoadIdentity();
		calcCamera();
		glMatrixMode(GL_MODELVIEW);
		GL11.glColor3f(bgcolour.R, bgcolour.G, bgcolour.G);
		glLoadIdentity();
		glEnable(GL_DEPTH_TEST);
		
	}
	
	public void calcCamera()
	{
		cameras[activeCamera].repos();
	}
	
	public void start()
	   {
		

		init();
		
		mainLoop();
				
		Display.destroy();
	   }
}

