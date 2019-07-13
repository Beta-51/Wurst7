/*
 * Copyright (C) 2014 - 2019 | Wurst-Imperium | All rights reserved.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.wurstclient.command;

import java.util.Objects;

import net.wurstclient.Feature;
import net.wurstclient.util.ChatUtils;

public abstract class Command extends Feature
{
	private final String name;
	private final String description;
	private final String[] syntax;
	
	public Command(String name, String description, String... syntax)
	{
		this.name = Objects.requireNonNull(name);
		this.description = Objects.requireNonNull(description);
		
		Objects.requireNonNull(syntax);
		if(syntax.length > 0)
			syntax[0] = "Syntax: " + syntax[0];
		this.syntax = syntax;
	}
	
	public abstract void call(String[] args) throws CmdException;
	
	public final String getName()
	{
		return name;
	}
	
	public final String[] getSyntax()
	{
		return syntax;
	}
	
	public final void printHelp()
	{
		for(String line : description.split("\n"))
			ChatUtils.message(line);
		
		for(String line : syntax)
			ChatUtils.message(line);
	}
}