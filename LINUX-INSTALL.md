# 🐧 CustomItems4MC - Linux Installation Guide

## 📍 **Your Current Setup:**
- **You're here**: `/home/dev/Projects/CustomItems4MC/`
- **Plugin JAR**: Already at `/home/dev/paper-mc/plugins/CustomItems4MC-1.0.0.jar` ✅
- **Resource Pack**: `CustomItems4MC-ResourcePack.zip` (in current directory) ✅

## 🎮 **Installing Resource Pack on Linux:**

### **Step 1: Find Your Minecraft Directory**
```bash
# Your Minecraft folder is at:
~/.minecraft/resourcepacks/

# Create the folder if it doesn't exist:
mkdir -p ~/.minecraft/resourcepacks/
```

### **Step 2: Copy the Resource Pack**
```bash
# From your current project directory:
cp CustomItems4MC-ResourcePack.zip ~/.minecraft/resourcepacks/

# Verify it copied:
ls ~/.minecraft/resourcepacks/
```

### **Step 3: Enable in Minecraft**
1. Start Minecraft (Java Edition)
2. Click **Options** → **Resource Packs**
3. You'll see "CustomItems4MC-ResourcePack" on the left
4. Click the **→** arrow to move it to the right side
5. Click **Done**

## 🚀 **Quick Linux Commands:**

### **Copy Resource Pack:**
```bash
cd /home/dev/Projects/CustomItems4MC
cp CustomItems4MC-ResourcePack.zip ~/.minecraft/resourcepacks/
```

### **Check if it worked:**
```bash
ls -la ~/.minecraft/resourcepacks/
```

### **If .minecraft doesn't exist yet:**
```bash
# Create the directory structure:
mkdir -p ~/.minecraft/resourcepacks/
```

## 🧪 **Testing on Your Server:**

Since your Paper server is at `/home/dev/paper-mc/`, you can test immediately:

1. **Start your Paper server**
2. **Connect to localhost**
3. **Run**: `/customitems giveall`
4. **You'll get all the items!** (they'll look like base materials until you enable the resource pack)

## 🎨 **The Items Will Work Either Way:**

**Without Resource Pack:**
- Voidcutter Blade = looks like a stick (but acts like a legendary sword!)
- Astral Bow = looks like carrot on a stick (but shoots magical arrows!)
- All abilities and powers work perfectly

**With Resource Pack:**
- Items will have custom models (once you add texture files)
- Same functionality, just looks cooler

## 💡 **Pro Tip for Linux:**
You can create a symlink to make updating easier:
```bash
# Create a symlink instead of copying:
ln -s /home/dev/Projects/CustomItems4MC/CustomItems4MC-ResourcePack.zip ~/.minecraft/resourcepacks/

# Now when you rebuild the pack, it auto-updates!
```

Want to test the items right now on your server? 🎮
