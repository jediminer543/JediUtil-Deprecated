package com.jediminer543.shooter;

import com.jediminer543.util.Game;

public class FirstPersonShooter extends Game {

	public FirstPersonShooter(int SizeX, int SizeY, int MaxFPS)
	{
		super(SizeX, SizeY, MaxFPS, "First Person Shooter Test");
	}

	public static void main(String[] args)
	{
		
		FirstPersonShooter game = new FirstPersonShooter(800,600,120);
		game.start();

	}

}
