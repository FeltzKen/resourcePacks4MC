# CustomItems4MC - Complete Custom Item System

A revolutionary Spigot/Paper plugin that creates **FULLY CUSTOM** items with unique models, textures, and abilities - not just recolored vanilla items!

## 🎨 **COMPLETELY CUSTOM GRAPHICS**

This isn't just another "custom items" plugin - we've created an entire custom item ecosystem with:
- ✨ **Unique 3D models** for every item
- 🎭 **Custom textures** (when resource pack is installed)
- ⚔️ **Completely new item types** that don't exist in vanilla
- 🌟 **Custom behaviors** and special abilities

## 🌌 **LEGENDARY WEAPONS**

### ⚫ **Voidcutter Blade** 
- **Base**: Stick (completely transformed)
- **Damage**: 15 | **Speed**: Very Fast
- **Special**: Void Slash teleport strike
- **Appearance**: Dark purple sword with void energy effects

### 🌟 **Astral Bow**
- **Base**: Carrot on a Stick (custom model)
- **Damage**: 12 | **Range**: Infinite
- **Special**: Astral arrows that pierce enemies
- **Appearance**: Celestial blue bow with starlight

### 💀 **Soul Reaper**
- **Base**: Warped Fungus on a Stick (scythe model)
- **Damage**: 18 | **Soul Steal**: 25%
- **Special**: Death aura heals wielder
- **Appearance**: Dark scythe with red soul energy

### 🐉 **Dragon Fang Dagger**
- **Base**: Knowledge Book (dagger model)
- **Damage**: 8 | **Speed**: Lightning Fast
- **Special**: Dragon fire + Shadow Step
- **Appearance**: Green dagger with dragon scales

## 🔮 **MYSTICAL ARTIFACTS**

### 🔮 **Ethereal Staff**
- **Base**: Blaze Rod (staff model)
- **Magic Power**: 20 | **Mana**: Infinite
- **Special**: Energy blast waves
- **Appearance**: Blue crystal staff with energy wisps

### 🔥 **Phoenix Wings**
- **Base**: Elytra (custom wing model)
- **Flight**: Unlimited | **Fire Immunity**: Yes
- **Special**: Phoenix dive + rebirth ability
- **Appearance**: Golden wings with fire effects

### 💎 **Crystal Core** & 🌌 **Void Essence**
- **Legendary crafting materials**
- **Used to upgrade weapons**
- **Unique models and effects**

## ✦ **MYSTIC ARMOR SET**
- **Full purple/pink armor set**
- **Set Bonus**: Invisibility when sneaking
- **Enhanced protection and magic resistance**

## 🚀 **Installation**

### **1. Plugin Installation:**
```bash
./build.sh
# Plugin JAR copied to /home/dev/paper-mc/plugins/
```

### **2. Resource Pack Installation:**
```bash
./package-resourcepack.sh
# Creates CustomItems4MC-ResourcePack.zip
```

**For players:**
1. Download `CustomItems4MC-ResourcePack.zip`
2. Place in `.minecraft/resourcepacks/`
3. Enable in Minecraft Settings > Resource Packs

**For servers:**
- Upload resource pack to web server
- Add to `server.properties`:
  ```
  resource-pack=http://yourserver.com/CustomItems4MC-ResourcePack.zip
  require-resource-pack=true
  ```

## 🎮 **Commands**

- `/customitems giveall` - **Get ALL custom items instantly!**
- `/customitems give <item>` - Get specific item
- `/customitems list` - Show all available items
- `/giveitem <player> <item>` - Give item to player

## 📦 **Available Items**

```
voidcutter_blade     - ⚫ Voidcutter Blade
astral_bow           - 🌟 Astral Bow  
soul_reaper          - 💀 Soul Reaper
dragon_fang_dagger   - 🐉 Dragon Fang Dagger
ethereal_staff       - 🔮 Ethereal Staff
phoenix_wings        - 🔥 Phoenix Wings
crystal_core         - 💎 Crystal Core
void_essence         - 🌌 Void Essence
mystic_helmet        - ✦ Mystic Helmet
mystic_chestplate    - ✦ Mystic Chestplate
mystic_leggings      - ✦ Mystic Leggings
mystic_boots         - ✦ Mystic Boots
```

## 🎨 **Custom Textures Needed**

The models are ready! You just need to add texture files:

**Required Textures** (16x16 PNG minimum):
- `voidcutter_blade.png` - Dark purple sword with void effects
- `astral_bow.png` - Blue bow with star patterns
- `soul_reaper.png` - Black scythe with red accents
- `dragon_fang_dagger.png` - Green dagger with scales
- `ethereal_staff.png` - Blue staff with crystal top
- `phoenix_wings.png` - Golden wings with fire
- `crystal_core.png` - White crystal with glow
- `void_essence.png` - Purple swirling essence

**Place in**: `resourcepack/assets/minecraft/textures/item/custom/`

## 🛠️ **Technical Details**

- **Custom Model Data**: 10001-10008 (completely unique)
- **Base Items**: Uses uncommon items for unique models
- **Resource Pack Format**: 18 (MC 1.21+)
- **Modern API**: Uses Adventure Components (no deprecation)
- **Paper/Spigot**: 1.21+ compatible

## 🎯 **Why This is Different**

**Traditional "Custom Items":**
❌ Just recolored leather armor  
❌ Vanilla swords with different names  
❌ Same models as existing items  

**Our Custom Items:**
✅ Completely unique 3D models  
✅ Custom textures and appearances  
✅ Items that don't exist in vanilla  
✅ Professional resource pack system  
✅ Legendary/Mythic rarity system  

## 🚀 **Future Expansions**

- 🏹 **Custom Enemies** that drop these items
- 🏰 **Dungeon Integration** with boss fights
- ⚒️ **Crafting Recipes** using custom materials
- 🎭 **Animated Textures** for special effects
- 🌟 **Particle Systems** for abilities

## 📝 **License**

Open source - modify and distribute freely!
