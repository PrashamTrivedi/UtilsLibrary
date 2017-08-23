# ChangeLog

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