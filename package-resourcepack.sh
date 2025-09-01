#!/bin/bash

echo "📦 Packaging CustomItems4MC Resource Pack..."

# Create a zip file of the resource pack
cd resourcepack
zip -r ../CustomItems4MC-ResourcePack.zip . -x "*.md" "README.md"

echo "✅ Resource pack created: CustomItems4MC-ResourcePack.zip"
echo ""
echo "🎯 To use the resource pack:"
echo "1. Copy CustomItems4MC-ResourcePack.zip to your .minecraft/resourcepacks/ folder"
echo "2. Enable it in Minecraft Settings > Resource Packs"
echo "3. Load the plugin on your server"
echo "4. Use /customitems giveall to get all items"
echo ""
echo "📝 Note: You'll need to add custom texture files to see the full visual effects!"
echo "   Check resourcepack/assets/minecraft/textures/item/custom/texture_guide.md"
