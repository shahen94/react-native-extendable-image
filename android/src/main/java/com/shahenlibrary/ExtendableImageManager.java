
package com.shahenlibrary;

import android.support.annotation.Nullable;
import android.util.Log;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.Map;

public class ExtendableImageManager extends SimpleViewManager<ExtendableImage> {

  private final String REACT_PACKAGE = "RNExtendableImage";
  private final String TAG = REACT_PACKAGE;

  /**
   * Props names
   */
  private final String PROP_SOURCE = "source";
  private final String PROP_MAX_SCALE = "maxScale";
  private final String PROP_MIN_SCALE = "minScale";
  private final String PROP_PAN_ENABLED = "panEnabled";
  private final String PROP_PAN_LIMIT = "panLimit";
  private final String PROP_SCALE_TYPE = "scaleType";
  private final String PROP_DOUBLE_TAP_SCALE = "doubleTapScale";
  private final String PROP_TILE_BACKGROUND_COLOR = "tileBackgroundColor";

  @Nullable
  @Override
  public Map getExportedCustomBubblingEventTypeConstants() {
    MapBuilder.Builder<String, Map> builder = MapBuilder.builder();
    for (SendEventTypes evt : SendEventTypes.values()) {
      builder.put(evt.toString(), MapBuilder.of("registrationName", evt.toString()));
    }
    Log.d(TAG, builder.toString());
    return builder.build();
  }

  @Nullable
  @Override
  public Map<String, Integer> getCommandsMap() {
    return MapBuilder.of(
            ReceiveEventTypes.ANIMATE,
            ReceiveEventTypes.ANIMATE_CODE
    );
  }

  @Override
  public void receiveCommand(ExtendableImage root, int commandId, @Nullable ReadableArray args) {
    super.receiveCommand(root, commandId, args);
    Log.d(TAG, "receiveCommand: " + args.toString());
    Log.d(TAG, "receiveCommand: commandId" + String.valueOf(commandId));
    switch (commandId) {
      case ReceiveEventTypes.ANIMATE_CODE:
        root.animate();
        break;
      default:
        // PASS
    }
  }

  @Nullable
  @Override
  public Map getExportedViewConstants() {
    return MapBuilder.of(
            "PanCenter", Integer.toString(ExtendableImage.PAN_LIMIT_CENTER),
            "PanInside", Integer.toString(ExtendableImage.PAN_LIMIT_INSIDE),
            "PanOutside", Integer.toString(ExtendableImage.PAN_LIMIT_OUTSIDE),
            "ScaleCenterCrop", Integer.toString(ExtendableImage.SCALE_TYPE_CENTER_CROP),
            "ScaleCenterInside", Integer.toString(ExtendableImage.SCALE_TYPE_CENTER_INSIDE),
            "ScaleCustom", Integer.toString(ExtendableImage.SCALE_TYPE_CUSTOM)
    );
  }

  @Override
  public String getName() {
    return REACT_PACKAGE;
  }

  @Override
  protected ExtendableImage createViewInstance(ThemedReactContext reactContext) {
    return new ExtendableImage(reactContext);
  }

  /**
   * Props
   */
  @ReactProp(name=PROP_SOURCE)
  public void setSource(ExtendableImage view, @Nullable String imageSource) {
    Log.d(TAG, "setSource: " + imageSource);
    view.setImage(ImageSource.uri(imageSource));
  }

  @ReactProp(name=PROP_MAX_SCALE, defaultDouble = 0.0d)
  public void setMaxScale(ExtendableImage view, @Nullable double maxScale) {
    Log.d(TAG, "setMaxScale: " + maxScale);
    view.setMaxScale((float) maxScale);
  }

  @ReactProp(name=PROP_MIN_SCALE, defaultDouble = 0.0d)
  public void setMinScale(ExtendableImage view, @Nullable double minScale) {
    Log.d(TAG, "setMinScale: " + minScale);
    view.setMinScale((float) minScale);
  }

  @ReactProp(name=PROP_PAN_ENABLED, defaultBoolean = true)
  public void setPanEnabled(ExtendableImage view, boolean isEnabled) {
    Log.d(TAG, "setPanEnabled: " + isEnabled);
    view.setPanEnabled(isEnabled);
  }

  @ReactProp(name=PROP_PAN_LIMIT)
  public void setPanLimit(ExtendableImage view, int panLimit) {
    if (view.isPanLimitValid(panLimit)) {
      view.setPanLimit(panLimit);
      return;
    }
    Log.d(TAG, "setPanLimit: Wrong value : " + panLimit);
  }

  @ReactProp(name=PROP_SCALE_TYPE)
  public void setScaleType(ExtendableImage view, int scaleType) {
    if (view.isScaleTypeValid(scaleType)) {
      view.setMinimumScaleType(scaleType);
      return;
    }
    Log.d(TAG, "setScaleType: Wrong value : " + scaleType);
  }

  @ReactProp(name=PROP_DOUBLE_TAP_SCALE)
  public void setDoubleTapEnabled(ExtendableImage view, int doubleTapScale) {
    view.setDoubleTapZoomDpi(doubleTapScale);
  }

  @ReactProp(name=PROP_TILE_BACKGROUND_COLOR)
  public void setTileBackgroundColor(ExtendableImage view, int color) {
    view.setTileBackgroundColor(color);
  }
}
