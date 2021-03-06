package com.massivecraft.massivegates.ta;

public class TriggerOpen extends BaseTrigger
{
	protected static TriggerOpen instance = new TriggerOpen();
	public static TriggerOpen getInstance() { return instance; }
	protected TriggerOpen()
	{
		super("mgcore_open", "Open", "When the gate opens.");
	}
}