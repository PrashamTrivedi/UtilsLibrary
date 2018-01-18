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
import android.support.annotation.RequiresApi
import android.telecom.TelecomManager
import android.telephony.TelephonyManager
import android.view.LayoutInflater
import android.view.WindowManager
import android.view.accessibility.AccessibilityManager
import android.view.accessibility.CaptioningManager
import android.view.inputmethod.InputMethodManager
import android.view.textservice.TextServicesManager


inline val Context.accessibilityManager: AccessibilityManager?
    get() =
    getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager

inline val Context.accountManager: AccountManager?
    get() =
    getSystemService(Context.ACCOUNT_SERVICE) as AccountManager

inline val Context.activityManager: ActivityManager
    get() =
    getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

inline val Context.alarmManager: AlarmManager
    get() =
    getSystemService(Context.ALARM_SERVICE) as AlarmManager


inline val Context.appWidgetManager: AppWidgetManager?
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP) get() =
    getSystemService(Context.APPWIDGET_SERVICE) as AppWidgetManager


inline val Context.appOpsManager: AppOpsManager?
    @RequiresApi(Build.VERSION_CODES.KITKAT) get() =
    getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager

inline val Context.audioManager: AudioManager
    get() =
    getSystemService(Context.AUDIO_SERVICE) as AudioManager

inline val Context.batteryManager: BatteryManager?
    @TargetApi(Build.VERSION_CODES.LOLLIPOP) get() =
    getSystemService(Context.BATTERY_SERVICE) as BatteryManager

inline val Context.bluetoothAdapter: BluetoothManager?
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2) get() =
    getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager


inline val Context.cameraManager: CameraManager?
    @TargetApi(Build.VERSION_CODES.LOLLIPOP) get() =
    getSystemService(Context.CAMERA_SERVICE) as CameraManager

inline val Context.captioningManager: CaptioningManager?
    @TargetApi(Build.VERSION_CODES.KITKAT) get() =
    getSystemService(Context.CAPTIONING_SERVICE) as CaptioningManager

val Context.clipboardManager: ClipboardManager
    get() =
    getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

val Context.connectivityManager: ConnectivityManager
    get() =
    getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

inline val Context.consumerIrManager: ConsumerIrManager?
    @TargetApi(Build.VERSION_CODES.KITKAT) get() =
    getSystemService(Context.CONSUMER_IR_SERVICE) as ConsumerIrManager

inline val Context.devicePolicyManager: DevicePolicyManager?
    get() =
    getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager

inline val Context.displayManager: DisplayManager?
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1) get() =
    getSystemService(Context.DISPLAY_SERVICE) as DisplayManager

inline val Context.downloadManager: DownloadManager?
    get() =
    getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

inline val Context.dropBoxManager: DropBoxManager?
    get() =
    getSystemService(Context.DROPBOX_SERVICE) as DropBoxManager

inline val Context.inputMethodManager: InputMethodManager?
    get() =
    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

inline val Context.inputManager: InputManager?
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN) get() =
    getSystemService(Context.INPUT_SERVICE) as InputManager

inline val Context.jobScheduler: JobScheduler?
    @TargetApi(Build.VERSION_CODES.LOLLIPOP) get() =
    getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler

inline val Context.keyguardManager: KeyguardManager
    get() =
    getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager

inline val Context.launcherApps: LauncherApps?
    @TargetApi(Build.VERSION_CODES.LOLLIPOP) get() =
    getSystemService(Context.LAUNCHER_APPS_SERVICE) as LauncherApps

inline val Context.layoutInflater: LayoutInflater
    get() =
    getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

inline val Context.locationManager: LocationManager
    get() =
    getSystemService(Context.LOCATION_SERVICE) as LocationManager

inline val Context.mediaProjectionManager: MediaProjectionManager?
    @TargetApi(Build.VERSION_CODES.LOLLIPOP) get() =
    getSystemService(Context.MEDIA_PROJECTION_SERVICE) as MediaProjectionManager

inline val Context.mediaRouter: MediaRouter?
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN) get() =
    getSystemService(Context.MEDIA_ROUTER_SERVICE) as MediaRouter

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
inline fun Context.mediaSessionManager(): MediaSessionManager? =
        getSystemService(Context.MEDIA_SESSION_SERVICE) as MediaSessionManager

inline val Context.nfcManager: NfcManager?
    get() =
    getSystemService(Context.NFC_SERVICE) as NfcManager

inline val Context.notificationManager: NotificationManager
    get() =
    getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

inline val Context.nsdManager: NsdManager?
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN) get() =
    getSystemService(Context.NSD_SERVICE) as NsdManager

inline val Context.powerManager: PowerManager
    get() =
    getSystemService(Context.POWER_SERVICE) as PowerManager

inline val Context.printManager: PrintManager?
    @TargetApi(Build.VERSION_CODES.KITKAT) get() =
    getSystemService(Context.PRINT_SERVICE) as PrintManager

inline val Context.restrictionsManager: RestrictionsManager?
    @TargetApi(Build.VERSION_CODES.LOLLIPOP) get() =
    getSystemService(Context.RESTRICTIONS_SERVICE) as RestrictionsManager

inline val Context.searchManager: SearchManager
    get() =
    getSystemService(Context.SEARCH_SERVICE) as SearchManager

inline val Context.sensorManager: SensorManager
    get() =
    getSystemService(Context.SENSOR_SERVICE) as SensorManager

inline val Context.storageManager: StorageManager?
    get() =
    getSystemService(Context.STORAGE_SERVICE) as StorageManager

inline val Context.telecomManager: TelecomManager?
    @TargetApi(Build.VERSION_CODES.LOLLIPOP) get() =
    getSystemService(Context.TELECOM_SERVICE) as TelecomManager

inline val Context.telephonyManager: TelephonyManager
    get() =
    getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

inline val Context.textServicesManager: TextServicesManager?
    get() =
    getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE) as TextServicesManager

inline val Context.tvInputManager: TvInputManager?
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    get() =
    getSystemService(Context.TV_INPUT_SERVICE) as TvInputManager

inline val Context.uiModeManager: UiModeManager?
    get() =
    getSystemService(Context.UI_MODE_SERVICE) as UiModeManager

inline val Context.usbManager: UsbManager?
    get() =
    getSystemService(Context.USB_SERVICE) as UsbManager

inline val Context.userManager: UserManager?
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1) get() =
    getSystemService(Context.USER_SERVICE) as UserManager

inline val Context.vibrator: Vibrator
    get() =
    getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

inline val Context.wallpaperService: WallpaperService
    get() =
    getSystemService(Context.WALLPAPER_SERVICE) as WallpaperService

inline val Context.wifiP2pManager: WifiP2pManager?
    get() =
    getSystemService(Context.WIFI_P2P_SERVICE) as WifiP2pManager

inline val Context.wifiManager: WifiManager
    @SuppressLint("WifiManagerLeak")
    get() =
    getSystemService(Context.WIFI_SERVICE) as WifiManager

inline val Context.windowService: WindowManager
    get() =
    getSystemService(Context.WINDOW_SERVICE) as WindowManager
