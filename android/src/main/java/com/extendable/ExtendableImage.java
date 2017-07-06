package com.extendable;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

import java.util.Arrays;

/**
 * Created by Shahen on 6/30/17.
 */

public class ExtendableImage extends SubsamplingScaleImageView {
    int[] panPossibleLimits = {
            ExtendableImage.PAN_LIMIT_CENTER,
            ExtendableImage.PAN_LIMIT_INSIDE,
            ExtendableImage.PAN_LIMIT_OUTSIDE
    };

    int[] possibleScaleTypes= {
            ExtendableImage.SCALE_TYPE_CENTER_CROP,
            ExtendableImage.SCALE_TYPE_CENTER_INSIDE,
            ExtendableImage.SCALE_TYPE_CUSTOM
    };

    GLSurfaceView mSurfaceView;

    public ExtendableImage(Context context, AttributeSet attr) {
        super(context, attr);
        initializeSurface(context);
    }

    public ExtendableImage(Context context) {
        super(context);
        initializeSurface(context);
    }

    private void initializeSurface(Context context) {
        mSurfaceView = new GLSurfaceView(context);
        mSurfaceView.setEGLContextClientVersion(2);
        mSurfaceView.setRenderer(new GLExtendableRenderer(context));
    }

    public boolean isPanLimitValid(int panLimit) {
        return Arrays.asList(panPossibleLimits).contains(panLimit);
    }

    public boolean isScaleTypeValid(int scaleType) {
        return Arrays.asList(possibleScaleTypes).contains(scaleType);
    }
}
