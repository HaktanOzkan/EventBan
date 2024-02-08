package me.event.banlist;

import me.event.eventCustomFile;
import me.event.eventMessageFile;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockMultiPlaceEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreeperPowerEvent;
import org.bukkit.event.entity.EntityBreakDoorEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityCombustByBlockEvent;
import org.bukkit.event.entity.EntityCombustByEntityEvent;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityCreatePortalEvent;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityPortalEvent;
import org.bukkit.event.entity.EntityPortalExitEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.EntityTameEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.entity.EntityTeleportEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.HorseJumpEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.SheepDyeWoolEvent;
import org.bukkit.event.entity.SheepRegrowWoolEvent;
import org.bukkit.event.entity.SlimeSplitEvent;
import org.bukkit.event.entity.SpawnerSpawnEvent;
import org.bukkit.event.inventory.InventoryCreativeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.event.weather.LightningStrikeEvent;
import org.bukkit.event.weather.ThunderChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.PortalCreateEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class eventBannedListener_v1_8 implements Listener {
   @EventHandler
   public void BlockBreakEvents(BlockBreakEvent e) {
      Player player = e.getPlayer();
      if (eventCustomFile.get().getStringList("EventList-v1_8.Player.BlockBreakEvent").contains(player.getUniqueId().toString())) {
         e.setCancelled(true);
         player.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Player.Removed_Event")));
      }
   }

   @EventHandler
   public void BlockDamageEvents(BlockDamageEvent e) {
      Player player = e.getPlayer();
      if (eventCustomFile.get().getStringList("EventList-v1_8.Player.BlockDamageEvent").contains(player.getUniqueId().toString())) {
         e.setCancelled(true);
         player.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Player.Removed_Event")));
      }
   }

   @EventHandler
   public void BlockMultiPlaceEvents(BlockMultiPlaceEvent e) {
      Player player = e.getPlayer();
      if (eventCustomFile.get().getStringList("EventList-v1_8.Player.BlockMultiPlaceEvent").contains(player.getUniqueId().toString())) {
         e.setCancelled(true);
         player.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Player.Removed_Event")));
      }
   }

   @EventHandler
   public void BlockPlaceEvents(BlockPlaceEvent e) {
      Player player = e.getPlayer();
      if (eventCustomFile.get().getStringList("EventList-v1_8.Player.BlockPlaceEvent").contains(player.getUniqueId().toString())) {
         e.setCancelled(true);
         player.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Player.Removed_Event")));
      }
   }

   @EventHandler
   public void SignChangeEvents(SignChangeEvent e) {
      Player player = e.getPlayer();
      if (eventCustomFile.get().getStringList("EventList-v1_8.Player.SignChangeEvent").contains(player.getUniqueId().toString())) {
         e.setCancelled(true);
         player.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Player.Removed_Event")));
      }
   }

   @EventHandler
   public void InventoryCreativeEvents(InventoryCreativeEvent e) {
      Player player = (Player)e.getWhoClicked();
      if (eventCustomFile.get().getStringList("EventList-v1_8.Player.InventoryCreativeEvent").contains(player.getUniqueId().toString())) {
         e.setCancelled(true);
         player.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Player.Removed_Event")));
      }
   }

   @EventHandler
   public void PlayerToggleSprintEvents(PlayerToggleSprintEvent e) {
      Player player = e.getPlayer();
      if (eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerToggleSprintEvent").contains(player.getUniqueId().toString())) {
         if (player.isSprinting()) {
            player.removePotionEffect(PotionEffectType.SLOW);
         } else if (!player.isSprinting()) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1000000, 255, true, false));
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Player.Removed_Event")));
         }

      }
   }

   @EventHandler
   public void PlayerToggleFlightEvents(PlayerToggleFlightEvent e) {
      Player player = e.getPlayer();
      if (eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerToggleFlightEvent").contains(player.getUniqueId().toString())) {
         if (e.isFlying()) {
            e.setCancelled(true);
            player.setFlying(false);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Player.Removed_Event")));
         } else if (!e.isFlying()) {
            if (!player.isFlying()) {
               return;
            }

            e.setCancelled(true);
            player.setFlying(false);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Player.Removed_Event")));
         }

      }
   }

   @EventHandler
   public void PlayerTeleportEvents(PlayerTeleportEvent e) {
      Player player = e.getPlayer();
      if (eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerTeleportEvent").contains(player.getUniqueId().toString())) {
         e.setCancelled(true);
         player.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Player.Removed_Event")));
      }
   }

   @EventHandler
   public void PlayerMoveEvents(PlayerMoveEvent e) {
      Player player = e.getPlayer();
      if (eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerMoveEvent").contains(player.getUniqueId().toString())) {
         e.setCancelled(true);
         player.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Player.Removed_Event")));
      }
   }

   @EventHandler
   public void PlayerGameModeChangeEvents(PlayerGameModeChangeEvent e) {
      Player player = e.getPlayer();
      if (eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerGameModeChangeEvent").contains(player.getUniqueId().toString())) {
         e.setCancelled(true);
         player.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Player.Removed_Event")));
      }
   }

   @EventHandler
   public void PlayerDropItemEvents(PlayerDropItemEvent e) {
      Player player = e.getPlayer();
      if (eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerDropItemEvent").contains(player.getUniqueId().toString())) {
         e.setCancelled(true);
         player.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Player.Removed_Event")));
      }
   }

   @EventHandler
   public void AsyncPlayerChatEvents(AsyncPlayerChatEvent e) {
      Player player = e.getPlayer();
      if (eventCustomFile.get().getStringList("EventList-v1_8.Player.AsyncPlayerChatEvent").contains(player.getUniqueId().toString())) {
         e.setCancelled(true);
         player.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Player.Removed_Event")));
      }
   }

   @EventHandler
   public void PlayerBedEnterEvents(PlayerBedEnterEvent e) {
      Player player = e.getPlayer();
      if (eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerBedEnterEvent").contains(player.getUniqueId().toString())) {
         e.setCancelled(true);
         player.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Player.Removed_Event")));
      }
   }

   @EventHandler
   public void PlayerChangedWorldEvents(PlayerChangedWorldEvent e) {
      Player player = e.getPlayer();
      if (eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerBedLeaveEvent").contains(player.getUniqueId().toString())) {
         ((Cancellable)e).setCancelled(true);
         player.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Player.Removed_Event")));
      }
   }

   @EventHandler
   public void ChunkLoadEvents(ChunkLoadEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.ChunkLoadEvent")) {
         e.getWorld().unloadChunk(e.getChunk());
      }
   }

   @EventHandler
   public void PortalCreateEvents(PortalCreateEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.PortalCreateEvent")) {
         e.setCancelled(true);
         e.getEntity().sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Player.Removed_Event")));
      }
   }

   @EventHandler
   public void WeatherChangeEvents(WeatherChangeEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.WeatherChangeEvent")) {
         e.setCancelled(true);
      }
   }

   @EventHandler
   public void ThunderChangeEvents(ThunderChangeEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.ThunderChangeEvent")) {
         e.setCancelled(true);
      }
   }

   @EventHandler
   public void LightningStrikeEvents(LightningStrikeEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.LightningStrikeEvent")) {
         e.setCancelled(true);
      }
   }

   @EventHandler
   public void CreatureSpawnEvents(CreatureSpawnEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.CreatureSpawnEvent")) {
         e.setCancelled(true);
         e.getEntity().sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Player.Removed_Event")));
      }
   }

   @EventHandler
   public void CreeperPowerEvents(CreeperPowerEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.CreeperPowerEvent")) {
         e.setCancelled(true);
      }
   }

   @EventHandler
   public void EntityBreakDoorEvents(EntityBreakDoorEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityBreakDoorEvent")) {
         e.setCancelled(true);
      }
   }

   @EventHandler
   public void EntityChangeBlockEvents(EntityChangeBlockEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityChangeBlockEvent")) {
         e.setCancelled(true);
      }
   }

   @EventHandler
   public void EntityCreatePortalEvents(EntityCreatePortalEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityCreatePortalEvent")) {
         e.setCancelled(true);
      }
   }

   @EventHandler
   public void EntityCombustEvents(EntityCombustEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityCombustEvent")) {
         e.setCancelled(true);
      }
   }

   @EventHandler
   public void EntityCombustByEntityEvents(EntityCombustByEntityEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityCombustByEntityEvent")) {
         e.setCancelled(true);
      }
   }

   @EventHandler
   public void EntityCombustByBlockEvents(EntityCombustByBlockEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityCombustByBlockEvent")) {
         e.setCancelled(true);
      }
   }

   @EventHandler
   public void EntityDamageByBlockEvents(EntityDamageByBlockEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityDamageByBlockEvent")) {
         e.setCancelled(true);
      }
   }

   @EventHandler
   public void EntityDamageByEntityEvents(EntityDamageByEntityEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityDamageByEntityEvent")) {
         e.setCancelled(true);
         e.getEntity().sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Player.Removed_Event")));
      }
   }

   @EventHandler
   public void EntityDamageEvents(EntityDamageEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityDamageEvent")) {
         e.setCancelled(true);
      }
   }

   @EventHandler
   public void EntityDeathEvents(EntityDeathEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityDeathEvent")) {
         e.getEntity().setHealth(1.0D);
         e.getDrops().clear();
      }
   }

   @EventHandler
   public void EntityExplodeEvents(EntityExplodeEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityExplodeEvent")) {
         e.setCancelled(true);
      }
   }

   @EventHandler
   public void EntityPortalEnterEvents(EntityPortalEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityPortalEvent")) {
         e.setCancelled(true);
      }
   }

   @EventHandler
   public void EntityPortalExitEvents(EntityPortalExitEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityPortalExitEvent")) {
         e.setCancelled(true);
      }
   }

   @EventHandler
   public void EntityRegainHealthEvents(EntityRegainHealthEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityRegainHealthEvent")) {
         e.setCancelled(true);
      }
   }

   @EventHandler
   public void EntityShootBowEvents(EntityShootBowEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityShootBowEvent")) {
         e.setCancelled(true);
      }
   }

   @EventHandler
   public void EntitySpawnEvents(EntitySpawnEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntitySpawnEvent")) {
         e.setCancelled(true);
      }
   }

   @EventHandler
   public void EntityTameEvents(EntityTameEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityTameEvent")) {
         e.setCancelled(true);
      }
   }

   @EventHandler
   public void EntityTargetEvents(EntityTargetEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityTargetEvent")) {
         e.setCancelled(true);
      }
   }

   @EventHandler
   public void EntityTargetLivingEntityEvents(EntityTargetLivingEntityEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityTargetLivingEntityEvent")) {
         e.setCancelled(true);
      }
   }

   @EventHandler
   public void EntityTeleportEvents(EntityTeleportEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityTeleportEvent")) {
         e.setCancelled(true);
      }
   }

   @EventHandler
   public void FoodLevelChangeEvents(FoodLevelChangeEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.FoodLevelChangeEvent")) {
         e.setCancelled(true);
      }
   }

   @EventHandler
   public void ExplosionPrimeEvents(ExplosionPrimeEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.ExplosionPrimeEvent")) {
         e.setCancelled(true);
      }
   }

   @EventHandler
   public void HorseJumpEvents(HorseJumpEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.HorseJumpEvent")) {
         e.setCancelled(true);
         e.setPower(0.0F);
      }
   }

   @EventHandler
   public void ProjectileHitEvents(ProjectileHitEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.ProjectileHitEvent")) {
         e.setCancelled(true);
      }
   }

   @EventHandler
   public void SheepDyeWoolEvents(SheepDyeWoolEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.SheepDyeWoolEvent")) {
         e.setCancelled(true);
      }
   }

   @EventHandler
   public void SheepRegrowWoolEvents(SheepRegrowWoolEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.SheepRegrowWoolEvent")) {
         e.setCancelled(true);
      }
   }

   @EventHandler
   public void SlimeSplitEvents(SlimeSplitEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.SlimeSplitEvent")) {
         e.setCancelled(true);
      }
   }

   @EventHandler
   public void SpawnerSpawnEvents(SpawnerSpawnEvent e) {
      if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.SpawnerSpawnEvent")) {
         e.setCancelled(true);
      }
   }
}
