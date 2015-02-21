package com.ceelites.devutils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * Created by Prasham on 21-01-2015.
 */
public class SharedPreferenceUtils {
	private static SharedPreferenceUtils sharedPreferenceUtils;
	private SharedPreferences sharedPreferences;

	public static SharedPreferenceUtils initWith(SharedPreferences sharedPreferences) {

		if (sharedPreferenceUtils == null) {
			sharedPreferenceUtils = new SharedPreferenceUtils();
		}
		sharedPreferenceUtils.sharedPreferences = sharedPreferences;
		return sharedPreferenceUtils;
	}

	public static SharedPreferenceUtils initWith(Context context) {
		if (sharedPreferenceUtils == null) {
			sharedPreferenceUtils = new SharedPreferenceUtils();
		}
		sharedPreferenceUtils.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
		return sharedPreferenceUtils;
	}

	public void put(String key, Object value) {
		if (value.getClass().equals(String.class)) {
			putString(key, value.toString());
		} else if (value.getClass().equals(Integer.class)) {
			putInt(key, (Integer) value);
		} else if (value.getClass().equals(Float.class)) {
			putFloat(key, (Float) value);
		} else if (value.getClass().equals(Long.class)) {
			putLong(key, (Long) value);
		} else if (value.getClass().equals(Boolean.class)) {
			putBoolean(key, (Boolean) value);
		} else {
			putString(key, value.toString());
		}
	}


	public void putInt(String key, int value) {
		sharedPreferences.edit().putInt(key, value).commit();
	}

	public int getInt(String key, int defaultValue) {

		return sharedPreferences.getInt(key, defaultValue);
	}


	public void putString(String key, String value) {
		sharedPreferences.edit().putString(key, value).commit();
	}

	public String getString(String key, String defaultValue) {

		return sharedPreferences.getString(key, (defaultValue == null) ? "" : defaultValue);
	}

	public void putBoolean(String key, boolean value) {
		sharedPreferences.edit().putBoolean(key, value).commit();
	}

	public boolean getBoolean(String key, boolean defaultValue) {

		return sharedPreferences.getBoolean(key, defaultValue);
	}

	public void putLong(String key, long value) {
		sharedPreferences.edit().putLong(key, value).commit();
	}

	public long getLong(String key, long defaultValue) {

		return sharedPreferences.getLong(key, defaultValue);
	}

	public void putFloat(String key, float value) {
		sharedPreferences.edit().putFloat(key, value).commit();
	}

	public float getFloat(String key, float defaultValue) {

		return sharedPreferences.getFloat(key, defaultValue);
	}

	/**
	 * Extract number from string, failsafe. If the string is not a proper number it will always return 0;
	 *
	 * @param string
	 * 		: String that should be converted into a number
	 *
	 * @return : 0 if conversion to number is failed anyhow, otherwise converted number is returned
	 */
	public static int getNumber(CharSequence string) {
		int number = 0;
		if (!isEmptyString(string)) {
			if (TextUtils.isDigitsOnly(string)) {

				number = Integer.parseInt(string.toString());
			}
		}
		return number;
	}

	public static float getNumberFloat(CharSequence string) {
		float number = 0.0f;
		if (!isEmptyString(string)) {
			if (TextUtils.isDigitsOnly(string)) {

				number = Float.parseFloat(string.toString());
			}
		}
		return number;
	}

	public static long getNumberLong(CharSequence string) {
		long number = 0l;
		if (!isEmptyString(string)) {
			if (TextUtils.isDigitsOnly(string)) {

				number = Long.parseLong(string.toString());
			}
		}
		return number;
	}

	/**
	 * This method checks if the string is empty or having null value.
	 *
	 * @param string
	 * 		: Charsequence string to check.
	 *
	 * @return <code>true</code> if string is null, blank or having "null" as value
	 */
	public static boolean isEmptyString(CharSequence string) {
		return (TextUtils.isEmpty(string) || string.toString().equalsIgnoreCase("null"));
	}


	public boolean isValueExistForKey(String key) {
		boolean isValueExists;
		try {
			String string = getString(key, "");
			isValueExists = !string.equalsIgnoreCase("");
		} catch (ClassCastException e) {
			try {
				int anInt = getInt(key, 0);
				isValueExists = anInt != 0;
			} catch (ClassCastException e1) {
				try {
					long aLong = getLong(key, 0);
					isValueExists = aLong != 0;
				} catch (ClassCastException e2) {
					try {
						float aFloat = getFloat(key, 0f);
						isValueExists = aFloat != 0;
					} catch (ClassCastException e3) {
						try {
							boolean aBoolean = getBoolean(key, false);
							isValueExists = !aBoolean;
						} catch (Exception e4) {
							isValueExists = false;
							e.printStackTrace();
						}
					}

				}

			}
		} catch (Exception e) {
			isValueExists = false;
		}
		return isValueExists;
	}

	public Object get(String key) {
		try {
			return getString(key, null);
		} catch (ClassCastException e) {
			try {
				return getInt(key, 0);
			} catch (ClassCastException e1) {
				try {
					return getLong(key, 0);
				} catch (ClassCastException e2) {
					try {
						return getFloat(key, 0f);
					} catch (ClassCastException e3) {
						try {
							return getBoolean(key, false);
						} catch (Exception e4) {
							e.printStackTrace();
						}
					}

				}

			}
		}
		return null;
	}

	public void clear(String key) {
		sharedPreferences.edit().remove(key).commit();
	}
}
