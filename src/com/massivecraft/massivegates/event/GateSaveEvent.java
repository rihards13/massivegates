package com.massivecraft.massivegates.event;

import com.massivecraft.massivegates.Gate;
import com.massivecraft.massivegates.event.abs.SingleGateEvent;

@SuppressWarnings("serial")
public class GateSaveEvent extends SingleGateEvent
{
	public GateSaveEvent(Gate gate)
	{
		super("GateSaveEvent", gate);
	}
}
