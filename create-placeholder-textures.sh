#!/bin/bash

echo "🎨 Creating placeholder textures for testing..."

TEXTURE_DIR="/home/dev/Projects/CustomItems4MC/resourcepack/assets/minecraft/textures/item/custom"

# Create simple colored placeholder textures (using ImageMagick if available)
if command -v convert &> /dev/null; then
    echo "📸 Creating colored placeholder textures..."
    
    # Create 16x16 colored squares as placeholders
    convert -size 16x16 xc:purple "$TEXTURE_DIR/voidcutter_blade.png"
    convert -size 16x16 xc:lightblue "$TEXTURE_DIR/astral_bow.png"
    convert -size 16x16 xc:darkred "$TEXTURE_DIR/soul_reaper.png"
    convert -size 16x16 xc:green "$TEXTURE_DIR/dragon_fang_dagger.png"
    convert -size 16x16 xc:cyan "$TEXTURE_DIR/ethereal_staff.png"
    convert -size 16x16 xc:gold "$TEXTURE_DIR/phoenix_wings.png"
    convert -size 16x16 xc:white "$TEXTURE_DIR/crystal_core.png"
    convert -size 16x16 xc:indigo "$TEXTURE_DIR/void_essence.png"
    
    echo "✅ Placeholder textures created!"
    echo "🎮 Test with: /customitems give voidcutter_blade"
    echo "📦 Run: ./package-resourcepack.sh to update"
    
else
    echo "❌ ImageMagick not found. Please install with:"
    echo "   sudo apt install imagemagick"
    echo ""
    echo "Or manually create 16x16 PNG files in:"
    echo "   $TEXTURE_DIR/"
    echo ""
    echo "Required files:"
    echo "   - voidcutter_blade.png"
    echo "   - astral_bow.png"
    echo "   - soul_reaper.png"
    echo "   - dragon_fang_dagger.png"
    echo "   - ethereal_staff.png"
    echo "   - phoenix_wings.png"
    echo "   - crystal_core.png"
    echo "   - void_essence.png"
fi
