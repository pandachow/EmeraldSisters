package com.mattdavben.emeraldsisters.entity;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

public class WorldEntity extends Entity {

	protected Polygon collisionShape;

	public WorldEntity() {
	}

	public WorldEntity withCollisionShape(int startingX, int startingY, int width, int height) {
		this.currentPosition = new Vector2f(startingX, startingY);
		float[] points = { startingX, startingY, startingX + width, startingY, startingX + width, startingY + height, startingX, startingY + height };
		this.collisionShape = new Polygon(points);
		return this;
	}

	public void render(Graphics gr, Viewport viewport) {
	}

	@Override
	public void update(GameContainer gc, int delta) {

	}

	public void renderCollisionBox(Viewport viewport, Graphics gr) {
		Shape copy = collisionShape.copy();
		float x = copy.getX();
		float y = copy.getY();
		copy.setX(x - viewport.position.x);
		copy.setY(y - viewport.position.y);
		gr.setColor(Color.red);
		gr.draw(copy);
	}

	public Shape getCollisionShapeCopy() {
		return collisionShape.copy();
	}

	@Override
	public void render(GameContainer gc, Viewport viewport, Graphics gr) {

	}

}
