# 📦 CustomItems4MC Resource Pack Installation Guide

## 🎯 **What You Have:**
- **Plugin JAR**: Already copied to `/home/dev/paper-mc/plugins/CustomItems4MC-1.0.0.jar`
- **Resource Pack**: Located at `/home/dev/Projects/CustomItems4MC/CustomItems4MC-ResourcePack.zip`

## 🎮 **For Minecraft Players (Client Installation):**

### **Step 1: Find Your Minecraft Folder**
**Windows:**
```
C:\Users\[YourUsername]\AppData\Roaming\.minecraft\resourcepacks\
```
- Press `Windows + R`, type `%appdata%`, hit Enter
- Go to `.minecraft` folder, then `resourcepacks` folder

**Mac:**
```
~/Library/Application Support/minecraft/resourcepacks/
```
- Press `Cmd + Space`, type "Finder"
- Press `Cmd + Shift + G`, paste the path above

**Linux:**
```
~/.minecraft/resourcepacks/
```
- Open file manager, press `Ctrl + H` to show hidden folders
- Go to `.minecraft` then `resourcepacks`

### **Step 2: Copy the Resource Pack**
1. Copy `CustomItems4MC-ResourcePack.zip` from your project folder
2. Paste it into the `resourcepacks` folder (from Step 1)

### **Step 3: Enable in Minecraft**
1. Start Minecraft
2. Click **Options** (or **Settings**)
3. Click **Resource Packs**
4. Find "CustomItems4MC-ResourcePack" in the left column
5. Click the **arrow button** to move it to the right column
6. Click **Done**

## 🌐 **For Server Owners (Automatic Distribution):**

### **Option A: Upload to Web Server**
1. Upload `CustomItems4MC-ResourcePack.zip` to a web server
2. Add to your `server.properties`:
```
resource-pack=http://yourserver.com/CustomItems4MC-ResourcePack.zip
require-resource-pack=true
```

### **Option B: Host on GitHub**
1. Upload the zip to a GitHub repository
2. Get the direct download link
3. Use that link in `server.properties`

## 🧪 **Testing:**

### **Without Resource Pack:**
- Items will show as their base materials (stick, carrot_on_a_stick, etc.)
- But they'll still have all the custom names, lore, and abilities!

### **With Resource Pack:**
- Items will show as completely custom models
- (Once you add the texture PNG files)

## 🎨 **Adding Custom Textures:**

The resource pack structure is ready, but you need to add texture files:

1. Create 16x16 PNG files in: `resourcepack/assets/minecraft/textures/item/custom/`
2. File names needed:
   - `voidcutter_blade.png`
   - `astral_bow.png` 
   - `soul_reaper.png`
   - `dragon_fang_dagger.png`
   - `ethereal_staff.png`
   - `phoenix_wings.png`
   - `crystal_core.png`
   - `void_essence.png`

3. Re-run `./package-resourcepack.sh` to update the zip

## 🚀 **Quick Test:**
1. Install the plugin on your server
2. Join the server
3. Run `/customitems giveall`
4. Items will work even without the resource pack!
5. Install resource pack for full visual experience
