package com.example.smashcraft.events;

import com.example.smashcraft.abilities.SteveAbilities;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class PlayerEventHandler {
    private boolean isAttacking = false;
    private int attackCooldown = 0;

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            EntityPlayer player = event.player;
            
            // 处理攻击冷却
            if (attackCooldown > 0) {
                attackCooldown--;
            }
            
            // 处理连击系统
            if (isAttacking && attackCooldown == 0) {
                SteveAbilities.basicAttack(player, player.world);
                attackCooldown = 10; // 设置攻击冷却时间
            }
        }
    }

    @SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent event) {
        EntityPlayer player = event.getEntityPlayer();
        
        // 处理特殊技能
        if (event instanceof PlayerInteractEvent.RightClickItem) {
            SteveAbilities.placeBlock(player, player.world);
        } else if (event instanceof PlayerInteractEvent.LeftClickBlock) {
            SteveAbilities.miningAttack(player, player.world);
        }
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        // 处理键盘输入
        // 这里可以添加特殊技能的按键绑定
    }
} 