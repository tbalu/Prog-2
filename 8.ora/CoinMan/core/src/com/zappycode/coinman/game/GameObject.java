package com.zappycode.coinman.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class GameObject {

    //public static Texture GameObjectTexture;
    private int gameObjectX;
    private int getGameObjectY;
    private Rectangle GameObjectRectangle;

    public GameObject(int x, int y){
        this.gameObjectX = x;
        this.getGameObjectY = y;
    }

    /*public static Texture getGameObjectTexture() {
        return GameObjectTexture;
    }

    public static void setGameObjectTexture(Texture gameObjectTexture) {
        GameObjectTexture = gameObjectTexture;
    }*/

    public int getGameObjectX() {
        return gameObjectX;
    }

    public void setGameObjectX(int gameObjectX) {
        this.gameObjectX = gameObjectX;
    }

    public int getGameObjectY() {
        return getGameObjectY;
    }

    public void setGetGameObjectY(int getGameObjectY) {
        this.getGameObjectY = getGameObjectY;
    }

    public Rectangle getGameObjectRectangle() {
        return GameObjectRectangle;
    }

    public void setGameObjectRectangle(Rectangle gameObjectRectangle) {
        GameObjectRectangle = gameObjectRectangle;
    }
}
