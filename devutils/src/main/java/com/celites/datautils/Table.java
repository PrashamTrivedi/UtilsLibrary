package com.celites.datautils;

import java.util.ArrayList;

/**
 * Helper for creating a table
 * Created by Prasham on 21-02-2015.
 */
public class Table {

	private String name;
	private boolean exists;
	private ArrayList<Column> columns;

	private Table(String name,boolean ifNotExists){
		this.name = name;
		exists = ifNotExists;
		columns = new ArrayList<Column>();
	}

	/**
	 *Creates a table
	 * @param name : Name of table
	 * @param ifNotExists: if true if not exists will be appended
	 * @return: Table object
	 */
	public static Table createTable(String name,boolean ifNotExists){
		return new Table(name, ifNotExists);
	}

	public Table addColumn(Column column){
		columns.add(column);
		return this;
	}


	public Table addColumns(Column... columnArray) {
		for (Column column : columnArray) {
		  columns.add(column);
		}
		return this;
	}


}
