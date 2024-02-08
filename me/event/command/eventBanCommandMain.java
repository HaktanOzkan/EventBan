package me.event.command;

import java.util.List;
import me.event.eventBan;
import me.event.eventCustomFile;
import me.event.eventMessageFile;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class eventBanCommandMain implements CommandExecutor {
   String version;
   public eventBan eventBan;

   public eventBanCommandMain(eventBan eventban) {
      this.eventBan = eventban;
   }

   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
      try {
         this.version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
      } catch (ArrayIndexOutOfBoundsException var8) {
         return true;
      }

      Player p = (Player)sender;
      if (!p.hasPermission("eventban.admin") && !p.isOp()) {
         p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " You are not permission to use this command !");
      } else if (args.length == 0) {
         p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eUsage :");
         p.sendMessage("");
         p.sendMessage("§e- §e/eventban [player_name] [event_name] [true/false]");
         p.sendMessage("§e- §7/eventban server [server_event_name] [true/false]");
         p.sendMessage("");
      } else if (args.length > 0) {
         Player target = Bukkit.getServer().getPlayerExact(args[0]);
         if (target != null) {
            if (args.length > 1) {
               List strList;
               if (args[1].equalsIgnoreCase("BlockBreakEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getStringList("EventList-v1_8.Player.BlockBreakEvent").contains(p.getUniqueId().toString())) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_RTrue_Event")));
                        } else {
                           strList = eventCustomFile.get().getStringList("EventList-v1_8.Player.BlockBreakEvent");
                           strList.add(p.getUniqueId().toString());
                           eventCustomFile.get().set("EventList-v1_8.Player.BlockBreakEvent", strList);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_True_Event")));
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (eventCustomFile.get().getStringList("EventList-v1_8.Player.BlockBreakEvent").contains(p.getUniqueId().toString())) {
                           strList = eventCustomFile.get().getStringList("EventList-v1_8.Player.BlockBreakEvent");
                           strList.remove(p.getUniqueId().toString());
                           eventCustomFile.get().set("EventList-v1_8.Player.BlockBreakEvent", strList);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_RFalse_Event")));
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("BlockDamageEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getStringList("EventList-v1_8.Player.BlockDamageEvent").contains(p.getUniqueId().toString())) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_RTrue_Event")));
                        } else {
                           strList = eventCustomFile.get().getStringList("EventList-v1_8.Player.BlockDamageEvent");
                           strList.add(p.getUniqueId().toString());
                           eventCustomFile.get().set("EventList-v1_8.Player.BlockDamageEvent", strList);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_True_Event")));
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (eventCustomFile.get().getStringList("EventList-v1_8.Player.BlockDamageEvent").contains(p.getUniqueId().toString())) {
                           strList = eventCustomFile.get().getStringList("EventList-v1_8.Player.BlockDamageEvent");
                           strList.remove(p.getUniqueId().toString());
                           eventCustomFile.get().set("EventList-v1_8.Player.BlockDamageEvent", strList);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_RFalse_Event")));
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("BlockMultiPlaceEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getStringList("EventList-v1_8.Player.BlockMultiPlaceEvent").contains(p.getUniqueId().toString())) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_RTrue_Event")));
                        } else {
                           strList = eventCustomFile.get().getStringList("EventList-v1_8.Player.BlockMultiPlaceEvent");
                           strList.add(p.getUniqueId().toString());
                           eventCustomFile.get().set("EventList-v1_8.Player.BlockMultiPlaceEvent", strList);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_True_Event")));
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (eventCustomFile.get().getStringList("EventList-v1_8.Player.BlockMultiPlaceEvent").contains(p.getUniqueId().toString())) {
                           strList = eventCustomFile.get().getStringList("EventList-v1_8.Player.BlockMultiPlaceEvent");
                           strList.remove(p.getUniqueId().toString());
                           eventCustomFile.get().set("EventList-v1_8.Player.BlockMultiPlaceEvent", strList);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_RFalse_Event")));
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("BlockPlaceEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getStringList("EventList-v1_8.Player.BlockPlaceEvent").contains(p.getUniqueId().toString())) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_RTrue_Event")));
                        } else {
                           strList = eventCustomFile.get().getStringList("EventList-v1_8.Player.BlockPlaceEvent");
                           strList.add(p.getUniqueId().toString());
                           eventCustomFile.get().set("EventList-v1_8.Player.BlockPlaceEvent", strList);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_True_Event")));
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (eventCustomFile.get().getStringList("EventList-v1_8.Player.BlockPlaceEvent").contains(p.getUniqueId().toString())) {
                           strList = eventCustomFile.get().getStringList("EventList-v1_8.Player.BlockPlaceEvent");
                           strList.remove(p.getUniqueId().toString());
                           eventCustomFile.get().set("EventList-v1_8.Player.BlockPlaceEvent", strList);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_RFalse_Event")));
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("SignChangeEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getStringList("EventList-v1_8.Player.SignChangeEvent").contains(p.getUniqueId().toString())) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_RTrue_Event")));
                        } else {
                           strList = eventCustomFile.get().getStringList("EventList-v1_8.Player.SignChangeEvent");
                           strList.add(p.getUniqueId().toString());
                           eventCustomFile.get().set("EventList-v1_8.Player.SignChangeEvent", strList);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_True_Event")));
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (eventCustomFile.get().getStringList("EventList-v1_8.Player.SignChangeEvent").contains(p.getUniqueId().toString())) {
                           strList = eventCustomFile.get().getStringList("EventList-v1_8.Player.SignChangeEvent");
                           strList.remove(p.getUniqueId().toString());
                           eventCustomFile.get().set("EventList-v1_8.Player.SignChangeEvent", strList);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_RFalse_Event")));
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("InventoryCreativeEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getStringList("EventList-v1_8.Player.InventoryCreativeEvent").contains(p.getUniqueId().toString())) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_RTrue_Event")));
                        } else {
                           strList = eventCustomFile.get().getStringList("EventList-v1_8.Player.InventoryCreativeEvent");
                           strList.add(p.getUniqueId().toString());
                           eventCustomFile.get().set("EventList-v1_8.Player.InventoryCreativeEvent", strList);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_True_Event")));
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (eventCustomFile.get().getStringList("EventList-v1_8.Player.InventoryCreativeEvent").contains(p.getUniqueId().toString())) {
                           strList = eventCustomFile.get().getStringList("EventList-v1_8.Player.InventoryCreativeEvent");
                           strList.remove(p.getUniqueId().toString());
                           eventCustomFile.get().set("EventList-v1_8.Player.InventoryCreativeEvent", strList);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_RFalse_Event")));
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("PlayerToggleSprintEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerToggleSprintEvent").contains(p.getUniqueId().toString())) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_RTrue_Event")));
                        } else {
                           strList = eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerToggleSprintEvent");
                           strList.add(p.getUniqueId().toString());
                           eventCustomFile.get().set("EventList-v1_8.Player.PlayerToggleSprintEvent", strList);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_True_Event")));
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerToggleSprintEvent").contains(p.getUniqueId().toString())) {
                           strList = eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerToggleSprintEvent");
                           strList.remove(p.getUniqueId().toString());
                           eventCustomFile.get().set("EventList-v1_8.Player.PlayerToggleSprintEvent", strList);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_RFalse_Event")));
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("PlayerToggleFlightEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerToggleFlightEvent").contains(p.getUniqueId().toString())) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_RTrue_Event")));
                        } else {
                           strList = eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerToggleFlightEvent");
                           strList.add(p.getUniqueId().toString());
                           eventCustomFile.get().set("EventList-v1_8.Player.PlayerToggleFlightEvent", strList);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_True_Event")));
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerToggleFlightEvent").contains(p.getUniqueId().toString())) {
                           strList = eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerToggleFlightEvent");
                           strList.remove(p.getUniqueId().toString());
                           eventCustomFile.get().set("EventList-v1_8.Player.PlayerToggleFlightEvent", strList);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_RFalse_Event")));
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("PlayerTeleportEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerTeleportEvent").contains(p.getUniqueId().toString())) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_RTrue_Event")));
                        } else {
                           strList = eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerTeleportEvent");
                           strList.add(p.getUniqueId().toString());
                           eventCustomFile.get().set("EventList-v1_8.Player.PlayerTeleportEvent", strList);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_True_Event")));
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerTeleportEvent").contains(p.getUniqueId().toString())) {
                           strList = eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerTeleportEvent");
                           strList.remove(p.getUniqueId().toString());
                           eventCustomFile.get().set("EventList-v1_8.Player.PlayerTeleportEvent", strList);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_RFalse_Event")));
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("PlayerMoveEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerMoveEvent").contains(p.getUniqueId().toString())) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_RTrue_Event")));
                        } else {
                           strList = eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerMoveEvent");
                           strList.add(p.getUniqueId().toString());
                           eventCustomFile.get().set("EventList-v1_8.Player.PlayerMoveEvent", strList);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_True_Event")));
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerMoveEvent").contains(p.getUniqueId().toString())) {
                           strList = eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerMoveEvent");
                           strList.remove(p.getUniqueId().toString());
                           eventCustomFile.get().set("EventList-v1_8.Player.PlayerMoveEvent", strList);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_RFalse_Event")));
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("PlayerGameModeChangeEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerGameModeChangeEvent").contains(p.getUniqueId().toString())) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_RTrue_Event")));
                        } else {
                           strList = eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerGameModeChangeEvent");
                           strList.add(p.getUniqueId().toString());
                           eventCustomFile.get().set("EventList-v1_8.Player.PlayerGameModeChangeEvent", strList);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_True_Event")));
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerGameModeChangeEvent").contains(p.getUniqueId().toString())) {
                           strList = eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerGameModeChangeEvent");
                           strList.remove(p.getUniqueId().toString());
                           eventCustomFile.get().set("EventList-v1_8.Player.PlayerGameModeChangeEvent", strList);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_RFalse_Event")));
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("PlayerDropItemEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerDropItemEvent").contains(p.getUniqueId().toString())) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_RTrue_Event")));
                        } else {
                           strList = eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerDropItemEvent");
                           strList.add(p.getUniqueId().toString());
                           eventCustomFile.get().set("EventList-v1_8.Player.PlayerDropItemEvent", strList);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_True_Event")));
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerDropItemEvent").contains(p.getUniqueId().toString())) {
                           strList = eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerDropItemEvent");
                           strList.remove(p.getUniqueId().toString());
                           eventCustomFile.get().set("EventList-v1_8.Player.PlayerDropItemEvent", strList);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_RFalse_Event")));
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("AsyncPlayerChatEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getStringList("EventList-v1_8.Player.AsyncPlayerChatEvent").contains(p.getUniqueId().toString())) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_RTrue_Event")));
                        } else {
                           strList = eventCustomFile.get().getStringList("EventList-v1_8.Player.AsyncPlayerChatEvent");
                           strList.add(p.getUniqueId().toString());
                           eventCustomFile.get().set("EventList-v1_8.Player.AsyncPlayerChatEvent", strList);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_True_Event")));
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (eventCustomFile.get().getStringList("EventList-v1_8.Player.AsyncPlayerChatEvent").contains(p.getUniqueId().toString())) {
                           strList = eventCustomFile.get().getStringList("EventList-v1_8.Player.AsyncPlayerChatEvent");
                           strList.remove(p.getUniqueId().toString());
                           eventCustomFile.get().set("EventList-v1_8.Player.AsyncPlayerChatEvent", strList);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_RFalse_Event")));
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("PlayerBedEnterEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerBedEnterEvent").contains(p.getUniqueId().toString())) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_RTrue_Event")));
                        } else {
                           strList = eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerBedEnterEvent");
                           strList.add(p.getUniqueId().toString());
                           eventCustomFile.get().set("EventList-v1_8.Player.PlayerBedEnterEvent", strList);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_True_Event")));
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerBedEnterEvent").contains(p.getUniqueId().toString())) {
                           strList = eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerBedEnterEvent");
                           strList.remove(p.getUniqueId().toString());
                           eventCustomFile.get().set("EventList-v1_8.Player.PlayerBedEnterEvent", strList);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_RFalse_Event")));
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("PlayerChangedWorldEvent") && args.length > 2) {
                  if (args[2].equalsIgnoreCase("true")) {
                     if (eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerChangedWorldEvent").contains(p.getUniqueId().toString())) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_RTrue_Event")));
                     } else {
                        strList = eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerChangedWorldEvent");
                        strList.add(p.getUniqueId().toString());
                        eventCustomFile.get().set("EventList-v1_8.Player.PlayerChangedWorldEvent", strList);
                        eventCustomFile.get().options().copyDefaults(true);
                        eventCustomFile.save();
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_True_Event")));
                     }
                  } else if (args[2].equalsIgnoreCase("false")) {
                     if (eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerChangedWorldEvent").contains(p.getUniqueId().toString())) {
                        strList = eventCustomFile.get().getStringList("EventList-v1_8.Player.PlayerChangedWorldEvent");
                        strList.remove(p.getUniqueId().toString());
                        eventCustomFile.get().set("EventList-v1_8.Player.PlayerChangedWorldEvent", strList);
                        eventCustomFile.get().options().copyDefaults(true);
                        eventCustomFile.save();
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_False_Event")));
                     } else {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_RFalse_Event")));
                     }
                  }
               }
            }
         } else if (args[0].equalsIgnoreCase("server")) {
            if (args.length > 1) {
               if (args[1].equalsIgnoreCase("ChunkLoadEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.ChunkLoadEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RTrue_Event")));
                        } else if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.ChunkLoadEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.ChunkLoadEvent", true);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_True_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check ChunkLoadEvent!");
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.ChunkLoadEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RFalse_Event")));
                        } else if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.ChunkLoadEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.ChunkLoadEvent", false);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check ChunkLoadEvent!");
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("PortalCreateEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.PortalCreateEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RTrue_Event")));
                        } else if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.PortalCreateEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.PortalCreateEvent", true);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_True_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check PortalCreateEvent!");
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.PortalCreateEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RFalse_Event")));
                        } else if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.PortalCreateEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.PortalCreateEvent", false);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check PortalCreateEvent!");
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("WeatherChangeEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.WeatherChangeEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RTrue_Event")));
                        } else if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.WeatherChangeEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.WeatherChangeEvent", true);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_True_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check WeatherChangeEvent!");
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.WeatherChangeEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RFalse_Event")));
                        } else if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.WeatherChangeEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.WeatherChangeEvent", false);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check WeatherChangeEvent!");
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("ThunderChangeEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.ThunderChangeEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RTrue_Event")));
                        } else if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.ThunderChangeEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.ThunderChangeEvent", true);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_True_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check ThunderChangeEvent!");
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.ThunderChangeEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RFalse_Event")));
                        } else if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.ThunderChangeEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.ThunderChangeEvent", false);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check ThunderChangeEvent!");
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("LightningStrikeEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.LightningStrikeEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RTrue_Event")));
                        } else if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.LightningStrikeEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.LightningStrikeEvent", true);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_True_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check LightningStrikeEvent!");
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.LightningStrikeEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RFalse_Event")));
                        } else if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.LightningStrikeEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.LightningStrikeEvent", false);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check LightningStrikeEvent!");
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("CreatureSpawnEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.CreatureSpawnEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RTrue_Event")));
                        } else if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.CreatureSpawnEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.CreatureSpawnEvent", true);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_True_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check CreatureSpawnEvent!");
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.CreatureSpawnEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RFalse_Event")));
                        } else if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.CreatureSpawnEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.CreatureSpawnEvent", false);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check CreatureSpawnEvent!");
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("CreeperPowerEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.CreeperPowerEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RTrue_Event")));
                        } else if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.CreeperPowerEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.CreeperPowerEvent", true);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_True_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check CreeperPowerEvent!");
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.CreeperPowerEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RFalse_Event")));
                        } else if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.CreeperPowerEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.CreeperPowerEvent", false);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check CreeperPowerEvent!");
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("EntityBreakDoorEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityBreakDoorEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RTrue_Event")));
                        } else if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityBreakDoorEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityBreakDoorEvent", true);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_True_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityBreakDoorEvent!");
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityBreakDoorEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RFalse_Event")));
                        } else if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityBreakDoorEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityBreakDoorEvent", false);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityBreakDoorEvent!");
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("EntityChangeBlockEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityChangeBlockEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RTrue_Event")));
                        } else if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityChangeBlockEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityChangeBlockEvent", true);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_True_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityChangeBlockEvent!");
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityChangeBlockEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RFalse_Event")));
                        } else if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityChangeBlockEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityChangeBlockEvent", false);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityChangeBlockEvent!");
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("EntityCreatePortalEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityCreatePortalEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RTrue_Event")));
                        } else if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityCreatePortalEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityCreatePortalEvent", true);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_True_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityCreatePortalEvent!");
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityCreatePortalEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RFalse_Event")));
                        } else if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityCreatePortalEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityCreatePortalEvent", false);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityCreatePortalEvent!");
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("EntityCombustEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityCombustEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RTrue_Event")));
                        } else if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityCombustEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityCombustEvent", true);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_True_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityCombustEvent!");
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityCombustEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RFalse_Event")));
                        } else if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityCombustEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityCombustEvent", false);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityCombustEvent!");
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("EntityCombustByEntityEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityCombustByEntityEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RTrue_Event")));
                        } else if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityCombustByEntityEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityCombustByEntityEvent", true);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_True_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityCombustByEntityEvent!");
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityCombustByEntityEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RFalse_Event")));
                        } else if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityCombustByEntityEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityCombustByEntityEvent", false);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityCombustByEntityEvent!");
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("EntityCombustByBlockEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityCombustByBlockEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RTrue_Event")));
                        } else if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityCombustByBlockEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityCombustByBlockEvent", true);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_True_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityCombustByBlockEvent!");
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityCombustByBlockEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RFalse_Event")));
                        } else if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityCombustByBlockEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityCombustByBlockEvent", false);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityCombustByBlockEvent!");
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("EntityDamageByEntityEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityDamageByEntityEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RTrue_Event")));
                        } else if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityDamageByEntityEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityDamageByEntityEvent", true);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_True_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityDamageByEntityEvent!");
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityDamageByEntityEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RFalse_Event")));
                        } else if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityDamageByEntityEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityDamageByEntityEvent", false);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityDamageByEntityEvent!");
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("EntityDamageEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityDamageEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RTrue_Event")));
                        } else if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityDamageEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityDamageEvent", true);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_True_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityDamageEvent!");
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityDamageEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RFalse_Event")));
                        } else if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityDamageEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityDamageEvent", false);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityDamageEvent!");
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("EntityDeathEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityDeathEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RTrue_Event")));
                        } else if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityDeathEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityDeathEvent", true);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_True_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityDeathEvent!");
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityDeathEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RFalse_Event")));
                        } else if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityDeathEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityDeathEvent", false);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityDeathEvent!");
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("EntityExplodeEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityExplodeEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RTrue_Event")));
                        } else if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityExplodeEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityExplodeEvent", true);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_True_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityExplodeEvent!");
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityExplodeEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RFalse_Event")));
                        } else if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityExplodeEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityExplodeEvent", false);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityExplodeEvent!");
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("EntityPortalEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityPortalEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RTrue_Event")));
                        } else if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityPortalEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityPortalEvent", true);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_True_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityPortalEvent!");
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityPortalEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RFalse_Event")));
                        } else if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityPortalEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityPortalEvent", false);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityPortalEvent!");
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("EntityPortalExitEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityPortalExitEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RTrue_Event")));
                        } else if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityPortalExitEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityPortalExitEvent", true);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_True_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityPortalExitEvent!");
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityPortalExitEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RFalse_Event")));
                        } else if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityPortalExitEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityPortalExitEvent", false);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityPortalExitEvent!");
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("EntityRegainHealthEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityRegainHealthEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RTrue_Event")));
                        } else if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityRegainHealthEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityRegainHealthEvent", true);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_True_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityRegainHealthEvent!");
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityRegainHealthEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RFalse_Event")));
                        } else if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityRegainHealthEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityRegainHealthEvent", false);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityRegainHealthEvent!");
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("EntityShootBowEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityShootBowEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RTrue_Event")));
                        } else if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityShootBowEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityShootBowEvent", true);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_True_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityShootBowEvent!");
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityShootBowEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RFalse_Event")));
                        } else if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityShootBowEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityShootBowEvent", false);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityShootBowEvent!");
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("EntitySpawnEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntitySpawnEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RTrue_Event")));
                        } else if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntitySpawnEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntitySpawnEvent", true);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_True_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntitySpawnEvent!");
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntitySpawnEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RFalse_Event")));
                        } else if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntitySpawnEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntitySpawnEvent", false);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntitySpawnEvent!");
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("EntityTameEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityTameEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RTrue_Event")));
                        } else if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityTameEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityTameEvent", true);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_True_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityTameEvent!");
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityTameEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RFalse_Event")));
                        } else if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityTameEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityTameEvent", false);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityTameEvent!");
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("EntityTargetEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityTargetEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RTrue_Event")));
                        } else if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityTargetEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityTargetEvent", true);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_True_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityTargetEvent!");
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityTargetEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RFalse_Event")));
                        } else if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityTargetEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityTargetEvent", false);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityTargetEvent!");
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("EntityTargetLivingEntityEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityTargetLivingEntityEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RTrue_Event")));
                        } else if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityTargetLivingEntityEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityTargetLivingEntityEvent", true);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_True_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityTargetLivingEntityEvent!");
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityTargetLivingEntityEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RFalse_Event")));
                        } else if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityTargetLivingEntityEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityTargetLivingEntityEvent", false);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityTargetLivingEntityEvent!");
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("EntityTeleportEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityTeleportEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RTrue_Event")));
                        } else if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityTeleportEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityTeleportEvent", true);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_True_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityTeleportEvent!");
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityTeleportEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RFalse_Event")));
                        } else if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.EntityTeleportEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.EntityTeleportEvent", false);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check EntityTeleportEvent!");
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("FoodLevelChangeEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.FoodLevelChangeEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RTrue_Event")));
                        } else if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.FoodLevelChangeEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.FoodLevelChangeEvent", true);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_True_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check FoodLevelChangeEvent!");
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.FoodLevelChangeEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RFalse_Event")));
                        } else if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.FoodLevelChangeEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.FoodLevelChangeEvent", false);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check FoodLevelChangeEvent!");
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("ExplosionPrimeEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.ExplosionPrimeEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RTrue_Event")));
                        } else if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.ExplosionPrimeEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.ExplosionPrimeEvent", true);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_True_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check ExplosionPrimeEvent!");
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.ExplosionPrimeEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RFalse_Event")));
                        } else if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.ExplosionPrimeEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.ExplosionPrimeEvent", false);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check ExplosionPrimeEvent!");
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("HorseJumpEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.HorseJumpEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RTrue_Event")));
                        } else if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.HorseJumpEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.HorseJumpEvent", true);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_True_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check HorseJumpEvent!");
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.HorseJumpEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RFalse_Event")));
                        } else if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.HorseJumpEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.HorseJumpEvent", false);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check HorseJumpEvent!");
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("ProjectileHitEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.ProjectileHitEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RTrue_Event")));
                        } else if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.ProjectileHitEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.ProjectileHitEvent", true);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_True_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check ProjectileHitEvent!");
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.ProjectileHitEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RFalse_Event")));
                        } else if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.ProjectileHitEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.ProjectileHitEvent", false);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check ProjectileHitEvent!");
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("SheepDyeWoolEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.SheepDyeWoolEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RTrue_Event")));
                        } else if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.SheepDyeWoolEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.SheepDyeWoolEvent", true);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_True_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check SheepDyeWoolEvent!");
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.SheepDyeWoolEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RFalse_Event")));
                        } else if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.SheepDyeWoolEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.SheepDyeWoolEvent", false);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check SheepDyeWoolEvent!");
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("SheepRegrowWoolEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.SheepRegrowWoolEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RTrue_Event")));
                        } else if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.SheepRegrowWoolEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.SheepRegrowWoolEvent", true);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_True_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check SheepRegrowWoolEvent!");
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.SheepRegrowWoolEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RFalse_Event")));
                        } else if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.SheepRegrowWoolEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.SheepRegrowWoolEvent", false);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check SheepRegrowWoolEvent!");
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("SlimeSplitEvent")) {
                  if (args.length > 2) {
                     if (args[2].equalsIgnoreCase("true")) {
                        if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.SlimeSplitEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RTrue_Event")));
                        } else if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.SlimeSplitEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.SlimeSplitEvent", true);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_True_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check SlimeSplitEvent!");
                        }
                     } else if (args[2].equalsIgnoreCase("false")) {
                        if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.SlimeSplitEvent")) {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RFalse_Event")));
                        } else if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.SlimeSplitEvent")) {
                           eventCustomFile.get().set("EventList-v1_8.Server.SlimeSplitEvent", false);
                           eventCustomFile.get().options().copyDefaults(true);
                           eventCustomFile.save();
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_False_Event")));
                        } else {
                           p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check SlimeSplitEvent!");
                        }
                     }
                  }
               } else if (args[1].equalsIgnoreCase("SpawnerSpawnEvent") && args.length > 2) {
                  if (args[2].equalsIgnoreCase("true")) {
                     if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.SpawnerSpawnEvent")) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RTrue_Event")));
                     } else if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.SpawnerSpawnEvent")) {
                        eventCustomFile.get().set("EventList-v1_8.Server.SpawnerSpawnEvent", true);
                        eventCustomFile.get().options().copyDefaults(true);
                        eventCustomFile.save();
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_True_Event")));
                     } else {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check SpawnerSpawnEvent!");
                     }
                  } else if (args[2].equalsIgnoreCase("false")) {
                     if (!eventCustomFile.get().getBoolean("EventList-v1_8.Server.SpawnerSpawnEvent")) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_RFalse_Event")));
                     } else if (eventCustomFile.get().getBoolean("EventList-v1_8.Server.SpawnerSpawnEvent")) {
                        eventCustomFile.get().set("EventList-v1_8.Server.SpawnerSpawnEvent", false);
                        eventCustomFile.get().options().copyDefaults(true);
                        eventCustomFile.save();
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Server_False_Event")));
                     } else {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " §eAn unexpected error has occurred! Please check SpawnerSpawnEvent!");
                     }
                  }
               }
            }
         } else if (args[0].equalsIgnoreCase("elserver")) {
            p.sendMessage("");
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " Event Server List");
            p.sendMessage("");
            p.sendMessage("§7ChunkLoadEvent PortalCreateEvent WeatherChangeEvent ThunderChangeEvent LightningStrikeEvent §7CreatureSpawnEvent CreeperPowerEvent EntityBreakDoorEvent EntityChangeBlockEvent EntityCreatePortalEvent§7EntityCombustEvent EntityCombustByEntityEvent EntityCombustByBlockEvent EntityDamageByBlockEvent§7EntityDamageByEntityEvent EntityDamageEvent EntityDeathEvent EntityExplodeEvent EntityPortalEvent §7EntityPortalExitEvent EntityRegainHealthEvent EntityShootBowEvent EntitySpawnEvent EntityTameEvent§7EntityTargetEvent EntityTargetLivingEntityEvent EntityTeleportEvent FoodLevelChangeEvent §7ExplosionPrimeEvent HorseJumpEvent ProjectileHitEvent SheepDyeWoolEvent SheepRegrowWoolEvent §7SlimeSplitEvent SpawnerSpawnEvent\u200b");
            p.sendMessage("");
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")));
            p.sendMessage("");
         } else if (args[0].equalsIgnoreCase("elplayer")) {
            p.sendMessage("");
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + " Event Player List");
            p.sendMessage("");
            p.sendMessage("§7\u200bBlockBreakEvent BlockDamageEvent BlockMultiPlaceEvent BlockPlaceEvent SignChangeEvent §7InventoryCreativeEvent PlayerToggleSprintEvent PlayerToggleFlightEvent PlayerTeleportEvent §7PlayerMoveEvent PlayerGameModeChangeEvent PlayerDropItemEvent AsyncPlayerChatEvent §7PlayerBedEnterEvent PlayerChangedWorldEvent");
            p.sendMessage("");
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")));
            p.sendMessage("");
         } else if (args[0].equalsIgnoreCase("reload")) {
            eventCustomFile.reload();
            eventCustomFile.get().options().copyDefaults(true);
            eventCustomFile.save();
            eventMessageFile.reload();
            eventMessageFile.get().options().copyDefaults(true);
            eventMessageFile.save();
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + "§eReloading successful!");
         } else {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Prefix")) + ChatColor.translateAlternateColorCodes('&', eventMessageFile.get().getString("Messages.Admin.Player_Not_Found")));
         }
      }

      return false;
   }
}
