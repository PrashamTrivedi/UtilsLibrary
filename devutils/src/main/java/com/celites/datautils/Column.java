package com.celites.datautils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.ceelites.devutils.ConstantMethods;

/**
 * Helper for creating a column
 * Created by Prasham on 21-02-2015.
 */
public class Column {
	private String name;
	private String type;
	private String constraint;
	private String defaults;

	public Column(@NonNull String name, @NonNull String type, @Nullable String constraint, @Nullable String defaults) {
		this.name = name;
		this.type = type;
		if (ConstantMethods.isEmptyString(constraint)) {
			constraint = "";
		}
		this.constraint = constraint;
		if (ConstantMethods.isEmptyString(defaults)) {
			defaults = "";
		}
		this.defaults = defaults;
	}


	public static Column createColumn(@NonNull String name, @NonNull String type,@Nullable String constraint,@Nullable String defaults) {
		return new Column(name, type, constraint, defaults);
	}

	public static Column createPrimaryKeyColumn(@NonNull String name, @NonNull String type, boolean isAutoIncrement,@Nullable String defaults) {
		String constrain = "PRIMARY KEY " + ((isAutoIncrement) ? "AUTOINCREMENT" : "");
		return new Column(name, type, constrain, defaults);
	}

	public static Column createUniqueKeyColumn(@NonNull String name, String type, String defaults) {
		String constrain = "UNIQUE ";
		return new Column(name, type, constrain, defaults);
	}


	public String getColumnDefinition() {
		return name + " " + type + " " + constraint + " " + defaults;
	}
}
