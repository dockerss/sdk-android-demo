# QN-Scale Bluetooth Android SDK 

#### The latest version of v0.4.2 [Download (https://github.com/YolandaQingniu/sdk-android-demo/releases/download/v0.4.2/qnsdk-0.4.2-Android.zip)]

## SDK file description

### Introduction
#### Import the jar file (qnsdk-xxx.jar) in the lib of the demo project and the corresponding so file.

### configuration (proguard-rules)
+ -keep class com.qingniu.scale.model.BleScaleData{*;}

### operating

#### QNBleApi
This class is the main working class of the SDK, providing operations for various methods of the SDK.

### Configuration
#### QNConfig
This class is the setting class of the SDK, including the configuration of the scan, the configuration of the connection, the display of the scale unit display, etc.

### Main method of measurement process
#### QNBleDeviceDiscoveryListener
Provides a callback when scanning the scale. The scale data object of the callback is QNBleDevice.

#### QNBleDevice
Scanning device object

#### QNUser
The user information object provided by the app to the SDK, which needs to be used when setting up the connection.

#### QNBleConnectionChangeListener
Provides callback of various Bluetooth status during use of the scale and measurement status of the scale during measurement

#### QNDataListener
Provide callbacks for measurement data, including real-time weight, measurement results, and stored data

#### QNScaleData
Measurement result data object

#### QNScaleStoreData
Store data objects, you can (QNScaleStoreData)generateScaleDataget QNScaleDataobjects by

#### QNScaleItemData
Detailed data object for each indicator

### Error message
#### CheckStatus
Show all the error messages in the SDK

## SDK call steps
1. Initialize the SDK (QNBleApi)initSdk
2. Turn on scanning (QNBleApi)startBleDeviceDiscovery
  +To enable scanning, you need to set the monitoring device to scan first. (QNBleApi)setBleDeviceDiscoveryListener
Set the scan configuration (the default configuration is used when no object is set)
Get configuration information (QNBleApi)getConfig()
Set whether to scan only the scale that is turned on onlyScreenOn
Set whether to return multiple times when scanning to the scale allowDuplicates
Set the scan time duration
Set the unit displayed on the scale end unit
Set the connection status monitor (QNBleApi)setBleConnectionChangeListener
Set monitoring of measurement data (QNBleApi)setDataListener
Building a user object that connects the scale (QNBleApi)buildUser:String userId,int height,String gender,Date birthday,QNResultCallback callback
Connecting device connectDevice:QNBleDevice device,QNUser user,QNResultCallback callback

## Precautions
- You must apply for Bluetooth permissions, location permissions, network permissions in the manifest file (not required for offline SDK)
- SDK minimum support API version is 18
- The resources of the v4 package are used in the SDK, and the dependency of the v4 package needs to be introduced in the developer project.
- The service that the SDK needs to use must be added to the manifest file: com.qingniu.qnble.scanner.BleScanService, com.qingniu.scale.ble.ScaleBleService
- targetSdkVersion In 23 and above, you need to obtain the positioning permission before you can scan the device. You need to apply for it yourself.
- If your project is multi-process, it is recommended to limit the initialization of the SDK to the main process.

## Common problems
- Initialization prompt appid error
- Check if the initialization file and the used appid match
- Check if the imported SDK is up to date
- Scan device call succeeded, but there is no device callback and no error callback
- Check if the scanned device is connected by someone else
- Some mobile phones need to turn on GPS to scan the device, please check if the mobile phone GPS is turned on.
- The connected device has been unsuccessful or has been disconnected soon after success.
- Check if the device is connected by someone else
- Check if the currently connected device has been paired in the system Bluetooth. If it is already paired, you need to cancel the pairing.
- Some phones need to be scanned before they can connect successfully. Scan the device before connecting.
- The obtained indicators are different from the number of indicators negotiated with the business.
- Check the device in question first, and the name displayed during scanning is correct.
- Heart rate scales, regardless of whether the heart rate indicator is open, the SDK will send heart rate indicators
- Data or device listening for callbacks, callback multiple times at the same time
- First determine if you have set up multiple listens. Must be set to null when the listener is not in use
- Determine if it is a shoe-wearing measurement, which may result in multiple measurements being completed in a short period of time.

Dvelopers  provide logs  so that we can find the problem as soon as possible.
