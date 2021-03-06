package Game.renderer.shapes;

import Game.renderer.buffers.VAO;
import Game.renderer.buffers.VBO;

import org.joml.*;

import static org.lwjgl.opengl.GL46.*;

public class TexturedRect {
    public double x;
    public double y;
    public final double width;
    public final double height;
    private VAO vao;
    private VBO vbo;
    private final Matrix4d model = new Matrix4d();


    public TexturedRect(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        model.translate(x, y, 0);
        model.translate(0.5f * width, 0.5f * height, 0);
        model.scale(0.5f * width, 0.5f * -height, 1.0f);

        createBuffer();
    }

    private void createBuffer() {
        vao = new VAO();
        vao.bind();
        vbo = new VBO(30);
        vbo.put(-1.0f).put(-1.0f).put(0.0f).put(1.0f);
        vbo.put(1.0f).put(-1.0f).put(1.0f).put(1.0f);
        vbo.put(1.0f).put(1.0f).put(1.0f).put(0.0f);
        vbo.put(1.0f).put(1.0f).put(1.0f).put(0.0f);
        vbo.put(-1.0f).put(1.0f).put(0.0f).put(0.0f);
        vbo.put(-1.0f).put(-1.0f).put(0.0f).put(1.0f);
        vbo.flip();
        vbo.sendData();
        glVertexAttribPointer(0, 4, GL_FLOAT, true, 0, 0L);
        glEnableVertexAttribArray(0);

    }

    public Matrix4d getModel() {
        model.setTranslation(x, y, 1.0f);
        return model;
    }

    public void bind() {
        vao.bind();
    }
}
