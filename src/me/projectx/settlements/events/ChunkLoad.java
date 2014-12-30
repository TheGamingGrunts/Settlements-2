package me.projectx.settlements.events;

import org.bukkit.Chunk;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;

public class ChunkLoad implements Listener {
	
	@EventHandler
	public void onLoad(ChunkLoadEvent e){
		Chunk c = e.getChunk();
		//Need manager
	}
}
