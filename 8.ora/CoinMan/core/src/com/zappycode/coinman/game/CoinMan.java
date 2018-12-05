package com.zappycode.coinman.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;


import java.util.ArrayList;
import java.util.Random;

import sun.rmi.runtime.Log;

public class CoinMan extends ApplicationAdapter {
	SpriteBatch batch;
	Texture background;
	Texture[] man;

	int pause = 0;
	float gravity = 0.2f;



	BitmapFont font;
	Texture dizzy;
	int score = 0;
	int gameState = 0;




	CoinArray CoinArr = new CoinArray ();
	BombArray BombArr = new BombArray ();



	int bombCount;
	Player Man;

	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture("bg.png");
		man = new Texture[4];
		man[0] = new Texture("frame-1.png");
		man[1] = new Texture("frame-2.png");
		man[2] = new Texture("frame-3.png");
		man[3] = new Texture("frame-4.png");



		dizzy = new Texture("dizzy-1.png");

		font = new BitmapFont();
		font.setColor(Color.WHITE);
		font.getData().setScale(10);


		Man = new Player(man,dizzy);
	}





	@Override
	public void render () {
		batch.begin();
		batch.draw(background,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

		if (gameState == 1) {

				BombArr.makeObject();
				BombArr.createGameObjectRectangles();
				BombArr.createGameObjectRectangles();



			CoinArr.makeObject();



			CoinArr.getGameObjectRectangleArrayList().clear();
			BombArr.getGameObjectRectangleArrayList().clear();
			Gdx.app.log("Rects",String.valueOf(CoinArr.getGameObjectArrayList().size()));
			Gdx.app.log("Coins",String.valueOf(CoinArr.getGameObjectArrayList().size()));
			for (int i= 0; i < CoinArr.getGameObjectArrayList().size();i++){

				batch.draw(Coin.getCoinTexture(), CoinArr.getGameObjectArrayList().get(i).getGameObjectX(),CoinArr.getGameObjectArrayList().get(i).getGameObjectY());
				CoinArr.getGameObjectArrayList().get(i).setGameObjectX(CoinArr.getGameObjectArrayList().get(i).getGameObjectX()-4);
				CoinArr.getGameObjectRectangleArrayList().add(new Rectangle(CoinArr.getGameObjectArrayList().get(i).getGameObjectX(),CoinArr.getGameObjectArrayList().get(i).getGameObjectY(),
																						Coin.getCoinTexture().getWidth(),Coin.getCoinTexture().getHeight()));
				Gdx.app.log("Coin!!!", String.valueOf(CoinArr.getGameObjectArrayList().get(i).getGameObjectY()));
			}
			//bomba rajzolása
			for (int i= 0; i < BombArr.getGameObjectArrayList().size();i++){

				batch.draw(Bomb.getBombTexture(), BombArr.getGameObjectArrayList().get(i).getGameObjectX(),BombArr.getGameObjectArrayList().get(i).getGameObjectY());
				BombArr.getGameObjectArrayList().get(i).setGameObjectX(BombArr.getGameObjectArrayList().get(i).getGameObjectX()-4);
				BombArr.getGameObjectRectangleArrayList().add(new Rectangle(BombArr.getGameObjectArrayList().get(i).getGameObjectX(),BombArr.getGameObjectArrayList().get(i).getGameObjectY(),
						Bomb.getBombTexture().getWidth(),Bomb.getBombTexture().getHeight()));

			}
			Gdx.app.log("Bombak szama!!!", String.valueOf(BombArr.getGameObjectArrayList().size()));

			if (Gdx.input.justTouched()) {
				Man.setVelocity(-10);
			}

			if (pause < 8) {
				pause++;
			} else {
				pause = 0;
				if (Man.getManState() < 3) {
					Man.setManState(Man.getManState()+1);
				} else {

					Man.setManState(0);
				}
			}


			Man.setVelocity(Man.getVelocity()+gravity);
			Man.setManY((int)(Man.getManY()-Man.getVelocity()));


			if (Man.getManY() <= 0) {
				Man.setManY(0);
			}
		} else if (gameState == 0) {
			// Waitng to start
			if (Gdx.input.justTouched()) {
				gameState = 1;
			}
		} else if (gameState == 2) {
			// GAME OVER
			if (Gdx.input.justTouched()) {
				gameState = 1;

				Man.setManY(Gdx.graphics.getHeight() / 2);
				score = 0;

				Man.setVelocity(0);

				CoinArr.getGameObjectArrayList().clear();
				BombArr.getGameObjectArrayList().clear();
				//CoinArr coinRectanglenek torlese
				CoinArr.getGameObjectRectangleArrayList().clear();
				BombArr.getGameObjectRectangleArrayList().clear();
				CoinArr.setGameObjectCount(0);


				bombCount = 0;
			}
		}

		if (gameState == 2) {

			batch.draw(Man.getDizzy(), Gdx.graphics.getWidth() / 2 - Man.getManTexture()[Man.getManState()].getWidth() / 2, Man.getManY());

		} else {

			batch.draw(Man.getManTexture()[Man.getManState()], Gdx.graphics.getWidth() / 2 - Man.getManTexture()[Man.getManState()].getWidth() / 2 , Man.getManY());
		}



		Rectangle R =		new Rectangle(Gdx.graphics.getWidth() / 2 - Man.getManTexture()[Man.getManState()].getWidth() / 2, Man.getManY(),
				Man.getManTexture()[Man.getManState()].getWidth(), Man.getManTexture()[Man.getManState()].getHeight());//);
		Man.setManRectangle(R);

		// ermekkel torteno utkozes vizsgalata
		for (int i=0; i < CoinArr.getGameObjectRectangleArrayList().size();i++) {

			if (Intersector.overlaps(Man.getManRectangle(), CoinArr.getGameObjectRectangleArrayList().get(i))) {

				score++;
				CoinArr.getGameObjectRectangleArrayList().remove(i);

				CoinArr.getGameObjectArrayList().remove(i);
				break;
			}
		}
		// bombakkal torteno utkozes vizsgélata
		Gdx.app.log("Bomb!", String.valueOf(BombArr.getGameObjectArrayList().size()));
		for (int i=0; i < BombArr.getGameObjectRectangleArrayList().size();i++) {

			if (Intersector.overlaps(Man.getManRectangle(), BombArr.getGameObjectRectangleArrayList().get(i))) {
				Gdx.app.log("Bomb!", "Collision!");
				gameState = 2;


			}
		}




		font.draw(batch, String.valueOf(score),100,200);

		Integer Y = Man.getManY();

		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
