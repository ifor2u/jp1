package jp1;

public class Element {
	private String unitName;
	private String horizontalPixelPosition;
	private String verticalPixelPosition;

	public Element(String unitName, String horizontalPixelPosition,
			String verticalPixelPosition) {
		this.unitName = unitName;
		this.horizontalPixelPosition = horizontalPixelPosition;
		this.verticalPixelPosition = verticalPixelPosition;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getVerticalPixelPosition() {
		return verticalPixelPosition;
	}

	public void setVerticalPixelPosition(String verticalPixelPosition) {
		this.verticalPixelPosition = verticalPixelPosition;
	}

	public String getHorizontalPixelPosition() {
		return horizontalPixelPosition;
	}

	public void setHorizontalPixelPosition(String horizontalPixelPosition) {
		this.horizontalPixelPosition = horizontalPixelPosition;
	}
}
