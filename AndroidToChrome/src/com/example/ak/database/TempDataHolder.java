package com.example.ak.database;

import java.util.ArrayList;
import java.util.List;

public final class TempDataHolder {

	public static List<String> tempList;

	public TempDataHolder() {
		TempDataHolder.tempList = new ArrayList<String>();
	}

	public static void initializeTempDataHolder() {
		if (tempList == null) {
			TempDataHolder.tempList = new ArrayList<String>();
		}
	}

	public static List<String> getTempList() {
		return tempList;
	}

	public static void setTempList(List<String> tempList) {
		TempDataHolder.tempList = tempList;
	}

	public static String getAtIndex(int index) {
		return tempList.get(index);
	}

	public static void removeFromIndex(int index) {
		TempDataHolder.tempList.remove(index);
	}

	public static void removeAll() {
		if (tempList != null) {
			tempList.clear();
		}
	}

	public static List<String> getMessages() {
		return tempList;
	}

	public static void addString(String value) {
		if(tempList == null) {
			tempList = new ArrayList<String>();
		}
		tempList.add(value);
	}
	public static String getLastString() {
		if(tempList != null) {
			return tempList.get(tempList.size() -1);
		}
		else {
			return "null";
		}
	}
}
