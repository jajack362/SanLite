/*
 * Copyright (c) 2020, Siraz <https://github.com/Sirazzz>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.chambersofxeric;

import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import javax.inject.Inject;
import java.awt.*;

public class ChambersOfXericDebugOverlay extends Overlay
{
	private final Client client;
	private final ChambersOfXericPlugin plugin;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	ChambersOfXericDebugOverlay(Client client, ChambersOfXericPlugin plugin)
	{
		this.client = client;
		this.plugin = plugin;
		panelComponent.setPreferredSize(new Dimension(300, 0));
		setPosition(OverlayPosition.TOP_LEFT);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.isInChambersOfXeric())
		{
			panelComponent.getChildren().clear();

			panelComponent.getChildren().add(TitleComponent.builder()
					.text("Chambers of Xeric debug")
					.build());

			panelComponent.getChildren().add(LineComponent.builder()
					.left("Game tick")
					.right("" + client.getTickCount())
					.build());

			panelComponent.getChildren().add(LineComponent.builder()
					.left("Client Tick")
					.right("" + client.getGameCycle())
					.build());

			panelComponent.getChildren().add(LineComponent.builder()
					.left("In Chambers of Xeric")
					.right("" + plugin.isInChambersOfXeric())
					.build());

			if (plugin.getCurrentRaid() != null)
			{
				panelComponent.getChildren().add(LineComponent.builder()
						.left("Current raid set")
						.right(String.valueOf(plugin.getCurrentRaid() != null))
						.build());

//				panelComponent.getChildren().add(LineComponent.builder()
//						.left("Healing cycles till reset")
//						.right("" + plugin.getCurrentRaid().getRemainingVasaHealingCycles())
//						.build());
//
//				panelComponent.getChildren().add(LineComponent.builder()
//						.left("Current crystal remaining cycles")
//						.right("" + ((plugin.getCurrentRaid().getStartVasaHealingCycle() +
//								plugin.getCurrentRaid().getRemainingVasaHealingCycles()) - client.getGameCycle()))
//						.build());

				if (plugin.getCurrentRaid().getAreaOfEffectProjectiles() != null)
				{
					panelComponent.getChildren().add(LineComponent.builder()
							.left("Number of AoE projectiles")
							.right("" + plugin.getCurrentRaid().getAreaOfEffectProjectiles().size())
							.build());
				}

				if (plugin.getCurrentRaid().getGraphicObjects() != null)
				{
					panelComponent.getChildren().add(LineComponent.builder()
							.left("Number of graphics objects")
							.right("" + plugin.getCurrentRaid().getGraphicObjects().size())
							.build());
				}

				if (plugin.getCurrentRaid().getGameObjects() != null)
				{
					panelComponent.getChildren().add(LineComponent.builder()
							.left("Number of encounter game objects")
							.right("" + plugin.getCurrentRaid().getGameObjects().size())
							.build());
				}

				panelComponent.getChildren().add(LineComponent.builder()
						.left("Number of alive vanguards")
						.right("" + plugin.getCurrentRaid().getAliveVanguards().size())
						.build());

				if (plugin.getCurrentRaid().getAliveVanguards().size() == 3)
				{
					panelComponent.getChildren().add(LineComponent.builder()
							.left("Vanguard 1 style")
							.right("" + plugin.getCurrentRaid().getAliveVanguards().get(0).getVangStyle().toString())
							.build());
					panelComponent.getChildren().add(LineComponent.builder()
							.left("Vanguard 1 health")
							.right("" + plugin.getCurrentRaid().getAliveVanguards().get(0).getVangPercent())
							.build());
					panelComponent.getChildren().add(LineComponent.builder()
							.left("Vanguard 2 style")
							.right("" + plugin.getCurrentRaid().getAliveVanguards().get(1).getVangStyle().toString())
							.build());
					panelComponent.getChildren().add(LineComponent.builder()
							.left("Vanguard 2 health")
							.right("" + plugin.getCurrentRaid().getAliveVanguards().get(1).getVangPercent())
							.build());
					panelComponent.getChildren().add(LineComponent.builder()
							.left("Vanguard 3 style")
							.right("" + plugin.getCurrentRaid().getAliveVanguards().get(2).getVangStyle().toString())
							.build());
					panelComponent.getChildren().add(LineComponent.builder()
							.left("Vanguard 3 health")
							.right("" + plugin.getCurrentRaid().getAliveVanguards().get(2).getVangPercent())
							.build());
				}
			}
			return panelComponent.render(graphics);
		}
		return null;
	}
}