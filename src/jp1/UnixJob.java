package jp1;

public class UnixJob extends Unit {
	private String commandText;// te

	public String getCommandText() {
		return commandText;
	}

	public void setCommandText(String commandText) {
		this.commandText = commandText;
	}

	private String environmentVariableFileName;// ev
	private String environmentVariable;// env
	private String executionHostName;// ex
	private String executionUserName;// un
	private String retention;// ha

	public void setExecutionUserName(String executionUserName) {
		this.executionUserName = executionUserName;
	}

	public String getExecutionUserName() {
		return this.executionUserName;
	}

	public String toString() {
		return getUnitName() + " " + getUnitType() + " " + executionUserName
				+ " " + getCommandText() + " " + getComment();
	}

	public String getRetention() {
		return retention;
	}

	public void setRetention(String retention) {
		this.retention = retention;
	}

	public String getExecutionHostName() {
		return executionHostName;
	}

	public void setExecutionHostName(String executionHostName) {
		this.executionHostName = executionHostName;
	}

	public String getEnvironmentVariable() {
		return environmentVariable;
	}

	public void setEnvironmentVariable(String environmentVariable) {
		this.environmentVariable = environmentVariable;
	}

	public String getEnvironmentVariableFileName() {
		return environmentVariableFileName;
	}

	public void setEnvironmentVariableFileName(
			String environmentVariableFileName) {
		this.environmentVariableFileName = environmentVariableFileName;
	}
}