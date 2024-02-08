package me.event;

import java.io.File;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class eventCustomFile {
   private static File file;
   private static FileConfiguration customfile;

   public static void setup() {
      file = new File(Bukkit.getServer().getPluginManager().getPlugin("EventBan").getDataFolder(), "eventList.yml");
      if (!file.exists()) {
         try {
            file.createNewFile();
         } catch (IOException var1) {
         }
      }

      customfile = YamlConfiguration.loadConfiguration(file);
   }

   public static FileConfiguration get() {
      return customfile;
   }

   public static void save() {
      try {
         customfile.save(file);
      } catch (IOException var1) {
         System.out.println("Kaydedilmedi !");
      }

   }

   public static void reload() {
      customfile = YamlConfiguration.loadConfiguration(file);
   }
}
