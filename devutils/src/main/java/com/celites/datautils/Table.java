package com.celites.datautils;

import com.ceelites.devutils.ConstantMethods;
import java.util.ArrayList;

/**
 * Helper for creating a table Created by Prasham on 21-02-2015.
 */
public class Table {

	private String name;
	private boolean addIfNotExist;
	private ArrayList<Column> columns;

	private Table(String name, boolean addIfNotExists) {
		this.name = name;
		addIfNotExist = addIfNotExists;
		columns = new ArrayList<Column>();
	}

	/**
	 * Creates a table
	 *
	 * @param name
	 * 		: Name of table
	 * @param addIfNotExists:
	 * 		if true if not exists will be appended
	 *
	 * @return: Table object
	 */
	public static Table createTable(String name, boolean addIfNotExists) {
		return new Table(name, addIfNotExists);
	}

	public Table addColumn(Column column) {
		columns.add(column);
		return this;
	}


	public Table addColumns(Column... columnArray) {
		for (Column column : columnArray) {
			columns.add(column);
		}
		return this;
	}

	public String getGenerateTableQuery() throws NoColumnsException {
		if (ConstantMethods.isArrayListEmpty(columns)) {
			throw new NoColumnsException("Table " + name + " must have atleast one column");
		} else {
			StringBuilder query = new StringBuilder(" CREATE TABLE ");
			if (addIfNotExist) {
				query.append("IF NOT EXISTS ");
			}

			query.append("(");
			String columnDefinitions = "";
			for (Column column : columns) {
				columnDefinitions = ConstantMethods.addToCommaSeparatedString(columnDefinitions, column.getColumnDefinition(), false);
			}
			query.append(columnDefinitions).append(")");
			return query.toString();
		}
	}


}
