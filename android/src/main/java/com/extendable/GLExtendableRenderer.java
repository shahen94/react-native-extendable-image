package com.extendable;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by simply on 7/6/17.
 */

public class GLExtendableRenderer implements GLSurfaceView.Renderer {
    private Context mContext;
    private final String vertexShader =  "attribute vec4 uv;" +
            "void main() {" +
            "  gl_Position = uv;" +
            "}";
    private String mFragmentShader;
    private int mTextureDataHandle;

    public GLExtendableRenderer(Context ctx) {
        mContext = ctx;
    }

    public void setFragmentShader(String shader) {
        mFragmentShader = shader;
    }

    public String getVertexShader() {
        return  vertexShader;
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {

    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);

        final int vertexShaderHandle = ShaderHelper.compileShader(
                GLES20.GL_VERTEX_SHADER, getVertexShader()
        );
        final int fragmentShader = ShaderHelper.compileShader(
                GLES20.GL_FRAGMENT_SHADER, mFragmentShader
        );
        int mProgram = ShaderHelper.createAndLinkProgram(vertexShaderHandle, fragmentShader, new String[] { "a_Position","a_TexCoordinate" });
        GLES20.glUseProgram(mProgram);

        int shader = GLES20.glGetUniformLocation(mProgram, "t");
        GLES20.glActiveTexture(GLES20.GL_TEXTURE0);
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, mTextureDataHandle);
        GLES20.glUniform1i(mTextureDataHandle, 0);
    }
}
