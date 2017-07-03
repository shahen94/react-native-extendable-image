import resolveAsset from 'react-native/Libraries/Image/resolveAssetSource';

export default function getActualSource(source) {
    if (typeof source === 'number') {
        return resolveAsset(source).uri;
    }
    return source;
}