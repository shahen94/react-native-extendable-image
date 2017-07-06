package com.extendable;

import java.nio.FloatBuffer;

public class Shader {
    private FloatBuffer vertexBuffer;

    private final String vertexShaderCode =
            "attribute vec4 uv;" +
                    "void main() {" +
                    "  gl_Position = uv;" +
                    "}";

    private final int coordsPerVertex = 3;
    private final float[] coordinates = {
            -0.5f,  0.5f, 0.0f,   // top left
            -0.5f, -0.5f, 0.0f,   // bottom left
            0.5f, -0.5f, 0.0f,   // bottom right
            0.5f,  0.5f, 0.0f
    };
    private short drawOrder[] = { 0, 1, 2, 0, 2, 3 }; // order to draw vertices
}
