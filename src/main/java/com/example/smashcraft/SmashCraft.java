package com.example.smashcraft;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = SmashCraft.MODID, version = SmashCraft.VERSION)
public class SmashCraft {
    public static final String MODID = "smashcraft";
    public static final String VERSION = "1.0";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // 注册物品、方块等
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        // 注册事件处理器
    }
} 