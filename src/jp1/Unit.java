package jp1;

public class Unit {
	private String unitType;// ty

	public String getUnitType() {
		return unitType;
	}

	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

	private String comment;// cm

	private String verticalIconCount;// sz
	private String horizontalIconCount;// sz

	private String unitName;
	private String jp1UserName;
	private Unit parent;

	public String getVerticalIconCount() {
		return verticalIconCount;
	}

	public void setVerticalIconCount(String verticalIconCount) {
		this.verticalIconCount = verticalIconCount;
	}

	public String getHorizontalIconCount() {
		return horizontalIconCount;
	}

	public void setHorizontalIconCount(String horizontalIconCount) {
		this.horizontalIconCount = horizontalIconCount;
	}

	public void setParent(Unit unit) {
		this.parent = unit;
	}

	public Unit getParent() {
		return this.parent;
	}

	public void setJp1UserName(String jp1UserName) {
		this.jp1UserName = jp1UserName;
	}

	public String getJp1UserName() {
		return this.jp1UserName;
	}

	public String getUnitName() {
		return this.unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String toString() {
		return unitName + " " + unitType;
	}
}

class NotImplementedUnit extends Unit {
}