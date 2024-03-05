./gradlew clean test

# Extract line coverage percentages from the console output
coverage=$(./gradlew test | grep -oE 'Line Coverage: ([0-9.]+)%' | grep -oE '[0-9.]+')

# Calculate total coverage
total_coverage=$(echo $coverage | awk '{ total += $1 } END { print total }')

# Print the total coverage in a different format
echo "Total Coverage: ${total_coverage}%"