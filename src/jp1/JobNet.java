package jp1;

import java.util.ArrayList;
import java.util.List;

public class JobNet extends Unit {
	private List<Element> elements = new ArrayList<Element>();

	public void addElement(Element element) {
		elements.add(element);
	}

	public List<Element> getElements() {
		return this.elements;
	}

	public String toString() {
		for (Arrow arrow : arrows) {
			System.out.println(arrow);
		}
		return getUnitName() + " " + getUnitType() + " "
				+ getVerticalIconCount() + " " + getHorizontalIconCount();
	}

	private String executeHostName;// ex

	public String getExecuteHostName() {
		return executeHostName;
	}

	public void setExecuteHostName(String executeHostName) {
		this.executeHostName = executeHostName;
	}

	public void addArrow(Arrow arrow) {
		arrows.add(arrow);
	}

	public List<Arrow> getArrows() {
		return this.arrows;
	}

	private List<Arrow> arrows = new ArrayList<Arrow>();// ar
	private String executionStartDate;// sd

	public String getExecutionStartDate() {
		return executionStartDate;
	}

	public void setExecutionStartDate(String executionStartDate) {
		this.executionStartDate = executionStartDate;
	}

	private String executionStartTime;// st

	public String getExecutionStartTime() {
		return executionStartTime;
	}

	public void setExecutionStartTime(String executionStartTime) {
		this.executionStartTime = executionStartTime;
	}

	private String cycle;// cy

	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	private String retention;// ha

	public String getRetention() {
		return retention;
	}

	public void setRetention(String retention) {
		this.retention = retention;
	}

	private String executionHostName;

	public String getExecutionHostName() {
		return executionHostName;
	}

	public void setExecutionHostName(String executionHostName) {
		this.executionHostName = executionHostName;
	}

	private List<Unit> children = new ArrayList<Unit>();

	public List<Unit> getChildren() {
		return this.children;
	}

	public void addChild(Unit unit) {
		children.add(unit);
	}

}
