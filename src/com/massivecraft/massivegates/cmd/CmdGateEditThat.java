package com.massivecraft.massivegates.cmd;

import org.bukkit.Location;
import org.bukkit.block.Block;

import com.massivecraft.massivegates.Conf;
import com.massivecraft.massivegates.Gate;
import com.massivecraft.massivegates.GateCommand;
import com.massivecraft.massivegates.Permission;
import com.massivecraft.massivegates.WorldCoord3;
import com.massivecraft.massivegates.cmdreq.ReqGateSelected;
import com.massivecraft.massivegates.util.VisualizeUtil;
import com.massivecraft.mcore3.cmd.req.ReqHasPerm;
import com.massivecraft.mcore3.cmd.req.ReqIsPlayer;
import com.massivecraft.mcore3.util.SmokeUtil;

public class CmdGateEditThat extends GateCommand
{
	public CmdGateEditThat()
	{
		super();
		this.addAliases("that");
		this.addRequiredArg("frame|content|del");
		this.addRequirements(ReqIsPlayer.getInstance(), ReqGateSelected.getInstance());
		this.addRequirements(new ReqHasPerm(Permission.EDIT_THAT.node));
	}
	
	@Override
	public void perform()
	{
		Gate gate = gme.getSelectedGate();
		
		Block thatBlock = gme.getThatBlock(true);
		if (thatBlock == null) return;
		
		Location thatLoc = thatBlock.getLocation();
		WorldCoord3 thatCoord = new WorldCoord3(thatBlock);
		
		char firstArgChar = this.arg(0).toLowerCase().charAt(0);
		
		if (firstArgChar == 'f')
		{
			gate.addFrame(thatCoord);
			VisualizeUtil.addLocation(me, thatLoc, Conf.visFrame);
			SmokeUtil.spawnCloudSimple(thatLoc);
		}
		else if (firstArgChar == 'c')
		{
			gate.addContent(thatCoord);
			VisualizeUtil.addLocation(me, thatLoc, Conf.visContent);
			SmokeUtil.spawnCloudSimple(thatLoc);	
		}
		else if (firstArgChar == 'd')
		{
			gate.delContent(thatCoord);
			gate.delFrame(thatCoord);
			SmokeUtil.spawnCloudSimple(thatLoc);	
		}
		else
		{
			this.msg("<b>arg must be frame|content|del");
		}
	}
}