# OnePlayerSleepX

A lightweight Minecraft plugin that controls whether **one player** or **all players** need to sleep to skip the night.
It automatically applies the setting on server startup, keeping gameplay smooth and consistent.

---

## 📦 Features

* Toggle between **One Player Sleep** and **All Players Sleep** using a simple command
* Automatically applies across **all worlds**
* Fully configurable via `config.yml`
* Includes **tab completion** and **aliases** for faster commands
* Lightweight and optimized for performance

---

## ⚙️ Configuration

**config.yml**
```yaml
# ==== OnePlayerSleepX Configuration ====
enabled: true # true = only one player needs to sleep, false = everyone must sleep
```

- When enabled is true, the plugin sets the needed players to **skip the night** to 1 
- When enabled is false, the plugin sets the needed players to **skip the night** 100% of the current online players

---

## 💬 Commands

| Command                   | Alias                                 | Description                                         |
| ------------------------- | ------------------------------------- | --------------------------------------------------- |
| `/oneplayersleep enable`  | `/ops enable` or `/oneplayersleep e`  | Enables OnePlayerSleep (only one player must sleep) |
| `/oneplayersleep disable` | `/ops disable` or `/oneplayersleep d` | Disables OnePlayerSleep (all players must sleep)    |

* The command immediately updates the config and applies the new setting to **all worlds**.
* Includes **tab completion** for `enable`, `disable`, `e`, and `d`.

---

## 🔑 Permissions

| Permission               | Default | Description                                           |
| ------------------------ | ------- | ----------------------------------------------------- |
| `oneplayersleepx.toggle` | `op`    | Allows the player to use `/oneplayersleep` and `/ops` |

---

## 🚀 Installation

1. Download the latest release
2. Place the `.jar` file into your server's `plugins` folder
3. Start your server — done!

---

## 🧩 Compatibility

* Minecraft **1.8.8+**
* Java **8+**
* Works with **Bukkit**, **Spigot**, **Paper**, **Purpur**, **Folia**, and other Bukkit-based servers

---

## 👤 Author

**Mobilestars**

---

## 📝 License

This project is licensed under the **Apache License 2.0**.
