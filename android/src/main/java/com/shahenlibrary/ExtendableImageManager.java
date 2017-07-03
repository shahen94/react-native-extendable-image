
package com.shahenlibrary;

import android.support.annotation.Nullable;
import android.util.Log;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.shahenlibrary.events.ReceiveEventTypes;
import com.shahenlibrary.events.SendEventTypes;

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
}