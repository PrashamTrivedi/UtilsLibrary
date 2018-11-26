# ChangeLog

### 1.0 - AndroidX version(Coming Soon)
- Started adding some documentation
- This library is dependent on AndroidX and Android-KTX. 
    - This removes many methods which are duplicate methods.
    - All the deprecations are meant to be removed in 1.1
- Added some date formatting methods in dates.
- Corrected inlining in lot of places
- Intents- Now you can pass data uri around intents and start activity methods
- Added share method in Intent Helpers
- Added `runAndLogException`: This method runs the block and when any exception occurs, logs this
 exception.
- Resources: Added font resource
- Views: Added some anim methods and read attribute method for custom views.
- Added utilities around date class

### 0.8
- Removed deprecated methods
- Added ability to have attachment to email.
- Added channel name parameter in generate notifications
- Added startActivity methods as Fragment's extensions
- Updated support libraries.

### 0.7.2
- AlertDialog can accept optional `themeId` parameter to add themes for dialog

### 0.7.1
- Version 0.7.1 fixes a small publishing issue
- Worked in Java interoperability
- All services are now extension properties
- Code cleanup
- Added methods from Anko



### 0.6
- Deprecation (Method removed in 0.8)
    -   `browse`, `email` functions are deprecated, please use `browseUrl` or `sendEmail` instead. These methods will be removed by 0.8

- Converted functions to properties. 
    - System services are available as extension properties Except
        - userManager
        - tvInputManager
        - telecomManager
        - restrictionsManager
        - nsdManager
        - mediaSessionManager
        - mediaProjectManager
        - launcherApps
        - jobScheduler
        - displayManager
        - consumerIrManager
        - captioningManager
        - cameraManager
        - bluetoothAdapter
        - batteryManager
        - appWidgetManager
        - appOpsManager
    - Current Platform Api is available as extension property of Any.
    - Version Name, Version Code is extension properties of Context
    - Document File's isVideo, isAudio, isImage are available as properties
    
- Many higherorder functions are available as inline (YAY for method counts)
- Some code cleanup

### 0.5
- New version, added many functions