package com.shahenlibrary;

import android.content.Context;
import android.util.AttributeSet;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

/**
 * Created by Shahen on 6/30/17.
 */

public class ExtendableImage extends SubsamplingScaleImageView {
    public ExtendableImage(Context context, AttributeSet attr) {
        super(context, attr);
    }

    public ExtendableImage(Context context) {
        super(context);
    }
}
