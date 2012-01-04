package com.massivecraft.massivegates.cmd;

import com.massivecraft.massivegates.Gate;
import com.massivecraft.massivegates.GateCommand;
import com.massivecraft.massivegates.cmdreq.ReqGateSelected;
import com.massivecraft.mcore1.cmd.req.ReqIsPlayer;

public class CmdGateTargetGate extends GateCommand
{
	public CmdGateTargetGate()
	{
		super();
		this.addAliases("gate");
		this.addRequiredArg("targetgate");
		this.addRequirements(ReqIsPlayer.getInstance(), ReqGateSelected.getInstance());
	}
	
	@Override
	public void perform()
	{
		Gate gate = gme.getSelectedGate();
		
		Gate target = this.argAs(0, Gate.class);
		if (target == null) return;
		
		gate.setTargetGate(target);
		this.msg("<i>Gate "+gate.getIdNameStringShort()+" <i>now has target gate "+target.getIdNameStringShort()+"<i>.");
	}
}