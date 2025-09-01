#!/bin/bash

# Build script for CustomItems4MC
echo "Building CustomItems4MC plugin..."

# Clean and compile
mvn clean package

# Check if build was successful
if [ $? -eq 0 ]; then
    echo "Build successful!"
    echo "Plugin JAR created at: target/CustomItems4MC-1.0.0.jar"
    
    # Copy to Paper server if it exists
    if [ -d "/home/dev/paper-mc/plugins" ]; then
        echo "Copying plugin to Paper server..."
        cp target/CustomItems4MC-1.0.0.jar /home/dev/paper-mc/plugins/
        echo "Plugin copied to /home/dev/paper-mc/plugins/"
    else
        echo "Paper server directory not found. Please copy the JAR manually."
    fi
else
    echo "Build failed! Check the output above for errors."
    exit 1
fi
