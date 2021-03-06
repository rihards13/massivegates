package com.massivecraft.massivegates.ta;

public class TriggerPowerOff extends BaseTrigger
{
	protected static TriggerPowerOff instance = new TriggerPowerOff();
	public static TriggerPowerOff getInstance() { return instance; }
	protected TriggerPowerOff()
	{
		super("mgcore_power_off", "PowerOff", "Frame redstone power off.");
	}
}