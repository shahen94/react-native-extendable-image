
# react-native-extendable-image

Highly performant ImageView transformation with gestures ✋.

This library provides Extendable Image component, which is editable using gestures like pinch, double tap or pull. You can scale/move ImageView

## Getting started

`$ npm install react-native-extendable-image --save`

### Mostly automatic installation

`$ react-native link react-native-extendable-image`

### Manual installation


#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.shahenlibrary.RNExtendableImagePackage;` to the imports at the top of the file
  - Add `new RNExtendableImagePackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-extendable-image'
  	project(':react-native-extendable-image').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-extendable-image/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-extendable-image')
  	```


## Usage
```javascript
import ExtendableImage from 'react-native-extendable-image';

class App extends PureComponent {
	render() {
		<ExtendableImage
			source={/* require() or { uri: 'https://..' } */}
			panEnabled={/* true | false */}
			minScale={/* number */}
			maxScale={/* number */}
			panLimit={/* use constants: ExtendableImage.Constants.Pan.* */}
			scaleType={/* use constants: ExtendableImage.Constants.Scale.* */}
			doubleTapScale={/* number */}
			tileBackgroundColor={/* RN color */}
		/>
	}
}
```
  
