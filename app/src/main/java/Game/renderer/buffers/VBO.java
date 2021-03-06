package Game.renderer.buffers;

import static org.lwjgl.opengl.GL46.*;

import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;

public class VBO {
    private final int id;
    private final FloatBuffer buff;

    public VBO(int size) {
        id = glGenBuffers();
        buff = BufferUtils.createFloatBuffer(size);
        bind();

    }

    public void bind() {
        glBindBuffer(GL_ARRAY_BUFFER, id);
    }

    public VBO put(float data) {
        buff.put(data);
        return this;
    }

    public void sendData() {
        bind();
        glBufferData(GL_ARRAY_BUFFER, buff, GL_STATIC_DRAW);
    }

    public void flip() {
        buff.flip();
    }
}
