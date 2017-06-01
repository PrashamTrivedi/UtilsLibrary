#ChangeLog

###0.6
- Deprecation
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

###0.5
- New version, added many functions