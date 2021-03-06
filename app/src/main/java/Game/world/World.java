package Game.world;


import Game.Drawable;
import Game.common.DrawableArray;
import Game.common.Vec2;
import Game.entity.Entity;
import Game.player.Player;
import Game.renderer.Renderer;

import java.util.LinkedList;
import java.util.List;

public class World {

    final Renderer renderer;
    final DrawableArray drawables = new DrawableArray();

    public World(Renderer renderer, Player player) throws Exception {
        this.renderer = renderer;


        drawables.add(player);
        drawables.add(new Entity(renderer, renderer.textures.get("img"), new Vec2<>(100.0, 100.0), new Vec2<>(30.0, 30.0)));

        for (int x = 0; x < 50; x++) {
            for (int y = 0; y < 50; y++) {
                drawables.add(new Ground(renderer, new Vec2<>(x, y)));
            }
        }

    }

    public void draw() {
        drawables.forEach(Drawable::draw);
    }
}
