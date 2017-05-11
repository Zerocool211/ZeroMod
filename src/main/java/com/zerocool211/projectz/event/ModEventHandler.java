package com.zerocool211.projectz.event;

import com.zerocool211.projectz.common.ModItems;
import com.zerocool211.projectz.items.ModTablet;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import java.util.Random;

public class ModEventHandler
{

    public static Random random;

    @SubscribeEvent
    public void entityJoinWorld(EntityJoinWorldEvent event)
    {
        //todo
    }

    @SubscribeEvent
    public void livingHurt(LivingHurtEvent event)
    {
        //todo
    }

    @SubscribeEvent
    public void itemPickup(PlayerEvent.ItemPickupEvent event)
    {
        if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(Blocks.COBBLESTONE)))
        {
            InventoryPlayer inventory = event.player.inventory;
            if (inventory.hasItemStack(new ItemStack(ModItems.destructionTablet)) && inventory.hasItemStack(new ItemStack(ModItems.fakeDiamond)) && inventory.hasItemStack(new ItemStack(ModTablet.fuelItem)) && !event.player.isSneaking() || inventory.hasItemStack(new ItemStack(ModItems.destructionTablet)) && inventory.hasItemStack(new ItemStack(ModItems.fakeDiamond)) && !event.player.isSneaking() && event.player.isCreative())
            {
                if(!event.player.isCreative())
                {
                    ModTablet.removeFuelItem(event.player);
                }
                removeItem(event.player, new ItemStack(Blocks.COBBLESTONE));
            }
        }

        if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(Blocks.WOOL)))
        {
            InventoryPlayer inventory = event.player.inventory;
            if(event.player.getHeldItemMainhand() != null)
            {
                if (event.player.getHeldItemMainhand().getItem() == ModItems.reversingTablet && inventory.hasItemStack(new ItemStack(ModTablet.fuelItem)) ||event.player.getHeldItemMainhand().getItem() == ModItems.reversingTablet && event.player.isCreative())
                {
                    if(!event.player.isCreative())
                    {
                        ModTablet.removeFuelItem(event.player);
                    }
                    ModTablet.removeItem(event.player, new ItemStack(Blocks.WOOL));
                    inventory.addItemStackToInventory(new ItemStack(Items.STRING, 4));
                }
            }
        }

        if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(Items.BOOK)))
        {
            InventoryPlayer inventory = event.player.inventory;
            if(event.player.getHeldItemMainhand() != null)
            {
                if (event.player.getHeldItemMainhand().getItem() == ModItems.reversingTablet && inventory.hasItemStack(new ItemStack(ModTablet.fuelItem)) ||event.player.getHeldItemMainhand().getItem() == ModItems.reversingTablet && event.player.isCreative())
                {
                    if(!event.player.isCreative())
                    {
                        ModTablet.removeFuelItem(event.player);
                    }
                    ModTablet.removeItem(event.player, new ItemStack(Items.BOOK));
                    inventory.addItemStackToInventory(new ItemStack(Items.PAPER, 3));
                    inventory.addItemStackToInventory(new ItemStack(Items.LEATHER, 1));
                }
            }
        }
    }

    public void removeItem(EntityPlayer ep, ItemStack removeitem)
    {
        IInventory inv = ep.inventory;
        for(int i=0; i < inv.getSizeInventory(); i++)
        {
            if(inv.getStackInSlot(i) != null)
            {
                ItemStack j = inv.getStackInSlot(i);
                if(j.getItem() != null && j.getItem() == removeitem.getItem())
                {
                    inv.setInventorySlotContents(i, null);
                }
            }
        }
    }

    @SubscribeEvent
    public void livingUpdate(LivingEvent.LivingUpdateEvent event)
    {
        //todo
    }

    @SubscribeEvent
    public void itemTooltip(ItemTooltipEvent event)
    {
        //todo
    }

    @SubscribeEvent
    public void blockBreak(BlockEvent.BreakEvent event)
    {
        //todo
    }

    @SubscribeEvent
    public void onPlayerPickupXP(PlayerPickupXpEvent event)
    {
        //todo
    }

}
