# Run your build and tests
#./gradlew clean test -Pversion="${CI_PIPELINE_ID}-${CI_COMMIT_BRANCH}-${CI_COMMIT_SHORT_SHA}"

# Extract all line coverage percentages from the console output and calculate average
average_coverage=$(./gradlew clean build -Pversion="${CI_PIPELINE_ID}-${CI_COMMIT_BRANCH}-${CI_COMMIT_SHORT_SHA}" | grep -oE 'Line Coverage: ([0-9.]+)%' | grep -oE '[0-9.]+' | awk '{ total += $1 } END { print total / NR }')

# Print the average coverage
echo "Average Coverage: ${average_coverage}%"