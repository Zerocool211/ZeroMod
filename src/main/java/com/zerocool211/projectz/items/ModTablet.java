package com.zerocool211.projectz.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Random;

public class ModTablet extends ModItem
{

    public static Random random;
    public static Item fuelItem;
    public static int useChance;

    public ModTablet(String name)
    {
        super(name);
        this.setMaxStackSize(1);
    }

    public static void initTabletValues()
    {
        fuelItem = Items.COAL;
        useChance = 5;
    }

    public void removeItem(EntityPlayer ep, ItemStack removeitem) {
        IInventory inv = ep.inventory;
        for(int i=0; i < inv.getSizeInventory(); i++)
        {
            if(inv.getStackInSlot(i) != null)
            {
                ItemStack j = inv.getStackInSlot(i);
                if(j.getItem() != null && j.getItem() == removeitem.getItem())
                {
                    inv.decrStackSize(i, 1);
                    ep.inventoryContainer.detectAndSendChanges();
                    //break;
                }
            }
        }
    }

}
