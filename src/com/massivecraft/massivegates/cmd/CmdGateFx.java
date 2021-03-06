package com.massivecraft.massivegates.cmd;

import com.massivecraft.massivegates.GateCommand;
import com.massivecraft.mcore3.cmd.HelpCommand;

public class CmdGateFx extends GateCommand
{
	public CmdGateFx()
	{
		super();
		this.addAliases("fx");
		this.addSubCommand(new CmdGateFxAlt());
		this.addSubCommand(new CmdGateFxTest());
		this.setDesc("info on the special effects system");
		this.setHelp(
		"<i>This system is used by the triggeractions \"FXE\" and \"FXG\".",
		"<i>Effects are defined with a comma-list of base effects.",
		"<i>Some effects use a datavalue. Put an int after effect name.",
		"<i>Example: \"<h>smoke,potion5,fire<i>\". (potion got data=5)"
		);
	}
	
	@Override
	public void perform()
	{
		this.getCommandChain().add(this);
		HelpCommand.getInstance().execute(this.sender, this.args, this.commandChain);
	}
}