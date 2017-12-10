package jp1;

public class Arrow {
	private String forwardUnitName;
	private String terminalUnitName;
	private String connectType;

	public String toString() {
		return forwardUnitName + "->" + terminalUnitName + " " + connectType;
	}

	public Arrow(String forwardUnitName, String terminalUnitName,
			String connectType) {
		this.forwardUnitName = forwardUnitName;
		this.terminalUnitName = terminalUnitName;
		this.connectType = connectType;
	}

	public String getForwardUnitName() {
		return forwardUnitName;
	}

	public void setForwardUnitName(String forwardUnitName) {
		this.forwardUnitName = forwardUnitName;
	}

	public String getConnectType() {
		return connectType;
	}

	public void setConnectType(String connectType) {
		this.connectType = connectType;
	}

	public String getTerminalUnitName() {
		return terminalUnitName;
	}

	public void setTerminalUnitName(String terminalUnitName) {
		this.terminalUnitName = terminalUnitName;
	}
}
