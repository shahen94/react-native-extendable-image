// @flow

import React, { PureComponent } from 'react';
import PropTypes from 'prop-types';
import {
    View,
    requireNativeComponent,
    UIManager,
    findNodeHandle,
    processColor,
    Image
} from 'react-native';

import resolveAsset from './utils/resolveAssets';

const ExtendableImageUI = UIManager.RNExtendableImage;

class ExtendableImage extends PureComponent {
    static propTypes = {
        ...View.propTypes,
        source: Image.propTypes.source,
        minScale: PropTypes.number,
        maxScale: PropTypes.number,
        panEnabled: PropTypes.bool,
        panLimit: PropTypes.number,
        scaleType: PropTypes.number,
        doubleTapScale: PropTypes.number,
        tileBackgroundColor: PropTypes.oneOfType([PropTypes.number, PropTypes.string])
    };
    static Constants = {
        Pan: {
            PanCenter: ExtendableImageUI.Constants.PanCenter,
            PanInside: ExtendableImageUI.Constants.PanInside,
            PanOutside: ExtendableImageUI.Constants.PanOutside,
        },
        Scale: {
            ScaleCenterCrop: ExtendableImageUI.Constants.ScaleCenterCrop,
            ScaleCenterInside: ExtendableImageUI.Constants.ScaleCenterInside,
            ScaleCustom: ExtendableImageUI.Constants.ScaleCustom
        }
    };
    animate = () => {
        UIManager.dispatchViewManagerCommand(
            findNodeHandle(this),
            ExtendableImageUI.Commands.animate
        )
    }
    render() {
        const source = resolveAsset(this.props.source);
        const { tileBackgroundColor } = this.props;
        const propsShouldPass = { ...this.props };
        propsShouldPass.source = source;
        if (tileBackgroundColor) {
            propsShouldPass.tileBackgroundColor = processColor(tileBackgroundColor);
        }
        return (
            <RNExtendableImage
                {...propsShouldPass}
                source={source}
            />
        );
    }
}

const RNExtendableImage = requireNativeComponent('RNExtendableImage', ExtendableImage, {
    nativeOnly: {
        onTouch: true
    }
});

export default ExtendableImage;