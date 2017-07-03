import React, { PureComponent } from 'react';
import PropTypes from 'prop-types';
import {
    View,
    requireNativeComponent,
    UIManager,
    findNodeHandle
} from 'react-native';

const ExtendableImageUI = UIManager.RNExtendableImage;

console.log(ExtendableImageUI, UIManager);
export default class ExtendableImage extends PureComponent {
    static propTypes = {
        ...View.propTypes,
        source: PropTypes.string.isRequired,
        minScale: PropTypes.number,
        maxScale: PropTypes.number,
        panEnabled: PropTypes.bool,
    };
    animate = () => {
        UIManager.dispatchViewManagerCommand(
            findNodeHandle(this),
            ExtendableImageUI.Commands.animate
        )
    }
    render() {
        return (
            <RNExtendableImage
                {...this.props}
            />
        );
    }
}

const RNExtendableImage = requireNativeComponent('RNExtendableImage', ExtendableImage, {
    nativeOnly: {
        onTouch: true
    }
});