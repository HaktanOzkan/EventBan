package me.event;

import java.util.List;
import me.event.banlist.eventBannedListener_v1_8;
import me.event.command.eventBanCommandMain;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class eventBan extends JavaPlugin {
   String version;

   public void onEnable() {
      try {
         this.version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
      } catch (ArrayIndexOutOfBoundsException var2) {
         return;
      }

      this.getServer().getPluginManager().registerEvents(new eventBannedListener_v1_8(), this);
      eventMessageFile.setup();
      eventMessageFile.get().addDefault("Messages.Prefix", "&c[A-EB Beta v0.0.3] ");
      eventMessageFile.get().addDefault("Messages.Player.Removed_Event", "&eRemoved from this event!");
      eventMessageFile.get().addDefault("Messages.Player.Not_Permission", "&eYou are not permission to use this command !");
      eventMessageFile.get().addDefault("Messages.Admin.Player_RTrue_Event", "&eThis player has restrictions!");
      eventMessageFile.get().addDefault("Messages.Admin.Player_True_Event", "&ePlayer ban has been activated!");
      eventMessageFile.get().addDefault("Messages.Admin.Player_RFalse_Event", "&eNo player restrictions!");
      eventMessageFile.get().addDefault("Messages.Admin.Player_False_Event", "&ePlayer ban has been deactivated!");
      eventMessageFile.get().addDefault("Messages.Admin.Player_Not_Found", "&ePlayer not found !");
      eventMessageFile.get().addDefault("Messages.Admin.Server_RTrue_Event", "&eThis feature is already active!");
      eventMessageFile.get().addDefault("Messages.Admin.Server_True_Event", "&eTransaction confirmed!");
      eventMessageFile.get().addDefault("Messages.Admin.Server_RFalse_Event", "&eThis feature is already deactive!");
      eventMessageFile.get().addDefault("Messages.Admin.Server_False_Event", "&eTransaction confirmed!");
      eventMessageFile.get().options().copyDefaults(true);
      eventMessageFile.save();
      eventCustomFile.setup();
      List<String> strList = eventCustomFile.get().getStringList("");
      eventCustomFile.get().addDefault("EventList-v1_8.Player.BlockBreakEvent", strList);
      eventCustomFile.get().addDefault("EventList-v1_8.Player.BlockDamageEvent", strList);
      eventCustomFile.get().addDefault("EventList-v1_8.Player.BlockMultiPlaceEvent", strList);
      eventCustomFile.get().addDefault("EventList-v1_8.Player.BlockPlaceEvent", strList);
      eventCustomFile.get().addDefault("EventList-v1_8.Player.SignChangeEvent", strList);
      eventCustomFile.get().addDefault("EventList-v1_8.Player.InventoryCreativeEvent", strList);
      eventCustomFile.get().addDefault("EventList-v1_8.Player.PlayerToggleSprintEvent", strList);
      eventCustomFile.get().addDefault("EventList-v1_8.Player.PlayerToggleFlightEvent", strList);
      eventCustomFile.get().addDefault("EventList-v1_8.Player.PlayerTeleportEvent", strList);
      eventCustomFile.get().addDefault("EventList-v1_8.Player.PlayerMoveEvent", strList);
      eventCustomFile.get().addDefault("EventList-v1_8.Player.PlayerGameModeChangeEvent", strList);
      eventCustomFile.get().addDefault("EventList-v1_8.Player.PlayerDropItemEvent", strList);
      eventCustomFile.get().addDefault("EventList-v1_8.Player.AsyncPlayerChatEvent", strList);
      eventCustomFile.get().addDefault("EventList-v1_8.Player.PlayerBedEnterEvent", strList);
      eventCustomFile.get().addDefault("EventList-v1_8.Player.PlayerChangedWorldEvent", strList);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.ChunkLoadEvent", false);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.PortalCreateEvent", false);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.WeatherChangeEvent", false);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.ThunderChangeEvent", false);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.LightningStrikeEvent", false);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.CreatureSpawnEvent", false);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.CreeperPowerEvent", false);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.EntityBreakDoorEvent", false);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.EntityChangeBlockEvent", false);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.EntityCreatePortalEvent", false);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.EntityCombustEvent", false);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.EntityCombustByEntityEvent", false);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.EntityCombustByBlockEvent", false);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.EntityDamageByBlockEvent", false);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.EntityDamageByEntityEvent", false);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.EntityDamageEvent", false);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.EntityDeathEvent", false);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.EntityExplodeEvent", false);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.EntityPortalEvent", false);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.EntityPortalExitEvent", false);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.EntityRegainHealthEvent", false);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.EntityShootBowEvent", false);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.EntitySpawnEvent", false);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.EntityTameEvent", false);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.EntityTargetEvent", false);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.EntityTargetLivingEntityEvent", false);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.EntityTeleportEvent", false);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.FoodLevelChangeEvent", false);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.ExplosionPrimeEvent", false);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.HorseJumpEvent", false);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.ProjectileHitEvent", false);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.SheepDyeWoolEvent", false);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.SheepRegrowWoolEvent", false);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.SlimeSplitEvent", false);
      eventCustomFile.get().addDefault("EventList-v1_8.Server.SpawnerSpawnEvent", false);
      eventCustomFile.get().options().copyDefaults(true);
      eventCustomFile.save();
      this.getLogger().info("Your server is running version " + this.version);
      this.getCommand("eventban").setExecutor(new eventBanCommandMain(this));
   }
}
