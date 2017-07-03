
# react-native-extendable-image

## Getting started

`$ npm install react-native-extendable-image --save`

### Mostly automatic installation

`$ react-native link react-native-extendable-image`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-extendable-image` and add `RNExtendableImage.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNExtendableImage.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

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
import RNExtendableImage from 'react-native-extendable-image';

// TODO: What to do with the module?
RNExtendableImage;
```
  