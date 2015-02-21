package com.ceelites.devutils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.text.TextUtils;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Prasham on 21-01-2015.
 */
public class ConstantMethods {
	/**
	 * Checks whether device is connected or not
	 *
	 * @param context
	 * 		: Context to getNetwork Info
	 *
	 * @return: <code>true</code> if device is online, false otherwise.
	 */
	public static boolean isOnline(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		boolean connectedOrConnecting = false;
		try {
			connectedOrConnecting = cm.getActiveNetworkInfo().isConnectedOrConnecting();
		} catch (Exception e) {

			e.printStackTrace();
			connectedOrConnecting = false;
		}
		return connectedOrConnecting;

	}

	/**
	 * Checks if Intent is available or not
	 *
	 * @param context:
	 * 		Context to get package manager
	 * @param intent
	 * 		: Intent which is going to be checked
	 *
	 * @return : <code>true</code> if any activity is available to handle the intent, <code>false</code> otherwise
	 */
	public static boolean isIntentAvailable(Context context, Intent intent) {
		final PackageManager mgr = context.getPackageManager();
		List<ResolveInfo> list = mgr.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
		return list.size() > 0;
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

	/**
	 * Extract number from string, failsafe. If the string is not a proper number it will always return 0;
	 *
	 * @param string
	 * 		: String that should be converted into a number
	 *
	 * @return : 0 if conversion to number is failed anyhow, otherwise converted number is returned
	 */
	public static int getNumber(String string) {
		int number = 0;
		if (!isEmptyString(string)) {
			if (TextUtils.isDigitsOnly(string)) {
				number = Integer.parseInt(string);
			}
		}
		return number;
	}

	/**
	 * Is arraylist null or empty
	 *
	 * @param arrayList:
	 * 		ArrayList to check
	 *
	 * @return <code>true</code> is arraylist is null or empty.
	 */
	public static boolean isArrayListEmpty(ArrayList arrayList) {
		return arrayList == null || arrayList.isEmpty();
	}

	/**
	 * Apply Drawable tint to image view, works for Pre-Lollipop.
	 *
	 * @param res
	 * 		: Resources to fetch colors and (if needed drawable)
	 * @param imageView
	 * 		: Image view To tint.
	 * @param color
	 * 		: Color which should be applied on drawable
	 */
	public static void applyTintingToImageView(Resources res, ImageView imageView, @ColorRes int color) {
		Drawable drawable = imageView.getDrawable();
		imageView.setImageDrawable(applyTinting(res, drawable, color));
	}

	/**
	 * Gets tinted drawable to draw anywhere you need
	 *
	 * @param res
	 * 		: Resources to fetch colors and (if needed drawable)
	 * @param drawable
	 * 		: Drawable Resourse to tint
	 * @param color
	 * 		: Color which should be applied on drawable
	 *
	 * @return Drwable with applied color
	 */
	public static Drawable getTintedDrawable(Resources res, @DrawableRes Drawable drawable, @ColorRes int color) {
		return applyTinting(res, drawable, color);
	}

	/**
	 * Gets tinted drawable to draw anywhere you need
	 *
	 * @param res
	 * 		: Resources to fetch colors and (if needed drawable)
	 * @param drawable
	 * 		: Drawable to tint
	 * @param colorRes
	 * 		: Color which should be applied on drawable
	 *
	 * @return Drwable with applied color
	 */
	private static Drawable applyTinting(Resources res, Drawable drawable, @ColorRes int colorRes) {
		int color = res.getColor(colorRes);
		drawable.mutate();
		drawable.setColorFilter(color, Mode.SRC_IN);
		return drawable;

	}

	/**
	 * Does a split without throwing an exception and giving proper array.
	 *
	 * @param stringToSplit
	 * 		: String to split.
	 * @param delimiter:
	 * 		Delimiter to split with.
	 *
	 * @return An array of splitted values. If delimiter is found in stringToSplit split will be done with the help of <code>TextUtils .split</code>,
	 * else an array consisting only stringToSplit will be generated and returned
	 */
	public static String[] failSafeSplit(String stringToSplit, String delimiter) {
		if (stringToSplit.contains(delimiter)) {
			return TextUtils.split(stringToSplit, delimiter);
		} else {
			return new String[]{stringToSplit};
		}
	}

	/**
	 * Adds a string to comma separated String.
	 *
	 * @param commaSeparatedString:
	 * 		Comma separated String where new string is going to be added.
	 * @param stringToAdd:
	 * 		New String to add in comma separated string
	 * @param allowDuplicates
	 * 		if <code>false</code> stringToAdd will not be added in commaSeparatedString if it's already present.
	 *
	 * @return commaSeparatedString with stringToAdd added.
	 */
	public static String addToCommaSeparatedString(String commaSeparatedString, String stringToAdd, boolean allowDuplicates) {
		String joinedStrings;
		if (isEmptyString(commaSeparatedString)) {
			joinedStrings = stringToAdd;
		} else {
			String[] commaSeparatedStrings = failSafeSplit(commaSeparatedString, ",");
			ArrayList<String> commaSeparatedStringArray = (ArrayList<String>) Arrays.asList(commaSeparatedStrings);
			if (!allowDuplicates) {
				boolean isExists = false;
				for (String string : commaSeparatedStrings) {
					if (string.equalsIgnoreCase(stringToAdd)) {
						isExists = true;
						break;
					}
				}
				if (!isExists) {
					commaSeparatedStringArray.add(stringToAdd);
				}
			} else {
				commaSeparatedStringArray.add(stringToAdd);
			}
			joinedStrings = TextUtils.join(",", commaSeparatedStringArray);

		}
		return joinedStrings;
	}
}
