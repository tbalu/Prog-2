package com.zappycode.coinman.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class BombArray extends GameObjectArray {

    public BombArray(){
        super();
    }

    public void makeObject() {
        if(this.gameObjectCount < 250){
            this.gameObjectCount++;
        }
        else{
            gameObjectCount = 0;
            float height = RandomGenerator.nextFloat()*Gdx.graphics.getHeight();

            GameObjectArrayList.add(new Bomb(Gdx.graphics.getWidth(),(int)height));
        }
    }

    public void createGameObjectRectangles(){
        this.GameObjectRectangleArrayList.clear();
        for(int i = 0; i < GameObjectRectangleArrayList.size(); i++){
            GameObjectRectangleArrayList.add(new Rectangle(GameObjectArrayList.get(i).getGameObjectX(),GameObjectArrayList.get(i).getGameObjectY(),
                    Bomb.getBombTexture().getWidth(),Bomb.getBombTexture().getHeight()));
        }

    }
}
