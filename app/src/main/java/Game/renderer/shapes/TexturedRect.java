package Game.renderer.shapes;

import Game.renderer.buffers.VAO;
import Game.renderer.buffers.VBO;

import org.joml.*;

import static org.lwjgl.opengl.GL46.*;

public class TexturedRect {
    public float x;
    public float y;
    public float width;
    public float height;
    VAO vao;
    VBO vbo;
    private Matrix4f model = new Matrix4f();


    public TexturedRect(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

//        model = glm::translate(model, glm::vec3(position, 0.0f));
//
//        model = glm::translate(model, glm::vec3(0.5f * size.x, 0.5f * size.y, 0.0f));
//        model = glm::rotate(model, glm::radians(rotate), glm::vec3(0.0f, 0.0f, 1.0f));
//        model = glm::translate(model, glm::vec3(-0.5f * size.x, -0.5f * size.y, 0.0f));
//
//        model = glm::scale(model, glm::vec3(size, 1.0f));

        model.translate(x, y, 0);
        model.translate(0.5f * width, 0.5f * height, 0);
        model.scale(width, height, 1.0f);

        updateBuffer();
    }

    public void updateBuffer() {
        vao = new VAO();
        vao.bind();
        vbo = new VBO(24);
        vbo.put(-1.0f).put(-1.0f).put(0.0f).put(1.0f);
        vbo.put(1.0f).put(-1.0f).put(1.0f).put(1.0f);
        vbo.put(1.0f).put(1.0f).put(1.0f).put(0.0f);
        vbo.put(1.0f).put(1.0f).put(1.0f).put(0.0f);
        vbo.put(-1.0f).put(1.0f).put(0.0f).put(0.0f);
        vbo.put(-1.0f).put(-1.0f).put(0.0f).put(1.0f);
        vbo.flip();
        vbo.sendData();
        glVertexAttribPointer(0, 4, GL_FLOAT, false, 0, 0L);
        glEnableVertexAttribArray(0);

    }

    public Matrix4f getModel() {
        return model;
    }

    public void bind() {
        vao.bind();
    }
}