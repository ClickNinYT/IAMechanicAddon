package dev.clicknin.iamechanic.listener;

import dev.clicknin.iamechanic.ConfigHandler;
import dev.clicknin.iamechanic.Smelt;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Furnace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceBurnEvent;

import dev.lone.itemsadder.api.CustomStack;
import org.bukkit.inventory.FurnaceInventory;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class SmeltListener implements Listener {
    @EventHandler
    public void onFurnaceBurn(FurnaceBurnEvent event) {
        if (CustomStack.byItemStack(event.getFuel()) == null) return;
        Smelt smelt = (Smelt) ConfigHandler.smelt.get(CustomStack.byItemStack(event.getFuel()).getNamespacedID());
        if (smelt == null) return;
        event.setBurnTime(smelt.getBurnTime());
        Block furnace = event.getBlock();
        if (!Objects.equals(smelt.getReplacementItem(), "NONE") || CustomStack.isInRegistry(smelt.getReplacementItem())) {
            if (furnace.getState() instanceof Furnace) {
                Furnace furnaceData = (Furnace) furnace.getState();
                FurnaceInventory furnaceInventory = furnaceData.getInventory();
                furnaceInventory.setFuel(CustomStack.getInstance(smelt.getReplacementItem()).getItemStack());
            }
        }
        else {
            if (furnace.getState() instanceof Furnace) {
                Furnace furnaceData = (Furnace) furnace.getState();
                FurnaceInventory furnaceInventory = furnaceData.getInventory();
                furnaceInventory.setFuel(new ItemStack(Objects.requireNonNull(Material.AIR)));
            }
        }
    }
}
