#!/bin/bash

echo "🚀 Adding Resource Pack Auto-Download to Paper Server"
echo ""
echo "📍 Server properties file: /home/dev/paper-mc/server.properties"
echo ""
echo "🔧 Adding these lines:"
echo "resource-pack=https://github.com/FeltzKen/resourcePacks4MC/raw/main/CustomItems4MC-ResourcePack.zip"
echo "resource-pack-sha1=4514f778c8b44927707b6a578c11a06d302f0be3"
echo "require-resource-pack=true"
echo "resource-pack-prompt=Download CustomItems4MC resource pack to see legendary weapons!"
echo ""

# Add the configuration lines to server.properties
cat >> /home/dev/paper-mc/server-1.21.4/server.properties << EOF

# CustomItems4MC Resource Pack Auto-Download
resource-pack=https://github.com/FeltzKen/resourcePacks4MC/raw/main/CustomItems4MC-ResourcePack.zip
resource-pack-sha1=4514f778c8b44927707b6a578c11a06d302f0be3
require-resource-pack=true
resource-pack-prompt=Download CustomItems4MC resource pack to see legendary weapons!
EOF

echo "✅ Configuration added to server.properties!"
echo ""
echo "🔄 Restart your Paper server to apply changes"
echo "🎮 Players will now be prompted to download the resource pack when they join!"
