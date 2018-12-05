package com.zappycode.coinman.game;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;
import java.util.Random;
import com.badlogic.gdx.math.Rectangle;

public class CoinArray extends GameObjectArray {
    public CoinArray(){
        super();
    }

    public void makeObject() {
        if(this.gameObjectCount < 100){
            this.gameObjectCount++;
        }
        else{
            gameObjectCount = 0;
            float height = RandomGenerator.nextFloat()*Gdx.graphics.getHeight();

            GameObjectArrayList.add(new Coin(Gdx.graphics.getWidth(),(int)height));
        }
    }

    public void createGameObjectRectangles(){
        this.GameObjectRectangleArrayList.clear();
        for(int i = 0; i < GameObjectRectangleArrayList.size(); i++){
            GameObjectRectangleArrayList.add(new Rectangle(GameObjectArrayList.get(i).getGameObjectX(),GameObjectArrayList.get(i).getGameObjectY(),
                    Coin.getCoinTexture().getWidth(),Coin.getCoinTexture().getHeight()));
        }

    }


}
