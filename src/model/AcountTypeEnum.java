package model;

import java.util.List;
import java.util.ArrayList;

public enum AcountTypeEnum {

	/** 0 */
	Savings("Savings") {
	},
	/** 1 */
	Current("Current") {
	};
	
	/** The display name. */
	private String displayName;

	/**
	 * Instantiates a new Acount Type Enum.
	 *
	 * @param displayNameX
	 *            the display name X
	 */
	private AcountTypeEnum(String displayNameX) {
		displayName = displayNameX;
	}

	/**
	 * Gets the friendly name.
	 *
	 * @return the friendly name
	 */
	public String getFriendlyName() {
		return displayName;
	}
	
	// status list for active acount types
	public static List<AcountTypeEnum> getAcountTypeList() {
			List<AcountTypeEnum> up = new ArrayList<>();
			up.add(AcountTypeEnum.Savings);
			up.add(AcountTypeEnum.Current);
			return up;
	}
}
