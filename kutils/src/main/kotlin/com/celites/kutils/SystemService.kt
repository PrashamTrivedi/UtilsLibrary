@file:JvmName("ServiceUtils")

/*
 * Copyright (C) 2015 Mobs & Geeks
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.celites.kutils

import android.accounts.AccountManager
import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.*
import android.app.admin.DevicePolicyManager
import android.app.job.JobScheduler
import android.appwidget.AppWidgetManager
import android.bluetooth.BluetoothManager
import android.content.ClipboardManager
import android.content.Context
import android.content.RestrictionsManager
import android.content.pm.LauncherApps
import android.hardware.ConsumerIrManager
import android.hardware.SensorManager
import android.hardware.camera2.CameraManager
import android.hardware.display.DisplayManager
import android.hardware.input.InputManager
import android.hardware.usb.UsbManager
import android.location.LocationManager
import android.media.AudioManager
import android.media.MediaRouter
import android.media.projection.MediaProjectionManager
import android.media.session.MediaSessionManager
import android.media.tv.TvInputManager
import android.net.ConnectivityManager
import android.net.nsd.NsdManager
import android.net.wifi.WifiManager
import android.net.wifi.p2p.WifiP2pManager
import android.nfc.NfcManager
import android.os.*
import android.os.storage.StorageManager
import android.print.PrintManager
import android.service.wallpaper.WallpaperService
import androidx.annotation.RequiresApi
import android.telecom.TelecomManager
import android.telephony.TelephonyManager
import android.view.LayoutInflater
import android.view.WindowManager
import android.view.accessibility.AccessibilityManager
import android.view.accessibility.CaptioningManager
import android.view.inputmethod.InputMethodManager
import android.view.textservice.TextServicesManager
import androidx.core.content.getSystemService


inline val Context.accessibilityManager: AccessibilityManager?
    get() = getSystemService()

inline val Context.accountManager: AccountManager?
    get() = getSystemService()

inline val Context.activityManager: ActivityManager?
    get() = getSystemService()

inline val Context.alarmManager: AlarmManager?
    get() = getSystemService()


inline val Context.appWidgetManager: AppWidgetManager?
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    get() = getSystemService()

inline val Context.appOpsManager: AppOpsManager?
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    get() = getSystemService()

inline val Context.audioManager: AudioManager?
    get() = getSystemService()

inline val Context.batteryManager: BatteryManager?
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    get() = getSystemService()

inline val Context.bluetoothAdapter: BluetoothManager?
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    get() = getSystemService()


inline val Context.cameraManager: CameraManager?
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    get() = getSystemService()

inline val Context.captioningManager: CaptioningManager?
    @TargetApi(Build.VERSION_CODES.KITKAT)
    get() = getSystemService()

val Context.clipboardManager: ClipboardManager?
    get() = getSystemService()

val Context.connectivityManager: ConnectivityManager?
    get() = getSystemService()

inline val Context.consumerIrManager: ConsumerIrManager?
    @TargetApi(Build.VERSION_CODES.KITKAT)
    get() = getSystemService()

inline val Context.devicePolicyManager: DevicePolicyManager?
    get() = getSystemService()

inline val Context.displayManager: DisplayManager?
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    get() = getSystemService()

inline val Context.downloadManager: DownloadManager?
    get() = getSystemService()

inline val Context.dropBoxManager: DropBoxManager?
    get() = getSystemService()

inline val Context.inputMethodManager: InputMethodManager?
    get() = getSystemService()

inline val Context.inputManager: InputManager?
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    get() = getSystemService()

inline val Context.jobScheduler: JobScheduler?
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    get() = getSystemService()

inline val Context.keyguardManager: KeyguardManager?
    get() = getSystemService()

inline val Context.launcherApps: LauncherApps?
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    get() = getSystemService()

inline val Context.layoutInflater: LayoutInflater?
    get() = getSystemService()

inline val Context.locationManager: LocationManager?
    get() = getSystemService()

inline val Context.mediaProjectionManager: MediaProjectionManager?
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    get() = getSystemService()

inline val Context.mediaRouter: MediaRouter?
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    get() = getSystemService()

inline val Context.mediaSessionManager: MediaSessionManager?
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    get() = getSystemService()

inline val Context.nfcManager: NfcManager?
    get() = getSystemService()

inline val Context.notificationManager: NotificationManager?
    get() = getSystemService()

inline val Context.nsdManager: NsdManager?
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    get() = getSystemService()

inline val Context.powerManager: PowerManager?
    get() = getSystemService()

inline val Context.printManager: PrintManager?
    @TargetApi(Build.VERSION_CODES.KITKAT)
    get() = getSystemService()

inline val Context.restrictionsManager: RestrictionsManager?
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    get() = getSystemService()

inline val Context.searchManager: SearchManager?
    get() = getSystemService()

inline val Context.sensorManager: SensorManager?
    get() = getSystemService()

inline val Context.storageManager: StorageManager?
    get() = getSystemService()

inline val Context.telecomManager: TelecomManager?
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    get() = getSystemService()

inline val Context.telephonyManager: TelephonyManager?
    get() = getSystemService()

inline val Context.textServicesManager: TextServicesManager?
    get() = getSystemService()

inline val Context.tvInputManager: TvInputManager?
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    get() = getSystemService()

inline val Context.uiModeManager: UiModeManager?
    get() = getSystemService()

inline val Context.usbManager: UsbManager?
    get() = getSystemService()

inline val Context.userManager: UserManager?
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    get() = getSystemService()

inline val Context.vibrator: Vibrator?
    get() = getSystemService()

inline val Context.wallpaperService: WallpaperService?
    get() = getSystemService()

inline val Context.wifiP2pManager: WifiP2pManager?
    get() = getSystemService()

inline val Context.wifiManager: WifiManager?
    @SuppressLint("WifiManagerLeak")
    get() = getSystemService()

inline val Context.windowService: WindowManager?
    get() = getSystemService()
