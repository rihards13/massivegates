package com.massivecraft.massivegates.cmd;

import com.massivecraft.massivegates.Gate;
import com.massivecraft.massivegates.GateCommand;
import com.massivecraft.massivegates.Permission;
import com.massivecraft.massivegates.cmdreq.ReqGateSelected;
import com.massivecraft.mcore3.cmd.req.ReqHasPerm;
import com.massivecraft.mcore3.cmd.req.ReqIsPlayer;

public class CmdGateNameSet extends GateCommand
{
	public CmdGateNameSet()
	{
		super();
		this.addAliases("set");
		this.addRequiredArg("name");
		this.addRequirements(ReqIsPlayer.getInstance(), ReqGateSelected.getInstance());
		this.addRequirements(new ReqHasPerm(Permission.NAME_SET.node));
	}
	
	@Override
	public void perform()
	{
		Gate gate = gme.getSelectedGate();
		String name = this.arg(0);
		gate.setName(name);
		this.msg("<i>Name updated: Gate "+gate.getIdNameStringShort()+"<i>.");
	}
}