/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.api;

/**
 * Information about a specific {@link NpcID}
 */
public interface NPCComposition
{
	/**
	 * Gets the name of the NPC.
	 *
	 * @return the name
	 */
	String getName();

	/**
	 * Gets the model IDs that compose this NPC.
	 *
	 * @return the NPCs model IDs
	 */
	int[] getModels();

	/**
	 * The 5 menuops this NPC has when in world. Index 0 corresponds to
	 * {@link MenuAction#NPC_FIRST_OPTION}, Index 2 to
	 * {@link MenuAction#NPC_SECOND_OPTION} and so on.
	 */
	String[] getActions();

	/**
	 * Gets whether the NPC can be clicked.
	 *
	 * @return true if the NPC can be clicked, false otherwise
	 */
	boolean isClickable();

	/**
	 * Gets whether the NPC is a follower (pet)
	 *
	 * @return true if the NPC is a follower, false otherwise
	 */
	boolean isFollower();

	/**
	 * NPC can be interacting with via menu options
	 * @return true if the NPC can be interacted with, false otherwise
	 */
	boolean isInteractible();

	/**
	 * Gets whether the NPC is visible on the mini-map.
	 *
	 * @return the mini-map visible state
	 */
	boolean isMinimapVisible();

	/**
	 * Gets whether the NPC is visible.
	 *
	 * @return the visible state
	 */
	boolean isVisible();

	/**
	 * Gets the ID of the NPC.
	 *
	 * @return the ID of the NPC
	 * @see NpcID
	 */
	int getId();

	/**
	 * Gets the combat level of the NPC.
	 *
	 * @return the combat level, -1 if none
	 */
	int getCombatLevel();

	/**
	 * Get the {@link NpcID}s of NPCs this can transform into, depending
	 * on a {@link Varbits} or {@link VarPlayer}
	 */
	int[] getConfigs();

	/**
	 * Get the NPC composition the player's state says this NPC should
	 * transmogrify into.
	 *
	 * @throws NullPointerException if {@link #getConfigs()} is null
	 */
	NPCComposition transform();

	/**
	 * How many tiles wide this NPC is
	 */
	int getSize();

	/**
	 * Gets the displayed overhead icon of the NPC.
	 *
	 * @return the overhead icon
	 */
	HeadIcon getOverheadIcon();
}